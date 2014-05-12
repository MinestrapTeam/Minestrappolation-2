package sobiohazardous.mods.minestrappolation.core.block;

import java.util.List;

import sobiohazardous.mods.minestrappolation.core.Minestrappolation;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * The first stonecutter block type.<br>
 * This makes up the following blocks:
 * <ul>
 * <li>0: (Raw Block)
 * <li>1: Brick
 * <li>2: Patterned Brick
 * <li>3: Tiles
 * <li>4: Road
 * <li>5: Refined Block
 * <li>6: Refined Tiles
 * <li>7: Chiseled
 * <li>8: Chiseled Variant
 * <li>9: Cracked
 * <li>10: Mossy
 * </ul>
 * Everything else is added by {@link MBlockStone2}
 * 
 * @author Clashsoft
 */
public class MBlockStone extends Block
{
	public static final String[] types = new String[] { "raw", "brick", "pattern_brick", "tiles", "road", "refined", "refined_tiles", "chiseled", "chiseled", "cracked", "mossy" };
	
	public String name;
	
	public IIcon brickIcon;
	public IIcon patternBrickIcon;
	public IIcon tilesIcon;
	public IIcon roadTopIcon;
	public IIcon roadSideIcon;
	public IIcon roadBottomIcon;
	public IIcon refinedIcon;
	public IIcon refinedTilesIcon;
	public IIcon chiseledIcon;
	public IIcon chiseledIcon2;
	public IIcon crackedIcon;
	public IIcon mossyIcon;
	
	public MBlockStone(String name)
	{
		super(Material.rock);
		this.setCreativeTab(Minestrappolation.creativeTabStone);
		this.name = name;
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
		this.blockIcon = iconRegister.registerIcon(this.name);
		this.brickIcon = iconRegister.registerIcon(this.name + "_brick");
		this.patternBrickIcon = iconRegister.registerIcon(this.name + "_pattern_brick");
		this.tilesIcon = iconRegister.registerIcon(this.name + "_tiles");
		this.roadTopIcon = iconRegister.registerIcon(this.name + "_road_top");
		this.roadSideIcon = iconRegister.registerIcon(this.name + "_road_side");
		this.roadBottomIcon = iconRegister.registerIcon(this.name + "_road_bottom");
		this.refinedIcon = iconRegister.registerIcon(this.name + "_refined");
		this.refinedTilesIcon = iconRegister.registerIcon(this.name + "_refined_tiles");
		this.chiseledIcon = iconRegister.registerIcon(this.name + "_chiseled");
		this.chiseledIcon2 = iconRegister.registerIcon(this.name + "_chiseled_2");
		this.crackedIcon = iconRegister.registerIcon(this.name + "_cracked");
		this.mossyIcon = iconRegister.registerIcon(this.name + "_mossy");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
			return this.blockIcon;
		else if (metadata == 1)
			return this.brickIcon;
		else if (metadata == 2)
			return this.patternBrickIcon;
		else if (metadata == 3)
			return this.tilesIcon;
		else if (metadata == 4)
		{
			if (side == 0)
				return this.roadBottomIcon;
			else if (side == 1)
				return this.roadTopIcon;
			else
				return this.roadSideIcon;
		}
		else if (metadata == 5)
			return this.refinedIcon;
		else if (metadata == 6)
			return this.refinedTilesIcon;
		else if (metadata == 7)
			return this.chiseledIcon;
		else if (metadata == 8)
			return this.chiseledIcon2;
		else if (metadata == 9)
			return this.crackedIcon;
		else if (metadata == 10)
			return this.mossyIcon;
		
		return this.blockIcon;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < types.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
