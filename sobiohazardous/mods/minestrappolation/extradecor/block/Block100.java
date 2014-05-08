package sobiohazardous.mods.minestrappolation.extradecor.block;

import java.util.List;

import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import sobiohazardous.mods.minestrappolation.extradecor.tileentity.TileEntity100;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Block100 extends BlockContainer
{
	TileEntity100					te			= new TileEntity100();
	public static final String[]	brickType	= new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
	
	private IIcon					tile;
	
	public Block100()
	{
		super(Material.grass);
		this.setCreativeTab(EDBlocks.tabDecor);
	}
	
	@Override
	public int damageDropped(int par1)
	{
		return par1;
		
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.tile = par1IconRegister.registerIcon("Minestrappolation:block_StoneTile");
		
	}
	
	@Override
	public IIcon getIcon(int i, int j)
	{
		switch (j)
		{
		case 0:
			return this.tile;
		case 472:
			return this.tile;
		case 999:
			return this.tile;
		}
		
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int meta = 0; meta < this.te.getMetaData(); meta++)
		{
			par3List.add(new ItemStack(par1, 1, meta));
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return this.te;
	}
	
}
