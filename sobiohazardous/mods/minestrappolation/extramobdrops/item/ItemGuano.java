package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItem;

public class ItemGuano extends MItem
{
	public ItemGuano()
	{
		super();
	}
	
	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		{
			return false;
		}
		else
		{
			if (applyBonemeal(par1ItemStack, par3World, par4, par5, par6))
			{
				if (!par3World.isRemote)
				{
					par3World.playAuxSFX(2005, par4, par5, par6, 0);
				}
				
				return true;
			}
			return false;
		}
	}
	
	public static boolean applyBonemeal(ItemStack item, World world, int x, int y, int z)
	{
		Block var5 = world.getBlock(x, y, z);
		
		if (var5 instanceof IGrowable)
		{
			IGrowable var6 = (IGrowable) var5;
			
			if (var6.func_149851_a(world, x, y, z, world.isRemote))
			{
				if (!world.isRemote)
				{
					if (var6.func_149852_a(world, world.rand, x, y, z))
					{
						var6.func_149853_b(world, world.rand, x, y, z);
					}
					
					--item.stackSize;
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add("Instantly grow anything");
		par3List.add("Cook up to 10 Items");
	}
	
}
