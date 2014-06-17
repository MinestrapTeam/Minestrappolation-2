package minestrapteam.minestrappolation.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.minestrap_core.block.MCBlock;
import minestrapteam.minestrap_core.item.block.MCItemBlockMulti;
import minestrapteam.minestrap_core.util.MCAssetManager;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.*;
import minestrapteam.minestrappolation.block.slab.BlockWoodBoardSlab;
import minestrapteam.minestrappolation.item.block.ItemBlockWoodBoardSlab;
import minestrapteam.minestrappolation.material.MaterialOoze;
import minestrapteam.minestrappolation.tileentity.TileEntityPlate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MBlocks
{
	public static Block				copperOre;
	public static Block				tinOre;
	public static Block				titaniumOre;
	public static Block				uraniumOre;
	public static Block				plutoniumOre;
	public static Block				meuroditeOre;
	public static Block				sunstoneOre;
	public static Block				toriteOre;
	public static Block				blaziumOre;
	public static Block				soulOre;
	public static Block				radiantQuartzOre;
	
	public static Block				copperBlock;
	public static Block				tinBlock;
	public static Block				bronzeBlock;
	public static Block				titaniumBlock;
	public static Block				uraniumBlock;
	public static Block				uraniumInsulated;
	public static Block				plutoniumBlock;
	public static Block				plutoniumInsulated;
	public static Block				meuroditeBlock;
	public static Block				sunstoneBlock;
	public static Block				toriteBlock;
	public static Block				blaziumBlock;
	public static Block				steelBlock;
	
	public static Block				tinPlate;
	public static Block				bronzePlate;
	public static Block				steelPlate;
	public static Block				meuroditePlate;
	
	public static Block				invincium;
	
	public static Block				glowGlass;
	
	public static Block				nuke;
	
	public static Block				godstone;
	
	public static Block				melterIdle;
	public static Block				melterBurning;
	
	public static Block				radiantQuartzStairs;
	public static Block				pinkQuartzStairs;
	
	public static Block				graniteBrickStairs;
	public static Block				tinPlatedCobbleStairs;
	public static Block				steelPlatedCobbleStairs;
	public static Block				bronzePlatedCobbleStairs;
	public static Block				tinPlatedStoneBrickStairs;
	public static Block				steelPlatedStoneBrickStairs;
	public static Block				bronzePlatedStoneBrickStairs;
	public static Block				tinPlatedGraniteBrickStairs;
	public static Block				steelPlatedGraniteBrickStairs;
	public static Block				bronzePlatedGraniteBrickStairs;
	
	// public static Block magma;
	
	public static Block				soulBlock;
	
	public static Block				doorWoodOverwrite;
	
	// TODO: ORGANIZE ED BLOCKS
	public static final Material	materialOoze	= new MaterialOoze(MapColor.foliageColor);
	
	public static Block				goblet;
	public static Block				plate;
	public static Block				edgeStoneBrick;
	public static Block				snowBrick;
	public static Block				glassRefined;
	public static Block				glassRefinedPane;
	
	public static Block				woodPanel;
	public static Block				woodBeveled;
	public static Block				gunpowderBlock;
	public static Block				sugarBlock;
	public static Block				meatBlock;
	public static Block				enderBlock;
	public static Block				oozeSlime;
	
	public static Block				rope;
	public static Block				ropeCoil;
	public static Block				crate;
	public static Block				barrel;
	public static Block				cardboard;
	public static Block				cardboardBlock;
	
	public static Block				woodBoards;
	public static Block				magmaOoze;
	
	public static Block				woodBoardsStairsOak;
	public static Block				woodBoardsStairsBirch;
	public static Block				woodBoardsStairsSpruce;
	public static Block				woodBoardsStairsJungle;
	public static BlockSlab			woodBoardsSingleSlab;
	public static BlockSlab			woodBoardsDoubleSlab;
	
	// public static Block checkerTileStairs;
	
	public static Block				infertileDirt;
	
	public static Block				sandyRoad;
	public static Block				sandstoneRoad;
	public static Block				gravelRoad;
	public static Block				cobbledRoad;
	public static Block				netherroad;
	
	public static Block				woodPlanksMossy;
	
	public static Block				glassDoor;
	
	public static void init()
	{
		meuroditeOre = new MCBlock(Material.rock).setHardness(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("oreMeurodite").setBlockTextureName(MCAssetManager.getMineralTexture("meurodite_ore"));
		GameRegistry.registerBlock(meuroditeOre, "oreMeurodite");
		meuroditeBlock = new MCBlock(Material.iron).setHardness(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("blockMeurodite").setBlockTextureName(MCAssetManager.getMineralTexture("meurodite_block"));
		GameRegistry.registerBlock(meuroditeBlock, "blockMeurodite");
		uraniumOre = new BlockUraniumOre(Material.rock).setHardness(5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreUranium").setBlockTextureName(MCAssetManager.getMineralTexture("uranium_ore"));
		GameRegistry.registerBlock(uraniumOre, "oreUranium");
		uraniumBlock = new BlockUraniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockUranium").setBlockTextureName(MCAssetManager.getMineralTexture("uranium_block"));
		GameRegistry.registerBlock(uraniumBlock, "blockUraniumRaw");
		plutoniumOre = new BlockPlutoniumOre(Material.rock).setHardness(5F).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockName("orePlutonium").setBlockTextureName(MCAssetManager.getMineralTexture("plutonium_ore")).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		GameRegistry.registerBlock(plutoniumOre, "orePlutonium");
		plutoniumBlock = new BlockPlutoniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockPlutonium").setBlockTextureName(MCAssetManager.getMineralTexture("plutonium_block"));
		GameRegistry.registerBlock(plutoniumBlock, "blockPlutoniumRaw");
		titaniumOre = new MCBlock(Material.rock).setHardness(10F).setResistance(15F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreTitanium").setBlockTextureName(MCAssetManager.getMineralTexture("titanium_ore"));
		GameRegistry.registerBlock(titaniumOre, "oreTitanium");
		titaniumBlock = new MCBlock(Material.iron).setHardness(10F).setResistance(12000000.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTitanium").setBlockTextureName(MCAssetManager.getMineralTexture("titanium_block"));
		GameRegistry.registerBlock(titaniumBlock, "blockTitanium");
		sunstoneBlock = new BlockSunstone(Material.glass).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setLightLevel(1.0F).setBlockName("blockSunstone").setBlockTextureName(MCAssetManager.getMineralTexture("sunstone_block"));
		GameRegistry.registerBlock(sunstoneBlock, "blockSunstone");
		sunstoneOre = new BlockSunstoneOre().setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("oreSunstone").setBlockTextureName(MCAssetManager.getMineralTexture("sunstone_ore")).setLightLevel(1F);
		GameRegistry.registerBlock(sunstoneOre, "oreSunstone");
		
		toriteOre = new MCBlock(Material.rock).setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("oreTorite").setBlockTextureName(MCAssetManager.getMineralTexture("torite_ore"));
		GameRegistry.registerBlock(toriteOre, "oreTorite");
		toriteBlock = new MCBlock(Material.iron).setHardness(6F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTorite").setBlockTextureName(MCAssetManager.getMineralTexture("torite_block"));
		GameRegistry.registerBlock(toriteBlock, "blockTorite");
		
		blaziumOre = new BlockBlaziumOre().setHardness(7F).setResistance(11F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("oreBlazium").setBlockTextureName(MCAssetManager.getMineralTexture("blazium_ore")).setLightLevel(0.5F);
		GameRegistry.registerBlock(blaziumOre, "oreBlazium");
		blaziumBlock = new BlockBlazium().setHardness(8F).setResistance(12F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("blockBlazium").setBlockTextureName(MCAssetManager.getMineralTexture("blazium_block")).setLightLevel(0.7F);
		GameRegistry.registerBlock(blaziumBlock, "blockBlazium");
		
		copperOre = new MCBlock(Material.rock).setHardness(3F).setResistance(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreCopper").setBlockTextureName(MCAssetManager.getMineralTexture("copper_ore"));
		GameRegistry.registerBlock(copperOre, "oreCopper");
		copperBlock = new BlockCopper(Material.iron).setHardness(5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockCopper");
		GameRegistry.registerBlock(copperBlock, "blockCopper");
		tinOre = new MCBlock(Material.rock).setHardness(3F).setResistance(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreTin").setBlockTextureName(MCAssetManager.getMineralTexture("tin_ore"));
		GameRegistry.registerBlock(tinOre, "oreTin");
		tinBlock = new MCBlock(Material.iron).setHardness(3F).setResistance(2F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockTin").setBlockTextureName(MCAssetManager.getMineralTexture("tin_block"));
		GameRegistry.registerBlock(tinBlock, "blockTin");
		tinPlate = new BlockPlateMetal().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingTin").setBlockTextureName(MCAssetManager.getMineralTexture("tin_block"));
		GameRegistry.registerBlock(tinPlate, "plateTin");
		bronzePlate = new BlockPlateMetal().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingBronze").setBlockTextureName(MCAssetManager.getMineralTexture("bronze_block"));
		GameRegistry.registerBlock(bronzePlate, "plateBronze");
		steelPlate = new BlockPlateMetal().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingSteel").setBlockTextureName(MCAssetManager.getMineralTexture("steel_block_top"));
		GameRegistry.registerBlock(steelPlate, "plateSteel");
		meuroditePlate = new BlockPlateMetal().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockName("platingMeurodite").setBlockTextureName(MCAssetManager.getMineralTexture("meurodite_block"));
		GameRegistry.registerBlock(meuroditePlate, "plateMeurodite");
		steelBlock = new BlockSteel().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("blockSteel").setBlockTextureName(MCAssetManager.getMineralTexture("steel_block_top"));
		GameRegistry.registerBlock(steelBlock, "blockSteel");
		soulOre = new BlockSoulOre().setHardness(2F).setResistance(3F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("oreSoulGem").setBlockTextureName(MCAssetManager.getMineralTexture("soul_gem_ore"));
		GameRegistry.registerBlock(soulOre, "oreSoul");
		bronzeBlock = new MCBlock(Material.iron).setHardness(7F).setResistance(20F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_Bronze").setBlockTextureName(MCAssetManager.getMineralTexture("bronze_block"));
		GameRegistry.registerBlock(bronzeBlock, "blockBronze");
		invincium = new BlockInvincium(Material.rock).setBlockUnbreakable().setResistance(12000000.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("block_Invincium").setBlockTextureName(MCAssetManager.getMineralTexture("invincium"));
		GameRegistry.registerBlock(invincium, "invincium");
		nuke = new BlockNuke().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("nuke");
		GameRegistry.registerBlock(nuke, "nuke");
		godstone = new BlockGodstone(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setLightLevel(1F).setBlockName("Godstone").setBlockTextureName(MCAssetManager.getMineralTexture("godstone"));
		GameRegistry.registerBlock(godstone, "godstone");
		melterIdle = new BlockMelter(false).setHardness(6F).setResistance(8.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("melter");
		GameRegistry.registerBlock(melterIdle, "melterIdle");
		melterBurning = new BlockMelter(true).setHardness(6F).setResistance(8.0F).setStepSound(Block.soundTypeStone).setBlockName("melter").setLightLevel(1F);
		GameRegistry.registerBlock(melterBurning, "melterBurning");
		
		plutoniumInsulated = new BlockPlutoniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeMetal).setBlockName("plutoniumInsulated");
		GameRegistry.registerBlock(plutoniumInsulated, "plutoniumInsulated");
		uraniumInsulated = new BlockUraniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeMetal).setBlockName("uraniumInsulated");
		GameRegistry.registerBlock(uraniumInsulated, "uraniumInsulated");
		// magma = new
		// BlockMagma(EOConfig.magmaId).setHardness(100.0F).setLightOpacity(3).setBlockName("magma").setLightLevel(1F);
		
		soulBlock = new BlockSoulBlock().setBlockName("block_SoulBlock").setHardness(65F).setResistance(30F).setLightLevel(1F).setBlockTextureName(MCAssetManager.getMineralTexture("soul_gem_block"));
		GameRegistry.registerBlock(soulBlock, "blockSoul");
		
		glowGlass = new BlockGlowGlass(Material.glass, true).setBlockName("block_GlowGlass").setLightLevel(0.7F).setStepSound(Block.soundTypeGlass).setHardness(.8F);
		GameRegistry.registerBlock(glowGlass, "block_GlowGlass");
		
		// TODO: ORGANIZE ED BLOCKS
		
		edgeStoneBrick = new BlockEdgeStoneBrick().setHardness(1.5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("edgeStoneBrick");
		
		snowBrick = new BlockSnowBrick().setHardness(0.3F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeSnow).setBlockName("tilesSnow").setBlockTextureName(MCAssetManager.getTexture("snow_tiles"));
		
		glassRefined = new BlockGlassRefined(Material.glass, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("glassRefined");
		glassRefinedPane = new EDBlockPane(Material.glass, MCAssetManager.getTexture("refined_glass"), MCAssetManager.getTexture("refined_glass_pane_edge"), false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("glassRefinedPane");
		gunpowderBlock = new BlockGunpowderBlock(Material.ground).setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("GunpowderBlock").setBlockTextureName(MCAssetManager.getMineralTexture("gunpowder_block"));
		
		rope = new BlockRope().setHardness(0.9F).setStepSound(Block.soundTypeCloth).setBlockName("rope");
		ropeCoil = new BlockRopeCoil().setHardness(0.9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeCloth).setBlockName("ropeCoil");
		
		oozeSlime = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setStepSound(Block.soundTypeCloth).setBlockName("SlimeOoze").setBlockTextureName(MCAssetManager.getTexture("ooze_slime"));
				
		sugarBlock = new BlockSugarBlock().setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("SugarBlock").setBlockTextureName(MCAssetManager.getFoodTexture("sugar_block"));
		meatBlock = new BlockMeatBlock().setHardness(0.8F).setStepSound(Block.soundTypeCloth).setBlockName("MeatBlock").setBlockTextureName(MCAssetManager.getFoodTexture("meat_block"));
		
		magmaOoze = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setStepSound(Block.soundTypeCloth).setBlockName("MagmaOoze").setBlockTextureName(MCAssetManager.getTexture("ooze_magma"));
		
		enderBlock = new BlockEnderblock().setHardness(3.0F).setResistance(4.0F).setBlockName("EnderBlock").setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabDecorationBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("ender_block"));
		
		crate = new BlockCrate().setHardness(2.5F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("crate");
		barrel = new BlockBarrel().setHardness(3F).setResistance(6.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("barrel");
		
		cardboard = new EDBlockPane(Material.cloth, MCAssetManager.getTexture("cardboard"), MCAssetManager.getTexture("cardboard_pane_edge"), true).setHardness(0.3F).setBlockName("cardboard");
		cardboardBlock = new BlockCardboard(Material.cloth).setHardness(0.4F).setBlockName("CardboardBlock").setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		woodBoardsStairsOak = new EDBlockStairs(woodBoards, 0).setBlockName("woodBoardsStairsOak").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		woodBoardsStairsBirch = new EDBlockStairs(woodBoards, 1).setBlockName("woodBoardsStairsBirch").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		woodBoardsStairsSpruce = new EDBlockStairs(woodBoards, 2).setBlockName("woodBoardsStairsSpruce").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		woodBoardsStairsJungle = new EDBlockStairs(woodBoards, 3).setBlockName("woodBoardsStairsJungle").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		woodBoardsSingleSlab = (BlockSlab) new BlockWoodBoardSlab(false).setBlockName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setLightOpacity(255);
		woodBoardsDoubleSlab = (BlockSlab) new BlockWoodBoardSlab(true).setBlockName("woodBoardsSingleSlab").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setLightOpacity(255);
		
		// checkerTileStairs = new EDBlockStairs(Tiles,
		// 3).setBlockName("checkerTileStairs").setHardness(3F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		cobbledRoad = new EDBlockRoad().setHardness(1).setResistance(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("cobbledRoad");
		infertileDirt = new MCBlock(Material.grass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("InfertileSoil").setHardness(.4F).setStepSound(Block.soundTypeGrass).setBlockTextureName(MCAssetManager.getTexture("grasslessDirt"));
		
		sandyRoad = new EDBlockRoad().setHardness(0.8F).setResistance(4F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("sandyRoad");
		sandstoneRoad = new EDBlockRoad().setHardness(1).setResistance(4.5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("sandstoneRoad");
		gravelRoad = new EDBlockRoad().setHardness(1.5F).setResistance(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("gravelRoad");
		netherroad = new EDBlockRoad().setHardness(2.2F).setResistance(4F).setBlockName("netherroad").setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		woodPlanksMossy = new BlockMossyWood().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("woodPlanksMossy").setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		goblet = new BlockGoblet(Material.rock).setHardness(.5F).setBlockName("goblet");
		plate = new BlockPlate(Material.rock).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("plate");
		
		glassDoor = new BlockGlassDoor(Material.glass).setHardness(1F).setBlockName("doorGlass");		
	}
	
	public static void load()
	{
		// TODO: ORGANIZE ED BLOCKS;
		GameRegistry.registerTileEntity(TileEntityPlate.class, "Plate");
		
		// GameRegistry.registerBlock(checkerTileStairs, "checkerTileStairs");
		
		GameRegistry.registerBlock(cobbledRoad, "cobbledRoad");
		
		GameRegistry.registerBlock(edgeStoneBrick, "edgeStoneBrick");
		
		GameRegistry.registerBlock(snowBrick, "snowBrick");
		
		GameRegistry.registerBlock(glassDoor, "GlassDoor");
		GameRegistry.registerBlock(glassRefined, "glassRefined");
		GameRegistry.registerBlock(glassRefinedPane, "glassRefinedPane");
		
		GameRegistry.registerBlock(gunpowderBlock, "gunpowderBlock");
		GameRegistry.registerBlock(sugarBlock, "sugarBlock");
		GameRegistry.registerBlock(meatBlock, "meatBlock");
		GameRegistry.registerBlock(enderBlock, "enderBlock");
		
		GameRegistry.registerBlock(rope, "rope");
		GameRegistry.registerBlock(ropeCoil, "ropeCoil");
		
		GameRegistry.registerBlock(oozeSlime, "oozeSlime");
		GameRegistry.registerBlock(magmaOoze, "magmaOoze");
		
		GameRegistry.registerBlock(woodBoards, MCItemBlockMulti.class, "woodBoards");
		
		GameRegistry.registerBlock(crate, "crate");
		GameRegistry.registerBlock(barrel, "barrel");
		GameRegistry.registerBlock(cardboard, "cardboard");
		GameRegistry.registerBlock(cardboardBlock, "cardboardBlock");
		
		GameRegistry.registerBlock(infertileDirt, "infertileDirt");
		
		GameRegistry.registerBlock(sandyRoad, "sandyRoad");
		GameRegistry.registerBlock(sandstoneRoad, "sandstoneRoad");
		GameRegistry.registerBlock(gravelRoad, "gravelRoad");
		GameRegistry.registerBlock(netherroad, "netherroad");
		
		GameRegistry.registerBlock(woodPanel, MCItemBlockMulti.class, "woodPanel");
		GameRegistry.registerBlock(woodBeveled, MCItemBlockMulti.class, "woodBeveled");
		GameRegistry.registerBlock(woodPlanksMossy, MCItemBlockMulti.class, "woodPlanksMossy");
		GameRegistry.registerBlock(woodBoardsStairsOak, "woodBoardStairsOak");
		GameRegistry.registerBlock(woodBoardsStairsBirch, "woodBoardStairsBirch");
		GameRegistry.registerBlock(woodBoardsStairsSpruce, "woodBoardStairsSpruce");
		GameRegistry.registerBlock(woodBoardsStairsJungle, "woodBoardStairsJungle");
		GameRegistry.registerBlock(woodBoardsSingleSlab, ItemBlockWoodBoardSlab.class, "woodBoardsSlabSingle", null, woodBoardsSingleSlab, woodBoardsDoubleSlab);
		GameRegistry.registerBlock(woodBoardsDoubleSlab, ItemBlockWoodBoardSlab.class, "woodBoardsSlabDouble", null, woodBoardsSingleSlab, woodBoardsDoubleSlab);
		
		GameRegistry.registerBlock(goblet, MCItemBlockMulti.class, "Goblet");
		GameRegistry.registerBlock(plate, "Plate");
	}
	
	public static void loadVanillaOverwrites()
	{
		/*
		 * Block.blocksList[Block.doorWood.blockID] = null; doorWoodOverwrite =
		 * new BlockDoorOverwrite(64,
		 * Material.wood).setHardness(3.0F).setStepSound
		 * (Block.soundWoodFootstep)
		 * .setBlockName("doorWood").setTextureName("door_wood");
		 * GameRegistry.registerBlock(doorWoodOverwrite, "doorWood");
		 */
	}
}
