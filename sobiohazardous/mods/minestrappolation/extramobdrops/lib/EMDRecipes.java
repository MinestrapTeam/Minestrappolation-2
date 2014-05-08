package sobiohazardous.mods.minestrappolation.extramobdrops.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class EMDRecipes
{
	public static void loadRecipes()
	{
		GameRegistry.addSmelting(EMDItems.fat, new ItemStack(EMDItems.grease, 1), 0.7F);
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedApple, 2), new Object[] { EMDItems.fat, Items.apple, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedBeef, 2), new Object[] { EMDItems.fat, Items.beef, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedBread, 2), new Object[] { EMDItems.fat, Items.bread, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedCarrot, 2), new Object[] { EMDItems.fat, Items.carrot, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedCookie, 2), new Object[] { EMDItems.fat, Items.cookie, EMDItems.fat });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.friedFlesh, 2), new Object[] { EMDItems.fat, Items.rotten_flesh, EMDItems.fat });
		GameRegistry.addRecipe(new ItemStack(Items.dye, 1, 16), new Object[] { "AA", "AA", 'A', EMDItems.animalBones });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordWood), new Object[] { EMDItems.horn, EMDItems.horn, Items.wooden_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordStone), new Object[] { EMDItems.horn, EMDItems.horn, Items.stone_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordIron), new Object[] { EMDItems.horn, EMDItems.horn, Items.iron_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordDiamond), new Object[] { EMDItems.horn, EMDItems.horn, Items.diamond_sword });
		GameRegistry.addShapelessRecipe(new ItemStack(EMDItems.hornSwordGold), new Object[] { EMDItems.horn, EMDItems.horn, Items.golden_sword });
		GameRegistry.addSmelting(EMDItems.chickenWingRaw, new ItemStack(EMDItems.chickenWingCooked, 1), 0.7F);
		GameRegistry.addSmelting(EMDItems.lambchopRaw, new ItemStack(EMDItems.lambchopCooked, 1), 0.7F);
		GameRegistry.addSmelting(EMDItems.squidTentacle, new ItemStack(EMDItems.calimari, 1), 0.7F);
		GameRegistry.addRecipe(new ItemStack(Items.string), new Object[] { "WW", "WW", 'W', EMDItems.whisker });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 0), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.pigHoof });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 1), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.cowHoof });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 2), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.footChicken });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 3), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.sheepHoof });
		GameRegistry.addRecipe(new ItemStack(EMDItems.charms, 1, 4), new Object[] { " G ", "GPG", " G ", 'G', Items.gold_ingot, 'P', EMDItems.horseHoof });
		GameRegistry.addSmelting(EMDItems.rawHorseHaunch, new ItemStack(EMDItems.cookedHorseHaunch), 0.8F);
		GameRegistry.addRecipe(new ItemStack(EMDItems.wingSegment, 1, 0), new Object[] { "FSF", "SLS", "FSF", 'F', Items.feather, 'S', EMDItems.wingSinew, 'L', Items.leather });
		GameRegistry.addRecipe(new ItemStack(EMDItems.hangGlider, 1, 0), new Object[] { "PPP", "W W", "W W", 'P', Blocks.planks, 'W', EMDItems.wingSegment });
	}
	
	public static void loadBridgeRecipes() throws Exception
	{
		/*
		 * if(Loader.isModLoaded("ExtraOres")) {
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornSandstone), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.SandstoneSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornGranite), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.GraniteSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornCopper), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.CopperSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornSteel), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.SteelSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornBronze), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.BronzeSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornMeurodite), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.meuroditeSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornTorite), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.ToriteSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornBlazium), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.BlaziumSword });
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(EMDItemManager.hornTitanium), new Object[] {
		 * EMDItemManager.horn, EMDItemManager.horn,
		 * sobiohazardous.minestrappolation
		 * .extraores.lib.EOItemManager.TitaniumSword }); }
		 */
	}
}
