package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItemFood;
import sobiohazardous.mods.minestrappolation.extramobdrops.handler.EMDPlayerTickHandler;

public class ItemGhastTentacle extends MItemFood
{
	public ItemGhastTentacle()
	{
		super(0, 0F);
		this.setAlwaysEdible();
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		
		if (player instanceof EntityPlayerMP)
		{
			EntityPlayerMP playermp = (EntityPlayerMP) player;
			
			if (player.dimension == 0)
			{
				playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, -1);
			}
		}
		
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, EMDPlayerTickHandler.gTime * 20));
		// nether neutrality
		EMDPlayerTickHandler.ghastTentacleEffect = true;
	}
}
