package sobiohazardous.minestrappolation.extramobdrops.bridge;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sobiohazardous.minestrappolation.extramobdrops.ExtraMobDrops;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class EMDBridgeRecipes 
{
	public static void loadBridgeRecipes() throws Exception
	{
		if(Loader.isModLoaded("ExtraOres"))
		{
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornSandstone), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SandstoneSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornGranite), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.GraniteSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornCopper), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.CopperSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornSteel), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.SteelSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornBronze), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BronzeSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornMeurodite), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.meuroditeSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornTorite), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.ToriteSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornBlazium), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.BlaziumSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornTitanium), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.lib.EOItemManager.TitaniumSword
					});
		}
	}
}
