package clashsoft.cslib.minecraft.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCustomSlab extends BlockStoneSlab implements ICustomBlock
{
	public Block	otherSlab;
	
	public String[]	names;
	public String[]	topIconNames;
	public String[]	sideIconNames;
	
	private IIcon[]	topIcons;
	private IIcon[]	sideIcons;
	
	public BlockCustomSlab(String[] names, String[] topIcons, String[] sideIcons, Block otherSlab, boolean doubleSlab)
	{
		super(doubleSlab);
		
		this.names = names;
		this.topIconNames = topIcons;
		this.topIcons = new IIcon[topIcons.length];
		this.sideIconNames = sideIcons;
		this.sideIcons = new IIcon[sideIcons.length];
		this.otherSlab = otherSlab;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		if (this.isOpaqueCube() && (metadata & 8) != 0)
		{
			side = 1;
		}
		
		return side == 1 || side == 0 ? this.topIcons[metadata & 7] : this.sideIcons[metadata & 7];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		for (int i = 0; i < this.topIconNames.length; i++)
		{
			this.topIcons[i] = iconRegister.registerIcon(this.topIconNames[i]);
			this.sideIcons[i] = iconRegister.registerIcon(this.sideIconNames[i]);
		}
		
		this.topIconNames = this.sideIconNames = null;
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return this.isOpaqueCube() ? this.otherSlab.getItem(world, x, y, z) : super.getItem(world, x, y, z);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return this.isOpaqueCube() ? this.otherSlab.getItemDropped(metadata, random, fortune) : super.getItemDropped(metadata, random, fortune);
	}
	
	@Override
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(this, 2, metadata & 7);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list)
	{
		for (int j = 0; j < this.names.length; ++j)
		{
			list.add(new ItemStack(this, 1, j));
		}
	}
	
	public String getFullSlabName(int metadata)
	{
		return this.func_150002_b(metadata);
	}
	
	/*
	 * getFullSlabName
	 */
	@Override
	public String func_150002_b(int metadata)
	{
		return this.names[metadata];
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
}
