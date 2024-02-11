package com.pedruhb.createarmouryweapon.materials.serialize;

import com.google.gson.JsonObject;
import com.ibm.icu.impl.coll.Collation;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.api.jei.JEIPlugin;
import com.pedruhb.createarmouryweapon.materials.serialize.tools.MaterialPart;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

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

        if (json.get("parts").getAsJsonObject().get("pickaxe_head").getAsJsonObject().get("enabled").getAsBoolean()){
            this.pickaxeHead = new MaterialPart("pickaxe_head", json.get("parts").getAsJsonObject().get("pickaxe_head").getAsJsonObject());
/* 
            IIngredientManager manager = JEIPlugin.runtime.getIngredientManager();
            Collection<ItemStack> toadd =null;

            CompoundTag item_nbt = new CompoundTag();
            item_nbt.putString("material", this.name.toLowerCase());

            var pick_head = CreateArmouryWeapon.PICKAXE_HEAD.asStack();
            pick_head.setTag(item_nbt);

            toadd.add(pick_head);

            manager.addIngredientsAtRuntime(VanillaTypes.ITEM_STACK, toadd); */
        }

        if (json.get("parts").getAsJsonObject().get("sword_blade").getAsJsonObject().get("enabled").getAsBoolean())
            this.swordBlade = new MaterialPart("sword_blade", json.get("parts").getAsJsonObject().get("sword_blade").getAsJsonObject());

        if (json.get("parts").getAsJsonObject().get("tool_handle").getAsJsonObject().get("enabled").getAsBoolean())
            this.toolHandle = new MaterialPart("tool_handle", json.get("parts").getAsJsonObject().get("tool_handle").getAsJsonObject());

        if (json.get("parts").getAsJsonObject().get("tool_binding").getAsJsonObject().get("enabled").getAsBoolean())
            this.toolBinding = new MaterialPart("tool_binding", json.get("parts").getAsJsonObject().get("tool_binding").getAsJsonObject());

        if (json.get("parts").getAsJsonObject().get("sword_guard").getAsJsonObject().get("enabled").getAsBoolean())
            this.swordGuard = new MaterialPart("tool_binding", json.get("parts").getAsJsonObject().get("sword_guard").getAsJsonObject());

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
