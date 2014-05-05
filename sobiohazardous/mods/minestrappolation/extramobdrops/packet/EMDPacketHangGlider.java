package sobiohazardous.mods.minestrappolation.extramobdrops.packet;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.extramobdrops.handler.EMDEventHandler;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import sobiohazardous.mods.minestrappolation.extramobdrops.tileentity.ModelHangGlider;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class EMDPacketHangGlider extends EMDPacket
{	
	public EMDPacketHangGlider(){}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
	{
		
	}

	@Override
	public void handleClientSide(EntityPlayer player)
	{
		/*
		if(player.inventory.getCurrentItem() != EMDItemManager.hangGlider.getContainerItem(null))
		{	
			System.out.println("Running");
			GL11.glPushMatrix();
			ModelHangGlider m = new ModelHangGlider();		
			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("extramobdrops:textures/misc/hangGlider.png"));
			int tick = 0;
			tick++;
			float rotateYaw = EMDEventHandler.interpolateRotation(player.prevRotationYaw, player.rotationYaw, tick);
			GL11.glRotatef(rotateYaw, 0, -1, 0);
			GL11.glRotatef(180F, 0, 0, 1);
			GL11.glTranslatef(0, 0, -0.5F);				
			m.render(0.0625F);
			GL11.glPopMatrix();			
		}
		*/
	}

	@Override
	public void handleServerSide(EntityPlayer player)
	{
		
	}
}
