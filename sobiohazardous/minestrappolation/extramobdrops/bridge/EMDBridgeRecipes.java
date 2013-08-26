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
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.ExtraOres.SandstoneSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornGranite), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.ExtraOres.GraniteSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornCopper), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.ExtraOres.CopperSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornSteel), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.ExtraOres.SteelSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornBronze), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.ExtraOres.BronzeSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornMeurodite), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.ExtraOres.meuroditeSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornTorite), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.ExtraOres.ToriteSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornBlazium), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.ExtraOres.BlaziumSword
					});
			GameRegistry.addShapelessRecipe(new ItemStack(ExtraMobDrops.hornTitanium), new Object[]
					{
				ExtraMobDrops.horn, ExtraMobDrops.horn, sobiohazardous.minestrappolation.extraores.ExtraOres.TitaniumSword
					});
		}
	}
}
