package com.pedruhb.createarmouryweapon.fluids;

import static com.pedruhb.createarmouryweapon.CreateArmouryWeapon.REGISTRATE;

import com.pedruhb.createarmouryweapon.fluids.molten.MoltenFluid;
import com.pedruhb.createarmouryweapon.fluids.molten.MoltenFluid.MoltenFluidType;
import com.tterrag.registrate.util.entry.FluidEntry;

public class AllFluids {

        public static final FluidEntry<MoltenFluid> MOLTEN = REGISTRATE.virtualFluid("molten", MoltenFluidType::new, MoltenFluid::new).register();

        public static void register() {}
        
}
