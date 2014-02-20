package clashsoft.cslib.minecraft.block;

import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.util.CSString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * The Class CustomBlock.
 */
public class CustomBlock extends Block implements ICustomBlock
{
	/** The names. */
	public String[]			names;
	
	/** The textures. */
	public String[][]		textures;
	
	/** The icons. */
	public IIcon[][]		icons;
	
	/** The opaque. */
	public boolean			opaque;
	
	/** The render type. */
	public int				renderType;
	
	/** The drops. */
	public ItemStack[]		drops;
	
	/** The hardnesses. */
	public float[]			hardnesses;
	
	/** The tabs. */
	public CreativeTabs[]	tabs;
	
	/** Checks if the metadata shows up in the creative inventory. */
	public boolean[]		disabled;
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param material
	 *            the material
	 * @param names
	 *            the display names
	 * @param iconNames
	 *            the icon names
	 * @param opaque
	 *            the opaque
	 * @param renderType
	 *            the render type
	 * @param creativeTabs
	 *            the creative tabs
	 */
	public CustomBlock(Material material, String[] names, String[][] iconNames, boolean opaque, int renderType, CreativeTabs[] creativeTabs)
	{
		super(material);
		
		this.names = names;
		this.textures = iconNames;
		
		this.opaque = opaque;
		this.renderType = renderType;
		this.drops = new ItemStack[this.names.length];
		this.hardnesses = new float[this.names.length];
		this.disabled = new boolean[this.names.length];
		
		for (int i = 0; i < this.disabled.length; i++)
		{
			this.disabled[i] = names[i] == null || names[i].isEmpty() || names[i].startsWith("%&");
		}
		
		this.tabs = creativeTabs;
		if (this.tabs != null)
		{
			this.setCreativeTab(creativeTabs[0]);
		}
	}
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param material
	 *            the material
	 * @param names
	 *            the display names
	 * @param iconNames
	 *            the icon names
	 * @param opaque
	 *            the opaque
	 * @param renderType
	 *            the render type
	 * @param creativeTabs
	 *            the creative tabs
	 */
	public CustomBlock(Material material, String[] names, String[] iconNames, boolean opaque, int renderType, CreativeTabs[] creativeTabs)
	{
		this(material, names, iconMetadataToSideArray(iconNames), opaque, renderType, creativeTabs);
	}
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param material
	 *            the material
	 * @param name
	 *            the display name
	 * @param iconNames
	 *            the icon names
	 * @param opaque
	 *            the opaque
	 * @param renderType
	 *            the render type
	 * @param creativeTabs
	 *            the creative tabs
	 */
	public CustomBlock(Material material, String name, String iconNames, boolean opaque, int renderType, CreativeTabs creativeTabs)
	{
		this(material, new String[] { name }, new String[][] { {
				iconNames,
				iconNames,
				iconNames,
				iconNames,
				iconNames,
				iconNames } }, opaque, renderType, new CreativeTabs[] { creativeTabs });
	}
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param material
	 *            the material
	 * @param names
	 *            the display names
	 * @param iconNames
	 *            the icon names
	 * @param creativeTabs
	 *            the creative tabs
	 */
	public CustomBlock(Material material, String[] names, String[] iconNames, CreativeTabs[] creativeTabs)
	{
		this(material, names, iconMetadataToSideArray(iconNames), true, 0, creativeTabs);
	}
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param material
	 *            the material
	 * @param name
	 *            the display name
	 * @param iconName
	 *            the icon name
	 * @param creativeTab
	 *            the creative tab
	 */
	public CustomBlock(Material material, String name, String iconName, CreativeTabs creativeTab)
	{
		this(material, new String[] { name }, new String[][] { {
				iconName,
				iconName,
				iconName,
				iconName,
				iconName,
				iconName } }, true, 0, new CreativeTabs[] { creativeTab });
	}
	
	/**
	 * Icon metadata to side array.
	 * 
	 * @param metadataArray
	 *            the metadata array
	 * @return the string[][]
	 */
	private static String[][] iconMetadataToSideArray(String[] metadataArray)
	{
		if (metadataArray == null)
		{
			return null;
		}
		
		String[][] s = new String[metadataArray.length][6];
		for (int i = 0; i < metadataArray.length; i++)
			for (int j = 0; j < 6; j++)
				s[i][j] = metadataArray[i];
		return s;
	}
	
	/**
	 * Disable metadata.
	 * 
	 * @param metadata
	 *            the metadata
	 * @return the custom block
	 */
	public CustomBlock disableMetadata(int metadata)
	{
		this.disabled[metadata] = true;
		return this;
	}
	
	/**
	 * Sets the hardness.
	 * 
	 * @param hardness
	 *            the hardness
	 * @return the custom block
	 */
	@Override
	public CustomBlock setHardness(float hardness)
	{
		return this.setHardness(0, hardness);
	}
	
	/**
	 * Sets the hardness.
	 * 
	 * @param metadata
	 *            the metadata
	 * @param hardness
	 *            the hardness
	 * @return the custom block
	 */
	public CustomBlock setHardness(int metadata, float hardness)
	{
		this.hardnesses[metadata] = hardness;
		return this;
	}
	
	/**
	 * Sets the hardnesses.
	 * 
	 * @param hardnessArray
	 *            the hardness array
	 * @return the custom block
	 */
	public CustomBlock setHardnesses(float... hardnessArray)
	{
		this.hardnesses = hardnessArray;
		return this;
	}
	
	/**
	 * Sets the drops.
	 * 
	 * @param metadata
	 *            the metadata
	 * @param drop
	 *            the drop
	 * @return the custom block
	 */
	public CustomBlock setDrops(int metadata, ItemStack drop)
	{
		this.drops[metadata] = drop;
		return this;
	}
	
	/**
	 * Sets the drops.
	 * 
	 * @param drops
	 *            the drops
	 * @return the custom block
	 */
	public CustomBlock setDrops(ItemStack... drops)
	{
		this.drops = drops;
		return this;
	}
	
	public CustomBlock setCreativeTab(int metadata, CreativeTabs tab)
	{
		this.tabs[metadata] = tab;
		return this;
	}
	
	public CustomBlock setCreativeTabs(CreativeTabs... tabs)
	{
		this.tabs = tabs;
		return this;
	}
	
	/**
	 * Gets the names.
	 * 
	 * @return the names
	 */
	public String[] getNames()
	{
		return this.names;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return this.opaque;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return this.renderType == 0;
	}
	
	@Override
	public int getRenderType()
	{
		return this.renderType;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (this.icons != null)
		{
			if (metadata < this.icons.length && side < this.icons[metadata].length)
			{
				return this.icons[metadata][side];
			}
			return this.icons[0][0];
		}
		return null;
	}
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) < this.hardnesses.length && this.hardnesses[world.getBlockMetadata(x, y, z)] > 0)
		{
			return this.hardnesses[world.getBlockMetadata(x, y, z)];
		}
		return this.blockHardness;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[this.textures.length][6];
		if (this.textures != null)
		{
			for (int i = 0; i < this.textures.length; i++)
			{
				String[] textures = this.textures[i];
				this.icons[i] = new IIcon[textures.length];
				
				for (int j = 0; j < textures.length; j++)
				{
					this.icons[i][j] = iconRegister.registerIcon(textures[j]);
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < this.names.length; i++)
		{
			if (!this.disabled[i])
			{
				if (this.tabs == null)
				{
					if (creativeTab == super.getCreativeTabToDisplayOn())
					{
						list.add(new ItemStack(this, 1, i));
					}
				}
				else if (i < this.tabs.length && creativeTab == this.tabs[i])
				{
					list.add(new ItemStack(this, 1, i));
				}
				else if (creativeTab == this.tabs[this.tabs.length - 1])
				{
					list.add(new ItemStack(this, 1, i));
				}
			}
		}
	}
	
	@Override
	public int quantityDropped(int metadata, int fortune, Random random)
	{
		if (this.drops[metadata] != null)
		{
			return this.drops[metadata].stackSize;
		}
		return 1;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this.drops[metadata] != null)
		{
			return this.drops[metadata].getItem();
		}
		return super.getItemDropped(metadata, random, fortune);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		if (this.drops[metadata] != null)
		{
			return this.drops[metadata].getItemDamage();
		}
		return metadata;
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int metadata = stack.getItemDamage();
		if (metadata < this.names.length)
		{
			return this.getUnlocalizedName() + "." + this.names[metadata];
		}
		return this.getUnlocalizedName();
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
		String key = this.getUnlocalizedName(stack) + ".desc";
		String desc = I18n.getString(key);
		if (desc != key)
		{
			list.addAll(CSString.lineList(desc));
		}
	}
}
