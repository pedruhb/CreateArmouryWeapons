package com.pedruhb.createarmouryweapon.materials.serialize.tools;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MaterialPart {

    private boolean enabled;
    private int mining_speed;
    private int attack_speed;
    private int attack_damage;
    private JsonArray traits;

    public MaterialPart(JsonObject json){
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
