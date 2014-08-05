package minestrapteam.minestrappolation.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class MBlockStairs extends BlockStairs
{
	public Block	block;
	public int		meta	= 0;
	
	public MBlockStairs(Block block)
	{
		this(block, 0);
		this.setLightOpacity(0);
		this.block = block;
		if (block instanceof MBlockCustom)
		{
			this.blockHardness = ((MBlockCustom) block).getHardness(0);
			this.blockResistance = ((MBlockCustom) block).getResistance(0);
		}
	}
	
	public MBlockStairs(Block block, int meta)
	{
		super(block, meta);
		this.setLightOpacity(0);
		this.block = block;
		this.meta = meta;
		if (block instanceof MBlockCustom)
		{
			this.blockHardness = ((MBlockCustom) block).getHardness(meta);
			this.blockResistance = ((MBlockCustom) block).getResistance(meta);
		}
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
	{
		if (this.block instanceof MBlockCustom && ((MBlockCustom) this.block).netherrack)
		{
			return this.isSideSolid(world, x, y, z, side);
		}
		return false;
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
	{
		if (this.block instanceof MBlockCustom && ((MBlockCustom) this.block).enderDragonCantDestroy)
		{
			return false;
		}
		return true;
	}
}
