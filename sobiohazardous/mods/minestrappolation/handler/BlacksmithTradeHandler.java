package sobiohazardous.mods.minestrappolation.handler;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class BlacksmithTradeHandler implements IVillageTradeHandler
{
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random)
	{
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.CopperIngot, 10), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.TinIngot, 10), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.SteelIngot, 6), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.BronzeIngot, 6), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.meuroditeIngot, 5), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.TitaniumIngot, 1), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.Uranium, 7), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(EOItems.Plutonium, 7), new ItemStack(Items.emerald, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(EOItems.BronzeHelmet, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 13), new ItemStack(EOItems.BronzeChest, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 9), new ItemStack(EOItems.BronzePants, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(EOItems.BronzeBoots, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 11), new ItemStack(EOItems.BronzeSword, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 8), new ItemStack(EOItems.BronzePickaxe, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 7), new ItemStack(EOItems.BronzeAxe, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(EOItems.BronzeShovel, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(EOItems.BronzeHoe, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(EOItems.SteelHelmet, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 13), new ItemStack(EOItems.SteelChest, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 9), new ItemStack(EOItems.SteelPants, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(EOItems.SteelBoots, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 11), new ItemStack(EOItems.SteelSword, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 8), new ItemStack(EOItems.SteelPickaxe, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 7), new ItemStack(EOItems.SteelAxe, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(EOItems.SteelShovel, 1)));
		
		recipes.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(EOItems.SteelHoe, 1)));
		
	}
}