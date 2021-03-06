package minestrapteam.minestrappolation.block.decor;

import java.util.List;

import minestrapteam.minestrappolation.tileentity.TileEntityGoblet;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockGoblet extends BlockContainer
{
	public BlockGoblet(Material material)
	{
		super(material);
		this.setBlockTextureName(MAssetManager.getTexture("cardboard"));
		this.setBlockBounds(0.3125F, 0F, 0.3125F, 0.6875F, 0.6875F, 0.6875F);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return world.isSideSolid(x, y - 1, z, ForgeDirection.UP);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
	{
		if (!this.canBlockStay(world, x, y, z))
		{
			world.func_147480_a(x, y, z, true);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return false;
		}
		
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
				world.setBlockMetadataWithNotify(x, y, z, 1, 2);
				if (!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
					player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
				}
			}
			else if (stack.getItem() == Items.milk_bucket)
			{
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
				if (!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
					player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
				}
			}
			else if (stack.getItem() instanceof ItemPotion)
			{
				List<PotionEffect> effects = ((ItemPotion) stack.getItem()).getEffects(stack);
				if (!effects.isEmpty())
				{
					goblet.setPotionEffect(effects.get(0));
					world.setBlockMetadataWithNotify(x, y, z, 3, 2);
				}
				else
				{
					world.setBlockMetadataWithNotify(x, y, z, 1, 2);
				}
				
				if (!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
					player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
				}
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
					goblet.setPotionEffect(null);
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
}
