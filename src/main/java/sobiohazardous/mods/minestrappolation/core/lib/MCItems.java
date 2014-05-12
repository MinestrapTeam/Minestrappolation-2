package sobiohazardous.mods.minestrappolation.core.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.minestrappolation.core.MinestrappolationCore;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import net.minecraft.item.Item;

public class MCItems
{
	public static Item	brickStone;
	
	public static void init()
	{
		brickStone = new Item().setTextureName(MCAssetManager.getMAPITexture("brickStone")).setUnlocalizedName("brickStone").setCreativeTab(MinestrappolationCore.creativeTabStone);
		GameRegistry.registerItem(brickStone, "brickStone");
	}
}
