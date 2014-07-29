package minestrapteam.minestrappolation.item;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;

public interface IPlating
{
	public static final Map<String, IPlating>	platings	= new HashMap();
	
	public boolean canApply(IPlatable platable);
	
	public String getType();
	
	public String getType(ItemStack stack);
	
	public float getEntityDamage();
	
	public float getDigSpeed();
	
	public int getDurability();
}
