package com.pedruhb.createarmouryweapon.materials.serialize.tools;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MaterialPart {

    private boolean enabled;
    private int mining_speed;
    private int attack_speed;
    private int attack_damage;
    private int durability;
    private JsonArray traits;

    public MaterialPart(String type, JsonObject json){

         this.enabled = json.get("enabled").getAsBoolean();
         this.mining_speed = json.get("mining_speed").getAsInt();
         this.attack_speed = json.get("attack_speed").getAsInt();
         this.attack_damage = json.get("attack_damage").getAsInt();
         this.durability = json.get("durability").getAsInt();
         this.traits = json.get("traits").getAsJsonArray();

    }

    public JsonArray getTraits() {
        return this.traits;
    }

    public boolean isEnabled(){
        return this.enabled;
    }

    public int getMiningSpeed() {
        return this.mining_speed;
    }

    public int getAttackSpeed() {
        return this.attack_speed;
    }

    public int getAttackDamage() {
        return this.attack_damage;
    }

    public int getDurability() {
        return this.durability;
    }

}
