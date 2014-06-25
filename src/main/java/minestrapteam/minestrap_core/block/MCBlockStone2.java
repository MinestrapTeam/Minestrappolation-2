package minestrapteam.minestrap_core.block;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.List;

import minestrapteam.minestrap_core.common.MCCommonProxy;
import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
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
 * Everything else is added by {@link MCBlockStone}
 * 
 * @author Clashsoft
 */
public class MCBlockStone2 extends Block
{
	public String[]	types;
	
	public String	name;
	public float	baseHardness;
	public float	baseResistance;
	public int		harvestLevel;
	
	public IIcon[]	topIcons;
	public IIcon[]	sideIcons;
	
	public boolean	netherrack;
	
	public MCBlockStone2(String[] types, String name, float baseHardness, float baseResistance, int harvestLevel)
	{
		super(Material.rock);
		this.setCreativeTab(Minestrappolation.tabStoneDecor);
		this.name = name;
		this.baseHardness = baseHardness;
		this.baseResistance = baseResistance;
		this.harvestLevel = harvestLevel;
		this.types = types;
	}
	
	public MCBlockStone2 setIsNetherrack()
	{
		this.netherrack = true;
		return this;
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
		if (metadata < 3)
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
		else if ((side == 0) || (side != 1 && hitY > 0.5D))
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
	public float getBlockHardness(World world, int x, int y, int z)
	{
		return this.getHardness(world.getBlockMetadata(x, y, z));
	}
	
	public float getHardness(int metadata)
	{
		float f = this.baseHardness;
		return f;
	}
	
	@Override
	public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		float g = this.baseResistance;
		return g;
	}
	
	@Override
	public String getHarvestTool(int metadata)
    {
        return "pickaxe";
    }
	
	@Override
	public int getHarvestLevel(int metadata)
    {
        return harvestLevel;
    }
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.topIcons = new IIcon[5];
		this.sideIcons = new IIcon[5];
		
		String textureName = this.getTextureName();
		this.topIcons[0] = iconRegister.registerIcon(textureName + "_pillar_top");
		this.sideIcons[0] = iconRegister.registerIcon(textureName + "_pillar_side");
		this.topIcons[1] = iconRegister.registerIcon(textureName + "_slab_top");
		this.sideIcons[1] = iconRegister.registerIcon(textureName + "_slab_side");
		this.topIcons[2] = this.sideIcons[2] = iconRegister.registerIcon(textureName + "_bricks");
		this.topIcons[3] = this.sideIcons[3] = iconRegister.registerIcon(textureName + "_tiles");
		this.topIcons[4] = iconRegister.registerIcon(textureName + "_refined");
		this.sideIcons[4] = iconRegister.registerIcon(textureName + "_refined_slab_side");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
		{
			if (side == 0 || side == 1)
			{
				return this.topIcons[0];
			}
			else
			{
				return this.sideIcons[0];
			}
		}
		else if (metadata == 1)
		{
			if (side == 2 || side == 3)
			{
				return this.topIcons[0];
			}
			else
			{
				return this.sideIcons[0];
			}
		}
		else if (metadata == 2)
		{
			if (side == 4 || side == 5)
			{
				return this.topIcons[0];
			}
			else
			{
				return this.sideIcons[0];
			}
		}
		else if (metadata < 15)
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
		return this.blockIcon;
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
    {
        if (this.netherrack == true && side == UP)
        {
            return true;
        }
        else
        {
        	return false;
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
		return MCCommonProxy.stone2RenderType;
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
