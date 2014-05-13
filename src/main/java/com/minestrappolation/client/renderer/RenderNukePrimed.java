package com.minestrappolation.client.renderer;

import org.lwjgl.opengl.GL11;

import com.minestrappolation.entity.EntityNukePrimed;
import com.minestrappolation.lib.MBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderNukePrimed extends Render
{
	private RenderBlocks	blockRenderer	= new RenderBlocks();
	
	public RenderNukePrimed()
	{
		this.shadowSize = 0.5F;
	}
	
	public void renderPrimedTNT(EntityNukePrimed entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		float f2;
		
		if (entity.fuse - partialTickTime + 1.0F < 10.0F)
		{
			f2 = 1.0F - (entity.fuse - partialTickTime + 1.0F) / 10.0F;
			
			if (f2 < 0.0F)
			{
				f2 = 0.0F;
			}
			
			if (f2 > 1.0F)
			{
				f2 = 1.0F;
			}
			
			f2 *= f2;
			f2 *= f2;
			float f3 = 1.0F + f2 * 0.3F;
			GL11.glScalef(f3, f3, f3);
		}
		
		f2 = (1.0F - (entity.fuse - partialTickTime + 1.0F) / 100.0F) * 0.8F;
		this.bindEntityTexture(entity);
		this.blockRenderer.renderBlockAsItem(MBlocks.nuke, 0, entity.getBrightness(partialTickTime));
		
		if (entity.fuse / 5 % 2 == 0)
		{
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_DST_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, f2);
			this.blockRenderer.renderBlockAsItem(MBlocks.nuke, 0, 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
		
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return TextureMap.locationBlocksTexture;
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)
	{
		this.renderPrimedTNT((EntityNukePrimed) entity, x, y, z, yaw, partialTickTime);
	}
}
