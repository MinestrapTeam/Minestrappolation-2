package minestrapteam.minestrappolation.block;

import java.util.ArrayList;

import minestrapteam.mcore.util.MCAssetManager;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;

public class BlockRopeCoil extends BlockFalling implements IShearable
{
	private IIcon	top;
	
	public BlockRopeCoil()
	{
		super(Material.cloth);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getTexture("rope_side"));
		this.top = iconRegister.registerIcon(MCAssetManager.getTexture("rope_top"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0 || side == 1)
		{
			return this.top;
		}
		
		return this.blockIcon;
	}
	

	@Override
	public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
	{
		return true;
	}

	@Override
	public boolean isShearable(ItemStack stack, IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack stack, IBlockAccess world, int x, int y, int z, int metadata)
	{
		ArrayList<ItemStack> list = new ArrayList();
		list.add(new ItemStack(this.getItemDropped(metadata, null, 0), 1, 0));
		return list;
	}
}
