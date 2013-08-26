package sobiohazardous.minestrappolation.extradecor.client.gui;

import org.lwjgl.opengl.GL11;

import sobiohazardous.minestrappolation.extradecor.container.ContainerCrate;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityCrate;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.src.*;
import net.minecraft.util.StatCollector;

public class GuiCrate extends GuiContainer
{
	public static ResourceLocation crategui = new ResourceLocation("Minestrappolation","gui/crate.png");

	public GuiCrate(InventoryPlayer player_inventory, TileEntityCrate tile_entity)
	{
		
		super(new ContainerCrate(tile_entity, player_inventory));
	}

	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) 
	{
		fontRenderer.drawString("Crate", 6, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 111, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.func_110577_a(crategui);		
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}