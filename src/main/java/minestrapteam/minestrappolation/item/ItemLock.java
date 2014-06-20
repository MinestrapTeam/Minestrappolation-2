package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.tileentity.TileEntityLocked;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
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
		if (world.isRemote)
		{
			return true;
		}
		
		if (stack.stackTagCompound == null)
		{
			createNBT(stack, player);
		}
		
		TileEntity te = world.getTileEntity(x, y, z);
		String name = stack.stackTagCompound.getString("player");
		if (te instanceof TileEntityLocked)
		{
			TileEntityLocked locked = (TileEntityLocked) te;
			
			if (locked.isOwner(name))
			{
				if (locked.isLocked())
				{
					player.addChatMessage(new ChatComponentTranslation("lock.already_locked"));
				}
				return true;
			}
			else
			{
				player.addChatMessage(new ChatComponentTranslation("lock.not_owner"));
				return false;
			}
		}
		else if (te != null)
		{
			TileEntityLocked locked = new TileEntityLocked(name, te);
			locked.lock();
			world.setTileEntity(x, y, z, locked);
			stack.stackSize--;
			player.addChatMessage(new ChatComponentTranslation("lock.added"));
			return true;
		}
		else
		{
			player.addChatMessage(new ChatComponentTranslation("lock.not_applicable"));
			return false;
		}
	}
}
