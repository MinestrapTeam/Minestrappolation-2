package clashsoft.cslib.minecraft.block;

import clashsoft.cslib.util.CSLog;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMetaTileEntity extends CustomBlock implements ITileEntityProvider
{
	public Class[]	tileEntities;
	
	public BlockMetaTileEntity(Material material, String name, String iconName, CreativeTabs creativeTab)
	{
		super(material, name, iconName, creativeTab);
	}
	
	public BlockMetaTileEntity(Material material, String[] names, String[] iconNames, CreativeTabs[] creativeTabs)
	{
		super(material, names, iconNames, creativeTabs);
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
	
	@Override
	public TileEntity createNewTileEntity(World paramWorld, int paramInt)
	{
		return null;
	}
}
