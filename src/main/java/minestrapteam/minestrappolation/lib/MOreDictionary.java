package minestrapteam.minestrappolation.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.mcore.lib.MCBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class MOreDictionary
{
	public static void load()
	{
		add("ingotCopper", MItems.copperIngot);
		add("oreCopper", MBlocks.copperOre);
		add("ingotTin", MItems.tinIngot);
		add("oreTin", MBlocks.tinOre);
		add("plateTin", MBlocks.tinPlate);
		add("ingotBronze", MItems.bronzeIngot);
		add("plateBronze", MBlocks.bronzePlate);
		add("ingotCoalIron", MItems.coalIronIngot);
		add("ingotSteel", MItems.steelIngot);
		add("plateSteel", MBlocks.steelPlate);
		add("oreMeurodite", MBlocks.meuroditeOre);
		add("plateMeurodite", MBlocks.meuroditePlate);
		add("oreTorite", MBlocks.toriteOre);
		add("ingotTorite", MItems.toriteIngot);
		add("oreTitanium", MBlocks.titaniumOre);
		add("ingotTitanium", MItems.titaniumIngot);
		add("oreSunstone", MBlocks.sunstoneOre);
		add("dustSunstone", MItems.sunstoneDust);
		add("oreUranium", MBlocks.uraniumOre);
		add("ingotUranium", MItems.uranium);
		add("orePlutonium", MBlocks.plutoniumOre);
		add("ingotPlutonium", MItems.plutonium);
		add("oreQuartzRadiant", MBlocks.radiantQuartzOre);
		add("gemRadiantQuartz", MItems.radiantQuartz);
		add("oreBlazium", MBlocks.blaziumOre);
		add("gemBlazium", MItems.blazeShard);
		add("ingotBlazium", MItems.blaziumIngot);
		add("oreSoul", MBlocks.soulOre);
		add("gemSoul", MItems.soulGem);
		
		OreDictionary.registerOre("sandstone", new ItemStack(Blocks.sandstone));
		OreDictionary.registerOre("sandstone", new ItemStack(MCBlocks.sandstone));
		OreDictionary.registerOre("sandstone", new ItemStack(MCBlocks.sandstone2));
		OreDictionary.registerOre("sandstone", new ItemStack(MCBlocks.redSandstone));
		OreDictionary.registerOre("sandstone", new ItemStack(MCBlocks.redSandstone2));
		
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.beef));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.porkchop));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.fish));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.chicken));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.rotten_flesh));
		
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
