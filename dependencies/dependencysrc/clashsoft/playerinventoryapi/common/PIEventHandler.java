package clashsoft.playerinventoryapi.common;

import clashsoft.playerinventoryapi.PlayerInventoryAPI;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class PIEventHandler
{
	@SubscribeEvent
	public void entityConstructing(EntityConstructing event)
	{
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER && event.entity instanceof EntityPlayer)
		{
			ExtendedInventory props = new ExtendedInventory((EntityPlayer) event.entity);
			ExtendedInventory.set((EntityPlayer) event.entity, props);
		}
	}
	
	@SubscribeEvent
	public void entityJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			
			PlayerInventoryAPI.proxy.replaceInventory(player);
			
			if (!event.world.isRemote)
			{
				ExtendedInventory ei = ExtendedInventory.get(player);
				ei.sync();
			}
		}
	}
	
	@SubscribeEvent
	public void onTick(TickEvent.PlayerTickEvent event)
	{
		if (event.phase == Phase.START)
		{
			ExtendedInventory.get(event.player).onUpdate();
		}
	}
	
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			ExtendedInventory.get((EntityPlayer) event.entityLiving).dropAllItems();
		}
	}
	
	@SubscribeEvent
	public void onItemPickup(EntityItemPickupEvent event)
	{
		EntityPlayer player = event.entityPlayer;
		ItemStack stack = event.item.getEntityItem();
		
		if (player.inventory.getFirstEmptyStack() == -1 && !ExtendedInventory.get(player).addItemStack(stack))
		{
			event.setResult(Result.DENY);
		}
	}
}
