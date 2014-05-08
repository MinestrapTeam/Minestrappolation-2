package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.mods.minestrappolation.core.item.MItem;
import sobiohazardous.mods.minestrappolation.extramobdrops.entity.EntityHangGlider;

public class ItemHangGlider extends MItem
{
	boolean	initCheck	= true;
	boolean	checking	= false;
	
	public ItemHangGlider()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(25);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int i, int j, int k, int par7, float par8, float par9, float par10)
	{
		if (!world.isRemote)
		{
			EntityHangGlider entity = new EntityHangGlider(world, i, j, k, player, itemStack);
			world.spawnEntityInWorld(entity);
			return true;
		}
		return false;
	}
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		/*
		 * EntityPlayer player = (EntityPlayer)par3Entity;
		 * if(player.inventory.getCurrentItem() !=
		 * EMDItemManager.hangGlider.getContainerItem(par1ItemStack) &&
		 * player.onGround == false && player.isInWater() == false) {
		 * player.motionY /= 1.55; player.fallDistance = 0;
		 * if(Math.abs(player.motionX) < 0.15) { player.motionX *= 1.1; } else
		 * if(Math.abs(player.motionX) < 0.9) { player.motionX *= 1.06; }
		 * if(Math.abs(player.motionZ) < 0.15) { player.motionZ *= 1.1; }
		 * if(Math.abs(player.motionZ) < 0.9) { player.motionZ *= 1.06; }
		 * if(initCheck == true && (Math.abs(player.motionX) +
		 * Math.abs(player.motionZ) > 0.15)) { checking = true; initCheck =
		 * false; } if(checking == true && (Math.abs(player.motionX) +
		 * Math.abs(player.motionZ) <= 0.15) && (player.isCollidedHorizontally
		 * == false)) { checking = false; initCheck = true; } //The problem for
		 * no damage is that player.isCollidedHorizontally only works client
		 * side, so it damages only client side, and not server side. these
		 * packets do nothing. if(checking == true &&
		 * (player.isCollidedHorizontally == true)) { player.motionX = 0;
		 * player.motionZ = 0; checking = false; initCheck = true; } //wall
		 * colision if((Math.abs(prev2XMotion) > 0.3 || Math.abs(prev2ZMotion) >
		 * 0.3 || (Math.abs(prev2XMotion) > 0.3 && Math.abs(prev2ZMotion) >
		 * 0.3)) && player.isCollidedHorizontally && Math.abs(player.motionY) >
		 * 0.13) { par1ItemStack.damageItem(1,
		 * Minecraft.getMinecraft().thePlayer); }
		 * //System.out.println("Checking" + checking);
		 * //System.out.println("InitChecking" + initCheck);
		 * //System.out.println("SpeedZ" + player.motionZ);
		 * //System.out.println("SpeedX" + player.motionX); }
		 */
	}
	
}
