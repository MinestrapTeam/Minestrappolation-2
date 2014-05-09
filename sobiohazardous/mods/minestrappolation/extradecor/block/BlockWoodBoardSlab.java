package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.List;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockWoodBoardSlab extends BlockSlab
{
	public static final String[]	woodType	= new String[] { "oak", "birch", "spruce", "jungle" };
	
	public BlockWoodBoardSlab(boolean doubleSlab)
	{
		super(doubleSlab, Material.wood);
		this.setCreativeTab(EDBlocks.tabDecor);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return EDBlocks.woodBoards.getIcon(side, metadata & 7);
	}
	
	@Override
	public String func_150002_b(int metadata)
	{
		return super.getUnlocalizedName() + "." + woodType[metadata % woodType.length];
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		if (this != EDBlocks.woodBoardsDoubleSlab)
		{
			for (int i = 0; i < 4; ++i)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
	}
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 75;
	}
}
