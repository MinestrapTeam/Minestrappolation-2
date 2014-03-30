package sobiohazardous.minestrappolation.extraores.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class EOIngotAndOreRegistration 
{
	public static void registerOresAndIngots()
	{
		add("ingotCopper",EOItemManager.CopperIngot);
		add("oreCopper",EOBlockManager.CopperOre);
		add("ingotTin",EOItemManager.TinIngot);
		add("oreTin",EOBlockManager.TinOre);
		add("plateTin",EOBlockManager.TinPlate);
		add("ingotBronze",EOItemManager.BronzeIngot);
		add("plateBronze",EOBlockManager.BronzePlate);
		add("ingotCoalIron",EOItemManager.CoalIronIngot);
		add("ingotSteel",EOItemManager.SteelIngot);
		add("plateSteel",EOBlockManager.SteelPlate);
		add("oreMeurodite",EOBlockManager.meuroditeOre);
		add("plateMeurodite",EOBlockManager.meuroditePlate);
		add("oreTorite",EOBlockManager.ToriteOre);
		add("ingotTorite",EOItemManager.ToriteIngot);
		add("oreTitanium",EOBlockManager.TitaniumOre);
		add("ingotTitanium",EOItemManager.TitaniumIngot);
		add("oreSunstone",EOBlockManager.SunstoneOre);
		add("dustSunstone",EOItemManager.SunstoneDust);
		add("oreUranium",EOBlockManager.UraniumOre);
		add("ingotUranium",EOItemManager.Uranium);
		add("orePlutonium",EOBlockManager.PlutoniumOre);
		add("ingotPlutonium",EOItemManager.Plutonium);
		add("oreQuartzRadiant",EOBlockManager.RadiantQuartzOre);
		add("gemRadiantQuartz",EOBlockManager.RadiantQuartz);
		add("oreBlazium",EOBlockManager.BlaziumOre);
		add("gemBlazium",EOItemManager.BlazeShard);
		add("ingotBlazium",EOItemManager.BlaziumIngot);
		add("oreSoul",EOBlockManager.SoulOre);
		add("gemSoul",EOBlockManager.SoulGem);
	}
	
	private static void add(String name,Item item)
	{
		OreDictionary.registerOre(name, new ItemStack(item));
	}
	
	private static void add(String name,Block block)
	{
		OreDictionary.registerOre(name, new ItemStack(block));
	}

}
