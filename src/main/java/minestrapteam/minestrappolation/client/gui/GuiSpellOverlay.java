package minestrapteam.minestrappolation.client.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.client.MClientProxy;
import minestrapteam.minestrappolation.network.SpellUsePacket;
import minestrapteam.minestrappolation.spell.ISpell;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.SpellHandler;
import minestrapteam.minestrappolation.spell.data.SpellType;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.TextureStitchEvent;

public class GuiSpellOverlay extends Gui
{
	public static final ResourceLocation	SPELL_OVERLAY	= new ResourceLocation("minestrappolation", "textures/gui/spell/spell_overlay.png");
	public static final float				SCALING			= 0.75F;
	
	public static GuiSpellOverlay			instance		= new GuiSpellOverlay();
	
	private Minecraft						mc				= Minecraft.getMinecraft();
	
	public PlayerSpells						spells;
	
	public boolean							spellBarSelected;
	public int								spellHighlightTicks;
	
	@SubscribeEvent
	public void onOverlay(RenderGameOverlayEvent event)
	{
		boolean pre = event.isCancelable();
		int width = event.resolution.getScaledWidth();
		int height = event.resolution.getScaledHeight();
		
		if (event.type == ElementType.ARMOR || event.type == ElementType.EXPERIENCE || event.type == ElementType.FOOD || event.type == ElementType.HEALTH || event.type == ElementType.HEALTHMOUNT || event.type == ElementType.JUMPBAR || event.type == ElementType.TEXT)
		{
			GL11.glTranslatef(0F, pre ? -6F : 6F, 0F);
		}
		
		if (!pre && event.type == ElementType.EXPERIENCE)
		{
			this.spells = PlayerSpells.get(this.mc.thePlayer);
			this.renderManaBar(width, height);
			this.renderSpellHotbar(width, height);
		}
	}
	
	@SubscribeEvent
	public void preTextureStitch(TextureStitchEvent.Pre event)
	{
		SpellHandler.registerIcons(event.map);
	}
	
	@SubscribeEvent
	public void onTick(ClientTickEvent event)
	{
		if (event.phase == Phase.START)
		{
			this.onUpdate();
		}
	}
	
	@SubscribeEvent
	public void mouseEvent(MouseEvent event)
	{
		if (this.spellBarSelected)
		{
			if (event.dwheel != 0)
			{
				event.setCanceled(true);
				this.spells.updateCurrentSpell(event.dwheel);
				this.spellHighlightTicks = 40;
			}
			else if (event.buttonstate && event.button == 1)
			{
				event.setCanceled(true);
				Minestrappolation.instance.netHandler.sendToServer(new SpellUsePacket(this.spells));
			}
		}
	}
	
	public void onUpdate()
	{
		if (MClientProxy.keySpellbarSwitch.isPressed())
		{
			this.spellBarSelected = !this.spellBarSelected;
		}
		
		if (MClientProxy.keySpellInventory.isPressed())
		{
			this.mc.displayGuiScreen(new GuiSpellInventory(this.mc.thePlayer));
		}
		
		if (this.spellHighlightTicks > 0)
		{
			this.spellHighlightTicks--;
		}
	}
	
	public void renderManaBar(int width, int height)
	{
		int left = width / 2 - 97;
		int top = height - 29;
		
		this.mc.renderEngine.bindTexture(SPELL_OVERLAY);
		this.drawTexturedModalRect(left, top, 46, 0, 194, 5);
		
		for (int i = 0; i < 8; i++)
		{
			SpellType type = SpellType.get(i);
			int manaLevel = this.spells.manaLevels[i];
			int maxManaLevel = this.spells.maxManaLevels[i];
			float f = (float) manaLevel / (float) maxManaLevel;
			
			// Overlay the bar
			int x = 1 + i * 24;
			GL11.glColor4f(1F, 1F, 1F, 1F);
			this.mc.renderEngine.bindTexture(SPELL_OVERLAY);
			this.drawTexturedModalRect(left + x, top, 46 + x, 5, (int) (f * 24), 5);
			
			// Draw the textual representation
			String s = String.valueOf(manaLevel);
			float w = this.mc.fontRenderer.getStringWidth(s) * SCALING;
			float x1 = left + x + (24F - w) / 2F;
			
			GL11.glTranslatef(x1, top, 0F);
			GL11.glScalef(SCALING, SCALING, 1F);
			this.mc.fontRenderer.drawStringWithShadow(s, 0, 0, type.color);
			GL11.glScalef(1F / SCALING, 1F / SCALING, 1F);
			GL11.glTranslatef(-x1, -top, 0F);
		}
	}
	
	public void renderSpellHotbar(int width, int height)
	{
		float f = this.spellBarSelected ? 1F : 0.5F;
		GL11.glColor4f(f, f, f, 1F);
		this.mc.renderEngine.bindTexture(SPELL_OVERLAY);
		int left = width - 22;
		int top = (height - 182) / 2;
		int top1 = top + (this.spells.currentSpell * 20);
		
		this.drawTexturedModalRect(left, top, 0, 0, 22, 182);
		this.drawTexturedModalRect(left - 1, top1 - 1, 22, 0, 24, 24);
		
		// Spell Icons
		this.mc.renderEngine.bindTexture(TextureMap.locationItemsTexture);
		for (int i = 0; i < 9; i++)
		{
			ISpell spell = this.spells.getSpell(i);
			if (spell == null)
			{
				continue;
			}
			
			GuiSpellInventory.renderSpellIcon(spell, left + 3, top + 3 + i * 20);
		}
		
		// Spell Tooltip
		if (this.spellHighlightTicks > 0)
		{
			ISpell spell = this.spells.getCurrentSpell();
			if (spell != null)
			{
				String name = spell.getDisplayName();
				int left1 = left - this.mc.fontRenderer.getStringWidth(name) - 5;
				int i = (int) (this.spellHighlightTicks * 256F / 10F);
				
				if (i > 255)
				{
					i = 255;
				}
				
				if (i > 0)
				{
					GL11.glPushMatrix();
					GL11.glEnable(GL11.GL_BLEND);
					OpenGlHelper.glBlendFunc(770, 771, 1, 0);
					this.mc.fontRenderer.drawStringWithShadow(name, left1, top1 + 7, spell.getDisplayColor() | (i << 24));
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glPopMatrix();
				}
			}
		}
	}
}
