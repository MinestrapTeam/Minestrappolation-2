package sobiohazardous.mods.minestrappolation.extradecor.block.slab;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.block.MBlockMultiSlab;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockWoodBoardSlab extends MBlockMultiSlab
{
	public BlockWoodBoardSlab(boolean doubleSlab)
	{
		super(Material.wood, doubleSlab, null, null);
		this.setCreativeTab(EDBlocks.tabBlocks);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return EDBlocks.woodBoards.getIcon(side, metadata & 7);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
	}
	
	@Override
	public Item getItem(int metadata)
	{
		return Item.getItemFromBlock(EDBlocks.woodBoards);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		if (!this.field_150004_a)
		{
			for (int i = 0; i < 4; i++)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}
}
