package sobiohazardous.minestrappolation.extraores.handler;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.block.BlockPlate;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderingHandler extends RenderBlocks implements ISimpleBlockRenderingHandler
{
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		if (modelId == ExtraOres.plateRenderId)
		{
			return renderTinPlate((BlockPlate) block, renderer, world, x, y, z, block, modelId);
		}
		return false;
	}

	public int getRenderId()
	{
		return ExtraOres.plateRenderId;
	}

	public boolean renderTinPlate(BlockPlate par1BlockRailBase, RenderBlocks renderblocks, IBlockAccess iblockaccess, int par2, int par3, int par4, Block block, int modelId)
	{
		Tessellator tessellator = Tessellator.instance;
		int l = iblockaccess.getBlockMetadata(par2, par3, par4);
		IIcon icon = this.getBlockIconFromSideAndMetadata(par1BlockRailBase, 0, l);

		if (this.hasOverrideBlockTexture())
		{
			icon = this.overrideBlockTexture;
		}

		tessellator.setBrightness(par1BlockRailBase.getMixedBrightnessForBlock(iblockaccess, par2, par3, par4));
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		double d0 = (double) icon.getMinU();
		double d1 = (double) icon.getMinV();
		double d2 = (double) icon.getMaxU();
		double d3 = (double) icon.getMaxV();
		double d4 = 0.0625D;
		double d5 = (double) (par2 + 1);
		double d6 = (double) (par2 + 1);
		double d7 = (double) (par2 + 0);
		double d8 = (double) (par2 + 0);
		double d9 = (double) (par4 + 0);
		double d10 = (double) (par4 + 1);
		double d11 = (double) (par4 + 1);
		double d12 = (double) (par4 + 0);
		double d13 = (double) par3 + d4;
		double d14 = (double) par3 + d4;
		double d15 = (double) par3 + d4;
		double d16 = (double) par3 + d4;

		if (l != 1 && l != 2 && l != 3 && l != 7)
		{
			if (l == 8)
			{
				d5 = d6 = (double) (par2 + 0);
				d7 = d8 = (double) (par2 + 1);
				d9 = d12 = (double) (par4 + 1);
				d10 = d11 = (double) (par4 + 0);
			}
			else if (l == 9)
			{
				d5 = d8 = (double) (par2 + 0);
				d6 = d7 = (double) (par2 + 1);
				d9 = d10 = (double) (par4 + 0);
				d11 = d12 = (double) (par4 + 1);
			}
		}
		else
		{
			d5 = d8 = (double) (par2 + 1);
			d6 = d7 = (double) (par2 + 0);
			d9 = d10 = (double) (par4 + 1);
			d11 = d12 = (double) (par4 + 0);
		}

		if (l != 2 && l != 4)
		{
			if (l == 3 || l == 5)
			{
				++d14;
				++d15;
			}
		}
		else
		{
			++d13;
			++d16;
		}

		tessellator.addVertexWithUV(d5, d13, d9, d2, d1);
		tessellator.addVertexWithUV(d6, d14, d10, d2, d3);
		tessellator.addVertexWithUV(d7, d15, d11, d0, d3);
		tessellator.addVertexWithUV(d8, d16, d12, d0, d1);
		tessellator.addVertexWithUV(d8, d16, d12, d0, d1);
		tessellator.addVertexWithUV(d7, d15, d11, d0, d3);
		tessellator.addVertexWithUV(d6, d14, d10, d2, d3);
		tessellator.addVertexWithUV(d5, d13, d9, d2, d1);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}
}
