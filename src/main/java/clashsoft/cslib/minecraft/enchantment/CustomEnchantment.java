package clashsoft.cslib.minecraft.enchantment;

import clashsoft.cslib.util.CSArrays;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

/**
 * The Class CustomEnchantment.
 */
public class CustomEnchantment extends Enchantment
{
	/** The max level. */
	private int	maxLevel;
	
	/** The min level. */
	private int	minLevel;
	
	/**
	 * Instantiates a new custom enchantment.
	 * 
	 * @param id
	 *            the id
	 * @param weigth
	 *            the weigth
	 * @param minLevel
	 *            the min level
	 * @param maxLevel
	 *            the max level
	 * @param type
	 *            the type
	 * @param name
	 *            the name
	 */
	public CustomEnchantment(int id, int weigth, int minLevel, int maxLevel, EnumEnchantmentType type, String name)
	{
		super(id, weigth, type);
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		this.name = name;
	}
	
	/**
	 * Instantiates a new custom enchantment.
	 * 
	 * @param weigth
	 *            the weigth
	 * @param minLevel
	 *            the min level
	 * @param maxLevel
	 *            the max level
	 * @param type
	 *            the type
	 * @param name
	 *            the name
	 */
	public CustomEnchantment(int weigth, int minLevel, int maxLevel, EnumEnchantmentType type, String name)
	{
		this(getNextFreeID(), weigth, minLevel, maxLevel, type, name);
	}
	
	/**
	 * Returns the minimum level that the enchantment can have.
	 * 
	 * @return the min level
	 */
	@Override
	public int getMinLevel()
	{
		return this.maxLevel;
	}
	
	/**
	 * Returns the maximum level that the enchantment can have.
	 * 
	 * @return the max level
	 */
	@Override
	public int getMaxLevel()
	{
		return this.minLevel;
	}
	
	/**
	 * Gets the next free enchantment id.
	 * 
	 * @return the next free enchantment id
	 */
	private static int getNextFreeID()
	{
		int id = CSArrays.indexOf(enchantmentsList, null);
		if (id == -1)
			throw new IllegalStateException("No more empty enchantment IDs!");
		return id;
	}
	
}
