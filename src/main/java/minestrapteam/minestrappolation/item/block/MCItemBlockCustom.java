package minestrapteam.minestrappolation.item.block;

import minestrapteam.minestrappolation.block.MBlockCustom;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MCItemBlockCustom extends ItemBlock
{
	public MBlockCustom	theBlock;
	
	public MCItemBlockCustom(Block block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		
		if (block instanceof MBlockCustom)
		{
			this.theBlock = (MBlockCustom) block;
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		if (this.theBlock != null)
		{
			return this.theBlock.getUnlocalizedName(stack.getItemDamage());
		}
		return this.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}
}
