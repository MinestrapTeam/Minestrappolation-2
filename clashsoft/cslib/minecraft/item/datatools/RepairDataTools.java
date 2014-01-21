package clashsoft.cslib.minecraft.item.datatools;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class RepairDataTools implements IRecipe
{
	@Override
	public boolean matches(InventoryCrafting inventorycrafting, World world)
	{
		ItemStack toolType = null;
		int itemsOfType = 0;
		for (int i = 0; i < inventorycrafting.getSizeInventory(); i++)
		{
			ItemStack stack = inventorycrafting.getStackInSlot(i);
			
			if (stack != null && stack.getItem() instanceof ItemDataTool)
			{
				if (toolType == null || (toolType == stack && ItemDataTool.getToolMaterialFromItemStack(stack) == ItemDataTool.getToolMaterialFromItemStack(toolType)))
				{
					toolType = stack;
					itemsOfType++;
					
					if (itemsOfType == 2)
						return true;
					else if (itemsOfType > 2)
						return false;
				}
				else
					return false;
			}
		}
		return false;
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting)
	{
		if (matches(inventorycrafting, null))
		{
			int maxDamage = -1;
			int damage1 = -1;
			int damage2 = -1;
			int resultdamage = -1;
			Item item = null;
			EnumToolMaterial material = null;
			
			for (int i = 0; i < inventorycrafting.getSizeInventory(); i++)
			{
				ItemStack stack = inventorycrafting.getStackInSlot(i);
				if (stack != null && stack.getItem() instanceof ItemDataTool)
				{
					maxDamage = stack.getMaxDamage();
					item = stack.getItem();
					material = ItemDataTool.getToolMaterialFromItemStack(stack);
					if (damage1 == -1)
						damage1 = stack.getItemDamage();
					else if (damage2 == -1)
						damage2 = stack.getItemDamage();
					else
					{
						resultdamage = (int) Math.min((float) maxDamage, (float) (MathHelper.floor_float(damage1 + damage2 + (maxDamage / 10F))));
						break;
					}
				}
			}
			return ItemDataTool.setToolMaterial(new ItemStack(item, 1, resultdamage), material);
		}
		return null;
	}
	
	@Override
	public int getRecipeSize()
	{
		return 9;
	}
	
	@Override
	public ItemStack getRecipeOutput()
	{
		return null;
	}
	
}
