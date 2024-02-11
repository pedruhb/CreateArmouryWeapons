package com.pedruhb.createarmouryweapon.api.jei;

import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.MaterialManager;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IModIngredientRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import java.util.Collection;
import java.util.ArrayList;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    public static final ResourceLocation ID = new ResourceLocation(CreateArmouryWeapon.MODID, "jei");
    public static IJeiRuntime runtime;

    @Override
    public void onRuntimeAvailable(IJeiRuntime r) {
        runtime = r;
        
            Collection<ItemStack> toadd = new ArrayList<ItemStack>();

            CompoundTag item_nbt = new CompoundTag();
            item_nbt.putString("material", "redstone");

            var pick_head = CreateArmouryWeapon.PICKAXE_HEAD.asStack();
            pick_head.setTag(item_nbt);

            toadd.add(pick_head);

            CompoundTag item_nbt2 = new CompoundTag();
            item_nbt2.putString("material", "gold");

            var pick_head2 = CreateArmouryWeapon.PICKAXE_HEAD.asStack();
            pick_head2.setTag(item_nbt2);

            toadd.add(pick_head2);

            r.getIngredientManager().addIngredientsAtRuntime(VanillaTypes.ITEM_STACK, toadd);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration r){
        r.useNbtForSubtypes(CreateArmouryWeapon.PICKAXE_HEAD.asItem());
    }

    @Override
    public void registerIngredients(IModIngredientRegistration r){
    }

    @Override
	public ResourceLocation getPluginUid() {
		return ID;
	}

}
