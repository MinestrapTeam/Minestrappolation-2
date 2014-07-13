package minestrapteam.minestrappolation.item;

import minestrapteam.mcore.item.MCItemFood;
import minestrapteam.minestrappolation.lib.MPotions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

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
		
		player.addPotionEffect(new PotionEffect(MPotions.ghastTentaclePotion.id, 2 * 20, 0));
	}
}
