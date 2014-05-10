package sobiohazardous.mods.minestrappolation.extraores.item;

import sobiohazardous.mods.minestrappolation.core.item.MItemAxe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ToriteToolAxe extends MItemAxe
{
	public ToriteToolAxe(ToolMaterial material, ToolMaterial bronzeMaterial)
	{
		super(material, bronzeMaterial);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.block;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 72000;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
	
}
