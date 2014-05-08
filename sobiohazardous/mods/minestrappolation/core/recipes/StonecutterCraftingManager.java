package sobiohazardous.mods.minestrappolation.core.recipes;

import java.util.*;

<<<<<<< HEAD
import sobiohazardous.mods.minestrappolation.core.lib.MItems;
import sobiohazardous.mods.minestrappolation.core.tileentity.InventoryStonecutterExtraSlot;
=======
>>>>>>> clashsoft
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StonecutterCraftingManager
{
<<<<<<< HEAD
    /** The static instance of this class */
    public static final StonecutterCraftingManager instance = new StonecutterCraftingManager();

    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    
    /**
     * Returns the static instance of this class
     */
    public static final StonecutterCraftingManager getInstance()
    {
        return instance;
    }

    private StonecutterCraftingManager()
    {
        //add recipes
    	this.addRecipe(new ItemStack(Items.stick, 1), new ItemStack(Items.stick, 1), new Object[]{" S ", " S ", " S ", 'S', Items.stick});
    	
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 15), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 1), new ItemStack(Items.dye, 1, 14), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 2), new ItemStack(Items.dye, 1, 13), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 3), new ItemStack(Items.dye, 1, 12), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 4), new ItemStack(Items.dye, 1, 11), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 5), new ItemStack(Items.dye, 1, 10), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 6), new ItemStack(Items.dye, 1, 9), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 7), new ItemStack(Items.dye, 1, 8), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 8), new ItemStack(Items.dye, 1, 7), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 9), new ItemStack(Items.dye, 1, 6), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 10), new ItemStack(Items.dye, 1, 5), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 11), new ItemStack(Items.dye, 1, 4), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 12), new ItemStack(Items.dye, 1, 3), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 13), new ItemStack(Items.dye, 1, 2), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 14), new ItemStack(Items.dye, 1, 1), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 15), new ItemStack(Items.dye, 1, 0), new Object[]{"CCC", "CCC", "CCC", 'C', Blocks.hardened_clay});
    	
    	//this.addRecipe(new ItemStack(MItems.brickStone, 4), null, new Object[]{"S", 'S', Blocks.stone});
    	
    	Collections.sort(this.recipes, new Comparator()
        {
            public int compare(IStonecutterRecipe par1IRecipe, IStonecutterRecipe par2IRecipe)
            {
                return par1IRecipe instanceof StonecutterShapelessRecipes && par2IRecipe instanceof StonecutterShapedRecipes ? 1 : (par2IRecipe instanceof StonecutterShapelessRecipes && par1IRecipe instanceof StonecutterShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
            }
            public int compare(Object par1Obj, Object par2Obj)
            {
                return this.compare((IStonecutterRecipe)par1Obj, (IStonecutterRecipe)par2Obj);
            }
        });    
    }

    StonecutterShapedRecipes addRecipe(ItemStack par1ItemStack, ItemStack extraSlot, Object ... par2ArrayOfObj)
    {
    	String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        if (par2ArrayOfObj[var4] instanceof String[])
        {
            String[] var7 = (String[])((String[])par2ArrayOfObj[var4++]);

            for (int var8 = 0; var8 < var7.length; ++var8)
            {
                String var9 = var7[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        }
        else
        {
            while (par2ArrayOfObj[var4] instanceof String)
            {
                String var11 = (String)par2ArrayOfObj[var4++];
                ++var6;
                var5 = var11.length();
                var3 = var3 + var11;
            }
        }

        HashMap var12;

        for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2)
        {
            Character var13 = (Character)par2ArrayOfObj[var4];
            ItemStack var14 = null;

            if (par2ArrayOfObj[var4 + 1] instanceof Item)
            {
                var14 = new ItemStack((Item)par2ArrayOfObj[var4 + 1]);
            }
            else if (par2ArrayOfObj[var4 + 1] instanceof Block)
            {
                var14 = new ItemStack((Block)par2ArrayOfObj[var4 + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack)
            {
                var14 = (ItemStack)par2ArrayOfObj[var4 + 1];
            }

            var12.put(var13, var14);
        }

        ItemStack[] var15 = new ItemStack[var5 * var6];

        for (int var16 = 0; var16 < var5 * var6; ++var16)
        {
            char var10 = var3.charAt(var16);

            if (var12.containsKey(Character.valueOf(var10)))
            {
                var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
            }
            else
            {
                var15[var16] = null;
            }
        }

        StonecutterShapedRecipes var17 = new StonecutterShapedRecipes(var5, var6, var15, par1ItemStack, extraSlot);
        this.recipes.add(var17);
        return var17;
    }

    void addShapelessRecipe(ItemStack par1ItemStack, ItemStack extra, Object ... par2ArrayOfObj)
    {
        ArrayList var3 = new ArrayList();
        Object[] var4 = par2ArrayOfObj;
        int var5 = par2ArrayOfObj.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            Object var7 = var4[var6];

            if (var7 instanceof ItemStack)
            {
                var3.add(((ItemStack)var7).copy());
            }
            else if (var7 instanceof Item)
            {
                var3.add(new ItemStack((Item)var7));
            }
            else
            {
                if (!(var7 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                var3.add(new ItemStack((Block)var7));
            }
        }

        this.recipes.add(new StonecutterShapelessRecipes(par1ItemStack, var3, extra));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, InventoryStonecutterExtraSlot extra, World par2World)
    {
    	int var3 = 0;
        ItemStack var4 = null;
        ItemStack var5 = null;
        int var6;

        for (var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6)
        {
            ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

            if (var7 != null)
            {
                if (var3 == 0)
                {
                    var4 = var7;
                }

                if (var3 == 1)
                {
                    var5 = var7;
                }

                ++var3;
            }
        }

        if (var3 == 2 && var4.getItem() == var5.getItem() && var4.stackSize == 1 && var5.stackSize == 1 && var4.getItem().isDamageable())
        {
            Item var11 = var4.getItem();
            int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
            int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
            int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
            int var10 = var11.getMaxDamage() - var9;

            if (var10 < 0)
            {
                var10 = 0;
            }

            return new ItemStack(var4.getItem(), 1, var10);
        }
        else
        {
            for (var6 = 0; var6 < this.recipes.size(); ++var6)
            {
                IStonecutterRecipe var12 = (IStonecutterRecipe)this.recipes.get(var6);
                if (var12.matches(par1InventoryCrafting, extra, par2World))
                {
                    return var12.getCraftingResult(par1InventoryCrafting, extra);
                }
            }

            return null;
        }
    }
    
    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
=======
	/** The static instance of this class */
	public static final StonecutterCraftingManager	instance	= new StonecutterCraftingManager();
	
	/** A list of all the recipes added */
	private List									recipes		= new ArrayList();
	
	private StonecutterCraftingManager()
	{
		// add recipes
		this.addRecipe(new ItemStack(Items.stick, 1), new ItemStack(Items.stick, 1), new Object[] { " S ", " S ", " S ", 'S', Items.stick });
		
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 15), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 1), new ItemStack(Items.dye, 1, 14), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 2), new ItemStack(Items.dye, 1, 13), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 3), new ItemStack(Items.dye, 1, 12), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 4), new ItemStack(Items.dye, 1, 11), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 5), new ItemStack(Items.dye, 1, 10), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 6), new ItemStack(Items.dye, 1, 9), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 7), new ItemStack(Items.dye, 1, 8), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 8), new ItemStack(Items.dye, 1, 7), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 9), new ItemStack(Items.dye, 1, 6), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 10), new ItemStack(Items.dye, 1, 5), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 11), new ItemStack(Items.dye, 1, 4), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 12), new ItemStack(Items.dye, 1, 3), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 13), new ItemStack(Items.dye, 1, 2), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 14), new ItemStack(Items.dye, 1, 1), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 15), new ItemStack(Items.dye, 1, 0), new Object[] { "CCC", "CCC", "CCC", 'C', Blocks.hardened_clay });
		
		Collections.sort(this.recipes, new Comparator()
		{
			public int compare(IStonecutterRecipe recipe1, IStonecutterRecipe recipe2)
			{
				boolean flag1 = recipe1 instanceof StonecutterShapedRecipes;
				boolean flag2 = recipe1 instanceof StonecutterShapelessRecipes;
				boolean flag3 = recipe2 instanceof StonecutterShapedRecipes;
				boolean flag4 = recipe2 instanceof StonecutterShapelessRecipes;
				return flag2 && flag3 ? 1 : flag4 && flag1 ? -1 : recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0;
			}
			
			@Override
			public int compare(Object o1, Object o2)
			{
				return this.compare((IStonecutterRecipe) o1, (IStonecutterRecipe) o2);
			}
		});
	}
	
	public StonecutterShapedRecipes addRecipe(ItemStack stack, ItemStack extraSlot, Object... data)
	{
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
		
		StonecutterShapedRecipes recipe = new StonecutterShapedRecipes(width, height, stacks, stack, extraSlot);
		this.recipes.add(recipe);
		return recipe;
	}
	
	public StonecutterShapelessRecipes addShapelessRecipe(ItemStack stack, ItemStack extra, Object... data)
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
		
		StonecutterShapelessRecipes recipe = new StonecutterShapelessRecipes(stack, list, extra);
		this.recipes.add(recipe);
		return recipe;
	}
	
	public ItemStack findMatchingRecipe(InventoryCrafting inventory, ItemStack extra, World world)
	{
		for (int i = 0; i < this.recipes.size(); ++i)
		{
			IStonecutterRecipe recipe = (IStonecutterRecipe) this.recipes.get(i);
			if (recipe.matches(inventory, extra, world))
			{
				return recipe.getCraftingResult(inventory, extra);
			}
		}
		
		return null;
	}
	
	public List getRecipeList()
	{
		return this.recipes;
	}
>>>>>>> clashsoft
}
