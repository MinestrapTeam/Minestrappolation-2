package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockOoze extends EDBlock
{
	private int	ticks	= 0;
	
	public BlockOoze(Material material)
	{
		super(material);
		this.setCreativeTab(EDBlocks.tabDecor);
	}
	
	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1
	 * for alpha
	 */
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par5Entity.setInWeb();
		par5Entity.addVelocity(0, -0.3, 0);
		/*
		 * if(blockID == ExtraDecor.oozeSlime.blockID) { ticks++;
		 * System.out.println(ticks); if(ticks<=10) { par5Entity.setAir(300);
		 * System.out.println("set"); } if(ticks>=11) {
		 * par5Entity.setAir(par5Entity.getAir() - 1); } }
		 */
		
		if (par1World.getBlock(par2, par3, par4) == EDBlocks.magmaOoze)
		{
			par5Entity.setFire(1);
		}
		
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}
	
}
