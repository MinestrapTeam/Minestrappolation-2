package clashsoft.cslib.minecraft.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCustomPillar extends BlockRotatedPillar implements ICustomBlock
{
public String[]	names, topIconNames, sideIconNames;
	
	@SideOnly(Side.CLIENT)
	public IIcon[]	sideIcons;
	@SideOnly(Side.CLIENT)
	public IIcon[]	topIcons;
	
	public BlockCustomPillar(Material material, String name, String topIcon, String sideIcon)
	{
		this(material, new String[] { name }, new String[] { topIcon }, new String[] { sideIcon });
	}
	
	public BlockCustomPillar(Material material, String[] names, String[] topIcons, String[] sideIcons)
	{
		super(material);
		this.names = names;
		this.topIconNames = topIcons;
		this.sideIconNames = sideIcons;
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
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z) & 3;
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
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < this.names.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
}
