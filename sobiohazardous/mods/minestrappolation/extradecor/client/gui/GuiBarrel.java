package sobiohazardous.mods.minestrappolation.extradecor.client.gui;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.container.ContainerBarrel;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityBarrel;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiBarrel extends GuiContainer
{	
	public static ResourceLocation texture = new ResourceLocation(MAssetManager.getEDTexture("/textures/gui/barrel.png"));
	
	private TileEntityBarrel barrel;
	
	public GuiBarrel(EntityPlayer player, TileEntityBarrel barrel)
	{	
		super(new ContainerBarrel(player, barrel));
		
		this.barrel = barrel;
		
		this.ySize = 185;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.barrel.hasCustomInventoryName() ? this.barrel.getInventoryName() : StatCollector.translateToLocal("tile.barrel.name");
		this.fontRendererObj.drawString(s, 6, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 6, this.ySize - 102, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(texture);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y + 1, 0, 0, this.xSize, this.ySize);
	}
}