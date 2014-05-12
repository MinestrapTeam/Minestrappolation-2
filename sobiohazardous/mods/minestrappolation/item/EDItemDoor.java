package sobiohazardous.mods.minestrappolation.item;

import sobiohazardous.mods.minestrappolation.core.item.MCItem;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EDItemDoor extends MCItem
{
	public Block	doorBlock;
	
	public EDItemDoor(Block block)
	{
		super();
		this.doorBlock = block;
		this.maxStackSize = 1;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (side != 1)
		{
			return false;
		}
		++y;
		
		if (!player.canPlayerEdit(x, y, z, side, stack) || !player.canPlayerEdit(x, y + 1, z, side, stack))
		{
			return false;
		}
		if (!this.doorBlock.canPlaceBlockAt(world, x, y, z))
		{
			return false;
		}
		
		int i = MathHelper.floor_double((player.rotationYaw + 180.0F) * 4.0F / 360.0F - 0.5D) & 0x3;
		
		ItemDoor.placeDoorBlock(world, x, y, z, i, this.doorBlock);
		
		stack.stackSize -= 1;
		return true;
	}
}
