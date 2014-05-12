package com.minestrappolation.lib;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation.common.MCommonProxy;
import com.minestrappolation.core.MinestrappolationCore;
import com.minestrappolation.core.item.*;
import com.minestrappolation.core.util.MCAssetManager;
import com.minestrappolation.item.*;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;

public class MItems
{
	// TODO: ORGANIZE EO ITEMS;
	static ArmorMaterial		MaterialMeurodite		= EnumHelper.addArmorMaterial("meurodite", 18, new int[] { 2, 7, 6, 2 }, 15);
	static ArmorMaterial		MaterialTitanium		= EnumHelper.addArmorMaterial("titanium", 66, new int[] { 4, 10, 8, 5 }, 11);
	static ArmorMaterial		MaterialTorite			= EnumHelper.addArmorMaterial("torite", 17, new int[] { 2, 8, 6, 2 }, 20);
	static ArmorMaterial		MaterialBlazium			= EnumHelper.addArmorMaterial("blazium", 25, new int[] { 3, 7, 6, 3 }, 18);
	static ArmorMaterial		MaterialTin				= EnumHelper.addArmorMaterial("tin", 5, new int[] { 2, 4, 3, 2 }, 5);
	static ArmorMaterial		MaterialBronze			= EnumHelper.addArmorMaterial("bronze", 30, new int[] { 3, 7, 5, 2 }, 8);
	static ArmorMaterial		MaterialSteel			= EnumHelper.addArmorMaterial("steel", 17, new int[] { 3, 8, 6, 3 }, 15);
	
	static ArmorMaterial		MaterialBPMeurodite		= EnumHelper.addArmorMaterial("meuroditeBronze", 36, new int[] { 2, 7, 6, 2 }, 15);
	static ArmorMaterial		MaterialBPTitanium		= EnumHelper.addArmorMaterial("titaniumBronze", 132, new int[] { 4, 10, 8, 5 }, 11);
	static ArmorMaterial		MaterialBPTorite		= EnumHelper.addArmorMaterial("toriteBronze", 34, new int[] { 2, 8, 6, 2 }, 20);
	static ArmorMaterial		MaterialBPBlazium		= EnumHelper.addArmorMaterial("blaziumBronze", 50, new int[] { 3, 7, 6, 3 }, 18);
	static ArmorMaterial		MaterialBPTin			= EnumHelper.addArmorMaterial("tinBronze", 10, new int[] { 2, 4, 3, 2 }, 5);
	static ArmorMaterial		MaterialBPSteel			= EnumHelper.addArmorMaterial("steelBronze", 34, new int[] { 3, 8, 6, 3 }, 15);
	static ArmorMaterial		MaterialBPCloth			= EnumHelper.addArmorMaterial("leatherBronze", 10, new int[] { 1, 3, 2, 1 }, 15);
	static ArmorMaterial		MaterialBPChain			= EnumHelper.addArmorMaterial("chainBronze", 30, new int[] { 2, 5, 4, 1 }, 12);
	static ArmorMaterial		MaterialBPIron			= EnumHelper.addArmorMaterial("ironBronze", 30, new int[] { 2, 6, 5, 2 }, 9);
	static ArmorMaterial		MaterialBPGold			= EnumHelper.addArmorMaterial("goldBronze", 14, new int[] { 2, 5, 3, 1 }, 25);
	static ArmorMaterial		MaterialBPDiamond		= EnumHelper.addArmorMaterial("diamondBronze", 66, new int[] { 3, 8, 6, 3 }, 10);
	
	public static ToolMaterial	toolMaterialMeurodite	= EnumHelper.addToolMaterial("ToolMeurodite", 2, 805, 7.0F, 2, 15);
	public static ToolMaterial	toolMaterialTitanium	= EnumHelper.addToolMaterial("ToolTitanium", 4, 2999, 10.0F, 5, 10);
	public static ToolMaterial	toolMaterialTorite		= EnumHelper.addToolMaterial("ToolTorite", 2, 699, 6.0F, 3, 20);
	public static ToolMaterial	toolMaterialBlazium		= EnumHelper.addToolMaterial("ToolBlazium", 2, 799, 8.0F, 3, 18);
	public static ToolMaterial	toolMaterialCopper		= EnumHelper.addToolMaterial("ToolCopper", 1, 139, 5.0F, 2, 10);
	public static ToolMaterial	toolMaterialSandstone	= EnumHelper.addToolMaterial("ToolSandstone", 1, 111, 4.5F, 2, 6);
	public static ToolMaterial	toolMaterialBronze		= EnumHelper.addToolMaterial("ToolBronze", 2, 1501, 6.5F, 2, 8);
	public static ToolMaterial	toolMaterialSteel		= EnumHelper.addToolMaterial("ToolSteel", 2, 300, 7.5F, 3, 15);
	public static ToolMaterial	toolMaterialBedrock		= EnumHelper.addToolMaterial("ToolBedrock", 5, 6247, 7F, 2, 5);
	public static ToolMaterial	toolMaterialGranite		= EnumHelper.addToolMaterial("ToolGranite", 1, 199, 4.3F, 2, 4);
	
	public static ToolMaterial	toolMaterialBPMeurodite	= EnumHelper.addToolMaterial("ToolBPMeurodite", 2, 1610, 7.0F, 2, 15);
	public static ToolMaterial	toolMaterialBPTitanium	= EnumHelper.addToolMaterial("ToolBPTitanium", 4, 5998, 10.0F, 5, 10);
	public static ToolMaterial	toolMaterialBPTorite	= EnumHelper.addToolMaterial("ToolBPTorite", 2, 1398, 6.0F, 3, 20);
	public static ToolMaterial	toolMaterialBPBlazium	= EnumHelper.addToolMaterial("ToolBPBlazium", 2, 1598, 8.0F, 3, 18);
	public static ToolMaterial	toolMaterialBPCopper	= EnumHelper.addToolMaterial("ToolBPCopper", 1, 278, 5.0F, 2, 10);
	public static ToolMaterial	toolMaterialBPSandstone	= EnumHelper.addToolMaterial("ToolBPSandstone", 1, 222, 4.5F, 2, 6);
	public static ToolMaterial	toolMaterialBPSteel		= EnumHelper.addToolMaterial("ToolBPSteel", 2, 600, 7.5F, 3, 15);
	public static ToolMaterial	toolMaterialBPBedrock	= EnumHelper.addToolMaterial("ToolBPBedrock", 5, 12494, 7F, 2, 5);
	public static ToolMaterial	toolMaterialBPGranite	= EnumHelper.addToolMaterial("ToolBPGranite", 1, 398, 4.3F, 2, 4);
	public static ToolMaterial	toolMaterialBPWood		= EnumHelper.addToolMaterial("ToolBPWood", 0, 118, 2.0F, 0, 15);
	public static ToolMaterial	toolMaterialBPStone		= EnumHelper.addToolMaterial("ToolBPStone", 1, 262, 4.0F, 1, 5);
	public static ToolMaterial	toolMaterialBPIron		= EnumHelper.addToolMaterial("ToolBPIron", 2, 500, 6.0F, 2, 14);
	public static ToolMaterial	toolMaterialBPEmerald	= EnumHelper.addToolMaterial("ToolBPEmerald", 3, 3122, 8.0F, 3, 10);
	public static ToolMaterial	toolMaterialBPGold		= EnumHelper.addToolMaterial("ToolBPGold", 0, 64, 12.0F, 0, 22);
	
	public static Item			grenade;
	public static Item			grenadeImpact;
	public static Item			grenadeSticky;
	
	public static Item			ToriteSword;
	public static Item			ToritePickaxe;
	public static Item			ToriteAxe;
	public static Item			ToriteHoe;
	public static Item			ToriteShovel;
	
	public static Item			ToriteHelmet;
	public static Item			ToriteChest;
	public static Item			ToritePants;
	public static Item			ToriteBoots;
	
	public static Item			BlazeShard;
	public static Item			BlaziumIngot;
	
	public static Item			BlaziumSword;
	public static Item			BlaziumPickaxe;
	public static Item			BlaziumAxe;
	public static Item			BlaziumHoe;
	public static Item			BlaziumShovel;
	public static Item			meuroditeIngot;
	
	public static Item			meuroditeSword;
	public static Item			meuroditePickaxe;
	public static Item			meuroditeAxe;
	public static Item			meuroditeHoe;
	public static Item			meuroditeShovel;
	
	public static Item			meuroditeHelmet;
	public static Item			meuroditeChest;
	public static Item			meuroditePants;
	public static Item			meuroditeBoots;
	public static Item			TitaniumIngot;
	
	public static Item			TitaniumSword;
	public static Item			TitaniumPickaxe;
	public static Item			TitaniumAxe;
	public static Item			TitaniumHoe;
	public static Item			TitaniumShovel;
	
	public static Item			TitaniumHelmet;
	public static Item			TitaniumChest;
	public static Item			TitaniumPants;
	public static Item			TitaniumBoots;
	public static Item			ToriteIngot;
	public static Item			SunstoneDust;
	public static Item			Plutonium;
	public static Item			Uranium;
	
	public static Item			BlaziumHelmet;
	public static Item			BlaziumChest;
	public static Item			BlaziumPants;
	public static Item			BlaziumBoots;
	public static Item			CopperSword;
	public static Item			CopperPickaxe;
	public static Item			CopperAxe;
	public static Item			CopperHoe;
	public static Item			CopperShovel;
	public static Item			TinHelmet;
	public static Item			TinChest;
	public static Item			TinPants;
	public static Item			TinBoots;
	
	public static Item			CoalIronIngot;
	public static Item			SteelIngot;
	
	public static Item			SteelPickaxe;
	public static Item			SteelAxe;
	public static Item			SteelShovel;
	public static Item			SteelHoe;
	public static Item			SteelSword;
	public static Item			SteelHelmet;
	public static Item			SteelChest;
	public static Item			SteelPants;
	public static Item			SteelBoots;
	public static Item			TinIngot;
	public static Item			CopperIngot;
	
	public static Item			PinkQuartz;
	
	public static Item			SandstonePickaxe;
	public static Item			SandstoneShovel;
	public static Item			SandstoneAxe;
	public static Item			SandstoneHoe;
	public static Item			SandstoneSword;
	
	public static Item			BronzeIngot;
	public static Item			BronzePickaxe;
	public static Item			BronzeShovel;
	public static Item			BronzeAxe;
	public static Item			BronzeHoe;
	public static Item			BronzeSword;
	public static Item			BronzeHelmet;
	public static Item			BronzeChest;
	public static Item			BronzePants;
	public static Item			BronzeBoots;
	
	public static Item			BedrockPickaxe;
	public static Item			BedrockAxe;
	public static Item			BedrockShovel;
	public static Item			BedrockHoe;
	
	public static Item			GranitePickaxe;
	public static Item			GraniteShovel;
	public static Item			GraniteAxe;
	public static Item			GraniteHoe;
	public static Item			GraniteSword;
	
	public static Item			steelKey;
	public static Item			steelLock;
	
	public static Item			plateTinItem;
	public static Item			plateBronzeItem;
	public static Item			plateSteelItem;
	public static Item			plateMeuroditeItem;
	
	// public static Item bucketMagma;
	
	// TODO ORGANIZE ED ITEMS;
	public static Item			ropeItem;
	public static Item			cardboardItem;
	public static Item			sandstoneBrick;
	public static Item			goblet;
	public static Item			glassDoor;
	
	public static Item			brickClay;
	
	// TODO ORGANIZE EMD ITEMS;
	public static Item			snout;
	public static Item			pigHoof;
	public static Item			fat;
	public static Item			grease;
	
	public static Item			friedApple;
	public static Item			friedBeef;
	public static Item			friedBread;
	public static Item			friedCarrot;
	public static Item			friedCookie;
	public static Item			friedFlesh;
	
	public static Item			animalBones;
	public static Item			cowHoof;
	public static Item			horn;
	
	public static Item			hornSwordWood;
	public static Item			hornSwordStone;
	public static Item			hornSwordIron;
	public static Item			hornSwordDiamond;
	public static Item			hornSwordGold;
	
	public static Item			hornSandstone;
	public static Item			hornGranite;
	public static Item			hornCopper;
	public static Item			hornSteel;
	public static Item			hornBronze;
	public static Item			hornMeurodite;
	public static Item			hornTorite;
	public static Item			hornBlazium;
	public static Item			hornTitanium;
	
	public static Item			beakChicken;
	
	public static Item			footChicken;
	
	public static Item			chickenWingRaw;
	public static Item			chickenWingCooked;
	
	public static Item			lambchopRaw;
	public static Item			lambchopCooked;
	
	public static Item			sheepHoof;
	
	public static Item			squidTentacle;
	public static Item			calimari;
	
	public static Item			infectiousFungus;
	
	public static Item			airSack;
	
	public static Item			whisker;
	
	public static Item			catEye;
	
	public static Item			wolfHide;
	
	public static Item			flesh;
	
	public static Item			marrow;
	
	public static Item			legSpider;
	public static Item			poisonSack;
	
	public static Item			swordPoisonWood;
	public static Item			swordPoisonStone;
	public static Item			swordPoisonIron;
	public static Item			swordPoisonDiamond;
	public static Item			swordPoisonGold;
	
	public static Item			swordPosionSandstone;
	public static Item			swordPosionGranite;
	public static Item			swordPosionCopper;
	public static Item			swordPosionSteel;
	public static Item			swordPosionBronze;
	public static Item			swordPosionMeurodite;
	public static Item			swordPosionTorite;
	public static Item			swordPosionBlazium;
	public static Item			swordPosionTitanium;
	
	public static Item			guano;
	public static Item			carcassSilverfish;
	
	public static Item			hideCreeper;
	
	public static Item			slimeCore;
	public static Item			enderCore;
	
	public static Item			ghastTentacle;
	
	public static Item			horseHoof;
	public static Item			rawHorseHaunch;
	public static Item			cookedHorseHaunch;
	public static Item			horseHair;
	
	public static Item			genes;
	
	public static Item			charms;
	
	public static Item			amuletPorcum;
	public static Item			amuletVaccam;
	public static Item			amuletPullum;
	public static Item			amuletOves;
	
	public static Item			wingSinew;
	public static Item			wingSegment;
	
	public static Item			hangGlider;
	
	public static Item			enderAura;
	
	public static Item			ghastlySoul;
	
	public static Item			witheredBone;
	
	public static Item			horseHairFibre;
	public static Item			horseHairBow;
	
	public static ToolMaterial	toolMaterialWoodH		= EnumHelper.addToolMaterial("ToolWoodH", 0, 59, 2.0F, 2.0F, 15);
	public static ToolMaterial	toolMaterialStoneH		= EnumHelper.addToolMaterial("ToolStoneH", 1, 131, 4.0F, 3.0F, 5);
	public static ToolMaterial	toolMaterialIronH		= EnumHelper.addToolMaterial("ToolIronH", 2, 250, 6.0F, 4.0F, 14);
	public static ToolMaterial	toolMaterialDiamondH	= EnumHelper.addToolMaterial("ToolDiamondH", 3, 1561, 8.0F, 5.0F, 10);
	public static ToolMaterial	toolMaterialGoldH		= EnumHelper.addToolMaterial("ToolGoldH", 0, 32, 12.0F, 2.0F, 22);
	
	public static ToolMaterial	toolMaterialSandstoneH	= EnumHelper.addToolMaterial("ToolSandstoneH", 1, 111, 4.5F, 4, 6);
	public static ToolMaterial	toolMaterialGraniteH	= EnumHelper.addToolMaterial("ToolGraniteH", 1, 199, 4.3F, 4, 4);
	public static ToolMaterial	toolMaterialCopperH		= EnumHelper.addToolMaterial("ToolCopperH", 1, 139, 5.0F, 4, 10);
	public static ToolMaterial	toolMaterialSteelH		= EnumHelper.addToolMaterial("ToolSteelH", 2, 300, 7.5F, 5, 15);
	public static ToolMaterial	toolMaterialBronzeH		= EnumHelper.addToolMaterial("ToolBronzeH", 2, 1501, 6.5F, 4, 8);
	public static ToolMaterial	toolMaterialMeuroditeH	= EnumHelper.addToolMaterial("ToolMeuroditeH", 2, 805, 7.0F, 4, 15);
	public static ToolMaterial	toolMaterialToriteH		= EnumHelper.addToolMaterial("ToolToriteH", 2, 699, 6.0F, 5, 20);
	public static ToolMaterial	toolMaterialBlaziumH	= EnumHelper.addToolMaterial("ToolBlaziumH", 2, 799, 8.0F, 5, 18);
	public static ToolMaterial	toolMaterialTitaniumH	= EnumHelper.addToolMaterial("ToolTitaniumH", 4, 2999, 10.0F, 6, 11);
	
	public static void init()
	{
		// TODO ORGANIZE EO ITEMS
		meuroditeIngot = new MCItem().setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditeIngot").setTextureName(MCAssetManager.getTexture("gemMeurodite"));
		GameRegistry.registerItem(meuroditeIngot, "ingotMeurodite");
		meuroditeSword = new MCItemSword(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditeSword").setTextureName(MCAssetManager.getTexture("weaponSwordMeurodite"));
		GameRegistry.registerItem(meuroditeSword, "weaponSwordMeurodite");
		meuroditePickaxe = new MCItemPickaxe(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditePickaxe").setTextureName(MCAssetManager.getTexture("toolPickMeurodite"));
		GameRegistry.registerItem(meuroditePickaxe, "toolPickMeurodite");
		meuroditeShovel = new MCItemShovel(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditeShovel").setTextureName(MCAssetManager.getTexture("toolShovelMeurodite"));
		GameRegistry.registerItem(meuroditeShovel, "toolShovelMeurodite");
		meuroditeHoe = new MCItemHoe(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditeHoe").setTextureName(MCAssetManager.getTexture("toolHoeMeurodite"));
		GameRegistry.registerItem(meuroditeHoe, "toolHoeMeurodite");
		meuroditeAxe = new MCItemAxe(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditeAxe").setTextureName(MCAssetManager.getTexture("toolAxeMeurodite"));
		GameRegistry.registerItem(meuroditeAxe, "toolAxeMeurodite");
		
		CopperSword = new MCItemSword(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_CopperSword").setTextureName(MCAssetManager.getTexture("weaponSwordCopper"));
		GameRegistry.registerItem(CopperSword, "weaponSwordCopper");
		CopperPickaxe = new MCItemPickaxe(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_CopperPickaxe").setTextureName(MCAssetManager.getTexture("toolPickCopper"));
		GameRegistry.registerItem(CopperPickaxe, "toolPickCopper");
		CopperShovel = new MCItemShovel(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_CopperShovel").setTextureName(MCAssetManager.getTexture("toolShovelCopper"));
		GameRegistry.registerItem(CopperShovel, "toolShovelCopper");
		CopperHoe = new MCItemHoe(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_CopperHoe").setTextureName(MCAssetManager.getTexture("toolHoeCopper"));
		GameRegistry.registerItem(CopperHoe, "toolHoeCopper");
		CopperAxe = new MCItemAxe(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_CopperAxe").setTextureName(MCAssetManager.getTexture("toolAxeCopper"));
		GameRegistry.registerItem(CopperAxe, "toolAxeCopper");
		
		BlaziumIngot = new MCItem().setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BlaziumIngot").setTextureName(MCAssetManager.getTexture("ingotBlazium"));
		GameRegistry.registerItem(BlaziumIngot, "ingotBlazium");
		BlazeShard = new MCItem().setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BlazeShard").setTextureName(MCAssetManager.getTexture("dustBlazium"));
		GameRegistry.registerItem(BlazeShard, "shardBlazium");
		
		BlaziumSword = new MCItemSword(toolMaterialBlazium, toolMaterialBPBlazium, true).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_FireSword").setTextureName(MCAssetManager.getTexture("weaponSwordFire"));
		GameRegistry.registerItem(BlaziumSword, "weaponSwordBlazium");
		BlaziumPickaxe = new MCItemPickaxe(toolMaterialBlazium, toolMaterialBPBlazium, true).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_FirePickaxe").setTextureName(MCAssetManager.getTexture("toolPickFire"));
		GameRegistry.registerItem(BlaziumPickaxe, "toolPickBlazium");
		BlaziumShovel = new MCItemShovel(toolMaterialBlazium, toolMaterialBPBlazium, true).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_FireShovel").setTextureName(MCAssetManager.getTexture("toolShovelFire"));
		GameRegistry.registerItem(BlaziumShovel, "toolShovelBlazium");
		BlaziumHoe = new MCItemHoe(toolMaterialBlazium, toolMaterialBPBlazium).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_FireHoe").setTextureName(MCAssetManager.getTexture("toolHoeFire"));
		GameRegistry.registerItem(BlaziumHoe, "toolHoeBlazium");
		BlaziumAxe = new MCItemAxe(toolMaterialBlazium, toolMaterialBPBlazium, true).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_FireAxe").setTextureName(MCAssetManager.getTexture("toolAxeFire"));
		GameRegistry.registerItem(BlaziumAxe, "toolAxeBlazium");
		
		ToriteIngot = new MCItem().setUnlocalizedName("ingotTorite").setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getTexture("ingotTorite"));
		GameRegistry.registerItem(ToriteIngot, "ingotTorite");
		SunstoneDust = new MCItem().setUnlocalizedName("dustSunstone").setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getTexture("dustSunstone"));
		GameRegistry.registerItem(SunstoneDust, "dustSunstone");
		Plutonium = new MCItem().setUnlocalizedName("plutonium").setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getTexture("dustPlutonium"));
		GameRegistry.registerItem(Plutonium, "dustPlutonium");
		Uranium = new MCItem().setUnlocalizedName("uranium").setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getTexture("dustUranium"));
		GameRegistry.registerItem(Uranium, "dustUranium");
		
		BlaziumHelmet = new MCItemArmor(MaterialBlazium, MaterialBPBlazium, MCommonProxy.addArmor("fire"), 0, "fire").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_FireHelmet").setTextureName(MCAssetManager.getTexture("armorHelmFire"));
		GameRegistry.registerItem(BlaziumHelmet, "armorHelmetBlazium");
		BlaziumChest = new MCItemArmor(MaterialBlazium, MaterialBPBlazium, MCommonProxy.addArmor("fire"), 1, "fire").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_FireChestplate").setTextureName(MCAssetManager.getTexture("armorChestFire"));
		GameRegistry.registerItem(BlaziumChest, "armorChestBlazium");
		BlaziumPants = new MCItemArmor(MaterialBlazium, MaterialBPBlazium, MCommonProxy.addArmor("fire"), 2, "fire").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_FireLeggings").setTextureName(MCAssetManager.getTexture("armorLegsFire"));
		GameRegistry.registerItem(BlaziumPants, "armorPantsBlazium");
		BlaziumBoots = new MCItemArmor(MaterialBlazium, MaterialBPBlazium, MCommonProxy.addArmor("fire"), 3, "fire").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_FireBoots").setTextureName(MCAssetManager.getTexture("armorBootsFire"));
		GameRegistry.registerItem(BlaziumBoots, "armorBootsBlazium");
		
		CoalIronIngot = new MCItem().setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_CoalIronIngot").setTextureName(MCAssetManager.getTexture("ingotCoalIron"));
		GameRegistry.registerItem(CoalIronIngot, "ingotCoalIron");
		SteelIngot = new MCItem().setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelIngot").setTextureName(MCAssetManager.getTexture("ingotSteel"));
		GameRegistry.registerItem(SteelIngot, "ingotSteel");
		
		SteelPickaxe = new MCItemPickaxe(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelPickaxe").setTextureName(MCAssetManager.getTexture("toolPickSteel"));
		GameRegistry.registerItem(SteelPickaxe, "toolPickSteel");
		SteelShovel = new MCItemShovel(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelShovel").setTextureName(MCAssetManager.getTexture("toolShovelSteel"));
		GameRegistry.registerItem(SteelShovel, "toolShovelSteel");
		ToriteSword = new MCItemSword(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_ToriteSword").setTextureName(MCAssetManager.getTexture("weaponSwordTorite"));
		GameRegistry.registerItem(ToriteSword, "weaponSwordTorite");
		ToritePickaxe = new ToriteToolPickaxe(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_ToritePickaxe").setTextureName(MCAssetManager.getTexture("toolPickTorite"));
		GameRegistry.registerItem(ToritePickaxe, "toolPickTorite");
		ToriteShovel = new ToriteToolShovel(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_ToriteShovel").setTextureName(MCAssetManager.getTexture("toolShovelTorite"));
		GameRegistry.registerItem(ToriteShovel, "toolShovelTorite");
		ToriteHoe = new MCItemHoe(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_ToriteHoe").setTextureName(MCAssetManager.getTexture("toolHoeTorite"));
		GameRegistry.registerItem(ToriteHoe, "toolHoeTorite");
		ToriteAxe = new ToriteToolAxe(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_ToriteAxe").setTextureName(MCAssetManager.getTexture("toolAxeTorite"));
		GameRegistry.registerItem(ToriteAxe, "toolAxeTorite");
		TitaniumIngot = new MCItem().setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumIngot").setTextureName(MCAssetManager.getTexture("ingotTitanium"));
		GameRegistry.registerItem(TitaniumIngot, "ingotTitanium");
		
		TitaniumSword = new MCItemSword(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumSword").setTextureName(MCAssetManager.getTexture("weaponSwordTitanium"));
		GameRegistry.registerItem(TitaniumSword, "weaponSwordTitanium");
		TitaniumPickaxe = new MCItemPickaxe(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumPickaxe").setTextureName(MCAssetManager.getTexture("toolPickTitanium"));
		GameRegistry.registerItem(TitaniumPickaxe, "toolPickTitanium");
		TitaniumShovel = new MCItemShovel(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumShovel").setTextureName(MCAssetManager.getTexture("toolShovelTitanium"));
		GameRegistry.registerItem(TitaniumShovel, "toolShovelTitanium");
		TitaniumHoe = new MCItemHoe(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumHoe").setTextureName(MCAssetManager.getTexture("toolHoeTitanium"));
		GameRegistry.registerItem(TitaniumHoe, "toolHoeTitanium");
		TitaniumAxe = new MCItemAxe(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumAxe").setTextureName(MCAssetManager.getTexture("toolAxeTitanium"));
		GameRegistry.registerItem(TitaniumAxe, "toolAxeTitanium");
		meuroditeHelmet = new MCItemArmor(MaterialMeurodite, MaterialBPMeurodite, MCommonProxy.addArmor("Meurodite"), 0, "meurodite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditeHelmet").setTextureName(MCAssetManager.getTexture("armorHelmMeurodite"));
		GameRegistry.registerItem(meuroditeHelmet, "armorHelmetMeirodite");
		meuroditeChest = new MCItemArmor(MaterialMeurodite, MaterialBPMeurodite, MCommonProxy.addArmor("Meurodite"), 1, "meurodite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditeChestplate").setTextureName(MCAssetManager.getTexture("armorChestMeurodite"));
		GameRegistry.registerItem(meuroditeChest, "armorChestMeurodite");
		meuroditePants = new MCItemArmor(MaterialMeurodite, MaterialBPMeurodite, MCommonProxy.addArmor("Meurodite"), 2, "meurodite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditeLeggings").setTextureName(MCAssetManager.getTexture("armorLegsMeurodite"));
		GameRegistry.registerItem(meuroditePants, "armorPantsMeurodite");
		meuroditeBoots = new MCItemArmor(MaterialMeurodite, MaterialBPMeurodite, MCommonProxy.addArmor("Meurodite"), 3, "meurodite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_MeuroditeBoots").setTextureName(MCAssetManager.getTexture("armorBootsMeurodite"));
		GameRegistry.registerItem(meuroditeBoots, "armorBootsMeurodite");
		
		TitaniumHelmet = new MCItemArmor(MaterialTitanium, MaterialBPTitanium, MCommonProxy.addArmor("titanium"), 0, "meurodite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumHelmet").setTextureName(MCAssetManager.getTexture("armorHelmTitanium"));
		GameRegistry.registerItem(TitaniumHelmet, "armorHelmetTitanium");
		TitaniumChest = new MCItemArmor(MaterialTitanium, MaterialBPTitanium, MCommonProxy.addArmor("titanium"), 1, "meurodite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumChestplate").setTextureName(MCAssetManager.getTexture("armorChestTitanium"));
		GameRegistry.registerItem(TitaniumChest, "armorChestTitanium");
		TitaniumPants = new MCItemArmor(MaterialTitanium, MaterialBPTitanium, MCommonProxy.addArmor("titanium"), 2, "meurodite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumLeggings").setTextureName(MCAssetManager.getTexture("armorLegsTitanium"));
		GameRegistry.registerItem(TitaniumPants, "armorPantsTitanium");
		TitaniumBoots = new MCItemArmor(MaterialTitanium, MaterialBPTitanium, MCommonProxy.addArmor("titanium"), 3, "meurodite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_TitaniumBoots").setTextureName(MCAssetManager.getTexture("armorBootsTitanium"));
		GameRegistry.registerItem(TitaniumBoots, "armorBootsTitanium");
		
		ToriteHelmet = new MCItemArmor(MaterialTorite, MaterialBPTorite, MCommonProxy.addArmor("torite"), 0, "torite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_ToriteHelmet").setTextureName(MCAssetManager.getTexture("armorHelmTorite"));
		GameRegistry.registerItem(ToriteHelmet, "armorHelmetTorite");
		ToriteChest = new MCItemArmor(MaterialTorite, MaterialBPTorite, MCommonProxy.addArmor("torite"), 1, "torite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_ToriteChestplate").setTextureName(MCAssetManager.getTexture("armorChestTorite"));
		GameRegistry.registerItem(ToriteChest, "armorChestTorite");
		ToritePants = new MCItemArmor(MaterialTorite, MaterialBPTorite, MCommonProxy.addArmor("torite"), 2, "torite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_ToriteLeggings").setTextureName(MCAssetManager.getTexture("armorLegsTorite"));
		GameRegistry.registerItem(ToritePants, "armorPantsTorite");
		ToriteBoots = new MCItemArmor(MaterialTorite, MaterialBPTorite, MCommonProxy.addArmor("torite"), 3, "torite").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_ToriteBoots").setTextureName(MCAssetManager.getTexture("armorBootsTorite"));
		GameRegistry.registerItem(ToriteBoots, "armorBootsTorite");
		
		TinIngot = new MCItem().setUnlocalizedName("ingotTin").setTextureName(MCAssetManager.getTexture("ingotTin"));
		GameRegistry.registerItem(TinIngot, "ingotTin");
		CopperIngot = new MCItem().setUnlocalizedName("ingotCopper").setTextureName(MCAssetManager.getTexture("ingotCopper"));
		GameRegistry.registerItem(CopperIngot, "ingotCopper");
		PinkQuartz = new MCItem().setUnlocalizedName("quartzDesert").setTextureName(MCAssetManager.getTexture("gemDesertQuartz"));
		GameRegistry.registerItem(PinkQuartz, "quartzPink");
		
		SandstonePickaxe = new MCItemPickaxe(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SandstonePickaxe").setTextureName(MCAssetManager.getTexture("toolPickSandstone"));
		GameRegistry.registerItem(SandstonePickaxe, "toolPickSandstone");
		SandstoneShovel = new MCItemShovel(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SandstoneShovel").setTextureName(MCAssetManager.getTexture("toolShovelSandstone"));
		GameRegistry.registerItem(SandstoneShovel, "toolShovelSandstone");
		SandstoneAxe = new MCItemAxe(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SandstoneAxe").setTextureName(MCAssetManager.getTexture("toolAxeSandstone"));
		GameRegistry.registerItem(SandstoneAxe, "toolAxeSandstone");
		SandstoneHoe = new MCItemHoe(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SandstoneHoe").setTextureName(MCAssetManager.getTexture("toolHoeSandstone"));
		GameRegistry.registerItem(SandstoneHoe, "toolHoeSandstone");
		SandstoneSword = new MCItemSword(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SandstoneSword").setTextureName(MCAssetManager.getTexture("weaponSwordSandstone"));
		GameRegistry.registerItem(SandstoneSword, "weaponSwordSandstone");
		SteelAxe = new MCItemAxe(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelAxe").setTextureName(MCAssetManager.getTexture("toolAxeSteel"));
		GameRegistry.registerItem(SteelAxe, "toolAxeSteel");
		SteelHoe = new MCItemHoe(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelHoe").setTextureName(MCAssetManager.getTexture("toolHoeSteel"));
		GameRegistry.registerItem(SteelHoe, "toolHoeSteel");
		SteelSword = new MCItemSword(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelSword").setTextureName(MCAssetManager.getTexture("weaponSwordSteel"));
		GameRegistry.registerItem(SteelSword, "weaponSwordSteel");
		
		SteelHelmet = new MCItemArmor(MaterialSteel, MaterialBPSteel, MCommonProxy.addArmor("steel"), 0, "steel").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelHelmet").setTextureName(MCAssetManager.getTexture("armorHelmSteel"));
		GameRegistry.registerItem(SteelHelmet, "armorHelmetSteel");
		SteelChest = new MCItemArmor(MaterialSteel, MaterialBPSteel, MCommonProxy.addArmor("steel"), 1, "steel").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelChestplate").setTextureName(MCAssetManager.getTexture("armorChestSteel"));
		GameRegistry.registerItem(SteelChest, "armorChestSteel");
		SteelPants = new MCItemArmor(MaterialSteel, MaterialBPSteel, MCommonProxy.addArmor("steel"), 2, "steel").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelLeggings").setTextureName(MCAssetManager.getTexture("armorLegsSteel"));
		GameRegistry.registerItem(SteelPants, "armorPantsSteel");
		SteelBoots = new MCItemArmor(MaterialSteel, MaterialBPSteel, MCommonProxy.addArmor("steel"), 3, "steel").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_SteelBoots").setTextureName(MCAssetManager.getTexture("armorBootsSteel"));
		GameRegistry.registerItem(SteelBoots, "armorBootsSteel");
		
		BronzeIngot = new MCItem().setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzeIngot").setTextureName(MCAssetManager.getTexture("ingotCopper"));
		GameRegistry.registerItem(BronzeIngot, "ingotBronze");
		BronzePickaxe = new MCItemPickaxe(toolMaterialBronze, null).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzePickaxe").setTextureName(MCAssetManager.getTexture("toolPickBronze"));
		GameRegistry.registerItem(BronzePickaxe, "toolPickBronze");
		BronzeShovel = new MCItemShovel(toolMaterialBronze, null).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzeShovel").setTextureName(MCAssetManager.getTexture("toolShovelBronze"));
		GameRegistry.registerItem(BronzeShovel, "toolShovelBronze");
		BronzeAxe = new MCItemAxe(toolMaterialBronze, null).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzeAxe").setTextureName(MCAssetManager.getTexture("toolAxeBronze"));
		GameRegistry.registerItem(BronzeAxe, "toolAxeBronze");
		BronzeHoe = new MCItemHoe(toolMaterialBronze, null).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzeHoe").setTextureName(MCAssetManager.getTexture("toolHoeBronze"));
		GameRegistry.registerItem(BronzeHoe, "toolHoeBronze");
		BronzeSword = new MCItemSword(toolMaterialBronze, null).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzeSword").setTextureName(MCAssetManager.getTexture("weaponSwordBronze"));
		GameRegistry.registerItem(BronzeSword, "weaponSwordBronze");
		BronzeHelmet = new MCItemArmor(MaterialBronze, null, MCommonProxy.addArmor("bronze"), 0, "bronze").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzeHelmet").setTextureName(MCAssetManager.getTexture("armorHelmBronze"));
		GameRegistry.registerItem(BronzeHelmet, "armorHelmetBronze");
		BronzeChest = new MCItemArmor(MaterialBronze, null, MCommonProxy.addArmor("bronze"), 1, "bronze").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzeChestplate").setTextureName(MCAssetManager.getTexture("armorChestBronze"));
		GameRegistry.registerItem(BronzeChest, "armorChestBronze");
		BronzePants = new MCItemArmor(MaterialBronze, null, MCommonProxy.addArmor("bronze"), 2, "bronze").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzeLeggings").setTextureName(MCAssetManager.getTexture("armorLegsBronze"));
		GameRegistry.registerItem(BronzePants, "armorPantsBronze");
		BronzeBoots = new MCItemArmor(MaterialBronze, null, MCommonProxy.addArmor("bronze"), 3, "bronze").setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BronzeBoots").setTextureName(MCAssetManager.getTexture("armorBootsBronze"));
		GameRegistry.registerItem(BronzeBoots, "armorBootsBronze");
		
		BedrockPickaxe = new MCItemPickaxe(toolMaterialBedrock, toolMaterialBPBedrock).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BedrockPickaxe").setTextureName(MCAssetManager.getTexture("toolPickBedrock"));
		GameRegistry.registerItem(BedrockPickaxe, "toolPickBedrock");
		BedrockAxe = new MCItemAxe(toolMaterialBedrock, toolMaterialBPBedrock).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BedrockAxe").setTextureName(MCAssetManager.getTexture("toolAxeBedrock"));
		GameRegistry.registerItem(BedrockAxe, "toolAxeBedrock");
		BedrockShovel = new MCItemShovel(toolMaterialBedrock, toolMaterialBPBedrock).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BedrockShovel").setTextureName(MCAssetManager.getTexture("toolShovelBedrock"));
		GameRegistry.registerItem(BedrockShovel, "toolShovelBedrock");
		BedrockHoe = new MCItemHoe(toolMaterialBedrock, toolMaterialBPBedrock).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_BedrockHoe").setTextureName(MCAssetManager.getTexture("toolHoeBedrock"));
		GameRegistry.registerItem(BedrockHoe, "toolHoeBedrock");
		
		GranitePickaxe = new MCItemPickaxe(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_GranitePickaxe").setTextureName(MCAssetManager.getTexture("toolPickGranite"));
		GameRegistry.registerItem(GranitePickaxe, "toolPickGranite");
		GraniteAxe = new MCItemAxe(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_GraniteAxe").setTextureName(MCAssetManager.getTexture("toolAxeGranite"));
		GameRegistry.registerItem(GraniteAxe, "toolAxeGranite");
		GraniteShovel = new MCItemShovel(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_GraniteShovel").setTextureName(MCAssetManager.getTexture("toolShovelGranite"));
		GameRegistry.registerItem(GraniteShovel, "toolShovelGranite");
		GraniteHoe = new MCItemHoe(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_GraniteHoe").setTextureName(MCAssetManager.getTexture("toolHoeGranite"));
		GameRegistry.registerItem(GraniteHoe, "toolHoeGranite");
		GraniteSword = new MCItemSword(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("item_GraniteSword").setTextureName(MCAssetManager.getTexture("weaponSwordGranite"));
		GameRegistry.registerItem(GraniteSword, "weaponSwordGranite");
		
		grenade = new ItemGrenade().setUnlocalizedName("grenade").setTextureName(MCAssetManager.getTexture("grenadeNuke"));
		GameRegistry.registerItem(grenade, "grenadeNuke");
		grenadeImpact = new ItemGrenadeImpact().setUnlocalizedName("grenadeImpact").setTextureName(MCAssetManager.getTexture("grenadeNuke"));
		GameRegistry.registerItem(grenadeImpact, "grenadeImpact");
		grenadeSticky = new ItemGrenadeSticky().setUnlocalizedName("grenadeSticky").setTextureName(MCAssetManager.getTexture("grenadeNuke"));
		GameRegistry.registerItem(grenadeSticky, "grenadeSticky");
		
		// bucketMagma = new MCItemBucket(EOConfig.bucketMagmaId,
		// ExtraOres.eoFluid.getBlockID()).setUnlocalizedName("item_MagmaBucket");
		
		steelKey = new ItemKey().setUnlocalizedName("item_SteelKey").setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getTexture("utilitySteelKey"));
		GameRegistry.registerItem(steelKey, "keySteel");
		steelLock = new ItemLock().setUnlocalizedName("item_SteelLock").setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getTexture("utilitySteelLock"));
		GameRegistry.registerItem(steelLock, "mlockSteel");
		
		plateTinItem = new ItemReed(MBlocks.TinPlate).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("plateTinItem").setTextureName(MCAssetManager.getTexture("platingTin"));
		GameRegistry.registerItem(plateTinItem, "plateTinItem");
		plateBronzeItem = new ItemReed(MBlocks.BronzePlate).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("plateBronzeItem").setTextureName(MCAssetManager.getTexture("platingBronze"));
		GameRegistry.registerItem(plateBronzeItem, "plateBronzeItem");
		plateSteelItem = new ItemReed(MBlocks.SteelPlate).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("plateSteelItem").setTextureName(MCAssetManager.getTexture("platingSteel"));
		GameRegistry.registerItem(plateSteelItem, "plateSteelItem");
		plateMeuroditeItem = new ItemReed(MBlocks.meuroditePlate).setCreativeTab(Minestrappolation.tabTools).setUnlocalizedName("plateMeuroditeItem").setTextureName(MCAssetManager.getTexture("platingMeurodite"));
		GameRegistry.registerItem(plateMeuroditeItem, "plateMeuroditeItem");
		
		// TODO ORGANIZE ED ITEMS;
		ropeItem = new ItemReed(MBlocks.rope).setUnlocalizedName("rope").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("rope"));
		GameRegistry.registerItem(ropeItem, "itemRope");
		cardboardItem = new ItemReed(MBlocks.cardboard).setCreativeTab(Minestrappolation.tabFood).setUnlocalizedName("item_Cardboard").setTextureName(MCAssetManager.getTexture("cardboard"));
		GameRegistry.registerItem(cardboardItem, "cardboardItem");
		sandstoneBrick = new MCItem().setUnlocalizedName("item_SandstoneBrick").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("brickSandstone"));
		GameRegistry.registerItem(sandstoneBrick, "sandstoneBrickItem");
		goblet = new ItemReed(MBlocks.Goblet).setCreativeTab(Minestrappolation.tabFood).setUnlocalizedName("item_GobletEmpty").setTextureName(MCAssetManager.getTexture("goblet"));
		GameRegistry.registerItem(goblet, "gobletItem");
		glassDoor = new EDItemDoor(MBlocks.GlassDoor).setUnlocalizedName("item_GlassDoor").setTextureName(MCAssetManager.getTexture("doorGlass"));
		GameRegistry.registerItem(glassDoor, "glassDoorItem");
		brickClay = new MCItemMulti(new String[] { MCAssetManager.getTexture("brickClayBlack"), MCAssetManager.getTexture("brickClayBlue"), MCAssetManager.getTexture("brickClayBrown"), MCAssetManager.getTexture("brickClayCyan"), MCAssetManager.getTexture("brickClayGray"), MCAssetManager.getTexture("brickClayGreen"), MCAssetManager.getTexture("brickClayLightBlue"), MCAssetManager.getTexture("brickClayLime"), MCAssetManager.getTexture("brickClayMagenta"), MCAssetManager.getTexture("brickClayOrange"), MCAssetManager.getTexture("brickClayPink"), MCAssetManager.getTexture("brickClayPurple"), MCAssetManager.getTexture("brickClayRed"), MCAssetManager.getTexture("brickClaySilver"), MCAssetManager.getTexture("brickClayWhite"), MCAssetManager.getTexture("brickClayYellow") }).setCreativeTab(MinestrappolationCore.creativeTabStone).setUnlocalizedName("brickClay");
		GameRegistry.registerItem(brickClay, "brickClay");
		
		// TODO ORGANIZE EMD ITEMS
		snout = new MCItemFood(3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setTextureName(MCAssetManager.getTexture("snout")).setUnlocalizedName("snout").setCreativeTab(Minestrappolation.tabFood);
		pigHoof = new MCItem().setUnlocalizedName("pigFoot").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("footPig"));
		fat = new MCItemFood(8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setUnlocalizedName("fat").setTextureName(MCAssetManager.getTexture("fat")).setCreativeTab(Minestrappolation.tabFood);
		grease = new MCItem().setUnlocalizedName("grease").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("grease"));
		
		friedApple = new MCItemFood(8, 0.3F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedApple")).setUnlocalizedName("grease_apple").setCreativeTab(Minestrappolation.tabFood);
		friedBeef = new MCItemFood(16, 0.8F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedBeef")).setUnlocalizedName("grease_beef").setCreativeTab(Minestrappolation.tabFood);
		friedBread = new MCItemFood(10, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedBread")).setUnlocalizedName("grease_bread").setCreativeTab(Minestrappolation.tabFood);
		friedCarrot = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedCarrot")).setUnlocalizedName("grease_carrot").setCreativeTab(Minestrappolation.tabFood);
		friedCookie = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedCookie")).setUnlocalizedName("grease_cookie").setCreativeTab(Minestrappolation.tabFood);
		friedFlesh = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getTexture("friedFlesh")).setUnlocalizedName("grease_flesh").setCreativeTab(Minestrappolation.tabFood);
		
		animalBones = new MCItem().setUnlocalizedName("animal_bones").setTextureName(MCAssetManager.getTexture("animalBones")).setCreativeTab(Minestrappolation.tabFood);
		cowHoof = new MCItem().setUnlocalizedName("cow_hoof").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("footCow"));
		
		horn = new MCItem().setUnlocalizedName("horn").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("horn"));
		
		hornSwordWood = new MCItemSword(toolMaterialWoodH, null).setUnlocalizedName("horned_wood_sword").setTextureName(MCAssetManager.getTexture("weaponSwordWoodHorned")).setCreativeTab(Minestrappolation.tabFood);
		hornSwordStone = new MCItemSword(toolMaterialStoneH, null).setUnlocalizedName("horned_stone_sword").setTextureName(MCAssetManager.getTexture("weaponSwordStoneHorned")).setCreativeTab(Minestrappolation.tabFood);
		hornSwordIron = new MCItemSword(toolMaterialIronH, null).setUnlocalizedName("horned_iron_sword").setTextureName(MCAssetManager.getTexture("weaponSwordIronHorned")).setCreativeTab(Minestrappolation.tabFood);
		hornSwordDiamond = new MCItemSword(toolMaterialDiamondH, null).setUnlocalizedName("horned_diamond_sword").setTextureName(MCAssetManager.getTexture("weaponSwordDiamondHorned")).setCreativeTab(Minestrappolation.tabFood);
		hornSwordGold = new MCItemSword(toolMaterialGoldH, null).setUnlocalizedName("horned_gold_sword").setTextureName(MCAssetManager.getTexture("weaponSwordGoldHorned")).setCreativeTab(Minestrappolation.tabFood);
		
		beakChicken = new MCItem().setUnlocalizedName("chicken_beak").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("chickenBeak"));
		
		footChicken = new MCItem().setUnlocalizedName("chicken_foot").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("footChicken"));
		
		chickenWingRaw = new MCItemFood(1, 0.1F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.3F).setTextureName(MCAssetManager.getTexture("chickenWingRaw")).setUnlocalizedName("raw_chicken_wing").setCreativeTab(Minestrappolation.tabFood);
		chickenWingCooked = new MCItemFood(4, 0.65F).setUnlocalizedName("cooked_chicken_wing").setTextureName(MCAssetManager.getTexture("chickenWingCooked")).setCreativeTab(Minestrappolation.tabFood);
		
		lambchopRaw = new MCItemFood(3, 0.2F).setUnlocalizedName("raw_lamb_chop").setTextureName(MCAssetManager.getTexture("lambChopRaw")).setCreativeTab(Minestrappolation.tabFood);
		lambchopCooked = new ItemCookedLambchop(6, 0.8F).setUnlocalizedName("cooked_lamb_chop").setTextureName(MCAssetManager.getTexture("lambChopCooked")).setCreativeTab(Minestrappolation.tabFood);
		
		sheepHoof = new MCItem().setUnlocalizedName("sheep_hoof").setTextureName(MCAssetManager.getTexture("footSheep")).setCreativeTab(Minestrappolation.tabFood);
		
		squidTentacle = new MCItemFood(2, 0.1F).setPotionEffect(Potion.hunger.id, 8 * 20, 1, 1F).setTextureName(MCAssetManager.getTexture("tentacleSquid")).setUnlocalizedName("tentacle").setCreativeTab(Minestrappolation.tabFood);
		calimari = new ItemCalimari(2, 0.6F).setUnlocalizedName("calamari").setTextureName(MCAssetManager.getTexture("calimari")).setCreativeTab(Minestrappolation.tabFood);
		
		infectiousFungus = new ItemInfectiousFungus(0, 0F).setUnlocalizedName("infectious_fungus").setTextureName(MCAssetManager.getTexture("infectiousFungus")).setCreativeTab(Minestrappolation.tabFood);
		
		airSack = new ItemAirSack().setUnlocalizedName("air_sack").setTextureName(MCAssetManager.getTexture("sackAir")).setCreativeTab(Minestrappolation.tabFood);
		
		whisker = new MCItem().setUnlocalizedName("whisker").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("whisker"));
		
		catEye = new ItemCatEye(0, 0.0F).setUnlocalizedName("cat_eye").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("catEye"));
		
		wolfHide = new MCItem().setUnlocalizedName("wolf_hide").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("hideWolf"));
		
		flesh = new MCItemFood(4, 0.35F).setPotionEffect(Potion.hunger.id, 20, 0, 0.05F).setUnlocalizedName("flesh").setTextureName(MCAssetManager.getTexture("flesh")).setCreativeTab(Minestrappolation.tabFood);
		
		marrow = new MCItemFood(5, 0.0F).setUnlocalizedName("marrow").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("bowlMarrow"));
		
		legSpider = new MCItem().setUnlocalizedName("spider_leg").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("armSpider"));
		poisonSack = new MCItem().setUnlocalizedName("poison_sack").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("sackPoison"));
		swordPoisonWood = new ItemPoisonSword(ToolMaterial.WOOD, Items.wooden_sword).setUnlocalizedName("woodSwordPoison").setTextureName("wood_sword").setCreativeTab(Minestrappolation.tabFood);
		swordPoisonStone = new ItemPoisonSword(ToolMaterial.STONE, Items.stone_sword).setUnlocalizedName("stoneSwordPoison").setTextureName("stone_sword").setCreativeTab(Minestrappolation.tabFood);
		swordPoisonIron = new ItemPoisonSword(ToolMaterial.IRON, Items.iron_sword).setUnlocalizedName("ironSwordPoison").setTextureName("iron_sword").setCreativeTab(Minestrappolation.tabFood);
		swordPoisonDiamond = new ItemPoisonSword(ToolMaterial.EMERALD, Items.diamond_sword).setUnlocalizedName("diamondSwordPoison").setTextureName("diamond_sword").setCreativeTab(Minestrappolation.tabFood);
		swordPoisonGold = new ItemPoisonSword(ToolMaterial.GOLD, Items.golden_sword).setUnlocalizedName("goldSwordPoison").setTextureName("gold_sword").setCreativeTab(Minestrappolation.tabFood);
		
		guano = new ItemGuano().setUnlocalizedName("guano").setTextureName(MCAssetManager.getTexture("guano")).setCreativeTab(Minestrappolation.tabFood);
		carcassSilverfish = new MCItem().setUnlocalizedName("silverfish_carcass").setTextureName(MCAssetManager.getTexture("silverfishCarcass")).setCreativeTab(Minestrappolation.tabFood);
		
		hideCreeper = new MCItem().setUnlocalizedName("creeper_hide").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("hideCreeper"));
		
		slimeCore = new MCItem().setUnlocalizedName("slime_core").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("coreSlime"));
		enderCore = new ItemEnderCore(0, 0).setUnlocalizedName("ender_core").setTextureName(MCAssetManager.getTexture("coreEnder")).setCreativeTab(Minestrappolation.tabFood);
		
		ghastTentacle = new ItemGhastTentacle().setUnlocalizedName("ghast_tentacle").setTextureName(MCAssetManager.getTexture("tentacleGhast")).setCreativeTab(Minestrappolation.tabFood);
		
		horseHoof = new MCItem().setCreativeTab(Minestrappolation.tabFood).setUnlocalizedName("horse_foot").setTextureName(MCAssetManager.getTexture("footHorse"));
		rawHorseHaunch = new MCItemFood(4, 0.4F).setCreativeTab(Minestrappolation.tabFood).setUnlocalizedName("raw_horse_haunch").setTextureName(MCAssetManager.getTexture("horseHaunchRaw"));
		cookedHorseHaunch = new MCItemFood(10, 0.8F).setCreativeTab(Minestrappolation.tabFood).setUnlocalizedName("cooked_horse_haunch").setTextureName(MCAssetManager.getTexture("horseHaunchCooked"));
		horseHair = new MCItem().setCreativeTab(Minestrappolation.tabFood).setUnlocalizedName("horse_hair").setTextureName(MCAssetManager.getTexture("horseHair"));
		
		genes = new ItemGene().setUnlocalizedName("gene");
		
		charms = new ItemCharm().setUnlocalizedName("charm").setCreativeTab(Minestrappolation.tabFood);
		
		amuletPorcum = new ItemAmuletPorcum().setUnlocalizedName("porcum_amulet").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("amuletPig"));
		amuletVaccam = new ItemAmuletVaccam().setUnlocalizedName("vaccam_amulet").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("amuletHorse"));
		amuletPullum = new ItemAmuletPullum().setUnlocalizedName("pullum_amulet").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("amuletChicken"));
		amuletOves = new ItemAmuletOves().setUnlocalizedName("oves_amulet").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("amuletSheep"));
		
		wingSinew = new MCItem().setUnlocalizedName("wing_sinew").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("wingSinew"));
		wingSegment = new MCItem().setUnlocalizedName("wing_segment").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("hangGliderSegment"));
		
		hangGlider = new ItemHangGlider().setUnlocalizedName("hangglider").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("hangGlider"));
		
		enderAura = new MCItem().setUnlocalizedName("ender_aura").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("enderAura"));
		
		ghastlySoul = new MCItem().setUnlocalizedName("ghastly_soul").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("ghastlySoul"));
		
		witheredBone = new MCItem().setUnlocalizedName("withered_bone").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("witherBone"));
		
		horseHairFibre = new MCItem().setUnlocalizedName("horse_hair_fibre").setCreativeTab(Minestrappolation.tabFood).setTextureName(MCAssetManager.getTexture("horseHairFibre"));
		horseHairBow = new ItemHorseHairBow().setUnlocalizedName("horsehair_bow").setCreativeTab(Minestrappolation.tabFood);
		
		GameRegistry.registerItem(snout, "snout");
		GameRegistry.registerItem(pigHoof, "pigHoof");
		GameRegistry.registerItem(fat, "fat");
		GameRegistry.registerItem(grease, "grease");
		GameRegistry.registerItem(friedApple, "friedApple");
		GameRegistry.registerItem(friedBeef, "friedBeef");
		GameRegistry.registerItem(friedBread, "friedBread");
		GameRegistry.registerItem(friedCarrot, "friedCarrot");
		GameRegistry.registerItem(friedCookie, "friedCookie");
		GameRegistry.registerItem(friedFlesh, "friedFlesh");
		GameRegistry.registerItem(animalBones, "animalBones");
		GameRegistry.registerItem(cowHoof, "cowHoof");
		GameRegistry.registerItem(horn, "horn");
		GameRegistry.registerItem(hornSwordWood, "hornSwordWood");
		GameRegistry.registerItem(hornSwordStone, "hornSwordStone");
		GameRegistry.registerItem(hornSwordIron, "hornSwordIron");
		GameRegistry.registerItem(hornSwordDiamond, "hornSwordDiamond");
		GameRegistry.registerItem(hornSwordGold, "hornSwordGold");
		GameRegistry.registerItem(beakChicken, "beakChicken");
		GameRegistry.registerItem(footChicken, "footChicken");
		GameRegistry.registerItem(chickenWingRaw, "chickenWingRaw");
		GameRegistry.registerItem(chickenWingCooked, "chickenWingCooked");
		GameRegistry.registerItem(lambchopRaw, "lambChopRaw");
		GameRegistry.registerItem(lambchopCooked, "lambChopCooked");
		GameRegistry.registerItem(sheepHoof, "sheepHoof");
		GameRegistry.registerItem(squidTentacle, "squidTentacle");
		GameRegistry.registerItem(calimari, "calimari");
		GameRegistry.registerItem(infectiousFungus, "infectiousFungus");
		GameRegistry.registerItem(airSack, "airSack");
		GameRegistry.registerItem(whisker, "whisker");
		GameRegistry.registerItem(catEye, "catEye");
		GameRegistry.registerItem(wolfHide, "wolfHide");
		GameRegistry.registerItem(flesh, "flesh");
		GameRegistry.registerItem(marrow, "marrow");
		GameRegistry.registerItem(legSpider, "legSpider");
		GameRegistry.registerItem(poisonSack, "poisonSack");
		GameRegistry.registerItem(swordPoisonWood, "swordPoisonWood");
		GameRegistry.registerItem(swordPoisonStone, "swordPoisonStone");
		GameRegistry.registerItem(swordPoisonIron, "swordPoisonIron");
		GameRegistry.registerItem(swordPoisonDiamond, "swordPoisonDiamond");
		GameRegistry.registerItem(swordPoisonGold, "swordPoisonGold");
		GameRegistry.registerItem(guano, "guano");
		GameRegistry.registerItem(carcassSilverfish, "carcassSilverFish");
		GameRegistry.registerItem(hideCreeper, "hideCreeper");
		GameRegistry.registerItem(slimeCore, "slimeCore");
		GameRegistry.registerItem(enderCore, "enderCore");
		GameRegistry.registerItem(ghastTentacle, "ghastTentacle");
		GameRegistry.registerItem(horseHoof, "horseHoof");
		GameRegistry.registerItem(rawHorseHaunch, "rawHorseHaunch");
		GameRegistry.registerItem(cookedHorseHaunch, "cookedHorseHaunch");
		GameRegistry.registerItem(horseHair, "horseHair");
		GameRegistry.registerItem(genes, "genes");
		GameRegistry.registerItem(charms, "charms");
		GameRegistry.registerItem(amuletPorcum, "amuletPorcum");
		GameRegistry.registerItem(amuletVaccam, "amuletVaccam");
		GameRegistry.registerItem(amuletPullum, "amuletPullum");
		GameRegistry.registerItem(amuletOves, "amuletOves");
		GameRegistry.registerItem(wingSinew, "wingSinew");
		GameRegistry.registerItem(wingSegment, "wingSegment");
		GameRegistry.registerItem(hangGlider, "hangGlider");
		GameRegistry.registerItem(enderAura, "enderAura");
		GameRegistry.registerItem(ghastlySoul, "ghastlySoul");
		GameRegistry.registerItem(witheredBone, "witheredBone");
		GameRegistry.registerItem(horseHairFibre, "horseHairFibre");
		GameRegistry.registerItem(horseHairBow, "horseHairBow");
		
		hornSandstone = new MCItemSword(toolMaterialSandstoneH, null).setUnlocalizedName("horned_sandstone_sword").setCreativeTab(Minestrappolation.tabFood);
		hornGranite = new MCItemSword(toolMaterialGraniteH, null).setUnlocalizedName("horned_granite_sword").setCreativeTab(Minestrappolation.tabFood);
		hornCopper = new MCItemSword(toolMaterialCopperH, null).setUnlocalizedName("horned_copper_sword").setCreativeTab(Minestrappolation.tabFood);
		hornSteel = new MCItemSword(toolMaterialSteelH, null).setUnlocalizedName("horned_steel_sword").setCreativeTab(Minestrappolation.tabFood);
		hornBronze = new MCItemSword(toolMaterialBronzeH, null).setUnlocalizedName("horned_bronze_sword").setCreativeTab(Minestrappolation.tabFood);
		hornMeurodite = new MCItemSword(toolMaterialMeuroditeH, null).setUnlocalizedName("horned_meurodite_sword").setCreativeTab(Minestrappolation.tabFood);
		hornTorite = new MCItemSword(toolMaterialToriteH, null).setUnlocalizedName("horned_torite_sword").setCreativeTab(Minestrappolation.tabFood);
		hornBlazium = new MCItemSword(toolMaterialBlaziumH, null).setUnlocalizedName("horned_fire_sword").setCreativeTab(Minestrappolation.tabFood);
		hornTitanium = new MCItemSword(toolMaterialTitaniumH, null).setUnlocalizedName("horned_titanium_sword").setCreativeTab(Minestrappolation.tabFood);
		
		// TODO REGISTER THAT SHIT ^^
		
		// swordPosionSandstone = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.MCItemManager.toolMaterialSandstone,
		// sobiohazardous.minestrappolation.extraores.lib.MCItemManager.SandstoneSword
		// ).setUnlocalizedName("sandstoneSwordPoison").setTextureName("minestrappolation:item_SandstoneSword").setCreativeTab(Minestrappolation.tabFood);
		// swordPosionGranite = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.MCItemManager.toolMaterialGranite,
		// sobiohazardous.minestrappolation.extraores.lib.MCItemManager.GraniteSword
		// ).setUnlocalizedName("graniteSwordPoison").setTextureName("minestrappolation:item_GraniteSword").setCreativeTab(Minestrappolation.tabFood);
		// swordPosionCopper = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.MCItemManager.toolMaterialCopper,
		// sobiohazardous.minestrappolation.extraores.lib.MCItemManager.CopperSword
		// ).setUnlocalizedName("copperSwordPoison").setTextureName("minestrappolation:item_CopperSword").setCreativeTab(Minestrappolation.tabFood);
		// swordPosionSteel = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.MCItemManager.toolMaterialSteel,
		// sobiohazardous.minestrappolation.extraores.lib.MCItemManager.SteelSword
		// ).setUnlocalizedName("steelSwordPoison").setTextureName("minestrappolation:item_SteelSword").setCreativeTab(Minestrappolation.tabFood);
		// swordPosionBronze = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.MCItemManager.toolMaterialBronze,
		// sobiohazardous.minestrappolation.extraores.lib.MCItemManager.BronzeSword
		// ).setUnlocalizedName("bronzeSwordPoison").setTextureName("minestrappolation:item_BronzeSword").setCreativeTab(Minestrappolation.tabFood);
		// swordPosionMeurodite = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.MCItemManager.toolMaterialMeurodite,
		// sobiohazardous.minestrappolation.extraores.lib.MCItemManager.meuroditeSword
		// ).setUnlocalizedName("meuroditeSwordPoison").setTextureName("minestrappolation:item_MeuroditeSword").setCreativeTab(Minestrappolation.tabFood);
		// swordPosionTorite = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.MCItemManager.toolMaterialTorite,
		// sobiohazardous.minestrappolation.extraores.lib.MCItemManager.ToriteSword
		// ).setUnlocalizedName("toriteSwordPoison").setTextureName("minestrappolation:item_ToriteSword").setCreativeTab(Minestrappolation.tabFood);
		// swordPosionBlazium = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.MCItemManager.toolMaterialBlazium,
		// sobiohazardous.minestrappolation.extraores.lib.MCItemManager.BlaziumSword
		// ).setUnlocalizedName("blaziumSwordPoison").setTextureName("minestrappolation:item_BlaziumSword").setCreativeTab(Minestrappolation.tabFood);
		// swordPosionTitanium = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.MCItemManager.toolMaterialTitanium,
		// sobiohazardous.minestrappolation.extraores.lib.MCItemManager.TitaniumSword
		// ).setUnlocalizedName("titaniumSwordPoison").setTextureName("minestrappolation:item_TitaniumSword").setCreativeTab(Minestrappolation.tabFood);
		
	}
	
	public static void addItemsToChests()
	{
		ChestGenHooks dungeonChest = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
		ChestGenHooks mineshaftCorridor = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		ChestGenHooks strongholdCorridor = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR);
		ChestGenHooks strongholdCrossing = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING);
		ChestGenHooks jungleChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		ChestGenHooks desertChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
		ChestGenHooks blacksmithChest = ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH);
		
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot), 1, 5, 30));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(TinIngot), 1, 5, 30));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(BronzeIngot), 1, 3, 25));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CoalIronIngot), 1, 5, 17));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(SteelIngot), 1, 5, 17));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(TinIngot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeIngot), 1, 4, 15));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot), 1, 3, 8));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(TitaniumIngot), 1, 2, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust), 1, 7, 25));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(Uranium), 1, 2, 10));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(Plutonium), 1, 2, 10));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(BronzePickaxe), 1, 1, 11));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(SteelPickaxe), 1, 1, 11));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot), 1, 5, 25));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(TinIngot), 1, 5, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeIngot), 1, 4, 15));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot), 1, 3, 8));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(TitaniumIngot), 1, 2, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust), 1, 7, 25));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(Uranium), 1, 2, 10));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(Plutonium), 1, 2, 10));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(BronzePickaxe), 1, 1, 11));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(SteelPickaxe), 1, 1, 11));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CoalIronIngot), 1, 5, 17));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(BronzeIngot), 1, 3, 25));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(BlaziumIngot), 1, 2, 7));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(SteelSword), 1, 1, 11));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(BronzeSword), 1, 1, 11));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot), 1, 5, 25));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(TinIngot), 1, 5, 30));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(meuroditeIngot), 1, 4, 15));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot), 1, 3, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(TitaniumIngot), 1, 2, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust), 1, 7, 25));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(Uranium), 1, 2, 10));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(Plutonium), 1, 2, 10));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(BronzePickaxe), 1, 1, 11));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(SteelPickaxe), 1, 1, 11));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CoalIronIngot), 1, 5, 17));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(BronzeIngot), 1, 3, 25));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(BlaziumIngot), 1, 2, 7));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(SteelSword), 1, 1, 11));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(BronzeSword), 1, 1, 11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.SoulGem), 1, 3, 12));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot), 1, 3, 8));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust), 1, 7, 25));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(PinkQuartz), 1, 10, 25));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.RadiantQuartz), 1, 3, 10));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(TinIngot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(BronzeIngot), 1, 3, 25));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(CoalIronIngot), 1, 5, 17));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(SteelIngot), 1, 5, 17));
	}
	
	public static void load()
	{
		MBlocks.CopperOre.setHarvestLevel("pickaxe", 0);
		MBlocks.CopperBlock.setHarvestLevel("pickaxe", 0);
		MBlocks.TinOre.setHarvestLevel("pickaxe", 1);
		MBlocks.TinBlock.setHarvestLevel("pickaxe", 1);
		MBlocks.meuroditeOre.setHarvestLevel("pickaxe", 2);
		MBlocks.meuroditeBlock.setHarvestLevel("pickaxe", 2);
		MBlocks.ToriteOre.setHarvestLevel("pickaxe", 2);
		MBlocks.ToriteBlock.setHarvestLevel("pickaxe", 2);
		MBlocks.TitaniumOre.setHarvestLevel("pickaxe", 3);
		MBlocks.TitaniumBlock.setHarvestLevel("pickaxe", 3);
		MBlocks.UraniumOre.setHarvestLevel("pickaxe", 2);
		MBlocks.PlutoniumOre.setHarvestLevel("pickaxe", 2);
		MBlocks.SunstoneOre.setHarvestLevel("pickaxe", 2);
		MBlocks.Granite.setHarvestLevel("pickaxe", 1);
		MBlocks.GraniteBrick.setHarvestLevel("pickaxe", 1);
		MBlocks.Quartzite.setHarvestLevel("pickaxe", 1);
		MBlocks.QuartziteTile.setHarvestLevel("pickaxe", 1);
		MBlocks.SmoothQuartzite.setHarvestLevel("pickaxe", 1);
		MBlocks.PillarQuartzite.setHarvestLevel("pickaxe", 1);
		MBlocks.ChiseledQuartzite.setHarvestLevel("pickaxe", 1);
		MBlocks.SmoothQuartzTile.setHarvestLevel("pickaxe", 1);
		MBlocks.BlaziumOre.setHarvestLevel("pickaxe", 2);
		MBlocks.BlaziumBlock.setHarvestLevel("pickaxe", 2);
		MBlocks.SoulOre.setHarvestLevel("shovel", 2);
		MBlocks.TinPlatedCobble.setHarvestLevel("pickaxe", 1);
		MBlocks.TinPlatedMossy.setHarvestLevel("pickaxe", 1);
		MBlocks.TinPlatedStoneBrick.setHarvestLevel("pickaxe", 1);
		MBlocks.TinPlatedChiseled.setHarvestLevel("pickaxe", 1);
		MBlocks.TinPlatedGranite.setHarvestLevel("pickaxe", 1);
		MBlocks.BronzeBlock.setHarvestLevel("pickaxe", 1);
		MBlocks.BronzePlatedCobble.setHarvestLevel("pickaxe", 2);
		MBlocks.BronzePlatedMossy.setHarvestLevel("pickaxe", 2);
		MBlocks.BronzePlatedStoneBrick.setHarvestLevel("pickaxe", 2);
		MBlocks.BronzePlatedChiseled.setHarvestLevel("pickaxe", 2);
		MBlocks.BronzePlatedGranite.setHarvestLevel("pickaxe", 2);
		MBlocks.SteelPlatedCobble.setHarvestLevel("pickaxe", 1);
		MBlocks.SteelPlatedMossy.setHarvestLevel("pickaxe", 1);
		MBlocks.SteelPlatedStoneBrick.setHarvestLevel("pickaxe", 1);
		MBlocks.SteelPlatedChiseled.setHarvestLevel("pickaxe", 1);
		MBlocks.SteelPlatedGranite.setHarvestLevel("pickaxe", 1);
		MBlocks.RawUraniumBlock.setHarvestLevel("pickaxe", 0);
		MBlocks.RawPlutoniumBlock.setHarvestLevel("pickaxe", 0);
		MBlocks.SmoothRadiantQuartz.setHarvestLevel("pickaxe", 3);
		MBlocks.PillarRadiantQuartz.setHarvestLevel("pickaxe", 3);
		MBlocks.ChiseledRadiantQuartz.setHarvestLevel("pickaxe", 3);
		MBlocks.RadiantQuartzOre.setHarvestLevel("pickaxe", 3);
		MBlocks.Godstone.setHarvestLevel("pickaxe", 2);
		MBlocks.soulBlock.setHarvestLevel("pickaxe", 4);
		Blocks.bedrock.setHarvestLevel("pickaxe", 4);
		
		MBlocks.snowBrick.setHarvestLevel("shovel", 0);
		MBlocks.Tiles.setHarvestLevel("pickaxe", 1, 1);
		MBlocks.Tiles.setHarvestLevel("pickaxe", 1, 3);
		MBlocks.Tiles.setHarvestLevel("pickaxe", 1, 5);
		MBlocks.Tiles.setHarvestLevel("pickaxe", 3, 0);
		MBlocks.gunpowderBlock.setHarvestLevel("shovel", 0);
		MBlocks.sugarBlock.setHarvestLevel("shovel", 0);
		MBlocks.ropeCoil.setHarvestLevel("shears", 0);
		MBlocks.rope.setHarvestLevel("shears", 0);
		MBlocks.checkerTileStairs.setHarvestLevel("pickaxe", 1);
		MBlocks.oozeSlime.setHarvestLevel("shovel", 0);
		MBlocks.magmaOoze.setHarvestLevel("shovel", 0);
		MBlocks.cobbledRoad.setHarvestLevel("pickaxe", 0);
		MBlocks.refinedRoad.setHarvestLevel("pickaxe", 0);
		MBlocks.sandyRoad.setHarvestLevel("pickaxe", 0);
		MBlocks.sandstoneRoad.setHarvestLevel("pickaxe", 0);
		MBlocks.gravelRoad.setHarvestLevel("shovel", 0);
		MBlocks.netherroad.setHarvestLevel("pickaxe", 0);
		MBlocks.refinedNetherroad.setHarvestLevel("pickaxe", 0);
		MBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 0);
		MBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 1);
		MBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 2);
		MBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 3);
		MBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 4);
		MBlocks.infertileDirt.setHarvestLevel("shovel", 0);
	}
}
