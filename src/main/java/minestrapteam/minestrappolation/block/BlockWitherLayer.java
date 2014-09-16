package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWitherLayer extends Block
{
	public BlockWitherLayer()
	{
		super(Material.ground);
		this.setLightOpacity(0);
	}
	
    @Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z) & 7;
        return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + l * 0.125F, z + this.maxZ);
    }

    @Override
	public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
	public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0);
    }

    @Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        this.setBlockBounds(world.getBlockMetadata(x, y, z));
    }

    protected void setBlockBounds(int metadata)
    {
        int j = (metadata & 7) + 1;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, j * 0.125F, 1.0F);
    }
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.witherAsh;
	}
	
	@Override
	public int quantityDropped(int metadata, int fortune, Random random)
    {
        return (metadata & 7) + 1;
    }

    @Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        return meta < 7 && this.blockMaterial.isReplaceable();
    }
}