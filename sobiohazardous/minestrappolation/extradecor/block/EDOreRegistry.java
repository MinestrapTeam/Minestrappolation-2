package sobiohazardous.minestrappolation.extradecor.block;

import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class EDOreRegistry 
{
	public static void oreRegistration()
	{
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlockManager.woodBoards, 1, 0));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlockManager.woodBoards, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlockManager.woodBoards, 1, 2));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlockManager.woodBoards, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlockManager.woodPlanksMossy, 1, 0));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlockManager.woodPlanksMossy, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlockManager.woodPlanksMossy, 1, 2));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlockManager.woodPlanksMossy, 1, 3));
		OreDictionary.registerOre("meatRaw", new ItemStack(Item.beefRaw));
		OreDictionary.registerOre("meatRaw", new ItemStack(Item.porkRaw));
		OreDictionary.registerOre("meatRaw", new ItemStack(Item.fishRaw));
		OreDictionary.registerOre("meatRaw", new ItemStack(Item.chickenRaw));
		OreDictionary.registerOre("meatRaw", new ItemStack(Item.rottenFlesh));
	}
	
	public static void addOreRecipes()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(EDBlockManager.meatBlock, true, new Object[]
				{
				"MMM", "MMM", "MMM", Character.valueOf('M'), "meatRaw"
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(EDBlockManager.crate, true, new Object[]
				{
			"WWW","SSS","WWW", Character.valueOf('S'), Item.stick, Character.valueOf('W'), "plankWood"
				}));
	}

}
