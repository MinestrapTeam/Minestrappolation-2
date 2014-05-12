package sobiohazardous.mods.minestrappolation.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import sobiohazardous.mods.minestrappolation.core.util.MCUtil;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDItems;
import sobiohazardous.mods.minestrappolation.extramobdrops.lib.EMDItems;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class MRecipes
{
	public static void load()
	{
		GameRegistry.addSmelting(EOBlocks.BlaziumOre, new ItemStack(Items.blaze_powder, 3), 1.0F);
		
		GameRegistry.addSmelting(EOBlocks.meuroditeOre, new ItemStack(EOItems.meuroditeIngot, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), EOItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditePants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), EOItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.meuroditeBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.meuroditeIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.meuroditeIngot, 9), new Object[] { EOBlocks.meuroditeBlock, });
		
		GameRegistry.addSmelting(EOBlocks.TitaniumOre, new ItemStack(EOItems.TitaniumIngot, 1), 2.0F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), EOItems.TitaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.TitaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumPants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.TitaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), EOItems.TitaniumIngot, });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.TitaniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.TitaniumIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.TitaniumIngot, 9), new Object[] { EOBlocks.TitaniumBlock, });
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.Sunstone, 1), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), EOItems.SunstoneDust, });
		
		GameRegistry.addSmelting(EOBlocks.SunstoneOre, new ItemStack(EOItems.SunstoneDust, 4), 1.0F);
		
		GameRegistry.addSmelting(EOBlocks.ToriteOre, new ItemStack(EOItems.ToriteIngot, 1), 1.1F);
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.ToriteBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.ToriteIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), EOItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.ToritePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.ToriteIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), EOItems.ToriteIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.ToriteIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.ToritePants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.ToriteIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), EOItems.ToriteIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.ToriteIngot, 9), new Object[] { EOBlocks.ToriteBlock, });
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.GraniteBrick, 4), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), EOBlocks.Granite, });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.QuartziteTile, 4), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), EOBlocks.Quartzite, });
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.BlaziumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.BlaziumIngot, });
		
		GameRegistry.addSmelting(Items.blaze_powder, new ItemStack(EOItems.BlazeShard, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumIngot, 1), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), EOItems.BlazeShard, });
		
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), EOItems.BlaziumIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.BlaziumIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumPants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.BlaziumIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), EOItems.BlaziumIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.BlaziumIngot, 9), new Object[] { EOBlocks.BlaziumBlock, });
		
		GameRegistry.addSmelting(EOBlocks.CopperOre, new ItemStack(EOItems.CopperIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.CopperBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.CopperIngot });
		
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.CopperIngot, 9), new Object[] { EOBlocks.CopperBlock, });
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.TinBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.TinIngot, });
		GameRegistry.addSmelting(EOBlocks.TinOre, new ItemStack(EOItems.TinIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.TinHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), EOItems.TinIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.TinChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.TinIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.TinPants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.TinIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.TinBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), EOItems.TinIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.TinIngot, 9), new Object[] { EOBlocks.TinBlock, });
		
		GameRegistry.addRecipe(new ItemStack(EOItems.plateTinItem, 4), new Object[] { "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.TinIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.plateBronzeItem, 1), new Object[] { "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.BronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.plateSteelItem, 1), new Object[] { "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.SteelIngot, });
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.CoalIronIngot, 1), new Object[] { Items.iron_ingot, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal });
		
		GameRegistry.addSmelting(EOItems.CoalIronIngot, new ItemStack(EOItems.SteelIngot, 1), 0.7F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), EOItems.SteelIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.SteelIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelPants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.SteelIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), EOItems.SteelIngot, });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.SteelBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.SteelIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.SteelIngot, 9), new Object[] { EOBlocks.SteelBlock, });
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.SmoothQuartzite, 1), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), EOItems.PinkQuartz });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.PillarQuartzite, 2), new Object[] { "Z", "Z", Character.valueOf('Z'), EOBlocks.SmoothQuartzite });
		/*
		 * GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.ChiseledQuartzite, 1), new Object[] { "Z",
		 * "Z", Character.valueOf('Z'), EOBlockManager.PinkQuartzSingleSlab });
		 */
		GameRegistry.addRecipe(new ItemStack(EOBlocks.SmoothQuartzTile, 8), new Object[] { "ZZZ", "ZYZ", "ZZZ", Character.valueOf('Z'), EOBlocks.SmoothQuartzite, Character.valueOf('Y'), Blocks.stone });
		
		GameRegistry.addSmelting(EOBlocks.SmoothQuartzite, new ItemStack(EOBlocks.Quartzite, 1), 0.15F);
		
		GameRegistry.addSmelting(EOBlocks.ChiseledQuartzite, new ItemStack(EOBlocks.Quartzite, 1), 0.15F);
		
		GameRegistry.addSmelting(EOBlocks.PillarQuartzite, new ItemStack(EOBlocks.Quartzite, 1), 0.15F);
		
		GameRegistry.addSmelting(EOBlocks.QuartziteTile, new ItemStack(EOBlocks.Quartzite, 1), 0.15F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.SandstonePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.SandstoneShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.SandstoneAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.SandstoneHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.SandstoneSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick });
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedCobble, 8), new Object[] { Blocks.cobblestone, EOItems.plateTinItem, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedMossy, 8), new Object[] { Blocks.mossy_cobblestone, EOItems.plateTinItem, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedStoneBrick, 8), new Object[] { new ItemStack(Blocks.stonebrick, 1, 0), EOItems.plateTinItem, new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedChiseled, 8), new Object[] { new ItemStack(Blocks.stonebrick, 1, 3), EOItems.plateTinItem, new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedGranite, 8), new Object[] { EOBlocks.GraniteBrick, EOItems.plateTinItem, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, });
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.BronzeIngot, 1), new Object[] { Items.iron_ingot, EOItems.CopperIngot, EOItems.CopperIngot, EOItems.TinIngot, EOItems.TinIngot });
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzeShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzeAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzeHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzeSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzeHelmet, 1), new Object[] { "ZZZ", "Z Z", Character.valueOf('Z'), EOItems.BronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzeChest, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.BronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzePants, 1), new Object[] { "ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.BronzeIngot, });
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzeBoots, 1), new Object[] { "Z Z", "Z Z", Character.valueOf('Z'), EOItems.BronzeIngot, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.BronzeIngot, 9), new Object[] { EOBlocks.BronzeBlock, });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.BronzeBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.BronzeIngot });
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedCobble, 8), new Object[] { Blocks.cobblestone, EOItems.plateBronzeItem, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedMossy, 8), new Object[] { Blocks.mossy_cobblestone, EOItems.plateBronzeItem, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedStoneBrick, 8), new Object[] { new ItemStack(Blocks.stonebrick, 1, 0), EOItems.plateBronzeItem, new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedChiseled, 8), new Object[] { new ItemStack(Blocks.stonebrick, 1, 3), EOItems.plateBronzeItem, new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedGranite, 8), new Object[] { EOBlocks.GraniteBrick, EOItems.plateBronzeItem, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, });
		
		GameRegistry.addRecipe(new ItemStack(EOItems.BedrockPickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.BedrockShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.BedrockAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.BedrockHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick });
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedCobble, 8), new Object[] { Blocks.cobblestone, EOItems.plateSteelItem, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedMossy, 8), new Object[] { Blocks.mossy_cobblestone, EOItems.plateSteelItem, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, Blocks.mossy_cobblestone, });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedStoneBrick, 8), new Object[] { new ItemStack(Blocks.stonebrick, 1, 0), EOItems.plateSteelItem, new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedChiseled, 8), new Object[] { new ItemStack(Blocks.stonebrick, 1, 3), EOItems.plateSteelItem, new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stonebrick, 1, 3), });
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedGranite, 8), new Object[] { EOBlocks.GraniteBrick, EOItems.plateSteelItem, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, EOBlocks.GraniteBrick, });
		
		GameRegistry.addRecipe(new ItemStack(EOItems.GranitePickaxe, 1), new Object[] { "ZZZ", " S ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.GraniteShovel, 1), new Object[] { " Z ", " S ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.GraniteAxe, 1), new Object[] { "ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.GraniteHoe, 1), new Object[] { "ZZ ", " S ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(EOItems.GraniteSword, 1), new Object[] { " Z ", " Z ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick });
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.Uranium, 9), new Object[] { EOBlocks.RawUraniumBlock, });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.RawUraniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.Uranium });
		GameRegistry.addSmelting(EOBlocks.UraniumOre, new ItemStack(EOItems.Uranium, 2), 0.15F);
		GameRegistry.addSmelting(EOBlocks.PlutoniumOre, new ItemStack(EOItems.Plutonium, 2), 0.15F);
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.Plutonium, 9), new Object[] { EOBlocks.RawPlutoniumBlock, });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.RawPlutoniumBlock, 1), new Object[] { "ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.Plutonium });
		
		GameRegistry.addRecipe(new ItemStack(EOItems.grenade, 1), new Object[] { "SUS", "PGP", "SUS", Character.valueOf('P'), EOItems.Plutonium, Character.valueOf('S'), EOItems.plateSteelItem, Character.valueOf('U'), EOItems.Uranium, Character.valueOf('G'), Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.nuke, 1), new Object[] { "UPU", "PUP", "UPU", Character.valueOf('P'), EOBlocks.RawPlutoniumBlock, Character.valueOf('U'), EOBlocks.RawUraniumBlock });
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.SmoothRadiantQuartz, 1), new Object[] { "ZZ", "ZZ", Character.valueOf('Z'), EOBlocks.RadiantQuartz });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.PillarRadiantQuartz, 2), new Object[] { "Z", "Z", Character.valueOf('Z'), EOBlocks.SmoothRadiantQuartz });
		/*
		 * GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.ChiseledRadiantQuartz, 1), new Object[] {
		 * "Z", "Z", Character.valueOf('Z'),
		 * EOBlockManager.RadiantQuartzSingleSlab });
		 * GameRegistry.addSmelting(EOBlockManager.SmoothRadiantQuartz, new
		 * ItemStack(EOBlockManager.RadiantQuartz, 1), 0.15F);
		 * GameRegistry.addRecipe(new ItemStack(EOBlockManager.Godstone, 1), new
		 * Object[] { "SSS", "SES", "SSS", Character.valueOf('S'),
		 * EOItemManager.SunstoneDust, Character.valueOf('E'), Blocks.end_stone
		 * }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.RadiantQuartzStairs, 4), new Object[] {
		 * "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.SmoothRadiantQuartz }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.RadiantQuartzSingleSlab, 6), new Object[] {
		 * "SSS", Character.valueOf('S'), EOBlockManager.SmoothRadiantQuartz });
		 * GameRegistry.addRecipe(new ItemStack(EOBlockManager.PinkQuartzStairs,
		 * 4), new Object[] { "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.SmoothQuartzite }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.PinkQuartzSingleSlab, 6), new Object[] {
		 * "SSS", Character.valueOf('S'), EOBlockManager.SmoothQuartzite });
		 * GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.graniteBrickStairs, 4), new Object[] {
		 * "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.GraniteBrick }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.graniteBrickSingleSlab, 6), new Object[] {
		 * "SSS", Character.valueOf('S'), EOBlockManager.GraniteBrick });
		 * GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.tinPlatedCobbleStairs, 4), new Object[] {
		 * "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.TinPlatedCobble }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.tinPlatedCobbleSingleSlab, 6), new Object[]
		 * { "SSS", Character.valueOf('S'), EOBlockManager.TinPlatedCobble });
		 * GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.steelPlatedCobbleStairs, 4), new Object[] {
		 * "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.SteelPlatedCobble }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.steelPlatedCobbleSingleSlab, 6), new
		 * Object[] { "SSS", Character.valueOf('S'),
		 * EOBlockManager.SteelPlatedCobble }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.bronzePlatedCobbleStairs, 4), new Object[] {
		 * "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.BronzePlatedCobble }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.bronzePlatedCobbleSingleSlab, 6), new
		 * Object[] { "SSS", Character.valueOf('S'),
		 * EOBlockManager.BronzePlatedCobble }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.tinPlatedStoneBrickStairs, 4), new Object[]
		 * { "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.TinPlatedStoneBrick }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.tinPlatedStoneBrickSingleSlab, 6), new
		 * Object[] { "SSS", Character.valueOf('S'),
		 * EOBlockManager.TinPlatedStoneBrick }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.steelPlatedStoneBrickStairs, 4), new
		 * Object[] { "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.SteelPlatedStoneBrick }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.steelPlatedStoneBrickSingleSlab, 6), new
		 * Object[] { "SSS", Character.valueOf('S'),
		 * EOBlockManager.SteelPlatedStoneBrick }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.bronzePlatedStoneBrickStairs, 4), new
		 * Object[] { "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.BronzePlatedStoneBrick }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.bronzePlatedStoneBrickSingleSlab, 6), new
		 * Object[] { "SSS", Character.valueOf('S'),
		 * EOBlockManager.BronzePlatedStoneBrick }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.tinPlatedGraniteBrickStairs, 4), new
		 * Object[] { "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.TinPlatedGranite }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.tinPlatedGraniteBrickSingleSlab, 6), new
		 * Object[] { "SSS", Character.valueOf('S'),
		 * EOBlockManager.TinPlatedGranite }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.steelPlatedGraniteBrickStairs, 4), new
		 * Object[] { "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.SteelPlatedGranite }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.steelPlatedGraniteBrickSingleSlab, 6), new
		 * Object[] { "SSS", Character.valueOf('S'),
		 * EOBlockManager.SteelPlatedGranite }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.bronzePlatedGraniteBrickStairs, 4), new
		 * Object[] { "  S", " SS", "SSS", Character.valueOf('S'),
		 * EOBlockManager.BronzePlatedGranite }); GameRegistry.addRecipe(new
		 * ItemStack(EOBlockManager.bronzePlatedGraniteBrickSingleSlab, 6), new
		 * Object[] { "SSS", Character.valueOf('S'),
		 * EOBlockManager.BronzePlatedGranite });
		 */
		GameRegistry.addRecipe(new ItemStack(EOBlocks.plutoniumInsulated, 1), new Object[] { "SSS", "GPG", "SSS", Character.valueOf('S'), EOItems.SteelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), EOBlocks.RawPlutoniumBlock });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.uraniumInsulated, 1), new Object[] { "SSS", "GPG", "SSS", Character.valueOf('S'), EOItems.SteelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), EOBlocks.RawUraniumBlock });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.melterIdle, 1), new Object[] { "ZZZ", "ZFZ", "ZBZ", Character.valueOf('Z'), EOItems.plateMeuroditeItem, Character.valueOf('F'), Blocks.furnace, Character.valueOf('B'), EOBlocks.BlaziumBlock });
		
		GameRegistry.addRecipe(new ItemStack(EOItems.plateMeuroditeItem, 4), new Object[] { "MMM", "MMM", Character.valueOf('M'), EOItems.meuroditeIngot, });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.SoulBottle, 4), new Object[] { "S", "G", Character.valueOf('S'), EOBlocks.SoulGem, Character.valueOf('G'), Items.glass_bottle });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.soulBlock, 1), new Object[] { "MMM", "MMM", "MMM", Character.valueOf('M'), EOBlocks.SoulGem, });
		GameRegistry.addRecipe(new ItemStack(EOBlocks.SoulGem, 9), new Object[] { "M", Character.valueOf('M'), EOBlocks.soulBlock, });
		GameRegistry.addSmelting(EOBlocks.RadiantQuartzOre, new ItemStack(EOBlocks.RadiantQuartz, 1), 0.8F);
		GameRegistry.addSmelting(EOBlocks.SoulOre, new ItemStack(EOBlocks.SoulGem, 1), 0.8F);
		
		GameRegistry.addSmelting(Blocks.glowstone, new ItemStack(EOBlocks.glowGlass), 0.5F);

		loadPlatedRecipes();
		
		//TODO ED RECIPES
		GameRegistry.addRecipe(new ItemStack(EDItems.goblet, 1), new Object[] { "D D", " D ", Character.valueOf('D'), Items.gold_ingot });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.infertileDirt, 8), new Object[] { "DDD", "DBD", "DDD", Character.valueOf('D'), Blocks.dirt, Character.valueOf('B'), Items.bucket.setContainerItem(Items.water_bucket) });
		
		GameRegistry.addRecipe(new ItemStack(Blocks.dirt, 8), new Object[] { "DDD", "DBD", "DDD", Character.valueOf('D'), EDBlocks.infertileDirt, Character.valueOf('B'), Items.water_bucket.setContainerItem(Items.bucket) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stones, 9, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Blocks.stone });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stonePillar, 2), new Object[] { "S", "S", Character.valueOf('S'), new ItemStack(EDBlocks.stones, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stones, 4), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.stones, 1, 1) });
		
		// GameRegistry.addRecipe(new ItemStack(EDBlocks.edgeStoneBrick), new Object[] { "SQ", "SQ", 'S', MItems.brickStone, 'Q', Items.quartz });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 2, 4), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.brick });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 4, 0), new Object[] { "SS", "SS", Character.valueOf('S'), Blocks.obsidian });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.snowBrick, 4), new Object[] { "SS", "SS", Character.valueOf('S'), Blocks.snow });
		GameRegistry.addSmelting(Blocks.end_stone, new ItemStack(EDBlocks.endstone, 1, 1), 20);
		GameRegistry.addRecipe(new ItemStack(EDBlocks.endstone, 9, 2), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.endstone, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.endstone, 4, 0), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.endstone, 1, 1) });
		GameRegistry.addSmelting(Blocks.glass, new ItemStack(EDBlocks.glassRefined), 20);
		GameRegistry.addRecipe(new ItemStack(EDBlocks.glassRefinedPane, 16), new Object[] { "SSS", "SSS", Character.valueOf('S'), EDBlocks.glassRefined });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 2, 5), new Object[] { "SS", "SS", Character.valueOf('S'), Items.flint });
		GameRegistry.addRecipe(new ItemStack(Items.flint, 2), new Object[] { "S", Character.valueOf('S'), new ItemStack(EDBlocks.Tiles, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.gunpowderBlock, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.gunpowder });
		GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.gunpowderBlock });
		GameRegistry.addRecipe(new ItemStack(EDItems.ropeItem, 1), new Object[] { "S", "S", "S", Character.valueOf('S'), Items.string });
		GameRegistry.addRecipe(new ItemStack(EDItems.ropeItem, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.ropeCoil });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.ropeCoil, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), EDItems.ropeItem });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.oozeSlime, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.slime_ball });
		GameRegistry.addRecipe(new ItemStack(Items.slime_ball, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.oozeSlime });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 0), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 0), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.woodBoards, 1, 0) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 1), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.woodBoards, 1, 1) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 2), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 2), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.woodBoards, 1, 2) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 3), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(Blocks.planks, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodPanel, 9, 3), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.woodBoards, 1, 3) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBeveled, 4, 0), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.woodPanel, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBeveled, 4, 1), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.woodPanel, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBeveled, 4, 2), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.woodPanel, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBeveled, 4, 3), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(EDBlocks.woodPanel, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stoneLamp, 8, 0), new Object[] { "SSS", "SGS", "SSS", Character.valueOf('S'), new ItemStack(EDBlocks.stones, 1, 1), Character.valueOf('G'), Blocks.glowstone });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 2, 6), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.netherbrick });
		
		// TODO add sandstone brick recipes
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandstonePillar, 2), new Object[] { "S", "S", Character.valueOf('S'), Blocks.sandstone });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoards, 16, 0), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoards, 16, 1), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoards, 16, 2), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoards, 16, 3), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.log, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 4, 1), new Object[] { "FF", "FF", Character.valueOf('F'), new ItemStack(EDBlocks.Tiles, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 4, 2), new Object[] { "FF", "FF", Character.valueOf('F'), Blocks.quartz_block });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sugarBlock), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.sugar });
		GameRegistry.addRecipe(new ItemStack(Items.sugar, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.sugarBlock });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.magmaOoze), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.magma_cream });
		GameRegistry.addRecipe(new ItemStack(Items.magma_cream, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.magmaOoze });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.enderBlock), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.ender_pearl });
		GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] { "S", Character.valueOf('S'), EDBlocks.enderBlock });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.barrel), new Object[] { "I", "C", "I", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('C'), EDBlocks.crate });
		GameRegistry.addRecipe(new ItemStack(EDItems.cardboardItem, 3), new Object[] { "SSS", "SSS", Character.valueOf('S'), Items.paper });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.cardboardBlock, 2), new Object[] { "CCC", " C ", " CC", Character.valueOf('C'), EDItems.cardboardItem });
		GameRegistry.addSmelting(Blocks.sandstone, new ItemStack(EDItems.sandstoneBrick, 4), 0.8F);
		/*
		 * GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 2, 3), new
		 * Object[] { "BBB", "BBB", "BBB", Character.valueOf('B'),
		 * EDItems.stoneBrickItem });
		 */
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandstoneBricks, 1, 0), new Object[] { "BB", "BB", Character.valueOf('B'), EDItems.sandstoneBrick });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandstoneBricks, 2, 1), new Object[] { "BBB", "BBB", "BBB", Character.valueOf('B'), EDItems.sandstoneBrick });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.Tiles, 4, 3), new Object[] { "FQ", "QF", Character.valueOf('F'), new ItemStack(EDBlocks.Tiles, 1, 1), Character.valueOf('Q'), new ItemStack(EDBlocks.Tiles, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsSingleSlab, 6, 0), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsSingleSlab, 6, 1), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsSingleSlab, 6, 2), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsSingleSlab, 6, 3), new Object[] { "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsStairsOak, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsStairsBirch, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsStairsSpruce, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.woodBoardsStairsJungle, 4), new Object[] { "  F", " FF", "FFF", Character.valueOf('F'), new ItemStack(EDBlocks.woodBoards, 1, 3) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 9), new Object[] { EDBlocks.enderBlock });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.checkerTileStairs, 4), new Object[] { "  T", " TT", "TTT", Character.valueOf('T'), new ItemStack(EDBlocks.Tiles, 1, 3) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 0), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 1), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 2), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 3), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 4), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 5), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 6), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 7), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 8), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 9), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 10) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 10), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 11), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 12), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 13), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 14), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 8, 15), new Object[] { "BBB", "BDB", "BBB", Character.valueOf('B'), Blocks.brick_block, Character.valueOf('D'), new ItemStack(Items.dye, 1, 13) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 0), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 1), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 2), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 3), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 4), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 5), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 6), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 7), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 8), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 9), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 10), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 13) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 11), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 12), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 13), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 14), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 10) });
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stainedBrick, 4, 15), new Object[] { "BB", "BB", Character.valueOf('B'), new ItemStack(Blocks.hardened_clay, 1, 2) });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.cobbledRoad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('D'), Blocks.dirt });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandstoneRoad, 2), new Object[] { "CCC", "CCC", "DDD", Character.valueOf('C'), EDItems.sandstoneBrick, Character.valueOf('D'), Blocks.sand });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.sandyRoad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('D'), Blocks.sand });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.gravelRoad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.cobblestone, Character.valueOf('D'), Blocks.gravel });
		/*
		 * GameRegistry.addRecipe(new ItemStack(EDBlocks.refinedRoad, 1), new
		 * Object[] { "CCC", "CCC", "DDD", Character.valueOf('C'), new
		 * ItemStack(EDItems.stoneBrickItem, 1, 0), Character.valueOf('D'),
		 * Blocks.dirt });
		 */
		GameRegistry.addRecipe(new ItemStack(EDBlocks.netherroad, 2), new Object[] { "CC", "DD", Character.valueOf('C'), Blocks.netherrack, Character.valueOf('D'), Blocks.soul_sand });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.refinedNetherroad, 1), new Object[] { "CCC", "CCC", "DDD", Character.valueOf('C'), new ItemStack(Items.netherbrick, 1, 0), Character.valueOf('D'), Blocks.soul_sand });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.stoneLamp, 8, 1), new Object[] { "SSS", "SGS", "SSS", 'S', new ItemStack(EDBlocks.stones, 1, 1), 'G', EOBlocks.Sunstone });
		
		GameRegistry.addRecipe(new ItemStack(EDBlocks.bedrockBrick, 4), new Object[] { "SS", "SS", 'S', Blocks.bedrock });
		
		//TODO EMD RECIPES
		GameRegistry.addSmelting(EMDItems.fat, new ItemStack(EMDItems.grease, 1), 0.7F);
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedApple, 2), new Object[] { EMDItems.fat, Items.apple, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedBeef, 2), new Object[] { EMDItems.fat, Items.beef, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedBread, 2), new Object[] { EMDItems.fat, Items.bread, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedCarrot, 2), new Object[] { EMDItems.fat, Items.carrot, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedCookie, 2), new Object[] { EMDItems.fat, Items.cookie, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedFlesh, 2), new Object[] { EMDItems.fat, Items.rotten_flesh, EMDItems.fat });
		GameRegistry.addRecipe(new ItemStack(Items.dye, 1, 16), new Object[] { "AA", "AA", 'A', EMDItems.animalBones });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordWood), new Object[] { EMDItems.horn, EMDItems.horn, Items.wooden_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordStone), new Object[] { EMDItems.horn, EMDItems.horn, Items.stone_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordIron), new Object[] { EMDItems.horn, EMDItems.horn, Items.iron_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordDiamond), new Object[] { EMDItems.horn, EMDItems.horn, Items.diamond_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordGold), new Object[] { EMDItems.horn, EMDItems.horn, Items.golden_sword });
		GameRegistry.addSmelting(EMDItems.chickenWingRaw, new ItemStack(EMDItems.chickenWingCooked, 1), 0.7F);
		GameRegistry.addSmelting(EMDItems.lambchopRaw, new ItemStack(EMDItems.lambchopCooked, 1), 0.7F);
		GameRegistry.addSmelting(EMDItems.squidTentacle, new ItemStack(EMDItems.calimari, 1), 0.7F);
		GameRegistry.addRecipe(new ItemStack(Items.string), new Object[] { "WW", "WW", 'W', EMDItems.whisker });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 0), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.pigHoof });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 1), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.cowHoof });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 2), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.footChicken });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 3), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.sheepHoof });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 4), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.horseHoof });
		GameRegistry.addSmelting(EMDItems.rawHorseHaunch, new ItemStack(EMDItems.cookedHorseHaunch), 0.8F);
		GameRegistry.addRecipe(new ItemStack(EMDItems.wingSegment, 1, 0), new Object[] { "FSF", "SLS", "FSF", 'F', Items.feather, 'S', EMDItems.wingSinew, 'L', Items.leather });
		GameRegistry.addRecipe(new ItemStack(EMDItems.hangGlider, 1, 0), new Object[] { "PPP", "W W", "W W", 'P', Blocks.planks, 'W', EMDItems.wingSegment });
		/*
		 * if(Loader.isModLoaded("ExtraOres")) {
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornSandstone), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.SandstoneSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornGranite), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.GraniteSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornCopper), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.CopperSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornSteel), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.SteelSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornBronze), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.BronzeSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornMeurodite), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.meuroditeSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornTorite), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.ToriteSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornBlazium), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.BlaziumSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornTitanium), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.TitaniumSword }); }
		 */
	}
	
	public static void loadPlatedRecipes()
	{
		ItemStack[] picks = new ItemStack[] { new ItemStack(EOItems.meuroditePickaxe, 1), new ItemStack(EOItems.ToritePickaxe, 1), new ItemStack(EOItems.BlaziumPickaxe, 1), new ItemStack(EOItems.TitaniumPickaxe, 1), new ItemStack(EOItems.SteelPickaxe, 1), new ItemStack(EOItems.SandstonePickaxe, 1), new ItemStack(EOItems.CopperPickaxe, 1), new ItemStack(EOItems.BedrockPickaxe, 1), new ItemStack(EOItems.GranitePickaxe, 1) };
		ItemStack[] picksWithoutNBT = new ItemStack[] { new ItemStack(EOItems.meuroditePickaxe, 1), new ItemStack(EOItems.ToritePickaxe, 1), new ItemStack(EOItems.BlaziumPickaxe, 1), new ItemStack(EOItems.TitaniumPickaxe, 1), new ItemStack(EOItems.SteelPickaxe, 1), new ItemStack(EOItems.SandstonePickaxe, 1), new ItemStack(EOItems.CopperPickaxe, 1), new ItemStack(EOItems.BedrockPickaxe, 1), new ItemStack(EOItems.GranitePickaxe, 1) };
		
		for (int i = 0; i < picks.length; i++)
		{
			picks[i].stackTagCompound = new NBTTagCompound();
			picks[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(picks[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), picksWithoutNBT[i] });
		}
		
		ItemStack[] axes = new ItemStack[] { new ItemStack(EOItems.meuroditeAxe, 1), new ItemStack(EOItems.ToriteAxe, 1), new ItemStack(EOItems.BlaziumAxe, 1), new ItemStack(EOItems.TitaniumAxe, 1), new ItemStack(EOItems.SteelAxe, 1), new ItemStack(EOItems.SandstoneAxe, 1), new ItemStack(EOItems.CopperAxe, 1), new ItemStack(EOItems.BedrockAxe, 1), new ItemStack(EOItems.GraniteAxe, 1) };
		ItemStack[] axesWithoutNBT = new ItemStack[] { new ItemStack(EOItems.meuroditeAxe, 1), new ItemStack(EOItems.ToriteAxe, 1), new ItemStack(EOItems.BlaziumAxe, 1), new ItemStack(EOItems.TitaniumAxe, 1), new ItemStack(EOItems.SteelAxe, 1), new ItemStack(EOItems.SandstoneAxe, 1), new ItemStack(EOItems.CopperAxe, 1), new ItemStack(EOItems.BedrockAxe, 1), new ItemStack(EOItems.GraniteAxe, 1) };
		
		for (int i = 0; i < axes.length; i++)
		{
			axes[i].stackTagCompound = new NBTTagCompound();
			axes[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(axes[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), axesWithoutNBT[i] });
		}
		
		ItemStack[] hoes = new ItemStack[] { new ItemStack(EOItems.meuroditeHoe, 1), new ItemStack(EOItems.ToriteHoe, 1), new ItemStack(EOItems.BlaziumHoe, 1), new ItemStack(EOItems.TitaniumHoe, 1), new ItemStack(EOItems.SteelHoe, 1), new ItemStack(EOItems.SandstoneHoe, 1), new ItemStack(EOItems.CopperHoe, 1), new ItemStack(EOItems.BedrockHoe, 1), new ItemStack(EOItems.GraniteHoe, 1) };
		ItemStack[] hoesWithoutNBT = new ItemStack[] { new ItemStack(EOItems.meuroditeHoe, 1), new ItemStack(EOItems.ToriteHoe, 1), new ItemStack(EOItems.BlaziumHoe, 1), new ItemStack(EOItems.TitaniumHoe, 1), new ItemStack(EOItems.SteelHoe, 1), new ItemStack(EOItems.SandstoneHoe, 1), new ItemStack(EOItems.CopperHoe, 1), new ItemStack(EOItems.BedrockHoe, 1), new ItemStack(EOItems.GraniteHoe, 1) };
		
		for (int i = 0; i < hoes.length; i++)
		{
			hoes[i].stackTagCompound = new NBTTagCompound();
			hoes[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(hoes[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), hoesWithoutNBT[i] });
		}
		
		ItemStack[] shovels = new ItemStack[] { new ItemStack(EOItems.meuroditeShovel, 1), new ItemStack(EOItems.ToriteShovel, 1), new ItemStack(EOItems.BlaziumShovel, 1), new ItemStack(EOItems.TitaniumShovel, 1), new ItemStack(EOItems.SteelShovel, 1), new ItemStack(EOItems.SandstoneShovel, 1), new ItemStack(EOItems.CopperShovel, 1), new ItemStack(EOItems.BedrockShovel, 1), new ItemStack(EOItems.GraniteShovel, 1) };
		ItemStack[] shovelsWithoutNBT = new ItemStack[] { new ItemStack(EOItems.meuroditeShovel, 1), new ItemStack(EOItems.ToriteShovel, 1), new ItemStack(EOItems.BlaziumShovel, 1), new ItemStack(EOItems.TitaniumShovel, 1), new ItemStack(EOItems.SteelShovel, 1), new ItemStack(EOItems.SandstoneShovel, 1), new ItemStack(EOItems.CopperShovel, 1), new ItemStack(EOItems.BedrockShovel, 1), new ItemStack(EOItems.GraniteShovel, 1) };
		
		for (int i = 0; i < shovels.length; i++)
		{
			shovels[i].stackTagCompound = new NBTTagCompound();
			shovels[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(shovels[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), shovelsWithoutNBT[i] });
		}
		
		ItemStack[] swords = new ItemStack[] { new ItemStack(EOItems.meuroditeSword, 1), new ItemStack(EOItems.ToriteSword, 1), new ItemStack(EOItems.BlaziumSword, 1), new ItemStack(EOItems.TitaniumSword, 1), new ItemStack(EOItems.SteelSword, 1), new ItemStack(EOItems.SandstoneSword, 1), new ItemStack(EOItems.CopperSword, 1), new ItemStack(EOItems.GraniteSword, 1) };
		ItemStack[] swordsWithoutNBT = new ItemStack[] { new ItemStack(EOItems.meuroditeSword, 1), new ItemStack(EOItems.ToriteSword, 1), new ItemStack(EOItems.BlaziumSword, 1), new ItemStack(EOItems.TitaniumSword, 1), new ItemStack(EOItems.SteelSword, 1), new ItemStack(EOItems.SandstoneSword, 1), new ItemStack(EOItems.CopperSword, 1), new ItemStack(EOItems.GraniteSword, 1) };
		
		for (int i = 0; i < swords.length; i++)
		{
			swords[i].stackTagCompound = new NBTTagCompound();
			swords[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(swords[i], new Object[] { "PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), swordsWithoutNBT[i] });
		}
		
	}
	
	public static void removeRecipes()
	{
		MCUtil.removeRecipe(new ItemStack(Blocks.stonebrick, 4, 0));
	}
}
