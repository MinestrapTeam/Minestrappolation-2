package sobiohazardous.mods.minestrappolation.extraores.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMelter extends BlockContainer
{
	/**
	 * Is the random generator used by furnace to drop the inventory contents in
	 * random directions.
	 */
	private final Random	furnaceRand				= new Random();
	
	/** True if this is an active furnace, false if idle */
	private final boolean	isActive;
	
	/**
	 * This flag is used to prevent the furnace inventory to be dropped upon
	 * block removal, is used internally when the furnace block changes from
	 * idle to active and vice-versa.
	 */
	private static boolean	keepFurnaceInventory	= false;
	@SideOnly(Side.CLIENT)
	private IIcon			field_94458_cO;
	@SideOnly(Side.CLIENT)
	private IIcon			field_94459_cP;
	
	public BlockMelter(boolean par2)
	{
		super(Material.rock);
		this.isActive = par2;
	}
	
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(EOBlocks.melterIdle);
	}
	
	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}
	
	/**
	 * set a blocks direction
	 */
	private void setDefaultDirection(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
	{
		if (!p_149930_1_.isRemote)
		{
			Block var5 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
			Block var6 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
			Block var7 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
			Block var8 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
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
			
			p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, var9, 2);
		}
	}
	
	@Override
	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
	{
		int var7 = MathHelper.floor_double(p_149689_5_.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if (var7 == 0)
		{
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
		}
		
		if (var7 == 1)
		{
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
		}
		
		if (var7 == 2)
		{
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
		}
		
		if (var7 == 3)
		{
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
		}
		
		if (p_149689_6_.hasDisplayName())
		{
			((TileEntityFurnace) p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.getDisplayName());
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.field_94458_cO : par1 == 0 ? this.field_94458_cO : par1 != par2 ? this.blockIcon : this.field_94459_cP;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MAssetManager.getEOTexture("melterSide"));
		this.field_94459_cP = par1IconRegister.registerIcon(this.isActive ? MAssetManager.getEOTexture("melterFrontOn") : MAssetManager.getEOTexture("melterFrontOff"));
		this.field_94458_cO = par1IconRegister.registerIcon(MAssetManager.getEOTexture("melterTop"));
	}
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if (par1World.isRemote)
		{
			return true;
		}
		else
		{
			TileEntityMelter tileentityfurnace = (TileEntityMelter) par1World.getTileEntity(par2, par3, par4);
			
			if (tileentityfurnace != null)
			{
				par5EntityPlayer.openGui(ExtraOres.instance, 0, par1World, par2, par3, par4);
			}
			
			return true;
		}
	}
	
	/**
	 * Update which block ID the furnace is using depending on whether or not it
	 * is burning
	 */
	public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
		keepFurnaceInventory = true;
		
		if (par0)
		{
			System.out.println("is active");
			par1World.setBlock(par2, par3, par4, EOBlocks.melterBurning);
		}
		else
		{
			System.out.println("inactive");
			par1World.setBlock(par2, par3, par4, EOBlocks.melterIdle);
		}
		
		keepFurnaceInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
		
		if (tileentity != null)
		{
			tileentity.validate();
			par1World.setTileEntity(par2, par3, par4, tileentity);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (this.isActive)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			float f = par2 + 0.5F;
			float f1 = par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
			float f2 = par4 + 0.5F;
			float f3 = 0.52F;
			float f4 = par5Random.nextFloat() * 0.6F - 0.3F;
			
			if (l == 4)
			{
				par1World.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
			}
			else if (l == 5)
			{
				par1World.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
			}
			else if (l == 2)
			{
				par1World.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
			}
			else if (l == 3)
			{
				par1World.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World par1World, int arg)
	{
		return new TileEntityMelter();
	}
	
	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double(par5EntityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if (l == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}
		
		if (l == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}
		
		if (l == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}
		
		if (l == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}
		
		if (par6ItemStack.hasDisplayName())
		{
			// ((TileEntityMelter)par1World.getBlockTileEntity(par2, par3,
			// par4)).isUseableByPlayer(par6ItemStack.getDisplayName());
		}
	}
	
	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{
		if (!keepFurnaceInventory)
		{
			TileEntityMelter tileentityfurnace = (TileEntityMelter) par1World.getTileEntity(par2, par3, par4);
			
			if (tileentityfurnace != null)
			{
				for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1)
				{
					ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);
					
					if (itemstack != null)
					{
						float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						
						while (itemstack.stackSize > 0)
						{
							int k1 = this.furnaceRand.nextInt(21) + 10;
							
							if (k1 > itemstack.stackSize)
							{
								k1 = itemstack.stackSize;
							}
							
							itemstack.stackSize -= k1;
							EntityItem entityitem = new EntityItem(par1World, par2 + f, par3 + f1, par4 + f2, new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));
							
							if (itemstack.hasTagCompound())
							{
								entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}
							
							float f3 = 0.05F;
							entityitem.motionX = (float) this.furnaceRand.nextGaussian() * f3;
							entityitem.motionY = (float) this.furnaceRand.nextGaussian() * f3 + 0.2F;
							entityitem.motionZ = (float) this.furnaceRand.nextGaussian() * f3;
							par1World.spawnEntityInWorld(entityitem);
						}
					}
				}
				
				par1World.func_147453_f(par2, par3, par4, par5);
			}
		}
		
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(EnumChatFormatting.RED + "WIP");
	}
	
	public boolean isActive()
	{
		return this.isActive;
	}
}
