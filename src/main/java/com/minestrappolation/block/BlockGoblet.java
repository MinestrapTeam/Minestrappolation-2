package com.minestrappolation.block;

import java.util.List;
import java.util.Random;

import com.minestrappolation.lib.MItems;
import com.minestrappolation.tileentity.TileEntityGoblet;
import com.minestrappolation_core.util.MCAssetManager;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGoblet extends BlockContainer
{
	public BlockGoblet(Material material)
	{
		super(material);
		this.setBlockTextureName(MCAssetManager.getTexture("cardboard"));
		this.setBlockBounds(0.3125F, 0F, 0.3125F, 0.6875F, 0.6875F, 0.6875F);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		int meta = world.getBlockMetadata(x, y, z);
		TileEntityGoblet goblet = (TileEntityGoblet) world.getTileEntity(x, y, z);
		
		if (meta == 0)
		{
			ItemStack stack = player.getHeldItem();
			if (stack == null)
			{
				return false;
			}
			else if (stack.getItem() == Items.water_bucket)
			{
				stack.stackSize--;
				player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}
			else if (stack.getItem() == Items.milk_bucket)
			{
				stack.stackSize--;
				player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
			}
			else if (stack.getItem() instanceof ItemPotion)
			{
				stack.stackSize--;
				List<PotionEffect> effects = ((ItemPotion) stack.getItem()).getEffects(stack);
				if (!effects.isEmpty())
					goblet.setPotionEffect(effects.get(0));
				world.setBlockMetadataWithNotify(x, y, z, 3, 2);
			}
		}
		else
		{
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
			if (meta == 1)
			{
				player.extinguish();
			}
			else if (meta == 2)
			{
				player.curePotionEffects(new ItemStack(Items.milk_bucket));
			}
			else if (meta == 3)
			{
				PotionEffect effect = goblet.getPotionEffect();
				if (effect != null)
				{
					player.addPotionEffect(new PotionEffect(effect));
				}
			}
		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityGoblet();
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return MItems.goblet;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return MItems.goblet;
	}
}
