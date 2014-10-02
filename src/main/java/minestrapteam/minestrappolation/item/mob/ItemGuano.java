package minestrapteam.minestrappolation.item.mob;

import java.util.List;

import clashsoft.cslib.minecraft.lang.I18n;
import minestrapteam.minestrappolation.item.MItem;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGuano extends MItem
{
	public ItemGuano()
	{
		super();
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!player.canPlayerEdit(x, y, z, side, stack))
		{
			return false;
		}
		
		if (applyBonemeal(stack, world, x, y, z))
		{
			if (!world.isRemote)
			{
				world.playAuxSFX(2005, x, y, z, 0);
			}
			
			return true;
		}
		
		return false;
	}
	
	public static boolean applyBonemeal(ItemStack item, World world, int x, int y, int z)
	{
		if (!world.isRemote)
		{
			Block block = world.getBlock(x, y, z);
			
			if (block instanceof IGrowable)
			{
				IGrowable growable = (IGrowable) block;
				
				if (growable.func_149851_a(world, x, y, z, world.isRemote))
				{
					if (growable.func_149852_a(world, world.rand, x, y, z))
					{
						growable.func_149853_b(world, world.rand, x, y, z);
					}
					
					--item.stackSize;
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		list.add(I18n.getString("item.guano.desc"));
		list.add(I18n.getString("item.guano.desc2"));
	}
}
