package minestrapteam.mcore.block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import minestrapteam.mcore.common.MCCommonProxy;
import minestrapteam.minestrappolation.Minestrappolation;

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
import net.minecraftforge.common.util.ForgeDirection;

/**
 * The second stonecutter block type.<br>
 * This makes up the following blocks:
 * <ul>
 * <li>0: Pillar (Up/Down)
 * <li>1: Pillar (North/South)
 * <li>2: Pillar (East/West)
 * <li>3: Raw Slab Lower
 * <li>4: Raw Slab Upper
 * <li>5: Raw Slab Double
 * <li>6: Brick Slab Lower
 * <li>7: Brick Slab Upper
 * <li>8: Brick Slab Double
 * <li>9: Tile Slab Lower
 * <li>10: Tile Slab Upper
 * <li>11: Tile Slab Double
 * <li>12: Refined Slab Lower
 * <li>13: Refined Slab Upper
 * <li>14: Refined Slab Double
 * </ul>
 * Everything else is added by {@link MCBlockCustom}
 * 
 * @author Clashsoft
 */
public class MCBlockCustom2 extends Block
{
	public String[]				types;
	
	public String				name;
	public float				baseHardness;
	public float				baseResistance;
	public int					harvestLevel;
	public String				harvestTool;
	
	public Map<String, IIcon>	iconMap	= new HashMap();
	
	public boolean				slabSided;
	public boolean				rawSlabUnsided;
	public boolean				netherrack;
	public boolean				redSandstone;
	public boolean				enderDragonCantDestroy;
	public boolean				beaconBase;
	
	public MCBlockCustom2(String[] types, String name)
	{
		this(types, name, 1F, 5F, 0, Material.rock);
	}
	
	public MCBlockCustom2(String[] types, String name, Material mat)
	{
		this(types, name, 1F, 5F, 0, mat);
	}
	
	public MCBlockCustom2(String[] types, String name, float baseHardness, float baseResistance, int harvestLevel, Material mat)
	{
		super(mat);
		this.setCreativeTab(Minestrappolation.tabStoneDecor);
		this.name = name;
		this.baseHardness = baseHardness;
		this.baseResistance = baseResistance;
		this.harvestLevel = harvestLevel;
		this.types = types;
	}
	
	public MCBlockCustom2 setEnderDragonCantDestroy()
	{
		this.enderDragonCantDestroy = true;
		return this;
	}
	
	public MCBlockCustom2 setBeaconBase()
	{
		this.beaconBase = true;
		return this;
	}
	
	public MCBlockCustom2 setRawSlabUnsided()
	{
		this.rawSlabUnsided = true;
		return this;
	}
	
	public MCBlockCustom2 setIsNetherrack()
	{
		this.netherrack = true;
		return this;
	}
	
	public MCBlockCustom2 setIsRedSandstone()
	{
		this.redSandstone = true;
		return this;
	}
	
	public MCBlockCustom2 setSlabSided()
	{
		this.slabSided = true;
		return this;
	}
	
	public MCBlockCustom2 setHarvestTool(String harvestTool)
	{
		this.harvestTool = harvestTool;
		return this;
	}
	
	public String getType(int metadata)
	{
		metadata /= 3;
		if (metadata < 0 || metadata >= this.types.length)
		{
			return null;
		}
		return this.types[metadata];
	}
	
	public String getUnlocalizedName(int metadata)
	{
		return "tile." + this.name + "." + this.getType(metadata);
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
		if ("pillar".equals(this.getType(metadata)))
		{
			this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		}
		else
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
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	{
		if ("pillar".equals(this.getType(metadata)))
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
		else if (side == 0 || side != 1 && hitY > 0.5D)
		{
			return metadata + 1;
		}
		return metadata;
	}
	
	public int limitToValidMetadata(int metadata)
	{
		return metadata - metadata % 3;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		if (!"pillar".equals(this.getType(meta)))
		{
			return meta % 3 == 2 ? 2 : 1;
		}
		return 1;
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
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		return this.getHardness(world.getBlockMetadata(x, y, z));
	}
	
	public float getHardness(int metadata)
	{
		return this.baseHardness;
	}
	
	@Override
	public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		return this.baseResistance;
	}
	
	@Override
	public String getHarvestTool(int metadata)
	{
		return this.harvestTool;
	}
	
	@Override
	public int getHarvestLevel(int metadata)
	{
		return this.harvestLevel;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		String textureName = this.getTextureName();
		
		this.iconMap.clear();
		for (String type : this.types)
		{
			if (type == null)
			{
				continue;
			}
			
			if ("pillar".equals(type))
			{
				this.iconMap.put("pillar_top", iconRegister.registerIcon(textureName + "_pillar_top"));
				this.iconMap.put("pillar_side", iconRegister.registerIcon(textureName + "_pillar_side"));
			}
			else if ("raw_slab".equals(type))
			{
				if (this.redSandstone)
				{
					this.iconMap.put("top", iconRegister.registerIcon(textureName + "_top"));
					this.iconMap.put("side", iconRegister.registerIcon(textureName + "_side"));
					this.iconMap.put("bottom", iconRegister.registerIcon(textureName + "_bottom"));
				}
				else if (this.rawSlabUnsided)
				{
					this.iconMap.put("raw", iconRegister.registerIcon(textureName));
				}
				else
				{
					this.iconMap.put("raw_slab_top", iconRegister.registerIcon(textureName + "_slab_top"));
					this.iconMap.put("raw_slab_side", iconRegister.registerIcon(textureName + "_slab_side"));
				}
			}
			else if ("refined_slab".equals(type))
			{
				if (this.redSandstone)
				{
					this.iconMap.put("refined_slab_side", iconRegister.registerIcon(textureName + "_refined"));
				}
				else
				{
					this.iconMap.put("refined_slab_top", iconRegister.registerIcon(textureName + "_refined"));
					this.iconMap.put("refined_slab_side", iconRegister.registerIcon(textureName + "_refined_slab_side"));
				}
			}
			else if ("tile_slab".equals(type))
			{
				this.iconMap.put("tile_slab_top", iconRegister.registerIcon(textureName + "_tiles"));
				if (this.slabSided)
				{
					this.iconMap.put("tile_slab_side", iconRegister.registerIcon(textureName + "_tile_slab_side"));
				}
			}
			else if ("brick_slab".equals(type))
			{
				this.iconMap.put("brick_slab_top", iconRegister.registerIcon(textureName + "_bricks"));
				if (this.slabSided)
				{
					this.iconMap.put("brick_slab_side", iconRegister.registerIcon(textureName + "_brick_slab_side"));
				}
			}
			else
			{
				int i = type.indexOf("_slab");
				String type1 = type;
				if (i != -1)
				{
					type1 = type.substring(0, i);
				}
				this.iconMap.put(type, iconRegister.registerIcon(textureName + "_" + type1));
			}
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		int m = metadata % 3;
		String type = this.getType(metadata);
		if (type == null)
		{
			return this.blockIcon;
		}
		else if ("pillar".equals(type))
		{
			if (m == 0 && (side == 0 || side == 1) || m == 1 && (side == 2 || side == 3) || m == 2 && (side == 4 || side == 5))
			{
				return this.iconMap.get("pillar_top");
			}
			else
			{
				return this.iconMap.get("pillar_side");
			}
		}
		else if ("raw_slab".equals(type))
		{
			if (this.redSandstone)
			{
				return side == 0 ? this.iconMap.get("bottom") : side == 1 ? this.iconMap.get("top") : this.iconMap.get("side");
			}
			else if (this.rawSlabUnsided)
			{
				return this.iconMap.get("raw");
			}
			else if (side > 1)
			{
				return this.iconMap.get("raw_slab_side");
			}
			else
			{
				return this.iconMap.get("raw_slab_top");
			}
		}
		else if ("refined_slab".equals(type))
		{
			if (this.redSandstone)
			{
				return side == 0 || side == 1 ? this.iconMap.get("top") : this.iconMap.get("refined_slab_side");
			}
			else if (side > 1)
			{
				return this.iconMap.get("refined_slab_side");
			}
			else
			{
				return this.iconMap.get("refined_slab_top");
			}
		}
		else if ("tile_slab".equals(type))
		{
			if (side > 1 && this.slabSided)
			{
				return this.iconMap.get("tile_slab_side");
			}
			else
			{
				return this.iconMap.get("tile_slab_top");
			}
		}
		else if ("brick_slab".equals(type))
		{
			if (side > 1 && this.slabSided)
			{
				return this.iconMap.get("brick_slab_side");
			}
			else
			{
				return this.iconMap.get("brick_slab_top");
			}
		}
		else
		{
			return this.iconMap.get(type);
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
		return MCCommonProxy.custom2RenderType;
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
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
	{
		if (this.enderDragonCantDestroy)
		{
			return false;
		}
		return super.canEntityDestroy(world, x, y, z, entity);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	{
		if (worldObj.getBlockMetadata(x, y, z) != 3 && worldObj.getBlockMetadata(x, y, z) != 4 && worldObj.getBlockMetadata(x, y, z) != 5 && worldObj.getBlockMetadata(x, y, z) != 12 && worldObj.getBlockMetadata(x, y, z) != 13 && worldObj.getBlockMetadata(x, y, z) != 14)
		{
			return this.beaconBase;
		}
		
		return false;
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
	{
		return this.netherrack && this.isSideSolid(world, x, y, z, side);
	}
	
	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		String type = this.getType(metadata);
		int model = metadata % 3;
		
		if ("pillar".equals(type) || model == 2)
		{
			return true;
		}
		return model == 0 && side == ForgeDirection.DOWN || model == 1 && side == ForgeDirection.UP;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		if (this.getMaterial() == Material.wood)
		{
			int metadata = world.getBlockMetadata(x, y, z);
			if ("pillar".equals(this.getType(metadata)))
			{
				return 300;
			}
			else
			{
				return 150;
			}
		}
		return super.getFlammability(world, x, y, z, face);
	}
}
