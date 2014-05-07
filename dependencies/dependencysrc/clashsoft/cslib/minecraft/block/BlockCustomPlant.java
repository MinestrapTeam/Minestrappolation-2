package clashsoft.cslib.minecraft.block;

import static net.minecraftforge.common.EnumPlantType.Plains;

import java.util.List;
import java.util.Random;

import clashsoft.cslib.util.CSString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockCustomPlant extends CustomBlock implements ICustomBlock, IPlantable
{
	@SideOnly(Side.CLIENT)
	public IIcon[]	icons;
	
	public BlockCustomPlant(String[] names, String[] icons)
	{
		super(Material.plants, names, icons, null);
		this.setBlockBounds(0.3F, 0F, 0.3F, 0.7F, 0.6F, 0.7F);
		this.setStepSound(Block.soundTypeGrass);
	}
	
	public BlockCustomPlant(String[] names, String domain)
	{
		this(names, CSString.concatAll(names, domain + ":", ""));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		return this.icons[metadata];
	}
	
	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
	{
		return super.canPlaceBlockOnSide(world, x, y, z, side) && this.canBlockStay(world, x, y, z, 0);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.checkFlowerChange(world, x, y, z);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock)
	{
		super.onNeighborBlockChange(world, x, y, z, neighborBlock);
		this.checkFlowerChange(world, x, y, z);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		this.checkFlowerChange(world, x, y, z);
	}
	
	protected void checkFlowerChange(World world, int x, int y, int z)
	{
		this.checkFlowerChange(world, x, y, z, world.getBlockMetadata(x, y, z));
	}
	
	protected void checkFlowerChange(World world, int x, int y, int z, int metadata)
	{
		if (!this.canBlockStay(world, x, y, z, metadata))
		{
			this.dropBlockAsItem(world, x, y, z, metadata, 0);
			world.setBlockToAir(x, y, z);
		}
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return this.canBlockStay(world, x, y, z, world.getBlockMetadata(x, y, z));
	}
	
	public boolean canBlockStay(World world, int x, int y, int z, int metadata)
	{
		Block soil = world.getBlock(x, y - 1, z);
		
		if (soil == null)
		{
			return false;
		}
		
		boolean validLight = world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z);
		
		return validLight && this.isValidGround(metadata, soil, world.getBlockMetadata(x, y - 1, z));
	}
	
	public boolean isValidGround(World world, int x, int y, int z)
	{
		return this.isValidGround(world.getBlockMetadata(x, y, z), world.getBlock(x, y - 1, z), world.getBlockMetadata(x, y - 1, z));
	}
	
	public boolean isValidGround(int metadata, Block block, int blockMetadata)
	{
		return block == Blocks.dirt || block == Blocks.grass;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
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
		return 1;
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return Plains;
	}
	
	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z)
	{
		return this;
	}
	
	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List itemList)
	{
		for (int i = 0; i < this.names.length; i++)
		{
			itemList.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[this.iconNames.length];
		for (int i = 0; i < this.iconNames.length; ++i)
		{
			this.icons[i] = iconRegister.registerIcon(this.iconNames[i]);
		}
	}
}
