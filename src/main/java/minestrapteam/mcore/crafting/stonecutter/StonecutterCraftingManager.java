package minestrapteam.mcore.crafting.stonecutter;

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
		Object[] mossyCobblestone = new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(Blocks.mossy_cobblestone, 1, 0) };
		this.addRecipe(new ItemStack(MCBlocks.stoneTin, 9, 8), new ItemStack(MItems.plateTinItem, 1, 0), mossyCobblestone);
		this.addRecipe(new ItemStack(MCBlocks.stoneBronze, 9, 8), new ItemStack(MItems.plateBronzeItem, 1, 0), mossyCobblestone);
		this.addRecipe(new ItemStack(MCBlocks.stoneSteel, 9, 8), new ItemStack(MItems.plateSteelItem, 1, 0), mossyCobblestone);
		this.addRecipe(new ItemStack(MCBlocks.stoneMeurodite, 9, 8), new ItemStack(MItems.plateMeuroditeItem, 1, 0), mossyCobblestone);
		
		// Sandstone Decor
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 1), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
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
		
		// Hardened Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.clay2, 6, 3), null, new Object[] { "SSS", 'S', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Items.brick, 4, 0), null, new Object[] { "S", 'S', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.brick_block, 1, 0), null, new Object[] { "BB", "BB", 'B', Items.brick });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 4), null, new Object[] { "SSS", 'S', Blocks.brick_block });
		this.addRecipe(new ItemStack(MCBlocks.clay, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', Items.brick });
		this.addRecipe(new ItemStack(MCBlocks.clay, 3, 4), null, new Object[] { "BBB", "BBB", "DDD", 'B', Items.brick, 'D', new ItemStack(Blocks.dirt, 1, 0) });
		this.addRecipe(new ItemStack(MCBlocks.clay, 9, 5), null, new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(MCBlocks.clay2, 6, 12), null, new Object[] { "RRR", 'R', new ItemStack(MCBlocks.clay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.clay, 4, 3), null, new Object[] { "RR", "RR", 'R', new ItemStack(MCBlocks.clay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.clay2, 6, 9), null, new Object[] { "TTT", 'T', new ItemStack(MCBlocks.clay, 1, 3) });
		this.addRecipe(new ItemStack(MCBlocks.clay2, 2, 0), null, new Object[] { "R", "R", 'R', new ItemStack(MCBlocks.clay, 1, 5) });
		this.addRecipe(new ItemStack(MCBlocks.clay, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MCBlocks.clay2, 1, 12) });
		
		// White Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.whiteClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 0) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 14), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 0) });
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
		
		// Light Grey Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.silverClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 8) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 13), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 8) });
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
		
		// Grey Stained Clay Decor (Commented out until Grey Stained Clay blocks
		// are added.)
		/*
		 * this.addRecipe(new ItemStack(MCBlocks.greyClay2, 6, 3), null, new
		 * Object[] {"SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1,
		 * 7)}); this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 4),
		 * null, new Object[] {"S", 'S', new
		 * ItemStack(Blocks.stained_hardened_clay, 1, 7)}); this.addRecipe(new
		 * ItemStack(MCBlocks.greyClay, 1, 1), null, new Object[] {"BB", "BB",
		 * 'B', new ItemStack(MCItems.brickColoredClay, 1, 4)});
		 * this.addRecipe(new ItemStack(MCBlocks.greyClay2, 6, 6), null, new
		 * Object[] {"SSS", 'S', new ItemStack(MCBlocks.greyClay, 1, 1)});
		 * this.addRecipe(new ItemStack(MCBlocks.greyClay, 2, 2), null, new
		 * Object[] {"BBB", "BBB", "BBB", 'B', new
		 * ItemStack(MCItems.brickColoredClay, 1, 4)}); this.addRecipe(new
		 * ItemStack(MCBlocks.greyClay, 3, 4), null, new Object[] {"BBB", "BBB",
		 * "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 4), 'D', new
		 * ItemStack(Blocks.dirt, 1, 0)}); this.addRecipe(new
		 * ItemStack(MCBlocks.greyClay, 9, 5), null, new Object[] {"SSS", "SSS",
		 * "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 7)});
		 * this.addRecipe(new ItemStack(MCBlocks.greyClay2, 6, 12), null, new
		 * Object[] {"RRR", 'R', new ItemStack(MCBlocks.greyClay, 1, 5)});
		 * this.addRecipe(new ItemStack(MCBlocks.greyClay, 4, 3), null, new
		 * Object[] {"RR", "RR", 'R', new ItemStack(MCBlocks.greyClay, 1, 5)});
		 * this.addRecipe(new ItemStack(MCBlocks.greyClay2, 6, 9), null, new
		 * Object[] {"TTT", 'T', new ItemStack(MCBlocks.greyClay, 1, 3)});
		 * this.addRecipe(new ItemStack(MCBlocks.greyClay2, 2, 0), null, new
		 * Object[] {"R", "R", 'R', new ItemStack(MCBlocks.greyClay, 1, 5)});
		 * this.addRecipe(new ItemStack(MCBlocks.greyClay, 1, 6), null, new
		 * Object[] {"S", "S", 'S', new ItemStack(MCBlocks.greyClay2, 1, 12)});
		 */
		
		// Black Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.blackClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 15) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 0), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 15) });
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
		
		// Brown Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.brownClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 12) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 2), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 12) });
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
		
		// Pink Stained Clay
		this.addRecipe(new ItemStack(MCBlocks.pinkClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 6) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 10), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 6) });
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
		
		// Red Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.redClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 14) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 12), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 14) });
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
		
		// Orange Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.orangeClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 1) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 9), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 1) });
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
		
		// Yellow Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.yellowClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 4) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 15), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 4) });
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
		
		// Lime Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.limeClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 5) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 7), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 5) });
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
		
		// Green Stained Clay Decor (Commented out until Green Stained Clay
		// blocks are added.)
		/*
		 * this.addRecipe(new ItemStack(MCBlocks.greenClay2, 6, 3), null, new
		 * Object[] {"SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1,
		 * 13)}); this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 5),
		 * null, new Object[] {"S", 'S', new
		 * ItemStack(Blocks.stained_hardened_clay, 1, 13)}); this.addRecipe(new
		 * ItemStack(MCBlocks.greenClay, 1, 1), null, new Object[] {"BB", "BB",
		 * 'B', new ItemStack(MCItems.brickColoredClay, 1, 5)});
		 * this.addRecipe(new ItemStack(MCBlocks.greenClay2, 6, 6), null, new
		 * Object[] {"SSS", 'S', new ItemStack(MCBlocks.greenClay, 1, 1)});
		 * this.addRecipe(new ItemStack(MCBlocks.greenClay, 2, 2), null, new
		 * Object[] {"BBB", "BBB", "BBB", 'B', new
		 * ItemStack(MCItems.brickColoredClay, 1, 5)}); this.addRecipe(new
		 * ItemStack(MCBlocks.greenClay, 3, 4), null, new Object[] {"BBB",
		 * "BBB", "DDD", 'B', new ItemStack(MCItems.brickColoredClay, 1, 5),
		 * 'D', new ItemStack(Blocks.dirt, 1, 0)}); this.addRecipe(new
		 * ItemStack(MCBlocks.greenClay, 9, 5), null, new Object[] {"SSS",
		 * "SSS", "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1,
		 * 13)}); this.addRecipe(new ItemStack(MCBlocks.greenClay2, 6, 12),
		 * null, new Object[] {"RRR", 'R', new ItemStack(MCBlocks.greenClay, 1,
		 * 5)}); this.addRecipe(new ItemStack(MCBlocks.greenClay, 4, 3), null,
		 * new Object[] {"RR", "RR", 'R', new ItemStack(MCBlocks.greenClay, 1,
		 * 5)}); this.addRecipe(new ItemStack(MCBlocks.greenClay2, 6, 9), null,
		 * new Object[] {"TTT", 'T', new ItemStack(MCBlocks.greenClay, 1, 3)});
		 * this.addRecipe(new ItemStack(MCBlocks.greenClay2, 2, 0), null, new
		 * Object[] {"R", "R", 'R', new ItemStack(MCBlocks.greenClay, 1, 5)});
		 * this.addRecipe(new ItemStack(MCBlocks.greenClay, 1, 6), null, new
		 * Object[] {"S", "S", 'S', new ItemStack(MCBlocks.greenClay2, 1, 12)});
		 */
		
		// Cyan Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.cyanClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 9) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 3), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 9) });
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
		
		// Light Blue Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.lightBlueClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 3) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 6), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 3) });
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
		
		// Blue Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.blueClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 11) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 1), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 11) });
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
		
		// Purple Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.purpleClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 10) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 11), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 10) });
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
		
		// Magenta Stained Clay Decor
		this.addRecipe(new ItemStack(MCBlocks.magentaClay2, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 2) });
		this.addRecipe(new ItemStack(MCItems.brickColoredClay, 4, 8), null, new Object[] { "S", 'S', new ItemStack(Blocks.stained_hardened_clay, 1, 2) });
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
		
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 6), null, new Object[] { "SSS", 'S', Blocks.nether_brick });
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 7), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.brick_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', Blocks.brick_block });
		this.addRecipe(new ItemStack(Blocks.stone_brick_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', new ItemStack(Blocks.stonebrick, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.nether_brick, 1, 0), null, new Object[] { "BB", "BB", 'B', Items.netherbrick });
		this.addRecipe(new ItemStack(Blocks.nether_brick_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', Blocks.nether_brick });
		this.addRecipe(new ItemStack(Blocks.nether_brick_fence, 6, 0), null, new Object[] { "BBB", "BBB", 'B', Blocks.nether_brick });
		this.addRecipe(new ItemStack(Blocks.sandstone_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.quartz_block, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab, 1, 7) });
		this.addRecipe(new ItemStack(Blocks.quartz_block, 2, 2), null, new Object[] { "Q", "Q", 'Q', new ItemStack(Blocks.quartz_block, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.quartz_stairs, 4, 0), null, new Object[] { "S  ", "SS ", "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0) });
		
		Object[] objects = new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay };
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 15), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 1), new ItemStack(Items.dye, 1, 14), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 2), new ItemStack(Items.dye, 1, 13), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 3), new ItemStack(Items.dye, 1, 12), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 4), new ItemStack(Items.dye, 1, 11), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 5), new ItemStack(Items.dye, 1, 10), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 6), new ItemStack(Items.dye, 1, 9), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 7), new ItemStack(Items.dye, 1, 8), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 8), new ItemStack(Items.dye, 1, 7), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 9), new ItemStack(Items.dye, 1, 6), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 10), new ItemStack(Items.dye, 1, 5), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 11), new ItemStack(Items.dye, 1, 4), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 12), new ItemStack(Items.dye, 1, 3), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 13), new ItemStack(Items.dye, 1, 2), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 14), new ItemStack(Items.dye, 1, 1), objects);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 15), new ItemStack(Items.dye, 1, 0), objects);
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
