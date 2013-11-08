package sobiohazardous.minestrappolation.extradecor.block;

import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityStatueTest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStatueTest extends BlockContainer{

	public BlockStatueTest(int par1, Material par2Material) {
		super(par1, Material.rock);
		
		this.setBlockBounds(1F/16F, 0F, 1F/16F, 1F-1F/16F, 1F-1F/16F*6F, 1F-1F/16F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityStatueTest();
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
	
	public void registerIcon(IconRegister icon){
		this.blockIcon = icon.registerIcon("minestrappolation:test.png");
	}

}
