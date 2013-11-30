package sobiohazardous.minestrappolation.extradecor.block;

import sobiohazardous.minestrappolation.extradecor.lib.EDBlockManager;
import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityPlate;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlate extends BlockContainer{

	public BlockPlate(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(EDBlockManager.tabDecorBlocks);
		this.setBlockBounds(1F/16F, 0F, 1F/16F, 1F-1F/16F, 1F-1F/16F*14F, 1F-1F/16F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityPlate();
	}
	
	public int getRenderType(){
		return -1;	
	}

	public boolean isOpaqueCube(){
		return false;		
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	

}
