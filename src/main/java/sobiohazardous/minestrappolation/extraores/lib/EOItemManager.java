package sobiohazardous.minestrappolation.extraores.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import sobiohazardous.minestrappolation.api.item.MItemArmor;
import sobiohazardous.minestrappolation.api.item.MItemAxe;
import sobiohazardous.minestrappolation.api.item.MItemBlockPlacer;
import sobiohazardous.minestrappolation.api.item.MItemHoe;
import sobiohazardous.minestrappolation.api.item.MItemPickaxe;
import sobiohazardous.minestrappolation.api.item.MItemShovel;
import sobiohazardous.minestrappolation.api.item.MItemSword;
import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extraores.CreativeTabExtraoresItems;
import sobiohazardous.minestrappolation.extraores.ExtraOres;
import sobiohazardous.minestrappolation.extraores.item.EOItem;
import sobiohazardous.minestrappolation.extraores.item.EOItemBucket;
import sobiohazardous.minestrappolation.extraores.item.ItemGrenade;
import sobiohazardous.minestrappolation.extraores.item.ItemGrenadeImpact;
import sobiohazardous.minestrappolation.extraores.item.ItemGrenadeSticky;
import sobiohazardous.minestrappolation.extraores.item.ItemKey;
import sobiohazardous.minestrappolation.extraores.item.ItemLock;
import sobiohazardous.minestrappolation.extraores.item.ToriteToolAxe;
import sobiohazardous.minestrappolation.extraores.item.ToriteToolPickaxe;
import sobiohazardous.minestrappolation.extraores.item.ToriteToolShovel;

public class EOItemManager 
{
	public static CreativeTabs tabOresItems = new CreativeTabExtraoresItems(CreativeTabs.getNextID(), "Extrappolated Ores - Items");
	
	static ArmorMaterial MaterialMeurodite = EnumHelper.addArmorMaterial("meurodite", 18, new int[]{2, 7, 6, 2}, 15);
	static ArmorMaterial MaterialTitanium = EnumHelper.addArmorMaterial("titanium", 66, new int[]{4, 10, 8, 5}, 11);
	static ArmorMaterial MaterialTorite = EnumHelper.addArmorMaterial("torite", 17, new int[]{2, 8, 6, 2}, 20);
	static ArmorMaterial MaterialBlazium = EnumHelper.addArmorMaterial("blazium", 25, new int[]{3, 7, 6, 3}, 18);
	static ArmorMaterial MaterialTin = EnumHelper.addArmorMaterial("tin", 5, new int[]{2, 4, 3, 2}, 5);
	static ArmorMaterial MaterialBronze = EnumHelper.addArmorMaterial("bronze", 30, new int[]{3, 7, 5, 2}, 8);
	static ArmorMaterial MaterialSteel  = EnumHelper.addArmorMaterial("steel", 17, new int[]{3, 8, 6, 3}, 15);
	static ArmorMaterial MaterialBPMeurodite = EnumHelper.addArmorMaterial("meuroditeBronze", 36, new int[]{2, 7, 6, 2}, 15);
	static ArmorMaterial MaterialBPTitanium = EnumHelper.addArmorMaterial("titaniumBronze", 132, new int[]{4, 10, 8, 5}, 11);
	static ArmorMaterial MaterialBPTorite = EnumHelper.addArmorMaterial("toriteBronze", 34, new int[]{2, 8, 6, 2}, 20);
	static ArmorMaterial MaterialBPBlazium = EnumHelper.addArmorMaterial("blaziumBronze", 50, new int[]{3, 7, 6, 3}, 18);
	static ArmorMaterial MaterialBPTin = EnumHelper.addArmorMaterial("tinBronze", 10, new int[]{2, 4, 3, 2}, 5);
	static ArmorMaterial MaterialBPSteel  = EnumHelper.addArmorMaterial("steelBronze", 34, new int[]{3, 8, 6, 3}, 15);
	static ArmorMaterial MaterialBPCloth = EnumHelper.addArmorMaterial("leatherBronze", 10, new int[]{1, 3, 2, 1}, 15);
	static ArmorMaterial MaterialBPChain = EnumHelper.addArmorMaterial("chainBronze", 30, new int[]{2, 5, 4, 1}, 12);
	static ArmorMaterial MaterialBPIron = EnumHelper.addArmorMaterial("ironBronze", 30, new int[]{2, 6, 5, 2}, 9);
	static ArmorMaterial MaterialBPGold = EnumHelper.addArmorMaterial("goldBronze", 14, new int[]{2, 5, 3, 1}, 25);
	static ArmorMaterial MaterialBPDiamond = EnumHelper.addArmorMaterial("diamondBronze", 66, new int[]{3, 8, 6, 3}, 10);
	
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
	
	public static Item steelKey;
	public static Item steelLock;
	
	//public static Item bucketMagma;
	
	public static void addItems()
	{
		meuroditeIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeIngot").setTextureName(MAssetManager.getEOTexture("gemMeurodite"));
		GameRegistry.registerItem(meuroditeIngot, "ingotMeurodite");
		meuroditeSword = (new MItemSword(toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeSword").setTextureName(MAssetManager.getEOTexture("weaponSwordMeurodite"));
		GameRegistry.registerItem(meuroditeSword, "weaponSwordMeurodite");
		meuroditePickaxe = (new MItemPickaxe(toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickMeurodite"));
		GameRegistry.registerItem(meuroditePickaxe, "toolPickMeurodite");
		meuroditeShovel = (new MItemShovel(toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeShovel").setTextureName(MAssetManager.getEOTexture("toolShovelMeurodite"));
		GameRegistry.registerItem(meuroditeShovel, "toolShovelMeurodite");
		meuroditeHoe = (new MItemHoe(toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHoe").setTextureName(MAssetManager.getEOTexture("toolHoeMeurodite"));
		GameRegistry.registerItem(meuroditeHoe, "toolHoeMeurodite");
		meuroditeAxe = (new MItemAxe(toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeAxe").setTextureName(MAssetManager.getEOTexture("toolAxeMeurodite"));
		GameRegistry.registerItem(meuroditeAxe, "toolAxeMeurodite");
		
		TinPlateItem = (new MItemBlockPlacer(EOBlockManager.TinPlate)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinPlate").setTextureName(MAssetManager.getEOTexture("platingTin"));
		GameRegistry.registerItem(TinPlateItem, "itemTinPlate");
		meuroditePlateItem = (new MItemBlockPlacer(EOBlockManager.meuroditePlate)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditePlate").setTextureName(MAssetManager.getEOTexture("platingMeurodite"));
		GameRegistry.registerItem(meuroditePlateItem, "itemMeuroditePlate");
		BronzePlateItem = (new MItemBlockPlacer(EOBlockManager.BronzePlate)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzePlate").setTextureName(MAssetManager.getEOTexture("platingBronze"));
		GameRegistry.registerItem(BronzePlateItem, "itemBronzePlate");
		SteelPlateItem = (new MItemBlockPlacer( EOBlockManager.SteelPlate)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelPlate").setTextureName(MAssetManager.getEOTexture("platingSteel"));
		GameRegistry.registerItem(SteelPlateItem, "itemSteelPlate");
		CopperSword = (new MItemSword(toolMaterialCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperSword").setTextureName(MAssetManager.getEOTexture("weaponSwordCopper"));
		GameRegistry.registerItem(CopperSword, "weaponSwordCopper");
		CopperPickaxe = (new MItemPickaxe(toolMaterialCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperPickaxe").setTextureName(MAssetManager.getEOTexture("toolPickCopper"));
		GameRegistry.registerItem(CopperPickaxe, "toolPickCopper");
		CopperShovel = (new MItemShovel(toolMaterialCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperShovel").setTextureName(MAssetManager.getEOTexture("toolShovelCopper"));
		GameRegistry.registerItem(CopperShovel, "toolShovelCopper");
		CopperHoe = (new MItemHoe(toolMaterialCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperHoe").setTextureName(MAssetManager.getEOTexture("toolHoeCopper"));
		GameRegistry.registerItem(CopperHoe, "toolHoeCopper");
		CopperAxe = (new MItemAxe(toolMaterialCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperAxe").setTextureName(MAssetManager.getEOTexture("toolAxeCopper"));
		GameRegistry.registerItem(CopperAxe, "toolAxeCopper");
		
		BlaziumIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_BlaziumIngot").setTextureName(MAssetManager.getEOTexture("ingotBlazium"));
		GameRegistry.registerItem(BlaziumIngot, "ingotBlazium");
		BlazeShard = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_BlazeShard").setTextureName(MAssetManager.getEOTexture("dustBlazium"));
		GameRegistry.registerItem(BlazeShard, "shardBlazium");
		
		BlaziumSword = (new MItemSword(toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireSword").setTextureName(MAssetManager.getEOTexture("weaponSwordFire"));
		GameRegistry.registerItem(BlaziumSword, "weaponSwordBlazium");
		BlaziumPickaxe = (new MItemPickaxe(toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FirePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickFire"));
		GameRegistry.registerItem(BlaziumPickaxe, "toolPickBlazium");
		BlaziumShovel = (new MItemShovel(toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireShovel").setTextureName(MAssetManager.getEOTexture("toolShovelFire"));
		GameRegistry.registerItem(BlaziumShovel, "toolShovelBlazium");
		BlaziumHoe = (new MItemHoe(toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHoe").setTextureName(MAssetManager.getEOTexture("toolHoeFire"));
		GameRegistry.registerItem(BlaziumHoe, "toolHoeBlazium");
		BlaziumAxe = (new MItemAxe(toolMaterialBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireAxe").setTextureName(MAssetManager.getEOTexture("toolAxeFire"));
		GameRegistry.registerItem(BlaziumAxe, "toolAxeBlazium");
		
		BlaziumHelmet = (new MItemArmor(MaterialBlazium, ExtraOres.proxy.addArmor("fire"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmFire"));
		GameRegistry.registerItem(BlaziumHelmet, "armorHelmetBlazium");
		BlaziumChest = (new MItemArmor(MaterialBlazium, ExtraOres.proxy.addArmor("fire"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireChestplate").setTextureName(MAssetManager.getEOTexture("armorChestFire"));
		GameRegistry.registerItem(BlaziumChest, "armorChestBlazium");
		BlaziumPants = (new MItemArmor(MaterialBlazium, ExtraOres.proxy.addArmor("fire"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsFire"));
		GameRegistry.registerItem(BlaziumPants, "armorPantsBlazium");
		BlaziumBoots = (new MItemArmor(MaterialBlazium, ExtraOres.proxy.addArmor("fire"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireBoots").setTextureName(MAssetManager.getEOTexture("armorBootsFire"));
		GameRegistry.registerItem(BlaziumBoots, "armorBootsBlazium");
		
		CoalIronIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_CoalIronIngot").setTextureName(MAssetManager.getEOTexture("ingotCoalIron"));
		GameRegistry.registerItem(CoalIronIngot, "ingotCoalIron");
		SteelIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelIngot").setTextureName(MAssetManager.getEOTexture("ingotSteel"));
		GameRegistry.registerItem(SteelIngot, "ingotSteel");
		
		SteelPickaxe = (new MItemPickaxe(toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelPickaxe").setTextureName(MAssetManager.getEOTexture("toolPickSteel"));
		GameRegistry.registerItem(SteelPickaxe, "toolPickSteel");
		SteelShovel = (new MItemShovel(toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelShovel").setTextureName(MAssetManager.getEOTexture("toolShovelSteel"));
		GameRegistry.registerItem(SteelShovel, "toolShovelSteel");
		ToriteSword = (new MItemSword(toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteSword").setTextureName(MAssetManager.getEOTexture("weaponSwordTorite"));
		GameRegistry.registerItem(ToriteSword, "weaponSwordTorite");
		ToritePickaxe = (new ToriteToolPickaxe(toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToritePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickTorite"));
		GameRegistry.registerItem(ToritePickaxe, "toolPickTorite");
		ToriteShovel = (new ToriteToolShovel(toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteShovel");
		GameRegistry.registerItem(ToriteShovel, "toolShovelTorite");
		ToriteHoe = (new MItemHoe(toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHoe").setTextureName(MAssetManager.getEOTexture("toolHoeTorite"));
		GameRegistry.registerItem(ToriteHoe, "toolHoeTorite");
		ToriteAxe = (new ToriteToolAxe(toolMaterialTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteAxe").setTextureName(MAssetManager.getEOTexture("toolAxeTorite"));
		GameRegistry.registerItem(ToriteAxe, "toolAxeTorite");
		TitaniumIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumIngot").setTextureName(MAssetManager.getEOTexture("ingotTitanium"));
		GameRegistry.registerItem(TitaniumIngot, "ingotTitanium");
		
		TitaniumSword = (new MItemSword(toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumSword").setTextureName(MAssetManager.getEOTexture("weaponSwordTitanium"));
		GameRegistry.registerItem(TitaniumSword, "weaponSwordTitanium");
		TitaniumPickaxe = (new MItemPickaxe(toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumPickaxe").setTextureName(MAssetManager.getEOTexture("toolPickTitanium"));
		GameRegistry.registerItem(TitaniumPickaxe, "toolPickTitanium");
		TitaniumShovel = (new MItemShovel(toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumShovel").setTextureName(MAssetManager.getEOTexture("toolShovelTitanium"));
		GameRegistry.registerItem(TitaniumShovel, "toolShovelTitanium");
		TitaniumHoe = (new MItemHoe(toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHoe").setTextureName(MAssetManager.getEOTexture("toolHoeTitanium"));
		GameRegistry.registerItem(TitaniumHoe, "toolHoeTitanium");
		TitaniumAxe = (new MItemAxe(toolMaterialTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumAxe").setTextureName(MAssetManager.getEOTexture("toolAxeTitanium"));
		GameRegistry.registerItem(TitaniumAxe, "toolAxeTitanium");
		meuroditeHelmet = (new MItemArmor(MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmMeurodite"));
		GameRegistry.registerItem(meuroditeHelmet, "armorHelmetMeirodite");
		meuroditeChest = (new MItemArmor(MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeChestplate").setTextureName(MAssetManager.getEOTexture("armorChestMeurodite"));
		GameRegistry.registerItem(meuroditeChest, "armorChestMeurodite");
		meuroditePants = (new MItemArmor(MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsMeurodite"));
		GameRegistry.registerItem(meuroditePants, "armorPantsMeurodite");
		meuroditeBoots = (new MItemArmor(MaterialMeurodite, ExtraOres.proxy.addArmor("Meurodite"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeBoots").setTextureName(MAssetManager.getEOTexture("armorBootsMeurodite"));
		GameRegistry.registerItem(meuroditeBoots, "armorBootsMeurodite");
		
		TitaniumHelmet = (new MItemArmor(MaterialTitanium, ExtraOres.proxy.addArmor("titanium"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmTitanium"));
		GameRegistry.registerItem(TitaniumHelmet, "armorHelmetTitanium");
		TitaniumChest = (new MItemArmor(MaterialTitanium, ExtraOres.proxy.addArmor("titanium"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumChestplate").setTextureName(MAssetManager.getEOTexture("armorChestTitanium"));
		GameRegistry.registerItem(TitaniumChest, "armorChestTitanium");
		TitaniumPants = (new MItemArmor(MaterialTitanium, ExtraOres.proxy.addArmor("titanium"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsTitanium"));
		GameRegistry.registerItem(TitaniumPants, "armorPantsTitanium");
		TitaniumBoots = (new MItemArmor(MaterialTitanium, ExtraOres.proxy.addArmor("titanium"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumBoots").setTextureName(MAssetManager.getEOTexture("armorBootsTitanium"));
		GameRegistry.registerItem(TitaniumBoots, "armorBootsTitanium");
		
		ToriteHelmet = (new MItemArmor(MaterialTorite, ExtraOres.proxy.addArmor("torite"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmTorite"));
		GameRegistry.registerItem(ToriteHelmet, "armorHelmetTorite");
		ToriteChest = (new MItemArmor(MaterialTorite, ExtraOres.proxy.addArmor("torite"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteChestplate").setTextureName(MAssetManager.getEOTexture("armorChestTorite"));
		GameRegistry.registerItem(ToriteChest, "armorChestTorite");
		ToritePants = (new MItemArmor(MaterialTorite, ExtraOres.proxy.addArmor("torite"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsTorite"));
		GameRegistry.registerItem(ToritePants, "armorPantsTorite");
		ToriteBoots = (new MItemArmor(MaterialTorite, ExtraOres.proxy.addArmor("torite"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteBoots").setTextureName(MAssetManager.getEOTexture("armorBootsTorite"));
		GameRegistry.registerItem(ToriteBoots, "armorBootsTorite");
		SandstonePickaxe = (new MItemPickaxe(toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstonePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickSandstone"));
		GameRegistry.registerItem(SandstonePickaxe, "toolPickSandstone");
		SandstoneShovel = (new MItemShovel(toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneShovel").setTextureName(MAssetManager.getEOTexture("toolShovelSandstone"));
		GameRegistry.registerItem(SandstoneShovel, "toolShovelSandstone");
		SandstoneAxe = (new MItemAxe( toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneAxe").setTextureName(MAssetManager.getEOTexture("toolAxeSandstone"));
		GameRegistry.registerItem(SandstoneAxe, "toolAxeSandstone");
		SandstoneHoe = (new MItemHoe(toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneHoe").setTextureName(MAssetManager.getEOTexture("toolHoeSandstone"));
		GameRegistry.registerItem(SandstoneHoe, "toolHoeSandstone");
		SandstoneSword = (new MItemSword(toolMaterialSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneSword").setTextureName(MAssetManager.getEOTexture("weaponSwordSandstone"));
		GameRegistry.registerItem(SandstoneSword, "weaponSwordSandstone");
		SteelAxe = (new MItemAxe(toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelAxe").setTextureName(MAssetManager.getEOTexture("toolAxeSteel"));
		GameRegistry.registerItem(SteelAxe, "toolAxeSteel");
		SteelHoe = (new MItemHoe(toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelHoe").setTextureName(MAssetManager.getEOTexture("toolHoeSteel"));
		GameRegistry.registerItem(SteelHoe, "toolHoeSteel");
		SteelSword = (new MItemSword(toolMaterialSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelSword").setTextureName(MAssetManager.getEOTexture("weaponSwordSteel"));
		GameRegistry.registerItem(SteelSword, "weaponSwordSteel");
		
		SteelHelmet = (new MItemArmor(MaterialSteel, ExtraOres.proxy.addArmor("steel"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmSteel"));
		GameRegistry.registerItem(SteelHelmet, "armorHelmetSteel");
		SteelChest = (new MItemArmor(MaterialSteel, ExtraOres.proxy.addArmor("steel"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelChestplate").setTextureName(MAssetManager.getEOTexture("armorChestSteel"));
		GameRegistry.registerItem(SteelChest, "armorChestSteel");
		SteelPants = (new MItemArmor(MaterialSteel, ExtraOres.proxy.addArmor("steel"), 2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsSteel"));
		GameRegistry.registerItem(SteelPants, "armorPantsSteel");
		SteelBoots = (new MItemArmor(MaterialSteel, ExtraOres.proxy.addArmor("steel"), 3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelBoots").setTextureName(MAssetManager.getEOTexture("armorBootsSteel"));
		GameRegistry.registerItem(SteelBoots, "armorBootsSteel");
		
		BronzeIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeIngot");
		GameRegistry.registerItem(BronzeIngot, "ingotBronze");
		BronzePickaxe = (new MItemPickaxe(toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzePickaxe");
		GameRegistry.registerItem(BronzePickaxe, "toolPickBronze");
		BronzeShovel = (new MItemShovel(toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeShovel");
		GameRegistry.registerItem(BronzeShovel, "toolShovelBronze");
		BronzeAxe = (new MItemAxe(toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeAxe");
		GameRegistry.registerItem(BronzeAxe, "toolAxeBronze");
		BronzeHoe = (new MItemHoe(toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeHoe");
		GameRegistry.registerItem(BronzeHoe, "toolHoeBronze");
		BronzeSword = (new MItemSword(toolMaterialBronze)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeSword");
		GameRegistry.registerItem(BronzeSword, "weaponSwordBronze");
		BronzeHelmet = (new MItemArmor(MaterialBronze, ExtraOres.proxy.addArmor("bronze"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeHelmet");
		GameRegistry.registerItem(BronzeHelmet, "armorHelmetBronze");
		BronzeChest = (new MItemArmor(MaterialBronze, ExtraOres.proxy.addArmor("bronze"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeChestplate");
		GameRegistry.registerItem(BronzeChest, "armorChestBronze");
		BronzePants = (new MItemArmor(MaterialBronze, ExtraOres.proxy.addArmor("bronze"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeLeggings");
		GameRegistry.registerItem(BronzePants, "armorPantsBronze");
		BronzeBoots = (new MItemArmor(MaterialBronze, ExtraOres.proxy.addArmor("bronze"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeBoots");
		GameRegistry.registerItem(BronzeBoots, "armorBootsBronze");
		
		grenade = (new ItemGrenade()).setUnlocalizedName("grenade");
		GameRegistry.registerItem(grenade, "grenadeNuke");
		grenadeImpact = (new ItemGrenadeImpact()).setUnlocalizedName("grenadeImpact");
		GameRegistry.registerItem(grenadeImpact, "grenadeImpact");
		grenadeSticky = (new ItemGrenadeSticky()).setUnlocalizedName("grenadeSticky");		
		GameRegistry.registerItem(grenadeSticky, "grenadeSticky");
		
		BPMeuroditeSword = (new MItemSword(toolMaterialBPMeurodite)).setUnlocalizedName("item_BronzePlatedMeuroditeSword");
		BPMeuroditePickaxe = (new MItemPickaxe(toolMaterialBPMeurodite)).setUnlocalizedName("item_BronzePlatedMeuroditePickaxe");
		BPMeuroditeShovel = (new MItemShovel(toolMaterialBPMeurodite)).setUnlocalizedName("item_BronzePlatedMeuroditeShovel");
		BPMeuroditeHoe = (new MItemHoe(toolMaterialBPMeurodite)).setUnlocalizedName("item_BronzePlatedMeuroditeHoe");
		BPMeuroditeAxe = (new MItemAxe(toolMaterialBPMeurodite)).setUnlocalizedName("item_BronzePlatedMeuroditeAxe");
	
		BPMeuroditeHelmet = (new MItemArmor(MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"), 0)).setUnlocalizedName("item_BronzePlatedMeuroditeHelmet");
		BPMeuroditeChest = (new MItemArmor(MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"), 1)).setUnlocalizedName("item_BronzePlatedMeuroditeChestplate");
		BPMeuroditePants = (new MItemArmor(MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"),2)).setUnlocalizedName("item_BronzePlatedMeuroditeLeggings");
		BPMeuroditeBoots = (new MItemArmor(MaterialBPMeurodite, ExtraOres.proxy.addArmor("BPMeurodite"),3)).setUnlocalizedName("item_BronzePlatedMeuroditeBoots");
		
		BPTitaniumSword = (new MItemSword(toolMaterialBPTitanium)).setUnlocalizedName("item_BronzePlatedTitaniumSword");
		BPTitaniumPickaxe = (new MItemPickaxe(toolMaterialBPTitanium)).setUnlocalizedName("item_BronzePlatedTitaniumPickaxe");
		BPTitaniumShovel = (new MItemShovel(toolMaterialBPTitanium)).setUnlocalizedName("item_BronzePlatedTitaniumShovel");
		BPTitaniumHoe = (new MItemHoe(toolMaterialBPTitanium)).setUnlocalizedName("item_BronzePlatedTitaniumHoe");
		BPTitaniumAxe = (new MItemAxe(toolMaterialBPTitanium)).setUnlocalizedName("item_BronzePlatedTitaniumAxe");
	
		BPTitaniumHelmet = (new MItemArmor(MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"), 0)).setUnlocalizedName("item_BronzePlatedTitaniumHelmet");
		BPTitaniumChest = (new MItemArmor(MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"), 1)).setUnlocalizedName("item_BronzePlatedTitaniumChestplate");
		BPTitaniumPants = (new MItemArmor(MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"),2)).setUnlocalizedName("item_BronzePlatedTitaniumLeggings");
		BPTitaniumBoots = (new MItemArmor(MaterialBPTitanium, ExtraOres.proxy.addArmor("BPtitanium"),3)).setUnlocalizedName("item_BronzePlatedTitaniumBoots");
		
		BPToriteSword = (new MItemSword(toolMaterialBPTorite)).setUnlocalizedName("item_BronzePlatedToriteSword");
		BPToritePickaxe = (new ToriteToolPickaxe(toolMaterialBPTorite)).setUnlocalizedName("item_BronzePlatedToritePickaxe");
		BPToriteShovel = (new ToriteToolShovel(toolMaterialBPTorite)).setUnlocalizedName("item_BronzePlatedToriteShovel");
		BPToriteHoe = (new MItemHoe(toolMaterialBPTorite)).setUnlocalizedName("item_BronzePlatedToriteHoe");
		BPToriteAxe = (new ToriteToolAxe(toolMaterialBPTorite)).setUnlocalizedName("item_BronzePlatedToriteAxe");
		
		BPToriteHelmet = (new MItemArmor(MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"), 0)).setUnlocalizedName("item_BronzePlatedToriteHelmet");
		BPToriteChest = (new MItemArmor(MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"), 1)).setUnlocalizedName("item_BronzePlatedToriteChestplate");
		BPToritePants = (new MItemArmor(MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"),2)).setUnlocalizedName("item_BronzePlatedToriteLeggings");
		BPToriteBoots = (new MItemArmor(MaterialBPTorite, ExtraOres.proxy.addArmor("BPtorite"),3)).setUnlocalizedName("item_BronzePlatedToriteBoots");
		
		BPBlaziumSword = (new MItemSword(toolMaterialBPBlazium)).setUnlocalizedName("item_BronzePlatedFireSword");
		BPBlaziumPickaxe = (new MItemPickaxe(toolMaterialBPBlazium)).setUnlocalizedName("item_BronzePlatedFirePickaxe");
		BPBlaziumShovel = (new MItemShovel(toolMaterialBPBlazium)).setUnlocalizedName("item_BronzePlatedFireShovel");
		BPBlaziumHoe = (new MItemHoe(toolMaterialBPBlazium)).setUnlocalizedName("item_BronzePlatedFireHoe");
		BPBlaziumAxe = (new MItemAxe(toolMaterialBPBlazium)).setUnlocalizedName("item_BronzePlatedFireAxe");
		
		BPBlaziumHelmet = (new MItemArmor(MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"), 0)).setUnlocalizedName("item_BronzePlatedFireHelmet");
		BPBlaziumChest = (new MItemArmor(MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"), 1)).setUnlocalizedName("item_BronzePlatedFireChestplate");
		BPBlaziumPants = (new MItemArmor(MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"),2)).setUnlocalizedName("item_BronzePlatedFireLeggings");
		BPBlaziumBoots = (new MItemArmor(MaterialBPBlazium, ExtraOres.proxy.addArmor("BPfire"),3)).setUnlocalizedName("item_BronzePlatedFireBoots");
		
		BPCopperSword = (new MItemSword(toolMaterialBPCopper)).setUnlocalizedName("item_BronzePlatedCopperSword");
		BPCopperPickaxe = (new MItemPickaxe(toolMaterialBPCopper)).setUnlocalizedName("item_BronzePlatedCopperPickaxe");
		BPCopperShovel = (new MItemShovel(toolMaterialBPCopper)).setUnlocalizedName("item_BronzePlatedCopperShovel");
		BPCopperHoe = (new MItemHoe(toolMaterialBPCopper)).setUnlocalizedName("item_BronzePlatedCopperHoe");
		BPCopperAxe = (new MItemAxe(toolMaterialBPCopper)).setUnlocalizedName("item_BronzePlatedCopperAxe");
		
		BPTinHelmet = (new MItemArmor(MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"), 0)).setUnlocalizedName("item_BronzePlatedTinHelmet");
		BPTinChest = (new MItemArmor(MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"), 1)).setUnlocalizedName("item_BronzePlatedTinChestplate");
		BPTinPants = (new MItemArmor(MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"),2)).setUnlocalizedName("item_BronzePlatedTinLeggings");
		BPTinBoots = (new MItemArmor(MaterialBPTin, ExtraOres.proxy.addArmor("BPtin"),3)).setUnlocalizedName("item_BronzePlatedTinBoots");
		
		BPSteelPickaxe = (new MItemPickaxe(toolMaterialBPSteel)).setUnlocalizedName("item_BronzePlatedSteelPickaxe");
		BPSteelShovel = (new MItemShovel(toolMaterialBPSteel)).setUnlocalizedName("item_BronzePlatedSteelShovel");
		BPSteelAxe = (new MItemAxe(toolMaterialBPSteel)).setUnlocalizedName("item_BronzePlatedSteelAxe");
		BPSteelHoe = (new MItemHoe(toolMaterialBPSteel)).setUnlocalizedName("item_BronzePlatedSteelHoe");
		BPSteelSword = (new MItemSword(toolMaterialBPSteel)).setUnlocalizedName("item_BronzePlatedSteelSword");
		
		BPSteelHelmet = (new MItemArmor(MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 0)).setUnlocalizedName("item_BronzePlatedSteelHelmet");
		BPSteelChest = (new MItemArmor(MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 1)).setUnlocalizedName("item_BronzePlatedSteelChestplate");
		BPSteelPants = (new MItemArmor(MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 2)).setUnlocalizedName("item_BronzePlatedSteelLeggings");
		BPSteelBoots = (new MItemArmor(MaterialBPSteel, ExtraOres.proxy.addArmor("BPsteel"), 3)).setUnlocalizedName("item_BronzePlatedSteelBoots");
		
		BPSandstonePickaxe = (new MItemPickaxe(toolMaterialBPSandstone)).setUnlocalizedName("item_BronzePlatedSandstonePickaxe");
		BPSandstoneShovel = (new MItemShovel(toolMaterialBPSandstone)).setUnlocalizedName("item_BronzePlatedSandstoneShovel");
		BPSandstoneAxe = (new MItemAxe( toolMaterialBPSandstone)).setUnlocalizedName("item_BronzePlatedSandstoneAxe");
		BPSandstoneHoe = (new MItemHoe(toolMaterialBPSandstone)).setUnlocalizedName("item_BronzePlatedSandstoneHoe");
		BPSandstoneSword = (new MItemSword(toolMaterialBPSandstone)).setUnlocalizedName("item_BronzePlatedSandstoneSword");
		
		BPBedrockPickaxe = (new MItemPickaxe(toolMaterialBPBedrock)).setUnlocalizedName("item_BronzePlatedBedrockPickaxe");
		BPBedrockShovel = (new MItemShovel(toolMaterialBPBedrock)).setUnlocalizedName("item_BronzePlatedBedrockShovel");
		BPBedrockAxe = (new MItemAxe(toolMaterialBPBedrock)).setUnlocalizedName("item_BronzePlatedBedrockAxe");
		BPBedrockHoe = (new MItemHoe(toolMaterialBPBedrock)).setUnlocalizedName("item_BronzePlatedBedrockHoe");
		
		BPGranitePickaxe = (new MItemPickaxe(toolMaterialBPGranite)).setUnlocalizedName("item_BronzePlatedGranitePickaxe");
		BPGraniteShovel = (new MItemShovel(toolMaterialBPGranite)).setUnlocalizedName( "item_BronzePlatedGraniteShovel");
		BPGraniteAxe = (new MItemAxe(toolMaterialBPGranite)).setUnlocalizedName("item_BronzePlatedGraniteAxe");
		BPGraniteHoe = (new MItemHoe(toolMaterialBPGranite)).setUnlocalizedName("item_BronzePlatedGraniteHoe");
		BPGraniteSword = (new MItemSword(toolMaterialBPGranite)).setUnlocalizedName("item_BronzePlatedGraniteSword");
		
		BPWoodPickaxe = (new MItemPickaxe(toolMaterialBPWood)).setUnlocalizedName("item_BronzePlatedWoodPickaxe");
		BPWoodShovel = (new MItemShovel(toolMaterialBPWood)).setUnlocalizedName("item_BronzePlatedWoodShovel");
		BPWoodAxe = (new MItemAxe(toolMaterialBPWood)).setUnlocalizedName("item_BronzePlatedWoodAxe");
		BPWoodHoe = (new MItemHoe(toolMaterialBPWood)).setUnlocalizedName("item_BronzePlatedWoodHoe");
		BPWoodSword = (new MItemSword(toolMaterialBPWood)).setUnlocalizedName("item_BronzePlatedWoodSword");
		
		BPClothHelmet = (new MItemArmor(MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 0)).setUnlocalizedName("item_BronzePlatedLeatherHelmet");
		BPClothChest = (new MItemArmor(MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 1)).setUnlocalizedName("item_BronzePlatedLeatherChestplate");
		BPClothPants = (new MItemArmor(MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 2)).setUnlocalizedName("item_BronzePlatedLeatherLeggings");
		BPClothBoots = (new MItemArmor(MaterialBPCloth, ExtraOres.proxy.addArmor("BPcloth"), 3)).setUnlocalizedName("item_BronzePlatedLeatherBoots");
		
		BPStonePickaxe = (new MItemPickaxe(toolMaterialBPStone)).setUnlocalizedName("item_BronzePlatedStonePickaxe");
		BPStoneShovel = (new MItemShovel(toolMaterialBPStone)).setUnlocalizedName("item_BronzePlatedStoneShovel");
		BPStoneAxe = (new MItemAxe(toolMaterialBPStone)).setUnlocalizedName( "item_BronzePlatedStoneAxe");
		BPStoneHoe = (new MItemHoe(toolMaterialBPStone)).setUnlocalizedName("item_BronzePlatedStoneHoe");
		BPStoneSword = (new MItemSword(toolMaterialBPStone)).setUnlocalizedName("item_BronzePlatedStoneSword");
		
		BPChainHelmet = (new MItemArmor(MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 0)).setUnlocalizedName("item_BronzePlatedChainHelmet");
		BPChainChest = (new MItemArmor(MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 1)).setUnlocalizedName("item_BronzePlatedChainChestplate");
		BPChainPants = (new MItemArmor(MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 2)).setUnlocalizedName("item_BronzePlatedChainLeggings");
		BPChainBoots = (new MItemArmor(MaterialBPChain, ExtraOres.proxy.addArmor("BPchain"), 3)).setUnlocalizedName("item_BronzePlatedChainBoots");
		Uranium = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_Uranium");
		GameRegistry.registerItem(Uranium, "uranium");

		ToriteIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteIngot");
		GameRegistry.registerItem(ToriteIngot, "ingotTorite");
		PinkQuartz = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_PinkQuartz");
		GameRegistry.registerItem(PinkQuartz, "gemDesertQuartz");
		CopperIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperIngot").setTextureName(MAssetManager.getEOTexture("ingotCopper"));
		GameRegistry.registerItem(CopperIngot, "ingotCopper");
		TinIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinIngot");
		GameRegistry.registerItem(TinIngot, "ingotTin");
		Plutonium = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_Plutonium");
		GameRegistry.registerItem(Plutonium, "plutonium");
		TinHelmet = (new MItemArmor(MaterialTin, ExtraOres.proxy.addArmor("tin"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinHelmet");
		GameRegistry.registerItem(TinHelmet, "armorHelmetTin");
		TinChest = (new MItemArmor(MaterialTin, ExtraOres.proxy.addArmor("tin"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinChestplate");
		GameRegistry.registerItem(TinChest, "armorChestTin");
		TinPants = (new MItemArmor(MaterialTin, ExtraOres.proxy.addArmor("tin"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinLeggings");
		GameRegistry.registerItem(TinPants, "armorPantsTin");
		TinBoots = (new MItemArmor(MaterialTin, ExtraOres.proxy.addArmor("tin"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TinBoots");
		GameRegistry.registerItem(TinBoots, "armorBootsTin");
		BedrockPickaxe = (new MItemPickaxe(toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockPickaxe");
		GameRegistry.registerItem(BedrockPickaxe, "toolPickBedrock");
		BedrockShovel = (new MItemShovel(toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName( "item_BedrockShovel");
		GameRegistry.registerItem(BedrockShovel, "toolPickBedrock");
		BedrockAxe = (new MItemAxe(toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockAxe");
		GameRegistry.registerItem(BedrockAxe, "toolAxeBedrock");
		BedrockHoe = (new MItemHoe(toolMaterialBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockHoe");
		GameRegistry.registerItem(BedrockHoe, "toolHoeBedrock");
		
		GranitePickaxe = (new MItemPickaxe(toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GranitePickaxe");
		GameRegistry.registerItem(GranitePickaxe, "toolPickGranite");
		GraniteShovel = (new MItemShovel(toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteShovel");
		GameRegistry.registerItem(GraniteShovel, "toolShovelGranite");
		GraniteAxe = (new MItemAxe(toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteAxe");
		GameRegistry.registerItem(GraniteAxe, "toolAxeGranite");
		GraniteHoe = (new MItemHoe(toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteHoe");
		GameRegistry.registerItem(GraniteHoe, "toolHoeGranite");
		GraniteSword = (new MItemSword(toolMaterialGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteSword");
		GameRegistry.registerItem(GraniteSword, "toolSwordGranite");
		SunstoneDust = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_SunstoneShard");
		GameRegistry.registerItem(SunstoneDust, "dustSunstone");
		
		BPIronPickaxe = (new MItemPickaxe(toolMaterialBPIron)).setUnlocalizedName("item_BronzePlatedIronPickaxe");
		BPIronShovel = (new MItemShovel(toolMaterialBPIron)).setUnlocalizedName("item_BronzePlatedIronShovel");
		BPIronAxe = (new MItemAxe(toolMaterialBPIron)).setUnlocalizedName("item_BronzePlatedIronAxe");
		BPIronHoe = (new MItemHoe(toolMaterialBPIron)).setUnlocalizedName("item_BronzePlatedIronHoe");
		BPIronSword = (new MItemSword(toolMaterialBPIron)).setUnlocalizedName("item_BronzePlatedIronSword");
		
		BPIronHelmet = (new MItemArmor( MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 0)).setUnlocalizedName("item_BronzePlatedIronHelmet");
		BPIronChest = (new MItemArmor(MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 1)).setUnlocalizedName("item_BronzePlatedIronChestplate");
		BPIronPants = (new MItemArmor(MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 2)).setUnlocalizedName("item_BronzePlatedIronLeggings");
		BPIronBoots = (new MItemArmor(MaterialBPIron, ExtraOres.proxy.addArmor("BPiron"), 3)).setUnlocalizedName("item_BronzePlatedIronBoots");
		
		BPGoldPickaxe = (new MItemPickaxe(toolMaterialBPGold)).setUnlocalizedName("item_BronzePlatedGoldPickaxe");
		BPGoldShovel = (new MItemShovel(toolMaterialBPGold)).setUnlocalizedName("item_BronzePlatedGoldShovel");
		BPGoldAxe = (new MItemAxe(toolMaterialBPGold)).setUnlocalizedName("item_BronzePlatedGoldAxe");
		BPGoldHoe = (new MItemHoe(toolMaterialBPGold)).setUnlocalizedName("item_BronzePlatedGoldHoe");
		BPGoldSword = (new MItemSword(toolMaterialBPGold)).setUnlocalizedName("item_BronzePlatedGoldSword");
		
		BPGoldHelmet = (new MItemArmor(MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 0)).setUnlocalizedName("item_BronzePlatedGoldHelmet");
		BPGoldChest = (new MItemArmor(MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 1)).setUnlocalizedName("item_BronzePlatedGoldChestplate");
		BPGoldPants = (new MItemArmor(MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 2)).setUnlocalizedName("item_BronzePlatedGoldLeggings");
		BPGoldBoots = (new MItemArmor(MaterialBPGold, ExtraOres.proxy.addArmor("BPgold"), 3)).setUnlocalizedName("item_BronzePlatedGoldBoots");
		
		BPDiamondPickaxe = (new MItemPickaxe(toolMaterialBPEmerald)).setUnlocalizedName("item_BronzePlatedDiamondPickaxe");
		BPDiamondShovel = (new MItemShovel(toolMaterialBPEmerald)).setUnlocalizedName("item_BronzePlatedDiamondShovel");
		BPDiamondAxe = (new MItemAxe(toolMaterialBPEmerald)).setUnlocalizedName("item_BronzePlatedDiamondAxe");
		BPDiamondHoe = (new MItemHoe(toolMaterialBPEmerald)).setUnlocalizedName("item_BronzePlatedDiamondHoe");
		BPDiamondSword = (new MItemSword(toolMaterialBPEmerald)).setUnlocalizedName("item_BronzePlatedDiamondSword");
		
		BPDiamondHelmet = (new MItemArmor( MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 0)).setUnlocalizedName("item_BronzePlatedDiamondHelmet");
		BPDiamondChest = (new MItemArmor(MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 1)).setUnlocalizedName("item_BronzePlatedDiamondChestplate");
		BPDiamondPants = (new MItemArmor(MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 2)).setUnlocalizedName("item_BronzePlatedDiamondLeggings");
		BPDiamondBoots = (new MItemArmor(MaterialBPDiamond, ExtraOres.proxy.addArmor("BPdiamond"), 3)).setUnlocalizedName("item_BronzePlatedDiamondBoots");		

		//bucketMagma = new EOItemBucket(EOConfig.bucketMagmaId, ExtraOres.eoFluid.getBlockID()).setUnlocalizedName("item_MagmaBucket");
		
		steelKey = new ItemKey().setUnlocalizedName("item_SteelKey").setCreativeTab(tabOresItems);
		GameRegistry.registerItem(steelKey, "keySteel");
		steelLock = new ItemLock().setUnlocalizedName("item_SteelLock").setCreativeTab(tabOresItems);
		GameRegistry.registerItem(steelLock, "mlockSteel");
	}
	
	public static void addItemsToChests()
	{
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(BronzeIngot),1,3,25));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(CoalIronIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(SteelIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(meuroditeIngot),1,4,15));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(TitaniumIngot),1,2,2));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Uranium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Plutonium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(BronzePickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(SteelPickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot),1,5,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(meuroditeIngot),1,4,15));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(TitaniumIngot),1,2,2));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Uranium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(Plutonium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(BronzePickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(SteelPickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(CoalIronIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(BronzeIngot),1,3,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(BlaziumIngot),1,2,7));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(SteelSword),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(BronzeSword),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot),1,5,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(meuroditeIngot),1,4,15));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(TitaniumIngot),1,2,2));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(Uranium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(Plutonium),1,2,10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(BronzePickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(SteelPickaxe),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(CoalIronIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(BronzeIngot),1,3,25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(BlaziumIngot),1,2,7));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(SteelSword),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(BronzeSword),1,1,11));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(EOBlockManager.SoulGem),1,3,12));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(PinkQuartz),1,10,25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(EOBlockManager.RadiantQuartz),1,3,10));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(CopperIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(BronzeIngot),1,3,25));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(CoalIronIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(SteelIngot),1,5,17));
		
		//TODO find alternative
		/*
		MinecraftForge.setToolClass(BPGoldShovel, "shovel", 0);
		MinecraftForge.setToolClass(BPIronShovel, "shovel", 2);
		MinecraftForge.setToolClass(BPDiamondShovel, "shovel", 3);
		MinecraftForge.setToolClass(BPWoodShovel, "shovel", 0);
		MinecraftForge.setToolClass(BPStoneShovel, "shovel", 1);
		MinecraftForge.setToolClass(GraniteShovel, "shovel", 1);
		MinecraftForge.setToolClass(BPGraniteShovel, "shovel", 1);
		MinecraftForge.setToolClass(meuroditeShovel, "shovel", 2);
		MinecraftForge.setToolClass(BPMeuroditeShovel, "shovel", 2);
		MinecraftForge.setToolClass(BedrockShovel, "shovel", 4);
		MinecraftForge.setToolClass(BPBedrockShovel, "shovel", 4);
		MinecraftForge.setToolClass(BronzeShovel, "shovel", 2);
		MinecraftForge.setToolClass(SteelShovel, "shovel", 2);
		MinecraftForge.setToolClass(BPSteelShovel, "shovel", 2);
		MinecraftForge.setToolClass(CopperShovel, "shovel", 1);
		MinecraftForge.setToolClass(BPCopperShovel, "shovel", 1);
		MinecraftForge.setToolClass(BlaziumShovel, "shovel", 2);
		MinecraftForge.setToolClass(BPBlaziumShovel, "shovel", 2);
		MinecraftForge.setToolClass(ToriteShovel, "shovel", 2);
		MinecraftForge.setToolClass(BPToriteShovel, "shovel", 2);
		MinecraftForge.setToolClass(TitaniumShovel, "shovel", 4);
		MinecraftForge.setToolClass(BPTitaniumShovel, "shovel", 4);
		MinecraftForge.setToolClass(meuroditeShovel, "shovel", 2);
		MinecraftForge.setToolClass(BPMeuroditeShovel, "shovel", 2);
		MinecraftForge.setToolClass(SandstoneShovel, "shovel", 1);
		MinecraftForge.setToolClass(BPSandstoneShovel, "shovel", 1);
		*/
	}

	public static void setHarvestLevels()
	{
		//TODO find alternative
		/*
		MinecraftForge.setToolClass(BPGoldPickaxe, "pickaxe", 0);
		MinecraftForge.setToolClass(BPIronPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(BPDiamondPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(BPWoodPickaxe, "pickaxe", 0);
		MinecraftForge.setToolClass(BPStonePickaxe, "pickaxe", 1);
		MinecraftForge.setToolClass(GranitePickaxe, "pickaxe", 1);
		MinecraftForge.setToolClass(BPGranitePickaxe, "pickaxe", 1);
		MinecraftForge.setToolClass(meuroditePickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(BPMeuroditePickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(BedrockPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(BPBedrockPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(BronzePickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(SteelPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(BPSteelPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(CopperPickaxe, "pickaxe", 1);
		MinecraftForge.setToolClass(BPCopperPickaxe, "pickaxe", 1);
		MinecraftForge.setToolClass(BlaziumPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(BPBlaziumPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(ToritePickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(BPToritePickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(TitaniumPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(BPTitaniumPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(meuroditePickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(BPMeuroditePickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(SandstonePickaxe, "pickaxe", 1);
		MinecraftForge.setToolClass(BPSandstonePickaxe, "pickaxe", 1);
		*/
		
		//TODO Why aren't these in the instantiation? 
		EOBlockManager.CopperOre.setHarvestLevel("pickaxe", 0);
		EOBlockManager.CopperBlock.setHarvestLevel("pickaxe", 0);
		EOBlockManager.TinOre.setHarvestLevel("pickaxe", 1);
		EOBlockManager.TinBlock.setHarvestLevel("pickaxe", 1);
		EOBlockManager.meuroditeOre.setHarvestLevel("pickaxe", 2);
		EOBlockManager.meuroditeBlock.setHarvestLevel("pickaxe", 2);
		EOBlockManager.ToriteOre.setHarvestLevel("pickaxe", 2);
		EOBlockManager.ToriteBlock.setHarvestLevel("pickaxe", 2);
		EOBlockManager.TitaniumOre.setHarvestLevel("pickaxe", 3);
		EOBlockManager.TitaniumBlock.setHarvestLevel("pickaxe", 3);
		EOBlockManager.UraniumOre.setHarvestLevel("pickaxe", 2);
		EOBlockManager.PlutoniumOre.setHarvestLevel("pickaxe", 2);
		EOBlockManager.SunstoneOre.setHarvestLevel("pickaxe", 2);
		EOBlockManager.Granite.setHarvestLevel("pickaxe", 1);
		EOBlockManager.GraniteBrick.setHarvestLevel("pickaxe", 1);
		EOBlockManager.Quartzite.setHarvestLevel("pickaxe", 1);
		EOBlockManager.QuartziteTile.setHarvestLevel("pickaxe", 1);
		EOBlockManager.SmoothQuartzite.setHarvestLevel("pickaxe", 1);
		EOBlockManager.PillarQuartzite.setHarvestLevel("pickaxe", 1);
		EOBlockManager.ChiseledQuartzite.setHarvestLevel("pickaxe", 1);
		EOBlockManager.SmoothQuartzTile.setHarvestLevel("pickaxe", 1);
		EOBlockManager.BlaziumOre.setHarvestLevel("pickaxe", 2);
		EOBlockManager.BlaziumBlock.setHarvestLevel("pickaxe", 2);
		EOBlockManager.SoulOre.setHarvestLevel("shovel", 2);
		EOBlockManager.TinPlatedCobble.setHarvestLevel("pickaxe", 1);
		EOBlockManager.TinPlatedMossy.setHarvestLevel("pickaxe", 1);
		EOBlockManager.TinPlatedStoneBrick.setHarvestLevel("pickaxe", 1);
		EOBlockManager.TinPlatedChiseled.setHarvestLevel("pickaxe", 1);
		EOBlockManager.TinPlatedGranite.setHarvestLevel("pickaxe", 1);
		EOBlockManager.BronzeBlock.setHarvestLevel("pickaxe", 1);
		EOBlockManager.BronzePlatedCobble.setHarvestLevel("pickaxe", 2);
		EOBlockManager.BronzePlatedMossy.setHarvestLevel("pickaxe", 2);
		EOBlockManager.BronzePlatedStoneBrick.setHarvestLevel("pickaxe", 2);
		EOBlockManager.BronzePlatedChiseled.setHarvestLevel("pickaxe", 2);
		EOBlockManager.BronzePlatedGranite.setHarvestLevel("pickaxe", 2);
		EOBlockManager.SteelPlatedCobble.setHarvestLevel("pickaxe", 1);
		EOBlockManager.SteelPlatedMossy.setHarvestLevel("pickaxe", 1);
		EOBlockManager.SteelPlatedStoneBrick.setHarvestLevel("pickaxe", 1);
		EOBlockManager.SteelPlatedChiseled.setHarvestLevel("pickaxe", 1);
		EOBlockManager.SteelPlatedGranite.setHarvestLevel("pickaxe", 1);
		EOBlockManager.RawUraniumBlock.setHarvestLevel("pickaxe", 0);
		EOBlockManager.RawPlutoniumBlock.setHarvestLevel("pickaxe", 0);
		EOBlockManager.SmoothRadiantQuartz.setHarvestLevel("pickaxe", 3);
		EOBlockManager.PillarRadiantQuartz.setHarvestLevel("pickaxe", 3);
		EOBlockManager.ChiseledRadiantQuartz.setHarvestLevel("pickaxe", 3);
		EOBlockManager.RadiantQuartzOre.setHarvestLevel("pickaxe", 3);
		EOBlockManager.Godstone.setHarvestLevel("pickaxe", 2);
		Blocks.bedrock.setHarvestLevel("pickaxe", 4);
		EOBlockManager.soulBlock.setHarvestLevel("pickaxe", 4);
	}
}
