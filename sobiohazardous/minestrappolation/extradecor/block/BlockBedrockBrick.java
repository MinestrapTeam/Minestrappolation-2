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
	public BlockBedrockBrick(int par1) {
		super(par1, Material.rock);
		// TODO Auto-generated constructor stub
	}
	
	 public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	    {
	        par2EntityPlayer.getHeldItem().damageItem(200, par2EntityPlayer);
	        this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(this));
	     
	    }

}
