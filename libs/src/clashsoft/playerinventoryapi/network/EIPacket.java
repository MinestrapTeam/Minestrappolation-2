package clashsoft.playerinventoryapi.network;

import java.io.IOException;

import clashsoft.cslib.minecraft.network.CSPacket;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class EIPacket extends CSPacket
{
	public ItemStack[]	stacks;
	
	public EIPacket()
	{
	}
	
	public EIPacket(ExtendedInventory inventory)
	{
		this.stacks = inventory.itemStacks;
	}
	
	@Override
	public void write(PacketBuffer buf)
	{
		int len = this.stacks.length;
		buf.writeInt(len);
		for (int i = 0; i < len; i++)
		{
			ItemStack stack = this.stacks[i];
			try
			{
				buf.writeItemStackToBuffer(stack);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void read(PacketBuffer buf)
	{
		int len = buf.readInt();
		this.stacks = new ItemStack[len];
		
		for (int i = 0; i < len; i++)
		{
			try
			{
				this.stacks[i] = buf.readItemStackFromBuffer();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
		ExtendedInventory ei = ExtendedInventory.get(player);
		ei.itemStacks = this.stacks;
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		ExtendedInventory ei = ExtendedInventory.get(player);
		ei.itemStacks = this.stacks;
	}
}
