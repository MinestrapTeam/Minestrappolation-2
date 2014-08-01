package minestrapteam.minestrappolation.crafting.stonecutter;

import static minestrapteam.minestrappolation.lib.MBlocks.edgeStoneBrick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.lib.MTools;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StonecuttingManager
{
	/** The static instance of this class */
	public static final StonecuttingManager	instance	= new StonecuttingManager();
	
	/** A list of all the recipes added */
	private List<ICuttingRecipe>			recipes		= new ArrayList();
	private boolean							listSorted;
	
	private StonecuttingManager()
	{
		// Stone Decor
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 0), null, new Object[] { "SSS", 'S', Blocks.stone });
		this.addRecipe(new ItemStack(MItems.brickStone, 4, 0), null, new Object[] { "S", 'S', Blocks.stone });
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 0), null, new Object[] { "BB", "BB", 'B', MItems.brickStone });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stonebrick, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.stone_brick_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', new ItemStack(Blocks.stonebrick, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickStone });
		this.addRecipe(new ItemStack(MBlocks.stone, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickStone, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stone, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.stone });
		this.addRecipe(new ItemStack(MBlocks.stone2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.stone, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stone, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.stone, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stone2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.stone, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.stone2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.stone, 1, 5) });
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.stone2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.stone, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(Blocks.stonebrick, 1, 3), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.stone, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(Blocks.stonebrick, 1, 3), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 3), null, new Object[] { "SSS", 'S', Blocks.cobblestone });
		this.addRecipe(new ItemStack(Blocks.stone_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', Blocks.cobblestone });
		this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 0), null, new Object[] { "CCC", "CCC", 'C', Blocks.cobblestone });
		this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 1), null, new Object[] { "CCC", "CCC", 'C', Blocks.mossy_cobblestone });
		this.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 9, 0), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.cobblestone });
		this.addRecipe(new ItemStack(Blocks.stonebrick, 9, 1), new ItemStack(Blocks.vine, 1, 0), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stonebrick, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stone, 1, 3) });
		
		// Tin-Plated Stone Decor
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.stoneTin, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickStoneTin, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.stoneTin, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickStoneTin });
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.stoneTin, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickStoneTin });
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickStoneTin, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.stoneTin, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.stoneTin, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.stoneTin, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.stoneTin, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.stoneTin, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.stoneTin2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MBlocks.stoneTin, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MBlocks.stoneTin, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stoneTin, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.stoneTinStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneTin, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneTinStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneTin, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.stoneTinStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneTin, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.stoneTinStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneTin, 1, 7) });
		
		// Bronze-Plated Stone Decor
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.stoneBronze, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickStoneBronze, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.stoneBronze, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickStoneBronze });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.stoneBronze, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickStoneBronze });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickStoneBronze, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.stoneBronze, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.stoneBronze, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.stoneBronze, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.stoneBronze, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.stoneBronze, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.stoneBronze2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MBlocks.stoneBronze, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MBlocks.stoneBronze, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stoneBronze, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronzeStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneBronze, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronzeStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneBronze, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronzeStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneBronze, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.stoneBronzeStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneBronze, 1, 7) });
		
		// Steel-Plated Stone Decor
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.stoneSteel, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickStoneSteel, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.stoneSteel, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickStoneSteel });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.stoneSteel, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickStoneSteel });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickStoneSteel, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.stoneSteel, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.stoneSteel, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.stoneSteel, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.stoneSteel, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.stoneSteel, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.stoneSteel2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MBlocks.stoneSteel, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MBlocks.stoneSteel, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stoneSteel, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteelStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneSteel, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteelStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneSteel, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteelStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneSteel, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.stoneSteelStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneSteel, 1, 7) });
		
		// Meurodite-Plated Stone Decor
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.stoneMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickStoneMeurodite, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.stoneMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickStoneMeurodite });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.stoneMeurodite, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickStoneMeurodite });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickStoneMeurodite, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.stoneMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.stoneMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.stoneMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.stoneMeurodite, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.stoneMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.stoneMeurodite2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MBlocks.stoneMeurodite, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MBlocks.stoneMeurodite, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stoneMeurodite, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeuroditeStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeuroditeStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneMeurodite, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeuroditeStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneMeurodite, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.stoneMeuroditeStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.stoneMeurodite, 1, 7) });
		
		// Plating Recipes for Stone Decor
		Object[] rawStone = new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.stone };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), rawStone);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), rawStone);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), rawStone);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), rawStone);
		Object[] rawStoneSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_slab, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 9, 3), new ItemStack(MItems.plateTinItem, 1, 0), rawStoneSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 9, 3), new ItemStack(MItems.plateBronzeItem, 1, 0), rawStoneSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 9, 3), new ItemStack(MItems.plateSteelItem, 1, 0), rawStoneSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 9, 3), new ItemStack(MItems.plateMeuroditeItem, 1, 0), rawStoneSlab);
		Object[] stoneBrick = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MItems.brickStone, 1, 0) };
		this.addRecipe(new ItemStack(MItems.brickStoneTin, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneBrick);
		this.addRecipe(new ItemStack(MItems.brickStoneBronze, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneBrick);
		this.addRecipe(new ItemStack(MItems.brickStoneSteel, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneBrick);
		this.addRecipe(new ItemStack(MItems.brickStoneMeurodite, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneBrick);
		Object[] stoneBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stonebrick, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 1), new ItemStack(MItems.plateTinItem, 1, 0), stoneBricks);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 1), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneBricks);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 1), new ItemStack(MItems.plateSteelItem, 1, 0), stoneBricks);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 1), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneBricks);
		Object[] stoneBrickSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_slab, 1, 5) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 9, 6), new ItemStack(MItems.plateTinItem, 1, 0), stoneBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 9, 6), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 9, 6), new ItemStack(MItems.plateSteelItem, 1, 0), stoneBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 9, 6), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneBrickSlab);
		Object[] patternStoneBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stone, 1, 2) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 2), new ItemStack(MItems.plateTinItem, 1, 0), patternStoneBricks);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 2), new ItemStack(MItems.plateBronzeItem, 1, 0), patternStoneBricks);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 2), new ItemStack(MItems.plateSteelItem, 1, 0), patternStoneBricks);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 2), new ItemStack(MItems.plateMeuroditeItem, 1, 0), patternStoneBricks);
		Object[] stoneRoad = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stone, 1, 4) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 4), new ItemStack(MItems.plateTinItem, 1, 0), stoneRoad);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 4), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneRoad);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 4), new ItemStack(MItems.plateSteelItem, 1, 0), stoneRoad);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 4), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneRoad);
		Object[] stoneRefined = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stone, 1, 5) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 5), new ItemStack(MItems.plateTinItem, 1, 0), stoneRefined);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 5), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneRefined);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 5), new ItemStack(MItems.plateSteelItem, 1, 0), stoneRefined);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 5), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneRefined);
		Object[] stoneRefinedSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stone2, 1, 12) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 9, 12), new ItemStack(MItems.plateTinItem, 1, 0), stoneRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 9, 12), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 9, 12), new ItemStack(MItems.plateSteelItem, 1, 0), stoneRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 9, 12), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneRefinedSlab);
		Object[] stoneTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stone, 1, 3) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 3), new ItemStack(MItems.plateTinItem, 1, 0), stoneTiles);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 3), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneTiles);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 3), new ItemStack(MItems.plateSteelItem, 1, 0), stoneTiles);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 3), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneTiles);
		Object[] stoneTileSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stone2, 1, 9) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 9, 9), new ItemStack(MItems.plateTinItem, 1, 0), stoneTileSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 9, 9), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneTileSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 9, 9), new ItemStack(MItems.plateSteelItem, 1, 0), stoneTileSlab);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 9, 9), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneTileSlab);
		Object[] stonePillar = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stone2, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin2, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stonePillar);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stonePillar);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stonePillar);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stonePillar);
		Object[] stoneChiseled = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stonebrick, 1, 3) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 6), new ItemStack(MItems.plateTinItem, 1, 0), stoneChiseled);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 6), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneChiseled);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 6), new ItemStack(MItems.plateSteelItem, 1, 0), stoneChiseled);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 6), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneChiseled);
		Object[] stoneGlowstoneLamp = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stone, 1, 14) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 14), new ItemStack(MItems.plateTinItem, 1, 0), stoneGlowstoneLamp);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 14), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneGlowstoneLamp);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 14), new ItemStack(MItems.plateSteelItem, 1, 0), stoneGlowstoneLamp);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 14), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneGlowstoneLamp);
		Object[] stoneSunstoneLamp = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stone, 1, 15) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 15), new ItemStack(MItems.plateTinItem, 1, 0), stoneSunstoneLamp);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 15), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneSunstoneLamp);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 15), new ItemStack(MItems.plateSteelItem, 1, 0), stoneSunstoneLamp);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 15), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneSunstoneLamp);
		Object[] cobblestone = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.cobblestone, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 7), new ItemStack(MItems.plateTinItem, 1, 0), cobblestone);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 7), new ItemStack(MItems.plateBronzeItem, 1, 0), cobblestone);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 7), new ItemStack(MItems.plateSteelItem, 1, 0), cobblestone);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 7), new ItemStack(MItems.plateMeuroditeItem, 1, 0), cobblestone);
		// Object[] cobblestoneSlab = new Object[] { "CCC", "CCC", "CCC", 'C',
		// new ItemStack(Blocks.stone_slab, 1, 3) };
		// this.addRecipe(new ItemStack(MBlocks.stoneTin2, 9, 15), new
		// ItemStack(MItems.plateTinItem, 1, 0), cobblestoneSlab);
		// this.addRecipe(new ItemStack(MBlocks.stoneBronze2, 9, 15), new
		// ItemStack(MItems.plateBronzeItem, 1, 0), cobblestoneSlab);
		// this.addRecipe(new ItemStack(MBlocks.stoneSteel2, 9, 15), new
		// ItemStack(MItems.plateSteelItem, 1, 0), cobblestoneSlab);
		// this.addRecipe(new ItemStack(MBlocks.stoneMeurodite2, 9, 15), new
		// ItemStack(MItems.plateMeuroditeItem, 1, 0), cobblestoneSlab);
		Object[] mossyCobblestone = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.mossy_cobblestone, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.stoneTin, 9, 8), new ItemStack(MItems.plateTinItem, 1, 0), mossyCobblestone);
		this.addRecipe(new ItemStack(MBlocks.stoneBronze, 9, 8), new ItemStack(MItems.plateBronzeItem, 1, 0), mossyCobblestone);
		this.addRecipe(new ItemStack(MBlocks.stoneSteel, 9, 8), new ItemStack(MItems.plateSteelItem, 1, 0), mossyCobblestone);
		this.addRecipe(new ItemStack(MBlocks.stoneMeurodite, 9, 8), new ItemStack(MItems.plateMeuroditeItem, 1, 0), mossyCobblestone);
		Object[] stoneRawStairs = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stoneStairsRaw, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.stoneTinStairsRaw, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneRawStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneBronzeStairsRaw, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneRawStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneSteelStairsRaw, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneRawStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneMeuroditeStairsRaw, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneRawStairs);
		Object[] stoneBricksStairs = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_brick_stairs, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.stoneTinStairsBricks, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneBricksStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneBronzeStairsBricks, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneBricksStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneSteelStairsBricks, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneBricksStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneMeuroditeStairsBricks, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneBricksStairs);
		Object[] stoneTilesStairs = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.stoneStairsTiles, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.stoneTinStairsTiles, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneTilesStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneBronzeStairsTiles, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneTilesStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneSteelStairsTiles, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneTilesStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneMeuroditeStairsTiles, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneTilesStairs);
		Object[] stoneCrackedStairs = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_stairs, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.stoneTinStairsCracked, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), stoneCrackedStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneBronzeStairsCracked, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), stoneCrackedStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneSteelStairsCracked, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), stoneCrackedStairs);
		this.addRecipe(new ItemStack(MBlocks.stoneMeuroditeStairsCracked, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), stoneCrackedStairs);
		
		// Sandstone Decor
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 1), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.sandstone_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickSandstone, 4, 0), null, new Object[] { "S", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.sandstone, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickSandstone });
		this.addRecipe(new ItemStack(MBlocks.sandstone2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.sandstone, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.sandstone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickSandstone });
		this.addRecipe(new ItemStack(MBlocks.sandstone, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickSandstone, 'D', new ItemStack(Blocks.sand, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.sandstone, 9, 2), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.sandstone2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(Blocks.sandstone, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.sandstone, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(Blocks.sandstone, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.sandstone2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.sandstone, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.sandstone2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(Blocks.sandstone, 1, 2) });
		this.addRecipe(new ItemStack(Blocks.sandstone, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.sandstone2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.sandstone, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.sandstone, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.sandstoneStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.sandstone, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.sandstoneStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.sandstone, 1, 3) });
		
		// Red Sandstone Decor
		this.addRecipe(new ItemStack(MBlocks.redSandstone2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.redSandstone, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickRedSandstone, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.redSandstone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.redSandstone, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickRedSandstone });
		this.addRecipe(new ItemStack(MBlocks.redSandstone2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.redSandstone, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.redSandstone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickRedSandstone });
		this.addRecipe(new ItemStack(MBlocks.redSandstone, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickRedSandstone, 'D', new ItemStack(Blocks.sand, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.redSandstone, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.redSandstone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.redSandstone2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.redSandstone, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.redSandstone, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.redSandstone, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.redSandstone2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.redSandstone, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.redSandstone2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.redSandstone, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.redSandstone, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.redSandstone2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.redSandstone, 9, 8), new ItemStack(Blocks.vine, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.redSandstone, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.redSandstoneStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.redSandstone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.redSandstoneStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.redSandstone, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.redSandstoneStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.redSandstone, 1, 3) });
		
		// Hardened Clay Decor
		this.addRecipe(new ItemStack(MBlocks.clay2, 6, 3), null, new Object[] { "SSS", 'S', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.brick_block, 1, 0), null, new Object[] { "BB", "BB", 'B', Items.brick });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 4), null, new Object[] { "SSS", 'S', Blocks.brick_block });
		this.addRecipe(new ItemStack(Blocks.brick_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', Blocks.brick_block });
		this.addRecipe(new ItemStack(MBlocks.clay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', Items.brick });
		this.addRecipe(new ItemStack(MBlocks.clay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', Items.brick, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.clay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(MBlocks.clay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.clay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.clay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.clay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.clay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.clay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.clay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.clay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.clay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.clay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.clayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.hardened_clay, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.clayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.clay, 1, 3) });
		
		// White Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 14) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.whiteClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 14) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 14), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.whiteClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.whiteClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.whiteClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.whiteClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.whiteClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.whiteClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.whiteClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.whiteClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.whiteClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.whiteClay, 1, 3) });
		
		// Light Grey Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 8) });
		this.addRecipe(new ItemStack(MBlocks.silverClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 13) });
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.silverClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.silverClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 13) });
		this.addRecipe(new ItemStack(MBlocks.silverClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 13), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.silverClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 8) });
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.silverClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.silverClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.silverClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.silverClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.silverClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.silverClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.silverClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.silverClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 8) });
		this.addRecipe(new ItemStack(MBlocks.silverClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.silverClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.silverClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.silverClay, 1, 3) });
		
		// Grey Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.greyClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 4) });
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.greyClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.greyClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 4) });
		this.addRecipe(new ItemStack(MBlocks.greyClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 4), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.greyClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.greyClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.greyClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.greyClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.greyClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.greyClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.greyClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.greyClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.greyClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.greyClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.greyClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.greyClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.greyClay, 1, 3) });
		
		// Black Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 15) });
		this.addRecipe(new ItemStack(MBlocks.blackClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.blackClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.blackClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.blackClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 0), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.blackClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 15) });
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.blackClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.blackClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.blackClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.blackClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.blackClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.blackClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.blackClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.blackClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 15) });
		this.addRecipe(new ItemStack(MBlocks.blackClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.blackClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.blackClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.blackClay, 1, 3) });
		
		// Brown Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.brownClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.brownClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.brownClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.brownClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 2), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.brownClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.brownClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.brownClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.brownClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.brownClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.brownClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.brownClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.brownClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.brownClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.brownClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.brownClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.brownClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.brownClay, 1, 3) });
		
		// Pink Stained Clay
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 6) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 10) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.pinkClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 10) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 10), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 6) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.pinkClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.pinkClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.pinkClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.pinkClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.pinkClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.pinkClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 6) });
		this.addRecipe(new ItemStack(MBlocks.pinkClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.pinkClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.pinkClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.pinkClay, 1, 3) });
		
		// Red Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.redClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 14) });
		this.addRecipe(new ItemStack(MBlocks.redClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.redClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.redClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.redClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.redClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 12), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.redClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 14) });
		this.addRecipe(new ItemStack(MBlocks.redClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.redClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.redClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.redClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.redClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.redClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.redClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.redClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.redClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.redClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.redClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 14) });
		this.addRecipe(new ItemStack(MBlocks.redClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.redClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.redClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.redClay, 1, 3) });
		
		// Orange Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 9) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.orangeClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 9) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 9), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.orangeClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.orangeClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.orangeClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.orangeClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.orangeClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.orangeClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.orangeClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.orangeClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.orangeClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.orangeClay, 1, 3) });
		
		// Yellow Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 4) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 15) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.yellowClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 15) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 15), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 4) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.yellowClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.yellowClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.yellowClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.yellowClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.yellowClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.yellowClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 4) });
		this.addRecipe(new ItemStack(MBlocks.yellowClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.yellowClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.yellowClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.yellowClay, 1, 3) });
		
		// Lime Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.limeClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.limeClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.limeClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.limeClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 7), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.limeClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.limeClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.limeClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.limeClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.limeClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.limeClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.limeClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.limeClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.limeClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.limeClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.limeClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.limeClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.limeClay, 1, 3) });
		
		// Green Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 13) });
		this.addRecipe(new ItemStack(MBlocks.greenClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.greenClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.greenClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.greenClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 5), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.greenClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 13) });
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.greenClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.greenClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.greenClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.greenClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.greenClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.greenClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.greenClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.greenClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 13) });
		this.addRecipe(new ItemStack(MBlocks.greenClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.greenClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.greenClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.greenClay, 1, 3) });
		
		// Cyan Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 9) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.cyanClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 3), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 9) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.cyanClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.cyanClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.cyanClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.cyanClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.cyanClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.cyanClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 9) });
		this.addRecipe(new ItemStack(MBlocks.cyanClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.cyanClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.cyanClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.cyanClay, 1, 3) });
		
		// Light Blue Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 6) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.lightBlueClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 6) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 6), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.lightBlueClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.lightBlueClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.lightBlueClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.lightBlueClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.lightBlueClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.lightBlueClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.lightBlueClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.lightBlueClay, 1, 3) });
		
		// Blue Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 11) });
		this.addRecipe(new ItemStack(MBlocks.blueClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.blueClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.blueClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.blueClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 1), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.blueClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 11) });
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.blueClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.blueClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.blueClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.blueClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.blueClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.blueClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.blueClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.blueClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 11) });
		this.addRecipe(new ItemStack(MBlocks.blueClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.blueClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.blueClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.blueClay, 1, 3) });
		
		// Purple Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 10) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 11) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.purpleClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 11) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 11), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 10) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.purpleClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.purpleClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.purpleClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.purpleClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.purpleClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.purpleClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 10) });
		this.addRecipe(new ItemStack(MBlocks.purpleClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.purpleClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.purpleClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.purpleClay, 1, 3) });
		
		// Magenta Stained Clay Decor
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 1, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MItems.brickColoredClay, 1, 8) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.magentaClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MItems.brickColoredClay, 1, 8) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', new ItemStack(MItems.brickColoredClay, 1, 8), 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.magentaClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.magentaClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.magentaClay, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.magentaClay, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.magentaClay2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.magentaClayStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.stained_hardened_clay, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.magentaClayStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.magentaClay, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.magentaClayStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.magentaClay, 1, 3) });
		
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
		Object[] rawClaySlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clay2, 1, 3) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 9, 3), new ItemStack(Items.dye, 1, 15), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 9, 3), new ItemStack(Items.dye, 1, 14), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 9, 3), new ItemStack(Items.dye, 1, 13), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 9, 3), new ItemStack(Items.dye, 1, 12), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 9, 3), new ItemStack(Items.dye, 1, 11), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 9, 3), new ItemStack(Items.dye, 1, 10), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 9, 3), new ItemStack(Items.dye, 1, 9), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 9, 3), new ItemStack(Items.dye, 1, 8), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 9, 3), new ItemStack(Items.dye, 1, 7), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 9, 3), new ItemStack(Items.dye, 1, 6), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 9, 3), new ItemStack(Items.dye, 1, 5), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 9, 3), new ItemStack(Items.dye, 1, 4), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 9, 3), new ItemStack(Items.dye, 1, 3), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 9, 3), new ItemStack(Items.dye, 1, 2), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.redClay2, 9, 3), new ItemStack(Items.dye, 1, 1), rawClaySlab);
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 9, 3), new ItemStack(Items.dye, 1, 0), rawClaySlab);
		Object[] clayBrick = new Object[] { "CCC", "CCC", "CCC", 'C', Items.brick };
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 14), new ItemStack(Items.dye, 1, 15), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 9), new ItemStack(Items.dye, 1, 14), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 8), new ItemStack(Items.dye, 1, 13), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 6), new ItemStack(Items.dye, 1, 12), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 15), new ItemStack(Items.dye, 1, 11), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 7), new ItemStack(Items.dye, 1, 10), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 10), new ItemStack(Items.dye, 1, 9), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 4), new ItemStack(Items.dye, 1, 8), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 13), new ItemStack(Items.dye, 1, 7), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 3), new ItemStack(Items.dye, 1, 6), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 11), new ItemStack(Items.dye, 1, 5), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 1), new ItemStack(Items.dye, 1, 4), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 2), new ItemStack(Items.dye, 1, 3), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 5), new ItemStack(Items.dye, 1, 2), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 12), new ItemStack(Items.dye, 1, 1), clayBrick);
		this.addRecipe(new ItemStack(MItems.brickColoredClay, 9, 0), new ItemStack(Items.dye, 1, 0), clayBrick);
		Object[] clayBricks = new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.brick_block };
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 9, 1), new ItemStack(Items.dye, 1, 15), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 9, 1), new ItemStack(Items.dye, 1, 14), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 9, 1), new ItemStack(Items.dye, 1, 13), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 9, 1), new ItemStack(Items.dye, 1, 12), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 9, 1), new ItemStack(Items.dye, 1, 11), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.limeClay, 9, 1), new ItemStack(Items.dye, 1, 10), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 9, 1), new ItemStack(Items.dye, 1, 9), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.greyClay, 9, 1), new ItemStack(Items.dye, 1, 8), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.silverClay, 9, 1), new ItemStack(Items.dye, 1, 7), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 9, 1), new ItemStack(Items.dye, 1, 6), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 9, 1), new ItemStack(Items.dye, 1, 5), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.blueClay, 9, 1), new ItemStack(Items.dye, 1, 4), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.brownClay, 9, 1), new ItemStack(Items.dye, 1, 3), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.greenClay, 9, 1), new ItemStack(Items.dye, 1, 2), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.redClay, 9, 1), new ItemStack(Items.dye, 1, 1), clayBricks);
		this.addRecipe(new ItemStack(MBlocks.blackClay, 9, 1), new ItemStack(Items.dye, 1, 0), clayBricks);
		Object[] clayBrickSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.stone_slab, 1, 4) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 9, 6), new ItemStack(Items.dye, 1, 15), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 9, 6), new ItemStack(Items.dye, 1, 14), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 9, 6), new ItemStack(Items.dye, 1, 13), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 9, 6), new ItemStack(Items.dye, 1, 12), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 9, 6), new ItemStack(Items.dye, 1, 11), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 9, 6), new ItemStack(Items.dye, 1, 10), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 9, 6), new ItemStack(Items.dye, 1, 9), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 9, 6), new ItemStack(Items.dye, 1, 8), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 9, 6), new ItemStack(Items.dye, 1, 7), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 9, 6), new ItemStack(Items.dye, 1, 6), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 9, 6), new ItemStack(Items.dye, 1, 5), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 9, 6), new ItemStack(Items.dye, 1, 4), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 9, 6), new ItemStack(Items.dye, 1, 3), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 9, 6), new ItemStack(Items.dye, 1, 2), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.redClay2, 9, 6), new ItemStack(Items.dye, 1, 1), clayBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 9, 6), new ItemStack(Items.dye, 1, 0), clayBrickSlab);
		Object[] clayPatternBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clay, 1, 2) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 9, 2), new ItemStack(Items.dye, 1, 15), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 9, 2), new ItemStack(Items.dye, 1, 14), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 9, 2), new ItemStack(Items.dye, 1, 13), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 9, 2), new ItemStack(Items.dye, 1, 12), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 9, 2), new ItemStack(Items.dye, 1, 11), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.limeClay, 9, 2), new ItemStack(Items.dye, 1, 10), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 9, 2), new ItemStack(Items.dye, 1, 9), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.greyClay, 9, 2), new ItemStack(Items.dye, 1, 8), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.silverClay, 9, 2), new ItemStack(Items.dye, 1, 7), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 9, 2), new ItemStack(Items.dye, 1, 6), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 9, 2), new ItemStack(Items.dye, 1, 5), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.blueClay, 9, 2), new ItemStack(Items.dye, 1, 4), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.brownClay, 9, 2), new ItemStack(Items.dye, 1, 3), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.greenClay, 9, 2), new ItemStack(Items.dye, 1, 2), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.redClay, 9, 2), new ItemStack(Items.dye, 1, 1), clayPatternBricks);
		this.addRecipe(new ItemStack(MBlocks.blackClay, 9, 2), new ItemStack(Items.dye, 1, 0), clayPatternBricks);
		Object[] clayRoad = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clay, 1, 4) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 9, 4), new ItemStack(Items.dye, 1, 15), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 9, 4), new ItemStack(Items.dye, 1, 14), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 9, 4), new ItemStack(Items.dye, 1, 13), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 9, 4), new ItemStack(Items.dye, 1, 12), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 9, 4), new ItemStack(Items.dye, 1, 11), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.limeClay, 9, 4), new ItemStack(Items.dye, 1, 10), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 9, 4), new ItemStack(Items.dye, 1, 9), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.greyClay, 9, 4), new ItemStack(Items.dye, 1, 8), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.silverClay, 9, 4), new ItemStack(Items.dye, 1, 7), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 9, 4), new ItemStack(Items.dye, 1, 6), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 9, 4), new ItemStack(Items.dye, 1, 5), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.blueClay, 9, 4), new ItemStack(Items.dye, 1, 4), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.brownClay, 9, 4), new ItemStack(Items.dye, 1, 3), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.greenClay, 9, 4), new ItemStack(Items.dye, 1, 2), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.redClay, 9, 4), new ItemStack(Items.dye, 1, 1), clayRoad);
		this.addRecipe(new ItemStack(MBlocks.blackClay, 9, 4), new ItemStack(Items.dye, 1, 0), clayRoad);
		Object[] clayRefined = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clay, 1, 5) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 9, 5), new ItemStack(Items.dye, 1, 15), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 9, 5), new ItemStack(Items.dye, 1, 14), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 9, 5), new ItemStack(Items.dye, 1, 13), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 9, 5), new ItemStack(Items.dye, 1, 12), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 9, 5), new ItemStack(Items.dye, 1, 11), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.limeClay, 9, 5), new ItemStack(Items.dye, 1, 10), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 9, 5), new ItemStack(Items.dye, 1, 9), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.greyClay, 9, 5), new ItemStack(Items.dye, 1, 8), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.silverClay, 9, 5), new ItemStack(Items.dye, 1, 7), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 9, 5), new ItemStack(Items.dye, 1, 6), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 9, 5), new ItemStack(Items.dye, 1, 5), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.blueClay, 9, 5), new ItemStack(Items.dye, 1, 4), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.brownClay, 9, 5), new ItemStack(Items.dye, 1, 3), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.greenClay, 9, 5), new ItemStack(Items.dye, 1, 2), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.redClay, 9, 5), new ItemStack(Items.dye, 1, 1), clayRefined);
		this.addRecipe(new ItemStack(MBlocks.blackClay, 9, 5), new ItemStack(Items.dye, 1, 0), clayRefined);
		Object[] clayRefinedSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clay2, 1, 12) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 9, 12), new ItemStack(Items.dye, 1, 15), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 9, 12), new ItemStack(Items.dye, 1, 14), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 9, 12), new ItemStack(Items.dye, 1, 13), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 9, 12), new ItemStack(Items.dye, 1, 12), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 9, 12), new ItemStack(Items.dye, 1, 11), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 9, 12), new ItemStack(Items.dye, 1, 10), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 9, 12), new ItemStack(Items.dye, 1, 9), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 9, 12), new ItemStack(Items.dye, 1, 8), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 9, 12), new ItemStack(Items.dye, 1, 7), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 9, 12), new ItemStack(Items.dye, 1, 6), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 9, 12), new ItemStack(Items.dye, 1, 5), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 9, 12), new ItemStack(Items.dye, 1, 4), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 9, 12), new ItemStack(Items.dye, 1, 3), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 9, 12), new ItemStack(Items.dye, 1, 2), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.redClay2, 9, 12), new ItemStack(Items.dye, 1, 1), clayRefinedSlab);
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 9, 12), new ItemStack(Items.dye, 1, 0), clayRefinedSlab);
		Object[] clayTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clay, 1, 3) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 9, 3), new ItemStack(Items.dye, 1, 15), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 9, 3), new ItemStack(Items.dye, 1, 14), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 9, 3), new ItemStack(Items.dye, 1, 13), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 9, 3), new ItemStack(Items.dye, 1, 12), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 9, 3), new ItemStack(Items.dye, 1, 11), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.limeClay, 9, 3), new ItemStack(Items.dye, 1, 10), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 9, 3), new ItemStack(Items.dye, 1, 9), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.greyClay, 9, 3), new ItemStack(Items.dye, 1, 8), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.silverClay, 9, 3), new ItemStack(Items.dye, 1, 7), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 9, 3), new ItemStack(Items.dye, 1, 6), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 9, 3), new ItemStack(Items.dye, 1, 5), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.blueClay, 9, 3), new ItemStack(Items.dye, 1, 4), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.brownClay, 9, 3), new ItemStack(Items.dye, 1, 3), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.greenClay, 9, 3), new ItemStack(Items.dye, 1, 2), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.redClay, 9, 3), new ItemStack(Items.dye, 1, 1), clayTiles);
		this.addRecipe(new ItemStack(MBlocks.blackClay, 9, 3), new ItemStack(Items.dye, 1, 0), clayTiles);
		Object[] clayTileSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clay2, 1, 9) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 9, 9), new ItemStack(Items.dye, 1, 15), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 9, 9), new ItemStack(Items.dye, 1, 14), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 9, 9), new ItemStack(Items.dye, 1, 13), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 9, 9), new ItemStack(Items.dye, 1, 12), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 9, 9), new ItemStack(Items.dye, 1, 11), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 9, 9), new ItemStack(Items.dye, 1, 10), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 9, 9), new ItemStack(Items.dye, 1, 9), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 9, 9), new ItemStack(Items.dye, 1, 8), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 9, 9), new ItemStack(Items.dye, 1, 7), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 9, 9), new ItemStack(Items.dye, 1, 6), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 9, 9), new ItemStack(Items.dye, 1, 5), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 9, 9), new ItemStack(Items.dye, 1, 4), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 9, 9), new ItemStack(Items.dye, 1, 3), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 9, 9), new ItemStack(Items.dye, 1, 2), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.redClay2, 9, 9), new ItemStack(Items.dye, 1, 1), clayTileSlab);
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 9, 9), new ItemStack(Items.dye, 1, 0), clayTileSlab);
		Object[] clayPillar = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clay2, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay2, 9, 0), new ItemStack(Items.dye, 1, 15), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.orangeClay2, 9, 0), new ItemStack(Items.dye, 1, 14), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.magentaClay2, 9, 0), new ItemStack(Items.dye, 1, 13), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay2, 9, 0), new ItemStack(Items.dye, 1, 12), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.yellowClay2, 9, 0), new ItemStack(Items.dye, 1, 11), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.limeClay2, 9, 0), new ItemStack(Items.dye, 1, 10), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.pinkClay2, 9, 0), new ItemStack(Items.dye, 1, 9), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.greyClay2, 9, 0), new ItemStack(Items.dye, 1, 8), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.silverClay2, 9, 0), new ItemStack(Items.dye, 1, 7), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.cyanClay2, 9, 0), new ItemStack(Items.dye, 1, 6), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.purpleClay2, 9, 0), new ItemStack(Items.dye, 1, 5), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.blueClay2, 9, 0), new ItemStack(Items.dye, 1, 4), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.brownClay2, 9, 0), new ItemStack(Items.dye, 1, 3), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.greenClay2, 9, 0), new ItemStack(Items.dye, 1, 2), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.redClay2, 9, 0), new ItemStack(Items.dye, 1, 1), clayPillar);
		this.addRecipe(new ItemStack(MBlocks.blackClay2, 9, 0), new ItemStack(Items.dye, 1, 0), clayPillar);
		Object[] clayChiseled = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clay, 1, 6) };
		this.addRecipe(new ItemStack(MBlocks.whiteClay, 9, 6), new ItemStack(Items.dye, 1, 15), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.orangeClay, 9, 6), new ItemStack(Items.dye, 1, 14), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.magentaClay, 9, 6), new ItemStack(Items.dye, 1, 13), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClay, 9, 6), new ItemStack(Items.dye, 1, 12), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.yellowClay, 9, 6), new ItemStack(Items.dye, 1, 11), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.limeClay, 9, 6), new ItemStack(Items.dye, 1, 10), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.pinkClay, 9, 6), new ItemStack(Items.dye, 1, 9), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.greyClay, 9, 6), new ItemStack(Items.dye, 1, 8), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.silverClay, 9, 6), new ItemStack(Items.dye, 1, 7), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.cyanClay, 9, 6), new ItemStack(Items.dye, 1, 6), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.purpleClay, 9, 6), new ItemStack(Items.dye, 1, 5), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.blueClay, 9, 6), new ItemStack(Items.dye, 1, 4), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.brownClay, 9, 6), new ItemStack(Items.dye, 1, 3), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.greenClay, 9, 6), new ItemStack(Items.dye, 1, 2), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.redClay, 9, 6), new ItemStack(Items.dye, 1, 1), clayChiseled);
		this.addRecipe(new ItemStack(MBlocks.blackClay, 9, 6), new ItemStack(Items.dye, 1, 0), clayChiseled);
		Object[] clayStairsRaw = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clayStairsRaw, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.whiteClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 15), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.orangeClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 14), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.magentaClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 13), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 12), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.yellowClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 11), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.limeClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 10), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.pinkClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 9), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.greyClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 8), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.silverClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 7), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.cyanClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 6), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.purpleClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 5), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.blueClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 4), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.brownClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 3), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.greenClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 2), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.redClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 1), clayStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.blackClayStairsRaw, 9, 0), new ItemStack(Items.dye, 1, 0), clayStairsRaw);
		Object[] clayStairsBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.brick_stairs, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.whiteClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 15), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.orangeClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 14), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.magentaClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 13), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 12), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.yellowClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 11), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.limeClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 10), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.pinkClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 9), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.greyClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 8), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.silverClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 7), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.cyanClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 6), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.purpleClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 5), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.blueClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 4), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.brownClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 3), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.greenClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 2), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.redClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 1), clayStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.blackClayStairsBricks, 9, 0), new ItemStack(Items.dye, 1, 0), clayStairsBricks);
		Object[] clayStairsTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.clayStairsTiles, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.whiteClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 15), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.orangeClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 14), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.magentaClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 13), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.lightBlueClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 12), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.yellowClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 11), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.limeClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 10), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.pinkClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 9), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.greyClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 8), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.silverClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 7), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.cyanClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 6), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.purpleClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 5), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.blueClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 4), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.brownClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 3), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.greenClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 2), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.redClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 1), clayStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.blackClayStairsTiles, 9, 0), new ItemStack(Items.dye, 1, 0), clayStairsTiles);
		
		// Flint Decor
		this.addRecipe(new ItemStack(MBlocks.flint2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.flint, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickFlint, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.flint, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.flint, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickFlint });
		this.addRecipe(new ItemStack(MBlocks.flint2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.flint, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.flint, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickFlint });
		this.addRecipe(new ItemStack(MBlocks.flint, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickFlint, 'D', Blocks.gravel });
		this.addRecipe(new ItemStack(MBlocks.flint, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.flint, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.flint2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.flint, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.flint, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.flint, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.flint2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.flint, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.flint2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.flint, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.flint, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.flint2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.flint, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MBlocks.flint, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.flint, 8, 15), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MBlocks.flint, 1, 6), 'G', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MBlocks.flintStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.flint, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.flintStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.flint, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.flintStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.flint, 1, 3) });
		
		// Lapis Decor
		this.addRecipe(new ItemStack(MBlocks.lapis2, 6, 3), null, new Object[] { "SSS", 'S', Blocks.lapis_block });
		this.addRecipe(new ItemStack(MItems.brickLapis, 4, 0), null, new Object[] { "S", 'S', Blocks.lapis_block });
		this.addRecipe(new ItemStack(MBlocks.lapis, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickLapis });
		this.addRecipe(new ItemStack(MBlocks.lapis2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.lapis, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.lapis, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickLapis });
		this.addRecipe(new ItemStack(MBlocks.lapis, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickLapis, 'D', new ItemStack(Blocks.sand, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.lapis, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.lapis_block });
		this.addRecipe(new ItemStack(MBlocks.lapis2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.lapis, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.lapis, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.lapis, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.lapis2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.lapis, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.lapis2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.lapis, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.lapis, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.lapis2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.lapis, 8, 7), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MBlocks.lapis, 1, 3), 'G', Blocks.gold_block });
		this.addRecipe(new ItemStack(MBlocks.lapisStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.lapis_block, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.lapisStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.lapis, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.lapisStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.lapis, 1, 3) });
		
		// Slate Decor
		this.addRecipe(new ItemStack(MBlocks.graniteSlate2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlate, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickSlate, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.graniteSlate, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickSlate });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlate, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickSlate });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickSlate, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.graniteSlate, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.graniteSlate, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.graniteSlate, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.graniteSlate, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.graniteSlate, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlate, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.graniteSlate2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlate, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlate, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlate, 1, 3) });
		
		// Tin-Plated Slate Decor
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlateTin, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickSlateTin, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.graniteSlateTin, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickSlateTin });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlateTin, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickSlateTin });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickSlateTin, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.graniteSlateTin, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.graniteSlateTin, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.graniteSlateTin, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.graniteSlateTin, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.graniteSlateTin, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.graniteSlateTin2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTinStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateTin, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTinStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateTin, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTinStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateTin, 1, 3) });
		
		// Bronze-Plated Slate Decor
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlateBronze, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickSlateBronze, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.graniteSlateBronze, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickSlateBronze });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlateBronze, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickSlateBronze });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickSlateBronze, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.graniteSlateBronze, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.graniteSlateBronze, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.graniteSlateBronze, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.graniteSlateBronze, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.graniteSlateBronze, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.graniteSlateBronze, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronzeStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateBronze, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronzeStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateBronze, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronzeStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateBronze, 1, 3) });
		
		// Steel-Plated Slate Decor
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlateSteel, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickSlateSteel, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.graniteSlateSteel, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickSlateSteel });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlateSteel, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickSlateSteel });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickSlateSteel, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.graniteSlateSteel, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.graniteSlateSteel, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.graniteSlateSteel, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.graniteSlateSteel, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.graniteSlateSteel, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.graniteSlateSteel2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteelStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateSteel, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteelStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateSteel, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteelStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateSteel, 1, 3) });
		
		// Meurodite-Plated Slate Decor
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickSlateMeurodite, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickSlateMeurodite });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickSlateMeurodite });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickSlateMeurodite, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.graniteSlateMeurodite2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeuroditeStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeuroditeStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeuroditeStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.graniteSlateMeurodite, 1, 3) });
		
		// Plating Recipes for Slate Decor
		Object[] rawSlate = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), rawSlate);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), rawSlate);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), rawSlate);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), rawSlate);
		Object[] rawSlateSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate2, 1, 3) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 9, 3), new ItemStack(MItems.plateTinItem, 1, 0), rawSlateSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 9, 3), new ItemStack(MItems.plateBronzeItem, 1, 0), rawSlateSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 9, 3), new ItemStack(MItems.plateSteelItem, 1, 0), rawSlateSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 9, 3), new ItemStack(MItems.plateMeuroditeItem, 1, 0), rawSlateSlab);
		Object[] slateBrick = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MItems.brickSlate, 1, 0) };
		this.addRecipe(new ItemStack(MItems.brickSlateTin, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slateBrick);
		this.addRecipe(new ItemStack(MItems.brickSlateBronze, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slateBrick);
		this.addRecipe(new ItemStack(MItems.brickSlateSteel, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slateBrick);
		this.addRecipe(new ItemStack(MItems.brickSlateMeurodite, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateBrick);
		Object[] slateBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate, 1, 1) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 9, 1), new ItemStack(MItems.plateTinItem, 1, 0), slateBricks);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 9, 1), new ItemStack(MItems.plateBronzeItem, 1, 0), slateBricks);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 9, 1), new ItemStack(MItems.plateSteelItem, 1, 0), slateBricks);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 9, 1), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateBricks);
		Object[] slateBrickSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate2, 1, 6) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 9, 6), new ItemStack(MItems.plateTinItem, 1, 0), slateBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 9, 6), new ItemStack(MItems.plateBronzeItem, 1, 0), slateBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 9, 6), new ItemStack(MItems.plateSteelItem, 1, 0), slateBrickSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 9, 6), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateBrickSlab);
		Object[] slatePatternBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate, 1, 2) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 9, 2), new ItemStack(MItems.plateTinItem, 1, 0), slatePatternBricks);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 9, 2), new ItemStack(MItems.plateBronzeItem, 1, 0), slatePatternBricks);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 9, 2), new ItemStack(MItems.plateSteelItem, 1, 0), slatePatternBricks);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 9, 2), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slatePatternBricks);
		Object[] slateRoad = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate, 1, 4) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 9, 4), new ItemStack(MItems.plateTinItem, 1, 0), slateRoad);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 9, 4), new ItemStack(MItems.plateBronzeItem, 1, 0), slateRoad);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 9, 4), new ItemStack(MItems.plateSteelItem, 1, 0), slateRoad);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 9, 4), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateRoad);
		Object[] refinedSlate = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate, 1, 5) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 9, 5), new ItemStack(MItems.plateTinItem, 1, 0), refinedSlate);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 9, 5), new ItemStack(MItems.plateBronzeItem, 1, 0), refinedSlate);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 9, 5), new ItemStack(MItems.plateSteelItem, 1, 0), refinedSlate);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 9, 5), new ItemStack(MItems.plateMeuroditeItem, 1, 0), refinedSlate);
		Object[] refinedSlateSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate2, 1, 12) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 9, 12), new ItemStack(MItems.plateTinItem, 1, 0), refinedSlateSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 9, 12), new ItemStack(MItems.plateBronzeItem, 1, 0), refinedSlateSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 9, 12), new ItemStack(MItems.plateSteelItem, 1, 0), refinedSlateSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 9, 12), new ItemStack(MItems.plateMeuroditeItem, 1, 0), refinedSlateSlab);
		Object[] slateTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate, 1, 3) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 9, 3), new ItemStack(MItems.plateTinItem, 1, 0), slateTiles);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 9, 3), new ItemStack(MItems.plateBronzeItem, 1, 0), slateTiles);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 9, 3), new ItemStack(MItems.plateSteelItem, 1, 0), slateTiles);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 9, 3), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateTiles);
		Object[] slateTileSlab = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate2, 1, 9) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 9, 9), new ItemStack(MItems.plateTinItem, 1, 0), slateTileSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 9, 9), new ItemStack(MItems.plateBronzeItem, 1, 0), slateTileSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 9, 9), new ItemStack(MItems.plateSteelItem, 1, 0), slateTileSlab);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 9, 9), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateTileSlab);
		Object[] slatePillar = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate2, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin2, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slatePillar);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze2, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slatePillar);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel2, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slatePillar);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite2, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slatePillar);
		Object[] slateChiseled = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlate, 1, 6) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTin, 9, 6), new ItemStack(MItems.plateTinItem, 1, 0), slateChiseled);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronze, 9, 6), new ItemStack(MItems.plateBronzeItem, 1, 0), slateChiseled);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteel, 9, 6), new ItemStack(MItems.plateSteelItem, 1, 0), slateChiseled);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeurodite, 9, 6), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateChiseled);
		Object[] slateStairsRaw = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlateStairsRaw, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTinStairsRaw, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slateStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronzeStairsRaw, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slateStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteelStairsRaw, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slateStairsRaw);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeuroditeStairsRaw, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateStairsRaw);
		Object[] slateStairsBricks = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlateStairsBricks, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTinStairsBricks, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slateStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronzeStairsBricks, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slateStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteelStairsBricks, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slateStairsBricks);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeuroditeStairsBricks, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateStairsBricks);
		Object[] slateStairsTiles = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MBlocks.graniteSlateStairsTiles, 1, 0) };
		this.addRecipe(new ItemStack(MBlocks.graniteSlateTinStairsTiles, 9, 0), new ItemStack(MItems.plateTinItem, 1, 0), slateStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateBronzeStairsTiles, 9, 0), new ItemStack(MItems.plateBronzeItem, 1, 0), slateStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateSteelStairsTiles, 9, 0), new ItemStack(MItems.plateSteelItem, 1, 0), slateStairsTiles);
		this.addRecipe(new ItemStack(MBlocks.graniteSlateMeuroditeStairsTiles, 9, 0), new ItemStack(MItems.plateMeuroditeItem, 1, 0), slateStairsTiles);
		
		// Desert Quartz Decor
		this.addRecipe(new ItemStack(MBlocks.desertQuartz2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickDesertQuartz, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickDesertQuartz });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.desertQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickDesertQuartz });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz, 3, 6), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickDesertQuartz, 'D', new ItemStack(Blocks.sand, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz, 9, 7), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.desertQuartz, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz, 4, 5), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.desertQuartz, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz, 4, 4), null, new Object[] { "TTT", "TST", "TTT", 'T', new ItemStack(MBlocks.desertQuartz, 1, 3), 'S', Blocks.stone });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.desertQuartz, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.desertQuartz, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartz, 1, 8), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.desertQuartz2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartzStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.desertQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartzStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.desertQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.desertQuartzStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.desertQuartz, 1, 3) });
		
		// Netherrack Decor
		this.addRecipe(new ItemStack(MBlocks.netherrack2, 6, 3), null, new Object[] { "NNN", 'N', Blocks.netherrack });
		this.addRecipe(new ItemStack(Blocks.nether_brick, 1, 0), null, new Object[] { "BB", "BB", 'B', Items.netherbrick });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 6), null, new Object[] { "SSS", 'S', Blocks.nether_brick });
		this.addRecipe(new ItemStack(Blocks.nether_brick_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', Blocks.nether_brick });
		this.addRecipe(new ItemStack(Blocks.nether_brick_fence, 6, 0), null, new Object[] { "BBB", "BBB", 'B', Blocks.nether_brick });
		this.addRecipe(new ItemStack(MBlocks.netherrack, 1, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', Items.netherbrick });
		this.addRecipe(new ItemStack(MBlocks.netherrack, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', Items.netherbrick, 'D', Blocks.soul_sand });
		this.addRecipe(new ItemStack(MBlocks.netherrack, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.netherrack });
		this.addRecipe(new ItemStack(MBlocks.netherrack2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.netherrack, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.netherrack, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.netherrack, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.netherrack2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.netherrack, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.netherrack2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.netherrack, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.netherrack, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.netherrack2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.netherrackStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.netherrack, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.netherrackStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.netherrack, 1, 3) });
		
		// Nether Quartz Decor
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 7), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.quartz_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickNetherQuartz, 4, 0), null, new Object[] { "S", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickNetherQuartz });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.netherQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickNetherQuartz });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickNetherQuartz, 'D', Blocks.soul_sand });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.netherQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.netherQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.netherQuartz, 1, 3) });
		this.addRecipe(new ItemStack(Blocks.quartz_block, 2, 2), null, new Object[] { "Q", "Q", 'Q', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.netherQuartz, 1, 5) });
		this.addRecipe(new ItemStack(Blocks.quartz_block, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.netherQuartz, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.netherQuartz2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.netherQuartzStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.netherQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.netherQuartzStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.netherQuartz, 1, 3) });
		
		// Obsidian Decor
		this.addRecipe(new ItemStack(MBlocks.obsidian2, 6, 3), null, new Object[] { "SSS", 'S', Blocks.obsidian });
		this.addRecipe(new ItemStack(MItems.brickObsidian, 4, 0), null, new Object[] { "S", 'S', Blocks.obsidian });
		this.addRecipe(new ItemStack(MBlocks.obsidian, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickObsidian });
		this.addRecipe(new ItemStack(MBlocks.obsidian2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.obsidian, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.obsidian, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickObsidian });
		this.addRecipe(new ItemStack(MBlocks.obsidian, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickObsidian, 'D', Blocks.end_stone });
		this.addRecipe(new ItemStack(MBlocks.obsidian, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.obsidian });
		this.addRecipe(new ItemStack(MBlocks.obsidian2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.obsidian, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.obsidian, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.obsidian, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.obsidian2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.obsidian, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.obsidian2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.obsidian, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.obsidian, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.obsidian2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.obsidianStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.obsidian, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.obsidianStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.obsidian, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.obsidianStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.obsidian, 1, 3) });
		
		// End Stone Decor
		this.addRecipe(new ItemStack(MBlocks.endstone2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.endstone, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickEndStone, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.endstone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.endstone, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickEndStone });
		this.addRecipe(new ItemStack(MBlocks.endstone2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.endstone, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.endstone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickEndStone });
		this.addRecipe(new ItemStack(MBlocks.endstone, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickEndStone, 'D', Blocks.obsidian });
		this.addRecipe(new ItemStack(MBlocks.endstone, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.endstone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.endstone2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.endstone, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.endstone, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.endstone, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.endstone2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.endstone, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.endstone2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.endstone, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.endstone, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.endstone2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.endstoneStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.endstone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.endstoneStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.endstone, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.endstoneStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.endstone, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.endstoneStairsCracked, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.end_stone, 1, 0) });
		
		// Bedrock Decor
		this.addRecipe(new ItemStack(MBlocks.bedrock2, 6, 3), null, new Object[] { "SSS", 'S', Blocks.bedrock });
		this.addRecipe(new ItemStack(MItems.brickBedrock, 4, 0), null, new Object[] { "S", 'S', Blocks.bedrock });
		this.addRecipe(new ItemStack(MBlocks.bedrock, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickBedrock });
		this.addRecipe(new ItemStack(MBlocks.bedrock2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.bedrock, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.bedrock, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickBedrock });
		this.addRecipe(new ItemStack(MBlocks.bedrock, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickBedrock, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.bedrock, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.bedrock });
		this.addRecipe(new ItemStack(MBlocks.bedrock2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.bedrock, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.bedrock, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.bedrock, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.bedrock2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.bedrock, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.bedrock2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.bedrock, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.bedrock, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.bedrock2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.bedrock, 8, 14), null, new Object[] { "CCC", "CGC", "CCC", 'C', new ItemStack(MBlocks.bedrock, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.bedrock, 8, 15), null, new Object[] { "CCC", "CSC", "CCC", 'C', new ItemStack(MBlocks.bedrock, 1, 6), 'S', MBlocks.sunstoneBlock });
		this.addRecipe(new ItemStack(MBlocks.bedrockStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(Blocks.bedrock, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.bedrockStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.bedrock, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.bedrockStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.bedrock, 1, 3) });
		
		// Radiant Quartz Decor
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.radiantQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MItems.brickRadiantQuartz, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.radiantQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.brickRadiantQuartz });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz2, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.radiantQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.brickRadiantQuartz });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', MItems.brickRadiantQuartz, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(MBlocks.radiantQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MBlocks.radiantQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MBlocks.radiantQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MBlocks.radiantQuartz, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MBlocks.radiantQuartz, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartz, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.radiantQuartz2, 1, 12) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartzStairsRaw, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.radiantQuartz, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartzStairsBricks, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.radiantQuartz, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.radiantQuartzStairsTiles, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.radiantQuartz, 1, 3) });
		
		// Checkered Tiles
		this.addRecipe(new ItemStack(MBlocks.checkerTiles, 4, 0), null, new Object[] { "BW", "WB", 'B', new ItemStack(MBlocks.flint, 1, 3), 'W', new ItemStack(MBlocks.endstone, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.checkerTiles, 4, 1), null, new Object[] { "BW", "WB", 'B', new ItemStack(MBlocks.flint, 1, 3), 'W', new ItemStack(MBlocks.netherQuartz, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.checkerTiles, 4, 2), null, new Object[] { "BW", "WB", 'B', new ItemStack(MBlocks.obsidian, 1, 3), 'W', new ItemStack(MBlocks.endstone, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.checkerTiles, 4, 3), null, new Object[] { "BW", "WB", 'B', new ItemStack(MBlocks.obsidian, 1, 3), 'W', new ItemStack(MBlocks.netherQuartz, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.flintEndstoneStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.checkerTiles, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.flintQuartzStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.checkerTiles, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.obsidianEndstoneStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.checkerTiles, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.obsidianQuartzStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', new ItemStack(MBlocks.checkerTiles, 1, 3) });
		
		// Edge Stone Brick
		this.addRecipe(new ItemStack(edgeStoneBrick, 1, 0), null, new Object[] { "SQ", "SQ", 'S', MItems.brickStone, 'Q', MItems.brickNetherQuartz });
		this.addRecipe(new ItemStack(edgeStoneBrick, 1, 1), null, new Object[] { "SQ", "SQ", 'S', MItems.brickStone, 'Q', MItems.brickFlint });
		
		// Misc
		this.addRecipe(new ItemStack(Blocks.anvil, 1, 0), null, new Object[] { "III", " S ", "SSS", 'I', Blocks.iron_block, 'S', MItems.steelIngot });
		this.addShapelessRecipe(new ItemStack(MTools.soulsteelAxe), new ItemStack(MItems.soulGem), new Object[] { MTools.steelAxe });
		this.addShapelessRecipe(new ItemStack(MTools.soulsteelHoe), new ItemStack(MItems.soulGem), new Object[] { MTools.steelHoe });
		this.addShapelessRecipe(new ItemStack(MTools.soulsteelPickaxe), new ItemStack(MItems.soulGem), new Object[] { MTools.steelPickaxe });
		this.addShapelessRecipe(new ItemStack(MTools.soulsteelShovel), new ItemStack(MItems.soulGem), new Object[] { MTools.steelShovel });
		this.addShapelessRecipe(new ItemStack(MTools.soulsteelSword), new ItemStack(MItems.soulGem), new Object[] { MTools.steelSword });
	}
	
	public ShapedCuttingRecipe addRecipe(ItemStack output, ItemStack extraSlot, Object... data)
	{
		ShapedCuttingRecipe recipe = new ShapedCuttingRecipe(output, extraSlot, data);
		this.recipes.add(recipe);
		this.listSorted = false;
		return recipe;
	}
	
	public ShapelessCuttingRecipe addShapelessRecipe(ItemStack stack, ItemStack extra, Object... data)
	{
		ShapelessCuttingRecipe recipe = new ShapelessCuttingRecipe(stack, extra, data);
		this.recipes.add(recipe);
		return recipe;
	}
	
	public ItemStack findMatchingRecipe(InventoryCrafting inventory, ItemStack extra, World world)
	{
		for (ICuttingRecipe recipe : this.getRecipeList())
		{
			if (recipe.matches(inventory, extra, world))
			{
				return recipe.getCraftingResult(inventory, extra);
			}
		}
		
		return null;
	}
	
	public List<ICuttingRecipe> getRecipeList()
	{
		if (!this.listSorted)
		{
			Collections.sort(this.recipes, new Comparator<ICuttingRecipe>()
			{
				@Override
				public int compare(ICuttingRecipe recipe1, ICuttingRecipe recipe2)
				{
					boolean flag1 = recipe1 instanceof ShapedCuttingRecipe;
					boolean flag2 = recipe1 instanceof ShapelessCuttingRecipe;
					boolean flag3 = recipe2 instanceof ShapedCuttingRecipe;
					boolean flag4 = recipe2 instanceof ShapelessCuttingRecipe;
					return flag2 && flag3 ? 1 : flag4 && flag1 ? -1 : recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0;
				}
			});
			
			this.listSorted = true;
		}
		
		return this.recipes;
	}
}
