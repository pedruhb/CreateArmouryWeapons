package com.pedruhb.createarmouryweapon.api.jei;

import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.MaterialManager;
import com.pedruhb.createarmouryweapon.materials.serialize.Material;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IModIngredientRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

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

        Collection<ItemStack> toadd = new ArrayList<ItemStack>();

        for (Material material : MaterialManager.MATERIALS) {

            HashMap<ItemStack, Boolean> parts = new HashMap<ItemStack, Boolean>();

            parts.put(CreateArmouryWeapon.PICKAXE_HEAD.asStack(), material.getPickaxePart().isEnabled());
            parts.put(CreateArmouryWeapon.TOOL_BINDING.asStack(), material.getToolBinding().isEnabled());
            parts.put(CreateArmouryWeapon.TOOL_HANDLE.asStack(), material.getToolHandle().isEnabled());
            parts.put(CreateArmouryWeapon.SWORD_BLADE.asStack(), material.getSwordBlade().isEnabled());
            parts.put(CreateArmouryWeapon.SWORD_GUARD.asStack(), material.getSwordGuard().isEnabled());

            for (Map.Entry<ItemStack, Boolean> part : parts.entrySet()) {

                Boolean partEnabled = part.getValue();
                ItemStack partStack = part.getKey();

                if(!partEnabled) continue;

                CompoundTag material_nbt = new CompoundTag();
                material_nbt.putString("material", material.getName().toLowerCase());

                partStack.setTag(material_nbt);
                partStack.setHoverName(Component.translatable("item.createarmouryweapon." + material.getName().toLowerCase() + "_" + partStack.getItem().toString()));

                toadd.add(partStack);

            }
            
        }

        r.getIngredientManager().addIngredientsAtRuntime(VanillaTypes.ITEM_STACK, toadd);

    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration r) {
        r.useNbtForSubtypes(CreateArmouryWeapon.PICKAXE_HEAD.asItem());
    }

    @Override
    public void registerIngredients(IModIngredientRegistration r) {
    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

}
