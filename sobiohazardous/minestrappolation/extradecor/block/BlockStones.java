package sobiohazardous.minestrappolation.extradecor.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockStones extends Block {

	public static final String[] brickType = new String[] {"tile","refined"};

	private Icon refined;
	private Icon tile;
	public BlockStones(int par1) {
		super(par1, Material.rock);

	}

	public void registerIcons(IconRegister par1IconRegister) {
		this.tile = par1IconRegister
				.registerIcon("Minestrappolation:block_StoneTile");
		this.refined = par1IconRegister
				.registerIcon("Minestrappolation:block_StoneRefined");

	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	 @SideOnly(Side.CLIENT)
		public Icon getIcon(int i, int j) {
			switch (j) {
			case 0:
					return tile;
			case 1:

			}
			return refined;

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
		}

}
