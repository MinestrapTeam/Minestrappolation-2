package minestrapteam.minestrappolation.crafting.sawmill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SawingManager
{
	/** The static instance of this class */
	public static final SawingManager	instance	= new SawingManager();
	
	/** A list of all the recipes added */
	private List<ISawingRecipe>			recipes		= new ArrayList();
	private boolean						listSorted;
	
	private SawingManager()
	{
		this.addRecipe(new ItemStack(MBlocks.oak, 8, 3), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(Blocks.planks, 1, 0), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.spruce, 8, 3), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(Blocks.planks, 1, 1), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.birch, 8, 3), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(Blocks.planks, 1, 2), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.jungleWood, 8, 3), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(Blocks.planks, 1, 3), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.acacia, 8, 3), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(Blocks.planks, 1, 4), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.darkOak, 8, 3), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(Blocks.planks, 1, 5), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.redwood, 8, 4), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.redwood, 1, 0), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.oak, 8, 4), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.oak, 1, 1), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.spruce, 8, 4), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.spruce, 1, 1), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.birch, 8, 4), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.birch, 1, 1), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.jungleWood, 8, 4), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.jungleWood, 1, 1), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.acacia, 8, 4), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.acacia, 1, 1), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.darkOak, 8, 4), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.darkOak, 1, 1), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.redwood, 8, 5), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.redwood, 1, 2), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.oak, 8, 5), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.oak, 1, 2), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.spruce, 8, 5), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.spruce, 1, 2), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.birch, 8, 5), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.birch, 1, 2), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.jungleWood, 8, 5), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.jungleWood, 1, 2), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.acacia, 8, 5), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.acacia, 1, 2), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.darkOak, 8, 5), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.darkOak, 1, 2), 'V', Blocks.vine });
		this.addRecipe(new ItemStack(MBlocks.redwood, 8, 6), new Object[] { "PPP", "PVP", "PPP", 'P', new ItemStack(MBlocks.redwood, 1, 3), 'V', Blocks.vine });
		
		this.addRecipe(new ItemStack(MBlocks.oak, 16, 1), new Object[] { "LL", "LL", 'L', new ItemStack(Blocks.log, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.birch, 16, 1), new Object[] { "LL", "LL", 'L', new ItemStack(Blocks.log, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.spruce, 16, 1), new Object[] { "LL", "LL", 'L', new ItemStack(Blocks.log, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.jungleWood, 16, 1), new Object[] { "LL", "LL", 'L', new ItemStack(Blocks.log, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.acacia, 16, 1), new Object[] { "LL", "LL", 'L', new ItemStack(Blocks.log2, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.darkOak, 16, 1), new Object[] { "LL", "LL", 'L', new ItemStack(Blocks.log2, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.redwood, 16, 2), new Object[] { "LL", "LL", 'L', new ItemStack(MBlocks.redwoodLog, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.oak2, 6, 0), new Object[] { "BBB", 'B', new ItemStack(MBlocks.oak, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.birch2, 6, 0), new Object[] { "BBB", 'B', new ItemStack(MBlocks.birch, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.spruce2, 6, 0), new Object[] { "BBB", 'B', new ItemStack(MBlocks.spruce, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.jungleWood2, 6, 0), new Object[] { "BBB", 'B', new ItemStack(MBlocks.jungleWood, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.acacia2, 6, 0), new Object[] { "BBB", 'B', new ItemStack(MBlocks.acacia, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.darkOak2, 6, 0), new Object[] { "BBB", 'B', new ItemStack(MBlocks.darkOak, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.redwood2, 6, 0), new Object[] { "BBB", 'B', new ItemStack(MBlocks.redwood, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.oakStairsBoards, 4, 0), new Object[] { "B  ", "BB ", "BBB", 'B', new ItemStack(MBlocks.oak, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.birchStairsBoards, 4, 0), new Object[] { "B  ", "BB ", "BBB", 'B', new ItemStack(MBlocks.birch, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.spruceStairsBoards, 4, 0), new Object[] { "B  ", "BB ", "BBB", 'B', new ItemStack(MBlocks.spruce, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.jungleWoodStairsBoards, 4, 0), new Object[] { "B  ", "BB ", "BBB", 'B', new ItemStack(MBlocks.jungleWood, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.acaciaStairsBoards, 4, 0), new Object[] { "B  ", "BB ", "BBB", 'B', new ItemStack(MBlocks.acacia, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.darkOakStairsBoards, 4, 0), new Object[] { "B  ", "BB ", "BBB", 'B', new ItemStack(MBlocks.darkOak, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.redwoodStairsBoards, 4, 0), new Object[] { "B  ", "BB ", "BBB", 'B', new ItemStack(MBlocks.redwood, 1, 1) });
		
		this.addRecipe(new ItemStack(MBlocks.oak, 4, 0), new Object[] { "PP", "PP", 'P', new ItemStack(MBlocks.oak, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.birch, 4, 0), new Object[] { "PP", "PP", 'P', new ItemStack(MBlocks.birch, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.spruce, 4, 0), new Object[] { "PP", "PP", 'P', new ItemStack(MBlocks.spruce, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.jungleWood, 4, 0), new Object[] { "PP", "PP", 'P', new ItemStack(MBlocks.jungleWood, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.acacia, 4, 0), new Object[] { "PP", "PP", 'P', new ItemStack(MBlocks.acacia, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.darkOak, 4, 0), new Object[] { "PP", "PP", 'P', new ItemStack(MBlocks.darkOak, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.redwood, 4, 1), new Object[] { "PP", "PP", 'P', new ItemStack(MBlocks.redwood, 1, 3) });
	}
	
	public ShapedSawingRecipe addRecipe(ItemStack output, Object... data)
	{
		ShapedSawingRecipe recipe = new ShapedSawingRecipe(output, data);
		this.recipes.add(recipe);
		this.listSorted = false;
		return recipe;
	}
	
	public ShapelessSawingRecipe addShapelessRecipe(ItemStack stack, Object... data)
	{
		ShapelessSawingRecipe recipe = new ShapelessSawingRecipe(stack, data);
		this.recipes.add(recipe);
		return recipe;
	}
	
	public ItemStack findMatchingRecipe(InventoryCrafting inventory, World world)
	{
		for (ISawingRecipe recipe : this.getRecipeList())
		{
			if (recipe.matches(inventory, world))
			{
				return recipe.getCraftingResult(inventory);
			}
		}
		
		return null;
	}
	
	public List<ISawingRecipe> getRecipeList()
	{
		if (!this.listSorted)
		{
			Collections.sort(this.recipes, new Comparator<ISawingRecipe>()
			{
				@Override
				public int compare(ISawingRecipe recipe1, ISawingRecipe recipe2)
				{
					boolean flag1 = recipe1 instanceof ShapedSawingRecipe;
					boolean flag2 = recipe1 instanceof ShapelessSawingRecipe;
					boolean flag3 = recipe2 instanceof ShapedSawingRecipe;
					boolean flag4 = recipe2 instanceof ShapelessSawingRecipe;
					return flag2 && flag3 ? 1 : flag4 && flag1 ? -1 : recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0;
				}
			});
			
			this.listSorted = true;
		}
		
		return this.recipes;
	}
}
