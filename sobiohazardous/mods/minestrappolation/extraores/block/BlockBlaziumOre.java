package sobiohazardous.mods.minestrappolation.extraores.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockBlaziumOre extends Block
{
	public BlockBlaziumOre()
	{
		super(Material.rock);
		this.setCreativeTab(EOBlocks.tabOresBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("oreBlazium"));
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return MathHelper.clamp_int(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 2 + random.nextInt(1);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return Items.blaze_powder;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		// the 1 means it drops 1 xp, change it to 20, 100, as much as you want.
		this.dropXpOnBlockBreak(world, x, y, z, 1);
	}
}
