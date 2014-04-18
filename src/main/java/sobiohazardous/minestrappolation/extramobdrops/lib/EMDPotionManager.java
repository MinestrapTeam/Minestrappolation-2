package sobiohazardous.minestrappolation.extramobdrops.lib;

import java.util.Iterator;
import java.util.List;

import clashsoft.brewingapi.potion.IPotionEffectHandler;
import clashsoft.brewingapi.potion.PotionList;
import clashsoft.brewingapi.potion.type.PotionType;

import sobiohazardous.minestrappolation.api.potion.MPotion;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EMDPotionManager implements IPotionEffectHandler
{
	private static String iconLoc = "minestrappolation:gui/potion_icons.png";

	public static Potion infectious;

	public static PotionType waterBreathing;
	public static PotionType resistance;

	public static void loadPotions()
	{
		infectious = new MPotion("potion.infectious", true, 0, false, iconLoc, 0,6).setInGamePotionName("Potion of Infection");
	}	

	/**
	 * Where all Brewing objects are instianted for brewing recipes (view BrewingList.java for help).
	 */
	public static void loadBrewingRecipes()
	{
		waterBreathing = new PotionType(new PotionEffect(Potion.waterBreathing.id, 120 * 20, 0), 2, 1, new ItemStack(EMDItemManager.airSack), PotionList.awkward);
		waterBreathing.register();
		resistance = new PotionType(new PotionEffect(Potion.resistance.id, 180 * 20), 2, 2, new ItemStack(EMDItemManager.marrow), PotionList.awkward);
		resistance.register();
	}

	@Override
	public void onPotionUpdate(int tick, EntityLivingBase entity, PotionEffect effect)
	{
		if (effect.getPotionID() == EMDPotionManager.infectious.id)
		{
			//check if grass is below, then place mycellium below
			if(entity.worldObj.getBlock((int)entity.posX-1, (int)entity.posY - 1, (int)entity.posZ-1) == Blocks.grass)
			{
				entity.worldObj.setBlock((int)entity.posX-1, (int)entity.posY - 2, (int)entity.posZ-1, Blocks.mycelium);		
			}

			//check if mycellium is below, then add potion of regen.
			if(entity.worldObj.getBlock((int)entity.posX-1, (int)entity.posY - 1, (int)entity.posZ-1) == Blocks.mycelium)
			{
				entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 1));
			}
			//TODO poison all mobs touched										
		}
	}

	@Override
	public boolean canHandle(PotionEffect effect)
	{
		return effect.getPotionID() == EMDPotionManager.infectious.id;
	}	
}