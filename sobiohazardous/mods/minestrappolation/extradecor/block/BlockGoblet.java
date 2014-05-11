package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDItems;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntityGoblet;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGoblet extends BlockContainer
{
	public BlockGoblet(Material material)
	{
		super(material);
		this.setBlockTextureName(MAssetManager.getEDTexture("cardboard"));
		this.setBlockBounds(0.3125F, 0F, 0.3125F, 0.6875F, 0.6875F, 0.6875F);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == 0)
		{
			ItemStack stack = player.getHeldItem();
			if (stack == null)
			{
				return false;
			}
			else if (stack.getItem() == Items.water_bucket)
			{
				player.inventory.getCurrentItem().stackSize--;
				player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
				world.setBlock(x, y, z, EDBlocks.Goblet, 1, 3);
			}
			else if (stack.getItem() == Items.milk_bucket)
			{
				player.inventory.getCurrentItem().stackSize--;
				player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
				world.setBlock(x, y, z, EDBlocks.Goblet, 2, 3);
			}
		}
		else
		{
			world.setBlock(x, y, z, EDBlocks.Goblet, 0, 2);
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
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 3490, 0, true));
			}
			else if (meta == 4)
			{
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3490, 0, true));
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
		return EDItems.goblet;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return EDItems.goblet;
	}
}
