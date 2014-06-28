package minestrapteam.minestrap_core.item;

import clashsoft.cslib.minecraft.item.datatools.ItemDataPickaxe;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MCItemPickaxe extends MCItemTool
{
	private boolean	breakBedrock	= false;
	
	public MCItemPickaxe(ToolMaterial material)
	{
		this(material, false);
	}
	
	public MCItemPickaxe(ToolMaterial material, boolean ignites)
	{
		super(ItemDataPickaxe.baseDamage, material, ItemDataPickaxe.blocksEffectiveAgainst, "pickaxe", ignites);
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		if (this.breakBedrock && block == Blocks.bedrock)
		{
			return this.toolMaterial.getHarvestLevel() == 4;
		}
		return super.canHarvestBlock(block, stack);
	}
	
    public boolean onBlockDestroyed(ItemStack itemstack, World world, Block blockDestroyed, int x, int y, int z, EntityLivingBase living)
    {
    	if(blockDestroyed == Blocks.bedrock)
    	{
    		itemstack.damageItem(2000, living);
    	}
    	
		return false;
    }
}
