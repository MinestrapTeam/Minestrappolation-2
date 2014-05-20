package com.minestrappolation.core.client.renderer.block;

import com.minestrappolation.core.block.MCBlockStone2;
import com.minestrappolation.core.client.MCClientProxy;
import com.minestrappolation.core.common.MCCommonProxy;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RenderBlockStone2 implements ISimpleBlockRenderingHandler
{
	@Override
	public int getRenderId()
	{
		return MCClientProxy.stone2RenderType;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		int i = MCCommonProxy.stone2RenderType;
		MCCommonProxy.stone2RenderType = 0;
		
		if (block instanceof MCBlockStone2)
		{
			((MCBlockStone2) block).setBlockBounds(metadata);
		}
		renderer.renderBlockAsItem(block, metadata, 1F);
		
		MCCommonProxy.stone2RenderType = i;
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer)
	{
		return renderer.renderStandardBlock(block, x, y, z);
	}
	
	@Override
	public boolean shouldRender3DInInventory(int metadata)
	{
		return true;
	}
}
