package minestrapteam.minestrappolation.block;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import clashsoft.cslib.collections.ArraySet;
import clashsoft.cslib.minecraft.block.CustomBlock;
import clashsoft.cslib.minecraft.block.ICustomBlock;
import clashsoft.cslib.minecraft.lang.I18n;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockEdgeBrick extends Block implements ICustomBlock
{
	public static String[]	TYPES			= new String[] { "stone", "deepstone", "redrock", "deep_redrock", "coldstone", "deep_coldstone", "icestone", "glacierrock", "oceanstone", "pressurized_oceanstone", "slate" };
	public static Block[]	BLOCKS			= new Block[] { Blocks.stonebrick, MBlocks.deepstone, MBlocks.redrock, MBlocks.deepRedrock, MBlocks.coldstone, MBlocks.deepColdstone, MBlocks.icestone, MBlocks.glacierrock, MBlocks.oceanstone, MBlocks.pressurizedOceanstone, MBlocks.graniteSlate };
	public static int[]		METADATA		= new int[] { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	
	public String[]			types;
	public Block[]			blocks;
	public int[]			metadata;
	
	private IIcon[]			icons;
	private IIcon[]			leftIcons;
	private IIcon[]			rightIcons;
	private IIcon[]			halfIcons;
	
	private Set<Block>		edgeBrickCache	= new ArraySet();
	
	public BlockEdgeBrick()
	{
		this(TYPES, BLOCKS, METADATA);
	}
	
	public BlockEdgeBrick(String[] types, Block[] blocks, int[] metadata)
	{
		super(Material.rock);
		this.types = types;
		this.blocks = blocks;
		this.metadata = metadata;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		int len = this.types.length;
		this.icons = new IIcon[len];
		this.leftIcons = new IIcon[len];
		this.rightIcons = new IIcon[len];
		this.halfIcons = new IIcon[len];
		
		for (int i = 0; i < len; i++)
		{
			String s = this.types[i];
			if (s != null)
			{
				this.icons[i] = iconRegister.registerIcon(MAssetManager.getEdgestoneTexture(s));
				this.leftIcons[i] = iconRegister.registerIcon(MAssetManager.getEdgestoneTexture(s + "_left"));
				this.rightIcons[i] = iconRegister.registerIcon(MAssetManager.getEdgestoneTexture(s + "_right"));
				this.halfIcons[i] = iconRegister.registerIcon(MAssetManager.getEdgestoneTexture(s + "_half"));
			}
		}
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0 || side == 1)
		{
			return this.icons[metadata];
		}
		else if (side == 2 || side == 3)
		{
			return this.leftIcons[metadata];
		}
		else if (side == 4 || side == 5)
		{
			return this.rightIcons[metadata];
		}
		return this.icons[metadata];
	}
	
	public IIcon getIcon(int metadata, byte type)
	{
		if (type == 0)
		{
			return this.icons[metadata];
		}
		else if (type == 1)
		{
			return this.leftIcons[metadata];
		}
		else if (type == 2)
		{
			return this.rightIcons[metadata];
		}
		else if (type == 3)
		{
			return this.halfIcons[metadata];
		}
		return this.blockIcon;
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		boolean xp = this.isBrick(metadata, world, x + 1, y, z);
		boolean zp = this.isBrick(metadata, world, x, y, z + 1);
		boolean xn = this.isBrick(metadata, world, x - 1, y, z);
		boolean zn = this.isBrick(metadata, world, x, y, z - 1);
		byte b = 0;
		if (side == 0 || side == 1)
		{
			if (xp)
			{
				b |= 1;
			}
			if (xn)
			{
				b |= 2;
			}
			if (zp || zn)
			{
				b = 3;
			}
		}
		else if (side == 2) // NORTH
		{
			if (xp)
			{
				b |= 2;
			}
			if (xn)
			{
				b |= 1;
			}
		}
		else if (side == 3) // SOUTH
		{
			if (xp)
			{
				b |= 1;
			}
			if (xn)
			{
				b |= 2;
			}
		}
		else if (side == 4) // WEST
		{
			if (zp)
			{
				b |= 1;
			}
			if (zn)
			{
				b |= 2;
			}
		}
		else if (side == 5) // EAST
		{
			if (zp)
			{
				b |= 2;
			}
			if (zn)
			{
				b |= 1;
			}
		}
		
		return this.getIcon(metadata, b);
	}
	
	public boolean isBrick(int metadata, IBlockAccess world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		if (this.isEdgeBrick(block))
		{
			return metadata == world.getBlockMetadata(x, y, z);
		}
		
		if (this.blocks[metadata] != block)
		{
			return false;
		}
		
		int m = this.metadata[metadata];
		if (m != -1 && m != world.getBlockMetadata(x, y, z))
		{
			return false;
		}
		return true;
	}
	
	public boolean isEdgeBrick(Block block)
	{
		if (block == this)
		{
			return true;
		}
		else if (block instanceof BlockEdgeBrick)
		{
			if (this.edgeBrickCache.contains(block))
			{
				return true;
			}
			
			BlockEdgeBrick edgeBrick = (BlockEdgeBrick) block;
			if (Arrays.equals(this.blocks, edgeBrick.blocks) && Arrays.equals(this.metadata, edgeBrick.metadata))
			{
				this.edgeBrickCache.add(edgeBrick);
				return true;
			}
		}
		return false;
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
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
		int metadata = stack.getItemDamage();
		ItemStack s = new ItemStack(this.blocks[metadata], 1, this.metadata[metadata]);
		list.add(I18n.getString("tile.edge_bricks.connects_to", s.getDisplayName()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return CustomBlock.getUnlocalizedName(this, stack, this.types);
	}
}
