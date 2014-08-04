package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class MBlockMachine extends BlockContainer
{
	protected IIcon	frontIcon;
	protected IIcon	topIcon;
	protected IIcon	bottomIcon;
	
	public MBlockMachine(Material material, String iconName)
	{
		super(material);
		this.setBlockTextureName(MAssetManager.getMachineTexture(iconName));
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
		if (side == 0)
		{
			return this.bottomIcon;
		}
		else if (side == 1)
		{
			return this.topIcon;
		}
		else if (metadata == side - 2)
		{
			return this.frontIcon;
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
}
