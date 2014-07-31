package minestrapteam.minestrappolation.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import minestrapteam.minestrappolation.util.MAssetManager;
import minestrapteam.minestrappolation.world.WorldGenBaseTree;
import minestrapteam.minestrappolation.world.WorldGenRedWoodTree;

public class BlockRedwoodSapling extends MBlockSapling
{
	public void registerBlockIcons(IIconRegister r)
	{
		this.blockIcon = r.registerIcon(MAssetManager.getPlantTexture("redwood_sapling"));
	}
	
	@Override
	public WorldGenBaseTree getTreeToGrow()
	{
		return new WorldGenRedWoodTree();
	}

}
