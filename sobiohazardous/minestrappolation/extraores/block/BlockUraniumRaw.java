package sobiohazardous.minestrappolation.extraores.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.api.util.MUtil;
import sobiohazardous.minestrappolation.extraores.entity.EntityInstantExplosion;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;


public class BlockUraniumRaw extends Block
{
	public BlockUraniumRaw instance;
	public EntityPlayer player;
	public EntityLivingBase living;
	public EntityZombie zombie;
	Random rand = new Random();

	public BlockUraniumRaw(Material par3Material)
	{
		super(par3Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("blockUranium"));
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random)
	{
		return 1;
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
		if (i == Blocks.lava || i == Blocks.mob_spawner || i != null && i == EOBlockManager.UraniumOre)
		{
			return true;
		}
		return i != null && i.getMaterial() != Material.air && i.isOpaqueCube();
	}

	public void updateTick(World world, int i, int j, int k, Random random)
	{
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(i, j, k))
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
		AxisAlignedBB axisalignedbb = getCollisionBoundingBoxFromPool(world, i, j, k).expand(6, 6, 6);
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
				living = (EntityLivingBase) var6.next();
				living.addPotionEffect(new PotionEffect(Potion.poison.getId(), 180, 2, false));
				// varEntityLiving.addPotionEffect(new
				// PotionEffect(Potion.poison.getId(),200,10));
			}
		}
		List list2 = world.getEntitiesWithinAABB(EntityZombie.class, axisalignedbb);
		Iterator var8 = list2.iterator();
		EntityZombie var9;
		if (list2.isEmpty() && world.getBlockMetadata(i, j, k) > 5)
		{
			// System.out.println("far");
		}
		else
			while (var8.hasNext())
			{
				// System.out.println("close");
				zombie = (EntityZombie) var8.next();
				zombie.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 300, 2, false));
				zombie.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 300, 1, false));
				// varEntityLiving.addPotionEffect(new
				// PotionEffect(Potion.poison.getId(),200,10));
			}
		}
	}

	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
	{
		return this.canPlaceBlockAt(par1World, par2, par3, par4);
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		if (MUtil.isWaterTouchingAnySide(par1World, par2, par3, par4))
		{
			return true;
		}
		else
		{
			if (!par1World.isRemote)
			{
				if (rand.nextInt(4) == 1)
				{
					EntityInstantExplosion entitytntprimed = new EntityInstantExplosion(par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, player);
					par1World.spawnEntityInWorld(entitytntprimed);
					par1World.playSoundAtEntity(entitytntprimed, "random.fuse", 1.0F, 1.0F);
				}

			}

		}
		return true;
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
	{
		if (!MUtil.isWaterTouchingAnySide(par1World, par2, par3, par4))
		{
			if (!par1World.isRemote)
			{

				EntityInstantExplosion entitytntprimed = new EntityInstantExplosion(par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, player);
				par1World.spawnEntityInWorld(entitytntprimed);
				par1World.playSoundAtEntity(entitytntprimed, "random.fuse", 1.0F, 1.0F);
			}
		}
	}

	/**
	 * Called upon the block being destroyed by an explosion
	 */
	@Override
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion)
	{
		if (!par1World.isRemote)
		{
			EntityInstantExplosion entitytntprimed = new EntityInstantExplosion(par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, player);
			par1World.spawnEntityInWorld(entitytntprimed);
			par1World.playSoundAtEntity(entitytntprimed, "random.fuse", 1.0F, 1.0F);
		}
	}

	public void func_94391_a(World par1World, int par2, int par3, int par4, int par5, EntityLivingBase par6EntityLivingBase)
	{
		if (!par1World.isRemote)
		{
			if ((par5 & 1) == 1)
			{
				EntityInstantExplosion entitytntprimed = new EntityInstantExplosion(par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, player);
				par1World.spawnEntityInWorld(entitytntprimed);
				par1World.playSoundAtEntity(entitytntprimed, "random.fuse", 1.0F, 1.0F);
			}
		}
	}
}