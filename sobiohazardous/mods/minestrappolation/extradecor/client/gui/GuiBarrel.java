package sobiohazardous.mods.minestrappolation.extradecor.client.gui;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.container.ContainerBarrel;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

public class GuiBarrel extends GuiContainer
{
	/** The Y size of the inventory window in pixels. */
	protected int	ySize	= 185;
	
	public GuiBarrel(InventoryPlayer player_inventory, TileEntityBarrel tile_entity)
	{
		
		super(new ContainerBarrel(tile_entity, player_inventory));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2)
	{
		this.fontRendererObj.drawString("Barrel", 6, -2, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 6, this.ySize - 102, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		ResourceLocation gui = new ResourceLocation(MAssetManager.getEDTexture("/textures/gui/barrel.png"));
		this.mc.renderEngine.bindTexture(gui);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y + 1, 0, 0, this.xSize, this.ySize);
	}
}