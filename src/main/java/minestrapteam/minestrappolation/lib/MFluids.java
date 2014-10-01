package minestrapteam.minestrappolation.lib;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class MFluids
{
	public static Fluid	MAGMA;
	
	public static void init()
	{
		MAGMA = new Fluid("Magma").setLuminosity(10).setViscosity(6500).setDensity(4000).setTemperature(1500);
		FluidRegistry.registerFluid(MAGMA);
	}
	
	public static void load()
	{
		FluidContainerRegistry.registerFluidContainer(MAGMA, new ItemStack(MItems.magmaBucket), FluidContainerRegistry.EMPTY_BUCKET);
	}
}
