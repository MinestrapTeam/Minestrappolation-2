package minestrapteam.minestrap_core.client.renderer.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import minestrapteam.minestrap_core.block.MCBlockWood2;
import minestrapteam.minestrap_core.client.MCClientProxy;
import minestrapteam.minestrap_core.common.MCCommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RenderBlockWood2 implements ISimpleBlockRenderingHandler
{
	@Override
	public int getRenderId()
	{
		return MCClientProxy.wood2RenderType;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		int i = MCCommonProxy.wood2RenderType;
		MCCommonProxy.wood2RenderType = 0;
		
		if (block instanceof MCBlockWood2)
		{
			((MCBlockWood2) block).setBlockBounds(metadata);
		}
		renderer.renderBlockAsItem(block, metadata, 1F);
		
		MCCommonProxy.wood2RenderType = i;
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 2)
		{
			renderer.uvRotateEast = 1;
			renderer.uvRotateWest = 1;
			renderer.uvRotateTop = 1;
			renderer.uvRotateBottom = 1;
			renderer.renderStandardBlock(block, x, y, z);
			renderer.uvRotateEast = 0;
			renderer.uvRotateWest = 0;
			renderer.uvRotateTop = 0;
			renderer.uvRotateBottom = 0;
		}
		else if (metadata == 1)
		{
			renderer.uvRotateNorth = 1;
			renderer.uvRotateSouth = 1;
			renderer.renderStandardBlock(block, x, y, z);
			renderer.uvRotateNorth = 0;
			renderer.uvRotateSouth = 0;
		}
		else
		{
			renderer.renderStandardBlock(block, x, y, z);
		}
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int metadata)
	{
		return true;
	}
}
