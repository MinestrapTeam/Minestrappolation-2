package sobiohazardous.minestrappolation.extraores.bridge;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class EOBridgeRecipes {
	
	public static void loadBridgedRecipes() throws Exception{
		if(Loader.isModLoaded("ExtraDecor")){
			GameRegistry.addSmelting(Block.glowStone.blockID, new ItemStack(EOBlockManager.glowGlass), 0.5F);
		}
	}

}
