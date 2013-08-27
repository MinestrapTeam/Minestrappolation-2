package sobiohazardous.minestrappolation.extramobdrops.bridge;

import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class EMDBridgeRecipes 
{
	public static void loadBridgeRecipes() throws Exception
	{
		if(Loader.isModLoaded("ExtraOres"))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornSandstone), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SandstoneSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornGranite), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.GraniteSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornCopper), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.CopperSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornSteel), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SteelSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornBronze), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BronzeSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornMeurodite), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.meuroditeSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornTorite), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.ToriteSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornBlazium), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BlaziumSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(EMDItemManager.hornTitanium), new Object[]
					{
				EMDItemManager.horn, EMDItemManager.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.TitaniumSword
					});
		}
	}
}
