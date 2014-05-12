package sobiohazardous.mods.minestrappolation.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.block.MCBlock;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import sobiohazardous.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBlazium extends MCBlock
{
	public BlockBlazium()
	{
		super(Material.iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEOTexture("blockBlazium"));
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return Item.getItemFromBlock(MBlocks.BlaziumBlock);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		if (fortune > 0 && this != Block.getBlockFromItem(this.getItemDropped(0, random, fortune)))
		{
			int multiplier = random.nextInt(fortune + 2);
			
			return this.quantityDropped(random) * multiplier;
		}
		else
		{
			return this.quantityDropped(random);
		}
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		for (int var5 = 0; var5 < 3; ++var5)
		{
			float x1 = x + 0.5F;
			float y1 = y + random.nextFloat();
			float z1 = z + 0.5F;
			float f = random.nextFloat() * 0.6F - 0.3F;
			float x2 = x1 + f;
			float z2 = z1 + f;
			
			world.spawnParticle("smoke", x1 - 0.52F, y1, z2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x1 - 0.52F, y1, z2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("smoke", x1 + 0.52F, y1, z2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x1 + 0.52F, y1, z2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("smoke", x2, y1, z1 - 0.52F, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x2, y1, z1 - 0.52F, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("smoke", x2, y1, z1 + 0.52F, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x2, y1, z1 + 0.52F, 0.0D, 0.0D, 0.0D);
		}
	}
	
	// code for Blaze-Summoning (Place blazium block over fire)
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		
		if (!world.isRemote)
		{
			if (world.getBlock(x, y - 1, z) == Blocks.fire)
			{
				world.setBlock(x, y, z, Blocks.air);
				world.setBlock(x, y - 1, z, Blocks.air);
				world.setBlock(x, y - 2, z, Blocks.air);
				
				EntityBlaze blaze = new EntityBlaze(world);
				blaze.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(blaze);
				
				for (int i = 0; i < 120; ++i)
				{
					world.spawnParticle("smoke", x + world.rand.nextDouble(), y - 2 + world.rand.nextDouble() * 2.5D, z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	{
		return true;
	}
}