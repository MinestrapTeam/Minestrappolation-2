package minestrapteam.minestrappolation.block.machine;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.MBlockMachine;
import minestrapteam.minestrappolation.tileentity.TileEntityFreezer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockFreezer extends MBlockMachine
{
	public IIcon activeSideIcon;
	
	public BlockFreezer()
	{
		super(Material.iron, "freezer");
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(this.textureName + "_side");
		this.activeSideIcon = iconRegister.registerIcon(this.textureName + "_side_active");
		this.frontIcon = iconRegister.registerIcon(this.textureName + "_front");
		this.backIcon = iconRegister.registerIcon(this.textureName + "_back");
		this.topIcon = iconRegister.registerIcon(this.textureName + "_top");
		this.bottomIcon = iconRegister.registerIcon(this.textureName + "_bottom");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		IIcon icon = super.getIcon(side, metadata);
		if (icon == this.blockIcon && (metadata & 4) != 0)
		{
			return this.activeSideIcon;
		}
		return icon;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityFreezer();
	}
	
	@Override
	public void openGUI(EntityPlayer player, World world, int x, int y, int z)
	{
		if (world.getTileEntity(x, y, z) instanceof TileEntityFreezer)
		{
			player.openGui(Minestrappolation.instance, 5, world, x, y, z);
		}
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		TileEntityFreezer melter = (TileEntityFreezer) world.getTileEntity(x, y, z);
		
		if (melter != null)
		{
			for (int i = 0; i < melter.getSizeInventory(); ++i)
			{
				ItemStack stack = melter.getStackInSlot(i);
				
				if (stack == null)
				{
					continue;
				}
				
				float f = world.rand.nextFloat() * 0.8F + 0.1F;
				float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
				float f2 = world.rand.nextFloat() * 0.8F + 0.1F;
				while (stack.stackSize > 0)
				{
					int k1 = world.rand.nextInt(21) + 10;
					
					if (k1 > stack.stackSize)
					{
						k1 = stack.stackSize;
					}
					
					ItemStack stack1 = stack.splitStack(k1);
					EntityItem entity = new EntityItem(world, x + f, y + f1, z + f2, stack1);
					
					float f3 = 0.05F;
					entity.motionX = (float) world.rand.nextGaussian() * f3;
					entity.motionY = (float) world.rand.nextGaussian() * f3 + 0.2F;
					entity.motionZ = (float) world.rand.nextGaussian() * f3;
					world.spawnEntityInWorld(entity);
				}
			}
			
			world.func_147453_f(x, y, z, block);
		}
		
		super.breakBlock(world, x, y, z, block, metadata);
	}
}
