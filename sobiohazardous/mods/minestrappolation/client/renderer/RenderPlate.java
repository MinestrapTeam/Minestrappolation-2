package sobiohazardous.mods.minestrappolation.client.renderer;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.client.model.ModelPlate;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderPlate extends TileEntitySpecialRenderer
{
	public static final ResourceLocation	texture	= MCAssetManager.getModelResource("plate");
	
	private ModelPlate						model;
	
	public RenderPlate()
	{
		this.model = new ModelPlate();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + .5F, (float) y + 1.5F, (float) z + 0.5F);
		this.bindTexture(RenderPlate.texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.model.render(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
