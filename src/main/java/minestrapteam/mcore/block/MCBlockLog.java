package minestrapteam.mcore.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.mcore.util.MCAssetManager;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class MCBlockLog extends BlockLog{
	
	public String name;
	private IIcon	topIcon;
	private String	topIconName;
	
	public MCBlockLog(String name)
	{
		this.name = name;
		this.setBlockName(name+"_log");
        this.setHardness(2.0F);
        this.setStepSound(soundTypeWood); 
        this.setBlockTextureName(MCAssetManager.getWoodTexture(name+"_log_side"));
		this.topIconName = MCAssetManager.getWoodTexture(name+"_log_top");
		GameRegistry.registerBlock(this, name+"_log");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		super.registerBlockIcons(iconRegister);
		this.topIcon = iconRegister.registerIcon(this.topIconName);
	}
	
	@SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_)
    {
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.topIcon;
    }

}
