package minestrapteam.minestrappolation.lib;

import static minestrapteam.minestrappolation.lib.MItems.*;
import clashsoft.cslib.minecraft.item.CSItems;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.common.MCommonProxy;
import minestrapteam.minestrappolation.item.*;
import minestrapteam.minestrappolation.item.tool.*;
import minestrapteam.minestrappolation.util.MAssetManager;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MTools
{
	static ArmorMaterial		armorMeurodite	= EnumHelper.addArmorMaterial("Meurodite", 18, new int[] { 2, 7, 6, 2 }, 15);
	static ArmorMaterial		armorTitanium	= EnumHelper.addArmorMaterial("Titanium", 66, new int[] { 4, 10, 8, 5 }, 11);
	static ArmorMaterial		armorTorite		= EnumHelper.addArmorMaterial("Torite", 17, new int[] { 2, 8, 6, 2 }, 20);
	static ArmorMaterial		armorBlazium	= EnumHelper.addArmorMaterial("Blazium", 25, new int[] { 3, 7, 6, 3 }, 18);
	static ArmorMaterial		armorTin		= EnumHelper.addArmorMaterial("Tin", 5, new int[] { 2, 4, 3, 2 }, 5);
	static ArmorMaterial		armorBronze		= EnumHelper.addArmorMaterial("Bronze", 30, new int[] { 3, 7, 5, 2 }, 8);
	static ArmorMaterial		armorSteel		= EnumHelper.addArmorMaterial("Steel", 17, new int[] { 3, 8, 6, 3 }, 15);
	
	public static ToolMaterial	toolMeurodite	= EnumHelper.addToolMaterial("Meurodite", 3, 805, 7.0F, 2, 15);
	public static ToolMaterial	toolTitanium	= EnumHelper.addToolMaterial("Titanium", 5, 2999, 10.0F, 5, 10);
	public static ToolMaterial	toolTorite		= EnumHelper.addToolMaterial("Torite", 3, 699, 6.0F, 3, 20);
	public static ToolMaterial	toolBlazium		= EnumHelper.addToolMaterial("Blazium", 3, 799, 8.0F, 3, 18);
	public static ToolMaterial	toolCopper		= EnumHelper.addToolMaterial("Copper", 1, 139, 5.0F, 2, 10);
	public static ToolMaterial	toolSandstone	= EnumHelper.addToolMaterial("Sandstone", 1, 111, 4.5F, 2, 6);
	public static ToolMaterial	toolBronze		= EnumHelper.addToolMaterial("Bronze", 2, 1501, 6.5F, 2, 8);
	public static ToolMaterial	toolSteel		= EnumHelper.addToolMaterial("Steel", 2, 300, 7.5F, 3, 15);
	public static ToolMaterial	toolBedrock		= EnumHelper.addToolMaterial("Bedrock", 5, 6247, 7F, 2, 5);
	public static ToolMaterial	toolGranite		= EnumHelper.addToolMaterial("Granite", 1, 199, 4.3F, 2, 4);
	public static ToolMaterial	toolSoulsteel	= EnumHelper.addToolMaterial("Soul-Steel", 2, 300, 7.5F, 3, 26);
	public static ToolMaterial	toolUnholy		= EnumHelper.addToolMaterial("Unholy", 3, 1100, 8.0F, 4.0F, 13);
	
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
	
	public static Item			soulsteelSword;
	public static Item			soulsteelShovel;
	public static Item			soulsteelPickaxe;
	public static Item			soulsteelAxe;
	public static Item			soulsteelHoe;
	
	public static Item			unholySword;
	public static Item			unholyShovel;
	public static Item			unholyPickaxe;
	public static Item			unholyAxe;
	public static Item			unholyHoe;
	
	public static void init()
	{
		CSItems.replaceItem(Items.wooden_sword, new MItemSword(ToolMaterial.WOOD).setUnlocalizedName("swordWood").setTextureName("wood_sword"));
		CSItems.replaceItem(Items.wooden_shovel, new MItemShovel(ToolMaterial.WOOD).setUnlocalizedName("shovelWood").setTextureName("wood_shovel"));
		CSItems.replaceItem(Items.wooden_pickaxe, new MItemPickaxe(ToolMaterial.WOOD).setUnlocalizedName("pickaxeWood").setTextureName("wood_pickaxe"));
		CSItems.replaceItem(Items.wooden_axe, new MItemAxe(ToolMaterial.WOOD).setUnlocalizedName("hatchetWood").setTextureName("wood_axe"));
		CSItems.replaceItem(Items.wooden_hoe, new MItemHoe(ToolMaterial.WOOD).setUnlocalizedName("hoeWood").setTextureName("wood_hoe"));
		
		CSItems.replaceItem(Items.stone_sword, new MItemSword(ToolMaterial.STONE).setUnlocalizedName("swordStone").setTextureName("stone_sword"));
		CSItems.replaceItem(Items.stone_shovel, new MItemShovel(ToolMaterial.STONE).setUnlocalizedName("shovelStone").setTextureName("stone_shovel"));
		CSItems.replaceItem(Items.stone_pickaxe, new MItemPickaxe(ToolMaterial.STONE).setUnlocalizedName("pickaxeStone").setTextureName("stone_pickaxe"));
		CSItems.replaceItem(Items.stone_axe, new MItemAxe(ToolMaterial.STONE).setUnlocalizedName("hatchetStone").setTextureName("stone_axe"));
		CSItems.replaceItem(Items.stone_hoe, new MItemHoe(ToolMaterial.STONE).setUnlocalizedName("hoeStone").setTextureName("stone_hoe"));
		
		CSItems.replaceItem(Items.iron_sword, new MItemSword(ToolMaterial.IRON).setUnlocalizedName("swordIron").setTextureName("iron_sword"));
		CSItems.replaceItem(Items.iron_shovel, new MItemShovel(ToolMaterial.IRON).setUnlocalizedName("shovelIron").setTextureName("iron_shovel"));
		CSItems.replaceItem(Items.iron_pickaxe, new MItemPickaxe(ToolMaterial.IRON).setUnlocalizedName("pickaxeIron").setTextureName("iron_pickaxe"));
		CSItems.replaceItem(Items.iron_axe, new MItemAxe(ToolMaterial.IRON).setUnlocalizedName("hatchetIron").setTextureName("iron_axe"));
		CSItems.replaceItem(Items.iron_hoe, new MItemHoe(ToolMaterial.IRON).setUnlocalizedName("hoeIron").setTextureName("iron_hoe"));
		
		CSItems.replaceItem(Items.golden_sword, new MItemSword(ToolMaterial.GOLD).setUnlocalizedName("swordGold").setTextureName("gold_sword"));
		CSItems.replaceItem(Items.golden_shovel, new MItemShovel(ToolMaterial.GOLD).setUnlocalizedName("shovelGold").setTextureName("gold_shovel"));
		CSItems.replaceItem(Items.golden_pickaxe, new MItemPickaxe(ToolMaterial.GOLD).setUnlocalizedName("pickaxeGold").setTextureName("gold_pickaxe"));
		CSItems.replaceItem(Items.golden_axe, new MItemAxe(ToolMaterial.GOLD).setUnlocalizedName("hatchetGold").setTextureName("gold_axe"));
		CSItems.replaceItem(Items.golden_hoe, new MItemHoe(ToolMaterial.GOLD).setUnlocalizedName("hoeGold").setTextureName("gold_hoe"));
		
		CSItems.replaceItem(Items.diamond_sword, new MItemSword(ToolMaterial.EMERALD).setUnlocalizedName("swordDiamond").setTextureName("diamond_sword"));
		CSItems.replaceItem(Items.diamond_shovel, new MItemShovel(ToolMaterial.EMERALD).setUnlocalizedName("shovelDiamond").setTextureName("diamond_shovel"));
		CSItems.replaceItem(Items.diamond_pickaxe, new MItemPickaxe(ToolMaterial.EMERALD).setUnlocalizedName("pickaxeDiamond").setTextureName("diamond_pickaxe"));
		CSItems.replaceItem(Items.diamond_axe, new MItemAxe(ToolMaterial.EMERALD).setUnlocalizedName("hatchetDiamond").setTextureName("diamond_axe"));
		CSItems.replaceItem(Items.diamond_hoe, new MItemHoe(ToolMaterial.EMERALD).setUnlocalizedName("hoeDiamond").setTextureName("diamond_hoe"));
		
		meuroditeSword = new MItemSword(toolMeurodite).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("meurodite_sword"));
		meuroditeShovel = new MItemShovel(toolMeurodite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("meurodite_shovel"));
		meuroditePickaxe = new MItemPickaxe(toolMeurodite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("meurodite_pickaxe"));
		meuroditeAxe = new MItemAxe(toolMeurodite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("meurodite_axe"));
		meuroditeHoe = new MItemHoe(toolMeurodite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("meurodite_hoe"));
		meuroditeHelmet = new MItemArmor(armorMeurodite, MCommonProxy.meurodite, 0).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("meurodite_helmet"));
		meuroditeChestplate = new MItemArmor(armorMeurodite, MCommonProxy.meurodite, 1).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("meurodite_chestplate"));
		meuroditeLeggings = new MItemArmor(armorMeurodite, MCommonProxy.meurodite, 2).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("meurodite_leggings"));
		meuroditeBoots = new MItemArmor(armorMeurodite, MCommonProxy.meurodite, 3).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("meurodite_boots"));
		
		titaniumSword = new MItemSword(toolTitanium).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("titanium_sword"));
		titaniumShovel = new MItemShovel(toolTitanium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("titanium_shovel"));
		titaniumPickaxe = new MItemPickaxe(toolTitanium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("titanium_pickaxe"));
		titaniumAxe = new MItemAxe(toolTitanium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("titanium_axe"));
		titaniumHoe = new MItemHoe(toolTitanium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("titanium_hoe"));
		titaniumHelmet = new MItemArmor(armorTitanium, MCommonProxy.titanium, 0).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("titanium_helmet"));
		titaniumChestplate = new MItemArmor(armorTitanium, MCommonProxy.titanium, 1).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("titanium_chestplate"));
		titaniumLeggings = new MItemArmor(armorTitanium, MCommonProxy.titanium, 2).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("titanium_leggings"));
		titaniumBoots = new MItemArmor(armorTitanium, MCommonProxy.titanium, 3).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("titanium_boots"));
		
		toriteSword = new MItemSword(toolTorite).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("torite_sword"));
		toriteShovel = new MItemShovel(toolTorite).setWeapon().setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("torite_shovel"));
		toritePickaxe = new MItemPickaxe(toolTorite).setWeapon().setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("torite_pickaxe"));
		toriteAxe = new MItemAxe(toolTorite).setWeapon().setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("torite_axe"));
		toriteHoe = new MItemHoe(toolTorite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("torite_hoe"));
		toriteHelmet = new MItemArmor(armorTorite, MCommonProxy.torite, 0).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("torite_helmet"));
		toriteChestplate = new MItemArmor(armorTorite, MCommonProxy.torite, 1).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("torite_chestplate"));
		toriteLeggings = new MItemArmor(armorTorite, MCommonProxy.torite, 2).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("torite_leggings"));
		toriteBoots = new MItemArmor(armorTorite, MCommonProxy.torite, 3).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("torite_boots"));
		
		blaziumSword = new MItemSword(toolBlazium, true).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("fire_sword"));
		blaziumShovel = new MItemShovel(toolBlazium, true).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("fire_shovel"));
		blaziumPickaxe = new MItemPickaxe(toolBlazium, true).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("fire_pickaxe"));
		blaziumAxe = new MItemAxe(toolBlazium, true).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("fire_axe"));
		blaziumHoe = new MItemHoe(toolBlazium).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("fire_hoe"));
		blaziumHelmet = new MItemArmor(armorBlazium, MCommonProxy.fire, 0).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("fire_helmet"));
		blaziumChestplate = new MItemArmor(armorBlazium, MCommonProxy.fire, 1).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("fire_chestplate"));
		blaziumLeggings = new MItemArmor(armorBlazium, MCommonProxy.fire, 2).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("fire_leggings"));
		blaziumBoots = new MItemArmor(armorBlazium, MCommonProxy.fire, 3).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("fire_boots"));
		
		copperSword = new MItemSword(toolCopper).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("copper_sword"));
		copperShovel = new MItemShovel(toolCopper).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("copper_shovel"));
		copperPickaxe = new MItemPickaxe(toolCopper).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("copper_pickaxe"));
		copperAxe = new MItemAxe(toolCopper).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("copper_axe"));
		copperHoe = new MItemHoe(toolCopper).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("copper_hoe"));
		tinHelmet = new MItemArmor(armorTin, MCommonProxy.tin, 0).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("tin_helmet"));
		tinChestplate = new MItemArmor(armorTin, MCommonProxy.tin, 1).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("tin_chesplate"));
		tinLeggings = new MItemArmor(armorTin, MCommonProxy.tin, 2).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("tin_leggings"));
		tinBoots = new MItemArmor(armorTin, MCommonProxy.tin, 3).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("tin_boots"));
		
		bronzeSword = new MItemSword(toolBronze).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("bronze_sword"));
		bronzeShovel = new MItemShovel(toolBronze).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("bronze_shovel"));
		bronzePickaxe = new MItemPickaxe(toolBronze).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("bronze_pickaxe"));
		bronzeAxe = new MItemAxe(toolBronze).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("bronze_axe"));
		bronzeHoe = new MItemHoe(toolBronze).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("bronze_hoe"));
		bronzeHelmet = new MItemArmor(armorBronze, MCommonProxy.bronze, 0).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("bronze_helmet"));
		bronzeChestplate = new MItemArmor(armorBronze, MCommonProxy.bronze, 1).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("bronze_chesplate"));
		bronzeLeggings = new MItemArmor(armorBronze, MCommonProxy.bronze, 2).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("bronze_leggings"));
		bronzeBoots = new MItemArmor(armorBronze, MCommonProxy.bronze, 3).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("bronze_boots"));
		
		steelSword = new MItemSword(toolSteel).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("steel_sword"));
		steelShovel = new MItemShovel(toolSteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("steel_shovel"));
		steelPickaxe = new MItemPickaxe(toolSteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("steel_pickaxe"));
		steelAxe = new MItemAxe(toolSteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("steel_axe"));
		steelHoe = new MItemHoe(toolSteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("steel_hoe"));
		steelHelmet = new MItemArmor(armorSteel, MCommonProxy.steel, 0).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("steel_helmet"));
		steelChestplate = new MItemArmor(armorSteel, MCommonProxy.steel, 1).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("steel_chestplate"));
		steelLeggings = new MItemArmor(armorSteel, MCommonProxy.steel, 2).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("steel_leggings"));
		steelBoots = new MItemArmor(armorSteel, MCommonProxy.steel, 3).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getArmorTexture("steel_boots"));
		
		sandstoneSword = new MItemSword(toolSandstone).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("sandstone_sword"));
		sandstoneShovel = new MItemShovel(toolSandstone).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("sandstone_shovel"));
		sandstonePickaxe = new MItemPickaxe(toolSandstone).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("sandstone_pickaxe"));
		sandstoneAxe = new MItemAxe(toolSandstone).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("sandstone_axe"));
		sandstoneHoe = new MItemHoe(toolSandstone).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("sandstone_hoe"));
		
		bedrockShovel = new MItemShovel(toolBedrock).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("bedrock_shovel"));
		bedrockPickaxe = new MItemPickaxe(toolBedrock).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("bedrock_pickaxe"));
		bedrockAxe = new MItemAxe(toolBedrock).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("bedrock_axe"));
		bedrockHoe = new MItemHoe(toolBedrock).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("bedrock_hoe"));
		
		graniteSword = new MItemSword(toolGranite).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("granite_sword"));
		graniteShovel = new MItemShovel(toolGranite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("granite_shovel"));
		granitePickaxe = new MItemPickaxe(toolGranite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("granite_pickaxe"));
		graniteAxe = new MItemAxe(toolGranite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("granite_axe"));
		graniteHoe = new MItemHoe(toolGranite).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("granite_hoe"));
		
		soulsteelSword = new MItemSword(toolSoulsteel).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("soulsteel_sword"));
		soulsteelShovel = new MItemShovel(toolSoulsteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("soulsteel_shovel"));
		soulsteelPickaxe = new MItemPickaxe(toolSoulsteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("soulsteel_pickaxe"));
		soulsteelAxe = new MItemAxe(toolSoulsteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("soulsteel_axe"));
		soulsteelHoe = new MItemHoe(toolSoulsteel).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("soulsteel_hoe"));
		
		unholySword = new MItemSword(toolUnholy).setPlatable(false).setCreativeTab(Minestrappolation.tabCombat).setTextureName(MAssetManager.getWeaponTexture("unholy_sword"));
		unholyShovel = new MItemShovel(toolUnholy).setPlatable(false).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("unholy_shovel"));
		unholyPickaxe = new MItemPickaxe(toolUnholy).setPlatable(false).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("unholy_pickaxe"));
		unholyAxe = new MItemAxe(toolUnholy).setPlatable(false).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("unholy_axe"));
		unholyHoe = new MItemHoe(toolUnholy).setPlatable(false).setCreativeTab(Minestrappolation.tabTools).setTextureName(MAssetManager.getToolTexture("unholy_hoe"));
		
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
		
		CSItems.addItem(soulsteelSword, "soulsteel_sword");
		CSItems.addItem(soulsteelShovel, "soulsteel_shovel");
		CSItems.addItem(soulsteelPickaxe, "soulsteel_pickaxe");
		CSItems.addItem(soulsteelAxe, "soulsteel_axe");
		CSItems.addItem(soulsteelHoe, "soulsteel_hoe");
		
		CSItems.addItem(unholySword, "unholy_sword");
		CSItems.addItem(unholyShovel, "unholy_shovel");
		CSItems.addItem(unholyPickaxe, "unholy_pickaxe");
		CSItems.addItem(unholyAxe, "unholy_axe");
		CSItems.addItem(unholyHoe, "unholy_hoe");
		
		armorMeurodite.customCraftingMaterial = meuroditeGem;
		armorTitanium.customCraftingMaterial = titaniumIngot;
		armorTorite.customCraftingMaterial = toriteIngot;
		armorBlazium.customCraftingMaterial = blaziumIngot;
		armorTin.customCraftingMaterial = tinIngot;
		armorBronze.customCraftingMaterial = bronzeIngot;
		armorSteel.customCraftingMaterial = steelIngot;
		toolMeurodite.customCraftingMaterial = meuroditeGem;
		toolTitanium.customCraftingMaterial = titaniumIngot;
		toolTorite.customCraftingMaterial = toriteIngot;
		toolBlazium.customCraftingMaterial = blaziumIngot;
		toolCopper.customCraftingMaterial = copperIngot;
		toolBronze.customCraftingMaterial = bronzeIngot;
		toolSteel.customCraftingMaterial = steelIngot;
		toolSandstone.customCraftingMaterial = Item.getItemFromBlock(Blocks.sandstone);
		toolBedrock.customCraftingMaterial = Item.getItemFromBlock(Blocks.bedrock);
		toolGranite.customCraftingMaterial = Item.getItemFromBlock(MBlocks.graniteSlate);
		toolSoulsteel.customCraftingMaterial = soulGem;
		toolUnholy.customCraftingMaterial = blackDiamond;
	}
}
