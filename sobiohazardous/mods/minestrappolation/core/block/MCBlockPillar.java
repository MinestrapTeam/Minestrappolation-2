package sobiohazardous.mods.minestrappolation.core.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MCBlockPillar extends Block
{
	private IIcon	topIcon;
	private String	topIconName;
	
	public MCBlockPillar(String sideIconName, String topIconName)
	{
		super(Material.rock);
		this.setBlockTextureName(sideIconName);
		this.topIconName = topIconName;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		super.registerBlockIcons(iconRegister);
		this.topIcon = iconRegister.registerIcon(this.topIconName);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		int k = meta & 12;
		return k == 0 && (side == 1 || side == 0) ? this.topIcon : k == 4 && (side == 5 || side == 4) ? this.topIcon : k == 8 && (side == 2 || side == 3) ? this.topIcon : this.blockIcon;
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	{
		int j1 = metadata & 3;
		byte b0 = 0;
		
		switch (side)
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
