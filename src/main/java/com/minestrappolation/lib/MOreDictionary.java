package com.minestrappolation.lib;

import cpw.mods.fml.common.registry.GameRegistry;

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
		add("ingotCopper", MItems.CopperIngot);
		add("oreCopper", MBlocks.copperOre);
		add("ingotTin", MItems.TinIngot);
		add("oreTin", MBlocks.tinOre);
		add("plateTin", MBlocks.tinPlate);
		add("ingotBronze", MItems.BronzeIngot);
		add("plateBronze", MBlocks.bronzePlate);
		add("ingotCoalIron", MItems.CoalIronIngot);
		add("ingotSteel", MItems.SteelIngot);
		add("plateSteel", MBlocks.steelPlate);
		add("oreMeurodite", MBlocks.meuroditeOre);
		add("plateMeurodite", MBlocks.meuroditePlate);
		add("oreTorite", MBlocks.toriteOre);
		add("ingotTorite", MItems.ToriteIngot);
		add("oreTitanium", MBlocks.titaniumOre);
		add("ingotTitanium", MItems.TitaniumIngot);
		add("oreSunstone", MBlocks.sunstoneOre);
		add("dustSunstone", MItems.SunstoneDust);
		add("oreUranium", MBlocks.uraniumOre);
		add("ingotUranium", MItems.Uranium);
		add("orePlutonium", MBlocks.plutoniumOre);
		add("ingotPlutonium", MItems.Plutonium);
		add("oreQuartzRadiant", MBlocks.radiantQuartzOre);
		add("gemRadiantQuartz", MItems.radiantQuartz);
		add("oreBlazium", MBlocks.blaziumOre);
		add("gemBlazium", MItems.BlazeShard);
		add("ingotBlazium", MItems.BlaziumIngot);
		add("oreSoul", MBlocks.soulOre);
		add("gemSoul", MItems.soulGem);
		
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodBoards, 1, 0));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodBoards, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodBoards, 1, 2));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodBoards, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodPlanksMossy, 1, 0));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodPlanksMossy, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodPlanksMossy, 1, 2));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodPlanksMossy, 1, 3));
		// raw
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.beef));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.porkchop));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.fish));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.chicken));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.rotten_flesh));
	}
	
	public static void addRecipes()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(MBlocks.meatBlock, new Object[] { "MMM", "MMM", "MMM", 'M', "meatRaw" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBlocks.crate, new Object[] { "WWW", "SSS", "WWW", 'S', Items.stick, 'W', "plankWood" }));
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
