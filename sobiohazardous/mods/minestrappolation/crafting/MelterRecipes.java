package sobiohazardous.mods.minestrappolation.crafting;

import sobiohazardous.mods.minestrappolation.lib.MBlocks;
import sobiohazardous.mods.minestrappolation.lib.MelterRecipeLoader;
import clashsoft.cslib.minecraft.crafting.ExperienceRecipeManager;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MelterRecipes extends ExperienceRecipeManager
{
	public static final MelterRecipes	instance		= new MelterRecipes();
	
	MelterRecipeLoader					recipeLoader	= new MelterRecipeLoader();
	
	private MelterRecipes()
	{
		this.recipeLoader.load();
		
		this.addRecipe(Blocks.cobblestone, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(Blocks.mossy_cobblestone, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(Blocks.gravel, new ItemStack(Items.lava_bucket, 1, 0), 0.2F);
		this.addRecipe(Blocks.stone, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(Blocks.stonebrick, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(Blocks.snow, new ItemStack(Items.water_bucket, 1, 0), 0.6F);
		this.addRecipe(Blocks.ice, new ItemStack(Items.water_bucket, 1, 0), 0.7F);
		this.addRecipe(Blocks.cobblestone_wall, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		// addSmelting(Blocks.obsidian, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		// addSmelting(Blocks.bedrock, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		this.addRecipe(MBlocks.Granite, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(Blocks.glowstone, new ItemStack(MBlocks.glowGlass), 0.7F);
		
		// addSmelting(EDBlockManager.obsidianTile, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		// addSmelting(EDBlockManager.bedrockBrick, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		// addSmelting(new ItemStack(EDBlockManager.snowBrick), new
		// ItemStack(Items.water_bucket, 1, 0), 0.7F);
		// addSmelting(new ItemStack(EDBlockManager.stones), 0, new
		// ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		// addSmelting(new ItemStack(EDBlockManager.stonePillar), new
		// ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		// addSmelting(new ItemStack(EDBlockManager.stones), 1, new
		// ItemStack(Items.lava_bucket, 1, 0), 0.7F);
	}
}