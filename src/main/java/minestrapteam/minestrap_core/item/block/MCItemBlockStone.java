package minestrapteam.minestrap_core.item.block;

import minestrapteam.minestrap_core.block.MCBlockStone;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MCItemBlockStone extends ItemBlock
{
	private MCBlockStone theBlock; 
	
	public MCItemBlockStone(Block block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		
		if (block instanceof MCBlockStone)
			this.theBlock = (MCBlockStone) block;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		if (this.theBlock != null)
			return this.theBlock.getUnlocalizedName(stack.getItemDamage());
		return this.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}
}
