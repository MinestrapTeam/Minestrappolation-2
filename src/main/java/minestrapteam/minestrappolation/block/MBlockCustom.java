package minestrapteam.minestrappolation.block;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.*;

import minestrapteam.minestrappolation.lib.MBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * The first Stone Cutter block type.<br>
 * This makes up the following blocks:
 * <ul>
 * <li>0: (Raw Block)
 * <li>1: Brick
 * <li>2: Patterned Brick
 * <li>3: Tiles
 * <li>4: Road
 * <li>5: Refined Block
 * <li>6: Chiseled
 * <li>7: Cracked
 * <li>8: Mossy
 * <li>14: Glowstone Lamp
 * <li>15: Sunstone Lamp
 * </ul>
 * Everything else is added by {@link MBlockCustom2}
 * 
 * @author Clashsoft
 */
public class MBlockCustom extends Block
{
	public String[]				types;
	
	public String				name;
	public float				baseHardness;
	public float				baseResistance;
	public int					harvestLevel;
	public String				harvestTool;
	
	public Map<String, IIcon>	iconMap		= new HashMap();
	
	public boolean				chiseledSided;
	public boolean				clay;
	public boolean				stone;
	public boolean				netherrack;
	public boolean				redSandstone;
	public boolean				enderDragonCantDestroy;
	public boolean				beaconBase;
	
	public float				walkSpeed	= 1F;
	
	public MBlockCustom(String[] types, String name)
	{
		this(types, name, 1F, 5F, 0, Material.rock);
	}
	
	public MBlockCustom(String[] types, String name, Material mat)
	{
		this(types, name, 1F, 5F, 0, mat);
	}
	
	public MBlockCustom(String[] types, String name, float baseHardness, float baseResistance, int harvestLevel, Material mat)
	{
		super(mat);
		this.name = name;
		this.baseHardness = baseHardness;
		this.baseResistance = baseResistance;
		this.harvestLevel = harvestLevel;
		this.types = types;
	}
	
	public MBlockCustom setEnderDragonCantDestroy()
	{
		this.enderDragonCantDestroy = true;
		return this;
	}
	
	public MBlockCustom setBeaconBase()
	{
		this.beaconBase = true;
		return this;
	}
	
	public MBlockCustom setRoadWalkSpeed(float percent)
	{
		this.walkSpeed = percent;
		return this;
	}
	
	public MBlockCustom setIsRedSandstone()
	{
		this.redSandstone = true;
		return this;
	}
	
	public MBlockCustom setChiseledSided()
	{
		this.chiseledSided = true;
		return this;
	}
	
	public MBlockCustom setIsClay()
	{
		this.clay = true;
		return this;
	}
	
	public MBlockCustom setIsStone()
	{
		this.stone = true;
		return this;
	}
	
	public MBlockCustom setIsNetherrack()
	{
		this.netherrack = true;
		return this;
	}
	
	public MBlockCustom setHarvestTool(String tool)
	{
		this.harvestTool = tool;
		return this;
	}
	
	public ItemStack toStack(String type)
	{
		return this.toStack(type, 1);
	}
	
	public ItemStack toStack(String type, int size)
	{
		int i = Arrays.binarySearch(this.types, type);
		return new ItemStack(this, size, i);
	}
	
	public String getType(int metadata)
	{
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
	public boolean canSilkHarvest()
	{
		return true;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == MBlocks.endstone && metadata == 0)
		{
			return Item.getItemFromBlock(Blocks.end_stone);
		}
		else if (this.getType(metadata).contains("rotten"))
		{
			return Items.stick;
		}
		return super.getItemDropped(metadata, random, fortune);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		if (this.getType(metadata).contains("rotten"))
		{
			return 0;
		}
		return metadata;
	}
	
	@Override
	public int quantityDropped(int metadata, int fortune, Random random)
	{
		if (this.getType(metadata).contains("rotten"))
		{
			return MathHelper.clamp_int(2 + random.nextInt(fortune + 3), 1, 4);
		}
		return 1;
	}
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		return this.getHardness(world.getBlockMetadata(x, y, z));
	}
	
	@Override
	public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		return this.getResistance(world.getBlockMetadata(x, y, z));
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
	
	/**
	 * Returns the hardness for the given {@code metadata}.
	 * 
	 * @param metadata
	 *            the metadata value
	 * @return the hardness
	 */
	public float getHardness(int metadata)
	{
		float f = this.baseHardness;
		String type = this.getType(metadata);
		
		if (type == null || "raw".equals(type))
		{
			return f;
		}
		else if ("bricks".equals(type))
		{
			if (this.netherrack)
			{
				return f + 1.6F;
			}
			else if (this.clay)
			{
				return f + 0.75F;
			}
		}
		else if ("pattern_bricks".equals(type))
		{
			if (this.netherrack)
			{
				return f + 1.6F;
			}
			else if (this.clay)
			{
				return f + 0.75F;
			}
		}
		else if ("refined".equals(type))
		{
			if (this.netherrack)
			{
				return (f + 1.6F) * (2F / 3F);
			}
			else if (this.clay)
			{
				return (f + 0.75F) * (2F / 3F);
			}
			else
			{
				return f * (2F / 3F);
			}
		}
		else if ("cracked".equals(type))
		{
			if (this.stone)
			{
				return f * (4F / 3F);
			}
		}
		else if ("mossy".equals(type))
		{
			if (this.stone)
			{
				return f * (4F / 3F);
			}
		}
		else if (type.contains("lamp"))
		{
			return f * 0.8F;
		}
		else if (type.contains("rotten"))
		{
			return f * 0.9F;
		}
		
		return f;
	}
	
	public float getResistance(int metadata)
	{
		float f = this.baseResistance;
		String type = this.getType(metadata);
		
		if (type == null || "raw".equals(type))
		{
			return f;
		}
		else if ("bricks".equals(type))
		{
			if (this.netherrack)
			{
				return f + 1.6F;
			}
			else if (this.clay)
			{
				return f + 0.75F;
			}
		}
		else if ("pattern_bricks".equals(type))
		{
			if (this.netherrack)
			{
				return f + 1.6F;
			}
			else if (this.clay)
			{
				return f + 0.75F;
			}
		}
		else if ("refined".equals(type))
		{
			if (this.netherrack)
			{
				return (f + 1.6F) * (2F / 3F);
			}
			else if (this.clay)
			{
				return (f + 0.75F) * (2F / 3F);
			}
			else
			{
				return f * (2F / 3F);
			}
		}
		else if ("cracked".equals(type))
		{
			if (this.stone)
			{
				return f * (4F / 3F);
			}
		}
		else if ("mossy".equals(type))
		{
			if (this.stone)
			{
				return f * (4F / 3F);
			}
		}
		else if (type.contains("lamp"))
		{
			return f * 0.8F;
		}
		else if (type.contains("rotten"))
		{
			return f * 0.9F;
		}
		
		return f;
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
	{
		if (this.netherrack && side == UP)
		{
			String type = this.getType(world.getBlockMetadata(x, y, z));
			return !"road".equals(type) && !"pattern_bricks".equals(type);
		}
		return false;
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		String type = this.getType(metadata);
		if ("glowstone_lamp".equals(type))
		{
			return Blocks.glowstone.getLightValue();
		}
		else if (type.contains("lamp"))
		{
			return 15;
		}
		return super.getLightValue(world, x, y, z);
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
			
			if ("raw".equals(type))
			{
				if (this.redSandstone)
				{
					this.iconMap.put("top", iconRegister.registerIcon(textureName + "_top"));
					this.iconMap.put("side", iconRegister.registerIcon(textureName + "_side"));
					this.iconMap.put("bottom", iconRegister.registerIcon(textureName + "_bottom"));
				}
				else
				{
					this.blockIcon = iconRegister.registerIcon(textureName);
				}
			}
			else if ("road".equals(type))
			{
				this.iconMap.put("road_top", iconRegister.registerIcon(textureName + "_pattern_bricks"));
				this.iconMap.put("road_side", iconRegister.registerIcon(textureName + "_road_side"));
				this.iconMap.put("road_bottom", iconRegister.registerIcon(textureName + "_road_bottom"));
			}
			else if ("chiseled".equals(type))
			{
				if (this.clay)
				{
					this.iconMap.put("chiseled", iconRegister.registerIcon(textureName + "_refined"));
					this.iconMap.put("chiseled_side", iconRegister.registerIcon(textureName + "_chiseled_side"));
				}
				else
				{
					this.iconMap.put("chiseled", iconRegister.registerIcon(textureName + "_chiseled"));
					if (this.chiseledSided)
					{
						this.iconMap.put("chiseled_side", iconRegister.registerIcon(textureName + "_chiseled_side"));
					}
				}
			}
			else
			{
				this.iconMap.put(type, iconRegister.registerIcon(textureName + "_" + type));
			}
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		String type = this.getType(metadata);
		if (type == null || "raw".equals(type))
		{
			if (this.redSandstone)
			{
				return side == 0 ? this.iconMap.get("bottom") : side == 1 ? this.iconMap.get("top") : this.iconMap.get("side");
			}
			else
			{
				return this.blockIcon;
			}
		}
		else if ("refined".equals(type))
		{
			if (this.redSandstone)
			{
				return side == 0 || side == 1 ? this.iconMap.get("top") : this.iconMap.get("refined");
			}
			else
			{
				return this.iconMap.get("refined");
			}
		}
		else if ("road".equals(type))
		{
			if (side == 0)
			{
				return this.iconMap.get("road_bottom");
			}
			else if (side == 1)
			{
				return this.iconMap.get("road_top");
			}
			else
			{
				return this.iconMap.get("road_side");
			}
		}
		else if ("chiseled".equals(type))
		{
			if (this.redSandstone)
			{
				if (side == 0)
				{
					return this.iconMap.get("bottom");
				}
				else if (side == 1)
				{
					return this.iconMap.get("top");
				}
				else
				{
					return this.iconMap.get("chiseled");
				}
			}
			else if (side > 1 && (this.clay || this.chiseledSided))
			{
				return this.iconMap.get("chiseled_side");
			}
			else
			{
				return this.iconMap.get("chiseled");
			}
		}
		else if ("gilded".equals(type))
		{
			return this.iconMap.get("gilded");
		}
		else
		{
			return this.iconMap.get(type);
		}
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.types.length; i++)
		{
			if (this.types[i] != null)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entityWalking)
	{
		String type = this.getType(world.getBlockMetadata(x, y, z));
		
		if ("road".equals(type))
		{
			entityWalking.motionX *= this.walkSpeed;
			entityWalking.motionY *= this.walkSpeed;
			entityWalking.motionZ *= this.walkSpeed;
		}
		else if (type.contains("rotten"))
		{
			if (!world.isRemote)
			{
				world.func_147480_a(x, y, z, true);
			}
		}
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
	{
		return !this.enderDragonCantDestroy && super.canEntityDestroy(world, x, y, z, entity);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	{
		if (worldObj.getBlockMetadata(x, y, z) != 4)
		{
			return this.beaconBase;
		}
		
		return false;
	}
}
