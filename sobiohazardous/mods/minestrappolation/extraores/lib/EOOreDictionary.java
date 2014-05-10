package sobiohazardous.mods.minestrappolation.extraores.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class EOOreDictionary
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
