package minestrapteam.minestrappolation.item.block;

import minestrapteam.minestrappolation.block.MBlockCustom2;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MCItemBlockCustom2 extends MCItemBlockMulti
{
	public MBlockCustom2	theBlock;
	
	public MCItemBlockCustom2(Block block)
	{
		super(block);
		
		if (block instanceof MBlockCustom2)
		{
			this.theBlock = (MBlockCustom2) block;
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		if (this.theBlock != null)
		{
			return this.theBlock.getUnlocalizedName(stack.getItemDamage());
		}
		return super.getUnlocalizedName(stack);
	}
	
	@Override
	public boolean func_150936_a(World world, int x, int y, int z, int side, EntityPlayer player, ItemStack stack)
	{
		Block block1 = world.getBlock(x, y, z);
		int i = world.getBlockMetadata(x, y, z);
		String s = this.theBlock.getType(stack.getItemDamage());
		
		int model = i % 3;
		int type = i - model;
		
		if (!"pillar".equals(s))
		{
			// Handles double slabs
			if (block1 == this.theBlock && type == stack.getItemDamage() && (side == 1 && model == 0 || side == 0 && model == 1))
			{
				return true;
			}
			else
			{
				int x1 = x;
				int y1 = y;
				int z1 = z;
				
				if (side == 0)
				{
					--y;
				}
				
				if (side == 1)
				{
					++y;
				}
				
				if (side == 2)
				{
					--z;
				}
				
				if (side == 3)
				{
					++z;
				}
				
				if (side == 4)
				{
					--x;
				}
				
				if (side == 5)
				{
					++x;
				}
				
				block1 = world.getBlock(x, y, z);
				i = world.getBlockMetadata(x, y, z);
				model = i % 3;
				type = i - model;
				
				if (block1 == this.theBlock && type == stack.getItemDamage())
				{
					return true;
				}
			}
		}
		return super.func_150936_a(world, x, y, z, side, player, stack);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		
		if (!player.canPlayerEdit(x, y, z, side, stack))
		{
			return false;
		}
		
		Block block1 = world.getBlock(x, y, z);
		int i = world.getBlockMetadata(x, y, z);
		String s = this.theBlock.getType(stack.getItemDamage());
		
		int model = i % 3;
		int type = i - model;
		
		if (!"pillar".equals(s))
		{
			// Handles double slabs
			if (block1 == this.field_150939_a && type == stack.getItemDamage() && (side == 1 && model == 0 || side == 0 && model == 1))
			{
				if (world.checkNoEntityCollision(this.field_150939_a.getCollisionBoundingBoxFromPool(world, x, y, z)))
				{
					if (world.setBlock(x, y, z, this.field_150939_a, type + 2, 3))
					{
						this.playPlaceSound(world, x, y, z);
						stack.stackSize--;
					}
				}
				return true;
			}
			
			if (this.placeBlockAt(stack, player, world, x, y, z, side))
			{
				return true;
			}
		}
		
		return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
	}
	
	private void playPlaceSound(World world, int x, int y, int z)
	{
		world.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, this.field_150939_a.stepSound.func_150496_b(), (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150939_a.stepSound.getPitch() * 0.8F);
	}
	
	private boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side)
	{
		if (side == 0)
		{
			--y;
		}
		if (side == 1)
		{
			++y;
		}
		if (side == 2)
		{
			--z;
		}
		if (side == 3)
		{
			++z;
		}
		if (side == 4)
		{
			--x;
		}
		if (side == 5)
		{
			++x;
		}
		
		Block block = world.getBlock(x, y, z);
		int i = world.getBlockMetadata(x, y, z);
		int type = i - i % 3;
		
		if (block == this.field_150939_a && type == stack.getItemDamage())
		{
			if (world.checkNoEntityCollision(this.field_150939_a.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlock(x, y, z, this.field_150939_a, type + 2, 3))
			{
				this.playPlaceSound(world, x, y, z);
				stack.stackSize--;
			}
			return true;
		}
		
		return false;
	}
}
