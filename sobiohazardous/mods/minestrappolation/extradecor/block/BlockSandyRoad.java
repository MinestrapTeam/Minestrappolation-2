package sobiohazardous.mods.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSandyRoad extends BlockFalling
{
	private IIcon	top;
	private IIcon	bottom;
	
	public BlockSandyRoad()
	{
		super(Material.sand);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		if (this == EDBlocks.sandyRoad)
		{
			this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadSandSide"));
			this.top = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadSandTop"));
			this.bottom = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadSandBottom"));
		}
		else if (this == EDBlocks.sandstoneRoad)
		{
			this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Sandstone_Road_Side_0"));
			this.top = par1IconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Sandstone_PatternBricks_0_0"));
			this.bottom = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadSandBottom"));
		}
		else
		{
			this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadGravelSide"));
			this.top = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadGravelTop"));
			this.bottom = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadGravelBottom"));
		}
	}
	
	@Override
	public IIcon getIcon(int i, int j)
	{
		if (i == 0)
		{
			return this.bottom;
		}
		if (i == 1)
		{
			return this.top;
		}
		
		if (i == 2)
		{
			return this.blockIcon;
		}
		if (i == 3)
		{
			return this.blockIcon;
		}
		if (i == 4)
		{
			return this.blockIcon;
		}
		if (i == 5)
		{
			return this.blockIcon;
		}
		
		if (j == 1)
		{
			return this.blockIcon;
		}
		return this.blockIcon;
	}
	
	@Override
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if (this == EDBlocks.sandyRoad)
		{
			par5Entity.motionX *= 1.4;
			par5Entity.motionZ *= 1.4;
		}
		else if (this == EDBlocks.gravelRoad)
		{
			par5Entity.motionX *= 1.6;
			par5Entity.motionZ *= 1.6;
		}
		else
		{
			par5Entity.motionX *= 1.8;
			par5Entity.motionZ *= 1.8;
		}
	}
}