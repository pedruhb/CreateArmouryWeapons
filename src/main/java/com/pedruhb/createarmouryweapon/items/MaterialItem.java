package com.pedruhb.createarmouryweapon.items;

import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.MaterialManager;
import com.pedruhb.createarmouryweapon.materials.serialize.Material;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class MaterialItem extends Item {

    public MaterialItem(Properties properties) {
        super(properties.rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {

        super.appendHoverText(stack, world, tooltip, flag);

        CompoundTag tags = stack.getTag();
        String material;

        if (tags == null || tags.getString("material") == null) {
            material = "Unknown";
        } else {
            material = tags.getString("material").substring(0, 1).toUpperCase() + tags.getString("material").substring(1);
        }

        tooltip.add(Component.literal("Material: " + material));

        if (tags == null)
            return;

        JsonArray partTraitsArray = new JsonArray();

        for (Material material_part : MaterialManager.MATERIALS) {

            if (material_part.getName().toLowerCase().contains(tags.getString("material").toLowerCase())) {

                if (stack.getItem().toString() == "pickaxe_head") {
                    partTraitsArray = material_part.getPickaxePart().getTraits();
                } else if (stack.getItem().toString() == "sword_blade") {
                    partTraitsArray = material_part.getSwordBlade().getTraits();
                } else if (stack.getItem().toString() == "sword_guard") {
                    partTraitsArray = material_part.getSwordGuard().getTraits();
                } else if (stack.getItem().toString() == "tool_binding") {
                    partTraitsArray = material_part.getToolBinding().getTraits();
                } else if (stack.getItem().toString() == "tool_handle") {
                    partTraitsArray = material_part.getToolHandle().getTraits();
                }

                if (partTraitsArray != null) {

                    if(partTraitsArray.size() > 0){
                        tooltip.add(Component.literal(""));
                        tooltip.add(Component.literal("Traits: "));
                    }

                    for (int i = 0; i < partTraitsArray.size(); i++) {
                        tooltip.add(Component.translatable("trait." + CreateArmouryWeapon.MODID + "." + partTraitsArray.get(i).getAsString() + ".name"));
                    }

                }

            }
        }

    }
}
