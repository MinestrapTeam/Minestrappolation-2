package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class BlockBedrockBrick extends MBlock
{
	public BlockBedrockBrick() 
	{
		super(Material.rock);
	}
	
	 public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	 {
		 par2EntityPlayer.getHeldItem().damageItem(2000, par2EntityPlayer);
	     this.dropBlockAsItem(par1World, par3, par4, par5, new ItemStack(this));     
	 }
}
