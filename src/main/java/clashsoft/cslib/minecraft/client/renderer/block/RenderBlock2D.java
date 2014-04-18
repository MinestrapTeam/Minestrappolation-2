package clashsoft.cslib.minecraft.client.renderer.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderBlock2D implements ISimpleBlockRenderingHandler
{
	public static RenderItem	itemRender	= new RenderItem();
	
	public static final int		renderID	= RenderingRegistry.getNextAvailableRenderId();
	
	@Override
	public int getRenderId()
	{
		return renderID;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		IIcon icon = block.getIcon(1, metadata);
		itemRender.renderIcon(0, 0, icon, 16, 16);
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer)
	{
		return renderer.renderBlockByRenderType(block, x, y, z);
	}
	
	@Override
	public boolean shouldRender3DInInventory(int paramInt)
	{
		return false;
	}
	
}
