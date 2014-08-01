package minestrapteam.minestrappolation.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRoads extends MBlock
{
	public static final String[]	names	= new String[] { "cobble", "gravel", "sand", "red_sand", "nether", "soul_steel" };
	
	private IIcon[]					topIcons;
	private IIcon[]					sideIcons;
	private IIcon[]					bottomIcons;
	
	public BlockRoads()
	{
		super(Material.rock);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.topIcons = new IIcon[names.length];
		this.sideIcons = new IIcon[names.length];
		this.bottomIcons = new IIcon[names.length];
		
		for (int i = 0; i < names.length; i++)
		{
			String name = names[i];
			this.topIcons[i] = iconRegister.registerIcon(name + "_road_top");
			this.sideIcons[i] = iconRegister.registerIcon(name + "_road_side");
			this.bottomIcons[i] = iconRegister.registerIcon(name + "_road_bottom");
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata >= names.length)
		{
			return this.blockIcon;
		}
		
		if (side == 0)
		{
			return this.bottomIcons[metadata];
		}
		else if (side == 1)
		{
			return this.topIcons[metadata];
		}
		else
		{
			return this.sideIcons[metadata];
		}
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 0)
		{
			entity.motionX *= 1.8D;
			entity.motionZ *= 1.8D;
		}
		else if (metadata == 1)
		{
			entity.motionX *= 1.5D;
			entity.motionZ *= 1.5D;
		}
		else if (metadata == 2)
		{
			entity.motionX *= 1.2D;
			entity.motionZ *= 1.2D;
		}
		else if (metadata == 3)
		{
			entity.motionX *= 1.2D;
			entity.motionZ *= 1.2D;
		}
		else if (metadata == 4)
		{
			entity.motionX *= 2.0D;
			entity.motionZ *= 2.0D;
		}
		else if (metadata == 5)
		{
			entity.motionX *= 5.0D;
			entity.motionZ *= 5.0D;
			entity.setFire(10);
		}
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < names.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
