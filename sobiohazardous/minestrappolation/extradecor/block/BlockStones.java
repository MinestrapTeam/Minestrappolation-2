package sobiohazardous.minestrappolation.extradecor.block;

import java.util.List;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockStones extends Block 
{
	private IIcon refined;
	private IIcon tile;
	
	public BlockStones() 
	{
		super(Material.rock);
	}

	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.tile = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Stone_Tiles_0_0"));
		this.refined = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Stone_Refined_0_0"));
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j) 
	 {
			switch (j) {
			case 0:
					return tile;
			case 1:

			}
			return refined;

	}
	
	@SideOnly(Side.CLIENT)		
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) 
	{
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
	}

}
