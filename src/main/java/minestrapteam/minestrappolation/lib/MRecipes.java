package minestrapteam.minestrappolation.lib;

import static minestrapteam.minestrappolation.lib.MBlocks.*;
import static minestrapteam.minestrappolation.lib.MItems.*;
import static minestrapteam.minestrappolation.lib.MTools.*;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrap_core.crafting.RecipesPlatings;
import minestrapteam.minestrap_core.lib.MCBlocks;
import minestrapteam.minestrap_core.lib.MCItems;
import minestrapteam.minestrap_core.util.MCUtil;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MRecipes
{
	public static void load()
	{
		GameRegistry.addRecipe(new RecipesPlatings());
		
		GameRegistry.addSmelting(MBlocks.blaziumOre, new ItemStack(Items.blaze_powder, 3), 1.0F);
		
		GameRegistry.addSmelting(MBlocks.meuroditeOre, new ItemStack(MItems.meuroditeGem, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(meuroditeSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), meuroditeGem, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditeShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), meuroditeGem, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditeAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), meuroditeGem, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), meuroditeGem, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditeHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), meuroditeGem, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(meuroditeHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), meuroditeGem, });
		GameRegistry.addRecipe(new ItemStack(meuroditeChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), meuroditeGem, });
		GameRegistry.addRecipe(new ItemStack(meuroditeLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), meuroditeGem, });
		GameRegistry.addRecipe(new ItemStack(meuroditeBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), meuroditeGem, });
		GameRegistry.addRecipe(new ItemStack(meuroditeBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), meuroditeGem, });
		GameRegistry.addShapelessRecipe(new ItemStack(meuroditeGem, 9), new Object[] { meuroditeBlock, });
		
		GameRegistry.addSmelting(titaniumOre, new ItemStack(titaniumIngot, 1), 2.0F);
		
		GameRegistry.addRecipe(new ItemStack(titaniumSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), titaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), titaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), titaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), titaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), titaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(titaniumHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), titaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(titaniumChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), titaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(titaniumLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), titaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(titaniumBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), titaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(titaniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), titaniumIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(titaniumIngot, 9), new Object[] { titaniumBlock, });
		
		GameRegistry.addRecipe(new ItemStack(sunstoneBlock, 1), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), sunstoneDust, });
		
		GameRegistry.addSmelting(sunstoneOre, new ItemStack(sunstoneDust, 4), 1.0F);
		
		GameRegistry.addSmelting(toriteOre, new ItemStack(toriteIngot, 1), 1.1F);
		
		GameRegistry.addRecipe(new ItemStack(toriteBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), toriteIngot, });
		GameRegistry.addRecipe(new ItemStack(toriteSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), toriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(toriteShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), toriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(toriteAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), toriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(toritePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), toriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(toriteHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), toriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(toriteHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), toriteIngot, });
		GameRegistry.addRecipe(new ItemStack(toriteChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), toriteIngot, });
		GameRegistry.addRecipe(new ItemStack(toriteLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), toriteIngot, });
		GameRegistry.addRecipe(new ItemStack(toriteBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), toriteIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(toriteIngot, 9), new Object[] { toriteBlock, });
		
		GameRegistry.addRecipe(new ItemStack(blaziumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), blaziumIngot, });
		
		GameRegistry.addSmelting(Items.blaze_powder, new ItemStack(blazeShard, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(blaziumIngot, 1), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), blazeShard, });
		
		GameRegistry.addRecipe(new ItemStack(blaziumSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), blaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), blaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), blaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), blaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), blaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blaziumHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), blaziumIngot, });
		GameRegistry.addRecipe(new ItemStack(blaziumChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), blaziumIngot, });
		GameRegistry.addRecipe(new ItemStack(blaziumLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), blaziumIngot, });
		GameRegistry.addRecipe(new ItemStack(blaziumBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), blaziumIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(blaziumIngot, 9), new Object[] { blaziumBlock, });
		
		GameRegistry.addSmelting(copperOre, new ItemStack(copperIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(copperBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), copperIngot });
		
		GameRegistry.addRecipe(new ItemStack(copperSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), copperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(copperShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), copperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(copperAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), copperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(copperPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), copperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(copperHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), copperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addShapelessRecipe(new ItemStack(copperIngot, 9), new Object[] { copperBlock, });
		
		GameRegistry.addRecipe(new ItemStack(tinBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), tinIngot, });
		GameRegistry.addSmelting(tinOre, new ItemStack(tinIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(tinHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), tinIngot, });
		GameRegistry.addRecipe(new ItemStack(tinChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), tinIngot, });
		GameRegistry.addRecipe(new ItemStack(tinLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), tinIngot, });
		GameRegistry.addRecipe(new ItemStack(tinBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), tinIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(tinIngot, 9), new Object[] { tinBlock, });
		
		GameRegistry.addRecipe(new ItemStack(plateTinItem, 4), new Object[] { "ZZZ", "ZZZ", Character.valueOf('Z'), tinIngot, });
		GameRegistry.addRecipe(new ItemStack(plateBronzeItem, 1), new Object[] { "ZZZ", "ZZZ", Character.valueOf('Z'), bronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(plateSteelItem, 1), new Object[] { "ZZZ", "ZZZ", Character.valueOf('Z'), steelIngot, });
		
		GameRegistry.addShapelessRecipe(new ItemStack(coalIronIngot, 1), new Object[] { Items.iron_ingot, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal });
		
		GameRegistry.addSmelting(coalIronIngot, new ItemStack(steelIngot, 1), 0.7F);
		
		GameRegistry.addRecipe(new ItemStack(steelPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), steelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), steelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), steelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), steelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), steelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(steelHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), steelIngot, });
		GameRegistry.addRecipe(new ItemStack(steelChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), steelIngot, });
		GameRegistry.addRecipe(new ItemStack(steelLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), steelIngot, });
		GameRegistry.addRecipe(new ItemStack(steelBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), steelIngot, });
		GameRegistry.addRecipe(new ItemStack(steelBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), steelIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(steelIngot, 9), new Object[] { steelBlock, });
		
		GameRegistry.addShapelessRecipe(new ItemStack(bronzeIngot, 1), new Object[] { Items.iron_ingot, copperIngot, copperIngot, tinIngot, tinIngot });
		GameRegistry.addRecipe(new ItemStack(bronzePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), bronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzeShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), bronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzeAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), bronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzeHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), bronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzeSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), bronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(bronzeHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), bronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(bronzeChestplate, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), bronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(bronzeLeggings, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), bronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(bronzeBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), bronzeIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(bronzeIngot, 9), new Object[] { bronzeBlock, });
		GameRegistry.addRecipe(new ItemStack(bronzeBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), bronzeIngot });
		
		GameRegistry.addRecipe(new ItemStack(bedrockPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(bedrockShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(bedrockAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(bedrockHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		
		// GameRegistry.addRecipe(new ItemStack(GranitePickaxe, 1), new
		// Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'),
		// Granite, Character.valueOf('S'), Items.stick });
		// GameRegistry.addRecipe(new ItemStack(GraniteShovel, 1), new
		// Object[] { " Z ", " S ", " S ", Character.valueOf('Z'),
		// Granite, Character.valueOf('S'), Items.stick });
		// GameRegistry.addRecipe(new ItemStack(GraniteAxe, 1), new
		// Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'),
		// Granite, Character.valueOf('S'), Items.stick });
		// GameRegistry.addRecipe(new ItemStack(GraniteHoe, 1), new
		// Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'),
		// Granite, Character.valueOf('S'), Items.stick });
		// GameRegistry.addRecipe(new ItemStack(GraniteSword, 1), new
		// Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'),
		// Granite, Character.valueOf('S'), Items.stick });
		
		GameRegistry.addShapelessRecipe(new ItemStack(uranium, 9), new Object[] { uraniumBlock, });
		GameRegistry.addRecipe(new ItemStack(uraniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), uranium });
		GameRegistry.addSmelting(uraniumOre, new ItemStack(uranium, 2), 0.15F);
		GameRegistry.addSmelting(plutoniumOre, new ItemStack(plutonium, 2), 0.15F);
		
		GameRegistry.addShapelessRecipe(new ItemStack(plutonium, 9), new Object[] { plutoniumBlock, });
		GameRegistry.addRecipe(new ItemStack(plutoniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), plutonium });
		
		GameRegistry.addRecipe(new ItemStack(grenade, 1), new Object[] { "SUS", "PGP", "SUS", Character.valueOf('P'), plutonium, Character.valueOf('S'), plateSteelItem, Character.valueOf('U'), uranium, Character.valueOf('G'), Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(nuke, 1), new Object[] { "UPU", "PUP", "UPU", Character.valueOf('P'), plutoniumBlock, Character.valueOf('U'), uraniumBlock });
		
		GameRegistry.addRecipe(new ItemStack(plutoniumInsulated, 1), new Object[] { "SSS", "GPG", "SSS", Character.valueOf('S'), steelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), plutoniumBlock });
		GameRegistry.addRecipe(new ItemStack(uraniumInsulated, 1), new Object[] { "SSS", "GPG", "SSS", Character.valueOf('S'), steelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), uraniumBlock });
		GameRegistry.addRecipe(new ItemStack(melterIdle, 1), new Object[] { "ZZZ", "ZFZ", "ZBZ", Character.valueOf('Z'), plateMeuroditeItem, Character.valueOf('F'), Blocks.furnace, Character.valueOf('B'), blaziumBlock });
		
		GameRegistry.addRecipe(new ItemStack(plateMeuroditeItem, 4), new Object[] { "MMM", "MMM", Character.valueOf('M'), meuroditeGem, });
		GameRegistry.addRecipe(new ItemStack(soulBottle, 4), new Object[] { "S", "G", Character.valueOf('S'), soulGem, Character.valueOf('G'), Items.glass_bottle });
		GameRegistry.addRecipe(new ItemStack(soulBlock, 1), new Object[] { "MMM", "MMM", "MMM", Character.valueOf('M'), soulGem, });
		GameRegistry.addRecipe(new ItemStack(soulGem, 9), new Object[] { "M", Character.valueOf('M'), soulBlock, });
		GameRegistry.addSmelting(radiantQuartzOre, new ItemStack(radiantQuartz, 1), 0.8F);
		GameRegistry.addSmelting(soulOre, new ItemStack(soulGem, 1), 0.8F);
		
		GameRegistry.addSmelting(Blocks.glowstone, new ItemStack(glowGlass), 0.5F);
		
		// TODO ED RECIPES
		GameRegistry.addRecipe(new ItemStack(MItems.goblet, 1), new Object[] { "D D", " D ", Character.valueOf('D'), Items.gold_ingot });
		
		GameRegistry.addRecipe(new ItemStack(edgeStoneBrick, 1, 0), new Object[] { "SQ", "SQ", 'S', MCItems.brickStone, 'Q', Items.quartz });
		GameRegistry.addRecipe(new ItemStack(edgeStoneBrick, 1, 1), new Object[] { "SQ", "SQ", 'S', MCItems.brickStone, 'Q', Items.flint });
		
		GameRegistry.addRecipe(new ItemStack(snowBrick, 4), new Object[] { "SS", "SS", Character.valueOf('S'), Blocks.snow });
		GameRegistry.addSmelting(Blocks.glass, new ItemStack(refinedGlass), 20);
		GameRegistry.addRecipe(new ItemStack(refinedGlassPane, 16), new Object[] { "SSS", "SSS", Character.valueOf('S'), refinedGlass });
		GameRegistry.addRecipe(new ItemStack(gunpowderBlock, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 9), new Object[] { "S", Character.valueOf('S'), gunpowderBlock });
		GameRegistry.addRecipe(new ItemStack(ropeItem, 1), new Object[] { "S", "S", "S", Character.valueOf('S'), Items.string });
		GameRegistry.addRecipe(new ItemStack(ropeItem, 9), new Object[] { "S", Character.valueOf('S'), ropeCoil });
		GameRegistry.addRecipe(new ItemStack(ropeCoil, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), ropeItem });
		GameRegistry.addRecipe(new ItemStack(slimeOoze, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.slime_ball });
		GameRegistry.addRecipe(new ItemStack(Items.slime_ball, 9), new Object[] { "S", Character.valueOf('S'), slimeOoze });
		
		GameRegistry.addRecipe(new ItemStack(sugarBlock), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.sugar });
		GameRegistry.addRecipe(new ItemStack(Items.sugar, 9), new Object[] { "S", Character.valueOf('S'), sugarBlock });
		GameRegistry.addRecipe(new ItemStack(magmaOoze), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.magma_cream });
		GameRegistry.addRecipe(new ItemStack(Items.magma_cream, 9), new Object[] { "S", Character.valueOf('S'), magmaOoze });
		GameRegistry.addRecipe(new ItemStack(enderBlock), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.ender_pearl });
		GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] { "S", Character.valueOf('S'), enderBlock });
		GameRegistry.addRecipe(new ItemStack(barrel), new Object[] { "I", "C", "I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('C'), crate });
		GameRegistry.addRecipe(new ItemStack(cardboardItem, 3), new Object[] { "SSS", "SSS", Character.valueOf('S'), Items.paper });
		GameRegistry.addRecipe(new ItemStack(cardboardBlock, 2), new Object[] { "CCC", " C ", " CC", Character.valueOf('C'), cardboardItem });
		GameRegistry.addRecipe(new ItemStack(MCBlocks.redSandstone, 1, 0), new Object[] { "SS", "SS", Character.valueOf('S'), (new ItemStack(Blocks.sand, 1, 1))});
		
		// GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 2, 3), new
		// Object[] { "BBB", "BBB", "BBB", Character.valueOf('B'),
		// MCItems.brickStone });
		
		// TODO EMD RECIPES
		GameRegistry.addSmelting(fat, new ItemStack(grease, 1), 0.7F);
		GameRegistry.addShapelessRecipe(new ItemStack(friedApple, 2), new Object[] { fat, Items.apple, fat });
		GameRegistry.addShapelessRecipe(new ItemStack(friedBeef, 2), new Object[] { fat, Items.beef, fat });
		GameRegistry.addShapelessRecipe(new ItemStack(friedBread, 2), new Object[] { fat, Items.bread, fat });
		GameRegistry.addShapelessRecipe(new ItemStack(friedCarrot, 2), new Object[] { fat, Items.carrot, fat });
		GameRegistry.addShapelessRecipe(new ItemStack(friedCookie, 2), new Object[] { fat, Items.cookie, fat });
		GameRegistry.addShapelessRecipe(new ItemStack(friedFlesh, 2), new Object[] { fat, Items.rotten_flesh, fat });
		GameRegistry.addRecipe(new ItemStack(Items.dye, 1, 16), new Object[] { "AA", "AA", 'A', animalBones });
		GameRegistry.addSmelting(chickenWingRaw, new ItemStack(chickenWingCooked, 1), 0.7F);
		GameRegistry.addSmelting(lambchopRaw, new ItemStack(lambchopCooked, 1), 0.7F);
		GameRegistry.addSmelting(squidTentacle, new ItemStack(calimari, 1), 0.7F);
		GameRegistry.addRecipe(new ItemStack(Items.string), new Object[] { "WW", "WW", 'W', whisker });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 0), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', pigHoof });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 1), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', cowHoof });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 2), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', footChicken });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 3), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', sheepHoof });
		GameRegistry.addRecipe(new ItemStack(charms, 1, 4), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', horseHoof });
		GameRegistry.addSmelting(horseHaunchRaw, new ItemStack(horseHaunchCooked), 0.8F);
		GameRegistry.addRecipe(new ItemStack(wingSegment, 1, 0), new Object[] { "FSF", "SLS", "FSF", 'F', Items.feather, 'S', wingSinew, 'L', Items.leather });
		GameRegistry.addRecipe(new ItemStack(hangGlider, 1, 0), new Object[] { "PPP", "W W", "W W", 'P', Blocks.planks, 'W', wingSegment });
	}
	
	public static void removeRecipes()
	{
		MCUtil.removeRecipe(new ItemStack(Blocks.stonebrick, 4, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.sandstone, 4, 2));
		MCUtil.removeRecipe(new ItemStack(Blocks.sandstone, 1, 1));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 1));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 2));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 3));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 4));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 5));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 6, 6));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_slab, 7, 6));
		MCUtil.removeRecipe(new ItemStack(Blocks.brick_block, 1, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_stairs, 4, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.brick_stairs, 4, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.stone_brick_stairs, 4, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.nether_brick_stairs, 4, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.sandstone_stairs, 4, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 1));
		MCUtil.removeRecipe(new ItemStack(Blocks.quartz_block, 1, 1));
		MCUtil.removeRecipe(new ItemStack(Blocks.quartz_block, 2, 2));
		MCUtil.removeRecipe(new ItemStack(Blocks.quartz_stairs, 4, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 0));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 1));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 2));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 3));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 4));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 5));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 6));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 7));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 8));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 9));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 10));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 11));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 12));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 13));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 14));
		MCUtil.removeRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 15));
	}
}
