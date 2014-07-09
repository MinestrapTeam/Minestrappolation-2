package minestrapteam.minestrappolation.block;

import java.util.List;

import minestrapteam.mcore.util.MCAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockTiles extends Block
{
	private IIcon	flintEndstoneIcon;
	private IIcon	flintQuartzIcon;
	private IIcon	obsidianEndstoneIcon;
	private IIcon	obsidianQuartzIcon;
	
	public BlockTiles()
	{
		super(Material.rock);
	}
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		// TODO
		return 1F;
	}
	
	@Override
	public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		int meta = world.getBlockMetadata(x, y, z);
		// TODO
		return 1F;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.flintEndstoneIcon = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("checker_tiles_flint_endstone"));
		this.flintQuartzIcon = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("checker_tiles_flint_netherquartz"));
		this.obsidianEndstoneIcon = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("checker_tiles_obsidian_endstone"));
		this.obsidianQuartzIcon = iconRegister.registerIcon(MCAssetManager.getStonecutterTexture("checker_tiles_obsidian_netherquartz"));
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
		{
			return this.flintEndstoneIcon;
		}
		else if (metadata == 1)
		{
			return this.flintQuartzIcon;
		}
		else if (metadata == 2)
		{
			return this.obsidianEndstoneIcon;
		}
		else if (metadata == 3)
		{
			return this.obsidianQuartzIcon;
		}
		return super.getIcon(side, metadata);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 4; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
