package minestrapteam.minestrappolation.client.gui;

import org.lwjgl.opengl.GL11;

import clashsoft.cslib.minecraft.entity.CSEntities;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import minestrapteam.minestrappolation.spell.PlayerSpells;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class GuiSpellOverlay extends Gui
{
	public static final ResourceLocation	SPELL_OVERLAY	= new ResourceLocation("minestrappolation", "textures/gui/spell/spell_overlay.png");
	
	private Minecraft						mc				= Minecraft.getMinecraft();
	
	public static final float				SCALING			= 0.75F;
	
	@SubscribeEvent
	public void onOverlay(RenderGameOverlayEvent event)
	{
		boolean pre = event.isCancelable();
		int width = event.resolution.getScaledWidth();
		int height = event.resolution.getScaledHeight();
		
		if (event.type != ElementType.HOTBAR)
		{
			GL11.glTranslatef(0F, pre ? -6F : 6F, 0F);
		}
		
		if (!pre && event.type == ElementType.EXPERIENCE)
		{
			PlayerSpells spells = (PlayerSpells) CSEntities.getProperties("MPlayerSpells", this.mc.thePlayer);
			int left = width / 2 - 97;
			int top = height - 29;
			
			this.mc.renderEngine.bindTexture(SPELL_OVERLAY);
			this.drawTexturedModalRect(left, top, 46, 0, 194, 5);
			
			for (int i = 0; i < 8; i++)
			{
				int manaLevel = spells.getManaLevel(i);
				int maxManaLevel = spells.getMaxManaLevel(i);
				float f = (float) manaLevel / (float) maxManaLevel;
				
				// Overlay the bar
				int x = 1 + i * 24;
				this.mc.renderEngine.bindTexture(SPELL_OVERLAY);
				this.drawTexturedModalRect(left + x, top, 46 + x, 5, (int) (f * 24), 5);
				
				// Draw the textual representation
				String s = String.valueOf(manaLevel);
				float w = this.mc.fontRenderer.getStringWidth(s) * SCALING;
				float x1 = left + x + (24F - w) / 2F;
				
				GL11.glTranslatef(x1, top, 0F);
				GL11.glScalef(SCALING, SCALING, 1F);
				this.mc.fontRenderer.drawStringWithShadow(s, 0, 0, 0xFFFFFF);
				GL11.glScalef(1F / SCALING, 1F / SCALING, 1F);
				GL11.glTranslatef(-x1, -top, 0F);
			}
		}
	}
}
