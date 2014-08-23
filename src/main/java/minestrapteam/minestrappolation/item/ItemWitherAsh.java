package minestrapteam.minestrappolation.item;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemWitherAsh extends MItem
{
	public int effectTick = 0;
	
    public void onUpdate(ItemStack item, World world, Entity entity, int tick, boolean bool) 
    {
    	effectTick++;
    	
    	if(effectTick == (new Random().nextInt(400) + 200))
    	{
    		EntityPlayer player = (EntityPlayer)entity;
    		player.addPotionEffect(new PotionEffect(Potion.wither.id, new Random().nextInt(100) + 100));
    		effectTick = 0;
    	}
    }

}
