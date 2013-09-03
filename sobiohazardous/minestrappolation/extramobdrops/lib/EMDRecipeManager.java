package sobiohazardous.minestrappolation.extramobdrops.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
			"WW", "WW", EMDItemManager.whisker
				});
	}
}
