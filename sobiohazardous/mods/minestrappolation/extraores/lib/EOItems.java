package sobiohazardous.mods.minestrappolation.extraores.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import sobiohazardous.mods.minestrappolation.core.item.MItemArmor;
import sobiohazardous.mods.minestrappolation.core.item.MItemAxe;
import sobiohazardous.mods.minestrappolation.core.item.MItemHoe;
import sobiohazardous.mods.minestrappolation.core.item.MItemPickaxe;
import sobiohazardous.mods.minestrappolation.core.item.MItemShovel;
import sobiohazardous.mods.minestrappolation.core.item.MItemSword;
import sobiohazardous.mods.minestrappolation.core.util.MAssetManager;
import sobiohazardous.mods.minestrappolation.extraores.CreativeTabExtraoresItems;
import sobiohazardous.mods.minestrappolation.extraores.ExtraOres;
import sobiohazardous.mods.minestrappolation.extraores.item.EOItem;
import sobiohazardous.mods.minestrappolation.extraores.item.EOItemBucket;
import sobiohazardous.mods.minestrappolation.extraores.item.ItemGrenade;
import sobiohazardous.mods.minestrappolation.extraores.item.ItemGrenadeImpact;
import sobiohazardous.mods.minestrappolation.extraores.item.ItemGrenadeSticky;
import sobiohazardous.mods.minestrappolation.extraores.item.ItemKey;
import sobiohazardous.mods.minestrappolation.extraores.item.ItemLock;
import sobiohazardous.mods.minestrappolation.extraores.item.ToriteToolAxe;
import sobiohazardous.mods.minestrappolation.extraores.item.ToriteToolPickaxe;
import sobiohazardous.mods.minestrappolation.extraores.item.ToriteToolShovel;

public class EOItems 
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
	
	//public static Item bucketMagma;
	
	public static void addItems()
	{
		meuroditeIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeIngot").setTextureName(MAssetManager.getEOTexture("gemMeurodite"));
		GameRegistry.registerItem(meuroditeIngot, "ingotMeurodite");
		meuroditeSword = (new MItemSword(toolMaterialMeurodite,toolMaterialBPMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeSword").setTextureName(MAssetManager.getEOTexture("weaponSwordMeurodite"));
		GameRegistry.registerItem(meuroditeSword, "weaponSwordMeurodite");
		meuroditePickaxe = (new MItemPickaxe(toolMaterialMeurodite, toolMaterialBPMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickMeurodite"));
		GameRegistry.registerItem(meuroditePickaxe, "toolPickMeurodite");
		meuroditeShovel = (new MItemShovel(toolMaterialMeurodite, toolMaterialBPMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeShovel").setTextureName(MAssetManager.getEOTexture("toolShovelMeurodite"));
		GameRegistry.registerItem(meuroditeShovel, "toolShovelMeurodite");
		meuroditeHoe = (new MItemHoe(toolMaterialMeurodite, toolMaterialBPMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHoe").setTextureName(MAssetManager.getEOTexture("toolHoeMeurodite"));
		GameRegistry.registerItem(meuroditeHoe, "toolHoeMeurodite");
		meuroditeAxe = (new MItemAxe(toolMaterialMeurodite, toolMaterialBPMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeAxe").setTextureName(MAssetManager.getEOTexture("toolAxeMeurodite"));
		GameRegistry.registerItem(meuroditeAxe, "toolAxeMeurodite");
		
		CopperSword = (new MItemSword(toolMaterialCopper,toolMaterialBPCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperSword").setTextureName(MAssetManager.getEOTexture("weaponSwordCopper"));
		GameRegistry.registerItem(CopperSword, "weaponSwordCopper");
		CopperPickaxe = (new MItemPickaxe(toolMaterialCopper, toolMaterialBPCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperPickaxe").setTextureName(MAssetManager.getEOTexture("toolPickCopper"));
		GameRegistry.registerItem(CopperPickaxe, "toolPickCopper");
		CopperShovel = (new MItemShovel(toolMaterialCopper, toolMaterialBPCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperShovel").setTextureName(MAssetManager.getEOTexture("toolShovelCopper"));
		GameRegistry.registerItem(CopperShovel, "toolShovelCopper");
		CopperHoe = (new MItemHoe(toolMaterialCopper, toolMaterialBPCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperHoe").setTextureName(MAssetManager.getEOTexture("toolHoeCopper"));
		GameRegistry.registerItem(CopperHoe, "toolHoeCopper");
		CopperAxe = (new MItemAxe(toolMaterialCopper, toolMaterialBPCopper)).setCreativeTab(tabOresItems).setUnlocalizedName("item_CopperAxe").setTextureName(MAssetManager.getEOTexture("toolAxeCopper"));
		GameRegistry.registerItem(CopperAxe, "toolAxeCopper");
		
		BlaziumIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_BlaziumIngot").setTextureName(MAssetManager.getEOTexture("ingotBlazium"));
		GameRegistry.registerItem(BlaziumIngot, "ingotBlazium");
		BlazeShard = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_BlazeShard").setTextureName(MAssetManager.getEOTexture("dustBlazium"));
		GameRegistry.registerItem(BlazeShard, "shardBlazium");
		
		BlaziumSword = (new MItemSword(toolMaterialBlazium,toolMaterialBPBlazium, true)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireSword").setTextureName(MAssetManager.getEOTexture("weaponSwordFire"));
		GameRegistry.registerItem(BlaziumSword, "weaponSwordBlazium");
		BlaziumPickaxe = (new MItemPickaxe(toolMaterialBlazium, toolMaterialBPBlazium, true)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FirePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickFire"));
		GameRegistry.registerItem(BlaziumPickaxe, "toolPickBlazium");
		BlaziumShovel = (new MItemShovel(toolMaterialBlazium, toolMaterialBPBlazium, true)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireShovel").setTextureName(MAssetManager.getEOTexture("toolShovelFire"));
		GameRegistry.registerItem(BlaziumShovel, "toolShovelBlazium");
		BlaziumHoe = (new MItemHoe(toolMaterialBlazium, toolMaterialBPBlazium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHoe").setTextureName(MAssetManager.getEOTexture("toolHoeFire"));
		GameRegistry.registerItem(BlaziumHoe, "toolHoeBlazium");
		BlaziumAxe = (new MItemAxe(toolMaterialBlazium, toolMaterialBPBlazium, true)).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireAxe").setTextureName(MAssetManager.getEOTexture("toolAxeFire"));
		GameRegistry.registerItem(BlaziumAxe, "toolAxeBlazium");
		
		ToriteIngot = new EOItem().setUnlocalizedName("ingotTorite").setCreativeTab(tabOresItems).setTextureName(MAssetManager.getEOTexture("ingotTorite"));
		GameRegistry.registerItem(ToriteIngot, "ingotTorite");
		SunstoneDust = new EOItem().setUnlocalizedName("dustSunstone").setCreativeTab(tabOresItems).setTextureName(MAssetManager.getEOTexture("dustSunstone"));
		GameRegistry.registerItem(SunstoneDust, "dustSunstone");
		Plutonium = new EOItem().setUnlocalizedName("plutonium").setCreativeTab(tabOresItems).setTextureName(MAssetManager.getEOTexture("dustPlutonium"));
		GameRegistry.registerItem(Plutonium, "dustPlutonium");
		Uranium = new EOItem().setUnlocalizedName("uranium").setCreativeTab(tabOresItems).setTextureName(MAssetManager.getEOTexture("dustUranium"));
		GameRegistry.registerItem(Uranium, "dustUranium");
		
		BlaziumHelmet = (new MItemArmor(MaterialBlazium, MaterialBPBlazium, ExtraOres.proxy.addArmor("fire"), 0, "fire")).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmFire"));
		GameRegistry.registerItem(BlaziumHelmet, "armorHelmetBlazium");
		BlaziumChest = (new MItemArmor(MaterialBlazium, MaterialBPBlazium,ExtraOres.proxy.addArmor("fire"), 1, "fire")).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireChestplate").setTextureName(MAssetManager.getEOTexture("armorChestFire"));
		GameRegistry.registerItem(BlaziumChest, "armorChestBlazium");
		BlaziumPants = (new MItemArmor(MaterialBlazium, MaterialBPBlazium,ExtraOres.proxy.addArmor("fire"),2, "fire")).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsFire"));
		GameRegistry.registerItem(BlaziumPants, "armorPantsBlazium");
		BlaziumBoots = (new MItemArmor(MaterialBlazium, MaterialBPBlazium,ExtraOres.proxy.addArmor("fire"),3, "fire")).setCreativeTab(tabOresItems).setUnlocalizedName("item_FireBoots").setTextureName(MAssetManager.getEOTexture("armorBootsFire"));
		GameRegistry.registerItem(BlaziumBoots, "armorBootsBlazium");
		
		CoalIronIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_CoalIronIngot").setTextureName(MAssetManager.getEOTexture("ingotCoalIron"));
		GameRegistry.registerItem(CoalIronIngot, "ingotCoalIron");
		SteelIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelIngot").setTextureName(MAssetManager.getEOTexture("ingotSteel"));
		GameRegistry.registerItem(SteelIngot, "ingotSteel");
		
		SteelPickaxe = (new MItemPickaxe(toolMaterialSteel, toolMaterialBPSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelPickaxe").setTextureName(MAssetManager.getEOTexture("toolPickSteel"));
		GameRegistry.registerItem(SteelPickaxe, "toolPickSteel");
		SteelShovel = (new MItemShovel(toolMaterialSteel, toolMaterialBPSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelShovel").setTextureName(MAssetManager.getEOTexture("toolShovelSteel"));
		GameRegistry.registerItem(SteelShovel, "toolShovelSteel");
		ToriteSword = (new MItemSword(toolMaterialTorite,toolMaterialBPTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteSword").setTextureName(MAssetManager.getEOTexture("weaponSwordTorite"));
		GameRegistry.registerItem(ToriteSword, "weaponSwordTorite");
		ToritePickaxe = (new ToriteToolPickaxe(toolMaterialTorite, toolMaterialBPTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToritePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickTorite"));
		GameRegistry.registerItem(ToritePickaxe, "toolPickTorite");
		ToriteShovel = (new ToriteToolShovel(toolMaterialTorite, toolMaterialBPTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteShovel").setTextureName(MAssetManager.getEOTexture("toolShovelTorite"));
		GameRegistry.registerItem(ToriteShovel, "toolShovelTorite");
		ToriteHoe = (new MItemHoe(toolMaterialTorite, toolMaterialBPTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHoe").setTextureName(MAssetManager.getEOTexture("toolHoeTorite"));
		GameRegistry.registerItem(ToriteHoe, "toolHoeTorite");
		ToriteAxe = (new ToriteToolAxe(toolMaterialTorite, toolMaterialBPTorite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteAxe").setTextureName(MAssetManager.getEOTexture("toolAxeTorite"));
		GameRegistry.registerItem(ToriteAxe, "toolAxeTorite");
		TitaniumIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumIngot").setTextureName(MAssetManager.getEOTexture("ingotTitanium"));
		GameRegistry.registerItem(TitaniumIngot, "ingotTitanium");
		
		TitaniumSword = (new MItemSword(toolMaterialTitanium,toolMaterialBPTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumSword").setTextureName(MAssetManager.getEOTexture("weaponSwordTitanium"));
		GameRegistry.registerItem(TitaniumSword, "weaponSwordTitanium");
		TitaniumPickaxe = (new MItemPickaxe(toolMaterialTitanium, toolMaterialBPTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumPickaxe").setTextureName(MAssetManager.getEOTexture("toolPickTitanium"));
		GameRegistry.registerItem(TitaniumPickaxe, "toolPickTitanium");
		TitaniumShovel = (new MItemShovel(toolMaterialTitanium, toolMaterialBPTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumShovel").setTextureName(MAssetManager.getEOTexture("toolShovelTitanium"));
		GameRegistry.registerItem(TitaniumShovel, "toolShovelTitanium");
		TitaniumHoe = (new MItemHoe(toolMaterialTitanium, toolMaterialBPTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHoe").setTextureName(MAssetManager.getEOTexture("toolHoeTitanium"));
		GameRegistry.registerItem(TitaniumHoe, "toolHoeTitanium");
		TitaniumAxe = (new MItemAxe(toolMaterialTitanium, toolMaterialBPTitanium)).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumAxe").setTextureName(MAssetManager.getEOTexture("toolAxeTitanium"));
		GameRegistry.registerItem(TitaniumAxe, "toolAxeTitanium");
		meuroditeHelmet = (new MItemArmor(MaterialMeurodite, MaterialBPMeurodite,  ExtraOres.proxy.addArmor("Meurodite"), 0, "meurodite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmMeurodite"));
		GameRegistry.registerItem(meuroditeHelmet,"armorHelmetMeirodite");
		meuroditeChest = (new MItemArmor(MaterialMeurodite, MaterialBPMeurodite,ExtraOres.proxy.addArmor("Meurodite"), 1, "meurodite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeChestplate").setTextureName(MAssetManager.getEOTexture("armorChestMeurodite"));
		GameRegistry.registerItem(meuroditeChest, "armorChestMeurodite");
		meuroditePants = (new MItemArmor(MaterialMeurodite, MaterialBPMeurodite,ExtraOres.proxy.addArmor("Meurodite"),2, "meurodite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsMeurodite"));
		GameRegistry.registerItem(meuroditePants, "armorPantsMeurodite");
		meuroditeBoots = (new MItemArmor(MaterialMeurodite, MaterialBPMeurodite,ExtraOres.proxy.addArmor("Meurodite"),3, "meurodite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_MeuroditeBoots").setTextureName(MAssetManager.getEOTexture("armorBootsMeurodite"));
		GameRegistry.registerItem(meuroditeBoots, "armorBootsMeurodite");
		
		TitaniumHelmet = (new MItemArmor(MaterialTitanium, MaterialBPTitanium,ExtraOres.proxy.addArmor("titanium"), 0, "meurodite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmTitanium"));
		GameRegistry.registerItem(TitaniumHelmet, "armorHelmetTitanium");
		TitaniumChest = (new MItemArmor(MaterialTitanium, MaterialBPTitanium,ExtraOres.proxy.addArmor("titanium"), 1, "meurodite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumChestplate").setTextureName(MAssetManager.getEOTexture("armorChestTitanium"));
		GameRegistry.registerItem(TitaniumChest, "armorChestTitanium");
		TitaniumPants = (new MItemArmor(MaterialTitanium, MaterialBPTitanium,ExtraOres.proxy.addArmor("titanium"),2, "meurodite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsTitanium"));
		GameRegistry.registerItem(TitaniumPants, "armorPantsTitanium");
		TitaniumBoots = (new MItemArmor(MaterialTitanium, MaterialBPTitanium,ExtraOres.proxy.addArmor("titanium"),3, "meurodite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_TitaniumBoots").setTextureName(MAssetManager.getEOTexture("armorBootsTitanium"));
		GameRegistry.registerItem(TitaniumBoots, "armorBootsTitanium");
		
		ToriteHelmet = (new MItemArmor(MaterialTorite,MaterialBPTorite, ExtraOres.proxy.addArmor("torite"), 0, "torite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmTorite"));
		GameRegistry.registerItem(ToriteHelmet, "armorHelmetTorite");
		ToriteChest = (new MItemArmor(MaterialTorite, MaterialBPTorite,ExtraOres.proxy.addArmor("torite"), 1, "torite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteChestplate").setTextureName(MAssetManager.getEOTexture("armorChestTorite"));
		GameRegistry.registerItem(ToriteChest, "armorChestTorite");
		ToritePants = (new MItemArmor(MaterialTorite, MaterialBPTorite,ExtraOres.proxy.addArmor("torite"),2, "torite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsTorite"));
		GameRegistry.registerItem(ToritePants, "armorPantsTorite");
		ToriteBoots = (new MItemArmor(MaterialTorite, MaterialBPTorite,ExtraOres.proxy.addArmor("torite"),3, "torite")).setCreativeTab(tabOresItems).setUnlocalizedName("item_ToriteBoots").setTextureName(MAssetManager.getEOTexture("armorBootsTorite"));
		GameRegistry.registerItem(ToriteBoots, "armorBootsTorite");
		
		TinIngot = new EOItem().setUnlocalizedName("ingotTin").setTextureName(MAssetManager.getEOTexture("ingotTin"));
		GameRegistry.registerItem(TinIngot, "ingotTin");
		CopperIngot = new EOItem().setUnlocalizedName("ingotCopper").setTextureName(MAssetManager.getEOTexture("ingotCopper"));
		GameRegistry.registerItem(CopperIngot, "ingotCopper");
		PinkQuartz = new EOItem().setUnlocalizedName("quartzDesert").setTextureName(MAssetManager.getEOTexture("gemDesertQuartz"));
		GameRegistry.registerItem(PinkQuartz, "quartzPink");
		
		SandstonePickaxe = (new MItemPickaxe(toolMaterialSandstone, toolMaterialBPSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstonePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickSandstone"));
		GameRegistry.registerItem(SandstonePickaxe, "toolPickSandstone");
		SandstoneShovel = (new MItemShovel(toolMaterialSandstone,toolMaterialBPSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneShovel").setTextureName(MAssetManager.getEOTexture("toolShovelSandstone"));
		GameRegistry.registerItem(SandstoneShovel, "toolShovelSandstone");
		SandstoneAxe = (new MItemAxe( toolMaterialSandstone,toolMaterialBPSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneAxe").setTextureName(MAssetManager.getEOTexture("toolAxeSandstone"));
		GameRegistry.registerItem(SandstoneAxe, "toolAxeSandstone");
		SandstoneHoe = (new MItemHoe(toolMaterialSandstone,toolMaterialBPSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneHoe").setTextureName(MAssetManager.getEOTexture("toolHoeSandstone"));
		GameRegistry.registerItem(SandstoneHoe, "toolHoeSandstone");
		SandstoneSword = (new MItemSword(toolMaterialSandstone,toolMaterialBPSandstone)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SandstoneSword").setTextureName(MAssetManager.getEOTexture("weaponSwordSandstone"));
		GameRegistry.registerItem(SandstoneSword, "weaponSwordSandstone");
		SteelAxe = (new MItemAxe(toolMaterialSteel,toolMaterialBPSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelAxe").setTextureName(MAssetManager.getEOTexture("toolAxeSteel"));
		GameRegistry.registerItem(SteelAxe, "toolAxeSteel");
		SteelHoe = (new MItemHoe(toolMaterialSteel,toolMaterialBPSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelHoe").setTextureName(MAssetManager.getEOTexture("toolHoeSteel"));
		GameRegistry.registerItem(SteelHoe, "toolHoeSteel");
		SteelSword = (new MItemSword(toolMaterialSteel,toolMaterialBPSteel)).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelSword").setTextureName(MAssetManager.getEOTexture("weaponSwordSteel"));
		GameRegistry.registerItem(SteelSword, "weaponSwordSteel");
		
		SteelHelmet = (new MItemArmor(MaterialSteel, MaterialBPSteel,ExtraOres.proxy.addArmor("steel"), 0, "steel")).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmSteel"));
		GameRegistry.registerItem(SteelHelmet, "armorHelmetSteel");
		SteelChest = (new MItemArmor(MaterialSteel, MaterialBPSteel,ExtraOres.proxy.addArmor("steel"), 1, "steel")).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelChestplate").setTextureName(MAssetManager.getEOTexture("armorChestSteel"));
		GameRegistry.registerItem(SteelChest, "armorChestSteel");
		SteelPants = (new MItemArmor(MaterialSteel, MaterialBPSteel,ExtraOres.proxy.addArmor("steel"), 2, "steel")).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsSteel"));
		GameRegistry.registerItem(SteelPants, "armorPantsSteel");
		SteelBoots = (new MItemArmor(MaterialSteel, MaterialBPSteel,ExtraOres.proxy.addArmor("steel"), 3, "steel")).setCreativeTab(tabOresItems).setUnlocalizedName("item_SteelBoots").setTextureName(MAssetManager.getEOTexture("armorBootsSteel"));
		GameRegistry.registerItem(SteelBoots, "armorBootsSteel");
		
		BronzeIngot = (new EOItem()).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeIngot").setTextureName(MAssetManager.getEOTexture("ingotCopper"));
		GameRegistry.registerItem(BronzeIngot, "ingotBronze");
		BronzePickaxe = (new MItemPickaxe(toolMaterialBronze, null)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickBronze"));
		GameRegistry.registerItem(BronzePickaxe, "toolPickBronze");
		BronzeShovel = (new MItemShovel(toolMaterialBronze, null)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeShovel").setTextureName(MAssetManager.getEOTexture("toolShovelBronze"));
		GameRegistry.registerItem(BronzeShovel, "toolShovelBronze");
		BronzeAxe = (new MItemAxe(toolMaterialBronze, null)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeAxe").setTextureName(MAssetManager.getEOTexture("toolAxeBronze"));
		GameRegistry.registerItem(BronzeAxe, "toolAxeBronze");
		BronzeHoe = (new MItemHoe(toolMaterialBronze, null)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeHoe").setTextureName(MAssetManager.getEOTexture("toolHoeBronze"));
		GameRegistry.registerItem(BronzeHoe, "toolHoeBronze");
		BronzeSword = (new MItemSword(toolMaterialBronze, null)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeSword").setTextureName(MAssetManager.getEOTexture("weaponSwordBronze"));
		GameRegistry.registerItem(BronzeSword, "weaponSwordBronze");
		BronzeHelmet = (new MItemArmor(MaterialBronze, null,ExtraOres.proxy.addArmor("bronze"), 0, "bronze")).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeHelmet").setTextureName(MAssetManager.getEOTexture("armorHelmBronze"));
		GameRegistry.registerItem(BronzeHelmet, "armorHelmetBronze");
		BronzeChest = (new MItemArmor(MaterialBronze, null,ExtraOres.proxy.addArmor("bronze"), 1, "bronze")).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeChestplate").setTextureName(MAssetManager.getEOTexture("armorChestBronze"));
		GameRegistry.registerItem(BronzeChest, "armorChestBronze");
		BronzePants = (new MItemArmor(MaterialBronze, null,ExtraOres.proxy.addArmor("bronze"),2, "bronze")).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeLeggings").setTextureName(MAssetManager.getEOTexture("armorLegsBronze"));
		GameRegistry.registerItem(BronzePants, "armorPantsBronze");
		BronzeBoots = (new MItemArmor(MaterialBronze, null,ExtraOres.proxy.addArmor("bronze"),3, "bronze")).setCreativeTab(tabOresItems).setUnlocalizedName("item_BronzeBoots").setTextureName(MAssetManager.getEOTexture("armorBootsBronze"));
		GameRegistry.registerItem(BronzeBoots, "armorBootsBronze");
		
		BedrockPickaxe = (new MItemPickaxe(toolMaterialBedrock, toolMaterialBPBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockPickaxe").setTextureName(MAssetManager.getEOTexture("toolPickBedrock"));
		GameRegistry.registerItem(BedrockPickaxe, "toolPickBedrock");
		BedrockAxe = (new MItemAxe( toolMaterialBedrock,toolMaterialBPBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockAxe").setTextureName(MAssetManager.getEOTexture("toolAxeBedrock"));
		GameRegistry.registerItem(BedrockAxe, "toolAxeBedrock");
		BedrockShovel = (new MItemShovel(toolMaterialBedrock,toolMaterialBPBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockShovel").setTextureName(MAssetManager.getEOTexture("toolShovelBedrock"));
		GameRegistry.registerItem(BedrockShovel, "toolShovelBedrock");
		BedrockHoe = (new MItemHoe(toolMaterialBedrock,toolMaterialBPBedrock)).setCreativeTab(tabOresItems).setUnlocalizedName("item_BedrockHoe").setTextureName(MAssetManager.getEOTexture("toolHoeBedrock"));
		GameRegistry.registerItem(BedrockHoe, "toolHoeBedrock");

		GranitePickaxe = (new MItemPickaxe(toolMaterialGranite, toolMaterialBPGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GranitePickaxe").setTextureName(MAssetManager.getEOTexture("toolPickGranite"));
		GameRegistry.registerItem(GranitePickaxe, "toolPickGranite");
		GraniteAxe = (new MItemAxe( toolMaterialGranite,toolMaterialBPGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteAxe").setTextureName(MAssetManager.getEOTexture("toolAxeGranite"));
		GameRegistry.registerItem(GraniteAxe, "toolAxeGranite");
		GraniteShovel = (new MItemShovel(toolMaterialGranite,toolMaterialBPGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteShovel").setTextureName(MAssetManager.getEOTexture("toolShovelGranite"));
		GameRegistry.registerItem(GraniteShovel, "toolShovelGranite");
		GraniteHoe = (new MItemHoe(toolMaterialGranite,toolMaterialBPGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteHoe").setTextureName(MAssetManager.getEOTexture("toolHoeGranite"));
		GameRegistry.registerItem(GraniteHoe, "toolHoeGranite");
		GraniteSword = (new MItemSword(toolMaterialGranite, toolMaterialBPGranite)).setCreativeTab(tabOresItems).setUnlocalizedName("item_GraniteSword").setTextureName(MAssetManager.getEOTexture("weaponSwordGranite"));
		GameRegistry.registerItem(GraniteSword, "weaponSwordGranite");

		grenade = (new ItemGrenade()).setUnlocalizedName("grenade").setTextureName(MAssetManager.getEOTexture("grenadeNuke"));
		GameRegistry.registerItem(grenade, "grenadeNuke");
		grenadeImpact = (new ItemGrenadeImpact()).setUnlocalizedName("grenadeImpact").setTextureName(MAssetManager.getEOTexture("grenadeNuke"));
		GameRegistry.registerItem(grenadeImpact, "grenadeImpact");
		grenadeSticky = (new ItemGrenadeSticky()).setUnlocalizedName("grenadeSticky").setTextureName(MAssetManager.getEOTexture("grenadeNuke"));		
		GameRegistry.registerItem(grenadeSticky, "grenadeSticky");

		//bucketMagma = new EOItemBucket(EOConfig.bucketMagmaId, ExtraOres.eoFluid.getBlockID()).setUnlocalizedName("item_MagmaBucket");
		
		steelKey = new ItemKey().setUnlocalizedName("item_SteelKey").setCreativeTab(tabOresItems).setTextureName(MAssetManager.getEOTexture("utilitySteelKey"));
		GameRegistry.registerItem(steelKey, "keySteel");
		steelLock = new ItemLock().setUnlocalizedName("item_SteelLock").setCreativeTab(tabOresItems).setTextureName(MAssetManager.getEOTexture("utilitySteelLock"));
		GameRegistry.registerItem(steelLock, "mlockSteel");
		
		plateTinItem = new ItemReed(EOBlocks.TinPlate).setCreativeTab(tabOresItems).setUnlocalizedName("plateTinItem").setTextureName(MAssetManager.getEOTexture("platingTin"));
		GameRegistry.registerItem(plateTinItem, "plateTinItem");
		plateBronzeItem = new ItemReed(EOBlocks.BronzePlate).setCreativeTab(tabOresItems).setUnlocalizedName("plateBronzeItem").setTextureName(MAssetManager.getEOTexture("platingBronze"));
		GameRegistry.registerItem(plateBronzeItem, "plateBronzeItem");
		plateSteelItem = new ItemReed(EOBlocks.SteelPlate).setCreativeTab(tabOresItems).setUnlocalizedName("plateSteelItem").setTextureName(MAssetManager.getEOTexture("platingSteel"));
		GameRegistry.registerItem(plateSteelItem, "plateSteelItem");
		plateMeuroditeItem = new ItemReed(EOBlocks.meuroditePlate).setCreativeTab(tabOresItems).setUnlocalizedName("plateMeuroditeItem").setTextureName(MAssetManager.getEOTexture("platingMeurodite"));
		GameRegistry.registerItem(plateMeuroditeItem, "plateMeuroditeItem");
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
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(EOBlocks.SoulGem),1,3,12));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(PinkQuartz),1,10,25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(EOBlocks.RadiantQuartz),1,3,10));
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
		Blocks.bedrock.setHarvestLevel("pickaxe", 4);
		EOBlocks.soulBlock.setHarvestLevel("pickaxe", 4);
	}
}
