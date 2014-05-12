package sobiohazardous.mods.minestrappolation.lib;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class MBucketHandler
{
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		ItemStack result = this.fillCustomBucket(event.world, event.target);
		if (result != null)
		{
			event.result = result;
			event.setResult(Result.ALLOW);
		}
	}
	
	public ItemStack fillCustomBucket(World world, MovingObjectPosition pos)
	{
		// Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);
		// if (block == EOBlocks.magma && world.getBlockMetadata(pos.blockX,
		// pos.blockY, pos.blockZ) == 0)
		// {
		// world.setBlock(pos.blockX, pos.blockY, pos.blockZ, 0);
		// return new ItemStack(EOItems.bucketMagma);
		// }
		return null;
	}
}
