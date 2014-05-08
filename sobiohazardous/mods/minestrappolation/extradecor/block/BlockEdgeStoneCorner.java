package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityEdgeStoneCorner;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockEdgeStoneCorner extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	private IIcon	left;
	private IIcon	right;
	
	public BlockEdgeStoneCorner()
	{
		super(Material.rock);
	}
	
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("EdgeStone_Bricks_0_Full"));
		this.left = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("EdgeStone_Bricks_0_Left"));
		this.right = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("EdgeStone_Bricks_0_Right"));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		switch (j)
		{
		case 0:
			if (i == 0)
			{
				return this.blockIcon;
			}
			if (i == 1)
			{
				return this.blockIcon;
			}
			
			if (i == 2)
			{
				return this.left;
			}
			if (i == 3)
			{
				return this.blockIcon;
			}
			if (i == 4)
			{
				return this.right;
			}
			if (i == 5)
			{
				return this.blockIcon;
			}
			break;
		
		case 1:
			if (i == 0)
			{
				return this.blockIcon;
			}
			if (i == 1)
			{
				return this.blockIcon;
			}
			
			if (i == 2)
			{
				return this.blockIcon;
			}
			if (i == 3)
			{
				return this.left;
			}
			if (i == 4)
			{
				return this.blockIcon;
			}
			if (i == 5)
			{
				return this.right;
			}
			break;
		
		case 2:
			if (i == 0)
			{
				return this.blockIcon;
			}
			if (i == 1)
			{
				return this.blockIcon;
			}
			
			if (i == 2)
			{
				return this.blockIcon;
			}
			if (i == 3)
			{
				return this.right;
			}
			if (i == 4)
			{
				return this.left;
			}
			if (i == 5)
			{
				return this.blockIcon;
			}
			break;
		
		case 3:
			if (i == 0)
			{
				return this.blockIcon;
			}
			if (i == 1)
			{
				return this.blockIcon;
			}
			
			if (i == 2)
			{
				return this.right;
			}
			if (i == 3)
			{
				return this.blockIcon;
			}
			if (i == 4)
			{
				return this.blockIcon;
			}
			if (i == 5)
			{
				return this.left;
			}
			break;
		case 4:
			if (i == 0)
			{
				return this.blockIcon;
			}
			if (i == 1)
			{
				return this.blockIcon;
			}
			
			if (i == 2)
			{
				return this.blockIcon;
			}
			if (i == 3)
			{
				return this.blockIcon;
			}
			if (i == 4)
			{
				return this.right;
			}
			if (i == 5)
			{
				return this.left;
			}
			break;
		case 5:
			if (i == 0)
			{
				return this.blockIcon;
			}
			if (i == 1)
			{
				return this.blockIcon;
			}
			
			if (i == 2)
			{
				return this.right;
			}
			if (i == 3)
			{
				return this.left;
			}
			if (i == 4)
			{
				return this.blockIcon;
			}
			if (i == 5)
			{
				return this.blockIcon;
			}
			break;
		case 6:
			if (i == 0)
			{
				return this.blockIcon;
			}
			if (i == 1)
			{
				return this.blockIcon;
			}
			
			if (i == 2)
			{
				return this.blockIcon;
			}
			if (i == 3)
			{
				return this.blockIcon;
			}
			if (i == 4)
			{
				return this.left;
			}
			if (i == 5)
			{
				return this.right;
			}
			break;
		case 7:
			if (i == 0)
			{
				return this.blockIcon;
			}
			if (i == 1)
			{
				return this.blockIcon;
			}
			
			if (i == 2)
			{
				return this.left;
			}
			if (i == 3)
			{
				return this.right;
			}
			if (i == 4)
			{
				return this.blockIcon;
			}
			if (i == 5)
			{
				return this.blockIcon;
			}
			break;
		
		}
		return this.blockIcon;
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
		
		par3List.add(new ItemStack(par1, 1, 4));
		par3List.add(new ItemStack(par1, 1, 5));
		par3List.add(new ItemStack(par1, 1, 6));
		par3List.add(new ItemStack(par1, 1, 7));
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return Item.getItemFromBlock(EDBlocks.edgeStoneBrick);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileEntityEdgeStoneCorner();
	}
}
