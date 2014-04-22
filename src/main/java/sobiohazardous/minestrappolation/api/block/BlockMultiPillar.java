package sobiohazardous.minestrappolation.api.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockMultiPillar extends BlockMultiPillarStationary
{
	public BlockMultiPillar(Material mat, String[] sidesImgs, String[] topImgs) 
	{
		super(mat, sidesImgs, topImgs);
	}
	
	/**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int j1 = par9 & 3;
        byte b0 = 0;

        switch (par5)
        {
            case 0:
            case 1:
                b0 = 0;
                break;
            case 2:
            case 3:
                b0 = 8;
                break;
            case 4:
            case 5:
                b0 = 4;
        }

        return j1 | b0;
    }
}
