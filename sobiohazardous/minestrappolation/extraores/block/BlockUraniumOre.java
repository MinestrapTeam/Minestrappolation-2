package sobiohazardous.minestrappolation.extraores.block;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
public class BlockUraniumOre extends Block
{
public BlockUraniumOre instance;
public EntityPlayer player;
public EntityLivingBase living;
public EntityZombie zombie;

public BlockUraniumOre(int par1, Material par3Material)
        {
                super(par1, par3Material);
                this.setCreativeTab(CreativeTabs.tabBlock);
        }
   
		public void registerIcons(IconRegister iconRegister)
			{
				blockIcon = iconRegister.registerIcon("extraores:block_UraniumOre");
			}

        /**
         * Returns the ID of the items to drop on destruction.
         */
        public int idDropped(int par1, Random par2Random, int par3)
        {
                return ExtraOres.Uranium.itemID;
        }
        /**
         * Returns the quantity of items to drop on block destruction.
         */
        public int quantityDropped(Random par1Random)
        {
         return 1 + par1Random.nextInt(2);
        }
   
   
        
        //public void onBlockPlacedBy(World par1World, int i, int j, int k, EntityLiving par5EntityLiving)
        //{
        //                par1World.setBlockMetadataWithNotify(i, j, k, blockIndexInTexture);
        //                par1World.scheduleBlockUpdate(i, j, k, blockID, tickRate());
        //}
        
        public void onBlockAdded(World par1World, int par2, int par3, int par4)
        {
                        par1World.setBlockMetadataWithNotify(par2, par3, par4, blockID, par4);
                        par1World.scheduleBlockUpdate(par2, par3, par4, blockID, tickRate());
        }
        
   
        public int tickRate()
        {
                        return 1;
        }
   
        public boolean isTraversable(int i)
        {
                        if(Block.blocksList[i] == Block.lavaStill || Block.blocksList[i] == Block.lavaMoving || Block.blocksList[i] == Block.mobSpawner || Block.blocksList[i] != null && Block.blocksList[i].blockID == ExtraOres.UraniumOre.blockID)
                        {
                                        return true;
                        }
                        return Block.blocksList[i] != null && Block.blocksList[i].blockMaterial != Material.air && Block.blocksList[i].isOpaqueCube();
        }
   
        public void updateTick(World world, int i, int j, int k, Random random)
        {
         world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
                int l = world.getBlockMetadata(i, j, k);
                int i1 = 0;
                int j1 = 0;
                int k1 = 0;
                if(l == 0 || l == 6)
                {
                                j1 = -1;
                                do
                                {
                                                if(j1 < -15)
                                                {
                                                                break;
                                                }
                                                int l1 = world.getBlockId(i, j + j1, k);
                                                if(isTraversable(l1))
                                                {
                                                                j1++;
                                                                break;
                                                }
                                                j1--;
                                } while(true);
                } else
                if(l == 1 || l == 7)
                {
                                j1 = 1;
                                do
                                {
                                                if(j1 > 15)
                                                {
                                                                break;
                                                }
                                                int i2 = world.getBlockId(i, j + j1, k);
                                                if(isTraversable(i2))
                                                {
                                                                j1--;
                                                                break;
                                                }
                                                j1++;
                                } while(true);
                } else
                if(l == 2 || l == 8)
                {
                                k1 = -1;
                                do
                                {
                                                if(k1 < -15)
                                                {
                                                                break;
                                                }
                                                int j2 = world.getBlockId(i, j, k + k1);
                                                if(isTraversable(j2))
                                                {
                                                                k1++;
                                                                break;
                                                }
                                                k1--;
                                } while(true);
                } else
                if(l == 3 || l == 9)
                {
                                k1 = 1;
                                do
                                {
                                                if(k1 > 15)
                                                {
                                                                break;
                                                }
                                                int k2 = world.getBlockId(i, j, k + k1);
                                                if(isTraversable(k2))
                                                {
                                                                k1--;
                                                                break;
                                                }
                                                k1++;
                                } while(true);
                } else
                if(l == 4 || l == 10)
                {
                                i1 = -1;
                                do
                                {
                                                if(i1 < -15)
                                                {
                                                                break;
                                                }
                                                int l2 = world.getBlockId(i + i1, j, k);
                                                if(isTraversable(l2))
                                                {
                                                                i1++;
                                                                break;
                                                }
                                                i1--;
                                } while(true);
                } else
                if(l == 5 || l == 11)
                {
                                i1 = 1;
                                do
                                {
                                                if(i1 > 15)
                                                {
                                                                break;
                                                }
                                                int i3 = world.getBlockId(i + i1, j, k);
                                                if(isTraversable(i3))
                                                {
                                                                i1--;
                                                                break;
                                                }
                                                i1++;
                                } while(true);
                }
                AxisAlignedBB axisalignedbb = getCollisionBoundingBoxFromPool(world, i, j, k).expand(1.5, 1.5, 1.5);
                List list = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
                Iterator var6 = list.iterator();
                EntityLivingBase var7;
                if(list.isEmpty() && world.getBlockMetadata(i, j, k) > 5)
                {
                    //System.out.println("far");
                }
                else
                {
                	while (var6.hasNext())
                    {
                	    //System.out.println("close");
                	    living = (EntityLivingBase)var6.next();
                        living.addPotionEffect(new PotionEffect(Potion.poison.getId(), 120, 1, false));
                	    //varEntityLiving.addPotionEffect(new PotionEffect(Potion.poison.getId(),200,10));          
                    }
                }
                List list2 = world.getEntitiesWithinAABB(EntityZombie.class, axisalignedbb);
                Iterator var8 = list2.iterator();
                EntityZombie var9;
                if(list2.isEmpty() && world.getBlockMetadata(i, j, k) > 5)
                {
                    //System.out.println("far");
                }
                else
                	while (var8.hasNext())
                    {
                	    //System.out.println("close");
                	    zombie = (EntityZombie)var8.next();
                        zombie.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 180, 1, false));
                        zombie.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 180, 0, false));
                	    //varEntityLiving.addPotionEffect(new PotionEffect(Potion.poison.getId(),200,10));          
                    }
        }
}