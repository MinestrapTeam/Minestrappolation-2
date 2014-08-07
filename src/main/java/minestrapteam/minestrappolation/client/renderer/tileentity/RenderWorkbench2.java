package minestrapteam.minestrappolation.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import minestrapteam.minestrappolation.client.model.ModelWorkbench;
import minestrapteam.minestrappolation.util.MAssetManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderWorkbench2 extends TileEntitySpecialRenderer
{
	private final ModelWorkbench	model;
	public static ResourceLocation	texture	= MAssetManager.getModelResource("CraftingTable");
	
	public RenderWorkbench2()
	{
		this.model = new ModelWorkbench();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		
		this.bindTexture(texture);
		
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glScalef(1F, -1F, -1F);
		GL11.glRotatef(t.getBlockMetadata() * 90, 0F, 1F, 0F);
		this.model.render((Entity) null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
		
		GL11.glPopMatrix();
	}
}