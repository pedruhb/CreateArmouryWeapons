package com.pedruhb.createarmouryweapon.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class PickaxeHead extends Item {

    public PickaxeHead(Properties properties) {
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
            material = tags.getString("material").substring(0, 1).toUpperCase()
                    + tags.getString("material").substring(1);
        }

        tooltip.add(Component.literal("Material: " + material));

    }
}
