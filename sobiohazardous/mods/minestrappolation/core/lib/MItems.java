package sobiohazardous.mods.minestrappolation.core.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.minestrappolation.core.Minestrappolation;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import net.minecraft.item.Item;

public class MItems 
{
	public static Item brickStone;
	
	public static void loadItems()
	{
		brickStone = new Item().setTextureName(MAssetManager.getMAPITexture("brickStone")).setUnlocalizedName("brickStone").setCreativeTab(Minestrappolation.creativeTabStone);
		GameRegistry.registerItem(brickStone, "brickStone");
	}
}
