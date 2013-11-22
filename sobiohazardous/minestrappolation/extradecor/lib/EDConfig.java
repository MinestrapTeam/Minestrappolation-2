package sobiohazardous.minestrappolation.extradecor.lib;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;


public class EDConfig {
	public static int
	refinedRoadID,
	bedrockBrickID,
	stonePillarId,
	stoneTileId,
	stoneLampId,
	edgeStoneBrickId,
	edgeStoneCornerID,
	obsidianTileId,
	snowBrickId,
	endstoneSmoothId,
	glassRefinedId,
	glassRefinedPaneId,
	woodPanelId,
	woodBeveledId,
	gunpowderBlockId,
	ropeId,
	itemRopeId,
	ropeCoilId,
	oozeSlimeId,
	netherBrickPatternId,
	sandstoneBrickId,
	sandstonePillarId,
	woodBoardsId,
	sugarBlockId,
	meatBlockId,
	magmaOozeId,
	enderBlockId,
	crateId,
	barrelId,
	cardboardId,
	cardboardItemId,
	cardboardBlockId,
	cardboardWetId,
	sandstoneBrickItemId,
	stoneBrickItemId,
	woodBoardsStairsOakId,
	woodBoardsStairsBirchId,
	woodBoardsStairsSpruceId,
	woodBoardsStairsJungleId,
	woodBoardsSingleSlabId,
	woodBoardsDoubleSlabId,
	checkerTileStairsId,
	stainedBrickId,
	infertiledirtId,
	cobbledRoadId,
	sandyRoadId,
	sandstoneRoadId,
	gravelRoadId,
	woodPlanksMossyId;
	
	public static int daysUntilMossy;
	
	public static void initilize(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		//blocks 700
		//items 2500
		stonePillarId = config.getBlock("Stone Pillar", 701).getInt();
		stoneTileId = config.getBlock("Stone Tile", 702).getInt();
		stoneLampId = config.getBlock("Stone Lamp", 703).getInt();
		edgeStoneBrickId = config.getBlock("Edge Stone Brick", 704).getInt();
		obsidianTileId = config.getBlock("Obsidian Tile", 708).getInt();
		snowBrickId = config.getBlock("Snow Brick", 709).getInt();
		endstoneSmoothId = config.getBlock("Smooth Endstone", 710).getInt();
		glassRefinedId = config.getBlock("Refined Glass", 713).getInt();
		glassRefinedPaneId = config.getBlock("Refined Glass Pane", 714).getInt();
		woodPanelId = config.getBlock("Wood Panel", 715).getInt();
		woodBeveledId = config.getBlock("Beveled Wood", 716).getInt();
		gunpowderBlockId = config.getBlock("Gunpowder Block", 718).getInt();
		ropeId = config.getBlock("Rope", 719).getInt();
		itemRopeId = config.getItem("Rope Item", 25000).getInt();
		ropeCoilId = config.getBlock("Rope Coil", 721).getInt();
		oozeSlimeId = config.getBlock("Slime Oooze", 722).getInt();
		netherBrickPatternId = config.getBlock("Patterned Nether Brick", 723).getInt();
		sandstoneBrickId = config.getBlock("Sandstone Brick", 724).getInt();
		sandstonePillarId = config.getBlock("Sandstone Pillar", 725).getInt();
		woodBoardsId = config.getBlock("Wood Boards", 726).getInt();
		sugarBlockId = config.getBlock("Sugar Block", 729).getInt();
		meatBlockId = config.getBlock("Meat Block", 730).getInt();
		magmaOozeId = config.getBlock("Magma Ooze", 731).getInt();
		enderBlockId = config.getBlock("Ender Block", 732).getInt();
		crateId = config.getBlock("Crate", 733).getInt();
		barrelId = config.getBlock("Barrel", 734).getInt();
		cardboardId = config.getBlock("Cardboard", 735).getInt();
		cardboardItemId = config.getItem("Cardboard Placer", 25001).getInt();
		cardboardBlockId = config.getBlock("Cardboard Block", 736).getInt();
		cardboardWetId = config.getBlock("Wet Cardboard", 737).getInt();
		sandstoneBrickItemId = config.getItem("Sandstone Brick Item", 25002).getInt();
		stoneBrickItemId = config.getItem("Stone Brick Item", 25003).getInt();
		woodBoardsStairsOakId = config.getBlock("Oak Board Stairs", 739).getInt();
		woodBoardsStairsBirchId = config.getBlock("Birch Boards Stairs", 740).getInt();
		woodBoardsStairsSpruceId = config.getBlock("Spruce Boards Stairs", 741).getInt();
		woodBoardsStairsJungleId = config.getBlock("Jungle Boards Stairs", 742).getInt();
		woodBoardsSingleSlabId = config.getBlock("Wood Boards Single Slab", 743).getInt();
		woodBoardsDoubleSlabId = config.getBlock("Wood Boards Double Slab", 744).getInt();
		checkerTileStairsId = config.getBlock("Checker Tile Stairs", 745).getInt();
		stainedBrickId = config.getBlock("Stained Bricks", 746).getInt();
		cobbledRoadId = config.getBlock("Cobbled Road", 747).getInt();
		infertiledirtId = config.getBlock("Infertile Dirt", 748).getInt();
		bedrockBrickID = config.getBlock("Bedrock Brick", 749).getInt();
		refinedRoadID = config.getBlock("Refined Road", 750).getInt();
		sandyRoadId = config.getBlock("Sandy Road", 751).getInt();
		sandstoneRoadId = config.getBlock("Sandstone Road", 752).getInt();
		gravelRoadId = config.getBlock("Gravel Road", 753).getInt();
		edgeStoneCornerID = config.getBlock("Edge stone corner", 845).getInt();
		woodPlanksMossyId = config.getBlock("Mossy Wood Planks", 754).getInt();
		daysUntilMossy = config.get("Misc", "Days Until Planks Get Mossy", 3).getInt();
		config.save();			
	}

}
