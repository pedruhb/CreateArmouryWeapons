package com.pedruhb.createarmouryweapon.fluids.molten;

import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.MaterialManager;
import com.pedruhb.createarmouryweapon.materials.serialize.Material;
import com.simibubi.create.AllFluids.TintedFluidType;
import com.simibubi.create.content.fluids.VirtualFluid;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidStack;

public class MoltenFluid extends VirtualFluid {

    public MoltenFluid(Properties properties) {
        super(properties);
    }

    public static FluidStack of(int amount, Material material) {
        FluidStack fluidStack = new FluidStack(CreateArmouryWeapon.MOLTEN.get().getSource(), amount);
        addMaterialToFluidStack(fluidStack, material);
        return fluidStack;
    }

    public static FluidStack withMaterial(int amount, Material material) {
        FluidStack fluidStack = of(amount, material);
        return fluidStack;
    }

    public static FluidStack addMaterialToFluidStack(FluidStack fs, Material material) {
        fs.getOrCreateTag().putString("material", material.getName().toLowerCase());
        return fs;
    }

    public static class MoltenFluidType extends TintedFluidType {

        public MoltenFluidType(Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture) {
            super(properties, stillTexture, flowingTexture);
        }

        @Override
        public int getTintColor(FluidStack stack) {

            CompoundTag tag = stack.getOrCreateTag();

            if (tag.contains("material")) {
                int color = MaterialManager.getMaterialByName(tag.getString("material")).getMoltenColor();
                return color;
            }

            return -1;

        }

        @Override
        public String getDescriptionId(FluidStack stack) {

            CompoundTag tag = stack.getOrCreateTag();

            String material_name = "unknown";

            if (tag.contains("material"))
                material_name = tag.getString("material");

            return Component.translatable("molten.createarmouryweapon." + material_name).getString();

        }

        @Override
        protected int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
            return NO_TINT;
        }

    }

}