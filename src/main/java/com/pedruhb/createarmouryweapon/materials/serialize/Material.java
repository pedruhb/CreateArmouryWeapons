package com.pedruhb.createarmouryweapon.materials.serialize;

import java.math.BigInteger;

import com.google.gson.JsonObject;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.serialize.tools.MaterialPart;
import com.pedruhb.createarmouryweapon.materials.serialize.tools.RepairKit;

public class Material {

    private final boolean enabled;
    private final String name;
    private final int tier;
    private int color = 0xFFFFFF; 

    private final boolean molten_enabled;
    private int molten_color = 0xFFff0000;

    private MaterialPart pickaxeHead = null;
    private MaterialPart swordBlade = null;
    private MaterialPart toolHandle = null;
    private MaterialPart toolBinding = null;
    private MaterialPart swordGuard = null;
    private MaterialPart axeHead = null;
    private MaterialPart cleaverBlade = null;
    private MaterialPart largePlate = null;
    private MaterialPart toughHandle = null;
    private MaterialPart roundPlate = null;
    private MaterialPart bowString = null;

    private RepairKit repairKit = null;

    public Material(JsonObject json) {

        this.enabled = json.get("enabled").getAsBoolean();
        this.name = json.get("name").getAsString();
        this.tier = json.get("tier").getAsInt();
        this.color = Integer.decode(json.get("color").getAsString());

        this.molten_enabled = json.get("molten_enabled").getAsBoolean();

        Long longMoltenColor = CreateArmouryWeapon.convertString2Hex(json.get("molten_color").getAsString());
        this.molten_color = longMoltenColor.intValue();

        this.repairKit = new RepairKit(json.get("repair_kit").getAsJsonObject());

        this.pickaxeHead = new MaterialPart("pickaxe_head", json.get("parts").getAsJsonObject().get("pickaxe_head").getAsJsonObject());
        this.swordBlade = new MaterialPart("sword_blade", json.get("parts").getAsJsonObject().get("sword_blade").getAsJsonObject());
        this.swordGuard = new MaterialPart("sword_guard", json.get("parts").getAsJsonObject().get("sword_guard").getAsJsonObject());
        this.toolHandle = new MaterialPart("tool_handle", json.get("parts").getAsJsonObject().get("tool_handle").getAsJsonObject());
        this.toolBinding = new MaterialPart("tool_binding", json.get("parts").getAsJsonObject().get("tool_binding").getAsJsonObject());
        this.axeHead = new MaterialPart("axe_head", json.get("parts").getAsJsonObject().get("axe_head").getAsJsonObject());
        this.cleaverBlade = new MaterialPart("cleaver_blade", json.get("parts").getAsJsonObject().get("cleaver_blade").getAsJsonObject());
        this.largePlate = new MaterialPart("large_plate", json.get("parts").getAsJsonObject().get("large_plate").getAsJsonObject());
        this.toughHandle = new MaterialPart("tough_handle", json.get("parts").getAsJsonObject().get("tough_handle").getAsJsonObject());
        this.bowString = new MaterialPart("bowstring", json.get("parts").getAsJsonObject().get("bowstring").getAsJsonObject());
        this.roundPlate = new MaterialPart("round_plate", json.get("parts").getAsJsonObject().get("round_plate").getAsJsonObject());

        CreateArmouryWeapon.LOGGER.debug("REGISTRED MATERIAL {}", this.name);

    }

    public Boolean isEnabled(){
        return this.enabled;
    }

    public String getName() {
        return this.name;
    }

    public int getColor() {
        return this.color;
    }

    public int getTier() {
        return this.tier;
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

    public MaterialPart getAxeHead(){
        return this.axeHead;
    }

    public MaterialPart getCleaverBlade(){
        return this.cleaverBlade;
    }

    public MaterialPart getLargePlate(){
        return this.largePlate;
    }

    public MaterialPart getToughHandle(){
        return this.toughHandle;
    }

    public MaterialPart getRoundPlate(){
        return this.roundPlate;
    }

    public MaterialPart getBowString(){
        return this.bowString;
    }

    public RepairKit getRepairKit(){
        return this.repairKit;
    }

    public Boolean isMoltenEnabled(){
        return this.molten_enabled;
    }

    public int getMoltenColor(){
        return this.molten_color;
    }

}
