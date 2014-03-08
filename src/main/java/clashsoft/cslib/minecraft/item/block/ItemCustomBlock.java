package clashsoft.cslib.minecraft.item.block;

import java.util.List;

import clashsoft.cslib.minecraft.block.CustomBlock;
import clashsoft.cslib.minecraft.block.ICustomBlock;
import clashsoft.cslib.minecraft.lang.I18n;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * The Class ItemCustomBlock.
 */
public class ItemCustomBlock extends ItemBlock
{
	/** The block. */
	public final Block		theBlock;
	protected ICustomBlock	customBlock;
	
	/**
	 * Instantiates a new item custom block.
	 * 
	 * @param itemID
	 *            the item id
	 * @param block
	 *            the block
	 */
	public ItemCustomBlock(Block block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		
		this.theBlock = block;
		if (block instanceof ICustomBlock)
		{
			this.customBlock = (ICustomBlock) block;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage)
	{
		return this.theBlock.getIcon(2, damage);
	}
	
	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return I18n.getString(this.getUnlocalizedName(stack) + ".name");
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.customBlock != null ? this.customBlock.getUnlocalizedName(stack) : this.getUnlocalizedName();
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return this.theBlock.getUnlocalizedName();
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		if (this.customBlock != null)
		{
			this.customBlock.addInformation(stack, player, list);
		}
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs()
	{
		if (this.customBlock != null && this.customBlock instanceof CustomBlock)
		{
			CreativeTabs[] tabs = ((CustomBlock) this.customBlock).tabs;
			if (tabs != null)
			{
				return tabs;
			}
		}
		return super.getCreativeTabs();
	}
}
