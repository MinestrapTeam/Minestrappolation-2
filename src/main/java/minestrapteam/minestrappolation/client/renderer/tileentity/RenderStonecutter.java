package minestrapteam.minestrappolation.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import minestrapteam.minestrappolation.client.model.ModelStonecutter;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderStonecutter extends TileEntitySpecialRenderer
{
	private final ModelStonecutter	model;
	ResourceLocation				texture	= new ResourceLocation(MAssetManager.getModel("stonecutter"));
	
	public RenderStonecutter()
	{
		this.model = new ModelStonecutter();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		
		this.bindTexture(this.texture);
		
		GL11.glTranslatef((float) x + .5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glScalef(1F, -1F, -1F);
		GL11.glRotatef(t.getBlockMetadata() * 90, 0F, 1F, 0F);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		
		GL11.glPopMatrix();
	}
	
	/*
	 * private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
	 * int meta = world.getBlockMetadata(x, y, z); GL11.glPushMatrix();
	 * GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F); GL11.glPopMatrix(); }
	 */
	
	/*
	 * private void adjustLightFixture(World world, int i, int j, int k, Block
	 * block) { Tessellator tess = Tessellator.instance; float brightness =
	 * block.getBlockBrightness(world, i, j, k); int skyLight =
	 * world.getLightBrightnessForSkyBlocks(i, j, k, 0); int modulousModifier =
	 * skyLight % 65536; int divModifier = skyLight / 65536;
	 * tess.setColorOpaque_F(brightness, brightness, brightness);
	 * OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
	 * (float) modulousModifier, divModifier); }
	 */
	
}