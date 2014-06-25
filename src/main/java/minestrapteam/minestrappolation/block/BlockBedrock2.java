package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockBedrock2 extends Block
{
	public BlockBedrock2()
	{
		super(Material.rock);
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int metadata)
	{
		super.harvestBlock(world, player, x, y, z, metadata);
		
		ItemStack heldItem = player.getHeldItem();
		if (heldItem != null && heldItem.isItemStackDamageable())
		{
			int i = Minestrappolation.bedrockDamage - 1;
			if (i > heldItem.getItemDamage())
				i = heldItem.getItemDamage();
			heldItem.damageItem(i, player);
		}
	}
}
