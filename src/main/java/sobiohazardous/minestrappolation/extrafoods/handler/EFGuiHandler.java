package sobiohazardous.minestrappolation.extrafoods.handler;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import sobiohazardous.minestrappolation.extrafoods.block.freezer.ContainerFreezer;
import sobiohazardous.minestrappolation.extrafoods.block.freezer.GuiFreezer;
import sobiohazardous.minestrappolation.extrafoods.block.freezer.TileEntityFreezer;
import sobiohazardous.minestrappolation.extrafoods.block.fridge.ContainerFridge;
import sobiohazardous.minestrappolation.extrafoods.block.fridge.GuiFridge;
import sobiohazardous.minestrappolation.extrafoods.block.fridge.TileEntityFridge;
import sobiohazardous.minestrappolation.extrafoods.block.microwave.ContainerMicrowave;
import sobiohazardous.minestrappolation.extrafoods.block.microwave.GuiMicrowave;
import sobiohazardous.minestrappolation.extrafoods.block.microwave.TileEntityMicrowave;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class EFGuiHandler implements IGuiHandler 
{
        //returns an instance of the Container you made earlier
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
        {
               TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                
               switch(id)
               {
                case 0: return new ContainerMicrowave(player.inventory, (TileEntityMicrowave) tileEntity);
                case 1: return id == 1 && world.getBlockId(x, y, z) == ExtraFoods.freezer.blockID ? new ContainerFreezer(player.inventory, (TileEntityFreezer) tileEntity) : null;
                case 2: return id == 2 && world.getBlockId(x, y, z) == ExtraFoods.fridge.blockID ? new ContainerFridge((TileEntityFridge) tileEntity, player.inventory) : null;
               }    
              return null;
        }
        

        //returns an instance of the Gui you made earlier
        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
        {
                
        	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                
        	switch(id)
        	{
        		case 0: return new GuiMicrowave(player.inventory, (TileEntityMicrowave) tileEntity);
        		case 1: return id == 1 && world.getBlockId(x, y, z) == ExtraFoods.freezer.blockID ? new GuiFreezer(player.inventory, (TileEntityFreezer) tileEntity) : null;
        		case 2: return id == 2 && world.getBlockId(x, y, z) == ExtraFoods.fridge.blockID ? new GuiFridge(player.inventory, (TileEntityFridge) tileEntity) : null;
        	}
	            			
        	return null; 
        }
		
}