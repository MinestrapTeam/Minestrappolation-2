package minestrapteam.minestrappolation.lib;

import cpw.mods.fml.common.registry.GameRegistry;

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
		
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodOak, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodBirch, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodSpruce, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodJungle, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodAcacia, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodDarkOak, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodDarkOak, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.redwood, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodOak, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodBirch, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodSpruce, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodJungle, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodAcacia, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodDarkOak, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.redwood, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodOak, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodBirch, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodSpruce, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodJungle, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodAcacia, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.woodDarkOak, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.redwood, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.redwoodPlanks, 1, 0));
		
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.woodOak2, 1, 3));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.woodBirch2, 1, 3));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.woodSpruce2, 1, 3));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.woodJungle2, 1, 3));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.woodAcacia2, 1, 3));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.woodDarkOak2, 1, 3));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.redwood2, 1, 3));
		
		OreDictionary.registerOre("plankOak", new ItemStack(Blocks.planks, 1, 0));
		OreDictionary.registerOre("plankBirch", new ItemStack(Blocks.planks, 1, 2));
		OreDictionary.registerOre("plankSpruce", new ItemStack(Blocks.planks, 1, 1));
		OreDictionary.registerOre("plankJungle", new ItemStack(Blocks.planks, 1, 3));
		OreDictionary.registerOre("plankAcacia", new ItemStack(Blocks.planks, 1, 4));
		OreDictionary.registerOre("plankDarkOak", new ItemStack(Blocks.planks, 1, 5));
		OreDictionary.registerOre("plankRedwood", new ItemStack(MBlocks.redwoodPlanks, 1, 0));
		OreDictionary.registerOre("plankOak", new ItemStack(MBlocks.woodOak, 1, 3));
		OreDictionary.registerOre("plankBirch", new ItemStack(MBlocks.woodBirch, 1, 3));
		OreDictionary.registerOre("plankSpruce", new ItemStack(MBlocks.woodSpruce, 1, 3));
		OreDictionary.registerOre("plankJungle", new ItemStack(MBlocks.woodJungle, 1, 3));
		OreDictionary.registerOre("plankAcacia", new ItemStack(MBlocks.woodAcacia, 1, 3));
		OreDictionary.registerOre("plankDarkOak", new ItemStack(MBlocks.woodDarkOak, 1, 3));
		OreDictionary.registerOre("plankRedwood", new ItemStack(MBlocks.redwood, 1, 3));
		OreDictionary.registerOre("plankOak", new ItemStack(MBlocks.woodOak, 1, 1));
		OreDictionary.registerOre("plankBirch", new ItemStack(MBlocks.woodBirch, 1, 1));
		OreDictionary.registerOre("plankSpruce", new ItemStack(MBlocks.woodSpruce, 1, 1));
		OreDictionary.registerOre("plankJungle", new ItemStack(MBlocks.woodJungle, 1, 1));
		OreDictionary.registerOre("plankAcacia", new ItemStack(MBlocks.woodAcacia, 1, 1));
		OreDictionary.registerOre("plankDarkOak", new ItemStack(MBlocks.woodDarkOak, 1, 1));
		OreDictionary.registerOre("plankRedwood", new ItemStack(MBlocks.redwood, 1, 1));
		OreDictionary.registerOre("plankOak", new ItemStack(MBlocks.woodOak, 1, 4));
		OreDictionary.registerOre("plankBirch", new ItemStack(MBlocks.woodBirch, 1, 4));
		OreDictionary.registerOre("plankSpruce", new ItemStack(MBlocks.woodSpruce, 1, 4));
		OreDictionary.registerOre("plankJungle", new ItemStack(MBlocks.woodJungle, 1, 4));
		OreDictionary.registerOre("plankAcacia", new ItemStack(MBlocks.woodAcacia, 1, 4));
		OreDictionary.registerOre("plankDarkOak", new ItemStack(MBlocks.woodDarkOak, 1, 4));
		OreDictionary.registerOre("plankRedwood", new ItemStack(MBlocks.redwood, 1, 4));
		
		OreDictionary.registerOre("sandstone", new ItemStack(Blocks.sandstone));
		OreDictionary.registerOre("sandstone", new ItemStack(MBlocks.sandstone));
		OreDictionary.registerOre("sandstone", new ItemStack(MBlocks.sandstone2));
		OreDictionary.registerOre("sandstone", new ItemStack(MBlocks.redSandstone));
		OreDictionary.registerOre("sandstone", new ItemStack(MBlocks.redSandstone2));
		
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.beef));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.porkchop));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.fish));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.chicken));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.rotten_flesh));
		OreDictionary.registerOre("meatRaw", new ItemStack(MItems.chickenWingRaw));
		OreDictionary.registerOre("meatRaw", new ItemStack(MItems.lambchopRaw));
		OreDictionary.registerOre("meatRaw", new ItemStack(MItems.squidTentacle));
		OreDictionary.registerOre("meatRaw", new ItemStack(MItems.horseHaunchRaw));
		
		OreDictionary.registerOre("glass", new ItemStack(Blocks.glass));
		OreDictionary.registerOre("glass", new ItemStack(MBlocks.refinedGlass));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(MBlocks.meatBlock, new Object[] { "MMM", "MMM", "MMM", 'M', "meatRaw" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBlocks.crate, new Object[] { "WWW", "SSS", "WWW", 'S', Items.stick, 'W', "plankWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBlocks.barrel, new Object[] { "WTW", "W W", "WTW", 'T', "ingotTin", 'W', "plankWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.woodOak, 9, 2), new Object[] { "WWW", "WWW", "WWW", 'W', "plankOak" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.woodBirch, 9, 2), new Object[] { "WWW", "WWW", "WWW", 'W', "plankBirch" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.woodSpruce, 9, 2), new Object[] { "WWW", "WWW", "WWW", 'W', "plankSpruce" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.woodJungle, 9, 2), new Object[] { "WWW", "WWW", "WWW", 'W', "plankJungle" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.woodAcacia, 9, 2), new Object[] { "WWW", "WWW", "WWW", 'W', "plankAcacia" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.woodDarkOak, 9, 2), new Object[] { "WWW", "WWW", "WWW", 'W', "plankDarkOak" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.redwood, 9, 2), new Object[] { "WWW", "WWW", "WWW", 'W', "plankRedwood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.beacon, 1, 0), new Object[] { "GGG", "GNG", "OOO", 'G', "glass", 'N', Items.nether_star, 'O', Blocks.obsidian }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.daylight_detector, 1, 0), new Object[] { "GGG", "QQQ", "SSS", 'G', "glass", 'Q', Items.quartz, 'S', "slabWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.glass_bottle, 3, 0), new Object[] { "G G", " G ", 'G', "glass" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MItems.glassDoor, 1, 0), new Object[] { "GG", "GI", "GG", 'G', "glass", 'I', Items.iron_ingot }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MItems.horseHairBow, 1), new Object[] { " SH", "S H", " SH", 'S', "slabWood", 'H', MItems.horseHairFibre}));
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
