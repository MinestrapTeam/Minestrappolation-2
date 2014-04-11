package sobiohazardous.minestrappolation.extradecor.block;

import java.util.List;

import sobiohazardous.minestrappolation.api.block.MBlock;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extradecor.lib.EDConfig;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

//flintBlock = (new MBlock(EDConfig.flintBlockId, Material.rock)).setHardness(3F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("block_FlintBlock").setCreativeTab(tabDecorBlocks);
//netherBrickPattern = (new MBlock(EDConfig.netherBrickPatternId, Material.rock)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(tabDecorBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("block_PatternBrickNether");

public class BlockTiles extends Block 
{
	private IIcon ob;
	private IIcon flint;
	private IIcon nether;
	private IIcon checker;
	private IIcon brick;
	private IIcon fb;
	private IIcon nb;
	
	public BlockTiles() 
	{
		super(Material.rock);
	}
	
	public float getBlockHardness(World par1World, int par2, int par3, int par4){
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		
		switch(meta){
		case 0:
			return 60F;
		case 1:
			return 3F;
		case 2:
			return .8F;
		case 3:
			return 3F;
		case 4:
			return 2F; 
		case 5:
			return 3F; 
		case 6:
			return 2F; 
		}
		
		
		return 5F;
		
	}
	
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
     int meta = world.getBlockMetadata(x, y, z);
     switch (meta)
     {
     case 0:
                     return 2000F;
     case 1:
                    return 10F;
     case 2:
                    return 1F;
     case 3:
                    return 10F;
     case 4:
    	    return 10F;
     case 5:
			return 10F; 
     case 6:
			return 10F; 
     
     }
     return 1F;
    }
	
	
	public void registerBlockIcons(IIconRegister par1IconRegister) 
	{
		this.ob = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Obsidian_Tiles_0_0"));
		this.flint = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Flint_Tiles_0_0"));
		this.nether = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("NetherQuartz_Tiles_0_0"));
		this.checker = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Flint-NetherQuartz_TileChecker_0_0"));
		this.brick = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Clay_PatternBricks_0_0"));
		this.fb = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Flint_Raw_0_0"));
		this.nb = par1IconRegister
				.registerIcon(MAssetManager.getEDStonecutterTexture("Netherrack_PatternBricks_0_0"));

	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	 @SideOnly(Side.CLIENT)
		public IIcon getIcon(int i, int j) 
	 {
			switch (j) {
			case 0:
					return ob;
			case 1:
				return flint;
			case 2:
				return nether;
			case 3:
				return checker;
			case 4:
				return brick;
			case 5:
				return fb;
			case 6:
				return nb;
			}
			return ob;

		}
	    @SideOnly(Side.CLIENT)

		/**
		 * returns a list of blocks with the same ID, but different meta (eg: wood
		 * returns 4 blocks)
		 */
		public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs,
				List par3List) {
			par3List.add(new ItemStack(par1, 1, 0));
			par3List.add(new ItemStack(par1, 1, 1));
			par3List.add(new ItemStack(par1, 1, 2));
			par3List.add(new ItemStack(par1, 1, 3));
			par3List.add(new ItemStack(par1, 1, 4));
			par3List.add(new ItemStack(par1, 1, 5));
			par3List.add(new ItemStack(par1, 1, 6));
		}

}
