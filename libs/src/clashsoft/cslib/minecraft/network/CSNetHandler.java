package clashsoft.cslib.minecraft.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.*;

import clashsoft.cslib.util.CSLog;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.PacketBuffer;

@ChannelHandler.Sharable
public class CSNetHandler extends MessageToMessageCodec<FMLProxyPacket, CSPacket>
{
	public final String							name;
	
	protected EnumMap<Side, FMLEmbeddedChannel>	channels;
	protected List<Class<? extends CSPacket>>	packets			= new ArrayList();
	
	protected boolean							initiliased		= false;
	protected boolean							postInitialised	= false;
	
	public CSNetHandler(String name)
	{
		this.name = name;
	}
	
	/**
	 * Register your packet with the pipeline. Discriminators are automatically
	 * set. If more than 256 packet classes are registered, the packet is not
	 * registered.
	 * 
	 * @param clazz
	 *            the class to register
	 * @return true, if the registration was successful.
	 */
	public boolean registerPacket(Class<? extends CSPacket> clazz)
	{
		if (this.postInitialised)
		{
			return false;
		}
		
		if (this.packets.size() > 256 || this.packets.contains(clazz))
		{
			return false;
		}
		
		this.packets.add(clazz);
		return true;
	}
	
	/**
	 * Returns this discriminator for the registered packet class. If the class
	 * is not registered, a {@link NullPointerException} is thrown.
	 */
	protected byte getDiscriminator(Class<? extends CSPacket> packetClass)
	{
		int index = (byte) this.packets.indexOf(packetClass);
		if (index == -1)
		{
			throw new NullPointerException("No Packet Registered for: " + packetClass.getCanonicalName());
		}
		return (byte) index;
	}
	
	/**
	 * Returns the registered packet class for the discriminator. If no
	 * registered class was found, a {@link NullPointerException} is thrown.
	 * 
	 * @param discriminator
	 * @return the packet class
	 */
	protected Class<? extends CSPacket> getClass(byte discriminator)
	{
		Class clazz = this.packets.get(discriminator);
		if (clazz == null)
		{
			throw new NullPointerException("No packet registered for discriminator: " + discriminator);
		}
		return clazz;
	}
	
	@Override
	protected void encode(ChannelHandlerContext ctx, CSPacket msg, List<Object> out) throws Exception
	{
		PacketBuffer buffer = new PacketBuffer(Unpooled.buffer());
		Class<? extends CSPacket> clazz = msg.getClass();
		byte discriminator = this.getDiscriminator(clazz);
		
		buffer.writeByte(discriminator);
		msg.write(buffer);
		FMLProxyPacket proxyPacket = new FMLProxyPacket(buffer.copy(), ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
		out.add(proxyPacket);
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) throws Exception
	{
		ByteBuf payload = msg.payload();
		byte discriminator = payload.readByte();
		Class<? extends CSPacket> clazz = this.getClass(discriminator);
		
		PacketBuffer buffer = new PacketBuffer(payload.slice());
		CSPacket pkt = clazz.newInstance();
		
		pkt.read(buffer);
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
		{
			INetHandler netHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
			EntityPlayerMP player = ((NetHandlerPlayServer) netHandler).playerEntity;
			pkt.handleServer(player);
		}
		else
		{
			EntityPlayer player = this.getClientPlayer();
			pkt.handleClient(player);
		}
		
		out.add(pkt);
	}
	
	/**
	 * Initializes this net handler by creating a new Channel using
	 * {@link NetworkRegistry#newChannel(String, ChannelHandler...)}.
	 */
	public void init()
	{
		if (this.initiliased)
		{
			return;
		}
		this.initiliased = true;
		
		this.channels = NetworkRegistry.INSTANCE.newChannel(this.name, this);
	}
	
	/**
	 * Ensures that packet discriminators are common between server and client
	 * by using logical sorting
	 */
	public void postInit()
	{
		if (!this.initiliased)
		{
			CSLog.warning("The net handler " + this.name + " is attempting to post-init, but it hasn't been initialised yet.");
		}
		
		if (this.postInitialised)
		{
			return;
		}
		this.postInitialised = true;
		
		Collections.sort(this.packets, new Comparator<Class>()
		{
			@Override
			public int compare(Class clazz1, Class clazz2)
			{
				String canon1 = clazz1.getCanonicalName();
				String canon2 = clazz2.getCanonicalName();
				int com = String.CASE_INSENSITIVE_ORDER.compare(canon1, canon2);
				
				if (com == 0)
				{
					com = canon1.compareTo(canon2);
				}
				
				return com;
			}
		});
	}
	
	/**
	 * Returns the client player from {@link Minecraft#thePlayer}.
	 * 
	 * @return the client player
	 */
	@SideOnly(Side.CLIENT)
	private EntityPlayer getClientPlayer()
	{
		return Minecraft.getMinecraft().thePlayer;
	}
	
	/**
	 * Send this message to everyone.
	 * <p>
	 * Adapted from CPW's code in
	 * {@link SimpleNetworkWrapper#sendToAll(IMessage)}
	 * 
	 * @param message
	 *            The message to send
	 */
	public void sendToAll(CSPacket message)
	{
		FMLEmbeddedChannel channel = this.channels.get(Side.SERVER);
		if (channel != null)
		{
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
			channel.writeAndFlush(message);
		}
		else
		{
			CSLog.error("Unable to send packet to players: No Server Channel!");
		}
	}
	
	/**
	 * Send this message to the specified player.
	 * <p>
	 * Adapted from CPW's code in
	 * {@link SimpleNetworkWrapper#sendTo(IMessage, EntityPlayerMP)}
	 * 
	 * @param message
	 *            The message to send
	 * @param player
	 *            The player to send it to
	 */
	public void sendTo(CSPacket message, EntityPlayerMP player)
	{
		FMLEmbeddedChannel channel = this.channels.get(Side.SERVER);
		if (channel != null)
		{
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
			channel.writeAndFlush(message);
		}
		else
		{
			CSLog.error("Unable to send packet to player: No Server Channel!");
		}
	}
	
	/**
	 * Send this message to everyone within a certain range of a point.
	 * <p>
	 * Adapted from CPW's code in
	 * {@link SimpleNetworkWrapper#sendToAllAround(IMessage, NetworkRegistry.TargetPoint)}
	 * 
	 * @param message
	 *            The message to send
	 * @param point
	 *            The {@link NetworkRegistry.TargetPoint} around which to send
	 */
	public void sendToAllAround(CSPacket message, NetworkRegistry.TargetPoint point)
	{
		FMLEmbeddedChannel channel = this.channels.get(Side.SERVER);
		if (channel != null)
		{
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
			channel.writeAndFlush(message);
		}
		else
		{
			CSLog.error("Unable to send packet to players around point: No Server Channel!");
		}
	}
	
	/**
	 * Send this message to everyone within the supplied dimension.
	 * <p>
	 * Adapted from CPW's code in
	 * {@link SimpleNetworkWrapper#sendToDimension(IMessage, int)}
	 * 
	 * @param message
	 *            The message to send
	 * @param dimensionId
	 *            The dimension id to target
	 */
	public void sendToDimension(CSPacket message, int dimensionId)
	{
		FMLEmbeddedChannel channel = this.channels.get(Side.SERVER);
		if (channel != null)
		{
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(dimensionId);
			channel.writeAndFlush(message);
		}
		else
		{
			CSLog.error("Unable to send packet to players in dimension: No Server Channel!");
		}
	}
	
	/**
	 * Send this message to the server.
	 * <p/>
	 * Adapted from CPW's code in
	 * {@link SimpleNetworkWrapper#sendToServer(IMessage)}
	 * 
	 * @param message
	 *            The message to send
	 */
	public void sendToServer(CSPacket message)
	{
		FMLEmbeddedChannel channel = this.channels.get(Side.CLIENT);
		if (channel != null)
		{
			channel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
			channel.writeAndFlush(message);
		}
		else
		{
			CSLog.error("Unable to send packet to server: No Client Channel!");
		}
	}
	
	/**
	 * Intelligently decides where the message should be sent. If this is called
	 * from a client-side thread, the message is sent to the server. Otherwise,
	 * it is sent to all players on the server.
	 */
	public void send(CSPacket message)
	{
		if (FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			this.sendToServer(message);
		}
		else
		{
			this.sendToAll(message);
		}
	}
}