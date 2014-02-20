package clashsoft.cslib.minecraft.block;

import java.util.Random;

import clashsoft.cslib.minecraft.CustomBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCustomGrass extends CustomBlock
{
	public String[]	topIconNames, sideIconNames, bottomIconNames;
	public int[]	dirtBlockIDs;
	public int[]	dirtBlockMetadatas;
	
	public Icon[]	topIcons, sideIcons, bottomIcons;
	
	public BlockCustomGrass(int blockID, String name, String topIcon, String sideIcon, String bottomIcon)
	{
		this(blockID, new String[] { name }, new String[] { topIcon }, new String[] { sideIcon }, new String[] { bottomIcon });
	}
	
	public BlockCustomGrass(int blockID, String[] names, String[] topIcons, String[] sideIcons, String[] bottomIcons)
	{
		super(blockID, Material.grass, names, sideIcons, null);
		this.names = names;
		this.topIconNames = topIcons;
		this.sideIconNames = sideIcons;
		this.bottomIconNames = bottomIcons;
		
		this.dirtBlockIDs = new int[names.length];
		this.dirtBlockMetadatas = new int[names.length];
		
		this.setStepSound(soundGrassFootstep);
		this.setTickRandomly(true);
	}
	
	public BlockCustomGrass setDirtBlocks(int[] ids, int[] metadata)
	{
		this.dirtBlockIDs = ids;
		this.dirtBlockMetadatas = metadata;
		return this;
	}
	
	public BlockCustomGrass setDirtBlock(int metadata, int dirtBlockID, int dirtBlockMetadata)
	{
		this.dirtBlockIDs[metadata] = dirtBlockID;
		this.dirtBlockMetadatas[metadata] = dirtBlockMetadata;
		return this;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.topIcons = new Icon[topIconNames.length];
		this.sideIcons = new Icon[sideIconNames.length];
		this.bottomIcons = new Icon[bottomIconNames.length];
		
		for (int i = 0; i < topIconNames.length; i++)
		{
			this.topIcons[i] = iconRegister.registerIcon(this.topIconNames[i]);
			this.sideIcons[i] = iconRegister.registerIcon(this.sideIconNames[i]);
			this.bottomIcons[i] = iconRegister.registerIcon(this.bottomIconNames[i]);
		}
	}
	
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int metadata)
	{
		return side == 1 ? this.topIcons[metadata] : (side == 0 ? this.bottomIcons[metadata] : this.sideIcons[metadata]);
	}
	
	@Override
	public int idDropped(int metadata, Random random, int fortune)
	{
		return this.dirtBlockIDs[metadata];
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
			int dirtID = this.dirtBlockIDs[metadata];
			int dirtMetadata = this.dirtBlockMetadatas[metadata];
			
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
				world.setBlock(x, y, z, dirtID, dirtMetadata, 3);
			
			else if (world.getBlockLightValue(x, y + 1, z) >= 9)
			{
				for (int l = 0; l < 4; ++l)
				{
					int x1 = x + random.nextInt(3) - 1;
					int y1 = y + random.nextInt(5) - 3;
					int z1 = z + random.nextInt(3) - 1;
					
					int blockID = world.getBlockId(x1, y1, z1);
					int blockMetadata = world.getBlockMetadata(x1, y1, z1);
					int lightValue = world.getBlockLightValue(x1, y1 + 1, z1);
					int lightOpacity = world.getBlockLightOpacity(x1, y1 + 1, z1);
					
					if (blockID == dirtID && blockMetadata == dirtMetadata && lightValue >= 4 && lightOpacity <= 2)
						world.setBlock(x1, y1, z1, this.blockID, metadata, 3);
				}
			}
		}
	}
}
