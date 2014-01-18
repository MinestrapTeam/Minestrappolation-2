package sobiohazardous.minestrappolation.api.block;

import sobiohazardous.minestrappolation.api.Minestrappolation;
import sobiohazardous.minestrappolation.api.tileentity.TileEntityStonecutter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockStonecutter extends BlockContainer
{
        public BlockStonecutter(int id) 
        {
                super(id, Material.rock);
                this.setCreativeTab(Minestrappolation.creativeTab);
        }

        public void registerIcons(IconRegister ir)
        {
        	blockIcon = ir.registerIcon("Minestrappolation:block_StoneCutterFullFront");
        }
        
        @Override
        public TileEntity createNewTileEntity(World world) 
        {
                return new TileEntityStonecutter();
        }
        
        @Override
        public int getRenderType() 
        {
                return -1;
        }
        
        @Override
        public boolean isOpaqueCube() 
        {
                return false;
        }
        
        public boolean renderAsNormalBlock() 
        {
                return false;
        }
        
        /**
         * Called whenever the block is added into the world. Args: world, x, y, z
         */
        public void onBlockAdded(World par1World, int par2, int par3, int par4)
        {
            super.onBlockAdded(par1World, par2, par3, par4);
            this.setDefaultDirection(par1World, par2, par3, par4);
        }
        
        /**
         * set a blocks direction
         */
        private void setDefaultDirection(World par1World, int par2, int par3, int par4)
        {
            if (!par1World.isRemote)
            {
                int l = par1World.getBlockId(par2, par3, par4 - 1);
                int i1 = par1World.getBlockId(par2, par3, par4 + 1);
                int j1 = par1World.getBlockId(par2 - 1, par3, par4);
                int k1 = par1World.getBlockId(par2 + 1, par3, par4);
                byte b0 = 3;

                if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
                {
                    b0 = 3;
                }

                if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
                {
                    b0 = 2;
                }

                if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
                {
                    b0 = 5;
                }

                if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
                {
                    b0 = 4;
                }

                par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
            }
        }
        
        /**
         * Called when the block is placed in the world.
         */
        public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
        {
            int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

            if (l == 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
            }

            if (l == 1)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
            }

            if (l == 2)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
            }

            if (l == 3)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
            }
        }
}