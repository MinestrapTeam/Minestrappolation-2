package minestrapteam.minestrappolation.block;

import java.util.List;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class MBlockMachine extends BlockContainer
{
	protected IIcon	frontIcon;
	protected IIcon	backIcon;
	protected IIcon	topIcon;
	protected IIcon	bottomIcon;
	
	public MBlockMachine(Material material, String iconName)
	{
		super(material);
		this.setBlockTextureName(MAssetManager.getMachineTexture(iconName));
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return 1;
	}
	
	public abstract void openGUI(EntityPlayer player, World world, int x, int y, int z);
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(this.textureName + "_side");
		this.frontIcon = iconRegister.registerIcon(this.textureName + "_front");
		this.topIcon = iconRegister.registerIcon(this.textureName + "_top");
		this.bottomIcon = iconRegister.registerIcon(this.textureName + "_bottom");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		metadata &= 3;
		if (side == 0)
		{
			return this.bottomIcon;
		}
		else if (side == 1)
		{
			return this.topIcon;
		}
		else if (side == metadata + 2)
		{
			return this.frontIcon;
		}
		else if (side == metadata + 3 && this.backIcon != null)
		{
			return this.backIcon;
		}
		return this.blockIcon;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		this.openGUI(player, world, x, y, z);
		
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
	{
		int l = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		this.setFacing(world, x, y, z, l);
		
		if (stack.hasDisplayName())
		{
			TileEntity te = world.getTileEntity(x, y, z);
			if (te instanceof TileEntityInventory)
			{
				((TileEntityInventory) te).setInventoryName(stack.getDisplayName());
			}
		}
	}
	
	public void setFacing(World world, int x, int y, int z, int l)
	{
		switch (l)
		{
		case 0:
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
			break;
		case 1:
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
			break;
		case 2:
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
			break;
		case 3:
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
			break;
		}
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
				var9 = 1;
			}
			
			if (var6.func_149730_j() && !var5.func_149730_j())
			{
				var9 = 0;
			}
			
			if (var7.func_149730_j() && !var8.func_149730_j())
			{
				var9 = 3;
			}
			
			if (var8.func_149730_j() && !var7.func_149730_j())
			{
				var9 = 2;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, var9, 2);
		}
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 1));
	}
}
