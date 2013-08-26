package sobiohazardous.minestrappolation.extraores.lib;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class EORecipeManager 

{

	public EORecipeManager()
	{
		loadRecipes();
	}
	
	public static void loadRecipes()
	{
		
		GameRegistry.addSmelting(ExtraOres.meuroditeOre.blockID, new ItemStack(ExtraOres.meuroditeIngot, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditeSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), ExtraOres.meuroditeIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditeShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), ExtraOres.meuroditeIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditeAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), ExtraOres.meuroditeIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditePickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), ExtraOres.meuroditeIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditeHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), ExtraOres.meuroditeIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditeHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), ExtraOres.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditeChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditePants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditeBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.meuroditeBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.meuroditeIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.meuroditeIngot, 9), new Object[]
				{
			ExtraOres.meuroditeBlock,
				});
		
		
		
		GameRegistry.addSmelting(ExtraOres.TitaniumOre.blockID, new ItemStack(ExtraOres.TitaniumIngot, 1), 2.0F);
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), ExtraOres.TitaniumIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), ExtraOres.TitaniumIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), ExtraOres.TitaniumIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumPickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), ExtraOres.TitaniumIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), ExtraOres.TitaniumIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), ExtraOres.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TitaniumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'),ExtraOres.TitaniumIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.TitaniumIngot, 9), new Object[]
				{
			ExtraOres.TitaniumBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.Sunstone, 1), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), ExtraOres.SunstoneDust,
				});
		
		GameRegistry.addSmelting(ExtraOres.SunstoneOre.blockID, new ItemStack(ExtraOres.SunstoneDust, 4), 1.0F);
		
		
		
		GameRegistry.addSmelting(ExtraOres.ToriteOre.blockID, new ItemStack(ExtraOres.ToriteIngot, 1), 1.1F);
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToriteBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToriteSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), ExtraOres.ToriteIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToriteShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), ExtraOres.ToriteIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToriteAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), ExtraOres.ToriteIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToritePickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), ExtraOres.ToriteIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToriteHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), ExtraOres.ToriteIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToriteHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), ExtraOres.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToriteChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToritePants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.ToriteBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.ToriteIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.ToriteIngot, 9), new Object[]
				{
			ExtraOres.ToriteBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.GraniteBrick, 4), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), ExtraOres.Granite,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.QuartziteTile, 4), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), ExtraOres.Quartzite,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.BlaziumIngot,
				});
		
		GameRegistry.addSmelting(Item.blazePowder.itemID, new ItemStack(ExtraOres.BlazeShard, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumIngot, 1), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), ExtraOres.BlazeShard,
				});
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), ExtraOres.BlaziumIngot, Character.valueOf('S'), Item.blazeRod
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), ExtraOres.BlaziumIngot, Character.valueOf('S'), Item.blazeRod
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), ExtraOres.BlaziumIngot, Character.valueOf('S'), Item.blazeRod
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumPickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), ExtraOres.BlaziumIngot, Character.valueOf('S'), Item.blazeRod
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), ExtraOres.BlaziumIngot, Character.valueOf('S'), Item.blazeRod
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), ExtraOres.BlaziumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.BlaziumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.BlaziumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BlaziumBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.BlaziumIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.BlaziumIngot, 9), new Object[]
				{
			ExtraOres.BlaziumBlock,
				});
		
		
		
		GameRegistry.addSmelting(ExtraOres.CopperOre.blockID, new ItemStack(ExtraOres.CopperIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.CopperBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.CopperIngot
				});
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.CopperSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), ExtraOres.CopperIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.CopperShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), ExtraOres.CopperIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.CopperAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), ExtraOres.CopperIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.CopperPickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), ExtraOres.CopperIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.CopperHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), ExtraOres.CopperIngot, Character.valueOf('S'), Item.stick
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.CopperIngot, 9), new Object[]
				{
			ExtraOres.CopperBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TinBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.TinIngot,
				});
		GameRegistry.addSmelting(ExtraOres.TinOre.blockID, new ItemStack(ExtraOres.TinIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TinHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), ExtraOres.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TinChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),ExtraOres.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TinPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TinBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.TinIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.TinIngot, 9), new Object[]
				{
			ExtraOres.TinBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.TinPlateItem, 4), new Object[]
				{
			"ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzePlateItem, 1), new Object[]
				{
			"ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelPlateItem, 1), new Object[]
				{
			"ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.SteelIngot,
				});
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.CoalIronIngot, 1), new Object[]
				{
			Item.ingotIron, Item.coal, Item.coal, Item.coal, Item.coal, Item.coal, Item.coal, Item.coal, Item.coal
				});
		
		GameRegistry.addSmelting(ExtraOres.CoalIronIngot.itemID, new ItemStack(ExtraOres.SteelIngot, 1), 0.7F);
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelPickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), ExtraOres.SteelIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), ExtraOres.SteelIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), ExtraOres.SteelIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), ExtraOres.SteelIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), ExtraOres.SteelIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), ExtraOres.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),ExtraOres.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.SteelBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.SteelIngot
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.SteelIngot, 9), new Object[]
				{
			ExtraOres.SteelBlock,
				});
		
		
		
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SmoothQuartzite, 1), new Object[]
        		{
        	"ZZ", "ZZ", Character.valueOf('Z'), ExtraOres.PinkQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.PillarQuartzite, 2), new Object[]
        		{
        	"Z", "Z", Character.valueOf('Z'), ExtraOres.SmoothQuartzite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.ChiseledQuartzite, 4), new Object[]
        		{
        	"ZZ", "ZZ", Character.valueOf('Z'), ExtraOres.SmoothQuartzite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SmoothQuartzTile, 8), new Object[]
        		{
        	"ZZZ", "ZYZ", "ZZZ", Character.valueOf('Z'), ExtraOres.SmoothQuartzite, Character.valueOf('Y'), Block.stone
        		});
        
        GameRegistry.addSmelting(ExtraOres.SmoothQuartzite.blockID, new ItemStack(ExtraOres.Quartzite, 1), 0.15F);
        
        GameRegistry.addSmelting(ExtraOres.ChiseledQuartzite.blockID, new ItemStack(ExtraOres.Quartzite, 1), 0.15F);
        
        GameRegistry.addSmelting(ExtraOres.PillarQuartzite.blockID, new ItemStack(ExtraOres.Quartzite, 1), 0.15F);
        
        GameRegistry.addSmelting(ExtraOres.QuartziteTile.blockID, new ItemStack(ExtraOres.Quartzite, 1), 0.15F);
        
        
        
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SandstonePickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), Block.sandStone, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SandstoneShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), Block.sandStone, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SandstoneAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), Block.sandStone, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SandstoneHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), Block.sandStone, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.SandstoneSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), Block.sandStone, Character.valueOf('S'), Item.stick
        		});
        
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.TinPlatedCobble, 8), new Object[]
				{
			Block.cobblestone, ExtraOres.TinPlateItem,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.TinPlatedMossy, 8), new Object[]
				{
			Block.cobblestoneMossy, ExtraOres.TinPlateItem,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.TinPlatedStoneBrick, 8), new Object[]
				{
			new ItemStack(Block.stoneBrick, 1, 0), ExtraOres.TinPlateItem,new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.TinPlatedChiseled, 8), new Object[]
				{
			new ItemStack(Block.stoneBrick, 1, 3), ExtraOres.TinPlateItem,new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.TinPlatedGranite, 8), new Object[]
				{
			ExtraOres.GraniteBrick, ExtraOres.TinPlateItem,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,
				});
        
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.BronzeIngot, 1), new Object[]
        		{
        	Item.ingotIron, ExtraOres.CopperIngot, ExtraOres.CopperIngot, ExtraOres.TinIngot, ExtraOres.TinIngot
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzePickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), ExtraOres.BronzeIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzeShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), ExtraOres.BronzeIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzeAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), ExtraOres.BronzeIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzeHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), ExtraOres.BronzeIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzeSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), ExtraOres.BronzeIngot, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzeHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), ExtraOres.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzeChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),ExtraOres.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzePants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzeBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), ExtraOres.BronzeIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.BronzeIngot, 9), new Object[]
				{
			ExtraOres.BronzeBlock,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BronzeBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.BronzeIngot
				});
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.BronzePlatedCobble, 8), new Object[]
				{
			Block.cobblestone, ExtraOres.BronzePlateItem,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.BronzePlatedMossy, 8), new Object[]
				{
			Block.cobblestoneMossy, ExtraOres.BronzePlateItem,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,Block.cobblestoneMossy,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.BronzePlatedStoneBrick, 8), new Object[]
				{
			new ItemStack(Block.stoneBrick, 1, 0), ExtraOres.BronzePlateItem,new ItemStack(Block.stoneBrick, 1, 0), new ItemStack(Block.stoneBrick, 1, 0), new ItemStack(Block.stoneBrick, 1, 0), new ItemStack(Block.stoneBrick, 1, 0), new ItemStack(Block.stoneBrick, 1, 0), new ItemStack(Block.stoneBrick, 1, 0), new ItemStack(Block.stoneBrick, 1, 0), 
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.BronzePlatedChiseled, 8), new Object[]
				{
			new ItemStack(Block.stoneBrick, 1, 3), ExtraOres.BronzePlateItem,new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.BronzePlatedGranite, 8), new Object[]
				{
			ExtraOres.GraniteBrick, ExtraOres.BronzePlateItem,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,
				});
        
        
        
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BedrockPickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), Block.bedrock, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BedrockShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), Block.bedrock, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BedrockAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), Block.bedrock, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.BedrockHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), Block.bedrock, Character.valueOf('S'), Item.stick
        		});
        
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.SteelPlatedCobble, 8), new Object[]
				{
			Block.cobblestone, ExtraOres.SteelPlateItem, Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,Block.cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.SteelPlatedMossy, 8), new Object[]
				{
			Block.cobblestoneMossy, ExtraOres.SteelPlateItem,			Block.cobblestoneMossy,			Block.cobblestoneMossy,			Block.cobblestoneMossy,			Block.cobblestoneMossy,			Block.cobblestoneMossy,			Block.cobblestoneMossy,			Block.cobblestoneMossy,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.SteelPlatedStoneBrick, 8), new Object[]
				{
			new ItemStack(Block.stoneBrick, 1, 0), ExtraOres.SteelPlateItem, new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),new ItemStack(Block.stoneBrick, 1, 0),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.SteelPlatedChiseled, 8), new Object[]
				{
			new ItemStack(Block.stoneBrick, 1, 3), ExtraOres.SteelPlateItem, new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),new ItemStack(Block.stoneBrick, 1, 3),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.SteelPlatedGranite, 8), new Object[]
				{
			ExtraOres.GraniteBrick, ExtraOres.SteelPlateItem,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,ExtraOres.GraniteBrick,
				});   
        
        GameRegistry.addRecipe(new ItemStack(ExtraOres.GranitePickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), ExtraOres.Granite, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.GraniteShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), ExtraOres.Granite, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.GraniteAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), ExtraOres.Granite, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.GraniteHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), ExtraOres.Granite, Character.valueOf('S'), Item.stick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.GraniteSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), ExtraOres.Granite, Character.valueOf('S'), Item.stick
        		});
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.Uranium, 9), new Object[]
				{
			ExtraOres.RawUraniumBlock,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.RawUraniumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.Uranium
				});
		GameRegistry.addSmelting(ExtraOres.UraniumOre.blockID, new ItemStack(ExtraOres.Uranium, 2), 0.15F);
		GameRegistry.addSmelting(ExtraOres.PlutoniumOre.blockID, new ItemStack(ExtraOres.Plutonium, 2), 0.15F);
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ExtraOres.Plutonium, 9), new Object[]
				{
			ExtraOres.RawPlutoniumBlock,
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.RawPlutoniumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), ExtraOres.Plutonium
				});
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.grenade, 1), new Object[]
				{
			"SUS", "SGS", "SPS", Character.valueOf('P'), ExtraOres.Plutonium, Character.valueOf('S'), ExtraOres.SteelPlateItem, Character.valueOf('U'), ExtraOres.Uranium, Character.valueOf('G'), Item.gunpowder
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.nuke, 1), new Object[]
				{
			"UPU", "PUP", "UPU", Character.valueOf('P'), ExtraOres.RawPlutoniumBlock, Character.valueOf('U'), ExtraOres.RawUraniumBlock
				});
		
	
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPMeuroditePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.meuroditePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPMeuroditeAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.meuroditeAxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPMeuroditeShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.meuroditeShovel
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPMeuroditeHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.meuroditeHoe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPMeuroditeSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.meuroditeSword
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPMeuroditeHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.meuroditeHelmet
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPMeuroditeChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.meuroditeChest
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPMeuroditePants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.meuroditePants
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPMeuroditeBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.meuroditeBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTitaniumPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TitaniumPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTitaniumAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TitaniumAxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTitaniumShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TitaniumShovel
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTitaniumHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TitaniumHoe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTitaniumSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TitaniumSword
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTitaniumHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TitaniumHelmet
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTitaniumChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TitaniumChest
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTitaniumPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TitaniumPants
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTitaniumBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TitaniumBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPToritePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.ToritePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPToriteAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.ToriteAxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPToriteShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.ToriteShovel
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPToriteHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.ToriteHoe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPToriteSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.ToriteSword
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPToriteHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.ToriteHelmet
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPToriteChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.ToriteChest
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPToritePants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.ToritePants
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPToriteBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.ToriteBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBlaziumPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BlaziumPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBlaziumAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BlaziumAxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBlaziumShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BlaziumShovel
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBlaziumHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BlaziumHoe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBlaziumSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BlaziumSword
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBlaziumHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BlaziumHelmet
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBlaziumChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BlaziumChest
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBlaziumPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BlaziumPants
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBlaziumBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BlaziumBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPCopperPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.CopperPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPCopperAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.CopperAxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPCopperShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.CopperShovel
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPCopperHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.CopperHoe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPCopperSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.CopperSword
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTinHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TinHelmet
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTinChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TinChest
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTinPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TinPants
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPTinBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.TinBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSteelPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SteelPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSteelAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SteelAxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSteelShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SteelShovel
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSteelHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SteelHoe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSteelSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SteelSword
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSteelHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SteelHelmet
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSteelChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SteelChest
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSteelPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SteelPants
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSteelBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SteelBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSandstonePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SandstonePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSandstoneAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SandstoneAxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSandstoneShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SandstoneShovel
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSandstoneHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SandstoneHoe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPSandstoneSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.SandstoneSword
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGranitePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.GranitePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGraniteAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.GraniteAxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGraniteShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.GraniteShovel
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGraniteHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.GraniteHoe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGraniteSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.GraniteSword
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBedrockPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BedrockPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBedrockAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BedrockAxe
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBedrockShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BedrockShovel
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPBedrockHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), ExtraOres.BedrockHoe
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPWoodPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.pickaxeWood
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPWoodAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.axeWood
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPWoodShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.shovelWood
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPWoodHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.hoeWood
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPWoodSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.swordWood
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPClothHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.helmetLeather
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPClothChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.plateLeather
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPClothPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.legsLeather
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPClothBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.bootsLeather
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPStonePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.pickaxeStone
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPStoneAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.axeStone
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPStoneShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.shovelStone
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPStoneHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.hoeStone
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPStoneSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.swordStone
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPChainHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.helmetChain
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPChainChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.plateChain
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPChainPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.legsChain
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPChainBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.bootsChain
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPIronPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.pickaxeIron
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPIronAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.axeIron
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPIronShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.shovelIron
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPIronHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.hoeIron
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPIronSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.swordIron
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPIronHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.helmetIron
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPIronChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.plateIron
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPIronPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.legsIron
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPIronBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.bootsIron
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGoldPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.pickaxeGold
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGoldAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.axeGold
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGoldShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.shovelGold
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGoldHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.hoeGold
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGoldSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.swordGold
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGoldHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.helmetGold
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGoldChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.plateGold
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGoldPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.legsGold
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPGoldBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.bootsGold
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPDiamondPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.pickaxeDiamond
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPDiamondAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.axeDiamond
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPDiamondShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.shovelDiamond
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPDiamondHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.hoeDiamond
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPDiamondSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.swordDiamond
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPDiamondHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.helmetDiamond
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPDiamondChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.plateDiamond
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPDiamondPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.legsDiamond
				});
		GameRegistry.addRecipe(new ItemStack(ExtraOres.BPDiamondBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), ExtraOres.BronzePlateItem, Character.valueOf('I'), Item.bootsDiamond
				});
		
		
		
		
		
		GameRegistry.addRecipe(new ItemStack(ExtraOres.SmoothRadiantQuartz, 1), new Object[]
        		{
        	"ZZ", "ZZ", Character.valueOf('Z'), ExtraOres.RadiantQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.PillarRadiantQuartz, 2), new Object[]
        		{
        	"Z", "Z", Character.valueOf('Z'), ExtraOres.SmoothRadiantQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.ChiseledRadiantQuartz, 4), new Object[]
        		{
        	"ZZ", "ZZ", Character.valueOf('Z'), ExtraOres.SmoothRadiantQuartz
        		});
        
        GameRegistry.addSmelting(ExtraOres.SmoothRadiantQuartz.blockID, new ItemStack(ExtraOres.RadiantQuartz, 1), 0.15F);
        
        
        
        GameRegistry.addRecipe(new ItemStack(ExtraOres.Godstone, 1), new Object[]
        		{
        	"SSS", "SES", "SSS", Character.valueOf('S'), ExtraOres.SunstoneDust, Character.valueOf('E'), Block.whiteStone
        		});
        
        GameRegistry.addRecipe(new ItemStack(ExtraOres.RadiantQuartzStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.SmoothRadiantQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.RadiantQuartzSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.SmoothRadiantQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.PinkQuartzStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.SmoothQuartzite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.PinkQuartzSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.SmoothQuartzite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.graniteBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.GraniteBrick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.graniteBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.GraniteBrick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.tinPlatedCobbleStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.TinPlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.tinPlatedCobbleSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.TinPlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.steelPlatedCobbleStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.SteelPlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.steelPlatedCobbleSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.SteelPlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.bronzePlatedCobbleStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.BronzePlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.bronzePlatedCobbleSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.BronzePlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.tinPlatedStoneBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.TinPlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.tinPlatedStoneBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.TinPlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.steelPlatedStoneBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.SteelPlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.steelPlatedStoneBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.SteelPlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.bronzePlatedStoneBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.BronzePlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.bronzePlatedStoneBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.BronzePlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.tinPlatedGraniteBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.TinPlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.tinPlatedGraniteBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.TinPlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.steelPlatedGraniteBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.SteelPlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.steelPlatedGraniteBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.SteelPlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.bronzePlatedGraniteBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), ExtraOres.BronzePlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.bronzePlatedGraniteBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), ExtraOres.BronzePlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.plutoniumInsulated, 1), new Object[]
        		{
        	"SSS", "GPG", "SSS", Character.valueOf('S'), ExtraOres.SteelIngot, Character.valueOf('G'), Block.thinGlass, Character.valueOf('P'), ExtraOres.RawPlutoniumBlock
        		});
        GameRegistry.addRecipe(new ItemStack(ExtraOres.uraniumInsulated, 1), new Object[]
        		{
        	"SSS", "GPG", "SSS", Character.valueOf('S'), ExtraOres.SteelIngot, Character.valueOf('G'), Block.thinGlass, Character.valueOf('P'), ExtraOres.RawUraniumBlock
        		});
	}
	
}
