package sobiohazardous.minestrappolation.extradecor.handler;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.block.EDBlockPane;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class PaneRenderingHandler extends RenderBlocks implements ISimpleBlockRenderingHandler
{
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
         
    }
	
	 @Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
	    if (modelId == ExtraDecor.paneRenderId)
		{
				return renderBlockEDPane((EDBlockPane)block, renderer, x, y, z);
		}
	    return false;
	 } 

	public int getRenderId()
	{
		return ExtraDecor.paneRenderId;
	}
	
	public boolean renderBlockEDPane(EDBlockPane par1BlockPane, RenderBlocks render, int par2, int par3, int par4)
    {
        int l = render.blockAccess.getHeight();
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(par1BlockPane.getMixedBrightnessForBlock(render.blockAccess, par2, par3, par4));
        float f = 1.0F;
        int i1 = par1BlockPane.colorMultiplier(render.blockAccess, par2, par3, par4);
        float f1 = (float)(i1 >> 16 & 255) / 255.0F;
        float f2 = (float)(i1 >> 8 & 255) / 255.0F;
        float f3 = (float)(i1 & 255) / 255.0F;

        if (EntityRenderer.anaglyphEnable)
        {
            float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }

        tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
        IIcon icon;
        IIcon icon1;

        if (this.hasOverrideBlockTexture())
        {
            icon = render.overrideBlockTexture;
            icon1 = render.overrideBlockTexture;
        }
        else
        {
            int j1 = render.blockAccess.getBlockMetadata(par2, par3, par4);
            icon = this.getBlockIconFromSideAndMetadata(par1BlockPane, 0, j1);
            icon1 = par1BlockPane.getSideTextureIndex();
        }

        double d0 = (double)icon.getMinU();
        double d1 = (double)icon.getInterpolatedU(8.0D);
        double d2 = (double)icon.getMaxU();
        double d3 = (double)icon.getMinV();
        double d4 = (double)icon.getMaxV();
        double d5 = (double)icon1.getInterpolatedU(7.0D);
        double d6 = (double)icon1.getInterpolatedU(9.0D);
        double d7 = (double)icon1.getMinV();
        double d8 = (double)icon1.getInterpolatedV(8.0D);
        double d9 = (double)icon1.getMaxV();
        double d10 = (double)par2;
        double d11 = (double)par2 + 0.5D;
        double d12 = (double)(par2 + 1);
        double d13 = (double)par4;
        double d14 = (double)par4 + 0.5D;
        double d15 = (double)(par4 + 1);
        double d16 = (double)par2 + 0.5D - 0.0625D;
        double d17 = (double)par2 + 0.5D + 0.0625D;
        double d18 = (double)par4 + 0.5D - 0.0625D;
        double d19 = (double)par4 + 0.5D + 0.0625D;
        boolean flag = par1BlockPane.canPaneConnectTo(render.blockAccess,par2, par3, par4, ForgeDirection.NORTH);
        boolean flag1 = par1BlockPane.canPaneConnectTo(render.blockAccess,par2, par3, par4, ForgeDirection.SOUTH);
        boolean flag2 = par1BlockPane.canPaneConnectTo(render.blockAccess,par2, par3, par4, ForgeDirection.WEST);
        boolean flag3 = par1BlockPane.canPaneConnectTo(render.blockAccess,par2, par3, par4, ForgeDirection.EAST);
        boolean flag4 = par1BlockPane.shouldSideBeRendered(render.blockAccess, par2, par3 + 1, par4, 1);
        boolean flag5 = par1BlockPane.shouldSideBeRendered(render.blockAccess, par2, par3 - 1, par4, 0);
        double d20 = 0.01D;
        double d21 = 0.005D;

        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
        {
            if (flag2 && !flag3)
            {
                tessellator.addVertexWithUV(d10, (double)(par3 + 1), d14, d0, d3);
                tessellator.addVertexWithUV(d10, (double)(par3 + 0), d14, d0, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d14, d1, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d14, d1, d3);
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d14, d0, d3);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d14, d0, d4);
                tessellator.addVertexWithUV(d10, (double)(par3 + 0), d14, d1, d4);
                tessellator.addVertexWithUV(d10, (double)(par3 + 1), d14, d1, d3);

                if (!flag1 && !flag)
                {
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1), d19, d5, d7);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 0), d19, d5, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 0), d18, d6, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1), d18, d6, d7);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1), d18, d5, d7);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 0), d18, d5, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 0), d19, d6, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1), d19, d6, d7);
                }

                if (flag4 || par3 < l - 1 && render.blockAccess.isAirBlock(par2 - 1, par3 + 1, par4))
                {
                    tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d19, d6, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d18, d5, d9);
                    tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d19, d6, d9);
                    tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d18, d5, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d18, d5, d8);
                }

                if (flag5 || par3 > 1 && render.blockAccess.isAirBlock(par2 - 1, par3 - 1, par4))
                {
                    tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d19, d6, d9);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d18, d5, d9);
                    tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d19, d6, d9);
                    tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d18, d5, d9);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d18, d5, d8);
                }
            }
            else if (!flag2 && flag3)
            {
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d14, d1, d3);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d14, d1, d4);
                tessellator.addVertexWithUV(d12, (double)(par3 + 0), d14, d2, d4);
                tessellator.addVertexWithUV(d12, (double)(par3 + 1), d14, d2, d3);
                tessellator.addVertexWithUV(d12, (double)(par3 + 1), d14, d1, d3);
                tessellator.addVertexWithUV(d12, (double)(par3 + 0), d14, d1, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d14, d2, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d14, d2, d3);

                if (!flag1 && !flag)
                {
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1), d18, d5, d7);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 0), d18, d5, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 0), d19, d6, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1), d19, d6, d7);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1), d19, d5, d7);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 0), d19, d5, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 0), d18, d6, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1), d18, d6, d7);
                }

                if (flag4 || par3 < l - 1 && render.blockAccess.isAirBlock(par2 + 1, par3 + 1, par4))
                {
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d19, d6, d7);
                    tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d18, d5, d7);
                    tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d19, d6, d7);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d18, d5, d7);
                }

                if (flag5 || par3 > 1 && render.blockAccess.isAirBlock(par2 + 1, par3 - 1, par4))
                {
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d19, d6, d7);
                    tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d18, d5, d7);
                    tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d19, d6, d7);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d18, d5, d7);
                }
            }
        }
        else
        {
            tessellator.addVertexWithUV(d10, (double)(par3 + 1), d14, d0, d3);
            tessellator.addVertexWithUV(d10, (double)(par3 + 0), d14, d0, d4);
            tessellator.addVertexWithUV(d12, (double)(par3 + 0), d14, d2, d4);
            tessellator.addVertexWithUV(d12, (double)(par3 + 1), d14, d2, d3);
            tessellator.addVertexWithUV(d12, (double)(par3 + 1), d14, d0, d3);
            tessellator.addVertexWithUV(d12, (double)(par3 + 0), d14, d0, d4);
            tessellator.addVertexWithUV(d10, (double)(par3 + 0), d14, d2, d4);
            tessellator.addVertexWithUV(d10, (double)(par3 + 1), d14, d2, d3);

            if (flag4)
            {
                tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d19, d6, d9);
                tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d19, d6, d7);
                tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d18, d5, d7);
                tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d18, d5, d9);
                tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d19, d6, d9);
                tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d19, d6, d7);
                tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d18, d5, d7);
                tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d18, d5, d9);
            }
            else
            {
                if (par3 < l - 1 && render.blockAccess.isAirBlock(par2 - 1, par3 + 1, par4))
                {
                    tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d19, d6, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d18, d5, d9);
                    tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d19, d6, d9);
                    tessellator.addVertexWithUV(d10, (double)(par3 + 1) + 0.01D, d18, d5, d9);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d18, d5, d8);
                }

                if (par3 < l - 1 && render.blockAccess.isAirBlock(par2 + 1, par3 + 1, par4))
                {
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d19, d6, d7);
                    tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d18, d5, d7);
                    tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d19, d6, d7);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d11, (double)(par3 + 1) + 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d12, (double)(par3 + 1) + 0.01D, d18, d5, d7);
                }
            }

            if (flag5)
            {
                tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d19, d6, d9);
                tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d19, d6, d7);
                tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d18, d5, d7);
                tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d18, d5, d9);
                tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d19, d6, d9);
                tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d19, d6, d7);
                tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d18, d5, d7);
                tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d18, d5, d9);
            }
            else
            {
                if (par3 > 1 && render.blockAccess.isAirBlock(par2 - 1, par3 - 1, par4))
                {
                    tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d19, d6, d9);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d18, d5, d9);
                    tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d19, d6, d9);
                    tessellator.addVertexWithUV(d10, (double)par3 - 0.01D, d18, d5, d9);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d18, d5, d8);
                }

                if (par3 > 1 && render.blockAccess.isAirBlock(par2 + 1, par3 - 1, par4))
                {
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d19, d6, d7);
                    tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d18, d5, d7);
                    tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d19, d6, d7);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d19, d6, d8);
                    tessellator.addVertexWithUV(d11, (double)par3 - 0.01D, d18, d5, d8);
                    tessellator.addVertexWithUV(d12, (double)par3 - 0.01D, d18, d5, d7);
                }
            }
        }

        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
        {
            if (flag && !flag1)
            {
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d13, d0, d3);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d13, d0, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d14, d1, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d14, d1, d3);
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d14, d0, d3);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d14, d0, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d13, d1, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d13, d1, d3);

                if (!flag3 && !flag2)
                {
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1), d14, d5, d7);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 0), d14, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 0), d14, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1), d14, d6, d7);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1), d14, d5, d7);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 0), d14, d5, d9);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 0), d14, d6, d9);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1), d14, d6, d7);
                }

                if (flag4 || par3 < l - 1 && render.blockAccess.isAirBlock(par2, par3 + 1, par4 - 1))
                {
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d13, d6, d7);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d14, d6, d8);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d14, d5, d8);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d13, d5, d7);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d14, d6, d7);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d13, d6, d8);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d13, d5, d8);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d14, d5, d7);
                }

                if (flag5 || par3 > 1 && render.blockAccess.isAirBlock(par2, par3 - 1, par4 - 1))
                {
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d13, d6, d7);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d14, d6, d8);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d14, d5, d8);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d13, d5, d7);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d14, d6, d7);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d13, d6, d8);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d13, d5, d8);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d14, d5, d7);
                }
            }
            else if (!flag && flag1)
            {
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d14, d1, d3);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d14, d1, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d15, d2, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d15, d2, d3);
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d15, d1, d3);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d15, d1, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 0), d14, d2, d4);
                tessellator.addVertexWithUV(d11, (double)(par3 + 1), d14, d2, d3);

                if (!flag3 && !flag2)
                {
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1), d14, d5, d7);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 0), d14, d5, d9);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 0), d14, d6, d9);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1), d14, d6, d7);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1), d14, d5, d7);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 0), d14, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 0), d14, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1), d14, d6, d7);
                }

                if (flag4 || par3 < l - 1 && render.blockAccess.isAirBlock(par2, par3 + 1, par4 + 1))
                {
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d14, d5, d8);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d15, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d15, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d14, d6, d8);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d15, d5, d8);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d14, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d14, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d15, d6, d8);
                }

                if (flag5 || par3 > 1 && render.blockAccess.isAirBlock(par2, par3 - 1, par4 + 1))
                {
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d14, d5, d8);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d15, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d15, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d14, d6, d8);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d15, d5, d8);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d14, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d14, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d15, d6, d8);
                }
            }
        }
        else
        {
            tessellator.addVertexWithUV(d11, (double)(par3 + 1), d15, d0, d3);
            tessellator.addVertexWithUV(d11, (double)(par3 + 0), d15, d0, d4);
            tessellator.addVertexWithUV(d11, (double)(par3 + 0), d13, d2, d4);
            tessellator.addVertexWithUV(d11, (double)(par3 + 1), d13, d2, d3);
            tessellator.addVertexWithUV(d11, (double)(par3 + 1), d13, d0, d3);
            tessellator.addVertexWithUV(d11, (double)(par3 + 0), d13, d0, d4);
            tessellator.addVertexWithUV(d11, (double)(par3 + 0), d15, d2, d4);
            tessellator.addVertexWithUV(d11, (double)(par3 + 1), d15, d2, d3);

            if (flag4)
            {
                tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d15, d6, d9);
                tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d13, d6, d7);
                tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d13, d5, d7);
                tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d15, d5, d9);
                tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d13, d6, d9);
                tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d15, d6, d7);
                tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d15, d5, d7);
                tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d13, d5, d9);
            }
            else
            {
                if (par3 < l - 1 && render.blockAccess.isAirBlock(par2, par3 + 1, par4 - 1))
                {
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d13, d6, d7);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d14, d6, d8);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d14, d5, d8);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d13, d5, d7);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d14, d6, d7);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d13, d6, d8);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d13, d5, d8);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d14, d5, d7);
                }

                if (par3 < l - 1 && render.blockAccess.isAirBlock(par2, par3 + 1, par4 + 1))
                {
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d14, d5, d8);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d15, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d15, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d14, d6, d8);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d15, d5, d8);
                    tessellator.addVertexWithUV(d16, (double)(par3 + 1) + 0.005D, d14, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d14, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)(par3 + 1) + 0.005D, d15, d6, d8);
                }
            }

            if (flag5)
            {
                tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d15, d6, d9);
                tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d13, d6, d7);
                tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d13, d5, d7);
                tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d15, d5, d9);
                tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d13, d6, d9);
                tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d15, d6, d7);
                tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d15, d5, d7);
                tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d13, d5, d9);
            }
            else
            {
                if (par3 > 1 && render.blockAccess.isAirBlock(par2, par3 - 1, par4 - 1))
                {
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d13, d6, d7);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d14, d6, d8);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d14, d5, d8);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d13, d5, d7);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d14, d6, d7);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d13, d6, d8);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d13, d5, d8);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d14, d5, d7);
                }

                if (par3 > 1 && render.blockAccess.isAirBlock(par2, par3 - 1, par4 + 1))
                {
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d14, d5, d8);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d15, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d15, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d14, d6, d8);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d15, d5, d8);
                    tessellator.addVertexWithUV(d16, (double)par3 - 0.005D, d14, d5, d9);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d14, d6, d9);
                    tessellator.addVertexWithUV(d17, (double)par3 - 0.005D, d15, d6, d8);
                }
            }
        }

        return true;
    }

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}
}
