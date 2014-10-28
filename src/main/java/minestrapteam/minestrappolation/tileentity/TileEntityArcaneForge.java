package minestrapteam.minestrappolation.tileentity;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.SpellRecipes;
import minestrapteam.minestrappolation.spell.data.SpellCategory;
import minestrapteam.minestrappolation.spell.data.SpellEnhancement;
import minestrapteam.minestrappolation.spell.data.SpellType;
import minestrapteam.minestrappolation.spell.data.SpellVariety;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityArcaneForge extends TileEntityInventory
{
	/*
	 * 0 - 7: Elemental Potency 8: Category 9: Variety 10: Enhancement 11: Name
	 */
	
	public Spell			spell;
	
	public int[]			potencies	= new int[SpellType.spellTypes.length];
	public SpellCategory	category;
	public SpellVariety		variety;
	public SpellEnhancement	enhancement;
	public String			name;
	
	public TileEntityArcaneForge()
	{
		super(12);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 12;
	}
	
	@Override
	public void onSlotChanged(int slotID)
	{
		ItemStack stack = this.itemStacks[slotID];
		if (slotID < 8)
		{
			this.potencies[slotID] = SpellRecipes.getPotency(SpellType.get(slotID), stack);
		}
		else if (slotID == 8)
		{
			this.category = SpellRecipes.getCategory(stack);
		}
		else if (slotID == 9)
		{
			this.variety = SpellRecipes.getVariety(stack, this.category);
		}
		else if (slotID == 10)
		{
			this.enhancement = SpellRecipes.getEnhancement(stack, this.variety);
		}
		else if (slotID == 11)
		{
			if (stack != null && stack.getItem() == Items.name_tag && stack.hasDisplayName())
			{
				this.name = stack.getDisplayName();
			}
		}
		
		if (this.category != null && this.variety != null && this.potencies != null)
		{
			this.spell = new Spell(this.name, this.category, this.variety, this.enhancement, this.potencies);
		}
		else
		{
			this.spell = null;
		}
	}
	
	public void onSpellCrafted(EntityPlayer player)
	{
		for (int i = 0; i < 8; i++)
		{
			this.itemStacks[i] = null;
		}
		
		this.decrStackSize(8, 1);
		this.decrStackSize(9, 1);
		this.decrStackSize(10, 1);
		this.decrStackSize(11, 1);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		for (int i = 0; i < 12; i++)
		{
			this.onSlotChanged(i);
		}
	}
	
	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack stack)
	{
		if (slotID == 9)
		{
			return this.category != null;
		}
		else if (slotID == 10 || slotID == 11)
		{
			return this.variety != null;
		}
		return true;
	}
}
