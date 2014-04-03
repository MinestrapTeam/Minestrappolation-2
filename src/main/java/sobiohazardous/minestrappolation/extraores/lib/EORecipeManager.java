package sobiohazardous.minestrappolation.extraores.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class EORecipeManager 
{
	public EORecipeManager()
	{
		loadRecipes();
	}
	
	public static void loadRecipes()
	{
		GameRegistry.addSmelting(EOBlockManager.BlaziumOre, new ItemStack(Items.blaze_powder, 3), 1.0F);
		
		GameRegistry.addSmelting(EOBlockManager.meuroditeOre, new ItemStack(EOItemManager.meuroditeIngot, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditeSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItemManager.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditeShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItemManager.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditeAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItemManager.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditePickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItemManager.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditeHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItemManager.meuroditeIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditeHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItemManager.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditeChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditePants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditeBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.meuroditeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.meuroditeBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.meuroditeIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.meuroditeIngot, 9), new Object[]
				{
			EOBlockManager.meuroditeBlock,
				});
		
		
		
		GameRegistry.addSmelting(EOBlockManager.TitaniumOre, new ItemStack(EOItemManager.TitaniumIngot, 1), 2.0F);
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TitaniumSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItemManager.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TitaniumShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItemManager.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TitaniumAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItemManager.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TitaniumPickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItemManager.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TitaniumHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItemManager.TitaniumIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TitaniumHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItemManager.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TitaniumChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TitaniumPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TitaniumBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.TitaniumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.TitaniumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItemManager.TitaniumIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.TitaniumIngot, 9), new Object[]
				{
			EOBlockManager.TitaniumBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.Sunstone, 1), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), EOItemManager.SunstoneDust,
				});
		
		GameRegistry.addSmelting(EOBlockManager.SunstoneOre, new ItemStack(EOItemManager.SunstoneDust, 4), 1.0F);
		
		
		
		GameRegistry.addSmelting(EOBlockManager.ToriteOre, new ItemStack(EOItemManager.ToriteIngot, 1), 1.1F);
		
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.ToriteBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.ToriteSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItemManager.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.ToriteShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItemManager.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.ToriteAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItemManager.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.ToritePickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'),EOItemManager.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.ToriteHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItemManager.ToriteIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.ToriteHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItemManager.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.ToriteChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItemManager.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.ToritePants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.ToriteIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.ToriteBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.ToriteIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.ToriteIngot, 9), new Object[]
				{
			EOBlockManager.ToriteBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.GraniteBrick, 4), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), EOBlockManager.Granite,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.QuartziteTile, 4), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), EOBlockManager.Quartzite,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.BlaziumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.BlaziumIngot,
				});
		
		GameRegistry.addSmelting(Items.blaze_powder, new ItemStack(EOItemManager.BlazeShard, 1), 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumIngot, 1), new Object[]
				{
			"ZZ", "ZZ", Character.valueOf('Z'), EOItemManager.BlazeShard,
				});
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItemManager.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItemManager.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItemManager.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumPickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItemManager.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItemManager.BlaziumIngot, Character.valueOf('S'), Items.blaze_rod
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItemManager.BlaziumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.BlaziumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'),EOItemManager.BlaziumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BlaziumBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.BlaziumIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.BlaziumIngot, 9), new Object[]
				{
			EOBlockManager.BlaziumBlock,
				});
		
		
		
		GameRegistry.addSmelting(EOBlockManager.CopperOre, new ItemStack(EOItemManager.CopperIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.CopperBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.CopperIngot
				});
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.CopperSword, 1), new Object[]
				{
			" Z ", " Z ", " S ", Character.valueOf('Z'), EOItemManager.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.CopperShovel, 1), new Object[]
				{
			" Z ", " S ", " S ", Character.valueOf('Z'), EOItemManager.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.CopperAxe, 1), new Object[]
				{
			"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItemManager.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.CopperPickaxe, 1), new Object[]
				{
			"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItemManager.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.CopperHoe, 1), new Object[]
				{
			"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItemManager.CopperIngot, Character.valueOf('S'), Items.stick
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.CopperIngot, 9), new Object[]
				{
			EOBlockManager.CopperBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.TinBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.TinIngot,
				});
		GameRegistry.addSmelting(EOBlockManager.TinOre, new ItemStack(EOItemManager.TinIngot, 1), 0.3F);
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TinHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItemManager.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TinChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItemManager.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TinPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TinBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.TinIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.TinIngot, 9), new Object[]
				{
			EOBlockManager.TinBlock,
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.TinPlateItem, 4), new Object[]
				{
			"ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.TinIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzePlateItem, 1), new Object[]
				{
			"ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelPlateItem, 1), new Object[]
				{
			"ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.SteelIngot,
				});
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.CoalIronIngot, 1), new Object[]
				{
			Items.iron_ingot, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal
				});
		
		GameRegistry.addSmelting(EOItemManager.CoalIronIngot, new ItemStack(EOItemManager.SteelIngot, 1), 0.7F);
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelPickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItemManager.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), EOItemManager.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItemManager.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItemManager.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), EOItemManager.SteelIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItemManager.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItemManager.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelPants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'),EOItemManager.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.SteelBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.SteelIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.SteelBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.SteelIngot
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.SteelIngot, 9), new Object[]
				{
			EOBlockManager.SteelBlock,
				});
		
		
		
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.SmoothQuartzite, 1), new Object[]
        		{
        	"ZZ", "ZZ", Character.valueOf('Z'), EOItemManager.PinkQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.PillarQuartzite, 2), new Object[]
        		{
        	"Z", "Z", Character.valueOf('Z'), EOBlockManager.SmoothQuartzite
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.ChiseledQuartzite, 1), new Object[]
        		{
        	"Z", "Z", Character.valueOf('Z'), EOBlockManager.PinkQuartzSingleSlab
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.SmoothQuartzTile, 8), new Object[]
        		{
        	"ZZZ", "ZYZ", "ZZZ", Character.valueOf('Z'), EOBlockManager.SmoothQuartzite, Character.valueOf('Y'), Blocks.stone
        		});
        
        GameRegistry.addSmelting(EOBlockManager.SmoothQuartzite, new ItemStack(EOBlockManager.Quartzite, 1), 0.15F);
        
        GameRegistry.addSmelting(EOBlockManager.ChiseledQuartzite, new ItemStack(EOBlockManager.Quartzite, 1), 0.15F);
        
        GameRegistry.addSmelting(EOBlockManager.PillarQuartzite, new ItemStack(EOBlockManager.Quartzite, 1), 0.15F);
        
        GameRegistry.addSmelting(EOBlockManager.QuartziteTile, new ItemStack(EOBlockManager.Quartzite, 1), 0.15F);
        
        
        
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SandstonePickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SandstoneShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SandstoneAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SandstoneHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.SandstoneSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), Blocks.sandstone, Character.valueOf('S'), Items.stick
        		});
        
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.TinPlatedCobble, 8), new Object[]
				{
			Blocks.cobblestone, EOItemManager.TinPlateItem,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.TinPlatedMossy, 8), new Object[]
				{
			Blocks.mossy_cobblestone, EOItemManager.TinPlateItem,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.TinPlatedStoneBrick, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 0), EOItemManager.TinPlateItem,new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.TinPlatedChiseled, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 3), EOItemManager.TinPlateItem,new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.TinPlatedGranite, 8), new Object[]
				{
			EOBlockManager.GraniteBrick, EOItemManager.TinPlateItem,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,
				});
        
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.BronzeIngot, 1), new Object[]
        		{
        	Items.iron_ingot, EOItemManager.CopperIngot, EOItemManager.CopperIngot, EOItemManager.TinIngot, EOItemManager.TinIngot
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzePickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), EOItemManager.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzeShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), EOItemManager.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzeAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOItemManager.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzeHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), EOItemManager.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzeSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), EOItemManager.BronzeIngot, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzeHelmet, 1), new Object[]
				{
			"ZZZ", "Z Z", Character.valueOf('Z'), EOItemManager.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzeChest, 1), new Object[]
				{
			"Z Z", "ZZZ", "ZZZ", Character.valueOf('Z'),EOItemManager.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzePants, 1), new Object[]
				{
			"ZZZ", "Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.BronzeIngot,
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BronzeBoots, 1), new Object[]
				{
			"Z Z", "Z Z", Character.valueOf('Z'), EOItemManager.BronzeIngot,
				});
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.BronzeIngot, 9), new Object[]
				{
			EOBlockManager.BronzeBlock,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.BronzeBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.BronzeIngot
				});
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.BronzePlatedCobble, 8), new Object[]
				{
			Blocks.cobblestone, EOItemManager.BronzePlateItem,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.BronzePlatedMossy, 8), new Object[]
				{
			Blocks.mossy_cobblestone, EOItemManager.BronzePlateItem,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.BronzePlatedStoneBrick, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 0), EOItemManager.BronzePlateItem,new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 0), 
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.BronzePlatedChiseled, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 3), EOItemManager.BronzePlateItem,new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.BronzePlatedGranite, 8), new Object[]
				{
			EOBlockManager.GraniteBrick, EOItemManager.BronzePlateItem,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,
				});
        
        
        
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BedrockPickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BedrockShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BedrockAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.BedrockHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), Blocks.bedrock, Character.valueOf('S'), Items.stick
        		});
        
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.SteelPlatedCobble, 8), new Object[]
				{
			Blocks.cobblestone, EOItemManager.SteelPlateItem, Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.SteelPlatedMossy, 8), new Object[]
				{
			Blocks.mossy_cobblestone, EOItemManager.SteelPlateItem,	Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,	Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,	Blocks.mossy_cobblestone,Blocks.mossy_cobblestone,
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.SteelPlatedStoneBrick, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 0), EOItemManager.SteelPlateItem, new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),new ItemStack(Blocks.stonebrick, 1, 0),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.SteelPlatedChiseled, 8), new Object[]
				{
			new ItemStack(Blocks.stonebrick, 1, 3), EOItemManager.SteelPlateItem, new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),new ItemStack(Blocks.stonebrick, 1, 3),
				});
        GameRegistry.addShapelessRecipe(new ItemStack(EOBlockManager.SteelPlatedGranite, 8), new Object[]
				{
			EOBlockManager.GraniteBrick, EOItemManager.SteelPlateItem,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,EOBlockManager.GraniteBrick,
				});   
        
        GameRegistry.addRecipe(new ItemStack(EOItemManager.GranitePickaxe, 1), new Object[]
        		{
        	"ZZZ", " S ", " S ", Character.valueOf('Z'), EOBlockManager.Granite, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.GraniteShovel, 1), new Object[]
        		{
        	" Z ", " S ", " S ", Character.valueOf('Z'), EOBlockManager.Granite, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.GraniteAxe, 1), new Object[]
        		{
        	"ZZ ", "ZS ", " S ", Character.valueOf('Z'), EOBlockManager.Granite, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.GraniteHoe, 1), new Object[]
        		{
        	"ZZ ", " S ", " S ", Character.valueOf('Z'), EOBlockManager.Granite, Character.valueOf('S'), Items.stick
        		});
        GameRegistry.addRecipe(new ItemStack(EOItemManager.GraniteSword, 1), new Object[]
        		{
        	" Z ", " Z ", " S ", Character.valueOf('Z'), EOBlockManager.Granite, Character.valueOf('S'), Items.stick
        		});
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.Uranium, 9), new Object[]
				{
			EOBlockManager.RawUraniumBlock,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.RawUraniumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.Uranium
				});
		GameRegistry.addSmelting(EOBlockManager.UraniumOre, new ItemStack(EOItemManager.Uranium, 2), 0.15F);
		GameRegistry.addSmelting(EOBlockManager.PlutoniumOre, new ItemStack(EOItemManager.Plutonium, 2), 0.15F);
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(EOItemManager.Plutonium, 9), new Object[]
				{
			EOBlockManager.RawPlutoniumBlock,
				});
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.RawPlutoniumBlock, 1), new Object[]
				{
			"ZZZ", "ZZZ", "ZZZ", Character.valueOf('Z'), EOItemManager.Plutonium
				});
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.grenade, 1), new Object[]
				{
			"SUS", "PGP", "SUS", Character.valueOf('P'), EOItemManager.Plutonium, Character.valueOf('S'), EOItemManager.SteelPlateItem, Character.valueOf('U'), EOItemManager.Uranium, Character.valueOf('G'), Items.gunpowder
				});
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.nuke, 1), new Object[]
				{
			"UPU", "PUP", "UPU", Character.valueOf('P'), EOBlockManager.RawPlutoniumBlock, Character.valueOf('U'), EOBlockManager.RawUraniumBlock
				});
		
	
		
		
		
		/*
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.meuroditeAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.meuroditeShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.meuroditeHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.meuroditeSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.meuroditeHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.meuroditeChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditePants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.meuroditePants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPMeuroditeBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.meuroditeBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TitaniumPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TitaniumAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'),EOItemManager.TitaniumShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TitaniumHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TitaniumSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'),EOItemManager.TitaniumHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TitaniumChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TitaniumPants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTitaniumBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'),EOItemManager.TitaniumBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToritePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.ToritePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.ToriteAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'),EOItemManager.ToriteShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.ToriteHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.ToriteSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.ToriteHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.ToriteChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToritePants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.ToritePants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPToriteBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.ToriteBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BlaziumPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BlaziumAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BlaziumShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BlaziumHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BlaziumSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BlaziumHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'),EOItemManager.BlaziumChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BlaziumPants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBlaziumBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BlaziumBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.CopperPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.CopperAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.CopperShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.CopperHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPCopperSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.CopperSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTinHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TinHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTinChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TinChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTinPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TinPants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPTinBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.TinBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SteelPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SteelAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SteelShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SteelHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SteelSword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SteelHelmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SteelChest
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SteelPants
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSteelBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SteelBoots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstonePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SandstonePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstoneAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SandstoneAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstoneShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'),EOItemManager.SandstoneShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstoneHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SandstoneHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPSandstoneSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.SandstoneSword
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGranitePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.GranitePickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGraniteAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.GraniteAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGraniteShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.GraniteShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGraniteHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'),EOItemManager.GraniteHoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGraniteSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.GraniteSword
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBedrockPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BedrockPickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBedrockAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'),EOItemManager.BedrockAxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBedrockShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BedrockShovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPBedrockHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), EOItemManager.BedrockHoe
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.wooden_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.wooden_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.wooden_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.wooden_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPWoodSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.wooden_sword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPClothHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.leather_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPClothChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.leather_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPClothPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.leather_leggings
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPClothBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.leather_boots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStonePickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.stone_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStoneAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.stone_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStoneShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.stone_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStoneHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.stone_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPStoneSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.stone_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPChainHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.chainmail_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPChainChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.chainmail_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPChainPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.chainmail_boots
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPChainBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.chainmail_boots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.iron_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.iron_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.iron_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.iron_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.iron_sword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.iron_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.iron_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.iron_leggings
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPIronBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.iron_boots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.golden_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.golden_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.golden_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.golden_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.golden_sword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.golden_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.golden_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.golden_leggings
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPGoldBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.golden_boots
				});
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondPickaxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.diamond_pickaxe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondAxe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.diamond_axe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondShovel, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.diamond_shovel
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondHoe, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.diamond_hoe
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondSword, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.diamond_sword
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondHelmet, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.diamond_helmet
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondChest, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.diamond_chestplate
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondPants, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.diamond_leggings
				});
		GameRegistry.addRecipe(new ItemStack(EOItemManager.BPDiamondBoots, 1), new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOItemManager.BronzePlateItem, Character.valueOf('I'), Items.diamond_boots
				});
		
		*/
		
		
		
		GameRegistry.addRecipe(new ItemStack(EOBlockManager.SmoothRadiantQuartz, 1), new Object[]
        		{
        	"ZZ", "ZZ", Character.valueOf('Z'), EOBlockManager.RadiantQuartz
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.PillarRadiantQuartz, 2), new Object[]
        		{
        	"Z", "Z", Character.valueOf('Z'), EOBlockManager.SmoothRadiantQuartz
        		});
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
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.plutoniumInsulated, 1), new Object[]
        		{
        	"SSS", "GPG", "SSS", Character.valueOf('S'), EOItemManager.SteelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), EOBlockManager.RawPlutoniumBlock
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.uraniumInsulated, 1), new Object[]
        		{
        	"SSS", "GPG", "SSS", Character.valueOf('S'), EOItemManager.SteelIngot, Character.valueOf('G'), Blocks.glass_pane, Character.valueOf('P'), EOBlockManager.RawUraniumBlock
        		});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.melterIdle, 1), new Object[]
				{
			"ZZZ", "ZFZ", "ZBZ", Character.valueOf('Z'), EOItemManager.meuroditePlateItem, Character.valueOf('F'), Blocks.furnace, Character.valueOf('B'), EOBlockManager.BlaziumBlock
				});
        
        GameRegistry.addRecipe(new ItemStack(EOItemManager.meuroditePlateItem, 4), new Object[]
				{
			"MMM", "MMM", Character.valueOf('M'), EOItemManager.meuroditeIngot,
				});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.SoulBottle, 4), new Object[]
				{
			"S", "G", Character.valueOf('S'), EOBlockManager.SoulGem, Character.valueOf('G'), Items.glass_bottle
				});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.soulBlock, 1), new Object[]
				{
			"MMM", "MMM", "MMM", Character.valueOf('M'), EOBlockManager.SoulGem,
				});
        GameRegistry.addRecipe(new ItemStack(EOBlockManager.SoulGem, 9), new Object[]
				{
			"M", Character.valueOf('M'), EOBlockManager.soulBlock,
				});
        GameRegistry.addSmelting(EOBlockManager.RadiantQuartzOre, new ItemStack(EOBlockManager.RadiantQuartz, 1), 0.8F);
        GameRegistry.addSmelting(EOBlockManager.SoulOre, new ItemStack(EOBlockManager.SoulGem, 1), 0.8F);

	}
	
	public static void loadPlatedRecipes()
	{
		ItemStack pick = new ItemStack(EOItemManager.meuroditePickaxe, 1);
		pick.stackTagCompound = new NBTTagCompound();
		pick.stackTagCompound.setBoolean("bronzePlated", true);
		
		GameRegistry.addRecipe(pick, new Object[]
				{
			"PPP", "PIP", "PPP", Character.valueOf('P'), EOBlockManager.BronzePlate, Character.valueOf('I'), EOItemManager.meuroditePickaxe
				});
		
		//TODO add rest of bp tools recipes!
		//TODO add bp armor
	}
	
	public static void loadBridgedRecipes() throws Exception
	{
		if(Loader.isModLoaded("ExtraDecor"))
		{
			GameRegistry.addSmelting(Blocks.glowstone, new ItemStack(EOBlockManager.glowGlass), 0.5F);
		}
	}
}
