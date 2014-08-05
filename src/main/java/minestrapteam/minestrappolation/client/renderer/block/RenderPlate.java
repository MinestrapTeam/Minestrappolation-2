package minestrapteam.minestrappolation.client.renderer.block;

import org.lwjgl.opengl.GL11;

import minestrapteam.minestrappolation.client.model.ModelPlate;
import minestrapteam.minestrappolation.tileentity.TileEntityPlate;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderPlate extends TileEntitySpecialRenderer
{
	public static final ResourceLocation	texture	= MAssetManager.getModelResource("plate");
	
	private ModelPlate						model;
	
	public RenderPlate()
	{
		this.model = new ModelPlate();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f)
	{
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y, z + 0.5D);
		GL11.glRotatef(90F, 1F, 0F, 0F);
		GL11.glTranslatef(0F, -0.25F, -0.15625F);
		
		TileEntityPlate plate = (TileEntityPlate) t;
		EntityItem item = plate.getItemEntity();
		if (item != null)
		{
			RenderManager.instance.renderEntityWithPosYaw(item, 0D, 0D, 0D, 0F, 0F);
		}
		
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		this.bindTexture(texture);
		GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
		GL11.glRotatef(180F, 0F, 0F, 1F);
		this.model.render(0.0625F);
		
		GL11.glPopMatrix();
	}
}
