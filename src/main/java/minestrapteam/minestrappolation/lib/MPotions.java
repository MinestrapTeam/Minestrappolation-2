package minestrapteam.minestrappolation.lib;

import clashsoft.brewingapi.potion.IPotionEffectHandler;
import clashsoft.brewingapi.potion.recipe.PotionRecipes;
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
	private static ResourceLocation	iconLoc	= MCAssetManager.getCoreResource("gui/potion_icons.png");
	
	public static Potion			infectious;
	public static Potion ghastTentacle;
	
	public static void loadPotions()
	{
		infectious = new MCPotion("potion.infectious", 0x000000, true).setIcon(iconLoc, 0, 6);
		ghastTentacle = new MCPotion("potion.ghastTentacle", 0xED03D5, true).setIcon(iconLoc, 0, 7);
	}
	
	public static void loadBrewingRecipes()
	{
		PotionRecipes.addRecipe(new ItemStack(MItems.airSack), new PotionEffect(Potion.waterBreathing.id, 120 * 20, 0));
		PotionRecipes.addRecipe(new ItemStack(MItems.marrow), new PotionEffect(Potion.resistance.id, 180 * 20));
	}
	
	@Override
	public void onPotionUpdate(int tick, EntityLivingBase entity, PotionEffect effect)
	{
		if (effect.getPotionID() == infectious.id)
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
		else if (effect.getPotionID() == ghastTentacle.id)
		{
		}
	}
	
	@Override
	public boolean canHandle(PotionEffect effect)
	{
		return effect.getPotionID() == MPotions.infectious.id;
	}
}