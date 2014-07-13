package minestrapteam.minestrappolation.client.renderer;

import org.lwjgl.opengl.GL11;

import minestrapteam.mcore.util.MCAssetManager;
import minestrapteam.minestrappolation.client.model.ModelHangGlider;
import minestrapteam.minestrappolation.entity.EntityHangGlider;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHangGlider extends Render
{
	public static ResourceLocation	texture	= MCAssetManager.getModelResource("hangglider");
	public ModelHangGlider			model	= new ModelHangGlider();
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		EntityHangGlider glider = (EntityHangGlider) entity;
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float) x, (float) y, (float) z);
		this.bindTexture(texture);
	    this.model.render(0.0625F);
		
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
