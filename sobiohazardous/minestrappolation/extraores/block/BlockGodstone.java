package sobiohazardous.minestrappolation.extraores.block;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
public class BlockGodstone extends Block
{
public BlockGodstone instance;
public EntityPlayer player;
public EntityLiving living;
public EntityZombie zombie;
public EntitySkeleton skeleton;
public EntityEnderman enderman;
public EntityWither wither;

public BlockGodstone(int par1, Material par3Material)
        {
                super(par1, par3Material);
                this.setCreativeTab(CreativeTabs.tabBlock);
        }
   
		public void registerIcons(IconRegister iconRegister)
		{
				blockIcon = iconRegister.registerIcon("Minestrappolation:block_Godstone");
		}
        /**
         * Returns the ID of the items to drop on destruction.
         */
        public int idDropped(int par1, Random par2Random, int par3)
        {
                return this.blockID;
        }
        /**
         * Returns the quantity of items to drop on block destruction.
         */
        public int quantityDropped(Random par1Random)
        {
         return 1;
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
                        /*Random random = new Random(432L);
                        Tessellator tessellator = Tessellator.instance;
                        for (int i = 0; (float)i < 50; ++i)
                        {
                            GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                            GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                            GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
                            GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                            GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                            GL11.glRotatef(random.nextFloat() * 360.0F + 50 * 90.0F, 0.0F, 0.0F, 1.0F);
                            tessellator.startDrawing(6);
                            float f3 = random.nextFloat() * 20.0F + 5.0F + 50 * 10.0F;
                            float f4 = random.nextFloat() * 2.0F + 1.0F + 50 * 2.0F;
                            tessellator.setColorRGBA_I(16777215, (int)(255.0F * (1.0F - 50)));
                            tessellator.addVertex(0.0D, 0.0D, 0.0D);
                            tessellator.setColorRGBA_I(16711935, 0);
                            tessellator.addVertex(-0.866D * (double)50, (double)50, (double)(-0.5F * 50));
                            tessellator.addVertex(0.866D * (double)50, (double)50, (double)(-0.5F * 50));
                            tessellator.addVertex(0.0D, (double)50, (double)(1.0F * 50));
                            tessellator.addVertex(-0.866D * (double)50, (double)50, (double)(-0.5F * 50));
                            tessellator.draw();
                        }*/
                        //My bullshit code didn't work. This is SUPPOSED to make the block emit ender dragon beam particles, but obviously I put it in the wrong place, because it only makes it crash when placed.
                        //If you can figure out how to fix this, please do.
        }
        
   
        public int tickRate()
        {
                        return 1;
        }
   
        public boolean isTraversable(int i)
        {
                        if(Block.blocksList[i] == Block.lavaStill || Block.blocksList[i] == Block.lavaMoving || Block.blocksList[i] == Block.mobSpawner || Block.blocksList[i] != null && Block.blocksList[i].blockID == EOBlockManager.UraniumOre.blockID)
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
                AxisAlignedBB axisalignedbb = getCollisionBoundingBoxFromPool(world, i, j, k).expand(6, 6, 6);
                
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
                        zombie.setFire(20);
                	    //varEntityLiving.addPotionEffect(new PotionEffect(Potion.poison.getId(),200,10));          
                    }
                List list3 = world.getEntitiesWithinAABB(EntitySkeleton.class, axisalignedbb);
                Iterator var10 = list3.iterator();
                EntitySkeleton var11;
                if(list3.isEmpty() && world.getBlockMetadata(i, j, k) > 5)
                {
                    //System.out.println("far");
                }
                else
                	while (var10.hasNext())
                    {
                	    //System.out.println("close");
                	    skeleton = (EntitySkeleton)var10.next();
                        skeleton.setFire(20);
                	    //varEntityLiving.addPotionEffect(new PotionEffect(Potion.poison.getId(),200,10));          
                    }
                List list4 = world.getEntitiesWithinAABB(EntityEnderman.class, axisalignedbb);
                Iterator var12 = list4.iterator();
                EntityEnderman var13;
                if(list4.isEmpty() && world.getBlockMetadata(i, j, k) > 5)
                {
                    //System.out.println("far");
                }
                else
                	while (var12.hasNext())
                    {
                	    //System.out.println("close");
                	    enderman = (EntityEnderman)var12.next();
                        enderman.setFire(20);
                	    //varEntityLiving.addPotionEffect(new PotionEffect(Potion.poison.getId(),200,10));          
                    }
                List list5 = world.getEntitiesWithinAABB(EntityWither.class, axisalignedbb);
                Iterator var14 = list5.iterator();
                EntityWither var15;
                if(list5.isEmpty() && world.getBlockMetadata(i, j, k) > 5)
                {
                    //System.out.println("far");
                }
                else
                	while (var14.hasNext())
                    {
                	    //System.out.println("close");
                	    wither = (EntityWither)var14.next();
                        wither.setFire(20);
                	    //varEntityLiving.addPotionEffect(new PotionEffect(Potion.poison.getId(),200,10));          
                    }
        }
}