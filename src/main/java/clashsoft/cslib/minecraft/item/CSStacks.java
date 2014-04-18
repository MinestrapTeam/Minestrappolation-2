package clashsoft.cslib.minecraft.item;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CSStacks
{
	// public static ItemStack = new ItemStack(Blocks.);
	
	public static ItemStack	air						= new ItemStack(Blocks.air);
	
	public static ItemStack	birch_log				= new ItemStack(Blocks.log, 1, 2);
	public static ItemStack	birch_planks			= new ItemStack(Blocks.planks, 1, 2);
	
	public static ItemStack	dirt					= new ItemStack(Blocks.dirt);
	
	public static ItemStack	end_stone				= new ItemStack(Blocks.end_stone);
	
	public static ItemStack	fire					= new ItemStack(Blocks.fire);
	
	public static ItemStack	glass_block				= new ItemStack(Blocks.glass);
	public static ItemStack	glass_pane				= new ItemStack(Blocks.glass_pane);
	public static ItemStack	glowstone				= new ItemStack(Blocks.glowstone);
	public static ItemStack	gold_block				= new ItemStack(Blocks.gold_block);
	
	public static ItemStack	ice						= new ItemStack(Blocks.ice);
	
	public static ItemStack	jungle_log				= new ItemStack(Blocks.log, 1, 3);
	public static ItemStack	jungle_planks			= new ItemStack(Blocks.planks, 1, 3);
	
	public static ItemStack	lapis_block				= new ItemStack(Blocks.lapis_block);
	
	public static ItemStack	oak_log					= new ItemStack(Blocks.log, 1, 0);
	public static ItemStack	oak_planks				= new ItemStack(Blocks.planks, 1, 0);
	public static ItemStack	obsidian				= new ItemStack(Blocks.obsidian);
	
	public static ItemStack	pumpkin					= new ItemStack(Blocks.pumpkin);
	
	public static ItemStack	redstone_block			= new ItemStack(Blocks.redstone_block);
	
	public static ItemStack	sandstone				= new ItemStack(Blocks.sandstone);
	public static ItemStack	spruce_log				= new ItemStack(Blocks.log, 1, 1);
	public static ItemStack	spruce_planks			= new ItemStack(Blocks.planks, 1, 1);
	
	// public static ItemStack = new ItemStack(Items.);
	
	public static ItemStack	apple					= new ItemStack(Items.apple);
	
	public static ItemStack	beef					= new ItemStack(Items.beef);
	public static ItemStack	blaze_powder			= new ItemStack(Items.blaze_powder);
	public static ItemStack	blaze_rod				= new ItemStack(Items.blaze_rod);
	public static ItemStack	bone					= new ItemStack(Items.bone);
	public static ItemStack	bonemeal				= new ItemStack(Items.dye, 1, 15);
	public static ItemStack	bowl					= new ItemStack(Items.bowl);
	public static ItemStack	bread					= new ItemStack(Items.bread);
	public static ItemStack	brick					= new ItemStack(Items.brick);
	public static ItemStack	bucket					= new ItemStack(Items.bucket);
	
	public static ItemStack	carrot					= new ItemStack(Items.carrot);
	public static ItemStack	char_coal				= new ItemStack(Items.coal, 1, 1);
	public static ItemStack	chicken					= new ItemStack(Items.chicken);
	public static ItemStack	clay					= new ItemStack(Items.clay_ball);
	public static ItemStack	coal					= new ItemStack(Items.coal);
	public static ItemStack	cocoa					= new ItemStack(Items.dye, 1, 3);
	
	public static ItemStack	diamond					= new ItemStack(Items.diamond);
	public static ItemStack	dye_red					= new ItemStack(Items.dye, 1, 1);
	public static ItemStack	dye_light_green			= new ItemStack(Items.dye, 1, 10);
	
	public static ItemStack	egg						= new ItemStack(Items.egg);
	public static ItemStack	emerald					= new ItemStack(Items.emerald);
	public static ItemStack	ender_pearl				= new ItemStack(Items.ender_pearl);
	
	public static ItemStack	fermented_spider_eye	= new ItemStack(Items.fermented_spider_eye);
	public static ItemStack	fish					= new ItemStack(Items.fish);
	public static ItemStack	flint					= new ItemStack(Items.flint);
	
	public static ItemStack	ghast_tear				= new ItemStack(Items.ghast_tear);
	public static ItemStack	glowstone_dust			= new ItemStack(Items.glowstone_dust);
	public static ItemStack	golden_carrot			= new ItemStack(Items.golden_carrot);
	public static ItemStack	gold_ingot				= new ItemStack(Items.gold_ingot);
	public static ItemStack	gold_nugget				= new ItemStack(Items.gold_nugget);
	
	public static ItemStack	iron_ingot				= new ItemStack(Items.iron_ingot);
	
	public static ItemStack	lava_bucket				= new ItemStack(Items.lava_bucket);
	public static ItemStack	leather					= new ItemStack(Items.leather);
	
	public static ItemStack	magma_cream				= new ItemStack(Items.magma_cream);
	public static ItemStack	melon					= new ItemStack(Items.melon);
	public static ItemStack	milk_bucket				= new ItemStack(Items.milk_bucket);
	
	public static ItemStack	nether_brick			= new ItemStack(Items.netherbrick);
	public static ItemStack	nether_star				= new ItemStack(Items.nether_star);
	
	public static ItemStack	paper					= new ItemStack(Items.paper);
	public static ItemStack	porkchop				= new ItemStack(Items.porkchop);
	public static ItemStack	potato					= new ItemStack(Items.potato);
	
	public static ItemStack	quartz					= new ItemStack(Items.quartz);
	
	public static ItemStack	reeds					= new ItemStack(Items.reeds);
	
	public static ItemStack	slimeball				= new ItemStack(Items.slime_ball);
	public static ItemStack	snowball				= new ItemStack(Items.snowball);
	public static ItemStack	speckled_melon			= new ItemStack(Items.speckled_melon);
	public static ItemStack	spider_eye				= new ItemStack(Items.spider_eye);
	public static ItemStack	stick					= new ItemStack(Items.stick);
	public static ItemStack	sugar					= new ItemStack(Items.sugar);
	
	public static ItemStack	water_bucket			= new ItemStack(Items.water_bucket);
	public static ItemStack	wheat					= new ItemStack(Items.wheat);
	public static ItemStack	wither_skull			= new ItemStack(Items.skull, 1, 1);
	
	public static boolean equals(ItemStack stack1, ItemStack stack2)
	{
		return OreDictionary.itemMatches(stack1, stack2, true);
	}
	
	public static int mergeItemStack(ItemStack[] stacks, int start, ItemStack stack)
	{
		return mergeItemStack(stacks, start, stacks.length, stack);
	}
	
	public static int mergeItemStack(ItemStack[] stacks, int start, int end, ItemStack stack)
	{
		int i = -1;
		int max = stack.getMaxStackSize();
		ItemStack stack1;
		
		for (int j = start; j < end && stack.isStackable() && stack.stackSize > 0; j++)
		{
			stack1 = stacks[j];
			if (stack1 != null && equals(stack, stack1))
			{
				int k = stack1.stackSize + stack.stackSize;
				if (k <= max)
				{
					stack.stackSize = 0;
					stack1.stackSize = k;
					i = j;
				}
				else if (stack1.stackSize < max)
				{
					stack.stackSize -= max - stack1.stackSize;
					stack1.stackSize = max;
					i = j;
				}
			}
		}
		
		if (stack.stackSize > 0)
		{
			for (int j = start; j < end; j++)
			{
				stack1 = stacks[j];
				if (stack1 == null)
				{
					stacks[j] = stack.copy();
					stack.stackSize = 0;
					return j;
				}
			}
		}
		
		return i;
	}
}
