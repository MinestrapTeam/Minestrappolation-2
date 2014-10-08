package minestrapteam.minestrappolation.client.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;

import clashsoft.cslib.minecraft.lang.I18n;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.network.SpellBarPacket;
import minestrapteam.minestrappolation.spell.PlayerSpells;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.SpellType;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class GuiSpellInventory extends GuiScreen
{
	private static final ResourceLocation	CREATIVE_TABS	= new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
	public static final ResourceLocation	SPELL_INVENTORY	= new ResourceLocation("minestrappolation", "textures/gui/spell/spell_inventory.png");
	
	public int								left;
	public int								top;
	
	public EntityPlayer						player;
	public PlayerSpells						playerSpells;
	
	public SpellType						currentType;
	public List<Spell>						spells;
	
	public Spell							hoveringSpell;
	public Spell							grabbedSpell;
	
	public GuiSpellInventory(EntityPlayer player)
	{
		this.player = player;
		this.playerSpells = PlayerSpells.get(player);
		this.setSpellType(SpellType.WATER);
	}
	
	@Override
	public void initGui()
	{
		this.left = (this.width - 176) / 2;
		this.top = (this.height - 136) / 2;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTickTime)
	{
		for (int i = 0; i < 8; i++)
		{
			SpellType type = SpellType.get(i);
			if (type != this.currentType)
			{
				this.renderTab(type, mouseX, mouseY, false);
			}
		}
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		this.mc.renderEngine.bindTexture(SPELL_INVENTORY);
		this.drawTexturedModalRect(this.left, this.top, 0, 0, 176, 136);
		
		this.renderTab(this.currentType, mouseX, mouseY, true);
		
		this.fontRendererObj.drawString(this.currentType.getDisplayName() + " " + I18n.getString("spell.spells"), this.left + 7, this.top + 6, 4210752);
		
		this.hoveringSpell = null;
		
		for (int i = 0; i < 9; i++)
		{
			Spell spell = null;
			int x = this.left + 8 + i * 18;
			int y;
			
			for (int j = 0; j < 5; j++)
			{
				int index = i + j * 9;
				y = this.top + 18 + j * 18;
				
				if (index < this.spells.size())
				{
					spell = this.spells.get(index);
				}
				else
				{
					spell = null;
				}
				
				this.drawSpellSlot(spell, x, y, mouseX, mouseY);
			}
			
			y = this.top + 112;
			spell = this.playerSpells.getSpell(i);
			
			this.drawSpellSlot(spell, x, y, mouseX, mouseY);
		}
		
		if (this.grabbedSpell != null)
		{
			renderSpellIcon(this.grabbedSpell, mouseX - 8, mouseY - 8);
		}
		
		if (this.hoveringSpell != null)
		{
			this.drawHoveringText(this.hoveringSpell.getTooltip(0), mouseX, mouseY, this.fontRendererObj);
		}
		
		for (int i = 0; i < 8; i++)
		{
			if (this.isMouseOverTab(i, mouseX, mouseY))
			{
				SpellType type = SpellType.get(i);
				this.drawCreativeTabHoveringText(type.chatColor + type.getDisplayName(), mouseX, mouseY);
			}
		}
	}
	
	public boolean drawSpellSlot(Spell spell, int x, int y, int mouseX, int mouseY)
	{
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		boolean flag = false;
		
		if (spell != null)
		{
			renderSpellIcon(spell, x, y);
		}
		
		if (mouseX >= x && mouseX < x + 18 && mouseY >= y && mouseY < y + 18)
		{
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glColorMask(true, true, true, false);
			this.drawGradientRect(x, y, x + 16, y + 16, -2130706433, -2130706433);
			GL11.glColorMask(true, true, true, true);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			
			this.hoveringSpell = spell;
			flag = true;
		}
		
		return flag;
	}
	
	protected void renderTab(SpellType type, int mouseX, int mouseY, boolean selected)
	{
		int id = type.id;
		int i1 = id % 4;
		int x = this.left + i1 * 48;
		int y = this.top - 28;
		int u = i1 * 28;
		int v = selected ? 32 : 0;
		
		if (id >= 4)
		{
			y += 160;
			v += 64;
		}
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		this.mc.renderEngine.bindTexture(CREATIVE_TABS);
		this.drawTexturedModalRect(x, y, u, v, 28, 32);
		
		// TODO Spell Type Icon
	}
	
	@Override
	protected void mouseClicked(int x, int y, int button)
	{
		if (button != 0)
		{
			return;
		}
		
		for (int i = 0; i < 8; i++)
		{
			if (this.isMouseOverTab(i, x, y))
			{
				this.setSpellType(SpellType.get(i));
				return;
			}
		}
		
		for (int i = 0; i < 9; i++)
		{
			int x1 = this.left + 8 + i * 18;
			int y1;
			
			if (this.grabbedSpell == null)
			{
				for (int j = 0; j < 5; j++)
				{
					int index = i + j * 9;
					y1 = this.top + 18 + j * 18;
					
					if (index < this.spells.size() && x >= x1 && x < x1 + 16 && y >= y1 && y < y1 + 16)
					{
						this.grabbedSpell = this.spells.get(index);
						return;
					}
				}
			}
			
			y1 = this.top + 112;
			
			if (x >= x1 && x < x1 + 16 && y >= y1 && y < y1 + 16)
			{
				Minestrappolation.instance.netHandler.sendToServer(new SpellBarPacket(i, this.grabbedSpell));
				
				Spell spell = this.playerSpells.getSpell(i);
				this.playerSpells.setSpell(i, this.grabbedSpell);
				this.grabbedSpell = spell;
				return;
			}
		}
		
		this.grabbedSpell = null;
	}
	
	public boolean isMouseOverTab(int type, int mouseX, int mouseY)
	{
		int i1 = type % 4;
		int x1 = this.left + i1 * 48;
		int y1 = this.top - 28;
		
		if (type >= 4)
		{
			y1 += 160;
		}
		
		return mouseX >= x1 && mouseX <= x1 + 28 && mouseY >= y1 && mouseY <= y1 + 28;
	}
	
	public void setSpellType(SpellType spellType)
	{
		this.currentType = spellType;
		this.spells = spellType.getSpells(this.playerSpells);
	}
	
	public static void renderSpellIcon(Spell spell, int x, int y)
	{
		for (int i = 0; i < spell.getRenderPasses(); i++)
		{
			IIcon icon = spell.getIcon(i);
			if (icon != null)
			{
				GL11.glColor4f(1F, 1F, 1F, 1F);
				Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
				Tessellator tessellator = Tessellator.instance;
				tessellator.startDrawingQuads();
				tessellator.addVertexWithUV(x, y + 16D, 0D, icon.getMinU(), icon.getMaxV());
				tessellator.addVertexWithUV(x + 16D, y + 16D, 0D, icon.getMaxU(), icon.getMaxV());
				tessellator.addVertexWithUV(x + 16D, y, 0D, icon.getMaxU(), icon.getMinV());
				tessellator.addVertexWithUV(x, y, 0D, icon.getMinU(), icon.getMinV());
				tessellator.draw();
			}
		}
	}
}
