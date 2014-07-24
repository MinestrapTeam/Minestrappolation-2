package minestrapteam.mcore.block;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class MCBlockLeaves extends BlockLeaves
{
	public int		color;
	
	private IIcon	opaqueIcon;
	
	public MCBlockLeaves(int color)
	{
		this.color = color;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(this.textureName);
		this.opaqueIcon = par1IconRegister.registerIcon(this.textureName + "_opaque");
	}
	
	@Override
	public int getBlockColor()
	{
		return this.color;
	}
	
	@Override
	public int getRenderColor(int metadata)
	{
		return this.color;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		this.field_150121_P = Minecraft.isFancyGraphicsEnabled();
		
		if (this.field_150121_P)
		{
			return this.blockIcon;
		}
		else
		{
			return this.opaqueIcon;
		}
	}
	
	@Override
	public String[] func_150125_e()
	{
		return null;
	}
}
