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
		ModLoader.addName(ExtraOres.meuroditeOre, "Meurodite Ore");

		ModLoader.addName(ExtraOres.meuroditeBlock, "Block of Meurodite");
		ModLoader.addName(ExtraOres.meuroditeIngot, "Meurodite Gem");
		
		ModLoader.addName(ExtraOres.meuroditeSword, "Meurodite Sword");
		ModLoader.addName(ExtraOres.meuroditePickaxe, "Meurodite Pickaxe");
		ModLoader.addName(ExtraOres.meuroditeShovel, "Meurodite Shovel");
		ModLoader.addName(ExtraOres.meuroditeHoe, "Meurodite Hoe");
		ModLoader.addName(ExtraOres.meuroditeAxe, "Meurodite Axe");
		
		ModLoader.addName(ExtraOres.meuroditeHelmet, "Meurodite Helmet");
		ModLoader.addName(ExtraOres.meuroditeChest, "Meurodite Chestplate");
		ModLoader.addName(ExtraOres.meuroditePants, "Meurodite Leggings");
		ModLoader.addName(ExtraOres.meuroditeBoots, "Meurodite Boots");
		

		ModLoader.addName(ExtraOres.UraniumOre, "Uranium Ore");
		ModLoader.addName(ExtraOres.Uranium, "Uranium");
		ModLoader.addName(ExtraOres.RawUraniumBlock, "Raw Uranium Block");

		ModLoader.addName(ExtraOres.PlutoniumOre, "Plutonium Ore");
		ModLoader.addName(ExtraOres.Plutonium, "Plutonium");
		ModLoader.addName(ExtraOres.RawPlutoniumBlock, "Raw Plutonium Block");

		ModLoader.addName(ExtraOres.TitaniumOre, "Titanium Ore");
		ModLoader.addName(ExtraOres.TitaniumIngot, "Titanium Ingot");
		
		ModLoader.addName(ExtraOres.TitaniumAxe, "Titanium Axe");
		ModLoader.addName(ExtraOres.TitaniumHoe, "Titanium Hoe");
		ModLoader.addName(ExtraOres.TitaniumPickaxe, "Titanium Pickaxe");
		ModLoader.addName(ExtraOres.TitaniumShovel, "Titanium Shovel");
		ModLoader.addName(ExtraOres.TitaniumSword, "Titanium Sword");
		
		ModLoader.addName(ExtraOres.TitaniumHelmet, "Titanium Helmet");
		ModLoader.addName(ExtraOres.TitaniumChest, "Titanium Chestplate");
		ModLoader.addName(ExtraOres.TitaniumPants, "Titanium Leggings");
		ModLoader.addName(ExtraOres.TitaniumBoots, "Titanium Boots");
		

		ModLoader.addName(ExtraOres.TitaniumBlock, "Block of Titanium");
		

		ModLoader.addName(ExtraOres.Sunstone, "Sunstone");
		ModLoader.addName(ExtraOres.SunstoneDust, "Sunstone Dust");
		ModLoader.addName(ExtraOres.SunstoneOre, "Sunstone Ore");
		

		ModLoader.addName(ExtraOres.ToriteOre, "Torite Ore");
		ModLoader.addName(ExtraOres.ToriteIngot, "Torite Ingot");

		ModLoader.addName(ExtraOres.ToriteBlock, "Block of Torite");
		
		ModLoader.addName(ExtraOres.ToriteAxe, "Torite Axe");
		ModLoader.addName(ExtraOres.ToriteHoe, "Torite Hoe");
		ModLoader.addName(ExtraOres.ToritePickaxe, "Torite Pickaxe");
		ModLoader.addName(ExtraOres.ToriteShovel, "Torite Shovel");
		ModLoader.addName(ExtraOres.ToriteSword, "Torite Sword");
		
		ModLoader.addName(ExtraOres.ToriteHelmet, "Torite Helmet");
		ModLoader.addName(ExtraOres.ToriteChest, "Torite Chestplate");
		ModLoader.addName(ExtraOres.ToritePants, "Torite Leggings");
		ModLoader.addName(ExtraOres.ToriteBoots, "Torite Boots");
		

		ModLoader.addName(ExtraOres.Granite, "Granite");

		ModLoader.addName(ExtraOres.GraniteBrick, "Granite Brick");
		

		ModLoader.addName(ExtraOres.Quartzite, "Desert Quartz Block");

		ModLoader.addName(ExtraOres.QuartziteTile, "Rough Desert Quartz Tile");
		

		ModLoader.addName(ExtraOres.BlaziumOre, "Blazium Ore");
		

		ModLoader.addName(ExtraOres.BlaziumBlock, "Block of Blazium");
		ModLoader.addName(ExtraOres.BlaziumIngot, "Blazium Ingot");
		ModLoader.addName(ExtraOres.BlazeShard, "Blaze Shard");
		
		ModLoader.addName(ExtraOres.BlaziumAxe, "Fire Axe");
		ModLoader.addName(ExtraOres.BlaziumHoe, "Fire Hoe");
		ModLoader.addName(ExtraOres.BlaziumPickaxe, "Fire Pickaxe");
		ModLoader.addName(ExtraOres.BlaziumShovel, "Fire Shovel");
		ModLoader.addName(ExtraOres.BlaziumSword, "Fire Sword");
		
		ModLoader.addName(ExtraOres.BlaziumHelmet, "Fire Helmet");
		ModLoader.addName(ExtraOres.BlaziumChest, "Fire Chestplate");
		ModLoader.addName(ExtraOres.BlaziumPants, "Fire Leggings");
		ModLoader.addName(ExtraOres.BlaziumBoots, "Fire Boots");
		

		ModLoader.addName(ExtraOres.CopperOre, "Copper Ore (Minestrappolation)");

		ModLoader.addName(ExtraOres.CopperBlock, "Block of Copper (Minestrappolation)");
		ModLoader.addName(ExtraOres.CopperIngot, "Copper Ingot (Minestrappolation)");
		
		ModLoader.addName(ExtraOres.CopperBlockTarnished, "Tarnished Copper Block");
		
		ModLoader.addName(ExtraOres.CopperAxe, "Copper Axe");
		ModLoader.addName(ExtraOres.CopperHoe, "Copper Hoe");
		ModLoader.addName(ExtraOres.CopperPickaxe, "Copper Pickaxe");
		ModLoader.addName(ExtraOres.CopperShovel, "Copper Shovel");
		ModLoader.addName(ExtraOres.CopperSword, "Copper Sword");
		

		ModLoader.addName(ExtraOres.TinOre, "Tin Ore (Minestrappolation)");
		ModLoader.addName(ExtraOres.TinBlock, "Block of Tin (Minestrappolation)");
		ModLoader.addName(ExtraOres.TinIngot, "Tin Ingot (Minestrappolation)");
		
		ModLoader.addName(ExtraOres.TinHelmet, "Tin Helmet");
		ModLoader.addName(ExtraOres.TinChest, "Tin Chestplate");
		ModLoader.addName(ExtraOres.TinPants, "Tin Leggings");
		ModLoader.addName(ExtraOres.TinBoots, "Tin Boots");
		
		ModLoader.addName(ExtraOres.TinPlate, "Tin Plate Block");
		ModLoader.addName(ExtraOres.BronzePlate, "Bronze Plate Block");
		ModLoader.addName(ExtraOres.SteelPlate, "Steel Plate Block");
		ModLoader.addName(ExtraOres.TinPlateItem, "Tin Plate");
		ModLoader.addName(ExtraOres.BronzePlateItem, "Bronze Plate");
		ModLoader.addName(ExtraOres.SteelPlateItem, "Steel Plate");
		
		ModLoader.addName(ExtraOres.CoalIronIngot, "Coal-Coated Iron Ingot");
		ModLoader.addName(ExtraOres.SteelIngot, "Steel Ingot");
		ModLoader.addName(ExtraOres.SteelPickaxe, "Steel Pickaxe");
		ModLoader.addName(ExtraOres.SteelShovel, "Steel Shovel");
		ModLoader.addName(ExtraOres.SteelAxe, "Steel Axe");
		ModLoader.addName(ExtraOres.SteelHoe, "Steel Hoe");
		ModLoader.addName(ExtraOres.SteelSword, "Steel Sword");
		ModLoader.addName(ExtraOres.SteelHelmet, "Steel Helmet");
		ModLoader.addName(ExtraOres.SteelChest, "Steel Chestplate");
		ModLoader.addName(ExtraOres.SteelPants, "Steel Leggings");
		ModLoader.addName(ExtraOres.SteelBoots, "Steel Boots");
		ModLoader.addName(ExtraOres.SteelBlock, "Block of Steel");
		
		ModLoader.addName(ExtraOres.SoulOre, "Soul Ore");
		ModLoader.addName(ExtraOres.SoulGem, "Soul Gem");
		
		ModLoader.addName(ExtraOres.SmoothQuartzite, "Smooth Desert Quartz Block");
		ModLoader.addName(ExtraOres.PillarQuartzite, "Desert Quartz Pillar");
		ModLoader.addName(ExtraOres.ChiseledQuartzite, "Chiseled Desert Quartz Block");
		ModLoader.addName(ExtraOres.SmoothQuartzTile, "Refined Desert Quartz Tile");
		ModLoader.addName(ExtraOres.PinkQuartz, "Desert Quartz");
		
		ModLoader.addName(ExtraOres.SandstonePickaxe, "Sandstone Pickaxe");
		ModLoader.addName(ExtraOres.SandstoneShovel, "Sandstone Shovel");
		ModLoader.addName(ExtraOres.SandstoneAxe, "Sandstone Axe");
		ModLoader.addName(ExtraOres.SandstoneHoe, "Sandstone Hoe");
		ModLoader.addName(ExtraOres.SandstoneSword, "Sandstone Sword");
		
		ModLoader.addName(ExtraOres.TinPlatedCobble, "Tin-Plated Cobblestone");
		ModLoader.addName(ExtraOres.TinPlatedMossy, "Mossy Tin-Plated Cobblestone");
		ModLoader.addName(ExtraOres.TinPlatedStoneBrick, "Tin-Plated Stone Brick");
		ModLoader.addName(ExtraOres.TinPlatedChiseled, "Tin-Plated Chiseled Stone Brick");
		ModLoader.addName(ExtraOres.TinPlatedGranite, "Tin-Plated Granite Brick");
		
		ModLoader.addName(ExtraOres.BronzeIngot, "Bronze Ingot");
		ModLoader.addName(ExtraOres.BronzePickaxe, "Bronze Pickaxe");
		ModLoader.addName(ExtraOres.BronzeShovel, "Bronze Shovel");
		ModLoader.addName(ExtraOres.BronzeAxe, "Bronze Axe");
		ModLoader.addName(ExtraOres.BronzeHoe, "Bronze Hoe");
		ModLoader.addName(ExtraOres.BronzeSword, "Bronze Sword");
		ModLoader.addName(ExtraOres.BronzeHelmet, "Bronze Helmet");
		ModLoader.addName(ExtraOres.BronzeChest, "Bronze Chestplate");
		ModLoader.addName(ExtraOres.BronzePants, "Bronze Leggings");
		ModLoader.addName(ExtraOres.BronzeBoots, "Bronze Boots");
		ModLoader.addName(ExtraOres.BronzeBlock, "Block of Bronze");
		
		ModLoader.addName(ExtraOres.BronzePlatedCobble, "Bronze-Plated Cobblestone");
		ModLoader.addName(ExtraOres.BronzePlatedMossy, "Mossy Bronze-Plated Cobblestone");
		ModLoader.addName(ExtraOres.BronzePlatedStoneBrick, "Bronze-Plated Stone Brick");
		ModLoader.addName(ExtraOres.BronzePlatedChiseled, "Bronze-Plated Chiseled Stone Brick");
		ModLoader.addName(ExtraOres.BronzePlatedGranite, "Bronze-Plated Granite Brick");
		
		ModLoader.addName(ExtraOres.Invincium, "Invincium");
		ModLoader.addName(ExtraOres.BedrockPickaxe, "Bedrock Pickaxe");
		ModLoader.addName(ExtraOres.BedrockShovel, "Bedrock Shovel");
		ModLoader.addName(ExtraOres.BedrockAxe, "Bedrock Axe");
		ModLoader.addName(ExtraOres.BedrockHoe, "Bedrock Hoe");
		
		ModLoader.addName(ExtraOres.SteelPlatedCobble, "Steel-Plated Cobblestone");
		ModLoader.addName(ExtraOres.SteelPlatedMossy, "Mossy Steel-Plated Cobblestone");
		ModLoader.addName(ExtraOres.SteelPlatedStoneBrick, "Steel-Plated Stone Brick");
		ModLoader.addName(ExtraOres.SteelPlatedChiseled, "Steel-Plated Chiseled Stone Brick");
		ModLoader.addName(ExtraOres.SteelPlatedGranite, "Steel-Plated Granite Brick");
		
		ModLoader.addName(ExtraOres.GranitePickaxe, "Granite Pickaxe");
		ModLoader.addName(ExtraOres.GraniteShovel, "Granite Shovel");
		ModLoader.addName(ExtraOres.GraniteAxe, "Granite Axe");
		ModLoader.addName(ExtraOres.GraniteHoe, "Granite Hoe");
		ModLoader.addName(ExtraOres.GraniteSword, "Granite Sword");
		
		ModLoader.addName(ExtraOres.SoulBottle, "Soul Bottle");
		
		ModLoader.addName(ExtraOres.nuke, "Nuke");
		ModLoader.addName(ExtraOres.grenade, "Nuclear Grenade");
		ModLoader.addName(ExtraOres.grenadeImpact, "Impact Grenade");
		ModLoader.addName(ExtraOres.grenadeSticky, "Sticky Grenade");
		
		ModLoader.addName(ExtraOres.melterIdle, "Melter");
			
		
		ModLoader.addName(ExtraOres.BPMeuroditeSword, "Bronze-Plated Meurodite Sword");
		ModLoader.addName(ExtraOres.BPMeuroditePickaxe, "Bronze-Plated Meurodite Pickaxe");
		ModLoader.addName(ExtraOres.BPMeuroditeShovel, "Bronze-Plated Meurodite Shovel");
		ModLoader.addName(ExtraOres.BPMeuroditeHoe, "Bronze-Plated Meurodite Hoe");
		ModLoader.addName(ExtraOres.BPMeuroditeAxe, "Bronze-Plated Meurodite Axe");
		
		ModLoader.addName(ExtraOres.BPMeuroditeHelmet, "Bronze-Plated Meurodite Helmet");
		ModLoader.addName(ExtraOres.BPMeuroditeChest, "Bronze-Plated Meurodite Chestplate");
		ModLoader.addName(ExtraOres.BPMeuroditePants, "Bronze-Plated Meurodite Leggings");
		ModLoader.addName(ExtraOres.BPMeuroditeBoots, "Bronze-Plated Meurodite Boots");
		
		ModLoader.addName(ExtraOres.BPTitaniumAxe, "Bronze-Plated Titanium Axe");
		ModLoader.addName(ExtraOres.BPTitaniumHoe, "Bronze-Plated Titanium Hoe");
		ModLoader.addName(ExtraOres.BPTitaniumPickaxe, "Bronze-Plated Titanium Pickaxe");
		ModLoader.addName(ExtraOres.BPTitaniumShovel, "Bronze-Plated Titanium Shovel");
		ModLoader.addName(ExtraOres.BPTitaniumSword, "Bronze-Plated Titanium Sword");
		
		ModLoader.addName(ExtraOres.BPTitaniumHelmet, "Bronze-Plated Titanium Helmet");
		ModLoader.addName(ExtraOres.BPTitaniumChest, "Bronze-Plated Titanium Chestplate");
		ModLoader.addName(ExtraOres.BPTitaniumPants, "Bronze-Plated Titanium Leggings");
		ModLoader.addName(ExtraOres.BPTitaniumBoots, "Bronze-Plated Titanium Boots");
		
		ModLoader.addName(ExtraOres.BPToriteAxe, "Bronze-Plated Torite Axe");
		ModLoader.addName(ExtraOres.BPToriteHoe, "Bronze-Plated Torite Hoe");
		ModLoader.addName(ExtraOres.BPToritePickaxe, "Bronze-Plated Torite Pickaxe");
		ModLoader.addName(ExtraOres.BPToriteShovel, "Bronze-Plated Torite Shovel");
		ModLoader.addName(ExtraOres.BPToriteSword, "Bronze-Plated Torite Sword");
		
		ModLoader.addName(ExtraOres.BPToriteHelmet, "Bronze-Plated Torite Helmet");
		ModLoader.addName(ExtraOres.BPToriteChest, "Bronze-Plated Torite Chestplate");
		ModLoader.addName(ExtraOres.BPToritePants, "Bronze-Plated Torite Leggings");
		ModLoader.addName(ExtraOres.BPToriteBoots, "Bronze-Plated Torite Boots");
		
		ModLoader.addName(ExtraOres.BPBlaziumAxe, "Bronze-Plated Fire Axe");
		ModLoader.addName(ExtraOres.BPBlaziumHoe, "Bronze-Plated Fire Hoe");
		ModLoader.addName(ExtraOres.BPBlaziumPickaxe, "Bronze-Plated Fire Pickaxe");
		ModLoader.addName(ExtraOres.BPBlaziumShovel, "Bronze-Plated Fire Shovel");
		ModLoader.addName(ExtraOres.BPBlaziumSword, "Bronze-Plated Fire Sword");
		
		ModLoader.addName(ExtraOres.BPBlaziumHelmet, "Bronze-Plated Fire Helmet");
		ModLoader.addName(ExtraOres.BPBlaziumChest, "Bronze-Plated Fire Chestplate");
		ModLoader.addName(ExtraOres.BPBlaziumPants, "Bronze-Plated Fire Leggings");
		ModLoader.addName(ExtraOres.BPBlaziumBoots, "Bronze-Plated Fire Boots");
		
		ModLoader.addName(ExtraOres.BPCopperAxe, "Bronze-Plated Copper Axe");
		ModLoader.addName(ExtraOres.BPCopperHoe, "Bronze-Plated Copper Hoe");
		ModLoader.addName(ExtraOres.BPCopperPickaxe, "Bronze-Plated Copper Pickaxe");
		ModLoader.addName(ExtraOres.BPCopperShovel, "Bronze-Plated Copper Shovel");
		ModLoader.addName(ExtraOres.BPCopperSword, "Bronze-Plated Copper Sword");
		
		ModLoader.addName(ExtraOres.BPTinHelmet, "Bronze-Plated Tin Helmet");
		ModLoader.addName(ExtraOres.BPTinChest, "Bronze-Plated Tin Chestplate");
		ModLoader.addName(ExtraOres.BPTinPants, "Bronze-Plated Tin Leggings");
		ModLoader.addName(ExtraOres.BPTinBoots, "Bronze-Plated Tin Boots");
		
		ModLoader.addName(ExtraOres.BPSteelPickaxe, "Bronze-Plated Steel Pickaxe");
		ModLoader.addName(ExtraOres.BPSteelShovel, "Bronze-Plated Steel Shovel");
		ModLoader.addName(ExtraOres.BPSteelAxe, "Bronze-Plated Steel Axe");
		ModLoader.addName(ExtraOres.BPSteelHoe, "Bronze-Plated Steel Hoe");
		ModLoader.addName(ExtraOres.BPSteelSword, "Bronze-Plated Steel Sword");
		
		ModLoader.addName(ExtraOres.BPSteelHelmet, "Bronze-Plated Steel Helmet");
		ModLoader.addName(ExtraOres.BPSteelChest, "Bronze-Plated Steel Chestplate");
		ModLoader.addName(ExtraOres.BPSteelPants, "Bronze-Plated Steel Leggings");
		ModLoader.addName(ExtraOres.BPSteelBoots, "Bronze-Plated Steel Boots");
		
		ModLoader.addName(ExtraOres.BPSandstonePickaxe, "Bronze-Plated Sandstone Pickaxe");
		ModLoader.addName(ExtraOres.BPSandstoneShovel, "Bronze-Plated Sandstone Shovel");
		ModLoader.addName(ExtraOres.BPSandstoneAxe, "Bronze-Plated Sandstone Axe");
		ModLoader.addName(ExtraOres.BPSandstoneHoe, "Bronze-Plated Sandstone Hoe");
		ModLoader.addName(ExtraOres.BPSandstoneSword, "Bronze-Plated Sandstone Sword");
		
		ModLoader.addName(ExtraOres.BPBedrockPickaxe, "Bronze-Plated Bedrock Pickaxe");
		ModLoader.addName(ExtraOres.BPBedrockShovel, "Bronze-Plated Bedrock Shovel");
		ModLoader.addName(ExtraOres.BPBedrockAxe, "Bronze-Plated Bedrock Axe");
		ModLoader.addName(ExtraOres.BPBedrockHoe, "Bronze-Plated Bedrock Hoe");
		
		ModLoader.addName(ExtraOres.BPGranitePickaxe, "Bronze-Plated Granite Pickaxe");
		ModLoader.addName(ExtraOres.BPGraniteShovel, "Bronze-Plated Granite Shovel");
		ModLoader.addName(ExtraOres.BPGraniteAxe, "Bronze-Plated Granite Axe");
		ModLoader.addName(ExtraOres.BPGraniteHoe, "Bronze-Plated Granite Hoe");
		ModLoader.addName(ExtraOres.BPGraniteSword, "Bronze-Plated Granite Sword");
		
		ModLoader.addName(ExtraOres.BPWoodAxe, "Bronze-Plated Wood Axe");
		ModLoader.addName(ExtraOres.BPWoodHoe, "Bronze-Plated Wood Hoe");
		ModLoader.addName(ExtraOres.BPWoodPickaxe, "Bronze-Plated Wood Pickaxe");
		ModLoader.addName(ExtraOres.BPWoodShovel, "Bronze-Plated Wood Shovel");
		ModLoader.addName(ExtraOres.BPWoodSword, "Bronze-Plated Wood Sword");
		
		ModLoader.addName(ExtraOres.BPClothHelmet, "Bronze-Plated Cloth Helmet");
		ModLoader.addName(ExtraOres.BPClothChest, "Bronze-Plated Cloth Chestplate");
		ModLoader.addName(ExtraOres.BPClothPants, "Bronze-Plated Cloth Leggings");
		ModLoader.addName(ExtraOres.BPClothBoots, "Bronze-Plated Cloth Boots");
		
		ModLoader.addName(ExtraOres.BPStoneAxe, "Bronze-Plated Stone Axe");
		ModLoader.addName(ExtraOres.BPStoneHoe, "Bronze-Plated Stone Hoe");
		ModLoader.addName(ExtraOres.BPStonePickaxe, "Bronze-Plated Stone Pickaxe");
		ModLoader.addName(ExtraOres.BPStoneShovel, "Bronze-Plated Stone Shovel");
		ModLoader.addName(ExtraOres.BPStoneSword, "Bronze-Plated Stone Sword");
		
		ModLoader.addName(ExtraOres.BPChainHelmet, "Bronze-Plated Chain Helmet");
		ModLoader.addName(ExtraOres.BPChainChest, "Bronze-Plated Chain Chestplate");
		ModLoader.addName(ExtraOres.BPChainPants, "Bronze-Plated Chain Leggings");
		ModLoader.addName(ExtraOres.BPChainBoots, "Bronze-Plated Chain Boots");
		
		ModLoader.addName(ExtraOres.BPIronAxe, "Bronze-Plated Iron Axe");
		ModLoader.addName(ExtraOres.BPIronHoe, "Bronze-Plated Iron Hoe");
		ModLoader.addName(ExtraOres.BPIronPickaxe, "Bronze-Plated Iron Pickaxe");
		ModLoader.addName(ExtraOres.BPIronShovel, "Bronze-Plated Iron Shovel");
		ModLoader.addName(ExtraOres.BPIronSword, "Bronze-Plated Iron Sword");
		
		ModLoader.addName(ExtraOres.BPIronHelmet, "Bronze-Plated Iron Helmet");
		ModLoader.addName(ExtraOres.BPIronChest, "Bronze-Plated Iron Chestplate");
		ModLoader.addName(ExtraOres.BPIronPants, "Bronze-Plated Iron Leggings");
		ModLoader.addName(ExtraOres.BPIronBoots, "Bronze-Plated Iron Boots");
		
		ModLoader.addName(ExtraOres.BPGoldAxe, "Bronze-Plated Gold Axe");
		ModLoader.addName(ExtraOres.BPGoldHoe, "Bronze-Plated Gold Hoe");
		ModLoader.addName(ExtraOres.BPGoldPickaxe, "Bronze-Plated Gold Pickaxe");
		ModLoader.addName(ExtraOres.BPGoldShovel, "Bronze-Plated Gold Shovel");
		ModLoader.addName(ExtraOres.BPGoldSword, "Bronze-Plated Gold Sword");
		
		ModLoader.addName(ExtraOres.BPGoldHelmet, "Bronze-Plated Gold Helmet");
		ModLoader.addName(ExtraOres.BPGoldChest, "Bronze-Plated Gold Chestplate");
		ModLoader.addName(ExtraOres.BPGoldPants, "Bronze-Plated Gold Leggings");
		ModLoader.addName(ExtraOres.BPGoldBoots, "Bronze-Plated Gold Boots");
		
		ModLoader.addName(ExtraOres.BPDiamondAxe, "Bronze-Plated Diamond Axe");
		ModLoader.addName(ExtraOres.BPDiamondHoe, "Bronze-Plated Diamond Hoe");
		ModLoader.addName(ExtraOres.BPDiamondPickaxe, "Bronze-Plated Diamond Pickaxe");
		ModLoader.addName(ExtraOres.BPDiamondShovel, "Bronze-Plated Diamond Shovel");
		ModLoader.addName(ExtraOres.BPDiamondSword, "Bronze-Plated Diamond Sword");
		
		ModLoader.addName(ExtraOres.BPDiamondHelmet, "Bronze-Plated Diamond Helmet");
		ModLoader.addName(ExtraOres.BPDiamondChest, "Bronze-Plated Diamond Chestplate");
		ModLoader.addName(ExtraOres.BPDiamondPants, "Bronze-Plated Diamond Leggings");
		ModLoader.addName(ExtraOres.BPDiamondBoots, "Bronze-Plated Diamond Boots");
		
		
		
		ModLoader.addName(ExtraOres.SmoothRadiantQuartz, "Smooth Radiant Quartz Block");
		ModLoader.addName(ExtraOres.PillarRadiantQuartz, "Radiant Quartz Pillar");
		ModLoader.addName(ExtraOres.ChiseledRadiantQuartz, "Chiseled Radiant Quartz Block");
		ModLoader.addName(ExtraOres.RadiantQuartzOre, "Radiant Quartz Ore");
		ModLoader.addName(ExtraOres.RadiantQuartz, "Radiant Quartz");
		
		ModLoader.addName(ExtraOres.Godstone, "Godstone");
		
		ModLoader.addName(ExtraOres.RadiantQuartzStairs, "Radiant Quartz Stairs");
		
		ModLoader.addName(ExtraOres.PinkQuartzStairs, "Desert Quartz Stairs");
		
		LanguageRegistry.addName(ExtraOres.RadiantQuartzDoubleSlab,"Radiant Quartz DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((RadiantQuartzSlab)ExtraOres.RadiantQuartzSingleSlab).getFullSlabName(0)+".name", "Radiant Quartz Slab");
	
		LanguageRegistry.addName(ExtraOres.PinkQuartzDoubleSlab,"Desert Quartz DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((PinkQuartzSlab)ExtraOres.PinkQuartzSingleSlab).getFullSlabName(0)+".name", "Desert Quartz Slab");
	
		ModLoader.addName(ExtraOres.graniteBrickStairs, "Granite Brick Stairs");
		
		LanguageRegistry.addName(ExtraOres.graniteBrickDoubleSlab,"Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((GraniteBrickSlab)ExtraOres.graniteBrickSingleSlab).getFullSlabName(0)+".name", "Granite Brick Slab");
		
		ModLoader.addName(ExtraOres.tinPlatedCobbleStairs, "Tin Plated Cobble Stairs");
		
		LanguageRegistry.addName(ExtraOres.tinPlatedCobbleDoubleSlab,"Tin Plated Cobble DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((TinPlatedCobbleSlab)ExtraOres.tinPlatedCobbleSingleSlab).getFullSlabName(0)+".name", "Tin Plated Cobble Slab");
		
		ModLoader.addName(ExtraOres.steelPlatedCobbleStairs, "Steel Plated Cobble Stairs");
		
		LanguageRegistry.addName(ExtraOres.steelPlatedCobbleDoubleSlab,"Steel Plated Cobble DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((SteelPlatedCobbleSlab)ExtraOres.steelPlatedCobbleSingleSlab).getFullSlabName(0)+".name", "Steel Plated Cobble Slab");
		
		ModLoader.addName(ExtraOres.bronzePlatedCobbleStairs, "Bronze Plated Cobble Stairs");
		
		LanguageRegistry.addName(ExtraOres.bronzePlatedCobbleDoubleSlab,"Bronze Plated Cobble DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((BronzePlatedCobbleSlab)ExtraOres.bronzePlatedCobbleSingleSlab).getFullSlabName(0)+".name", "Bronze Plated Cobble Slab");	
	
		ModLoader.addName(ExtraOres.tinPlatedStoneBrickStairs, "Tin Plated Stone Brick Stairs");
		
		LanguageRegistry.addName(ExtraOres.tinPlatedStoneBrickDoubleSlab,"Tin Plated Stone Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((TinPlatedStoneBrickSlab)ExtraOres.tinPlatedStoneBrickSingleSlab).getFullSlabName(0)+".name", "Tin Plated Stone Brick Slab");	
		
		ModLoader.addName(ExtraOres.steelPlatedStoneBrickStairs, "Steel Plated Stone Brick Stairs");
		
		LanguageRegistry.addName(ExtraOres.steelPlatedStoneBrickDoubleSlab,"Steel Plated Stone Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((SteelPlatedStoneBrickSlab)ExtraOres.steelPlatedStoneBrickSingleSlab).getFullSlabName(0)+".name", "Steel Plated Stone Brick Slab");	
		
		ModLoader.addName(ExtraOres.bronzePlatedStoneBrickStairs, "Bronze Plated Stone Brick Stairs");
		
		LanguageRegistry.addName(ExtraOres.bronzePlatedStoneBrickDoubleSlab,"Bronze Plated Stone Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((BronzePlatedStoneBrickSlab)ExtraOres.bronzePlatedStoneBrickSingleSlab).getFullSlabName(0)+".name", "Bronze Plated Stone Brick Slab");	
		
		ModLoader.addName(ExtraOres.tinPlatedGraniteBrickStairs, "Tin Plated Granite Brick Stairs");
		
		LanguageRegistry.addName(ExtraOres.tinPlatedGraniteBrickDoubleSlab,"Tin Plated Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((TinPlatedGraniteBrickSlab)ExtraOres.tinPlatedGraniteBrickSingleSlab).getFullSlabName(0)+".name", "Tin Plated Granite Brick Slab");	
		
		ModLoader.addName(ExtraOres.steelPlatedGraniteBrickStairs, "Steel Plated Granite Brick Stairs");
		
		LanguageRegistry.addName(ExtraOres.steelPlatedGraniteBrickDoubleSlab,"Steel Plated Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((SteelPlatedGraniteBrickSlab)ExtraOres.steelPlatedGraniteBrickSingleSlab).getFullSlabName(0)+".name", "Steel Plated Granite Brick Slab");	
		
		ModLoader.addName(ExtraOres.bronzePlatedGraniteBrickStairs, "Bronze Plated Granite Brick Stairs");
		
		LanguageRegistry.addName(ExtraOres.bronzePlatedGraniteBrickDoubleSlab,"Bronze Plated Granite Brick DoubleSlab");
		LanguageRegistry.instance().addStringLocalization(((BronzePlatedGraniteBrickSlab)ExtraOres.bronzePlatedGraniteBrickSingleSlab).getFullSlabName(0)+".name", "Bronze Plated Granite Brick Slab");	
		
		ModLoader.addName(ExtraOres.plutoniumInsulated, "Insulated Plutonium Block");
		ModLoader.addName(ExtraOres.uraniumInsulated, "Insulated Uranium Block");
	}
	
}
