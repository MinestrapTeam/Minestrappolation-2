package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;

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
		if (this == EDBlocks.refinedRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Stone_Road_Side_0"));
			this.top = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Stone_PatternBricks_0_0"));
			this.bottom = iconRegister.registerIcon(MAssetManager.getEDTexture("roadStoneBottom"));
		}
		else if (this == EDBlocks.refinedNetherroad)
		{
			this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Netherrack_Road_Side_0"));
			this.top = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Netherrack_PatternBricks_0_0"));
			this.bottom = iconRegister.registerIcon(MAssetManager.getEDTexture("roadNetherrackBottom"));
		}
		else if (this == EDBlocks.cobbledRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDTexture("roadCobbledSide"));
			this.top = iconRegister.registerIcon(MAssetManager.getEDTexture("roadCobbledTop"));
			this.bottom = iconRegister.registerIcon(MAssetManager.getEDTexture("roadCobbledBottom"));
		}
		else if (this == EDBlocks.sandyRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDTexture("roadSandSide"));
			this.top = iconRegister.registerIcon(MAssetManager.getEDTexture("roadSandTop"));
			this.bottom = iconRegister.registerIcon(MAssetManager.getEDTexture("roadSandBottom"));
		}
		else if (this == EDBlocks.sandstoneRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Sandstone_Road_Side_0"));
			this.top = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Sandstone_PatternBricks_0_0"));
			this.bottom = iconRegister.registerIcon(MAssetManager.getEDTexture("roadSandBottom"));
		}
		else if (this == EDBlocks.gravelRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDTexture("roadGravelSide"));
			this.top = iconRegister.registerIcon(MAssetManager.getEDTexture("roadGravelTop"));
			this.bottom = iconRegister.registerIcon(MAssetManager.getEDTexture("roadGravelBottom"));
		}
		else
		{
			this.blockIcon = iconRegister.registerIcon(MAssetManager.getEDTexture("roadNetherrackSide"));
			this.top = iconRegister.registerIcon(MAssetManager.getEDTexture("roadNetherrackTop"));
			this.bottom = iconRegister.registerIcon(MAssetManager.getEDTexture("roadNetherrackBottom"));
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
		if (this == EDBlocks.refinedRoad)
		{
			entity.motionX *= 1.6;
			entity.motionZ *= 1.6;
		}
		else if (this == EDBlocks.refinedNetherroad)
		{
			entity.motionX *= 2.4;
			entity.motionZ *= 2.4;
		}
		else if (this == EDBlocks.cobbledRoad)
		{
			entity.motionX *= 1.4;
			entity.motionZ *= 1.4;
		}
		else if (this == EDBlocks.sandyRoad)
		{
			entity.motionX *= 1.4;
			entity.motionZ *= 1.4;
		}
		else if (this == EDBlocks.sandstoneRoad)
		{
			entity.motionX *= 1.8;
			entity.motionZ *= 1.8;
		}
		else if (this == EDBlocks.gravelRoad)
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