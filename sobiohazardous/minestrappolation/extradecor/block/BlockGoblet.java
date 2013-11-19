package sobiohazardous.minestrappolation.extradecor.block;

import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityGoblet;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGoblet extends BlockContainer{

	public BlockGoblet(int par1, Material par2Material) {
		super(par1, Material.rock);
		
		this.setBlockBounds(1F/16F*5F, 0F, 1F/16F*5F, 1F-1F/16F*5F, 1F-1F/16F*5F, 1F-1F/16F*5F);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        int itemstack = par5EntityPlayer.inventory.getCurrentItem().itemID;

        if (itemstack == Item.appleRed.itemID)
        {
        	par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 1));
            return true;
        }
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGoblet();
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
	
	public void registerIcon(IconRegister icon){
		this.blockIcon = icon.registerIcon("Minestrappolation:block_Goblet");
	}

}
