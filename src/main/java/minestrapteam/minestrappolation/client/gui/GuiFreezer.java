package minestrapteam.minestrappolation.client.gui;

import org.lwjgl.opengl.GL11;

import clashsoft.cslib.minecraft.lang.I18n;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrappolation.inventory.ContainerFreezer;
import minestrapteam.minestrappolation.tileentity.TileEntityFreezer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiFreezer extends GuiContainer
{
    public static final ResourceLocation texture = new ResourceLocation("minestrappolation", "textures/gui/container/freezer.png");
    
    public TileEntityFreezer freezer;

    public GuiFreezer(InventoryPlayer inventory, TileEntityFreezer freezer)
    {
        super(new ContainerFreezer(inventory, freezer));
        this.freezer = freezer;
    }

    @Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.freezer.getInventoryName();
        this.fontRendererObj.drawString(s, (this.xSize - this.fontRendererObj.getStringWidth(s)) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        if (this.freezer.hasEnergy())
        {
            int i1 = this.freezer.getEnergyTimeScaled(13);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
            i1 = this.freezer.getProgressScaled(24);
            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
        }
    }
}