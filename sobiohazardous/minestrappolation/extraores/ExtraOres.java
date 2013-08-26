package sobiohazardous.minestrappolation.extraores;

import java.util.Map;
import java.util.Random;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.EnumSet;
import java.util.logging.Level;

import javax.swing.text.html.parser.Entity;

import org.lwjgl.input.Keyboard;

import sobiohazardous.minestrappolation.extradecor.tileentity.TileEntityCardboardWet;
import sobiohazardous.minestrappolation.extraores.block.*;
import sobiohazardous.minestrappolation.extraores.client.renderer.RenderGrenade;
import sobiohazardous.minestrappolation.extraores.client.renderer.RenderNukePrimed;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenade;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenadeImpact;
import sobiohazardous.minestrappolation.extraores.entity.EntityGrenadeSticky;
import sobiohazardous.minestrappolation.extraores.entity.EntityNukePrimed;
import sobiohazardous.minestrappolation.extraores.entity.EntityInstantExplosion;
import sobiohazardous.minestrappolation.extraores.gen.EOOreGenerator;
import sobiohazardous.minestrappolation.extraores.handler.ClientPacketHandler;
import sobiohazardous.minestrappolation.extraores.handler.ClientTickHandler;
import sobiohazardous.minestrappolation.extraores.handler.GuiHandler;
import sobiohazardous.minestrappolation.extraores.handler.BlacksmithTradeHandler;
import sobiohazardous.minestrappolation.extraores.handler.PriestTradeHandler;
import sobiohazardous.minestrappolation.extraores.handler.RenderingHandler;
import sobiohazardous.minestrappolation.extraores.handler.ServerPacketHandler;
import sobiohazardous.minestrappolation.extraores.handler.PlayerTickHandler;
import sobiohazardous.minestrappolation.extraores.item.*;
import sobiohazardous.minestrappolation.extraores.lib.EOBlockRegister;
import sobiohazardous.minestrappolation.extraores.lib.EOFuelHandler;
import sobiohazardous.minestrappolation.extraores.lib.EONameManager;
import sobiohazardous.minestrappolation.extraores.lib.EORecipeManager;
import sobiohazardous.minestrappolation.extraores.proxy.CommonProxy;
import sobiohazardous.minestrappolation.extraores.tileentity.TileEntityMelter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStep;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.Mod.ServerStarted;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * 
 * 
 * 
 * @author SoBiohazardous
 */

@NetworkMod(clientSideRequired = true, serverSideRequired = true,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"extraoresChan"}, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"extroresChan"}, packetHandler = ServerPacketHandler.class))
@Mod ( modid = "ExtraOres", name="Extrapolated Ores", version="B1.3", dependencies = "required-after:Minestrappolation")
public class ExtraOres 
{	
	@SidedProxy(clientSide = "sobiohazardous.minestrappolation.extraores.proxy.ClientProxy", serverSide = "sobiohazardous.minestrappolation.extraores.proxy.CommonProxy")
    public static CommonProxy proxy;
		
	public static int 
	meuroditeOreId, 
	meuroditeBlockId, 
	meuroditeIngotId, 
	meuroditeSwordId, 
	meuroditePickaxeId, 
	meuroditeAxeId, 
	meuroditeHoeId, 
	meuroditeShovelId, 
	meuroditeHelmetId, 
	meuroditeChestId, 
	meuroditePantsId, 
	meuroditeBootsId,
	uraniumOreId,
	uraniumId,
	rawUraniumBlockId,
	plutoniumOreId,
	plutoniumId,
	rawPlutoniumBlockId,
	titaniumOreId,
	titaniumIngotId,
	titaniumSwordId,
	titaniumPickaxeId,
	titaniumAxeId,
	titaniumHoeId,
	titaniumShovelId,
	titaniumHelmetId,
	titaniumChestId,
	titaniumPantsId,
	titaniumBootsId,
	titaniumBlockId,
	sunstoneId,
	sunstoneDustId,
	sunstoneOreId,
	toriteOreId,
	toriteIngotId,
	toriteBlockId,
	toriteSwordId,
	toritePickaxeId,
	toriteAxeId,
	toriteHoeId,
	toriteShovelId,
	toriteHelmetId,
	toriteChestId,
	toritePantsId,
	toriteBootsId,
	graniteId,
	graniteBrickId,
	quartziteId,
	quartziteTileId,
	blaziumOreId,
	blaziumBlockId,
	blaziumShardId,
	blaziumIngotId,
	blaziumSwordId,
	blaziumPickaxeId,
	blaziumAxeId,
	blaziumHoeId,
	blaziumShovelId,
	blaziumHelmetId,
	blaziumChestId,
	blaziumPantsId,
	blaziumBootsId,
	copperOreId,
	copperBlockId,
	copperIngotId,
	copperTarnishedId,
	copperSwordId,
	copperPickaxeId,
	copperAxeId,
	copperHoeId,
	copperShovelId,
	tinOreId,
	tinIngotId,
	tinBlockId,
	tinHelmetId,
	tinChestId,
	tinPantsId,
	tinBootsId,
	tinPlateId,
	bronzePlateId,
	steelPlateId,
	tinPlateItemId,
	bronzePlateItemId,
	steelPlateItemId,
	coalIronIngotId,
	steelIngotId,
	steelPickaxeId,
	steelAxeId,
	steelShovelId,
	steelHoeId,
	steelSwordId,
	steelHelmetId,
	steelChestId,
	steelPantsId,
	steelBootsId,
	steelBlockId,
	soulOreId,
	soulGemId,
	smoothQuartziteId,
	pillarQuartziteId,
	chiseledQuartziteId,
	smoothQuartzTileId,
	pinkQuartzId,
	sandstonePickaxeId,
	sandstoneShovelId,
	sandstoneAxeId,
	sandstoneHoeId,
	sandstoneSwordId,
	tinPlatedCobbleId,
	tinPlatedMossyId,
	tinPlatedStoneBrickId,
	tinPlatedChiseledId,
	tinPlatedGraniteId,
	bronzeIngotId,
	bronzePickaxeId,
	bronzeShovelId,
	bronzeAxeId,
	bronzeHoeId,
	bronzeSwordId,
	bronzeHelmetId,
	bronzeChestId,
	bronzePantsId,
	bronzeBootsId,
	bronzeBlockId,
	bronzePlatedCobbleId,
	bronzePlatedMossyId,
	bronzePlatedStoneBrickId,
	bronzePlatedChiseledId,
	bronzePlatedGraniteId,
	invinciumId,
	extraOresBedrockId,
	bedrockPickaxeId,
	bedrockAxeId,
	bedrockShovelId,
	bedrockHoeId,
	steelPlatedCobbleId,
	steelPlatedMossyId,
	steelPlatedStoneBrickId,
	steelPlatedChiseledId,
	steelPlatedGraniteId,
	granitePickaxeId,
	graniteShovelId,
	graniteAxeId,
	graniteHoeId,
	graniteSwordId,
	soulBottleId,
	nukeId,
	grenadeId,
	grenadeImpactId,
	grenadeStickyId,
	BPmeuroditeSwordId,
	BPmeuroditePickaxeId,
	BPmeuroditeAxeId,
	BPmeuroditeHoeId,
	BPmeuroditeShovelId,
	BPmeuroditeHelmetId,
	BPmeuroditeChestId,
	BPmeuroditePantsId,
	BPmeuroditeBootsId,
	BPTitaniumSwordId,
	BPTitaniumPickaxeId,
	BPTitaniumAxeId,
	BPTitaniumHoeId,
	BPTitaniumShovelId,
	BPTitaniumHelmetId,
	BPTitaniumChestId,
	BPTitaniumPantsId,
	BPTitaniumBootsId,
	BPToriteSwordId,
	BPToritePickaxeId,
	BPToriteAxeId,
	BPToriteHoeId,
	BPToriteShovelId,
	BPToriteHelmetId,
	BPToriteChestId,
	BPToritePantsId,
	BPToriteBootsId,
	BPBlaziumSwordId,
	BPBlaziumPickaxeId,
	BPBlaziumAxeId,
	BPBlaziumHoeId,
	BPBlaziumShovelId,
	BPBlaziumHelmetId,
	BPBlaziumChestId,
	BPBlaziumPantsId,
	BPBlaziumBootsId,
	BPCopperSwordId,
	BPCopperPickaxeId,
	BPCopperAxeId,
	BPCopperHoeId,
	BPCopperShovelId,
	BPTinHelmetId,
	BPTinChestId,
	BPTinPantsId,
	BPTinBootsId,
	BPSteelPickaxeId,
	BPSteelAxeId,
	BPSteelShovelId,
	BPSteelHoeId,
	BPSteelSwordId,
	BPSteelHelmetId,
	BPSteelChestId,
	BPSteelPantsId,
	BPSteelBootsId,
	BPSandstonePickaxeId,
	BPSandstoneShovelId,
	BPSandstoneAxeId,
	BPSandstoneHoeId,
	BPSandstoneSwordId,
	BPBedrockPickaxeId,
	BPBedrockAxeId,
	BPBedrockShovelId,
	BPBedrockHoeId,
	BPGranitePickaxeId,
	BPGraniteShovelId,
	BPGraniteAxeId,
	BPGraniteHoeId,
	BPGraniteSwordId,
	BPWoodPickaxeId,
	BPWoodAxeId,
	BPWoodShovelId,
	BPWoodHoeId,
	BPWoodSwordId,
    BPClothHelmetId,
	BPClothChestId,
	BPClothPantsId,
	BPClothBootsId,
	BPStonePickaxeId,
	BPStoneAxeId,
	BPStoneShovelId,
	BPStoneHoeId,
	BPStoneSwordId,
	BPChainHelmetId,
	BPChainChestId,
	BPChainPantsId,
	BPChainBootsId,
	BPIronPickaxeId,
	BPIronAxeId,
	BPIronShovelId,
	BPIronHoeId,
	BPIronSwordId,
	BPIronHelmetId,
	BPIronChestId,
	BPIronPantsId,
	BPIronBootsId,
	BPGoldPickaxeId,
	BPGoldAxeId,
	BPGoldShovelId,
	BPGoldHoeId,
	BPGoldSwordId,
	BPGoldHelmetId,
	BPGoldChestId,
	BPGoldPantsId,
	BPGoldBootsId,
	BPDiamondPickaxeId,
	BPDiamondAxeId,
	BPDiamondShovelId,
	BPDiamondHoeId,
	BPDiamondSwordId,
	BPDiamondHelmetId,
	BPDiamondChestId,
	BPDiamondPantsId,
	BPDiamondBootsId,
	smoothRadiantQuartzId,
	chiseledRadiantQuartzId,
	pillarRadiantQuartzId,
	radiantQuartzOreId,
	radiantQuartzId,
	godstoneId,
	melterIdleId,
	melterBurningId,
	radiantQuartzStairsId,
	radiantQuartzSingleSlabId,
	radiantQuartzDoubleSlabId,
	pinkQuartzStairsId,
	pinkQuartzSingleSlabId,
	pinkQuartzDoubleSlabId,
	graniteBrickStairsId,
	graniteBrickSingleSlabId,
	graniteBrickDoubleSlabId,
	tinPlatedCobbleStairsId,
	tinPlatedCobbleSingleSlabId,
	tinPlatedCobbleDoubleSlabId,
	steelPlatedCobbleStairsId,
	steelPlatedCobbleSingleSlabId,
	steelPlatedCobbleDoubleSlabId,	
	bronzePlatedCobbleStairsId,
	bronzePlatedCobbleSingleSlabId,
	bronzePlatedCobbleDoubleSlabId,
	tinPlatedStoneBrickStairsId,
	tinPlatedStoneBrickSingleSlabId,
	tinPlatedStoneBrickDoubleSlabId,
	steelPlatedStoneBrickStairsId,
	steelPlatedStoneBrickSingleSlabId,
	steelPlatedStoneBrickDoubleSlabId,
	bronzePlatedStoneBrickStairsId,
	bronzePlatedStoneBrickSingleSlabId,
	bronzePlatedStoneBrickDoubleSlabId,
	tinPlatedGraniteBrickStairsId,
	tinPlatedGraniteBrickSingleSlabId,
	tinPlatedGraniteBrickDoubleSlabId,
	steelPlatedGraniteBrickStairsId,
	steelPlatedGraniteBrickSingleSlabId,
	steelPlatedGraniteBrickDoubleSlabId,
	bronzePlatedGraniteBrickStairsId,
	bronzePlatedGraniteBrickSingleSlabId,
	bronzePlatedGraniteBrickDoubleSlabId,
	plutoniumInsulatedId,
	uraniumInsulatedId;
	
	public static Block meuroditeOre;
	public static Block meuroditeBlock;
	
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
	
	public static  Block UraniumOre;
	public static Item Uranium;
	public static Block RawUraniumBlock;
	
	public static Block PlutoniumOre;
	public static Item Plutonium;
	public static Block RawPlutoniumBlock;
	
	public static Block TitaniumOre;
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
	
	public static Block TitaniumBlock;
	
	public static Block Sunstone;
	public static Item SunstoneDust;
	public static Block SunstoneOre;
	
	public static Block ToriteOre; 
	public static Item ToriteIngot;
	public static Block ToriteBlock;
	
	public static Item ToriteSword;
	public static Item ToritePickaxe;
	public static Item ToriteAxe;
	public static Item ToriteHoe;
	public static Item ToriteShovel;
	
	public static Item ToriteHelmet;
	public static Item ToriteChest;
	public static Item ToritePants;
	public static Item ToriteBoots;
	
	public static Block Granite;
	public static Block GraniteBrick;
	
	public static Block Quartzite;
	public static Block QuartziteTile;
	
	public static Block BlaziumOre;
	public static Block BlaziumBlock;
	
	public static Item BlazeShard;
	public static Item BlaziumIngot;

	public static Item BlaziumSword;
	public static Item BlaziumPickaxe;
	public static Item BlaziumAxe;
	public static Item BlaziumHoe;
	public static Item BlaziumShovel;
	
	public static Item BlaziumHelmet;
	public static Item BlaziumChest;
	public static Item BlaziumPants;
	public static Item BlaziumBoots;
	
	public static Block CopperOre;
	public static Block CopperBlock;
	public static Item CopperIngot;
	
	public static  Block CopperBlockTarnished;
	
	public static Item CopperSword;
	public static Item CopperPickaxe;
	public static Item CopperAxe;
	public static Item CopperHoe;
	public static Item CopperShovel;
	
	public static Block TinOre;
	public static Item TinIngot;
	public static Block TinBlock;
	
	public static Item TinHelmet;
	public static Item TinChest;
	public static Item TinPants;
	public static Item TinBoots;
	
	public static Block TinPlate;
	public static Block BronzePlate;
	public static Block SteelPlate;
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
	public static Block SteelBlock;
	
	public static Block SoulOre;
	public static Item SoulGem;
	
	public static Block SmoothQuartzite;
	public static Block PillarQuartzite;
	public static Block ChiseledQuartzite;
	public static Block SmoothQuartzTile;
	public static Item PinkQuartz;
	
	public static Item SandstonePickaxe;
	public static Item SandstoneShovel;
	public static Item SandstoneAxe;
	public static Item SandstoneHoe;
	public static Item SandstoneSword;
	
	public static Block TinPlatedCobble;
	public static Block TinPlatedMossy;
	public static Block TinPlatedStoneBrick;
	public static Block TinPlatedChiseled;
	public static Block TinPlatedGranite;
	
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
	public static Block BronzeBlock;
	
	public static Block BronzePlatedCobble;
	public static Block BronzePlatedMossy;
	public static Block BronzePlatedStoneBrick;
	public static Block BronzePlatedChiseled;
	public static Block BronzePlatedGranite;
	
	public static Block Invincium;

	public static Item BedrockPickaxe;
	public static Item BedrockAxe;
	public static Item BedrockShovel;
	public static Item BedrockHoe;
	
	public static Block SteelPlatedCobble;
	public static Block SteelPlatedMossy;
	public static Block SteelPlatedStoneBrick;
	public static Block SteelPlatedChiseled;
	public static Block SteelPlatedGranite;
	
	public static Item GranitePickaxe;
	public static Item GraniteShovel;
	public static Item GraniteAxe;
	public static Item GraniteHoe;
	public static Item GraniteSword;
	
	public static Item SoulBottle;
	
	public static Block nuke;
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
	
	public static Block SmoothRadiantQuartz;
	public static Block ChiseledRadiantQuartz;
	public static Block PillarRadiantQuartz;
	public static Block RadiantQuartzOre;
	
	public static Item RadiantQuartz;
	
	public static Block Godstone;
	
	public static Block melterIdle;
	public static Block melterBurning;
	
	public static Block RadiantQuartzStairs;
	public static BlockHalfSlab RadiantQuartzSingleSlab;
	public static BlockHalfSlab RadiantQuartzDoubleSlab;
	
	public static Block PinkQuartzStairs;
	public static BlockHalfSlab PinkQuartzSingleSlab;
	public static BlockHalfSlab PinkQuartzDoubleSlab;
	
	public static Block graniteBrickStairs;
	public static BlockHalfSlab graniteBrickSingleSlab;
	public static BlockHalfSlab graniteBrickDoubleSlab;
	
	public static Block tinPlatedCobbleStairs;
	public static BlockHalfSlab tinPlatedCobbleSingleSlab;
	public static BlockHalfSlab tinPlatedCobbleDoubleSlab;
	
	public static Block steelPlatedCobbleStairs;
	public static BlockHalfSlab steelPlatedCobbleSingleSlab;
	public static BlockHalfSlab steelPlatedCobbleDoubleSlab;
	
	public static Block bronzePlatedCobbleStairs;
	public static BlockHalfSlab bronzePlatedCobbleSingleSlab;
	public static BlockHalfSlab bronzePlatedCobbleDoubleSlab;
	
	public static Block tinPlatedStoneBrickStairs;
	public static BlockHalfSlab tinPlatedStoneBrickSingleSlab;
	public static BlockHalfSlab tinPlatedStoneBrickDoubleSlab;
	
	public static Block steelPlatedStoneBrickStairs;
	public static BlockHalfSlab steelPlatedStoneBrickSingleSlab;
	public static BlockHalfSlab steelPlatedStoneBrickDoubleSlab;
	
	public static Block bronzePlatedStoneBrickStairs;
	public static BlockHalfSlab bronzePlatedStoneBrickSingleSlab;
	public static BlockHalfSlab bronzePlatedStoneBrickDoubleSlab;
	
	public static Block tinPlatedGraniteBrickStairs;
	public static BlockHalfSlab tinPlatedGraniteBrickSingleSlab;
	public static BlockHalfSlab tinPlatedGraniteBrickDoubleSlab;
	
	public static Block steelPlatedGraniteBrickStairs;
	public static BlockHalfSlab steelPlatedGraniteBrickSingleSlab;
	public static BlockHalfSlab steelPlatedGraniteBrickDoubleSlab;
	
	public static Block bronzePlatedGraniteBrickStairs;
	public static BlockHalfSlab bronzePlatedGraniteBrickSingleSlab;
	public static BlockHalfSlab bronzePlatedGraniteBrickDoubleSlab;
	
	public static Block plutoniumInsulated;
	public static Block uraniumInsulated;
	
	public static int plateRenderId = RenderingRegistry.getNextAvailableRenderId();
	
	public static CreativeTabs tabOresBlocks = new CreativeTabExtraoresBlocks(CreativeTabs.getNextID(),"Extrappolated Ores - Blocks");
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

	@Instance("ExtraOres")
	public static ExtraOres instance;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	@Mod.EventHandler
    public void myNewPreLoadMethod(FMLPreInitializationEvent evt)	
   {    

		//blocks 3000
		//items 1000;
		Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
	    config.load();
	    
	    meuroditeOreId = config.getBlock("meurodite Ore", 3000).getInt();
	    meuroditeBlockId = config.getBlock("meurodite Block", 3001).getInt();
	    meuroditeIngotId = config.getItem("meurodite Ingot", 1000).getInt();
	    meuroditeSwordId = config.getItem("meurodite Sword", 1001).getInt();
		meuroditePickaxeId = config.getItem("meurodite Pickaxe", 1002).getInt();
		meuroditeAxeId = config.getItem("meurodite Axe", 1003).getInt(); 
		meuroditeHoeId = config.getItem("meurodite Hoe", 1004).getInt(); 
		meuroditeShovelId = config.getItem("meurodite Shovel", 1005).getInt(); 
		meuroditeHelmetId = config.getItem("meurodite Helmet", 1006).getInt();  
		meuroditeChestId = config.getItem("meurodite Chest", 1007).getInt(); 
		meuroditePantsId = config.getItem("meurodite Pants", 1008).getInt();  
		meuroditeBootsId = config.getItem("meurodite Boots", 1009).getInt(); 
		uraniumOreId = config.getBlock("Uranium Ore", 3002).getInt();
		uraniumId = config.getItem("Uranium", 1010).getInt();
		rawUraniumBlockId = config.getBlock("Raw Uranium", 3003).getInt();
		plutoniumOreId = config.getBlock("Plutonium Ore", 3004).getInt();
		plutoniumId = config.getItem("Plutonium", 1011).getInt();
		rawPlutoniumBlockId = config.getBlock("Raw Plutonium", 3005).getInt();
		titaniumOreId = config.getBlock("Titanium Ore", 3006).getInt(); 
		titaniumIngotId = config.getItem("Titanium Ingot", 1012).getInt();
		titaniumSwordId = config.getItem("Titanium Sword", 1013).getInt(); 
		titaniumPickaxeId = config.getItem("Titanium Pick", 1014).getInt();
		titaniumAxeId = config.getItem("Titanium Axe", 1015).getInt();
		titaniumHoeId = config.getItem("Titanium Hoe", 1016).getInt();
		titaniumShovelId = config.getItem("Titanium Shovel", 1017).getInt();
		titaniumHelmetId = config.getItem("Titanium Helmet", 1018).getInt();
		titaniumChestId = config.getItem("Titanium Chest", 1019).getInt();
		titaniumPantsId = config.getItem("Titanium Pants", 1020).getInt();
		titaniumBootsId = config.getItem("Titanium Boots", 1021).getInt();
		titaniumBlockId = config.getBlock("Titanium Block", 3007).getInt(); 
		sunstoneId = config.getBlock("Sunstone", 3008).getInt();
		sunstoneDustId = config.getItem("Sunstone Dust", 1022).getInt();
		sunstoneOreId = config.getBlock("Sunstone Ore", 3009).getInt();
		toriteOreId = config.getBlock("Torite Ore", 3010).getInt();
		toriteIngotId = config.getItem("Torite Ingot", 1023).getInt();
		toriteBlockId = config.getBlock("Torite Block", 3011).getInt();
		toriteSwordId = config.getItem("Torite Sword", 1024).getInt();
		toritePickaxeId = config.getItem("Torite Pick", 1025).getInt();
		toriteAxeId = config.getItem("Torite Axe", 1026).getInt();
		toriteHoeId = config.getItem("Torite Hoe", 1027).getInt();
		toriteShovelId = config.getItem("Torite Shovel", 1028).getInt();
		toriteHelmetId = config.getItem("Torite Helmet", 1029).getInt();
		toriteChestId = config.getItem("Torite Chest", 1030).getInt();
		toritePantsId = config.getItem("Torite Pants", 1031).getInt();
		toriteBootsId = config.getItem("Torite Boots", 1032).getInt();
		graniteId = config.getBlock("Granite", 3012).getInt();
		graniteBrickId = config.getBlock("Granite Brick", 3013).getInt();
		quartziteId = config.getBlock("Quartzite", 3014).getInt();
		quartziteTileId = config.getBlock("Quartzite Tile", 3015).getInt();
		blaziumOreId = config.getBlock("Blazium Ore", 3016).getInt();
		blaziumBlockId = config.getBlock("Blazium Block", 3017).getInt();
		blaziumShardId = config.getItem("Blazium Shard", 1033).getInt();
		blaziumIngotId = config.getItem("Blazium Ingot", 1034).getInt();
		blaziumSwordId = config.getItem("Blazium Sword", 1035).getInt();
		blaziumPickaxeId = config.getItem("Blazium Pickaxe", 1036).getInt();
		blaziumAxeId = config.getItem("Blazium Axe", 1037).getInt();
		blaziumHoeId = config.getItem("Blazium Hoe", 1038).getInt();
		blaziumShovelId = config.getItem("Blazium Shovel", 1039).getInt();
		blaziumHelmetId = config.getItem("Blazium Helmet", 1040).getInt();
		blaziumChestId = config.getItem("Blazium Chest", 1041).getInt();
		blaziumPantsId = config.getItem("Blazium Pants", 1042).getInt();
		blaziumBootsId = config.getItem("Blazium Boots", 1043).getInt();
		copperOreId = config.getBlock("Copper Ore", 3018).getInt();
		copperBlockId = config.getBlock("Copper Block", 3019).getInt();
		copperIngotId = config.getItem("Copper Ingot", 1044).getInt();
		copperTarnishedId = config.getBlock("Copper Tarnished", 3020).getInt();
		copperSwordId = config.getItem("Copper Sword", 1045).getInt();
		copperPickaxeId = config.getItem("Copper Pick", 1046).getInt();
		copperAxeId = config.getItem("Copper Axe", 1047).getInt();
		copperHoeId = config.getItem("Copper Hoe", 1048).getInt();
		copperShovelId = config.getItem("Copper Shovel", 1049).getInt();
		tinOreId = config.getBlock("Tin Ore", 3021).getInt();
		tinIngotId = config.getItem("Tin Ingot", 1050).getInt();
		tinBlockId = config.getBlock("Tin Block", 3022).getInt();
		tinHelmetId = config.getItem("Tin Helmet", 1051).getInt();
		tinChestId = config.getItem("Tin Chest", 1052).getInt();
		tinPantsId = config.getItem("Tin Pants", 1053).getInt();
		tinBootsId = config.getItem("Tin Boots", 1054).getInt();
		tinPlateId = config.getBlock("Tin Plate Block", 3023).getInt();
		bronzePlateId = config.getBlock("Bronze Plate Block", 3024).getInt();
		steelPlateId = config.getBlock("Steel Plate Block", 3025).getInt();
		tinPlateItemId = config.getItem("Tin Plate Item", 1055).getInt();
		bronzePlateItemId = config.getItem("Bronze Plate Item", 1056).getInt();
		steelPlateItemId = config.getItem("Steel Plate Item", 1057).getInt();
		coalIronIngotId = config.getItem("Coal Iron Ingot", 1058).getInt();
		steelIngotId = config.getItem("Steel Ingot", 1059).getInt();
		steelPickaxeId = config.getItem("Steel Pickaxe", 1060).getInt();
		steelAxeId = config.getItem("Steel Axe", 1061).getInt();
		steelShovelId = config.getItem("Steel Shovel", 1062).getInt();
		steelHoeId = config.getItem("Steel Hoe", 1063).getInt();
		steelSwordId = config.getItem("Steel Sword", 1064).getInt();
		steelHelmetId = config.getItem("Steel Helmet", 1065).getInt();
		steelChestId = config.getItem("Steel Chest", 1066).getInt();
		steelPantsId = config.getItem("Steel Pants", 1067).getInt();
		steelBootsId = config.getItem("Steel Boots", 1068).getInt();
		steelBlockId = config.getBlock("Steel Block", 3026).getInt();
		soulOreId = config.getBlock("Soul Ore", 3027).getInt();
		soulGemId = config.getItem("Soul Gem", 1069).getInt();
		smoothQuartziteId = config.getBlock("Smooth Quartzite", 3028).getInt();
		pillarQuartziteId = config.getBlock("Quartzite Pillar", 3029).getInt();
		chiseledQuartziteId = config.getBlock("Chiseled Quartzite", 3030).getInt();
		smoothQuartzTileId = config.getBlock("Smooth Quartzite Tile", 3031).getInt();
		pinkQuartzId = config.getItem("Pink Quartz", 1070).getInt();
		sandstonePickaxeId = config.getItem("Sandstone Pick", 1071).getInt();
		sandstoneShovelId = config.getItem("Sandstone Shovel", 1072).getInt();
		sandstoneAxeId = config.getItem("Sandstone Axe", 1073).getInt();
		sandstoneHoeId = config.getItem("Sandstone Hoe", 1074).getInt();
		sandstoneSwordId = config.getItem("Sandstone Sword", 1075).getInt();
		tinPlatedCobbleId = config.getBlock("Tin Plated Cobble", 3032).getInt();
		tinPlatedMossyId = config.getBlock("Tin Plated Mossy", 3033).getInt();
		tinPlatedStoneBrickId = config.getBlock("Tine Plate Stone Brick", 3034).getInt();
		tinPlatedChiseledId = config.getBlock("Tin Plate Chiseled", 3035).getInt();
		tinPlatedGraniteId = config.getBlock("Tin Plated Granite", 3036).getInt();
		bronzeIngotId = config.getItem("Bronze Ingot", 1076).getInt();
		bronzePickaxeId = config.getItem("Bronze Pick", 1077).getInt();
		bronzeShovelId = config.getItem("Bronze Shovel", 1078).getInt();
		bronzeAxeId = config.getItem("Bronze Axe", 1079).getInt();
		bronzeHoeId = config.getItem("Bronze Hoe", 1080).getInt();
		bronzeSwordId = config.getItem("Bronze Sword", 1081).getInt();
		bronzeHelmetId = config.getItem("Bronze Helmet", 1082).getInt();
		bronzeChestId = config.getItem("Bronze Chest", 1083).getInt();
		bronzePantsId = config.getItem("Bronze Pants", 1084).getInt();
		bronzeBootsId = config.getItem("Bronze Boots", 1085).getInt();
		bronzeBlockId = config.getBlock("Bronze Block", 3037).getInt();
		bronzePlatedCobbleId = config.getBlock("Bronze Plated Cobble", 3038).getInt();
		bronzePlatedMossyId = config.getBlock("Bronze Plated Mossy", 3039).getInt();
		bronzePlatedStoneBrickId = config.getBlock("Bronze Plated Stone Brick", 3040).getInt();
		bronzePlatedChiseledId = config.getBlock("Bronze Plated Chiseled", 3041).getInt();
		bronzePlatedGraniteId = config.getBlock("Bronze Plated Granite", 3042).getInt();
		invinciumId = config.getBlock("Invincium", 3043).getInt();
		extraOresBedrockId = config.getBlock("Extra Ores Bedrock", 3044).getInt();
		bedrockPickaxeId = config.getItem("Bedrock Pickaxe", 1086).getInt();
		bedrockAxeId = config.getItem("Bedrock Axe", 1087).getInt();
		bedrockShovelId = config.getItem("Bedrock Shovel", 1088).getInt();
		bedrockHoeId = config.getItem("Bedrock Hoe", 1089).getInt(); 
		steelPlatedCobbleId = config.getBlock("Steel Plated Cobble", 3045).getInt();
		steelPlatedMossyId = config.getBlock("Steel Plated Mossy", 3046).getInt();
		steelPlatedStoneBrickId = config.getBlock("Steel Plated Stone Brick", 3047).getInt();
		steelPlatedChiseledId = config.getBlock("Steel Plated Chiseled", 3048).getInt();
		steelPlatedGraniteId = config.getBlock("Steel Plated Granite", 3049).getInt();
		granitePickaxeId = config.getItem("Granite Pickaxe", 1090).getInt();
		graniteShovelId = config.getItem("Granite Shovel", 1091).getInt();
		graniteAxeId = config.getItem("Granite Axe", 1092).getInt();
		graniteHoeId = config.getItem("Granite Hoe", 1093).getInt();
		graniteSwordId = config.getItem("Granite Sword", 1094).getInt();
		soulBottleId = config.getItem("Soul Bottle", 1095).getInt();
		nukeId = config.getBlock("Nuke", 3050).getInt();
		grenadeId = config.getItem("Nuke Grenade", 1096).getInt();
		grenadeImpactId = config.getItem("Grenade Impact", 1097).getInt(); 
		grenadeStickyId = config.getItem("Grenade Sticky", 1098).getInt();
		BPmeuroditeSwordId = config.getItem("BP meurodite Sword", 1099).getInt();
		BPmeuroditePickaxeId = config.getItem("BP meurodite Pickaxe", 1100).getInt();
		BPmeuroditeAxeId = config.getItem("BP meurodite Axe", 1101).getInt(); 
		BPmeuroditeHoeId = config.getItem("BP meurodite Hoe", 1102).getInt();
		BPmeuroditeShovelId = config.getItem("BP meurodite Shovel", 1103).getInt();
		BPmeuroditeHelmetId = config.getItem("BP meurodite Helmet", 1104).getInt();
		BPmeuroditeChestId = config.getItem("BP meurodite Chest", 1105).getInt();
		BPmeuroditePantsId = config.getItem("BP meurodite Pants", 1106).getInt();
		BPmeuroditeBootsId = config.getItem("BP meurodite Boots", 1107).getInt();
		BPTitaniumSwordId = config.getItem("BP Titanium Sword", 1108).getInt();
		BPTitaniumPickaxeId = config.getItem("BP Titanium Pickaxe", 1109).getInt();
		BPTitaniumAxeId = config.getItem("BP Titanium Axe", 1110).getInt();
		BPTitaniumHoeId = config.getItem("BP Titanium Hoe", 1111).getInt();
		BPTitaniumShovelId = config.getItem("BP Titanium Shovel", 1112).getInt();
		BPTitaniumHelmetId = config.getItem("BP Titanium Helmet", 1113).getInt();
		BPTitaniumChestId = config.getItem("BP Titanium Chest", 1114).getInt();
		BPTitaniumPantsId = config.getItem("BP Titanium Pants", 1115).getInt();
		BPTitaniumBootsId = config.getItem("BP Titanium Boots", 1116).getInt(); 
		BPToriteSwordId = config.getItem("BP Torite Sword", 1117).getInt();
		BPToritePickaxeId = config.getItem("BP Torite Pickaxe", 1118).getInt();
		BPToriteAxeId = config.getItem("BP Torite Axe", 1119).getInt();
		BPToriteHoeId = config.getItem("BP Torite Hoe", 1120).getInt();
		BPToriteShovelId = config.getItem("BP Torite Shovel", 1121).getInt();
		BPToriteHelmetId = config.getItem("BP Torite Helmet", 1122).getInt();
		BPToriteChestId = config.getItem("BP Torite Chest", 1123).getInt();
		BPToritePantsId = config.getItem("BP Torite Pants", 1124).getInt();
		BPToriteBootsId = config.getItem("BP Torite Boots", 1125).getInt();
		BPBlaziumSwordId = config.getItem("BP Blazium Sword", 1126).getInt(); 
		BPBlaziumPickaxeId = config.getItem("BP Blazium Pickaxe", 1127).getInt();
		BPBlaziumAxeId = config.getItem("BP Blazium Axe", 1128).getInt();
		BPBlaziumHoeId = config.getItem("BP Blazium Hoe", 1129).getInt();
		BPBlaziumShovelId = config.getItem("BP Blazium Shovel", 1130).getInt();
		BPBlaziumHelmetId = config.getItem("BP Blazium Helmet", 1131).getInt();
		BPBlaziumChestId = config.getItem("BP Blazium Chest", 1132).getInt();
		BPBlaziumPantsId = config.getItem("BP Blazium Pants", 1133).getInt();
		BPBlaziumBootsId = config.getItem("BP Blazium Boots", 1134).getInt();
		BPCopperSwordId = config.getItem("BP Copper Sword", 1135).getInt(); 
		BPCopperPickaxeId = config.getItem("BP Copper Pickaxe", 1136).getInt();
		BPCopperAxeId = config.getItem("BP Copper Axe", 1137).getInt();
		BPCopperHoeId = config.getItem("BP Copper Hoe", 1138).getInt();
		BPCopperShovelId = config.getItem("BP Copper Shovel", 1139).getInt();
		BPTinHelmetId = config.getItem("BP Tin Helmet", 1140).getInt();
		BPTinChestId = config.getItem("BP Tin Chest", 1141).getInt();
		BPTinPantsId = config.getItem("BP Tin Pants", 1142).getInt();
		BPTinBootsId = config.getItem("BP Tin Boots", 1143).getInt();
		BPSteelPickaxeId = config.getItem("BP Steel Pickaxe", 1144).getInt();
		BPSteelAxeId = config.getItem("BP Steel Axe", 1145).getInt();
		BPSteelShovelId = config.getItem("BP Steel Shovel", 1146).getInt();
		BPSteelHoeId = config.getItem("BP Steel Hoe", 1147).getInt();
		BPSteelSwordId = config.getItem("BP Steel Sword", 1148).getInt();
		BPSteelHelmetId = config.getItem("BP Steel Helmet", 1149).getInt();
		BPSteelChestId = config.getItem("BP Steel Chest", 1150).getInt();
		BPSteelPantsId = config.getItem("BP Steel Pants", 1151).getInt();
		BPSteelBootsId = config.getItem("BP Steel Boots", 1152).getInt(); 
		BPSandstonePickaxeId = config.getItem("BP Sandstone Pick", 1153).getInt();
		BPSandstoneShovelId = config.getItem("BP Sandstone Shovel", 1154).getInt();
		BPSandstoneAxeId = config.getItem("BP Sandstone Axe", 1155).getInt();
		BPSandstoneHoeId = config.getItem("BP Sandstone Hoe", 1156).getInt();
		BPSandstoneSwordId = config.getItem("BP Sandstone Sword", 1157).getInt();
		BPBedrockPickaxeId = config.getItem("BP Bedrock Pick", 1158).getInt();
		BPBedrockAxeId = config.getItem("BP Bedrock Axe", 1159).getInt();
		BPBedrockShovelId = config.getItem("BP Bedrock Shovel", 1160).getInt(); 
		BPBedrockHoeId = config.getItem("BP Bedrock Hoe", 1161).getInt();
		BPGranitePickaxeId = config.getItem("BP Granite Pickaxe", 1162).getInt();
		BPGraniteShovelId = config.getItem("BP Granite Shovel", 1163).getInt();
		BPGraniteAxeId = config.getItem("BP Granite Axe", 1164).getInt();
		BPGraniteHoeId = config.getItem("BP Granite Hoe", 1165).getInt();
		BPGraniteSwordId = config.getItem("BP Granite Sword", 1166).getInt();
		BPWoodPickaxeId = config.getItem("BP Wood Pickaxe", 1167).getInt();
		BPWoodAxeId = config.getItem("BP Wood Axe", 1168).getInt();
		BPWoodShovelId = config.getItem("BP Wood Shovel", 1169).getInt();
		BPWoodHoeId = config.getItem("BP Wood Hoe", 1170).getInt();
		BPWoodSwordId = config.getItem("BP Wood Sword", 1171).getInt();
	    BPClothHelmetId = config.getItem("BP Cloth Helmet", 1172).getInt();
		BPClothChestId = config.getItem("BP Cloth Chest", 1173).getInt();
		BPClothPantsId = config.getItem("BP Cloth Pants", 1174).getInt();
		BPClothBootsId = config.getItem("BP Cloth Boots", 1175).getInt();
		BPStonePickaxeId = config.getItem("BP Stone Pickaxe", 1176).getInt();
		BPStoneAxeId = config.getItem("BP Stone Axe", 1177).getInt();
		BPStoneShovelId = config.getItem("BP Stone Shovel", 1178).getInt();
		BPStoneHoeId = config.getItem("BP Stone Hoe", 1179).getInt();
		BPStoneSwordId = config.getItem("BP Stone Sword", 1180).getInt();
		BPChainHelmetId = config.getItem("BP Chain Helmet", 1181).getInt();
		BPChainChestId = config.getItem("BP Chain Chest", 1182).getInt();
		BPChainPantsId = config.getItem("BP Chain Pants", 1183).getInt();
		BPChainBootsId = config.getItem("BP Chain Boots", 1184).getInt();
		BPIronPickaxeId = config.getItem("BP Iron Pick", 1185).getInt();
		BPIronAxeId = config.getItem("BP Iron Axe", 1186).getInt();
		BPIronShovelId = config.getItem("BP Iron Shovel", 1187).getInt();
		BPIronHoeId = config.getItem("BP Iron Hoe", 1188).getInt();
		BPIronSwordId = config.getItem("BP Iron Sword", 1189).getInt();
		BPIronHelmetId = config.getItem("BP Iron Helmet", 1190).getInt();
		BPIronChestId = config.getItem("BP Iron Chest", 1191).getInt();
		BPIronPantsId = config.getItem("BP Iron Pants", 1192).getInt();
		BPIronBootsId = config.getItem("BP Iron Boots", 1193).getInt();
		BPGoldPickaxeId = config.getItem("BP Gold Pick", 1194).getInt();
		BPGoldAxeId = config.getItem("BP Gold Axe", 1195).getInt();
		BPGoldShovelId = config.getItem("BP Gold Shovel", 1196).getInt();
		BPGoldHoeId = config.getItem("BP Gold Hoe", 1197).getInt();
		BPGoldSwordId = config.getItem("BP Gold Sword", 1198).getInt();
		BPGoldHelmetId = config.getItem("BP Gold Helmet", 1199).getInt();
		BPGoldChestId = config.getItem("BP Gold Chest", 1200).getInt();
		BPGoldPantsId = config.getItem("BP Gold Pants", 1201).getInt();
		BPGoldBootsId = config.getItem("BP Gold Boots", 1202).getInt();
		BPDiamondPickaxeId = config.getItem("BP Diamond Pickaxe", 1203).getInt();
		BPDiamondAxeId = config.getItem("BP Diamond Axe", 1204).getInt();
		BPDiamondShovelId = config.getItem("BP Diamond Shovel", 1205).getInt();
		BPDiamondHoeId = config.getItem("BP Diamond Hoe", 1206).getInt();
		BPDiamondSwordId = config.getItem("BP Diamond Sword", 1207).getInt();
		BPDiamondHelmetId = config.getItem("BP Diamond Helmet", 1208).getInt();
		BPDiamondChestId = config.getItem("BP Diamond Chest", 1209).getInt();
		BPDiamondPantsId = config.getItem("BP Diamond Pants", 1210).getInt();
		BPDiamondBootsId = config.getItem("BP Diamond Boots", 1211).getInt();
		smoothRadiantQuartzId = config.getBlock("Smooth Radiant Quartz", 3051).getInt();
		chiseledRadiantQuartzId = config.getBlock("Chiseled Radiant Quartz", 3052).getInt();
		pillarRadiantQuartzId = config.getBlock("Pillar Radiant Quartz", 3053).getInt();
		radiantQuartzOreId = config.getBlock("Radiant Quartz Ore", 3054).getInt(); 
		radiantQuartzId = config.getItem("Radiant Quartz", 1212).getInt();
		godstoneId  = config.getBlock("Godstone", 3055).getInt();
		melterIdleId  = config.getBlock("Melter Idle", 3056).getInt();
		melterBurningId = config.getBlock("Melter Burnign", 3057).getInt(); 
		radiantQuartzStairsId  = config.getBlock("Radiant Quartz Stairs", 3058).getInt();
		radiantQuartzSingleSlabId  = config.getBlock("Radiant Quartz Single Slab", 3059).getInt();
		radiantQuartzDoubleSlabId  = config.getBlock("Radiant Quartz Double Slab", 3060).getInt();
		pinkQuartzStairsId  = config.getBlock("Pink Quartz Stairs", 3061).getInt();
		pinkQuartzSingleSlabId  = config.getBlock("Pink Quartz Slab", 3062).getInt();
		pinkQuartzDoubleSlabId = config.getBlock("Pink Quartz Double Slab", 3063).getInt();
		graniteBrickStairsId = config.getBlock("Granite Brick Stairs", 3064).getInt();
		graniteBrickSingleSlabId = config.getBlock("Granite Brick Slab", 3065).getInt();
		graniteBrickDoubleSlabId = config.getBlock("Granite Brick Double Slab", 3066).getInt();
		tinPlatedCobbleStairsId = config.getBlock("Tin Plated Cobble Stairs", 3067).getInt();
		tinPlatedCobbleSingleSlabId = config.getBlock("Tin Cobble Plated Slab", 3068).getInt();
		tinPlatedCobbleDoubleSlabId = config.getBlock("Tin Cobble Plated Double Slab", 3069).getInt();
	    steelPlatedCobbleStairsId = config.getBlock("Steel Plated Cobble Stairs", 3070).getInt();
	    steelPlatedCobbleSingleSlabId = config.getBlock("Steel Cobble Plated Slab", 3071).getInt();
	    steelPlatedCobbleDoubleSlabId = config.getBlock("Steel Cobble Plated Double Slab", 3072).getInt();
	    bronzePlatedCobbleStairsId = config.getBlock("Bronze Plated Cobble Stairs", 3073).getInt();
	    bronzePlatedCobbleSingleSlabId = config.getBlock("Bronze Plated Slab", 3074).getInt();
	    bronzePlatedCobbleDoubleSlabId = config.getBlock("Bronze Plated Double Slab", 3075).getInt();
	    tinPlatedStoneBrickStairsId = config.getBlock("Tin Plated Stone Brick Stairs", 3076).getInt();
	    tinPlatedStoneBrickSingleSlabId = config.getBlock("Tin Plated Stone Brick Slab", 3077).getInt();
	    tinPlatedStoneBrickDoubleSlabId = config.getBlock("Tin Plated Stone Brick Double Slab", 3078).getInt();
	    steelPlatedStoneBrickStairsId = config.getBlock("Steel Plated Stone Brick Stairs", 3079).getInt();
	    steelPlatedStoneBrickSingleSlabId = config.getBlock("Steel Plated Stone Brick Slab", 3080).getInt();
	    steelPlatedStoneBrickDoubleSlabId = config.getBlock("Steel Plated Stone Brick Double Slab", 3081).getInt();
	    bronzePlatedStoneBrickStairsId = config.getBlock("Bronze Plated Stone Brick Stairs", 3082).getInt();
	    bronzePlatedStoneBrickSingleSlabId = config.getBlock("Bronze Plated Stone Brick Slab", 3083).getInt();
	    bronzePlatedStoneBrickDoubleSlabId = config.getBlock("Bronze Plated Stone Brick Double Slab", 3084).getInt();
	    tinPlatedGraniteBrickStairsId = config.getBlock("Tin Plated Granite Brick Stairs", 3085).getInt();
	    tinPlatedGraniteBrickSingleSlabId = config.getBlock("Tin Plated Granite Brick Slab", 3086).getInt();
	    tinPlatedGraniteBrickDoubleSlabId = config.getBlock("Tin Plated Granite Brick Double Slab", 3087).getInt();
	    steelPlatedGraniteBrickStairsId = config.getBlock("Steel Plated Granite Brick Stairs", 3088).getInt();
	    steelPlatedGraniteBrickSingleSlabId = config.getBlock("Steel Plated Granite Brick Slab", 3089).getInt();
	    steelPlatedGraniteBrickDoubleSlabId = config.getBlock("Steel Plated Granite Brick Double Slab", 3090).getInt();
	    bronzePlatedGraniteBrickStairsId = config.getBlock("Bronze Plated Granite Brick Stairs", 3091).getInt();
	    bronzePlatedGraniteBrickSingleSlabId = config.getBlock("Bronze Plated Granite Brick Slab", 3092).getInt();
	    bronzePlatedGraniteBrickDoubleSlabId = config.getBlock("Bronze Plated Granite Brick Double Slab", 3093).getInt();
	    plutoniumInsulatedId = config.getBlock("Insulated Plutonium Block", 3094).getInt();
	    uraniumInsulatedId = config.getBlock("Insulated Uranium Block", 3095).getInt();
	    
	    config.save();
	    
	    Block.bedrock.setHardness(80F);
	    
		GameRegistry.registerWorldGenerator(new EOOreGenerator());
		EntityRegistry.registerModEntity(EntityInstantExplosion.class, "Plutonium", 4, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 2, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityNukePrimed.class, "NukePrimed", 3, this, 350, 5, false);
		EntityRegistry.registerModEntity(EntityGrenadeImpact.class, "GrenadeImpact", 4, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityGrenadeSticky.class, "GrenadeSticky", 5, this, 40, 3, true);
		
		meuroditeOre = (new EOBlock(meuroditeOreId, "block_MeuroditeOre", Material.rock)).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("MeuroditeOre");
		meuroditeBlock = (new EOBlock(meuroditeBlockId, "block_Meurodite", Material.iron)).setHardness(5F).setCreativeTab(tabOresBlocks).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("MeuroditeBlock");
		meuroditeIngot = (new EOItem(meuroditeIngotId, "item_MeuroditeIngot")).setCreativeTab(tabOresItems).setUnlocalizedName("MeuroditeIngot");
		
		meuroditeSword = (new ItemESword(meuroditeSwordId, "item_MeuroditeSword", toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("MeuroditeSword");
		meuroditePickaxe = (new ItemEPickaxe(meuroditePickaxeId, "item_MeuroditePickaxe", toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("MeuroditePickaxe");
		meuroditeShovel = (new ItemEShovel(meuroditeShovelId, "item_MeuroditeShovel", toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("MeuroditeShovel");
		meuroditeHoe = (new ItemEHoe(meuroditeHoeId, "item_MeuroditeHoe", toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("MeuroditeHoe");
		meuroditeAxe = (new ItemEAxe(meuroditeAxeId, "item_MeuroditeAxe", toolMaterialMeurodite)).setCreativeTab(tabOresItems).setUnlocalizedName("MeuroditeAxe");
	
		meuroditeHelmet = (new ItemExtracraftHelmet(meuroditeHelmetId, "item_MeuroditeHelmet", MaterialMeurodite, proxy.addArmor("Meurodite"), 0)).setCreativeTab(tabOresItems).setUnlocalizedName("MeuroditeHelmet");
		meuroditeChest = (new ItemExtracraftChest(meuroditeChestId, "item_MeuroditeChestplate", MaterialMeurodite, proxy.addArmor("Meurodite"), 1)).setCreativeTab(tabOresItems).setUnlocalizedName("ZurconiumChest");
		meuroditePants = (new ItemExtracraftPants(meuroditePantsId, "item_MeuroditeLeggings",MaterialMeurodite, proxy.addArmor("Meurodite"),2)).setCreativeTab(tabOresItems).setUnlocalizedName("MeuroditePants");
		meuroditeBoots = (new ItemExtracraftBoots(meuroditeBootsId, "item_MeuroditeBoots", MaterialMeurodite, proxy.addArmor("Meurodite"),3)).setCreativeTab(tabOresItems).setUnlocalizedName("MeuroditeBoots");
				
		UraniumOre = (new BlockUraniumOre(uraniumOreId, Material.rock)).setHardness(5F).setResistance(10F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("UraniumOre");
		Uranium = (new EOItem(uraniumId, "item_Uranium")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("Uranium");
		RawUraniumBlock = (new BlockUraniumRaw(rawUraniumBlockId, Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("RawUraniumBlock");
		
		PlutoniumOre = (new BlockPlutoniumOre(plutoniumOreId, Material.rock)).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("PlutoniumOre").setCreativeTab(tabOresBlocks);
		Plutonium = (new EOItem(plutoniumOreId, "item_Plutonium")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("Plutonium");
		RawPlutoniumBlock = (new BlockPlutoniumRaw(rawPlutoniumBlockId, Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("RawPlutoniumBlock");
		
		TitaniumOre = (new EOBlock(titaniumOreId, "block_TitaniumOre", Material.rock)).setHardness(10F).setResistance(15F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TitaniumOre");
		TitaniumIngot = (new EOItem(titaniumIngotId, "item_TitaniumIngot")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("Titanium");
		
		TitaniumSword = (new ItemESword(titaniumSwordId,"item_TitaniumSword", toolMaterialTitanium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TitaniumSword");
		TitaniumPickaxe = (new ItemEPickaxe(titaniumPickaxeId, "item_TitaniumPickaxe", toolMaterialTitanium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TitaniumPickaxe");
		TitaniumShovel = (new ItemEShovel(titaniumShovelId, "item_TitaniumShovel", toolMaterialTitanium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TitaniumShovel");
		TitaniumHoe = (new ItemEHoe(titaniumHoeId, "item_TitaniumHoe",toolMaterialTitanium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TitaniumHoe");
		TitaniumAxe = (new ItemEAxe(titaniumAxeId, "item_TitaniumAxe",toolMaterialTitanium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TitaniumAxe");
	
		TitaniumHelmet = (new ItemExtracraftHelmet(titaniumHelmetId, "item_TitaniumHelmet", MaterialTitanium, proxy.addArmor("titanium"), 0)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TitaniumHelmet");
		TitaniumChest = (new ItemExtracraftChest(titaniumChestId, "item_TitaniumChestplate",MaterialTitanium, proxy.addArmor("titanium"), 1)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TitaniumChest");
		TitaniumPants = (new ItemExtracraftPants(titaniumPantsId, "item_TitaniumLeggings", MaterialTitanium, proxy.addArmor("titanium"),2)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TitaniumPants");
		TitaniumBoots = (new ItemExtracraftBoots(titaniumBootsId, "item_TitaniumBoots",MaterialTitanium, proxy.addArmor("titanium"),3)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TitaniumBoots");
		
		TitaniumBlock = (new EOBlock(titaniumBlockId, "block_Titanium", Material.iron)).setHardness(10F).setResistance(12000000.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("Titanium Block");
		
		Sunstone = (new BlockSunstone(sunstoneId,Material.glass)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setLightValue(1.0F).setUnlocalizedName("Sunstone");
		SunstoneDust = (new EOItem(sunstoneDustId, "item_SunstoneShard")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SunstoneDust");
		SunstoneOre = (new EOBlock(sunstoneOreId, "block_SunstoneOre", Material.rock)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("SunstoneOre").setLightValue(1F);
		//Old Sunstone Ore code: SunstoneOre = (new BlockSunstoneOre(212, 40)).setHardness(7F).setStepSound(Block.soundStoneFootstep).setCreativeTab(ExtraOres.tabExtra).setLightValue(1.0F).setBlockName("Sunstone Ore");
		
		ToriteOre = (new EOBlock(toriteOreId, "block_ToriteOre", Material.rock)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("ToriteOre");
		ToriteIngot = (new EOItem(toriteIngotId, "item_ToriteIngot")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToriteIngot");
		ToriteBlock = (new EOBlock(toriteBlockId, "block_Torite", Material.iron)).setHardness(6F).setResistance(10F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("ToriteBlock");
	
		ToriteSword = (new ItemESword(toriteSwordId, "item_ToriteSword", toolMaterialTorite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToriteSword");
		ToritePickaxe = (new ItemEPickaxe(toritePickaxeId, "item_ToritePickaxe", toolMaterialTorite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToritePickaxe");
		ToriteShovel = (new ItemEShovel(toriteShovelId, "item_ToriteShovel", toolMaterialTorite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToriteShovel");
		ToriteHoe = (new ItemEHoe(toriteHoeId, "item_ToriteHoe",toolMaterialTorite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToriteHoe");
		ToriteAxe = (new ItemEAxe(toriteAxeId, "item_ToriteAxe",toolMaterialTorite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToriteAxe");
		
		ToriteHelmet = (new ItemExtracraftHelmet(toriteHelmetId, "item_ToriteHelmet",MaterialTorite, proxy.addArmor("torite"), 0)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToriteHelmet");
		ToriteChest = (new ItemExtracraftChest(toriteChestId, "item_ToriteChestplate",MaterialTorite, proxy.addArmor("torite"), 1)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToriteChest");
		ToritePants = (new ItemExtracraftPants(toritePantsId, "item_ToriteLeggings",MaterialTorite, proxy.addArmor("torite"),2)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToritePants");
		ToriteBoots = (new ItemExtracraftBoots(toriteBootsId, "item_ToriteBoots",MaterialTorite, proxy.addArmor("torite"),3)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("ToriteBoots");
		
		Granite = (new EOBlock(graniteId, "block_Granite", Material.rock)).setHardness(5F).setResistance(9F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("Granite");
		GraniteBrick = (new EOBlock(graniteBrickId, "block_GraniteBrick", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("GraniteBrick");
		
		Quartzite = (new EOBlock(quartziteId, "block_PinkQuartzRaw", Material.rock)).setHardness(5F).setResistance(9F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("Quartzite");
		QuartziteTile = (new EOBlock(quartziteTileId, "block_PinkQuartzTileRough", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("QuartziteTile");
	    SmoothQuartzite = (new EOBlock(smoothQuartziteId, "block_PinkQuartzSmooth", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("SmoothQuartzite");
		PillarQuartzite = (new BlockPinkPillar(pillarQuartziteId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("QuartzitePillar");
		ChiseledQuartzite = (new BlockPinkChiseled(chiseledQuartziteId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("ChiseledQuartzite");
		SmoothQuartzTile = (new EOBlock(smoothQuartzTileId, "block_PinkQuartzTileRefined", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("SmoothQuartzTile");
		PinkQuartz = (new EOItem(pinkQuartzId, "item_PinkQuartz")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("PinkQuartz");
	    
		BlaziumOre = (new EOBlock(blaziumOreId, "block_BlaziumOre", Material.rock)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("BlaziumOre").setLightValue(0.5F);
		//Experimental Blazium Ore Code: BlaziumOre = (new BlockBlaziumOre(204, 5)).setHardness(7F).setResistance(11F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabExtra).setLightValue(0.5F).setBlockName("Blazium Ore");
		BlaziumBlock = (new BlockBlazium(blaziumBlockId, Material.iron)).setHardness(8F).setResistance(12F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("BlaziumBlock").setLightValue(0.7F);
		
		BlaziumIngot = (new EOItem(blaziumIngotId, "item_BlaziumIngot")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumIngot");
		BlazeShard = (new EOItem(blaziumShardId, "item_BlazeShard")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlazeShard");
	
		BlaziumSword = (new ItemESword(blaziumSwordId, "item_FireSword", toolMaterialBlazium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumSword");
		BlaziumPickaxe = (new ItemEPickaxe(blaziumPickaxeId, "item_FirePickaxe", toolMaterialBlazium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumPickaxe");
		BlaziumShovel = (new ItemEShovel(blaziumShovelId, "item_FireShovel",toolMaterialBlazium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumShovel");
		BlaziumHoe = (new ItemEHoe(blaziumHoeId, "item_FireHoe",toolMaterialBlazium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumHoe");
		BlaziumAxe = (new ItemEAxe(blaziumAxeId, "item_FireAxe",toolMaterialBlazium)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumAxe");
		
		BlaziumHelmet = (new ItemExtracraftHelmet(blaziumHelmetId,"item_FireHelmet", MaterialBlazium, proxy.addArmor("fire"), 0)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumHelmet");
		BlaziumChest = (new ItemExtracraftChest(blaziumChestId, "item_FireChestplate",MaterialBlazium, proxy.addArmor("fire"), 1)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumChest");
		BlaziumPants = (new ItemExtracraftPants(blaziumPantsId, "item_FireLeggings",MaterialBlazium, proxy.addArmor("fire"),2)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumPants");
		BlaziumBoots = (new ItemExtracraftBoots(blaziumBootsId, "item_FireBoots",MaterialBlazium, proxy.addArmor("fire"),3)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BlaziumBoots");
	
		CopperOre = (new EOBlock(copperOreId, "block_CopperOre", Material.rock)).setHardness(3F).setResistance(5F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("CopperOre");
		CopperBlock = (new BlockCopper(copperBlockId, Material.iron)).setHardness(5F).setResistance(10F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("CopperBlock");
		CopperIngot = (new EOItem(copperBlockId, "item_CopperIngot")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("CopperIngot");
		
		CopperBlockTarnished = (new BlockCopperTarnished(copperTarnishedId)).setHardness(6F).setResistance(12F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("CopperBlockTarnished");
		
		CopperSword = (new ItemESword(copperSwordId, "item_CopperSword",toolMaterialCopper)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("CopperSword");
		CopperPickaxe = (new ItemEPickaxe(copperPickaxeId, "item_CopperPickaxe",toolMaterialCopper)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("CopperPickaxe");
		CopperShovel = (new ItemEShovel(copperShovelId, "item_CopperShovel",toolMaterialCopper)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("CopperShovel");
		CopperHoe = (new ItemEHoe(copperHoeId, "item_CopperHoe",toolMaterialCopper)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("CopperHoe");
		CopperAxe = (new ItemEAxe(copperAxeId, "item_CopperAxe",toolMaterialCopper)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("CopperAxe");
		
		TinOre = (new EOBlock(tinOreId, "block_TinOre", Material.rock)).setHardness(3F).setResistance(5F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinOre");
		TinBlock = (new EOBlock(tinBlockId, "block_Tin", Material.iron)).setHardness(3F).setResistance(2F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinBlock");
		TinIngot = (new EOItem(tinIngotId, "item_TinIngot")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TinIngot");

		TinHelmet = (new ItemExtracraftHelmet(tinHelmetId,"item_TinHelmet", MaterialTin, proxy.addArmor("tin"), 0)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TinHelmet");
		TinChest = (new ItemExtracraftChest(tinChestId, "item_TinChestplate",MaterialTin, proxy.addArmor("tin"), 1)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TinChest");
		TinPants = (new ItemExtracraftPants(tinPantsId, "item_TinLeggings",MaterialTin, proxy.addArmor("tin"),2)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TinPants");
		TinBoots = (new ItemExtracraftBoots(tinBootsId, "item_TinBoots",MaterialTin, proxy.addArmor("tin"),3)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TinBoots");
	
		TinPlate = (new BlockPlate(tinPlateId,"block_Tin")).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlate");
		BronzePlate = (new BlockPlate(bronzePlateId, "block_Bronze")).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlate");
		SteelPlate = (new BlockPlate(steelPlateId, "block_SteelSide")).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlate");
		TinPlateItem = (new ItemBlockPlacer(tinPlateItemId,"item_TinPlate", TinPlate)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("TinPlateItem");
		BronzePlateItem = (new ItemBlockPlacer(bronzePlateItemId, "item_BronzePlate", BronzePlate)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzePlateItem");
		SteelPlateItem = (new ItemBlockPlacer(steelPlateItemId,"item_SteelPlate", SteelPlate)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelPlateItem");
		
		CoalIronIngot = (new EOItem(coalIronIngotId,"item_CoalIronIngot")).setCreativeTab(tabOresItems).setUnlocalizedName("CoalIronIngot");
		SteelIngot = (new EOItem(steelIngotId, "item_SteelIngot")).setCreativeTab(tabOresItems).setUnlocalizedName("SteelIngot");
		
		SteelPickaxe = (new ItemEPickaxe(steelPickaxeId, "item_SteelPickaxe",toolMaterialSteel)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelPickaxe");
		SteelShovel = (new ItemEShovel(steelShovelId, "item_SteelShovel",toolMaterialSteel)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelShovel");
		SteelAxe = (new ItemEAxe(steelAxeId, "item_SteelAxe",toolMaterialSteel)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelAxe");
		SteelHoe = (new ItemEHoe(steelHoeId, "item_SteelHoe",toolMaterialSteel)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelHoe");
		SteelSword = (new ItemESword(steelSwordId, "item_SteelSword",toolMaterialSteel)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelSword");
		
		SteelHelmet = (new ItemExtracraftHelmet(steelHelmetId,"item_SteelHelmet", MaterialSteel, proxy.addArmor("steel"), 0)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelHelmet");
		SteelChest = (new ItemExtracraftChest(steelChestId, "item_SteelChestplate",MaterialSteel, proxy.addArmor("steel"), 1)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelChest");
		SteelPants = (new ItemExtracraftPants(steelPantsId, "item_SteelLeggings",MaterialSteel, proxy.addArmor("steel"), 2)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelPants");
		SteelBoots = (new ItemExtracraftBoots(steelBootsId, "item_SteelBoots",MaterialSteel, proxy.addArmor("steel"), 3)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SteelBoots");
		
		SteelBlock = (new BlockSteel(steelBlockId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setUnlocalizedName("SteelBlock");
		
		SoulOre = (new EOBlock(soulOreId, "block_SoulOre", Material.sand)).setHardness(2F).setResistance(3F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundSandFootstep).setUnlocalizedName("SoulOre");
		SoulGem = (new EItemFoiled(soulGemId, "item_SoulGem")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SoulGem");
		
		SandstonePickaxe = (new ItemEPickaxe(sandstonePickaxeId,"item_SandstonePickaxe", toolMaterialSandstone)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SandstonePickaxe");
		SandstoneShovel = (new ItemEShovel(sandstoneShovelId, "item_SandstoneShovel",toolMaterialSandstone)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SandstoneShovel");
		SandstoneAxe = (new ItemEAxe(sandstoneAxeId, "item_SandstoneAxe", toolMaterialSandstone)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SandstoneAxe");
		SandstoneHoe = (new ItemEHoe(sandstoneHoeId, "item_SandstoneHoe",toolMaterialSandstone)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SandstoneHoe");
		SandstoneSword = (new ItemESword(sandstoneSwordId, "item_SandstoneSword",toolMaterialSandstone)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SandstoneSword");
		
		TinPlatedCobble = (new EOBlock(tinPlatedCobbleId, "block_TinCobble", Material.rock)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedCobble");
		TinPlatedMossy = (new EOBlock(tinPlatedMossyId, "block_TinMossy", Material.rock)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedMossy");
		TinPlatedStoneBrick = (new EOBlock(tinPlatedStoneBrickId, "block_TinStoneBrick", Material.rock)).setHardness(1.5F).setResistance(10.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedStoneBrick");
		TinPlatedChiseled = (new EOBlock(tinPlatedChiseledId, "block_TinChiseled", Material.rock)).setHardness(1.5F).setResistance(10.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedChiseled");
		TinPlatedGranite = (new EOBlock(tinPlatedGraniteId,"block_TinGraniteBrick", Material.rock)).setHardness(6F).setResistance(10.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("TinPlatedGranite");
		
		BronzeIngot = (new EOItem(bronzeIngotId, "item_BronzeIngot")).setCreativeTab(tabOresItems).setUnlocalizedName("BronzeIngot");
		BronzePickaxe = (new ItemEPickaxe(bronzePickaxeId, "item_BronzePickaxe",toolMaterialBronze)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzePickaxe");
		BronzeShovel = (new ItemEShovel(bronzeShovelId, "item_BronzeShovel",toolMaterialBronze)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzeShovel");
		BronzeAxe = (new ItemEAxe(bronzeAxeId, "item_BronzeAxe",toolMaterialBronze)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzeAxe");
		BronzeHoe = (new ItemEHoe(bronzeHoeId,"item_BronzeHoe", toolMaterialBronze)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzeHoe");
		BronzeSword = (new ItemESword(bronzeSwordId,"item_BronzeSword", toolMaterialBronze)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzeSword");
		BronzeHelmet = (new ItemExtracraftHelmet(bronzeHelmetId,"item_BronzeHelmet", MaterialBronze, proxy.addArmor("bronze"), 0)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzeHelmet");
		BronzeChest = (new ItemExtracraftChest(bronzeChestId, "item_BronzeChestplate",MaterialBronze, proxy.addArmor("bronze"), 1)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzeChest");
		BronzePants = (new ItemExtracraftPants(bronzePantsId, "item_BronzeLeggings",MaterialBronze, proxy.addArmor("bronze"),2)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzePants");
		BronzeBoots = (new ItemExtracraftBoots(bronzeBootsId, "item_BronzeBoots",MaterialBronze, proxy.addArmor("bronze"),3)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BronzeBoots");
		BronzeBlock = (new EOBlock(bronzeBlockId, "block_Bronze", Material.iron)).setHardness(7F).setResistance(20F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzeBlock");
		
		BronzePlatedCobble = (new EOBlock(bronzePlatedCobbleId, "block_BronzeCobble", Material.rock)).setHardness(2.0F).setResistance(30.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedCobble");
		BronzePlatedMossy = (new EOBlock(bronzePlatedMossyId, "block_BronzeMossy", Material.rock)).setHardness(2.0F).setResistance(30.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedMossy");
		BronzePlatedStoneBrick = (new EOBlock(bronzePlatedStoneBrickId, "block_BronzeStoneBrick", Material.rock)).setHardness(1.5F).setResistance(30.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedStoneBrick");
		BronzePlatedChiseled = (new EOBlock(bronzePlatedChiseledId, "block_BronzeChiseled", Material.rock)).setHardness(1.5F).setResistance(30.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedChiseled");
		BronzePlatedGranite = (new EOBlock(bronzePlatedGraniteId, "block_BronzeGraniteBrick", Material.rock)).setHardness(6F).setResistance(30.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BronzePlatedGranite");
		
		Invincium = (new EOBlock(invinciumId, "block_Invincium", Material.rock)).setBlockUnbreakable().setResistance(12000000.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Invincium");
		//Replacement block for vanilla Bedrock to make it breakable. Currently modifies net.minecraft.world.gen.ChunkProviderGenerate, net.minecraft.world.gen.ChunkProviderHell, and net.minecraft.world.gen.feature.WorldGenSpikes.
		//TODO: Find a solution to removing Bedrock invincibility that doesn't edit base classes.
		
		SteelPlatedCobble = (new EOBlock(steelPlatedCobbleId, "block_SteelCobble", Material.rock)).setHardness(2.0F).setResistance(20.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedCobble");
		SteelPlatedMossy = (new EOBlock(steelPlatedMossyId, "block_SteelMossy", Material.rock)).setHardness(2.0F).setResistance(20.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedMossy");
		SteelPlatedStoneBrick = (new EOBlock(steelPlatedStoneBrickId, "block_SteelStoneBrick", Material.rock)).setHardness(1.5F).setResistance(20.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedStoneBrick");
		SteelPlatedChiseled = (new EOBlock(steelPlatedChiseledId, "block_SteelChiseled", Material.rock)).setHardness(1.5F).setResistance(20.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedChiseled");
		SteelPlatedGranite = (new EOBlock(steelPlatedGraniteId, "block_SteelGraniteBrick", Material.rock)).setHardness(6F).setResistance(20.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("SteelPlatedGranite");
		
		BedrockPickaxe = (new ItemEPickaxe(bedrockPickaxeId, "item_BedrockPickaxe", toolMaterialBedrock)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BedrockPickaxe");
		BedrockShovel = (new ItemEShovel(bedrockShovelId, "item_BedrockShovel",toolMaterialBedrock)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BedrockShovel");
		BedrockAxe = (new ItemEAxe(bedrockAxeId, "item_BedrockAxe",toolMaterialBedrock)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BedrockAxe");
		BedrockHoe = (new ItemEHoe(bedrockHoeId, "item_BedrockHoe",toolMaterialBedrock)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("BedrockHoe");
		
		GranitePickaxe = (new ItemEPickaxe(granitePickaxeId, "item_GranitePickaxe",toolMaterialGranite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("GranitePickaxe");
		GraniteShovel = (new ItemEShovel(graniteShovelId, "item_GraniteShovel",toolMaterialGranite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("GraniteShovel");
		GraniteAxe = (new ItemEAxe(graniteAxeId, "item_GraniteAxe",toolMaterialGranite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("GraniteAxe");
		GraniteHoe = (new ItemEHoe(graniteHoeId, "item_GraniteHoe",toolMaterialGranite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("GraniteHoe");
		GraniteSword = (new ItemESword(graniteSwordId, "item_GraniteSword",toolMaterialGranite)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("GraniteSword");
		
		SoulBottle = (new ItemSoulBottle(soulBottleId)).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("SoulBottle");
		
		nuke = (new BlockNuke(nukeId)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("nuke");
		grenade = (new ItemGrenade(grenadeId)).setUnlocalizedName("grenade");
		grenadeImpact = (new ItemGrenadeImpact(grenadeImpactId)).setUnlocalizedName("grenadeImpact");
		grenadeSticky = (new ItemGrenadeSticky(grenadeStickyId)).setUnlocalizedName("grenadeSticky");		
		
		BPMeuroditeSword = (new ItemESword(BPmeuroditeSwordId, "item_BronzePlatedMeuroditeSword", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditeSword");
		BPMeuroditePickaxe = (new ItemEPickaxe(BPmeuroditePickaxeId, "item_BronzePlatedMeuroditePickaxe", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditePickaxe");
		BPMeuroditeShovel = (new ItemEShovel(BPmeuroditeShovelId, "item_BronzePlatedMeuroditeShovel", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditeShovel");
		BPMeuroditeHoe = (new ItemEHoe(BPmeuroditeHoeId, "item_BronzePlatedMeuroditeHoe", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditeHoe");
		BPMeuroditeAxe = (new ItemEAxe(BPmeuroditeAxeId, "item_BronzePlatedMeuroditeAxe", toolMaterialBPMeurodite)).setUnlocalizedName("BPMeuroditeAxe");
	
		BPMeuroditeHelmet = (new ItemExtracraftHelmet(BPmeuroditeHelmetId, "item_BronzePlatedMeuroditeHelmet", MaterialBPMeurodite, proxy.addArmor("BPMeurodite"), 0)).setUnlocalizedName("BPMeuroditeHelmet");
		BPMeuroditeChest = (new ItemExtracraftChest(BPmeuroditeChestId, "item_BronzePlatedMeuroditeChestplate", MaterialBPMeurodite, proxy.addArmor("BPMeurodite"), 1)).setUnlocalizedName("BPMeuroditeChest");
		BPMeuroditePants = (new ItemExtracraftPants(BPmeuroditePantsId, "item_BronzePlatedMeuroditeLeggings",MaterialBPMeurodite, proxy.addArmor("BPMeurodite"),2)).setUnlocalizedName("BPMeuroditePants");
		BPMeuroditeBoots = (new ItemExtracraftBoots(BPmeuroditeBootsId, "item_BronzePlatedMeuroditeBoots", MaterialBPMeurodite, proxy.addArmor("BPMeurodite"),3)).setUnlocalizedName("BPMeuroditeBoots");
		
		BPTitaniumSword = (new ItemESword(BPTitaniumSwordId,"item_BronzePlatedTitaniumSword", toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumSword");
		BPTitaniumPickaxe = (new ItemEPickaxe(BPTitaniumPickaxeId, "item_BronzePlatedTitaniumPickaxe", toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumPickaxe");
		BPTitaniumShovel = (new ItemEShovel(BPTitaniumShovelId, "item_BronzePlatedTitaniumShovel", toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumShovel");
		BPTitaniumHoe = (new ItemEHoe(BPTitaniumHoeId, "item_BronzePlatedTitaniumHoe",toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumHoe");
		BPTitaniumAxe = (new ItemEAxe(BPTitaniumAxeId, "item_BronzePlatedTitaniumAxe",toolMaterialBPTitanium)).setUnlocalizedName("BPTitaniumAxe");
	
		BPTitaniumHelmet = (new ItemExtracraftHelmet(BPTitaniumHelmetId, "item_BronzePlatedTitaniumHelmet", MaterialBPTitanium, proxy.addArmor("BPtitanium"), 0)).setUnlocalizedName("BPTitaniumHelmet");
		BPTitaniumChest = (new ItemExtracraftChest(BPTitaniumChestId, "item_BronzePlatedTitaniumChestplate",MaterialBPTitanium, proxy.addArmor("BPtitanium"), 1)).setUnlocalizedName("BPTitaniumChest");
		BPTitaniumPants = (new ItemExtracraftPants(BPTitaniumPantsId, "item_BronzePlatedTitaniumLeggings", MaterialBPTitanium, proxy.addArmor("BPtitanium"),2)).setUnlocalizedName("BPTitaniumPants");
		BPTitaniumBoots = (new ItemExtracraftBoots(BPTitaniumBootsId, "item_BronzePlatedTitaniumBoots",MaterialBPTitanium, proxy.addArmor("BPtitanium"),3)).setUnlocalizedName("BPTitaniumBoots");
		
		BPToriteSword = (new ItemESword(BPToriteSwordId, "item_BronzePlatedToriteSword", toolMaterialBPTorite)).setUnlocalizedName("BPToriteSword");
		BPToritePickaxe = (new ItemEPickaxe(BPToritePickaxeId, "item_BronzePlatedToritePickaxe", toolMaterialBPTorite)).setUnlocalizedName("BPToritePickaxe");
		BPToriteShovel = (new ItemEShovel(BPToriteShovelId, "item_BronzePlatedToriteShovel", toolMaterialBPTorite)).setUnlocalizedName("BPToriteShovel");
		BPToriteHoe = (new ItemEHoe(BPToriteHoeId, "item_BronzePlatedToriteHoe",toolMaterialBPTorite)).setUnlocalizedName("BPToriteHoe");
		BPToriteAxe = (new ItemEAxe(BPToriteAxeId, "item_BronzePlatedToriteAxe",toolMaterialBPTorite)).setUnlocalizedName("BPToriteAxe");
		
		BPToriteHelmet = (new ItemExtracraftHelmet(BPToriteHelmetId, "item_BronzePlatedToriteHelmet",MaterialBPTorite, proxy.addArmor("BPtorite"), 0)).setUnlocalizedName("BPToriteHelmet");
		BPToriteChest = (new ItemExtracraftChest(BPToriteChestId, "item_BronzePlatedToriteChestplate",MaterialBPTorite, proxy.addArmor("BPtorite"), 1)).setUnlocalizedName("BPToriteChest");
		BPToritePants = (new ItemExtracraftPants(BPToritePantsId, "item_BronzePlatedToriteLeggings",MaterialBPTorite, proxy.addArmor("BPtorite"),2)).setUnlocalizedName("BPToritePants");
		BPToriteBoots = (new ItemExtracraftBoots(BPToriteBootsId, "item_BronzePlatedToriteBoots",MaterialBPTorite, proxy.addArmor("BPtorite"),3)).setUnlocalizedName("BPToriteBoots");
		
		BPBlaziumSword = (new ItemESword(BPBlaziumSwordId, "item_BronzePlatedFireSword", toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumSword");
		BPBlaziumPickaxe = (new ItemEPickaxe(BPBlaziumPickaxeId, "item_BronzePlatedFirePickaxe", toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumPickaxe");
		BPBlaziumShovel = (new ItemEShovel(BPBlaziumShovelId, "item_BronzePlatedFireShovel",toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumShovel");
		BPBlaziumHoe = (new ItemEHoe(BPBlaziumHoeId, "item_BronzePlatedFireHoe",toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumHoe");
		BPBlaziumAxe = (new ItemEAxe(BPBlaziumAxeId, "item_BronzePlatedFireAxe",toolMaterialBPBlazium)).setUnlocalizedName("BPBlaziumAxe");
		
		BPBlaziumHelmet = (new ItemExtracraftHelmet(BPBlaziumHelmetId,"item_BronzePlatedFireHelmet", MaterialBPBlazium, proxy.addArmor("BPfire"), 0)).setUnlocalizedName("BPBlaziumHelmet");
		BPBlaziumChest = (new ItemExtracraftChest(BPBlaziumChestId, "item_BronzePlatedFireChestplate",MaterialBPBlazium, proxy.addArmor("BPfire"), 1)).setUnlocalizedName("BPBlaziumChest");
		BPBlaziumPants = (new ItemExtracraftPants(BPBlaziumPantsId, "item_BronzePlatedFireLeggings",MaterialBPBlazium, proxy.addArmor("BPfire"),2)).setUnlocalizedName("BPBlaziumPants");
		BPBlaziumBoots = (new ItemExtracraftBoots(BPBlaziumBootsId, "item_BronzePlatedFireBoots",MaterialBPBlazium, proxy.addArmor("BPfire"),3)).setUnlocalizedName("BPBlaziumBoots");
		
		BPCopperSword = (new ItemESword(BPCopperSwordId, "item_BronzePlatedCopperSword",toolMaterialBPCopper)).setUnlocalizedName("BPCopperSword");
		BPCopperPickaxe = (new ItemEPickaxe(BPCopperPickaxeId, "item_BronzePlatedCopperPickaxe",toolMaterialBPCopper)).setUnlocalizedName("BPCopperPickaxe");
		BPCopperShovel = (new ItemEShovel(BPCopperShovelId, "item_BronzePlatedCopperShovel",toolMaterialBPCopper)).setUnlocalizedName("BPCopperShovel");
		BPCopperHoe = (new ItemEHoe(BPCopperHoeId, "item_BronzePlatedCopperHoe",toolMaterialBPCopper)).setUnlocalizedName("BPCopperHoe");
		BPCopperAxe = (new ItemEAxe(BPCopperAxeId, "item_BronzePlatedCopperAxe",toolMaterialBPCopper)).setUnlocalizedName("BPCopperAxe");
		
		BPTinHelmet = (new ItemExtracraftHelmet(BPTinHelmetId,"item_BronzePlatedTinHelmet", MaterialBPTin, proxy.addArmor("BPtin"), 0)).setUnlocalizedName("BPTinHelmet");
		BPTinChest = (new ItemExtracraftChest(BPTinChestId, "item_BronzePlatedTinChestplate",MaterialBPTin, proxy.addArmor("BPtin"), 1)).setUnlocalizedName("BPTinChest");
		BPTinPants = (new ItemExtracraftPants(BPTinPantsId, "item_BronzePlatedTinLeggings",MaterialBPTin, proxy.addArmor("BPtin"),2)).setUnlocalizedName("BPTinPants");
		BPTinBoots = (new ItemExtracraftBoots(BPTinBootsId, "item_BronzePlatedTinBoots",MaterialBPTin, proxy.addArmor("BPtin"),3)).setUnlocalizedName("BPTinBoots");
		
		BPSteelPickaxe = (new ItemEPickaxe(BPSteelPickaxeId, "item_BronzePlatedSteelPickaxe",toolMaterialBPSteel)).setUnlocalizedName("BPSteelPickaxe");
		BPSteelShovel = (new ItemEShovel(BPSteelShovelId, "item_BronzePlatedSteelShovel",toolMaterialBPSteel)).setUnlocalizedName("BPSteelShovel");
		BPSteelAxe = (new ItemEAxe(BPSteelAxeId, "item_BronzePlatedSteelAxe",toolMaterialBPSteel)).setUnlocalizedName("BPSteelAxe");
		BPSteelHoe = (new ItemEHoe(BPSteelHoeId, "item_BronzePlatedSteelHoe",toolMaterialBPSteel)).setUnlocalizedName("BPSteelHoe");
		BPSteelSword = (new ItemESword(BPSteelSwordId, "item_BronzePlatedSteelSword",toolMaterialBPSteel)).setUnlocalizedName("BPSteelSword");
		
		BPSteelHelmet = (new ItemExtracraftHelmet(BPSteelHelmetId,"item_BronzePlatedSteelHelmet", MaterialBPSteel, proxy.addArmor("BPsteel"), 0)).setUnlocalizedName("BPSteelHelmet");
		BPSteelChest = (new ItemExtracraftChest(BPSteelChestId, "item_BronzePlatedSteelChestplate",MaterialBPSteel, proxy.addArmor("BPsteel"), 1)).setUnlocalizedName("BPSteelChest");
		BPSteelPants = (new ItemExtracraftPants(BPSteelPantsId, "item_BronzePlatedSteelLeggings",MaterialBPSteel, proxy.addArmor("BPsteel"), 2)).setUnlocalizedName("BPSteelPants");
		BPSteelBoots = (new ItemExtracraftBoots(BPSteelBootsId, "item_BronzePlatedSteelBoots",MaterialBPSteel, proxy.addArmor("BPsteel"), 3)).setUnlocalizedName("BPSteelBoots");
		
		BPSandstonePickaxe = (new ItemEPickaxe(BPSandstonePickaxeId,"item_BronzePlatedSandstonePickaxe", toolMaterialBPSandstone)).setUnlocalizedName("BPSandstonePickaxe");
		BPSandstoneShovel = (new ItemEShovel(BPSandstoneShovelId, "item_BronzePlatedSandstoneShovel",toolMaterialBPSandstone)).setUnlocalizedName("BPSandstoneShovel");
		BPSandstoneAxe = (new ItemEAxe(BPSandstoneAxeId, "item_BronzePlatedSandstoneAxe", toolMaterialBPSandstone)).setUnlocalizedName("BPSandstoneAxe");
		BPSandstoneHoe = (new ItemEHoe(BPSandstoneHoeId, "item_BronzePlatedSandstoneHoe",toolMaterialBPSandstone)).setUnlocalizedName("BPSandstoneHoe");
		BPSandstoneSword = (new ItemESword(BPSandstoneSwordId, "item_BronzePlatedSandstoneSword",toolMaterialBPSandstone)).setUnlocalizedName("BPSandstoneSword");
		
		BPBedrockPickaxe = (new ItemEPickaxe(BPBedrockPickaxeId, "item_BronzePlatedBedrockPickaxe", toolMaterialBPBedrock)).setUnlocalizedName("BPBedrockPickaxe");
		BPBedrockShovel = (new ItemEShovel(BPBedrockShovelId, "item_BronzePlatedBedrockShovel",toolMaterialBPBedrock)).setUnlocalizedName("BPBedrockShovel");
		BPBedrockAxe = (new ItemEAxe(BPBedrockAxeId, "item_BronzePlatedBedrockAxe",toolMaterialBPBedrock)).setUnlocalizedName("BPBedrockAxe");
		BPBedrockHoe = (new ItemEHoe(BPBedrockHoeId, "item_BronzePlatedBedrockHoe",toolMaterialBPBedrock)).setUnlocalizedName("BPBedrockHoe");
		
		BPGranitePickaxe = (new ItemEPickaxe(BPGranitePickaxeId, "item_BronzePlatedGranitePickaxe",toolMaterialBPGranite)).setUnlocalizedName("BPGranitePickaxe");
		BPGraniteShovel = (new ItemEShovel(BPGraniteShovelId, "item_BronzePlatedGraniteShovel",toolMaterialBPGranite)).setUnlocalizedName("BPGraniteShovel");
		BPGraniteAxe = (new ItemEAxe(BPGraniteAxeId, "item_BronzePlatedGraniteAxe",toolMaterialBPGranite)).setUnlocalizedName("BPGraniteAxe");
		BPGraniteHoe = (new ItemEHoe(BPGraniteHoeId, "item_BronzePlatedGraniteHoe",toolMaterialBPGranite)).setUnlocalizedName("BPGraniteHoe");
		BPGraniteSword = (new ItemESword(BPGraniteSwordId, "item_BronzePlatedGraniteSword",toolMaterialBPGranite)).setUnlocalizedName("BPGraniteSword");
		
		BPWoodPickaxe = (new ItemEPickaxe(BPWoodPickaxeId, "item_BronzePlatedWoodPickaxe",toolMaterialBPWood)).setUnlocalizedName("BPWoodPickaxe");
		BPWoodShovel = (new ItemEShovel(BPWoodShovelId, "item_BronzePlatedWoodShovel",toolMaterialBPWood)).setUnlocalizedName("BPWoodShovel");
		BPWoodAxe = (new ItemEAxe(BPWoodAxeId, "item_BronzePlatedWoodAxe",toolMaterialBPWood)).setUnlocalizedName("BPWoodAxe");
		BPWoodHoe = (new ItemEHoe(BPWoodHoeId, "item_BronzePlatedWoodHoe",toolMaterialBPWood)).setUnlocalizedName("BPWoodHoe");
		BPWoodSword = (new ItemESword(BPWoodSwordId, "item_BronzePlatedWoodSword",toolMaterialBPWood)).setUnlocalizedName("BPWoodSword");
		
		BPClothHelmet = (new ItemExtracraftHelmet(BPClothHelmetId,"item_BronzePlatedLeatherHelmet", MaterialBPCloth, proxy.addArmor("BPcloth"), 0)).setUnlocalizedName("BPClothHelmet");
		BPClothChest = (new ItemExtracraftChest(BPClothChestId, "item_BronzePlatedLeatherChestplate",MaterialBPCloth, proxy.addArmor("BPcloth"), 1)).setUnlocalizedName("BPClothChest");
		BPClothPants = (new ItemExtracraftPants(BPClothPantsId, "item_BronzePlatedLeatherLeggings",MaterialBPCloth, proxy.addArmor("BPcloth"), 2)).setUnlocalizedName("BPClothPants");
		BPClothBoots = (new ItemExtracraftBoots(BPClothBootsId, "item_BronzePlatedLeatherBoots",MaterialBPCloth, proxy.addArmor("BPcloth"), 3)).setUnlocalizedName("BPClothBoots");
		
		BPStonePickaxe = (new ItemEPickaxe(BPStonePickaxeId, "item_BronzePlatedStonePickaxe",toolMaterialBPStone)).setUnlocalizedName("BPStonePickaxe");
		BPStoneShovel = (new ItemEShovel(BPStoneShovelId, "item_BronzePlatedStoneShovel",toolMaterialBPStone)).setUnlocalizedName("BPStoneShovel");
		BPStoneAxe = (new ItemEAxe(BPStoneAxeId, "item_BronzePlatedStoneAxe",toolMaterialBPStone)).setUnlocalizedName("BPStoneAxe");
		BPStoneHoe = (new ItemEHoe(BPStoneHoeId, "item_BronzePlatedStoneHoe",toolMaterialBPStone)).setUnlocalizedName("BPStoneHoe");
		BPStoneSword = (new ItemESword(BPStoneSwordId, "item_BronzePlatedStoneSword",toolMaterialBPStone)).setUnlocalizedName("BPStoneSword");
		
		BPChainHelmet = (new ItemExtracraftHelmet(BPChainHelmetId,"item_BronzePlatedChainHelmet", MaterialBPChain, proxy.addArmor("BPchain"), 0)).setUnlocalizedName("BPChainHelmet");
		BPChainChest = (new ItemExtracraftChest(BPChainChestId, "item_BronzePlatedChainChestplate",MaterialBPChain, proxy.addArmor("BPchain"), 1)).setUnlocalizedName("BPChainChest");
		BPChainPants = (new ItemExtracraftPants(BPChainPantsId, "item_BronzePlatedChainLeggings",MaterialBPChain, proxy.addArmor("BPchain"), 2)).setUnlocalizedName("BPChainPants");
		BPChainBoots = (new ItemExtracraftBoots(BPChainBootsId, "item_BronzePlatedChainBoots",MaterialBPChain, proxy.addArmor("BPchain"), 3)).setUnlocalizedName("BPChainBoots");
		
		BPIronPickaxe = (new ItemEPickaxe(BPIronPickaxeId, "item_BronzePlatedIronPickaxe",toolMaterialBPIron)).setUnlocalizedName("BPIronPickaxe");
		BPIronShovel = (new ItemEShovel(BPIronShovelId, "item_BronzePlatedIronShovel",toolMaterialBPIron)).setUnlocalizedName("BPIronShovel");
		BPIronAxe = (new ItemEAxe(BPIronAxeId, "item_BronzePlatedIronAxe",toolMaterialBPIron)).setUnlocalizedName("BPIronAxe");
		BPIronHoe = (new ItemEHoe(BPIronHoeId, "item_BronzePlatedIronHoe",toolMaterialBPIron)).setUnlocalizedName("BPIronHoe");
		BPIronSword = (new ItemESword(BPIronSwordId, "item_BronzePlatedIronSword",toolMaterialBPIron)).setUnlocalizedName("BPStoneSword");
		
		BPIronHelmet = (new ItemExtracraftHelmet(BPIronHelmetId,"item_BronzePlatedIronHelmet", MaterialBPIron, proxy.addArmor("BPiron"), 0)).setUnlocalizedName("BPIronHelmet");
		BPIronChest = (new ItemExtracraftChest(BPIronChestId, "item_BronzePlatedIronChestplate",MaterialBPIron, proxy.addArmor("BPiron"), 1)).setUnlocalizedName("BPIronChest");
		BPIronPants = (new ItemExtracraftPants(BPIronPantsId, "item_BronzePlatedIronLeggings",MaterialBPIron, proxy.addArmor("BPiron"), 2)).setUnlocalizedName("BPIronPants");
		BPIronBoots = (new ItemExtracraftBoots(BPIronBootsId, "item_BronzePlatedIronBoots",MaterialBPIron, proxy.addArmor("BPiron"), 3)).setUnlocalizedName("BPIronBoots");
		
		BPGoldPickaxe = (new ItemEPickaxe(BPGoldPickaxeId, "item_BronzePlatedGoldPickaxe",toolMaterialBPGold)).setUnlocalizedName("BPGoldPickaxe");
		BPGoldShovel = (new ItemEShovel(BPGoldShovelId, "item_BronzePlatedGoldShovel",toolMaterialBPGold)).setUnlocalizedName("BPGoldShovel");
		BPGoldAxe = (new ItemEAxe(BPGoldAxeId, "item_BronzePlatedGoldAxe",toolMaterialBPGold)).setUnlocalizedName("BPGoldAxe");
		BPGoldHoe = (new ItemEHoe(BPGoldHoeId, "item_BronzePlatedGoldHoe",toolMaterialBPGold)).setUnlocalizedName("BPGoldHoe");
		BPGoldSword = (new ItemESword(BPGoldSwordId, "item_BronzePlatedGoldSword",toolMaterialBPGold)).setUnlocalizedName("BPGoldSword");
		
		BPGoldHelmet = (new ItemExtracraftHelmet(BPGoldHelmetId,"item_BronzePlatedGoldHelmet", MaterialBPGold, proxy.addArmor("BPgold"), 0)).setUnlocalizedName("BPGoldHelmet");
		BPGoldChest = (new ItemExtracraftChest(BPGoldChestId, "item_BronzePlatedGoldChestplate",MaterialBPGold, proxy.addArmor("BPgold"), 1)).setUnlocalizedName("BPGoldChest");
		BPGoldPants = (new ItemExtracraftPants(BPGoldPantsId, "item_BronzePlatedGoldLeggings",MaterialBPGold, proxy.addArmor("BPgold"), 2)).setUnlocalizedName("BPGoldPants");
		BPGoldBoots = (new ItemExtracraftBoots(BPGoldBootsId, "item_BronzePlatedGoldBoots",MaterialBPGold, proxy.addArmor("BPgold"), 3)).setUnlocalizedName("BPGoldBoots");
		
		BPDiamondPickaxe = (new ItemEPickaxe(BPDiamondPickaxeId, "item_BronzePlatedDiamondPickaxe",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondPickaxe");
		BPDiamondShovel = (new ItemEShovel(BPDiamondShovelId, "item_BronzePlatedDiamondShovel",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondShovel");
		BPDiamondAxe = (new ItemEAxe(BPDiamondAxeId, "item_BronzePlatedDiamondAxe",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondAxe");
		BPDiamondHoe = (new ItemEHoe(BPDiamondHoeId, "item_BronzePlatedDiamondHoe",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondHoe");
		BPDiamondSword = (new ItemESword(BPDiamondSwordId, "item_BronzePlatedDiamondSword",toolMaterialBPEmerald)).setUnlocalizedName("BPDiamondSword");
		
		BPDiamondHelmet = (new ItemExtracraftHelmet(BPDiamondHelmetId,"item_BronzePlatedDiamondHelmet", MaterialBPDiamond, proxy.addArmor("BPdiamond"), 0)).setUnlocalizedName("BPDiamondHelmet");
		BPDiamondChest = (new ItemExtracraftChest(BPDiamondChestId, "item_BronzePlatedDiamondChestplate",MaterialBPDiamond, proxy.addArmor("BPdiamond"), 1)).setUnlocalizedName("BPDiamondChest");
		BPDiamondPants = (new ItemExtracraftPants(BPDiamondPantsId, "item_BronzePlatedDiamondLeggings",MaterialBPDiamond, proxy.addArmor("BPdiamond"), 2)).setUnlocalizedName("BPDiamondPants");
		BPDiamondBoots = (new ItemExtracraftBoots(BPDiamondBootsId, "item_BronzePlatedDiamondBoots",MaterialBPDiamond, proxy.addArmor("BPdiamond"), 3)).setUnlocalizedName("BPDiamondBoots");		
		
		SmoothRadiantQuartz = (new EOBlock(smoothRadiantQuartzId, "block_SmoothRadiantQuartz", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("SmoothRadiantQuartz");
		ChiseledRadiantQuartz = (new EOBlock(chiseledRadiantQuartzId, "block_ChiseledRadiantQuartz", Material.rock)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("ChiseledRadiantQuartz");
		PillarRadiantQuartz = (new BlockRadiantPillar(pillarRadiantQuartzId)).setHardness(6F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setLightValue(0.5F).setUnlocalizedName("PillarRadiantQuartz");
		RadiantQuartzOre = (new EOBlock(radiantQuartzOreId, "block_RadiantQuartzOre", Material.rock)).setHardness(5.5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setCreativeTab(ExtraOres.tabOresBlocks).setLightValue(0.4F).setUnlocalizedName("RadiantQuartzOre");
		
		RadiantQuartz = (new EItemFoiled(radiantQuartzId, "item_RadiantQuartz")).setCreativeTab(ExtraOres.tabOresItems).setUnlocalizedName("RadiantQuartz");
		
		Godstone = (new BlockGodstone(godstoneId, Material.rock)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setLightValue(1F).setUnlocalizedName("Godstone");
		
		melterIdle = (new BlockMelter(melterIdleId, false)).setHardness(6F).setResistance(8.0F).setCreativeTab(ExtraOres.tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("melter");
		melterBurning = (new BlockMelter(melterBurningId, true)).setHardness(6F).setResistance(8.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("melter");
	
		RadiantQuartzStairs = new EOBlockStairs(radiantQuartzStairsId, SmoothRadiantQuartz, 0).setUnlocalizedName("RadiantQuartzStairs");
		RadiantQuartzSingleSlab = (BlockHalfSlab) new RadiantQuartzSlab(radiantQuartzSingleSlabId, false).setUnlocalizedName("RadiantQuartzSingleSlab").setCreativeTab(tabOresBlocks);
		RadiantQuartzDoubleSlab = (BlockHalfSlab) new RadiantQuartzSlab(radiantQuartzDoubleSlabId, true).setUnlocalizedName("RadiantQuartzDoubleSlab");
	
		PinkQuartzStairs = new EOBlockStairs(pinkQuartzStairsId, SmoothQuartzite, 0).setUnlocalizedName("PinkQuartzStairs");
		PinkQuartzSingleSlab = (BlockHalfSlab) new PinkQuartzSlab(pinkQuartzSingleSlabId, false).setUnlocalizedName("PinkQuartzSingleSlab").setCreativeTab(tabOresBlocks);
		PinkQuartzDoubleSlab = (BlockHalfSlab) new PinkQuartzSlab(pinkQuartzDoubleSlabId, true).setUnlocalizedName("PinkQuartzDoubleSlab");
		
		graniteBrickStairs = new EOBlockStairs(graniteBrickStairsId, GraniteBrick, 0).setUnlocalizedName("graniteBrickStairs");
		graniteBrickSingleSlab = (BlockHalfSlab) new GraniteBrickSlab(graniteBrickSingleSlabId, false).setUnlocalizedName("graniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		graniteBrickDoubleSlab = (BlockHalfSlab) new GraniteBrickSlab(graniteBrickDoubleSlabId, true).setUnlocalizedName("graniteBrickDoubleSlab");
		
		tinPlatedCobbleStairs = new EOBlockStairs(tinPlatedCobbleStairsId, TinPlatedCobble, 0).setUnlocalizedName("tinPlatedCobbleStairs");
		tinPlatedCobbleSingleSlab = (BlockHalfSlab) new TinPlatedCobbleSlab(tinPlatedCobbleSingleSlabId, false).setUnlocalizedName("tinPlatedCobbleSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedCobbleDoubleSlab = (BlockHalfSlab) new TinPlatedCobbleSlab(tinPlatedCobbleDoubleSlabId, true).setUnlocalizedName("tinPlatedCobbleDoubleSlab");
		
		steelPlatedCobbleStairs = new EOBlockStairs(steelPlatedCobbleStairsId, SteelPlatedCobble, 0).setUnlocalizedName("steelPlatedCobbleStairs");
		steelPlatedCobbleSingleSlab = (BlockHalfSlab) new SteelPlatedCobbleSlab(steelPlatedCobbleSingleSlabId, false).setUnlocalizedName("steelPlatedCobbleSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedCobbleDoubleSlab = (BlockHalfSlab) new SteelPlatedCobbleSlab(steelPlatedCobbleDoubleSlabId, true).setUnlocalizedName("steelPlatedCobbleDoubleSlab");
		
		bronzePlatedCobbleStairs = new EOBlockStairs(bronzePlatedCobbleStairsId, BronzePlatedCobble, 0).setUnlocalizedName("bronzePlatedCobbleStairs");
		bronzePlatedCobbleSingleSlab = (BlockHalfSlab) new BronzePlatedCobbleSlab(bronzePlatedCobbleSingleSlabId, false).setUnlocalizedName("bronzePlatedCobbleSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedCobbleDoubleSlab = (BlockHalfSlab) new BronzePlatedCobbleSlab(bronzePlatedCobbleDoubleSlabId, true).setUnlocalizedName("bronzePlatedCobbleDoubleSlab");
		
		tinPlatedStoneBrickStairs = new EOBlockStairs(tinPlatedStoneBrickStairsId, TinPlatedStoneBrick, 0).setUnlocalizedName("tinPlatedStoneBrickStairs");
		tinPlatedStoneBrickSingleSlab = (BlockHalfSlab) new TinPlatedStoneBrickSlab(tinPlatedStoneBrickSingleSlabId, false).setUnlocalizedName("tinPlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedStoneBrickDoubleSlab = (BlockHalfSlab) new TinPlatedStoneBrickSlab(tinPlatedStoneBrickDoubleSlabId, true).setUnlocalizedName("tinPlatedStoneBrickDoubleSlab");
		
		steelPlatedStoneBrickStairs = new EOBlockStairs(steelPlatedStoneBrickStairsId, SteelPlatedStoneBrick, 0).setUnlocalizedName("steelPlatedStoneBrickStairs");
		steelPlatedStoneBrickSingleSlab = (BlockHalfSlab) new SteelPlatedStoneBrickSlab(steelPlatedStoneBrickSingleSlabId, false).setUnlocalizedName("steelPlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedStoneBrickDoubleSlab = (BlockHalfSlab) new SteelPlatedStoneBrickSlab(steelPlatedStoneBrickDoubleSlabId, true).setUnlocalizedName("steelPlatedStoneBrickDoubleSlab");
		
		bronzePlatedStoneBrickStairs = new EOBlockStairs(bronzePlatedStoneBrickStairsId, BronzePlatedStoneBrick, 0).setUnlocalizedName("bronzePlatedStoneBrickStairs");
		bronzePlatedStoneBrickSingleSlab = (BlockHalfSlab) new BronzePlatedStoneBrickSlab(bronzePlatedStoneBrickSingleSlabId, false).setUnlocalizedName("bronzePlatedStoneBrickSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedStoneBrickDoubleSlab = (BlockHalfSlab) new BronzePlatedStoneBrickSlab(bronzePlatedStoneBrickDoubleSlabId, true).setUnlocalizedName("bronzePlatedStoneBrickDoubleSlab");
		
		tinPlatedGraniteBrickStairs = new EOBlockStairs(tinPlatedGraniteBrickStairsId, this.TinPlatedGranite, 0).setUnlocalizedName("tinPlatedGraniteBrickStairs");
		tinPlatedGraniteBrickSingleSlab = (BlockHalfSlab) new TinPlatedGraniteBrickSlab(tinPlatedGraniteBrickSingleSlabId, false).setUnlocalizedName("tinPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		tinPlatedGraniteBrickDoubleSlab = (BlockHalfSlab) new TinPlatedGraniteBrickSlab(tinPlatedGraniteBrickDoubleSlabId, true).setUnlocalizedName("tinPlatedGraniteBrickDoubleSlab");
		
		steelPlatedGraniteBrickStairs = new EOBlockStairs(steelPlatedGraniteBrickStairsId, this.SteelPlatedGranite, 0).setUnlocalizedName("steelPlatedGraniteBrickStairs");
		steelPlatedGraniteBrickSingleSlab = (BlockHalfSlab) new SteelPlatedGraniteBrickSlab(steelPlatedGraniteBrickSingleSlabId, false).setUnlocalizedName("steelPlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		steelPlatedGraniteBrickDoubleSlab = (BlockHalfSlab) new SteelPlatedGraniteBrickSlab(steelPlatedGraniteBrickDoubleSlabId, true).setUnlocalizedName("steelPlatedGraniteBrickDoubleSlab");
		
		bronzePlatedGraniteBrickStairs = new EOBlockStairs(bronzePlatedGraniteBrickStairsId, this.BronzePlatedGranite, 0).setUnlocalizedName("bronzePlatedGraniteBrickStairs");
		bronzePlatedGraniteBrickSingleSlab = (BlockHalfSlab) new BronzePlatedGraniteBrickSlab(bronzePlatedGraniteBrickSingleSlabId, false).setUnlocalizedName("bronzePlatedGraniteBrickSingleSlab").setCreativeTab(tabOresBlocks);
		bronzePlatedGraniteBrickDoubleSlab = (BlockHalfSlab) new BronzePlatedGraniteBrickSlab(bronzePlatedGraniteBrickDoubleSlabId, true).setUnlocalizedName("bronzePlatedGraniteBrickDoubleSlab");
		
		plutoniumInsulated = (new BlockPlutoniumInsulated(plutoniumInsulatedId, Material.iron)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("plutoniumInsulated");
		uraniumInsulated = (new BlockUraniumInsulated(uraniumInsulatedId, Material.iron)).setHardness(6F).setResistance(9F).setCreativeTab(tabOresBlocks).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("uraniumInsulated");
          
        EONameManager.loadNames();
		EORecipeManager.loadRecipes();
		EOBlockRegister.registerBlocks();		
   }
	
	@Mod.EventHandler
    public void loadNew(FMLInitializationEvent event)
    {		
        proxy.registerRenderThings(); //this allows seperate renderings for server and client
        
        TickRegistry.registerTickHandler(new ClientTickHandler(EnumSet.of(TickType.CLIENT)), Side.CLIENT);
        TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);

        GameRegistry.registerFuelHandler(new EOFuelHandler());
    	GameRegistry.registerTileEntity(TileEntityMelter.class, "tileEntityMelter");

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
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(this.SoulGem),1,3,12));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.ToriteIngot),1,3,8));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.SunstoneDust),1,7,25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.PinkQuartz),1,10,25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this.RadiantQuartz),1,3,10));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.CopperIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.TinIngot),1,5,30));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.BronzeIngot),1,3,25));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.CoalIronIngot),1,5,17));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(this.SteelIngot),1,5,17));
		
		VillagerRegistry.instance().registerVillageTradeHandler(3, new BlacksmithTradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(2, new PriestTradeHandler());
		
		MinecraftForge.setBlockHarvestLevel(CopperOre, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(CopperBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(TinOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(TinBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(meuroditeOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(meuroditeBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ToriteOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ToriteBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(TitaniumOre, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(TitaniumBlock, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(UraniumOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(PlutoniumOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(SunstoneOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(Granite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(GraniteBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Quartzite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(QuartziteTile, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(SmoothQuartzite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(PillarQuartzite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(ChiseledQuartzite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(SmoothQuartzTile, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(BlaziumOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(BlaziumBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(SoulOre, "shovel", 2);
		MinecraftForge.setBlockHarvestLevel(TinPlatedCobble, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(TinPlatedMossy, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(TinPlatedStoneBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(TinPlatedChiseled, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(TinPlatedGranite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(BronzeBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(BronzePlatedCobble, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(BronzePlatedMossy, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(BronzePlatedStoneBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(BronzePlatedChiseled, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(BronzePlatedGranite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(SteelPlatedCobble, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(SteelPlatedMossy, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(SteelPlatedStoneBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(SteelPlatedChiseled, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(SteelPlatedGranite, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(RawUraniumBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(RawPlutoniumBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(SmoothRadiantQuartz, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(PillarRadiantQuartz, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(ChiseledRadiantQuartz, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(RadiantQuartzOre, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(Godstone, "pickaxe", 2);
		
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		NetworkRegistry.instance().registerConnectionHandler(new sobiohazardous.minestrappolation.extraores.handler.NetworkHandler());
		
	}
	
	@Mod.EventHandler
    public void myNewPostLoadMethod(FMLPostInitializationEvent evt)
    {
		Item.itemsList[this.RadiantQuartzSingleSlab.blockID] = (new ItemSlab(this.RadiantQuartzSingleSlab.blockID - 256, (BlockHalfSlab)RadiantQuartzSingleSlab, (BlockHalfSlab)RadiantQuartzDoubleSlab, false));
		Item.itemsList[this.PinkQuartzSingleSlab.blockID] = (new ItemSlab(this.PinkQuartzSingleSlab.blockID - 256, (BlockHalfSlab)PinkQuartzSingleSlab, (BlockHalfSlab)PinkQuartzDoubleSlab, false));
		Item.itemsList[this.graniteBrickSingleSlab.blockID] = (new ItemSlab(this.graniteBrickSingleSlab.blockID - 256, (BlockHalfSlab)graniteBrickSingleSlab, (BlockHalfSlab)graniteBrickDoubleSlab, false));
		Item.itemsList[this.tinPlatedCobbleSingleSlab.blockID] = (new ItemSlab(this.tinPlatedCobbleSingleSlab.blockID - 256, (BlockHalfSlab)tinPlatedCobbleSingleSlab, (BlockHalfSlab)tinPlatedCobbleDoubleSlab, false));
		Item.itemsList[this.steelPlatedCobbleSingleSlab.blockID] = (new ItemSlab(this.steelPlatedCobbleSingleSlab.blockID - 256, (BlockHalfSlab)steelPlatedCobbleSingleSlab, (BlockHalfSlab)steelPlatedCobbleDoubleSlab, false));
		Item.itemsList[this.bronzePlatedCobbleSingleSlab.blockID] = (new ItemSlab(this.bronzePlatedCobbleSingleSlab.blockID - 256, (BlockHalfSlab)bronzePlatedCobbleSingleSlab, (BlockHalfSlab)bronzePlatedCobbleDoubleSlab, false));
		Item.itemsList[this.tinPlatedStoneBrickSingleSlab.blockID] = (new ItemSlab(this.tinPlatedStoneBrickSingleSlab.blockID - 256, (BlockHalfSlab)tinPlatedStoneBrickSingleSlab, (BlockHalfSlab)tinPlatedStoneBrickDoubleSlab, false));
		Item.itemsList[this.steelPlatedStoneBrickSingleSlab.blockID] = (new ItemSlab(this.steelPlatedStoneBrickSingleSlab.blockID - 256, (BlockHalfSlab)steelPlatedStoneBrickSingleSlab, (BlockHalfSlab)steelPlatedStoneBrickDoubleSlab, false));
		Item.itemsList[this.bronzePlatedStoneBrickSingleSlab.blockID] = (new ItemSlab(this.bronzePlatedStoneBrickSingleSlab.blockID - 256, (BlockHalfSlab)bronzePlatedStoneBrickSingleSlab, (BlockHalfSlab)bronzePlatedStoneBrickDoubleSlab, false));
		Item.itemsList[this.tinPlatedGraniteBrickSingleSlab.blockID] = (new ItemSlab(this.tinPlatedGraniteBrickSingleSlab.blockID - 256, (BlockHalfSlab)tinPlatedGraniteBrickSingleSlab, (BlockHalfSlab)tinPlatedGraniteBrickDoubleSlab, false));
		Item.itemsList[this.steelPlatedGraniteBrickSingleSlab.blockID] = (new ItemSlab(this.steelPlatedGraniteBrickSingleSlab.blockID - 256, (BlockHalfSlab)steelPlatedGraniteBrickSingleSlab, (BlockHalfSlab)steelPlatedGraniteBrickDoubleSlab, false));
		Item.itemsList[this.bronzePlatedGraniteBrickSingleSlab.blockID] = (new ItemSlab(this.bronzePlatedGraniteBrickSingleSlab.blockID - 256, (BlockHalfSlab)bronzePlatedGraniteBrickSingleSlab, (BlockHalfSlab)bronzePlatedGraniteBrickDoubleSlab, false));
    }

}
