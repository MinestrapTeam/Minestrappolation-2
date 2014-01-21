package clashsoft.cslib.minecraft;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.block.ICustomBlock;
import clashsoft.cslib.util.CSString;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * The Class CustomBlock.
 */
public class CustomBlock extends Block implements ICustomBlock
{
	
	/** The names. */
	public String[]			names, descriptions;
	
	/** The textures. */
	public String[][]		textures;
	
	/** The icons. */
	public Icon[][]			icons;
	
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
	
	/** The disabled. */
	public boolean[]		disabled;
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param blockID
	 *            the block id
	 * @param material
	 *            the material
	 * @param displayNames
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
	public CustomBlock(int blockID, Material material, String[] displayNames, String[][] iconNames, boolean opaque, int renderType, CreativeTabs[] creativeTabs)
	{
		super(blockID, material);
		
		this.names = displayNames;
		this.descriptions = new String[displayNames.length];
		this.textures = iconNames;
		
		this.opaque = opaque;
		this.renderType = renderType;
		this.drops = new ItemStack[this.names.length];
		this.hardnesses = new float[this.names.length];
		this.disabled = new boolean[this.names.length];
		
		for (int i = 0; i < this.disabled.length; i++)
		{
			this.disabled[i] = displayNames[i] == null || displayNames[i].isEmpty() || displayNames[i].startsWith("%&");
		}
		
		this.tabs = creativeTabs;
		if (tabs != null)
			this.setCreativeTab(creativeTabs[0]);
	}
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param blockID
	 *            the block id
	 * @param material
	 *            the material
	 * @param displayNames
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
	public CustomBlock(int blockID, Material material, String[] displayNames, String[] iconNames, boolean opaque, int renderType, CreativeTabs[] creativeTabs)
	{
		this(blockID, material, displayNames, iconMetadataToSideArray(iconNames), opaque, renderType, creativeTabs);
	}
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param blockID
	 *            the block id
	 * @param material
	 *            the material
	 * @param displayName
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
	public CustomBlock(int blockID, Material material, String displayName, String iconNames, boolean opaque, int renderType, CreativeTabs creativeTabs)
	{
		this(blockID, material, new String[] { displayName }, new String[][] { { iconNames, iconNames, iconNames, iconNames, iconNames, iconNames } }, opaque, renderType, new CreativeTabs[] { creativeTabs });
	}
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param blockID
	 *            the block id
	 * @param material
	 *            the material
	 * @param displayNames
	 *            the display names
	 * @param iconNames
	 *            the icon names
	 * @param creativeTabs
	 *            the creative tabs
	 */
	public CustomBlock(int blockID, Material material, String[] displayNames, String[] iconNames, CreativeTabs[] creativeTabs)
	{
		this(blockID, material, displayNames, iconMetadataToSideArray(iconNames), true, 0, creativeTabs);
	}
	
	/**
	 * Instantiates a new custom block.
	 * 
	 * @param blockID
	 *            the block id
	 * @param material
	 *            the material
	 * @param displayName
	 *            the display name
	 * @param iconName
	 *            the icon name
	 * @param creativeTab
	 *            the creative tab
	 */
	public CustomBlock(int blockID, Material material, String displayName, String iconName, CreativeTabs creativeTab)
	{
		this(blockID, material, new String[] { displayName }, new String[][] { { iconName, iconName, iconName, iconName, iconName, iconName } }, true, 0, new CreativeTabs[] { creativeTab });
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
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#isOpaqueCube()
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return this.opaque;
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#renderAsNormalBlock()
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return this.renderType == 0;
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#getRenderType()
	 */
	@Override
	public int getRenderType()
	{
		return this.renderType;
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#getIcon(int, int)
	 */
	@Override
	public Icon getIcon(int side, int metadata)
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
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#getBlockHardness(net.minecraft.world.World, int, int, int)
	 */
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) < this.hardnesses.length && this.hardnesses[world.getBlockMetadata(x, y, z)] > 0)
		{
			return this.hardnesses[world.getBlockMetadata(x, y, z)];
		}
		return this.blockHardness;
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#registerIcons(net.minecraft.client.renderer .texture.IconRegister)
	 */
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		if (this.textures != null && this.icons != null)
		{
			this.icons = new Icon[this.textures.length][6];
			
			for (int i = 0; i < this.textures.length; i++)
			{
				this.icons[i] = new Icon[this.textures[i].length];
				
				for (int j = 0; j < this.textures[i].length; j++)
				{
					if (!this.textures[i][j].startsWith("%&"))
					{
						this.icons[i][j] = iconRegister.registerIcon(this.textures[i][j]);
					}
				}
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#getSubBlocks(int, net.minecraft.creativetab.CreativeTabs, java.util.List)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockID, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < this.names.length; i++)
		{
			if (!this.disabled[i])
				if (this.tabs == null)
				{
					if (creativeTab == super.getCreativeTabToDisplayOn())
						list.add(new ItemStack(this, 1, i));
				}
				else if (i < this.tabs.length && creativeTab == this.tabs[i])
					list.add(new ItemStack(this, 1, i));
				else if (creativeTab == this.tabs[this.tabs.length - 1])
					list.add(new ItemStack(this, 1, i));
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#quantityDropped(int, int, java.util.Random)
	 */
	@Override
	public int quantityDropped(int metadata, int fortune, Random random)
	{
		if (this.drops[metadata] != null)
			return this.drops[metadata].stackSize;
		return 1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#idDropped(int, java.util.Random, int)
	 */
	@Override
	public int idDropped(int metadata, Random random, int fortune)
	{
		if (this.drops[metadata] != null)
			return this.drops[metadata].itemID;
		return this.blockID;
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#damageDropped(int)
	 */
	@Override
	public int damageDropped(int metadata)
	{
		if (this.drops[metadata] != null)
			return this.drops[metadata].getItemDamage();
		return metadata;
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.block.Block#getDamageValue(net.minecraft.world.World, int, int, int)
	 */
	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	/**
	 * Adds the names.
	 */
	@Override
	public void addNames()
	{
		for (int i = 0; i < this.names.length; i++)
			LanguageRegistry.addName(new ItemStack(this, 1, i), this.names[i]);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
		int metadata = stack.getItemDamage();
		if (descriptions[metadata] != null && !descriptions[metadata].isEmpty())
			list.addAll(Arrays.asList(CSString.makeLineList(descriptions[metadata])));
	}
}
