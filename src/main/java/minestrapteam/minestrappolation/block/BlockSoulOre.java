package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrap_core.block.MCBlock;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSoulOre extends MCBlock
{
	Random	rand	= new Random();
	
	public BlockSoulOre()
	{
		super(Material.sand);
		this.setCreativeTab(Minestrappolation.tabMaterials);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 0.875F, z + 1);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(2);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		entity.motionX *= 0.4D;
		entity.motionZ *= 0.4D;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.soulGem;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		this.dropXpOnBlockBreak(world, x, y, z, this.rand.nextInt(6) + 4);
	}
}
