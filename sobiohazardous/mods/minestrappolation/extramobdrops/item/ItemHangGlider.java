package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import sobiohazardous.mods.minestrappolation.core.item.MItem;
import sobiohazardous.mods.minestrappolation.extramobdrops.entity.EntityHangGlider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHangGlider extends MItem
{
	public ItemHangGlider()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(25);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			EntityHangGlider entity = new EntityHangGlider(world, x, y, z, player, stack);
			world.spawnEntityInWorld(entity);
			return true;
		}
		return false;
	}
}
