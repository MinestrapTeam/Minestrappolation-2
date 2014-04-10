package sobiohazardous.minestrappolation.extradecor.block;

import java.util.List;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
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
	public static final String[] bType = new String[] {"brick","smooth","refined"};

	private IIcon refined;
	private IIcon smooth;
	private IIcon brick;
	
	public BlockEndStone() 
	{
		super(Material.rock);
		this.setCreativeTab(EDBlockManager.tabDecorBlocks);
	}

	public void registerBlockIcons(IIconRegister par1IconRegister) 
	{
		this.brick = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Endstone_Bricks_0_0"));
		this.refined = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Endstone_Refine_0_0"));
		this.smooth = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Endstone_Raw_0_0"));
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j) 
	{
			switch (j) 
			{
			case 0:
				return brick;
			case 1:
				return smooth;
			case 2:
				return refined;
			}
			return refined;

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
		}

}