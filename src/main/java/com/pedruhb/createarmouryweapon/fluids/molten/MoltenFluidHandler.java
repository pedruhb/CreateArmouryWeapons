package com.pedruhb.createarmouryweapon.fluids.molten;

import com.pedruhb.createarmouryweapon.materials.serialize.Material;
import net.minecraftforge.fluids.FluidStack;

public class MoltenFluidHandler {

	public static FluidStack getFluidFromMaterial(Material material) {

		FluidStack fluid = MoltenFluid.withMaterial(1000, material);
		return fluid;

	}

}
