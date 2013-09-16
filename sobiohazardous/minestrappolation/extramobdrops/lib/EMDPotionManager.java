package sobiohazardous.minestrappolation.extramobdrops.lib;

import java.util.Iterator;
import java.util.List;

import sobiohazardous.minestrappolation.api.brewing.brewing.Brewing;
import sobiohazardous.minestrappolation.api.brewing.brewing.BrewingList;
import sobiohazardous.minestrappolation.api.potion.MPotion;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EMDPotionManager 
{
	private static String iconLoc = "minestrappolation:gui/potion_icons.png";
	
	public static Potion infectious;
	
	public static Brewing waterBreathing;
	public static Brewing resistance;
	
	public static void loadPotions()
	{
		infectious = new MPotion("potion.infectious", true, 0, false, iconLoc, 0,6).setInGamePotionName("Potion of Infection");
	}
	
	/**
	 * Add potion effects for any time the player is alive
	 * @param event
	 */
	public static void loadPotionEffect(LivingUpdateEvent event)
	{
		if (event.entityLiving.isPotionActive(EMDPotionManager.infectious)) 
		{
			//check if grass is below, then place mycellium below
			if(event.entityLiving.worldObj.getBlockId((int)event.entityLiving.posX-1, (int)event.entityLiving.posY - 2, (int)event.entityLiving.posZ-1) == Block.grass.blockID)
			{
				event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX-1, (int)event.entityLiving.posY - 2, (int)event.entityLiving.posZ-1, Block.mycelium.blockID);		
			}
			
			//check if mycellium is below, then add potion of regen.
			if(event.entityLiving.worldObj.getBlockId((int)event.entityLiving.posX-1, (int)event.entityLiving.posY - 2, (int)event.entityLiving.posZ-1) == Block.mycelium.blockID)
			{
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 1));
			}
			//TODO poison all mobs touched
		} 

	}
	
	/**
	 * Where all Brewing objects are instianted for brewing recipes (view BrewingList.java for help).
	 */
	public static void loadBrewingRecipes()
	{
		waterBreathing = new Brewing(new PotionEffect(Potion.waterBreathing.id, 120 * 20, 0), 2, 1, new ItemStack(EMDItemManager.airSack), BrewingList.awkward);
		waterBreathing.register();
		resistance = new Brewing(new PotionEffect(Potion.resistance.id, 180 * 20), 2, 2, new ItemStack(EMDItemManager.marrow), BrewingList.awkward);
		resistance.register();
	}
	
}
