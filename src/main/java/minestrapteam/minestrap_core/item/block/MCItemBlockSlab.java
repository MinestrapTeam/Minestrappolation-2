package minestrapteam.minestrap_core.item.block;

import minestrapteam.minestrap_core.block.MCBlockMultiSlab;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class MCItemBlockSlab extends ItemSlab
{
	public MCItemBlockSlab(Block block, MCBlockMultiSlab singleSlab, MCBlockMultiSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab, block == doubleSlab);
		doubleSlab.setOtherSlab(singleSlab);
		this.hasSubtypes = true;
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta & 7;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
}