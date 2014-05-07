package sobiohazardous.mods.minestrappolation.extraores.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class EOFluids extends Fluid
{
	public EOFluids(String fluidName)
	{
		super(fluidName);
		FluidRegistry.registerFluid(this);
	}
}
