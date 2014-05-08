package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItem;

public class ItemAmuletPorcum extends MItem
{
	int	tick	= 0;
	
	public ItemAmuletPorcum()
	{
		super();
		this.setMaxDamage(50);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		EntityPlayer player = (EntityPlayer) par3Entity;
		Random rand = new Random();
		int randnum = rand.nextInt(61);
		this.tick++;
		if (player.inventory.hasItem(this))
		{
			if (this.tick > 60)
			{
				if (randnum > 59)
				{
					this.tick = 0;
					if (player.getFoodStats().needFood())
					{
						player.getFoodStats().addStats(1, 0F);
						par1ItemStack.damageItem(1, player);
					}
				}
			}
			else if (this.tick > 120)
			{
				this.tick = 0;
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
}
