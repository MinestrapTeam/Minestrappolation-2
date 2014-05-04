package sobiohazardous.mods.minestrappolation.extradecor.handler;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class EDPriestTradeHandler implements IVillageTradeHandler
{
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random) 
	{
		recipes.add(new MerchantRecipe(
				new ItemStack(EDBlocks.sandstoneBricks, 1, 3),
				new ItemStack(Items.emerald, 5)));
		
		recipes.add(new MerchantRecipe(
				new ItemStack(EDBlocks.sandstoneBricks, 1, 4),
				new ItemStack(Items.emerald, 5)));
	}
}
