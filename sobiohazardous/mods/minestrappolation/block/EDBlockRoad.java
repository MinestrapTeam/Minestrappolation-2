package sobiohazardous.mods.minestrappolation.block;

import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import sobiohazardous.mods.minestrappolation.lib.MBlocks;
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
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEDTextureSC("Stone_Road_Side_0"));
			this.top = iconRegister.registerIcon(MCAssetManager.getEDTextureSC("Stone_PatternBricks_0_0"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadStoneBottom"));
		}
		else if (this == MBlocks.refinedNetherroad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEDTextureSC("Netherrack_Road_Side_0"));
			this.top = iconRegister.registerIcon(MCAssetManager.getEDTextureSC("Netherrack_PatternBricks_0_0"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadNetherrackBottom"));
		}
		else if (this == MBlocks.cobbledRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadCobbledSide"));
			this.top = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadCobbledTop"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadCobbledBottom"));
		}
		else if (this == MBlocks.sandyRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadSandSide"));
			this.top = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadSandTop"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadSandBottom"));
		}
		else if (this == MBlocks.sandstoneRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEDTextureSC("Sandstone_Road_Side_0"));
			this.top = iconRegister.registerIcon(MCAssetManager.getEDTextureSC("Sandstone_PatternBricks_0_0"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadSandBottom"));
		}
		else if (this == MBlocks.gravelRoad)
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadGravelSide"));
			this.top = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadGravelTop"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadGravelBottom"));
		}
		else
		{
			this.blockIcon = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadNetherrackSide"));
			this.top = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadNetherrackTop"));
			this.bottom = iconRegister.registerIcon(MCAssetManager.getEDTexture("roadNetherrackBottom"));
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