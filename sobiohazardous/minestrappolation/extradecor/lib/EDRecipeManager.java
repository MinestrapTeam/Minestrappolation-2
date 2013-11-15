package sobiohazardous.minestrappolation.extradecor.lib;

import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class EDRecipeManager 
{

	public static void loadAllRecipes()
	{
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.infertileDirt, 8), new Object[]
				{
			"DDD","DBD", "DDD", Character.valueOf('D'), Block.dirt,Character.valueOf('B'), Item.bucketEmpty.setContainerItem(Item.bucketWater)
				});
		
		GameRegistry.addRecipe(new ItemStack(Block.dirt, 8), new Object[]
				{
			"DDD","DBD", "DDD", Character.valueOf('D'), EDBlockManager.infertileDirt,Character.valueOf('B'), Item.bucketWater.setContainerItem(Item.bucketEmpty)
				});
		
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stones,9, 1), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), Block.stone
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stonePillar, 2), new Object[]
				{
			"S", "S", Character.valueOf('S'), new ItemStack(EDBlockManager.stones,1,1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stones,4, 0), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(EDBlockManager.stones,1,1)
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.edgeStoneBrick, 1), new Object[]
				{
			"SG", "SG", Character.valueOf('S'), new ItemStack(EDItemManager.stoneBrickItem, 1,1), Character.valueOf('G'), new ItemStack(Item.netherQuartz, 1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.Tiles, 2,4), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), Item.brick
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.Tiles, 4,0), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), Block.obsidian
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.snowBrick, 4), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), Block.blockSnow
				});
		GameRegistry.addSmelting(Block.whiteStone.blockID, new ItemStack(EDBlockManager.endstone, 1,1), 20);
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.endstone, 9,2), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlockManager.endstone,1,1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.endstone, 4,0), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(EDBlockManager.endstone,1,1)
				});
		GameRegistry.addSmelting(Block.glass.blockID, new ItemStack(EDBlockManager.glassRefined), 20);
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.glassRefinedPane, 16), new Object[]
				{
			"SSS", "SSS", Character.valueOf('S'), EDBlockManager.glassRefined
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.Tiles, 2,5), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), Item.flint
				});
		GameRegistry.addRecipe(new ItemStack(Item.flint, 2), new Object[]
				{
			"S", Character.valueOf('S'), new ItemStack(EDBlockManager.Tiles,1,5)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.gunpowderBlock, 1), new Object[]
				{
			"SSS", "SSS","SSS", Character.valueOf('S'), Item.gunpowder
				});
		GameRegistry.addRecipe(new ItemStack(Item.gunpowder, 9), new Object[]
				{
			"S", Character.valueOf('S'), EDBlockManager.gunpowderBlock
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.itemRope, 1), new Object[]
				{
			"S", "S", "S", Character.valueOf('S'), Item.silk
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.ropeCoil, 1), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), EDBlockManager.itemRope
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.itemRope, 9), new Object[]
				{
			"S", Character.valueOf('S'), EDBlockManager.ropeCoil
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.oozeSlime, 1), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), Item.slimeBall
				});
		GameRegistry.addRecipe(new ItemStack(Item.slimeBall, 9), new Object[]
				{
			"S", Character.valueOf('S'), EDBlockManager.oozeSlime
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodPanel, 9, 0), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Block.planks, 1, 0)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodPanel, 9, 0), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlockManager.woodBoards, 1, 0)
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodPanel, 9, 1), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Block.planks, 1, 2)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodPanel, 9, 1), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlockManager.woodBoards, 1, 1)
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodPanel, 9,2), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Block.planks, 1, 1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodPanel, 9,2), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlockManager.woodBoards, 1, 2)
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodPanel, 9,3), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Block.planks, 1, 3)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodPanel, 9,3), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlockManager.woodBoards, 1, 3)
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBeveled, 4, 0), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(EDBlockManager.woodPanel, 1 , 0)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBeveled, 4, 1), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(EDBlockManager.woodPanel, 1 , 1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBeveled, 4, 2), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(EDBlockManager.woodPanel, 1 , 2)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBeveled, 4, 3), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(EDBlockManager.woodPanel, 1 , 3)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stoneLamp, 8, 0), new Object[]
				{
			"SSS", "SGS", "SSS", Character.valueOf('S'), new ItemStack(EDBlockManager.stones,1), Character.valueOf('G'), Block.glowStone
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.Tiles, 9,6), new Object[]
				{
			"SSS", "SSS", "SSS", Character.valueOf('S'), Item.netherrackBrick
				});
		
		//TODO add sandstone brick recipes
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.sandstonePillar, 2), new Object[]
				{
			"S", "S", Character.valueOf('S'), Block.sandStone
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoards, 16, 0), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(Block.wood, 1 , 0)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoards, 16, 1), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(Block.wood, 1 , 2)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoards, 16, 2), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(Block.wood, 1 , 1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoards, 16, 3), new Object[]
				{
			"SS", "SS", Character.valueOf('S'), new ItemStack(Block.wood, 1 , 3)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.Tiles, 4,1), new Object[]
				{
			"FF", "FF", Character.valueOf('F'), new ItemStack(EDBlockManager.Tiles,1,5)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.Tiles, 4,2), new Object[]
				{
			"FF", "FF", Character.valueOf('F'), Block.blockNetherQuartz
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.sugarBlock), new Object[]
				{
			"SSS","SSS","SSS", Character.valueOf('S'), Item.sugar
				});
		GameRegistry.addRecipe(new ItemStack(Item.sugar, 9), new Object[]
				{
			"S", Character.valueOf('S'), EDBlockManager.sugarBlock
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.magmaOoze), new Object[]
				{
			"SSS","SSS","SSS", Character.valueOf('S'), Item.magmaCream
				});
		GameRegistry.addRecipe(new ItemStack(Item.magmaCream, 9), new Object[]
				{
			"S", Character.valueOf('S'), EDBlockManager.magmaOoze
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.enderBlock), new Object[]
				{
			"SSS","SSS","SSS", Character.valueOf('S'), Item.enderPearl
				});
		GameRegistry.addRecipe(new ItemStack(Item.enderPearl, 9), new Object[]
				{
			"S", Character.valueOf('S'), EDBlockManager.enderBlock
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.barrel), new Object[]
				{
			"I", "C", "I", Character.valueOf('I'), Item.ingotIron, Character.valueOf('C'), EDBlockManager.crate
				});
		GameRegistry.addRecipe(new ItemStack(EDItemManager.cardboardItem, 3), new Object[]
				{
			"SSS", "SSS", Character.valueOf('S'), Item.paper
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.cardboardBlock, 2), new Object[]
				{
			"CCC", " C ", " CC", Character.valueOf('C'), EDItemManager.cardboardItem
				});
		GameRegistry.addSmelting(Block.sandStone.blockID, new ItemStack(EDItemManager.sandstoneBrickItem, 4),  0.8F);
		GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 2, 3), new Object[]
				{
			"BBB", "BBB", "BBB", Character.valueOf('B'), EDItemManager.stoneBrickItem
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.sandstoneBricks, 1, 0), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), EDItemManager.sandstoneBrickItem
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.sandstoneBricks, 2, 1), new Object[]
				{
			"BBB", "BBB", "BBB", Character.valueOf('B'), EDItemManager.sandstoneBrickItem
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.Tiles, 4,3), new Object[]
				{
			"FQ", "QF", Character.valueOf('F'), new ItemStack(EDBlockManager.Tiles,1,2), Character.valueOf('Q'), new ItemStack(EDBlockManager.Tiles,1,2)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoardsSingleSlab, 6, 0), new Object[]
				{
			"FFF", Character.valueOf('F'), new ItemStack(EDBlockManager.woodBoards, 1, 0)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoardsSingleSlab, 6, 1), new Object[]
				{
			"FFF", Character.valueOf('F'), new ItemStack(EDBlockManager.woodBoards, 1, 1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoardsSingleSlab, 6, 2), new Object[]
				{
			"FFF", Character.valueOf('F'), new ItemStack(EDBlockManager.woodBoards, 1, 2)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoardsSingleSlab, 6, 3), new Object[]
				{
			"FFF", Character.valueOf('F'), new ItemStack(EDBlockManager.woodBoards, 1, 3)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoardsStairsOak, 4), new Object[]
				{
			"  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlockManager.woodBoards, 1, 0)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoardsStairsBirch, 4), new Object[]
				{
			"  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlockManager.woodBoards, 1, 1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoardsStairsSpruce, 4), new Object[]
				{
			"  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlockManager.woodBoards, 1, 2)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.woodBoardsStairsJungle, 4), new Object[]
				{
			"  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlockManager.woodBoards, 1, 3)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.enderPearl, 9), new Object[]
				{
			EDBlockManager.enderBlock
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.checkerTileStairs, 4), new Object[]
				{
			"  T",  " TT", "TTT", Character.valueOf('T'), new ItemStack(EDBlockManager.Tiles,1,3)
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 0), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 15)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 1), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 7)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 2), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 8)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 3), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 0)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 4), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 3)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 5), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 9)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 6), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 7), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 14)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 8), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 11)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 9), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 10)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 10), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 2)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 11), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 6)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 12), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 12)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 13), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 4)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 14), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 5)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 8, 15), new Object[]
				{
			"BBB", "BDB", "BBB", Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 13)
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 0), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 0)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 1), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 8)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 2), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 7)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 3), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 15)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 4), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 12)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 5), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 6)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 6), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 14)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 7), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 1)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 8), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 4)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 9), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 5)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 10), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 13)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 11), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 9)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 12), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 3)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 13), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 11)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 14), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 10)
				});
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.stainedBrick, 4, 15), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), new ItemStack(Block.hardenedClay, 1, 2)
				});	
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.cobbledRoad, 2), new Object[]
				{
			"CC", "DD", Character.valueOf('C'), Block.cobblestone, Character.valueOf('D'), Block.dirt
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.sandstoneRoad, 2), new Object[]
				{
			"CCC","CCC", "DDD", Character.valueOf('C'), EDItemManager.sandstoneBrickItem, Character.valueOf('D'), Block.sand
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.sandyRoad, 2), new Object[]
				{
			"CC", "DD", Character.valueOf('C'), Block.cobblestone, Character.valueOf('D'), Block.sand
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.gravelRoad, 2), new Object[]
				{
			"CC", "DD", Character.valueOf('C'), Block.cobblestone, Character.valueOf('D'), Block.gravel
				});
		
		GameRegistry.addRecipe(new ItemStack(EDBlockManager.refinedRoad, 1), new Object[]
				{
			"CCC", "CCC", "DDD", Character.valueOf('C'), new ItemStack(EDItemManager.stoneBrickItem, 1, 0), Character.valueOf('D'), Block.dirt
				});
		
		GameRegistry.addRecipe(new ItemStack(EDItemManager.stoneBrickItem, 16), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), Block.stone
				});

		
	}
	
	public static void removeRecipes()
	{
		MUtil.removeRecipe(new ItemStack(Block.stoneBrick, 4, 0));
		
		//It must be added after the recipe is removed.
		GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 1), new Object[]
				{
			"BB", "BB", Character.valueOf('B'), EDItemManager.stoneBrickItem
				});
	}
}
