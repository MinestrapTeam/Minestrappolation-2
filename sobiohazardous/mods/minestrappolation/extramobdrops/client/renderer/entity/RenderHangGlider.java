package sobiohazardous.mods.minestrappolation.extramobdrops.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.extramobdrops.client.model.ModelHangGlider;
import sobiohazardous.mods.minestrappolation.extramobdrops.common.EMDEventHandler;
import sobiohazardous.mods.minestrappolation.extramobdrops.entity.EntityHangGlider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHangGlider extends Render
{
	public ResourceLocation	texture	= new ResourceLocation("extramobdrops:textures/misc/hangGlider.png");
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		EntityHangGlider glider = (EntityHangGlider) entity;
		Entity rider = glider.riddenByEntity;
		
		GL11.glPushMatrix();
		ModelHangGlider m = new ModelHangGlider();
		Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
		float f = EMDEventHandler.interpolateRotation(rider.prevRotationYaw, rider.rotationYaw, partialTickTime);
		GL11.glRotatef(f, 0, -1, 0);
		GL11.glRotatef(180F, 0, 0, 1);
		GL11.glTranslated(x, y, z - 0.5D);
		m.render(0.0625F);
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.texture;
	}
}