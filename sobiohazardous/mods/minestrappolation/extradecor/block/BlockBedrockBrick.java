package sobiohazardous.mods.minestrappolation.extradecor.block;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockBedrockBrick extends MBlock
{
	public BlockBedrockBrick()
	{
		super(Material.rock);
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int metadata)
	{
		player.getHeldItem().damageItem(2000, player);
		this.dropBlockAsItem(world, x, y, z, new ItemStack(this));
	}
}
