package minestrapteam.minestrappolation.lib;

import clashsoft.brewingapi.potion.IPotionEffectHandler;
import clashsoft.brewingapi.potion.recipe.PotionRecipes;
import clashsoft.brewingapi.potion.type.PotionType;
import minestrapteam.mcore.potion.MCPotion;
import minestrapteam.mcore.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class MPotions implements IPotionEffectHandler
{
	private static ResourceLocation	iconLoc				= MCAssetManager.getCoreResource("gui/potion_icons.png");
	
	public static Potion			infectiousPotion	= new MCPotion("potion.infectious", 0xFE3040, true).setIcon(iconLoc, 6, 1);
	public static Potion			ghastTentaclePotion	= new MCPotion("potion.ghastTentacle", 0xED03D5, true).setIcon(iconLoc, 7, 1);
	
	public static PotionType		infectious;
	public static PotionType		ghastTentacle;
	
	public static void loadPotions()
	{
		PotionType infectious1 = new PotionType(new PotionEffect(infectiousPotion.id, 120 * 20), 1, 240 * 20);
		PotionType ghastTentacle1 = new PotionType(new PotionEffect(ghastTentaclePotion.id, 90 * 20), 0, 210 * 20);
	}
	
	public static void loadBrewingRecipes()
	{
		PotionRecipes.addRecipe(new ItemStack(MItems.infectiousFungus), infectious);
		PotionRecipes.addRecipe(new ItemStack(MItems.ghastTentacle), ghastTentacle);
		PotionRecipes.addRecipe(new ItemStack(MItems.airSack), new PotionEffect(Potion.waterBreathing.id, 120 * 20, 0));
		PotionRecipes.addRecipe(new ItemStack(MItems.marrow), new PotionEffect(Potion.resistance.id, 180 * 20));
	}
	
	@Override
	public void onPotionUpdate(int tick, EntityLivingBase entity, PotionEffect effect)
	{
		if (effect.getPotionID() == infectiousPotion.id)
		{
			Block block = entity.worldObj.getBlock((int) entity.posX - 1, (int) entity.posY - 1, (int) entity.posZ - 1);
			if (block == Blocks.grass)
			{
				entity.worldObj.setBlock((int) entity.posX - 1, (int) entity.posY - 1, (int) entity.posZ - 1, Blocks.mycelium);
			}
			else if (block == Blocks.mycelium)
			{
				entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1, 1));
			}
		}
		else if (effect.getPotionID() == ghastTentaclePotion.id)
		{
			if (entity.dimension != -1)
			{
				entity.travelToDimension(-1);
				entity.addPotionEffect(new PotionEffect(Potion.confusion.id, effect.getDuration(), 0));
			}
			else if (effect.getDuration() < 10)
			{
				entity.travelToDimension(0);
			}
		}
	}
	
	@Override
	public boolean canHandle(PotionEffect effect)
	{
		return effect.getPotionID() == infectiousPotion.id || effect.getPotionID() == ghastTentaclePotion.id;
	}
}