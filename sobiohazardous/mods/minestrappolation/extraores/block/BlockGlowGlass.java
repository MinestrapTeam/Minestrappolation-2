package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;

public class BlockGlowGlass extends BlockBreakable
{
	public BlockGlowGlass(Material par3Material, boolean par4)
	{
		super("GlowGlass", par3Material, par4);
		this.setCreativeTab(EOBlocks.tabOresBlocks);
	}
	
	@Override
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	/**
	 * Return true if a player with Silk Touch can harvest this block directly,
	 * and not its normal drops.
	 */
	@Override
	protected boolean canSilkHarvest()
	{
		return true;
	}
}
