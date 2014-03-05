package sobiohazardous.minestrappolation.extradecor.client.gui;

import org.lwjgl.opengl.GL11;

import sobiohazardous.minestrappolation.extradecor.container.ContainerBarrel;
import sobiohazardous.minestrappolation.extradecor.container.ContainerCrate;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityCrate;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.src.*;
import net.minecraft.util.StatCollector;

public class GuiBarrel extends GuiContainer
{
	/** The Y size of the inventory window in pixels. */
    protected int ySize = 185;

	public GuiBarrel(InventoryPlayer player_inventory, TileEntityBarrel tile_entity)
	{
		
		super(new ContainerBarrel(tile_entity, player_inventory));
	}

	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) 
	{
		this.fontRendererObj.drawString("Barrel", 6, -2, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 102, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		ResourceLocation gui = new ResourceLocation("minestrappolation","gui/barrel.png");
		this.mc.renderEngine.bindTexture(gui);		
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y+1, 0, 0, xSize, ySize);
	}
}