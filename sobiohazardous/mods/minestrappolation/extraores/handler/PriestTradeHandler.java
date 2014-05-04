package sobiohazardous.mods.minestrappolation.extraores.handler;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItemManager;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class PriestTradeHandler implements IVillageTradeHandler
{ 
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random) 
	{
		recipes.add(new MerchantRecipe(
	       new ItemStack(EOItemManager.SunstoneDust, 11),
	       new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOBlockManager.SoulGem, 3),
			       new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOItemManager.BlaziumIngot, 5),
			       new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOItemManager.ToriteIngot, 6),
			       new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOItemManager.PinkQuartz, 18),
			       new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOBlockManager.RadiantQuartz, 2),
			       new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(Items.emerald, 5),
			       new ItemStack(EOBlockManager.SoulBottle, 1)));
	}
}
