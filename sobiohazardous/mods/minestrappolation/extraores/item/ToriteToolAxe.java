package sobiohazardous.mods.minestrappolation.extraores.item;

import sobiohazardous.mods.minestrappolation.core.item.MItemAxe;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class ToriteToolAxe extends MItemAxe
{
    public ToriteToolAxe(ToolMaterial par2EnumToolMaterial, ToolMaterial bronzeMaterial)
	{
		super(par2EnumToolMaterial, bronzeMaterial);
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }
    
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

}
