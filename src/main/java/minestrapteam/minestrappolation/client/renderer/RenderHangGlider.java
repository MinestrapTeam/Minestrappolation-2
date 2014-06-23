package minestrapteam.minestrappolation.client.renderer;

import org.lwjgl.opengl.GL11;

import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrappolation.client.model.ModelHangGlider;
import minestrapteam.minestrappolation.entity.EntityHangGlider;
import minestrapteam.minestrappolation.handler.MEventHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHangGlider extends Render
{
	public static ResourceLocation	texture	= MCAssetManager.getModelResource("textures/misc/hangglider.png");
	public ModelHangGlider			model	= new ModelHangGlider();
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		EntityHangGlider glider = (EntityHangGlider) entity;
		Entity rider = glider.riddenByEntity;
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		float f = MEventHandler.interpolateRotation(rider.prevRotationYaw, rider.rotationYaw, partialTickTime);
		GL11.glRotatef(f, 0F, -1F, 0F);
		GL11.glRotatef(180F, 0F, 0F, 1F);
		GL11.glTranslated(x, y, z - 0.5D);
		this.model.render(0.0625F);
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
