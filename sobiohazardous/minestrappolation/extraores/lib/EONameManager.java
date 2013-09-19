package sobiohazardous.minestrappolation.extraores.lib;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.block.*;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;


public class EONameManager 

{

	//Load using method or constructor, depending on situation
	
	public EONameManager()
	{
		loadNames();
	}
	
	public static void loadNames()
	{
		//TODO: Change LanguageRegistry to LanguageRegistry
		LanguageRegistry.addName(EOBlockManager.meuroditeOre, "Meurodite Ore");

		LanguageRegistry.addName(EOBlockManager.meuroditeBlock, "Block of Meurodite");
		LanguageRegistry.addName(EOItemManager.meuroditeIngot, "Meurodite Gem");
		
		LanguageRegistry.addName(EOItemManager.meuroditeSword, "Meurodite Sword");
		LanguageRegistry.addName(EOItemManager.meuroditePickaxe, "Meurodite Pickaxe");
		LanguageRegistry.addName(EOItemManager.meuroditeShovel, "Meurodite Shovel");
		LanguageRegistry.addName(EOItemManager.meuroditeHoe, "Meurodite Hoe");
		LanguageRegistry.addName(EOItemManager.meuroditeAxe, "Meurodite Axe");
		
		LanguageRegistry.addName(EOItemManager.meuroditeHelmet, "Meurodite Helmet");
		LanguageRegistry.addName(EOItemManager.meuroditeChest, "Meurodite Chestplate");
		LanguageRegistry.addName(EOItemManager.meuroditePants, "Meurodite Leggings");
		LanguageRegistry.addName(EOItemManager.meuroditeBoots, "Meurodite Boots");
		LanguageRegistry.addName(EOBlockManager.meuroditePlate, "Block of Meurodite");
		LanguageRegistry.addName(EOItemManager.meuroditePlateItem, "Meurodite Plate");
		

		LanguageRegistry.addName(EOBlockManager.UraniumOre, "Uranium Ore");
		LanguageRegistry.addName(EOItemManager.Uranium, "Uranium");
		LanguageRegistry.addName(EOBlockManager.RawUraniumBlock, "Raw Uranium Block");

		LanguageRegistry.addName(EOBlockManager.PlutoniumOre, "Plutonium Ore");
		LanguageRegistry.addName(EOItemManager.Plutonium, "Plutonium");
		LanguageRegistry.addName(EOBlockManager.RawPlutoniumBlock, "Raw Plutonium Block");

		LanguageRegistry.addName(EOBlockManager.TitaniumOre, "Titanium Ore");
		LanguageRegistry.addName(EOItemManager.TitaniumIngot, "Titanium Ingot");
		
		LanguageRegistry.addName(EOItemManager.TitaniumAxe, "Titanium Axe");
		LanguageRegistry.addName(EOItemManager.TitaniumHoe, "Titanium Hoe");
		LanguageRegistry.addName(EOItemManager.TitaniumPickaxe, "Titanium Pickaxe");
		LanguageRegistry.addName(EOItemManager.TitaniumShovel, "Titanium Shovel");
		LanguageRegistry.addName(EOItemManager.TitaniumSword, "Titanium Sword");
		
		LanguageRegistry.addName(EOItemManager.TitaniumHelmet, "Titanium Helmet");
		LanguageRegistry.addName(EOItemManager.TitaniumChest, "Titanium Chestplate");
		LanguageRegistry.addName(EOItemManager.TitaniumPants, "Titanium Leggings");
		LanguageRegistry.addName(EOItemManager.TitaniumBoots, "Titanium Boots");
		

		LanguageRegistry.addName(EOBlockManager.TitaniumBlock, "Block of Titanium");
		

		LanguageRegistry.addName(EOBlockManager.Sunstone, "Sunstone");
		LanguageRegistry.addName(EOItemManager.SunstoneDust, "Sunstone Dust");
		LanguageRegistry.addName(EOBlockManager.SunstoneOre, "Sunstone Ore");
		

		LanguageRegistry.addName(EOBlockManager.ToriteOre, "Torite Ore");
		LanguageRegistry.addName(EOItemManager.ToriteIngot, "Torite Ingot");

		LanguageRegistry.addName(EOBlockManager.ToriteBlock, "Block of Torite");
		
		LanguageRegistry.addName(EOItemManager.ToriteAxe, "Torite Axe");
		LanguageRegistry.addName(EOItemManager.ToriteHoe, "Torite Hoe");
		LanguageRegistry.addName(EOItemManager.ToritePickaxe, "Torite Pickaxe");
		LanguageRegistry.addName(EOItemManager.ToriteShovel, "Torite Shovel");
		LanguageRegistry.addName(EOItemManager.ToriteSword, "Torite Sword");
		
		LanguageRegistry.addName(EOItemManager.ToriteHelmet, "Torite Helmet");
		LanguageRegistry.addName(EOItemManager.ToriteChest, "Torite Chestplate");
		LanguageRegistry.addName(EOItemManager.ToritePants, "Torite Leggings");
		LanguageRegistry.addName(EOItemManager.ToriteBoots, "Torite Boots");
		

		LanguageRegistry.addName(EOBlockManager.Granite, "Granite");

		LanguageRegistry.addName(EOBlockManager.GraniteBrick, "Granite Bricks");
		

		LanguageRegistry.addName(EOBlockManager.Quartzite, "Desert Quartz Block");

		LanguageRegistry.addName(EOBlockManager.QuartziteTile, "Rough Desert Quartz Tile");
		

		LanguageRegistry.addName(EOBlockManager.BlaziumOre, "Blazium Ore");
		

		LanguageRegistry.addName(EOBlockManager.BlaziumBlock, "Block of Blazium");
		LanguageRegistry.addName(EOItemManager.BlaziumIngot, "Blazium Ingot");
		LanguageRegistry.addName(EOItemManager.BlazeShard, "Blaze Shard");
		
		LanguageRegistry.addName(EOItemManager.BlaziumAxe, "Fire Axe");
		LanguageRegistry.addName(EOItemManager.BlaziumHoe, "Fire Hoe");
		LanguageRegistry.addName(EOItemManager.BlaziumPickaxe, "Fire Pickaxe");
		LanguageRegistry.addName(EOItemManager.BlaziumShovel, "Fire Shovel");
		LanguageRegistry.addName(EOItemManager.BlaziumSword, "Fire Sword");
		
		LanguageRegistry.addName(EOItemManager.BlaziumHelmet, "Fire Helmet");
		LanguageRegistry.addName(EOItemManager.BlaziumChest, "Fire Chestplate");
		LanguageRegistry.addName(EOItemManager.BlaziumPants, "Fire Leggings");
		LanguageRegistry.addName(EOItemManager.BlaziumBoots, "Fire Boots");
		

		LanguageRegistry.addName(EOBlockManager.CopperOre, "Copper Ore (Minestrappolation)");

		LanguageRegistry.addName(EOBlockManager.CopperBlock, "Block of Copper (Minestrappolation)");
		LanguageRegistry.addName(EOItemManager.CopperIngot, "Copper Ingot (Minestrappolation)");
		
		LanguageRegistry.addName(EOBlockManager.CopperBlockTarnished, "Tarnished Copper Block");
		
		LanguageRegistry.addName(EOItemManager.CopperAxe, "Copper Axe");
		LanguageRegistry.addName(EOItemManager.CopperHoe, "Copper Hoe");
		LanguageRegistry.addName(EOItemManager.CopperPickaxe, "Copper Pickaxe");
		LanguageRegistry.addName(EOItemManager.CopperShovel, "Copper Shovel");
		LanguageRegistry.addName(EOItemManager.CopperSword, "Copper Sword");
		

		LanguageRegistry.addName(EOBlockManager.TinOre, "Tin Ore (Minestrappolation)");
		LanguageRegistry.addName(EOBlockManager.TinBlock, "Block of Tin (Minestrappolation)");
		LanguageRegistry.addName(EOItemManager.TinIngot, "Tin Ingot (Minestrappolation)");
		
		LanguageRegistry.addName(EOItemManager.TinHelmet, "Tin Helmet");
		LanguageRegistry.addName(EOItemManager.TinChest, "Tin Chestplate");
		LanguageRegistry.addName(EOItemManager.TinPants, "Tin Leggings");
		LanguageRegistry.addName(EOItemManager.TinBoots, "Tin Boots");
		
		LanguageRegistry.addName(EOBlockManager.TinPlate, "Block of Tin (Minestrappolation)");
		LanguageRegistry.addName(EOBlockManager.BronzePlate, "Bronze Plate Block");
		LanguageRegistry.addName(EOBlockManager.SteelPlate, "Steel Plate Block");
		LanguageRegistry.addName(EOItemManager.TinPlateItem, "Tin Plate");
		LanguageRegistry.addName(EOItemManager.BronzePlateItem, "Bronze Plate");
		LanguageRegistry.addName(EOItemManager.SteelPlateItem, "Steel Plate");
		
		LanguageRegistry.addName(EOItemManager.CoalIronIngot, "Coal-Coated Iron Ingot");
		LanguageRegistry.addName(EOItemManager.SteelIngot, "Steel Ingot");
		LanguageRegistry.addName(EOItemManager.SteelPickaxe, "Steel Pickaxe");
		LanguageRegistry.addName(EOItemManager.SteelShovel, "Steel Shovel");
		LanguageRegistry.addName(EOItemManager.SteelAxe, "Steel Axe");
		LanguageRegistry.addName(EOItemManager.SteelHoe, "Steel Hoe");
		LanguageRegistry.addName(EOItemManager.SteelSword, "Steel Sword");
		LanguageRegistry.addName(EOItemManager.SteelHelmet, "Steel Helmet");
		LanguageRegistry.addName(EOItemManager.SteelChest, "Steel Chestplate");
		LanguageRegistry.addName(EOItemManager.SteelPants, "Steel Leggings");
		LanguageRegistry.addName(EOItemManager.SteelBoots, "Steel Boots");
		LanguageRegistry.addName(EOBlockManager.SteelBlock, "Block of Steel");
		
		LanguageRegistry.addName(EOBlockManager.SoulOre, "Soul Ore");
		LanguageRegistry.addName(EOBlockManager.SoulGem, "Soul Gem");
		
		LanguageRegistry.addName(EOBlockManager.SmoothQuartzite, "Smooth Desert Quartz Block");
		LanguageRegistry.addName(EOBlockManager.PillarQuartzite, "Desert Quartz Pillar");
		LanguageRegistry.addName(EOBlockManager.ChiseledQuartzite, "Chiseled Desert Quartz Block");
		LanguageRegistry.addName(EOBlockManager.SmoothQuartzTile, "Refined Desert Quartz Tile");
		LanguageRegistry.addName(EOItemManager.PinkQuartz, "Desert Quartz");
		
		LanguageRegistry.addName(EOItemManager.SandstonePickaxe, "Sandstone Pickaxe");
		LanguageRegistry.addName(EOItemManager.SandstoneShovel, "Sandstone Shovel");
		LanguageRegistry.addName(EOItemManager.SandstoneAxe, "Sandstone Axe");
		LanguageRegistry.addName(EOItemManager.SandstoneHoe, "Sandstone Hoe");
		LanguageRegistry.addName(EOItemManager.SandstoneSword, "Sandstone Sword");
		
		LanguageRegistry.addName(EOBlockManager.TinPlatedCobble, "Tin-Plated Cobblestone");
		LanguageRegistry.addName(EOBlockManager.TinPlatedMossy, "Mossy Tin-Plated Cobblestone");
		LanguageRegistry.addName(EOBlockManager.TinPlatedStoneBrick, "Tin-Plated Stone Bricks");
		LanguageRegistry.addName(EOBlockManager.TinPlatedChiseled, "Tin-Plated Chiseled Stone Bricks");
		LanguageRegistry.addName(EOBlockManager.TinPlatedGranite, "Tin-Plated Granite Bricks");
		
		LanguageRegistry.addName(EOItemManager.BronzeIngot, "Bronze Ingot");
		LanguageRegistry.addName(EOItemManager.BronzePickaxe, "Bronze Pickaxe");
		LanguageRegistry.addName(EOItemManager.BronzeShovel, "Bronze Shovel");
		LanguageRegistry.addName(EOItemManager.BronzeAxe, "Bronze Axe");
		LanguageRegistry.addName(EOItemManager.BronzeHoe, "Bronze Hoe");
		LanguageRegistry.addName(EOItemManager.BronzeSword, "Bronze Sword");
		LanguageRegistry.addName(EOItemManager.BronzeHelmet, "Bronze Helmet");
		LanguageRegistry.addName(EOItemManager.BronzeChest, "Bronze Chestplate");
		LanguageRegistry.addName(EOItemManager.BronzePants, "Bronze Leggings");
		LanguageRegistry.addName(EOItemManager.BronzeBoots, "Bronze Boots");
		LanguageRegistry.addName(EOBlockManager.BronzeBlock, "Block of Bronze");
		
		LanguageRegistry.addName(EOBlockManager.BronzePlatedCobble, "Bronze-Plated Cobblestone");
		LanguageRegistry.addName(EOBlockManager.BronzePlatedMossy, "Mossy Bronze-Plated Cobblestone");
		LanguageRegistry.addName(EOBlockManager.BronzePlatedStoneBrick, "Bronze-Plated Stone Bricks");
		LanguageRegistry.addName(EOBlockManager.BronzePlatedChiseled, "Bronze-Plated Chiseled Stone Bricks");
		LanguageRegistry.addName(EOBlockManager.BronzePlatedGranite, "Bronze-Plated Granite Bricks");
		
		LanguageRegistry.addName(EOBlockManager.Invincium, "Invincium");
		LanguageRegistry.addName(EOItemManager.BedrockPickaxe, "Bedrock Pickaxe");
		LanguageRegistry.addName(EOItemManager.BedrockShovel, "Bedrock Shovel");
		LanguageRegistry.addName(EOItemManager.BedrockAxe, "Bedrock Axe");
		LanguageRegistry.addName(EOItemManager.BedrockHoe, "Bedrock Hoe");
		
		LanguageRegistry.addName(EOBlockManager.SteelPlatedCobble, "Steel-Plated Cobblestone");
		LanguageRegistry.addName(EOBlockManager.SteelPlatedMossy, "Mossy Steel-Plated Cobblestone");
		LanguageRegistry.addName(EOBlockManager.SteelPlatedStoneBrick, "Steel-Plated Stone Bricks");
		LanguageRegistry.addName(EOBlockManager.SteelPlatedChiseled, "Steel-Plated Chiseled Stone Bricks");
		LanguageRegistry.addName(EOBlockManager.SteelPlatedGranite, "Steel-Plated Granite Bricks");
		
		LanguageRegistry.addName(EOItemManager.GranitePickaxe, "Granite Pickaxe");
		LanguageRegistry.addName(EOItemManager.GraniteShovel, "Granite Shovel");
		LanguageRegistry.addName(EOItemManager.GraniteAxe, "Granite Axe");
		LanguageRegistry.addName(EOItemManager.GraniteHoe, "Granite Hoe");
		LanguageRegistry.addName(EOItemManager.GraniteSword, "Granite Sword");
		
		LanguageRegistry.addName(EOBlockManager.SoulBottle, "Soul Bottle");
		
		LanguageRegistry.addName(EOBlockManager.nuke, "Nuke");
		LanguageRegistry.addName(EOItemManager.grenade, "Nuclear Grenade");
		LanguageRegistry.addName(EOItemManager.grenadeImpact, "Impact Grenade");
		LanguageRegistry.addName(EOItemManager.grenadeSticky, "Sticky Grenade");
		
		LanguageRegistry.addName(EOBlockManager.melterIdle, "Melter");
			
		
		LanguageRegistry.addName(EOItemManager.BPMeuroditeSword, "Bronze-Plated Meurodite Sword");
		LanguageRegistry.addName(EOItemManager.BPMeuroditePickaxe, "Bronze-Plated Meurodite Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPMeuroditeShovel, "Bronze-Plated Meurodite Shovel");
		LanguageRegistry.addName(EOItemManager.BPMeuroditeHoe, "Bronze-Plated Meurodite Hoe");
		LanguageRegistry.addName(EOItemManager.BPMeuroditeAxe, "Bronze-Plated Meurodite Axe");
		
		LanguageRegistry.addName(EOItemManager.BPMeuroditeHelmet, "Bronze-Plated Meurodite Helmet");
		LanguageRegistry.addName(EOItemManager.BPMeuroditeChest, "Bronze-Plated Meurodite Chestplate");
		LanguageRegistry.addName(EOItemManager.BPMeuroditePants, "Bronze-Plated Meurodite Leggings");
		LanguageRegistry.addName(EOItemManager.BPMeuroditeBoots, "Bronze-Plated Meurodite Boots");
		
		LanguageRegistry.addName(EOItemManager.BPTitaniumAxe, "Bronze-Plated Titanium Axe");
		LanguageRegistry.addName(EOItemManager.BPTitaniumHoe, "Bronze-Plated Titanium Hoe");
		LanguageRegistry.addName(EOItemManager.BPTitaniumPickaxe, "Bronze-Plated Titanium Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPTitaniumShovel, "Bronze-Plated Titanium Shovel");
		LanguageRegistry.addName(EOItemManager.BPTitaniumSword, "Bronze-Plated Titanium Sword");
		
		LanguageRegistry.addName(EOItemManager.BPTitaniumHelmet, "Bronze-Plated Titanium Helmet");
		LanguageRegistry.addName(EOItemManager.BPTitaniumChest, "Bronze-Plated Titanium Chestplate");
		LanguageRegistry.addName(EOItemManager.BPTitaniumPants, "Bronze-Plated Titanium Leggings");
		LanguageRegistry.addName(EOItemManager.BPTitaniumBoots, "Bronze-Plated Titanium Boots");
		
		LanguageRegistry.addName(EOItemManager.BPToriteAxe, "Bronze-Plated Torite Axe");
		LanguageRegistry.addName(EOItemManager.BPToriteHoe, "Bronze-Plated Torite Hoe");
		LanguageRegistry.addName(EOItemManager.BPToritePickaxe, "Bronze-Plated Torite Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPToriteShovel, "Bronze-Plated Torite Shovel");
		LanguageRegistry.addName(EOItemManager.BPToriteSword, "Bronze-Plated Torite Sword");
		
		LanguageRegistry.addName(EOItemManager.BPToriteHelmet, "Bronze-Plated Torite Helmet");
		LanguageRegistry.addName(EOItemManager.BPToriteChest, "Bronze-Plated Torite Chestplate");
		LanguageRegistry.addName(EOItemManager.BPToritePants, "Bronze-Plated Torite Leggings");
		LanguageRegistry.addName(EOItemManager.BPToriteBoots, "Bronze-Plated Torite Boots");
		
		LanguageRegistry.addName(EOItemManager.BPBlaziumAxe, "Bronze-Plated Fire Axe");
		LanguageRegistry.addName(EOItemManager.BPBlaziumHoe, "Bronze-Plated Fire Hoe");
		LanguageRegistry.addName(EOItemManager.BPBlaziumPickaxe, "Bronze-Plated Fire Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPBlaziumShovel, "Bronze-Plated Fire Shovel");
		LanguageRegistry.addName(EOItemManager.BPBlaziumSword, "Bronze-Plated Fire Sword");
		
		LanguageRegistry.addName(EOItemManager.BPBlaziumHelmet, "Bronze-Plated Fire Helmet");
		LanguageRegistry.addName(EOItemManager.BPBlaziumChest, "Bronze-Plated Fire Chestplate");
		LanguageRegistry.addName(EOItemManager.BPBlaziumPants, "Bronze-Plated Fire Leggings");
		LanguageRegistry.addName(EOItemManager.BPBlaziumBoots, "Bronze-Plated Fire Boots");
		
		LanguageRegistry.addName(EOItemManager.BPCopperAxe, "Bronze-Plated Copper Axe");
		LanguageRegistry.addName(EOItemManager.BPCopperHoe, "Bronze-Plated Copper Hoe");
		LanguageRegistry.addName(EOItemManager.BPCopperPickaxe, "Bronze-Plated Copper Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPCopperShovel, "Bronze-Plated Copper Shovel");
		LanguageRegistry.addName(EOItemManager.BPCopperSword, "Bronze-Plated Copper Sword");
		
		LanguageRegistry.addName(EOItemManager.BPTinHelmet, "Bronze-Plated Tin Helmet");
		LanguageRegistry.addName(EOItemManager.BPTinChest, "Bronze-Plated Tin Chestplate");
		LanguageRegistry.addName(EOItemManager.BPTinPants, "Bronze-Plated Tin Leggings");
		LanguageRegistry.addName(EOItemManager.BPTinBoots, "Bronze-Plated Tin Boots");
		
		LanguageRegistry.addName(EOItemManager.BPSteelPickaxe, "Bronze-Plated Steel Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPSteelShovel, "Bronze-Plated Steel Shovel");
		LanguageRegistry.addName(EOItemManager.BPSteelAxe, "Bronze-Plated Steel Axe");
		LanguageRegistry.addName(EOItemManager.BPSteelHoe, "Bronze-Plated Steel Hoe");
		LanguageRegistry.addName(EOItemManager.BPSteelSword, "Bronze-Plated Steel Sword");
		
		LanguageRegistry.addName(EOItemManager.BPSteelHelmet, "Bronze-Plated Steel Helmet");
		LanguageRegistry.addName(EOItemManager.BPSteelChest, "Bronze-Plated Steel Chestplate");
		LanguageRegistry.addName(EOItemManager.BPSteelPants, "Bronze-Plated Steel Leggings");
		LanguageRegistry.addName(EOItemManager.BPSteelBoots, "Bronze-Plated Steel Boots");
		
		LanguageRegistry.addName(EOItemManager.BPSandstonePickaxe, "Bronze-Plated Sandstone Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPSandstoneShovel, "Bronze-Plated Sandstone Shovel");
		LanguageRegistry.addName(EOItemManager.BPSandstoneAxe, "Bronze-Plated Sandstone Axe");
		LanguageRegistry.addName(EOItemManager.BPSandstoneHoe, "Bronze-Plated Sandstone Hoe");
		LanguageRegistry.addName(EOItemManager.BPSandstoneSword, "Bronze-Plated Sandstone Sword");
		
		LanguageRegistry.addName(EOItemManager.BPBedrockPickaxe, "Bronze-Plated Bedrock Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPBedrockShovel, "Bronze-Plated Bedrock Shovel");
		LanguageRegistry.addName(EOItemManager.BPBedrockAxe, "Bronze-Plated Bedrock Axe");
		LanguageRegistry.addName(EOItemManager.BPBedrockHoe, "Bronze-Plated Bedrock Hoe");
		
		LanguageRegistry.addName(EOItemManager.BPGranitePickaxe, "Bronze-Plated Granite Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPGraniteShovel, "Bronze-Plated Granite Shovel");
		LanguageRegistry.addName(EOItemManager.BPGraniteAxe, "Bronze-Plated Granite Axe");
		LanguageRegistry.addName(EOItemManager.BPGraniteHoe, "Bronze-Plated Granite Hoe");
		LanguageRegistry.addName(EOItemManager.BPGraniteSword, "Bronze-Plated Granite Sword");
		
		LanguageRegistry.addName(EOItemManager.BPWoodAxe, "Bronze-Plated Wood Axe");
		LanguageRegistry.addName(EOItemManager.BPWoodHoe, "Bronze-Plated Wood Hoe");
		LanguageRegistry.addName(EOItemManager.BPWoodPickaxe, "Bronze-Plated Wood Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPWoodShovel, "Bronze-Plated Wood Shovel");
		LanguageRegistry.addName(EOItemManager.BPWoodSword, "Bronze-Plated Wood Sword");
		
		LanguageRegistry.addName(EOItemManager.BPClothHelmet, "Bronze-Plated Cloth Helmet");
		LanguageRegistry.addName(EOItemManager.BPClothChest, "Bronze-Plated Cloth Chestplate");
		LanguageRegistry.addName(EOItemManager.BPClothPants, "Bronze-Plated Cloth Leggings");
		LanguageRegistry.addName(EOItemManager.BPClothBoots, "Bronze-Plated Cloth Boots");
		
		LanguageRegistry.addName(EOItemManager.BPStoneAxe, "Bronze-Plated Stone Axe");
		LanguageRegistry.addName(EOItemManager.BPStoneHoe, "Bronze-Plated Stone Hoe");
		LanguageRegistry.addName(EOItemManager.BPStonePickaxe, "Bronze-Plated Stone Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPStoneShovel, "Bronze-Plated Stone Shovel");
		LanguageRegistry.addName(EOItemManager.BPStoneSword, "Bronze-Plated Stone Sword");
		
		LanguageRegistry.addName(EOItemManager.BPChainHelmet, "Bronze-Plated Chain Helmet");
		LanguageRegistry.addName(EOItemManager.BPChainChest, "Bronze-Plated Chain Chestplate");
		LanguageRegistry.addName(EOItemManager.BPChainPants, "Bronze-Plated Chain Leggings");
		LanguageRegistry.addName(EOItemManager.BPChainBoots, "Bronze-Plated Chain Boots");
		
		LanguageRegistry.addName(EOItemManager.BPIronAxe, "Bronze-Plated Iron Axe");
		LanguageRegistry.addName(EOItemManager.BPIronHoe, "Bronze-Plated Iron Hoe");
		LanguageRegistry.addName(EOItemManager.BPIronPickaxe, "Bronze-Plated Iron Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPIronShovel, "Bronze-Plated Iron Shovel");
		LanguageRegistry.addName(EOItemManager.BPIronSword, "Bronze-Plated Iron Sword");
		
		LanguageRegistry.addName(EOItemManager.BPIronHelmet, "Bronze-Plated Iron Helmet");
		LanguageRegistry.addName(EOItemManager.BPIronChest, "Bronze-Plated Iron Chestplate");
		LanguageRegistry.addName(EOItemManager.BPIronPants, "Bronze-Plated Iron Leggings");
		LanguageRegistry.addName(EOItemManager.BPIronBoots, "Bronze-Plated Iron Boots");
		
		LanguageRegistry.addName(EOItemManager.BPGoldAxe, "Bronze-Plated Gold Axe");
		LanguageRegistry.addName(EOItemManager.BPGoldHoe, "Bronze-Plated Gold Hoe");
		LanguageRegistry.addName(EOItemManager.BPGoldPickaxe, "Bronze-Plated Gold Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPGoldShovel, "Bronze-Plated Gold Shovel");
		LanguageRegistry.addName(EOItemManager.BPGoldSword, "Bronze-Plated Gold Sword");
		
		LanguageRegistry.addName(EOItemManager.BPGoldHelmet, "Bronze-Plated Gold Helmet");
		LanguageRegistry.addName(EOItemManager.BPGoldChest, "Bronze-Plated Gold Chestplate");
		LanguageRegistry.addName(EOItemManager.BPGoldPants, "Bronze-Plated Gold Leggings");
		LanguageRegistry.addName(EOItemManager.BPGoldBoots, "Bronze-Plated Gold Boots");
		
		LanguageRegistry.addName(EOItemManager.BPDiamondAxe, "Bronze-Plated Diamond Axe");
		LanguageRegistry.addName(EOItemManager.BPDiamondHoe, "Bronze-Plated Diamond Hoe");
		LanguageRegistry.addName(EOItemManager.BPDiamondPickaxe, "Bronze-Plated Diamond Pickaxe");
		LanguageRegistry.addName(EOItemManager.BPDiamondShovel, "Bronze-Plated Diamond Shovel");
		LanguageRegistry.addName(EOItemManager.BPDiamondSword, "Bronze-Plated Diamond Sword");
		
		LanguageRegistry.addName(EOItemManager.BPDiamondHelmet, "Bronze-Plated Diamond Helmet");
		LanguageRegistry.addName(EOItemManager.BPDiamondChest, "Bronze-Plated Diamond Chestplate");
		LanguageRegistry.addName(EOItemManager.BPDiamondPants, "Bronze-Plated Diamond Leggings");
		LanguageRegistry.addName(EOItemManager.BPDiamondBoots, "Bronze-Plated Diamond Boots");
		
		
		
		LanguageRegistry.addName(EOBlockManager.SmoothRadiantQuartz, "Smooth Radiant Quartz Block");
		LanguageRegistry.addName(EOBlockManager.PillarRadiantQuartz, "Radiant Quartz Pillar");
		LanguageRegistry.addName(EOBlockManager.ChiseledRadiantQuartz, "Chiseled Radiant Quartz Block");
		LanguageRegistry.addName(EOBlockManager.RadiantQuartzOre, "Radiant Quartz Ore");
		LanguageRegistry.addName(EOBlockManager.RadiantQuartz, "Radiant Quartz");
		
		LanguageRegistry.addName(EOBlockManager.Godstone, "Godstone");
		
		LanguageRegistry.addName(EOBlockManager.RadiantQuartzStairs, "Radiant Quartz Stairs");
		
		LanguageRegistry.addName(EOBlockManager.PinkQuartzStairs, "Desert Quartz Stairs");
		
		LanguageRegistry.addName(EOBlockManager.RadiantQuartzDoubleSlab,"Radiant Quartz DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((RadiantQuartzSlab)EOBlockManager.RadiantQuartzSingleSlab).getFullSlabName(0)+".name", "Radiant Quartz Slab");
	
		LanguageRegistry.addName(EOBlockManager.PinkQuartzDoubleSlab,"Desert Quartz DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((PinkQuartzSlab)EOBlockManager.PinkQuartzSingleSlab).getFullSlabName(0)+".name", "Desert Quartz Slab");
	
		LanguageRegistry.addName(EOBlockManager.graniteBrickStairs, "Granite Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.graniteBrickDoubleSlab,"Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((GraniteBrickSlab)EOBlockManager.graniteBrickSingleSlab).getFullSlabName(0)+".name", "Granite Brick Slab");
		
		LanguageRegistry.addName(EOBlockManager.tinPlatedCobbleStairs, "Tin Plated Cobble Stairs");
		
		LanguageRegistry.addName(EOBlockManager.tinPlatedCobbleDoubleSlab,"Tin Plated Cobble DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((TinPlatedCobbleSlab)EOBlockManager.tinPlatedCobbleSingleSlab).getFullSlabName(0)+".name", "Tin Plated Cobble Slab");
		
		LanguageRegistry.addName(EOBlockManager.steelPlatedCobbleStairs, "Steel Plated Cobble Stairs");
		
		LanguageRegistry.addName(EOBlockManager.steelPlatedCobbleDoubleSlab,"Steel Plated Cobble DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((SteelPlatedCobbleSlab)EOBlockManager.steelPlatedCobbleSingleSlab).getFullSlabName(0)+".name", "Steel Plated Cobble Slab");
		
		LanguageRegistry.addName(EOBlockManager.bronzePlatedCobbleStairs, "Bronze Plated Cobble Stairs");
		
		LanguageRegistry.addName(EOBlockManager.bronzePlatedCobbleDoubleSlab,"Bronze Plated Cobble DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((BronzePlatedCobbleSlab)EOBlockManager.bronzePlatedCobbleSingleSlab).getFullSlabName(0)+".name", "Bronze Plated Cobble Slab");	
	
		LanguageRegistry.addName(EOBlockManager.tinPlatedStoneBrickStairs, "Tin Plated Stone Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.tinPlatedStoneBrickDoubleSlab,"Tin Plated Stone Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((TinPlatedStoneBrickSlab)EOBlockManager.tinPlatedStoneBrickSingleSlab).getFullSlabName(0)+".name", "Tin Plated Stone Brick Slab");	
		
		LanguageRegistry.addName(EOBlockManager.steelPlatedStoneBrickStairs, "Steel Plated Stone Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.steelPlatedStoneBrickDoubleSlab,"Steel Plated Stone Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((SteelPlatedStoneBrickSlab)EOBlockManager.steelPlatedStoneBrickSingleSlab).getFullSlabName(0)+".name", "Steel Plated Stone Brick Slab");	
		
		LanguageRegistry.addName(EOBlockManager.bronzePlatedStoneBrickStairs, "Bronze Plated Stone Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.bronzePlatedStoneBrickDoubleSlab,"Bronze Plated Stone Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((BronzePlatedStoneBrickSlab)EOBlockManager.bronzePlatedStoneBrickSingleSlab).getFullSlabName(0)+".name", "Bronze Plated Stone Brick Slab");	
		
		LanguageRegistry.addName(EOBlockManager.tinPlatedGraniteBrickStairs, "Tin Plated Granite Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.tinPlatedGraniteBrickDoubleSlab,"Tin Plated Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((TinPlatedGraniteBrickSlab)EOBlockManager.tinPlatedGraniteBrickSingleSlab).getFullSlabName(0)+".name", "Tin Plated Granite Brick Slab");	
		
		LanguageRegistry.addName(EOBlockManager.steelPlatedGraniteBrickStairs, "Steel Plated Granite Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.steelPlatedGraniteBrickDoubleSlab,"Steel Plated Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((SteelPlatedGraniteBrickSlab)EOBlockManager.steelPlatedGraniteBrickSingleSlab).getFullSlabName(0)+".name", "Steel Plated Granite Brick Slab");	
		
		LanguageRegistry.addName(EOBlockManager.bronzePlatedGraniteBrickStairs, "Bronze Plated Granite Brick Stairs");
		
		LanguageRegistry.addName(EOBlockManager.bronzePlatedGraniteBrickDoubleSlab,"Bronze Plated Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((BronzePlatedGraniteBrickSlab)EOBlockManager.bronzePlatedGraniteBrickSingleSlab).getFullSlabName(0)+".name", "Bronze Plated Granite Brick Slab");	
		
		LanguageRegistry.addName(EOBlockManager.plutoniumInsulated, "Insulated Plutonium Block");
		LanguageRegistry.addName(EOBlockManager.uraniumInsulated, "Insulated Uranium Block");
	
		LanguageRegistry.addName(EOBlockManager.magma, "Magma");
		LanguageRegistry.addName(EOItemManager.bucketMagma, "Bucket of Magma");

	}
	
}
