package minestrapteam.minestrappolation.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.util.MAssetManager;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockDeepStones extends MBlock
{
	public String[] types;
	
    private IIcon[] icons;

	public BlockDeepStones(String[] types)
	{
		super(Material.rock);
		this.types = types;
		this.setCreativeTab(Minestrappolation.tabStoneDecor);
	}
	
	/**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.icons[meta];
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        for (int i = 0; i < types.length; ++i)
        {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.icons = new IIcon[types.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon(MAssetManager.getStonecutterTexture(types[i]));
        }
    }

}
