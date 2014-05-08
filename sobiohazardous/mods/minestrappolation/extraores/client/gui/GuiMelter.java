package sobiohazardous.mods.minestrappolation.extraores.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityMelter;

public class GuiMelter extends GuiContainer
{
	private TileEntityMelter	tileEntity;
	
	public GuiMelter(InventoryPlayer inventory, TileEntityMelter gold)
	{
		super(new ContainerMelter(inventory, gold));
		this.tileEntity = gold;
	}
	
	/**
	 * Draw the foreground layer for the GuiContainer (everythin in front of the
	 * items)
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.fontRendererObj.drawString("Melter", 8, this.ySize - 96 + 2, 4210752);
	}
	
	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ResourceLocation gui = new ResourceLocation(MAssetManager.getEOTexture("textures/gui/melter.png"));
		this.mc.renderEngine.bindTexture(gui);
		int j = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);
		
		if (this.tileEntity.isBurning())
		{
			int burn = this.tileEntity.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(j + 56, k + 36 + 12 - burn, 176, 12 - burn, 14, burn + 2);
		}
		
		if (this.tileEntity.isPowered())
		{
			this.drawTexturedModalRect(j + 58, k + 5, 176, 31, 12, 10);
		}
		
		int update = this.tileEntity.getCookProgressScaled(24);
		this.drawTexturedModalRect(j + 79, k + 34, 176, 14, update + 1, 16);
	}
}