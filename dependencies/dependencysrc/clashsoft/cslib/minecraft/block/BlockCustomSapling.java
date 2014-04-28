package clashsoft.cslib.minecraft.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.terraingen.TerrainGen;

public abstract class BlockCustomSapling extends BlockSapling implements ICustomBlock
{
	public String[]	names;
	public String[]	iconNames;
	
	@SideOnly(Side.CLIENT)
	public IIcon[]	icons;
	
	public BlockCustomSapling(String[] names, String[] iconNames)
	{
		this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
		this.setHardness(0F);
		this.setStepSound(Block.soundTypeGrass);
		
		this.names = names;
		this.iconNames = iconNames;
	}
	
	public BlockCustomSapling(String[] names, String domain)
	{
		this(names, CustomBlock.applyDomain(names, domain));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return CustomBlock.getUnlocalizedName(this, stack, this.names);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
		CustomBlock.addInformation(this, stack, list);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote)
		{
			super.updateTick(world, x, y, z, random);
			
			if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
			{
				this.markOrGrowMarked(world, x, y, z, random);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		return this.icons[metadata & 3];
	}
	
	public void markOrGrowMarked(World world, int x, int y, int z, Random random)
	{
		this.func_149879_c(world, x, y, z, random);
	}
	
	/*
	 * markOrGrowMarked
	 */
	@Override
	public void func_149879_c(World world, int x, int y, int z, Random random)
	{
		int l = world.getBlockMetadata(x, y, z);
		
		if ((l & 8) == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
		}
		else
		{
			this.func_149878_d(world, x, y, z, random);
		}
	}
	
	public void growTree(World world, int x, int y, int z, Random random)
	{
		this.func_149878_d(world, x, y, z, random);
	}
	
	/*
	 * growTree
	 */
	@Override
	public void func_149878_d(World world, int x, int y, int z, Random random)
	{
		if (world.isRemote)
		{
			return;
		}
		
		if (!TerrainGen.saplingGrowTree(world, random, x, y, z))
		{
			return;
		}
		
		int l = world.getBlockMetadata(x, y, z) & 3;
		WorldGenerator worldgen = this.getWorldGen(world, x, y, z, random);
		
		world.setBlock(x, y, z, Blocks.air, 0, 0);
		if (worldgen != null && !worldgen.generate(world, random, x, y, z))
		{
			world.setBlock(x, y, z, this, l, 4);
		}
	}
	
	public abstract WorldGenerator getWorldGen(World world, int x, int y, int z, Random random);
	
	public boolean canBlockStay(World world, int x, int y, int z, int metadata)
	{
		Block soil = world.getBlock(x, y - 1, z);
		
		if (soil == null)
		{
			return false;
		}
		
		boolean validLight = world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z);
		boolean validSoil = soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
		
		return validLight && this.isValidGround(metadata, soil, world.getBlockMetadata(x, y - 1, z));
	}
	
	public boolean isValidGround(World world, int x, int y, int z)
	{
		return this.isValidGround(world.getBlockMetadata(x, y, z), world.getBlock(x, y - 1, z), world.getBlockMetadata(x, y - 1, z));
	}
	
	public abstract boolean isValidGround(int metadata, Block block, int blockMetadata);
	
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
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		int len = this.iconNames.length;
		
		this.icons = new IIcon[len];
		for (int i = 0; i < len; ++i)
		{
			this.icons[i] = iconRegister.registerIcon(this.iconNames[i]);
		}
	}
}
