package sobiohazardous.minestrappolation.api.block;

import sobiohazardous.minestrappolation.api.Minestrappolation;
import sobiohazardous.minestrappolation.api.tileentity.TileEntityStonecutter;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStonecutter extends BlockContainer 
{
        public BlockStonecutter(int id) 
        {
                super(id, Material.rock);
                this.setCreativeTab(Minestrappolation.creativeTab);
                this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 3.0F, 0.6F);
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
        
}