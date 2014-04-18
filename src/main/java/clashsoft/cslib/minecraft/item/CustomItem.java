package clashsoft.cslib.minecraft.item;

import java.util.Arrays;
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
	
	public List<IMetaItem>		subItems;
	public List<IMetaItem>		shownSubItems;
	
	/**
	 * Instantiates a new custom item.
	 * 
	 * @param subItems
	 *            the sub items
	 * @param showSubItems
	 *            the displaylist
	 */
	public CustomItem(List<IMetaItem> subItems, List<IMetaItem> showSubItems)
	{
		this.subItems = subItems;
		this.shownSubItems = showSubItems;
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
		Arrays.fill(this.enabled, true);
		
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
	
	@Override
	public CreativeTabs[] getCreativeTabs()
	{
		if (this.tabs == null)
		{
			this.tabs = new CreativeTabs[] { this.getCreativeTab() };
		}
		return this.tabs;
	}
	
	public CreativeTabs getCreativeTab(int metadata)
	{
		if (this.tabs == null)
		{
			return this.getCreativeTab();
		}
		return this.tabs[metadata % this.tabs.length];
	}
	
	public CustomItem addSubItem(IMetaItem metaItem)
	{
		if (metaItem != null)
		{
			this.subItems.add(metaItem);
			if (metaItem.isEnabled())
			{
				this.shownSubItems.add(metaItem);
			}
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
		return this.subItems != null && this.shownSubItems != null;
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
			return this.subItems.get(stack.getItemDamage()).getName();
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
			this.icons = new IIcon[this.subItems.size()];
			for (int i = 0; i < this.subItems.size(); i++)
			{
				String iconName = this.subItems.get(i).getIconName();
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
			Collection<String> s = this.subItems.get(stack.getItemDamage()).getDescription();
			list.addAll(s);
		}
		
		String key = this.getUnlocalizedName(stack) + ".desc";
		String desc = I18n.getString(key);
		if (desc != key && !desc.isEmpty())
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
			for (IMetaItem subitem : this.shownSubItems)
			{
				subItems.add(subitem.asStack());
			}
		}
		else
		{
			for (int i = 0; i < this.names.length; i++)
			{
				if (this.enabled[i] && tab == this.getCreativeTab(i))
				{
					subItems.add(new ItemStack(this, 1, i));
				}
			}
		}
	}
}
