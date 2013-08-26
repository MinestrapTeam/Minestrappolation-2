package sobiohazardous.minestrappolation.extraores.handler;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import sobiohazardous.minestrappolation.extraores.ExtraOres;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class PriestTradeHandler implements IVillageTradeHandler
{ 
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random) 
	{
		recipes.add(new MerchantRecipe(
	       new ItemStack(ExtraOres.SunstoneDust, 11),
	       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(ExtraOres.SoulGem, 3),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(ExtraOres.BlaziumIngot, 5),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(ExtraOres.ToriteIngot, 6),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(ExtraOres.PinkQuartz, 18),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(ExtraOres.RadiantQuartz, 2),
			       new ItemStack(Item.emerald, 1)));
		
		recipes.add(new MerchantRecipe(
			       new ItemStack(Item.emerald, 5),
			       new ItemStack(ExtraOres.SoulBottle, 1)));
	}
}
