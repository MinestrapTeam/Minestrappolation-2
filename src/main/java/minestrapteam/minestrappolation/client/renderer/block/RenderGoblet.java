package minestrapteam.minestrappolation.client.renderer.block;

import org.lwjgl.opengl.GL11;

import minestrapteam.minestrappolation.client.model.ModelGoblet;
import minestrapteam.minestrappolation.tileentity.TileEntityGoblet;
import minestrapteam.minestrappolation.util.MAssetManager;

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
		
		ResourceLocation texture = null;
		int meta = t.getBlockMetadata();
		int color = 0xFFFFFF;
		
		switch (meta)
		{
		case 0:
			texture = MAssetManager.getModelResource("goblet_empty");
			break;
		case 1:
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			texture = MAssetManager.getModelResource("goblet_water");
			break;
		case 2:
			texture = MAssetManager.getModelResource("goblet_milk");
			break;
		case 3:
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			color = ((TileEntityGoblet) t).getColor();
			texture = MAssetManager.getModelResource("goblet_potion");
			break;
		}
		this.bindTexture(texture);
		
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.model.render(0.0625F, color);
		GL11.glPopMatrix();
	}
}
