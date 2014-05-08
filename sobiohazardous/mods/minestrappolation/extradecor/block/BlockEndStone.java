package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockEndStone extends Block
{
	private IIcon	refined;
	private IIcon	smooth;
	private IIcon	brick;
	
	public BlockEndStone()
	{
		super(Material.rock);
		this.setCreativeTab(EDBlocks.tabDecor);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.brick = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Endstone_Bricks_0_0"));
		this.refined = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Endstone_Refined_0_0"));
		this.smooth = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Endstone_Raw_0_0"));
	}
	
	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j)
	{
		switch (j)
		{
		case 0:
			return this.brick;
		case 1:
			return this.smooth;
		case 2:
			return this.refined;
		}
		return this.refined;
		
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
	}
	
}