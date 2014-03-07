package sobiohazardous.minestrappolation.extramobdrops.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.api.item.MItemFood;
import sobiohazardous.minestrappolation.extramobdrops.handler.EMDPlayerTickHandler;

public class ItemGhastTentacle extends MItemFood
{
	public ItemGhastTentacle() 
	{
		super(0, 0.0f);
		this.setAlwaysEdible();
	}
	
    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
    	super.onFoodEaten(par1ItemStack, par2World, player);
    	
    	if(player instanceof EntityPlayerMP)
    	{
    		EntityPlayerMP playermp = (EntityPlayerMP)player;
    	
    		if(player.dimension == 0)
    		{    		
    			playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, -1);
    		}
    	}
    	
    	player.addPotionEffect(new PotionEffect(Potion.confusion.id, EMDPlayerTickHandler.gTime * 20));
    	//nether neutrality
    	EMDPlayerTickHandler.gTentacleEffect = true;			
    }
}
