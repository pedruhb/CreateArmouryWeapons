package com.pedruhb.createarmouryweapon.materials.serialize;

import com.google.gson.JsonObject;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.serialize.tools.MaterialPickaxeHead;

public class Material {

    private final boolean enabled;
    private final String name;
    private final int tier;
    private int color = 0xFFFFFF;
    private final String ingot_tag = "";

    private final MaterialPickaxeHead pickaxeHead;

    public Material(JsonObject json) {
        
        this.enabled = json.get("enabled").getAsBoolean();
        this.name = json.get("name").getAsString();
        this.tier = json.get("tier").getAsInt();
        this.color = Integer.decode(json.get("base_color").getAsString());

        this.pickaxeHead = new MaterialPickaxeHead(json.get("tools").getAsJsonObject().get("pickaxe").getAsJsonObject());

        CreateArmouryWeapon.LOGGER.info("REGISTRED MATERIAL {}", this.name);

        /// Add tools to creative tabs
    }

    public String getName(){
        return this.name;
    }

    public int getColor(){
        return this.color;
    }

    public Material getMaterial(){
        return this;
    }

}
