package minestrapteam.minestrappolation.client.gui;

import org.lwjgl.opengl.GL11;

import minestrapteam.minestrappolation.inventory.ContainerBarrel;
import minestrapteam.minestrappolation.tileentity.TileEntityBarrel;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiBarrel extends GuiContainer
{
	public static ResourceLocation	texture	= MAssetManager.getGUIResource("container/barrel");
	
	private TileEntityBarrel		barrel;
	
	public GuiBarrel(EntityPlayer player, TileEntityBarrel barrel)
	{
		super(new ContainerBarrel(player, barrel));
		this.barrel = barrel;
		this.ySize = 186;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal(this.barrel.getInventoryName()), 7, 7, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 7, this.ySize - 92, 4210752);
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