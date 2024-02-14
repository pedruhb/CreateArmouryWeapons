package com.pedruhb.createarmouryweapon.items;

import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.MaterialManager;
import com.pedruhb.createarmouryweapon.materials.serialize.Material;
import com.pedruhb.createarmouryweapon.materials.serialize.tools.MaterialPart;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

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
            material = Component.translatable("generic.createarmouryweapon.unknown").getString();
        } else {
            material = Component.translatable("material.createarmouryweapon." + tags.getString("material")).getString();
        }

        tooltip.add(Component.literal(Component.translatable("generic.createarmouryweapon.material").getString() + ": " + material));

        if (tags == null)
            return;

        JsonArray partTraitsArray = new JsonArray();

        for (Material material_part : MaterialManager.MATERIALS) {

            if (material_part.getName().toLowerCase().equals(tags.getString("material").toLowerCase())) {

                int attack_damage = 0;
                int attack_speed = 0;
                int mining_speed = 0;
                int tier = material_part.getTier();
                int durability = 0;

                HashMap<String, MaterialPart> parts = new HashMap<String, MaterialPart>();

                parts.put("pickaxe_head", material_part.getPickaxePart());
                parts.put("sword_blade", material_part.getSwordBlade());
                parts.put("sword_guard", material_part.getSwordGuard());
                parts.put("tool_binding", material_part.getToolBinding());
                parts.put("tool_handle", material_part.getToolHandle());

                for (Map.Entry<String, MaterialPart> part : parts.entrySet()) {
                    if (stack.getItem().toString() == part.getKey()) {
                        partTraitsArray = part.getValue().getTraits();
                        attack_damage = part.getValue().getAttackDamage();
                        attack_speed = part.getValue().getAttackSpeed();
                        mining_speed = part.getValue().getMiningSpeed();
                        durability = part.getValue().getDurability();
                    }
                }

                tooltip.add(Component.literal(""));
                tooltip.add(Component.literal(Component.translatable("generic.createarmouryweapon.stats").getString() + ": "));
                tooltip.add(Component.literal(Component.translatable("stats.createarmouryweapon.tier").getString() + ": " + tier));
                tooltip.add(Component.literal(Component.translatable("stats.createarmouryweapon.durability").getString() + ": " + durability));
                tooltip.add(Component.literal(Component.translatable("stats.createarmouryweapon.attack_damage").getString() + ": " + attack_damage));
                tooltip.add(Component.literal(Component.translatable("stats.createarmouryweapon.attack_speed").getString() + ": " + attack_speed));
                tooltip.add(Component.literal(Component.translatable("stats.createarmouryweapon.mining_speed").getString() + ": " + mining_speed));

                if (partTraitsArray != null) {

                    if (partTraitsArray.size() > 0) {
                        tooltip.add(Component.literal(""));
                        tooltip.add(Component.literal(Component.translatable("generic.createarmouryweapon.traits").getString() + ": "));
                    }

                    for (int i = 0; i < partTraitsArray.size(); i++) {
                        tooltip.add(Component.translatable("trait." + CreateArmouryWeapon.MODID + "." + partTraitsArray.get(i).getAsString() + ".name"));
                    }

                }

            }
        }

    }
}
