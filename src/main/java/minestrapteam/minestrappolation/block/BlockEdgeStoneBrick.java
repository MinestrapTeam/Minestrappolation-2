package minestrapteam.minestrappolation.block;

import java.util.List;
import java.util.Random;

import minestrapteam.mcore.util.MCAssetManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockEdgeStoneBrick extends Block
{
	private IIcon[]	icons1;
	private IIcon[]	icons2;
	
	public BlockEdgeStoneBrick()
	{
		super(Material.rock);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.icons1 = new IIcon[4];
		this.icons2 = new IIcon[4];
		
		this.icons1[0] = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("edgestone"));
		this.icons1[1] = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("edgestone_left"));
		this.icons1[2] = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("edgestone_right"));
		this.icons1[3] = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("edgestone_half"));
		this.icons2[0] = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("dark_edgestone"));
		this.icons2[1] = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("dark_edgestone_left"));
		this.icons2[2] = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("dark_edgestone_right"));
		this.icons2[3] = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("dark_edgestone_half"));
	}
	
	@Override
	public int damageDropped(int meta)
    {
        return meta;
    }

	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
		{
			return this.icons1[0];
		}
		else if (metadata == 1)
		{
			return this.icons2[0];
		}
		return this.blockIcon;
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		boolean x1 = this.isBrick(world, x + 1, y, z);
		boolean z1 = this.isBrick(world, x, y, z + 1);
		boolean x2 = this.isBrick(world, x - 1, y, z);
		boolean z2 = this.isBrick(world, x, y, z - 1);
		byte b = 0;
		if (side == 2) // NORTH
		{
			if (x1)
			{
				b |= 1;
			}
			if (x2)
			{
				b |= 2;
			}
		}
		else if (side == 3) // SOUTH
		{
			if (x1)
			{
				b |= 1;
			}
			if (x2)
			{
				b |= 2;
			}
		}
		else if (side == 4)
		{
			if (z1)
			{
				b |= 1;
			}
			if (z2)
			{
				b |= 2;
			}
		}
		else if (side == 5)
		{
			if (z1)
			{
				b |= 1;
			}
			if (z2)
			{
				b |= 2;
			}
		}
		
		if (metadata == 0)
		{
			return this.icons1[b];
		}
		else if (metadata == 1)
		{
			return this.icons2[b];
		}
		return this.blockIcon;
	}
	
	public boolean isBrick(IBlockAccess world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		return block == Blocks.stonebrick;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
}
