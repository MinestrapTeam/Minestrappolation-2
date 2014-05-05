package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOConfig;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;


public class BlockPlutoniumOre extends Block
{
	public BlockPlutoniumOre instance;
	public EntityPlayer player;
	public EntityLivingBase living;
	public EntitySkeleton skeleton;
	public EntityZombie zombie;

	public BlockPlutoniumOre(Material par3Material)
	{
		super(par3Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	Random rand = new Random();

	public void registerIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("orePlutonium"));
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
    public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return EOItems.Plutonium;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random)
	{
		return 1 + par1Random.nextInt(2);
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, par4);
		par1World.scheduleBlockUpdate(par2, par3, par4, this, tickRate());
	}

	public int tickRate()
	{
		return 1;
	}

	public boolean isTraversable(Block i)
	{
		if (i == Blocks.lava || i == Blocks.mob_spawner || i != null && i == EOBlocks.UraniumOre)
		{
			return true;
		}
		return i != null && i.getMaterial() != Material.air && i.isOpaqueCube();
	}

	public void updateTick(World world, int i, int j, int k, Random random)
	{
		world.scheduleBlockUpdate(i, j, k, this, tickRate());
		int l = world.getBlockMetadata(i, j, k);
		int i1 = 0;
		int j1 = 0;
		int k1 = 0;
		if (l == 0 || l == 6)
		{
			j1 = -1;
			do
			{
				if (j1 < -15)
				{
					break;
				}
				Block l1 = world.getBlock(i, j + j1, k);
				if (isTraversable(l1))
				{
					j1++;
					break;
				}
				j1--;
			} while (true);
		}
		else if (l == 1 || l == 7)
		{
			j1 = 1;
			do
			{
				if (j1 > 15)
				{
					break;
				}
				Block i2 = world.getBlock(i, j + j1, k);
				if (isTraversable(i2))
				{
					j1--;
					break;
				}
				j1++;
			} while (true);
		}
		else if (l == 2 || l == 8)
		{
			k1 = -1;
			do
			{
				if (k1 < -15)
				{
					break;
				}
				Block j2 = world.getBlock(i, j, k + k1);
				if (isTraversable(j2))
				{
					k1++;
					break;
				}
				k1--;
			} while (true);
		}
		else if (l == 3 || l == 9)
		{
			k1 = 1;
			do
			{
				if (k1 > 15)
				{
					break;
				}
				Block k2 = world.getBlock(i, j, k + k1);
				if (isTraversable(k2))
				{
					k1--;
					break;
				}
				k1++;
			} while (true);
		}
		else if (l == 4 || l == 10)
		{
			i1 = -1;
			do
			{
				if (i1 < -15)
				{
					break;
				}
				Block l2 = world.getBlock(i + i1, j, k);
				if (isTraversable(l2))
				{
					i1++;
					break;
				}
				i1--;
			} while (true);
		}
		else if (l == 5 || l == 11)
		{
			i1 = 1;
			do
			{
				if (i1 > 15)
				{
					break;
				}
				Block i3 = world.getBlock(i + i1, j, k);
				if (isTraversable(i3))
				{
					i1--;
					break;
				}
				i1++;
			} while (true);
		}
		AxisAlignedBB axisalignedbb = getCollisionBoundingBoxFromPool(world, i, j, k).expand(1.5, 1.5, 1.5);
		List list = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		Iterator var6 = list.iterator();
		EntityLivingBase var7;
		if (list.isEmpty() && world.getBlockMetadata(i, j, k) > 5)
		{
			// System.out.println("far");
		}
		else
		{
			while (var6.hasNext())
			{
				// System.out.println("close");
				if (EOConfig.shouldOresEffect)
				{
					living = (EntityLivingBase) var6.next();
					living.addPotionEffect(new PotionEffect(Potion.wither.getId(), 20, 1, false));
					// varEntityLiving.addPotionEffect(new
					// PotionEffect(Potion.poison.getId(),200,10));
				}
			}
		}
		List list2 = world.getEntitiesWithinAABB(EntitySkeleton.class, axisalignedbb);
		Iterator var8 = list2.iterator();
		EntitySkeleton var9;
		if (list2.isEmpty() && world.getBlockMetadata(i, j, k) > 5)
		{
			// System.out.println("far");
		}
		else
			while (var8.hasNext())
			{
				// System.out.println("close");
				if (EOConfig.shouldOresEffect)
				{
					skeleton = (EntitySkeleton) var8.next();
					skeleton.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 180, 0, false));
					skeleton.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 180, 0, false));
					skeleton.removePotionEffect(Potion.wither.getId());
					// varEntityLiving.addPotionEffect(new
					// PotionEffect(Potion.poison.getId(),200,10));
				}
			}
	}

	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
	{
		this.spawnParticle(par1World, par2, par3, par4);
		super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
	}

	public void spawnParticle(World par1World, int par2, int par3, int par4)
	{
		Random var5 = par1World.rand;
		double var6 = 0.0625D;

		for (int var8 = 0; var8 < 6; ++var8)
		{
			double var9 = (double) ((float) par2 + var5.nextFloat());
			double var11 = (double) ((float) par3 + var5.nextFloat());
			double var13 = (double) ((float) par4 + var5.nextFloat());

			if (var8 == 0 && !par1World.isBlockNormalCubeDefault(par2, par3 + 1, par4, true))
			{
				var11 = (double) (par3 + 1) + var6;
			}

			if (var8 == 1 && !par1World.isBlockNormalCubeDefault(par2, par3 - 1, par4, true))
			{
				var11 = (double) (par3 + 0) - var6;
			}

			if (var8 == 2 && !par1World.isBlockNormalCubeDefault(par2, par3, par4 + 1, true))
			{
				var13 = (double) (par4 + 1) + var6;
			}

			if (var8 == 3 && !par1World.isBlockNormalCubeDefault(par2, par3, par4 - 1, true))
			{
				var13 = (double) (par4 + 0) - var6;
			}

			if (var8 == 4 && !par1World.isBlockNormalCubeDefault(par2 + 1, par3, par4, true))
			{
				var9 = (double) (par2 + 1) + var6;
			}

			if (var8 == 5 && !par1World.isBlockNormalCubeDefault(par2 - 1, par3, par4, true))
			{
				var9 = (double) (par2 + 0) - var6;
			}

			if (var9 < (double) par2 || var9 > (double) (par2 + 1) || var11 < 0.0D || var11 > (double) (par3 + 1) || var13 < (double) par4 || var13 > (double) (par4 + 1))
			{
				par1World.spawnParticle("mobSpell", var9, var11, var13, 0.0D, 0.0D, 0.0D);
			}
			//TODO test if the particle is correct! If not, change to "smoke"
		}
	}

	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	{
		this.dropXpOnBlockBreak(par1World, par2, par3, par4, rand.nextInt(6) + 1); // 1 is the XP it drops 
	}
}