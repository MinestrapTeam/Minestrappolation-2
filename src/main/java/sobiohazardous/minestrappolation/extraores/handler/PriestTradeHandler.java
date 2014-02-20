package sobiohazardous.minestrappolation.extraores.handler;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class PriestTradeHandler implements IVillageTradeHandler
{ 
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random) 
	{
		recipes.add(new MerchantRecipe(
	       new ItemStack(EOItemManager.SunstoneDust, 11),
	       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOBlockManager.SoulGem, 3),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOItemManager.BlaziumIngot, 5),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOItemManager.ToriteIngot, 6),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOItemManager.PinkQuartz, 18),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(EOBlockManager.RadiantQuartz, 2),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(Item.emerald, 5),
			       new ItemStack(EOBlockManager.SoulBottle, 1)));
	}
}
