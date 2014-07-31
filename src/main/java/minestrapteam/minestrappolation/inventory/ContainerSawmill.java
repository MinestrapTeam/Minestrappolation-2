package minestrapteam.minestrappolation.inventory;

import minestrapteam.minestrappolation.tileentity.TileEntitySawmill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;

public class ContainerSawmill extends ContainerWorkbench
{
	public TileEntitySawmill	sawmill;
	
	public ContainerSawmill(InventoryPlayer inventory, TileEntitySawmill sawmill)
	{
		super(inventory, sawmill.getWorldObj(), sawmill.xCoord, sawmill.yCoord, sawmill.zCoord);
		this.sawmill = sawmill;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.sawmill.isUseableByPlayer(player);
	}
}
