package minestrapteam.minestrappolation.common;

import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.lib.MTools;

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
		recipes.add(new MerchantRecipe(new ItemStack(MItems.copperIngot, 10), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.tinIngot, 10), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.steelIngot, 6), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.bronzeIngot, 6), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.meuroditeGem, 5), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.titaniumIngot, 1), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.uranium, 7), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.plutonium, 7), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 11), new ItemStack(MTools.bronzeSword, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MTools.bronzeShovel, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 8), new ItemStack(MTools.bronzePickaxe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 7), new ItemStack(MTools.bronzeAxe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MTools.bronzeHoe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MTools.bronzeHelmet, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 13), new ItemStack(MTools.bronzeChestplate, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 9), new ItemStack(MTools.bronzeLeggings, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MTools.bronzeBoots, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 11), new ItemStack(MTools.steelSword, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MTools.steelShovel, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 8), new ItemStack(MTools.steelPickaxe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 7), new ItemStack(MTools.steelAxe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MTools.steelHoe, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MTools.steelHelmet, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 13), new ItemStack(MTools.steelChestplate, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 9), new ItemStack(MTools.steelLeggings, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MTools.steelBoots, 1)));
	}
}