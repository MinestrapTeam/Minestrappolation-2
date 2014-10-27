package minestrapteam.minestrappolation.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public abstract class BlockRadiation extends Block
{
	protected BlockRadiation(Material material)
	{
		super(material);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.scheduleBlockUpdate(x, y, z, this, 1);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote)
		{
			world.scheduleBlockUpdate(x, y, z, this, 20);
			
			float range = this.getRange();
			AxisAlignedBB axisalignedbb = this.getCollisionBoundingBoxFromPool(world, x, y, z).expand(range, range, range);
			List<EntityLivingBase> list = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
			
			for (EntityLivingBase living : list)
			{
				this.addPotionEffect(living);
			}
		}
	}
	
	public abstract void addPotionEffect(EntityLivingBase living);
	
	public abstract float getRange();
}
