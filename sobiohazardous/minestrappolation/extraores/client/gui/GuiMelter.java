package sobiohazardous.minestrappolation.extraores.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;
public class GuiMelter extends GuiContainer
	{
	private TileEntityMelter goldInventory;

	public GuiMelter(InventoryPlayer inventory, TileEntityMelter gold)
	{
         super(new ContainerMelter(inventory, gold));
         goldInventory = gold;
	}

/**
         * Draw the foreground layer for the GuiContainer (everythin in front of the items)
         */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
         fontRenderer.drawString("Melter", 8, (ySize - 96) + 2, 4210752);
	}

/**
         * Draw the background layer for the GuiContainer (everything behind the items)
         */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation gui = new ResourceLocation("minestrappolation:gui/melter.png");
         this.mc.renderEngine.bindTexture(gui);
         int j = (width - xSize) / 2;
         int k = (height - ySize) / 2;
         drawTexturedModalRect(j, k, 0, 0, xSize, ySize);

         if (goldInventory.isBurning())
         {
                 int burn = goldInventory.getBurnTimeRemainingScaled(12);
                 this.drawTexturedModalRect(j + 56, k + 36 + 12 - burn, 176, 12 - burn, 14, burn + 2);
         }

         int update = goldInventory.getCookProgressScaled(24);
         this.drawTexturedModalRect(j + 79, k + 34, 176, 14, update + 1, 16);
	}
}