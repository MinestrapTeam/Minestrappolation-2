package minestrapteam.minestrappolation.common;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.lib.MTools;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

public class MEventHandler
{
	@SubscribeEvent
	public void populateChunk(PopulateChunkEvent.Pre event) 
	{
		final Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX, event.chunkZ);
		final ExtendedBlockStorage[] storageArray = chunk.getBlockStorageArray();
		for (int x = 0; x < 16; x++) 
		{
			for (int z = 0; z < 16; z++) 
			{
				ExtendedBlockStorage storage = storageArray[0]; // 0 <= y < 16
				if (storage != null) 
				{
					for (int y = 0; y < 16; y++) 
					{
						final Block block = storage.getBlockByExtId(x, y, z);
						
						if (block == Blocks.coal_ore) {
							storage.setExtBlockMetadata(x, 0, z, MBlocks.biomeStone.damageDropped(0));
						}
					}
				}
				
				storage = storageArray[1]; // 16 <= y < 32
				
				if (storage != null)
				{
					for (int y = 0; y < 16; y++) 
					{
						if (storage != null) 
						{
							if (storage.getBlockByExtId(x, y, z) == Blocks.coal_ore) 
							{
								storage.setExtBlockMetadata(x, y, z,MBlocks.biomeStone.damageDropped(0));
							}
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
		if (block == MBlocks.magma)
		{
			event.result = new ItemStack(MItems.magmaBucket);
			event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
			event.setResult(Result.ALLOW);
		}
	}
	
	@SubscribeEvent
	public void onDamage(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack stack = player.getHeldItem();
			
			if (stack == null)
			{
				return;
			}
			else if (stack.getItem() == MItems.amuletOves)
			{
				if (player.getRNG().nextInt(8) == 0)
				{
					event.setCanceled(true);
					stack.damageItem(1, player);
				}
			}
			else if (stack.getItem() == MItems.amuletPullum)
			{
				if ("fall".equals(event.source.getDamageType()))
				{
					event.setCanceled(true);
					stack.damageItem(1, player);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void playerUpdate(PlayerTickEvent evt)
	{
		EntityPlayer player = evt.player;
		
		if (evt.phase == Phase.START)
		{
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chest = player.getCurrentArmor(2);
			ItemStack pants = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			if (helmet != null && chest != null && pants != null && boots != null)
			{
				if (helmet.getItem() == MTools.meuroditeHelmet && chest.getItem() == MTools.meuroditeChestplate && pants.getItem() == MTools.meuroditeLeggings && boots.getItem() == MTools.meuroditeBoots)
				{
					player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2, 0, true));
				}
				else if (helmet.getItem() == MTools.toriteHelmet && chest.getItem() == MTools.toriteChestplate && pants.getItem() == MTools.toriteLeggings && boots.getItem() == MTools.toriteBoots)
				{
					player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2, 0, true));
				}
				else if (helmet.getItem() == MTools.titaniumHelmet && chest.getItem() == MTools.titaniumChestplate && pants.getItem() == MTools.titaniumLeggings && boots.getItem() == MTools.titaniumBoots)
				{
					player.addPotionEffect(new PotionEffect(Potion.resistance.id, 2, 1, true));
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onMobDrops(LivingDropsEvent event)
	{
		EntityLivingBase living = event.entityLiving;
		String damageType = event.source.getDamageType();
		
		if ("player".equals(damageType))
		{
			Random random = living.getRNG();
			boolean onFire = living.isBurning();
			int looting = event.lootingLevel;
			int looting1 = looting + 1;
			double rand1 = random.nextDouble() / looting1;
			double rand2 = random.nextDouble() / looting1;
			double rand3 = random.nextDouble() / looting1;
			double rand4 = random.nextDouble() / looting1;
			double rand5 = random.nextDouble() / looting1;
			
			if (living instanceof EntityPig)
			{
				if (rand1 < 0.15D)
				{
					living.dropItem(MItems.snout, random.nextInt(1 + looting));
				}
				if (rand2 < 0.15D)
				{
					living.dropItem(MItems.pigHoof, random.nextInt(4 + looting));
				}
				if (rand3 < 0.3D)
				{
					living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
				}
				if (rand4 < 0.5D)
				{
					living.dropItem(onFire ? MItems.grease : MItems.fat, random.nextInt(5 + looting));
				}
			}
			else if (living instanceof EntityCow)
			{
				if (rand1 < 0.15D)
				{
					living.dropItem(MItems.snout, random.nextInt(1 + looting));
				}
				if (rand2 < 0.3D)
				{
					living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
				}
				if (rand3 < 0.15D)
				{
					living.dropItem(MItems.cowHoof, random.nextInt(4 + looting));
				}
				if (rand4 < 0.05D)
				{
					living.dropItem(MItems.horn, random.nextInt(2 + looting));
				}
			}
			else if (living instanceof EntityMooshroom)
			{
				if (rand1 < 0.15D)
				{
					living.dropItem(MItems.snout, random.nextInt(1 + looting));
				}
				if (rand2 < 0.3D)
				{
					living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
				}
				if (rand3 < 0.25D)
				{
					living.dropItem(MItems.cowHoof, random.nextInt(4 + looting));
				}
				if (rand4 < 0.05D)
				{
					living.dropItem(MItems.horn, random.nextInt(2 + looting));
				}
				if (rand5 < 0.1D)
				{
					living.dropItem(MItems.infectiousFungus, random.nextInt(3 + looting));
				}
			}
			else if (living instanceof EntityHorse)
			{
				if (rand1 < 0.15D)
				{
					living.dropItem(MItems.snout, random.nextInt(1 + looting));
				}
				if (rand2 < 0.2D)
				{
					living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
				}
				if (rand3 < 0.20D)
				{
					living.dropItem(MItems.horseHoof, random.nextInt(4 + looting));
				}
				if (rand4 < 0.5)
				{
					living.dropItem(onFire ? MItems.horseHaunchCooked : MItems.horseHaunchRaw, random.nextInt(3 + looting));
				}
				if (rand5 < 0.3)
				{
					living.dropItem(MItems.horseHair, random.nextInt(4 + looting));
				}
			}
			else if (living instanceof EntityWolf)
			{
				if (rand1 < 0.1D)
				{
					living.dropItem(MItems.snout, random.nextInt(1 + looting));
				}
				if (rand2 < 0.4D)
				{
					living.dropItem(MItems.wolfHide, random.nextInt(3 + looting));
				}
			}
			else if (living instanceof EntityPigZombie)
			{
				if (rand1 < 0.1D)
				{
					living.dropItem(MItems.snout, random.nextInt(1 + looting));
				}
				
				if (rand2 < 0.1D)
				{
					living.dropItem(MItems.pigHoof, random.nextInt(2 + looting));
				}
				
				if (rand3 < 0.15D)
				{
					living.dropItem(onFire ? MItems.grease : MItems.fat, random.nextInt(2 + looting));
				}
				
				if (rand4 < 0.1D)
				{
					living.dropItem(MItems.animalBones, random.nextInt(2 + looting));
				}
				
				if (rand5 < 0.1D)
				{
					living.dropItem(MItems.marrow, random.nextInt(3 + looting));
				}
			}
			else if (living instanceof EntitySheep)
			{
				if (rand1 < 0.3D)
				{
					living.dropItem(MItems.animalBones, random.nextInt(4 + looting));
				}
				
				if (rand2 < 0.7D)
				{
					living.dropItem(onFire ? MItems.lambchopCooked : MItems.lambchopRaw, random.nextInt(3 + looting));
				}
				if (rand3 < 0.15D)
				{
					living.dropItem(MItems.sheepHoof, random.nextInt(3 + looting));
				}
			}
			else if (living instanceof EntityChicken)
			{
				if (rand1 < 0.2D)
				{
					living.dropItem(MItems.animalBones, random.nextInt(2 + looting));
				}
				if (rand2 < 0.15D)
				{
					living.dropItem(MItems.beakChicken, random.nextInt(1 + looting));
				}
				if (rand3 < 0.15D)
				{
					living.dropItem(MItems.footChicken, random.nextInt(2 + looting));
				}
				if (rand4 < 0.5D)
				{
					living.dropItem(onFire ? MItems.chickenWingCooked : MItems.chickenWingRaw, random.nextInt(2 + looting));
				}
			}
			else if (living instanceof EntitySpider)
			{
				if (rand1 < 0.05D)
				{
					living.dropItem(MItems.animalBones, random.nextInt(1 + looting));
				}
				if (rand2 < 0.15D)
				{
					living.dropItem(MItems.legSpider, random.nextInt(4 + looting));
				}
			}
			else if (living instanceof EntityCaveSpider)
			{
				if (rand1 < 0.05D)
				{
					living.dropItem(MItems.animalBones, random.nextInt(1 + looting));
				}
				
				if (rand2 < 0.3D)
				{
					living.dropItem(MItems.poisonSack, random.nextInt(2 + looting));
				}
				
				if (rand3 < 0.15D)
				{
					living.dropItem(MItems.legSpider, random.nextInt(4 + looting));
				}
			}
			else if (living instanceof EntityOcelot)
			{
				if (rand1 < 0.05D)
				{
					living.dropItem(MItems.footChicken, random.nextInt(1 + looting));
				}
				
				if (rand2 < 0.25D)
				{
					living.dropItem(MItems.whisker, random.nextInt(4 + looting));
				}
				if (rand3 < 0.15D)
				{
					living.dropItem(MItems.catEye, random.nextInt(2 + looting));
				}
			}
			else if (living instanceof EntitySquid)
			{
				if (rand1 < 0.4D)
				{
					living.dropItem(MItems.squidTentacle, random.nextInt(4 + looting));
				}
				
				if (rand2 < 0.2D)
				{
					living.dropItem(MItems.airSack, random.nextInt(1 + looting));
				}
			}
			else if (living instanceof EntityVillager)
			{
				if (rand1 < 0.2D)
				{
					living.dropItem(MItems.flesh, random.nextInt(3 + looting));
				}
			}
			else if (living instanceof EntitySkeleton)
			{
				EntitySkeleton skeleton = (EntitySkeleton) living;
				if (skeleton.getSkeletonType() == 1)
				{
					if (rand1 < 0.2D)
					{
						living.dropItem(MItems.witheredBone, random.nextInt(3 + looting));
					}
				}
				else if (rand1 < 0.15D)
				{
					living.dropItem(MItems.marrow, random.nextInt(3 + looting));
				}
			}
			else if (living instanceof EntityBat)
			{
				if (rand1 < 0.5)
				{
					living.dropItem(MItems.guano, random.nextInt(2 + looting));
				}
				if (rand1 < 0.5)
				{
					living.dropItem(MItems.wingSinew, random.nextInt(2 + looting));
				}
			}
			else if (living instanceof EntitySilverfish)
			{
				if (rand1 < 0.5)
				{
					living.dropItem(MItems.carcassSilverfish, 1);
				}
			}
			else if (living instanceof EntityCreeper)
			{
				if (rand1 < 0.1)
				{
					living.dropItem(MItems.hideCreeper, random.nextInt(2 + looting));
				}
			}
			else if (living instanceof EntitySlime)
			{
				if (rand1 < 0.1)
				{
					living.dropItem(MItems.slimeCore, 1);
				}
			}
			else if (living instanceof EntityEnderman)
			{
				if (rand1 < 0.25)
				{
					living.dropItem(MItems.enderCore, 1);
				}
				if (rand1 < 0.20)
				{
					living.dropItem(MItems.enderAura, random.nextInt(2 + looting));
				}
			}
			else if (living instanceof EntityGhast)
			{
				if (rand1 < 0.15)
				{
					living.dropItem(MItems.ghastTentacle, random.nextInt(4 + looting));
				}
			}
			else if (living instanceof EntityWither)
			{
				living.dropItem(MItems.witheredBone, random.nextInt(15 + looting));
			}
		}
	}
	
	@SubscribeEvent
	public void entityInteract(EntityInteractEvent event)
	{
		if (event.target instanceof EntityGhast)
		{
			ItemStack stack = event.entityPlayer.getHeldItem();
			if (stack != null && stack.getItem() == Items.glass_bottle)
			{
				stack.stackSize--;
				event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(MItems.ghastlySoul, 1));
			}
		}
	}
}
