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

public class RepairKitItem extends Item {

    public RepairKitItem(Properties properties) {
        super(properties.rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {

        super.appendHoverText(stack, world, tooltip, flag);

        CompoundTag tags = stack.getTag();
        String material;

        if (tags == null || tags.getString("material") == null) {
            material = Component.translatable("generic.createarmouryweapon.unknown").getString();
        } else {
            material = Component.translatable("material.createarmouryweapon." + tags.getString("material")).getString();
        }

        tooltip.add(Component.literal(Component.translatable("generic.createarmouryweapon.material").getString() + ": " + material));

    }
}
