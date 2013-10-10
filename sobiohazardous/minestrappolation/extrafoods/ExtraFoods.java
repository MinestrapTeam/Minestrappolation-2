package sobiohazardous.minestrappolation.extrafoods;

import java.util.ArrayList;
import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import sobiohazardous.minestrappolation.extrafoods.block.*;
import sobiohazardous.minestrappolation.extrafoods.block.freezer.BlockFreezer;
import sobiohazardous.minestrappolation.extrafoods.block.freezer.TileEntityFreezer;
import sobiohazardous.minestrappolation.extrafoods.block.fridge.BlockFridge;
import sobiohazardous.minestrappolation.extrafoods.block.microwave.BlockMicrowave;
import sobiohazardous.minestrappolation.extrafoods.block.microwave.TileEntityMicrowave;
import sobiohazardous.minestrappolation.extrafoods.client.render.RenderCakeMan;
import sobiohazardous.minestrappolation.extrafoods.creativetab.*;
import sobiohazardous.minestrappolation.extrafoods.entity.mob.EntityCakeMan;
import sobiohazardous.minestrappolation.extrafoods.gen.EFOreGenerator;
import sobiohazardous.minestrappolation.extrafoods.handler.*;
import sobiohazardous.minestrappolation.extrafoods.item.EFFood;
import sobiohazardous.minestrappolation.extrafoods.item.EFFoodSpoilable;
import sobiohazardous.minestrappolation.extrafoods.item.EFItem;
import sobiohazardous.minestrappolation.extrafoods.item.EFItemSeed;
import sobiohazardous.minestrappolation.extrafoods.item.ItemBlockPlacer;
import sobiohazardous.minestrappolation.extrafoods.item.ItemGlassCup;
import sobiohazardous.minestrappolation.extrafoods.item.ItemKnife;
import sobiohazardous.minestrappolation.extrafoods.item.ItemWaterCup;
import sobiohazardous.minestrappolation.extrafoods.lib.BlockRegistry;
import sobiohazardous.minestrappolation.extrafoods.lib.EFCraftingManager;
import sobiohazardous.minestrappolation.extrafoods.lib.NameManager;
import sobiohazardous.minestrappolation.extrafoods.lib.RecipeManager;
import sobiohazardous.minestrappolation.extrafoods.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;

@NetworkMod(clientSideRequired = true, serverSideRequired = false,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"extrafoodsCChan"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"extrafoodsSChan"}, packetHandler = ServerPacketHandler.class))
@Mod ( modid = "ExtraFoods", name="Extrapolated Foods", version="B1.0", dependencies = "required-after:Minestrappolation")
public class ExtraFoods 
{
	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extrafoods.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extrafoods.proxy.CommonProxy" )
    public static CommonProxy proxy;

	@Instance("ExtraFoods")
	public static ExtraFoods instance;
	
	//TODO organize id's
	public static int microwaveID;
	public static int microwaveOnID;
	public static int freezerID;
	public static int fridgeID;
	
	public static int oreAluminumID;
	public static int oreSaltID;
	
	public static int aluminumID;
	public static int saltID;
	
	public static int knifeStoneID;
	public static int knifeIronID;
	public static int knifeDiamondID;
	
	public static int flourID;
	public static int doughID;
	public static int syrupChocolateID;
	
	public static int cakeCheeseID;	
	public static int cakeCheeseItemID;
	public static int cakeChocolateID;
	public static int cakeChocolateItemID;
	public static int cakeGoldID;
	public static int cakeGoldItemID;
	public static int cakeExplosiveID;
	public static int cakeExplosiveItemID;
	
	public static int cheeseSpoiledID;
	public static int cheeseBlueID;
	public static int cheeseID;

	public static int breadSliceID;

	public static int pepperID;
	public static int pepperCropID;
	public static int pepperSeedID;
	
	public static int cornID;
	public static int cornCropID;
	public static int cornSeedID;
	
	public static int cornCookedID;
	
	public static int riceID;
	public static int riceCropID;
	public static int riceSeedID;
	
	public static int chickenSpoiledID;
	public static int chickenID;
	
	public static int fishSpoiledID;
	public static int fishID;
	
	public static int beefSpoiledID;
	public static int beefID;
	
	public static int porkchopSpoiledID;
	public static int porkchopID;
	
	public static int pizzaID;
	public static int pizzaItemID;
	public static int pizzaSliceID;
	
	public static int oreoID;
	public static int oreoCakeID;
	public static int oreoCakeItemID;
	
	public static int netherCakeID;
	public static int netherCakeItemID;
	
	public static int calimariRawID;
	public static int calimariCookedID;
	
	public static int lambchopRawID;
	public static int lambchopCookedID;
	
	public static int meatblockRawID;
	public static int meatblockCookedID;
	
	public static int sausageID;
	
	public static int pieAppleId;
	public static int pieBaconId;
	public static int pieCheeseId;
	public static int pieChickenId;
	public static int pieChocolateId;
	public static int pieFishId;
	public static int pieGoldAppleId;
	
	public static int baconRawId;
	public static int baconSpoiledId;
	public static int baconCookedId;
	
	public static int flowerVanillaId;
	public static int vanillaExtractId;
	public static int creamId;
	public static int cupGlassId;
	public static int cupWaterId;
	
	//TODO Blocks/items
	public static Block microwaveIdle;
	public static Block microwaveOn;
	public static Block freezer;
	public static Block fridge;
	
	public static Block oreAluminum;
	public static Block oreSalt;
	
	public static Item aluminum;
	public static Item salt;
	
	public static Item knifeStone;
	public static Item knifeIron;
	public static Item knifeDiamond;
	
	public static Item flour;
	public static Item dough;
	public static Item syrupChocolate;
	
	public static Block cakeCheese;
	public static Item cakeCheeseItem;
	public static Block cakeChocolate;
	public static Item cakeChocolateItem;
	public static Block cakeGold;
	public static Item cakeGoldItem;
	public static Block cakeExplosive;
	public static Item cakeExplosiveItem;
	
	public static Item cheeseSpoiled;
	public static Item cheeseBlue;
	public static Item cheese;
	
	public static Item breadSlice;
	
	public static Item pepper;
	public static Block pepperCrop;
	public static Item pepperSeed;
	
	public static Item corn;
	public static Block cornCrop;
	public static Item cornSeed;
	
	public static Item cornCooked;
	
	public static Item rice;
	public static Block riceCrop;
	public static Item riceSeed;
	
	public static Item chickenSpoiled;
	public static Item chicken;
	
	public static Item fishSpoiled;
	public static Item fish;
	
	public static Item beefSpoiled;
	public static Item beef;
	
	public static Item porkchopSpoiled;
	public static Item porkchop;
	
	public static Block pizza;
	public static Item pizzaItem;
	public static Item pizzaSlice;
	
	public static Item oreo;
	public static Block oreoCake;
	public static Item oreoCakeItem;
	
	public static Block netherCake;
	public static Item netherCakeItem;
	
	public static Item calimariRaw;
	public static Item calimariCooked;
	
	public static Item lambchopRaw;
	public static Item lambchopCooked;
	
	public static Block meatblockRaw;
	public static Block meatblockCooked;
	
	public static Item sausage;
	
	public static Item pieApple;
	public static Item pieBacon;
	public static Item pieCheese;
	public static Item pieChicken;
	public static Item pieChocolate;
	public static Item pieFish;
	public static Item pieGoldApple;
	
	public static Item baconRaw;
	public static Item baconSpoiled;
	public static Item baconCooked;
	
	public static EFBlockFlower flowerVanilla;
	public static Item vanillaExtract;
	public static Item cream;
	public static Item cupGlass;
	public static Item cupWater;
	
	public static final CreativeTabs tabBlocks = new TabEFBlocks(CreativeTabs.getNextID(), "Extrapolated Foods - Blocks");
	public static final CreativeTabs tabItems = new TabEFItems(CreativeTabs.getNextID(), "Extrapolated Foods - Items");
	public static final CreativeTabs tabFoods = new TabEFFoods(CreativeTabs.getNextID(), "Extrapolated Foods - Foods");
	
	@EventHandler
	public void preload(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	    config.load();
	    
		microwaveID = config.getBlock("Microwave", 900).getInt();
		microwaveOnID = config.getBlock("Microwave On", 901).getInt();
		freezerID = config.getBlock("Freezer", 902).getInt();
		fridgeID = config.getBlock("Fridge", 903).getInt();
		
		oreAluminumID = config.getBlock("Aluminum Ore", 904).getInt();
		oreSaltID = config.getBlock("Salt Ore", 905).getInt();
		
		aluminumID = config.getItem("Aluminum", 5000).getInt();
		saltID = config.getItem("Salt", 5001).getInt();
		
		knifeStoneID = config.getItem("Stone Knife", 5002).getInt();
		knifeIronID = config.getItem("Iron Knife", 5003).getInt();
		knifeDiamondID = config.getItem("Diamond Knife", 5004).getInt();
		
		flourID = config.getItem("Flour", 5005).getInt();
		doughID = config.getItem("Dough", 5006).getInt();
		syrupChocolateID = config.getItem("Chocolate Syrup", 5012).getInt();
		
		cakeCheeseID = config.getBlock("Cheese Cake Block", 906).getInt();
		cakeCheeseItemID = config.getItem("Cheese Cake Item", 5007).getInt();
		cakeChocolateID = config.getBlock("Chocolate Cake Block", 907).getInt();
		cakeChocolateItemID = config.getItem("Chocolate Cake Item", 5011).getInt();
		cakeGoldID = config.getBlock("Gold Apple Cake Block", 908).getInt();
		cakeGoldItemID = config.getItem("Gold Apple Cake Item", 5013).getInt();
		cakeExplosiveID = config.getBlock("Explosive Cake Block", 909).getInt();
		cakeExplosiveItemID = config.getItem("Explosive Cake Item", 5014).getInt();

		cheeseSpoiledID = config.getItem("Spoiled Cheese", 5015).getInt();
		cheeseBlueID = config.getItem("Blue Cheese", 5016).getInt();
		cheeseID = config.getItem("Cheese", 5017).getInt();
		
		breadSliceID = config.getItem("Sliced Bread", 5010).getInt();

		pepperID = config.getItem("Pepper", 5019).getInt();
		pepperCropID = config.getBlock("Pepper Crop", 910).getInt();
		pepperSeedID = config.getItem("pepperSeed", 5018).getInt();
		
		cornID = config.getItem("Corn", 5019).getInt();
		cornCropID = config.getBlock("Corn Crop", 911).getInt();
		cornSeedID = config.getItem("Corn Seed", 5020).getInt();
		
		cornCookedID = config.getItem("Corn Cooked", 5021).getInt();
		
		riceID = config.getItem("Rice", 5022).getInt();
		riceCropID = config.getBlock("Rice Crop", 912).getInt();
		riceSeedID = config.getItem("Rice Seed", 5023).getInt();
		
		chickenSpoiledID = config.getItem("Spoiled Chicken", 5024).getInt();
		chickenID = config.getItem("Overriding Chicken Cooked", 5025).getInt();
		
		fishSpoiledID = config.getItem("Fish Spoiled", 5026).getInt();
		fishID = config.getItem("Overriding Fish Cooked", 5027).getInt();
		
		beefSpoiledID = config.getItem("Spoiled Beef", 5028).getInt();
		beefID = config.getItem("Overriding Beef Cooked", 5029).getInt();
		
		porkchopSpoiledID = config.getItem("Spoiled Porkchop", 5030).getInt();
		porkchopID = config.getItem("Overriding Cooked Porkchop", 5031).getInt();
		
		pizzaID = config.getBlock("Pizza Block", 913).getInt();
		pizzaItemID = config.getItem("Pizza Placer Item", 5032).getInt();
		pizzaSliceID = config.getItem("Pizza Slice", 5033).getInt();
		
		oreoID = config.getItem("Oreo", 5034).getInt();
		oreoCakeID = config.getBlock("Oreo Cake", 914).getInt();
		oreoCakeItemID = config.getItem("Oreo Cake Item", 5035).getInt();
		
		netherCakeID = config.getBlock("Nether Cake BLock", 915).getInt();
		netherCakeItemID = config.getItem("Nether Cake Item", 5036).getInt();
		
		calimariRawID = config.getItem("Raw Calimari", 5037).getInt();
		calimariCookedID = config.getItem("Cooked Calimari", 5038).getInt();
		
		lambchopRawID = config.getItem("Raw Lambchop", 5039).getInt();
		lambchopCookedID = config.getItem("Cooked Lambchop", 5040).getInt();
		
		meatblockRawID = config.getBlock("Raw Meat Block", 916).getInt();
		meatblockCookedID = config.getBlock("Cooked Meat Block", 917).getInt();
		
		sausageID = config.getItem("Sausage", 5041).getInt();
		
		pieAppleId = config.getItem("Apple Pie", 5042).getInt();
		pieBaconId = config.getItem("Bacon Pie", 5043).getInt();
		pieCheeseId = config.getItem("Cheese Pie", 5044).getInt();
		pieChickenId = config.getItem("Chicken Pie", 5045).getInt();
		pieChocolateId = config.getItem("Chocolate Pie", 5046).getInt();
		pieFishId = config.getItem("Fish Pie", 5047).getInt();
		pieGoldAppleId = config.getItem("Golden Apple Pie", 5048).getInt();
		
		baconRawId = config.getItem("Raw Bacon", 5049).getInt();
		baconSpoiledId = config.getItem("Spoiled Bacon", 5050).getInt();
		baconCookedId = config.getItem("Cooked Bacon", 5051).getInt();
		
		flowerVanillaId = config.getBlock("Vanilla Flower", 918).getInt();
		vanillaExtractId = config.getItem("Vanilla Extract", 5052).getInt();
		creamId = config.getItem("Cream", 5053).getInt();
		cupGlassId = config.getItem("Glass Cup", 5054).getInt();
		cupWaterId = config.getItem("Cup of Water", 5055).getInt();
		
		config.save();
        NetworkRegistry.instance().registerGuiHandler(instance, new EFGuiHandler());
                
        microwaveIdle = (new BlockMicrowave(microwaveID, false)).setHardness(1.5F).setResistance(2.5F).setCreativeTab(this.tabBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("microwave");
        microwaveOn = (new BlockMicrowave(microwaveOnID, true)).setHardness(1.5F).setResistance(2.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("microwaveOn");
        freezer = (new BlockFreezer(freezerID)).setHardness(3.5F).setResistance(5.0F).setCreativeTab(this.tabBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("freezer");
        fridge = (new BlockFridge(fridgeID)).setHardness(3.5F).setResistance(5.0F).setCreativeTab(tabBlocks).setUnlocalizedName("fridge");
        
        oreAluminum = (new EFBlock(oreAluminumID, Material.rock, "alu_ore")).setHardness(4.0F).setResistance(6.0F).setUnlocalizedName("oreAluminum");
        oreSalt = (new EFBlock(oreSaltID, Material.rock, "SaltOre")).setHardness(3.0F).setResistance(4.5F).setUnlocalizedName("oreSalt");
        
        aluminum = (new EFItem(aluminumID, "alu_cooked")).setUnlocalizedName("aluminum");
        salt = (new EFItem(saltID, "salt")).setUnlocalizedName("salt");
        
        knifeStone = (new ItemKnife(knifeStoneID, "knife_stone", 15)).setUnlocalizedName("knifeStone");
        knifeIron = (new ItemKnife(knifeIronID, "knife_iron", 25)).setUnlocalizedName("knifeIron");
        knifeDiamond = (new ItemKnife(knifeDiamondID, "knife_diamond", 50)).setUnlocalizedName("knifeDiamond");
        
        flour = (new EFItem(flourID, "flour")).setUnlocalizedName("flour");
        dough = (new EFItem(doughID, "dough")).setUnlocalizedName("dough");
        syrupChocolate = new EFItem(syrupChocolateID, "chocolate_syrup").setUnlocalizedName("syrupChocolate");
        
        cakeCheese = (new EFCake(cakeCheeseID, "CheesecakeSide", "CheesecakeTop", "CheesecakeBottom", "CheesecakeInside", cakeCheeseItem, 4)).setUnlocalizedName("cakeCheese");
        cakeCheeseItem = (new ItemBlockPlacer(cakeCheeseItemID, cakeCheese, "cake_cheese")).setUnlocalizedName("cakeCheeseItem").setCreativeTab(tabFoods);
        cakeChocolate = new EFCake(cakeChocolateID, "ChocolateCakeSide", "ChocolateCakeTop", "ChocolateCakeBottom", "ChocolateCakeInside", cakeChocolateItem, 4).setUnlocalizedName("cakeChocolate");
        cakeChocolateItem = new ItemBlockPlacer(cakeChocolateItemID, cakeChocolate, "cake_chocolate").setUnlocalizedName("chocolateCakeItem").setCreativeTab(tabFoods);
        cakeGold = new CakePotionEffect(cakeGoldID, "GoldAppleCakeSide", "GoldAppleCakeTop", "GoldAppleCakeBottom", "GoldAppleCakeInside", cakeGoldItem, 4, Potion.regeneration, 5, 1).setUnlocalizedName("cakeGold");
        cakeGoldItem = new ItemBlockPlacer(cakeGoldItemID, cakeGold, "cake_gold").setUnlocalizedName("cakeGoldItem").setCreativeTab(tabFoods);
        cakeExplosive = new BlockCakeExplosive(cakeExplosiveID, cakeExplosiveItem).setUnlocalizedName("cakeExplosive");
        cakeExplosiveItem = new ItemBlockPlacer(cakeExplosiveItemID, cakeExplosive, "cake_explosive").setUnlocalizedName("cakeExplosiveItem").setCreativeTab(tabFoods);
        
        cheeseSpoiled = new EFFood(cheeseSpoiledID, "cheese_spoiled", 3, 0.6F).setPotionEffect(Potion.poison.id, 5, 1, 1.0F).setUnlocalizedName("cheeseSpoiled");
        cheeseBlue = (new EFFoodSpoilable(cheeseBlueID, "cheese_blue", 7, 0.8F, 7, new ItemStack(cheeseSpoiled, 1))).setUnlocalizedName("cheeseBlue");
        cheese = (new EFFoodSpoilable(cheeseID, "cheese", 4, 0.7F, 7, new ItemStack(cheeseBlue, 1))).setUnlocalizedName("cheese");
        
        breadSlice = (new EFFood(breadSliceID, "bread_shit", 1, 0.4F)).setUnlocalizedName("breadSlice");
        
        pepper = new EFFood(pepperID, "pepper", 2, 0.5F).setUnlocalizedName("pepper");
        pepperCrop = new BlockCropPepper(pepperCropID, 7, "crop_pepper_");
        pepperSeed = new EFItemSeed(pepperSeedID, pepperCrop.blockID, Block.tilledField.blockID, "seeds_pepper").setUnlocalizedName("pepperSeeds");
                
        corn = new EFFood(cornID, "corn", 3, 0.5F).setUnlocalizedName("corn");
        cornCrop = new BlockCropCorn(cornCropID, 7, "crop_corn_").setUnlocalizedName("cornCrop");
        cornSeed = new EFItemSeed(cornSeedID, cornCrop.blockID, Block.tilledField.blockID, "seeds_corn").setUnlocalizedName("seedsCorn");
        
        cornCooked = new EFFood(cornCookedID, "corn_cooked", 7, 0.8F).setUnlocalizedName("cornCooked");
        
        rice = new EFFood(riceID, "rice", 1, 0.1F).setUnlocalizedName("rice");
        riceCrop = new BlockCropRice(riceCropID, 4, "cropRice_").setUnlocalizedName("riceCrop");
        riceSeed = new EFItemSeed(riceSeedID, riceCrop.blockID, Block.tilledField.blockID, "seeds_rice").setUnlocalizedName("seedsRice");
        
        chickenSpoiled = new EFFood(chickenSpoiledID, "chicken_spoiled", 4, 0.5F).setPotionEffect(Potion.poison.id, 5, 1,1.0F).setUnlocalizedName("chickenSpoiled");
        chicken = new EFFoodSpoilable(chickenID, "chickenCooked", 6, 0.7F, 7, new ItemStack(chickenSpoiled, 1)).setUnlocalizedName("chicken").setCreativeTab(CreativeTabs.tabFood);  

        fishSpoiled = new EFFood(fishSpoiledID, "fish_spoiled", 3, 0.4F).setPotionEffect(Potion.poison.id, 5, 1,1.0F).setUnlocalizedName("fishSpoiled");
        fish = new EFFoodSpoilable(fishID, "fishCooked", 5, 0.6F, 7, new ItemStack(fishSpoiled, 1)).setUnlocalizedName("fish").setCreativeTab(CreativeTabs.tabFood);
        
        beefSpoiled = new EFFood(beefSpoiledID, "beef_spoiled", 4, 0.6F).setPotionEffect(Potion.poison.id, 5, 1,1.0F).setUnlocalizedName("beefSpoiled");
        beef = new EFFoodSpoilable(beefID, "beefCooked", 8, 0.8F, 8, new ItemStack(beefSpoiled, 1)).setUnlocalizedName("beef").setCreativeTab(CreativeTabs.tabFood);
        
        porkchopSpoiled = new EFFood(porkchopSpoiledID, "porkchop_spoiled", 6, 0.4F).setPotionEffect(Potion.poison.id, 5, 1,1.0F).setUnlocalizedName("porkchopSpoiled");
        porkchop = new EFFoodSpoilable(porkchopID, "porkchopCooked", 8, 8.0F, 8, new ItemStack(porkchopSpoiled, 1)).setUnlocalizedName("porkchop").setCreativeTab(CreativeTabs.tabFood);
        
        pizza = new BlockPizza(pizzaID).setUnlocalizedName("pizza");
        pizzaItem = new ItemBlockPlacer(pizzaItemID, pizza, "pizza_item").setCreativeTab(tabFoods).setUnlocalizedName("pizzaItem");
        pizzaSlice = new EFFood(pizzaSliceID, "pizza_slice", 3, 0.4F).setUnlocalizedName("pizzaSlice");
        
        oreo = new EFFood(oreoID, "oreo", 5, 0.4F).setUnlocalizedName("oreo");
        oreoCake = new EFCake(oreoCakeID,"OreoCakeSide", "OreoCakeTop", "OreoCakeBottom", "OreoCakeInside", oreoCakeItem, 2);
        oreoCakeItem = new ItemBlockPlacer(oreoCakeItemID, oreoCake, "cake_oreo").setUnlocalizedName("oreoCakeItem").setCreativeTab(tabFoods);
        
        netherCake = new CakePotionEffect(netherCakeID, "NetherCake_Side", "NetherCake_Top", "NetherCake_Bottom", "NetherCake_Inside", netherCakeItem, 3, Potion.fireResistance, 5, 1).setUnlocalizedName("netherCake");
        netherCakeItem = new ItemBlockPlacer(netherCakeItemID, netherCake, "cake_nether").setUnlocalizedName("netherCakeItem").setCreativeTab(tabFoods);
        
        calimariRaw = new EFFood(calimariRawID, "calimari_raw", 4, 0.6F).setPotionEffect(Potion.hunger.id, 10, 1, 0.5F).setUnlocalizedName("calimariRaw");
        calimariCooked = new EFFood(calimariCookedID, "calimari_cooked", 8, 0.7F).setUnlocalizedName("calimariCooked");
        
        lambchopRaw = new EFFood(lambchopRawID, "lambchop_raw", 4, 0.6F).setPotionEffect(Potion.hunger.id, 10, 1, 0.5F).setUnlocalizedName("lambchopRaw");
        lambchopCooked = new EFFood(lambchopCookedID, "lambchop_cooked", 8, 1.0F).setUnlocalizedName("lambchopCooked");
        
        meatblockRaw = new BlockMeatblockRaw(meatblockRawID).setUnlocalizedName("meatblockRaw").setCreativeTab(tabBlocks);
        meatblockCooked = new BlockMeatblockRaw(meatblockCookedID).setUnlocalizedName("meatblockCooked").setCreativeTab(tabBlocks);
        
        sausage = new EFFood(sausageID, "sausage", 6, 0.6F).setUnlocalizedName("sausage");
        
        pieApple = new EFFood(pieAppleId, "pie_apple", 7, 0.7F).setUnlocalizedName("pieApple");
        pieBacon = new EFFood(pieBaconId, "pie_bacon", 8, 0.7F).setUnlocalizedName("pieBacon");
        pieCheese = new EFFood(pieCheeseId, "pie_cheese", 7, 0.7F).setUnlocalizedName("pieCheese");
        pieChicken = new EFFood(pieChickenId, "pie_chicken", 9, 0.7F).setUnlocalizedName("pieChicken");
        pieChocolate = new EFFood(pieChocolateId, "pie_chocolate", 8, 0.7F).setUnlocalizedName("pieChocolate");
        pieFish = new EFFood(pieFishId, "pie_fish", 8, 0.7F).setUnlocalizedName("pieFish");
        pieGoldApple = new EFFood(pieGoldAppleId, "pie_goldApple", 8, 0.7F).setUnlocalizedName("pieGoldApple");

        baconRaw = new EFFood(baconRawId, "bacon", 1, 0.4F).setPotionEffect(Potion.hunger.id, 10, 1, 0.5F).setUnlocalizedName("baconRaw");
        baconSpoiled = new EFFood(baconSpoiledId, "bacon_spoiled", 2, 0.3F).setPotionEffect(Potion.poison.id, 5, 1,1.0F).setUnlocalizedName("baconSpoiled");
        baconCooked = new EFFoodSpoilable(baconCookedId, "bacon_cooked", 2, 0.4F, 7, new ItemStack(baconSpoiled, 1)).setUnlocalizedName("baconCooked");
        
        flowerVanilla = (EFBlockFlower)new EFBlockFlower(flowerVanillaId, "flower_vanilla").setUnlocalizedName("flowerVanilla").setStepSound(Block.soundGrassFootstep);
        vanillaExtract = new EFItem(vanillaExtractId, "vanilla_extract").setUnlocalizedName("vanillaExtract");
        cream = new EFItem(creamId, "cream").setUnlocalizedName("cream");
        cupGlass = new ItemGlassCup(cupGlassId, 0).setUnlocalizedName("cupGlass");
        cupWater = new ItemWaterCup(cupWaterId).setUnlocalizedName("cupWater");
        
        removeRecipe(new ItemStack(Item.pumpkinPie, 1, 0));
        
		NameManager.loadNames();
		RecipeManager.loadRecipes();
		BlockRegistry.registerBlocks();		 
	}
	
	@EventHandler
    public void load(FMLInitializationEvent event)
	{
	    
        MinecraftForge.EVENT_BUS.register(new EFEventHandler());
        MinecraftForge.EVENT_BUS.register(new EFSoundHandler());
        
        ModLoader.registerEntityID(EntityCakeMan.class, "CakeMan", ModLoader.getUniqueEntityId(), 0x646464, 0x3A3A3A);
        RenderingRegistry.registerEntityRenderingHandler(EntityCakeMan.class, new RenderCakeMan());
        LanguageRegistry.instance().addStringLocalization("entity.CakeMan.name", "Cake Man");
        ModLoader.addSpawn(EntityCakeMan.class, 9, 4, 4, EnumCreatureType.creature);
        
		TickRegistry.registerTickHandler(new ClientTickHandler(EnumSet.of(TickType.CLIENT)), Side.CLIENT);
        TickRegistry.registerTickHandler(new ServerTickHandler(EnumSet.of(TickType.SERVER)), Side.SERVER);
		TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);
                
        MinecraftForge.setBlockHarvestLevel(oreAluminum, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(oreSalt, "pickaxe", 1);
        
		proxy.registerRenderThings();
		
		NetworkRegistry.instance().registerConnectionHandler(new NetworkHandler());
		GameRegistry.registerWorldGenerator(new EFOreGenerator());
		GameRegistry.registerCraftingHandler(new EFCraftingManager());
		
        Item.itemsList[Item.chickenCooked.itemID - 256] = chicken;
        Item.itemsList[Item.fishCooked.itemID - 256] = fish;
        Item.itemsList[Item.beefCooked.itemID - 256] = beef;
        Item.itemsList[Item.porkCooked.itemID - 256] = porkchop; 
	}

	
	@EventHandler
    public void myNewPostLoadMethod(FMLPostInitializationEvent event)
	{
		
	}
	
	private static void removeRecipe(ItemStack resultItem)
	{
		ItemStack recipeResult = null;
		ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
		for (int scan = 0; scan < recipes.size(); scan++)
		{
			IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
			recipeResult = tmpRecipe.getRecipeOutput();
			if (recipeResult != null) {
				if (recipeResult.itemID == resultItem.itemID && recipeResult.getItemDamage() == resultItem.getItemDamage())
				{
					System.out.println("CrazyFoods: Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
					recipes.remove(scan);
					scan--; //list is shifted after remove! Adjust index, so next time we will check this value again.
				}
			}
		}
	}
}
