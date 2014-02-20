package clashsoft.cslib.minecraft.block;

import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCustomWorkbench extends Block implements ICustomBlock
{
	public String[]	names;
	public String[]	topIconNames;
	public String[]	sideIconNames;
	public String[]	side2IconNames;
	public String[]	bottomIconNames;
	
	public Icon[]	topIcons;
	public Icon[]	sideIcons;
	public Icon[]	side2Icons;
	public Icon[]	bottomIcons;
	
	public BlockCustomWorkbench(int blockID, String[] names, String[] topIcons, String[] sideIcons, String[] side2Icons, String[] bottomIcons)
	{
		super(blockID, Material.wood);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		
		this.names = names;
		this.topIconNames = topIcons;
		this.sideIconNames = sideIcons;
		this.side2IconNames = side2Icons;
		this.bottomIconNames = bottomIcons;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int side, int metadata)
	{
		if (side == 1)
			return topIcons[metadata];
		else if (side == 0)
			return bottomIcons[metadata];
		else if (side == 2 || side == 4)
			return sideIcons[metadata];
		else
			return side2Icons[metadata];
	}
	
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.topIcons = new Icon[topIcons.length];
		this.sideIcons = new Icon[sideIcons.length];
		this.side2Icons = new Icon[side2Icons.length];
		this.bottomIcons = new Icon[bottomIcons.length];
		
		for (int i = 0; i < topIconNames.length; i++)
		{
			topIcons[i] = iconRegister.registerIcon(topIconNames[i]);
			sideIcons[i] = iconRegister.registerIcon(sideIconNames[i]);
			side2Icons[i] = iconRegister.registerIcon(side2IconNames[i]);
			bottomIcons[i] = iconRegister.registerIcon(bottomIconNames[i]);
		}
		
		topIconNames = sideIconNames = side2IconNames = bottomIconNames = null;
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		else
		{
			player.displayGUIWorkbench(x, y, z);
			return true;
		}
	}
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(int blockID, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < names.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public void addNames()
	{
		for (int i = 0; i < names.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(this, 1, i), names[i]);
		}
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
	}
}
