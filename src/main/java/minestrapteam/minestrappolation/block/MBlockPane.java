package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class MBlockPane extends BlockPane
{
	public MBlockPane(Material material, String iconName, String sideIconName, boolean drops)
	{
		super(iconName, sideIconName, material, drops);
	}
	
	@Override
	public int getRenderBlockPass()
	{
		if (this == MBlocks.glowGlassPane)
		{
			return 1;
		}
		return 0;
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		if (this == MBlocks.cardboard)
		{
			return MItems.cardboardItem;
		}
		return super.getItem(world, x, y, z);
	}
	
	@Override
	public int getRenderType()
	{
		return this.blockMaterial == Material.cloth ? 41 : 18;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == MBlocks.cardboard)
		{
			return MItems.cardboardItem;
		}
		return super.getItemDropped(metadata, random, fortune);
	}
	
	@Override
	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata)
	{
		return false;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return this == MBlocks.cardboard ? 300 : 0;
	}
}
