package sobiohazardous.minestrappolation.extraores.lib;

import sobiohazardous.minestrappolation.api.item.MItemArmor;
import sobiohazardous.minestrappolation.api.item.MItemAxe;
import sobiohazardous.minestrappolation.api.item.MItemBlockPlacer;
import sobiohazardous.minestrappolation.api.item.MItemHoe;
import sobiohazardous.minestrappolation.api.item.MItemPickaxe;
import sobiohazardous.minestrappolation.api.item.MItemShovel;
import sobiohazardous.minestrappolation.api.item.MItemSword;
import sobiohazardous.minestrappolation.extraores.CreativeTabExtraoresItems;
import sobiohazardous.minestrappolation.extraores.EOConfig;
import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.item.EOItem;
import sobiohazardous.minestrappolation.extraores.item.ItemGrenade;
import sobiohazardous.minestrappolation.extraores.item.ItemGrenadeImpact;
import sobiohazardous.minestrappolation.extraores.item.ItemGrenadeSticky;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

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
	public static EnumToolMaterial toolMaterialBedrock = EnumHelper.addToolMaterial("ToolBedrock", 4, 6247, 7F, 2, 5);
	public static EnumToolMaterial toolMaterialGranite = EnumHelper.addToolMaterial("ToolGranite", 1, 199, 4.3F, 2, 4);
	public static EnumToolMaterial toolMaterialBPMeurodite = EnumHelper.addToolMaterial("ToolBPMeurodite", 2, 1610, 7.0F, 2, 15);
	public static EnumToolMaterial toolMaterialBPTitanium = EnumHelper.addToolMaterial("ToolBPTitanium", 4, 5998, 10.0F, 5, 11);
	public static EnumToolMaterial toolMaterialBPTorite = EnumHelper.addToolMaterial("ToolBPTorite", 2, 1398, 6.0F, 3, 20);
	public static EnumToolMaterial toolMaterialBPBlazium = EnumHelper.addToolMaterial("ToolBPBlazium", 2, 1598, 8.0F, 3, 18);
	public static EnumToolMaterial toolMaterialBPCopper = EnumHelper.addToolMaterial("ToolBPCopper", 1, 278, 5.0F, 2, 10);
	public static EnumToolMaterial toolMaterialBPSandstone = EnumHelper.addToolMaterial("ToolBPSandstone", 1, 222, 4.5F, 2, 6);
	public static EnumToolMaterial toolMaterialBPSteel = EnumHelper.addToolMaterial("ToolBPSteel", 2, 600, 7.5F, 3, 15);
	public static EnumToolMaterial toolMaterialBPBedrock = EnumHelper.addToolMaterial("ToolBPBedrock", 4, 12494, 7F, 2, 5);
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
	
	public static void addItems()
	{
		meuroditeIngot = (new EOItem(EOConfig.meuroditeIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeIngot");
		meuroditeSword = (new MItemSword(EOConfig.meuroditeSwordId, toolMaterialMeurodite, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeSword");
		meuroditePickaxe = (new MItemPickaxe(EOConfig.meuroditePickaxeId, toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditePickaxe");
		meuroditeShovel = (new MItemShovel(EOConfig.meuroditeShovelId, toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeShovel");
		meuroditeHoe = (new MItemHoe(EOConfig.meuroditeHoeId, toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHoe");
		meuroditeAxe = (new MItemAxe(EOConfig.meuroditeAxeId, toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeAxe");

		TinPlateItem = (new MItemBlockPlacer(EOConfig.tinPlateItemId, EOBlockManager.TinPlate)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinPlate");
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
		BlaziumPickaxe = (new MItemPickaxe(EOConfig.blaziumPickaxeId, toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FirePickaxe");
		BlaziumShovel = (new MItemShovel(EOConfig.blaziumShovelId,toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireShovel");
		BlaziumHoe = (new MItemHoe(EOConfig.blaziumHoeId,toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHoe");
		BlaziumAxe = (new MItemAxe(EOConfig.blaziumAxeId,toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireAxe");
		
		BlaziumHelmet = (new MItemArmor(EOConfig.blaziumHelmetId, MaterialBlazium, ExtraOres.proxy.addArmor("fire"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHelmet");
		BlaziumChest = (new MItemArmor(EOConfig.blaziumChestId,MaterialBlazium, ExtraOres.proxy.addArmor("fire"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireChestplate");
		BlaziumPants = (new MItemArmor(EOConfig.blaziumPantsId,MaterialBlazium, ExtraOres.proxy.addArmor("fire"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireLeggings");
		BlaziumBoots = (new MItemArmor(EOConfig.blaziumBootsId,MaterialBlazium, ExtraOres.proxy.addArmor("fire"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireBoots");
	
		CoalIronIngot = (new EOItem(EOConfig.coalIronIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CoalIronIngot");
		SteelIngot = (new EOItem(EOConfig.steelIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelIngot");
		
		SteelPickaxe = (new MItemPickaxe(EOConfig.steelPickaxeId,toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelPickaxe");
		SteelShovel = (new MItemShovel(EOConfig.steelShovelId,toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelShovel");
		ToriteSword = (new MItemSword(EOConfig.toriteSwordId, toolMaterialTorite, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteSword");
		ToritePickaxe = (new MItemPickaxe(EOConfig.toritePickaxeId, toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToritePickaxe");
		ToriteShovel = (new MItemShovel(EOConfig.toriteShovelId, toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteShovel");
		ToriteHoe = (new MItemHoe(EOConfig.toriteHoeId,toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHoe");
		ToriteAxe = (new MItemAxe(EOConfig.toriteAxeId,toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteAxe");
		TitaniumIngot = (new EOItem(EOConfig.titaniumIngotId)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumIngot");
		
		TitaniumSword = (new MItemSword(EOConfig.titaniumSwordId, toolMaterialTitanium, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumSword");
		TitaniumPickaxe = (new MItemPickaxe(EOConfig.titaniumPickaxeId, toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumPickaxe");
		TitaniumShovel = (new MItemShovel(EOConfig.titaniumShovelId, toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumShovel");
		TitaniumHoe = (new MItemHoe(EOConfig.titaniumHoeId,toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHoe");
		TitaniumAxe = (new MItemAxe(EOConfig.titaniumAxeId,toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumAxe");
		meuroditeHelmet = (new MItemArmor(EOConfig.meuroditeHelmetId, MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHelmet");
		meuroditeChest = (new MItemArmor(EOConfig.meuroditeChestId, MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeChestplate");
		meuroditePants = (new MItemArmor(EOConfig.meuroditePantsId,MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeLeggings");
		meuroditeBoots = (new MItemArmor(EOConfig.meuroditeBootsId, MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeBoots");
			
		TitaniumHelmet = (new MItemArmor(EOConfig.titaniumHelmetId, MaterialTitanium, ExtraOres.proxy.addArmor("titanium"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHelmet");
		TitaniumChest = (new MItemArmor(EOConfig.titaniumChestId,MaterialTitanium, ExtraOres.proxy.addArmor("titanium"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumChestplate");
		TitaniumPants = (new MItemArmor(EOConfig.titaniumPantsId, MaterialTitanium, ExtraOres.proxy.addArmor("titanium"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumLeggings");
		TitaniumBoots = (new MItemArmor(EOConfig.titaniumBootsId,MaterialTitanium, ExtraOres.proxy.addArmor("titanium"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumBoots");
		
		ToriteHelmet = (new MItemArmor(EOConfig.toriteHelmetId,MaterialTorite, ExtraOres.proxy.addArmor("torite"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHelmet");
		ToriteChest = (new MItemArmor(EOConfig.toriteChestId,MaterialTorite, ExtraOres.proxy.addArmor("torite"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteChestplate");
		ToritePants = (new MItemArmor(EOConfig.toritePantsId,MaterialTorite, ExtraOres.proxy.addArmor("torite"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteLeggings");
		ToriteBoots = (new MItemArmor(EOConfig.toriteBootsId,MaterialTorite, ExtraOres.proxy.addArmor("torite"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteBoots");
		SandstonePickaxe = (new MItemPickaxe(EOConfig.sandstonePickaxeId, toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstonePickaxe");
		SandstoneShovel = (new MItemShovel(EOConfig.sandstoneShovelId,toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneShovel");
		SandstoneAxe = (new MItemAxe(EOConfig.sandstoneAxeId, toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneAxe");
		SandstoneHoe = (new MItemHoe(EOConfig.sandstoneHoeId,toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneHoe");
		SandstoneSword = (new MItemSword(EOConfig.sandstoneSwordId,toolMaterialSandstone, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneSword");
		SteelAxe = (new MItemAxe(EOConfig.steelAxeId,toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelAxe");
		SteelHoe = (new MItemHoe(EOConfig.steelHoeId,toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelHoe");
		SteelSword = (new MItemSword(EOConfig.steelSwordId,toolMaterialSteel, false)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelSword");
		
		SteelHelmet = (new MItemArmor(EOConfig.steelHelmetId,"item_SteelHelmet", MaterialSteel, ExtraOres.proxy.addArmor("steel"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("SteelHelmet");
		SteelChest = (new MItemArmor(EOConfig.steelChestId, "item_SteelChestplate",MaterialSteel, ExtraOres.proxy.addArmor("steel"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("SteelChest");
		SteelPants = (new MItemArmor(EOConfig.steelPantsId, "item_SteelLeggings",MaterialSteel, ExtraOres.proxy.addArmor("steel"), 2)).setCreativeTab(tabOresItems).setUnlocalizedName("SteelPants");
		SteelBoots = (new MItemArmor(EOConfig.steelBootsId, "item_SteelBoots",MaterialSteel, ExtraOres.proxy.addArmor("steel"), 3)).setCreativeTab(tabOresItems).setUnlocalizedName("SteelBoots");
		
		BronzeIngot = (new EOItem(EOConfig.bronzeIngotId, "item_BronzeIngot")).setCreativeTab(tabOresItems).setUnlocalizedName("BronzeIngot");
		BronzePickaxe = (new MItemPickaxe(EOConfig.bronzePickaxeId, "item_BronzePickaxe",toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("BronzePickaxe");
		BronzeShovel = (new MItemShovel(EOConfig.bronzeShovelId, "item_BronzeShovel",toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("BronzeShovel");
		BronzeAxe = (new MItemAxe(EOConfig.bronzeAxeId, "item_BronzeAxe",toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("BronzeAxe");
		BronzeHoe = (new MItemHoe(EOConfig.bronzeHoeId,"item_BronzeHoe", toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("BronzeHoe");
		BronzeSword = (new MItemSword(EOConfig.bronzeSwordId,"item_BronzeSword", toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("BronzeSword");
		BronzeHelmet = (new MItemArmor(EOConfig.bronzeHelmetId,"item_BronzeHelmet", MaterialBronze, ExtraOres.proxy.addArmor("bronze"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("BronzeHelmet");
		BronzeChest = (new MItemArmor(EOConfig.bronzeChestId, "item_BronzeChestplate",MaterialBronze, ExtraOres.proxy.addArmor("bronze"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("BronzeChest");
		BronzePants = (new MItemArmor(EOConfig.bronzePantsId, "item_BronzeLeggings",MaterialBronze, ExtraOres.proxy.addArmor("bronze"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("BronzePants");
		BronzeBoots = (new MItemArmor(EOConfig.bronzeBootsId, "item_BronzeBoots",MaterialBronze, ExtraOres.proxy.addArmor("bronze"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("BronzeBoots");
		
		grenade = (new ItemGrenade(EOConfig.grenadeId)).setUnlocalizedName("grenade");
		grenadeImpact = (new ItemGrenadeImpact(EOConfig.grenadeImpactId)).setUnlocalizedName("grenadeImpact");
		grenadeSticky = (new ItemGrenadeSticky(EOConfig.grenadeStickyId)).setUnlocalizedName("grenadeSticky");		
		
		BPMeuroditeSword = (new MItemSword(EOConfig.BPmeuroditeSwordId, "item_BronzePlatedMeuroditeSword", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditeSword");
		BPMeuroditePickaxe = (new MItemPickaxe(EOConfig.BPmeuroditePickaxeId, "item_BronzePlatedMeuroditePickaxe", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditePickaxe");
		BPMeuroditeShovel = (new MItemShovel(EOConfig.BPmeuroditeShovelId, "item_BronzePlatedMeuroditeShovel", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditeShovel");
		BPMeuroditeHoe = (new MItemHoe(EOConfig.BPmeuroditeHoeId, "item_BronzePlatedMeuroditeHoe", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditeHoe");
		BPMeuroditeAxe = (new MItemAxe(EOConfig.BPmeuroditeAxeId, "item_BronzePlatedMeuroditeAxe", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditeAxe");
	
		BPMeuroditeHelmet = (new MItemArmor(EOConfig.BPmeuroditeHelmetId, "item_BronzePlatedMeuroditeHelmet", MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"), 0)).setUnlocalizedName("BPMeuroditeHelmet");
		BPMeuroditeChest = (new MItemArmor(EOConfig.BPmeuroditeChestId, "item_BronzePlatedMeuroditeChestplate", MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"), 1)).setUnlocalizedName("BPMeuroditeChest");
		BPMeuroditePants = (new MItemArmor(EOConfig.BPmeuroditePantsId, "item_BronzePlatedMeuroditeLeggings",MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"),2)).setUnlocalizedName("BPMeuroditePants");
		BPMeuroditeBoots = (new MItemArmor(EOConfig.BPmeuroditeBootsId, "item_BronzePlatedMeuroditeBoots", MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"),3)).setUnlocalizedName("BPMeuroditeBoots");
		
		BPTitaniumSword = (new MItemSword(EOConfig.BPTitaniumSwordId,"item_BronzePlatedTitaniumSword", toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumSword");
		BPTitaniumPickaxe = (new MItemPickaxe(EOConfig.BPTitaniumPickaxeId, "item_BronzePlatedTitaniumPickaxe", toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumPickaxe");
		BPTitaniumShovel = (new MItemShovel(EOConfig.BPTitaniumShovelId, "item_BronzePlatedTitaniumShovel", toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumShovel");
		BPTitaniumHoe = (new MItemHoe(EOConfig.BPTitaniumHoeId, "item_BronzePlatedTitaniumHoe",toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumHoe");
		BPTitaniumAxe = (new MItemAxe(EOConfig.BPTitaniumAxeId, "item_BronzePlatedTitaniumAxe",toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumAxe");
	
		BPTitaniumHelmet = (new MItemArmor(EOConfig.BPTitaniumHelmetId, "item_BronzePlatedTitaniumHelmet", MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"), 0)).setUnlocalizedName("BPTitaniumHelmet");
		BPTitaniumChest = (new MItemArmor(EOConfig.BPTitaniumChestId, "item_BronzePlatedTitaniumChestplate",MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"), 1)).setUnlocalizedName("BPTitaniumChest");
		BPTitaniumPants = (new MItemArmor(EOConfig.BPTitaniumPantsId, "item_BronzePlatedTitaniumLeggings", MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"),2)).setUnlocalizedName("BPTitaniumPants");
		BPTitaniumBoots = (new MItemArmor(EOConfig.BPTitaniumBootsId, "item_BronzePlatedTitaniumBoots",MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"),3)).setUnlocalizedName("BPTitaniumBoots");
		
		BPToriteSword = (new MItemSword(EOConfig.BPToriteSwordId, "item_BronzePlatedToriteSword", toolMaterialBPTorite)).setUnlocalizedName("BPToriteSword");
		BPToritePickaxe = (new MItemPickaxe(EOConfig.BPToritePickaxeId, "item_BronzePlatedToritePickaxe", toolMaterialBPTorite)).setUnlocalizedName("BPToritePickaxe");
		BPToriteShovel = (new MItemShovel(EOConfig.BPToriteShovelId, "item_BronzePlatedToriteShovel", toolMaterialBPTorite)).setUnlocalizedName("BPToriteShovel");
		BPToriteHoe = (new MItemHoe(EOConfig.BPToriteHoeId, "item_BronzePlatedToriteHoe",toolMaterialBPTorite)).setUnlocalizedName("BPToriteHoe");
		BPToriteAxe = (new MItemAxe(EOConfig.BPToriteAxeId, "item_BronzePlatedToriteAxe",toolMaterialBPTorite)).setUnlocalizedName("BPToriteAxe");
		
		BPToriteHelmet = (new MItemArmor(EOConfig.BPToriteHelmetId, "item_BronzePlatedToriteHelmet",MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"), 0)).setUnlocalizedName("BPToriteHelmet");
		BPToriteChest = (new MItemArmor(EOConfig.BPToriteChestId, "item_BronzePlatedToriteChestplate",MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"), 1)).setUnlocalizedName("BPToriteChest");
		BPToritePants = (new MItemArmor(EOConfig.BPToritePantsId, "item_BronzePlatedToriteLeggings",MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"),2)).setUnlocalizedName("BPToritePants");
		BPToriteBoots = (new MItemArmor(EOConfig.BPToriteBootsId, "item_BronzePlatedToriteBoots",MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"),3)).setUnlocalizedName("BPToriteBoots");
		
		BPBlaziumSword = (new MItemSword(EOConfig.BPBlaziumSwordId, "item_BronzePlatedFireSword", toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumSword");
		BPBlaziumPickaxe = (new MItemPickaxe(EOConfig.BPBlaziumPickaxeId, "item_BronzePlatedFirePickaxe", toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumPickaxe");
		BPBlaziumShovel = (new MItemShovel(EOConfig.BPBlaziumShovelId, "item_BronzePlatedFireShovel",toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumShovel");
		BPBlaziumHoe = (new MItemHoe(EOConfig.BPBlaziumHoeId, "item_BronzePlatedFireHoe",toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumHoe");
		BPBlaziumAxe = (new MItemAxe(EOConfig.BPBlaziumAxeId, "item_BronzePlatedFireAxe",toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumAxe");
		
		BPBlaziumHelmet = (new MItemArmor(EOConfig.BPBlaziumHelmetId,"item_BronzePlatedFireHelmet", MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"), 0)).setUnlocalizedName("BPBlaziumHelmet");
		BPBlaziumChest = (new MItemArmor(EOConfig.BPBlaziumChestId, "item_BronzePlatedFireChestplate",MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"), 1)).setUnlocalizedName("BPBlaziumChest");
		BPBlaziumPants = (new MItemArmor(EOConfig.BPBlaziumPantsId, "item_BronzePlatedFireLeggings",MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"),2)).setUnlocalizedName("BPBlaziumPants");
		BPBlaziumBoots = (new MItemArmor(EOConfig.BPBlaziumBootsId, "item_BronzePlatedFireBoots",MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"),3)).setUnlocalizedName("BPBlaziumBoots");
		
		BPCopperSword = (new MItemSword(EOConfig.BPCopperSwordId, "item_BronzePlatedCopperSword",toolMaterialBPCopper)).setUnlocalizedName("BPCopperSword");
		BPCopperPickaxe = (new MItemPickaxe(EOConfig.BPCopperPickaxeId, "item_BronzePlatedCopperPickaxe",toolMaterialBPCopper)).setUnlocalizedName("BPCopperPickaxe");
		BPCopperShovel = (new MItemShovel(EOConfig.BPCopperShovelId, "item_BronzePlatedCopperShovel",toolMaterialBPCopper)).setUnlocalizedName("BPCopperShovel");
		BPCopperHoe = (new MItemHoe(EOConfig.BPCopperHoeId, "item_BronzePlatedCopperHoe",toolMaterialBPCopper)).setUnlocalizedName("BPCopperHoe");
		BPCopperAxe = (new MItemAxe(EOConfig.BPCopperAxeId, "item_BronzePlatedCopperAxe",toolMaterialBPCopper)).setUnlocalizedName("BPCopperAxe");
		
		BPTinHelmet = (new MItemArmor(EOConfig.BPTinHelmetId,"item_BronzePlatedTinHelmet", MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"), 0)).setUnlocalizedName("BPTinHelmet");
		BPTinChest = (new MItemArmor(EOConfig.BPTinChestId, "item_BronzePlatedTinChestplate",MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"), 1)).setUnlocalizedName("BPTinChest");
		BPTinPants = (new MItemArmor(EOConfig.BPTinPantsId, "item_BronzePlatedTinLeggings",MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"),2)).setUnlocalizedName("BPTinPants");
		BPTinBoots = (new MItemArmor(EOConfig.BPTinBootsId, "item_BronzePlatedTinBoots",MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"),3)).setUnlocalizedName("BPTinBoots");
		
		BPSteelPickaxe = (new MItemPickaxe(EOConfig.BPSteelPickaxeId, "item_BronzePlatedSteelPickaxe",toolMaterialBPSteel)).setUnlocalizedName("BPSteelPickaxe");
		BPSteelShovel = (new MItemShovel(EOConfig.BPSteelShovelId, "item_BronzePlatedSteelShovel",toolMaterialBPSteel)).setUnlocalizedName("BPSteelShovel");
		BPSteelAxe = (new MItemAxe(EOConfig.BPSteelAxeId, "item_BronzePlatedSteelAxe",toolMaterialBPSteel)).setUnlocalizedName("BPSteelAxe");
		BPSteelHoe = (new MItemHoe(EOConfig.BPSteelHoeId, "item_BronzePlatedSteelHoe",toolMaterialBPSteel)).setUnlocalizedName("BPSteelHoe");
		BPSteelSword = (new MItemSword(EOConfig.BPSteelSwordId, "item_BronzePlatedSteelSword",toolMaterialBPSteel)).setUnlocalizedName("BPSteelSword");
		
		BPSteelHelmet = (new MItemArmor(EOConfig.BPSteelHelmetId,"item_BronzePlatedSteelHelmet", MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 0)).setUnlocalizedName("BPSteelHelmet");
		BPSteelChest = (new MItemArmor(EOConfig.BPSteelChestId, "item_BronzePlatedSteelChestplate",MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 1)).setUnlocalizedName("BPSteelChest");
		BPSteelPants = (new MItemArmor(EOConfig.BPSteelPantsId, "item_BronzePlatedSteelLeggings",MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 2)).setUnlocalizedName("BPSteelPants");
		BPSteelBoots = (new MItemArmor(EOConfig.BPSteelBootsId, "item_BronzePlatedSteelBoots",MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 3)).setUnlocalizedName("BPSteelBoots");
		
		BPSandstonePickaxe = (new MItemPickaxe(EOConfig.BPSandstonePickaxeId,"item_BronzePlatedSandstonePickaxe", toolMaterialBPSandstone)).setUnlocalizedName("BPSandstonePickaxe");
		BPSandstoneShovel = (new MItemShovel(EOConfig.BPSandstoneShovelId, "item_BronzePlatedSandstoneShovel",toolMaterialBPSandstone)).setUnlocalizedName("BPSandstoneShovel");
		BPSandstoneAxe = (new MItemAxe(EOConfig.BPSandstoneAxeId, "item_BronzePlatedSandstoneAxe", toolMaterialBPSandstone)).setUnlocalizedName("BPSandstoneAxe");
		BPSandstoneHoe = (new MItemHoe(EOConfig.BPSandstoneHoeId, "item_BronzePlatedSandstoneHoe",toolMaterialBPSandstone)).setUnlocalizedName("BPSandstoneHoe");
		BPSandstoneSword = (new MItemSword(EOConfig.BPSandstoneSwordId, "item_BronzePlatedSandstoneSword",toolMaterialBPSandstone)).setUnlocalizedName("BPSandstoneSword");
		
		BPBedrockPickaxe = (new MItemPickaxe(EOConfig.BPBedrockPickaxeId, "item_BronzePlatedBedrockPickaxe", toolMaterialBPBedrock)).setUnlocalizedName("BPBedrockPickaxe");
		BPBedrockShovel = (new MItemShovel(EOConfig.BPBedrockShovelId, "item_BronzePlatedBedrockShovel",toolMaterialBPBedrock)).setUnlocalizedName("BPBedrockShovel");
		BPBedrockAxe = (new MItemAxe(EOConfig.BPBedrockAxeId, "item_BronzePlatedBedrockAxe",toolMaterialBPBedrock)).setUnlocalizedName("BPBedrockAxe");
		BPBedrockHoe = (new MItemHoe(EOConfig.BPBedrockHoeId, "item_BronzePlatedBedrockHoe",toolMaterialBPBedrock)).setUnlocalizedName("BPBedrockHoe");
		
		BPGranitePickaxe = (new MItemPickaxe(EOConfig.BPGranitePickaxeId, "item_BronzePlatedGranitePickaxe",toolMaterialBPGranite)).setUnlocalizedName("BPGranitePickaxe");
		BPGraniteShovel = (new MItemShovel(EOConfig.BPGraniteShovelId, "item_BronzePlatedGraniteShovel",toolMaterialBPGranite)).setUnlocalizedName("BPGraniteShovel");
		BPGraniteAxe = (new MItemAxe(EOConfig.BPGraniteAxeId, "item_BronzePlatedGraniteAxe",toolMaterialBPGranite)).setUnlocalizedName("BPGraniteAxe");
		BPGraniteHoe = (new MItemHoe(EOConfig.BPGraniteHoeId, "item_BronzePlatedGraniteHoe",toolMaterialBPGranite)).setUnlocalizedName("BPGraniteHoe");
		BPGraniteSword = (new MItemSword(EOConfig.BPGraniteSwordId, "item_BronzePlatedGraniteSword",toolMaterialBPGranite)).setUnlocalizedName("BPGraniteSword");
		
		BPWoodPickaxe = (new MItemPickaxe(EOConfig.BPWoodPickaxeId, "item_BronzePlatedWoodPickaxe",toolMaterialBPWood)).setUnlocalizedName("BPWoodPickaxe");
		BPWoodShovel = (new MItemShovel(EOConfig.BPWoodShovelId, "item_BronzePlatedWoodShovel",toolMaterialBPWood)).setUnlocalizedName("BPWoodShovel");
		BPWoodAxe = (new MItemAxe(EOConfig.BPWoodAxeId, "item_BronzePlatedWoodAxe",toolMaterialBPWood)).setUnlocalizedName("BPWoodAxe");
		BPWoodHoe = (new MItemHoe(EOConfig.BPWoodHoeId, "item_BronzePlatedWoodHoe",toolMaterialBPWood)).setUnlocalizedName("BPWoodHoe");
		BPWoodSword = (new MItemSword(EOConfig.BPWoodSwordId, "item_BronzePlatedWoodSword",toolMaterialBPWood)).setUnlocalizedName("BPWoodSword");
		
		BPClothHelmet = (new MItemArmor(EOConfig.BPClothHelmetId,"item_BronzePlatedLeatherHelmet", MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 0)).setUnlocalizedName("BPClothHelmet");
		BPClothChest = (new MItemArmor(EOConfig.BPClothChestId, "item_BronzePlatedLeatherChestplate",MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 1)).setUnlocalizedName("BPClothChest");
		BPClothPants = (new MItemArmor(EOConfig.BPClothPantsId, "item_BronzePlatedLeatherLeggings",MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 2)).setUnlocalizedName("BPClothPants");
		BPClothBoots = (new MItemArmor(EOConfig.BPClothBootsId, "item_BronzePlatedLeatherBoots",MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 3)).setUnlocalizedName("BPClothBoots");
		
		BPStonePickaxe = (new MItemPickaxe(EOConfig.BPStonePickaxeId, "item_BronzePlatedStonePickaxe",toolMaterialBPStone)).setUnlocalizedName("BPStonePickaxe");
		BPStoneShovel = (new MItemShovel(EOConfig.BPStoneShovelId, "item_BronzePlatedStoneShovel",toolMaterialBPStone)).setUnlocalizedName("BPStoneShovel");
		BPStoneAxe = (new MItemAxe(EOConfig.BPStoneAxeId, "item_BronzePlatedStoneAxe",toolMaterialBPStone)).setUnlocalizedName("BPStoneAxe");
		BPStoneHoe = (new MItemHoe(EOConfig.BPStoneHoeId, "item_BronzePlatedStoneHoe",toolMaterialBPStone)).setUnlocalizedName("BPStoneHoe");
		BPStoneSword = (new MItemSword(EOConfig.BPStoneSwordId, "item_BronzePlatedStoneSword",toolMaterialBPStone)).setUnlocalizedName("BPStoneSword");
		
		BPChainHelmet = (new MItemArmor(EOConfig.BPChainHelmetId,"item_BronzePlatedChainHelmet", MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 0)).setUnlocalizedName("BPChainHelmet");
		BPChainChest = (new MItemArmor(EOConfig.BPChainChestId, "item_BronzePlatedChainChestplate",MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 1)).setUnlocalizedName("BPChainChest");
		BPChainPants = (new MItemArmor(EOConfig.BPChainPantsId, "item_BronzePlatedChainLeggings",MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 2)).setUnlocalizedName("BPChainPants");
		BPChainBoots = (new MItemArmor(EOConfig.BPChainBootsId, "item_BronzePlatedChainBoots",MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 3)).setUnlocalizedName("BPChainBoots");
		Uranium = (new EOItem(EOConfig.uraniumId, "item_Uranium")).setCreativeTab(tabOresItems).setUnlocalizedName("Uranium");

		ToriteIngot = (new EOItem(EOConfig.toriteIngotId, "item_ToriteIngot")).setCreativeTab(tabOresItems).setUnlocalizedName("ToriteIngot");
		PinkQuartz = (new EOItem(EOConfig.pinkQuartzId, "item_PinkQuartz")).setCreativeTab(tabOresItems).setUnlocalizedName("PinkQuartz");
		CopperIngot = (new EOItem(EOConfig.copperBlockId, "item_CopperIngot")).setCreativeTab(tabOresItems).setUnlocalizedName("CopperIngot");
		TinIngot = (new EOItem(EOConfig.tinIngotId, "item_TinIngot")).setCreativeTab(tabOresItems).setUnlocalizedName("TinIngot");
		Plutonium = (new EOItem(EOConfig.plutoniumOreId, "item_Plutonium")).setCreativeTab(tabOresItems).setUnlocalizedName("Plutonium");
		TinHelmet = (new MItemArmor(EOConfig.tinHelmetId,"item_TinHelmet", MaterialTin, ExtraOres.proxy.addArmor("tin"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("TinHelmet");
		TinChest = (new MItemArmor(EOConfig.tinChestId, "item_TinChestplate",MaterialTin, ExtraOres.proxy.addArmor("tin"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("TinChest");
		TinPants = (new MItemArmor(EOConfig.tinPantsId, "item_TinLeggings",MaterialTin, ExtraOres.proxy.addArmor("tin"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("TinPants");
		TinBoots = (new MItemArmor(EOConfig.tinBootsId, "item_TinBoots",MaterialTin, ExtraOres.proxy.addArmor("tin"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("TinBoots");
		BedrockPickaxe = (new MItemPickaxe(EOConfig.bedrockPickaxeId, "item_BedrockPickaxe", toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("BedrockPickaxe");
		BedrockShovel = (new MItemShovel(EOConfig.bedrockShovelId, "item_BedrockShovel",toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("BedrockShovel");
		BedrockAxe = (new MItemAxe(EOConfig.bedrockAxeId, "item_BedrockAxe",toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("BedrockAxe");
		BedrockHoe = (new MItemHoe(EOConfig.bedrockHoeId, "item_BedrockHoe",toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("BedrockHoe");
		
		GranitePickaxe = (new MItemPickaxe(EOConfig.granitePickaxeId, "item_GranitePickaxe",toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("GranitePickaxe");
		GraniteShovel = (new MItemShovel(EOConfig.graniteShovelId, "item_GraniteShovel",toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("GraniteShovel");
		GraniteAxe = (new MItemAxe(EOConfig.graniteAxeId, "item_GraniteAxe",toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("GraniteAxe");
		GraniteHoe = (new MItemHoe(EOConfig.graniteHoeId, "item_GraniteHoe",toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("GraniteHoe");
		GraniteSword = (new MItemSword(EOConfig.graniteSwordId, "item_GraniteSword",toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("GraniteSword");
		SunstoneDust = (new EOItem(EOConfig.sunstoneDustId, "item_SunstoneShard")).setCreativeTab(tabOresItems).setUnlocalizedName("SunstoneDust");
	
		BPIronPickaxe = (new MItemPickaxe(EOConfig.BPIronPickaxeId, "item_BronzePlatedIronPickaxe",toolMaterialBPIron)).setUnlocalizedName("BPIronPickaxe");
		BPIronShovel = (new MItemShovel(EOConfig.BPIronShovelId, "item_BronzePlatedIronShovel",toolMaterialBPIron)).setUnlocalizedName("BPIronShovel");
		BPIronAxe = (new MItemAxe(EOConfig.BPIronAxeId, "item_BronzePlatedIronAxe",toolMaterialBPIron)).setUnlocalizedName("BPIronAxe");
		BPIronHoe = (new MItemHoe(EOConfig.BPIronHoeId, "item_BronzePlatedIronHoe",toolMaterialBPIron)).setUnlocalizedName("BPIronHoe");
		BPIronSword = (new MItemSword(EOConfig.BPIronSwordId, "item_BronzePlatedIronSword",toolMaterialBPIron)).setUnlocalizedName("BPStoneSword");
		
		BPIronHelmet = (new MItemArmor(EOConfig.BPIronHelmetId,"item_BronzePlatedIronHelmet", MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 0)).setUnlocalizedName("BPIronHelmet");
		BPIronChest = (new MItemArmor(EOConfig.BPIronChestId, "item_BronzePlatedIronChestplate",MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 1)).setUnlocalizedName("BPIronChest");
		BPIronPants = (new MItemArmor(EOConfig.BPIronPantsId, "item_BronzePlatedIronLeggings",MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 2)).setUnlocalizedName("BPIronPants");
		BPIronBoots = (new MItemArmor(EOConfig.BPIronBootsId, "item_BronzePlatedIronBoots",MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 3)).setUnlocalizedName("BPIronBoots");
		
		BPGoldPickaxe = (new MItemPickaxe(EOConfig.BPGoldPickaxeId, "item_BronzePlatedGoldPickaxe",toolMaterialBPGold)).setUnlocalizedName("BPGoldPickaxe");
		BPGoldShovel = (new MItemShovel(EOConfig.BPGoldShovelId, "item_BronzePlatedGoldShovel",toolMaterialBPGold)).setUnlocalizedName("BPGoldShovel");
		BPGoldAxe = (new MItemAxe(EOConfig.BPGoldAxeId, "item_BronzePlatedGoldAxe",toolMaterialBPGold)).setUnlocalizedName("BPGoldAxe");
		BPGoldHoe = (new MItemHoe(EOConfig.BPGoldHoeId, "item_BronzePlatedGoldHoe",toolMaterialBPGold)).setUnlocalizedName("BPGoldHoe");
		BPGoldSword = (new MItemSword(EOConfig.BPGoldSwordId, "item_BronzePlatedGoldSword",toolMaterialBPGold)).setUnlocalizedName("BPGoldSword");
		
		BPGoldHelmet = (new MItemArmor(EOConfig.BPGoldHelmetId,"item_BronzePlatedGoldHelmet", MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 0)).setUnlocalizedName("BPGoldHelmet");
		BPGoldChest = (new MItemArmor(EOConfig.BPGoldChestId, "item_BronzePlatedGoldChestplate",MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 1)).setUnlocalizedName("BPGoldChest");
		BPGoldPants = (new MItemArmor(EOConfig.BPGoldPantsId, "item_BronzePlatedGoldLeggings",MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 2)).setUnlocalizedName("BPGoldPants");
		BPGoldBoots = (new MItemArmor(EOConfig.BPGoldBootsId, "item_BronzePlatedGoldBoots",MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 3)).setUnlocalizedName("BPGoldBoots");
		
		BPDiamondPickaxe = (new MItemPickaxe(EOConfig.BPDiamondPickaxeId, "item_BronzePlatedDiamondPickaxe",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondPickaxe");
		BPDiamondShovel = (new MItemShovel(EOConfig.BPDiamondShovelId, "item_BronzePlatedDiamondShovel",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondShovel");
		BPDiamondAxe = (new MItemAxe(EOConfig.BPDiamondAxeId, "item_BronzePlatedDiamondAxe",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondAxe");
		BPDiamondHoe = (new MItemHoe(EOConfig.BPDiamondHoeId, "item_BronzePlatedDiamondHoe",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondHoe");
		BPDiamondSword = (new MItemSword(EOConfig.BPDiamondSwordId, "item_BronzePlatedDiamondSword",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondSword");
		
		BPDiamondHelmet = (new MItemArmor(EOConfig.BPDiamondHelmetId,"item_BronzePlatedDiamondHelmet", MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 0)).setUnlocalizedName("BPDiamondHelmet");
		BPDiamondChest = (new MItemArmor(EOConfig.BPDiamondChestId, "item_BronzePlatedDiamondChestplate",MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 1)).setUnlocalizedName("BPDiamondChest");
		BPDiamondPants = (new MItemArmor(EOConfig.BPDiamondPantsId, "item_BronzePlatedDiamondLeggings",MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 2)).setUnlocalizedName("BPDiamondPants");
		BPDiamondBoots = (new MItemArmor(EOConfig.BPDiamondBootsId, "item_BronzePlatedDiamondBoots",MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 3)).setUnlocalizedName("BPDiamondBoots");		
		
	}
	
	public void addItemsToChests(){

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
	
	public static void setHarvestLevels(){

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
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedCobble, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedMossy, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedStoneBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedChiseled, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(EOBlockManager.BronzePlatedGranite, "pickaxe", 1);
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
	}
}
