package minestrapteam.minestrappolation.crafting;

import clashsoft.cslib.minecraft.crafting.manager.ExperienceRecipeManager;
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
		this.addRecipe(MBlocks.stoneStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.stoneStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.stone, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MBlocks.stone2, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MBlocks.stoneBronze, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MBlocks.stoneBronze2, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MBlocks.stoneBronzeStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MBlocks.stoneBronzeStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MBlocks.stoneMeurodite, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.stoneMeurodite2, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.stoneMeuroditeStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.stoneMeuroditeStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.stoneSteel, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MBlocks.stoneSteel2, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MBlocks.stoneSteelStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MBlocks.stoneSteelStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.7F);
		this.addRecipe(MBlocks.stoneTin, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.stoneTin2, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.stoneTinStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.stoneTinStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		
		this.addRecipe(Blocks.sandstone, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(Blocks.sandstone_stairs, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MBlocks.sandstone, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MBlocks.sandstone2, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MBlocks.sandstoneStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		this.addRecipe(MBlocks.sandstoneStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.4F);
		
		this.addRecipe(MBlocks.redSandstone, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.redSandstone2, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.redSandstoneStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.redSandstoneStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		
		this.addRecipe(MBlocks.graniteSlate, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.graniteSlate2, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		this.addRecipe(MBlocks.graniteSlateBronze, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateBronze2, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateMeurodite, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MBlocks.graniteSlateMeurodite2, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.9F);
		this.addRecipe(MBlocks.graniteSlateSteel, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateSteel2, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.8F);
		this.addRecipe(MBlocks.graniteSlateTin, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.graniteSlateTin2, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.graniteSlateStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.graniteSlateStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.graniteSlateStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		
		this.addRecipe(MBlocks.flint, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.flint2, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.flintStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.flintStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.flintStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		
		this.addRecipe(MBlocks.desertQuartz, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.desertQuartz2, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.desertQuartzStairsRaw, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.desertQuartzStairsBricks, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		this.addRecipe(MBlocks.desertQuartzStairsTiles, new ItemStack(Items.lava_bucket, 1, 0), 0.6F);
		
		this.addRecipe(MBlocks.edgeStoneBrick, new ItemStack(Items.lava_bucket, 1, 0), 0.5F);
		
		this.addRecipe(Blocks.snow, new ItemStack(Items.water_bucket, 1, 0), 0.4F);
		this.addRecipe(Blocks.ice, new ItemStack(Items.water_bucket, 1, 0), 0.7F);
		this.addRecipe(Blocks.packed_ice, new ItemStack(Items.water_bucket, 1, 0), 0.8F);
		
		this.addRecipe(MBlocks.titaniumOre, new ItemStack(MItems.titaniumIngot, 1, 0), 2.0F);
		this.addRecipe(Blocks.obsidian, new ItemStack(MItems.magmaBucket, 1, 0), 0.7F);
		this.addRecipe(Blocks.bedrock, new ItemStack(MItems.magmaBucket, 1, 0), 0.7F);
		this.addRecipe(Blocks.glowstone, new ItemStack(MBlocks.glowGlass), 0.7F);
	}
}
