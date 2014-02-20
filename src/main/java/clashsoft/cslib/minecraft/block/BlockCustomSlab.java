package clashsoft.cslib.minecraft.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCustomSlab extends BlockHalfSlab implements ICustomBlock
{
	public int		otherSlab;
	
	/** The list of the types of step blocks. */
	public String[]	names;
	public String[]	topIcons;
	public String[]	sideIcons;
	
	private Icon[]	TopIcons;
	private Icon[]	SideIcons;
	
	public BlockCustomSlab(int blockID, String[] names, String[] topIcons, String[] sideIcons, int otherSlabID, boolean doubleSlab)
	{
		super(blockID, doubleSlab, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.names = names;
		this.topIcons = topIcons;
		this.TopIcons = new Icon[topIcons.length];
		this.sideIcons = sideIcons;
		this.SideIcons = new Icon[sideIcons.length];
		this.otherSlab = otherSlabID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int side, int metadata)
	{
		if (this.isDoubleSlab && (metadata & 8) != 0)
		{
			side = 1;
		}
		
		return side == 1 || side == 0 ? TopIcons[metadata & 7] : SideIcons[metadata & 7];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister iconRegister)
	{
		for (int i = 0; i < topIcons.length; i++)
		{
			TopIcons[i] = iconRegister.registerIcon(topIcons[i]);
			SideIcons[i] = iconRegister.registerIcon(sideIcons[i]);
		}
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int metadata, Random random, int fortune)
	{
		return this.blockID;
	}
	
	/**
	 * Returns an item stack containing a single instance of the current block
	 * type. 'i' is the block's subtype/damage and is ignored for blocks which
	 * do not support subtypes. Blocks which cannot be harvested should return
	 * null.
	 */
	@Override
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(this.blockID, 2, metadata & 7);
	}
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockID, CreativeTabs creativeTab, List list)
	{
		for (int j = 0; j < names.length; ++j)
		{
			list.add(new ItemStack(blockID, 1, j));
		}
	}
	
	/**
	 * only called by clickMiddleMouseButton , and passed to
	 * inventory.setCurrentItem (along with isCreative)
	 */
	@Override
	public int idPicked(World world, int x, int y, int z)
	{
		return !isDoubleSlab ? this.blockID : this.otherSlab;
	}
	
	@Override
	public void addNames()
	{
		for (int i = 0; i < names.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(this, 1, i), names[i]);
		}
	}
	
	@Override
	public String getFullSlabName(int metadata)
	{
		return names[metadata];
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
	}
}
