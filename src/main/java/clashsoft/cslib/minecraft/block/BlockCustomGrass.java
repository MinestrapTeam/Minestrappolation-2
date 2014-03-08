package clashsoft.cslib.minecraft.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCustomGrass extends CustomBlock
{
	public String[]	topIconNames, sideIconNames, bottomIconNames;
	public Block[]	dirtBlocks;
	public int[]	dirtBlockMetadatas;
	
	public IIcon[]	topIcons, sideIcons, bottomIcons;
	
	public BlockCustomGrass(String name, String topIcon, String sideIcon, String bottomIcon)
	{
		this(new String[] { name }, new String[] { topIcon }, new String[] { sideIcon }, new String[] { bottomIcon });
	}
	
	public BlockCustomGrass(String[] names, String[] topIcons, String[] sideIcons, String[] bottomIcons)
	{
		super(Material.grass, names, sideIcons, null);
		this.setStepSound(Block.soundTypeGrass);
		this.setTickRandomly(true);
		this.setHardness(0.6F);
		
		this.names = names;
		this.topIconNames = topIcons;
		this.sideIconNames = sideIcons;
		this.bottomIconNames = bottomIcons;
		
		this.dirtBlocks = new Block[names.length];
		this.dirtBlockMetadatas = new int[names.length];
	}
	
	public BlockCustomGrass setDirtBlocks(Block[] blocks, int[] metadata)
	{
		this.dirtBlocks = blocks;
		this.dirtBlockMetadatas = metadata;
		return this;
	}
	
	public BlockCustomGrass setDirtBlock(int metadata, Block block, int dirtBlockMetadata)
	{
		this.dirtBlocks[metadata] = block;
		this.dirtBlockMetadatas[metadata] = dirtBlockMetadata;
		return this;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.topIcons = new IIcon[this.topIconNames.length];
		this.sideIcons = new IIcon[this.sideIconNames.length];
		this.bottomIcons = new IIcon[this.bottomIconNames.length];
		
		for (int i = 0; i < this.topIconNames.length; i++)
		{
			this.topIcons[i] = iconRegister.registerIcon(this.topIconNames[i]);
			this.sideIcons[i] = iconRegister.registerIcon(this.sideIconNames[i]);
			this.bottomIcons[i] = iconRegister.registerIcon(this.bottomIconNames[i]);
		}
		
		this.topIconNames = this.sideIconNames = this.bottomIconNames = null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		return side == 1 ? this.topIcons[metadata] : (side == 0 ? this.bottomIcons[metadata] : this.sideIcons[metadata]);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		Block dirt = this.dirtBlocks[metadata];
		int meta = this.dirtBlockMetadatas[metadata];
		return dirt.getItemDropped(meta, random, fortune);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return this.dirtBlockMetadatas[metadata];
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote)
		{
			int metadata = world.getBlockMetadata(x, y, z);
			Block dirt = this.dirtBlocks[metadata];
			int dirtMetadata = this.dirtBlockMetadatas[metadata];
			
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
			{
				world.setBlock(x, y, z, dirt, dirtMetadata, 3);
			}
			
			else if (world.getBlockLightValue(x, y + 1, z) >= 9)
			{
				for (int l = 0; l < 4; ++l)
				{
					int x1 = x + random.nextInt(3) - 1;
					int y1 = y + random.nextInt(5) - 3;
					int z1 = z + random.nextInt(3) - 1;
					
					Block block = world.getBlock(x1, y1, z1);
					int blockMetadata = world.getBlockMetadata(x1, y1, z1);
					int lightValue = world.getBlockLightValue(x1, y1 + 1, z1);
					int lightOpacity = world.getBlockLightOpacity(x1, y1 + 1, z1);
					
					if (block == dirt && blockMetadata == dirtMetadata && lightValue >= 4 && lightOpacity <= 2)
					{
						world.setBlock(x1, y1, z1, this, metadata, 3);
					}
				}
			}
		}
	}
}
