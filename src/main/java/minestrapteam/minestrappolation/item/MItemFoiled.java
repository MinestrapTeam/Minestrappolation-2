package minestrapteam.minestrappolation.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.ItemStack;

public class MItemFoiled extends MItem
{
	public MItemFoiled()
	{
		super();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
}