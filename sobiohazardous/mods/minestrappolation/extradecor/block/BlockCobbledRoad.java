package sobiohazardous.mods.minestrappolation.extradecor.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCobbledRoad extends Block
{
	public Entity			entity;
	public EntityLivingBase	living;
	private IIcon			top;
	private IIcon			bottom;
	
	public BlockCobbledRoad()
	{
		super(Material.ground);
	}
	
	@Override
	public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadCobbledSide"));
		this.top = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadCobbledTop"));
		this.bottom = par1IconRegister.registerIcon(MAssetManager.getEDTexture("roadCobbledBottom"));
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
		par5Entity.motionX *= 1.4;
		par5Entity.motionZ *= 1.4;
	}
}