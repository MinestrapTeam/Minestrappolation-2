package clashsoft.cslib.minecraft.item.datatools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * The Class DataToolSet.
 */
public class DataToolSet
{
	public List<ToolMaterial>			materials		= new ArrayList();
	public Map<String, ToolMaterial>	nameToMaterial	= new HashMap();
	public Map<ToolMaterial, String>	materialToName	= new HashMap();
	
	/** The sword. */
	public ItemDataSword				sword;
	
	/** The shovel. */
	public ItemDataSpade				shovel;
	
	/** The pickaxe. */
	public ItemDataPickaxe				pickaxe;
	
	/** The axe. */
	public ItemDataAxe					axe;
	
	/** The hoe. */
	public ItemDataHoe					hoe;
	
	/**
	 * Instantiates a new data tool set.
	 * 
	 * @param sword
	 *            the sword
	 * @param shovel
	 *            the shovel
	 * @param pickaxe
	 *            the pickaxe
	 * @param axe
	 *            the axe
	 * @param hoe
	 *            the hoe
	 */
	public DataToolSet(ItemDataSword sword, ItemDataSpade shovel, ItemDataPickaxe pickaxe, ItemDataAxe axe, ItemDataHoe hoe)
	{
		this.sword = sword;
		this.shovel = shovel;
		this.pickaxe = pickaxe;
		this.axe = axe;
		this.hoe = hoe;
	}
	
	/**
	 * Register tool material.
	 * 
	 * @param material
	 *            the material
	 * @param name
	 *            the name
	 */
	public void registerToolMaterial(ToolMaterial material, String name)
	{
		this.materials.add(material);
		this.materialToName.put(material, name);
		this.nameToMaterial.put(name, material);
	}
	
	public ToolMaterial getToolMaterial(ItemStack stack)
	{
		return this.nameToMaterial.get(this.getMaterialName(stack));
	}
	
	public String getMaterialName(ItemStack stack)
	{
		if (stack != null)
		{
			NBTTagCompound nbt = stack.getTagCompound();
			return nbt.getString("ToolMaterial");
		}
		return null;
	}
	
	public ItemStack setToolMaterial(ItemStack stack, ToolMaterial material)
	{
		return this.setMaterialName(stack, this.materialToName.get(material));
	}
	
	public ItemStack setMaterialName(ItemStack stack, String name)
	{
		if (stack != null)
		{
			NBTTagCompound nbt = stack.getTagCompound();
			nbt.setString("ToolMaterial", name);
		}
		return stack;
	}
}