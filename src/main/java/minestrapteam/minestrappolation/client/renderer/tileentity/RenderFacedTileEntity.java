package minestrapteam.minestrappolation.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderFacedTileEntity extends TileEntitySpecialRenderer
{
	private final ModelBase			model;
	private final ResourceLocation	texture;
	
	public RenderFacedTileEntity(ModelBase model, ResourceLocation texture)
	{
		this.model = model;
		this.texture = texture;
	}
	
	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		
		this.bindTexture(this.texture);
		
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glScalef(1F, -1F, -1F);
		GL11.glRotatef(t.getBlockMetadata() * 90, 0F, 1F, 0F);
		this.model.render((Entity) null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
		
		GL11.glPopMatrix();
	}
}