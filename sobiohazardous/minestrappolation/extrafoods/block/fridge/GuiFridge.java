package sobiohazardous.minestrappolation.extrafoods.block.fridge;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiFridge extends GuiContainer {

		private TileEntityFridge fridgeInventory;
	
        public GuiFridge (InventoryPlayer inventoryPlayer, TileEntityFridge tileEntity) 
        {
                super(new ContainerFridge(tileEntity, inventoryPlayer));
                fridgeInventory = tileEntity;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                //draw text and stuff here
                //the parameters for drawString are: string, x, y, color
                fontRenderer.drawString("Fridge", 8, 6, 4210752);
                //draws "Inventory" or your regional equivalent
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) 
        {
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                ResourceLocation gui = new ResourceLocation("crazyfoods:textures/gui/fridge.png");
                this.mc.renderEngine.bindTexture(gui);
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }

}