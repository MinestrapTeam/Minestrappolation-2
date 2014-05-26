package com.minestrappolation_core.item.block;

import com.minestrappolation_core.block.MCBlockStone2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MCItemBlockStone2 extends MCItemBlockMulti
{
	private MCBlockStone2	theBlock;
	
	public MCItemBlockStone2(Block block)
	{
		super(block);
		
		if (block instanceof MCBlockStone2)
			this.theBlock = (MCBlockStone2) block;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		if (this.theBlock != null)
			return this.theBlock.getUnlocalizedName(stack.getItemDamage());
		return super.getUnlocalizedName(stack);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (stack.getItemDamage() < 3)
			return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
		
		if (stack.stackSize == 0)
			return false;
		if (!player.canPlayerEdit(x, y, z, side, stack))
			return false;
		
		Block block1 = world.getBlock(x, y, z);
		int i = world.getBlockMetadata(x, y, z);
		
		int type = (i / 3) * 3;
		int model = i % 3;
		
		// Handles double slabs
		if (block1 == this.field_150939_a && (side == 1 && model == 0) || (side == 0 && model == 1) && type == stack.getItemDamage())
		{
			int newMeta = type + 2;
			if (world.checkNoEntityCollision(this.field_150939_a.getCollisionBoundingBoxFromPool(world, x, y, z)))
			{
				if (world.setBlock(x, y, z, this.field_150939_a, newMeta, 3))
				{
					playPlaceSound(world, x, y, z);
					stack.stackSize -= 1;
				}
			}
			return true;
		}
		
		if (placeBlockAt(stack, player, world, x, y, z, side, hitY > 0.5F))
		{
			return true;
		}
		
		return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
	}
	
	private void playPlaceSound(World world, int x, int y, int z)
	{
		world.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, this.field_150939_a.stepSound.func_150496_b(), (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150939_a.stepSound.getPitch() * 0.8F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean func_150936_a(World world, int x, int y, int z, int side, EntityPlayer player, ItemStack stack)
	{
		int i = x;
		int j = y;
		int k = z;
		
		Block block = world.getBlock(x, y, z);
		int metadata = world.getBlockMetadata(x, y, z);
		
		if (metadata < 3)
			return super.func_150936_a(world, i, j, k, side, player, stack);
		
		int type = (metadata / 3) * 3;
		int model = metadata % 3;
		
		// Handles double slabs
		if ((side == 1 && model == 0) || (side == 0 && model == 1) && block == this.field_150939_a && type == stack.getItemDamage())
		{
			return true;
		}
		
		if (side == 0)
			--y;
		if (side == 1)
			++y;
		if (side == 2)
			--z;
		if (side == 3)
			++z;
		if (side == 4)
			--x;
		if (side == 5)
			++x;
		
		block = world.getBlock(x, y, z);
		metadata = world.getBlockMetadata(x, y, z);
		type = (metadata / 3) * 3;
		
		if ((block == this.field_150939_a) && (type == stack.getItemDamage()))
		{
			return true;
		}
		
		return super.func_150936_a(world, i, j, k, side, player, stack);
	}
	
	private boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, boolean upper)
	{
		if (side == 0)
			--y;
		if (side == 1)
			++y;
		if (side == 2)
			--z;
		if (side == 3)
			++z;
		if (side == 4)
			--x;
		if (side == 5)
			++x;
		
		Block block = world.getBlock(x, y, z);
		int i = world.getBlockMetadata(x, y, z);
		int type = (i / 3) * 3;
		
		if (block == this.field_150939_a && type == stack.getItemDamage())
		{
			int newMeta = i;
			if (upper)
				newMeta++;
			
			if (world.checkNoEntityCollision(this.field_150939_a.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlock(x, y, z, this.field_150939_a, newMeta, 3))
			{
				this.playPlaceSound(world, x, y, z);
				stack.stackSize -= 1;
			}
			return true;
		}
		
		return false;
	}
}
