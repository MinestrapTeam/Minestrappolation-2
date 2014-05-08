package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockBedrockBrick extends MBlock
{
	public BlockBedrockBrick()
	{
		super(Material.rock);
	}
	
	@Override
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	{
		par2EntityPlayer.getHeldItem().damageItem(2000, par2EntityPlayer);
		this.dropBlockAsItem(par1World, par3, par4, par5, new ItemStack(this));
	}
}
