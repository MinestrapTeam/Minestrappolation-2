package sobiohazardous.minestrappolation.extradecor.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extradecor.ExtraDecor;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityEdgeStoneCorner;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
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
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockEdgeStoneCorner extends BlockContainer{
    @SideOnly(Side.CLIENT)
	private Icon left;
	private Icon right;
	
	public static final String[] cType = new String[] {"0", "1", "2", "3","4","5","6","7"};

	public BlockEdgeStoneCorner(int par1) {
		super(par1, Material.rock);
	
	}

	public int damageDropped(int par1)
    {
        return par1;
    }
    @SideOnly(Side.CLIENT)


	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister
				.registerIcon("Minestrappolation:block_EdgeStoneFull");
		this.left = par1IconRegister
				.registerIcon("Minestrappolation:block_EdgeStoneSideRight");
		this.right = par1IconRegister
				.registerIcon("Minestrappolation:block_EdgeStoneSideLeft");

	}

    @SideOnly(Side.CLIENT)
	public Icon getIcon(int i, int j) {
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
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
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
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityEdgeStoneCorner();
	}

	@Override
    public int idDropped(int par1, Random par2Random, int par3)
	{
		return EDBlockManager.edgeStoneBrick.blockID;
	}
}
