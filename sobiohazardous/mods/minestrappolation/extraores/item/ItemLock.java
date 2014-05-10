package sobiohazardous.mods.minestrappolation.extraores.item;

import sobiohazardous.mods.minestrappolation.core.util.MChatMessageHandler;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityLocked;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemLock extends ItemKey
{
	public ItemLock()
	{
		super();
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (stack.stackTagCompound == null)
		{
			createNBT(stack, player);
		}
		
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntityLocked)
		{
			String name = stack.stackTagCompound.getString("player");
			TileEntityLocked locked = (TileEntityLocked) te;
			
			if (name.equals(locked.getPlayer()))
			{
				if (locked.isLocked())
				{
					locked.unlock();
					MChatMessageHandler.sendChatToPlayer(player, "Already locked!");
				}
				else
				{
					locked.lock();
					stack.stackSize--;
					MChatMessageHandler.sendChatToPlayer(player, "Lock added!");
				}
				return true;
			}
			else
			{
				MChatMessageHandler.sendChatToPlayer(player, "This is not your lock!");
			}
		}
		else
		{
			MChatMessageHandler.sendChatToPlayer(player, "Not applicable for a lock!");
		}
		
		return false;
	}
}
