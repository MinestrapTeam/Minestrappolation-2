package clashsoft.cslib.minecraft.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.CustomBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockCustomLeaves extends CustomBlock implements IShearable
{
	public String[]			iconNames;
	
	public ItemStack[]		appleStacks		= new ItemStack[4];
	public ItemStack[]		saplingStacks	= new ItemStack[4];
	public boolean[]		isColored		= new boolean[4];
	
	public Icon[]			icons, opaqueIcons;
	public int[]			adjacentTreeBlocks;
	
	public static boolean	graphicsLevel;
	
	public BlockCustomLeaves(int blockID, String[] names, String[] icons)
	{
		super(blockID, Material.leaves, names, icons, null);
		this.setTickRandomly(true);
		this.setStepSound(soundGrassFootstep);
		this.setLightOpacity(1);
		
		this.names = names;
		this.iconNames = icons;
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
		if (isColored[0])
		{
			double d0 = 0.5D;
			double d1 = 1.0D;
			return ColorizerFoliage.getFoliageColor(d0, d1);
		}
		return super.getBlockColor();
	}
	
	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int pass)
	{
		return isColored[pass & 3] ? ColorizerFoliage.getFoliageColorBasic() : super.getRenderColor(pass);
	}
	
	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied
	 * against the blocks color. Note only called when first determining what to
	 * render.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		
		if (isColored[l & 3])
		{
			if ((l & 3) == 1)
				return ColorizerFoliage.getFoliageColorPine();
			else if ((l & 3) == 2)
				return ColorizerFoliage.getFoliageColorBirch();
			else
			{
				int i1 = 0;
				int j1 = 0;
				int k1 = 0;
				
				for (int l1 = -1; l1 <= 1; ++l1)
				{
					for (int i2 = -1; i2 <= 1; ++i2)
					{
						int j2 = world.getBiomeGenForCoords(x + i2, z + l1).getBiomeFoliageColor();
						i1 += (j2 & 16711680) >> 16;
						j1 += (j2 & 65280) >> 8;
						k1 += j2 & 255;
					}
				}
				
				return (i1 / 9 & 255) << 16 | (j1 / 9 & 255) << 8 | k1 / 9 & 255;
			}
		}
		return super.colorMultiplier(world, x, y, z);
	}
	
	/**
	 * Called on server worlds only when the block has been replaced by a
	 * different block ID, or the same block with a different metadata value,
	 * but before the new metadata value is set. Args: World, x, y, z, old block
	 * ID, old metadata
	 */
	@Override
	public void breakBlock(World world, int x, int y, int z, int oldBlockID, int oldBlockMetadata)
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
						int j2 = world.getBlockId(x + k1, y + l1, z + i2);
						
						if (Block.blocksList[j2] != null)
							Block.blocksList[j2].beginLeavesDecay(world, x + k1, y + l1, z + i2);
					}
				}
			}
		}
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World world, int par2, int par3, int par4, Random par5Random)
	{
		if (!world.isRemote)
		{
			int l = world.getBlockMetadata(par2, par3, par4);
			
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
				
				if (world.checkChunksExist(par2 - i1, par3 - i1, par4 - i1, par2 + i1, par3 + i1, par4 + i1))
				{
					int i2;
					int j2;
					int k2;
					
					for (l1 = -b0; l1 <= b0; ++l1)
					{
						for (i2 = -b0; i2 <= b0; ++i2)
						{
							for (j2 = -b0; j2 <= b0; ++j2)
							{
								k2 = world.getBlockId(par2 + l1, par3 + i2, par4 + j2);
								
								Block block = Block.blocksList[k2];
								
								if (block != null && block.canSustainLeaves(world, par2 + l1, par3 + i2, par4 + j2))
								{
									this.adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
								}
								else if (block != null && block.isLeaves(world, par2 + l1, par3 + i2, par4 + j2))
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
					world.setBlockMetadataWithNotify(par2, par3, par4, l & -9, 4);
				}
				else
				{
					this.removeLeaves(world, par2, par3, par4);
				}
			}
		}
	}
	
	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int par2, int par3, int par4, Random par5Random)
	{
		if (world.canLightningStrikeAt(par2, par3 + 1, par4) && !world.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && par5Random.nextInt(15) == 1)
		{
			double d0 = par2 + par5Random.nextFloat();
			double d1 = par3 - 0.05D;
			double d2 = par4 + par5Random.nextFloat();
			world.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
	
	public void removeLeaves(World world, int par2, int par3, int par4)
	{
		this.dropBlockAsItem(world, par2, par3, par4, world.getBlockMetadata(par2, par3, par4), 0);
		world.setBlockToAir(par2, par3, par4);
	}
	
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random)
	{
		return par1Random.nextInt(20) == 0 ? 1 : 0;
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		ItemStack stack = saplingStacks[par1 % saplingStacks.length];
		return stack != null ? stack.itemID : 0;
	}
	
	/**
	 * Drops the block items with a specified chance of dropping the specified
	 * items
	 */
	@Override
	public void dropBlockAsItemWithChance(World world, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		if (!world.isRemote)
		{
			int j1 = 20;
			int metadata = world.getBlockMetadata(par2, par3, par4);
			
			if ((par5 & 3) == 3)
			{
				j1 = 40;
			}
			
			if (par7 > 0)
			{
				j1 -= 2 << par7;
				
				if (j1 < 10)
				{
					j1 = 10;
				}
			}
			
			if (world.rand.nextInt(j1) == 0)
			{
				ItemStack stack = this.saplingStacks[metadata & 3];
				if (stack != null)
					this.dropBlockAsItem_do(world, par2, par3, par4, stack);
			}
			
			j1 = 200;
			
			if (par7 > 0)
			{
				j1 -= 10 << par7;
				
				if (j1 < 40)
				{
					j1 = 40;
				}
			}
			
			if ((par5 & 3) == 0 && world.rand.nextInt(j1) == 0)
			{
				ItemStack stack = this.appleStacks[metadata & 3];
				if (stack != null)
					this.dropBlockAsItem_do(world, par2, par3, par4, stack);
				;
			}
		}
	}
	
	/**
	 * Called when the player destroys a block with an item that can harvest it.
	 * (i, j, k) are the coordinates of the block and l is the block's
	 * subtype/damage.
	 */
	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int metadata)
	{
		super.harvestBlock(world, player, x, y, z, metadata);
	}
	
	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int metadata)
	{
		return metadata & 3;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return !graphicsLevel;
	}
	
	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		graphicsLevel = Minecraft.getMinecraft().gameSettings.fancyGraphics;
		return graphicsLevel ? this.icons[metadata & 3] : this.opaqueIcons[metadata & 3];
	}
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockID, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < names.length; i++)
			list.add(new ItemStack(this, 1, i));
	}
	
	/**
	 * Returns an item stack containing a single instance of the current block
	 * type. 'i' is the block's subtype/damage and is ignored for blocks which
	 * do not support subtypes. Blocks which cannot be harvested should return
	 * null.
	 */
	@Override
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(this.blockID, 1, metadata & 3);
	}
	
	/**
	 * When this method is called, your block should register all the icons it
	 * needs with the given IconRegister. This is the only chance you get to
	 * register icons.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.icons = new Icon[iconNames.length];
		this.opaqueIcons = new Icon[iconNames.length];
		
		for (int i = 0; i < iconNames.length; ++i)
		{
			this.icons[i] = iconRegister.registerIcon(iconNames[i]);
			this.opaqueIcons[i] = iconRegister.registerIcon(iconNames[i] + "_opaque");
		}
	}
	
	@Override
	public boolean isShearable(ItemStack item, World world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(createStackedBlock(world.getBlockMetadata(x, y, z)));
		return ret;
	}
	
	@Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}
	
	@Override
	public boolean isLeaves(World world, int x, int y, int z)
	{
		return true;
	}
	
	/**
	 * Returns true if the given side of this block type should be rendered, if
	 * the adjacent block is at the given coordinates. Args: blockAccess, x, y,
	 * z, side
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		int i1 = world.getBlockId(x, y, z);
		return !graphicsLevel && i1 == this.blockID ? false : super.shouldSideBeRendered(world, x, y, z, side);
	}
}
