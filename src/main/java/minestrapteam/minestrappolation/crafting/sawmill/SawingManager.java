package minestrapteam.minestrappolation.crafting.sawmill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
		
	}
	
	public ShapedSawingRecipe addRecipe(ItemStack output, ItemStack extraSlot, Object... data)
	{
		ShapedSawingRecipe recipe = new ShapedSawingRecipe(output, extraSlot, data);
		this.recipes.add(recipe);
		this.listSorted = false;
		return recipe;
	}
	
	public ShapelessSawingRecipe addShapelessRecipe(ItemStack stack, ItemStack extra, Object... data)
	{
		ShapelessSawingRecipe recipe = new ShapelessSawingRecipe(stack, extra, data);
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
