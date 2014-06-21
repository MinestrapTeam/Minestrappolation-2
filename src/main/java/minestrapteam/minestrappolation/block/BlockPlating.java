package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrap_core.block.MCBlock;
import minestrapteam.minestrappolation.client.MClientProxy;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPlating extends MCBlock
{
	public BlockPlating()
	{
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.setCreativeTab(null);
	}
	
	@Override
	public int getRenderType()
	{
		return MClientProxy.platingRenderID;
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
