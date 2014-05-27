package com.minestrappolation.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGoblet extends TileEntity
{
	protected PotionEffect	potionEffect;
	
	public void setPotionEffect(PotionEffect effect)
	{
		this.potionEffect = effect;
	}
	
	public PotionEffect getPotionEffect()
	{
		return this.potionEffect;
	}
	
	public int getColor()
	{
		if (this.potionEffect != null)
			return Potion.potionTypes[this.potionEffect.getPotionID()].getLiquidColor();
		return 0xFFFFFF;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		if (this.potionEffect != null)
		{
			NBTTagCompound nbt1 = new NBTTagCompound();
			this.potionEffect.writeCustomPotionEffectToNBT(nbt1);
			nbt.setTag("PotionEffect", nbt1);
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		if (nbt.hasKey("PotionEffect"))
		{
			NBTTagCompound nbt1 = nbt.getCompoundTag("PotionEffect");
			this.potionEffect = PotionEffect.readCustomPotionEffectFromNBT(nbt1);
		}
	}
}
