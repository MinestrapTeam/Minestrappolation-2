package minestrapteam.minestrappolation.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockGodstone extends Block
{
	public BlockGodstone(Material material)
	{
		super(material);
		this.setLightLevel(1F);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate());
	}
	
	public int tickRate()
	{
		return 5;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote)
		{
			world.scheduleBlockUpdate(x, y, z, this, this.tickRate());
			AxisAlignedBB axisalignedbb = this.getCollisionBoundingBoxFromPool(world, x, y, z).expand(6, 6, 6);
			
			List<EntityMob> list = world.getEntitiesWithinAABB(EntityMob.class, axisalignedbb);
			for (EntityMob mob : list)
			{
				mob.setFire(20);
			}
		}
	}
}