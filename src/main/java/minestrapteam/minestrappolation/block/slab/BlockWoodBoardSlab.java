package minestrapteam.minestrappolation.block.slab;

import java.util.List;

import minestrapteam.minestrap_core.block.MCBlockMultiSlab;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockWoodBoardSlab extends MCBlockMultiSlab
{
	public BlockWoodBoardSlab(boolean doubleSlab)
	{
		super(Material.wood, doubleSlab, null, null);
		this.setCreativeTab(Minestrappolation.tabBuildingBlocks);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return MBlocks.woodBoards.getIcon(side, metadata & 7);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
	}
	
	@Override
	public Item getItem(int metadata)
	{
		return Item.getItemFromBlock(MBlocks.woodBoards);
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
