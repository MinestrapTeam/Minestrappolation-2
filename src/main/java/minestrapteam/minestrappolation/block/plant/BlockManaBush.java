package minestrapteam.minestrappolation.block.plant;

import java.util.ArrayList;

import clashsoft.cslib.minecraft.block.BlockCustomBush;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockManaBush extends BlockCustomBush
{
	public BlockManaBush()
	{
		super(MAssetManager.getPlantTexture("mana_leaves"), MAssetManager.getPlantTexture("mana_stem"));
		this.setBushBounds(0.0625F, 0.0625F, 0.0625F, 0.9375F, 0.9375F, 0.9375F);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> list = super.getDrops(world, x, y, z, metadata, fortune);
		
		list.add(new ItemStack(MItems.manaLeaf));
		if (metadata >= this.fullGrownMetadata)
		{
			list.add(new ItemStack(MItems.manaLeaf));
			if (world.rand.nextBoolean())
			{
				list.add(new ItemStack(MItems.manaLeaf));
			}
		}
		
		return list;
	}
}
