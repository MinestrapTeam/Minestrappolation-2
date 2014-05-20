package com.minestrappolation.lib;

import com.minestrappolation_core.lib.MCItems;
import com.minestrappolation_core.util.MCUtil;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MRecipes
{
	public static void load()
	{
		GameRegistry.addSmelting(MBlocks.blaziumOre, new ItemStack(Items.blaze_powder, 3), 1.0F);
		
		GameRegistry.addSmelting(MBlocks.meuroditeOre, new ItemStack(MItems.meuroditeIngot, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(MItems.meuroditeSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), MItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.meuroditeShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), MItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.meuroditeAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), MItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.meuroditePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), MItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.meuroditeHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), MItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.meuroditeHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), MItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.meuroditeChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.meuroditePants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), MItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.meuroditeBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), MItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(MBlocks.meuroditeBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.meuroditeIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.meuroditeIngot, 9), new Object[] { MBlocks.meuroditeBlock, });
		
		GameRegistry.addSmelting(MBlocks.titaniumOre, new ItemStack(MItems.TitaniumIngot, 1), 2.0F);
		
		GameRegistry.addRecipe(new ItemStack(MItems.TitaniumSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), MItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.TitaniumShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), MItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.TitaniumAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), MItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.TitaniumPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), MItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.TitaniumHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), MItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.TitaniumHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), MItems.TitaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.TitaniumChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.TitaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.TitaniumPants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), MItems.TitaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.TitaniumBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), MItems.TitaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(MBlocks.titaniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.TitaniumIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.TitaniumIngot, 9), new Object[] { MBlocks.titaniumBlock, });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.sunstoneBlock, 1), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), MItems.SunstoneDust, });
		
		GameRegistry.addSmelting(MBlocks.sunstoneOre, new ItemStack(MItems.SunstoneDust, 4), 1.0F);
		
		GameRegistry.addSmelting(MBlocks.toriteOre, new ItemStack(MItems.ToriteIngot, 1), 1.1F);
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.toriteBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.ToriteIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.ToriteSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), MItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.ToriteShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), MItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.ToriteAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), MItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.ToritePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), MItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.ToriteHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), MItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.ToriteHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), MItems.ToriteIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.ToriteChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.ToriteIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.ToritePants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), MItems.ToriteIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.ToriteBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), MItems.ToriteIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.ToriteIngot, 9), new Object[] { MBlocks.toriteBlock, });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.blaziumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.BlaziumIngot, });
		
		GameRegistry.addSmelting(Items.blaze_powder, new ItemStack(MItems.BlazeShard, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumIngot, 1), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), MItems.BlazeShard, });
		
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), MItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), MItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), MItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), MItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), MItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), MItems.BlaziumIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.BlaziumIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumPants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), MItems.BlaziumIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.BlaziumBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), MItems.BlaziumIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.BlaziumIngot, 9), new Object[] { MBlocks.blaziumBlock, });
		
		GameRegistry.addSmelting(MBlocks.copperOre, new ItemStack(MItems.CopperIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.copperBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.CopperIngot });
		
		GameRegistry.addRecipe(new ItemStack(MItems.CopperSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), MItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.CopperShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), MItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.CopperAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), MItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.CopperPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), MItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.CopperHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), MItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.CopperIngot, 9), new Object[] { MBlocks.copperBlock, });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.tinBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.TinIngot, });
		GameRegistry.addSmelting(MBlocks.tinOre, new ItemStack(MItems.TinIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(MItems.TinHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), MItems.TinIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.TinChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.TinIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.TinPants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), MItems.TinIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.TinBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), MItems.TinIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.TinIngot, 9), new Object[] { MBlocks.tinBlock, });
		
		GameRegistry.addRecipe(new ItemStack(MItems.plateTinItem, 4), new Object[] { "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.TinIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.plateBronzeItem, 1), new Object[] { "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.BronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.plateSteelItem, 1), new Object[] { "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.SteelIngot, });
		
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.CoalIronIngot, 1), new Object[] { Items.iron_ingot, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal });
		
		GameRegistry.addSmelting(MItems.CoalIronIngot, new ItemStack(MItems.SteelIngot, 1), 0.7F);
		
		GameRegistry.addRecipe(new ItemStack(MItems.SteelPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), MItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.SteelShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), MItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.SteelAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), MItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.SteelHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), MItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.SteelSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), MItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.SteelHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), MItems.SteelIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.SteelChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.SteelIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.SteelPants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), MItems.SteelIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.SteelBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), MItems.SteelIngot, });
		GameRegistry.addRecipe(new ItemStack(MBlocks.steelBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.SteelIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.SteelIngot, 9), new Object[] { MBlocks.steelBlock, });
		
		GameRegistry.addRecipe(new ItemStack(MItems.SandstonePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.SandstoneShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.SandstoneAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.SandstoneHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.SandstoneSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.BronzeIngot, 1), new Object[] { Items.iron_ingot, MItems.CopperIngot, MItems.CopperIngot, MItems.TinIngot, MItems.TinIngot });
		GameRegistry.addRecipe(new ItemStack(MItems.BronzePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), MItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.BronzeShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), MItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.BronzeAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), MItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.BronzeHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), MItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.BronzeSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), MItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.BronzeHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), MItems.BronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.BronzeChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.BronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.BronzePants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), MItems.BronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.BronzeBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), MItems.BronzeIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.BronzeIngot, 9), new Object[] { MBlocks.bronzeBlock, });
		GameRegistry.addRecipe(new ItemStack(MBlocks.bronzeBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.BronzeIngot });
		
		GameRegistry.addRecipe(new ItemStack(MItems.BedrockPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.BedrockShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.BedrockAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.BedrockHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		
		// GameRegistry.addRecipe(new ItemStack(MItems.GranitePickaxe, 1), new
		// Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'),
		// MBlocks.Granite, Character.valueOf('S'), Items.stick });
		// GameRegistry.addRecipe(new ItemStack(MItems.GraniteShovel, 1), new
		// Object[] { " Z ", " S ", " S ", Character.valueOf('Z'),
		// MBlocks.Granite, Character.valueOf('S'), Items.stick });
		// GameRegistry.addRecipe(new ItemStack(MItems.GraniteAxe, 1), new
		// Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'),
		// MBlocks.Granite, Character.valueOf('S'), Items.stick });
		// GameRegistry.addRecipe(new ItemStack(MItems.GraniteHoe, 1), new
		// Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'),
		// MBlocks.Granite, Character.valueOf('S'), Items.stick });
		// GameRegistry.addRecipe(new ItemStack(MItems.GraniteSword, 1), new
		// Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'),
		// MBlocks.Granite, Character.valueOf('S'), Items.stick });
		
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.Uranium, 9), new Object[] { MBlocks.uraniumBlock, });
		GameRegistry.addRecipe(new ItemStack(MBlocks.uraniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.Uranium });
		GameRegistry.addSmelting(MBlocks.uraniumOre, new ItemStack(MItems.Uranium, 2), 0.15F);
		GameRegistry.addSmelting(MBlocks.plutoniumOre, new ItemStack(MItems.Plutonium, 2), 0.15F);
		
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.Plutonium, 9), new Object[] { MBlocks.plutoniumBlock, });
		GameRegistry.addRecipe(new ItemStack(MBlocks.plutoniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), MItems.Plutonium });
		
		GameRegistry.addRecipe(new ItemStack(MItems.grenade, 1), new Object[] { "SUS", "PGP", "SUS", Character.valueOf('P'), MItems.Plutonium, Character.valueOf('S'), MItems.plateSteelItem, Character.valueOf('U'), MItems.Uranium, Character.valueOf('G'), Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(MBlocks.nuke, 1), new Object[] { "UPU", "PUP", "UPU", Character.valueOf('P'), MBlocks.plutoniumBlock, Character.valueOf('U'), MBlocks.uraniumBlock });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.plutoniumInsulated, 1), new Object[] { "SSS", "GPG", "SSS", Character.valueOf('S'), MItems.SteelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), MBlocks.plutoniumBlock });
		GameRegistry.addRecipe(new ItemStack(MBlocks.uraniumInsulated, 1), new Object[] { "SSS", "GPG", "SSS", Character.valueOf('S'), MItems.SteelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), MBlocks.uraniumBlock });
		GameRegistry.addRecipe(new ItemStack(MBlocks.melterIdle, 1), new Object[] { "ZZZ", "ZFZ", "ZBZ", Character.valueOf('Z'), MItems.plateMeuroditeItem, Character.valueOf('F'), Blocks.furnace, Character.valueOf('B'), MBlocks.blaziumBlock });
		
		GameRegistry.addRecipe(new ItemStack(MItems.plateMeuroditeItem, 4), new Object[] { "MMM", "MMM", Character.valueOf('M'), MItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(MItems.soulBottle, 4), new Object[] { "S", "G", Character.valueOf('S'), MItems.soulGem, Character.valueOf('G'), Items.glass_bottle });
		GameRegistry.addRecipe(new ItemStack(MBlocks.soulBlock, 1), new Object[] { "MMM", "MMM", "MMM", Character.valueOf('M'), MItems.soulGem, });
		GameRegistry.addRecipe(new ItemStack(MItems.soulGem, 9), new Object[] { "M", Character.valueOf('M'), MBlocks.soulBlock, });
		GameRegistry.addSmelting(MBlocks.radiantQuartzOre, new ItemStack(MItems.radiantQuartz, 1), 0.8F);
		GameRegistry.addSmelting(MBlocks.soulOre, new ItemStack(MItems.soulGem, 1), 0.8F);
		
		GameRegistry.addSmelting(Blocks.glowstone, new ItemStack(MBlocks.glowGlass), 0.5F);
		
		loadPlatedRecipes();
		
		// TODO ED RECIPES
		GameRegistry.addRecipe(new ItemStack(MItems.goblet, 1), new Object[] { "D D", " D ", Character.valueOf('D'), Items.gold_ingot });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.infertileDirt, 8), new Object[] { "DDD", "DBD", "DDD", Character.valueOf('D'), Blocks.dirt, Character.valueOf('B'), Items.bucket.setContainerItem(Items.water_bucket) });
		
		GameRegistry.addRecipe(new ItemStack(Blocks.dirt, 8), new Object[] { "DDD", "DBD", "DDD", Character.valueOf('D'), MBlocks.infertileDirt, Character.valueOf('B'), Items.water_bucket.setContainerItem(Items.bucket) });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.edgeStoneBrick), new Object[] { "SQ", "SQ", 'S', MCItems.brickStone, 'Q', Items.quartz });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.snowBrick, 4), new Object[] { "SS", "SS", Character.valueOf('S'), Blocks.snow });
		GameRegistry.addSmelting(Blocks.glass, new ItemStack(MBlocks.glassRefined), 20);
		GameRegistry.addRecipe(new ItemStack(MBlocks.glassRefinedPane, 16), new Object[] { "SSS", "SSS", Character.valueOf('S'), MBlocks.glassRefined });
		GameRegistry.addRecipe(new ItemStack(MBlocks.gunpowderBlock, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 9), new Object[] { "S", Character.valueOf('S'), MBlocks.gunpowderBlock });
		GameRegistry.addRecipe(new ItemStack(MItems.ropeItem, 1), new Object[] { "S", "S", "S", Character.valueOf('S'), Items.string });
		GameRegistry.addRecipe(new ItemStack(MItems.ropeItem, 9), new Object[] { "S", Character.valueOf('S'), MBlocks.ropeCoil });
		GameRegistry.addRecipe(new ItemStack(MBlocks.ropeCoil, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), MItems.ropeItem });
		GameRegistry.addRecipe(new ItemStack(MBlocks.oozeSlime, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.slime_ball });
		GameRegistry.addRecipe(new ItemStack(Items.slime_ball, 9), new Object[] { "S", Character.valueOf('S'), MBlocks.oozeSlime });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodPanel, 9, 0), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodPanel, 9, 0), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(MBlocks.woodBoards, 1, 0) });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodPanel, 9, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodPanel, 9, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(MBlocks.woodBoards, 1, 1) });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodPanel, 9, 2), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodPanel, 9, 2), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(MBlocks.woodBoards, 1, 2) });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodPanel, 9, 3), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodPanel, 9, 3), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(MBlocks.woodBoards, 1, 3) });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBeveled, 4, 0), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(MBlocks.woodPanel, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBeveled, 4, 1), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(MBlocks.woodPanel, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBeveled, 4, 2), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(MBlocks.woodPanel, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBeveled, 4, 3), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(MBlocks.woodPanel, 1, 3) });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoards, 16, 0), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoards, 16, 1), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoards, 16, 2), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoards, 16, 3), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.sugarBlock), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.sugar });
		GameRegistry.addRecipe(new ItemStack(Items.sugar, 9), new Object[] { "S", Character.valueOf('S'), MBlocks.sugarBlock });
		GameRegistry.addRecipe(new ItemStack(MBlocks.magmaOoze), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.magma_cream });
		GameRegistry.addRecipe(new ItemStack(Items.magma_cream, 9), new Object[] { "S", Character.valueOf('S'), MBlocks.magmaOoze });
		GameRegistry.addRecipe(new ItemStack(MBlocks.enderBlock), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.ender_pearl });
		GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] { "S", Character.valueOf('S'), MBlocks.enderBlock });
		GameRegistry.addRecipe(new ItemStack(MBlocks.barrel), new Object[] { "I", "C", "I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('C'), MBlocks.crate });
		GameRegistry.addRecipe(new ItemStack(MItems.cardboardItem, 3), new Object[] { "SSS", "SSS", Character.valueOf('S'), Items.paper });
		GameRegistry.addRecipe(new ItemStack(MBlocks.cardboardBlock, 2), new Object[] { "CCC", " C ", " CC", Character.valueOf('C'), MItems.cardboardItem });
		GameRegistry.addSmelting(Blocks.sandstone, new ItemStack(MItems.sandstoneBrick, 4), 0.8F);
		
		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 2, 3), new Object[] { "BBB", "BBB", "BBB", Character.valueOf('B'), MCItems.brickStone });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoardsSingleSlab, 6, 0), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(MBlocks.woodBoards, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoardsSingleSlab, 6, 1), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(MBlocks.woodBoards, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoardsSingleSlab, 6, 2), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(MBlocks.woodBoards, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoardsSingleSlab, 6, 3), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(MBlocks.woodBoards, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoardsStairsOak, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(MBlocks.woodBoards, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoardsStairsBirch, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(MBlocks.woodBoards, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoardsStairsSpruce, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(MBlocks.woodBoards, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.woodBoardsStairsJungle, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(MBlocks.woodBoards, 1, 3) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] { MBlocks.enderBlock });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.cobbledRoad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('D'), Blocks.dirt });
		GameRegistry.addRecipe(new ItemStack(MBlocks.sandstoneRoad, 2), new Object[] { "CCC", "CCC", "DDD", Character.valueOf('C'), MItems.sandstoneBrick, Character.valueOf('D'), Blocks.sand });
		GameRegistry.addRecipe(new ItemStack(MBlocks.sandyRoad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('D'), Blocks.sand });
		GameRegistry.addRecipe(new ItemStack(MBlocks.gravelRoad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('D'), Blocks.gravel });
		GameRegistry.addRecipe(new ItemStack(MBlocks.netherroad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.netherrack, Character.valueOf('D'), Blocks.soul_sand });
		
		// TODO EMD RECIPES
		GameRegistry.addSmelting(MItems.fat, new ItemStack(MItems.grease, 1), 0.7F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.friedApple, 2), new Object[] { MItems.fat, Items.apple, MItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.friedBeef, 2), new Object[] { MItems.fat, Items.beef, MItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.friedBread, 2), new Object[] { MItems.fat, Items.bread, MItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.friedCarrot, 2), new Object[] { MItems.fat, Items.carrot, MItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.friedCookie, 2), new Object[] { MItems.fat, Items.cookie, MItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.friedFlesh, 2), new Object[] { MItems.fat, Items.rotten_flesh, MItems.fat });
		GameRegistry.addRecipe(new ItemStack(Items.dye, 1, 16), new Object[] { "AA", "AA", 'A', MItems.animalBones });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.hornSwordWood), new Object[] { MItems.horn, MItems.horn, Items.wooden_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.hornSwordStone), new Object[] { MItems.horn, MItems.horn, Items.stone_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.hornSwordIron), new Object[] { MItems.horn, MItems.horn, Items.iron_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.hornSwordDiamond), new Object[] { MItems.horn, MItems.horn, Items.diamond_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.hornSwordGold), new Object[] { MItems.horn, MItems.horn, Items.golden_sword });
		GameRegistry.addSmelting(MItems.chickenWingRaw, new ItemStack(MItems.chickenWingCooked, 1), 0.7F);
		GameRegistry.addSmelting(MItems.lambchopRaw, new ItemStack(MItems.lambchopCooked, 1), 0.7F);
		GameRegistry.addSmelting(MItems.squidTentacle, new ItemStack(MItems.calimari, 1), 0.7F);
		GameRegistry.addRecipe(new ItemStack(Items.string), new Object[] { "WW", "WW", 'W', MItems.whisker });
		GameRegistry.addRecipe(new ItemStack(MItems.charms, 1, 0), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', MItems.pigHoof });
		GameRegistry.addRecipe(new ItemStack(MItems.charms, 1, 1), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', MItems.cowHoof });
		GameRegistry.addRecipe(new ItemStack(MItems.charms, 1, 2), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', MItems.footChicken });
		GameRegistry.addRecipe(new ItemStack(MItems.charms, 1, 3), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', MItems.sheepHoof });
		GameRegistry.addRecipe(new ItemStack(MItems.charms, 1, 4), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', MItems.horseHoof });
		GameRegistry.addSmelting(MItems.rawHorseHaunch, new ItemStack(MItems.cookedHorseHaunch), 0.8F);
		GameRegistry.addRecipe(new ItemStack(MItems.wingSegment, 1, 0), new Object[] { "FSF", "SLS", "FSF", 'F', Items.feather, 'S', MItems.wingSinew, 'L', Items.leather });
		GameRegistry.addRecipe(new ItemStack(MItems.hangGlider, 1, 0), new Object[] { "PPP", "W W", "W W", 'P', Blocks.planks, 'W', MItems.wingSegment });
	}
	
	public static void loadPlatedRecipes()
	{
		ItemStack[] picks = new ItemStack[] { new ItemStack(MItems.meuroditePickaxe, 1), new ItemStack(MItems.ToritePickaxe, 1), new ItemStack(MItems.BlaziumPickaxe, 1), new ItemStack(MItems.TitaniumPickaxe, 1), new ItemStack(MItems.SteelPickaxe, 1), new ItemStack(MItems.SandstonePickaxe, 1), new ItemStack(MItems.CopperPickaxe, 1), new ItemStack(MItems.BedrockPickaxe, 1), new ItemStack(MItems.GranitePickaxe, 1) };
		ItemStack[] picksWithoutNBT = new ItemStack[] { new ItemStack(MItems.meuroditePickaxe, 1), new ItemStack(MItems.ToritePickaxe, 1), new ItemStack(MItems.BlaziumPickaxe, 1), new ItemStack(MItems.TitaniumPickaxe, 1), new ItemStack(MItems.SteelPickaxe, 1), new ItemStack(MItems.SandstonePickaxe, 1), new ItemStack(MItems.CopperPickaxe, 1), new ItemStack(MItems.BedrockPickaxe, 1), new ItemStack(MItems.GranitePickaxe, 1) };
		
		for (int i = 0; i < picks.length; i++)
		{
			picks[i].stackTagCompound = new NBTTagCompound();
			picks[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(picks[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), MItems.plateBronzeItem, Character.valueOf('I'), picksWithoutNBT[i] });
		}
		
		ItemStack[] axes = new ItemStack[] { new ItemStack(MItems.meuroditeAxe, 1), new ItemStack(MItems.ToriteAxe, 1), new ItemStack(MItems.BlaziumAxe, 1), new ItemStack(MItems.TitaniumAxe, 1), new ItemStack(MItems.SteelAxe, 1), new ItemStack(MItems.SandstoneAxe, 1), new ItemStack(MItems.CopperAxe, 1), new ItemStack(MItems.BedrockAxe, 1), new ItemStack(MItems.GraniteAxe, 1) };
		ItemStack[] axesWithoutNBT = new ItemStack[] { new ItemStack(MItems.meuroditeAxe, 1), new ItemStack(MItems.ToriteAxe, 1), new ItemStack(MItems.BlaziumAxe, 1), new ItemStack(MItems.TitaniumAxe, 1), new ItemStack(MItems.SteelAxe, 1), new ItemStack(MItems.SandstoneAxe, 1), new ItemStack(MItems.CopperAxe, 1), new ItemStack(MItems.BedrockAxe, 1), new ItemStack(MItems.GraniteAxe, 1) };
		
		for (int i = 0; i < axes.length; i++)
		{
			axes[i].stackTagCompound = new NBTTagCompound();
			axes[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(axes[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), MItems.plateBronzeItem, Character.valueOf('I'), axesWithoutNBT[i] });
		}
		
		ItemStack[] hoes = new ItemStack[] { new ItemStack(MItems.meuroditeHoe, 1), new ItemStack(MItems.ToriteHoe, 1), new ItemStack(MItems.BlaziumHoe, 1), new ItemStack(MItems.TitaniumHoe, 1), new ItemStack(MItems.SteelHoe, 1), new ItemStack(MItems.SandstoneHoe, 1), new ItemStack(MItems.CopperHoe, 1), new ItemStack(MItems.BedrockHoe, 1), new ItemStack(MItems.GraniteHoe, 1) };
		ItemStack[] hoesWithoutNBT = new ItemStack[] { new ItemStack(MItems.meuroditeHoe, 1), new ItemStack(MItems.ToriteHoe, 1), new ItemStack(MItems.BlaziumHoe, 1), new ItemStack(MItems.TitaniumHoe, 1), new ItemStack(MItems.SteelHoe, 1), new ItemStack(MItems.SandstoneHoe, 1), new ItemStack(MItems.CopperHoe, 1), new ItemStack(MItems.BedrockHoe, 1), new ItemStack(MItems.GraniteHoe, 1) };
		
		for (int i = 0; i < hoes.length; i++)
		{
			hoes[i].stackTagCompound = new NBTTagCompound();
			hoes[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(hoes[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), MItems.plateBronzeItem, Character.valueOf('I'), hoesWithoutNBT[i] });
		}
		
		ItemStack[] shovels = new ItemStack[] { new ItemStack(MItems.meuroditeShovel, 1), new ItemStack(MItems.ToriteShovel, 1), new ItemStack(MItems.BlaziumShovel, 1), new ItemStack(MItems.TitaniumShovel, 1), new ItemStack(MItems.SteelShovel, 1), new ItemStack(MItems.SandstoneShovel, 1), new ItemStack(MItems.CopperShovel, 1), new ItemStack(MItems.BedrockShovel, 1), new ItemStack(MItems.GraniteShovel, 1) };
		ItemStack[] shovelsWithoutNBT = new ItemStack[] { new ItemStack(MItems.meuroditeShovel, 1), new ItemStack(MItems.ToriteShovel, 1), new ItemStack(MItems.BlaziumShovel, 1), new ItemStack(MItems.TitaniumShovel, 1), new ItemStack(MItems.SteelShovel, 1), new ItemStack(MItems.SandstoneShovel, 1), new ItemStack(MItems.CopperShovel, 1), new ItemStack(MItems.BedrockShovel, 1), new ItemStack(MItems.GraniteShovel, 1) };
		
		for (int i = 0; i < shovels.length; i++)
		{
			shovels[i].stackTagCompound = new NBTTagCompound();
			shovels[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(shovels[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), MItems.plateBronzeItem, Character.valueOf('I'), shovelsWithoutNBT[i] });
		}
		
		ItemStack[] swords = new ItemStack[] { new ItemStack(MItems.meuroditeSword, 1), new ItemStack(MItems.ToriteSword, 1), new ItemStack(MItems.BlaziumSword, 1), new ItemStack(MItems.TitaniumSword, 1), new ItemStack(MItems.SteelSword, 1), new ItemStack(MItems.SandstoneSword, 1), new ItemStack(MItems.CopperSword, 1), new ItemStack(MItems.GraniteSword, 1) };
		ItemStack[] swordsWithoutNBT = new ItemStack[] { new ItemStack(MItems.meuroditeSword, 1), new ItemStack(MItems.ToriteSword, 1), new ItemStack(MItems.BlaziumSword, 1), new ItemStack(MItems.TitaniumSword, 1), new ItemStack(MItems.SteelSword, 1), new ItemStack(MItems.SandstoneSword, 1), new ItemStack(MItems.CopperSword, 1), new ItemStack(MItems.GraniteSword, 1) };
		
		for (int i = 0; i < swords.length; i++)
		{
			swords[i].stackTagCompound = new NBTTagCompound();
			swords[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(swords[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), MItems.plateBronzeItem, Character.valueOf('I'), swordsWithoutNBT[i] });
		}
		
	}
	
	public static void removeRecipes()
	{
		MCUtil.removeRecipe(new ItemStack(Blocks.stonebrick, 4, 0));
	}
}
