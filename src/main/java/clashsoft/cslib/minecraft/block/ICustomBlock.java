package clashsoft.cslib.minecraft.block;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface ICustomBlock
{
	public void addNames();
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list);
}
