package sobiohazardous.minestrappolation.extramobdrops.lib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.api.item.MItemFood;
import sobiohazardous.minestrappolation.api.item.MItemSword;
import sobiohazardous.minestrappolation.extramobdrops.CreativeTabExtraMobDropsItems;
import sobiohazardous.minestrappolation.extramobdrops.EMDConfig;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.EnumHelper;

public class EMDItemManager 
{
	public static Item snout;
	public static Item pigHoof;
	public static Item fat;
	public static Item grease;
	
	public static Item friedApple;
	public static Item friedBeef;
	public static Item friedBread;
	public static Item friedCarrot;
	public static Item friedCookie;
	public static Item friedFlesh;
	
	public static Item animalBones;
	public static Item cowHoof;
	public static Item horn;
	
	public static Item hornSwordWood;
	public static Item hornSwordStone;
	public static Item hornSwordIron;
	public static Item hornSwordDiamond;
	public static Item hornSwordGold;
	
	public static Item hornSandstone;
	public static Item hornGranite;
	public static Item hornCopper;
	public static Item hornSteel;
	public static Item hornBronze;
	public static Item hornMeurodite;
	public static Item hornTorite;
	public static Item hornBlazium;
	public static Item hornTitanium;
	
	public static Item beakChicken;
	
	public static Item footChicken;
	
	public static EnumToolMaterial toolMaterialWoodH = EnumHelper.addToolMaterial("ToolWoodH", 0, 59, 2.0F, 2.0F, 15);
	public static EnumToolMaterial toolMaterialStoneH = EnumHelper.addToolMaterial("ToolStoneH", 1, 131, 4.0F, 3.0F, 5);
	public static EnumToolMaterial toolMaterialIronH = EnumHelper.addToolMaterial("ToolIronH", 2, 250, 6.0F, 4.0F, 14);
	public static EnumToolMaterial toolMaterialDiamondH = EnumHelper.addToolMaterial("ToolDiamondH", 3, 1561, 8.0F, 5.0F, 10);
	public static EnumToolMaterial toolMaterialGoldH = EnumHelper.addToolMaterial("ToolGoldH", 0, 32, 12.0F, 2.0F, 22);
	
	public static EnumToolMaterial toolMaterialSandstoneH = EnumHelper.addToolMaterial("ToolSandstoneH", 1, 111, 4.5F, 4, 6);
	public static EnumToolMaterial toolMaterialGraniteH = EnumHelper.addToolMaterial("ToolGraniteH", 1, 199, 4.3F, 4, 4);
	public static EnumToolMaterial toolMaterialCopperH = EnumHelper.addToolMaterial("ToolCopperH", 1, 139, 5.0F, 4, 10);
	public static EnumToolMaterial toolMaterialSteelH = EnumHelper.addToolMaterial("ToolSteelH", 2, 300, 7.5F, 5, 15);
	public static EnumToolMaterial toolMaterialBronzeH = EnumHelper.addToolMaterial("ToolBronzeH", 2, 1501, 6.5F, 4, 8);
	public static EnumToolMaterial toolMaterialMeuroditeH = EnumHelper.addToolMaterial("ToolMeuroditeH", 2, 805, 7.0F, 4, 15);
	public static EnumToolMaterial toolMaterialToriteH = EnumHelper.addToolMaterial("ToolToriteH", 2, 699, 6.0F, 5, 20);
	public static EnumToolMaterial toolMaterialBlaziumH = EnumHelper.addToolMaterial("ToolBlaziumH", 2, 799, 8.0F, 5, 18);
	public static EnumToolMaterial toolMaterialTitaniumH = EnumHelper.addToolMaterial("ToolTitaniumH", 4, 2999, 10.0F, 6, 11);
	
	public static CreativeTabs tabItems = new CreativeTabExtraMobDropsItems(CreativeTabs.getNextID(), "Extrappolated Mob Drops - Items");

	public static void loadItems()
	{
		snout = new MItemFood(EMDConfig.snoutId, 3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setUnlocalizedName("snout").setCreativeTab(tabItems);
		pigHoof = new MItem(EMDConfig.pigHoofId).setUnlocalizedName("pig_foot").setCreativeTab(tabItems);
		fat = new MItemFood(EMDConfig.fatId, 8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setUnlocalizedName("fat").setCreativeTab(tabItems);
		grease = new MItem(EMDConfig.greaseId).setUnlocalizedName("grease").setCreativeTab(tabItems);
		
		friedApple = new MItemFood(EMDConfig.friedAppleId, 8, 0.3F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_apple").setCreativeTab(tabItems);
		friedBeef = new MItemFood(EMDConfig.friedBeefId, 16, 0.8F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_beef").setCreativeTab(tabItems);
		friedBread = new MItemFood(EMDConfig.friedBreadId, 10, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_bread").setCreativeTab(tabItems);
		friedCarrot = new MItemFood(EMDConfig.friedCarrotId, 8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_carrot").setCreativeTab(tabItems);
		friedCookie = new MItemFood(EMDConfig.friedCookieId, 8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_cookie").setCreativeTab(tabItems);
		friedFlesh = new MItemFood(EMDConfig.friedFleshId, 8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_flesh").setCreativeTab(tabItems);
		
		animalBones = new MItem(EMDConfig.animalBonesId).setUnlocalizedName("animal_bones").setCreativeTab(tabItems);
		cowHoof = new MItem(EMDConfig.cowHoofId).setUnlocalizedName("cow_hoof").setCreativeTab(tabItems);
		
		horn = new MItem(EMDConfig.hornId).setUnlocalizedName("horn").setCreativeTab(tabItems);
		
		hornSwordWood = new MItemSword(EMDConfig.hornSwordWoodId, toolMaterialWoodH, false).setUnlocalizedName("horned_wood_sword").setCreativeTab(tabItems);
		hornSwordStone = new MItemSword(EMDConfig.hornSwordStoneId, toolMaterialStoneH, false).setUnlocalizedName("horned_stone_sword").setCreativeTab(tabItems);
		hornSwordIron = new MItemSword(EMDConfig.hornSwordIronId, toolMaterialIronH, false).setUnlocalizedName("horned_iron_sword").setCreativeTab(tabItems);
		hornSwordDiamond = new MItemSword(EMDConfig.hornSwordDiamondId, toolMaterialDiamondH, false).setUnlocalizedName("horned_diamond_sword").setCreativeTab(tabItems);
		hornSwordGold = new MItemSword(EMDConfig.hornSwordGoldId, toolMaterialGoldH, false).setUnlocalizedName("horned_gold_sword").setCreativeTab(tabItems);

		hornSandstone = new MItemSword(EMDConfig.hornSandstoneId, toolMaterialSandstoneH, false).setUnlocalizedName("horned_sandstone_sword").setCreativeTab(tabItems);
		hornGranite= new MItemSword(EMDConfig.hornGraniteId, toolMaterialGraniteH, false).setUnlocalizedName("horned_granite_sword").setCreativeTab(tabItems);
		hornCopper= new MItemSword(EMDConfig.hornCopperId, toolMaterialCopperH, false).setUnlocalizedName("horned_copper_sword").setCreativeTab(tabItems);
		hornSteel= new MItemSword(EMDConfig.hornSteelId, toolMaterialSteelH, false).setUnlocalizedName("horned_steel_sword").setCreativeTab(tabItems);
		hornBronze= new MItemSword(EMDConfig.hornBronzeId, toolMaterialBronzeH, false).setUnlocalizedName("horned_bronze_sword").setCreativeTab(tabItems);
		hornMeurodite= new MItemSword(EMDConfig.hornMeuroditeId, toolMaterialMeuroditeH, false).setUnlocalizedName("horned_meurodite_sword").setCreativeTab(tabItems);
		hornTorite= new MItemSword(EMDConfig.hornToriteId, toolMaterialToriteH, false).setUnlocalizedName("horned_torite_sword").setCreativeTab(tabItems);
		hornBlazium= new MItemSword(EMDConfig.hornBlaziumId, toolMaterialBlaziumH, true).setUnlocalizedName("horned_fire_sword").setCreativeTab(tabItems);
		hornTitanium= new MItemSword(EMDConfig.hornTitaniumId, toolMaterialTitaniumH, false).setUnlocalizedName("horned_titanium_sword").setCreativeTab(tabItems);
		
		beakChicken = new MItem(EMDConfig.beakChickenId).setUnlocalizedName("chicken_beak").setCreativeTab(tabItems);
			
		footChicken = new MItem(EMDConfig.footChickenId).setUnlocalizedName("chicken_foot").setCreativeTab(tabItems);
	}
	
	public static void loadNames()
	{
		LanguageRegistry.addName(snout, "Snout");
		LanguageRegistry.addName(pigHoof, "Pig Hoof");
		LanguageRegistry.addName(fat, "Fat");
		LanguageRegistry.addName(grease, "Grease");
		LanguageRegistry.addName(friedApple, "Fried Apple");
		LanguageRegistry.addName(friedBeef, "Fried Beef");
		LanguageRegistry.addName(friedBread, "Fried Bread");
		LanguageRegistry.addName(friedCarrot, "Fried Carrot");
		LanguageRegistry.addName(friedCookie, "Fried Cookie");
		LanguageRegistry.addName(friedFlesh, "Fried Flesh");
		LanguageRegistry.addName(animalBones, "Amimal Bones");
		LanguageRegistry.addName(cowHoof, "Cow Hoof");
		LanguageRegistry.addName( horn, "Horn");
		LanguageRegistry.addName( hornSwordWood, "Horned Wood Sword");
		LanguageRegistry.addName( hornSwordStone, "Horned Stone Sword");
		LanguageRegistry.addName( hornSwordIron, "Horned Iron Sword");
		LanguageRegistry.addName( hornSwordDiamond, "Horned Diamond Sword");
		LanguageRegistry.addName( hornSwordGold, "Horned Gold Sword");
		LanguageRegistry.addName( hornSandstone, "Horned Sanstone Sword");
		LanguageRegistry.addName( hornGranite, "Horned Granite Sword");
		LanguageRegistry.addName( hornCopper, "Horned Copper Sword");
		LanguageRegistry.addName( hornSteel, "Horned Steel Sword");
		LanguageRegistry.addName( hornBronze, "Horned Bronze Sword");
		LanguageRegistry.addName( hornMeurodite, "Horned Meurodite Sword");
		LanguageRegistry.addName( hornTorite, "Horned Torite Sword");
		LanguageRegistry.addName( hornBlazium, "Horned Blazium Sword");
		LanguageRegistry.addName( hornTitanium, "Horned Titanium Sword");
		LanguageRegistry.addName( beakChicken, "Chicken Beak");
		LanguageRegistry.addName( footChicken, "Chicken Foot");
	}
}
