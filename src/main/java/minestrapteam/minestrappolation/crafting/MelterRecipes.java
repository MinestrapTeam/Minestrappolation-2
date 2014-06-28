package minestrapteam.minestrappolation.crafting;

import clashsoft.cslib.minecraft.crafting.ExperienceRecipeManager;
import minestrapteam.minestrap_core.lib.MCBlocks;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MelterRecipes extends ExperienceRecipeManager
{
	public static final MelterRecipes	instance	= new MelterRecipes();
	
	private MelterRecipes()
	{
		this.addRecipe(Blocks.cobblestone, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(Blocks.mossy_cobblestone, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(Blocks.gravel, new ItemStack(Items.lava_bucket, 1, 0), 0.2F);
		this.addRecipe(Blocks.stone, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(Blocks.stonebrick, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(Blocks.snow, new ItemStack(Items.water_bucket, 1, 0), 0.4F);
		this.addRecipe(Blocks.ice, new ItemStack(Items.water_bucket, 1, 0), 0.7F);
		this.addRecipe(Blocks.packed_ice, new ItemStack(Items.water_bucket, 1, 0), 0.8F);
		this.addRecipe(Blocks.cobblestone_wall, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MCBlocks.graniteSlate, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.graniteSlate2, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.graniteSlateBronze, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateBronze2, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateMeurodite, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MCBlocks.graniteSlateMeurodite2, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MCBlocks.graniteSlateSteel, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateSteel2, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateTin, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.graniteSlateTin2, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.titaniumOre, new ItemStack(MItems.titaniumIngot, 1, 0), 2.0F);
		// addSmelting(Blocks.obsidian, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		// addSmelting(Blocks.bedrock, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		// this.addRecipe(MBlocks.Granite, new ItemStack(Items.lava_bucket, 1,
		// 0), 0.7F);
		this.addRecipe(Blocks.glowstone, new ItemStack(MBlocks.glowGlass), 0.7F);
	}
}
