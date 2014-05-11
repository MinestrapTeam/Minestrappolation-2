package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class EDOreRegistry
{
	public static void registerOres()
	{
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlocks.woodBoards, 1, 0));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlocks.woodBoards, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlocks.woodBoards, 1, 2));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlocks.woodBoards, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlocks.woodPlanksMossy, 1, 0));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlocks.woodPlanksMossy, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlocks.woodPlanksMossy, 1, 2));
		OreDictionary.registerOre("plankWood", new ItemStack(EDBlocks.woodPlanksMossy, 1, 3));
		// raw
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.beef));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.porkchop));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.fish));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.chicken));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.rotten_flesh));
	}
	
	public static void addRecipes()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(EDBlocks.meatBlock, new Object[] { "MMM", "MMM", "MMM", 'M', "meatRaw" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(EDBlocks.crate, new Object[] { "WWW", "SSS", "WWW", 'S', Items.stick, 'W', "plankWood" }));
	}
	
}
