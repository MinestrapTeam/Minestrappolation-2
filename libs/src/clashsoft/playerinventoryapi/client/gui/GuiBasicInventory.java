package clashsoft.playerinventoryapi.client.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.opengl.GL11;

import clashsoft.cslib.minecraft.client.gui.GuiBuilder;
import clashsoft.cslib.util.CSString;
import clashsoft.playerinventoryapi.PlayerInventoryAPI;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public abstract class GuiBasicInventory extends GuiContainer
{
	protected final GuiBuilder			guiBuilder;
	
	private boolean						wasEmpty	= false;
	private Collection<PotionEffect>	effects;
	
	public GuiBasicInventory(Container container)
	{
		super(container);
		this.guiBuilder = new GuiBuilder(this);
	}
	
	public void drawBackgroundFrame(int posX, int posY, int width, int height)
	{
		this.guiBuilder.drawFrame(posX, posY, width, height);
	}
	
	public void drawPlayerBackground(int posX, int posY)
	{
		this.guiBuilder.drawPlayerBackgroundL(posX, posY);
	}
	
	public void drawSlot(int posX, int posY)
	{
		this.guiBuilder.drawSlot(posX, posY);
	}
	
	public void drawPlayerHoveringText(EntityPlayer player, int x, int y, FontRenderer font)
	{
		List<String> list = new ArrayList();
		Team team = player.getTeam();
		
		if (team != null)
		{
			list.add(team.formatString(player.getDisplayName()));
			list.add(team.getRegisteredName());
		}
		else
		{
			list.add(player.getDisplayName());
		}
		
		this.drawHoveringText(list, x - this.guiLeft, y - this.guiTop, font);
	}
	
	public void drawPotionEffectHoveringText(PotionEffect effect, int x, int y, FontRenderer font)
	{
		List<String> list = new ArrayList();
		Potion potion = Potion.potionTypes[effect.getPotionID()];
		String name = StatCollector.translateToLocal(effect.getEffectName());
		
		list.add((potion.isBadEffect() ? EnumChatFormatting.RED : EnumChatFormatting.GREEN) + name);
		list.add("Level: " + CSString.convertToRoman(effect.getAmplifier() + 1));
		list.add(Potion.getDurationString(effect));
		if (effect.getIsAmbient())
		{
			list.add("\u00a73\u00a7oAmbient");
		}
		
		this.drawHoveringText(list, x - this.guiLeft, y - this.guiTop, font);
	}
	
	@Override
	public void updateScreen()
	{
		this.effects = this.mc.thePlayer.getActivePotionEffects();
		boolean isEmpty = this.effects.isEmpty();
		
		if (isEmpty != this.wasEmpty)
		{
			this.buttonList.clear();
			this.initGui();
			this.wasEmpty = isEmpty;
		}
		
		super.updateScreen();
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		this.effects = this.mc.thePlayer.getActivePotionEffects();
		if (!this.effects.isEmpty())
		{
			this.guiLeft += 60;
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		if (PlayerInventoryAPI.itemTooltip)
		{
			ItemStack stack = this.mc.thePlayer.inventory.getItemStack();
			if (stack != null)
			{
				this.renderToolTip(stack, mouseX - this.guiLeft, mouseY - this.guiTop);
			}
		}
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		
		int i = -124;
		int j = 0;
		
		Collection effects = this.effects;
		
		if (effects != null && !effects.isEmpty())
		{
			int l = 33;
			if (effects.size() > 5)
			{
				l = 132 / (effects.size() - 1);
			}
			
			for (Object o : effects)
			{
				PotionEffect effect = (PotionEffect) o;
				Potion localPotion = Potion.potionTypes[effect.getPotionID()];
				
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				this.mc.getTextureManager().bindTexture(field_147001_a);
				
				this.drawTexturedModalRect(i, j, 0, 166, 140, 32);
				
				if (localPotion.hasStatusIcon())
				{
					int i1 = localPotion.getStatusIconIndex();
					this.drawTexturedModalRect(i + 6, j + 7, i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
				}
				
				String text = StatCollector.translateToLocal(localPotion.getName());
				if (effect.getAmplifier() > 0)
				{
					text += " " + CSString.convertToRoman(effect.getAmplifier() + 1);
				}
				
				this.fontRendererObj.drawStringWithShadow(text, i + 28, j + 6, 16777215);
				text = Potion.getDurationString(effect);
				this.fontRendererObj.drawStringWithShadow(text, i + 28, j + 16, 8355711);
				
				if (PlayerInventoryAPI.buffTooltip && this.func_146978_c(i + 6, j + 7, 18, 18, mouseX, mouseY))
				{
					this.drawPotionEffectHoveringText(effect, mouseX, mouseY, this.fontRendererObj);
				}
				
				j += l;
			}
		}
	}
}
