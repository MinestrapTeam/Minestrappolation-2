package clashsoft.cslib.minecraft.item.meta;

import java.util.Collection;

import net.minecraft.block.Block;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * The Interface IItemMetadataList.
 */
public interface ISubItem
{
	public ItemStack asStack();
	
	public ItemStack asStack(int i);
	
	public EnumAction getAction();
	
	public Block getBlockPlaced();
	
	public int getMetadataPlaced();
	
	public PotionEffect[] getEffects();
	
	public int getFoodValue();
	
	public String getIconName();
	
	public int getID();
	
	public String getName();
	
	public Collection<String> getDescription();
	
	public boolean isEnabled();
	
	public ISubItem register();
	
	public ISubItem setBlockPlaced(Block block, int metadata);
	
	public ISubItem setEffects(PotionEffect... effects);
	
	public ISubItem setEnabled(boolean enabled);
	
	public ISubItem setFoodValue(int foodValue);
	
	public ISubItem setIconName(String icon);
	
	public ISubItem setName(String name);
	
	public ISubItemRecipe getRecipe();
}