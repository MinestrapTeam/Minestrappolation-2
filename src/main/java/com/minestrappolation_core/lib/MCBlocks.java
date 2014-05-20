package com.minestrappolation_core.lib;

import com.minestrappolation.Minestrappolation;
import com.minestrappolation_core.block.MCBlockStonecutter;
import com.minestrappolation_core.util.MCBlockHelper;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class MCBlocks
{
	public static Block	stoneCutter;
	
	public static Block stone;
	public static Block stone2;
	public static Block stoneTin;
	public static Block stoneTin2;
	public static Block stoneBronze;
	public static Block stoneBronze2;
	public static Block stoneSteel;
	public static Block stoneSteel2;
	public static Block stoneMeurodite;
	public static Block stoneMeurodite2;
	
	public static Block granite;
	public static Block granite2;
	public static Block graniteTin;
	public static Block graniteTin2;
	public static Block graniteBronze;
	public static Block graniteBronze2;
	public static Block graniteSteel;
	public static Block graniteSteel2;
	public static Block graniteMeurodite;
	public static Block graniteMeurodite2;
	
	public static Block sandstone;
	public static Block sandstone2;
	public static Block redSandstone;
	public static Block redSandstone2;
	public static Block flint;
	public static Block flint2;
	public static Block lapis;
	public static Block lapis2;
	public static Block obsidian;
	public static Block obsidian2;
	public static Block endstone;
	public static Block endstone2;
	public static Block bedrock;
	public static Block bedrock2;
	public static Block netherrack;
	public static Block netherrack2;
	public static Block netherQuartz;
	public static Block netherQuartz2;
	public static Block desertQuartz;
	public static Block desertQuartz2;
	public static Block radiantQuartz;
	public static Block radiantQuartz2;
	
	public static Block clay;
	public static Block clay2;
	
	public static void init()
	{
		stoneCutter = new MCBlockStonecutter().setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName("stoneCutter");
		GameRegistry.registerBlock(stoneCutter, "stoneCutter");
		
		CreativeTabs tab = Minestrappolation.tabStoneDecor;
		stone = MCBlockHelper.createStoneBlock("stone", 2F, tab);
		stone2 = MCBlockHelper.createStoneBlock2("stone", 2F, tab);
		stoneTin = MCBlockHelper.createStoneBlock("stone_tin", 2F, tab);
		stoneTin2 = MCBlockHelper.createStoneBlock2("stone_tin", 2F, tab);
		stoneBronze = MCBlockHelper.createStoneBlock("stone_bronze", 2F, tab);
		stoneBronze2 = MCBlockHelper.createStoneBlock2("stone_bronze", 2F, tab);
		stoneSteel = MCBlockHelper.createStoneBlock("stone_steel", 2F, tab);
		stoneSteel2 = MCBlockHelper.createStoneBlock2("stone_steel", 2F, tab);
		stoneMeurodite = MCBlockHelper.createStoneBlock("stone_meurodite", 2F, tab);
		stoneMeurodite2 = MCBlockHelper.createStoneBlock2("stone_meurodite", 2F, tab);
		
		granite = MCBlockHelper.createStoneBlock("granite", 2F, tab);
		granite2 = MCBlockHelper.createStoneBlock2("granite", 2F, tab);
		graniteTin = MCBlockHelper.createStoneBlock("granite_tin", 2F, tab);
		graniteTin2 = MCBlockHelper.createStoneBlock2("granite_tin", 2F, tab);
		graniteBronze = MCBlockHelper.createStoneBlock("granite_bronze", 2F, tab);
		graniteBronze2 = MCBlockHelper.createStoneBlock2("granite_bronze", 2F, tab);
		graniteSteel = MCBlockHelper.createStoneBlock("granite_steel", 2F, tab);
		graniteSteel2 = MCBlockHelper.createStoneBlock2("granite_steel", 2F, tab);
		graniteMeurodite = MCBlockHelper.createStoneBlock("granite_meurodite", 2F, tab);
		graniteMeurodite2 = MCBlockHelper.createStoneBlock2("granite_meurodite", 2F, tab);
		
		sandstone     = MCBlockHelper.createStoneBlock("sandstone", 1.5F, tab);
		sandstone2    = MCBlockHelper.createStoneBlock2("sandstone", 1.5F, tab);
		flint         = MCBlockHelper.createStoneBlock("flint", 1F, tab);
		flint2        = MCBlockHelper.createStoneBlock2("flint", 1F, tab);
		lapis         = MCBlockHelper.createStoneBlock("lapis", 1F, tab);
		lapis2        = MCBlockHelper.createStoneBlock2("lapis", 1F, tab);
		obsidian      = MCBlockHelper.createStoneBlock("obsidian", 1F, tab);
		obsidian2     = MCBlockHelper.createStoneBlock2("obsidian", 1F, tab);
		endstone      = MCBlockHelper.createStoneBlock("endstone", 1F, tab);
		endstone2     = MCBlockHelper.createStoneBlock2("endstone", 1F, tab);
		bedrock       = MCBlockHelper.createStoneBlock("bedrock", 1F, tab);
		bedrock2      = MCBlockHelper.createStoneBlock2("bedrock", 1F, tab);
		netherrack    = MCBlockHelper.createStoneBlock("netherrack", 1F, tab);
		netherrack2   = MCBlockHelper.createStoneBlock2("netherrack", 1F, tab);
		netherQuartz  = MCBlockHelper.createStoneBlock("netherquartz", 1F, tab);
		netherQuartz2 = MCBlockHelper.createStoneBlock2("netherquartz", 1F, tab);
		desertQuartz  = MCBlockHelper.createStoneBlock("desertquartz", 1F, tab);
		desertQuartz2 = MCBlockHelper.createStoneBlock2("desertquartz", 1F, tab);
		radiantQuartz = MCBlockHelper.createStoneBlock("radiantquartz", 1F, tab);
		radiantQuartz2= MCBlockHelper.createStoneBlock2("radiantquartz", 1F, tab);
	}
}
