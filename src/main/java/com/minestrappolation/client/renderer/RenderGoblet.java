package com.minestrappolation.client.renderer;

import org.lwjgl.opengl.GL11;

import com.minestrappolation.client.model.ModelGoblet;
import com.minestrappolation.core.util.MCAssetManager;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderGoblet extends TileEntitySpecialRenderer
{
	
	private ModelGoblet	model;
	
	public RenderGoblet()
	{
		this.model = new ModelGoblet();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + .5F, (float) y + 1.5F, (float) z + 0.5F);
		ResourceLocation texture = null;
		int meta = t.getBlockMetadata();
		switch (meta)
		{
		case 0:
			texture = MCAssetManager.getModelResource("gobletEmpty");
			break;
		case 1:
			texture = MCAssetManager.getModelResource("gobletWater");
			break;
		case 2:
			texture = MCAssetManager.getModelResource("gobletMilk");
			break;
		case 3:
			texture = MCAssetManager.getModelResource("gobletInvisibility");
			break;
		case 4:
			texture = MCAssetManager.getModelResource("gobletRegeneration");
			break;
		
		}
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
	
}
