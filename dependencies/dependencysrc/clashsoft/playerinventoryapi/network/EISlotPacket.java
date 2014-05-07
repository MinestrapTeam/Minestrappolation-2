package clashsoft.playerinventoryapi.network;

import java.io.IOException;

import clashsoft.cslib.minecraft.network.CSPacket;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class EISlotPacket extends CSPacket
{
	public int			slot;
	public ItemStack	stack;
	
	public EISlotPacket()
	{
	}
	
	public EISlotPacket(ExtendedInventory ei, int slot)
	{
		this.slot = slot;
		this.stack = ei.getStackInSlot(slot);
	}
	
	@Override
	public void write(PacketBuffer buf)
	{
		buf.writeInt(this.slot);
		try
		{
			buf.writeItemStackToBuffer(this.stack);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void read(PacketBuffer buf)
	{
		this.slot = buf.readInt();
		try
		{
			this.stack = buf.readItemStackFromBuffer();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void handleClient(EntityPlayer player)
	{
	}
	
	@Override
	public void handleServer(EntityPlayerMP player)
	{
		ExtendedInventory ei = ExtendedInventory.get(player);
		ei.itemStacks[this.slot] = this.stack;
	}
}
