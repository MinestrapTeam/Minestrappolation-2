package clashsoft.cslib.minecraft.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCustomLog extends BlockRotatedPillar implements ICustomBlock
{
	public String[]	names, topIconNames, sideIconNames;
	
	@SideOnly(Side.CLIENT)
	public IIcon[]	sideIcons;
	@SideOnly(Side.CLIENT)
	public IIcon[]	topIcons;
	
	public BlockCustomLog(String name, String topIcon, String sideIcon)
	{
		this(new String[] { name }, new String[] { topIcon }, new String[] { sideIcon });
	}
	
	public BlockCustomLog(String[] names, String[] topIcons, String[] sideIcons)
	{
		super(Material.wood);
		this.setStepSound(Block.soundTypeWood);
		this.setHardness(2F);
		
		this.names = names;
		this.topIconNames = topIcons;
		this.sideIconNames = sideIcons;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldBlockMetadata)
	{
		byte b0 = 4;
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
	@SideOnly(Side.CLIENT)
	protected IIcon getSideIcon(int metadata)
	{
		return this.sideIcons[metadata];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int metadata)
	{
		return this.topIcons[metadata];
	}
	
	public static int limitToValidMetadata(int metadata)
	{
		return metadata & 3;
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
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		int len1 = this.topIconNames.length;
		int len2 = this.sideIconNames.length;
		
		this.topIcons = new IIcon[len1];
		this.sideIcons = new IIcon[len2];
		
		for (int i = 0; i < len1; ++i)
		{
			this.topIcons[i] = iconRegister.registerIcon(this.topIconNames[i]);
		}
		for (int i = 0; i < len2; ++i)
		{
			this.sideIcons[i] = iconRegister.registerIcon(this.sideIconNames[i]);
		}
	}
	
	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z) & 3;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int metadata = stack.getItemDamage();
		if (metadata < this.names.length)
		{
			return this.getUnlocalizedName() + "." + this.names[metadata];
		}
		return this.getUnlocalizedName();
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
	}
}
