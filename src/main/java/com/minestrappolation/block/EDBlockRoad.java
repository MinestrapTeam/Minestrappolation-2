package com.minestrappolation.block;

import com.minestrappolation.lib.MBlocks;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class EDBlockRoad extends Block
{
	public Entity			entity;
	public EntityLivingBase	living;
	
	private IIcon			top;
	private IIcon			bottom;
	
	public EDBlockRoad()
	{
		super(Material.ground);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		if (this == MBlocks.refinedRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getSCTexture("Stone_Road_Side_0"));
			this.top = iconRegister.registerIcon(MCAssetManager.getSCTexture("Stone_PatternBricks_0_0"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getTexture("roadStoneBottom"));
		}
		else if (this == MBlocks.refinedNetherroad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getSCTexture("Netherrack_Road_Side_0"));
			this.top = iconRegister.registerIcon(MCAssetManager.getSCTexture("Netherrack_PatternBricks_0_0"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getTexture("roadNetherrackBottom"));
		}
		else if (this == MBlocks.cobbledRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("roadCobbledSide"));
			this.top = iconRegister.registerIcon(MCAssetManager.getTexture("roadCobbledTop"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getTexture("roadCobbledBottom"));
		}
		else if (this == MBlocks.sandyRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("roadSandSide"));
			this.top = iconRegister.registerIcon(MCAssetManager.getTexture("roadSandTop"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getTexture("roadSandBottom"));
		}
		else if (this == MBlocks.sandstoneRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getSCTexture("Sandstone_Road_Side_0"));
			this.top = iconRegister.registerIcon(MCAssetManager.getSCTexture("Sandstone_PatternBricks_0_0"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getTexture("roadSandBottom"));
		}
		else if (this == MBlocks.gravelRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("roadGravelSide"));
			this.top = iconRegister.registerIcon(MCAssetManager.getTexture("roadGravelTop"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getTexture("roadGravelBottom"));
		}
		else
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("roadNetherrackSide"));
			this.top = iconRegister.registerIcon(MCAssetManager.getTexture("roadNetherrackTop"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getTexture("roadNetherrackBottom"));
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0)
		{
			return this.bottom;
		}
		else if (side == 1)
		{
			return this.top;
		}
		return this.blockIcon;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		if (this == MBlocks.refinedRoad)
		{
			entity.motionX *= 1.6;
			entity.motionZ *= 1.6;
		}
		else if (this == MBlocks.refinedNetherroad)
		{
			entity.motionX *= 2.4;
			entity.motionZ *= 2.4;
		}
		else if (this == MBlocks.cobbledRoad)
		{
			entity.motionX *= 1.4;
			entity.motionZ *= 1.4;
		}
		else if (this == MBlocks.sandyRoad)
		{
			entity.motionX *= 1.4;
			entity.motionZ *= 1.4;
		}
		else if (this == MBlocks.sandstoneRoad)
		{
			entity.motionX *= 1.8;
			entity.motionZ *= 1.8;
		}
		else if (this == MBlocks.gravelRoad)
		{
			entity.motionX *= 1.6;
			entity.motionZ *= 1.6;
		}
		else
		{
			entity.motionX *= 1.9;
			entity.motionZ *= 1.9;
		}
	}
}