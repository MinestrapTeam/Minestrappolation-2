package minestrapteam.minestrappolation.spell;

import java.util.List;

import minestrapteam.minestrappolation.spell.data.SpellVariety;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.IIcon;

public interface ISpell
{
	public String getDisplayName();
	
	public int getDisplayColor();
	
	public EnumRarity getRarity();
	
	public boolean hasVariety(SpellVariety variety);
	
	public List<String> getTooltip(int level);
	
	public void addInformation(List<String> list, int level);
	
	public void registerIcons(IIconRegister iconRegister);
	
	public IIcon getIcon(int pass);
	
	public int getRenderColor(int pass);
	
	public int getRenderPasses();
	
	public void onSpellRightClick(PlayerSpells spells, EntityPlayerMP player);
	
	public boolean castSpell(EntityPlayer player);
}
