package sobiohazardous.minestrappolation.extraores.lib;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import sobiohazardous.minestrappolation.api.item.MItemArmor;
import sobiohazardous.minestrappolation.api.item.MItemAxe;
import sobiohazardous.minestrappolation.api.item.MItemBlockPlacer;
import sobiohazardous.minestrappolation.api.item.MItemHoe;
import sobiohazardous.minestrappolation.api.item.MItemPickaxe;
import sobiohazardous.minestrappolation.api.item.MItemShovel;
import sobiohazardous.minestrappolation.api.item.MItemSword;
import sobiohazardous.minestrappolation.extraores.CreativeTabExtraoresItems;
import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.item.BlaziumToolAxe;
import sobiohazardous.minestrappolation.extraores.item.BlaziumToolHoe;
import sobiohazardous.minestrappolation.extraores.item.BlaziumToolPickaxe;
import sobiohazardous.minestrappolation.extraores.item.BlaziumToolShovel;
import sobiohazardous.minestrappolation.extraores.item.BlaziumToolSword;
import sobiohazardous.minestrappolation.extraores.item.EOItem;
import sobiohazardous.minestrappolation.extraores.item.ItemGrenade;
import sobiohazardous.minestrappolation.extraores.item.ItemGrenadeImpact;
import sobiohazardous.minestrappolation.extraores.item.ItemGrenadeSticky;
import sobiohazardous.minestrappolation.extraores.item.ItemTitaniumPickaxe;
import sobiohazardous.minestrappolation.extraores.item.ToriteToolAxe;
import sobiohazardous.minestrappolation.extraores.item.ToriteToolHoe;
import sobiohazardous.minestrappolation.extraores.item.ToriteToolPickaxe;
import sobiohazardous.minestrappolation.extraores.item.ToriteToolShovel;
import sobiohazardous.minestrappolation.extraores.item.ToriteToolSword;

public class EOItemManager 
{
	public static CreativeTabs tabOresItems = new CreativeTabExtraoresItems(CreativeTabs.getNextID(), "Extrappolated Ores - Items");
	
	static EnumArmorMaterial MaterialMeurodite = EnumHelper.addArmorMaterial("Meurodite", 18, new int[]{2, 7, 6, 2}, 15);
	static EnumArmorMaterial MaterialTitanium = EnumHelper.addArmorMaterial("Titanium", 66, new int[]{4, 10, 8, 5}, 11);
	static EnumArmorMaterial MaterialTorite = EnumHelper.addArmorMaterial("Torite", 17, new int[]{2, 8, 6, 2}, 20);
	static EnumArmorMaterial MaterialBlazium = EnumHelper.addArmorMaterial("Blazium", 25, new int[]{3, 7, 6, 3}, 18);
	static EnumArmorMaterial MaterialTin = EnumHelper.addArmorMaterial("Tin", 5, new int[]{2, 4, 3, 2}, 5);
	static EnumArmorMaterial MaterialBronze = EnumHelper.addArmorMaterial("Bronze", 30, new int[]{3, 7, 5, 2}, 8);
	static EnumArmorMaterial MaterialSteel  = EnumHelper.addArmorMaterial("Steel", 17, new int[]{3, 8, 6, 3}, 15);
	static EnumArmorMaterial MaterialBPMeurodite = EnumHelper.addArmorMaterial("Meurodite", 36, new int[]{2, 7, 6, 2}, 15);
	static EnumArmorMaterial MaterialBPTitanium = EnumHelper.addArmorMaterial("Titanium", 132, new int[]{4, 10, 8, 5}, 11);
	static EnumArmorMaterial MaterialBPTorite = EnumHelper.addArmorMaterial("Torite", 34, new int[]{2, 8, 6, 2}, 20);
	static EnumArmorMaterial MaterialBPBlazium = EnumHelper.addArmorMaterial("Blazium", 50, new int[]{3, 7, 6, 3}, 18);
	static EnumArmorMaterial MaterialBPTin = EnumHelper.addArmorMaterial("Tin", 10, new int[]{2, 4, 3, 2}, 5);
	static EnumArmorMaterial MaterialBPSteel  = EnumHelper.addArmorMaterial("Steel", 34, new int[]{3, 8, 6, 3}, 15);
	static EnumArmorMaterial MaterialBPCloth = EnumHelper.addArmorMaterial("BOCloth", 10, new int[]{1, 3, 2, 1}, 15);
	static EnumArmorMaterial MaterialBPChain = EnumHelper.addArmorMaterial("BPChain", 30, new int[]{2, 5, 4, 1}, 12);
	static EnumArmorMaterial MaterialBPIron = EnumHelper.addArmorMaterial("BPIron", 30, new int[]{2, 6, 5, 2}, 9);
	static EnumArmorMaterial MaterialBPGold = EnumHelper.addArmorMaterial("BPGold", 14, new int[]{2, 5, 3, 1}, 25);
	static EnumArmorMaterial MaterialBPDiamond = EnumHelper.addArmorMaterial("BPDiamond", 66, new int[]{3, 8, 6, 3}, 10);
	
	public static EnumToolMaterial toolMaterialMeurodite = EnumHelper.addToolMaterial("ToolMeurodite", 2, 805, 7.0F, 2, 15);
	public static EnumToolMaterial toolMaterialTitanium = EnumHelper.addToolMaterial("ToolTitanium", 4, 2999, 10.0F, 5, 11);
	public static EnumToolMaterial toolMaterialTorite = EnumHelper.addToolMaterial("ToolTorite", 2, 699, 6.0F, 3, 20);
	public static EnumToolMaterial toolMaterialBlazium = EnumHelper.addToolMaterial("ToolBlazium", 2, 799, 8.0F, 3, 18);
	public static EnumToolMaterial toolMaterialCopper = EnumHelper.addToolMaterial("ToolCopper", 1, 139, 5.0F, 2, 10);
	public static EnumToolMaterial toolMaterialSandstone = EnumHelper.addToolMaterial("ToolSandstone", 1, 111, 4.5F, 2, 6);
	public static EnumToolMaterial toolMaterialBronze = EnumHelper.addToolMaterial("ToolBronze", 2, 1501, 6.5F, 2, 8);
	public static EnumToolMaterial toolMaterialSteel = EnumHelper.addToolMaterial("ToolSteel", 2, 300, 7.5F, 3, 15);
	public static EnumToolMaterial toolMaterialBedrock = EnumHelper.addToolMaterial("ToolBedrock", 3, 6247, 7F, 2, 5);
	public static EnumToolMaterial toolMaterialGranite = EnumHelper.addToolMaterial("ToolGranite", 1, 199, 4.3F, 2, 4);
	public static EnumToolMaterial toolMaterialBPMeurodite = EnumHelper.addToolMaterial("ToolBPMeurodite", 2, 1610, 7.0F, 2, 15);
	public static EnumToolMaterial toolMaterialBPTitanium = EnumHelper.addToolMaterial("ToolBPTitanium", 3, 5998, 10.0F, 5, 11);
	public static EnumToolMaterial toolMaterialBPTorite = EnumHelper.addToolMaterial("ToolBPTorite", 2, 1398, 6.0F, 3, 20);
	public static EnumToolMaterial toolMaterialBPBlazium = EnumHelper.addToolMaterial("ToolBPBlazium", 2, 1598, 8.0F, 3, 18);
	public static EnumToolMaterial toolMaterialBPCopper = EnumHelper.addToolMaterial("ToolBPCopper", 1, 278, 5.0F, 2, 10);
	public static EnumToolMaterial toolMaterialBPSandstone = EnumHelper.addToolMaterial("ToolBPSandstone", 1, 222, 4.5F, 2, 6);
	public static EnumToolMaterial toolMaterialBPSteel = EnumHelper.addToolMaterial("ToolBPSteel", 2, 600, 7.5F, 3, 15);
	public static EnumToolMaterial toolMaterialBPBedrock = EnumHelper.addToolMaterial("ToolBPBedrock", 3, 12494, 7F, 2, 5);
	public static EnumToolMaterial toolMaterialBPGranite = EnumHelper.addToolMaterial("ToolBPGranite", 1, 398, 4.3F, 2, 4);
	public static EnumToolMaterial toolMaterialBPWood = EnumHelper.addToolMaterial("ToolBPWood", 0, 118, 2.0F, 0, 15);
	public static EnumToolMaterial toolMaterialBPStone = EnumHelper.addToolMaterial("ToolBPStone", 1, 262, 4.0F, 1, 5);
	public static EnumToolMaterial toolMaterialBPIron = EnumHelper.addToolMaterial("ToolBPIron", 2, 500, 6.0F, 2, 14);
	public static EnumToolMaterial toolMaterialBPEmerald = EnumHelper.addToolMaterial("ToolBPEmerald", 3, 3122, 8.0F, 3, 10);
	public static EnumToolMaterial toolMaterialBPGold = EnumHelper.addToolMaterial("ToolBPGold", 0, 64, 12.0F, 0, 22);

	public static Item grenade;
	public static Item grenadeImpact;
	public static Item grenadeSticky;
	
	public static Item BPMeuroditeSword;
	public static Item BPMeuroditePickaxe;
	public static Item BPMeuroditeAxe;
	public static Item BPMeuroditeHoe;
	public static Item BPMeuroditeShovel;
	
	public static Item BPMeuroditeHelmet;
	public static Item BPMeuroditeChest;
	public static Item BPMeuroditePants;
	public static Item BPMeuroditeBoots;
	
	public static Item BPTitaniumSword;
	public static Item BPTitaniumPickaxe;
	public static Item BPTitaniumAxe;
	public static Item BPTitaniumHoe;
	public static Item BPTitaniumShovel;
	
	public static Item BPTitaniumHelmet;
	public static Item BPTitaniumChest;
	public static Item BPTitaniumPants;
	public static Item BPTitaniumBoots;
	
	public static Item BPToriteSword;
	public static Item BPToritePickaxe;
	public static Item BPToriteAxe;
	public static Item BPToriteHoe;
	public static Item BPToriteShovel;
	
	public static Item BPToriteHelmet;
	public static Item BPToriteChest;
	public static Item BPToritePants;
	public static Item BPToriteBoots;
	
	public static Item BPBlaziumSword;
	public static Item BPBlaziumPickaxe;
	public static Item BPBlaziumAxe;
	public static Item BPBlaziumHoe;
	public static Item BPBlaziumShovel;
	
	public static Item BPBlaziumHelmet;
	public static Item BPBlaziumChest;
	public static Item BPBlaziumPants;
	public static Item BPBlaziumBoots;
	
	public static Item BPCopperSword;
	public static Item BPCopperPickaxe;
	public static Item BPCopperAxe;
	public static Item BPCopperHoe;
	public static Item BPCopperShovel;
	
	public static Item BPTinHelmet;
	public static Item BPTinChest;
	public static Item BPTinPants;
	public static Item BPTinBoots;
	
	public static Item BPSteelPickaxe;
	public static Item BPSteelAxe;
	public static Item BPSteelShovel;
	public static Item BPSteelHoe;
	public static Item BPSteelSword;
	
	public static Item BPSteelHelmet;
	public static Item BPSteelChest;
	public static Item BPSteelPants;
	public static Item BPSteelBoots;
	
	public static Item BPSandstonePickaxe;
	public static Item BPSandstoneShovel;
	public static Item BPSandstoneAxe;
	public static Item BPSandstoneHoe;
	public static Item BPSandstoneSword;
	
	public static Item BPBedrockPickaxe;
	public static Item BPBedrockAxe;
	public static Item BPBedrockShovel;
	public static Item BPBedrockHoe;
	
	public static Item BPGranitePickaxe;
	public static Item BPGraniteShovel;
	public static Item BPGraniteAxe;
	public static Item BPGraniteHoe;
	public static Item BPGraniteSword;
	
	public static Item BPWoodPickaxe;
	public static Item BPWoodAxe;
	public static Item BPWoodShovel;
	public static Item BPWoodHoe;
	public static Item BPWoodSword;
	
	public static Item BPClothHelmet;
	public static Item BPClothChest;
	public static Item BPClothPants;
	public static Item BPClothBoots;
	
	public static Item BPStonePickaxe;
	public static Item BPStoneAxe;
	public static Item BPStoneShovel;
	public static Item BPStoneHoe;
	public static Item BPStoneSword;
	
	public static Item BPChainHelmet;
	public static Item BPChainChest;
	public static Item BPChainPants;
	public static Item BPChainBoots;
	
	public static Item BPIronPickaxe;
	public static Item BPIronAxe;
	public static Item BPIronShovel;
	public static Item BPIronHoe;
	public static Item BPIronSword;
	
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
	public static Item TinPlateItem;
	public static Item BronzePlateItem;
	public static Item SteelPlateItem;
	
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
	
	public static Item BPIronHelmet;
	public static Item BPIronChest;
	public static Item BPIronPants;
	public static Item BPIronBoots;
	
	public static Item BPGoldPickaxe;
	public static Item BPGoldAxe;
	public static Item BPGoldShovel;
	public static Item BPGoldHoe;
	public static Item BPGoldSword;
	
	public static Item BPGoldHelmet;
	public static Item BPGoldChest;
	public static Item BPGoldPants;
	public static Item BPGoldBoots;
	
	public static Item BPDiamondPickaxe;
	public static Item BPDiamondAxe;
	public static Item BPDiamondShovel;
	public static Item BPDiamondHoe;
	public static Item BPDiamondSword;
	
	public static Item BPDiamondHelmet;
	public static Item BPDiamondChest;
	public static Item BPDiamondPants;
	public static Item BPDiamondBoots;
	
	public static Item meuroditePlateItem;
	
	public static void addItems()
	{
		meuroditeIngot = (new EOItem(EOConfig.meuroditeIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeIngot");
		meuroditeSword = (new MItemSword(EOConfig.meuroditeSwordId, toolMaterialMeurodite, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeSword");
		meuroditePickaxe = (new MItemPickaxe(EOConfig.meuroditePickaxeId, toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditePickaxe");
		meuroditeShovel = (new MItemShovel(EOConfig.meuroditeShovelId, toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeShovel");
		meuroditeHoe = (new MItemHoe(EOConfig.meuroditeHoeId, toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHoe");
		meuroditeAxe = (new MItemAxe(EOConfig.meuroditeAxeId, toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeAxe");

		TinPlateItem = (new MItemBlockPlacer(EOConfig.tinPlateItemId, EOBlockManager.TinPlate)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinPlate");
		meuroditePlateItem = (new MItemBlockPlacer(EOConfig.meuroditePlateItemID, EOBlockManager.meuroditePlate)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditePlate");
		BronzePlateItem = (new MItemBlockPlacer(EOConfig.bronzePlateItemId, EOBlockManager.BronzePlate)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzePlate");
		SteelPlateItem = (new MItemBlockPlacer(EOConfig.steelPlateItemId, EOBlockManager.SteelPlate)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelPlate");
		CopperSword = (new MItemSword(EOConfig.copperSwordId,toolMaterialCopper, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperSword");
		CopperPickaxe = (new MItemPickaxe(EOConfig.copperPickaxeId,toolMaterialCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperPickaxe");
		CopperShovel = (new MItemShovel(EOConfig.copperShovelId,toolMaterialCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperShovel");
		CopperHoe = (new MItemHoe(EOConfig.copperHoeId,toolMaterialCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperHoe");
		CopperAxe = (new MItemAxe(EOConfig.copperAxeId,toolMaterialCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperAxe");

		BlaziumIngot = (new EOItem(EOConfig.blaziumIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BlaziumIngot");
		BlazeShard = (new EOItem(EOConfig.blaziumShardId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BlazeShard");
	
		BlaziumSword = (new MItemSword(EOConfig.blaziumSwordId, toolMaterialBlazium, true)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireSword");
		BlaziumPickaxe = (new BlaziumToolPickaxe(EOConfig.blaziumPickaxeId, toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FirePickaxe");
		BlaziumShovel = (new BlaziumToolShovel(EOConfig.blaziumShovelId,toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireShovel");
		BlaziumHoe = (new MItemHoe(EOConfig.blaziumHoeId,toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHoe");
		BlaziumAxe = (new BlaziumToolAxe(EOConfig.blaziumAxeId,toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireAxe");
		
		BlaziumHelmet = (new MItemArmor(EOConfig.blaziumHelmetId, MaterialBlazium, ExtraOres.proxy.addArmor("fire"), 0, "fire_1", "fire_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHelmet");
		BlaziumChest = (new MItemArmor(EOConfig.blaziumChestId,MaterialBlazium, ExtraOres.proxy.addArmor("fire"), 1, "fire_1", "fire_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireChestplate");
		BlaziumPants = (new MItemArmor(EOConfig.blaziumPantsId,MaterialBlazium, ExtraOres.proxy.addArmor("fire"),2, "fire_1", "fire_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireLeggings");
		BlaziumBoots = (new MItemArmor(EOConfig.blaziumBootsId,MaterialBlazium, ExtraOres.proxy.addArmor("fire"),3, "fire_1", "fire_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireBoots");
	
		CoalIronIngot = (new EOItem(EOConfig.coalIronIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CoalIronIngot");
		SteelIngot = (new EOItem(EOConfig.steelIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelIngot");
		
		SteelPickaxe = (new MItemPickaxe(EOConfig.steelPickaxeId,toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelPickaxe");
		SteelShovel = (new MItemShovel(EOConfig.steelShovelId,toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelShovel");
		ToriteSword = (new ToriteToolSword(EOConfig.toriteSwordId, toolMaterialTorite, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteSword");
		ToritePickaxe = (new ToriteToolPickaxe(EOConfig.toritePickaxeId, toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToritePickaxe");
		ToriteShovel = (new ToriteToolShovel(EOConfig.toriteShovelId, toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteShovel");
		ToriteHoe = (new ToriteToolHoe(EOConfig.toriteHoeId,toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHoe");
		ToriteAxe = (new ToriteToolAxe(EOConfig.toriteAxeId,toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteAxe");
		TitaniumIngot = (new EOItem(EOConfig.titaniumIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumIngot");
		
		TitaniumSword = (new MItemSword(EOConfig.titaniumSwordId, toolMaterialTitanium, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumSword");
		TitaniumPickaxe = (new ItemTitaniumPickaxe(EOConfig.titaniumPickaxeId, toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumPickaxe");
		TitaniumShovel = (new MItemShovel(EOConfig.titaniumShovelId, toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumShovel");
		TitaniumHoe = (new MItemHoe(EOConfig.titaniumHoeId,toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHoe");
		TitaniumAxe = (new MItemAxe(EOConfig.titaniumAxeId,toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumAxe");
		meuroditeHelmet = (new MItemArmor(EOConfig.meuroditeHelmetId, MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"), 0, "meurodite_1", "meurodite_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHelmet");
		meuroditeChest = (new MItemArmor(EOConfig.meuroditeChestId, MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"), 1, "meurodite_1", "meurodite_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeChestplate");
		meuroditePants = (new MItemArmor(EOConfig.meuroditePantsId,MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"),2, "meurodite_1", "meurodite_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeLeggings");
		meuroditeBoots = (new MItemArmor(EOConfig.meuroditeBootsId, MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"),3, "meurodite_1", "meurodite_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeBoots");
			
		TitaniumHelmet = (new MItemArmor(EOConfig.titaniumHelmetId, MaterialTitanium, ExtraOres.proxy.addArmor("titanium"), 0, "titanium_1", "titanium_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHelmet");
		TitaniumChest = (new MItemArmor(EOConfig.titaniumChestId,MaterialTitanium, ExtraOres.proxy.addArmor("titanium"), 1, "titanium_1", "titanium_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumChestplate");
		TitaniumPants = (new MItemArmor(EOConfig.titaniumPantsId, MaterialTitanium, ExtraOres.proxy.addArmor("titanium"),2, "titanium_1", "titanium_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumLeggings");
		TitaniumBoots = (new MItemArmor(EOConfig.titaniumBootsId,MaterialTitanium, ExtraOres.proxy.addArmor("titanium"),3, "titanium_1", "titanium_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumBoots");
		
		ToriteHelmet = (new MItemArmor(EOConfig.toriteHelmetId,MaterialTorite, ExtraOres.proxy.addArmor("torite"), 0, "torite_1", "torite_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHelmet");
		ToriteChest = (new MItemArmor(EOConfig.toriteChestId,MaterialTorite, ExtraOres.proxy.addArmor("torite"), 1, "torite_1", "torite_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteChestplate");
		ToritePants = (new MItemArmor(EOConfig.toritePantsId,MaterialTorite, ExtraOres.proxy.addArmor("torite"),2, "torite_1", "torite_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteLeggings");
		ToriteBoots = (new MItemArmor(EOConfig.toriteBootsId,MaterialTorite, ExtraOres.proxy.addArmor("torite"),3, "torite_1", "torite_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteBoots");
		SandstonePickaxe = (new MItemPickaxe(EOConfig.sandstonePickaxeId, toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstonePickaxe");
		SandstoneShovel = (new MItemShovel(EOConfig.sandstoneShovelId,toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneShovel");
		SandstoneAxe = (new MItemAxe(EOConfig.sandstoneAxeId, toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneAxe");
		SandstoneHoe = (new MItemHoe(EOConfig.sandstoneHoeId,toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneHoe");
		SandstoneSword = (new MItemSword(EOConfig.sandstoneSwordId,toolMaterialSandstone, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneSword");
		SteelAxe = (new MItemAxe(EOConfig.steelAxeId,toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelAxe");
		SteelHoe = (new MItemHoe(EOConfig.steelHoeId,toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelHoe");
		SteelSword = (new MItemSword(EOConfig.steelSwordId,toolMaterialSteel, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelSword");
		
		SteelHelmet = (new MItemArmor(EOConfig.steelHelmetId, MaterialSteel, ExtraOres.proxy.addArmor("steel"), 0, "steel_1", "steel_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelHelmet");
		SteelChest = (new MItemArmor(EOConfig.steelChestId,MaterialSteel, ExtraOres.proxy.addArmor("steel"), 1, "steel_1", "steel_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelChestplate");
		SteelPants = (new MItemArmor(EOConfig.steelPantsId,MaterialSteel, ExtraOres.proxy.addArmor("steel"), 2, "steel_1", "steel_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelLeggings");
		SteelBoots = (new MItemArmor(EOConfig.steelBootsId,MaterialSteel, ExtraOres.proxy.addArmor("steel"), 3, "steel_1", "steel_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelBoots");
		
		BronzeIngot = (new EOItem(EOConfig.bronzeIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeIngot");
		BronzePickaxe = (new MItemPickaxe(EOConfig.bronzePickaxeId,toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzePickaxe");
		BronzeShovel = (new MItemShovel(EOConfig.bronzeShovelId,toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeShovel");
		BronzeAxe = (new MItemAxe(EOConfig.bronzeAxeId,toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeAxe");
		BronzeHoe = (new MItemHoe(EOConfig.bronzeHoeId, toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeHoe");
		BronzeSword = (new MItemSword(EOConfig.bronzeSwordId, toolMaterialBronze, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeSword");
		BronzeHelmet = (new MItemArmor(EOConfig.bronzeHelmetId, MaterialBronze, ExtraOres.proxy.addArmor("bronze"), 0, "bronze_1", "bronze_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeHelmet");
		BronzeChest = (new MItemArmor(EOConfig.bronzeChestId,MaterialBronze, ExtraOres.proxy.addArmor("bronze"), 1, "bronze_1", "bronze_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeChestplate");
		BronzePants = (new MItemArmor(EOConfig.bronzePantsId,MaterialBronze, ExtraOres.proxy.addArmor("bronze"),2, "bronze_1", "bronze_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeLeggings");
		BronzeBoots = (new MItemArmor(EOConfig.bronzeBootsId,MaterialBronze, ExtraOres.proxy.addArmor("bronze"),3, "bronze_1", "bronze_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeBoots");
		
		grenade = (new ItemGrenade(EOConfig.grenadeId)).setUnlocalizedName("grenade");
		grenadeImpact = (new ItemGrenadeImpact(EOConfig.grenadeImpactId)).setUnlocalizedName("grenadeImpact");
		grenadeSticky = (new ItemGrenadeSticky(EOConfig.grenadeStickyId)).setUnlocalizedName("grenadeSticky");		
		
		BPMeuroditeSword = (new MItemSword(EOConfig.BPmeuroditeSwordId, toolMaterialBPMeurodite, false)).setUnlocalizedName("item_BronzePlatedMeuroditeSword");
		BPMeuroditePickaxe = (new MItemPickaxe(EOConfig.BPmeuroditePickaxeId, toolMaterialBPMeurodite)).setUnlocalizedName("item_BronzePlatedMeuroditePickaxe");
		BPMeuroditeShovel = (new MItemShovel(EOConfig.BPmeuroditeShovelId, toolMaterialBPMeurodite)).setUnlocalizedName("item_BronzePlatedMeuroditeShovel");
		BPMeuroditeHoe = (new MItemHoe(EOConfig.BPmeuroditeHoeId, toolMaterialBPMeurodite)).setUnlocalizedName("item_BronzePlatedMeuroditeHoe");
		BPMeuroditeAxe = (new MItemAxe(EOConfig.BPmeuroditeAxeId, toolMaterialBPMeurodite)).setUnlocalizedName("item_BronzePlatedMeuroditeAxe");
	
		BPMeuroditeHelmet = (new MItemArmor(EOConfig.BPmeuroditeHelmetId, MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"), 0, "meurodite_plated_1", "meurodite_plated_2")).setUnlocalizedName("item_BronzePlatedMeuroditeHelmet");
		BPMeuroditeChest = (new MItemArmor(EOConfig.BPmeuroditeChestId, MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"), 1, "meurodite_plated_1", "meurodite_plated_2")).setUnlocalizedName("item_BronzePlatedMeuroditeChestplate");
		BPMeuroditePants = (new MItemArmor(EOConfig.BPmeuroditePantsId,MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"),2, "meurodite_plated_1", "meurodite_plated_2")).setUnlocalizedName("item_BronzePlatedMeuroditeLeggings");
		BPMeuroditeBoots = (new MItemArmor(EOConfig.BPmeuroditeBootsId, MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"),3, "meurodite_plated_1", "meurodite_plated_2")).setUnlocalizedName("item_BronzePlatedMeuroditeBoots");
		
		BPTitaniumSword = (new MItemSword(EOConfig.BPTitaniumSwordId, toolMaterialBPTitanium, false)).setUnlocalizedName("item_BronzePlatedTitaniumSword");
		BPTitaniumPickaxe = (new MItemPickaxe(EOConfig.BPTitaniumPickaxeId, toolMaterialBPTitanium)).setUnlocalizedName("item_BronzePlatedTitaniumPickaxe");
		BPTitaniumShovel = (new MItemShovel(EOConfig.BPTitaniumShovelId, toolMaterialBPTitanium)).setUnlocalizedName("item_BronzePlatedTitaniumShovel");
		BPTitaniumHoe = (new MItemHoe(EOConfig.BPTitaniumHoeId,toolMaterialBPTitanium)).setUnlocalizedName("item_BronzePlatedTitaniumHoe");
		BPTitaniumAxe = (new MItemAxe(EOConfig.BPTitaniumAxeId,toolMaterialBPTitanium)).setUnlocalizedName("item_BronzePlatedTitaniumAxe");
	
		BPTitaniumHelmet = (new MItemArmor(EOConfig.BPTitaniumHelmetId, MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"), 0, "titanium_plated_1", "titanium_plated_2")).setUnlocalizedName("item_BronzePlatedTitaniumHelmet");
		BPTitaniumChest = (new MItemArmor(EOConfig.BPTitaniumChestId,MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"), 1, "titanium_plated_1", "titanium_plated_2")).setUnlocalizedName("item_BronzePlatedTitaniumChestplate");
		BPTitaniumPants = (new MItemArmor(EOConfig.BPTitaniumPantsId, MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"),2, "titanium_plated_1", "titanium_plated_2")).setUnlocalizedName("item_BronzePlatedTitaniumLeggings");
		BPTitaniumBoots = (new MItemArmor(EOConfig.BPTitaniumBootsId,MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"),3, "titanium_plated_1", "titanium_plated_2")).setUnlocalizedName("item_BronzePlatedTitaniumBoots");
		
		BPToriteSword = (new ToriteToolSword(EOConfig.BPToriteSwordId, toolMaterialBPTorite, false)).setUnlocalizedName("item_BronzePlatedToriteSword");
		BPToritePickaxe = (new ToriteToolPickaxe(EOConfig.BPToritePickaxeId, toolMaterialBPTorite)).setUnlocalizedName("item_BronzePlatedToritePickaxe");
		BPToriteShovel = (new ToriteToolShovel(EOConfig.BPToriteShovelId, toolMaterialBPTorite)).setUnlocalizedName("item_BronzePlatedToriteShovel");
		BPToriteHoe = (new ToriteToolHoe(EOConfig.BPToriteHoeId,toolMaterialBPTorite)).setUnlocalizedName("item_BronzePlatedToriteHoe");
		BPToriteAxe = (new ToriteToolAxe(EOConfig.BPToriteAxeId,toolMaterialBPTorite)).setUnlocalizedName("item_BronzePlatedToriteAxe");
		
		BPToriteHelmet = (new MItemArmor(EOConfig.BPToriteHelmetId,MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"), 0, "torite_plated_1", "torite_plated_2")).setUnlocalizedName("item_BronzePlatedToriteHelmet");
		BPToriteChest = (new MItemArmor(EOConfig.BPToriteChestId,MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"), 1, "torite_plated_1", "torite_plated_2")).setUnlocalizedName("item_BronzePlatedToriteChestplate");
		BPToritePants = (new MItemArmor(EOConfig.BPToritePantsId,MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"),2, "torite_plated_1", "torite_plated_2")).setUnlocalizedName("item_BronzePlatedToriteLeggings");
		BPToriteBoots = (new MItemArmor(EOConfig.BPToriteBootsId,MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"),3, "torite_plated_1", "torite_plated_2")).setUnlocalizedName("item_BronzePlatedToriteBoots");
		
		BPBlaziumSword = (new MItemSword(EOConfig.BPBlaziumSwordId, toolMaterialBPBlazium, true)).setUnlocalizedName("item_BronzePlatedFireSword");
		BPBlaziumPickaxe = (new BlaziumToolPickaxe(EOConfig.BPBlaziumPickaxeId, toolMaterialBPBlazium)).setUnlocalizedName("item_BronzePlatedFirePickaxe");
		BPBlaziumShovel = (new BlaziumToolShovel(EOConfig.BPBlaziumShovelId,toolMaterialBPBlazium)).setUnlocalizedName("item_BronzePlatedFireShovel");
		BPBlaziumHoe = (new MItemHoe(EOConfig.BPBlaziumHoeId,toolMaterialBPBlazium)).setUnlocalizedName("item_BronzePlatedFireHoe");
		BPBlaziumAxe = (new BlaziumToolAxe(EOConfig.BPBlaziumAxeId,toolMaterialBPBlazium)).setUnlocalizedName("item_BronzePlatedFireAxe");
		
		BPBlaziumHelmet = (new MItemArmor(EOConfig.BPBlaziumHelmetId, MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"), 0, "fire_plated_1", "fire_plated_2")).setUnlocalizedName("item_BronzePlatedFireHelmet");
		BPBlaziumChest = (new MItemArmor(EOConfig.BPBlaziumChestId,MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"), 1, "fire_plated_1", "fire_plated_2")).setUnlocalizedName("item_BronzePlatedFireChestplate");
		BPBlaziumPants = (new MItemArmor(EOConfig.BPBlaziumPantsId,MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"),2, "fire_plated_1", "fire_plated_2")).setUnlocalizedName("item_BronzePlatedFireLeggings");
		BPBlaziumBoots = (new MItemArmor(EOConfig.BPBlaziumBootsId,MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"),3, "fire_plated_1", "fire_plated_2")).setUnlocalizedName("item_BronzePlatedFireBoots");
		
		BPCopperSword = (new MItemSword(EOConfig.BPCopperSwordId,toolMaterialBPCopper, false)).setUnlocalizedName("item_BronzePlatedCopperSword");
		BPCopperPickaxe = (new MItemPickaxe(EOConfig.BPCopperPickaxeId,toolMaterialBPCopper)).setUnlocalizedName("item_BronzePlatedCopperPickaxe");
		BPCopperShovel = (new MItemShovel(EOConfig.BPCopperShovelId,toolMaterialBPCopper)).setUnlocalizedName("item_BronzePlatedCopperShovel");
		BPCopperHoe = (new MItemHoe(EOConfig.BPCopperHoeId,toolMaterialBPCopper)).setUnlocalizedName("item_BronzePlatedCopperHoe");
		BPCopperAxe = (new MItemAxe(EOConfig.BPCopperAxeId,toolMaterialBPCopper)).setUnlocalizedName("item_BronzePlatedCopperAxe");
		
		BPTinHelmet = (new MItemArmor(EOConfig.BPTinHelmetId, MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"), 0, "tin_plated_1", "tin_plated_2")).setUnlocalizedName("item_BronzePlatedTinHelmet");
		BPTinChest = (new MItemArmor(EOConfig.BPTinChestId,MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"), 1, "tin_plated_1", "tin_plated_2")).setUnlocalizedName("item_BronzePlatedTinChestplate");
		BPTinPants = (new MItemArmor(EOConfig.BPTinPantsId,MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"),2, "tin_plated_1", "tin_plated_2")).setUnlocalizedName("item_BronzePlatedTinLeggings");
		BPTinBoots = (new MItemArmor(EOConfig.BPTinBootsId,MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"),3, "tin_plated_1", "tin_plated_2")).setUnlocalizedName("item_BronzePlatedTinBoots");
		
		BPSteelPickaxe = (new MItemPickaxe(EOConfig.BPSteelPickaxeId,toolMaterialBPSteel)).setUnlocalizedName("item_BronzePlatedSteelPickaxe");
		BPSteelShovel = (new MItemShovel(EOConfig.BPSteelShovelId,toolMaterialBPSteel)).setUnlocalizedName("item_BronzePlatedSteelShovel");
		BPSteelAxe = (new MItemAxe(EOConfig.BPSteelAxeId,toolMaterialBPSteel)).setUnlocalizedName("item_BronzePlatedSteelAxe");
		BPSteelHoe = (new MItemHoe(EOConfig.BPSteelHoeId,toolMaterialBPSteel)).setUnlocalizedName("item_BronzePlatedSteelHoe");
		BPSteelSword = (new MItemSword(EOConfig.BPSteelSwordId,toolMaterialBPSteel, false)).setUnlocalizedName("item_BronzePlatedSteelSword");
		
		BPSteelHelmet = (new MItemArmor(EOConfig.BPSteelHelmetId, MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 0, "steel_plated_1", "steel_plated_2")).setUnlocalizedName("item_BronzePlatedSteelHelmet");
		BPSteelChest = (new MItemArmor(EOConfig.BPSteelChestId,MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 1, "steel_plated_1", "steel_plated_2")).setUnlocalizedName("item_BronzePlatedSteelChestplate");
		BPSteelPants = (new MItemArmor(EOConfig.BPSteelPantsId,MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 2, "steel_plated_1", "steel_plated_2")).setUnlocalizedName("item_BronzePlatedSteelLeggings");
		BPSteelBoots = (new MItemArmor(EOConfig.BPSteelBootsId,MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 3, "steel_plated_1", "steel_plated_2")).setUnlocalizedName("item_BronzePlatedSteelBoots");
		
		BPSandstonePickaxe = (new MItemPickaxe(EOConfig.BPSandstonePickaxeId, toolMaterialBPSandstone)).setUnlocalizedName("item_BronzePlatedSandstonePickaxe");
		BPSandstoneShovel = (new MItemShovel(EOConfig.BPSandstoneShovelId,toolMaterialBPSandstone)).setUnlocalizedName("item_BronzePlatedSandstoneShovel");
		BPSandstoneAxe = (new MItemAxe(EOConfig.BPSandstoneAxeId, toolMaterialBPSandstone)).setUnlocalizedName("item_BronzePlatedSandstoneAxe");
		BPSandstoneHoe = (new MItemHoe(EOConfig.BPSandstoneHoeId,toolMaterialBPSandstone)).setUnlocalizedName("item_BronzePlatedSandstoneHoe");
		BPSandstoneSword = (new MItemSword(EOConfig.BPSandstoneSwordId,toolMaterialBPSandstone, false)).setUnlocalizedName("item_BronzePlatedSandstoneSword");
		
		BPBedrockPickaxe = (new MItemPickaxe(EOConfig.BPBedrockPickaxeId, toolMaterialBPBedrock)).setUnlocalizedName("item_BronzePlatedBedrockPickaxe");
		BPBedrockShovel = (new MItemShovel(EOConfig.BPBedrockShovelId,toolMaterialBPBedrock)).setUnlocalizedName("item_BronzePlatedBedrockShovel");
		BPBedrockAxe = (new MItemAxe(EOConfig.BPBedrockAxeId,toolMaterialBPBedrock)).setUnlocalizedName("item_BronzePlatedBedrockAxe");
		BPBedrockHoe = (new MItemHoe(EOConfig.BPBedrockHoeId,toolMaterialBPBedrock)).setUnlocalizedName("item_BronzePlatedBedrockHoe");
		
		BPGranitePickaxe = (new MItemPickaxe(EOConfig.BPGranitePickaxeId,toolMaterialBPGranite)).setUnlocalizedName("item_BronzePlatedGranitePickaxe");
		BPGraniteShovel = (new MItemShovel(EOConfig.BPGraniteShovelId,toolMaterialBPGranite)).setUnlocalizedName( "item_BronzePlatedGraniteShovel");
		BPGraniteAxe = (new MItemAxe(EOConfig.BPGraniteAxeId,toolMaterialBPGranite)).setUnlocalizedName("item_BronzePlatedGraniteAxe");
		BPGraniteHoe = (new MItemHoe(EOConfig.BPGraniteHoeId,toolMaterialBPGranite)).setUnlocalizedName("item_BronzePlatedGraniteHoe");
		BPGraniteSword = (new MItemSword(EOConfig.BPGraniteSwordId,toolMaterialBPGranite, false)).setUnlocalizedName("item_BronzePlatedGraniteSword");
		
		BPWoodPickaxe = (new MItemPickaxe(EOConfig.BPWoodPickaxeId,toolMaterialBPWood)).setUnlocalizedName("item_BronzePlatedWoodPickaxe");
		BPWoodShovel = (new MItemShovel(EOConfig.BPWoodShovelId,toolMaterialBPWood)).setUnlocalizedName("item_BronzePlatedWoodShovel");
		BPWoodAxe = (new MItemAxe(EOConfig.BPWoodAxeId,toolMaterialBPWood)).setUnlocalizedName("item_BronzePlatedWoodAxe");
		BPWoodHoe = (new MItemHoe(EOConfig.BPWoodHoeId,toolMaterialBPWood)).setUnlocalizedName("item_BronzePlatedWoodHoe");
		BPWoodSword = (new MItemSword(EOConfig.BPWoodSwordId,toolMaterialBPWood, false)).setUnlocalizedName("item_BronzePlatedWoodSword");
		
		BPClothHelmet = (new MItemArmor(EOConfig.BPClothHelmetId, MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 0,"cloth_plated_1", "cloth_plated_2")).setUnlocalizedName("item_BronzePlatedLeatherHelmet");
		BPClothChest = (new MItemArmor(EOConfig.BPClothChestId,MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 1,"cloth_plated_1", "cloth_plated_2")).setUnlocalizedName("item_BronzePlatedLeatherChestplate");
		BPClothPants = (new MItemArmor(EOConfig.BPClothPantsId,MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 2,"cloth_plated_1", "cloth_plated_2")).setUnlocalizedName("item_BronzePlatedLeatherLeggings");
		BPClothBoots = (new MItemArmor(EOConfig.BPClothBootsId,MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 3,"cloth_plated_1", "cloth_plated_2")).setUnlocalizedName("item_BronzePlatedLeatherBoots");
		
		BPStonePickaxe = (new MItemPickaxe(EOConfig.BPStonePickaxeId,toolMaterialBPStone)).setUnlocalizedName("item_BronzePlatedStonePickaxe");
		BPStoneShovel = (new MItemShovel(EOConfig.BPStoneShovelId,toolMaterialBPStone)).setUnlocalizedName("item_BronzePlatedStoneShovel");
		BPStoneAxe = (new MItemAxe(EOConfig.BPStoneAxeId,toolMaterialBPStone)).setUnlocalizedName( "item_BronzePlatedStoneAxe");
		BPStoneHoe = (new MItemHoe(EOConfig.BPStoneHoeId,toolMaterialBPStone)).setUnlocalizedName("item_BronzePlatedStoneHoe");
		BPStoneSword = (new MItemSword(EOConfig.BPStoneSwordId,toolMaterialBPStone, false)).setUnlocalizedName("item_BronzePlatedStoneSword");
		
		BPChainHelmet = (new MItemArmor(EOConfig.BPChainHelmetId, MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 0, "chain_plated_1", "chain_plated_2")).setUnlocalizedName("item_BronzePlatedChainHelmet");
		BPChainChest = (new MItemArmor(EOConfig.BPChainChestId,MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 1, "chain_plated_1", "chain_plated_2")).setUnlocalizedName("item_BronzePlatedChainChestplate");
		BPChainPants = (new MItemArmor(EOConfig.BPChainPantsId,MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 2, "chain_plated_1", "chain_plated_2")).setUnlocalizedName("item_BronzePlatedChainLeggings");
		BPChainBoots = (new MItemArmor(EOConfig.BPChainBootsId,MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 3, "chain_plated_1", "chain_plated_2")).setUnlocalizedName("item_BronzePlatedChainBoots");
		Uranium = (new EOItem(EOConfig.uraniumId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_Uranium");

		ToriteIngot = (new EOItem(EOConfig.toriteIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteIngot");
		PinkQuartz = (new EOItem(EOConfig.pinkQuartzId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_PinkQuartz");
		CopperIngot = (new EOItem(EOConfig.copperBlockId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperIngot");
		TinIngot = (new EOItem(EOConfig.tinIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinIngot");
		Plutonium = (new EOItem(EOConfig.plutoniumOreId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_Plutonium");
		TinHelmet = (new MItemArmor(EOConfig.tinHelmetId, MaterialTin, ExtraOres.proxy.addArmor("tin"), 0, "tin_1", "tin_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinHelmet");
		TinChest = (new MItemArmor(EOConfig.tinChestId,MaterialTin, ExtraOres.proxy.addArmor("tin"), 1, "tin_1", "tin_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinChestplate");
		TinPants = (new MItemArmor(EOConfig.tinPantsId,MaterialTin, ExtraOres.proxy.addArmor("tin"),2, "tin_1", "tin_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinLeggings");
		TinBoots = (new MItemArmor(EOConfig.tinBootsId,MaterialTin, ExtraOres.proxy.addArmor("tin"),3, "tin_1", "tin_2")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinBoots");
		BedrockPickaxe = (new MItemPickaxe(EOConfig.bedrockPickaxeId, toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockPickaxe");
		BedrockShovel = (new MItemShovel(EOConfig.bedrockShovelId,toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName( "item_BedrockShovel");
		BedrockAxe = (new MItemAxe(EOConfig.bedrockAxeId,toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockAxe");
		BedrockHoe = (new MItemHoe(EOConfig.bedrockHoeId,toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockHoe");
		
		GranitePickaxe = (new MItemPickaxe(EOConfig.granitePickaxeId,toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GranitePickaxe");
		GraniteShovel = (new MItemShovel(EOConfig.graniteShovelId,toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteShovel");
		GraniteAxe = (new MItemAxe(EOConfig.graniteAxeId,toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteAxe");
		GraniteHoe = (new MItemHoe(EOConfig.graniteHoeId,toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteHoe");
		GraniteSword = (new MItemSword(EOConfig.graniteSwordId,toolMaterialGranite, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteSword");
		SunstoneDust = (new EOItem(EOConfig.sunstoneDustId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SunstoneShard");
	
		BPIronPickaxe = (new MItemPickaxe(EOConfig.BPIronPickaxeId,toolMaterialBPIron)).setUnlocalizedName("item_BronzePlatedIronPickaxe");
		BPIronShovel = (new MItemShovel(EOConfig.BPIronShovelId,toolMaterialBPIron)).setUnlocalizedName("item_BronzePlatedIronShovel");
		BPIronAxe = (new MItemAxe(EOConfig.BPIronAxeId,toolMaterialBPIron)).setUnlocalizedName("item_BronzePlatedIronAxe");
		BPIronHoe = (new MItemHoe(EOConfig.BPIronHoeId,toolMaterialBPIron)).setUnlocalizedName("item_BronzePlatedIronHoe");
		BPIronSword = (new MItemSword(EOConfig.BPIronSwordId,toolMaterialBPIron, false)).setUnlocalizedName("item_BronzePlatedIronSword");
		
		BPIronHelmet = (new MItemArmor(EOConfig.BPIronHelmetId, MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 0, "iron_plated_1", "iron_plated_2")).setUnlocalizedName("item_BronzePlatedIronHelmet");
		BPIronChest = (new MItemArmor(EOConfig.BPIronChestId,MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 1, "iron_plated_1", "iron_plated_2")).setUnlocalizedName("item_BronzePlatedIronChestplate");
		BPIronPants = (new MItemArmor(EOConfig.BPIronPantsId,MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 2, "iron_plated_1", "iron_plated_2")).setUnlocalizedName("item_BronzePlatedIronLeggings");
		BPIronBoots = (new MItemArmor(EOConfig.BPIronBootsId,MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 3, "iron_plated_1", "iron_plated_2")).setUnlocalizedName("item_BronzePlatedIronBoots");
		
		BPGoldPickaxe = (new MItemPickaxe(EOConfig.BPGoldPickaxeId,toolMaterialBPGold)).setUnlocalizedName("item_BronzePlatedGoldPickaxe");
		BPGoldShovel = (new MItemShovel(EOConfig.BPGoldShovelId,toolMaterialBPGold)).setUnlocalizedName("item_BronzePlatedGoldShovel");
		BPGoldAxe = (new MItemAxe(EOConfig.BPGoldAxeId,toolMaterialBPGold)).setUnlocalizedName("item_BronzePlatedGoldAxe");
		BPGoldHoe = (new MItemHoe(EOConfig.BPGoldHoeId,toolMaterialBPGold)).setUnlocalizedName("item_BronzePlatedGoldHoe");
		BPGoldSword = (new MItemSword(EOConfig.BPGoldSwordId,toolMaterialBPGold, false)).setUnlocalizedName("item_BronzePlatedGoldSword");
		
		BPGoldHelmet = (new MItemArmor(EOConfig.BPGoldHelmetId, MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 0, "gold_plated_1", "gold_plated_2")).setUnlocalizedName("item_BronzePlatedGoldHelmet");
		BPGoldChest = (new MItemArmor(EOConfig.BPGoldChestId,MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 1, "gold_plated_1", "gold_plated_2")).setUnlocalizedName("item_BronzePlatedGoldChestplate");
		BPGoldPants = (new MItemArmor(EOConfig.BPGoldPantsId,MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 2, "gold_plated_1", "gold_plated_2")).setUnlocalizedName("item_BronzePlatedGoldLeggings");
		BPGoldBoots = (new MItemArmor(EOConfig.BPGoldBootsId,MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 3, "gold_plated_1", "gold_plated_2")).setUnlocalizedName("item_BronzePlatedGoldBoots");
		
		BPDiamondPickaxe = (new MItemPickaxe(EOConfig.BPDiamondPickaxeId,toolMaterialBPEmerald)).setUnlocalizedName("item_BronzePlatedDiamondPickaxe");
		BPDiamondShovel = (new MItemShovel(EOConfig.BPDiamondShovelId,toolMaterialBPEmerald)).setUnlocalizedName("item_BronzePlatedDiamondShovel");
		BPDiamondAxe = (new MItemAxe(EOConfig.BPDiamondAxeId,toolMaterialBPEmerald)).setUnlocalizedName("item_BronzePlatedDiamondAxe");
		BPDiamondHoe = (new MItemHoe(EOConfig.BPDiamondHoeId,toolMaterialBPEmerald)).setUnlocalizedName("item_BronzePlatedDiamondHoe");
		BPDiamondSword = (new MItemSword(EOConfig.BPDiamondSwordId,toolMaterialBPEmerald, false)).setUnlocalizedName("item_BronzePlatedDiamondSword");
		
		BPDiamondHelmet = (new MItemArmor(EOConfig.BPDiamondHelmetId, MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 0, "diamond_plated_1", "diamond_plated_2")).setUnlocalizedName("item_BronzePlatedDiamondHelmet");
		BPDiamondChest = (new MItemArmor(EOConfig.BPDiamondChestId,MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 1, "diamond_plated_1", "diamond_plated_2")).setUnlocalizedName("item_BronzePlatedDiamondChestplate");
		BPDiamondPants = (new MItemArmor(EOConfig.BPDiamondPantsId,MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 2, "diamond_plated_1", "diamond_plated_2")).setUnlocalizedName("item_BronzePlatedDiamondLeggings");
		BPDiamondBoots = (new MItemArmor(EOConfig.BPDiamondBootsId,MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 3, "diamond_plated_1", "diamond_plated_2")).setUnlocalizedName("item_BronzePlatedDiamondBoots");		
	}
	
	public void addItemsToChests()
	{
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.CopperIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzeIngot),1,3,25));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.CoalIronIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.SteelIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.CopperIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.meuroditeIngot),1,4,15));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.TitaniumIngot),1,2,2));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.Uranium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.Plutonium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzePickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.SteelPickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.CopperIngot),1,5,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.meuroditeIngot),1,4,15));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.TitaniumIngot),1,2,2));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.Uranium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.Plutonium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzePickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.SteelPickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.CoalIronIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzeIngot),1,3,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.BlaziumIngot),1,2,7));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.SteelSword),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzeSword),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.CopperIngot),1,5,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.meuroditeIngot),1,4,15));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.TitaniumIngot),1,2,2));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.Uranium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.Plutonium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzePickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.SteelPickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.CoalIronIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzeIngot),1,3,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.BlaziumIngot),1,2,7));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.SteelSword),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzeSword),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(EOBlockManager.SoulGem),1,3,12));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.PinkQuartz),1,10,25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(EOBlockManager.RadiantQuartz),1,3,10));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.CopperIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzeIngot),1,3,25));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.CoalIronIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.SteelIngot),1,5,17));
	}
	
	public static void setHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.CopperOre, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.CopperBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.TinOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.TinBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.meuroditeOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.meuroditeBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.ToriteOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.ToriteBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.TitaniumOre, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.TitaniumBlock, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.UraniumOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.PlutoniumOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SunstoneOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.Granite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.GraniteBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.Quartzite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.QuartziteTile, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SmoothQuartzite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.PillarQuartzite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.ChiseledQuartzite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SmoothQuartzTile, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BlaziumOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BlaziumBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SoulOre, "shovel", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.TinPlatedCobble, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.TinPlatedMossy, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.TinPlatedStoneBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.TinPlatedChiseled, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.TinPlatedGranite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzeBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedCobble, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedMossy, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedStoneBrick, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedChiseled, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedGranite, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SteelPlatedCobble, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SteelPlatedMossy, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SteelPlatedStoneBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SteelPlatedChiseled, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SteelPlatedGranite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.RawUraniumBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.RawPlutoniumBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.SmoothRadiantQuartz, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.PillarRadiantQuartz, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.ChiseledRadiantQuartz, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.RadiantQuartzOre, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.Godstone, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(Block.bedrock, "pickaxe", 4);
	}
}
