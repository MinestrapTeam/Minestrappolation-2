package minestrapteam.minestrappolation.crafting;

import clashsoft.cslib.minecraft.crafting.ExperienceRecipeManager;
import minestrapteam.mcore.lib.MCBlocks;
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
		this.addRecipe(Blocks.stone_stairs, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(Blocks.stone_brick_stairs, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(Blocks.cobblestone_wall, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MCBlocks.stoneStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.stoneStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.stone, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MCBlocks.stone2, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MCBlocks.stoneBronze, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MCBlocks.stoneBronze2, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MCBlocks.stoneBronzeStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MCBlocks.stoneBronzeStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MCBlocks.stoneMeurodite, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.stoneMeurodite2, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.stoneMeuroditeStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.stoneMeuroditeStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.stoneSteel, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MCBlocks.stoneSteel2, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MCBlocks.stoneSteelStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MCBlocks.stoneSteelStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MCBlocks.stoneTin, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.stoneTin2, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.stoneTinStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.stoneTinStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		
		this.addRecipe(Blocks.sandstone, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(Blocks.sandstone_stairs, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MCBlocks.sandstone, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MCBlocks.sandstone2, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MCBlocks.sandstoneStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MCBlocks.sandstoneStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		
		this.addRecipe(MCBlocks.redSandstone, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.redSandstone2, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.redSandstoneStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.redSandstoneStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		
		this.addRecipe(MCBlocks.graniteSlate, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.graniteSlate2, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MCBlocks.graniteSlateBronze, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateBronze2, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateMeurodite, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MCBlocks.graniteSlateMeurodite2, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MCBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MCBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MCBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MCBlocks.graniteSlateSteel, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateSteel2, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MCBlocks.graniteSlateTin, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.graniteSlateTin2, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		
		this.addRecipe(MCBlocks.flint, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.flint2, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.flintStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.flintStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.flintStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		
		this.addRecipe(MCBlocks.desertQuartz, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.desertQuartz2, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.desertQuartzStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.desertQuartzStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MCBlocks.desertQuartzStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		
		this.addRecipe(MBlocks.edgeStoneBrick, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		
		this.addRecipe(Blocks.snow, new ItemStack(Items.water_bucket, 1, 0), 0.4F);
		this.addRecipe(Blocks.ice, new ItemStack(Items.water_bucket, 1, 0), 0.7F);
		this.addRecipe(Blocks.packed_ice, new ItemStack(Items.water_bucket, 1, 0), 0.8F);

		this.addRecipe(MBlocks.titaniumOre, new ItemStack(MItems.titaniumIngot, 1, 0), 2.0F);
		// addSmelting(Blocks.obsidian, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		// addSmelting(Blocks.bedrock, new
		// ItemStack(EOItemManager.bucketMagma,1,0), 0.7F);
		this.addRecipe(Blocks.glowstone, new ItemStack(MBlocks.glowGlass), 0.7F);
	}
}
