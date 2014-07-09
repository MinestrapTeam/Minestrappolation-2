package minestrapteam.mcore.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MCBlockMultiPillarStationary extends MCBlockMultiPillar
{
	public MCBlockMultiPillarStationary(Material mat, String[] tops, String[] bottoms)
	{
		super(mat, tops, bottoms);
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	{
		return metadata;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return side == 0 || side == 1 ? this.getTopIcon(metadata) : this.getSideIcon(metadata);
	}
}
