package sobiohazardous.mods.minestrappolation.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class MOreDictionary
{
	public static void init()
	{
		add("ingotCopper", EOItems.CopperIngot);
		add("oreCopper", EOBlocks.CopperOre);
		add("ingotTin", EOItems.TinIngot);
		add("oreTin", EOBlocks.TinOre);
		add("plateTin", EOBlocks.TinPlate);
		add("ingotBronze", EOItems.BronzeIngot);
		add("plateBronze", EOBlocks.BronzePlate);
		add("ingotCoalIron", EOItems.CoalIronIngot);
		add("ingotSteel", EOItems.SteelIngot);
		add("plateSteel", EOBlocks.SteelPlate);
		add("oreMeurodite", EOBlocks.meuroditeOre);
		add("plateMeurodite", EOBlocks.meuroditePlate);
		add("oreTorite", EOBlocks.ToriteOre);
		add("ingotTorite", EOItems.ToriteIngot);
		add("oreTitanium", EOBlocks.TitaniumOre);
		add("ingotTitanium", EOItems.TitaniumIngot);
		add("oreSunstone", EOBlocks.SunstoneOre);
		add("dustSunstone", EOItems.SunstoneDust);
		add("oreUranium", EOBlocks.UraniumOre);
		add("ingotUranium", EOItems.Uranium);
		add("orePlutonium", EOBlocks.PlutoniumOre);
		add("ingotPlutonium", EOItems.Plutonium);
		add("oreQuartzRadiant", EOBlocks.RadiantQuartzOre);
		add("gemRadiantQuartz", EOBlocks.RadiantQuartz);
		add("oreBlazium", EOBlocks.BlaziumOre);
		add("gemBlazium", EOItems.BlazeShard);
		add("ingotBlazium", EOItems.BlaziumIngot);
		add("oreSoul", EOBlocks.SoulOre);
		add("gemSoul", EOBlocks.SoulGem);
		
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
	
	private static void add(String name, Item item)
	{
		OreDictionary.registerOre(name, new ItemStack(item));
	}
	
	private static void add(String name, Block block)
	{
		OreDictionary.registerOre(name, new ItemStack(block));
	}
	
}
