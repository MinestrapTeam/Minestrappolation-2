package minestrapteam.mcore.item;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;

public interface IPlating
{
	public static final Map<String, IPlating>	platings	= new HashMap();
	
	public boolean canApply(String toolType);
	
	public String getType();
	
	public String getType(ItemStack stack);
	
	public float getDigSpeed();
	
	public int getDurability();
}
