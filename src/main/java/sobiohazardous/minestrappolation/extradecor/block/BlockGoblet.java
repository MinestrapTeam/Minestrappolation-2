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
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockGoblet extends BlockContainer
{
	public static final String[] g = new String[] {"0", "1", "2", "3","4","5","6","7"};

	public BlockGoblet(Material par2Material) 
	{
		super(Material.grass);
		this.setBlockBounds(1F/16F*5F, 0F, 1F/16F*5F, 1F-1F/16F*5F, 1F-1F/16F*5F, 1F-1F/16F*5F);
	}
	@SideOnly(Side.CLIENT)


	public void registerBlockIcon(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("Minestrappolation:block_CardboardBlock.png");
	}
	
	public IIcon getIcon(int i,int j)
	{
		switch(j)
		{
		case 0:
			return this.blockIcon;
		default:
			return this.blockIcon;		
		}
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        switch(meta)
        {
        case 0:
        	if(par5EntityPlayer.getCurrentEquippedItem() == null)
        	{
            	return false;
            }else
        	if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.inventory.getCurrentItem().getItem() == Items.water_bucket)
            {
        		par5EntityPlayer.inventory.getCurrentItem().stackSize --;
        		par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
            	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet, 1,2);
                return true;
            }
        	else if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.inventory.getCurrentItem().getItem() == Items.milk_bucket)
            {
        		par5EntityPlayer.inventory.getCurrentItem().stackSize --;
        		par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
            	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet, 2,2);
                return true;
            }
        	else if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.inventory.getCurrentItem() == new ItemStack(Items.potionitem,1,8026))
            {
        		par5EntityPlayer.inventory.getCurrentItem().stackSize --;
        		par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
            	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet, 3,2);
                return true;
            }
        	else if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.inventory.getCurrentItem() == new ItemStack(Items.potionitem,1,8193))
            {
        		par5EntityPlayer.inventory.getCurrentItem().stackSize --;
        		par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
            	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet, 4,2);
                return true;
            }
        	
        case 1:
        		par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet, 0,2);
        		if(par5EntityPlayer.isBurning())
        		{
        			par5EntityPlayer.extinguish();
        		}
            	return true;
            	
        case 2:
        	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet, 0,2);
        	par5EntityPlayer.curePotionEffects(new ItemStack(Items.milk_bucket));
        	return true;
        	
        case 3:
        	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet, 0,2);
        	par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.invisibility.id,3490,0,true));
        	return true;
        case 4:
        	par1World.setBlock(par2, par3, par4, EDBlockManager.Goblet, 0,2);
        	par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id,3490,0,true));
        	return true;
        	
        }
		return true;

    }
	
	public int getRenderType()
	{
		return -1;	
	}

	public boolean isOpaqueCube()
	{
		return false;		
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) 
	{
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
		par3List.add(new ItemStack(par1, 1, 4));
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)    
	{
		return EDItemManager.gobletItem;
	}
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) 
	{
		return new TileEntityGoblet();
	}

}
