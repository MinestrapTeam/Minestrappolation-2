package sobiohazardous.minestrappolation.extrafoods.block.microwave;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;



public class GuiMicrowave extends GuiContainer {

		private TileEntityMicrowave microwaveInventory;
	
        public GuiMicrowave (InventoryPlayer inventoryPlayer,
                        TileEntityMicrowave tileEntity) {
                //the container is instanciated and passed to the superclass for handling
                super(new ContainerMicrowave(inventoryPlayer, tileEntity));
                microwaveInventory = tileEntity;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                //draw text and stuff here
                //the parameters for drawString are: string, x, y, color
                fontRenderer.drawString("Microwave", 8, 6, 4210752);
                //draws "Inventory" or your regional equivalent
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                        int par3) {
                //draw your Gui here, only thing you need to change is the path
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                ResourceLocation gui = new ResourceLocation("crazyfoods:textures/gui/microwave.png");
                this.mc.renderEngine.bindTexture(gui);
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
                int i1;
                
                if (this.microwaveInventory.isBurning())
                {
                    i1 = this.microwaveInventory.getBurnTimeRemainingScaled(12);
                    this.drawTexturedModalRect(x + 45, y + 36 + 13 - i1, 176, 12 - i1, 18, i1 + 3);
                }

                i1 = this.microwaveInventory.getCookProgressScaled(24);
                this.drawTexturedModalRect(x + 79, y + 34, 176, 14, i1 + 1, 16);
        }

}