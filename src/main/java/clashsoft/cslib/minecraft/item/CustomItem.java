package clashsoft.cslib.minecraft.item;

import java.util.Collection;
import java.util.List;

import clashsoft.cslib.minecraft.item.meta.IMetaItem;
import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.cslib.util.CSArrays;
import clashsoft.cslib.util.CSString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * The Class CustomItem.
 */
public class CustomItem extends Item
{
	public static final String	FORCEHIDE	= "%&";
	
	public String[]				names;
	public String[]				iconNames;
	
	public CreativeTabs[]		tabs;
	
	public IIcon[]				icons;
	
	public boolean[]			enabled;
	
	public List<IMetaItem>		subItemList;
	public List<IMetaItem>		subItemDisplayList;
	
	/**
	 * Instantiates a new custom item.
	 * 
	 * @param subItems
	 *            the sub items
	 * @param subItemDisplay
	 *            the displaylist
	 */
	public CustomItem(List<IMetaItem> subItems, List<IMetaItem> subItemDisplay)
	{
		this.subItemList = subItems;
		this.subItemDisplayList = subItemDisplay;
	}
	
	/**
	 * Instantiates a new custom item.
	 * 
	 * @param names
	 *            the names
	 * @param iconNames
	 *            the icon names
	 * @param descriptions
	 *            the descriptions
	 */
	public CustomItem(String[] names, String[] iconNames, CreativeTabs[] tabs)
	{
		this.names = names;
		this.iconNames = iconNames;
		this.tabs = tabs;
		this.enabled = new boolean[this.names.length];
		
		this.setHasSubtypes(names.length > 1);
	}
	
	public CustomItem(String[] names, String[] iconNames)
	{
		this(names, iconNames, null);
	}
	
	public CustomItem(String[] names, String domain, CreativeTabs[] tabs)
	{
		this(names, CSString.concatAll(names, domain + ":", ""), tabs);
	}
	
	public CustomItem(String[] names, String domain)
	{
		this(names, domain, null);
	}
	
	public CustomItem(String names, String iconName, CreativeTabs tab)
	{
		this(CSArrays.create(names), CSArrays.create(iconName), CSArrays.create(tab));
	}
	
	public CustomItem(String name, String iconName)
	{
		this(CSArrays.create(name), CSArrays.create(iconName));
	}
	
	public CustomItem addSubItem(IMetaItem metaItem)
	{
		if (metaItem != null)
		{
			this.subItemList.add(metaItem);
			if (metaItem.isEnabled())
			{
				this.subItemDisplayList.add(metaItem);
			}
		}
		return this;
	}
	
	/**
	 * Checks if this CustomItem defines its meta-item properties with a MetaItem object.
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
		return this.setMetadataEnabled(false, metadata);
	}
	
	/**
	 * Sets the <code>metadata</code> values to be shown in the creative inventory or not.
	 * 
	 * @param metadata
	 *            the metadata
	 * @return the custom item
	 */
	public CustomItem setMetadataEnabled(boolean enabled, int... metadata)
	{
		if (metadata != null)
		{
			for (int i : metadata)
			{
				this.enabled[i] = enabled;
			}
		}
		return this;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		if (this.hasItemMetadataList())
		{
			return this.subItemList.get(stack.getItemDamage()).getName();
		}
		else
		{
			return this.getUnlocalizedName() + "." + this.names[stack.getItemDamage()];
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int damage)
	{
		return this.icons[damage];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		if (this.hasItemMetadataList())
		{
			this.icons = new IIcon[this.subItemList.size()];
			for (int i = 0; i < this.subItemList.size(); i++)
			{
				String iconName = this.subItemList.get(i).getIconName();
				this.icons[i] = iconRegister.registerIcon(iconName);
			}
		}
		else
		{
			this.icons = new IIcon[this.iconNames.length];
			for (int i = 0; i < this.iconNames.length; i++)
			{
				String iconName = this.iconNames[i];
				this.icons[i] = iconRegister.registerIcon(iconName);
			}
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		if (this.hasItemMetadataList())
		{
			Collection<String> s = this.subItemList.get(stack.getItemDamage()).getDescription();
			list.addAll(s);
		}
		
		String key = this.getUnlocalizedName(stack) + ".desc";
		String desc = I18n.getString(key);
		if (desc != key)
		{
			list.addAll(CSString.lineList(desc));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List subItems)
	{
		if (this.hasItemMetadataList())
		{
			for (IMetaItem subitem : this.subItemDisplayList)
			{
				subItems.add(subitem.asStack());
			}
		}
		else
		{
			for (int i = 0; i < this.names.length; i++)
			{
				if (this.enabled[i])
				{
					if (this.tabs == null)
					{
						if (tab == this.getCreativeTab())
						{
							subItems.add(new ItemStack(this, 1, i));
						}
					}
					else if (tab == this.tabs[i % this.tabs.length])
					{
						subItems.add(new ItemStack(this, 1, i));
					}
				}
			}
		}
	}
}
