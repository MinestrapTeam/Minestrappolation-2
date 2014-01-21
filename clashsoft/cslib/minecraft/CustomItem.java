package clashsoft.cslib.minecraft;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import clashsoft.cslib.minecraft.item.IMetaItem;
import clashsoft.cslib.util.CSArrays;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;

/**
 * The Class CustomItem.
 */
public class CustomItem extends Item
{
	public static final String	FORCEHIDE	= "%&";
	
	/** The display names. */
	public String[]				names;
	/** The icon names. */
	public String[]				iconNames;
	/** The descriptions. */
	public String[]				descriptions;
	
	public CreativeTabs[]		tabs;
	
	/** The icons. */
	public Icon[]				icons;
	
	/** The enabled values. */
	public boolean[]			enabled;
	
	/** The ItemMeta list. */
	public List<IMetaItem>		subItemList;
	public List<IMetaItem>		subItemDisplayList;
	
	/**
	 * Instantiates a new custom item.
	 * 
	 * @param itemID
	 *            the item id
	 * @param subItems
	 *            the sub items
	 * @param subItemDisplay
	 *            the displaylist
	 */
	public CustomItem(int itemID, List<IMetaItem> subItems, List<IMetaItem> subItemDisplay)
	{
		super(itemID);
		this.subItemList = subItems;
		this.subItemDisplayList = subItemDisplay;
	}
	
	/**
	 * Instantiates a new custom item.
	 * 
	 * @param itemID
	 *            the item id
	 * @param displayNames
	 *            the display names
	 * @param iconNames
	 *            the icon names
	 * @param descriptions
	 *            the descriptions
	 */
	public CustomItem(int itemID, String[] displayNames, String[] iconNames, String[] descriptions, CreativeTabs[] tabs)
	{
		super(itemID);
		this.names = displayNames;
		this.iconNames = iconNames;
		this.descriptions = descriptions;
		this.tabs = tabs;
		
		this.enabled = new boolean[this.names.length];
		for (int i = 0; i < this.enabled.length; i++)
			this.enabled[i] = !iconNames[i].isEmpty() && !displayNames[i].isEmpty() && !displayNames[i].contains(FORCEHIDE);
		
		this.setHasSubtypes(displayNames.length > 1);
	}
	
	public CustomItem(int itemID, String[] displayNames, String[] iconNames, String[] descriptions)
	{
		this(itemID, displayNames, iconNames, descriptions, null);
	}
	
	/**
	 * Instantiates a new custom item.
	 * 
	 * @param itemID
	 *            the item id
	 * @param displayNames
	 *            the display names
	 * @param iconNames
	 *            the icon names
	 */
	public CustomItem(int itemID, String[] displayNames, String[] iconNames, CreativeTabs[] tabs)
	{
		this(itemID, displayNames, iconNames, null, tabs);
	}
	
	/**
	 * Instantiates a new custom item.
	 * 
	 * @param itemID
	 *            the item id
	 * @param displayNames
	 *            the display names
	 * @param iconNames
	 *            the icon names
	 */
	public CustomItem(int itemID, String[] displayNames, String[] iconNames)
	{
		this(itemID, displayNames, iconNames, (CreativeTabs[]) null);
	}
	
	/**
	 * Instantiates a new custom item.
	 * 
	 * @param itemID
	 *            the item id
	 * @param displayName
	 *            the display name
	 * @param iconName
	 *            the icon name
	 * @param description
	 *            the description
	 */
	public CustomItem(int itemID, String displayName, String iconName, String description, CreativeTabs tab)
	{
		this(itemID, CSArrays.create(displayName), CSArrays.create(iconName), CSArrays.create(description), CSArrays.create(tab));
	}
	
	/**
	 * Instantiates a new custom item.
	 * 
	 * @param itemID
	 *            the item id
	 * @param displayName
	 *            the display name
	 * @param iconName
	 *            the icon name
	 */
	public CustomItem(int itemID, String displayName, String iconName, CreativeTabs tab)
	{
		this(itemID, CSArrays.create(displayName), CSArrays.create(iconName), CSArrays.create(tab));
	}
	
	public CustomItem addSubItem(IMetaItem metaItem)
	{
		if (metaItem != null)
		{
			this.subItemList.add(metaItem);
			if (metaItem.isEnabled())
				this.subItemDisplayList.add(metaItem);
		}
		return this;
	}
	
	/**
	 * Checks if this CustomItem defines its meta-item properties with a
	 * MetaItem object.
	 * 
	 * @return true, if successful
	 */
	public boolean hasItemMetadataList()
	{
		return this.subItemList != null && this.subItemDisplayList != null;
	}
	
	@Deprecated
	public CustomItem disableMetadata(int... metadata)
	{
		return setMetadataEnabled(false, metadata);
	}
	
	/**
	 * Sets the <code>metadata</code> values to be shown in the creative
	 * inventory or not.
	 * 
	 * @param metadata
	 *            the metadata
	 * @return the custom item
	 */
	public CustomItem setMetadataEnabled(boolean enabled, int... metadata)
	{
		if (metadata != null)
			for (int i : metadata)
				this.enabled[i] = enabled;
		return this;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * net.minecraft.item.Item#getItemDisplayName(net.minecraft.item.ItemStack)
	 */
	@Override
	public String getItemDisplayName(ItemStack stack)
	{
		String ret = this.hasItemMetadataList() ? this.subItemList.get(stack.getItemDamage()).getName() : this.names[stack.getItemDamage()];
		return StatCollector.translateToLocal(ret.replace(FORCEHIDE, ""));
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.item.Item#getIconFromDamage(int)
	 */
	@Override
	public Icon getIconFromDamage(int damage)
	{
		return this.icons[damage];
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * net.minecraft.item.Item#registerIcons(net.minecraft.client.renderer.texture
	 * .IconRegister)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		if (this.hasItemMetadataList())
		{
			this.icons = new Icon[this.subItemList.size()];
			for (int i = 0; i < this.subItemList.size(); i++)
			{
				String iconName = this.subItemList.get(i).getIconName();
				if (!iconName.contains(FORCEHIDE))
					this.icons[i] = iconRegister.registerIcon(iconName);
			}
		}
		else
		{
			this.icons = new Icon[this.iconNames.length];
			for (int i = 0; i < this.iconNames.length; i++)
			{
				String iconName = this.iconNames[i];
				if (this.enabled[i])
					this.icons[i] = iconRegister.registerIcon(iconName);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.item.Item#addInformation(net.minecraft.item.ItemStack,
	 * net.minecraft.entity.player.EntityPlayer, java.util.List, boolean)
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		if (this.hasItemMetadataList())
		{
			Collection<String> s = this.subItemList.get(stack.getItemDamage()).getDescription();
			list.addAll(s);
		}
		else if (this.descriptions != null)
		{
			String s = this.descriptions[stack.getItemDamage()];
			if (s == null || s.isEmpty())
				return;
			list.addAll(Arrays.asList(s.split("\n")));
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.minecraft.item.Item#getSubItems(int,
	 * net.minecraft.creativetab.CreativeTabs, java.util.List)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List subItems)
	{
		if (this.hasItemMetadataList())
			for (IMetaItem item : this.subItemDisplayList)
				subItems.add(item.asStack());
		else
			for (int i = 0; i < this.names.length; i++)
			{
				if (this.enabled[i])
					if (this.tabs == null)
					{
						if (tab == super.getCreativeTab())
							subItems.add(new ItemStack(this, 1, i));
					}
					else if (i < this.tabs.length && tab == this.tabs[i])
						subItems.add(new ItemStack(this, 1, i));
					else if (tab == this.tabs[this.tabs.length - 1])
						subItems.add(new ItemStack(this, 1, i));
			}
	}
}
