package sobiohazardous.mods.minestrappolation.handler;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class PriestTradeHandler implements IVillageTradeHandler
{
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random)
	{
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.SunstoneDust, 11), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOBlocks.SoulGem, 3), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.BlaziumIngot, 5), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.ToriteIngot, 6), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.PinkQuartz, 18), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOBlocks.RadiantQuartz, 2), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(EOBlocks.SoulBottle, 1)));
	}
}
