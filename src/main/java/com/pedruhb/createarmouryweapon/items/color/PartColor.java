package com.pedruhb.createarmouryweapon.items.color;

import com.pedruhb.createarmouryweapon.materials.MaterialManager;
import com.pedruhb.createarmouryweapon.materials.serialize.Material;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class PartColor implements ItemColor {

    @Override
    public int getColor(ItemStack stack, int layer) {
       
        CompoundTag tags = stack.getTag();

        if (tags == null) {
            return -1;
        }

        for (Material material : MaterialManager.MATERIALS) {

            if (material.getName().toLowerCase().contains(tags.getString("material").toLowerCase())) {
                 
                return material.getColor();

            }
        }

        return -1; 

    }

}
