package clashsoft.cslib.minecraft.item;

import java.util.Collection;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * The Interface IItemMetadataList.
 */
public interface IMetaItem
{	
	/**
	 * As stack.
	 * 
	 * @return the item stack
	 */
	public ItemStack asStack();
	
	/**
	 * As stack.
	 * 
	 * @param i
	 *            the i
	 * @return the item stack
	 */
	public ItemStack asStack(int i);
	
	/**
	 * Gets the action.
	 * 
	 * @return the action
	 */
	public EnumAction getAction();
	
	/**
	 * Gets the block placed.
	 * 
	 * @return the blockPlaced
	 */
	public int getBlockPlaced();
	
	public int getMetadataPlaced();
	
	/**
	 * Gets the effects.
	 * 
	 * @return the effects
	 */
	public PotionEffect[] getEffects();
	
	/**
	 * Gets the food value.
	 * 
	 * @return the foodValue
	 */
	public int getFoodValue();
	
	/**
	 * Gets the icon name.
	 * 
	 * @return the icon
	 */
	public String getIconName();
	
	/**
	 * Gets the id.
	 * 
	 * @return the foodID
	 */
	public int getID();
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName();
	
	public Collection<String> getDescription();
	
	/**
	 * Checks if is enabled.
	 * 
	 * @return the isEnabled
	 */
	public boolean isEnabled();
	
	/**
	 * Register.
	 * @return 
	 */
	public IMetaItem register();
	
	/**
	 * Sets the block placed.
	 * 
	 * @param blockPlaced
	 *            the blockPlaced to set
	 */
	public void setBlockPlaced(int blockPlaced);
	
	/**
	 * Sets the effects.
	 * 
	 * @param effects
	 *            the effects
	 * @return this
	 */
	public IMetaItem setEffects(PotionEffect... effects);
	
	/**
	 * Sets the enabled.
	 * 
	 * @param enabled
	 *            the enabled
	 * @return this
	 */
	public IMetaItem setEnabled(boolean enabled);
	
	/**
	 * Sets the food value.
	 * 
	 * @param foodValue
	 *            the foodValue to set
	 */
	public void setFoodValue(int foodValue);
	
	/**
	 * Sets the icon name.
	 * 
	 * @param icon
	 *            the icon to set
	 */
	public void setIconName(String icon);
	
	/**
	 * Sets the id.
	 * 
	 * @param foodID
	 *            the foodID to set
	 */
	public void setID(int foodID);
	
	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name);

	IMetaItemRecipe getRecipe();
	
}