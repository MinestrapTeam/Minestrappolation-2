package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockTiles extends Block
{
	private IIcon	obsidianTiles;
	private IIcon	flintTiles;
	private IIcon	netherQuartz;
	private IIcon	checkerBoard;
	private IIcon	clayPattern;
	private IIcon	flintRaw;
	private IIcon	netherrackPattern;
	
	public BlockTiles()
	{
		super(Material.rock);
	}
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		
		if (meta == 0)
		{
			return 60F;
		}
		else if (meta == 2)
		{
			return 0.8F;
		}
		else if (meta == 1 || meta == 3 || meta == 5)
		{
			return 3F;
		}
		else if (meta == 4 || meta == 6)
		{
			return 2F;
		}
		return 5F;
		
	}
	
	@Override
	public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == 0)
		{
			return 2000F;
		}
		else if (meta == 2)
		{
			return 1F;
		}
		else if (meta == 1 || meta == 3 || meta == 4 || meta == 5 || meta == 6)
		{
			return 10F;
		}
		return 1F;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.obsidianTiles = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Obsidian_Tiles_0_0"));
		this.flintTiles = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Flint_Tiles_0_0"));
		this.netherQuartz = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("NetherQuartz_Tiles_0_0"));
		this.checkerBoard = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Flint-NetherQuartz_TileChecker_0_0"));
		this.clayPattern = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_0"));
		this.flintRaw = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Flint_Raw_0_0"));
		this.netherrackPattern = iconRegister.registerIcon(MAssetManager.getEDStonecutterTexture("Netherrack_PatternBricks_0_0"));
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		switch (metadata)
		{
		case 0:
			return this.obsidianTiles;
		case 1:
			return this.flintTiles;
		case 2:
			return this.netherQuartz;
		case 3:
			return this.checkerBoard;
		case 4:
			return this.clayPattern;
		case 5:
			return this.flintRaw;
		case 6:
			return this.netherrackPattern;
		}
		return this.obsidianTiles;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 7; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
