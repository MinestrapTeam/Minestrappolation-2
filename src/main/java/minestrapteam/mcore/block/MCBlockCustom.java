package minestrapteam.mcore.block;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
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
 * Everything else is added by {@link MCBlockCustom2}
 * 
 * @author Clashsoft
 */
public class MCBlockCustom extends Block
{
	public String[]				types;
	
	public String				name;
	public float				baseHardness;
	public float				baseResistance;
	public int					harvestLevel;
	public String				harvestTool;
	
	public Map<String, IIcon>	iconMap	= new HashMap();
	
	public boolean				chiseledSided;
	public boolean				clay;
	public boolean				stone;
	public boolean				netherrack;
	public boolean				redSandstone;
	public boolean				enderDragonCantDestroy;
	
	public float				walkSpeed;
	
	public MCBlockCustom(String[] types, String name)
	{
		this(types, name, 1F, 5F, 0);
	}
	
	public MCBlockCustom(String[] types, String name, float baseHardness, float baseResistance, int harvestLevel)
	{
		super(Material.rock);
		this.name = name;
		this.baseHardness = baseHardness;
		this.baseResistance = baseResistance;
		this.harvestLevel = harvestLevel;
		this.types = types;
	}
	
	public MCBlockCustom setEnderDragonCantDestroy()
	{
		this.enderDragonCantDestroy = true;
		return this;
	}
	
	public MCBlockCustom setRoadWalkSpeed(float percent)
	{
		this.walkSpeed = percent;
		return this;
	}
	
	public MCBlockCustom setIsRedSandstone()
	{
		this.redSandstone = true;
		return this;
	}
	
	public MCBlockCustom setChiseledSided()
	{
		this.chiseledSided = true;
		return this;
	}
	
	public MCBlockCustom setIsClay()
	{
		this.clay = true;
		return this;
	}
	
	public MCBlockCustom setIsStone()
	{
		this.stone = true;
		return this;
	}
	
	public MCBlockCustom setIsNetherrack()
	{
		this.netherrack = true;
		return this;
	}
	
	public MCBlockCustom setHarvestTool(String tool)
	{
		this.harvestTool = tool;
		return this;
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
	public int damageDropped(int metadata)
	{
		return metadata;
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
		return f;
	}
	
	public float getResistance(int metadata)
	{
		return this.baseResistance;
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
	{
		return this.netherrack && side == UP;
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
		if ("road".equals(type))
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
		if ("road".equals(this.getType(world.getBlockMetadata(x, y, z))))
		{
			entityWalking.motionX *= this.walkSpeed;
			entityWalking.motionY *= this.walkSpeed;
			entityWalking.motionZ *= this.walkSpeed;
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
}
