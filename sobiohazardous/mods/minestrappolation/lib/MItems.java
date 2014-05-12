package sobiohazardous.mods.minestrappolation.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import sobiohazardous.mods.minestrappolation.core.MinestrappolationCore;
import sobiohazardous.mods.minestrappolation.core.item.MCItem;
import sobiohazardous.mods.minestrappolation.core.item.MCItemArmor;
import sobiohazardous.mods.minestrappolation.core.item.MCItemAxe;
import sobiohazardous.mods.minestrappolation.core.item.MCItemFood;
import sobiohazardous.mods.minestrappolation.core.item.MCItemHoe;
import sobiohazardous.mods.minestrappolation.core.item.MCItemMulti;
import sobiohazardous.mods.minestrappolation.core.item.MCItemPickaxe;
import sobiohazardous.mods.minestrappolation.core.item.MCItemShovel;
import sobiohazardous.mods.minestrappolation.core.item.MCItemSword;
import sobiohazardous.mods.minestrappolation.core.util.MCAssetManager;
import sobiohazardous.mods.minestrappolation.extradecor.lib.EDBlocks;
import sobiohazardous.mods.minestrappolation.extraores.common.EOCommonProxy;
import sobiohazardous.mods.minestrappolation.extraores.lib.EOBlocks;
import sobiohazardous.mods.minestrappolation.item.EDItemDoor;
import sobiohazardous.mods.minestrappolation.item.EOItem;
import sobiohazardous.mods.minestrappolation.item.ItemAirSack;
import sobiohazardous.mods.minestrappolation.item.ItemAmuletOves;
import sobiohazardous.mods.minestrappolation.item.ItemAmuletPorcum;
import sobiohazardous.mods.minestrappolation.item.ItemAmuletPullum;
import sobiohazardous.mods.minestrappolation.item.ItemAmuletVaccam;
import sobiohazardous.mods.minestrappolation.item.ItemCalimari;
import sobiohazardous.mods.minestrappolation.item.ItemCatEye;
import sobiohazardous.mods.minestrappolation.item.ItemCharm;
import sobiohazardous.mods.minestrappolation.item.ItemCookedLambchop;
import sobiohazardous.mods.minestrappolation.item.ItemEnderCore;
import sobiohazardous.mods.minestrappolation.item.ItemGene;
import sobiohazardous.mods.minestrappolation.item.ItemGhastTentacle;
import sobiohazardous.mods.minestrappolation.item.ItemGrenade;
import sobiohazardous.mods.minestrappolation.item.ItemGrenadeImpact;
import sobiohazardous.mods.minestrappolation.item.ItemGrenadeSticky;
import sobiohazardous.mods.minestrappolation.item.ItemGuano;
import sobiohazardous.mods.minestrappolation.item.ItemHangGlider;
import sobiohazardous.mods.minestrappolation.item.ItemHorseHairBow;
import sobiohazardous.mods.minestrappolation.item.ItemInfectiousFungus;
import sobiohazardous.mods.minestrappolation.item.ItemKey;
import sobiohazardous.mods.minestrappolation.item.ItemLock;
import sobiohazardous.mods.minestrappolation.item.ItemPoisonSword;
import sobiohazardous.mods.minestrappolation.item.ToriteToolAxe;
import sobiohazardous.mods.minestrappolation.item.ToriteToolPickaxe;
import sobiohazardous.mods.minestrappolation.item.ToriteToolShovel;
import cpw.mods.fml.common.registry.GameRegistry;

public class MItems
{
	//TODO: ORGANIZE EO ITEMS;
	static ArmorMaterial MaterialMeurodite = EnumHelper.addArmorMaterial("meurodite", 18, new int[] { 2, 7, 6, 2 }, 15);
	static ArmorMaterial MaterialTitanium = EnumHelper.addArmorMaterial("titanium", 66, new int[] { 4, 10, 8, 5 }, 11);
	static ArmorMaterial MaterialTorite = EnumHelper.addArmorMaterial("torite", 17, new int[] { 2, 8, 6, 2 }, 20);
	static ArmorMaterial MaterialBlazium = EnumHelper.addArmorMaterial("blazium", 25, new int[] { 3, 7, 6, 3 }, 18);
	static ArmorMaterial MaterialTin = EnumHelper.addArmorMaterial("tin", 5, new int[] { 2, 4, 3, 2 }, 5);
	static ArmorMaterial MaterialBronze = EnumHelper.addArmorMaterial("bronze", 30, new int[] { 3, 7, 5, 2 }, 8);
	static ArmorMaterial MaterialSteel = EnumHelper.addArmorMaterial("steel", 17, new int[] { 3, 8, 6, 3 }, 15);

	static ArmorMaterial MaterialBPMeurodite = EnumHelper.addArmorMaterial("meuroditeBronze", 36, new int[] { 2, 7, 6, 2 }, 15);
	static ArmorMaterial MaterialBPTitanium = EnumHelper.addArmorMaterial("titaniumBronze", 132, new int[] { 4, 10, 8, 5 }, 11);
	static ArmorMaterial MaterialBPTorite = EnumHelper.addArmorMaterial("toriteBronze", 34, new int[] { 2, 8, 6, 2 }, 20);
	static ArmorMaterial MaterialBPBlazium = EnumHelper.addArmorMaterial("blaziumBronze", 50, new int[] { 3, 7, 6, 3 }, 18);
	static ArmorMaterial MaterialBPTin = EnumHelper.addArmorMaterial("tinBronze", 10, new int[] { 2, 4, 3, 2 }, 5);
	static ArmorMaterial MaterialBPSteel = EnumHelper.addArmorMaterial("steelBronze", 34, new int[] { 3, 8, 6, 3 }, 15);
	static ArmorMaterial MaterialBPCloth = EnumHelper.addArmorMaterial("leatherBronze", 10, new int[] { 1, 3, 2, 1 }, 15);
	static ArmorMaterial MaterialBPChain = EnumHelper.addArmorMaterial("chainBronze", 30, new int[] { 2, 5, 4, 1 }, 12);
	static ArmorMaterial MaterialBPIron = EnumHelper.addArmorMaterial("ironBronze", 30, new int[] { 2, 6, 5, 2 }, 9);
	static ArmorMaterial MaterialBPGold = EnumHelper.addArmorMaterial("goldBronze", 14, new int[] { 2, 5, 3, 1 }, 25);
	static ArmorMaterial MaterialBPDiamond = EnumHelper.addArmorMaterial("diamondBronze", 66, new int[] { 3, 8, 6, 3 }, 10);

	public static ToolMaterial toolMaterialMeurodite = EnumHelper.addToolMaterial("ToolMeurodite", 2, 805, 7.0F, 2, 15);
	public static ToolMaterial toolMaterialTitanium = EnumHelper.addToolMaterial("ToolTitanium", 4, 2999, 10.0F, 5, 10);
	public static ToolMaterial toolMaterialTorite = EnumHelper.addToolMaterial("ToolTorite", 2, 699, 6.0F, 3, 20);
	public static ToolMaterial toolMaterialBlazium = EnumHelper.addToolMaterial("ToolBlazium", 2, 799, 8.0F, 3, 18);
	public static ToolMaterial toolMaterialCopper = EnumHelper.addToolMaterial("ToolCopper", 1, 139, 5.0F, 2, 10);
	public static ToolMaterial toolMaterialSandstone = EnumHelper.addToolMaterial("ToolSandstone", 1, 111, 4.5F, 2, 6);
	public static ToolMaterial toolMaterialBronze = EnumHelper.addToolMaterial("ToolBronze", 2, 1501, 6.5F, 2, 8);
	public static ToolMaterial toolMaterialSteel = EnumHelper.addToolMaterial("ToolSteel", 2, 300, 7.5F, 3, 15);
	public static ToolMaterial toolMaterialBedrock = EnumHelper.addToolMaterial("ToolBedrock", 5, 6247, 7F, 2, 5);
	public static ToolMaterial toolMaterialGranite = EnumHelper.addToolMaterial("ToolGranite", 1, 199, 4.3F, 2, 4);

	public static ToolMaterial toolMaterialBPMeurodite = EnumHelper.addToolMaterial("ToolBPMeurodite", 2, 1610, 7.0F, 2, 15);
	public static ToolMaterial toolMaterialBPTitanium = EnumHelper.addToolMaterial("ToolBPTitanium", 4, 5998, 10.0F, 5, 10);
	public static ToolMaterial toolMaterialBPTorite = EnumHelper.addToolMaterial("ToolBPTorite", 2, 1398, 6.0F, 3, 20);
	public static ToolMaterial toolMaterialBPBlazium = EnumHelper.addToolMaterial("ToolBPBlazium", 2, 1598, 8.0F, 3, 18);
	public static ToolMaterial toolMaterialBPCopper = EnumHelper.addToolMaterial("ToolBPCopper", 1, 278, 5.0F, 2, 10);
	public static ToolMaterial toolMaterialBPSandstone = EnumHelper.addToolMaterial("ToolBPSandstone", 1, 222, 4.5F, 2, 6);
	public static ToolMaterial toolMaterialBPSteel = EnumHelper.addToolMaterial("ToolBPSteel", 2, 600, 7.5F, 3, 15);
	public static ToolMaterial toolMaterialBPBedrock = EnumHelper.addToolMaterial("ToolBPBedrock", 5, 12494, 7F, 2, 5);
	public static ToolMaterial toolMaterialBPGranite = EnumHelper.addToolMaterial("ToolBPGranite", 1, 398, 4.3F, 2, 4);
	public static ToolMaterial toolMaterialBPWood = EnumHelper.addToolMaterial("ToolBPWood", 0, 118, 2.0F, 0, 15);
	public static ToolMaterial toolMaterialBPStone = EnumHelper.addToolMaterial("ToolBPStone", 1, 262, 4.0F, 1, 5);
	public static ToolMaterial toolMaterialBPIron = EnumHelper.addToolMaterial("ToolBPIron", 2, 500, 6.0F, 2, 14);
	public static ToolMaterial toolMaterialBPEmerald = EnumHelper.addToolMaterial("ToolBPEmerald", 3, 3122, 8.0F, 3, 10);
	public static ToolMaterial toolMaterialBPGold = EnumHelper.addToolMaterial("ToolBPGold", 0, 64, 12.0F, 0, 22);

	public static Item grenade;
	public static Item grenadeImpact;
	public static Item grenadeSticky;

	public static Item ToriteSword;
	public static Item ToritePickaxe;
	public static Item ToriteAxe;
	public static Item ToriteHoe;
	public static Item ToriteShovel;

	public static Item ToriteHelmet;
	public static Item ToriteChest;
	public static Item ToritePants;
	public static Item ToriteBoots;

	public static Item BlazeShard;
	public static Item BlaziumIngot;

	public static Item BlaziumSword;
	public static Item BlaziumPickaxe;
	public static Item BlaziumAxe;
	public static Item BlaziumHoe;
	public static Item BlaziumShovel;
	public static Item meuroditeIngot;

	public static Item meuroditeSword;
	public static Item meuroditePickaxe;
	public static Item meuroditeAxe;
	public static Item meuroditeHoe;
	public static Item meuroditeShovel;

	public static Item meuroditeHelmet;
	public static Item meuroditeChest;
	public static Item meuroditePants;
	public static Item meuroditeBoots;
	public static Item TitaniumIngot;

	public static Item TitaniumSword;
	public static Item TitaniumPickaxe;
	public static Item TitaniumAxe;
	public static Item TitaniumHoe;
	public static Item TitaniumShovel;

	public static Item TitaniumHelmet;
	public static Item TitaniumChest;
	public static Item TitaniumPants;
	public static Item TitaniumBoots;
	public static Item ToriteIngot;
	public static Item SunstoneDust;
	public static Item Plutonium;
	public static Item Uranium;

	public static Item BlaziumHelmet;
	public static Item BlaziumChest;
	public static Item BlaziumPants;
	public static Item BlaziumBoots;
	public static Item CopperSword;
	public static Item CopperPickaxe;
	public static Item CopperAxe;
	public static Item CopperHoe;
	public static Item CopperShovel;
	public static Item TinHelmet;
	public static Item TinChest;
	public static Item TinPants;
	public static Item TinBoots;

	public static Item CoalIronIngot;
	public static Item SteelIngot;

	public static Item SteelPickaxe;
	public static Item SteelAxe;
	public static Item SteelShovel;
	public static Item SteelHoe;
	public static Item SteelSword;
	public static Item SteelHelmet;
	public static Item SteelChest;
	public static Item SteelPants;
	public static Item SteelBoots;
	public static Item TinIngot;
	public static Item CopperIngot;

	public static Item PinkQuartz;

	public static Item SandstonePickaxe;
	public static Item SandstoneShovel;
	public static Item SandstoneAxe;
	public static Item SandstoneHoe;
	public static Item SandstoneSword;

	public static Item BronzeIngot;
	public static Item BronzePickaxe;
	public static Item BronzeShovel;
	public static Item BronzeAxe;
	public static Item BronzeHoe;
	public static Item BronzeSword;
	public static Item BronzeHelmet;
	public static Item BronzeChest;
	public static Item BronzePants;
	public static Item BronzeBoots;

	public static Item BedrockPickaxe;
	public static Item BedrockAxe;
	public static Item BedrockShovel;
	public static Item BedrockHoe;

	public static Item GranitePickaxe;
	public static Item GraniteShovel;
	public static Item GraniteAxe;
	public static Item GraniteHoe;
	public static Item GraniteSword;

	public static Item steelKey;
	public static Item steelLock;

	public static Item plateTinItem;
	public static Item plateBronzeItem;
	public static Item plateSteelItem;
	public static Item plateMeuroditeItem;

	// public static Item bucketMagma;
	
	//TODO ORGANIZE ED ITEMS;
	public static Item			ropeItem;
	public static Item			cardboardItem;
	public static Item			sandstoneBrick;
	public static Item			goblet;
	public static Item			glassDoor;
	
	public static Item			brickClay;
	
	//TODO ORGANIZE EMD ITEMS;
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
		//TODO ORGANIZE EO ITEMS
		meuroditeIngot = new EOItem().setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeIngot").setTextureName(MCAssetManager.getEOTexture("gemMeurodite"));
		GameRegistry.registerItem(meuroditeIngot, "ingotMeurodite");
		meuroditeSword = new MCItemSword(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeSword").setTextureName(MCAssetManager.getEOTexture("weaponSwordMeurodite"));
		GameRegistry.registerItem(meuroditeSword, "weaponSwordMeurodite");
		meuroditePickaxe = new MCItemPickaxe(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditePickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickMeurodite"));
		GameRegistry.registerItem(meuroditePickaxe, "toolPickMeurodite");
		meuroditeShovel = new MCItemShovel(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelMeurodite"));
		GameRegistry.registerItem(meuroditeShovel, "toolShovelMeurodite");
		meuroditeHoe = new MCItemHoe(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeMeurodite"));
		GameRegistry.registerItem(meuroditeHoe, "toolHoeMeurodite");
		meuroditeAxe = new MCItemAxe(toolMaterialMeurodite, toolMaterialBPMeurodite).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeMeurodite"));
		GameRegistry.registerItem(meuroditeAxe, "toolAxeMeurodite");

		CopperSword = new MCItemSword(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperSword").setTextureName(MCAssetManager.getEOTexture("weaponSwordCopper"));
		GameRegistry.registerItem(CopperSword, "weaponSwordCopper");
		CopperPickaxe = new MCItemPickaxe(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperPickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickCopper"));
		GameRegistry.registerItem(CopperPickaxe, "toolPickCopper");
		CopperShovel = new MCItemShovel(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelCopper"));
		GameRegistry.registerItem(CopperShovel, "toolShovelCopper");
		CopperHoe = new MCItemHoe(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeCopper"));
		GameRegistry.registerItem(CopperHoe, "toolHoeCopper");
		CopperAxe = new MCItemAxe(toolMaterialCopper, toolMaterialBPCopper).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeCopper"));
		GameRegistry.registerItem(CopperAxe, "toolAxeCopper");

		BlaziumIngot = new EOItem().setCreativeTab(tabOresItems).setUnlocalizedName("item_BlaziumIngot").setTextureName(MCAssetManager.getEOTexture("ingotBlazium"));
		GameRegistry.registerItem(BlaziumIngot, "ingotBlazium");
		BlazeShard = new EOItem().setCreativeTab(tabOresItems).setUnlocalizedName("item_BlazeShard").setTextureName(MCAssetManager.getEOTexture("dustBlazium"));
		GameRegistry.registerItem(BlazeShard, "shardBlazium");

		BlaziumSword = new MCItemSword(toolMaterialBlazium, toolMaterialBPBlazium, true).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireSword").setTextureName(MCAssetManager.getEOTexture("weaponSwordFire"));
		GameRegistry.registerItem(BlaziumSword, "weaponSwordBlazium");
		BlaziumPickaxe = new MCItemPickaxe(toolMaterialBlazium, toolMaterialBPBlazium, true).setCreativeTab(tabOresItems).setUnlocalizedName("item_FirePickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickFire"));
		GameRegistry.registerItem(BlaziumPickaxe, "toolPickBlazium");
		BlaziumShovel = new MCItemShovel(toolMaterialBlazium, toolMaterialBPBlazium, true).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelFire"));
		GameRegistry.registerItem(BlaziumShovel, "toolShovelBlazium");
		BlaziumHoe = new MCItemHoe(toolMaterialBlazium, toolMaterialBPBlazium).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeFire"));
		GameRegistry.registerItem(BlaziumHoe, "toolHoeBlazium");
		BlaziumAxe = new MCItemAxe(toolMaterialBlazium, toolMaterialBPBlazium, true).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeFire"));
		GameRegistry.registerItem(BlaziumAxe, "toolAxeBlazium");

		ToriteIngot = new EOItem().setUnlocalizedName("ingotTorite").setCreativeTab(tabOresItems).setTextureName(MCAssetManager.getEOTexture("ingotTorite"));
		GameRegistry.registerItem(ToriteIngot, "ingotTorite");
		SunstoneDust = new EOItem().setUnlocalizedName("dustSunstone").setCreativeTab(tabOresItems).setTextureName(MCAssetManager.getEOTexture("dustSunstone"));
		GameRegistry.registerItem(SunstoneDust, "dustSunstone");
		Plutonium = new EOItem().setUnlocalizedName("plutonium").setCreativeTab(tabOresItems).setTextureName(MCAssetManager.getEOTexture("dustPlutonium"));
		GameRegistry.registerItem(Plutonium, "dustPlutonium");
		Uranium = new EOItem().setUnlocalizedName("uranium").setCreativeTab(tabOresItems).setTextureName(MCAssetManager.getEOTexture("dustUranium"));
		GameRegistry.registerItem(Uranium, "dustUranium");

		BlaziumHelmet = new MCItemArmor(MaterialBlazium, MaterialBPBlazium, EOCommonProxy.addArmor("fire"), 0, "fire").setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHelmet").setTextureName(MCAssetManager.getEOTexture("armorHelmFire"));
		GameRegistry.registerItem(BlaziumHelmet, "armorHelmetBlazium");
		BlaziumChest = new MCItemArmor(MaterialBlazium, MaterialBPBlazium, EOCommonProxy.addArmor("fire"), 1, "fire").setCreativeTab(tabOresItems).setUnlocalizedName("item_FireChestplate").setTextureName(MCAssetManager.getEOTexture("armorChestFire"));
		GameRegistry.registerItem(BlaziumChest, "armorChestBlazium");
		BlaziumPants = new MCItemArmor(MaterialBlazium, MaterialBPBlazium, EOCommonProxy.addArmor("fire"), 2, "fire").setCreativeTab(tabOresItems).setUnlocalizedName("item_FireLeggings").setTextureName(MCAssetManager.getEOTexture("armorLegsFire"));
		GameRegistry.registerItem(BlaziumPants, "armorPantsBlazium");
		BlaziumBoots = new MCItemArmor(MaterialBlazium, MaterialBPBlazium, EOCommonProxy.addArmor("fire"), 3, "fire").setCreativeTab(tabOresItems).setUnlocalizedName("item_FireBoots").setTextureName(MCAssetManager.getEOTexture("armorBootsFire"));
		GameRegistry.registerItem(BlaziumBoots, "armorBootsBlazium");

		CoalIronIngot = new EOItem().setCreativeTab(tabOresItems).setUnlocalizedName("item_CoalIronIngot").setTextureName(MCAssetManager.getEOTexture("ingotCoalIron"));
		GameRegistry.registerItem(CoalIronIngot, "ingotCoalIron");
		SteelIngot = new EOItem().setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelIngot").setTextureName(MCAssetManager.getEOTexture("ingotSteel"));
		GameRegistry.registerItem(SteelIngot, "ingotSteel");

		SteelPickaxe = new MCItemPickaxe(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelPickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickSteel"));
		GameRegistry.registerItem(SteelPickaxe, "toolPickSteel");
		SteelShovel = new MCItemShovel(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelSteel"));
		GameRegistry.registerItem(SteelShovel, "toolShovelSteel");
		ToriteSword = new MCItemSword(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteSword").setTextureName(MCAssetManager.getEOTexture("weaponSwordTorite"));
		GameRegistry.registerItem(ToriteSword, "weaponSwordTorite");
		ToritePickaxe = new ToriteToolPickaxe(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToritePickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickTorite"));
		GameRegistry.registerItem(ToritePickaxe, "toolPickTorite");
		ToriteShovel = new ToriteToolShovel(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelTorite"));
		GameRegistry.registerItem(ToriteShovel, "toolShovelTorite");
		ToriteHoe = new MCItemHoe(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeTorite"));
		GameRegistry.registerItem(ToriteHoe, "toolHoeTorite");
		ToriteAxe = new ToriteToolAxe(toolMaterialTorite, toolMaterialBPTorite).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeTorite"));
		GameRegistry.registerItem(ToriteAxe, "toolAxeTorite");
		TitaniumIngot = new EOItem().setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumIngot").setTextureName(MCAssetManager.getEOTexture("ingotTitanium"));
		GameRegistry.registerItem(TitaniumIngot, "ingotTitanium");

		TitaniumSword = new MCItemSword(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumSword").setTextureName(MCAssetManager.getEOTexture("weaponSwordTitanium"));
		GameRegistry.registerItem(TitaniumSword, "weaponSwordTitanium");
		TitaniumPickaxe = new MCItemPickaxe(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumPickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickTitanium"));
		GameRegistry.registerItem(TitaniumPickaxe, "toolPickTitanium");
		TitaniumShovel = new MCItemShovel(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelTitanium"));
		GameRegistry.registerItem(TitaniumShovel, "toolShovelTitanium");
		TitaniumHoe = new MCItemHoe(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeTitanium"));
		GameRegistry.registerItem(TitaniumHoe, "toolHoeTitanium");
		TitaniumAxe = new MCItemAxe(toolMaterialTitanium, toolMaterialBPTitanium).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeTitanium"));
		GameRegistry.registerItem(TitaniumAxe, "toolAxeTitanium");
		meuroditeHelmet = new MCItemArmor(MaterialMeurodite, MaterialBPMeurodite, EOCommonProxy.addArmor("Meurodite"), 0, "meurodite").setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHelmet").setTextureName(MCAssetManager.getEOTexture("armorHelmMeurodite"));
		GameRegistry.registerItem(meuroditeHelmet, "armorHelmetMeirodite");
		meuroditeChest = new MCItemArmor(MaterialMeurodite, MaterialBPMeurodite, EOCommonProxy.addArmor("Meurodite"), 1, "meurodite").setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeChestplate").setTextureName(MCAssetManager.getEOTexture("armorChestMeurodite"));
		GameRegistry.registerItem(meuroditeChest, "armorChestMeurodite");
		meuroditePants = new MCItemArmor(MaterialMeurodite, MaterialBPMeurodite, EOCommonProxy.addArmor("Meurodite"), 2, "meurodite").setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeLeggings").setTextureName(MCAssetManager.getEOTexture("armorLegsMeurodite"));
		GameRegistry.registerItem(meuroditePants, "armorPantsMeurodite");
		meuroditeBoots = new MCItemArmor(MaterialMeurodite, MaterialBPMeurodite, EOCommonProxy.addArmor("Meurodite"), 3, "meurodite").setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeBoots").setTextureName(MCAssetManager.getEOTexture("armorBootsMeurodite"));
		GameRegistry.registerItem(meuroditeBoots, "armorBootsMeurodite");

		TitaniumHelmet = new MCItemArmor(MaterialTitanium, MaterialBPTitanium, EOCommonProxy.addArmor("titanium"), 0, "meurodite").setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHelmet").setTextureName(MCAssetManager.getEOTexture("armorHelmTitanium"));
		GameRegistry.registerItem(TitaniumHelmet, "armorHelmetTitanium");
		TitaniumChest = new MCItemArmor(MaterialTitanium, MaterialBPTitanium, EOCommonProxy.addArmor("titanium"), 1, "meurodite").setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumChestplate").setTextureName(MCAssetManager.getEOTexture("armorChestTitanium"));
		GameRegistry.registerItem(TitaniumChest, "armorChestTitanium");
		TitaniumPants = new MCItemArmor(MaterialTitanium, MaterialBPTitanium, EOCommonProxy.addArmor("titanium"), 2, "meurodite").setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumLeggings").setTextureName(MCAssetManager.getEOTexture("armorLegsTitanium"));
		GameRegistry.registerItem(TitaniumPants, "armorPantsTitanium");
		TitaniumBoots = new MCItemArmor(MaterialTitanium, MaterialBPTitanium, EOCommonProxy.addArmor("titanium"), 3, "meurodite").setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumBoots").setTextureName(MCAssetManager.getEOTexture("armorBootsTitanium"));
		GameRegistry.registerItem(TitaniumBoots, "armorBootsTitanium");

		ToriteHelmet = new MCItemArmor(MaterialTorite, MaterialBPTorite, EOCommonProxy.addArmor("torite"), 0, "torite").setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHelmet").setTextureName(MCAssetManager.getEOTexture("armorHelmTorite"));
		GameRegistry.registerItem(ToriteHelmet, "armorHelmetTorite");
		ToriteChest = new MCItemArmor(MaterialTorite, MaterialBPTorite, EOCommonProxy.addArmor("torite"), 1, "torite").setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteChestplate").setTextureName(MCAssetManager.getEOTexture("armorChestTorite"));
		GameRegistry.registerItem(ToriteChest, "armorChestTorite");
		ToritePants = new MCItemArmor(MaterialTorite, MaterialBPTorite, EOCommonProxy.addArmor("torite"), 2, "torite").setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteLeggings").setTextureName(MCAssetManager.getEOTexture("armorLegsTorite"));
		GameRegistry.registerItem(ToritePants, "armorPantsTorite");
		ToriteBoots = new MCItemArmor(MaterialTorite, MaterialBPTorite, EOCommonProxy.addArmor("torite"), 3, "torite").setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteBoots").setTextureName(MCAssetManager.getEOTexture("armorBootsTorite"));
		GameRegistry.registerItem(ToriteBoots, "armorBootsTorite");

		TinIngot = new EOItem().setUnlocalizedName("ingotTin").setTextureName(MCAssetManager.getEOTexture("ingotTin"));
		GameRegistry.registerItem(TinIngot, "ingotTin");
		CopperIngot = new EOItem().setUnlocalizedName("ingotCopper").setTextureName(MCAssetManager.getEOTexture("ingotCopper"));
		GameRegistry.registerItem(CopperIngot, "ingotCopper");
		PinkQuartz = new EOItem().setUnlocalizedName("quartzDesert").setTextureName(MCAssetManager.getEOTexture("gemDesertQuartz"));
		GameRegistry.registerItem(PinkQuartz, "quartzPink");

		SandstonePickaxe = new MCItemPickaxe(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstonePickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickSandstone"));
		GameRegistry.registerItem(SandstonePickaxe, "toolPickSandstone");
		SandstoneShovel = new MCItemShovel(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelSandstone"));
		GameRegistry.registerItem(SandstoneShovel, "toolShovelSandstone");
		SandstoneAxe = new MCItemAxe(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeSandstone"));
		GameRegistry.registerItem(SandstoneAxe, "toolAxeSandstone");
		SandstoneHoe = new MCItemHoe(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeSandstone"));
		GameRegistry.registerItem(SandstoneHoe, "toolHoeSandstone");
		SandstoneSword = new MCItemSword(toolMaterialSandstone, toolMaterialBPSandstone).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneSword").setTextureName(MCAssetManager.getEOTexture("weaponSwordSandstone"));
		GameRegistry.registerItem(SandstoneSword, "weaponSwordSandstone");
		SteelAxe = new MCItemAxe(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeSteel"));
		GameRegistry.registerItem(SteelAxe, "toolAxeSteel");
		SteelHoe = new MCItemHoe(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeSteel"));
		GameRegistry.registerItem(SteelHoe, "toolHoeSteel");
		SteelSword = new MCItemSword(toolMaterialSteel, toolMaterialBPSteel).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelSword").setTextureName(MCAssetManager.getEOTexture("weaponSwordSteel"));
		GameRegistry.registerItem(SteelSword, "weaponSwordSteel");

		SteelHelmet = new MCItemArmor(MaterialSteel, MaterialBPSteel, EOCommonProxy.addArmor("steel"), 0, "steel").setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelHelmet").setTextureName(MCAssetManager.getEOTexture("armorHelmSteel"));
		GameRegistry.registerItem(SteelHelmet, "armorHelmetSteel");
		SteelChest = new MCItemArmor(MaterialSteel, MaterialBPSteel, EOCommonProxy.addArmor("steel"), 1, "steel").setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelChestplate").setTextureName(MCAssetManager.getEOTexture("armorChestSteel"));
		GameRegistry.registerItem(SteelChest, "armorChestSteel");
		SteelPants = new MCItemArmor(MaterialSteel, MaterialBPSteel, EOCommonProxy.addArmor("steel"), 2, "steel").setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelLeggings").setTextureName(MCAssetManager.getEOTexture("armorLegsSteel"));
		GameRegistry.registerItem(SteelPants, "armorPantsSteel");
		SteelBoots = new MCItemArmor(MaterialSteel, MaterialBPSteel, EOCommonProxy.addArmor("steel"), 3, "steel").setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelBoots").setTextureName(MCAssetManager.getEOTexture("armorBootsSteel"));
		GameRegistry.registerItem(SteelBoots, "armorBootsSteel");

		BronzeIngot = new EOItem().setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeIngot").setTextureName(MCAssetManager.getEOTexture("ingotCopper"));
		GameRegistry.registerItem(BronzeIngot, "ingotBronze");
		BronzePickaxe = new MCItemPickaxe(toolMaterialBronze, null).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzePickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickBronze"));
		GameRegistry.registerItem(BronzePickaxe, "toolPickBronze");
		BronzeShovel = new MCItemShovel(toolMaterialBronze, null).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelBronze"));
		GameRegistry.registerItem(BronzeShovel, "toolShovelBronze");
		BronzeAxe = new MCItemAxe(toolMaterialBronze, null).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeBronze"));
		GameRegistry.registerItem(BronzeAxe, "toolAxeBronze");
		BronzeHoe = new MCItemHoe(toolMaterialBronze, null).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeBronze"));
		GameRegistry.registerItem(BronzeHoe, "toolHoeBronze");
		BronzeSword = new MCItemSword(toolMaterialBronze, null).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeSword").setTextureName(MCAssetManager.getEOTexture("weaponSwordBronze"));
		GameRegistry.registerItem(BronzeSword, "weaponSwordBronze");
		BronzeHelmet = new MCItemArmor(MaterialBronze, null, EOCommonProxy.addArmor("bronze"), 0, "bronze").setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeHelmet").setTextureName(MCAssetManager.getEOTexture("armorHelmBronze"));
		GameRegistry.registerItem(BronzeHelmet, "armorHelmetBronze");
		BronzeChest = new MCItemArmor(MaterialBronze, null, EOCommonProxy.addArmor("bronze"), 1, "bronze").setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeChestplate").setTextureName(MCAssetManager.getEOTexture("armorChestBronze"));
		GameRegistry.registerItem(BronzeChest, "armorChestBronze");
		BronzePants = new MCItemArmor(MaterialBronze, null, EOCommonProxy.addArmor("bronze"), 2, "bronze").setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeLeggings").setTextureName(MCAssetManager.getEOTexture("armorLegsBronze"));
		GameRegistry.registerItem(BronzePants, "armorPantsBronze");
		BronzeBoots = new MCItemArmor(MaterialBronze, null, EOCommonProxy.addArmor("bronze"), 3, "bronze").setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeBoots").setTextureName(MCAssetManager.getEOTexture("armorBootsBronze"));
		GameRegistry.registerItem(BronzeBoots, "armorBootsBronze");

		BedrockPickaxe = new MCItemPickaxe(toolMaterialBedrock, toolMaterialBPBedrock).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockPickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickBedrock"));
		GameRegistry.registerItem(BedrockPickaxe, "toolPickBedrock");
		BedrockAxe = new MCItemAxe(toolMaterialBedrock, toolMaterialBPBedrock).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeBedrock"));
		GameRegistry.registerItem(BedrockAxe, "toolAxeBedrock");
		BedrockShovel = new MCItemShovel(toolMaterialBedrock, toolMaterialBPBedrock).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelBedrock"));
		GameRegistry.registerItem(BedrockShovel, "toolShovelBedrock");
		BedrockHoe = new MCItemHoe(toolMaterialBedrock, toolMaterialBPBedrock).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeBedrock"));
		GameRegistry.registerItem(BedrockHoe, "toolHoeBedrock");

		GranitePickaxe = new MCItemPickaxe(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(tabOresItems).setUnlocalizedName("item_GranitePickaxe").setTextureName(MCAssetManager.getEOTexture("toolPickGranite"));
		GameRegistry.registerItem(GranitePickaxe, "toolPickGranite");
		GraniteAxe = new MCItemAxe(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteAxe").setTextureName(MCAssetManager.getEOTexture("toolAxeGranite"));
		GameRegistry.registerItem(GraniteAxe, "toolAxeGranite");
		GraniteShovel = new MCItemShovel(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteShovel").setTextureName(MCAssetManager.getEOTexture("toolShovelGranite"));
		GameRegistry.registerItem(GraniteShovel, "toolShovelGranite");
		GraniteHoe = new MCItemHoe(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteHoe").setTextureName(MCAssetManager.getEOTexture("toolHoeGranite"));
		GameRegistry.registerItem(GraniteHoe, "toolHoeGranite");
		GraniteSword = new MCItemSword(toolMaterialGranite, toolMaterialBPGranite).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteSword").setTextureName(MCAssetManager.getEOTexture("weaponSwordGranite"));
		GameRegistry.registerItem(GraniteSword, "weaponSwordGranite");

		grenade = new ItemGrenade().setUnlocalizedName("grenade").setTextureName(MCAssetManager.getEOTexture("grenadeNuke"));
		GameRegistry.registerItem(grenade, "grenadeNuke");
		grenadeImpact = new ItemGrenadeImpact().setUnlocalizedName("grenadeImpact").setTextureName(MCAssetManager.getEOTexture("grenadeNuke"));
		GameRegistry.registerItem(grenadeImpact, "grenadeImpact");
		grenadeSticky = new ItemGrenadeSticky().setUnlocalizedName("grenadeSticky").setTextureName(MCAssetManager.getEOTexture("grenadeNuke"));
		GameRegistry.registerItem(grenadeSticky, "grenadeSticky");

		// bucketMagma = new EOItemBucket(EOConfig.bucketMagmaId,
		// ExtraOres.eoFluid.getBlockID()).setUnlocalizedName("item_MagmaBucket");

		steelKey = new ItemKey().setUnlocalizedName("item_SteelKey").setCreativeTab(tabOresItems).setTextureName(MCAssetManager.getEOTexture("utilitySteelKey"));
		GameRegistry.registerItem(steelKey, "keySteel");
		steelLock = new ItemLock().setUnlocalizedName("item_SteelLock").setCreativeTab(tabOresItems).setTextureName(MCAssetManager.getEOTexture("utilitySteelLock"));
		GameRegistry.registerItem(steelLock, "mlockSteel");

		plateTinItem = new ItemReed(EOBlocks.TinPlate).setCreativeTab(tabOresItems).setUnlocalizedName("plateTinItem").setTextureName(MCAssetManager.getEOTexture("platingTin"));
		GameRegistry.registerItem(plateTinItem, "plateTinItem");
		plateBronzeItem = new ItemReed(EOBlocks.BronzePlate).setCreativeTab(tabOresItems).setUnlocalizedName("plateBronzeItem").setTextureName(MCAssetManager.getEOTexture("platingBronze"));
		GameRegistry.registerItem(plateBronzeItem, "plateBronzeItem");
		plateSteelItem = new ItemReed(EOBlocks.SteelPlate).setCreativeTab(tabOresItems).setUnlocalizedName("plateSteelItem").setTextureName(MCAssetManager.getEOTexture("platingSteel"));
		GameRegistry.registerItem(plateSteelItem, "plateSteelItem");
		plateMeuroditeItem = new ItemReed(EOBlocks.meuroditePlate).setCreativeTab(tabOresItems).setUnlocalizedName("plateMeuroditeItem").setTextureName(MCAssetManager.getEOTexture("platingMeurodite"));
		GameRegistry.registerItem(plateMeuroditeItem, "plateMeuroditeItem");
		
		//TODO ORGANIZE ED ITEMS;
		ropeItem = new ItemReed(EDBlocks.rope).setUnlocalizedName("rope").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEDTexture("rope"));
		GameRegistry.registerItem(ropeItem, "itemRope");
		cardboardItem = new ItemReed(EDBlocks.cardboard).setCreativeTab(tabItems).setUnlocalizedName("item_Cardboard").setTextureName(MCAssetManager.getEDTexture("cardboard"));
		GameRegistry.registerItem(cardboardItem, "cardboardItem");
		sandstoneBrick = new MCItem().setUnlocalizedName("item_SandstoneBrick").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEDTexture("brickSandstone"));
		GameRegistry.registerItem(sandstoneBrick, "sandstoneBrickItem");
		goblet = new ItemReed(EDBlocks.Goblet).setCreativeTab(tabItems).setUnlocalizedName("item_GobletEmpty").setTextureName(MCAssetManager.getEDTexture("goblet"));
		GameRegistry.registerItem(goblet, "gobletItem");
		glassDoor = new EDItemDoor(EDBlocks.GlassDoor).setUnlocalizedName("item_GlassDoor").setTextureName(MCAssetManager.getEDTexture("doorGlass"));
		GameRegistry.registerItem(glassDoor, "glassDoorItem");
		brickClay = new MCItemMulti(new String[] { MCAssetManager.getEDTexture("brickClayBlack"), MCAssetManager.getEDTexture("brickClayBlue"), MCAssetManager.getEDTexture("brickClayBrown"), MCAssetManager.getEDTexture("brickClayCyan"), MCAssetManager.getEDTexture("brickClayGray"), MCAssetManager.getEDTexture("brickClayGreen"), MCAssetManager.getEDTexture("brickClayLightBlue"), MCAssetManager.getEDTexture("brickClayLime"), MCAssetManager.getEDTexture("brickClayMagenta"), MCAssetManager.getEDTexture("brickClayOrange"), MCAssetManager.getEDTexture("brickClayPink"), MCAssetManager.getEDTexture("brickClayPurple"), MCAssetManager.getEDTexture("brickClayRed"), MCAssetManager.getEDTexture("brickClaySilver"), MCAssetManager.getEDTexture("brickClayWhite"), MCAssetManager.getEDTexture("brickClayYellow") }).setCreativeTab(MinestrappolationCore.creativeTabStone).setUnlocalizedName("brickClay");	
		GameRegistry.registerItem(brickClay, "brickClay");
		
		//TODO ORGANIZE EMD ITEMS
		snout = new MCItemFood(3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setTextureName(MCAssetManager.getEMDTexture("snout")).setUnlocalizedName("snout").setCreativeTab(tabItems);
		pigHoof = new MCItem().setUnlocalizedName("pigFoot").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("footPig"));
		fat = new MCItemFood(8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setUnlocalizedName("fat").setTextureName(MCAssetManager.getEMDTexture("fat")).setCreativeTab(tabItems);
		grease = new MCItem().setUnlocalizedName("grease").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("grease"));
		
		friedApple = new MCItemFood(8, 0.3F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getEMDTexture("friedApple")).setUnlocalizedName("grease_apple").setCreativeTab(tabItems);
		friedBeef = new MCItemFood(16, 0.8F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getEMDTexture("friedBeef")).setUnlocalizedName("grease_beef").setCreativeTab(tabItems);
		friedBread = new MCItemFood(10, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getEMDTexture("friedBread")).setUnlocalizedName("grease_bread").setCreativeTab(tabItems);
		friedCarrot = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getEMDTexture("friedCarrot")).setUnlocalizedName("grease_carrot").setCreativeTab(tabItems);
		friedCookie = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getEMDTexture("friedCookie")).setUnlocalizedName("grease_cookie").setCreativeTab(tabItems);
		friedFlesh = new MCItemFood(8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setTextureName(MCAssetManager.getEMDTexture("friedFlesh")).setUnlocalizedName("grease_flesh").setCreativeTab(tabItems);
		
		animalBones = new MCItem().setUnlocalizedName("animal_bones").setTextureName(MCAssetManager.getEMDTexture("animalBones")).setCreativeTab(tabItems);
		cowHoof = new MCItem().setUnlocalizedName("cow_hoof").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("footCow"));
		
		horn = new MCItem().setUnlocalizedName("horn").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("horn"));
		
		hornSwordWood = new MCItemSword(toolMaterialWoodH, null).setUnlocalizedName("horned_wood_sword").setTextureName(MCAssetManager.getEMDTexture("weaponSwordWoodHorned")).setCreativeTab(tabItems);
		hornSwordStone = new MCItemSword(toolMaterialStoneH, null).setUnlocalizedName("horned_stone_sword").setTextureName(MCAssetManager.getEMDTexture("weaponSwordStoneHorned")).setCreativeTab(tabItems);
		hornSwordIron = new MCItemSword(toolMaterialIronH, null).setUnlocalizedName("horned_iron_sword").setTextureName(MCAssetManager.getEMDTexture("weaponSwordIronHorned")).setCreativeTab(tabItems);
		hornSwordDiamond = new MCItemSword(toolMaterialDiamondH, null).setUnlocalizedName("horned_diamond_sword").setTextureName(MCAssetManager.getEMDTexture("weaponSwordDiamondHorned")).setCreativeTab(tabItems);
		hornSwordGold = new MCItemSword(toolMaterialGoldH, null).setUnlocalizedName("horned_gold_sword").setTextureName(MCAssetManager.getEMDTexture("weaponSwordGoldHorned")).setCreativeTab(tabItems);
		
		beakChicken = new MCItem().setUnlocalizedName("chicken_beak").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("chickenBeak"));
		
		footChicken = new MCItem().setUnlocalizedName("chicken_foot").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("footChicken"));
		
		chickenWingRaw = new MCItemFood(1, 0.1F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.3F).setTextureName(MCAssetManager.getEMDTexture("chickenWingRaw")).setUnlocalizedName("raw_chicken_wing").setCreativeTab(tabItems);
		chickenWingCooked = new MCItemFood(4, 0.65F).setUnlocalizedName("cooked_chicken_wing").setTextureName(MCAssetManager.getEMDTexture("chickenWingCooked")).setCreativeTab(tabItems);
		
		lambchopRaw = new MCItemFood(3, 0.2F).setUnlocalizedName("raw_lamb_chop").setTextureName(MCAssetManager.getEMDTexture("lambChopRaw")).setCreativeTab(tabItems);
		lambchopCooked = new ItemCookedLambchop(6, 0.8F).setUnlocalizedName("cooked_lamb_chop").setTextureName(MCAssetManager.getEMDTexture("lambChopCooked")).setCreativeTab(tabItems);
		
		sheepHoof = new MCItem().setUnlocalizedName("sheep_hoof").setTextureName(MCAssetManager.getEMDTexture("footSheep")).setCreativeTab(tabItems);
		
		squidTentacle = new MCItemFood(2, 0.1F).setPotionEffect(Potion.hunger.id, 8 * 20, 1, 1F).setTextureName(MCAssetManager.getEMDTexture("tentacleSquid")).setUnlocalizedName("tentacle").setCreativeTab(tabItems);
		calimari = new ItemCalimari(2, 0.6F).setUnlocalizedName("calamari").setTextureName(MCAssetManager.getEMDTexture("calimari")).setCreativeTab(tabItems);
		
		infectiousFungus = new ItemInfectiousFungus(0, 0F).setUnlocalizedName("infectious_fungus").setTextureName(MCAssetManager.getEMDTexture("infectiousFungus")).setCreativeTab(tabItems);
		
		airSack = new ItemAirSack().setUnlocalizedName("air_sack").setTextureName(MCAssetManager.getEMDTexture("sackAir")).setCreativeTab(tabItems);
		
		whisker = new MCItem().setUnlocalizedName("whisker").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("whisker"));
		
		catEye = new ItemCatEye(0, 0.0F).setUnlocalizedName("cat_eye").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("catEye"));
		
		wolfHide = new MCItem().setUnlocalizedName("wolf_hide").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("hideWolf"));
		
		flesh = new MCItemFood(4, 0.35F).setPotionEffect(Potion.hunger.id, 20, 0, 0.05F).setUnlocalizedName("flesh").setTextureName(MCAssetManager.getEMDTexture("flesh")).setCreativeTab(tabItems);
		
		marrow = new MCItemFood(5, 0.0F).setUnlocalizedName("marrow").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("bowlMarrow"));
		
		
		legSpider = new MCItem().setUnlocalizedName("spider_leg").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("armSpider"));
		poisonSack = new MCItem().setUnlocalizedName("poison_sack").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("sackPoison"));
		swordPoisonWood = new ItemPoisonSword(ToolMaterial.WOOD, Items.wooden_sword).setUnlocalizedName("woodSwordPoison").setTextureName("wood_sword").setCreativeTab(tabItems);
		swordPoisonStone = new ItemPoisonSword(ToolMaterial.STONE, Items.stone_sword).setUnlocalizedName("stoneSwordPoison").setTextureName("stone_sword").setCreativeTab(tabItems);
		swordPoisonIron = new ItemPoisonSword(ToolMaterial.IRON, Items.iron_sword).setUnlocalizedName("ironSwordPoison").setTextureName("iron_sword").setCreativeTab(tabItems);
		swordPoisonDiamond = new ItemPoisonSword(ToolMaterial.EMERALD, Items.diamond_sword).setUnlocalizedName("diamondSwordPoison").setTextureName("diamond_sword").setCreativeTab(tabItems);
		swordPoisonGold = new ItemPoisonSword(ToolMaterial.GOLD, Items.golden_sword).setUnlocalizedName("goldSwordPoison").setTextureName("gold_sword").setCreativeTab(tabItems);
		
		guano = new ItemGuano().setUnlocalizedName("guano").setTextureName(MCAssetManager.getEMDTexture("guano")).setCreativeTab(tabItems);
		carcassSilverfish = new MCItem().setUnlocalizedName("silverfish_carcass").setTextureName(MCAssetManager.getEMDTexture("silverfishCarcass")).setCreativeTab(tabItems);
		
		hideCreeper = new MCItem().setUnlocalizedName("creeper_hide").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("hideCreeper"));
		
		slimeCore = new MCItem().setUnlocalizedName("slime_core").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("coreSlime"));
		enderCore = new ItemEnderCore(0, 0).setUnlocalizedName("ender_core").setTextureName(MCAssetManager.getEMDTexture("coreEnder")).setCreativeTab(tabItems);
		
		ghastTentacle = new ItemGhastTentacle().setUnlocalizedName("ghast_tentacle").setTextureName(MCAssetManager.getEMDTexture("tentacleGhast")).setCreativeTab(tabItems);
		
		horseHoof = new MCItem().setCreativeTab(tabItems).setUnlocalizedName("horse_foot").setTextureName(MCAssetManager.getEMDTexture("footHorse"));
		rawHorseHaunch = new MCItemFood(4, 0.4F).setCreativeTab(tabItems).setUnlocalizedName("raw_horse_haunch").setTextureName(MCAssetManager.getEMDTexture("horseHaunchRaw"));
		cookedHorseHaunch = new MCItemFood(10, 0.8F).setCreativeTab(tabItems).setUnlocalizedName("cooked_horse_haunch").setTextureName(MCAssetManager.getEMDTexture("horseHaunchCooked"));
		horseHair = new MCItem().setCreativeTab(tabItems).setUnlocalizedName("horse_hair").setTextureName(MCAssetManager.getEMDTexture("horseHair"));
		
		genes = new ItemGene().setUnlocalizedName("gene");
		
		charms = new ItemCharm().setUnlocalizedName("charm").setCreativeTab(tabItems);
		
		amuletPorcum = new ItemAmuletPorcum().setUnlocalizedName("porcum_amulet").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("amuletPig"));
		amuletVaccam = new ItemAmuletVaccam().setUnlocalizedName("vaccam_amulet").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("amuletHorse"));
		amuletPullum = new ItemAmuletPullum().setUnlocalizedName("pullum_amulet").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("amuletChicken"));
		amuletOves = new ItemAmuletOves().setUnlocalizedName("oves_amulet").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("amuletSheep"));
		
		wingSinew = new MCItem().setUnlocalizedName("wing_sinew").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("wingSinew"));
		wingSegment = new MCItem().setUnlocalizedName("wing_segment").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("hangGliderSegment"));
		
		hangGlider = new ItemHangGlider().setUnlocalizedName("hangglider").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("hangGlider"));
		
		enderAura = new MCItem().setUnlocalizedName("ender_aura").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("enderAura"));
		
		ghastlySoul = new MCItem().setUnlocalizedName("ghastly_soul").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("ghastlySoul"));
		
		witheredBone = new MCItem().setUnlocalizedName("withered_bone").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("witherBone"));
		
		horseHairFibre = new MCItem().setUnlocalizedName("horse_hair_fibre").setCreativeTab(tabItems).setTextureName(MCAssetManager.getEMDTexture("horseHairFibre"));
		horseHairBow = new ItemHorseHairBow().setUnlocalizedName("horsehair_bow").setCreativeTab(tabItems);
		
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
		
		hornSandstone = new MCItemSword(toolMaterialSandstoneH, null).setUnlocalizedName("horned_sandstone_sword").setCreativeTab(tabItems);
		hornGranite = new MCItemSword(toolMaterialGraniteH, null).setUnlocalizedName("horned_granite_sword").setCreativeTab(tabItems);
		hornCopper = new MCItemSword(toolMaterialCopperH, null).setUnlocalizedName("horned_copper_sword").setCreativeTab(tabItems);
		hornSteel = new MCItemSword(toolMaterialSteelH, null).setUnlocalizedName("horned_steel_sword").setCreativeTab(tabItems);
		hornBronze = new MCItemSword(toolMaterialBronzeH, null).setUnlocalizedName("horned_bronze_sword").setCreativeTab(tabItems);
		hornMeurodite = new MCItemSword(toolMaterialMeuroditeH, null).setUnlocalizedName("horned_meurodite_sword").setCreativeTab(tabItems);
		hornTorite = new MCItemSword(toolMaterialToriteH, null).setUnlocalizedName("horned_torite_sword").setCreativeTab(tabItems);
		hornBlazium = new MCItemSword(toolMaterialBlaziumH, null).setUnlocalizedName("horned_fire_sword").setCreativeTab(tabItems);
		hornTitanium = new MCItemSword(toolMaterialTitaniumH, null).setUnlocalizedName("horned_titanium_sword").setCreativeTab(tabItems);
		//TODO REGISTER THAT SHIT ^^
		
		// swordPosionSandstone = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialSandstone,
		// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SandstoneSword
		// ).setUnlocalizedName("sandstoneSwordPoison").setTextureName("minestrappolation:item_SandstoneSword").setCreativeTab(tabItems);
		// swordPosionGranite = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialGranite,
		// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.GraniteSword
		// ).setUnlocalizedName("graniteSwordPoison").setTextureName("minestrappolation:item_GraniteSword").setCreativeTab(tabItems);
		// swordPosionCopper = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialCopper,
		// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.CopperSword
		// ).setUnlocalizedName("copperSwordPoison").setTextureName("minestrappolation:item_CopperSword").setCreativeTab(tabItems);
		// swordPosionSteel = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialSteel,
		// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SteelSword
		// ).setUnlocalizedName("steelSwordPoison").setTextureName("minestrappolation:item_SteelSword").setCreativeTab(tabItems);
		// swordPosionBronze = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialBronze,
		// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BronzeSword
		// ).setUnlocalizedName("bronzeSwordPoison").setTextureName("minestrappolation:item_BronzeSword").setCreativeTab(tabItems);
		// swordPosionMeurodite = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialMeurodite,
		// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.meuroditeSword
		// ).setUnlocalizedName("meuroditeSwordPoison").setTextureName("minestrappolation:item_MeuroditeSword").setCreativeTab(tabItems);
		// swordPosionTorite = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialTorite,
		// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.ToriteSword
		// ).setUnlocalizedName("toriteSwordPoison").setTextureName("minestrappolation:item_ToriteSword").setCreativeTab(tabItems);
		// swordPosionBlazium = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialBlazium,
		// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BlaziumSword
		// ).setUnlocalizedName("blaziumSwordPoison").setTextureName("minestrappolation:item_BlaziumSword").setCreativeTab(tabItems);
		// swordPosionTitanium = new
		// ItemPoisonSword(sobiohazardous.minestrappolation.extraores.lib.EOItemManager.toolMaterialTitanium,
		// sobiohazardous.minestrappolation.extraores.lib.EOItemManager.TitaniumSword
		// ).setUnlocalizedName("titaniumSwordPoison").setTextureName("minestrappolation:item_TitaniumSword").setCreativeTab(tabItems);

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
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(EOBlocks.SoulGem), 1, 3, 12));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot), 1, 3, 8));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust), 1, 7, 25));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(PinkQuartz), 1, 10, 25));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(EOBlocks.RadiantQuartz), 1, 3, 10));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(TinIngot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(BronzeIngot), 1, 3, 25));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(CoalIronIngot), 1, 5, 17));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(SteelIngot), 1, 5, 17));
	}

	public static void load()
	{
		EOBlocks.CopperOre.setHarvestLevel("pickaxe", 0);
		EOBlocks.CopperBlock.setHarvestLevel("pickaxe", 0);
		EOBlocks.TinOre.setHarvestLevel("pickaxe", 1);
		EOBlocks.TinBlock.setHarvestLevel("pickaxe", 1);
		EOBlocks.meuroditeOre.setHarvestLevel("pickaxe", 2);
		EOBlocks.meuroditeBlock.setHarvestLevel("pickaxe", 2);
		EOBlocks.ToriteOre.setHarvestLevel("pickaxe", 2);
		EOBlocks.ToriteBlock.setHarvestLevel("pickaxe", 2);
		EOBlocks.TitaniumOre.setHarvestLevel("pickaxe", 3);
		EOBlocks.TitaniumBlock.setHarvestLevel("pickaxe", 3);
		EOBlocks.UraniumOre.setHarvestLevel("pickaxe", 2);
		EOBlocks.PlutoniumOre.setHarvestLevel("pickaxe", 2);
		EOBlocks.SunstoneOre.setHarvestLevel("pickaxe", 2);
		EOBlocks.Granite.setHarvestLevel("pickaxe", 1);
		EOBlocks.GraniteBrick.setHarvestLevel("pickaxe", 1);
		EOBlocks.Quartzite.setHarvestLevel("pickaxe", 1);
		EOBlocks.QuartziteTile.setHarvestLevel("pickaxe", 1);
		EOBlocks.SmoothQuartzite.setHarvestLevel("pickaxe", 1);
		EOBlocks.PillarQuartzite.setHarvestLevel("pickaxe", 1);
		EOBlocks.ChiseledQuartzite.setHarvestLevel("pickaxe", 1);
		EOBlocks.SmoothQuartzTile.setHarvestLevel("pickaxe", 1);
		EOBlocks.BlaziumOre.setHarvestLevel("pickaxe", 2);
		EOBlocks.BlaziumBlock.setHarvestLevel("pickaxe", 2);
		EOBlocks.SoulOre.setHarvestLevel("shovel", 2);
		EOBlocks.TinPlatedCobble.setHarvestLevel("pickaxe", 1);
		EOBlocks.TinPlatedMossy.setHarvestLevel("pickaxe", 1);
		EOBlocks.TinPlatedStoneBrick.setHarvestLevel("pickaxe", 1);
		EOBlocks.TinPlatedChiseled.setHarvestLevel("pickaxe", 1);
		EOBlocks.TinPlatedGranite.setHarvestLevel("pickaxe", 1);
		EOBlocks.BronzeBlock.setHarvestLevel("pickaxe", 1);
		EOBlocks.BronzePlatedCobble.setHarvestLevel("pickaxe", 2);
		EOBlocks.BronzePlatedMossy.setHarvestLevel("pickaxe", 2);
		EOBlocks.BronzePlatedStoneBrick.setHarvestLevel("pickaxe", 2);
		EOBlocks.BronzePlatedChiseled.setHarvestLevel("pickaxe", 2);
		EOBlocks.BronzePlatedGranite.setHarvestLevel("pickaxe", 2);
		EOBlocks.SteelPlatedCobble.setHarvestLevel("pickaxe", 1);
		EOBlocks.SteelPlatedMossy.setHarvestLevel("pickaxe", 1);
		EOBlocks.SteelPlatedStoneBrick.setHarvestLevel("pickaxe", 1);
		EOBlocks.SteelPlatedChiseled.setHarvestLevel("pickaxe", 1);
		EOBlocks.SteelPlatedGranite.setHarvestLevel("pickaxe", 1);
		EOBlocks.RawUraniumBlock.setHarvestLevel("pickaxe", 0);
		EOBlocks.RawPlutoniumBlock.setHarvestLevel("pickaxe", 0);
		EOBlocks.SmoothRadiantQuartz.setHarvestLevel("pickaxe", 3);
		EOBlocks.PillarRadiantQuartz.setHarvestLevel("pickaxe", 3);
		EOBlocks.ChiseledRadiantQuartz.setHarvestLevel("pickaxe", 3);
		EOBlocks.RadiantQuartzOre.setHarvestLevel("pickaxe", 3);
		EOBlocks.Godstone.setHarvestLevel("pickaxe", 2);
		EOBlocks.soulBlock.setHarvestLevel("pickaxe", 4);
		Blocks.bedrock.setHarvestLevel("pickaxe", 4);
		
		EDBlocks.snowBrick.setHarvestLevel("shovel", 0);
		EDBlocks.Tiles.setHarvestLevel("pickaxe", 1, 1);
		EDBlocks.Tiles.setHarvestLevel("pickaxe", 1, 3);
		EDBlocks.Tiles.setHarvestLevel("pickaxe", 1, 5);
		EDBlocks.Tiles.setHarvestLevel("pickaxe", 3, 0);
		EDBlocks.gunpowderBlock.setHarvestLevel("shovel", 0);
		EDBlocks.sugarBlock.setHarvestLevel("shovel", 0);
		EDBlocks.ropeCoil.setHarvestLevel("shears", 0);
		EDBlocks.rope.setHarvestLevel("shears", 0);
		EDBlocks.checkerTileStairs.setHarvestLevel("pickaxe", 1);
		EDBlocks.oozeSlime.setHarvestLevel("shovel", 0);
		EDBlocks.magmaOoze.setHarvestLevel("shovel", 0);
		EDBlocks.cobbledRoad.setHarvestLevel("pickaxe", 0);
		EDBlocks.refinedRoad.setHarvestLevel("pickaxe", 0);
		EDBlocks.sandyRoad.setHarvestLevel("pickaxe", 0);
		EDBlocks.sandstoneRoad.setHarvestLevel("pickaxe", 0);
		EDBlocks.gravelRoad.setHarvestLevel("shovel", 0);
		EDBlocks.netherroad.setHarvestLevel("pickaxe", 0);
		EDBlocks.refinedNetherroad.setHarvestLevel("pickaxe", 0);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 0);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 1);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 2);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 3);
		EDBlocks.sandstoneBricks.setHarvestLevel("pickaxe", 0, 4);
		EDBlocks.infertileDirt.setHarvestLevel("shovel", 0);
	}
}
