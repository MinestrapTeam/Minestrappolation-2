package sobiohazardous.mods.minestrappolation.extradecor.client.gui;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.container.ContainerCrate;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityCrate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

public class GuiCrate extends GuiContainer
{
	public static ResourceLocation	crategui	= new ResourceLocation(MAssetManager.getEDTexture("/textures/gui/barrel.png"));
	
	public GuiCrate(InventoryPlayer player_inventory, TileEntityCrate tile_entity)
	{
		super(new ContainerCrate(tile_entity, player_inventory));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2)
	{
		this.fontRendererObj.drawString("Crate", 6, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 6, this.ySize - 111, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(crategui);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
}