package sobiohazardous.mods.minestrappolation.core.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.core.inventory.ContainerStonecutter;
import sobiohazardous.mods.minestrappolation.core.tileentity.TileEntityStonecutter;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;

@SideOnly(Side.CLIENT)
public class GuiStonecutter extends GuiContainer
{
	private static final ResourceLocation	texture	= new ResourceLocation(MAssetManager.getMAPITexture("textures/gui/stonecutter.png"));
	
	public GuiStonecutter(InventoryPlayer inventory, TileEntityStonecutter te, World world, int x, int y, int z)
	{
		super(new ContainerStonecutter(inventory, te));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("tile.stonecutter.name"), 28, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}
