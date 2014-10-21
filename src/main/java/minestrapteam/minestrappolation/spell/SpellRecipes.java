package minestrapteam.minestrappolation.spell;

import scala.actors.threadpool.Arrays;
import clashsoft.brewingapi.item.ItemPotion2;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;

public class SpellRecipes
{
	public static int getPotency(SpellType type, ItemStack stack)
	{
		if (stack == null)
		{
			return 0;
		}
		// FIXME
		return 100 * stack.stackSize;
	}
	
	public static SpellCategory getCategory(ItemStack stack)
	{
		if (stack == null)
		{
			return null;
		}
		
		NBTTagList enchantments = stack.getEnchantmentTagList();
		if (enchantments == null || enchantments.tagCount() == 0)
		{
			return null;
		}
		
		for (int i = 0; i < enchantments.tagCount(); i++)
		{
			short id = enchantments.getCompoundTagAt(i).getShort("id");
			Enchantment ench = Enchantment.enchantmentsList[id];
			SpellCategory category = getCategory(ench);
			if (category != null)
			{
				return category;
			}
		}
		
		return null;
	}
	
	public static SpellCategory getCategory(Enchantment ench)
	{
		if (ench == null)
		{
			return null;
		}
		else if (ench == Enchantment.looting || ench == Enchantment.fortune)
		{
			return SpellCategory.SUMMONING;
		}
		
		EnumEnchantmentType type = ench.type;
		if (type == EnumEnchantmentType.weapon)
		{
			return SpellCategory.OFFENSE;
		}
		else if (type == EnumEnchantmentType.armor || type == EnumEnchantmentType.armor_head || type == EnumEnchantmentType.armor_torso || type == EnumEnchantmentType.armor_legs || type == EnumEnchantmentType.armor_feet)
		{
			return SpellCategory.DEFENSE;
		}
		else if (type == EnumEnchantmentType.digger)
		{
			return SpellCategory.ALTERATION;
		}
		else if (type == EnumEnchantmentType.fishing_rod)
		{
			return SpellCategory.SUMMONING;
		}
		
		return null;
	}
	
	public static SpellVariety getVariety(ItemStack stack, SpellCategory category)
	{
		if (stack == null)
		{
			return null;
		}
		
		Item item = stack.getItem();
		if (category == SpellCategory.OFFENSE)
		{
			if (item == Items.fire_charge)
			{
				return SpellVariety.PROJECTILE;
			}
			else if (item == MItems.radiantQuartz)
			{
				return SpellVariety.BEAM;
			}
			else if (item instanceof ItemPotion2)
			{
				if (((ItemPotion2) item).isSplash(stack))
				{
					return SpellVariety.SPRAY;
				}
			}
			else if (item == Items.ender_eye)
			{
				return SpellVariety.VORTEX;
			}
		}
		else if (category == SpellCategory.DEFENSE)
		{
			if (item == MItems.plateSteelItem)
			{
				return SpellVariety.BODY_ARMOR;
			}
			else if (item == Item.getItemFromBlock(MBlocks.sunstoneBlock))
			{
				return SpellVariety.AREA_SHIELD;
			}
			else if (item == Item.getItemFromBlock(MBlocks.enderBlock))
			{
				return SpellVariety.MIRROR_SHIELD;
			}
			else if (item == MItems.blazeShard)
			{
				return SpellVariety.ABRASIVE_ARMOR;
			}
		}
		return null;
	}
	
	public static SpellEnhancement getEnhancement(ItemStack stack, SpellVariety variety)
	{
		if (stack == null)
		{
			return null;
		}
		return null;
	}
	
	public static int[] combinePotencies(int[] potencies)
	{
		potencies = Arrays.copyOf(potencies, 8);
		combinePotencies(potencies, SpellType.WATER, SpellType.FIRE, SpellType.WIND);
		combinePotencies(potencies, SpellType.WATER, SpellType.ELECTRICITY, SpellType.ELECTRICITY);
		combinePotencies(potencies, SpellType.EARTH, SpellType.ELECTRICITY, SpellType.EARTH);
		combinePotencies(potencies, SpellType.FROST, SpellType.FIRE, SpellType.WATER);
		return potencies;
	}
	
	private static void combinePotencies(int[] potencies, SpellType type1, SpellType type2, SpellType type3)
	{
		int i1 = type1.id;
		int p1 = potencies[i1];
		if (p1 > 0)
		{
			int i2 = type2.id;
			int p2 = potencies[i2];
			if (p2 > 0)
			{
				potencies[i1] = 0;
				potencies[i2] = 0;
				potencies[type3.id] += p1 + p2;
			}
		}
	}
}
