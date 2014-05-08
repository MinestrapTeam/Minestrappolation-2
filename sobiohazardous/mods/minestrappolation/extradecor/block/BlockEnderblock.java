package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEnderblock extends EDBlock
{
	private EntityLiving	living;
	
	public BlockEnderblock()
	{
		super(Material.rock);
		this.setLightLevel(0.6F);
		this.setLightOpacity(1);
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		for (int l = 0; l < 3; ++l)
		{
			double d1 = par3 + par5Random.nextFloat();
			double d2 = 0.0D;
			double d3 = 0.0D;
			double d4 = 0.0D;
			int i1 = par5Random.nextInt(2) * 2 - 1;
			int j1 = par5Random.nextInt(2) * 2 - 1;
			d2 = (par5Random.nextFloat() - 0.5D) * 0.125D;
			d3 = (par5Random.nextFloat() - 0.5D) * 0.125D;
			d4 = (par5Random.nextFloat() - 0.5D) * 0.125D;
			double d5 = par4 + 0.5D + 0.25D * j1;
			d4 = par5Random.nextFloat() * 1.0F * j1;
			double d6 = par2 + 0.5D + 0.25D * i1;
			d2 = par5Random.nextFloat() * 1.0F * i1;
			par1World.spawnParticle("portal", d6, d1, d5, d2, d3, d4);
		}
	}
	
}
