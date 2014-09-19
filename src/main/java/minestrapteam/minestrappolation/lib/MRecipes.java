package minestrapteam.minestrappolation.lib;

import static minestrapteam.minestrappolation.lib.MBlocks.*;
import static minestrapteam.minestrappolation.lib.MItems.*;
import static minestrapteam.minestrappolation.lib.MTools.*;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrappolation.crafting.RecipesItemAddons;
import minestrapteam.minestrappolation.util.MUtil;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MRecipes
{
	public static void load()
	{
		GameRegistry.addRecipe(new RecipesItemAddons());
		
		// Wood Recipes
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.redwood, 4, 0), new Object[] { "L", 'L', MBlocks.redwoodLog });
		GameRegistry.addSmelting(MBlocks.redwoodLog, new ItemStack(Items.coal, 1, 1), 0.15F);
		
		// EO Item Recipes
		
		GameRegistry.addSmelting(copperOre, new ItemStack(copperIngot), 0.3F);
		GameRegistry.addShapelessRecipe(new ItemStack(copperIngot, 9), new Object[] { copperBlock });
		GameRegistry.addSmelting(tinOre, new ItemStack(tinIngot), 0.3F);
		GameRegistry.addShapelessRecipe(new ItemStack(tinIngot, 9), new Object[] { tinBlock });
		GameRegistry.addShapelessRecipe(new ItemStack(bronzeIngot, 1), new Object[] { Items.iron_ingot, copperIngot, copperIngot, tinIngot, tinIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(bronzeIngot, 9), new Object[] { bronzeBlock });
		GameRegistry.addShapelessRecipe(new ItemStack(coalIronIngot, 1), new Object[] { Items.iron_ingot, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal });
		GameRegistry.addSmelting(coalIronIngot, new ItemStack(steelIngot, 1), 0.7F);
		GameRegistry.addShapelessRecipe(new ItemStack(steelIngot, 9), new Object[] { steelBlock });
		GameRegistry.addShapelessRecipe(new ItemStack(titaniumIngot, 9), new Object[] { titaniumBlock });
		GameRegistry.addSmelting(toriteOre, new ItemStack(toriteIngot, 1), 1.1F);
		GameRegistry.addShapelessRecipe(new ItemStack(toriteIngot, 9), new Object[] { toriteBlock });
		GameRegistry.addRecipe(new ItemStack(blaziumIngot, 1), new Object[] { "ZZ", "ZZ", 'Z', blazeShard });
		GameRegistry.addShapelessRecipe(new ItemStack(blaziumIngot, 9), new Object[] { blaziumBlock });
		
		GameRegistry.addSmelting(soulOre, new ItemStack(soulGem), 0.8F);
		GameRegistry.addRecipe(new ItemStack(soulGem, 9), new Object[] { "M", 'M', soulBlock });
		GameRegistry.addSmelting(meuroditeOre, new ItemStack(meuroditeGem, 1), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(meuroditeGem, 9), new Object[] { meuroditeBlock });
		GameRegistry.addSmelting(uraniumOre, new ItemStack(uranium), 0.15F);
		GameRegistry.addShapelessRecipe(new ItemStack(uranium, 9), new Object[] { uraniumBlock });
		GameRegistry.addSmelting(plutoniumOre, new ItemStack(plutonium), 0.15F);
		GameRegistry.addShapelessRecipe(new ItemStack(plutonium, 9), new Object[] { plutoniumBlock });
		GameRegistry.addSmelting(radiantQuartzOre, new ItemStack(MItems.radiantQuartz), 0.8F);
		GameRegistry.addSmelting(MBlocks.blaziumOre, new ItemStack(blazeShard), 1.0F);
		GameRegistry.addSmelting(Items.blaze_powder, new ItemStack(blazeShard), 1.0F);
		GameRegistry.addSmelting(sunstoneOre, new ItemStack(sunstoneDust), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(soulBottle, 4), new Object[] { "S", "G", 'S', soulGem, 'G', Items.glass_bottle });
		GameRegistry.addRecipe(new ItemStack(grenade), new Object[] { " I ", "SGS", "SGS", 'I', Items.iron_ingot, 'S', plateSteelItem, 'G', Items.gunpowder });
		GameRegistry.addShapelessRecipe(new ItemStack(grenadeImpact), new ItemStack(Items.gunpowder), new ItemStack(grenade), new ItemStack(Items.gunpowder));
		GameRegistry.addShapelessRecipe(new ItemStack(grenadeSticky), new ItemStack(grenade), new ItemStack(Items.slime_ball));
		GameRegistry.addRecipe(new ItemStack(grenadeNuke), new Object[] { "SUS", "PGP", "SUS", 'S', plateSteelItem, 'U', uranium, 'P', plutonium, 'G', Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(plateTinItem, 1), new Object[] { "ZZZ", "ZZZ", 'Z', tinIngot });
		GameRegistry.addRecipe(new ItemStack(plateBronzeItem, 1), new Object[] { "ZZZ", "ZZZ", 'Z', bronzeIngot });
		GameRegistry.addRecipe(new ItemStack(plateSteelItem, 1), new Object[] { "ZZZ", "ZZZ", 'Z', steelIngot });
		GameRegistry.addRecipe(new ItemStack(plateMeuroditeItem, 1), new Object[] { "MMM", "MMM", 'M', meuroditeGem });
		
		// EO Block Recipes
		
		GameRegistry.addRecipe(new ItemStack(copperBlock), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', copperIngot });
		GameRegistry.addRecipe(new ItemStack(tinBlock), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', tinIngot });
		GameRegistry.addRecipe(new ItemStack(bronzeBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', bronzeIngot });
		GameRegistry.addRecipe(new ItemStack(titaniumBlock), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', titaniumIngot });
		GameRegistry.addRecipe(new ItemStack(uraniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', uranium });
		GameRegistry.addRecipe(new ItemStack(uraniumInsulated, 1), new Object[] { "SPS", "GUG", "SPS", 'S', steelIngot, 'G', MBlocks.refinedGlassPane, 'U', uraniumBlock, 'P', MItems.plateSteelItem });
		GameRegistry.addRecipe(new ItemStack(plutoniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', plutonium });
		GameRegistry.addRecipe(new ItemStack(plutoniumInsulated, 1), new Object[] { "SPS", "GUG", "SPS", 'S', steelIngot, 'G', MBlocks.refinedGlassPane, 'U', plutoniumBlock, 'P', MItems.plateSteelItem });
		GameRegistry.addRecipe(new ItemStack(meuroditeBlock), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', meuroditeGem });
		GameRegistry.addRecipe(new ItemStack(sunstoneBlock), new Object[] { "ZZ", "ZZ", 'Z', sunstoneDust });
		GameRegistry.addRecipe(new ItemStack(toriteBlock), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', toriteIngot });
		GameRegistry.addRecipe(new ItemStack(blaziumBlock), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', blaziumIngot });
		GameRegistry.addRecipe(new ItemStack(steelBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z', steelIngot });
		GameRegistry.addRecipe(new ItemStack(soulBlock, 1), new Object[] { "MMM", "MMM", "MMM", 'M', soulGem });
		
		GameRegistry.addRecipe(new ItemStack(godstone, 1), new Object[] { "SSS", "SES", "SSS", 'S', MItems.sunstoneDust, 'E', new ItemStack(MBlocks.endstone, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(nuke, 1), new Object[] { "UPU", "PUP", "UPU", 'P', plutoniumBlock, 'U', uraniumBlock });
		// MBlockMachine recipes require the metadata 1 because of the front
		// texture of the item.
		GameRegistry.addRecipe(new ItemStack(melterIdle, 1, 1), new Object[] { "ZZZ", "ZFZ", "IBI", 'Z', plateMeuroditeItem, 'F', Blocks.furnace, 'B', blaziumBlock, 'I', Blocks.iron_bars });
		GameRegistry.addRecipe(new ItemStack(stoneCutter, 1, 1), new Object[] { "II", "CC", "CC", 'C', Blocks.cobblestone, 'I', Items.iron_ingot });
		
		// EO Tool Recipes
		
		GameRegistry.addRecipe(new ItemStack(sandstoneSword), new Object[] { " Z ", " Z ", " S ", 'Z', Blocks.sandstone, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(sandstoneShovel), new Object[] { " Z ", " S ", " S ", 'Z', Blocks.sandstone, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(sandstonePickaxe), new Object[] { "ZZZ", " S ", " S ", 'Z', Blocks.sandstone, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(sandstoneAxe), new Object[] { "ZZ ", "ZS ", " S ", 'Z', Blocks.sandstone, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(sandstoneHoe), new Object[] { "ZZ ", " S ", " S ", 'Z', Blocks.sandstone, 'S', Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(graniteSword, 1), new Object[] { " Z ", " Z ", " S ", 'Z', MBlocks.graniteSlate, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(graniteShovel, 1), new Object[] { " Z ", " S ", " S ", 'Z', MBlocks.graniteSlate, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(graniteAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", 'Z', MBlocks.graniteSlate, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(granitePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", 'Z', MBlocks.graniteSlate, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(graniteHoe, 1), new Object[] { "ZZ ", " S ", " S ", 'Z', MBlocks.graniteSlate, 'S', Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(meuroditeSword, 1), new Object[] { " Z ", " Z ", " S ", 'Z', meuroditeGem, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditeShovel, 1), new Object[] { " Z ", " S ", " S ", 'Z', meuroditeGem, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", 'Z', meuroditeGem, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditeAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", 'Z', meuroditeGem, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditeHoe, 1), new Object[] { "ZZ ", " S ", " S ", 'Z', meuroditeGem, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditeHelmet, 1), new Object[] { "ZZZ", "Z Z", 'Z', meuroditeGem });
		GameRegistry.addRecipe(new ItemStack(meuroditeChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z', meuroditeGem });
		GameRegistry.addRecipe(new ItemStack(meuroditeLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", 'Z', meuroditeGem });
		GameRegistry.addRecipe(new ItemStack(meuroditeBoots, 1), new Object[] { "Z Z", "Z Z", 'Z', meuroditeGem });
		
		GameRegistry.addRecipe(new ItemStack(titaniumSword, 1), new Object[] { " Z ", " Z ", " S ", 'Z', titaniumIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumShovel, 1), new Object[] { " Z ", " S ", " S ", 'Z', titaniumIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", 'Z', titaniumIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", 'Z', titaniumIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumHoe, 1), new Object[] { "ZZ ", " S ", " S ", 'Z', titaniumIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumHelmet, 1), new Object[] { "ZZZ", "Z Z", 'Z', titaniumIngot });
		GameRegistry.addRecipe(new ItemStack(titaniumChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z', titaniumIngot });
		GameRegistry.addRecipe(new ItemStack(titaniumLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", 'Z', titaniumIngot });
		GameRegistry.addRecipe(new ItemStack(titaniumBoots, 1), new Object[] { "Z Z", "Z Z", 'Z', titaniumIngot });
		
		GameRegistry.addRecipe(new ItemStack(toriteSword, 1), new Object[] { " Z ", " Z ", " S ", 'Z', toriteIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(toriteShovel, 1), new Object[] { " Z ", " S ", " S ", 'Z', toriteIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(toritePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", 'Z', toriteIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(toriteAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", 'Z', toriteIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(toriteHoe, 1), new Object[] { "ZZ ", " S ", " S ", 'Z', toriteIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(toriteHelmet, 1), new Object[] { "ZZZ", "Z Z", 'Z', toriteIngot });
		GameRegistry.addRecipe(new ItemStack(toriteChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z', toriteIngot });
		GameRegistry.addRecipe(new ItemStack(toriteLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", 'Z', toriteIngot });
		GameRegistry.addRecipe(new ItemStack(toriteBoots, 1), new Object[] { "Z Z", "Z Z", 'Z', toriteIngot });
		
		GameRegistry.addRecipe(new ItemStack(blaziumSword, 1), new Object[] { " Z ", " Z ", " S ", 'Z', blaziumIngot, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumShovel, 1), new Object[] { " Z ", " S ", " S ", 'Z', blaziumIngot, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", 'Z', blaziumIngot, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", 'Z', blaziumIngot, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumHoe, 1), new Object[] { "ZZ ", " S ", " S ", 'Z', blaziumIngot, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumHelmet, 1), new Object[] { "ZZZ", "Z Z", 'Z', blaziumIngot });
		GameRegistry.addRecipe(new ItemStack(blaziumChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z', blaziumIngot });
		GameRegistry.addRecipe(new ItemStack(blaziumLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", 'Z', blaziumIngot });
		GameRegistry.addRecipe(new ItemStack(blaziumBoots, 1), new Object[] { "Z Z", "Z Z", 'Z', blaziumIngot });
		
		GameRegistry.addRecipe(new ItemStack(copperSword, 1), new Object[] { " Z ", " Z ", " S ", 'Z', copperIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(copperShovel, 1), new Object[] { " Z ", " S ", " S ", 'Z', copperIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(copperPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", 'Z', copperIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(copperAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", 'Z', copperIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(copperHoe, 1), new Object[] { "ZZ ", " S ", " S ", 'Z', copperIngot, 'S', Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(tinHelmet, 1), new Object[] { "ZZZ", "Z Z", 'Z', tinIngot });
		GameRegistry.addRecipe(new ItemStack(tinChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z', tinIngot });
		GameRegistry.addRecipe(new ItemStack(tinLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", 'Z', tinIngot });
		GameRegistry.addRecipe(new ItemStack(tinBoots, 1), new Object[] { "Z Z", "Z Z", 'Z', tinIngot });
		
		GameRegistry.addRecipe(new ItemStack(steelSword, 1), new Object[] { " Z ", " Z ", " S ", 'Z', steelIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelShovel, 1), new Object[] { " Z ", " S ", " S ", 'Z', steelIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", 'Z', steelIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", 'Z', steelIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelHoe, 1), new Object[] { "ZZ ", " S ", " S ", 'Z', steelIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelHelmet, 1), new Object[] { "ZZZ", "Z Z", 'Z', steelIngot });
		GameRegistry.addRecipe(new ItemStack(steelChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z', steelIngot });
		GameRegistry.addRecipe(new ItemStack(steelLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", 'Z', steelIngot });
		GameRegistry.addRecipe(new ItemStack(steelBoots, 1), new Object[] { "Z Z", "Z Z", 'Z', steelIngot });
		
		GameRegistry.addRecipe(new ItemStack(bronzeSword, 1), new Object[] { " Z ", " Z ", " S ", 'Z', bronzeIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzeShovel, 1), new Object[] { " Z ", " S ", " S ", 'Z', bronzeIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", 'Z', bronzeIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzeAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", 'Z', bronzeIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzeHoe, 1), new Object[] { "ZZ ", " S ", " S ", 'Z', bronzeIngot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzeHelmet, 1), new Object[] { "ZZZ", "Z Z", 'Z', bronzeIngot });
		GameRegistry.addRecipe(new ItemStack(bronzeChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z', bronzeIngot });
		GameRegistry.addRecipe(new ItemStack(bronzeLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", 'Z', bronzeIngot });
		GameRegistry.addRecipe(new ItemStack(bronzeBoots, 1), new Object[] { "Z Z", "Z Z", 'Z', bronzeIngot });
		
		GameRegistry.addRecipe(new ItemStack(bedrockShovel, 1), new Object[] { " Z ", " S ", " S ", 'Z', Blocks.bedrock, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(bedrockPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", 'Z', Blocks.bedrock, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(bedrockAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", 'Z', Blocks.bedrock, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(bedrockHoe, 1), new Object[] { "ZZ ", " S ", " S ", 'Z', Blocks.bedrock, 'S', Items.stick });
		
		// ED Items
		
		GameRegistry.addRecipe(new ItemStack(ropeItem, 1), new Object[] { "S", "S", "S", 'S', Items.string });
		GameRegistry.addRecipe(new ItemStack(ropeItem, 9), new Object[] { "S", 'S', ropeCoil });
		GameRegistry.addRecipe(new ItemStack(cardboardItem, 3), new Object[] { "SSS", "SSS", 'S', Items.paper });
		
		// ED Blocks
		
		GameRegistry.addRecipe(new ItemStack(snowBrick, 4), new Object[] { "SS", "SS", 'S', Blocks.snow });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.glowGlassPane, 16), new Object[] { "GGG", "GGG", 'G', glowGlass });
		GameRegistry.addSmelting(Blocks.glass, new ItemStack(refinedGlass), 20);
		GameRegistry.addRecipe(new ItemStack(refinedGlassPane, 16), new Object[] { "SSS", "SSS", 'S', refinedGlass });
		
		GameRegistry.addRecipe(new ItemStack(gunpowderBlock), new Object[] { "SSS", "SSS", "SSS", 'S', Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 9), new Object[] { "S", 'S', gunpowderBlock });
		GameRegistry.addRecipe(new ItemStack(sugarBlock), new Object[] { "SSS", "SSS", "SSS", 'S', Items.sugar });
		GameRegistry.addRecipe(new ItemStack(Items.sugar, 9), new Object[] { "S", 'S', sugarBlock });
		GameRegistry.addRecipe(new ItemStack(enderBlock), new Object[] { "SSS", "SSS", "SSS", 'S', Items.ender_pearl });
		GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] { "S", 'S', enderBlock });
		GameRegistry.addRecipe(new ItemStack(slimeOoze), new Object[] { "SSS", "SSS", "SSS", 'S', Items.slime_ball });
		GameRegistry.addRecipe(new ItemStack(Items.slime_ball, 9), new Object[] { "S", 'S', slimeOoze });
		GameRegistry.addRecipe(new ItemStack(magmaOoze), new Object[] { "SSS", "SSS", "SSS", 'S', Items.magma_cream });
		GameRegistry.addRecipe(new ItemStack(Items.magma_cream, 9), new Object[] { "S", 'S', magmaOoze });
		
		GameRegistry.addRecipe(new ItemStack(goblet), new Object[] { "D D", " D ", 'D', Items.gold_ingot });
		GameRegistry.addRecipe(new ItemStack(plate, 2), new Object[] { "GG", "GG", 'G', Items.gold_ingot });
		GameRegistry.addRecipe(new ItemStack(ropeCoil), new Object[] { "SSS", "SSS", "SSS", 'S', ropeItem });
		GameRegistry.addRecipe(new ItemStack(cardboardBlock, 2), new Object[] { "CCC", " C ", " CC", 'C', cardboardItem });
		GameRegistry.addShapelessRecipe(new ItemStack(cardboardBlock, 1, 2), new ItemStack(cardboardBlock), new ItemStack(Items.glowstone_dust));
		
		for (int i = 0; i < 16; i++)
		{
			GameRegistry.addShapedRecipe(new ItemStack(MBlocks.coloredLampOff, 1, i), new Object[] { " D ", "DLD", " D ", 'L', Blocks.redstone_lamp, 'D', new ItemStack(Items.dye, 1, i) });
		}
		
		// Misc Stone Block Recipes
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.redSandstone, 1, 0), new Object[] { "SS", "SS", 'S', new ItemStack(Blocks.sand, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.flint, 1, 0), new Object[] { "FF", "FF", 'F', Items.flint });
		GameRegistry.addRecipe(new ItemStack(Items.flint, 4, 0), new Object[] { "F", 'F', new ItemStack(MBlocks.flint, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.desertQuartz, 1, 0), new Object[] { "QQ", "QQ", 'Q', MItems.desertQuartz });
		GameRegistry.addSmelting(Blocks.end_stone, new ItemStack(MBlocks.endstone, 1, 0), 1.5F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.radiantQuartz, 1, 0), new Object[] { "QQ", "QQ", 'Q', MItems.radiantQuartz });
		
		// EMD Items
		
		GameRegistry.addSmelting(fat, new ItemStack(grease, 1), 0.7F);
		
		GameRegistry.addRecipe(new ItemStack(Items.dye, 1, 15), new Object[] { "AA", "AA", 'A', animalBones });
		GameRegistry.addSmelting(chickenWingRaw, new ItemStack(chickenWingCooked, 1), 0.7F);
		GameRegistry.addSmelting(lambchopRaw, new ItemStack(lambchopCooked, 1), 0.7F);
		GameRegistry.addSmelting(squidTentacle, new ItemStack(calimari, 1), 0.7F);
		GameRegistry.addRecipe(new ItemStack(Items.string), new Object[] { "WW", "WW", 'W', whisker });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 0), new Object[] { "GGG", "GPG", "GGG", 'G', Items.gold_ingot, 'P', pigHoof });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 1), new Object[] { "GGG", "GPG", "GGG", 'G', Items.gold_ingot, 'P', cowHoof });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 2), new Object[] { "GGG", "GPG", "GGG", 'G', Items.gold_ingot, 'P', footChicken });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 3), new Object[] { "GGG", "GPG", "GGG", 'G', Items.gold_ingot, 'P', sheepHoof });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 4), new Object[] { "GGG", "GPG", "GGG", 'G', Items.gold_ingot, 'P', horseHoof });
		GameRegistry.addRecipe(new ItemStack(amuletPorcum, 1), new Object[] { " S ", "S S", " C ", 'S', Items.string, 'C', new ItemStack(charms, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(amuletVaccam, 1), new Object[] { " S ", "S S", " C ", 'S', Items.string, 'C', new ItemStack(charms, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(amuletPullum, 1), new Object[] { " S ", "S S", " C ", 'S', Items.string, 'C', new ItemStack(charms, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(amuletOves, 1), new Object[] { " S ", "S S", " C ", 'S', Items.string, 'C', new ItemStack(charms, 1, 3) });
		GameRegistry.addSmelting(horseHaunchRaw, new ItemStack(horseHaunchCooked), 0.8F);
		GameRegistry.addRecipe(new ItemStack(wingSegment, 1, 0), new Object[] { "FSF", "SLS", "FSF", 'F', Items.feather, 'S', wingSinew, 'L', Items.leather });
		// GameRegistry.addRecipe(new ItemStack(hangGlider, 1, 0), new Object[]
		// { "PPP", "W W", "W W", 'P', Blocks.planks, 'W', wingSegment });
	}
	
	public static void removeRecipes()
	{
		// Misc Recipes
		MUtil.removeRecipe(new ItemStack(Blocks.anvil, 1, 0));
		
		// Stone Recipes
		MUtil.removeRecipe(new ItemStack(Blocks.stonebrick, 4, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.sandstone, 4, 2));
		MUtil.removeRecipe(new ItemStack(Blocks.sandstone, 1, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 3));
		MUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 4));
		MUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 5));
		MUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 6));
		MUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 7));
		MUtil.removeRecipe(new ItemStack(Blocks.brick_block, 1, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.stone_stairs, 4, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.brick_stairs, 4, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.stone_brick_stairs, 4, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.nether_brick, 1, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.nether_brick_stairs, 4, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.nether_brick_fence, 6, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.sandstone_stairs, 4, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 0));
		MUtil.removeRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.quartz_block, 1, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.quartz_block, 2, 2));
		MUtil.removeRecipe(new ItemStack(Blocks.quartz_stairs, 4, 0));
		MUtil.removeRecipe(Blocks.stained_hardened_clay);
		
		// Wood Recipes
		MUtil.removeRecipe(new ItemStack(Blocks.fence, 2));
		MUtil.removeRecipe(new ItemStack(Blocks.fence_gate, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.jukebox, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.noteblock, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.bookshelf, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.wooden_slab, 6));
		MUtil.removeRecipe(new ItemStack(Items.boat, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.ladder, 3));
		MUtil.removeRecipe(new ItemStack(Items.wooden_door, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.trapdoor, 2));
		MUtil.removeRecipe(new ItemStack(Items.sign, 3));
		MUtil.removeRecipe(new ItemStack(Items.item_frame, 1));
		MUtil.removeRecipe(new ItemStack(Items.painting, 1));
		MUtil.removeRecipe(new ItemStack(Blocks.oak_stairs, 4));
		MUtil.removeRecipe(new ItemStack(Blocks.birch_stairs, 4));
		MUtil.removeRecipe(new ItemStack(Blocks.spruce_stairs, 4));
		MUtil.removeRecipe(new ItemStack(Blocks.jungle_stairs, 4));
		MUtil.removeRecipe(new ItemStack(Blocks.acacia_stairs, 4));
		MUtil.removeRecipe(new ItemStack(Blocks.dark_oak_stairs, 4));
		MUtil.removeRecipe(new ItemStack(Items.bed, 1));
		
		MUtil.removeRecipe(new ItemStack(Items.flint_and_steel, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.flint_and_steel), new Object[] { MItems.steelIngot, Items.flint });
	}
}
