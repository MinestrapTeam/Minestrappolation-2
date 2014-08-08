package minestrapteam.minestrappolation.lib;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class MOreDictionary
{
	public static void load()
	{
		OreDictionary.registerOre("ingotCopper", MItems.copperIngot);
		OreDictionary.registerOre("oreCopper", MBlocks.copperOre);
		OreDictionary.registerOre("ingotTin", MItems.tinIngot);
		OreDictionary.registerOre("oreTin", MBlocks.tinOre);
		OreDictionary.registerOre("plateTin", MBlocks.tinPlate);
		OreDictionary.registerOre("ingotBronze", MItems.bronzeIngot);
		OreDictionary.registerOre("plateBronze", MBlocks.bronzePlate);
		OreDictionary.registerOre("ingotCoalIron", MItems.coalIronIngot);
		OreDictionary.registerOre("ingotSteel", MItems.steelIngot);
		OreDictionary.registerOre("plateSteel", MBlocks.steelPlate);
		OreDictionary.registerOre("oreMeurodite", MBlocks.meuroditeOre);
		OreDictionary.registerOre("plateMeurodite", MBlocks.meuroditePlate);
		OreDictionary.registerOre("oreTorite", MBlocks.toriteOre);
		OreDictionary.registerOre("ingotTorite", MItems.toriteIngot);
		OreDictionary.registerOre("oreTitanium", MBlocks.titaniumOre);
		OreDictionary.registerOre("ingotTitanium", MItems.titaniumIngot);
		OreDictionary.registerOre("oreSunstone", MBlocks.sunstoneOre);
		OreDictionary.registerOre("dustSunstone", MItems.sunstoneDust);
		OreDictionary.registerOre("oreUranium", MBlocks.uraniumOre);
		OreDictionary.registerOre("ingotUranium", MItems.uranium);
		OreDictionary.registerOre("orePlutonium", MBlocks.plutoniumOre);
		OreDictionary.registerOre("ingotPlutonium", MItems.plutonium);
		OreDictionary.registerOre("oreQuartzRadiant", MBlocks.radiantQuartzOre);
		OreDictionary.registerOre("gemRadiantQuartz", MItems.radiantQuartz);
		OreDictionary.registerOre("oreBlazium", MBlocks.blaziumOre);
		OreDictionary.registerOre("gemBlazium", MItems.blazeShard);
		OreDictionary.registerOre("ingotBlazium", MItems.blaziumIngot);
		OreDictionary.registerOre("oreSoul", MBlocks.soulOre);
		OreDictionary.registerOre("gemSoul", MItems.soulGem);
		
		// Planks
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.redwood, 1, 0));
		
		OreDictionary.registerOre("plankOak", new ItemStack(Blocks.planks, 1, 0));
		OreDictionary.registerOre("plankBirch", new ItemStack(Blocks.planks, 1, 2));
		OreDictionary.registerOre("plankSpruce", new ItemStack(Blocks.planks, 1, 1));
		OreDictionary.registerOre("plankJungle", new ItemStack(Blocks.planks, 1, 3));
		OreDictionary.registerOre("plankAcacia", new ItemStack(Blocks.planks, 1, 4));
		OreDictionary.registerOre("plankDarkOak", new ItemStack(Blocks.planks, 1, 5));
		OreDictionary.registerOre("plankRedwood", new ItemStack(MBlocks.redwood, 1, 0));
		
		// Boards
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.oak, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.birch, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.spruce, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.jungleWood, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.acacia, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.darkOak, 1, 1));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.redwood, 1, 2));
		
		OreDictionary.registerOre("plankOak", new ItemStack(MBlocks.oak, 1, 1));
		OreDictionary.registerOre("plankBirch", new ItemStack(MBlocks.birch, 1, 1));
		OreDictionary.registerOre("plankSpruce", new ItemStack(MBlocks.spruce, 1, 1));
		OreDictionary.registerOre("plankJungle", new ItemStack(MBlocks.jungleWood, 1, 1));
		OreDictionary.registerOre("plankAcacia", new ItemStack(MBlocks.acacia, 1, 1));
		OreDictionary.registerOre("plankDarkOak", new ItemStack(MBlocks.darkOak, 1, 1));
		OreDictionary.registerOre("plankRedwood", new ItemStack(MBlocks.redwood, 1, 2));
		
		// Mossy Planks
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.oak, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.birch, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.spruce, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.jungleWood, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.acacia, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.darkOak, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.darkOak, 1, 3));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.redwood, 1, 4));
		
		OreDictionary.registerOre("plankOak", new ItemStack(MBlocks.oak, 1, 3));
		OreDictionary.registerOre("plankBirch", new ItemStack(MBlocks.birch, 1, 3));
		OreDictionary.registerOre("plankSpruce", new ItemStack(MBlocks.spruce, 1, 3));
		OreDictionary.registerOre("plankJungle", new ItemStack(MBlocks.jungleWood, 1, 3));
		OreDictionary.registerOre("plankAcacia", new ItemStack(MBlocks.acacia, 1, 3));
		OreDictionary.registerOre("plankDarkOak", new ItemStack(MBlocks.darkOak, 1, 3));
		OreDictionary.registerOre("plankRedwood", new ItemStack(MBlocks.redwood, 1, 4));
		
		// Mossy Boards
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.oak, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.birch, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.spruce, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.jungleWood, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.acacia, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.darkOak, 1, 4));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.redwood, 1, 5));
		
		OreDictionary.registerOre("plankOak", new ItemStack(MBlocks.oak, 1, 4));
		OreDictionary.registerOre("plankBirch", new ItemStack(MBlocks.birch, 1, 4));
		OreDictionary.registerOre("plankSpruce", new ItemStack(MBlocks.spruce, 1, 4));
		OreDictionary.registerOre("plankJungle", new ItemStack(MBlocks.jungleWood, 1, 4));
		OreDictionary.registerOre("plankAcacia", new ItemStack(MBlocks.acacia, 1, 4));
		OreDictionary.registerOre("plankDarkOak", new ItemStack(MBlocks.darkOak, 1, 4));
		OreDictionary.registerOre("plankRedwood", new ItemStack(MBlocks.redwood, 1, 5));
		
		// Planks Slabs
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.redwood2, 1, 0));
		
		// Boards Slabs
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.oak2, 1, 0));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.birch2, 1, 0));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.spruce2, 1, 0));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.jungleWood2, 1, 0));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.acacia2, 1, 0));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.darkOak2, 1, 0));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.redwood2, 1, 1));
		
		OreDictionary.registerOre("sandstone", MBlocks.sandstone);
		OreDictionary.registerOre("sandstone", MBlocks.redSandstone);
		
		OreDictionary.registerOre("meatRaw", Items.beef);
		OreDictionary.registerOre("meatRaw", Items.porkchop);
		OreDictionary.registerOre("meatRaw", Items.fish);
		OreDictionary.registerOre("meatRaw", Items.chicken);
		OreDictionary.registerOre("meatRaw", Items.rotten_flesh);
		OreDictionary.registerOre("meatRaw", MItems.chickenWingRaw);
		OreDictionary.registerOre("meatRaw", MItems.lambchopRaw);
		OreDictionary.registerOre("meatRaw", MItems.squidTentacle);
		OreDictionary.registerOre("meatRaw", MItems.horseHaunchRaw);
		
		OreDictionary.registerOre("blockGlass", MBlocks.refinedGlass);
		OreDictionary.registerOre("blockGlassColorless", MBlocks.refinedGlass);
		OreDictionary.registerOre("paneGlass", MBlocks.refinedGlassPane);
		OreDictionary.registerOre("paneGlassColorless", MBlocks.refinedGlassPane);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(MBlocks.meatBlock, new Object[] { "MMM", "MMM", "MMM", 'M', "meatRaw" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBlocks.crate, new Object[] { "WWW", "SSS", "WWW", 'S', Items.stick, 'W', "plankWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBlocks.barrel, new Object[] { "WTW", "W W", "WTW", 'T', "ingotTin", 'W', "plankWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(MItems.glassDoorItem, new Object[] { "GG", "GI", "GG", 'G', "glass", 'I', Items.iron_ingot }));
		GameRegistry.addRecipe(new ShapedOreRecipe(MItems.horseHairBow, new Object[] { " SH", "S H", " SH", 'S', "slabWood", 'H', MItems.horseHairFibre }));
	}
}
