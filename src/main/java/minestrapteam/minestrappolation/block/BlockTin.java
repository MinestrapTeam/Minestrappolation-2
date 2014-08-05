package minestrapteam.minestrappolation.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class BlockTin extends MBlock
{
	public BlockTin(Material material)
	{
		super(material);
	}
	
	@Override
	public int tickRate(World world)
	{
		return 20;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
		boolean hot = world.getWorldTime() < 12000 && world.canBlockSeeTheSky(x, y, z);
		int metadata = world.getBlockMetadata(x, y, z);
		
		if (hot && metadata == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		else if (metadata == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (world.isRemote)
		{
			return;
		}
		
		if (world.getBlockMetadata(x, y, z) == 1 && entity.posY > y + 1D && entity instanceof EntityItem)
		{
			EntityItem item = (EntityItem) entity;
			ItemStack stack = item.getEntityItem();
			if (stack.getItem() instanceof ItemFood)
			{
				ItemStack result = FurnaceRecipes.smelting().getSmeltingResult(stack);
				if (result != null)
				{
					result = result.copy();
					item.setEntityItemStack(result);
				}
			}
		}
	}
}
