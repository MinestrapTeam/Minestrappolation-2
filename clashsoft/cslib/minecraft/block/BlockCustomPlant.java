package clashsoft.cslib.minecraft.block;

import static net.minecraftforge.common.EnumPlantType.*;

import java.util.List;
import java.util.Random;

import clashsoft.cslib.minecraft.CustomBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public abstract class BlockCustomPlant extends CustomBlock implements ICustomBlock, IPlantable
{
	public String[]	iconNames;
	
	@SideOnly(Side.CLIENT)
	public Icon[]	icons;
	
	public BlockCustomPlant(int blockID, String[] names, String[] icons)
	{
		super(blockID, Material.plants, names, icons, null);
		this.setBlockBounds(0.3F, 0F, 0.3F, 0.7F, 0.6F, 0.7F);
		this.setStepSound(soundGrassFootstep);
		
		this.names = names;
		this.iconNames = icons;
	}
	
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return this.icons[metadata];
	}
	
	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side, ItemStack stack)
	{
		return super.canPlaceBlockOnSide(world, x, y, z, side, stack) && canBlockStay(world, x, y, z, stack.getItemDamage());
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.checkFlowerChange(world, x, y, z);
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are their own) Args: x, y, z, neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID)
	{
		super.onNeighborBlockChange(world, x, y, z, neighborBlockID);
		this.checkFlowerChange(world, x, y, z);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		this.checkFlowerChange(world, x, y, z);
	}
	
	protected void checkFlowerChange(World world, int x, int y, int z)
	{
		checkFlowerChange(world, x, y, z, world.getBlockMetadata(x, y, z));
	}
	
	protected void checkFlowerChange(World world, int x, int y, int z, int metadata)
	{
		if (!this.canBlockStay(world, x, y, z, metadata))
		{
			this.dropBlockAsItem(world, x, y, z, metadata, 0);
			world.setBlock(x, y, z, 0, 0, 2);
		}
	}
	
	/**
	 * Can this block stay at this position. Similar to canPlaceBlockAt except gets checked often with plants.
	 */
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return canBlockStay(world, x, y, z, world.getBlockMetadata(x, y, z));
	}
	
	public boolean canBlockStay(World world, int x, int y, int z, int metadata)
	{
		Block soil = blocksList[world.getBlockId(x, y - 1, z)];
		
		if (soil == null)
			return false;
		
		boolean validLight = world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z);
		boolean validSoil = soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
		
		return validLight && this.isValidGround(metadata, soil.blockID, world.getBlockMetadata(x, y - 1, z));
	}
	
	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether or not to render the shared face of two adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return 1;
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		if (blockID == crops.blockID)
			return Crop;
		if (blockID == deadBush.blockID)
			return Desert;
		if (blockID == waterlily.blockID)
			return Water;
		if (blockID == mushroomRed.blockID)
			return Cave;
		if (blockID == mushroomBrown.blockID)
			return Cave;
		if (blockID == netherStalk.blockID)
			return Nether;
		if (blockID == sapling.blockID)
			return Plains;
		if (blockID == melonStem.blockID)
			return Crop;
		if (blockID == pumpkinStem.blockID)
			return Crop;
		if (blockID == tallGrass.blockID)
			return Plains;
		return Plains;
	}
	
	@Override
	public int getPlantID(World world, int x, int y, int z)
	{
		return blockID;
	}
	
	@Override
	public int getPlantMetadata(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	public boolean isValidGround(World world, int x, int y, int z)
	{
		return this.isValidGround(world.getBlockMetadata(x, y, z), world.getBlockId(x, y - 1, z), world.getBlockMetadata(x, y - 1, z));
	}
	
	public abstract boolean isValidGround(int metadata, int blockID, int blockMetadata);
	
	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	/**
	 * Returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockID, CreativeTabs creativeTab, List itemList)
	{
		for (int i = 0; i < names.length; i++)
			itemList.add(new ItemStack(this, 1, i));
	}
	
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This is the only chance you get to register icons.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.icons = new Icon[iconNames.length];
		for (int i = 0; i < iconNames.length; ++i)
		{
			this.icons[i] = iconRegister.registerIcon(iconNames[i]);
		}
	}
}
