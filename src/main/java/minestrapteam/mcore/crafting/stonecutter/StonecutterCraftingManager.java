package minestrapteam.mcore.crafting.stonecutter;

import static minestrapteam.minestrappolation.lib.MBlocks.edgeStoneBrick;

import java.util.*;

import minestrapteam.mcore.lib.MCBlocks;
import minestrapteam.mcore.lib.MCItems;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StonecutterCraftingManager
{
	/** The static instance of this class */
	public static final StonecutterCraftingManager	instance	= new StonecutterCraftingManager();
	
	/** A list of all the recipes added */
	private List<ISCRecipe>							recipes		= new ArrayList();
	private boolean									listSorted;
	
	private StonecutterCraftingManager()
	{
		// Stone Decor
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 0), null, new Object[] { "SSS", 'S', Blocks.stone });
		this.addRecipe(new ItemStack(MCItems.brickStone, 4, 0), null, new Object[] { "S", 'S', Blocks.stone });
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 0), null, new Object[] { "BB", "BB", 'B', MCItems.brickStone });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stonebrick, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.stone_brick_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', new ItemStack(Blocks.stonebrick, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickStone });
		this.addRecipe(new ItemStack(MCBlocks.stone, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickStone, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stone, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.stone });
		this.addRecipe(new ItemStack(MCBlocks.stone2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.stone, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stone, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.stone, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stone2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.stone, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.stone2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.stone, 1, 5) });
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.stone2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.stone, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(Blocks.stonebrick, 1, 3), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MCBlocks.stone, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(Blocks.stonebrick, 1, 3), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 3), null, new Object[] { "SSS", 'S', Blocks.cobblestone });
		this.addRecipe(new ItemStack(Blocks.stone_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', Blocks.cobblestone });
		this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 0), null, new Object[] { "CCC", "CCC", 'C', Blocks.cobblestone });
		this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 1), null, new Object[] { "CCC", "CCC", 'C', Blocks.mossy_cobblestone });
		this.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 9, 0), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.cobblestone });
		this.addRecipe(new ItemStack(Blocks.stonebrick, 9, 1), new ItemStack(Blocks.vine, 1, 0), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stonebrick, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stone, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stone, 1, 3) });
		
		// Tin-Plated Stone Decor
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.stoneTin, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickStoneTin, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.stoneTin, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickStoneTin });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.stoneTin, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickStoneTin });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickStoneTin, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.stoneTin, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.stoneTin, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.stoneTin, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.stoneTin, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.stoneTin, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.stoneTin2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MCBlocks.stoneTin, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MCBlocks.stoneTin, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stoneTin, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTinStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneTin, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTinStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneTin, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTinStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneTin, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.stoneTinStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneTin, 1, 7) });
		
		// Bronze-Plated Stone Decor
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.stoneBronze, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickStoneBronze, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.stoneBronze, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickStoneBronze });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.stoneBronze, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickStoneBronze });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickStoneBronze, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.stoneBronze, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.stoneBronze, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.stoneBronze, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.stoneBronze, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.stoneBronze, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.stoneBronze2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MCBlocks.stoneBronze, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MCBlocks.stoneBronze, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stoneBronze, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronzeStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneBronze, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronzeStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneBronze, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronzeStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneBronze, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.stoneBronzeStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneBronze, 1, 7) });
		
		// Steel-Plated Stone Decor
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.stoneSteel, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickStoneSteel, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.stoneSteel, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickStoneSteel });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.stoneSteel, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickStoneSteel });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickStoneSteel, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.stoneSteel, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.stoneSteel, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.stoneSteel, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.stoneSteel, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.stoneSteel, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.stoneSteel2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MCBlocks.stoneSteel, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MCBlocks.stoneSteel, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stoneSteel, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteelStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneSteel, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteelStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneSteel, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteelStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneSteel, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.stoneSteelStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneSteel, 1, 7) });
		
		// Meurodite-Plated Stone Decor
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.stoneMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickStoneMeurodite, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.stoneMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickStoneMeurodite });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.stoneMeurodite, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickStoneMeurodite });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickStoneMeurodite, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.stoneMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.stoneMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.stoneMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.stoneMeurodite, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.stoneMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.stoneMeurodite2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MCBlocks.stoneMeurodite, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MCBlocks.stoneMeurodite, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stoneMeurodite, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeuroditeStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeuroditeStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneMeurodite, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeuroditeStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneMeurodite, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.stoneMeuroditeStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.stoneMeurodite, 1, 7) });
		
		// Plating Recipes for Stone Decor
		Object[] rawStone = new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.stone };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), rawStone);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), rawStone);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), rawStone);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), rawStone);
		Object[] rawStoneSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_slab, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 9, 3), new ItemStack(MItems.plateTinItem, 1, 0), rawStoneSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 9, 3), new ItemStack(MItems.plateBronzeItem, 1, 0), rawStoneSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 9, 3), new ItemStack(MItems.plateSteelItem, 1, 0), rawStoneSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 9, 3), new ItemStack(MItems.plateMeuroditeItem, 1, 0), rawStoneSlab);
		Object[] stoneBrick = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCItems.brickStone, 1, 0) };
		this.addRecipe(new ItemStack(MCItems.brickStoneTin, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneBrick);
		this.addRecipe(new ItemStack(MCItems.brickStoneBronze, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneBrick);
		this.addRecipe(new ItemStack(MCItems.brickStoneSteel, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneBrick);
		this.addRecipe(new ItemStack(MCItems.brickStoneMeurodite, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneBrick);
		Object[] stoneBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stonebrick, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 1), new ItemStack(MItems.plateTinItem, 1, 0), stoneBricks);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 1), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneBricks);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 1), new ItemStack(MItems.plateSteelItem, 1, 0), stoneBricks);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 1), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneBricks);
		Object[] stoneBrickSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_slab, 1, 5) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 9, 6), new ItemStack(MItems.plateTinItem, 1, 0), stoneBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 9, 6), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 9, 6), new ItemStack(MItems.plateSteelItem, 1, 0), stoneBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 9, 6), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneBrickSlab);
		Object[] patternStoneBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stone, 1, 2) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 2), new ItemStack(MItems.plateTinItem, 1, 0), patternStoneBricks);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 2), new ItemStack(MItems.plateBronzeItem, 1, 0), patternStoneBricks);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 2), new ItemStack(MItems.plateSteelItem, 1, 0), patternStoneBricks);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 2), new ItemStack(MItems.plateMeuroditeItem, 1, 0), patternStoneBricks);
		Object[] stoneRoad = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stone, 1, 4) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 4), new ItemStack(MItems.plateTinItem, 1, 0), stoneRoad);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 4), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneRoad);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 4), new ItemStack(MItems.plateSteelItem, 1, 0), stoneRoad);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 4), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneRoad);
		Object[] stoneRefined = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stone, 1, 5) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 5), new ItemStack(MItems.plateTinItem, 1, 0), stoneRefined);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 5), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneRefined);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 5), new ItemStack(MItems.plateSteelItem, 1, 0), stoneRefined);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 5), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneRefined);
		Object[] stoneRefinedSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stone2, 1, 12) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 9, 12), new ItemStack(MItems.plateTinItem, 1, 0), stoneRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 9, 12), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 9, 12), new ItemStack(MItems.plateSteelItem, 1, 0), stoneRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 9, 12), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneRefinedSlab);
		Object[] stoneTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stone, 1, 3) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 3), new ItemStack(MItems.plateTinItem, 1, 0), stoneTiles);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 3), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneTiles);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 3), new ItemStack(MItems.plateSteelItem, 1, 0), stoneTiles);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 3), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneTiles);
		Object[] stoneTileSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stone2, 1, 9) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 9, 9), new ItemStack(MItems.plateTinItem, 1, 0), stoneTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 9, 9), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 9, 9), new ItemStack(MItems.plateSteelItem, 1, 0), stoneTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 9, 9), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneTileSlab);
		Object[] stonePillar = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stone2, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stonePillar);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stonePillar);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stonePillar);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stonePillar);
		Object[] stoneChiseled = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stonebrick, 1, 3) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 6), new ItemStack(MItems.plateTinItem, 1, 0), stoneChiseled);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 6), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneChiseled);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 6), new ItemStack(MItems.plateSteelItem, 1, 0), stoneChiseled);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 6), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneChiseled);
		Object[] stoneGlowstoneLamp = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stone, 1, 14) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 14), new ItemStack(MItems.plateTinItem, 1, 0), stoneGlowstoneLamp);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 14), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneGlowstoneLamp);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 14), new ItemStack(MItems.plateSteelItem, 1, 0), stoneGlowstoneLamp);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 14), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneGlowstoneLamp);
		Object[] stoneSunstoneLamp = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stone, 1, 15) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 15), new ItemStack(MItems.plateTinItem, 1, 0), stoneSunstoneLamp);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 15), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneSunstoneLamp);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 15), new ItemStack(MItems.plateSteelItem, 1, 0), stoneSunstoneLamp);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 15), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneSunstoneLamp);
		Object[] cobblestone = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.cobblestone, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 7), new ItemStack(MItems.plateTinItem, 1, 0), cobblestone);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 7), new ItemStack(MItems.plateBronzeItem, 1, 0), cobblestone);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 7), new ItemStack(MItems.plateSteelItem, 1, 0), cobblestone);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 7), new ItemStack(MItems.plateMeuroditeItem, 1, 0), cobblestone);
		// Object[] cobblestoneSlab = new Object[] { "CCC", "CCC", "CCC", 'C',
		// new ItemStack(Blocks.stone_slab, 1, 3) };
		// this.addRecipe(new ItemStack(MCBlocks.stoneTin2, 9, 15), new
		// ItemStack(MItems.plateTinItem, 1, 0), cobblestoneSlab);
		// this.addRecipe(new ItemStack(MCBlocks.stoneBronze2, 9, 15), new
		// ItemStack(MItems.plateBronzeItem, 1, 0), cobblestoneSlab);
		// this.addRecipe(new ItemStack(MCBlocks.stoneSteel2, 9, 15), new
		// ItemStack(MItems.plateSteelItem, 1, 0), cobblestoneSlab);
		// this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite2, 9, 15), new
		// ItemStack(MItems.plateMeuroditeItem, 1, 0), cobblestoneSlab);
		Object[] mossyCobblestone = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.mossy_cobblestone, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 8), new ItemStack(MItems.plateTinItem, 1, 0), mossyCobblestone);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 8), new ItemStack(MItems.plateBronzeItem, 1, 0), mossyCobblestone);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 8), new ItemStack(MItems.plateSteelItem, 1, 0), mossyCobblestone);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 8), new ItemStack(MItems.plateMeuroditeItem, 1, 0), mossyCobblestone);
		Object[] stoneRawStairs = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stoneStairsRaw, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTinStairsRaw, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneRawStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronzeStairsRaw, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneRawStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteelStairsRaw, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneRawStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeuroditeStairsRaw, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneRawStairs);
		Object[] stoneBricksStairs = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_brick_stairs, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTinStairsBricks, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneBricksStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronzeStairsBricks, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneBricksStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteelStairsBricks, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneBricksStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeuroditeStairsBricks, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneBricksStairs);
		Object[] stoneTilesStairs = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.stoneStairsTiles, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTinStairsTiles, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneTilesStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronzeStairsTiles, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneTilesStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteelStairsTiles, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneTilesStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeuroditeStairsTiles, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneTilesStairs);
		Object[] stoneCrackedStairs = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_stairs, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTinStairsCracked, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneCrackedStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronzeStairsCracked, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneCrackedStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteelStairsCracked, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneCrackedStairs);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeuroditeStairsCracked, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneCrackedStairs);
		
		// Sandstone Decor
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 1), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.sandstone_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickSandstone, 4, 0), null, new Object[] { "S", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.sandstone, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickSandstone });
		this.addRecipe(new ItemStack(MCBlocks.sandstone2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.sandstone, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.sandstone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickSandstone });
		this.addRecipe(new ItemStack(MCBlocks.sandstone, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickSandstone, 'D', new ItemStack(Blocks.sand, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.sandstone, 9, 2), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.sandstone2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(Blocks.sandstone, 1, 2) });
		this.addRecipe(new ItemStack(MCBlocks.sandstone, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(Blocks.sandstone, 1, 2) });
		this.addRecipe(new ItemStack(MCBlocks.sandstone2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.sandstone, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.sandstone2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(Blocks.sandstone, 1, 2) });
		this.addRecipe(new ItemStack(Blocks.sandstone, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.sandstone2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.sandstone, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.sandstone, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.sandstoneStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.sandstone, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.sandstoneStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.sandstone, 1, 3) });
		
		// Red Sandstone Decor
		this.addRecipe(new ItemStack(MCBlocks.redSandstone2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.redSandstone, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickRedSandstone, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.redSandstone, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickRedSandstone });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.redSandstone, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickRedSandstone });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickRedSandstone, 'D', new ItemStack(Blocks.sand, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.redSandstone, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.redSandstone, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.redSandstone, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.redSandstone, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.redSandstone, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.redSandstone2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstone, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.redSandstone, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstoneStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.redSandstone, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstoneStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.redSandstone, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.redSandstoneStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.redSandstone, 1, 3) });
		
		// Hardened Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.clay2, 6, 3), null, new Object[] { "SSS", 'S', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.brick_block, 1, 0), null, new Object[] { "BB", "BB", 'B', Items.brick });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 4), null, new Object[] { "SSS", 'S', Blocks.brick_block });
		this.addRecipe(new ItemStack(Blocks.brick_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', Blocks.brick_block });
		this.addRecipe(new ItemStack(MCBlocks.clay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', Items.brick });
		this.addRecipe(new ItemStack(MCBlocks.clay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', Items.brick, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.clay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(MCBlocks.clay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.clay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.clay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.clay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.clay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.clay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.clay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.clay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.clay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.clay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.clayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.hardened_clay, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.clayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.clay, 1, 3) });
		
		// White Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 14) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.whiteClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 14) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 14), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.whiteClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.whiteClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.whiteClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.whiteClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.whiteClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.whiteClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.whiteClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.whiteClay, 1, 3) });
		
		// Light Grey Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 8) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 13) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.silverClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 13) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 13), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 8) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.silverClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.silverClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.silverClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.silverClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.silverClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.silverClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 8) });
		this.addRecipe(new ItemStack(MCBlocks.silverClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.silverClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.silverClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.silverClay, 1, 3) });
		
		// Grey Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 4) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.greyClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 4) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 4), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.greyClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.greyClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.greyClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.greyClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.greyClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.greyClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.greyClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.greyClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.greyClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.greyClay, 1, 3) });
		
		// Black Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 15) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.blackClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 0), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 15) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.blackClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.blackClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.blackClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.blackClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.blackClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.blackClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 15) });
		this.addRecipe(new ItemStack(MCBlocks.blackClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.blackClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.blackClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.blackClay, 1, 3) });
		
		// Brown Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 2) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.brownClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 2) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 2), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.brownClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.brownClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.brownClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.brownClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.brownClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.brownClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.brownClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.brownClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.brownClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.brownClay, 1, 3) });
		
		// Pink Stained Clay
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 6) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 10) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.pinkClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 10) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 10), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 6) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.pinkClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.pinkClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.pinkClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.pinkClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.pinkClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 6) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.pinkClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.pinkClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.pinkClay, 1, 3) });
		
		// Red Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 14) });
		this.addRecipe(new ItemStack(MCBlocks.redClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.redClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.redClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.redClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 12), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.redClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 14) });
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.redClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.redClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.redClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.redClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.redClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.redClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.redClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.redClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 14) });
		this.addRecipe(new ItemStack(MCBlocks.redClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.redClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.redClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.redClay, 1, 3) });
		
		// Orange Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 9) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.orangeClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 9) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 9), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.orangeClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.orangeClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.orangeClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.orangeClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.orangeClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.orangeClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.orangeClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.orangeClay, 1, 3) });
		
		// Yellow Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 4) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 15) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.yellowClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 15) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 15), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 4) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.yellowClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.yellowClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.yellowClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.yellowClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.yellowClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 4) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.yellowClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.yellowClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.yellowClay, 1, 3) });
		
		// Lime Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.limeClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 7), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.limeClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.limeClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.limeClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.limeClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.limeClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.limeClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.limeClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.limeClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.limeClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.limeClay, 1, 3) });
		
		// Green Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 13) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.greenClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 5), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 13) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.greenClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.greenClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.greenClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.greenClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.greenClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.greenClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 13) });
		this.addRecipe(new ItemStack(MCBlocks.greenClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.greenClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.greenClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.greenClay, 1, 3) });
		
		// Cyan Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 9) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.cyanClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 3), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 9) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.cyanClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.cyanClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.cyanClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.cyanClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.cyanClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 9) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.cyanClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.cyanClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.cyanClay, 1, 3) });
		
		// Light Blue Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 6) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.lightBlueClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 6) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 6), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.lightBlueClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.lightBlueClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.lightBlueClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.lightBlueClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.lightBlueClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.lightBlueClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.lightBlueClay, 1, 3) });
		
		// Blue Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 11) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.blueClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 1), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 11) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.blueClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.blueClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.blueClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.blueClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.blueClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.blueClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 11) });
		this.addRecipe(new ItemStack(MCBlocks.blueClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.blueClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.blueClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.blueClay, 1, 3) });
		
		// Purple Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 10) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 11) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.purpleClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 11) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 11), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 10) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.purpleClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.purpleClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.purpleClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.purpleClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.purpleClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 10) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.purpleClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.purpleClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.purpleClay, 1, 3) });
		
		// Magenta Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 2) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 8) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.magentaClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MCItems.brickColoredClay, 1, 8) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 8), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 2) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.magentaClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.magentaClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.magentaClay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.magentaClay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.magentaClay2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 2) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.magentaClay, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.magentaClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.magentaClay, 1, 3) });
		
		// Stained Clay Dying Recipes
		Object[] rawClay = new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay };
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 15), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 1), new ItemStack(Items.dye, 1, 14), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 2), new ItemStack(Items.dye, 1, 13), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 3), new ItemStack(Items.dye, 1, 12), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 4), new ItemStack(Items.dye, 1, 11), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 5), new ItemStack(Items.dye, 1, 10), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 6), new ItemStack(Items.dye, 1, 9), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 7), new ItemStack(Items.dye, 1, 8), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 8), new ItemStack(Items.dye, 1, 7), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 9), new ItemStack(Items.dye, 1, 6), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 10), new ItemStack(Items.dye, 1, 5), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 11), new ItemStack(Items.dye, 1, 4), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 12), new ItemStack(Items.dye, 1, 3), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 13), new ItemStack(Items.dye, 1, 2), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 14), new ItemStack(Items.dye, 1, 1), rawClay);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 15), new ItemStack(Items.dye, 1, 0), rawClay);
		Object[] rawClaySlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clay2, 1, 3) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 9, 3), new ItemStack(Items.dye, 1, 15), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 9, 3), new ItemStack(Items.dye, 1, 14), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 9, 3), new ItemStack(Items.dye, 1, 13), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 9, 3), new ItemStack(Items.dye, 1, 12), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 9, 3), new ItemStack(Items.dye, 1, 11), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 9, 3), new ItemStack(Items.dye, 1, 10), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 9, 3), new ItemStack(Items.dye, 1, 9), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 9, 3), new ItemStack(Items.dye, 1, 8), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 9, 3), new ItemStack(Items.dye, 1, 7), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 9, 3), new ItemStack(Items.dye, 1, 6), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 9, 3), new ItemStack(Items.dye, 1, 5), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 9, 3), new ItemStack(Items.dye, 1, 4), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 9, 3), new ItemStack(Items.dye, 1, 3), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 9, 3), new ItemStack(Items.dye, 1, 2), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 9, 3), new ItemStack(Items.dye, 1, 1), rawClaySlab);
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 9, 3), new ItemStack(Items.dye, 1, 0), rawClaySlab);
		Object[] clayBrick = new Object[] { "CCC", "CCC", "CCC", 'C', Items.brick };
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 14), new ItemStack(Items.dye, 1, 15), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 9), new ItemStack(Items.dye, 1, 14), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 8), new ItemStack(Items.dye, 1, 13), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 6), new ItemStack(Items.dye, 1, 12), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 15), new ItemStack(Items.dye, 1, 11), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 7), new ItemStack(Items.dye, 1, 10), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 10), new ItemStack(Items.dye, 1, 9), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 4), new ItemStack(Items.dye, 1, 8), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 13), new ItemStack(Items.dye, 1, 7), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 3), new ItemStack(Items.dye, 1, 6), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 11), new ItemStack(Items.dye, 1, 5), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 1), new ItemStack(Items.dye, 1, 4), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 2), new ItemStack(Items.dye, 1, 3), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 5), new ItemStack(Items.dye, 1, 2), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 12), new ItemStack(Items.dye, 1, 1), clayBrick);
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 9, 0), new ItemStack(Items.dye, 1, 0), clayBrick);
		Object[] clayBricks = new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.brick_block };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 9, 1), new ItemStack(Items.dye, 1, 15), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 9, 1), new ItemStack(Items.dye, 1, 14), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 9, 1), new ItemStack(Items.dye, 1, 13), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 9, 1), new ItemStack(Items.dye, 1, 12), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 9, 1), new ItemStack(Items.dye, 1, 11), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 9, 1), new ItemStack(Items.dye, 1, 10), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 9, 1), new ItemStack(Items.dye, 1, 9), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 9, 1), new ItemStack(Items.dye, 1, 8), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 9, 1), new ItemStack(Items.dye, 1, 7), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 9, 1), new ItemStack(Items.dye, 1, 6), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 9, 1), new ItemStack(Items.dye, 1, 5), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 9, 1), new ItemStack(Items.dye, 1, 4), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 9, 1), new ItemStack(Items.dye, 1, 3), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 9, 1), new ItemStack(Items.dye, 1, 2), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.redClay, 9, 1), new ItemStack(Items.dye, 1, 1), clayBricks);
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 9, 1), new ItemStack(Items.dye, 1, 0), clayBricks);
		Object[] clayBrickSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_slab, 1, 4) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 9, 6), new ItemStack(Items.dye, 1, 15), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 9, 6), new ItemStack(Items.dye, 1, 14), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 9, 6), new ItemStack(Items.dye, 1, 13), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 9, 6), new ItemStack(Items.dye, 1, 12), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 9, 6), new ItemStack(Items.dye, 1, 11), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 9, 6), new ItemStack(Items.dye, 1, 10), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 9, 6), new ItemStack(Items.dye, 1, 9), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 9, 6), new ItemStack(Items.dye, 1, 8), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 9, 6), new ItemStack(Items.dye, 1, 7), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 9, 6), new ItemStack(Items.dye, 1, 6), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 9, 6), new ItemStack(Items.dye, 1, 5), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 9, 6), new ItemStack(Items.dye, 1, 4), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 9, 6), new ItemStack(Items.dye, 1, 3), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 9, 6), new ItemStack(Items.dye, 1, 2), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 9, 6), new ItemStack(Items.dye, 1, 1), clayBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 9, 6), new ItemStack(Items.dye, 1, 0), clayBrickSlab);
		Object[] clayPatternBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clay, 1, 2) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 9, 2), new ItemStack(Items.dye, 1, 15), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 9, 2), new ItemStack(Items.dye, 1, 14), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 9, 2), new ItemStack(Items.dye, 1, 13), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 9, 2), new ItemStack(Items.dye, 1, 12), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 9, 2), new ItemStack(Items.dye, 1, 11), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 9, 2), new ItemStack(Items.dye, 1, 10), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 9, 2), new ItemStack(Items.dye, 1, 9), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 9, 2), new ItemStack(Items.dye, 1, 8), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 9, 2), new ItemStack(Items.dye, 1, 7), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 9, 2), new ItemStack(Items.dye, 1, 6), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 9, 2), new ItemStack(Items.dye, 1, 5), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 9, 2), new ItemStack(Items.dye, 1, 4), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 9, 2), new ItemStack(Items.dye, 1, 3), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 9, 2), new ItemStack(Items.dye, 1, 2), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.redClay, 9, 2), new ItemStack(Items.dye, 1, 1), clayPatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 9, 2), new ItemStack(Items.dye, 1, 0), clayPatternBricks);
		Object[] clayRoad = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clay, 1, 4) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 9, 4), new ItemStack(Items.dye, 1, 15), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 9, 4), new ItemStack(Items.dye, 1, 14), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 9, 4), new ItemStack(Items.dye, 1, 13), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 9, 4), new ItemStack(Items.dye, 1, 12), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 9, 4), new ItemStack(Items.dye, 1, 11), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 9, 4), new ItemStack(Items.dye, 1, 10), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 9, 4), new ItemStack(Items.dye, 1, 9), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 9, 4), new ItemStack(Items.dye, 1, 8), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 9, 4), new ItemStack(Items.dye, 1, 7), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 9, 4), new ItemStack(Items.dye, 1, 6), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 9, 4), new ItemStack(Items.dye, 1, 5), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 9, 4), new ItemStack(Items.dye, 1, 4), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 9, 4), new ItemStack(Items.dye, 1, 3), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 9, 4), new ItemStack(Items.dye, 1, 2), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.redClay, 9, 4), new ItemStack(Items.dye, 1, 1), clayRoad);
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 9, 4), new ItemStack(Items.dye, 1, 0), clayRoad);
		Object[] clayRefined = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clay, 1, 5) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 9, 5), new ItemStack(Items.dye, 1, 15), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 9, 5), new ItemStack(Items.dye, 1, 14), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 9, 5), new ItemStack(Items.dye, 1, 13), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 9, 5), new ItemStack(Items.dye, 1, 12), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 9, 5), new ItemStack(Items.dye, 1, 11), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 9, 5), new ItemStack(Items.dye, 1, 10), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 9, 5), new ItemStack(Items.dye, 1, 9), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 9, 5), new ItemStack(Items.dye, 1, 8), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 9, 5), new ItemStack(Items.dye, 1, 7), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 9, 5), new ItemStack(Items.dye, 1, 6), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 9, 5), new ItemStack(Items.dye, 1, 5), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 9, 5), new ItemStack(Items.dye, 1, 4), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 9, 5), new ItemStack(Items.dye, 1, 3), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 9, 5), new ItemStack(Items.dye, 1, 2), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.redClay, 9, 5), new ItemStack(Items.dye, 1, 1), clayRefined);
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 9, 5), new ItemStack(Items.dye, 1, 0), clayRefined);
		Object[] clayRefinedSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clay2, 1, 12) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 9, 12), new ItemStack(Items.dye, 1, 15), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 9, 12), new ItemStack(Items.dye, 1, 14), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 9, 12), new ItemStack(Items.dye, 1, 13), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 9, 12), new ItemStack(Items.dye, 1, 12), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 9, 12), new ItemStack(Items.dye, 1, 11), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 9, 12), new ItemStack(Items.dye, 1, 10), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 9, 12), new ItemStack(Items.dye, 1, 9), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 9, 12), new ItemStack(Items.dye, 1, 8), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 9, 12), new ItemStack(Items.dye, 1, 7), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 9, 12), new ItemStack(Items.dye, 1, 6), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 9, 12), new ItemStack(Items.dye, 1, 5), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 9, 12), new ItemStack(Items.dye, 1, 4), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 9, 12), new ItemStack(Items.dye, 1, 3), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 9, 12), new ItemStack(Items.dye, 1, 2), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 9, 12), new ItemStack(Items.dye, 1, 1), clayRefinedSlab);
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 9, 12), new ItemStack(Items.dye, 1, 0), clayRefinedSlab);
		Object[] clayTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clay, 1, 3) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 9, 3), new ItemStack(Items.dye, 1, 15), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 9, 3), new ItemStack(Items.dye, 1, 14), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 9, 3), new ItemStack(Items.dye, 1, 13), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 9, 3), new ItemStack(Items.dye, 1, 12), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 9, 3), new ItemStack(Items.dye, 1, 11), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 9, 3), new ItemStack(Items.dye, 1, 10), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 9, 3), new ItemStack(Items.dye, 1, 9), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 9, 3), new ItemStack(Items.dye, 1, 8), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 9, 3), new ItemStack(Items.dye, 1, 7), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 9, 3), new ItemStack(Items.dye, 1, 6), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 9, 3), new ItemStack(Items.dye, 1, 5), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 9, 3), new ItemStack(Items.dye, 1, 4), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 9, 3), new ItemStack(Items.dye, 1, 3), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 9, 3), new ItemStack(Items.dye, 1, 2), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.redClay, 9, 3), new ItemStack(Items.dye, 1, 1), clayTiles);
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 9, 3), new ItemStack(Items.dye, 1, 0), clayTiles);
		Object[] clayTileSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clay2, 1, 9) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 9, 9), new ItemStack(Items.dye, 1, 15), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 9, 9), new ItemStack(Items.dye, 1, 14), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 9, 9), new ItemStack(Items.dye, 1, 13), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 9, 9), new ItemStack(Items.dye, 1, 12), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 9, 9), new ItemStack(Items.dye, 1, 11), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 9, 9), new ItemStack(Items.dye, 1, 10), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 9, 9), new ItemStack(Items.dye, 1, 9), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 9, 9), new ItemStack(Items.dye, 1, 8), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 9, 9), new ItemStack(Items.dye, 1, 7), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 9, 9), new ItemStack(Items.dye, 1, 6), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 9, 9), new ItemStack(Items.dye, 1, 5), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 9, 9), new ItemStack(Items.dye, 1, 4), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 9, 9), new ItemStack(Items.dye, 1, 3), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 9, 9), new ItemStack(Items.dye, 1, 2), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 9, 9), new ItemStack(Items.dye, 1, 1), clayTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 9, 9), new ItemStack(Items.dye, 1, 0), clayTileSlab);
		Object[] clayPillar = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clay2, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 9, 0), new ItemStack(Items.dye, 1, 15), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 9, 0), new ItemStack(Items.dye, 1, 14), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 9, 0), new ItemStack(Items.dye, 1, 13), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 9, 0), new ItemStack(Items.dye, 1, 12), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 9, 0), new ItemStack(Items.dye, 1, 11), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 9, 0), new ItemStack(Items.dye, 1, 10), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 9, 0), new ItemStack(Items.dye, 1, 9), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.greyClay2, 9, 0), new ItemStack(Items.dye, 1, 8), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 9, 0), new ItemStack(Items.dye, 1, 7), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 9, 0), new ItemStack(Items.dye, 1, 6), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 9, 0), new ItemStack(Items.dye, 1, 5), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 9, 0), new ItemStack(Items.dye, 1, 4), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 9, 0), new ItemStack(Items.dye, 1, 3), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.greenClay2, 9, 0), new ItemStack(Items.dye, 1, 2), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 9, 0), new ItemStack(Items.dye, 1, 1), clayPillar);
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 9, 0), new ItemStack(Items.dye, 1, 0), clayPillar);
		Object[] clayChiseled = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clay, 1, 6) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClay, 9, 6), new ItemStack(Items.dye, 1, 15), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.orangeClay, 9, 6), new ItemStack(Items.dye, 1, 14), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.magentaClay, 9, 6), new ItemStack(Items.dye, 1, 13), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay, 9, 6), new ItemStack(Items.dye, 1, 12), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.yellowClay, 9, 6), new ItemStack(Items.dye, 1, 11), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.limeClay, 9, 6), new ItemStack(Items.dye, 1, 10), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.pinkClay, 9, 6), new ItemStack(Items.dye, 1, 9), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.greyClay, 9, 6), new ItemStack(Items.dye, 1, 8), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.silverClay, 9, 6), new ItemStack(Items.dye, 1, 7), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.cyanClay, 9, 6), new ItemStack(Items.dye, 1, 6), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.purpleClay, 9, 6), new ItemStack(Items.dye, 1, 5), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.blueClay, 9, 6), new ItemStack(Items.dye, 1, 4), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.brownClay, 9, 6), new ItemStack(Items.dye, 1, 3), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.greenClay, 9, 6), new ItemStack(Items.dye, 1, 2), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.redClay, 9, 6), new ItemStack(Items.dye, 1, 1), clayChiseled);
		this.addRecipe(new ItemStack(MCBlocks.blackClay, 9, 6), new ItemStack(Items.dye, 1, 0), clayChiseled);
		Object[] clayStairsRaw = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clayStairsRaw, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 15), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.orangeClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 14), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.magentaClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 13), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 12), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.yellowClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 11), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.limeClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 10), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.pinkClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 9), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.greyClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 8), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.silverClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 7), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.cyanClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 6), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.purpleClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 5), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.blueClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 4), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.brownClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 3), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.greenClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 2), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.redClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 1), clayStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.blackClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 0), clayStairsRaw);
		Object[] clayStairsBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.brick_stairs, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 15), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.orangeClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 14), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.magentaClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 13), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 12), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.yellowClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 11), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.limeClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 10), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.pinkClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 9), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.greyClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 8), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.silverClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 7), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.cyanClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 6), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.purpleClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 5), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.blueClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 4), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.brownClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 3), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.greenClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 2), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.redClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 1), clayStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.blackClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 0), clayStairsBricks);
		Object[] clayStairsTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.clayStairsTiles, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.whiteClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 15), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.orangeClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 14), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.magentaClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 13), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 12), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.yellowClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 11), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.limeClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 10), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.pinkClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 9), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.greyClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 8), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.silverClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 7), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.cyanClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 6), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.purpleClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 5), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.blueClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 4), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.brownClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 3), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.greenClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 2), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.redClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 1), clayStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.blackClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 0), clayStairsTiles);
		
		// Flint Decor
		this.addRecipe(new ItemStack(MCBlocks.flint2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.flint, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickFlint, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.flint, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.flint, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickFlint });
		this.addRecipe(new ItemStack(MCBlocks.flint2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.flint, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.flint, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickFlint });
		this.addRecipe(new ItemStack(MCBlocks.flint, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickFlint, 'D', Blocks.gravel });
		this.addRecipe(new ItemStack(MCBlocks.flint, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.flint, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.flint2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.flint, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.flint, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.flint, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.flint2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.flint, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.flint2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.flint, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.flint, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.flint2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.flint, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MCBlocks.flint, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MCBlocks.flint, 8, 15), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MCBlocks.flint, 1, 6), 'G', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MCBlocks.flintStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.flint, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.flintStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.flint, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.flintStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.flint, 1, 3) });
		
		// Lapis Decor
		this.addRecipe(new ItemStack(MCBlocks.lapis2, 6, 3), null, new Object[] { "SSS", 'S', Blocks.lapis_block });
		this.addRecipe(new ItemStack(MCItems.brickLapis, 4, 0), null, new Object[] { "S", 'S', Blocks.lapis_block });
		this.addRecipe(new ItemStack(MCBlocks.lapis, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickLapis });
		this.addRecipe(new ItemStack(MCBlocks.lapis2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.lapis, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.lapis, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickLapis });
		this.addRecipe(new ItemStack(MCBlocks.lapis, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickLapis, 'D', new ItemStack(Blocks.sand, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.lapis, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.lapis_block });
		this.addRecipe(new ItemStack(MCBlocks.lapis2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.lapis, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.lapis, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.lapis, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.lapis2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.lapis, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.lapis2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.lapis, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.lapis, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.lapis2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.lapis, 8, 7), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MCBlocks.lapis, 1, 3), 'G', Blocks.gold_block });
		this.addRecipe(new ItemStack(MCBlocks.lapisStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.lapis_block, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.lapisStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.lapis, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.lapisStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.lapis, 1, 3) });
		
		// Slate Decor
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlate, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickSlate, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.graniteSlate, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickSlate });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlate, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickSlate });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickSlate, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.graniteSlate, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.graniteSlate, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.graniteSlate, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.graniteSlate, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.graniteSlate, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlate, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.graniteSlate2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlate, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlate, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlate, 1, 3) });
		
		// Tin-Plated Slate Decor
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlateTin, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickSlateTin, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.graniteSlateTin, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickSlateTin });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlateTin, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickSlateTin });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickSlateTin, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.graniteSlateTin, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.graniteSlateTin, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.graniteSlateTin, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.graniteSlateTin, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.graniteSlateTin, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.graniteSlateTin2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTinStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateTin, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTinStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateTin, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTinStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateTin, 1, 3) });
		
		// Bronze-Plated Slate Decor
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlateBronze, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickSlateBronze, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.graniteSlateBronze, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickSlateBronze });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlateBronze, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickSlateBronze });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickSlateBronze, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.graniteSlateBronze, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.graniteSlateBronze, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.graniteSlateBronze, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.graniteSlateBronze, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.graniteSlateBronze, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.graniteSlateBronze, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronzeStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateBronze, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronzeStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateBronze, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronzeStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateBronze, 1, 3) });
		
		// Steel-Plated Slate Decor
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlateSteel, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickSlateSteel, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.graniteSlateSteel, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickSlateSteel });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlateSteel, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickSlateSteel });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickSlateSteel, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.graniteSlateSteel, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.graniteSlateSteel, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.graniteSlateSteel, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.graniteSlateSteel, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.graniteSlateSteel, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.graniteSlateSteel2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteelStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateSteel, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteelStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateSteel, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteelStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateSteel, 1, 3) });
		
		// Meurodite-Plated Slate Decor
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickSlateMeurodite, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickSlateMeurodite });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickSlateMeurodite });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickSlateMeurodite, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.graniteSlateMeurodite2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeuroditeStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeuroditeStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeuroditeStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.graniteSlateMeurodite, 1, 3) });
		
		// Plating Recipes for Slate Decor
		Object[] rawSlate = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), rawSlate);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), rawSlate);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), rawSlate);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), rawSlate);
		Object[] rawSlateSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate2, 1, 3) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 9, 3), new ItemStack(MItems.plateTinItem, 1, 0), rawSlateSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 9, 3), new ItemStack(MItems.plateBronzeItem, 1, 0), rawSlateSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 9, 3), new ItemStack(MItems.plateSteelItem, 1, 0), rawSlateSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 9, 3), new ItemStack(MItems.plateMeuroditeItem, 1, 0), rawSlateSlab);
		Object[] slateBrick = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCItems.brickSlate, 1, 0) };
		this.addRecipe(new ItemStack(MCItems.brickSlateTin, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slateBrick);
		this.addRecipe(new ItemStack(MCItems.brickSlateBronze, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slateBrick);
		this.addRecipe(new ItemStack(MCItems.brickSlateSteel, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slateBrick);
		this.addRecipe(new ItemStack(MCItems.brickSlateMeurodite, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateBrick);
		Object[] slateBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate, 1, 1) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 9, 1), new ItemStack(MItems.plateTinItem, 1, 0), slateBricks);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 9, 1), new ItemStack(MItems.plateBronzeItem, 1, 0), slateBricks);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 9, 1), new ItemStack(MItems.plateSteelItem, 1, 0), slateBricks);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 9, 1), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateBricks);
		Object[] slateBrickSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate2, 1, 6) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 9, 6), new ItemStack(MItems.plateTinItem, 1, 0), slateBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 9, 6), new ItemStack(MItems.plateBronzeItem, 1, 0), slateBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 9, 6), new ItemStack(MItems.plateSteelItem, 1, 0), slateBrickSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 9, 6), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateBrickSlab);
		Object[] slatePatternBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate, 1, 2) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 9, 2), new ItemStack(MItems.plateTinItem, 1, 0), slatePatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 9, 2), new ItemStack(MItems.plateBronzeItem, 1, 0), slatePatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 9, 2), new ItemStack(MItems.plateSteelItem, 1, 0), slatePatternBricks);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 9, 2), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slatePatternBricks);
		Object[] slateRoad = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate, 1, 4) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 9, 4), new ItemStack(MItems.plateTinItem, 1, 0), slateRoad);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 9, 4), new ItemStack(MItems.plateBronzeItem, 1, 0), slateRoad);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 9, 4), new ItemStack(MItems.plateSteelItem, 1, 0), slateRoad);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 9, 4), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateRoad);
		Object[] refinedSlate = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate, 1, 5) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 9, 5), new ItemStack(MItems.plateTinItem, 1, 0), refinedSlate);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 9, 5), new ItemStack(MItems.plateBronzeItem, 1, 0), refinedSlate);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 9, 5), new ItemStack(MItems.plateSteelItem, 1, 0), refinedSlate);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 9, 5), new ItemStack(MItems.plateMeuroditeItem, 1, 0), refinedSlate);
		Object[] refinedSlateSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate2, 1, 12) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 9, 12), new ItemStack(MItems.plateTinItem, 1, 0), refinedSlateSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 9, 12), new ItemStack(MItems.plateBronzeItem, 1, 0), refinedSlateSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 9, 12), new ItemStack(MItems.plateSteelItem, 1, 0), refinedSlateSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 9, 12), new ItemStack(MItems.plateMeuroditeItem, 1, 0), refinedSlateSlab);
		Object[] slateTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate, 1, 3) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 9, 3), new ItemStack(MItems.plateTinItem, 1, 0), slateTiles);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 9, 3), new ItemStack(MItems.plateBronzeItem, 1, 0), slateTiles);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 9, 3), new ItemStack(MItems.plateSteelItem, 1, 0), slateTiles);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 9, 3), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateTiles);
		Object[] slateTileSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate2, 1, 9) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 9, 9), new ItemStack(MItems.plateTinItem, 1, 0), slateTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 9, 9), new ItemStack(MItems.plateBronzeItem, 1, 0), slateTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 9, 9), new ItemStack(MItems.plateSteelItem, 1, 0), slateTileSlab);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 9, 9), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateTileSlab);
		Object[] slatePillar = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate2, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin2, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slatePillar);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze2, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slatePillar);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel2, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slatePillar);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite2, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slatePillar);
		Object[] slateChiseled = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlate, 1, 6) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTin, 9, 6), new ItemStack(MItems.plateTinItem, 1, 0), slateChiseled);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronze, 9, 6), new ItemStack(MItems.plateBronzeItem, 1, 0), slateChiseled);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteel, 9, 6), new ItemStack(MItems.plateSteelItem, 1, 0), slateChiseled);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeurodite, 9, 6), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateChiseled);
		Object[] slateStairsRaw = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlateStairsRaw, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTinStairsRaw, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slateStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronzeStairsRaw, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slateStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteelStairsRaw, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slateStairsRaw);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeuroditeStairsRaw, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateStairsRaw);
		Object[] slateStairsBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlateStairsBricks, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTinStairsBricks, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slateStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronzeStairsBricks, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slateStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteelStairsBricks, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slateStairsBricks);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeuroditeStairsBricks, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateStairsBricks);
		Object[] slateStairsTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MCBlocks.graniteSlateStairsTiles, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateTinStairsTiles, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slateStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateBronzeStairsTiles, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slateStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateSteelStairsTiles, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slateStairsTiles);
		this.addRecipe(new ItemStack(MCBlocks.graniteSlateMeuroditeStairsTiles, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateStairsTiles);
		
		// Desert Quartz Decor
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickDesertQuartz, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickDesertQuartz });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.desertQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickDesertQuartz });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz, 3, 6), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickDesertQuartz, 'D', new ItemStack(Blocks.sand, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz, 9, 7), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.desertQuartz, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz, 4, 5), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.desertQuartz, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz, 4, 4), null, new Object[] { "TTT", "TST", "TTT", 'T', new ItemStack(MCBlocks.desertQuartz, 1, 3), 'S', Blocks.stone });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.desertQuartz, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.desertQuartz, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartz, 1, 8), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.desertQuartz2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartzStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartzStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.desertQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.desertQuartzStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.desertQuartz, 1, 3) });
		
		// Netherrack Decor
		this.addRecipe(new ItemStack(MCBlocks.netherrack2, 6, 3), null, new Object[] { "NNN", 'N', Blocks.netherrack });
		this.addRecipe(new ItemStack(Blocks.nether_brick, 1, 0), null, new Object[] { "BB", "BB", 'B', Items.netherbrick });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 6), null, new Object[] { "SSS", 'S', Blocks.nether_brick });
		this.addRecipe(new ItemStack(Blocks.nether_brick_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', Blocks.nether_brick });
		this.addRecipe(new ItemStack(Blocks.nether_brick_fence, 6, 0), null, new Object[] { "BBB", "BBB", 'B', Blocks.nether_brick });
		this.addRecipe(new ItemStack(MCBlocks.netherrack, 1, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', Items.netherbrick });
		this.addRecipe(new ItemStack(MCBlocks.netherrack, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', Items.netherbrick, 'D', Blocks.soul_sand });
		this.addRecipe(new ItemStack(MCBlocks.netherrack, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.netherrack });
		this.addRecipe(new ItemStack(MCBlocks.netherrack2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.netherrack, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.netherrack, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.netherrack, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.netherrack2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.netherrack, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.netherrack2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.netherrack, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.netherrack, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.netherrack2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.netherrackStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.netherrack, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.netherrackStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.netherrack, 1, 3) });
		
		// Nether Quartz Decor
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 7), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.quartz_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickNetherQuartz, 4, 0), null, new Object[] { "S", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickNetherQuartz });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.netherQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickNetherQuartz });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickNetherQuartz, 'D', Blocks.soul_sand });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.netherQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.netherQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.netherQuartz, 1, 3) });
		this.addRecipe(new ItemStack(Blocks.quartz_block, 2, 2), null, new Object[] { "Q", "Q", 'Q', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.netherQuartz, 1, 5) });
		this.addRecipe(new ItemStack(Blocks.quartz_block, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab, 1, 7) });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartz, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.netherQuartz2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartzStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.netherQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.netherQuartzStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.netherQuartz, 1, 3) });
		
		// Obsidian Decor
		this.addRecipe(new ItemStack(MCBlocks.obsidian2, 6, 3), null, new Object[] { "SSS", 'S', Blocks.obsidian });
		this.addRecipe(new ItemStack(MCItems.brickObsidian, 4, 0), null, new Object[] { "S", 'S', Blocks.obsidian });
		this.addRecipe(new ItemStack(MCBlocks.obsidian, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickObsidian });
		this.addRecipe(new ItemStack(MCBlocks.obsidian2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.obsidian, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.obsidian, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickObsidian });
		this.addRecipe(new ItemStack(MCBlocks.obsidian, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickObsidian, 'D', Blocks.end_stone });
		this.addRecipe(new ItemStack(MCBlocks.obsidian, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.obsidian });
		this.addRecipe(new ItemStack(MCBlocks.obsidian2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.obsidian, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.obsidian, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.obsidian, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.obsidian2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.obsidian, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.obsidian2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.obsidian, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.obsidian, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.obsidian2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.obsidianStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.obsidian, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.obsidianStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.obsidian, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.obsidianStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.obsidian, 1, 3) });
		
		// End Stone Decor
		this.addRecipe(new ItemStack(MCBlocks.endstone2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.endstone, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickEndStone, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.endstone, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.endstone, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickEndStone });
		this.addRecipe(new ItemStack(MCBlocks.endstone2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.endstone, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.endstone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickEndStone });
		this.addRecipe(new ItemStack(MCBlocks.endstone, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickEndStone, 'D', Blocks.obsidian });
		this.addRecipe(new ItemStack(MCBlocks.endstone, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.endstone, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.endstone2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.endstone, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.endstone, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.endstone, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.endstone2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.endstone, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.endstone2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.endstone, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.endstone, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.endstone2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.endstoneStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.endstone, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.endstoneStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.endstone, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.endstoneStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.endstone, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.endstoneStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.end_stone, 1, 0) });
		
		// Bedrock Decor
		this.addRecipe(new ItemStack(MCBlocks.bedrock2, 6, 3), null, new Object[] { "SSS", 'S', Blocks.bedrock });
		this.addRecipe(new ItemStack(MCItems.brickBedrock, 4, 0), null, new Object[] { "S", 'S', Blocks.bedrock });
		this.addRecipe(new ItemStack(MCBlocks.bedrock, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickBedrock });
		this.addRecipe(new ItemStack(MCBlocks.bedrock2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.bedrock, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.bedrock, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickBedrock });
		this.addRecipe(new ItemStack(MCBlocks.bedrock, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickBedrock, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.bedrock, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.bedrock });
		this.addRecipe(new ItemStack(MCBlocks.bedrock2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.bedrock, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.bedrock, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.bedrock, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.bedrock2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.bedrock, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.bedrock2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.bedrock, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.bedrock, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.bedrock2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.bedrock, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MCBlocks.bedrock, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MCBlocks.bedrock, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MCBlocks.bedrock, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MCBlocks.bedrockStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.bedrock, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.bedrockStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.bedrock, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.bedrockStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.bedrock, 1, 3) });
		
		// Radiant Quartz Decor
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.radiantQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickRadiantQuartz, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MCBlocks.radiantQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz, 1, 1), null, new Object[] { "BB", "BB", 'B', MCItems.brickRadiantQuartz });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MCBlocks.radiantQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MCItems.brickRadiantQuartz });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MCItems.brickRadiantQuartz, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MCBlocks.radiantQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.radiantQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.radiantQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.radiantQuartz, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.radiantQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartz, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.radiantQuartz2, 1, 12) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartzStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.radiantQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartzStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.radiantQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MCBlocks.radiantQuartzStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MCBlocks.radiantQuartz, 1, 3) });
		
		// Checkered Tiles
		this.addRecipe(new ItemStack(MBlocks.checkerTiles, 4, 0), null, new Object[] { "BW", "WB", 'B', new ItemStack(MCBlocks.flint, 1, 3), 'W', new ItemStack(MCBlocks.endstone, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.checkerTiles, 4, 1), null, new Object[] { "BW", "WB", 'B', new ItemStack(MCBlocks.flint, 1, 3), 'W', new ItemStack(MCBlocks.netherQuartz, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.checkerTiles, 4, 2), null, new Object[] { "BW", "WB", 'B', new ItemStack(MCBlocks.obsidian, 1, 3), 'W', new ItemStack(MCBlocks.endstone, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.checkerTiles, 4, 3), null, new Object[] { "BW", "WB", 'B', new ItemStack(MCBlocks.obsidian, 1, 3), 'W', new ItemStack(MCBlocks.netherQuartz, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.flintEndstoneStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.checkerTiles, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.flintQuartzStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.checkerTiles, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.obsidianEndstoneStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.checkerTiles, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.obsidianQuartzStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.checkerTiles, 1, 3) });
		
		// Edge Stone Brick
		this.addRecipe(new ItemStack(edgeStoneBrick, 1, 0), null, new Object[] { "SQ", "SQ", 'S', MCItems.brickStone, 'Q', Items.quartz });
		this.addRecipe(new ItemStack(edgeStoneBrick, 1, 1), null, new Object[] { "SQ", "SQ", 'S', MCItems.brickStone, 'Q', Items.flint });
		
		// Misc
		this.addRecipe(new ItemStack(Blocks.anvil, 1, 0), null, new Object[] { "III", " S ", "SSS", 'I', Blocks.iron_block, 'S', MItems.steelIngot });
	}
	
	public ShapedSCRecipe addRecipe(ItemStack output, ItemStack extraSlot, Object... data)
	{
		this.listSorted = false;
		
		String s = "";
		int index = 0;
		int width = 0;
		int height = 0;
		
		if (data[index] instanceof String[])
		{
			String[] strings = (String[]) data[index++];
			
			for (String s1 : strings)
			{
				++height;
				width = s1.length();
				s += s1;
			}
		}
		else
		{
			while (data[index] instanceof String)
			{
				String s1 = (String) data[index++];
				++height;
				width = s1.length();
				s += s1;
			}
		}
		
		HashMap map;
		
		for (map = new HashMap(); index < data.length; index += 2)
		{
			Character c = (Character) data[index];
			int index1 = index + 1;
			ItemStack stack1 = null;
			
			if (data[index1] instanceof Item)
			{
				stack1 = new ItemStack((Item) data[index1]);
			}
			else if (data[index1] instanceof Block)
			{
				stack1 = new ItemStack((Block) data[index1], 1, 32767);
			}
			else if (data[index1] instanceof ItemStack)
			{
				stack1 = (ItemStack) data[index1];
			}
			
			map.put(c, stack1);
		}
		
		int len = width * height;
		ItemStack[] stacks = new ItemStack[len];
		
		for (int i = 0; i < len; ++i)
		{
			char c = s.charAt(i);
			
			if (map.containsKey(Character.valueOf(c)))
			{
				stacks[i] = ((ItemStack) map.get(Character.valueOf(c))).copy();
			}
			else
			{
				stacks[i] = null;
			}
		}
		
		ShapedSCRecipe recipe = new ShapedSCRecipe(width, height, stacks, output, extraSlot);
		this.recipes.add(recipe);
		return recipe;
	}
	
	public ShapelessSCRecipe addShapelessRecipe(ItemStack stack, ItemStack extra, Object... data)
	{
		ArrayList list = new ArrayList();
		int len = data.length;
		
		for (int i = 0; i < len; ++i)
		{
			Object o = data[i];
			
			if (o instanceof ItemStack)
			{
				list.add(((ItemStack) o).copy());
			}
			else if (o instanceof Item)
			{
				list.add(new ItemStack((Item) o));
			}
			else if (o instanceof Block)
			{
				list.add(new ItemStack((Block) o));
			}
			else
			{
				throw new RuntimeException("Invalid shapeless recipy!");
			}
		}
		
		ShapelessSCRecipe recipe = new ShapelessSCRecipe(stack, list, extra);
		this.recipes.add(recipe);
		return recipe;
	}
	
	public ItemStack findMatchingRecipe(InventoryCrafting inventory, ItemStack extra, World world)
	{
		for (ISCRecipe recipe : this.getRecipeList())
		{
			if (recipe.matches(inventory, extra, world))
			{
				return recipe.getCraftingResult(inventory, extra);
			}
		}
		
		return null;
	}
	
	public List<ISCRecipe> getRecipeList()
	{
		if (!this.listSorted)
		{
			Collections.sort(this.recipes, new Comparator()
			{
				public int compare(ISCRecipe recipe1, ISCRecipe recipe2)
				{
					boolean flag1 = recipe1 instanceof ShapedSCRecipe;
					boolean flag2 = recipe1 instanceof ShapelessSCRecipe;
					boolean flag3 = recipe2 instanceof ShapedSCRecipe;
					boolean flag4 = recipe2 instanceof ShapelessSCRecipe;
					return flag2 && flag3 ? 1 : flag4 && flag1 ? -1 : recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0;
				}
				
				@Override
				public int compare(Object o1, Object o2)
				{
					return this.compare((ISCRecipe) o1, (ISCRecipe) o2);
				}
			});
			
			this.listSorted = true;
		}
		
		return this.recipes;
	}
}
