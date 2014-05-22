package com.minestrappolation.client.gui;

import org.lwjgl.opengl.GL11;

import com.minestrappolation.inventory.ContainerCrate;
import com.minestrappolation.tileentity.TileEntityCrate;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiCrate extends GuiContainer
{
	public static ResourceLocation	texture	= new ResourceLocation(MCAssetManager.getTexture("/textures/gui/crate.png"));
	
	private TileEntityCrate			crate;
	
	public GuiCrate(EntityPlayer player, TileEntityCrate crate)
	{
		super(new ContainerCrate(player, crate));
		this.crate = crate;
		this.ySize = 148;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.crate.hasCustomInventoryName() ? this.crate.getInventoryName() : StatCollector.translateToLocal("tile.crate.name");
		this.fontRendererObj.drawString(s, 7, 7, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 7, this.ySize - 92, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(texture);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
}