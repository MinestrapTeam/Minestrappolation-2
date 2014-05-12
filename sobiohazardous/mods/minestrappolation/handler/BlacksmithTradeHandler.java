package sobiohazardous.mods.minestrappolation.handler;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.lib.MItems;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class BlacksmithTradeHandler implements IVillageTradeHandler
{
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random)
	{
		recipes.add(new MerchantRecipe(new ItemStack(MItems.CopperIngot, 10), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.TinIngot, 10), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.SteelIngot, 6), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.BronzeIngot, 6), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.meuroditeIngot, 5), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.TitaniumIngot, 1), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.Uranium, 7), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.Plutonium, 7), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MItems.BronzeHelmet, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 13), new ItemStack(MItems.BronzeChest, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 9), new ItemStack(MItems.BronzePants, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MItems.BronzeBoots, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 11), new ItemStack(MItems.BronzeSword, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 8), new ItemStack(MItems.BronzePickaxe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 7), new ItemStack(MItems.BronzeAxe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MItems.BronzeShovel, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MItems.BronzeHoe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MItems.SteelHelmet, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 13), new ItemStack(MItems.SteelChest, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 9), new ItemStack(MItems.SteelPants, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MItems.SteelBoots, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 11), new ItemStack(MItems.SteelSword, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 8), new ItemStack(MItems.SteelPickaxe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 7), new ItemStack(MItems.SteelAxe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MItems.SteelShovel, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MItems.SteelHoe, 1)));
	}
}