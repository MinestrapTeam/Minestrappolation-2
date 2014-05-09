package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockGunpowderBlock extends BlockFalling
{
	public BlockGunpowderBlock(Material material)
	{
		super(material);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (MUtil.isBlockTouchingAnySide(world, x, y, z, Blocks.fire))
		{
			world.createExplosion(null, x, y, z, 8F, true);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			ItemStack stack = player.getHeldItem();
			if (stack != null && (stack.getItem() == Items.flint_and_steel || stack.getItem() == Items.fire_charge))
			{
				world.createExplosion(player, x, y, z, 8F, true);
				return true;
			}
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}
}
