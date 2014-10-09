package minestrapteam.minestrappolation.block.decor;

import java.util.Random;

import minestrapteam.minestrappolation.block.MBlock;
import minestrapteam.minestrappolation.common.MCommonProxy;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPlating extends MBlock
{
	public BlockPlating()
	{
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}
	
	@Override
	public int getRenderType()
	{
		return MCommonProxy.platingRenderID;
	}
	
	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		return true;
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return this.getItemDropped(world.getBlockMetadata(x, y, z), world.rand, 0);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == MBlocks.tinPlate)
		{
			return MItems.plateTinItem;
		}
		else if (this == MBlocks.bronzePlate)
		{
			return MItems.plateBronzeItem;
		}
		else if (this == MBlocks.steelPlate)
		{
			return MItems.plateSteelItem;
		}
		else if (this == MBlocks.meuroditePlate)
		{
			return MItems.plateMeuroditeItem;
		}
		return Item.getItemFromBlock(this);
	}
}
