package sobiohazardous.mods.minestrappolation.client.gui;

import org.lwjgl.opengl.GL11;

import sobiohazardous.mods.minestrappolation.container.ContainerMelter;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import sobiohazardous.mods.minestrappolation.tileentity.TileEntityMelter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiMelter extends GuiContainer
{
	private TileEntityMelter	tileEntity;
	
	public GuiMelter(EntityPlayer player, TileEntityMelter melter)
	{
		super(new ContainerMelter(player, melter));
		this.tileEntity = melter;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.tileEntity.hasCustomInventoryName() ? this.tileEntity.getInventoryName() : StatCollector.translateToLocal("tile.melter.name");
		this.fontRendererObj.drawString(s, 8, this.ySize - 94, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ResourceLocation gui = new ResourceLocation(MCAssetManager.getTexture("textures/gui/melter.png"));
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
		
		int update = this.tileEntity.getProgressScaled(24);
		this.drawTexturedModalRect(j + 79, k + 34, 176, 14, update + 1, 16);
	}
}