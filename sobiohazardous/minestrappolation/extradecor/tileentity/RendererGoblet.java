package sobiohazardous.minestrappolation.extradecor.tileentity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RendererGoblet extends TileEntitySpecialRenderer {

	private ModelGoblet model;
	public RendererGoblet() {
		this.model = new ModelGoblet();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + .5F, (float) y + 1.5F, (float) z + 0.5F);
		ResourceLocation texture = new ResourceLocation("minestrappolation:textures/blocks/block_Goblet.png");
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180, 0F, 0F, 1F);
		model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

	}

}
