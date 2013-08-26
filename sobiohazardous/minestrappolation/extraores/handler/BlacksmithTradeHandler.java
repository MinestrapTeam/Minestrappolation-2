package sobiohazardous.minestrappolation.extraores.handler;

import java.util.Random;

import sobiohazardous.minestrappolation.extraores.ExtraOres;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class BlacksmithTradeHandler implements IVillageTradeHandler 
{
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random) 
	{
		recipes.add(new MerchantRecipe(
        new ItemStack(ExtraOres.CopperIngot, 10),
        new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(ExtraOres.TinIngot, 10),
		        new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(ExtraOres.SteelIngot, 6),
		        new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(ExtraOres.BronzeIngot, 6),
		        new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(ExtraOres.meuroditeIngot, 5),
		        new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(ExtraOres.TitaniumIngot, 1),
		        new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(ExtraOres.Uranium, 7),
		        new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(ExtraOres.Plutonium, 7),
		        new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 5),
		        new ItemStack(ExtraOres.BronzeHelmet, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 13),
		        new ItemStack(ExtraOres.BronzeChest, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 9),
		        new ItemStack(ExtraOres.BronzePants, 1)));

		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 5),
		        new ItemStack(ExtraOres.BronzeBoots, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 11),
		        new ItemStack(ExtraOres.BronzeSword, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 8),
		        new ItemStack(ExtraOres.BronzePickaxe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 7),
		        new ItemStack(ExtraOres.BronzeAxe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 5),
		        new ItemStack(ExtraOres.BronzeShovel, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 5),
		        new ItemStack(ExtraOres.BronzeHoe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 5),
		        new ItemStack(ExtraOres.SteelHelmet, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 13),
		        new ItemStack(ExtraOres.SteelChest, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 9),
		        new ItemStack(ExtraOres.SteelPants, 1)));

		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 5),
		        new ItemStack(ExtraOres.SteelBoots, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 11),
		        new ItemStack(ExtraOres.SteelSword, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 8),
		        new ItemStack(ExtraOres.SteelPickaxe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 7),
		        new ItemStack(ExtraOres.SteelAxe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 5),
		        new ItemStack(ExtraOres.SteelShovel, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Item.emerald, 5),
		        new ItemStack(ExtraOres.SteelHoe, 1)));

	}
}