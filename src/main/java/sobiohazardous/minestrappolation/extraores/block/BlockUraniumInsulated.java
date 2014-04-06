package sobiohazardous.minestrappolation.extraores.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;

public class BlockUraniumInsulated extends Block
{
	private static final EntityLivingBase par6EntityLiving = null;
	public BlockUraniumInsulated instance;
	public EntityPlayer player;
	public EntityLivingBase living;
	public EntitySkeleton skeleton;
	public EntityZombie zombie;
	public World world;
	private IIcon topbottom;

	public BlockUraniumInsulated(Material par3Material)
	{
		super(par3Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("uraniumInsulatedSide"));
		topbottom = iconRegister.registerIcon("iron_block");
	}

	public IIcon getIcon(int i, int j)
	{
		if (i == 0)// bottom

			return topbottom;
		if (i == 1)// top

			return topbottom;

		if (i == 2) // side

			return blockIcon;
		if (i == 3)// side

			return blockIcon;
		if (i == 4) // side

			return blockIcon;
		if (i == 5) // side

			return blockIcon;

		if (j == 1)
		{
			return blockIcon;
		}
		return blockIcon;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
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

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5)
	{
		if (!par1World.isRemote)
		{
			if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
			{
				par1World.scheduleBlockUpdate(par2, par3, par4, this, 4);
			}
		}
	}
}