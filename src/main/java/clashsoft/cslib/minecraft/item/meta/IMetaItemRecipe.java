package clashsoft.cslib.minecraft.item.meta;

/**
 * The Interface IItemMetadataRecipe.
 */
public interface IMetaItemRecipe
{
	public static final int	CRAFTING			= 0;
	public static final int	CRAFTING_SHAPELESS	= 1;
	public static final int	FURNACE				= 2;
	
	/**
	 * Gets the crafting type.
	 * 
	 * @return the crafting type
	 */
	public int getCraftingType();
	
	/**
	 * Gets the amount.
	 * 
	 * @return the amount
	 */
	public int getAmount();
	
	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public Object[] getData();
}
