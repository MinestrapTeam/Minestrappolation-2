package sobiohazardous.minestrappolation.extramobdrops;

import java.util.EnumSet;

import sobiohazardous.minestrappolation.api.item.MItemFood;
import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.api.item.MItemSword;
import sobiohazardous.minestrappolation.extramobdrops.bridge.EMDBridgeRecipes;
import sobiohazardous.minestrappolation.extramobdrops.handler.ClientPacketHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.EMDEventHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.PlayerTickHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.ServerPacketHandler;
import sobiohazardous.minestrappolation.extramobdrops.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDNameManager;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDRecipeManager;

/**
 * 
 * 
 * 
 * @author Crzyguitardude
 */
@NetworkMod(clientSideRequired = true, serverSideRequired = false,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"extraoresChan"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"extroresChan"}, packetHandler = ServerPacketHandler.class))
@Mod ( modid = "ExtraMobDrops", name="Extrappolated Mob Drops", version="B1.0", dependencies = "required-after:Minestrappolation")
public class ExtraMobDrops 
{

	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extramobdrops.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extramobdrops.proxy.CommonProxy")
    public static CommonProxy proxy;
	public static CreativeTabs tabItems = new CreativeTabExtraMobDropsItems(CreativeTabs.getNextID(), "Extrappolated Mob Drops - Items");
	public static CreativeTabs tabPotions = new CreativeTabExtraMobDropsPotions(CreativeTabs.getNextID(), "Extrappolated Mob Drops - Potions");
	@Instance("ExtraMobDrops")
	public static ExtraMobDrops instance;
	
	public static int snoutId,
	pigHoofId,
	fatId,
	greaseId,
	friedAppleId,
	friedBeefId,
	friedBreadId,
	friedCarrotId,
	friedCookieId,
	friedFleshId,
	animalBonesId,
	cowHoofId,
	hornId,
	hornSwordWoodId,
	hornSwordStoneId,
	hornSwordIronId,
	hornSwordDiamondId,
	hornSwordGoldId,
	hornSandstoneId,
	hornGraniteId,
	hornCopperId,
	hornSteelId,
	hornBronzeId,
	hornMeuroditeId,
	hornToriteId,
	hornBlaziumId,
	hornTitaniumId,
	beakChickenId,
	potionId,
	footChickenId;
	
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

		
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		//items 400
		snoutId = config.getItem("Snout", 4000).getInt();
		pigHoofId = config.getItem("Pig Hoof", 4001).getInt();
		fatId = config.getItem("Fat", 4002).getInt();
		greaseId = config.getItem("Grease", 4003).getInt();
		friedAppleId = config.getItem("Fried Apple", 4004).getInt();
		friedBeefId = config.getItem("Fried Beef", 4005).getInt();
		friedBreadId = config.getItem("Fried Bread", 4006).getInt();
		friedCarrotId = config.getItem("Fried Carrot", 4007).getInt();
		friedCookieId = config.getItem("Fried Cookie", 4008).getInt();
		friedFleshId = config.getItem("Fried Flesh", 4009).getInt();
		animalBonesId = config.getItem("Animal Bones", 4010).getInt();
		cowHoofId = config.getItem("Cow Hoof", 4011).getInt();
		hornId = config.getItem("Horn", 4012).getInt();
		hornSwordWoodId = config.getItem("Horned Wood Sword", 4013).getInt();
		hornSwordStoneId = config.getItem("Horned Stone Sword", 4014).getInt();
		hornSwordIronId = config.getItem("Horned Iron Sword", 4015).getInt();
		hornSwordDiamondId = config.getItem("Horned Diamond Sword", 4016).getInt();
		hornSwordGoldId = config.getItem("Horned Gold Sword", 4026).getInt();
		hornSandstoneId = config.getItem("Horned Sandstone Sword", 4017).getInt();
		hornGraniteId = config.getItem("Horned Granite Sword", 4018).getInt();
		hornCopperId = config.getItem("Horned Copper Sword", 4019).getInt();
		hornSteelId = config.getItem("Horned Steel Sword", 4020).getInt();
		hornBronzeId = config.getItem("Horned Bronze Sword", 4021).getInt();
		hornMeuroditeId = config.getItem("Horned Meurodite Sword", 4022).getInt();
		hornToriteId = config.getItem("Horned Torite Sword", 4023).getInt();
		hornBlaziumId = config.getItem("Horned Blazium Sword", 4024).getInt();
		hornTitaniumId = config.getItem("Horned Titanium Sword", 4025).getInt();
		beakChickenId = config.getItem("Chicken Beak", 4026).getInt();
		potionId = config.getItem("Potion", 4027).getInt();
		footChickenId = config.getItem("Chicken Foot", 4028).getInt();
		
		config.save();

		snout = new MItemFood(snoutId, 3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setUnlocalizedName("snout").setCreativeTab(tabItems);
		pigHoof = new MItem(pigHoofId).setUnlocalizedName("pig_foot").setCreativeTab(tabItems);
		fat = new MItemFood(fatId, 8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setUnlocalizedName("fat").setCreativeTab(tabItems);
		grease = new MItem(greaseId).setUnlocalizedName("grease").setCreativeTab(tabItems);
		
		friedApple = new MItemFood(friedAppleId, 8, 0.3F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_apple").setCreativeTab(tabItems);
		friedBeef = new MItemFood(friedBeefId, 16, 0.8F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_beef").setCreativeTab(tabItems);
		friedBread = new MItemFood(friedBreadId, 10, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_bread").setCreativeTab(tabItems);
		friedCarrot = new MItemFood(friedCarrotId, 8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_carrot").setCreativeTab(tabItems);
		friedCookie = new MItemFood(friedCookieId, 8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_cookie").setCreativeTab(tabItems);
		friedFlesh = new MItemFood(friedFleshId, 8, 0.6F).setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("grease_flesh").setCreativeTab(tabItems);
		
		animalBones = new MItem(animalBonesId).setUnlocalizedName("animal_bones").setCreativeTab(tabItems);
		cowHoof = new MItem(cowHoofId).setUnlocalizedName("cow_hoof").setCreativeTab(tabItems);
		
		horn = new MItem(hornId).setUnlocalizedName("horn").setCreativeTab(tabItems);
		
		hornSwordWood = new MItemSword(hornSwordWoodId, toolMaterialWoodH, false).setUnlocalizedName("horned_wood_sword").setCreativeTab(tabItems);
		hornSwordStone = new MItemSword(hornSwordStoneId, toolMaterialStoneH, false).setUnlocalizedName("horned_stone_sword").setCreativeTab(tabItems);
		hornSwordIron = new MItemSword(hornSwordIronId, toolMaterialIronH, false).setUnlocalizedName("horned_iron_sword").setCreativeTab(tabItems);
		hornSwordDiamond = new MItemSword(hornSwordDiamondId, toolMaterialDiamondH, false).setUnlocalizedName("horned_diamond_sword").setCreativeTab(tabItems);
		hornSwordGold = new MItemSword(hornSwordGoldId, toolMaterialGoldH, false).setUnlocalizedName("horned_gold_sword").setCreativeTab(tabItems);

		hornSandstone = new MItemSword(hornSandstoneId, toolMaterialSandstoneH, false).setUnlocalizedName("horned_sandstone_sword").setCreativeTab(tabItems);
		hornGranite= new MItemSword(hornGraniteId, toolMaterialGraniteH, false).setUnlocalizedName("horned_granite_sword").setCreativeTab(tabItems);
		hornCopper= new MItemSword(hornCopperId, toolMaterialCopperH, false).setUnlocalizedName("horned_copper_sword").setCreativeTab(tabItems);
		hornSteel= new MItemSword(hornSteelId, toolMaterialSteelH, false).setUnlocalizedName("horned_steel_sword").setCreativeTab(tabItems);
		hornBronze= new MItemSword(hornBronzeId, toolMaterialBronzeH, false).setUnlocalizedName("horned_bronze_sword").setCreativeTab(tabItems);
		hornMeurodite= new MItemSword(hornMeuroditeId, toolMaterialMeuroditeH, false).setUnlocalizedName("horned_meurodite_sword").setCreativeTab(tabItems);
		hornTorite= new MItemSword(hornToriteId, toolMaterialToriteH, false).setUnlocalizedName("horned_torite_sword").setCreativeTab(tabItems);
		hornBlazium= new MItemSword(hornBlaziumId, toolMaterialBlaziumH, true).setUnlocalizedName("horned_fire_sword").setCreativeTab(tabItems);
		hornTitanium= new MItemSword(hornTitaniumId, toolMaterialTitaniumH, false).setUnlocalizedName("horned_titanium_sword").setCreativeTab(tabItems);
		
		beakChicken = new MItem(beakChickenId).setUnlocalizedName("chicken_beak").setCreativeTab(tabItems);
			
		footChicken = new MItem(footChickenId).setUnlocalizedName("chicken_foot").setCreativeTab(tabItems);
		
		EMDNameManager.loadNames();
		EMDRecipeManager.loadRecipes();			
	}
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent e)
	{
		proxy.registerRenderThings();
		TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);
		MinecraftForge.EVENT_BUS.register(new EMDEventHandler());
	}

	@Mod.EventHandler
	public void postLoad(FMLPostInitializationEvent e)
	{
		try
		{
			EMDBridgeRecipes.loadBridgeRecipes();
		}
		catch(Exception ex)
		{
			System.err.println("ExtraMobDrops: Could not load bridge recipes. Heres why: ");
			ex.printStackTrace();
		}
		
	}
}
