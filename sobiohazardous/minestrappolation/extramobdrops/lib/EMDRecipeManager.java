package sobiohazardous.minestrappolation.extramobdrops.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class EMDRecipeManager 
{
	public static void loadRecipes()
	{
		GameRegistry.addSmelting(EMDItemManager.fat.itemID, new ItemStack(EMDItemManager.grease, 1), 0.7F);
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.friedApple, 2), new Object[]
				{
			EMDItemManager.fat, Item.appleRed,EMDItemManager.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.friedBeef, 2), new Object[]
				{
			EMDItemManager.fat, Item.beefCooked,EMDItemManager.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.friedBread, 2), new Object[]
				{
			EMDItemManager.fat, Item.bread,EMDItemManager.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.friedCarrot, 2), new Object[]
				{
			EMDItemManager.fat, Item.carrot,EMDItemManager.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.friedCookie, 2), new Object[]
				{
			EMDItemManager.fat, Item.cookie,EMDItemManager.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.friedFlesh, 2), new Object[]
				{
			EMDItemManager.fat, Item.rottenFlesh,EMDItemManager.fat
				});
		GameRegistry.addRecipe(new ItemStack(Item.dyePowder, 1, 16), new Object []
				{
			"AA", "AA", Character.valueOf('A'), EMDItemManager.animalBones
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornSwordWood), new Object[]
				{
			EMDItemManager.horn, EMDItemManager.horn, Item.swordWood
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornSwordStone), new Object[]
				{
			EMDItemManager.horn, EMDItemManager.horn, Item.swordStone
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornSwordIron), new Object[]
				{
			EMDItemManager.horn, EMDItemManager.horn, Item.swordIron
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornSwordDiamond), new Object[]
				{
			EMDItemManager.horn, EMDItemManager.horn, Item.swordDiamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornSwordGold), new Object[]
				{
			EMDItemManager.horn, EMDItemManager.horn, Item.swordGold
				});
		GameRegistry.addSmelting(EMDItemManager.chickenWingRaw.itemID, new ItemStack(EMDItemManager.chickenWingCooked, 1), 0.7F);
		GameRegistry.addSmelting(EMDItemManager.lambchopRaw.itemID, new ItemStack(EMDItemManager.lambchopCooked, 1), 0.7F);
		GameRegistry.addSmelting(EMDItemManager.squidTentacle.itemID, new ItemStack(EMDItemManager.calimari, 1), 0.7F);
		GameRegistry.addRecipe(new ItemStack(Item.silk), new Object[]
				{
			"WW", "WW", Character.valueOf('W'), EMDItemManager.whisker
				});
		GameRegistry.addRecipe(new ItemStack(EMDItemManager.charms, 1, 0), new Object[]
				{
			" G ", "GPG", " G ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('P'), EMDItemManager.pigHoof
				});
		GameRegistry.addRecipe(new ItemStack(EMDItemManager.charms, 1, 1), new Object[]
				{
			" G ", "GPG", " G ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('P'), EMDItemManager.cowHoof
				});
		GameRegistry.addRecipe(new ItemStack(EMDItemManager.charms, 1, 2), new Object[]
				{
			" G ", "GPG", " G ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('P'), EMDItemManager.footChicken
				});
		GameRegistry.addRecipe(new ItemStack(EMDItemManager.charms, 1, 3), new Object[]
				{
			" G ", "GPG", " G ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('P'), EMDItemManager.sheepHoof
				});
		GameRegistry.addRecipe(new ItemStack(EMDItemManager.charms, 1, 4), new Object[]
				{
			" G ", "GPG", " G ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('P'), EMDItemManager.horseHoof
				});
		GameRegistry.addSmelting(EMDItemManager.rawHorseHaunch.itemID, new ItemStack(EMDItemManager.cookedHorseHaunch), 0.8F);
		GameRegistry.addRecipe(new ItemStack(EMDItemManager.wingSegment, 1, 0), new Object[]
				{
			"FSF", "SLS", "FSF", Character.valueOf('F'), Item.feather, Character.valueOf('S'), EMDItemManager.wingSinew, Character.valueOf('L'), Item.leather
				});
		GameRegistry.addRecipe(new ItemStack(EMDItemManager.hangGlider, 1, 0), new Object[]
				{
			"PPP", "W W", "W W", Character.valueOf('P'), Block.planks, Character.valueOf('W'), EMDItemManager.wingSegment
				});
	}
	
	public static void loadBridgeRecipes() throws Exception
	{
		if(Loader.isModLoaded("ExtraOres"))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornSandstone), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SandstoneSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornGranite), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.GraniteSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornCopper), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.CopperSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornSteel), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SteelSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornBronze), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BronzeSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornMeurodite), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.meuroditeSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornTorite), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.ToriteSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornBlazium), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BlaziumSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornTitanium), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.TitaniumSword
					});
		}
	}
}
