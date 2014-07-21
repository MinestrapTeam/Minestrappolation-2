package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.mcore.util.MCAssetManager;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMelter extends BlockContainer
{
	private final boolean	isActive;
	
	private static boolean	keepInventory	= false;
	
	private IIcon			topIcon;
	private IIcon			frontIcon;
	private IIcon			bottomIcon;
	
	public BlockMelter(boolean active)
	{
		super(Material.rock);
		this.isActive = active;
		
		if (active)
		{
			this.setLightLevel(1F);
		}
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return Item.getItemFromBlock(MBlocks.melterIdle);
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return Item.getItemFromBlock(MBlocks.melterIdle);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if (!world.isRemote)
		{
			Block var5 = world.getBlock(x, y, z - 1);
			Block var6 = world.getBlock(x, y, z + 1);
			Block var7 = world.getBlock(x - 1, y, z);
			Block var8 = world.getBlock(x + 1, y, z);
			byte var9 = 3;
			
			if (var5.func_149730_j() && !var6.func_149730_j())
			{
				var9 = 3;
			}
			
			if (var6.func_149730_j() && !var5.func_149730_j())
			{
				var9 = 2;
			}
			
			if (var7.func_149730_j() && !var8.func_149730_j())
			{
				var9 = 5;
			}
			
			if (var8.func_149730_j() && !var7.func_149730_j())
			{
				var9 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, var9, 2);
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		int var7 = MathHelper.floor_double(living.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if (var7 == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if (var7 == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		
		if (var7 == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		
		if (var7 == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		if (stack.hasDisplayName())
		{
			((TileEntityFurnace) world.getTileEntity(x, y, z)).func_145951_a(stack.getDisplayName());
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 0)
		{
			return this.bottomIcon;
		}
		else if (side == 1)
		{
			return this.topIcon;
		}
		else if (side != metadata)
		{
			return this.blockIcon;
		}
		return this.frontIcon;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MCAssetManager.getMachineTexture("melter_side"));
		this.frontIcon = iconRegister.registerIcon(this.isActive ? MCAssetManager.getMachineTexture("melter_front_on") : MCAssetManager.getMachineTexture("melter_front_off"));
		this.topIcon = iconRegister.registerIcon(MCAssetManager.getMachineTexture("melter_top"));
		this.bottomIcon = iconRegister.registerIcon(MCAssetManager.getMachineTexture("melter_bottom"));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			TileEntity te = world.getTileEntity(x, y, z);
			
			if (te instanceof TileEntityMelter)
			{
				player.openGui(Minestrappolation.instance, 2, world, x, y, z);
			}
		}
		return true;
	}
	
	public static void updateBlockState(boolean active, World world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		keepInventory = true;
		
		if (active)
		{
			world.setBlock(x, y, z, MBlocks.melterBurning);
		}
		else
		{
			world.setBlock(x, y, z, MBlocks.melterIdle);
		}
		
		keepInventory = false;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
		
		if (tileentity != null)
		{
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (this.isActive)
		{
			int l = world.getBlockMetadata(x, y, z);
			float f = x + 0.5F;
			float f1 = y + random.nextFloat() * 0.375F;
			float f2 = z + 0.5F;
			float f3 = 0.52F;
			float f4 = random.nextFloat() * 0.6F - 0.3F;
			
			if (l == 4)
			{
				world.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
			}
			else if (l == 5)
			{
				world.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
			}
			else if (l == 2)
			{
				world.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
			}
			else if (l == 3)
			{
				world.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityMelter();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		if (!keepInventory)
		{
			TileEntityMelter tileentityfurnace = (TileEntityMelter) world.getTileEntity(x, y, z);
			
			if (tileentityfurnace != null)
			{
				for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1)
				{
					ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);
					
					if (itemstack != null)
					{
						float f = world.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = world.rand.nextFloat() * 0.8F + 0.1F;
						
						while (itemstack.stackSize > 0)
						{
							int k1 = world.rand.nextInt(21) + 10;
							
							if (k1 > itemstack.stackSize)
							{
								k1 = itemstack.stackSize;
							}
							
							itemstack.stackSize -= k1;
							EntityItem entityitem = new EntityItem(world, x + f, y + f1, z + f2, new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));
							
							if (itemstack.hasTagCompound())
							{
								entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}
							
							float f3 = 0.05F;
							entityitem.motionX = (float) world.rand.nextGaussian() * f3;
							entityitem.motionY = (float) world.rand.nextGaussian() * f3 + 0.2F;
							entityitem.motionZ = (float) world.rand.nextGaussian() * f3;
							world.spawnEntityInWorld(entityitem);
						}
					}
				}
				
				world.func_147453_f(x, y, z, block);
			}
		}
		
		super.breakBlock(world, x, y, z, block, metadata);
	}
	
	public boolean isActive()
	{
		return this.isActive;
	}
}
