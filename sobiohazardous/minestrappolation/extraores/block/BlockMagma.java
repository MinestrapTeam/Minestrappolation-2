package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import sobiohazardous.minestrappolation.extraores.ExtraOres;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockMagma extends BlockFluidClassic
{  
	protected Icon[] iconArray;

    public BlockMagma(int par1) 
    {
    	super(par1, ExtraOres.eoFluid, Material.lava);
   
     }
    
    @Override
	public void registerIcons(IconRegister r)
	{
		this.iconArray = new Icon[]
    			{
            r.registerIcon("minestrappolation:block_MagmaStill"),
            r.registerIcon("minestrappolation:block_MagmaFlow") };
    }
    
    @Override
	public Icon getIcon(int side, int meta)
	{
		return meta == 1 ? iconArray[0] : iconArray[1];		
	}
}