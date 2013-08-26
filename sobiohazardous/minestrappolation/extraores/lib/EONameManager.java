package sobiohazardous.minestrappolation.extraores.lib;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.block.*;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.src.ModLoader;

public class EONameManager 

{

	//Load using method or constructor, depending on situation
	
	public EONameManager()
	{
		loadNames();
	}
	
	public static void loadNames()
	{
		//TODO: Change Modloader to LanguageRegistry
		ModLoader.addName(EOBlockManager.meuroditeOre, "Meurodite Ore");

		ModLoader.addName(EOBlockManager.meuroditeBlock, "Block of Meurodite");
		ModLoader.addName(EOItemManager.meuroditeIngot, "Meurodite Gem");
		
		ModLoader.addName(EOItemManager.meuroditeSword, "Meurodite Sword");
		ModLoader.addName(EOItemManager.meuroditePickaxe, "Meurodite Pickaxe");
		ModLoader.addName(EOItemManager.meuroditeShovel, "Meurodite Shovel");
		ModLoader.addName(EOItemManager.meuroditeHoe, "Meurodite Hoe");
		ModLoader.addName(EOItemManager.meuroditeAxe, "Meurodite Axe");
		
		ModLoader.addName(EOItemManager.meuroditeHelmet, "Meurodite Helmet");
		ModLoader.addName(EOItemManager.meuroditeChest, "Meurodite Chestplate");
		ModLoader.addName(EOItemManager.meuroditePants, "Meurodite Leggings");
		ModLoader.addName(EOItemManager.meuroditeBoots, "Meurodite Boots");
		

		ModLoader.addName(EOBlockManager.UraniumOre, "Uranium Ore");
		ModLoader.addName(EOItemManager.Uranium, "Uranium");
		ModLoader.addName(EOBlockManager.RawUraniumBlock, "Raw Uranium Block");

		ModLoader.addName(EOBlockManager.PlutoniumOre, "Plutonium Ore");
		ModLoader.addName(EOItemManager.Plutonium, "Plutonium");
		ModLoader.addName(EOBlockManager.RawPlutoniumBlock, "Raw Plutonium Block");

		ModLoader.addName(EOBlockManager.TitaniumOre, "Titanium Ore");
		ModLoader.addName(EOItemManager.TitaniumIngot, "Titanium Ingot");
		
		ModLoader.addName(EOItemManager.TitaniumAxe, "Titanium Axe");
		ModLoader.addName(EOItemManager.TitaniumHoe, "Titanium Hoe");
		ModLoader.addName(EOItemManager.TitaniumPickaxe, "Titanium Pickaxe");
		ModLoader.addName(EOItemManager.TitaniumShovel, "Titanium Shovel");
		ModLoader.addName(EOItemManager.TitaniumSword, "Titanium Sword");
		
		ModLoader.addName(EOItemManager.TitaniumHelmet, "Titanium Helmet");
		ModLoader.addName(EOItemManager.TitaniumChest, "Titanium Chestplate");
		ModLoader.addName(EOItemManager.TitaniumPants, "Titanium Leggings");
		ModLoader.addName(EOItemManager.TitaniumBoots, "Titanium Boots");
		

		ModLoader.addName(EOBlockManager.TitaniumBlock, "Block of Titanium");
		

		ModLoader.addName(EOBlockManager.Sunstone, "Sunstone");
		ModLoader.addName(EOItemManager.SunstoneDust, "Sunstone Dust");
		ModLoader.addName(EOBlockManager.SunstoneOre, "Sunstone Ore");
		

		ModLoader.addName(EOBlockManager.ToriteOre, "Torite Ore");
		ModLoader.addName(EOItemManager.ToriteIngot, "Torite Ingot");

		ModLoader.addName(EOBlockManager.ToriteBlock, "Block of Torite");
		
		ModLoader.addName(EOItemManager.ToriteAxe, "Torite Axe");
		ModLoader.addName(EOItemManager.ToriteHoe, "Torite Hoe");
		ModLoader.addName(EOItemManager.ToritePickaxe, "Torite Pickaxe");
		ModLoader.addName(EOItemManager.ToriteShovel, "Torite Shovel");
		ModLoader.addName(EOItemManager.ToriteSword, "Torite Sword");
		
		ModLoader.addName(EOItemManager.ToriteHelmet, "Torite Helmet");
		ModLoader.addName(EOItemManager.ToriteChest, "Torite Chestplate");
		ModLoader.addName(EOItemManager.ToritePants, "Torite Leggings");
		ModLoader.addName(EOItemManager.ToriteBoots, "Torite Boots");
		

		ModLoader.addName(EOBlockManager.Granite, "Granite");

		ModLoader.addName(EOBlockManager.GraniteBrick, "Granite Brick");
		

		ModLoader.addName(EOBlockManager.Quartzite, "Desert Quartz Block");

		ModLoader.addName(EOBlockManager.QuartziteTile, "Rough Desert Quartz Tile");
		

		ModLoader.addName(EOBlockManager.BlaziumOre, "Blazium Ore");
		

		ModLoader.addName(EOBlockManager.BlaziumBlock, "Block of Blazium");
		ModLoader.addName(EOItemManager.BlaziumIngot, "Blazium Ingot");
		ModLoader.addName(EOItemManager.BlazeShard, "Blaze Shard");
		
		ModLoader.addName(EOItemManager.BlaziumAxe, "Fire Axe");
		ModLoader.addName(EOItemManager.BlaziumHoe, "Fire Hoe");
		ModLoader.addName(EOItemManager.BlaziumPickaxe, "Fire Pickaxe");
		ModLoader.addName(EOItemManager.BlaziumShovel, "Fire Shovel");
		ModLoader.addName(EOItemManager.BlaziumSword, "Fire Sword");
		
		ModLoader.addName(EOItemManager.BlaziumHelmet, "Fire Helmet");
		ModLoader.addName(EOItemManager.BlaziumChest, "Fire Chestplate");
		ModLoader.addName(EOItemManager.BlaziumPants, "Fire Leggings");
		ModLoader.addName(EOItemManager.BlaziumBoots, "Fire Boots");
		

		ModLoader.addName(EOBlockManager.CopperOre, "Copper Ore (Minestrappolation)");

		ModLoader.addName(EOBlockManager.CopperBlock, "Block of Copper (Minestrappolation)");
		ModLoader.addName(EOItemManager.CopperIngot, "Copper Ingot (Minestrappolation)");
		
		ModLoader.addName(EOBlockManager.CopperBlockTarnished, "Tarnished Copper Block");
		
		ModLoader.addName(EOItemManager.CopperAxe, "Copper Axe");
		ModLoader.addName(EOItemManager.CopperHoe, "Copper Hoe");
		ModLoader.addName(EOItemManager.CopperPickaxe, "Copper Pickaxe");
		ModLoader.addName(EOItemManager.CopperShovel, "Copper Shovel");
		ModLoader.addName(EOItemManager.CopperSword, "Copper Sword");
		

		ModLoader.addName(EOBlockManager.TinOre, "Tin Ore (Minestrappolation)");
		ModLoader.addName(EOBlockManager.TinBlock, "Block of Tin (Minestrappolation)");
		ModLoader.addName(EOItemManager.TinIngot, "Tin Ingot (Minestrappolation)");
		
		ModLoader.addName(EOItemManager.TinHelmet, "Tin Helmet");
		ModLoader.addName(EOItemManager.TinChest, "Tin Chestplate");
		ModLoader.addName(EOItemManager.TinPants, "Tin Leggings");
		ModLoader.addName(EOItemManager.TinBoots, "Tin Boots");
		
		ModLoader.addName(EOBlockManager.TinPlate, "Tin Plate Block");
		ModLoader.addName(EOBlockManager.BronzePlate, "Bronze Plate Block");
		ModLoader.addName(EOBlockManager.SteelPlate, "Steel Plate Block");
		ModLoader.addName(EOItemManager.TinPlateItem, "Tin Plate");
		ModLoader.addName(EOItemManager.BronzePlateItem, "Bronze Plate");
		ModLoader.addName(EOItemManager.SteelPlateItem, "Steel Plate");
		
		ModLoader.addName(EOItemManager.CoalIronIngot, "Coal-Coated Iron Ingot");
		ModLoader.addName(EOItemManager.SteelIngot, "Steel Ingot");
		ModLoader.addName(EOItemManager.SteelPickaxe, "Steel Pickaxe");
		ModLoader.addName(EOItemManager.SteelShovel, "Steel Shovel");
		ModLoader.addName(EOItemManager.SteelAxe, "Steel Axe");
		ModLoader.addName(EOItemManager.SteelHoe, "Steel Hoe");
		ModLoader.addName(EOItemManager.SteelSword, "Steel Sword");
		ModLoader.addName(EOItemManager.SteelHelmet, "Steel Helmet");
		ModLoader.addName(EOItemManager.SteelChest, "Steel Chestplate");
		ModLoader.addName(EOItemManager.SteelPants, "Steel Leggings");
		ModLoader.addName(EOItemManager.SteelBoots, "Steel Boots");
		ModLoader.addName(EOBlockManager.SteelBlock, "Block of Steel");
		
		ModLoader.addName(EOBlockManager.SoulOre, "Soul Ore");
		ModLoader.addName(EOBlockManager.SoulGem, "Soul Gem");
		
		ModLoader.addName(EOBlockManager.SmoothQuartzite, "Smooth Desert Quartz Block");
		ModLoader.addName(EOBlockManager.PillarQuartzite, "Desert Quartz Pillar");
		ModLoader.addName(EOBlockManager.ChiseledQuartzite, "Chiseled Desert Quartz Block");
		ModLoader.addName(EOBlockManager.SmoothQuartzTile, "Refined Desert Quartz Tile");
		ModLoader.addName(EOItemManager.PinkQuartz, "Desert Quartz");
		
		ModLoader.addName(EOItemManager.SandstonePickaxe, "Sandstone Pickaxe");
		ModLoader.addName(EOItemManager.SandstoneShovel, "Sandstone Shovel");
		ModLoader.addName(EOItemManager.SandstoneAxe, "Sandstone Axe");
		ModLoader.addName(EOItemManager.SandstoneHoe, "Sandstone Hoe");
		ModLoader.addName(EOItemManager.SandstoneSword, "Sandstone Sword");
		
		ModLoader.addName(EOBlockManager.TinPlatedCobble, "Tin-Plated Cobblestone");
		ModLoader.addName(EOBlockManager.TinPlatedMossy, "Mossy Tin-Plated Cobblestone");
		ModLoader.addName(EOBlockManager.TinPlatedStoneBrick, "Tin-Plated Stone Brick");
		ModLoader.addName(EOBlockManager.TinPlatedChiseled, "Tin-Plated Chiseled Stone Brick");
		ModLoader.addName(EOBlockManager.TinPlatedGranite, "Tin-Plated Granite Brick");
		
		ModLoader.addName(EOItemManager.BronzeIngot, "Bronze Ingot");
		ModLoader.addName(EOItemManager.BronzePickaxe, "Bronze Pickaxe");
		ModLoader.addName(EOItemManager.BronzeShovel, "Bronze Shovel");
		ModLoader.addName(EOItemManager.BronzeAxe, "Bronze Axe");
		ModLoader.addName(EOItemManager.BronzeHoe, "Bronze Hoe");
		ModLoader.addName(EOItemManager.BronzeSword, "Bronze Sword");
		ModLoader.addName(EOItemManager.BronzeHelmet, "Bronze Helmet");
		ModLoader.addName(EOItemManager.BronzeChest, "Bronze Chestplate");
		ModLoader.addName(EOItemManager.BronzePants, "Bronze Leggings");
		ModLoader.addName(EOItemManager.BronzeBoots, "Bronze Boots");
		ModLoader.addName(EOBlockManager.BronzeBlock, "Block of Bronze");
		
		ModLoader.addName(EOBlockManager.BronzePlatedCobble, "Bronze-Plated Cobblestone");
		ModLoader.addName(EOBlockManager.BronzePlatedMossy, "Mossy Bronze-Plated Cobblestone");
		ModLoader.addName(EOBlockManager.BronzePlatedStoneBrick, "Bronze-Plated Stone Brick");
		ModLoader.addName(EOBlockManager.BronzePlatedChiseled, "Bronze-Plated Chiseled Stone Brick");
		ModLoader.addName(EOBlockManager.BronzePlatedGranite, "Bronze-Plated Granite Brick");
		
		ModLoader.addName(EOBlockManager.Invincium, "Invincium");
		ModLoader.addName(EOItemManager.BedrockPickaxe, "Bedrock Pickaxe");
		ModLoader.addName(EOItemManager.BedrockShovel, "Bedrock Shovel");
		ModLoader.addName(EOItemManager.BedrockAxe, "Bedrock Axe");
		ModLoader.addName(EOItemManager.BedrockHoe, "Bedrock Hoe");
		
		ModLoader.addName(EOBlockManager.SteelPlatedCobble, "Steel-Plated Cobblestone");
		ModLoader.addName(EOBlockManager.SteelPlatedMossy, "Mossy Steel-Plated Cobblestone");
		ModLoader.addName(EOBlockManager.SteelPlatedStoneBrick, "Steel-Plated Stone Brick");
		ModLoader.addName(EOBlockManager.SteelPlatedChiseled, "Steel-Plated Chiseled Stone Brick");
		ModLoader.addName(EOBlockManager.SteelPlatedGranite, "Steel-Plated Granite Brick");
		
		ModLoader.addName(EOItemManager.GranitePickaxe, "Granite Pickaxe");
		ModLoader.addName(EOItemManager.GraniteShovel, "Granite Shovel");
		ModLoader.addName(EOItemManager.GraniteAxe, "Granite Axe");
		ModLoader.addName(EOItemManager.GraniteHoe, "Granite Hoe");
		ModLoader.addName(EOItemManager.GraniteSword, "Granite Sword");
		
		ModLoader.addName(EOBlockManager.SoulBottle, "Soul Bottle");
		
		ModLoader.addName(EOBlockManager.nuke, "Nuke");
		ModLoader.addName(EOItemManager.grenade, "Nuclear Grenade");
		ModLoader.addName(EOItemManager.grenadeImpact, "Impact Grenade");
		ModLoader.addName(EOItemManager.grenadeSticky, "Sticky Grenade");
		
		ModLoader.addName(EOBlockManager.melterIdle, "Melter");
			
		
		ModLoader.addName(EOItemManager.BPMeuroditeSword, "Bronze-Plated Meurodite Sword");
		ModLoader.addName(EOItemManager.BPMeuroditePickaxe, "Bronze-Plated Meurodite Pickaxe");
		ModLoader.addName(EOItemManager.BPMeuroditeShovel, "Bronze-Plated Meurodite Shovel");
		ModLoader.addName(EOItemManager.BPMeuroditeHoe, "Bronze-Plated Meurodite Hoe");
		ModLoader.addName(EOItemManager.BPMeuroditeAxe, "Bronze-Plated Meurodite Axe");
		
		ModLoader.addName(EOItemManager.BPMeuroditeHelmet, "Bronze-Plated Meurodite Helmet");
		ModLoader.addName(EOItemManager.BPMeuroditeChest, "Bronze-Plated Meurodite Chestplate");
		ModLoader.addName(EOItemManager.BPMeuroditePants, "Bronze-Plated Meurodite Leggings");
		ModLoader.addName(EOItemManager.BPMeuroditeBoots, "Bronze-Plated Meurodite Boots");
		
		ModLoader.addName(EOItemManager.BPTitaniumAxe, "Bronze-Plated Titanium Axe");
		ModLoader.addName(EOItemManager.BPTitaniumHoe, "Bronze-Plated Titanium Hoe");
		ModLoader.addName(EOItemManager.BPTitaniumPickaxe, "Bronze-Plated Titanium Pickaxe");
		ModLoader.addName(EOItemManager.BPTitaniumShovel, "Bronze-Plated Titanium Shovel");
		ModLoader.addName(EOItemManager.BPTitaniumSword, "Bronze-Plated Titanium Sword");
		
		ModLoader.addName(EOItemManager.BPTitaniumHelmet, "Bronze-Plated Titanium Helmet");
		ModLoader.addName(EOItemManager.BPTitaniumChest, "Bronze-Plated Titanium Chestplate");
		ModLoader.addName(EOItemManager.BPTitaniumPants, "Bronze-Plated Titanium Leggings");
		ModLoader.addName(EOItemManager.BPTitaniumBoots, "Bronze-Plated Titanium Boots");
		
		ModLoader.addName(EOItemManager.BPToriteAxe, "Bronze-Plated Torite Axe");
		ModLoader.addName(EOItemManager.BPToriteHoe, "Bronze-Plated Torite Hoe");
		ModLoader.addName(EOItemManager.BPToritePickaxe, "Bronze-Plated Torite Pickaxe");
		ModLoader.addName(EOItemManager.BPToriteShovel, "Bronze-Plated Torite Shovel");
		ModLoader.addName(EOItemManager.BPToriteSword, "Bronze-Plated Torite Sword");
		
		ModLoader.addName(EOItemManager.BPToriteHelmet, "Bronze-Plated Torite Helmet");
		ModLoader.addName(EOItemManager.BPToriteChest, "Bronze-Plated Torite Chestplate");
		ModLoader.addName(EOItemManager.BPToritePants, "Bronze-Plated Torite Leggings");
		ModLoader.addName(EOItemManager.BPToriteBoots, "Bronze-Plated Torite Boots");
		
		ModLoader.addName(EOItemManager.BPBlaziumAxe, "Bronze-Plated Fire Axe");
		ModLoader.addName(EOItemManager.BPBlaziumHoe, "Bronze-Plated Fire Hoe");
		ModLoader.addName(EOItemManager.BPBlaziumPickaxe, "Bronze-Plated Fire Pickaxe");
		ModLoader.addName(EOItemManager.BPBlaziumShovel, "Bronze-Plated Fire Shovel");
		ModLoader.addName(EOItemManager.BPBlaziumSword, "Bronze-Plated Fire Sword");
		
		ModLoader.addName(EOItemManager.BPBlaziumHelmet, "Bronze-Plated Fire Helmet");
		ModLoader.addName(EOItemManager.BPBlaziumChest, "Bronze-Plated Fire Chestplate");
		ModLoader.addName(EOItemManager.BPBlaziumPants, "Bronze-Plated Fire Leggings");
		ModLoader.addName(EOItemManager.BPBlaziumBoots, "Bronze-Plated Fire Boots");
		
		ModLoader.addName(EOItemManager.BPCopperAxe, "Bronze-Plated Copper Axe");
		ModLoader.addName(EOItemManager.BPCopperHoe, "Bronze-Plated Copper Hoe");
		ModLoader.addName(EOItemManager.BPCopperPickaxe, "Bronze-Plated Copper Pickaxe");
		ModLoader.addName(EOItemManager.BPCopperShovel, "Bronze-Plated Copper Shovel");
		ModLoader.addName(EOItemManager.BPCopperSword, "Bronze-Plated Copper Sword");
		
		ModLoader.addName(EOItemManager.BPTinHelmet, "Bronze-Plated Tin Helmet");
		ModLoader.addName(EOItemManager.BPTinChest, "Bronze-Plated Tin Chestplate");
		ModLoader.addName(EOItemManager.BPTinPants, "Bronze-Plated Tin Leggings");
		ModLoader.addName(EOItemManager.BPTinBoots, "Bronze-Plated Tin Boots");
		
		ModLoader.addName(EOItemManager.BPSteelPickaxe, "Bronze-Plated Steel Pickaxe");
		ModLoader.addName(EOItemManager.BPSteelShovel, "Bronze-Plated Steel Shovel");
		ModLoader.addName(EOItemManager.BPSteelAxe, "Bronze-Plated Steel Axe");
		ModLoader.addName(EOItemManager.BPSteelHoe, "Bronze-Plated Steel Hoe");
		ModLoader.addName(EOItemManager.BPSteelSword, "Bronze-Plated Steel Sword");
		
		ModLoader.addName(EOItemManager.BPSteelHelmet, "Bronze-Plated Steel Helmet");
		ModLoader.addName(EOItemManager.BPSteelChest, "Bronze-Plated Steel Chestplate");
		ModLoader.addName(EOItemManager.BPSteelPants, "Bronze-Plated Steel Leggings");
		ModLoader.addName(EOItemManager.BPSteelBoots, "Bronze-Plated Steel Boots");
		
		ModLoader.addName(EOItemManager.BPSandstonePickaxe, "Bronze-Plated Sandstone Pickaxe");
		ModLoader.addName(EOItemManager.BPSandstoneShovel, "Bronze-Plated Sandstone Shovel");
		ModLoader.addName(EOItemManager.BPSandstoneAxe, "Bronze-Plated Sandstone Axe");
		ModLoader.addName(EOItemManager.BPSandstoneHoe, "Bronze-Plated Sandstone Hoe");
		ModLoader.addName(EOItemManager.BPSandstoneSword, "Bronze-Plated Sandstone Sword");
		
		ModLoader.addName(EOItemManager.BPBedrockPickaxe, "Bronze-Plated Bedrock Pickaxe");
		ModLoader.addName(EOItemManager.BPBedrockShovel, "Bronze-Plated Bedrock Shovel");
		ModLoader.addName(EOItemManager.BPBedrockAxe, "Bronze-Plated Bedrock Axe");
		ModLoader.addName(EOItemManager.BPBedrockHoe, "Bronze-Plated Bedrock Hoe");
		
		ModLoader.addName(EOItemManager.BPGranitePickaxe, "Bronze-Plated Granite Pickaxe");
		ModLoader.addName(EOItemManager.BPGraniteShovel, "Bronze-Plated Granite Shovel");
		ModLoader.addName(EOItemManager.BPGraniteAxe, "Bronze-Plated Granite Axe");
		ModLoader.addName(EOItemManager.BPGraniteHoe, "Bronze-Plated Granite Hoe");
		ModLoader.addName(EOItemManager.BPGraniteSword, "Bronze-Plated Granite Sword");
		
		ModLoader.addName(EOItemManager.BPWoodAxe, "Bronze-Plated Wood Axe");
		ModLoader.addName(EOItemManager.BPWoodHoe, "Bronze-Plated Wood Hoe");
		ModLoader.addName(EOItemManager.BPWoodPickaxe, "Bronze-Plated Wood Pickaxe");
		ModLoader.addName(EOItemManager.BPWoodShovel, "Bronze-Plated Wood Shovel");
		ModLoader.addName(EOItemManager.BPWoodSword, "Bronze-Plated Wood Sword");
		
		ModLoader.addName(EOItemManager.BPClothHelmet, "Bronze-Plated Cloth Helmet");
		ModLoader.addName(EOItemManager.BPClothChest, "Bronze-Plated Cloth Chestplate");
		ModLoader.addName(EOItemManager.BPClothPants, "Bronze-Plated Cloth Leggings");
		ModLoader.addName(EOItemManager.BPClothBoots, "Bronze-Plated Cloth Boots");
		
		ModLoader.addName(EOItemManager.BPStoneAxe, "Bronze-Plated Stone Axe");
		ModLoader.addName(EOItemManager.BPStoneHoe, "Bronze-Plated Stone Hoe");
		ModLoader.addName(EOItemManager.BPStonePickaxe, "Bronze-Plated Stone Pickaxe");
		ModLoader.addName(EOItemManager.BPStoneShovel, "Bronze-Plated Stone Shovel");
		ModLoader.addName(EOItemManager.BPStoneSword, "Bronze-Plated Stone Sword");
		
		ModLoader.addName(EOItemManager.BPChainHelmet, "Bronze-Plated Chain Helmet");
		ModLoader.addName(EOItemManager.BPChainChest, "Bronze-Plated Chain Chestplate");
		ModLoader.addName(EOItemManager.BPChainPants, "Bronze-Plated Chain Leggings");
		ModLoader.addName(EOItemManager.BPChainBoots, "Bronze-Plated Chain Boots");
		
		ModLoader.addName(EOItemManager.BPIronAxe, "Bronze-Plated Iron Axe");
		ModLoader.addName(EOItemManager.BPIronHoe, "Bronze-Plated Iron Hoe");
		ModLoader.addName(EOItemManager.BPIronPickaxe, "Bronze-Plated Iron Pickaxe");
		ModLoader.addName(EOItemManager.BPIronShovel, "Bronze-Plated Iron Shovel");
		ModLoader.addName(EOItemManager.BPIronSword, "Bronze-Plated Iron Sword");
		
		ModLoader.addName(EOItemManager.BPIronHelmet, "Bronze-Plated Iron Helmet");
		ModLoader.addName(EOItemManager.BPIronChest, "Bronze-Plated Iron Chestplate");
		ModLoader.addName(EOItemManager.BPIronPants, "Bronze-Plated Iron Leggings");
		ModLoader.addName(EOItemManager.BPIronBoots, "Bronze-Plated Iron Boots");
		
		ModLoader.addName(EOItemManager.BPGoldAxe, "Bronze-Plated Gold Axe");
		ModLoader.addName(EOItemManager.BPGoldHoe, "Bronze-Plated Gold Hoe");
		ModLoader.addName(EOItemManager.BPGoldPickaxe, "Bronze-Plated Gold Pickaxe");
		ModLoader.addName(EOItemManager.BPGoldShovel, "Bronze-Plated Gold Shovel");
		ModLoader.addName(EOItemManager.BPGoldSword, "Bronze-Plated Gold Sword");
		
		ModLoader.addName(EOItemManager.BPGoldHelmet, "Bronze-Plated Gold Helmet");
		ModLoader.addName(EOItemManager.BPGoldChest, "Bronze-Plated Gold Chestplate");
		ModLoader.addName(EOItemManager.BPGoldPants, "Bronze-Plated Gold Leggings");
		ModLoader.addName(EOItemManager.BPGoldBoots, "Bronze-Plated Gold Boots");
		
		ModLoader.addName(EOItemManager.BPDiamondAxe, "Bronze-Plated Diamond Axe");
		ModLoader.addName(EOItemManager.BPDiamondHoe, "Bronze-Plated Diamond Hoe");
		ModLoader.addName(EOItemManager.BPDiamondPickaxe, "Bronze-Plated Diamond Pickaxe");
		ModLoader.addName(EOItemManager.BPDiamondShovel, "Bronze-Plated Diamond Shovel");
		ModLoader.addName(EOItemManager.BPDiamondSword, "Bronze-Plated Diamond Sword");
		
		ModLoader.addName(EOItemManager.BPDiamondHelmet, "Bronze-Plated Diamond Helmet");
		ModLoader.addName(EOItemManager.BPDiamondChest, "Bronze-Plated Diamond Chestplate");
		ModLoader.addName(EOItemManager.BPDiamondPants, "Bronze-Plated Diamond Leggings");
		ModLoader.addName(EOItemManager.BPDiamondBoots, "Bronze-Plated Diamond Boots");
		
		
		
		ModLoader.addName(EOBlockManager.SmoothRadiantQuartz, "Smooth Radiant Quartz Block");
		ModLoader.addName(EOBlockManager.PillarRadiantQuartz, "Radiant Quartz Pillar");
		ModLoader.addName(EOBlockManager.ChiseledRadiantQuartz, "Chiseled Radiant Quartz Block");
		ModLoader.addName(EOBlockManager.RadiantQuartzOre, "Radiant Quartz Ore");
		ModLoader.addName(EOBlockManager.RadiantQuartz, "Radiant Quartz");
		
		ModLoader.addName(EOBlockManager.Godstone, "Godstone");
		
		ModLoader.addName(EOBlockManager.RadiantQuartzStairs, "Radiant Quartz Stairs");
		
		ModLoader.addName(EOBlockManager.PinkQuartzStairs, "Desert Quartz Stairs");
		
		LanguageRegistry.addName(EOBlockManager.RadiantQuartzDoubleSlab,"Radiant Quartz DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((RadiantQuartzSlab)EOBlockManager.RadiantQuartzSingleSlab).getFullSlabName(0)+".name", "Radiant Quartz Slab");
	
		LanguageRegistry.addName(EOBlockManager.PinkQuartzDoubleSlab,"Desert Quartz DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((PinkQuartzSlab)EOBlockManager.PinkQuartzSingleSlab).getFullSlabName(0)+".name", "Desert Quartz Slab");
	
		ModLoader.addName(EOBlockManager.graniteBrickStairs, "Granite Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.graniteBrickDoubleSlab,"Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((GraniteBrickSlab)EOBlockManager.graniteBrickSingleSlab).getFullSlabName(0)+".name", "Granite Brick Slab");
		
		ModLoader.addName(EOBlockManager.tinPlatedCobbleStairs, "Tin Plated Cobble Stairs");
		
		LanguageRegistry.addName(EOBlockManager.tinPlatedCobbleDoubleSlab,"Tin Plated Cobble DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((TinPlatedCobbleSlab)EOBlockManager.tinPlatedCobbleSingleSlab).getFullSlabName(0)+".name", "Tin Plated Cobble Slab");
		
		ModLoader.addName(EOBlockManager.steelPlatedCobbleStairs, "Steel Plated Cobble Stairs");
		
		LanguageRegistry.addName(EOBlockManager.steelPlatedCobbleDoubleSlab,"Steel Plated Cobble DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((SteelPlatedCobbleSlab)EOBlockManager.steelPlatedCobbleSingleSlab).getFullSlabName(0)+".name", "Steel Plated Cobble Slab");
		
		ModLoader.addName(EOBlockManager.bronzePlatedCobbleStairs, "Bronze Plated Cobble Stairs");
		
		LanguageRegistry.addName(EOBlockManager.bronzePlatedCobbleDoubleSlab,"Bronze Plated Cobble DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((BronzePlatedCobbleSlab)EOBlockManager.bronzePlatedCobbleSingleSlab).getFullSlabName(0)+".name", "Bronze Plated Cobble Slab");	
	
		ModLoader.addName(EOBlockManager.tinPlatedStoneBrickStairs, "Tin Plated Stone Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.tinPlatedStoneBrickDoubleSlab,"Tin Plated Stone Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((TinPlatedStoneBrickSlab)EOBlockManager.tinPlatedStoneBrickSingleSlab).getFullSlabName(0)+".name", "Tin Plated Stone Brick Slab");	
		
		ModLoader.addName(EOBlockManager.steelPlatedStoneBrickStairs, "Steel Plated Stone Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.steelPlatedStoneBrickDoubleSlab,"Steel Plated Stone Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((SteelPlatedStoneBrickSlab)EOBlockManager.steelPlatedStoneBrickSingleSlab).getFullSlabName(0)+".name", "Steel Plated Stone Brick Slab");	
		
		ModLoader.addName(EOBlockManager.bronzePlatedStoneBrickStairs, "Bronze Plated Stone Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.bronzePlatedStoneBrickDoubleSlab,"Bronze Plated Stone Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((BronzePlatedStoneBrickSlab)EOBlockManager.bronzePlatedStoneBrickSingleSlab).getFullSlabName(0)+".name", "Bronze Plated Stone Brick Slab");	
		
		ModLoader.addName(EOBlockManager.tinPlatedGraniteBrickStairs, "Tin Plated Granite Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.tinPlatedGraniteBrickDoubleSlab,"Tin Plated Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((TinPlatedGraniteBrickSlab)EOBlockManager.tinPlatedGraniteBrickSingleSlab).getFullSlabName(0)+".name", "Tin Plated Granite Brick Slab");	
		
		ModLoader.addName(EOBlockManager.steelPlatedGraniteBrickStairs, "Steel Plated Granite Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.steelPlatedGraniteBrickDoubleSlab,"Steel Plated Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((SteelPlatedGraniteBrickSlab)EOBlockManager.steelPlatedGraniteBrickSingleSlab).getFullSlabName(0)+".name", "Steel Plated Granite Brick Slab");	
		
		ModLoader.addName(EOBlockManager.bronzePlatedGraniteBrickStairs, "Bronze Plated Granite Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.bronzePlatedGraniteBrickDoubleSlab,"Bronze Plated Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((BronzePlatedGraniteBrickSlab)EOBlockManager.bronzePlatedGraniteBrickSingleSlab).getFullSlabName(0)+".name", "Bronze Plated Granite Brick Slab");	
		
		ModLoader.addName(EOBlockManager.plutoniumInsulated, "Insulated Plutonium Block");
		ModLoader.addName(EOBlockManager.uraniumInsulated, "Insulated Uranium Block");
	}
	
}
