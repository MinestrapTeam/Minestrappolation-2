package minestrapteam.minestrappolation.client.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;

import clashsoft.cslib.minecraft.lang.I18n;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.inventory.ContainerArcaneForge;
import minestrapteam.minestrappolation.network.SpellAddPacket;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.tileentity.TileEntityArcaneForge;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiArcaneForge extends GuiContainer
{
	public static final ResourceLocation	texture	= new ResourceLocation("minestrappolation", "textures/gui/spell/arcane_forge.png");
	
	public TileEntityArcaneForge			arcaneForge;
	
	public GuiArcaneForge(EntityPlayer player, TileEntityArcaneForge freezer)
	{
		super(new ContainerArcaneForge(player, freezer));
		this.arcaneForge = freezer;
		this.ySize = 218;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.arcaneForge.getInventoryName();
		this.fontRendererObj.drawString(s, (this.xSize - this.fontRendererObj.getStringWidth(s)) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.getString("container.inventory"), 8, this.ySize - 94, 4210752);
		
		// Renders the Spell icon in the result slot
		Spell spell = this.arcaneForge.spell;
		if (spell != null)
		{
			GuiSpellInventory.renderSpellIcon(spell, 80, 67);
		}
		
		// Renders the result slot hover 'highlight' effect
		if (this.func_146978_c(80, 67, 16, 16, mouseX, mouseY))
		{
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glColorMask(true, true, true, false);
			this.drawGradientRect(80, 67, 96, 83, -2130706433, -2130706433);
			GL11.glColorMask(true, true, true, true);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			
			// Renders the Spell tooltip
			if (spell != null)
			{
				List<String> lines = spell.getTooltip();
				this.drawHoveringText(lines, mouseX - this.guiLeft, mouseY - this.guiTop, this.fontRendererObj);
			}
		}
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
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int button)
	{
		Spell spell = this.arcaneForge.spell;
		if (button == 0 && spell != null && this.func_146978_c(80, 67, 16, 16, mouseX, mouseY))
		{
			EntityPlayer player = this.mc.thePlayer;
			PlayerSpells spells = PlayerSpells.get(player);
			if (spells.addSpell(spell))
			{
				this.arcaneForge.onSpellCrafted(player);
				Minestrappolation.instance.netHandler.sendToServer(new SpellAddPacket(spell));
			}
		}
		else
		{
			super.mouseClicked(mouseX, mouseY, button);
		}
	}
}
