package com.pedruhb.createarmouryweapon.materials.serialize.tools;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.datafixers.types.templates.Tag;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.MaterialManager;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class MaterialPart {

    private boolean enabled;
    private int mining_speed;
    private int attack_speed;
    private int attack_damage;
    private JsonArray traits;

    public MaterialPart(String type, JsonObject json){

         this.enabled = json.get("enabled").getAsBoolean();
         this.mining_speed = json.get("mining_speed").getAsInt();
         this.attack_speed = json.get("attack_speed").getAsInt();
         this.attack_damage = json.get("attack_damage").getAsInt();
         this.traits = json.get("traits").getAsJsonArray();



    }

    public JsonArray getTraits() {
        return this.traits;
    }

}
