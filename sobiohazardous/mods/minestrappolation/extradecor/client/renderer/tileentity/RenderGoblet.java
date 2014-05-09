package sobiohazardous.mods.minestrappolation.extradecor.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import sobiohazardous.mods.minestrappolation.extradecor.client.model.ModelGoblet;

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
			texture = new ResourceLocation(MReference.MODID_ED + ":textures/blocks/model/gobletEmpty.png");
			break;
		case 1:
			texture = new ResourceLocation(MReference.MODID_ED + ":textures/blocks/model/gobletWater.png");
			break;
		case 2:
			texture = new ResourceLocation(MReference.MODID_ED + ":textures/blocks/model/gobletMilk.png");
			break;
		case 3:
			texture = new ResourceLocation(MReference.MODID_ED + ":textures/blocks/model/gobletInvisibility.png");
			break;
		case 4:
			texture = new ResourceLocation(MReference.MODID_ED + ":textures/blocks/model/gobletRegeneration.png");
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
