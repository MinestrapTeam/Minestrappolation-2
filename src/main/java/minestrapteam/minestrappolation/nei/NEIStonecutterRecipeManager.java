package minestrapteam.minestrappolation.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import minestrapteam.minestrappolation.client.gui.GuiStonecutter;
import minestrapteam.minestrappolation.crafting.stonecutter.ISCRecipe;
import minestrapteam.minestrappolation.crafting.stonecutter.ShapedSCRecipe;
import minestrapteam.minestrappolation.crafting.stonecutter.StonecutterCraftingManager;
import minestrapteam.minestrappolation.util.MAssetManager;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.ShapedRecipeHandler;

public class NEIStonecutterRecipeManager extends ShapedRecipeHandler
{
	public class SCCachedShapedRecipe extends CachedRecipe
    {
        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;

        public SCCachedShapedRecipe(int width, int height, Object[] items, ItemStack out) {
            result = new PositionedStack(out, 119, 24);
            ingredients = new ArrayList<PositionedStack>();
            setIngredients(width, height, items);
        }

        public SCCachedShapedRecipe(ShapedSCRecipe recipe) {
            this(recipe.recipeWidth, recipe.recipeHeight, recipe.recipeItems, recipe.getRecipeOutput());
        }

		/**
         * @param width
         * @param height
         * @param items  an ItemStack[] or ItemStack[][]
         */
        public void setIngredients(int width, int height, Object[] items) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (items[y * width + x] == null)
                        continue;

                    PositionedStack stack = new PositionedStack(items[y * width + x], 25 + x * 18, 6 + y * 18, false);
                    stack.setMaxSize(1);
                    ingredients.add(stack);
                }
            }
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 20, ingredients);
        }

        public PositionedStack getResult() {
            return result;
        }

        public void computeVisuals() {
            for (PositionedStack p : ingredients)
                p.generatePermutations();
        }
    }
	
	@Override
    public String getGuiTexture() 
	{
        return MAssetManager.getTexture("textures/gui/container/stonecutter.png");
    }
	
	@Override
	public String getRecipeName()
	{
		return "Stonecutter";
	}
	
	@Override
	public void loadTransferRects()
	{
		transferRects.add(new RecipeTransferRect(new Rectangle(8, 35, 24, 26), "stonecutter"));
	}
	
	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiStonecutter.class;
	}
	
	@Override
	public boolean hasOverlay(GuiContainer gui, Container container, int recipe)
	{
		return false;
	}
	
	@Override
    public void loadUsageRecipes(ItemStack ingredient) 
	{
        for (ISCRecipe irecipe : (List<ISCRecipe>) StonecutterCraftingManager.instance.getRecipeList()) 
        {
            SCCachedShapedRecipe recipe = null;
            if (irecipe instanceof ShapedSCRecipe)
                recipe = new SCCachedShapedRecipe((ShapedSCRecipe) irecipe);

            if (recipe == null || !recipe.contains(recipe.ingredients, ingredient.getItem()))
                continue;

            recipe.computeVisuals();
            if (recipe.contains(recipe.ingredients, ingredient)) 
            {
                recipe.setIngredientPermutation(recipe.ingredients, ingredient);
                arecipes.add(recipe);
            }
        }
    }

	@Override
    public void loadCraftingRecipes(ItemStack result) 
	{
        for (ISCRecipe irecipe : (List<ISCRecipe>) StonecutterCraftingManager.instance.getRecipeList()) 
        {
            if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) 
            {
            	SCCachedShapedRecipe recipe = null;
                if (irecipe instanceof ISCRecipe)
                    recipe = new SCCachedShapedRecipe((ShapedSCRecipe) irecipe);

                if (recipe == null)
                    continue;

                recipe.computeVisuals();
                arecipes.add(recipe);
            }
        }
    }
}
