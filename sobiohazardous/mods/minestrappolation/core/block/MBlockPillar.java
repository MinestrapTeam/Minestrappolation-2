package sobiohazardous.mods.minestrappolation.core.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MBlockPillar extends Block
{
	private IIcon	top;
	private String	sidesImg;
	private String	topImg;
	
	public MBlockPillar(String sidesImg, String topImg)
	{
		super(Material.rock);
		this.sidesImg = sidesImg;
		this.topImg = topImg;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(this.sidesImg);
		this.top = iconRegister.registerIcon(this.topImg);
	}
	
	@Override
	public int damageDropped(int par1)
	{
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		int k = par2 & 12;
		return k == 0 && (par1 == 1 || par1 == 0) ? this.top : k == 4 && (par1 == 5 || par1 == 4) ? this.top : k == 8 && (par1 == 2 || par1 == 3) ? this.top : this.blockIcon;
	}
	
	@Override
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
	
	@Override
	public int getRenderType()
	{
		return 31;
	}
}
