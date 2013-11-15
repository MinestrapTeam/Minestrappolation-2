package sobiohazardous.minestrappolation.extradecor.lib;

import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityBarrel;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityCardboardWet;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityCrate;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityEdgeStone;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityEdgeStoneCorner;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityPlanks;
import cpw.mods.fml.common.registry.GameRegistry;

public class EDTileEntityManager {

	public static void registerTileEntitys(){
		GameRegistry.registerTileEntity(TileEntityCrate.class, "tileEntityCrate");
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "tileEntityBarrel");
		GameRegistry.registerTileEntity(TileEntityCardboardWet.class, "tileEntityCardboardWet");
		GameRegistry.registerTileEntity(TileEntityPlanks.class, "tileEntityPlanks");
		GameRegistry.registerTileEntity(TileEntityEdgeStone.class, "tileEntityedgestone");
		GameRegistry.registerTileEntity(TileEntityEdgeStoneCorner.class, "tileEntityedgecorner");
		
	}
}
