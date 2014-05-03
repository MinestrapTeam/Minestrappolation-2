package sobiohazardous.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockManager;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.src.*;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockPinkChiseled extends Block
{
	private IIcon top;

	public BlockPinkChiseled()
	{
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(MAssetManager.getEOStonecutterTexture("DesertQuartz_Chiseled_Side_0"));
		this.top = iconRegister.registerIcon(MAssetManager.getEOStonecutterTexture("DesertQuartz_Chiseled_Top_0"));
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	public int damageDropped(int par1)
	{
		return 0;
	}

	// Args: side, metadata
	public IIcon getIcon(int i, int j)
	{
		if (i == 0)// bottom

			return blockIcon;
		if (i == 1)// top

			return top;

		if (i == 2) // side

			return blockIcon;
		if (i == 3)// side

			return blockIcon;
		if (i == 4) // side

			return blockIcon;
		if (i == 5) // side

			return blockIcon;

		if (j == 1)
		{
			return blockIcon;
		}
		return top;
	}

}
