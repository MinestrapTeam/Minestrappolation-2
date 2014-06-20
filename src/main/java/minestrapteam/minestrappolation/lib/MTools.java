package minestrapteam.minestrappolation.lib;

import clashsoft.cslib.minecraft.item.CSItems;
import minestrapteam.minestrap_core.item.*;
import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.common.MCommonProxy;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MTools
{
	static ArmorMaterial		armorMeurodite		= EnumHelper.addArmorMaterial("meurodite", 18, new int[] { 2, 7, 6, 2 }, 15);
	static ArmorMaterial		armorTitanium		= EnumHelper.addArmorMaterial("titanium", 66, new int[] { 4, 10, 8, 5 }, 11);
	static ArmorMaterial		armorTorite			= EnumHelper.addArmorMaterial("torite", 17, new int[] { 2, 8, 6, 2 }, 20);
	static ArmorMaterial		armorBlazium			= EnumHelper.addArmorMaterial("blazium", 25, new int[] { 3, 7, 6, 3 }, 18);
	static ArmorMaterial		armorTin				= EnumHelper.addArmorMaterial("tin", 5, new int[] { 2, 4, 3, 2 }, 5);
	static ArmorMaterial		armorBronze			= EnumHelper.addArmorMaterial("bronze", 30, new int[] { 3, 7, 5, 2 }, 8);
	static ArmorMaterial		armorSteel			= EnumHelper.addArmorMaterial("steel", 17, new int[] { 3, 8, 6, 3 }, 15);
	
	public static ToolMaterial	toolMeurodite	= EnumHelper.addToolMaterial("ToolMeurodite", 2, 805, 7.0F, 2, 15);
	public static ToolMaterial	toolTitanium	= EnumHelper.addToolMaterial("ToolTitanium", 4, 2999, 10.0F, 5, 10);
	public static ToolMaterial	toolTorite		= EnumHelper.addToolMaterial("ToolTorite", 2, 699, 6.0F, 3, 20);
	public static ToolMaterial	toolBlazium		= EnumHelper.addToolMaterial("ToolBlazium", 2, 799, 8.0F, 3, 18);
	public static ToolMaterial	toolCopper		= EnumHelper.addToolMaterial("ToolCopper", 1, 139, 5.0F, 2, 10);
	public static ToolMaterial	toolSandstone	= EnumHelper.addToolMaterial("ToolSandstone", 1, 111, 4.5F, 2, 6);
	public static ToolMaterial	toolBronze		= EnumHelper.addToolMaterial("ToolBronze", 2, 1501, 6.5F, 2, 8);
	public static ToolMaterial	toolSteel		= EnumHelper.addToolMaterial("ToolSteel", 2, 300, 7.5F, 3, 15);
	public static ToolMaterial	toolBedrock		= EnumHelper.addToolMaterial("ToolBedrock", 5, 6247, 7F, 2, 5);
	public static ToolMaterial	toolGranite		= EnumHelper.addToolMaterial("ToolGranite", 1, 199, 4.3F, 2, 4);
	
	public static Item			meuroditeSword;
	public static Item			meuroditeShovel;
	public static Item			meuroditePickaxe;
	public static Item			meuroditeAxe;
	public static Item			meuroditeHoe;
	public static Item			meuroditeHelmet;
	public static Item			meuroditeChestplate;
	public static Item			meuroditeLeggings;
	public static Item			meuroditeBoots;
	
	public static Item			titaniumSword;
	public static Item			titaniumShovel;
	public static Item			titaniumPickaxe;
	public static Item			titaniumAxe;
	public static Item			titaniumHoe;
	public static Item			titaniumHelmet;
	public static Item			titaniumChestplate;
	public static Item			titaniumLeggings;
	public static Item			titaniumBoots;
	
	public static Item			toriteSword;
	public static Item			toriteShovel;
	public static Item			toritePickaxe;
	public static Item			toriteAxe;
	public static Item			toriteHoe;
	public static Item			toriteHelmet;
	public static Item			toriteChestplate;
	public static Item			toriteLeggings;
	public static Item			toriteBoots;
	
	public static Item			blaziumSword;
	public static Item			blaziumShovel;
	public static Item			blaziumPickaxe;
	public static Item			blaziumAxe;
	public static Item			blaziumHoe;
	public static Item			blaziumHelmet;
	public static Item			blaziumChestplate;
	public static Item			blaziumLeggings;
	public static Item			blaziumBoots;
	
	public static Item			copperSword;
	public static Item			copperShovel;
	public static Item			copperPickaxe;
	public static Item			copperAxe;
	public static Item			copperHoe;
	public static Item			tinHelmet;
	public static Item			tinChestplate;
	public static Item			tinLeggings;
	public static Item			tinBoots;
	
	public static Item			bronzeShovel;
	public static Item			bronzePickaxe;
	public static Item			bronzeAxe;
	public static Item			bronzeHoe;
	public static Item			bronzeSword;
	public static Item			bronzeHelmet;
	public static Item			bronzeChestplate;
	public static Item			bronzeLeggings;
	public static Item			bronzeBoots;
	
	public static Item			steelSword;
	public static Item			steelShovel;
	public static Item			steelPickaxe;
	public static Item			steelAxe;
	public static Item			steelHoe;
	public static Item			steelHelmet;
	public static Item			steelChestplate;
	public static Item			steelLeggings;
	public static Item			steelBoots;
	
	public static Item			bedrockShovel;
	public static Item			bedrockPickaxe;
	public static Item			bedrockAxe;
	public static Item			bedrockHoe;
	
	public static Item			sandstoneSword;
	public static Item			sandstoneShovel;
	public static Item			sandstonePickaxe;
	public static Item			sandstoneAxe;
	public static Item			sandstoneHoe;
	
	public static Item			graniteSword;
	public static Item			graniteShovel;
	public static Item			granitePickaxe;
	public static Item			graniteAxe;
	public static Item			graniteHoe;
	
	public static void init()
	{
		meuroditeSword = new MCItemSword(toolMeurodite).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getWeaponTexture("meurodite_sword"));
		meuroditeShovel = new MCItemShovel(toolMeurodite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("meurodite_shovel"));
		meuroditePickaxe = new MCItemPickaxe(toolMeurodite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("meurodite_pickaxe"));
		meuroditeAxe = new MCItemAxe(toolMeurodite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("meurodite_axe"));
		meuroditeHoe = new MCItemHoe(toolMeurodite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("meurodite_hoe"));
		meuroditeHelmet = new MCItemArmor(armorMeurodite, MCommonProxy.meurodite, 0, "meurodite").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("meurodite_helmet"));
		meuroditeChestplate = new MCItemArmor(armorMeurodite, MCommonProxy.meurodite, 1, "meurodite").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("meurodite_chestplate"));
		meuroditeLeggings = new MCItemArmor(armorMeurodite, MCommonProxy.meurodite, 2, "meurodite").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("meurodite_leggings"));
		meuroditeBoots = new MCItemArmor(armorMeurodite, MCommonProxy.meurodite, 3, "meurodite").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("meurodite_boots"));
		
		titaniumSword = new MCItemSword(toolTitanium).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getWeaponTexture("titanium_sword"));
		titaniumShovel = new MCItemShovel(toolTitanium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("titanium_shovel"));
		titaniumPickaxe = new MCItemPickaxe(toolTitanium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("titanium_pickaxe"));
		titaniumAxe = new MCItemAxe(toolTitanium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("titanium_axe"));
		titaniumHoe = new MCItemHoe(toolTitanium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("titanium_hoe"));
		titaniumHelmet = new MCItemArmor(armorTitanium, MCommonProxy.titanium, 0, "titanium").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("titanium_helmet"));
		titaniumChestplate = new MCItemArmor(armorTitanium, MCommonProxy.titanium, 1, "titanium").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("titanium_chestplate"));
		titaniumLeggings = new MCItemArmor(armorTitanium, MCommonProxy.titanium, 2, "titanium").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("titanium_leggings"));
		titaniumBoots = new MCItemArmor(armorTitanium, MCommonProxy.titanium, 3, "titanium").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("titanium_boots"));
		
		toriteSword = new MCItemSword(toolTorite).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getWeaponTexture("torite_sword"));
		toriteShovel = new MCItemShovel(toolTorite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("torite_shovel"));
		toritePickaxe = new MCItemPickaxe(toolTorite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("torite_pickaxe"));
		toriteAxe = new MCItemAxe(toolTorite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("torite_axe"));
		toriteHoe = new MCItemHoe(toolTorite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("torite_hoe"));
		toriteHelmet = new MCItemArmor(armorTorite, MCommonProxy.torite, 0, "torite").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("torite_helmet"));
		toriteChestplate = new MCItemArmor(armorTorite, MCommonProxy.torite, 1, "torite").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("torite_chestplate"));
		toriteLeggings = new MCItemArmor(armorTorite, MCommonProxy.torite, 2, "torite").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("torite_leggings"));
		toriteBoots = new MCItemArmor(armorTorite, MCommonProxy.torite, 3, "torite").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("torite_boots"));
		
		blaziumSword = new MCItemSword(toolBlazium).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getWeaponTexture("fire_sword"));
		blaziumShovel = new MCItemShovel(toolBlazium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("fire_shovel"));
		blaziumPickaxe = new MCItemPickaxe(toolBlazium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("fire_pickaxe"));
		blaziumAxe = new MCItemAxe(toolBlazium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("fire_axe"));
		blaziumHoe = new MCItemHoe(toolBlazium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("fire_hoe"));
		blaziumHelmet = new MCItemArmor(armorBlazium, MCommonProxy.fire, 0, "fire").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("fire_helmet"));
		blaziumChestplate = new MCItemArmor(armorBlazium, MCommonProxy.fire, 1, "fire").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("fire_chestplate"));
		blaziumLeggings = new MCItemArmor(armorBlazium, MCommonProxy.fire, 2, "fire").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("fire_leggings"));
		blaziumBoots = new MCItemArmor(armorBlazium, MCommonProxy.fire, 3, "fire").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("fire_boots"));
		
		copperSword = new MCItemSword(toolCopper).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getWeaponTexture("copper_sword"));
		copperShovel = new MCItemShovel(toolCopper).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("copper_shovel"));
		copperPickaxe = new MCItemPickaxe(toolCopper).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("copper_pickaxe"));
		copperAxe = new MCItemAxe(toolCopper).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("copper_axe"));
		copperHoe = new MCItemHoe(toolCopper).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("copper_hoe"));
		tinHelmet = new MCItemArmor(armorTin, MCommonProxy.tin, 0, "tin").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("tin_helmet"));
		tinChestplate = new MCItemArmor(armorTin, MCommonProxy.tin, 1, "tin").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("tin_chesplate"));
		tinLeggings = new MCItemArmor(armorTin, MCommonProxy.tin, 2, "tin").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("tin_leggings"));
		tinBoots = new MCItemArmor(armorTin, MCommonProxy.tin, 3, "tin").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("tin_boots"));
		
		bronzeSword = new MCItemSword(toolBronze).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getWeaponTexture("bronze_sword"));
		bronzeShovel = new MCItemShovel(toolBronze).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("bronze_shovel"));
		bronzePickaxe = new MCItemPickaxe(toolBronze).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("bronze_pickaxe"));
		bronzeAxe = new MCItemAxe(toolBronze).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("bronze_axe"));
		bronzeHoe = new MCItemHoe(toolBronze).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("bronze_hoe"));
		bronzeHelmet = new MCItemArmor(armorBronze, MCommonProxy.bronze, 0, "bronze").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("bronze_helmet"));
		bronzeChestplate = new MCItemArmor(armorBronze, MCommonProxy.bronze, 1, "bronze").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("bronze_chesplate"));
		bronzeLeggings = new MCItemArmor(armorBronze, MCommonProxy.bronze, 2, "bronze").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("bronze_leggings"));
		bronzeBoots = new MCItemArmor(armorBronze, MCommonProxy.bronze, 3, "bronze").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("bronze_boots"));
		
		steelSword = new MCItemSword(toolSteel).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getWeaponTexture("steel_sword"));
		steelShovel = new MCItemShovel(toolSteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("steel_shovel"));
		steelPickaxe = new MCItemPickaxe(toolSteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("steel_pickaxe"));
		steelAxe = new MCItemAxe(toolSteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("steel_axe"));
		steelHoe = new MCItemHoe(toolSteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("steel_hoe"));
		steelHelmet = new MCItemArmor(armorSteel, MCommonProxy.steel, 0, "steel").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("steel_helmet"));
		steelChestplate = new MCItemArmor(armorSteel, MCommonProxy.steel, 1, "steel").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("steel_chestplate"));
		steelLeggings = new MCItemArmor(armorSteel, MCommonProxy.steel, 2, "steel").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("steel_leggings"));
		steelBoots = new MCItemArmor(armorSteel, MCommonProxy.steel, 3, "steel").setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getArmorTexture("steel_boots"));
		
		sandstoneSword = new MCItemSword(toolSandstone).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getWeaponTexture("sandstone_sword"));
		sandstoneShovel = new MCItemShovel(toolSandstone).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("sandstone_shovel"));
		sandstonePickaxe = new MCItemPickaxe(toolSandstone).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("sandstone_pickaxe"));
		sandstoneAxe = new MCItemAxe(toolSandstone).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("sandstone_axe"));
		sandstoneHoe = new MCItemHoe(toolSandstone).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("sandstone_hoe"));
		
		bedrockShovel = new MCItemShovel(toolBedrock).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("bedrock_shovel"));
		bedrockPickaxe = new MCItemPickaxe(toolBedrock).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("bedrock_pickaxe"));
		bedrockAxe = new MCItemAxe(toolBedrock).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("bedrock_axe"));
		bedrockHoe = new MCItemHoe(toolBedrock).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("bedrock_hoe"));
		
		graniteSword = new MCItemSword(toolGranite).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MCAssetManager.getWeaponTexture("granite_sword"));
		graniteShovel = new MCItemShovel(toolGranite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("granite_shovel"));
		granitePickaxe = new MCItemPickaxe(toolGranite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("granite_pickaxe"));
		graniteAxe = new MCItemAxe(toolGranite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("granite_axe"));
		graniteHoe = new MCItemHoe(toolGranite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MCAssetManager.getToolTexture("granite_hoe"));
	}
	
	public static void load()
	{
		CSItems.addItem(meuroditeSword, "meurodite_sword");
		CSItems.addItem(meuroditeShovel, "meurodite_shovel");
		CSItems.addItem(meuroditePickaxe, "meurodite_pickaxe");
		CSItems.addItem(meuroditeAxe, "meurodite_axe");
		CSItems.addItem(meuroditeHoe, "meurodite_hoe");
		CSItems.addItem(meuroditeHelmet, "meurodite_helmet");
		CSItems.addItem(meuroditeChestplate, "meurodite_chestplate");
		CSItems.addItem(meuroditeLeggings, "meurodite_leggings");
		CSItems.addItem(meuroditeBoots, "meurodite_boots");
		
		CSItems.addItem(titaniumSword, "titanium_sword");
		CSItems.addItem(titaniumShovel, "titanium_shovel");
		CSItems.addItem(titaniumPickaxe, "titanium_pickaxe");
		CSItems.addItem(titaniumAxe, "titanium_axe");
		CSItems.addItem(titaniumHoe, "titanium_hoe");
		CSItems.addItem(titaniumHelmet, "titanium_helmet");
		CSItems.addItem(titaniumChestplate, "titanium_chestplate");
		CSItems.addItem(titaniumLeggings, "titanium_leggings");
		CSItems.addItem(titaniumBoots, "titanium_boots");
		
		CSItems.addItem(toriteSword, "torite_sword");
		CSItems.addItem(toriteShovel, "torite_shovel");
		CSItems.addItem(toritePickaxe, "torite_pickaxe");
		CSItems.addItem(toriteAxe, "torite_axe");
		CSItems.addItem(toriteHoe, "torite_hoe");
		CSItems.addItem(toriteHelmet, "torite_helmet");
		CSItems.addItem(toriteChestplate, "torite_chestplate");
		CSItems.addItem(toriteLeggings, "torite_leggings");
		CSItems.addItem(toriteBoots, "torite_boots");
		
		CSItems.addItem(blaziumSword, "blazium_sword");
		CSItems.addItem(blaziumShovel, "blazium_shovel");
		CSItems.addItem(blaziumPickaxe, "blazium_pickaxe");
		CSItems.addItem(blaziumAxe, "blazium_axe");
		CSItems.addItem(blaziumHoe, "blazium_hoe");
		CSItems.addItem(blaziumHelmet, "blazium_helmet");
		CSItems.addItem(blaziumChestplate, "blazium_chestplate");
		CSItems.addItem(blaziumLeggings, "blazium_leggings");
		CSItems.addItem(blaziumBoots, "blazium_boots");
		
		CSItems.addItem(copperSword, "copper_sword");
		CSItems.addItem(copperShovel, "copper_shovel");
		CSItems.addItem(copperPickaxe, "copper_pickaxe");
		CSItems.addItem(copperAxe, "copper_axe");
		CSItems.addItem(copperHoe, "copper_hoe");
		CSItems.addItem(tinHelmet, "tin_helmet");
		CSItems.addItem(tinChestplate, "tin_chestplate");
		CSItems.addItem(tinLeggings, "tin_leggings");
		CSItems.addItem(tinBoots, "tin_boots");
		
		CSItems.addItem(bronzeSword, "bronze_sword");
		CSItems.addItem(bronzeShovel, "bronze_shovel");
		CSItems.addItem(bronzePickaxe, "bronze_pickaxe");
		CSItems.addItem(bronzeAxe, "bronze_axe");
		CSItems.addItem(bronzeHoe, "bronze_hoe");
		CSItems.addItem(bronzeHelmet, "bronze_helmet");
		CSItems.addItem(bronzeChestplate, "bronze_chestplate");
		CSItems.addItem(bronzeLeggings, "bronze_leggings");
		CSItems.addItem(bronzeBoots, "bronze_boots");
		
		CSItems.addItem(steelSword, "steel_sword");
		CSItems.addItem(steelShovel, "steel_shovel");
		CSItems.addItem(steelPickaxe, "steel_pickaxe");
		CSItems.addItem(steelAxe, "steel_axe");
		CSItems.addItem(steelHoe, "steel_hoe");
		CSItems.addItem(steelHelmet, "steel_helmet");
		CSItems.addItem(steelChestplate, "steel_chestplate");
		CSItems.addItem(steelLeggings, "steel_leggings");
		CSItems.addItem(steelBoots, "steel_boots");
		
		CSItems.addItem(bedrockShovel, "bedrock_shovel");
		CSItems.addItem(bedrockPickaxe, "bedrock_pickaxe");
		CSItems.addItem(bedrockAxe, "bedrock_axe");
		CSItems.addItem(bedrockHoe, "bedrock_hoe");
		
		CSItems.addItem(sandstoneSword, "sandstone_sword");
		CSItems.addItem(sandstoneShovel, "sandstone_shovel");
		CSItems.addItem(sandstonePickaxe, "sandstone_pickaxe");
		CSItems.addItem(sandstoneAxe, "sandstone_axe");
		CSItems.addItem(sandstoneHoe, "sandstone_hoe");
		
		CSItems.addItem(graniteSword, "granite_sword");
		CSItems.addItem(graniteShovel, "granite_shovel");
		CSItems.addItem(granitePickaxe, "granite_pickaxe");
		CSItems.addItem(graniteAxe, "granite_axe");
		CSItems.addItem(graniteHoe, "granite_hoe");
	}
}
