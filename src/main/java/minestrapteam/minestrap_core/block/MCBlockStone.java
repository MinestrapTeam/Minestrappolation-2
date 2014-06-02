package minestrapteam.minestrap_core.block;

import java.util.List;

import minestrapteam.minestrappolation.Minestrappolation;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * The first stonecutter block type.<br>
 * This makes up the following blocks:
 * <ul>
 * <li>0: (Raw Block)
 * <li>1: Brick
 * <li>2: Patterned Brick
 * <li>3: Tiles
 * <li>4: Road
 * <li>5: Refined Block
 * <li>6: Chiseled
 * <li>7: Cracked
 * <li>8: Mossy
 * <li>14: Glowstone Lamp
 * <li>15: Sunstone Lamp
 * </ul>
 * Everything else is added by {@link MCBlockStone2}
 * 
 * @author Clashsoft
 */
public class MCBlockStone extends Block
{
	public String[]	types;
	
	public String	name;
	public float	baseHardness;
	
	public IIcon	brickIcon;
	public IIcon	patternBrickIcon;
	public IIcon	tilesIcon;
	public IIcon	roadSideIcon;
	public IIcon	roadBottomIcon;
	public IIcon	refinedIcon;
	public IIcon	chiseledIcon;
	public IIcon	chiseledSideIcon;
	public IIcon	crackedIcon;
	public IIcon	mossyIcon;
	
	public IIcon	glowstoneLampIcon;
	public IIcon	sunstoneLampIcon;
	
	public boolean	chiseledSided;
	public boolean	clayChiseled;
	
	public MCBlockStone(String[] types, String name, float baseHardness)
	{
		super(Material.rock);
		this.setCreativeTab(Minestrappolation.tabStoneDecor);
		this.name = name;
		this.baseHardness = baseHardness;
		this.types = types;
	}
	
	/**
	 * Sets the side texture of the chiseled block to a specific one
	 * (type_chiseled_side)
	 * 
	 * @return this instance
	 */
	public MCBlockStone setChiseledSided()
	{
		this.chiseledSided = true;
		return this;
	}
	
	/**
	 * Sets refined texture for top of chiseled blocks. Used for chiseled clay
	 * blocks.
	 * 
	 * @return this instance
	 */
	public MCBlockStone setClayChiseled()
	{
		this.clayChiseled = true;
		this.chiseledSided = true;
		return this;
	}
	
	public String getUnlocalizedName(int metadata)
	{
		if (metadata >= types.length)
			metadata = 0;
		return "tile." + this.name + "." + types[metadata];
	}
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		return this.getHardness(world.getBlockMetadata(x, y, z));
	}
	
	/**
	 * Returns the hardness for the given {@code metadata}.
	 * 
	 * @param metadata
	 *            the metadata value
	 * @return the hardness
	 */
	public float getHardness(int metadata)
	{
		float f = this.baseHardness;
		if (metadata == 0)
			return f;
		else if (metadata == 3)
			return f + 0.1F;
		else if (metadata == 5)
			return f + 0.2F;
		else if (metadata == 6)
			return f + 0.3F;
		else if (metadata == 14)
			return f + 0.5F;
		else if (metadata == 15)
			return f + 0.6F;
		return f;
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 14)
			return Blocks.glowstone.getLightValue();
		else if (metadata == 15)
			return 15;
		return super.getLightValue(world, x, y, z);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		String textureName = this.getTextureName();
		this.blockIcon = iconRegister.registerIcon(textureName);
		this.brickIcon = iconRegister.registerIcon(textureName + "_bricks");
		this.patternBrickIcon = iconRegister.registerIcon(textureName + "_pattern_bricks");
		this.tilesIcon = iconRegister.registerIcon(textureName + "_tiles");
		this.roadSideIcon = iconRegister.registerIcon(textureName + "_road_side");
		this.roadBottomIcon = iconRegister.registerIcon(textureName + "_road_bottom");
		this.refinedIcon = iconRegister.registerIcon(textureName + "_refined");
		this.crackedIcon = iconRegister.registerIcon(textureName + "_cracked");
		this.mossyIcon = iconRegister.registerIcon(textureName + "_mossy");
		
		this.chiseledIcon = iconRegister.registerIcon(textureName + "_chiseled");
		if (this.chiseledSided)
			this.chiseledSideIcon = iconRegister.registerIcon(textureName + "_chiseled_side");
		
		this.glowstoneLampIcon = iconRegister.registerIcon(textureName + "_lamp_glowstone");
		this.sunstoneLampIcon = iconRegister.registerIcon(textureName + "_lamp_sunstone");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
			return this.blockIcon;
		else if (metadata == 1)
			return this.brickIcon;
		else if (metadata == 2)
			return this.patternBrickIcon;
		else if (metadata == 3)
			return this.tilesIcon;
		else if (metadata == 4)
		{
			if (side == 0)
				return this.roadBottomIcon;
			else if (side == 1)
				return this.patternBrickIcon;
			else
				return this.roadSideIcon;
		}
		else if (metadata == 5)
			return this.refinedIcon;
		else if (metadata == 6)
		{
			if (this.chiseledSided && side > 1)
				return this.chiseledSideIcon;
			else if (this.clayChiseled)
				return this.refinedIcon;
			else
				return this.chiseledIcon;
		}
		else if (metadata == 7)
			return this.crackedIcon;
		else if (metadata == 8)
			return this.mossyIcon;
		else if (metadata == 14)
			return this.glowstoneLampIcon;
		else if (metadata == 15)
			return this.sunstoneLampIcon;
		
		return this.blockIcon;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.types.length; i++)
		{
			if (this.types[i] != null)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}
}
