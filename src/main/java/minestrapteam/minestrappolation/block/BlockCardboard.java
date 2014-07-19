package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.mcore.util.MCAssetManager;
import minestrapteam.mcore.util.MCUtil;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCardboard extends Block
{
	private IIcon	topIcon;
	private IIcon	wetTopIcon;
	private IIcon	wetSideIcon;
	
	public BlockCardboard(Material material)
	{
		super(material);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return metadata == 1 ? MItems.cardboardItem : super.getItemDropped(metadata, random, fortune);
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		return meta == 1 ? 1 + random.nextInt(5 + fortune) : 1;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 255;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		if (!world.isRemote && world.getBlockMetadata(x, y, z) == 1)
		{
			world.func_147480_a(x, y, z, true);
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
		{
			if (side == 0)
			{
				return this.topIcon;
			}
		}
		else if (metadata == 1)
		{
			if (side == 1)
			{
				return this.wetTopIcon;
			}
			else if (side != 0)
			{
				return this.wetSideIcon;
			}
		}
		
		return this.blockIcon;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("cardboard"));
		this.topIcon = iconRegister.registerIcon(MCAssetManager.getTexture("cardboard_top"));
		this.wetSideIcon = iconRegister.registerIcon(MCAssetManager.getTexture("cardboard_wet_side"));
		this.wetTopIcon = iconRegister.registerIcon(MCAssetManager.getTexture("cardboard_wet_top"));
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
	{
		this.checkDryness(world, x, y, z);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		this.checkDryness(world, x, y, z);
	}
	
	public void checkDryness(World world, int x, int y, int z)
	{
		if (MCUtil.isWaterTouchingAnySide(world, x, y, z))
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
	}
}
