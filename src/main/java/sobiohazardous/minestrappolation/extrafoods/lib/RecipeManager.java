package sobiohazardous.minestrappolation.extrafoods.lib;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import sobiohazardous.minestrappolation.extrafoods.block.microwave.MicrowaveRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class RecipeManager 
{
	public static final int ALL_DURABILITIES = Short.MAX_VALUE;

	public static void loadRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.microwaveIdle, 1), new Object[]
				{
			"III", "RGR", "IBI", Character.valueOf('I'), Item.ingotIron, Character.valueOf('R'), Item.redstone, Character.valueOf('G'), Block.thinGlass, Character.valueOf('B'), Item.blazeRod
				});
		GameRegistry.addSmelting(ExtraFoods.oreAluminum.blockID, new ItemStack(ExtraFoods.aluminum), 0.8F);

		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.breadSlice, 4), new Object[]
				{
			Item.bread, new ItemStack(ExtraFoods.knifeStone, 1,ALL_DURABILITIES)
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.breadSlice, 4), new Object[]
				{
			Item.bread, new ItemStack(ExtraFoods.knifeIron, 1,ALL_DURABILITIES)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.breadSlice, 4), new Object[]
				{
			Item.bread, new ItemStack(ExtraFoods.knifeDiamond, 1,ALL_DURABILITIES)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.flour, 1), new Object[]
				{
			Item.wheat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.dough, 1), new Object[]
				{
			ExtraFoods.flour, Item.bucketWater
				});
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.cakeCheeseItem, 1), new Object[]
				{
			"CCC", "SES", "DDD", Character.valueOf('C'), ExtraFoods.cheese, Character.valueOf('S'), Item.sugar, Character.valueOf('E'), Item.egg, Character.valueOf('D'), ExtraFoods.dough
				});
		MicrowaveRecipes.smelting().addDoubleSmelting(new ItemStack(Item.bucketMilk), new ItemStack(Item.bucketMilk), new ItemStack(ExtraFoods.cheese,1));
		FurnaceRecipes.smelting().addSmelting(new ItemStack(Item.dyePowder, 1, 3).itemID, new ItemStack(ExtraFoods.syrupChocolate), 0.6F);
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.cakeChocolateItem, 1), new Object[]
				{
			"MCM", "SES", "DDD", Character.valueOf('M'), Item.bucketMilk, Character.valueOf('S'), Item.sugar, Character.valueOf('E'), Item.egg, Character.valueOf('D'), ExtraFoods.dough, Character.valueOf('C'), ExtraFoods.syrupChocolate
				});
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.cakeGoldItem, 1), new Object[]
				{
			"MCM", "SES", "DDD", Character.valueOf('M'), Item.bucketMilk, Character.valueOf('S'), Item.sugar, Character.valueOf('E'), Item.egg, Character.valueOf('D'), ExtraFoods.dough, Character.valueOf('C'), new ItemStack(Item.appleGold, 1, 0)
				});
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.cakeExplosiveItem, 1), new Object[]
				{
			"MTM", "SES", "DDD", Character.valueOf('M'), Item.bucketMilk, Character.valueOf('S'), Item.sugar, Character.valueOf('E'), Item.egg, Character.valueOf('D'), ExtraFoods.dough, Character.valueOf('T'), Block.tnt
				});
		GameRegistry.addSmelting(ExtraFoods.corn.itemID, new ItemStack(ExtraFoods.cornCooked), 0.6F);
		GameRegistry.addSmelting(Item.chickenRaw.itemID, new ItemStack(ExtraFoods.chicken), 0.6F);
		GameRegistry.addSmelting(Item.fishRaw.itemID, new ItemStack(ExtraFoods.fish), 0.6F);
		GameRegistry.addSmelting(Item.beefCooked.itemID, new ItemStack(ExtraFoods.beef), 0.7F);
		GameRegistry.addSmelting(Item.porkRaw.itemID, new ItemStack(ExtraFoods.porkchop), 0.7F);
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.pizzaItem, 1), new Object[]
				{
			"DDD", "DCD", "DDD", Character.valueOf('D'), ExtraFoods.dough, Character.valueOf('C'), ExtraFoods.cheese
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.pizzaSlice, 2), new Object[]
				{
			ExtraFoods.pizzaItem
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.oreo, 1), new Object[]
				{
			Item.cookie, ExtraFoods.syrupChocolate, 
				});
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.oreoCakeItem, 1), new Object[]
				{
			"MTM", "SES", "DDD", Character.valueOf('M'), Item.bucketMilk, Character.valueOf('S'), Item.sugar, Character.valueOf('E'), Item.egg, Character.valueOf('D'), ExtraFoods.dough, Character.valueOf('T'), ExtraFoods.oreo
				});
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.netherCakeItem, 1), new Object[]
				{
			"MTM", "SES", "DDD", Character.valueOf('M'), Item.bucketMilk, Character.valueOf('S'), Item.sugar, Character.valueOf('E'), Item.egg, Character.valueOf('D'), ExtraFoods.dough, Character.valueOf('T'), Item.blazePowder
				});
		GameRegistry.addSmelting(ExtraFoods.calimariRaw.itemID, new ItemStack(ExtraFoods.calimariCooked, 1), 0.7F);
		GameRegistry.addSmelting(ExtraFoods.lambchopRaw.itemID, new ItemStack(ExtraFoods.lambchopCooked), 0.7F);
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.meatblockRaw, 1), new Object[]
				{
			"RFR", "BPB", "CSC", Character.valueOf('R'), Item.rottenFlesh, Character.valueOf('F'), Item.fishRaw, Character.valueOf('B'), Item.beefRaw, Character.valueOf('P'), Item.porkRaw, Character.valueOf('C'), Item.chickenRaw, Character.valueOf('S'), ExtraFoods.lambchopRaw
				});
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.meatblockCooked, 1), new Object[]
				{
			"RFR", "BPB", "CSC", Character.valueOf('R'), Item.rottenFlesh, Character.valueOf('F'), ExtraFoods.fish, Character.valueOf('B'), ExtraFoods.beef, Character.valueOf('P'), ExtraFoods.porkchop, Character.valueOf('C'), ExtraFoods.chicken, Character.valueOf('S'), ExtraFoods.lambchopCooked
				});
		GameRegistry.addSmelting(ExtraFoods.meatblockRaw.blockID, new ItemStack(ExtraFoods.meatblockCooked), 0.9F);
		
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.sausage, 3), new Object[]
				{
			"P  ", " P ", "  P", Character.valueOf('P'), ExtraFoods.porkchop
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.pieApple, 1), new Object[]
				{
			Item.sugar, Item.egg, ExtraFoods.dough, Item.appleRed
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.pieBacon, 1), new Object[]
				{
			Item.sugar, Item.egg, ExtraFoods.dough, ExtraFoods.baconRaw
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.pieCheese, 1), new Object[]
				{
			Item.sugar, Item.egg, ExtraFoods.dough, ExtraFoods.cheese
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.pieChicken, 1), new Object[]
				{
			Item.sugar, Item.egg, ExtraFoods.dough, ExtraFoods.chicken
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.pieChocolate, 1), new Object[]
				{
			Item.sugar, Item.egg, ExtraFoods.dough, ExtraFoods.syrupChocolate
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.pieFish, 1), new Object[]
				{
			Item.sugar, Item.egg, ExtraFoods.dough, ExtraFoods.fish
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.pieGoldApple, 1), new Object[]
				{
			Item.sugar, Item.egg, ExtraFoods.dough, new ItemStack(Item.appleGold, 1, 0)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.pumpkinPie, 1), new Object[]
				{
			Item.sugar, Item.egg, ExtraFoods.dough, Block.pumpkin
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.baconRaw, 1), new Object[]
				{
			Item.porkRaw
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.baconCooked, 1), new Object[]
				{
			ExtraFoods.porkchop
				});
		GameRegistry.addSmelting(ExtraFoods.baconRaw.itemID, new ItemStack(ExtraFoods.baconCooked, 1, 0), 0.5F);
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.vanillaExtract, 1), new Object[]
				{
			ExtraFoods.flowerVanilla, Item.glassBottle
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraFoods.cream, 1), new Object[]
				{
			ExtraFoods.vanillaExtract, Item.sugar, Item.sugar
				});
		GameRegistry.addRecipe(new ItemStack(ExtraFoods.cupGlass, 1), new Object[]
				{
			 "M M", "M M", " M ", Character.valueOf('M'), Block.glass
				});
	}
	
}
