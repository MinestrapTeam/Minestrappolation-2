package sobiohazardous.minestrappolation.extrafoods.lib;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry 
{

	public static void registerBlocks()
	{
    	GameRegistry.registerBlock(ExtraFoods.microwaveIdle, "microwave");
    	GameRegistry.registerBlock(ExtraFoods.microwaveOn, "microwaveOn");
    	GameRegistry.registerBlock(ExtraFoods.freezer, "freezer");
    	GameRegistry.registerBlock(ExtraFoods.fridge, "fridge");
    	GameRegistry.registerBlock(ExtraFoods.oreAluminum, "oreAluminum");
    	GameRegistry.registerBlock(ExtraFoods.oreSalt, "oreSalt");	
    	GameRegistry.registerBlock(ExtraFoods.cakeCheese, "cakeCheese");	
    	GameRegistry.registerBlock(ExtraFoods.cakeChocolate, "cakeChocolate");
    	GameRegistry.registerBlock(ExtraFoods.cakeGold, "cakeGold");
    	GameRegistry.registerBlock(ExtraFoods.cakeExplosive, "cakeExplosive");
    	GameRegistry.registerBlock(ExtraFoods.pepperCrop, "pepperCrop");
    	GameRegistry.registerBlock(ExtraFoods.cornCrop, "cornCrop");
    	GameRegistry.registerBlock(ExtraFoods.riceCrop, "riceCrop");
    	GameRegistry.registerBlock(ExtraFoods.pizza, "pizza");
    	GameRegistry.registerBlock(ExtraFoods.oreoCake, "oreoCake");
    	GameRegistry.registerBlock(ExtraFoods.netherCake, "netherCake");
    	GameRegistry.registerBlock(ExtraFoods.meatblockRaw, "meatblockRaw");
    	GameRegistry.registerBlock(ExtraFoods.meatblockCooked, "meatblockCooked");
    	GameRegistry.registerBlock(ExtraFoods.flowerVanilla, "flowerVanilla");
	}
	
}
