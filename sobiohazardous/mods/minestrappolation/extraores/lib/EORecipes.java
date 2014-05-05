package sobiohazardous.mods.minestrappolation.extraores.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class EORecipes 
{
	public EORecipes()
	{
		loadRecipes();
	}
	
	public static void loadRecipes()
	{
		GameRegistry.addSmelting(EOBlocks.BlaziumOre, new ItemStack(Items.blaze_powder, 3), 1.0F);
		
		GameRegistry.addSmelting(EOBlocks.meuroditeOre, new ItemStack(EOItems.meuroditeIngot, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditePickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItems.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditePants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.meuroditeBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItems.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlocks.meuroditeBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.meuroditeIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.meuroditeIngot, 9), new Object[]
				{
			EOBlocks.meuroditeBlock,
				});
		
		
		
		GameRegistry.addSmelting(EOBlocks.TitaniumOre, new ItemStack(EOItems.TitaniumIngot, 1), 2.0F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumPickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItems.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TitaniumBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItems.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlocks.TitaniumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItems.TitaniumIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.TitaniumIngot, 9), new Object[]
				{
			EOBlocks.TitaniumBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.Sunstone, 1), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), EOItems.SunstoneDust,
				});
		
		GameRegistry.addSmelting(EOBlocks.SunstoneOre, new ItemStack(EOItems.SunstoneDust, 4), 1.0F);
		
		
		
		GameRegistry.addSmelting(EOBlocks.ToriteOre, new ItemStack(EOItems.ToriteIngot, 1), 1.1F);
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.ToriteBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItems.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.ToritePickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'),EOItems.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItems.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItems.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.ToritePants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.ToriteBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItems.ToriteIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.ToriteIngot, 9), new Object[]
				{
			EOBlocks.ToriteBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.GraniteBrick, 4), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), EOBlocks.Granite,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlocks.QuartziteTile, 4), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), EOBlocks.Quartzite,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.BlaziumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.BlaziumIngot,
				});
		
		GameRegistry.addSmelting(Items.blaze_powder, new ItemStack(EOItems.BlazeShard, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumIngot, 1), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), EOItems.BlazeShard,
				});
		
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumPickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItems.BlaziumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.BlaziumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'),EOItems.BlaziumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BlaziumBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItems.BlaziumIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.BlaziumIngot, 9), new Object[]
				{
			EOBlocks.BlaziumBlock,
				});
		
		
		
		GameRegistry.addSmelting(EOBlocks.CopperOre, new ItemStack(EOItems.CopperIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.CopperBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.CopperIngot
				});
		
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperPickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.CopperHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.CopperIngot, 9), new Object[]
				{
			EOBlocks.CopperBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.TinBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.TinIngot,
				});
		GameRegistry.addSmelting(EOBlocks.TinOre, new ItemStack(EOItems.TinIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.TinHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItems.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TinChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItems.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TinPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.TinBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItems.TinIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.TinIngot, 9), new Object[]
				{
			EOBlocks.TinBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItems.plateTinItem, 4), new Object[]
				{
			"ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.plateBronzeItem, 1), new Object[]
				{
			"ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.plateSteelItem, 1), new Object[]
				{
			"ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.SteelIngot,
				});
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.CoalIronIngot, 1), new Object[]
				{
			Items.iron_ingot, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal
				});
		
		GameRegistry.addSmelting(EOItems.CoalIronIngot, new ItemStack(EOItems.SteelIngot, 1), 0.7F);
		
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelPickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.SteelShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.SteelAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.SteelHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.SteelSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.SteelHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItems.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItems.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'),EOItems.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.SteelBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItems.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlocks.SteelBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.SteelIngot
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.SteelIngot, 9), new Object[]
				{
			EOBlocks.SteelBlock,
				});
		
		
		
        GameRegistry.addRecipe(new ItemStack(EOBlocks.SmoothQuartzite, 1), new Object[]
        		{
        	"ZZ", "ZZ", Character.valueOf('Z'), EOItems.PinkQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlocks.PillarQuartzite, 2), new Object[]
        		{
        	"Z", "Z", Character.valueOf('Z'), EOBlocks.SmoothQuartzite
        		});
        /*
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.ChiseledQuartzite, 1), new Object[]
        		{
        	"Z", "Z", Character.valueOf('Z'), EOBlockManager.PinkQuartzSingleSlab
        		});
        		*/
        GameRegistry.addRecipe(new ItemStack(EOBlocks.SmoothQuartzTile, 8), new Object[]
        		{
        	"ZZZ", "ZYZ", "ZZZ", Character.valueOf('Z'), EOBlocks.SmoothQuartzite, Character.valueOf('Y'), Blocks.stone
        		});
        
        GameRegistry.addSmelting(EOBlocks.SmoothQuartzite, new ItemStack(EOBlocks.Quartzite, 1), 0.15F);
        
        GameRegistry.addSmelting(EOBlocks.ChiseledQuartzite, new ItemStack(EOBlocks.Quartzite, 1), 0.15F);
        
        GameRegistry.addSmelting(EOBlocks.PillarQuartzite, new ItemStack(EOBlocks.Quartzite, 1), 0.15F);
        
        GameRegistry.addSmelting(EOBlocks.QuartziteTile, new ItemStack(EOBlocks.Quartzite, 1), 0.15F);
        
        
        
        GameRegistry.addRecipe(new ItemStack(EOItems.SandstonePickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.SandstoneShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.SandstoneAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.SandstoneHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.SandstoneSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedCobble, 8), new Object[]
				{
			Blocks.cobblestone, EOItems.plateTinItem,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedMossy, 8), new Object[]
				{
			Blocks.mossy_cobblestone, EOItems.plateTinItem,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedStoneBrick, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 0), EOItems.plateTinItem,new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedChiseled, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 3), EOItems.plateTinItem,new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.TinPlatedGranite, 8), new Object[]
				{
			EOBlocks.GraniteBrick, EOItems.plateTinItem,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,
				});
        
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(EOItems.BronzeIngot, 1), new Object[]
        		{
        	Items.iron_ingot, EOItems.CopperIngot, EOItems.CopperIngot, EOItems.TinIngot, EOItems.TinIngot
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.BronzePickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.BronzeShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.BronzeAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.BronzeHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.BronzeSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), EOItems.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.BronzeHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItems.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzeChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItems.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzePants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItems.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItems.BronzeBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItems.BronzeIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.BronzeIngot, 9), new Object[]
				{
			EOBlocks.BronzeBlock,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlocks.BronzeBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.BronzeIngot
				});
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedCobble, 8), new Object[]
				{
			Blocks.cobblestone, EOItems.plateBronzeItem,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedMossy, 8), new Object[]
				{
			Blocks.mossy_cobblestone, EOItems.plateBronzeItem,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedStoneBrick, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 0), EOItems.plateBronzeItem,new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), 
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedChiseled, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 3), EOItems.plateBronzeItem,new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.BronzePlatedGranite, 8), new Object[]
				{
			EOBlocks.GraniteBrick, EOItems.plateBronzeItem,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,
				});
        
        
        
        GameRegistry.addRecipe(new ItemStack(EOItems.BedrockPickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.BedrockShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.BedrockAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.BedrockHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick
        		});
        
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedCobble, 8), new Object[]
				{
			Blocks.cobblestone, EOItems.plateSteelItem, Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedMossy, 8), new Object[]
				{
			Blocks.mossy_cobblestone, EOItems.plateSteelItem,	Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,	Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,	Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedStoneBrick, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 0), EOItems.plateSteelItem, new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedChiseled, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 3), EOItems.plateSteelItem, new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlocks.SteelPlatedGranite, 8), new Object[]
				{
			EOBlocks.GraniteBrick, EOItems.plateSteelItem,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,EOBlocks.GraniteBrick,
				});   
        
        GameRegistry.addRecipe(new ItemStack(EOItems.GranitePickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.GraniteShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.GraniteAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.GraniteHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItems.GraniteSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), EOBlocks.Granite, Character.valueOf('S'), Items.stick
        		});
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(EOItems.Uranium, 9), new Object[]
				{
			EOBlocks.RawUraniumBlock,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlocks.RawUraniumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.Uranium
				});
		GameRegistry.addSmelting(EOBlocks.UraniumOre, new ItemStack(EOItems.Uranium, 2), 0.15F);
		GameRegistry.addSmelting(EOBlocks.PlutoniumOre, new ItemStack(EOItems.Plutonium, 2), 0.15F);
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOItems.Plutonium, 9), new Object[]
				{
			EOBlocks.RawPlutoniumBlock,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlocks.RawPlutoniumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItems.Plutonium
				});
		
		GameRegistry.addRecipe(new ItemStack(EOItems.grenade, 1), new Object[]
				{
			"SUS", "PGP", "SUS", Character.valueOf('P'), EOItems.Plutonium, Character.valueOf('S'), EOItems.plateSteelItem, Character.valueOf('U'), EOItems.Uranium, Character.valueOf('G'), Items.gunpowder
				});
		GameRegistry.addRecipe(new ItemStack(EOBlocks.nuke, 1), new Object[]
				{
			"UPU", "PUP", "UPU", Character.valueOf('P'), EOBlocks.RawPlutoniumBlock, Character.valueOf('U'), EOBlocks.RawUraniumBlock
				});
		
	
		
		
		
		/*
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.meuroditeAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.meuroditeShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.meuroditeHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.meuroditeSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.meuroditeHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.meuroditeChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditePants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.meuroditePants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.meuroditeBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TitaniumPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TitaniumAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'),EOItemManager.TitaniumShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TitaniumHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TitaniumSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'),EOItemManager.TitaniumHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TitaniumChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TitaniumPants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'),EOItemManager.TitaniumBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToritePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.ToritePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.ToriteAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'),EOItemManager.ToriteShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.ToriteHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.ToriteSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.ToriteHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.ToriteChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToritePants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.ToritePants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.ToriteBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BlaziumPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BlaziumAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BlaziumShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BlaziumHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BlaziumSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BlaziumHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'),EOItemManager.BlaziumChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BlaziumPants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BlaziumBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.CopperPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.CopperAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.CopperShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.CopperHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.CopperSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTinHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TinHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTinChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TinChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTinPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TinPants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTinBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.TinBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SteelPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SteelAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SteelShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SteelHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SteelSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SteelHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SteelChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SteelPants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SteelBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstonePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SandstonePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstoneAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SandstoneAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstoneShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'),EOItemManager.SandstoneShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstoneHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SandstoneHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstoneSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.SandstoneSword
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGranitePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.GranitePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGraniteAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.GraniteAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGraniteShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.GraniteShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGraniteHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'),EOItemManager.GraniteHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGraniteSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.GraniteSword
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBedrockPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BedrockPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBedrockAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'),EOItemManager.BedrockAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBedrockShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BedrockShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBedrockHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), EOItemManager.BedrockHoe
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.wooden_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.wooden_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.wooden_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.wooden_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.wooden_sword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPClothHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.leather_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPClothChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.leather_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPClothPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.leather_leggings
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPClothBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.leather_boots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStonePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.stone_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStoneAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.stone_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStoneShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.stone_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStoneHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.stone_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStoneSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.stone_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPChainHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.chainmail_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPChainChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.chainmail_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPChainPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.chainmail_boots
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPChainBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.chainmail_boots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.iron_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.iron_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.iron_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.iron_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.iron_sword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.iron_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.iron_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.iron_leggings
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.iron_boots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.golden_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.golden_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.golden_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.golden_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.golden_sword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.golden_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.golden_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.golden_leggings
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.golden_boots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.diamond_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.diamond_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.diamond_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.diamond_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.diamond_sword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.diamond_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.diamond_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.diamond_leggings
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.plateBronzeItem, Character.valueOf('I'), Items.diamond_boots
				});
		
		*/
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlocks.SmoothRadiantQuartz, 1), new Object[]
        		{
        	"ZZ", "ZZ", Character.valueOf('Z'), EOBlocks.RadiantQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlocks.PillarRadiantQuartz, 2), new Object[]
        		{
        	"Z", "Z", Character.valueOf('Z'), EOBlocks.SmoothRadiantQuartz
        		});
        /*
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.ChiseledRadiantQuartz, 1), new Object[]
        		{
        	"Z", "Z", Character.valueOf('Z'), EOBlockManager.RadiantQuartzSingleSlab
        		});
        
        GameRegistry.addSmelting(EOBlockManager.SmoothRadiantQuartz, new ItemStack(EOBlockManager.RadiantQuartz, 1), 0.15F);
        
        
        
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.Godstone, 1), new Object[]
        		{
        	"SSS", "SES", "SSS", Character.valueOf('S'), EOItemManager.SunstoneDust, Character.valueOf('E'), Blocks.end_stone
        		});
        
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.RadiantQuartzStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.SmoothRadiantQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.RadiantQuartzSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.SmoothRadiantQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.PinkQuartzStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.SmoothQuartzite
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.PinkQuartzSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.SmoothQuartzite
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.graniteBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.GraniteBrick
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.graniteBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.GraniteBrick
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.tinPlatedCobbleStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.TinPlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.tinPlatedCobbleSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.TinPlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.steelPlatedCobbleStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.SteelPlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.steelPlatedCobbleSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.SteelPlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.bronzePlatedCobbleStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.BronzePlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.bronzePlatedCobbleSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.BronzePlatedCobble
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.tinPlatedStoneBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.TinPlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.tinPlatedStoneBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.TinPlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.steelPlatedStoneBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.SteelPlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.steelPlatedStoneBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.SteelPlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.bronzePlatedStoneBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.BronzePlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.bronzePlatedStoneBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.BronzePlatedStoneBrick
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.tinPlatedGraniteBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.TinPlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.tinPlatedGraniteBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.TinPlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.steelPlatedGraniteBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.SteelPlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.steelPlatedGraniteBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.SteelPlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.bronzePlatedGraniteBrickStairs, 4), new Object[]
        		{
        	"  S", " SS", "SSS", Character.valueOf('S'), EOBlockManager.BronzePlatedGranite
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.bronzePlatedGraniteBrickSingleSlab, 6), new Object[]
        		{
        	"SSS", Character.valueOf('S'), EOBlockManager.BronzePlatedGranite
        		});
        		*/
        GameRegistry.addRecipe(new ItemStack(EOBlocks.plutoniumInsulated, 1), new Object[]
        		{
        	"SSS", "GPG", "SSS", Character.valueOf('S'), EOItems.SteelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), EOBlocks.RawPlutoniumBlock
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlocks.uraniumInsulated, 1), new Object[]
        		{
        	"SSS", "GPG", "SSS", Character.valueOf('S'), EOItems.SteelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), EOBlocks.RawUraniumBlock
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlocks.melterIdle, 1), new Object[]
				{
			"ZZZ", "ZFZ", "ZBZ", Character.valueOf('Z'), EOItems.plateMeuroditeItem, Character.valueOf('F'), Blocks.furnace, Character.valueOf('B'), EOBlocks.BlaziumBlock
				});
        
        GameRegistry.addRecipe(new ItemStack(EOItems.plateMeuroditeItem, 4), new Object[]
				{
			"MMM", "MMM", Character.valueOf('M'), EOItems.meuroditeIngot,
				});
        GameRegistry.addRecipe(new ItemStack(EOBlocks.SoulBottle, 4), new Object[]
				{
			"S", "G", Character.valueOf('S'), EOBlocks.SoulGem, Character.valueOf('G'), Items.glass_bottle
				});
        GameRegistry.addRecipe(new ItemStack(EOBlocks.soulBlock, 1), new Object[]
				{
			"MMM", "MMM", "MMM", Character.valueOf('M'), EOBlocks.SoulGem,
				});
        GameRegistry.addRecipe(new ItemStack(EOBlocks.SoulGem, 9), new Object[]
				{
			"M", Character.valueOf('M'), EOBlocks.soulBlock,
				});
        GameRegistry.addSmelting(EOBlocks.RadiantQuartzOre, new ItemStack(EOBlocks.RadiantQuartz, 1), 0.8F);
        GameRegistry.addSmelting(EOBlocks.SoulOre, new ItemStack(EOBlocks.SoulGem, 1), 0.8F);

	}
	
	public static void loadPlatedRecipes()
	{
		//TODO: Yes, I realize this could be neater. If you have a better system, by all means, code away.
		ItemStack[] picks = new ItemStack[] {new ItemStack(EOItems.meuroditePickaxe, 1), new ItemStack(EOItems.ToritePickaxe, 1), new ItemStack(EOItems.BlaziumPickaxe, 1), new ItemStack(EOItems.TitaniumPickaxe, 1), new ItemStack(EOItems.SteelPickaxe, 1), new ItemStack(EOItems.SandstonePickaxe, 1), new ItemStack(EOItems.CopperPickaxe, 1), new ItemStack(EOItems.BedrockPickaxe, 1), new ItemStack(EOItems.GranitePickaxe, 1)};
		ItemStack[] picksWithoutNBT = new ItemStack[] {new ItemStack(EOItems.meuroditePickaxe, 1), new ItemStack(EOItems.ToritePickaxe, 1), new ItemStack(EOItems.BlaziumPickaxe, 1), new ItemStack(EOItems.TitaniumPickaxe, 1), new ItemStack(EOItems.SteelPickaxe, 1), new ItemStack(EOItems.SandstonePickaxe, 1), new ItemStack(EOItems.CopperPickaxe, 1), new ItemStack(EOItems.BedrockPickaxe, 1), new ItemStack(EOItems.GranitePickaxe, 1)};

		for(int i=0; i<picks.length; i++)
		{
			picks[i].stackTagCompound = new NBTTagCompound();
			picks[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(picks[i], new Object[]
					{
				"PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), picksWithoutNBT[i]
					});
		}	
		
		ItemStack[] axes = new ItemStack[] {new ItemStack(EOItems.meuroditeAxe, 1), new ItemStack(EOItems.ToriteAxe, 1), new ItemStack(EOItems.BlaziumAxe, 1), new ItemStack(EOItems.TitaniumAxe, 1), new ItemStack(EOItems.SteelAxe, 1), new ItemStack(EOItems.SandstoneAxe, 1), new ItemStack(EOItems.CopperAxe, 1), new ItemStack(EOItems.BedrockAxe, 1), new ItemStack(EOItems.GraniteAxe, 1)};
		ItemStack[] axesWithoutNBT = new ItemStack[] {new ItemStack(EOItems.meuroditeAxe, 1), new ItemStack(EOItems.ToriteAxe, 1), new ItemStack(EOItems.BlaziumAxe, 1), new ItemStack(EOItems.TitaniumAxe, 1), new ItemStack(EOItems.SteelAxe, 1), new ItemStack(EOItems.SandstoneAxe, 1), new ItemStack(EOItems.CopperAxe, 1), new ItemStack(EOItems.BedrockAxe, 1), new ItemStack(EOItems.GraniteAxe, 1)};

		for(int i=0; i<axes.length; i++)
		{
			axes[i].stackTagCompound = new NBTTagCompound();
			axes[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(axes[i], new Object[]
					{
				"PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), axesWithoutNBT[i]
					});
		}
		
		ItemStack[] hoes = new ItemStack[] {new ItemStack(EOItems.meuroditeHoe, 1), new ItemStack(EOItems.ToriteHoe, 1), new ItemStack(EOItems.BlaziumHoe, 1), new ItemStack(EOItems.TitaniumHoe, 1), new ItemStack(EOItems.SteelHoe, 1), new ItemStack(EOItems.SandstoneHoe, 1), new ItemStack(EOItems.CopperHoe, 1), new ItemStack(EOItems.BedrockHoe, 1), new ItemStack(EOItems.GraniteHoe, 1)};
		ItemStack[] hoesWithoutNBT = new ItemStack[] {new ItemStack(EOItems.meuroditeHoe, 1), new ItemStack(EOItems.ToriteHoe, 1), new ItemStack(EOItems.BlaziumHoe, 1), new ItemStack(EOItems.TitaniumHoe, 1), new ItemStack(EOItems.SteelHoe, 1), new ItemStack(EOItems.SandstoneHoe, 1), new ItemStack(EOItems.CopperHoe, 1), new ItemStack(EOItems.BedrockHoe, 1), new ItemStack(EOItems.GraniteHoe, 1)};
		
		for(int i=0; i<hoes.length; i++)
		{
			hoes[i].stackTagCompound = new NBTTagCompound();
			hoes[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(hoes[i], new Object[]
					{
				"PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), hoesWithoutNBT[i]
					});
		}
		
		ItemStack[] shovels = new ItemStack[] {new ItemStack(EOItems.meuroditeShovel, 1), new ItemStack(EOItems.ToriteShovel, 1), new ItemStack(EOItems.BlaziumShovel, 1), new ItemStack(EOItems.TitaniumShovel, 1), new ItemStack(EOItems.SteelShovel, 1), new ItemStack(EOItems.SandstoneShovel, 1), new ItemStack(EOItems.CopperShovel, 1), new ItemStack(EOItems.BedrockShovel, 1), new ItemStack(EOItems.GraniteShovel, 1)};
		ItemStack[] shovelsWithoutNBT = new ItemStack[] {new ItemStack(EOItems.meuroditeShovel, 1), new ItemStack(EOItems.ToriteShovel, 1), new ItemStack(EOItems.BlaziumShovel, 1), new ItemStack(EOItems.TitaniumShovel, 1), new ItemStack(EOItems.SteelShovel, 1), new ItemStack(EOItems.SandstoneShovel, 1), new ItemStack(EOItems.CopperShovel, 1), new ItemStack(EOItems.BedrockShovel, 1), new ItemStack(EOItems.GraniteShovel, 1)};
		
		for(int i=0; i<shovels.length; i++)
		{
			shovels[i].stackTagCompound = new NBTTagCompound();
			shovels[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(shovels[i], new Object[]
					{
				"PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), shovelsWithoutNBT[i]
					});
		}
		
		ItemStack[] swords = new ItemStack[] {new ItemStack(EOItems.meuroditeSword, 1), new ItemStack(EOItems.ToriteSword, 1), new ItemStack(EOItems.BlaziumSword, 1), new ItemStack(EOItems.TitaniumSword, 1), new ItemStack(EOItems.SteelSword, 1), new ItemStack(EOItems.SandstoneSword, 1), new ItemStack(EOItems.CopperSword, 1), new ItemStack(EOItems.GraniteSword, 1)};
		ItemStack[] swordsWithoutNBT = new ItemStack[] {new ItemStack(EOItems.meuroditeSword, 1), new ItemStack(EOItems.ToriteSword, 1), new ItemStack(EOItems.BlaziumSword, 1), new ItemStack(EOItems.TitaniumSword, 1), new ItemStack(EOItems.SteelSword, 1), new ItemStack(EOItems.SandstoneSword, 1), new ItemStack(EOItems.CopperSword, 1), new ItemStack(EOItems.GraniteSword, 1)};

		for(int i=0; i<swords.length; i++)
		{
			swords[i].stackTagCompound = new NBTTagCompound();
			swords[i].stackTagCompound.setBoolean("bronzePlated", true);
			
			GameRegistry.addRecipe(swords[i], new Object[]
					{
				"PPP", "PIP", "PPP", Character.valueOf('P'), EOItems.plateBronzeItem, Character.valueOf('I'), swordsWithoutNBT[i]
					});
		}
		
	}
	
	public static void loadBridgedRecipes() throws Exception
	{
		if(Loader.isModLoaded("ExtraDecor"))
		{
			GameRegistry.addSmelting(Blocks.glowstone, new ItemStack(EOBlocks.glowGlass), 0.5F);
		}
	}
}
