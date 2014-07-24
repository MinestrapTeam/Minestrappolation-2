package minestrapteam.mcore.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.mcore.util.MCAssetManager;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;

public class MCBlockLeaves extends BlockLeaves {
	
	public String name;
	public int color;
	
	IIcon fancy;
	IIcon fast;
	
	public MCBlockLeaves(String name,int color)
	{
		this.name = name;
		this.color = color;
		this.setBlockName(name+"_leaves");
		GameRegistry.registerBlock(this, name+"_leaves");
		
	}
	
	@Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        fancy = par1IconRegister.registerIcon(MCAssetManager.getPlantTexture(name+"_leaves"));
        fast  = par1IconRegister.registerIcon(MCAssetManager.getPlantTexture(name+"_leaves_opaque"));
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public int getBlockColor()
    {
        return color;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderColor(int p_149741_1_)
    {
        return color;
    }

	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) 
	{
		 this.field_150121_P = Minecraft.getMinecraft().isFancyGraphicsEnabled();
	    
	     if(this.field_150121_P)
	     {
	    	 return fancy;
	     }
	     else 
	    	 
	     return fast;
	}

	@Override
	public String[] func_150125_e() 
	{
		return null;
	}

	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }

}
