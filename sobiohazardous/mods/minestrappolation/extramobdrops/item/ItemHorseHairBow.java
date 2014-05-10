package sobiohazardous.mods.minestrappolation.extramobdrops.item;

import sobiohazardous.mods.minestrappolation.core.lib.MReference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemHorseHairBow extends ItemBow
{
	protected IIcon[]	iconArray;
	
	public ItemHorseHairBow()
	{
		this.maxStackSize = 1;
		this.setMaxDamage(500);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(MReference.EMD_MODID + ":horseHairBow");
		this.iconArray = new IIcon[3];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(MReference.EMD_MODID + "horseHairBow" + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if (player.getItemInUse() == null)
		{
			return this.itemIcon;
		}
		int pull = stack.getMaxItemUseDuration() - useRemaining;
		if (pull >= 18)
		{
			return this.iconArray[2];
		}
		else if (pull > 13)
		{
			return this.iconArray[1];
		}
		else if (pull > 0)
		{
			return this.iconArray[0];
		}
		return this.iconArray[0];
	}
}
