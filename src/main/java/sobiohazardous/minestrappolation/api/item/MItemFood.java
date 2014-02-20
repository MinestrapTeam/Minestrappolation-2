package sobiohazardous.minestrappolation.api.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class MItemFood extends ItemFood
{
	public MItemFood(int id, int healAmt, float sat)
	{
		super(id, healAmt, sat, false);
	}
	
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("Minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
}
