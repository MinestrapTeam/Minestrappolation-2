package minestrapteam.minestrappolation.inventory;

import minestrapteam.minestrappolation.crafting.sawmill.SawingManager;
import minestrapteam.minestrappolation.tileentity.TileEntitySawmill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

public class ContainerSawmill extends ContainerWorkbench
{
	public World worldObj;
	public TileEntitySawmill	sawmill;
	
	public ContainerSawmill(InventoryPlayer inventory, TileEntitySawmill sawmill)
	{
		super(inventory, sawmill.getWorldObj(), sawmill.xCoord, sawmill.yCoord, sawmill.zCoord);
		this.worldObj = sawmill.getWorldObj();
		this.sawmill = sawmill;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.sawmill.isUseableByPlayer(player);
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory p_75130_1_)
    {
        this.craftResult.setInventorySlotContents(0, SawingManager.instance.findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
}
