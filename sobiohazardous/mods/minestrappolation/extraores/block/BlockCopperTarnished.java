package sobiohazardous.mods.minestrappolation.extraores.block;

import sobiohazardous.mods.minestrappolation.core.block.MBlock;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCopperTarnished extends MBlock
{
	public IIcon	top;
	
	public BlockCopperTarnished()
	{
		super(Material.iron);
		this.setCreativeTab(EOBlocks.tabOresBlocks);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(MAssetManager.getEOTexture("blockCopperTarnishedSide"));
		this.top = iconRegister.registerIcon(MAssetManager.getEOTexture("blockCopperTarnishedTop"));
	}
	
	// Args: side, metadata
	
	@Override
	public IIcon getIcon(int i, int j)
	{
		if (i == 0)
		{
			return this.blockIcon;
		}
		if (i == 1)
		{
			return this.top;
		}
		
		if (i == 2)
		{
			return this.blockIcon;
		}
		if (i == 3)
		{
			return this.blockIcon;
		}
		if (i == 4)
		{
			return this.blockIcon;
		}
		if (i == 5)
		{
			return this.blockIcon;
		}
		
		if (j == 1)
		{
			return this.blockIcon;
		}
		return this.top;
	}
	
	/*
	 * public boolean onBlockActivated(World par1World, int par2, int par3, int
	 * par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8,
	 * float par9) { if (par5EntityPlayer.getCurrentEquippedItem() != null &&
	 * (par5EntityPlayer.getCurrentEquippedItem().getItem() ==
	 * EMDItemManager.grease ||
	 * par5EntityPlayer.getCurrentEquippedItem().getItem() ==
	 * Items.fire_charge)) {
	 * par5EntityPlayer.getCurrentEquippedItem().stackSize--;
	 * par1World.setBlock(par2, par3, par4, EOBlockManager.CopperBlock); return
	 * true; }else if(par5EntityPlayer.getCurrentEquippedItem() == null){ return
	 * false; } return false; }
	 */
}
