package clashsoft.cslib.minecraft.block;

import clashsoft.cslib.minecraft.CustomBlock;
import clashsoft.cslib.util.CSLog;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMetaTileEntity extends CustomBlock implements ITileEntityProvider
{
	public Class[] tileEntities;
	
	public BlockMetaTileEntity(int blockID, Material material, String displayName, String iconNames, boolean opaque, int renderType, CreativeTabs creativeTabs)
	{
		super(blockID, material, displayName, iconNames, opaque, renderType, creativeTabs);
	}

	public BlockMetaTileEntity(int blockID, Material material, String displayName, String iconName, CreativeTabs creativeTab)
	{
		super(blockID, material, displayName, iconName, creativeTab);
	}

	public BlockMetaTileEntity(int blockID, Material material, String[] displayNames, String[] iconNames, boolean opaque, int renderType, CreativeTabs[] creativeTabs)
	{
		super(blockID, material, displayNames, iconNames, opaque, renderType, creativeTabs);
	}

	public BlockMetaTileEntity(int blockID, Material material, String[] displayNames, String[] iconNames, CreativeTabs[] creativeTabs)
	{
		super(blockID, material, displayNames, iconNames, creativeTabs);
	}

	public BlockMetaTileEntity(int blockID, Material material, String[] displayNames, String[][] iconNames, boolean opaque, int renderType, CreativeTabs[] creativeTabs)
	{
		super(blockID, material, displayNames, iconNames, opaque, renderType, creativeTabs);
		
	}
	
	public BlockMetaTileEntity setTileEntityClasses(Class<? extends TileEntity>... tileEntityClasses)
	{
		this.tileEntities = tileEntityClasses;
		return this;
	}
	
	public BlockMetaTileEntity setTileEntityClass(int metadata, Class<? extends TileEntity> tileEntityClass)
	{
		if (this.tileEntities == null)
		{
			this.tileEntities = new Class[this.names.length];
		}
		this.tileEntities[metadata] = tileEntityClass;
		return this;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return createTileEntity(world, 0);
	}
	
	public boolean hasTileEntity(int metadata)
	{
		return this.tileEntities[metadata] != null;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		Class tileEntityClass = this.tileEntities[metadata];
		if (tileEntityClass != null)
		{
			try
			{
				return (TileEntity) tileEntityClass.newInstance();
			}
			catch (Exception ex)
			{
				CSLog.error(ex);
			}
		}
		return null;
	}
}
