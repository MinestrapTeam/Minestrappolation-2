package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDItemManager;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityEdgeStoneCorner;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockEdgeStoneCorner extends BlockContainer
{
    @SideOnly(Side.CLIENT)
	private IIcon left;
	private IIcon right;
	
	public BlockEdgeStoneCorner() 
	{
		super(Material.rock);	
	}

	public int damageDropped(int par1)
    {
        return par1;
    }
	
    @SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) 
    {
		this.blockIcon = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("EdgeStone_Bricks_0_Full"));
		this.left = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("EdgeStone_Bricks_0_Right"));
		this.right = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("EdgeStone_Bricks_0_Left"));
	}

    @SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j) 
    {
		switch (j) {
		case 0:
			if (i == 0)// bottom

				return blockIcon;
			if (i == 1)// top

				return blockIcon;

			if (i == 2) // side

				return left;
			if (i == 3)// side

				return blockIcon;
			if (i == 4) // side

				return right;
			if (i == 5) // side

				return blockIcon;
			break;
			
		case 1:
			if (i == 0)// bottom

				return blockIcon;
			if (i == 1)// top

				return blockIcon;

			if (i == 2) // side

				return blockIcon;
			if (i == 3)// side

				return left;
			if (i == 4) // side

				return blockIcon;
			if (i == 5) // side

				return right;
			break;
			
		case 2:
			if (i == 0)// bottom

				return blockIcon;
			if (i == 1)// top

				return blockIcon;

			if (i == 2) // side

				return blockIcon;
			if (i == 3)// side

				return right;
			if (i == 4) // side

				return left;
			if (i == 5) // side

				return blockIcon;
			break;
			
		case 3:
			if (i == 0)// bottom

				return blockIcon;
			if (i == 1)// top

				return blockIcon;

			if (i == 2) // side

				return right;
			if (i == 3)// side

				return blockIcon;
			if (i == 4) // side

				return blockIcon;
			if (i == 5) // side

				return left;
			break;
		case 4:
			if (i == 0)// bottom

				return blockIcon;
			if (i == 1)// top

				return blockIcon;

			if (i == 2) // side

				return blockIcon;
			if (i == 3)// side

				return blockIcon;
			if (i == 4) // side

				return right;
			if (i == 5) // side

				return left;
			break;
		case 5:
			if (i == 0)// bottom

				return blockIcon;
			if (i == 1)// top

				return blockIcon;

			if (i == 2) // side

				return right;
			if (i == 3)// side

				return left;
			if (i == 4) // side

				return blockIcon;
			if (i == 5) // side

				return blockIcon;
			break;
		case 6:
			if (i == 0)// bottom

				return blockIcon;
			if (i == 1)// top

				return blockIcon;

			if (i == 2) // side

				return blockIcon;
			if (i == 3)// side

				return blockIcon;
			if (i == 4) // side

				return left;
			if (i == 5) // side

				return right;
			break;
		case 7:
			if (i == 0)// bottom

				return blockIcon;
			if (i == 1)// top

				return blockIcon;

			if (i == 2) // side

				return left;
			if (i == 3)// side

				return right;
			if (i == 4) // side

				return blockIcon;
			if (i == 5) // side

				return blockIcon;
			break;

		}
		return blockIcon;

	}
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
		return Item.getItemFromBlock(EDBlockManager.edgeStoneBrick);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileEntityEdgeStoneCorner();
	}
}
