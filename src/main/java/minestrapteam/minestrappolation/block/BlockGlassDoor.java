package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockGlassDoor extends BlockDoor
{
	public BlockGlassDoor(Material material)
	{
		super(material);
		this.setBlockTextureName(MCAssetManager.getTexture("glass_door"));
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return MItems.glassDoor;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.glassDoor;
	}
}
