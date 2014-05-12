package com.minestrappolation.core.item;

import java.util.Collections;

import clashsoft.cslib.minecraft.item.datatools.ItemDataSword;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MCItemSword extends MCItemTool
{
	public MCItemSword(ToolMaterial material, ToolMaterial plateMaterial, boolean ignites)
	{
		super(ItemDataSword.baseDamage, material, plateMaterial, Collections.EMPTY_SET, "overlayWeaponSwordBronze", ignites);
	}
	
	public MCItemSword(ToolMaterial material, ToolMaterial plateMaterial)
	{
		this(material, plateMaterial, false);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker)
	{
		if (this.ignites)
		{
			entity.setFire(10);
			stack.damageItem(2, attacker);
		}
		else
		{
			stack.damageItem(1, attacker);
		}
		return true;
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{
		if (block == Blocks.web)
		{
			return 15.0F;
		}
		else
		{
			float f = ItemDataSword.isEfficientOnMaterial(block.getMaterial()) ? 1.5F : 1.0F;
			return super.getDigSpeed(stack, block, metadata) * f;
		}
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase living)
	{
		if (block.getBlockHardness(world, x, y, z) != 0.0D)
		{
			stack.damageItem(2, living);
		}
		return true;
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
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return block == Blocks.web;
	}
}
