package minestrapteam.minestrappolation.client.gui;

import org.lwjgl.opengl.GL11;

import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrappolation.inventory.ContainerMelter;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiMelter extends GuiContainer
{
	public static ResourceLocation	texture	= MCAssetManager.getResource("textures/gui/container/melter.png");
	
	private TileEntityMelter		melter;
	
	public GuiMelter(EntityPlayer player, TileEntityMelter melter)
	{
		super(new ContainerMelter(player, melter));
		this.melter = melter;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal(this.melter.getInventoryName()), 8, this.ySize - 94, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		int j = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);
		
		if (this.melter.isBurning())
		{
			int burn = this.melter.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(j + 56, k + 48 - burn, 176, 12 - burn, 14, burn + 2);
		}
		
		if (this.melter.isPowered())
		{
			this.drawTexturedModalRect(j + 58, k + 5, 176, 31, 12, 10);
		}
		
		int update = this.melter.getProgressScaled(24);
		this.drawTexturedModalRect(j + 79, k + 34, 176, 14, update + 1, 16);
	}
}