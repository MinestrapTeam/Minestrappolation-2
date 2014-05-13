package com.minestrappolation.handler;

import java.util.Random;

import com.minestrappolation.lib.MBlocks;
import com.minestrappolation.lib.MItems;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

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
		recipes.add(new MerchantRecipe(new ItemStack(MBlocks.sandstoneBricks, 1, 3), new ItemStack(Items.emerald, 5)));
		recipes.add(new MerchantRecipe(new ItemStack(MBlocks.sandstoneBricks, 1, 4), new ItemStack(Items.emerald, 5)));
		
		recipes.add(new MerchantRecipe(new ItemStack(MItems.SunstoneDust, 11), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MBlocks.SoulGem, 3), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.BlaziumIngot, 5), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.ToriteIngot, 6), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MItems.PinkQuartz, 18), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(MBlocks.RadiantQuartz, 2), new ItemStack(Items.emerald, 1)));
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(MBlocks.SoulBottle, 1)));
	}
}
