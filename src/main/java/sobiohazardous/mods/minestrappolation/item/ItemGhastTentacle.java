package sobiohazardous.mods.minestrappolation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MCItemFood;
import sobiohazardous.mods.minestrappolation.handler.MPlayerTickHandler;

public class ItemGhastTentacle extends MCItemFood
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
		
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, MPlayerTickHandler.gTime * 20));
		// nether neutrality
		MPlayerTickHandler.ghastTentacleEffect = true;
	}
}
