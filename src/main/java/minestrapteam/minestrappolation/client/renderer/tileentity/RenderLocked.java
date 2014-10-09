package minestrapteam.minestrappolation.client.renderer.tileentity;

import minestrapteam.minestrappolation.tileentity.TileEntityLocked;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderLocked extends TileEntitySpecialRenderer
{
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f)
	{
		TileEntityLocked locked = (TileEntityLocked) tileEntity;
		TileEntity te = locked.getTileEntity();
		
		if (te != null)
		{
			TileEntityRendererDispatcher.instance.renderTileEntityAt(te, x, y, z, f);
		}
	}
}
