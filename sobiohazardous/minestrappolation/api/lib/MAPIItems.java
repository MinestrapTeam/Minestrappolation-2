package sobiohazardous.minestrappolation.api.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.minestrappolation.api.Minestrappolation;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import net.minecraft.item.Item;

public class MAPIItems 
{
	public static Item brickStone;
	
	public static void loadItems()
	{
		brickStone = new Item().setTextureName(MAssetManager.getMAPITexture("brickStone")).setUnlocalizedName("brickStone").setCreativeTab(Minestrappolation.creativeTabStone);
		GameRegistry.registerItem(brickStone, "brickStone");
	}
}
