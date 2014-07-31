package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class MBlockLeaves extends BlockLeaves
{
	public int		color;
	
	private IIcon	opaqueIcon;
	
	public MBlockLeaves(int color)
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
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return Item.getItemFromBlock(MBlocks.redwoodSapling);
	}
}
