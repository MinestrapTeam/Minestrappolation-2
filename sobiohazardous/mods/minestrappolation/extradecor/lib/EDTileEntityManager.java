package sobiohazardous.mods.minestrappolation.extradecor.lib;

import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityCardboardWet;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityCrate;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityEdgeStone;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityEdgeStoneCorner;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityGoblet;
import cpw.mods.fml.common.registry.GameRegistry;

public class EDTileEntityManager {

	public static void registerTileEntitys(){
		GameRegistry.registerTileEntity(TileEntityCrate.class, "tileEntityCrate");
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "tileEntityBarrel");
		GameRegistry.registerTileEntity(TileEntityCardboardWet.class, "tileEntityCardboardWet");
		GameRegistry.registerTileEntity(TileEntityEdgeStone.class, "tileEntityedgestone");
		GameRegistry.registerTileEntity(TileEntityEdgeStoneCorner.class, "tileEntityedgecorner");
		GameRegistry.registerTileEntity(TileEntityGoblet.class, "tileEntitygoblet");
	}
}
