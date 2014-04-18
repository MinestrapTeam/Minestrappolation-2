package clashsoft.cslib.minecraft.item.meta;

import java.util.Collection;

import net.minecraft.block.Block;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * The Interface IItemMetadataList.
 */
public interface IMetaItem
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
	
	public IMetaItem register();
	
	public IMetaItem setBlockPlaced(Block block, int metadata);
	
	public IMetaItem setEffects(PotionEffect... effects);
	
	public IMetaItem setEnabled(boolean enabled);
	
	public IMetaItem setFoodValue(int foodValue);
	
	public IMetaItem setIconName(String icon);
	
	public IMetaItem setName(String name);
	
	public IMetaItemRecipe getRecipe();
}