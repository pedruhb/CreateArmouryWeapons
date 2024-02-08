package com.pedruhb.createarmouryweapon.materials.serialize.tools;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;

public class MaterialPickaxeHead {

    private boolean enabled;
    private int mining_speed;
    private int attack_speed;
    private int attack_damage;
    private String[] traits;

    public MaterialPickaxeHead(JsonObject json){
         Gson gson = new Gson();
         gson.fromJson(json, MaterialPickaxeHead.class);

         CreateArmouryWeapon.LOGGER.info("Registred Pickaxe!");
    }

}
