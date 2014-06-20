package minestrapteam.minestrap_core.block;

import java.util.List;

import minestrapteam.minestrap_core.common.MCCommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Wood slabs.
 * 
 * @author SoBiohazardous, Clashsoft
 */
public class MCBlockWood2 extends Block
{
	public String[]	types;
	
	public String	name;
	
	public IIcon[]	topIcons;
	public IIcon[]	sideIcons;
	
	public MCBlockWood2(String[] types, String name)
	{
		super(Material.rock);
		this.name = name;
		this.types = types;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		this.setBlockBounds(world.getBlockMetadata(x, y, z));
	}
	
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity)
	{
		this.setBlockBoundsBasedOnState(world, x, y, z);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
	}
	
	public void setBlockBounds(int metadata)
	{
		int model = metadata % 3;
		
		if (model == 0)
		{
			this.setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
		}
		else if (model == 1)
		{
			this.setBlockBounds(0F, 0.5F, 0F, 1F, 1F, 1F);
		}
		else
		{
			this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		}
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	{
		if (metadata < 3)
		{
			if (side == 0 || side == 1)
			{
				return 0;
			}
			else if (side == 2 || side == 3)
			{
				return 1;
			}
			else if (side == 4 || side == 5)
			{
				return 2;
			}
		}
		return metadata;
	}
	
	public int limitToValidMetadata(int metadata)
	{
		return metadata - metadata % 3;
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return this.limitToValidMetadata(world.getBlockMetadata(x, y, z));
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return this.limitToValidMetadata(metadata);
	}
	
	public String getUnlocalizedName(int metadata)
	{
		metadata /= 3;
		if (metadata >= this.types.length)
		{
			metadata = 0;
		}
		return "tile." + this.name + "." + this.types[metadata];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.topIcons = new IIcon[5];
		this.sideIcons = new IIcon[5];
		
		String textureName = this.getTextureName();
		this.topIcons[0] = this.sideIcons[0] = iconRegister.registerIcon(textureName + "_bevel");
		this.topIcons[1] = this.sideIcons[1] = iconRegister.registerIcon(textureName + "_boards");
		this.topIcons[2] = this.sideIcons[2] = iconRegister.registerIcon(textureName + "_panel");
		this.topIcons[3] = this.sideIcons[3] = iconRegister.registerIcon(textureName + "_planks_mossy");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0 || side == 1)
		{
			return this.topIcons[metadata / 3];
		}
		else
		{
			return this.sideIcons[metadata / 3];
		}
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
	public int getRenderType()
	{
		return MCCommonProxy.wood2RenderType;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.types.length; i++)
		{
			if (this.types[i] != null)
			{
				list.add(new ItemStack(item, 1, i * 3));
			}
		}
	}
}
