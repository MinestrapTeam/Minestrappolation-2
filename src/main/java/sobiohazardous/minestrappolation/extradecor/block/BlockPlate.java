package sobiohazardous.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityPlate;
import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockPlate extends BlockContainer{

	public BlockPlate(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(EDBlockManager.tabDecorBlocks);
		this.setBlockBounds(1F/16F, 0F, 1F/16F, 1F-1F/16F, 1F-1F/16F*14F, 1F-1F/16F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPlate();
	}
	
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister
				.registerIcon("Minestrappolation:block_StoneTile");


	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	 @SideOnly(Side.CLIENT)
		public Icon getIcon(int i, int j) {
			return blockIcon;

		}
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
	    ItemStack currItem = par5EntityPlayer.inventory.getCurrentItem();
	    TileEntityPlate te = (TileEntityPlate) par1World.getBlockTileEntity(par2, par3, par4);
	    if(currItem != null)
	    {
	    	te.render(true, currItem);
	    }
	    
	    if(!par5EntityPlayer.capabilities.isCreativeMode)
	    {
	    	par5EntityPlayer.inventory.getCurrentItem().stackSize--;
	    }
		return true;	
	}
	
	public int getRenderType(){
		return -1;	
	}

	public boolean isOpaqueCube(){
		return false;		
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}

}
