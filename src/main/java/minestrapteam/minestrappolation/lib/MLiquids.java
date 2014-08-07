package minestrapteam.minestrappolation.lib;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class MLiquids
{
	public static Fluid					magmaFluid;

	public static void init()
	{
		magmaFluid = new Fluid("Magma").setLuminosity(10).setViscosity(6500).setDensity(4000).setTemperature(1500);
	}
	
	public static void load()
	{
		FluidRegistry.registerFluid(magmaFluid);
	}
	
	public static void registerFluidContainers()
	{
		FluidContainerRegistry.registerFluidContainer(magmaFluid, new ItemStack(MItems.magmaBucket));
	}
}
