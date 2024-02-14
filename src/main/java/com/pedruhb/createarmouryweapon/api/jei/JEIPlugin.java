package com.pedruhb.createarmouryweapon.api.jei;

import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.fluids.AllFluids;
import com.pedruhb.createarmouryweapon.fluids.molten.MoltenFluid;
import com.pedruhb.createarmouryweapon.fluids.molten.MoltenFluidHandler;
import com.pedruhb.createarmouryweapon.items.AllItems;
import com.pedruhb.createarmouryweapon.materials.MaterialManager;
import com.pedruhb.createarmouryweapon.materials.serialize.Material;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.helpers.IPlatformFluidHelper;
import mezz.jei.api.registration.IModIngredientRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    public static final ResourceLocation ID = new ResourceLocation(CreateArmouryWeapon.MODID, "jei");
    public static IJeiRuntime runtime;

    @Override
    public void onRuntimeAvailable(IJeiRuntime r) {

        runtime = r;

        Collection<ItemStack> toadd_item = new ArrayList<ItemStack>();
        Collection<FluidStack> toadd_fluid = new ArrayList<FluidStack>();

        for (Material material : MaterialManager.MATERIALS) {

            HashMap<ItemStack, Boolean> parts = new HashMap<ItemStack, Boolean>();

            parts.put(AllItems.PICKAXE_HEAD.asStack(), material.getPickaxePart().isEnabled());
            parts.put(AllItems.TOOL_BINDING.asStack(), material.getToolBinding().isEnabled());
            parts.put(AllItems.TOOL_HANDLE.asStack(), material.getToolHandle().isEnabled());
            parts.put(AllItems.SWORD_BLADE.asStack(), material.getSwordBlade().isEnabled());
            parts.put(AllItems.SWORD_GUARD.asStack(), material.getSwordGuard().isEnabled());
            parts.put(AllItems.AXE_HEAD.asStack(), material.getAxeHead().isEnabled());
            parts.put(AllItems.CLEAVER_BLADE.asStack(), material.getCleaverBlade().isEnabled());
            parts.put(AllItems.LARGE_PLATE.asStack(), material.getLargePlate().isEnabled());
            parts.put(AllItems.TOUGH_HANDLE.asStack(), material.getToughHandle().isEnabled());
            parts.put(AllItems.ROUND_PLATE.asStack(), material.getRoundPlate().isEnabled());
            parts.put(AllItems.BOWSTRING.asStack(), material.getBowString().isEnabled());
            parts.put(AllItems.REPAIR_KIT.asStack(), material.getRepairKit().isEnabled());

            for (Map.Entry<ItemStack, Boolean> part : parts.entrySet()) {

                Boolean partEnabled = part.getValue();
                ItemStack partStack = part.getKey();

                if(!partEnabled) continue;

                CompoundTag material_nbt = new CompoundTag();
                material_nbt.putString("material", material.getName().toLowerCase());

                partStack.setTag(material_nbt);
                partStack.setHoverName(Component.translatable("item.createarmouryweapon." + material.getName().toLowerCase() + "_" + partStack.getItem().toString()));

                toadd_item.add(partStack);

            }

            if(material.isMoltenEnabled()){
                CreateArmouryWeapon.LOGGER.debug("Molten {} is enabled!", material.getName());
                FluidStack fluid = MoltenFluidHandler.getFluidFromMaterial(material);
                toadd_fluid.add(fluid);
            }

        }

        if(toadd_item.size() > 0) runtime.getIngredientManager().addIngredientsAtRuntime(VanillaTypes.ITEM_STACK, toadd_item);
        if(toadd_fluid.size() > 0) runtime.getIngredientManager().addIngredientsAtRuntime(ForgeTypes.FLUID_STACK, toadd_fluid);

    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration r) {
        r.useNbtForSubtypes(AllFluids.MOLTEN.get());
    }

    @Override
    public void registerIngredients(IModIngredientRegistration r) {
    }

    @Override
	public <T> void registerFluidSubtypes(ISubtypeRegistration registration, IPlatformFluidHelper<T> platformFluidHelper) {
		MoltenFluidSubtypeInterpreter interpreter = new MoltenFluidSubtypeInterpreter();
		MoltenFluid moltenFluid = AllFluids.MOLTEN.get();
		registration.registerSubtypeInterpreter(ForgeTypes.FLUID_STACK, moltenFluid.getSource(), interpreter);
		registration.registerSubtypeInterpreter(ForgeTypes.FLUID_STACK, moltenFluid.getFlowing(), interpreter);
	}

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

}