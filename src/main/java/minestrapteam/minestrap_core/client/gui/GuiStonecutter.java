package minestrapteam.minestrap_core.client.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrap_core.inventory.ContainerStonecutter;
import minestrapteam.minestrap_core.tileentity.TileEntityStonecutter;
import minestrapteam.minestrap_core.util.MCAssetManager;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class GuiStonecutter extends GuiContainer
{
	public static ResourceLocation	texture	= MCAssetManager.getResource("stonecutter");
	
	private TileEntityStonecutter	stonecutter;
	
	public GuiStonecutter(InventoryPlayer inventory, TileEntityStonecutter te, World world, int x, int y, int z)
	{
		super(new ContainerStonecutter(inventory, te));
		this.stonecutter = te;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal(this.stonecutter.getInventoryName()), 42, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 94, 4210752);
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
