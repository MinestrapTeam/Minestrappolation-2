package clashsoft.cslib.minecraft.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockCustomLeaves extends CustomBlock implements IShearable
{	
	public ItemStack[]		appleStacks		= new ItemStack[4];
	public ItemStack[]		saplingStacks	= new ItemStack[4];
	public boolean[]		isColored		= new boolean[4];
	
	public IIcon[]			icons, opaqueIcons;
	public int[]			adjacentTreeBlocks;
	
	public static boolean	graphicsLevel;
	
	public BlockCustomLeaves(String[] names, String[] icons)
	{
		super(Material.leaves, names, icons, null);
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeGrass);
		this.setLightOpacity(1);
	}
	
	public BlockCustomLeaves(String[] names, String domain)
	{
		this(names, applyDomain(names, domain));
	}
	
	public BlockCustomLeaves setAppleStacks(ItemStack... appleStacks)
	{
		this.appleStacks = appleStacks;
		return this;
	}
	
	public BlockCustomLeaves setSaplingStacks(ItemStack... saplingStacks)
	{
		this.saplingStacks = saplingStacks;
		return this;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		if (this.isColored[0])
		{
			double d0 = 0.5D;
			double d1 = 1.0D;
			return ColorizerFoliage.getFoliageColor(d0, d1);
		}
		return super.getBlockColor();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int pass)
	{
		return this.isColored[pass & 3] ? ColorizerFoliage.getFoliageColorBasic() : super.getRenderColor(pass);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		
		if (this.isColored[l & 3])
		{
			if ((l & 3) == 1)
			{
				return ColorizerFoliage.getFoliageColorPine();
			}
			else if ((l & 3) == 2)
			{
				return ColorizerFoliage.getFoliageColorBirch();
			}
			else
			{
				int k = 0;
				int i1 = 0;
				int j1 = 0;
				
				for (int k1 = -1; k1 <= 1; ++k1)
				{
					for (int l1 = -1; l1 <= 1; ++l1)
					{
						int i2 = world.getBiomeGenForCoords(x + l1, z + k1).getBiomeFoliageColor(x + l1, y, z + k1);
						k += ((i2 & 0xFF0000) >> 16);
						i1 += ((i2 & 0xFF00) >> 8);
						j1 += (i2 & 0xFF);
					}
				}
				
				return ((l / 9 & 0xFF) << 16 | (i1 / 9 & 0xFF) << 8 | j1 / 9 & 0xFF);
			}
		}
		return super.colorMultiplier(world, x, y, z);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldBlockMetadata)
	{
		byte b0 = 1;
		int j1 = b0 + 1;
		
		if (world.checkChunksExist(x - j1, y - j1, z - j1, x + j1, y + j1, z + j1))
		{
			for (int k1 = -b0; k1 <= b0; ++k1)
			{
				for (int l1 = -b0; l1 <= b0; ++l1)
				{
					for (int i2 = -b0; i2 <= b0; ++i2)
					{
						Block block = world.getBlock(x + k1, y + l1, z + i2);
						block.beginLeavesDecay(world, x + k1, y + l1, z + i2);
					}
				}
			}
		}
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote)
		{
			int l = world.getBlockMetadata(x, y, z);
			
			if ((l & 8) != 0 && (l & 4) == 0)
			{
				byte b0 = 4;
				int i1 = b0 + 1;
				byte b1 = 32;
				int j1 = b1 * b1;
				int k1 = b1 / 2;
				
				if (this.adjacentTreeBlocks == null)
				{
					this.adjacentTreeBlocks = new int[b1 * b1 * b1];
				}
				
				int l1;
				
				if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1))
				{
					int i2;
					int j2;
					
					for (l1 = -b0; l1 <= b0; ++l1)
					{
						for (i2 = -b0; i2 <= b0; ++i2)
						{
							for (j2 = -b0; j2 <= b0; ++j2)
							{
								Block block = world.getBlock(x + l1, y + i2, z + j2);
								
								if (block != null && block.canSustainLeaves(world, x + l1, y + i2, z + j2))
								{
									this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
								}
								else if (block != null && block.isLeaves(world, x + l1, y + i2, z + j2))
								{
									this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
								}
								else
								{
									this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
								}
							}
						}
					}
					
					int k2;
					
					for (l1 = 1; l1 <= 4; ++l1)
					{
						for (i2 = -b0; i2 <= b0; ++i2)
						{
							for (j2 = -b0; j2 <= b0; ++j2)
							{
								for (k2 = -b0; k2 <= b0; ++k2)
								{
									if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1)
									{
										if (this.adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
										{
											this.adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
										}
										
										if (this.adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
										{
											this.adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
										}
										
										if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2)
										{
											this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
										}
										
										if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2)
										{
											this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
										}
										
										if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2)
										{
											this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
										}
										
										if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2)
										{
											this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
										}
									}
								}
							}
						}
					}
				}
				
				l1 = this.adjacentTreeBlocks[k1 * j1 + k1 * b1 + k1];
				
				if (l1 >= 0)
				{
					world.setBlockMetadataWithNotify(x, y, z, l & -9, 4);
				}
				else
				{
					this.removeLeaves(world, x, y, z);
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (world.canLightningStrikeAt(x, y + 1, z) && !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && random.nextInt(15) == 1)
		{
			double d0 = x + random.nextFloat();
			double d1 = y - 0.05D;
			double d2 = z + random.nextFloat();
			world.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
	
	public void removeLeaves(World world, int x, int y, int z)
	{
		this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
		world.setBlockToAir(x, y, z);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(20) == 0 ? 1 : 0;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		ItemStack stack = this.saplingStacks[metadata];
		return stack != null ? stack.getItem() : null;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float dropChance, int fortune)
	{
		if (!world.isRemote)
		{
			int j1 = 20;
			
			if ((metadata & 3) == 3)
			{
				j1 = 40;
			}
			
			if (fortune > 0)
			{
				j1 -= 2 << fortune;
				
				if (j1 < 10)
				{
					j1 = 10;
				}
			}
			
			if (world.rand.nextInt(j1) == 0)
			{
				ItemStack stack = this.saplingStacks[metadata & 3];
				if (stack != null)
				{
					this.dropBlockAsItem(world, x, y, z, stack);
				}
			}
			
			j1 = 200;
			
			if (fortune > 0)
			{
				j1 -= 10 << fortune;
				
				if (j1 < 40)
				{
					j1 = 40;
				}
			}
			
			if ((metadata & 3) == 0 && world.rand.nextInt(j1) == 0)
			{
				ItemStack stack = this.appleStacks[metadata & 3];
				if (stack != null)
				{
					this.dropBlockAsItem(world, x, y, z, stack);
				}
				;
			}
		}
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int metadata)
	{
		super.harvestBlock(world, player, x, y, z, metadata);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata & 3;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return !graphicsLevel;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		graphicsLevel = Minecraft.getMinecraft().gameSettings.fancyGraphics;
		return graphicsLevel ? this.icons[metadata & 3] : this.opaqueIcons[metadata & 3];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < this.names.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(this, 1, metadata & 3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		int len = this.iconNames.length;
		
		this.icons = new IIcon[len];
		this.opaqueIcons = new IIcon[len];
		
		for (int i = 0; i < len; ++i)
		{
			this.icons[i] = iconRegister.registerIcon(this.iconNames[i]);
			this.opaqueIcons[i] = iconRegister.registerIcon(this.iconNames[i] + "_opaque");
		}
	}
	
	@Override
	public boolean isShearable(ItemStack stack, IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public ArrayList<ItemStack> onSheared(ItemStack stack, IBlockAccess world, int x, int y, int z, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(this.createStackedBlock(world.getBlockMetadata(x, y, z)));
		return ret;
	}
	
	@Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}
	
	@Override
	public boolean isLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		Block block = world.getBlock(x, y, z);
		return !graphicsLevel && block == this ? false : super.shouldSideBeRendered(world, x, y, z, side);
	}
}
