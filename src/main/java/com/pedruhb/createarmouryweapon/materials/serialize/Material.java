package com.pedruhb.createarmouryweapon.materials.serialize;

import com.google.gson.JsonObject;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.serialize.tools.MaterialPart;

public class Material {

    private final boolean enabled;
    private final boolean molten_enabled;
    private final String name;
    private final int tier;
    private int color = 0xFFFFFF;

    private MaterialPart pickaxeHead = null;
    private MaterialPart swordBlade = null;
    private MaterialPart toolHandle = null;
    private MaterialPart toolBinding = null;
    private MaterialPart swordGuard = null;

    public Material(JsonObject json) {

        this.enabled = json.get("enabled").getAsBoolean();
        this.molten_enabled = json.get("molten_enabled").getAsBoolean();
        this.name = json.get("name").getAsString();
        this.tier = json.get("tier").getAsInt();
        this.color = Integer.decode(json.get("color").getAsString());

        if (json.get("parts").getAsJsonObject().get("pickaxe_head").getAsJsonObject().get("enabled").getAsBoolean())
            this.pickaxeHead = new MaterialPart(json.get("parts").getAsJsonObject().get("pickaxe_head").getAsJsonObject());

        if (json.get("parts").getAsJsonObject().get("sword_blade").getAsJsonObject().get("enabled").getAsBoolean())
            this.swordBlade = new MaterialPart(json.get("parts").getAsJsonObject().get("sword_blade").getAsJsonObject());

        if (json.get("parts").getAsJsonObject().get("tool_handle").getAsJsonObject().get("enabled").getAsBoolean())
            this.toolHandle = new MaterialPart(json.get("parts").getAsJsonObject().get("tool_handle").getAsJsonObject());

        if (json.get("parts").getAsJsonObject().get("tool_binding").getAsJsonObject().get("enabled").getAsBoolean())
            this.toolBinding = new MaterialPart(json.get("parts").getAsJsonObject().get("tool_binding").getAsJsonObject());

        if (json.get("parts").getAsJsonObject().get("sword_guard").getAsJsonObject().get("enabled").getAsBoolean())
            this.swordGuard = new MaterialPart(json.get("parts").getAsJsonObject().get("sword_guard").getAsJsonObject());

        CreateArmouryWeapon.LOGGER.info("REGISTRED MATERIAL {}", this.name);

    }

    public String getName() {
        return this.name;
    }

    public int getColor() {
        return this.color;
    }

    public Material getMaterial() {
        return this;
    }

    public MaterialPart getPickaxePart(){
        return this.pickaxeHead;
    }

    public MaterialPart getSwordBlade(){
        return this.swordBlade;
    }
    
    public MaterialPart getToolHandle(){
        return this.toolHandle;
    }
    
    public MaterialPart getToolBinding(){
        return this.toolBinding;
    }

    public MaterialPart getSwordGuard(){
        return this.swordGuard;
    }

}
