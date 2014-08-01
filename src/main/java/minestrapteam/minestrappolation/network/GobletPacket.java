package minestrapteam.minestrappolation.network;

import clashsoft.cslib.minecraft.network.CSPacket;
import minestrapteam.minestrappolation.tileentity.TileEntityGoblet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class GobletPacket extends CSPacket
{
	private World			world;
	private int				x;
	private int				y;
	private int				z;
	private PotionEffect	effect;
	
	public GobletPacket()
	{
	}
	
	public GobletPacket(World world, int x, int y, int z, PotionEffect effect)
	{
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.effect = effect;
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
		TileEntityGoblet goblet = (TileEntityGoblet) player.worldObj.getTileEntity(this.x, this.y, this.z);
		goblet.setPotionEffect(this.effect, false);
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		TileEntityGoblet goblet = (TileEntityGoblet) this.world.getTileEntity(this.x, this.y, this.z);
		goblet.setPotionEffect(this.effect);
	}
	
	@Override
	public void read(PacketBuffer buf)
	{
		this.world = readWorld(buf);
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.effect = readPotionEffect(buf);
	}
	
	@Override
	public void write(PacketBuffer buf)
	{
		writeWorld(buf, this.world);
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);
		writePotionEffect(buf, this.effect);
	}
}
