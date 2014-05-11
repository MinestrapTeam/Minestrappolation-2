package clashsoft.cslib.minecraft.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCustomWorkbench extends Block implements ICustomBlock
{
	public String[]	names;
	public String[]	topIconNames;
	public String[]	sideIconNames;
	public String[]	side2IconNames;
	public String[]	bottomIconNames;
	
	public IIcon[]	topIcons;
	public IIcon[]	sideIcons;
	public IIcon[]	side2Icons;
	public IIcon[]	bottomIcons;
	
	public BlockCustomWorkbench(int blockID, String[] names, String[] topIcons, String[] sideIcons, String[] side2Icons, String[] bottomIcons)
	{
		super(Material.wood);
		this.setStepSound(soundTypeWood);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		
		this.names = names;
		this.topIconNames = topIcons;
		this.sideIconNames = sideIcons;
		this.side2IconNames = side2Icons;
		this.bottomIconNames = bottomIcons;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 1)
		{
			return this.topIcons[metadata];
		}
		else if (side == 0)
		{
			return this.bottomIcons[metadata];
		}
		else if (side == 2 || side == 4)
		{
			return this.sideIcons[metadata];
		}
		else
		{
			return this.side2Icons[metadata];
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.topIcons = new IIcon[this.topIcons.length];
		this.sideIcons = new IIcon[this.sideIcons.length];
		this.side2Icons = new IIcon[this.side2Icons.length];
		this.bottomIcons = new IIcon[this.bottomIcons.length];
		
		for (int i = 0; i < this.topIconNames.length; i++)
		{
			this.topIcons[i] = iconRegister.registerIcon(this.topIconNames[i]);
			this.sideIcons[i] = iconRegister.registerIcon(this.sideIconNames[i]);
			this.side2Icons[i] = iconRegister.registerIcon(this.side2IconNames[i]);
			this.bottomIcons[i] = iconRegister.registerIcon(this.bottomIconNames[i]);
		}
		
		this.topIconNames = this.sideIconNames = this.side2IconNames = this.bottomIconNames = null;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			player.displayGUIWorkbench(x, y, z);
			return true;
		}
		return false;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.names.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
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
