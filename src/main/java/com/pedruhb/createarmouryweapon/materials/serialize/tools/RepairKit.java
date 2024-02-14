package com.pedruhb.createarmouryweapon.materials.serialize.tools;

import com.google.gson.JsonObject;

public class RepairKit {

    private boolean enabled;
    private int durability;

    public RepairKit(JsonObject json){
         this.enabled = json.get("enabled").getAsBoolean();
         this.durability = json.get("durability_amount").getAsInt();
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public int getDurability(){
        return this.durability;
    }

}
