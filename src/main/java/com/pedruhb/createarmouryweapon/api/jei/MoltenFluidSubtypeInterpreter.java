package com.pedruhb.createarmouryweapon.api.jei;

import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.fluids.FluidStack;

public class MoltenFluidSubtypeInterpreter implements IIngredientSubtypeInterpreter<FluidStack> {

	@Override
	public String apply(FluidStack ingredient, UidContext context) {

		if (!ingredient.hasTag())
			return IIngredientSubtypeInterpreter.NONE;

		CompoundTag tag = ingredient.getTag();
        
        if(!tag.contains("material"))
            return IIngredientSubtypeInterpreter.NONE;
		
        return tag.getString("material");

	}

}