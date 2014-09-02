package minestrapteam.minestrappolation.common;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MDrops;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.lib.MTools;
import minestrapteam.minestrappolation.world.MOreGenerator;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;

public class MEventHandler
{
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
		String damageType = event.source.getDamageType();	
		if ("player".equals(damageType))
		{
			MDrops.onMobDrops(event);
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
	
	@SubscribeEvent
	public void genBiomeTerrain(ReplaceBiomeBlocks event)
	{
		Random random = new Random(event.world.getSeed());
		for (int k = 0; k < 16; ++k)
		{
			for (int l = 0; l < 16; ++l)
			{
				BiomeGenBase biome = event.biomeArray[l + k * 16];
				MOreGenerator.genBiomeStone(biome, event.world, random, event.blockArray, event.metaArray, event.chunkX * 16 + k, event.chunkZ * 16 + l);
			}
		}
	}
}
