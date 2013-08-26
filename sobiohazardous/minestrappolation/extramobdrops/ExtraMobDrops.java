package sobiohazardous.minestrappolation.extramobdrops;

import java.util.EnumSet;

import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.extramobdrops.bridge.EMDBridgeRecipes;
import sobiohazardous.minestrappolation.extramobdrops.handler.ClientPacketHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.EMDEventHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.PlayerTickHandler;
import sobiohazardous.minestrappolation.extramobdrops.handler.ServerPacketHandler;
import sobiohazardous.minestrappolation.extramobdrops.proxy.CommonProxy;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import sobiohazardous.minestrappolation.extramobdrops.item.*;
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

		snout = new EMDItemFood(snoutId, 3, 0.2F).setPotionEffect(Potion.hunger.id, 10 * 20, 1, 0.25F).setUnlocalizedName("snout");
		pigHoof = new MItem(pigHoofId).setUnlocalizedName("pig_hoof");
		fat = new EMDItemFood(fatId, 8, 0.2F).setPotionEffect(Potion.hunger.id, 25 * 20, 1, 1.0F).setUnlocalizedName("fat");
		grease = new MItem(greaseId).setUnlocalizedName("grease");
		
		friedApple = new EMDItemFood(friedAppleId, 8, 0.3F, "grease_apple").setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("friedApple");
		friedBeef = new EMDItemFood(friedBeefId, 16, 0.8F, "grease_beef").setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("friedBeef");
		friedBread = new EMDItemFood(friedBreadId, 10, 0.6F, "grease_bread").setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("friedBread");
		friedCarrot = new EMDItemFood(friedCarrotId, 8, 0.6F, "grease_carrot").setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("friedCarrot");
		friedCookie = new EMDItemFood(friedCookieId, 8, 0.6F, "grease_cookie").setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("friedCookie");
		friedFlesh = new EMDItemFood(friedFleshId, 8, 0.6F, "grease_flesh").setPotionEffect(Potion.hunger.id, 15 * 20, 1, 0.4F).setUnlocalizedName("friedFlesh");
		
		animalBones = new MItem(animalBonesId, "animal_bones").setUnlocalizedName("animalBones");
		cowHoof = new MItem(cowHoofId, "cow_hoof").setUnlocalizedName("cowHoof");
		
		horn = new MItem(hornId).setUnlocalizedName("horn");
		
		hornSwordWood = new ItemHornSword(hornSwordWoodId, "horned_wood_sword", EnumHornSwordMaterial.WOODH).setUnlocalizedName("hornedSwordWood");
		hornSwordStone = new ItemHornSword(hornSwordStoneId, "horned_stone_sword", EnumHornSwordMaterial.STONEH).setUnlocalizedName("hornedSwordStone");
		hornSwordIron = new ItemHornSword(hornSwordIronId, "horned_iron_sword", EnumHornSwordMaterial.IRONH).setUnlocalizedName("hornedSwordIron");
		hornSwordDiamond = new ItemHornSword(hornSwordDiamondId, "horned_diamond_sword", EnumHornSwordMaterial.EMERALDH).setUnlocalizedName("hornedSwordDiamond");
		hornSwordGold = new ItemHornSword(hornSwordGoldId, "horned_gold_sword", EnumHornSwordMaterial.GOLDH).setUnlocalizedName("hornedSwordGold");

		hornSandstone = new ItemHornSword(hornSandstoneId, "horned_sandstone_sword", EnumHornSwordMaterial.SANDSTONEH).setUnlocalizedName("hornedSwordSandstone");
		hornGranite= new ItemHornSword(hornGraniteId, "horned_granite_sword", EnumHornSwordMaterial.GRANITEH).setUnlocalizedName("hornedSwordGranite");
		hornCopper= new ItemHornSword(hornCopperId, "horned_copper_sword", EnumHornSwordMaterial.COPPERH).setUnlocalizedName("hornedSwordCopper");
		hornSteel= new ItemHornSword(hornSteelId, "horned_steel_sword", EnumHornSwordMaterial.STEELH).setUnlocalizedName("hornedSwordSteel");
		hornBronze= new ItemHornSword(hornBronzeId, "horned_bronze_sword", EnumHornSwordMaterial.BRONZEH).setUnlocalizedName("hornedSwordBronze");
		hornMeurodite= new ItemHornSword(hornMeuroditeId, "horned_meurodite_sword", EnumHornSwordMaterial.MEURODITEH).setUnlocalizedName("hornedSwordMeurodite");
		hornTorite= new ItemHornSword(hornToriteId, "horned_torite_sword", EnumHornSwordMaterial.TORITEH).setUnlocalizedName("hornedSwordTorite");
		hornBlazium= new ItemHornSword(hornBlaziumId, "horned_fire_sword", EnumHornSwordMaterial.BLAZIUMH).setUnlocalizedName("hornedSwordBlazium");
		hornTitanium= new ItemHornSword(hornTitaniumId, "horned_titanium_sword", EnumHornSwordMaterial.TITANIUMH).setUnlocalizedName("hornedSwordTitanium");
		
		beakChicken = new MItem(beakChickenId, "chicken_beak").setUnlocalizedName("beakChicken");
			
		footChicken = new MItem(footChickenId, "chicken_foot").setUnlocalizedName("footChicken");
		
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
