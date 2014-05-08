package sobiohazardous.mods.minestrappolation.extradecor.handler;

import sobiohazardous.mods.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.mods.minestrappolation.extradecor.block.BlockRope;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RopeRenderingHandler extends RenderBlocks implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		if (modelId == ExtraDecor.ropeRenderId)
		{
			return this.renderBlockRope((BlockRope) block, renderer, x, y, z);
		}
		return false;
	}
	
	@Override
	public int getRenderId()
	{
		return ExtraDecor.ropeRenderId;
	}
	
	public boolean renderBlockRope(BlockRope blockRope, RenderBlocks renderer, int x, int y, int z)
	{
		renderer.setRenderBounds(0.375F, 0.0D, 0.375F, 0.625F, 1.0D, 0.625F);
		renderer.renderStandardBlock(blockRope, x, y, z);
		
		blockRope.setBlockBoundsBasedOnState(renderer.blockAccess, x, y, z);
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}
	
}
