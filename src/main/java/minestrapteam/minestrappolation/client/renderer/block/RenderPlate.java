package minestrapteam.minestrappolation.client.renderer.block;

import org.lwjgl.opengl.GL11;

import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrappolation.client.model.ModelPlate;
import minestrapteam.minestrappolation.tileentity.TileEntityPlate;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderPlate extends TileEntitySpecialRenderer
{
	public static final ResourceLocation	texture	= MCAssetManager.getModelResource("plate");
	
	private ModelPlate						model;
	
	public RenderPlate()
	{
		this.model = new ModelPlate();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f)
	{
		TileEntityPlate plate = (TileEntityPlate) t;
		EntityItem item = plate.getItemEntity();
		if (item != null)
		{
			RenderManager.instance.renderEntitySimple(item, 0F);
		}
		
		GL11.glPushMatrix();
		
		this.bindTexture(texture);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.model.render(0.0625F);
		
		GL11.glPopMatrix();
	}
}
