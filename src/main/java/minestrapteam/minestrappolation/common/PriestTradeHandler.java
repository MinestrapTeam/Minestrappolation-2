package minestrapteam.minestrappolation.common;

import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class PriestTradeHandler implements IVillageTradeHandler
{
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random)
	{
		recipes.add(new MerchantRecipe(new ItemStack(MBlocks.sandstone, 3, 6), new ItemStack(Items.emerald, 2)));
		recipes.add(new MerchantRecipe(new ItemStack(MBlocks.sandstone, 3, 7), new ItemStack(Items.emerald, 2)));
		recipes.add(new MerchantRecipe(new ItemStack(MBlocks.redSandstone, 3, 7), new ItemStack(Items.emerald, 2)));
		recipes.add(new MerchantRecipe(new ItemStack(MBlocks.redSandstone, 3, 8), new ItemStack(Items.emerald, 2)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.radiantQuartz, 2), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.soulGem, 2), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.soulBottle, 3), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.blazeShard, 9), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(MBlocks.sunstoneBlock, 2)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 20), new ItemStack(MBlocks.godstone, 1)));
	}
}
