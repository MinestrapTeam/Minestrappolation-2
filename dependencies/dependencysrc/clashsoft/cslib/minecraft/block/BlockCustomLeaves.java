package clashsoft.cslib.minecraft.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCustomLeaves extends BlockLeaves implements ICustomBlock
{
	public String[]			names;
	public String[]			iconNames;
	
	public ItemStack[]		appleStacks		= new ItemStack[4];
	public ItemStack[]		saplingStacks	= new ItemStack[4];
	public boolean[]		isColored		= new boolean[4];
	
	public IIcon[]			icons, opaqueIcons;
	public int[]			adjacentTreeBlocks;
	
	public static boolean	graphicsLevel;
	
	public BlockCustomLeaves(String[] names, String[] iconNames)
	{
		super();
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeGrass);
		this.setLightOpacity(1);
		
		this.names = names;
		this.iconNames = iconNames;
	}
	
	public BlockCustomLeaves(String[] names, String domain)
	{
		this(names, CustomBlock.applyDomain(names, domain));
	}
	
	public BlockCustomLeaves setAppleStacks(ItemStack... appleStacks)
	{
		this.appleStacks = appleStacks;
		return this;
	}
	
	public BlockCustomLeaves setSaplingStacks(ItemStack... saplingStacks)
	{
		this.saplingStacks = saplingStacks;
		return this;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return CustomBlock.getUnlocalizedName(this, stack, this.names);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list)
	{
		CustomBlock.addInformation(this, stack, list);
	}
	
	@Override
	public String[] func_150125_e()
	{
		return this.names;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		if (this.isColored[world.getBlockMetadata(x, y, z) & 3])
		{
			return super.colorMultiplier(world, x, y, z);
		}
		return 0xFFFFFF;
	}
	
	@Override
	public int getRenderColor(int metadata)
	{
		if (this.isColored[metadata & 3])
		{
			return super.getRenderColor(metadata);
		}
		return 0xFFFFFF;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(20) == 0 ? 1 : 0;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		ItemStack stack = this.saplingStacks[metadata];
		return stack != null ? stack.getItem() : null;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int metadata, float dropChance, int fortune)
	{
		if (!world.isRemote)
		{
			int j1 = 20;
			
			if (fortune > 0)
			{
				j1 -= 2 << fortune;
				
				if (j1 < 10)
				{
					j1 = 10;
				}
			}
			
			if (world.rand.nextInt(j1) == 0)
			{
				ItemStack stack = this.saplingStacks[metadata & 3];
				if (stack != null)
				{
					this.dropBlockAsItem(world, x, y, z, stack);
				}
			}
			
			j1 = 200;
			
			if (fortune > 0)
			{
				j1 -= 10 << fortune;
				
				if (j1 < 40)
				{
					j1 = 40;
				}
			}
			
			if (world.rand.nextInt(j1) == 0)
			{
				ItemStack stack = this.appleStacks[metadata & 3];
				if (stack != null)
				{
					this.dropBlockAsItem(world, x, y, z, stack);
				}
			}
		}
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return !graphicsLevel;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		graphicsLevel = Minecraft.getMinecraft().gameSettings.fancyGraphics;
		return graphicsLevel ? this.icons[metadata & 3] : this.opaqueIcons[metadata & 3];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < this.names.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		int len = this.iconNames.length;
		
		this.icons = new IIcon[len];
		this.opaqueIcons = new IIcon[len];
		
		for (int i = 0; i < len; ++i)
		{
			this.icons[i] = iconRegister.registerIcon(this.iconNames[i]);
			this.opaqueIcons[i] = iconRegister.registerIcon(this.iconNames[i] + "_opaque");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		Block block = world.getBlock(x, y, z);
		return graphicsLevel || block != this;
	}
}
