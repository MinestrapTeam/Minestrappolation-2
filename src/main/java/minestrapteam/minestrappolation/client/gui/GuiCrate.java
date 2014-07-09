package minestrapteam.minestrappolation.client.gui;

import org.lwjgl.opengl.GL11;

import minestrapteam.mcore.util.MCAssetManager;
import minestrapteam.minestrappolation.inventory.ContainerCrate;
import minestrapteam.minestrappolation.tileentity.TileEntityCrate;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiCrate extends GuiContainer
{
	public static ResourceLocation	texture	= MCAssetManager.getGUIResource("container/crate");
	
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
		this.fontRendererObj.drawString(StatCollector.translateToLocal(this.crate.getInventoryName()), 7, 7, 4210752);
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