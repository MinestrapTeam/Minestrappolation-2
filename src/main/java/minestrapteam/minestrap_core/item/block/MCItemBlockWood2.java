package minestrapteam.minestrap_core.item.block;

import minestrapteam.minestrap_core.block.MCBlockWood2;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MCItemBlockWood2 extends MCItemBlockMulti
{
	private MCBlockWood2	theBlock;
	
	public MCItemBlockWood2(Block block)
	{
		super(block);
		
		if (block instanceof MCBlockWood2)
		{
			this.theBlock = (MCBlockWood2) block;
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
		return this.onItemUse(stack, player, world, x, y, z, side, 0F, 0F, 0F);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		
		if (stack.getItemDamage() < 3)
		{
			return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
		}
		
		if (!player.canPlayerEdit(x, y, z, side, stack))
		{
			return false;
		}
		
		Block block1 = world.getBlock(x, y, z);
		int i = world.getBlockMetadata(x, y, z);
		
		int type = i / 3 * 3;
		int model = i % 3;
		
		// Handles double slabs
		if (block1 == this.field_150939_a && type == stack.getItemDamage() && ((side == 1 && model == 0) || (side == 0 && model == 1)))
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
		int type = i / 3 * 3;
		
		if (block == this.field_150939_a && type == stack.getItemDamage())
		{
			if (world.checkNoEntityCollision(this.field_150939_a.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlock(x, y, z, this.field_150939_a, i, 3))
			{
				this.playPlaceSound(world, x, y, z);
				stack.stackSize--;
			}
			return true;
		}
		
		return false;
	}
}
