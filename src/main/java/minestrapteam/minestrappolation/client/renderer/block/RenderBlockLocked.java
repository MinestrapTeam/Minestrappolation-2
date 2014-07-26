package minestrapteam.minestrappolation.client.renderer.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import minestrapteam.minestrappolation.common.MCommonProxy;
import minestrapteam.minestrappolation.tileentity.TileEntityLocked;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RenderBlockLocked implements ISimpleBlockRenderingHandler
{
	@Override
	public int getRenderId()
	{
		return MCommonProxy.lockedRenderID;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer)
	{
		TileEntityLocked locked = (TileEntityLocked) world.getTileEntity(x, y, z);
		Block block1 = locked.getBlock();
		if (block1 != null)
		{
			return renderer.renderBlockByRenderType(block1, x, y, z);
		}
		return renderer.renderStandardBlock(block, x, y, z);
	}
	
	@Override
	public boolean shouldRender3DInInventory(int paramInt)
	{
		return false;
	}
	
}
