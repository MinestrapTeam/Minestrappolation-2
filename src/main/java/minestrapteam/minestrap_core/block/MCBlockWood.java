package minestrapteam.minestrap_core.block;

import java.util.List;

import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * Creates wood from wood textures folder.
 * <ul>
 * <li>0: Beveled Wood
 * <li>1: Boards
 * <li>2: Panels
 * <li>3: Mossy Planks
 * </ul>
 * @author SoBiohazardous
 */
public class MCBlockWood extends Block
{
	public String[]	types;
	
	public String	name;
	
	public IIcon bevel;
	public IIcon boards;
	public IIcon panel;
	public IIcon mossyPlanks;
	
	public MCBlockWood(String[] types, String name)
	{
		super(Material.wood);
		this.setCreativeTab(Minestrappolation.tabBuildingBlocks);	
		
		this.name = name;
		this.types = types;
		
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.disableStats();
	}
	
	public String getUnlocalizedName(int metadata)
	{
		if (metadata >= types.length)
			metadata = 0;
		return "tile." + this.name + "." + types[metadata];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		String textureName = this.getTextureName();
		
		this.blockIcon = iconRegister.registerIcon(textureName);       
		this.bevel = iconRegister.registerIcon(textureName + "_bevel");
		this.boards = iconRegister.registerIcon(textureName + "_boards");
		this.panel = iconRegister.registerIcon(textureName + "_panel");
		this.mossyPlanks = iconRegister.registerIcon(textureName + "_planks_mossy");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if(metadata == 0)
			return bevel;
		else if(metadata == 1)
			return boards;
		else if(metadata == 2)
			return panel;
		else if(metadata == 3)
			return mossyPlanks;
		
		return this.blockIcon;
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
}
