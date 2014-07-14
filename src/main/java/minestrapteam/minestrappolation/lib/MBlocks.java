package minestrapteam.minestrappolation.lib;

import clashsoft.cslib.minecraft.block.CSBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.mcore.block.MCBlock;
import minestrapteam.mcore.block.MCBlockPane;
import minestrapteam.mcore.block.MCBlockStairs;
import minestrapteam.mcore.item.block.MCItemBlockMulti;
import minestrapteam.mcore.util.MCAssetManager;
import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.*;
import minestrapteam.minestrappolation.material.MaterialOoze;
import minestrapteam.minestrappolation.tileentity.TileEntityPlate;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MBlocks
{
	public static Material	materialOoze	= new MaterialOoze(MapColor.foliageColor);
	
	public static Block		copperOre;
	public static Block		tinOre;
	public static Block		titaniumOre;
	public static Block		uraniumOre;
	public static Block		plutoniumOre;
	public static Block		meuroditeOre;
	public static Block		sunstoneOre;
	public static Block		toriteOre;
	public static Block		blaziumOre;
	public static Block		soulOre;
	public static Block		radiantQuartzOre;
	
	public static Block		copperBlock;
	public static Block		tinBlock;
	public static Block		bronzeBlock;
	public static Block		titaniumBlock;
	public static Block		uraniumBlock;
	public static Block		uraniumInsulated;
	public static Block		plutoniumBlock;
	public static Block		plutoniumInsulated;
	public static Block		meuroditeBlock;
	public static Block		sunstoneBlock;
	public static Block		toriteBlock;
	public static Block		blaziumBlock;
	public static Block		steelBlock;
	public static Block		soulBlock;
	
	public static Block		tinPlate;
	public static Block		bronzePlate;
	public static Block		steelPlate;
	public static Block		meuroditePlate;
	
	public static Block		invincium;
	public static Block		godstone;
	public static Block		nuke;
	public static Block		melterIdle;
	public static Block		melterBurning;
	
	public static Block		checkerTiles;
	public static Block		flintEndstoneStairs;
	public static Block		flintQuartzStairs;
	public static Block		obsidianEndstoneStairs;
	public static Block		obsidianQuartzStairs;
	public static Block		edgeStoneBrick;
	public static Block		snowBrick;
	
	public static Block		glowGlass;
	public static Block		refinedGlass;
	public static Block		refinedGlassPane;
	
	public static Block		gunpowderBlock;
	public static Block		sugarBlock;
	public static Block		meatBlock;
	public static Block		enderBlock;
	public static Block		slimeOoze;
	public static Block		magmaOoze;
	
	public static Block		goblet;
	public static Block		plate;
	public static Block		rope;
	public static Block		ropeCoil;
	public static Block		crate;
	public static Block		barrel;
	public static Block		cardboard;
	public static Block		cardboardBlock;
	
	public static Block		glassDoor;
	
	public static void init()
	{
		copperOre = new MCBlock(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("copper_ore"));
		tinOre = new MCBlock(Material.rock).setHardness(3F).setResistance(4F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("tin_ore"));
		titaniumOre = new MCBlock(Material.rock).setHardness(6F).setResistance(6000000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("titanium_ore"));
		uraniumOre = new BlockUraniumOre(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("uranium_ore"));
		plutoniumOre = new BlockPlutoniumOre(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("plutonium_ore"));
		meuroditeOre = new MCBlock(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("meurodite_ore"));
		sunstoneOre = new BlockSunstoneOre().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("sunstone_ore"));
		toriteOre = new MCBlock(Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("torite_ore"));
		blaziumOre = new BlockBlaziumOre().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("blazium_ore"));
		soulOre = new BlockSoulOre().setHardness(0.8F).setResistance(1F).setStepSound(Block.soundTypeSand).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("soul_gem_ore"));
		radiantQuartzOre = new MCBlock(Material.rock).setHardness(3F).setResistance(6F).setLightLevel(0.3F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("radiant_quartz_ore"));
		
		copperBlock = new BlockCopper(Material.iron).setHardness(5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockName("blockCopper");
		tinBlock = new MCBlock(Material.iron).setHardness(3F).setResistance(2F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("tin_block"));
		bronzeBlock = new MCBlock(Material.iron).setHardness(7F).setResistance(20F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("bronze_block"));
		titaniumBlock = new MCBlock(Material.iron).setHardness(10F).setResistance(12000000.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("titanium_block"));
		uraniumBlock = new BlockUraniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("uranium_block"));
		uraniumInsulated = new BlockUraniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeMetal);
		plutoniumBlock = new BlockPlutoniumRaw(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("plutonium_block"));
		plutoniumInsulated = new BlockPlutoniumInsulated(Material.iron).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeMetal);
		meuroditeBlock = new MCBlock(Material.iron).setHardness(5F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setResistance(10F).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("meurodite_block"));
		sunstoneBlock = new BlockSunstone(Material.glass).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("sunstone_block"));
		toriteBlock = new MCBlock(Material.iron).setHardness(6F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("torite_block"));
		blaziumBlock = new BlockBlazium().setHardness(8F).setResistance(12F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("blazium_block")).setLightLevel(0.7F);
		steelBlock = new BlockSteel().setHardness(6F).setResistance(10F).setStepSound(Block.soundTypeStone).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("steel_block_top"));
		soulBlock = new BlockSoulBlock().setHardness(65F).setResistance(30F).setStepSound(Block.soundTypeGravel).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getMineralTexture("soul_gem_block"));
		
		tinPlate = new BlockPlating().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("tin_block"));
		bronzePlate = new BlockPlating().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("bronze_block"));
		steelPlate = new BlockPlating().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("steel_block_top"));
		meuroditePlate = new BlockPlating().setHardness(0.7F).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("meurodite_block"));
		
		invincium = new BlockInvincium(Material.rock).setBlockUnbreakable().setResistance(12000000.0F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("invincium"));
		godstone = new BlockGodstone(Material.rock).setHardness(6F).setResistance(9F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone).setBlockTextureName(MCAssetManager.getMineralTexture("godstone"));
		nuke = new BlockNuke().setHardness(0.0F).setCreativeTab(Minestrappolation.tabTech).setStepSound(Block.soundTypeGrass);
		melterIdle = new BlockMelter(false).setHardness(6F).setResistance(8.0F).setCreativeTab(Minestrappolation.tabTech).setStepSound(Block.soundTypeStone);
		melterBurning = new BlockMelter(true).setHardness(6F).setResistance(8.0F).setStepSound(Block.soundTypeStone);
		
		checkerTiles = new BlockTiles().setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone);
		flintEndstoneStairs = new MCBlockStairs(checkerTiles, 0).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("stairs_flint_endstone");
		flintQuartzStairs = new MCBlockStairs(checkerTiles, 1).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("stairs_flint_quartz");
		obsidianEndstoneStairs = new MCBlockStairs(checkerTiles, 2).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("stairs_obsidian_endstone");
		obsidianQuartzStairs = new MCBlockStairs(checkerTiles, 3).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockName("stairs_obsidan_quartz");

		edgeStoneBrick = new BlockEdgeStoneBrick().setHardness(1.5F).setResistance(10F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeStone);
		snowBrick = new BlockSnowBrick().setHardness(0.3F).setCreativeTab(Minestrappolation.tabBuildingBlocks).setStepSound(Block.soundTypeSnow).setBlockTextureName(MCAssetManager.getTexture("snow_tiles"));
		
		glowGlass = new BlockGlowGlass(Material.glass, true).setHardness(0.8F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setStepSound(Block.soundTypeGlass).setBlockTextureName(MCAssetManager.getTexture("glow_glass"));
		refinedGlass = new BlockGlassRefined(Material.glass, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks).setBlockTextureName(MCAssetManager.getTexture("glass_refined"));
		refinedGlassPane = new MCBlockPane(Material.glass, MCAssetManager.getTexture("glass_refined"), MCAssetManager.getTexture("glass_refined_pane"), false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(Minestrappolation.tabBuildingBlocks);
		
		gunpowderBlock = new BlockGunpowderBlock(Material.ground).setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockTextureName(MCAssetManager.getMineralTexture("gunpowder_block"));
		sugarBlock = new BlockSugarBlock().setHardness(0.6F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setStepSound(Block.soundTypeGravel).setBlockTextureName(MCAssetManager.getFoodTexture("sugar_block"));
		meatBlock = new BlockMeatBlock().setHardness(0.8F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setStepSound(Block.soundTypeCloth).setBlockTextureName(MCAssetManager.getFoodTexture("meat_block"));
		enderBlock = new BlockEnderblock().setHardness(3.0F).setResistance(4.0F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setStepSound(Block.soundTypeGlass).setBlockTextureName(MCAssetManager.getMineralTexture("ender_block"));
		
		slimeOoze = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setCreativeTab(Minestrappolation.tabMisc).setStepSound(Block.soundTypeCloth).setBlockTextureName(MCAssetManager.getTexture("ooze_slime"));
		magmaOoze = new BlockOoze(materialOoze).setHardness(1F).setResistance(2000F).setCreativeTab(Minestrappolation.tabMisc).setStepSound(Block.soundTypeCloth).setBlockTextureName(MCAssetManager.getTexture("ooze_magma"));
		
		goblet = new BlockGoblet(Material.rock).setHardness(0.5F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setBlockTextureName(MCAssetManager.getTexture("goblet"));
		plate = new BlockPlate(Material.rock).setHardness(0.7F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setBlockTextureName(MCAssetManager.getTexture("plate"));
		rope = new BlockRope().setHardness(0.9F).setStepSound(Block.soundTypeCloth);
		ropeCoil = new BlockRopeCoil().setHardness(0.9F).setCreativeTab(Minestrappolation.tabDecorationBlocks).setStepSound(Block.soundTypeCloth);
		crate = new BlockCrate().setHardness(2.5F).setCreativeTab(Minestrappolation.tabMisc).setStepSound(Block.soundTypeWood);
		barrel = new BlockBarrel().setHardness(3F).setResistance(6.0F).setCreativeTab(Minestrappolation.tabMisc).setStepSound(Block.soundTypeWood);
		cardboard = new MCBlockPane(Material.cloth, MCAssetManager.getTexture("cardboard"), MCAssetManager.getTexture("cardboard_pane_edge"), true).setHardness(0.3F);
		cardboardBlock = new BlockCardboard(Material.cloth).setHardness(0.4F).setCreativeTab(Minestrappolation.tabDecorationBlocks);
		
		glassDoor = new BlockGlassDoor(Material.glass).setHardness(1F);
	}
	
	public static void load()
	{
		GameRegistry.registerTileEntity(TileEntityPlate.class, "Plate");
		
		CSBlocks.addBlock(copperOre, "copper_ore");
		CSBlocks.addBlock(tinOre, "tin_ore");
		CSBlocks.addBlock(titaniumOre, "titanium_ore");
		CSBlocks.addBlock(uraniumOre, "uranium_ore");
		CSBlocks.addBlock(plutoniumOre, "plutonium_ore");
		CSBlocks.addBlock(meuroditeOre, "meurodite_ore");
		CSBlocks.addBlock(sunstoneOre, "sunstone_ore");
		CSBlocks.addBlock(toriteOre, "torite_ore");
		CSBlocks.addBlock(blaziumOre, "blazium_ore");
		CSBlocks.addBlock(soulOre, "soul_ore");
		CSBlocks.addBlock(radiantQuartzOre, "radiant_quartz_ore");
		
		CSBlocks.addBlock(copperBlock, "copper_block");
		CSBlocks.addBlock(tinBlock, "tin_block");
		CSBlocks.addBlock(bronzeBlock, "bronze_block");
		CSBlocks.addBlock(titaniumBlock, "titanium_block");
		CSBlocks.addBlock(uraniumBlock, "uranium_block");
		CSBlocks.addBlock(uraniumInsulated, "insulated_uranium");
		CSBlocks.addBlock(plutoniumBlock, "plutonium_block");
		CSBlocks.addBlock(plutoniumInsulated, "insulated_plutonium");
		CSBlocks.addBlock(meuroditeBlock, "meurodite_block");
		CSBlocks.addBlock(sunstoneBlock, "sunstone_block");
		CSBlocks.addBlock(toriteBlock, "torite_block");
		CSBlocks.addBlock(blaziumBlock, "blazium_block");
		CSBlocks.addBlock(steelBlock, "steel_block");
		CSBlocks.addBlock(soulBlock, "soul_block");
		
		CSBlocks.addBlock(tinPlate, "tin_plate_block");
		CSBlocks.addBlock(bronzePlate, "bronze_plate_block");
		CSBlocks.addBlock(steelPlate, "steel_plate_block");
		CSBlocks.addBlock(meuroditePlate, "meurodite_plate_block");
		
		CSBlocks.addBlock(invincium, "invincium");
		CSBlocks.addBlock(godstone, "godstone");
		CSBlocks.addBlock(nuke, "nuke");
		CSBlocks.addBlock(melterIdle, "melter");
		CSBlocks.addBlock(melterBurning, "melter_burning");
		
		CSBlocks.addBlock(checkerTiles, MCItemBlockMulti.class, "checker_tiles");
		CSBlocks.addBlock(flintQuartzStairs);
		CSBlocks.addBlock(flintEndstoneStairs);
		CSBlocks.addBlock(obsidianEndstoneStairs);
		CSBlocks.addBlock(obsidianQuartzStairs);
		
		CSBlocks.addBlock(edgeStoneBrick, MCItemBlockMulti.class, "edge_stone_brick");
		CSBlocks.addBlock(snowBrick, "snow_brick");
		
		CSBlocks.addBlock(glowGlass, "glow_glass");
		CSBlocks.addBlock(refinedGlass, "refined_glass");
		CSBlocks.addBlock(refinedGlassPane, "refined_glass_pane");
		
		CSBlocks.addBlock(gunpowderBlock, "gunpowder_block");
		CSBlocks.addBlock(sugarBlock, "sugar_block");
		CSBlocks.addBlock(meatBlock, "meat_block");
		CSBlocks.addBlock(enderBlock, "ender_block");
		
		CSBlocks.addBlock(slimeOoze, "slime_ooze");
		CSBlocks.addBlock(magmaOoze, "magma_ooze");
		
		CSBlocks.addBlock(goblet, "goblet");
		CSBlocks.addBlock(plate, "plate");
		CSBlocks.addBlock(rope, "rope_block");
		CSBlocks.addBlock(ropeCoil, "rope_coil");
		CSBlocks.addBlock(crate, "crate");
		CSBlocks.addBlock(barrel, "barrel");
		CSBlocks.addBlock(cardboard, "cardboard_pane");
		CSBlocks.addBlock(cardboardBlock, "cardboard_block");
		
		CSBlocks.addBlock(glassDoor, "glass_door_block");
	}
}
