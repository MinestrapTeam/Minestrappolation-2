package sobiohazardous.mods.minestrappolation.extraores.handler;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
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
        new ItemStack(EOItemManager.CopperIngot, 10),
        new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(EOItemManager.TinIngot, 10),
		        new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(EOItemManager.SteelIngot, 6),
		        new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(EOItemManager.BronzeIngot, 6),
		        new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(EOItemManager.meuroditeIngot, 5),
		        new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(EOItemManager.TitaniumIngot, 1),
		        new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(EOItemManager.Uranium, 7),
		        new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(EOItemManager.Plutonium, 7),
		        new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 5),
		        new ItemStack(EOItemManager.BronzeHelmet, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 13),
		        new ItemStack(EOItemManager.BronzeChest, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 9),
		        new ItemStack(EOItemManager.BronzePants, 1)));

		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 5),
		        new ItemStack(EOItemManager.BronzeBoots, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 11),
		        new ItemStack(EOItemManager.BronzeSword, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 8),
		        new ItemStack(EOItemManager.BronzePickaxe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 7),
		        new ItemStack(EOItemManager.BronzeAxe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 5),
		        new ItemStack(EOItemManager.BronzeShovel, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 5),
		        new ItemStack(EOItemManager.BronzeHoe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 5),
		        new ItemStack(EOItemManager.SteelHelmet, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 13),
		        new ItemStack(EOItemManager.SteelChest, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 9),
		        new ItemStack(EOItemManager.SteelPants, 1)));

		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 5),
		        new ItemStack(EOItemManager.SteelBoots, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 11),
		        new ItemStack(EOItemManager.SteelSword, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 8),
		        new ItemStack(EOItemManager.SteelPickaxe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 7),
		        new ItemStack(EOItemManager.SteelAxe, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 5),
		        new ItemStack(EOItemManager.SteelShovel, 1)));
		
		recipes.add(new MerchantRecipe(
		        new ItemStack(Items.emerald, 5),
		        new ItemStack(EOItemManager.SteelHoe, 1)));

	}
}