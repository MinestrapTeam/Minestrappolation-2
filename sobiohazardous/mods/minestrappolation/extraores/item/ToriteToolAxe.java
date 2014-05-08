package sobiohazardous.mods.minestrappolation.extraores.item;

import sobiohazardous.mods.minestrappolation.core.item.MItemAxe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ToriteToolAxe extends MItemAxe
{
	public ToriteToolAxe(ToolMaterial par2EnumToolMaterial, ToolMaterial bronzeMaterial)
	{
		super(par2EnumToolMaterial, bronzeMaterial);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.block;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
	
}
