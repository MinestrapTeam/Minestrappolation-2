package minestrapteam.minestrap_core.item;

import java.util.Collections;

public class MCItemHoe extends MCItemTool
{
	public MCItemHoe(ToolMaterial material, ToolMaterial plateMaterial)
	{
		super(0F, material, plateMaterial, Collections.EMPTY_SET, "overlayToolHoeBronze", false);
	}
}
