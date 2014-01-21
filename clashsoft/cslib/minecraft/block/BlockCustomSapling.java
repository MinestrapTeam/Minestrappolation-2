package clashsoft.cslib.minecraft.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public abstract class BlockCustomSapling extends BlockSapling implements ICustomBlock
{
	public String[]	names, iconNames;
	
	@SideOnly(Side.CLIENT)
	public Icon[]	icons;
	
	public BlockCustomSapling(int blockID, String[] names, String[] icons)
	{
		super(blockID);
		this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
		this.setHardness(0F);
		this.setStepSound(soundGrassFootstep);
		
		this.names = names;
		this.iconNames = icons;
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
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
	
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return this.icons[metadata & 3];
	}
	
	@Override
	public void markOrGrowMarked(World world, int x, int y, int z, Random random)
	{
		int l = world.getBlockMetadata(x, y, z);
		
		if ((l & 8) == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
		}
		else
		{
			this.growTree(world, x, y, z, random);
		}
	}
	
	/**
	 * Attempts to grow a sapling into a tree
	 */
	@Override
	public void growTree(World world, int x, int y, int z, Random random)
	{
		if (world.isRemote)
			return;
		
		if (!TerrainGen.saplingGrowTree(world, random, x, y, z))
			return;
		
		int l = world.getBlockMetadata(x, y, z) & 3;
		WorldGenerator worldgen = getWorldGen(world, x, y, z, random);
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		
		if (flag)
		{
			world.setBlock(x + i1, y, z + j1, 0, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1, 0, 0, 4);
			world.setBlock(x + i1, y, z + j1 + 1, 0, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1 + 1, 0, 0, 4);
		}
		else
		{
			world.setBlock(x, y, z, 0, 0, 4);
		}
		
		if (!worldgen.generate(world, random, x + i1, y, z + j1))
		{
			if (flag)
			{
				world.setBlock(x + i1, y, z + j1, this.blockID, l, 4);
				world.setBlock(x + i1 + 1, y, z + j1, this.blockID, l, 4);
				world.setBlock(x + i1, y, z + j1 + 1, this.blockID, l, 4);
				world.setBlock(x + i1 + 1, y, z + j1 + 1, this.blockID, l, 4);
			}
			else
			{
				world.setBlock(x, y, z, this.blockID, l, 4);
			}
		}
	}
	
	public abstract WorldGenerator getWorldGen(World world, int x, int y, int z, Random random);
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return super.canBlockStay(world, x, y, z) || this.isValidGround(world, x, y, z);
	}
	
	public boolean isValidGround(World world, int x, int y, int z)
	{
		return this.isValidGround(world.getBlockId(x, y, z), world.getBlockMetadata(x, y, z));
	}
	
	public abstract boolean isValidGround(int blockID, int blockMetadata);
	
	/**
	 * Determines if the same sapling is present at the given location.
	 */
	@Override
	public boolean isSameSapling(World world, int x, int y, int z, int metadata)
	{
		return world.getBlockId(x, y, z) == this.blockID && (world.getBlockMetadata(x, y, z) & 3) == metadata;
	}
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockID, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < names.length; i++)
			list.add(new ItemStack(this, 1, i));
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
	
	@Override
	public void addNames()
	{
		for (int i = 0; i < this.names.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(this, 1, i), this.names[i]);
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
	}
}
