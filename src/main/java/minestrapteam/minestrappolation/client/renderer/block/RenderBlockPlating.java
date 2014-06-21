package minestrapteam.minestrappolation.client.renderer.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import minestrapteam.minestrappolation.client.MClientProxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class RenderBlockPlating implements ISimpleBlockRenderingHandler
{
	
	public RenderBlockPlating()
	{
	}
	
	@Override
	public int getRenderId()
	{
		return MClientProxy.platingRenderID;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int metadata, RenderBlocks renderer)
	{
		boolean x1 = world.isSideSolid(x + 1, y, z, ForgeDirection.WEST, false);
		boolean x2 = world.isSideSolid(x - 1, y, z, ForgeDirection.EAST, false);
		boolean z1 = world.isSideSolid(x, y, z + 1, ForgeDirection.NORTH, false);
		boolean z2 = world.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH, false);
		
		double y1 = y + (x2 || z2 ? 1.0625D : 0.0625D);
		double y2 = y + (x2 || z1 ? 1.0625D : 0.0625D);
		double y3 = y + (x1 || z1 ? 1.0625D : 0.0625D);
		double y4 = y + (x1 || z2 ? 1.0625D : 0.0625D);
		
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		
		IIcon icon = block.getIcon(world, x, y, z, 1);
		float minU = icon.getMinU();
		float maxU = icon.getMaxU();
		float minV = icon.getMinV();
		float maxV = icon.getMaxV();
		
		tessellator.addVertexWithUV(x, y1, z, minU, maxV);
		tessellator.addVertexWithUV(x, y2, z + 1, minU, minV);
		tessellator.addVertexWithUV(x + 1, y3, z + 1, maxU, minV);
		tessellator.addVertexWithUV(x + 1, y4, z, maxU, maxV);
		
		tessellator.addVertexWithUV(x + 1, y4, z, maxU, maxV);
		tessellator.addVertexWithUV(x + 1, y3, z + 1, maxU, minV);
		tessellator.addVertexWithUV(x, y2, z + 1, minU, minV);
		tessellator.addVertexWithUV(x, y1, z, minU, maxV);
		
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int metadata)
	{
		return false;
	}
	
}
