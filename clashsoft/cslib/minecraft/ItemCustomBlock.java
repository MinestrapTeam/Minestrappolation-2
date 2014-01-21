package clashsoft.cslib.minecraft;

import java.util.List;

import clashsoft.cslib.minecraft.block.ICustomBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;

/**
 * The Class ItemCustomBlock.
 */
public class ItemCustomBlock extends ItemBlock
{
	/** The block. */
	private Block	theBlock;
	
	/**
	 * Instantiates a new item custom block.
	 * 
	 * @param itemID
	 *            the item id
	 * @param block
	 *            the block
	 */
	public ItemCustomBlock(int itemID, Block block)
	{
		super(itemID);
		this.theBlock = block;
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.item.ItemBlock#getIconFromDamage(int)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		return this.theBlock.getIcon(2, damage);
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#getMetadata(int)
	 */
	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#getItemStackDisplayName(net.minecraft.item.ItemStack)
	 */
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.item.ItemBlock#getUnlocalizedName(net.minecraft.item.ItemStack)
	 */
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.theBlock instanceof ICustomBlock ? this.theBlock.getUnlocalizedName() + "." + stack.getItemDamage() : this.theBlock.getUnlocalizedName();
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.item.ItemBlock#getUnlocalizedName()
	 */
	@Override
	public String getUnlocalizedName()
	{
		return this.theBlock instanceof ICustomBlock ? this.theBlock.getUnlocalizedName() : theBlock.getUnlocalizedName() + ".0";
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#addInformation(net.minecraft.item.ItemStack, net.minecraft.entity.player.EntityPlayer, java.util.List, boolean)
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		if (theBlock instanceof ICustomBlock)
			((ICustomBlock)theBlock).addInformation(stack, player, list);
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#getCreativeTabs()
	 */
	@Override
	public CreativeTabs[] getCreativeTabs()
	{
		if (theBlock instanceof CustomBlock)
		{
			CreativeTabs[] tabs = ((CustomBlock)theBlock).tabs;
			if (tabs != null)
				return tabs;
		}
		return super.getCreativeTabs();
	}
}
