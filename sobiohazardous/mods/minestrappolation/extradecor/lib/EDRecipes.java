package sobiohazardous.mods.minestrappolation.extradecor.lib;

import sobiohazardous.mods.minestrappolation.core.util.MUtil;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EDRecipes
{
	
	public static void loadAllRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(EDItems.goblet, 1), new Object[] { "D D", " D ", Character.valueOf('D'), Items.gold_ingot });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.infertileDirt, 8), new Object[] { "DDD", "DBD", "DDD", Character.valueOf('D'), Blocks.dirt, Character.valueOf('B'), Items.bucket.setContainerItem(Items.water_bucket) });
		
		GameRegistry.addRecipe(new ItemStack(Blocks.dirt, 8), new Object[] { "DDD", "DBD", "DDD", Character.valueOf('D'), EDBlocks.infertileDirt, Character.valueOf('B'), Items.water_bucket.setContainerItem(Items.bucket) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stones, 9, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Blocks.stone });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stonePillar, 2), new Object[] { "S", "S", Character.valueOf('S'), new ItemStack(EDBlocks.stones, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stones, 4), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.stones, 1, 1) });
		
		// GameRegistry.addRecipe(new ItemStack(EDBlocks.edgeStoneBrick), new Object[] { "SQ", "SQ", 'S', MItems.brickStone, 'Q', Items.quartz });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 2, 4), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.brick });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 4, 0), new Object[] { "SS", "SS", Character.valueOf('S'), Blocks.obsidian });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.snowBrick, 4), new Object[] { "SS", "SS", Character.valueOf('S'), Blocks.snow });
		GameRegistry.addSmelting(Blocks.end_stone, new ItemStack(EDBlocks.endstone, 1, 1), 20);
		GameRegistry.addRecipe(new ItemStack(EDBlocks.endstone, 9, 2), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.endstone, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.endstone, 4, 0), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.endstone, 1, 1) });
		GameRegistry.addSmelting(Blocks.glass, new ItemStack(EDBlocks.glassRefined), 20);
		GameRegistry.addRecipe(new ItemStack(EDBlocks.glassRefinedPane, 16), new Object[] { "SSS", "SSS", Character.valueOf('S'), EDBlocks.glassRefined });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 2, 5), new Object[] { "SS", "SS", Character.valueOf('S'), Items.flint });
		GameRegistry.addRecipe(new ItemStack(Items.flint, 2), new Object[] { "S", Character.valueOf('S'), new ItemStack(EDBlocks.Tiles, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.gunpowderBlock, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.gunpowderBlock });
		GameRegistry.addRecipe(new ItemStack(EDItems.ropeItem, 1), new Object[] { "S", "S", "S", Character.valueOf('S'), Items.string });
		GameRegistry.addRecipe(new ItemStack(EDItems.ropeItem, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.ropeCoil });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.ropeCoil, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), EDItems.ropeItem });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.oozeSlime, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.slime_ball });
		GameRegistry.addRecipe(new ItemStack(Items.slime_ball, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.oozeSlime });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 0), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 0), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.woodBoards, 1, 0) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.woodBoards, 1, 1) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 2), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 2), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.woodBoards, 1, 2) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 3), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 3), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.woodBoards, 1, 3) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBeveled, 4, 0), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.woodPanel, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBeveled, 4, 1), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.woodPanel, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBeveled, 4, 2), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.woodPanel, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBeveled, 4, 3), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.woodPanel, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stoneLamp, 8, 0), new Object[] { "SSS", "SGS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.stones, 1, 1), Character.valueOf('G'), Blocks.glowstone });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 2, 6), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.netherbrick });
		
		// TODO add sandstone brick recipes
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandstonePillar, 2), new Object[] { "S", "S", Character.valueOf('S'), Blocks.sandstone });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoards, 16, 0), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoards, 16, 1), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoards, 16, 2), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoards, 16, 3), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 4, 1), new Object[] { "FF", "FF", Character.valueOf('F'), new ItemStack(EDBlocks.Tiles, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 4, 2), new Object[] { "FF", "FF", Character.valueOf('F'), Blocks.quartz_block });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sugarBlock), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.sugar });
		GameRegistry.addRecipe(new ItemStack(Items.sugar, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.sugarBlock });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.magmaOoze), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.magma_cream });
		GameRegistry.addRecipe(new ItemStack(Items.magma_cream, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.magmaOoze });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.enderBlock), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.ender_pearl });
		GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.enderBlock });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.barrel), new Object[] { "I", "C", "I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('C'), EDBlocks.crate });
		GameRegistry.addRecipe(new ItemStack(EDItems.cardboardItem, 3), new Object[] { "SSS", "SSS", Character.valueOf('S'), Items.paper });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.cardboardBlock, 2), new Object[] { "CCC", " C ", " CC", Character.valueOf('C'), EDItems.cardboardItem });
		GameRegistry.addSmelting(Blocks.sandstone, new ItemStack(EDItems.sandstoneBrick, 4), 0.8F);
		/*
		 * GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 2, 3), new
		 * Object[] { "BBB", "BBB", "BBB", Character.valueOf('B'),
		 * EDItems.stoneBrickItem });
		 */
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandstoneBricks, 1, 0), new Object[] { "BB", "BB", Character.valueOf('B'), EDItems.sandstoneBrick });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandstoneBricks, 2, 1), new Object[] { "BBB", "BBB", "BBB", Character.valueOf('B'), EDItems.sandstoneBrick });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 4, 3), new Object[] { "FQ", "QF", Character.valueOf('F'), new ItemStack(EDBlocks.Tiles, 1, 1), Character.valueOf('Q'), new ItemStack(EDBlocks.Tiles, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsSingleSlab, 6, 0), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsSingleSlab, 6, 1), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsSingleSlab, 6, 2), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsSingleSlab, 6, 3), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsStairsOak, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsStairsBirch, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsStairsSpruce, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsStairsJungle, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 3) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] { EDBlocks.enderBlock });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.checkerTileStairs, 4), new Object[] { "  T", " TT", "TTT", Character.valueOf('T'), new ItemStack(EDBlocks.Tiles, 1, 3) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 0), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 1), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 2), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 3), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 4), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 5), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 6), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 7), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 8), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 9), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 10) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 10), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 11), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 12), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 13), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 14), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 15), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 13) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 0), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 1), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 2), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 3), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 4), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 5), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 6), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 7), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 8), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 9), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 10), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 13) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 11), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 12), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 13), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 14), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 10) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 15), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 2) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.cobbledRoad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('D'), Blocks.dirt });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandstoneRoad, 2), new Object[] { "CCC", "CCC", "DDD", Character.valueOf('C'), EDItems.sandstoneBrick, Character.valueOf('D'), Blocks.sand });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandyRoad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('D'), Blocks.sand });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.gravelRoad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('D'), Blocks.gravel });
		/*
		 * GameRegistry.addRecipe(new ItemStack(EDBlocks.refinedRoad, 1), new
		 * Object[] { "CCC", "CCC", "DDD", Character.valueOf('C'), new
		 * ItemStack(EDItems.stoneBrickItem, 1, 0), Character.valueOf('D'),
		 * Blocks.dirt });
		 */
		GameRegistry.addRecipe(new ItemStack(EDBlocks.netherroad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.netherrack, Character.valueOf('D'), Blocks.soul_sand });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.refinedNetherroad, 1), new Object[] { "CCC", "CCC", "DDD", Character.valueOf('C'), new ItemStack(Items.netherbrick, 1, 0), Character.valueOf('D'), Blocks.soul_sand });
	}
	
	public static void removeRecipes()
	{
		MUtil.removeRecipe(new ItemStack(Blocks.stonebrick, 4, 0));
	}
}
