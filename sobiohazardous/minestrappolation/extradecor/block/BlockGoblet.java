package sobiohazardous.minestrappolation.extradecor.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDItemManager;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityGoblet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockGoblet extends BlockContainer{
	
	public static final String[] g = new String[] {"0", "1", "2", "3","4","5","6","7"};

	public BlockGoblet(int par1, Material par2Material) {
		super(par1, Material.grass);
		this.setBlockBounds(1F/16F*5F, 0F, 1F/16F*5F, 1F-1F/16F*5F, 1F-1F/16F*5F, 1F-1F/16F*5F);
	}
	@SideOnly(Side.CLIENT)


	public void registerIcon(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon("Minestrappolation:block_CardboardBlock.png");
	}
	
	public Icon getIcon(int i,int j){
		switch(j){
		case 0:
			return this.blockIcon;
		default:
			return this.blockIcon;		
		}
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        switch(meta){
        case 0:
        	if(par5EntityPlayer.getCurrentEquippedItem() == null){
            	return false;
            }else
        	if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.inventory.getCurrentItem().itemID == Item.bucketWater.itemID)
            {
        		par5EntityPlayer.inventory.getCurrentItem().stackSize --;
        		par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty));
            	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet.blockID, 1,2);
                return true;
            }
        	else if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.inventory.getCurrentItem().itemID == Item.bucketMilk.itemID)
            {
        		par5EntityPlayer.inventory.getCurrentItem().stackSize --;
        		par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketEmpty));
            	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet.blockID, 2,2);
                return true;
            }
        	
        case 1:
        		par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet.blockID, 0,2);
        		if(par5EntityPlayer.isBurning()){
        			par5EntityPlayer.extinguish();
        		}
            	return true;
            	
        case 2:
        	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet.blockID, 0,2);
        	par5EntityPlayer.curePotionEffects(new ItemStack(Item.bucketMilk));
        	return true;
        	
        }
		return true;

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
	
	
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
	}
	
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return EDItemManager.gobletItem.itemID;
    }
	
	@Override
    public int idDropped(int par1, Random par2Random, int par3)
	{
		return EDItemManager.gobletItem.itemID;
	}

}
