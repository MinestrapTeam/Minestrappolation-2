package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockRope extends Block
{
	public BlockRope()
	{
		super(Material.cloth);
		this.setCreativeTab(null);
		this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean getBlocksMovement(IBlockAccess world, int x, int y, int z)
	{
		return false;
	}
	
	@Override
	public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
	{
		return true;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		return true;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDTexture("ropeSide"));
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y + 1, z);
		return block == this || block.isSideSolid(world, x, y, z, ForgeDirection.DOWN);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return EDBlocks.itemRope;
	}
}
