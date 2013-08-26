package sobiohazardous.minestrappolation.extramobdrops.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sobiohazardous.minestrappolation.extramobdrops.ExtraMobDrops;
import cpw.mods.fml.common.registry.GameRegistry;

public class EMDRecipeManager 
{
	public static void loadRecipes()
	{
		GameRegistry.addSmelting(ExtraMobDrops.fat.itemID, new ItemStack(ExtraMobDrops.grease, 1), 0.7F);
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.friedApple, 2), new Object[]
				{
			ExtraMobDrops.fat, Item.appleRed,ExtraMobDrops.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.friedBeef, 2), new Object[]
				{
			ExtraMobDrops.fat, Item.beefCooked,ExtraMobDrops.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.friedBread, 2), new Object[]
				{
			ExtraMobDrops.fat, Item.bread,ExtraMobDrops.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.friedCarrot, 2), new Object[]
				{
			ExtraMobDrops.fat, Item.carrot,ExtraMobDrops.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.friedCookie, 2), new Object[]
				{
			ExtraMobDrops.fat, Item.cookie,ExtraMobDrops.fat
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.friedFlesh, 2), new Object[]
				{
			ExtraMobDrops.fat, Item.rottenFlesh,ExtraMobDrops.fat
				});
		GameRegistry.addRecipe(new ItemStack(Item.dyePowder, 1, 16), new Object []
				{
			"AA", "AA", Character.valueOf('A'), ExtraMobDrops.animalBones
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornSwordWood), new Object[]
				{
			ExtraMobDrops.horn, ExtraMobDrops.horn, Item.swordWood
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornSwordStone), new Object[]
				{
			ExtraMobDrops.horn, ExtraMobDrops.horn, Item.swordStone
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornSwordIron), new Object[]
				{
			ExtraMobDrops.horn, ExtraMobDrops.horn, Item.swordIron
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornSwordDiamond), new Object[]
				{
			ExtraMobDrops.horn, ExtraMobDrops.horn, Item.swordDiamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornSwordGold), new Object[]
				{
			ExtraMobDrops.horn, ExtraMobDrops.horn, Item.swordGold
				});
	}
}
