package com.pedruhb.createarmouryweapon.items;

import static com.pedruhb.createarmouryweapon.CreateArmouryWeapon.REGISTRATE;

import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.items.color.PartColor;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateArmouryWeapon.MODID);

        /* Ores */
        public static final RegistryObject<Item> RAW_ARDITE = ITEMS.register("raw_ardite", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ARDITE_INGOT = ITEMS.register("ardite_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ARDITE_NUGGET = ITEMS.register("ardite_nugget", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_COBALT = ITEMS.register("raw_cobalt", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget", () -> new Item(new Item.Properties()));

        /* NUGGETS */
        public static final RegistryObject<Item> DEBRIS_NUGGET = ITEMS.register("debris_nugget", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties()));

        /* REINFORCEMENT */
        public static final RegistryObject<Item> REINFORCEMENT_BASE = ITEMS.register("reinforcement_base", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> REINFORCEMENT_BRONZE = ITEMS.register("reinforcement_bronze", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> REINFORCEMENT_COBALT = ITEMS.register("reinforcement_cobalt", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> REINFORCEMENT_EMERALD = ITEMS.register("reinforcement_emerald", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> REINFORCEMENT_GOLD = ITEMS.register("reinforcement_gold", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> REINFORCEMENT_IRON = ITEMS.register("reinforcement_iron", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> REINFORCEMENT_SEARED = ITEMS.register("reinforcement_seared", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> REINFORCEMENT_SLIMESTEEL = ITEMS.register("reinforcement_slimesteel", () -> new Item(new Item.Properties()));

        /* SEARED */
        public static final RegistryObject<Item> SEARED_BRICK = ITEMS.register("seared_brick", () -> new Item(new Item.Properties()));

         /* CAST */
        public static final RegistryObject<Item> CAST_BLANK = ITEMS.register("cast_blank", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_BOW_GRIP = ITEMS.register("cast_bow_grip", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAT_BOW_LIMB = ITEMS.register("cast_bow_limb", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_BOWSTRING = ITEMS.register("cast_bowstring", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_BROAD_AXE_HEAD = ITEMS.register("cast_broad_axe_head", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_BROAD_BLADE = ITEMS.register("cast_broad_blade", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_COIN = ITEMS.register("cast_coin", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_GEAR = ITEMS.register("cast_gear", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_GEM = ITEMS.register("cast_gem", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_HAMMER_HEAD = ITEMS.register("cast_hammer_head", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_INGOT = ITEMS.register("cast_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_LARGE_PLATE = ITEMS.register("cast_large_plate", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_NUGGET = ITEMS.register("cast_nugget", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_PICKAXE_HEAD = ITEMS.register("cast_pickaxe_head", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_PLATE = ITEMS.register("cast_plate", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_REPAIR_KIT = ITEMS.register("cast_repair_kit", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_ROD = ITEMS.register("cast_rod", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_ROUND_PLATE = ITEMS.register("cast_round_plate", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_SMALL_AXE_HEAD = ITEMS.register("cast_small_axe_head", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_SMALL_BLADE = ITEMS.register("cast_small_blade", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_TOOL_BINDING = ITEMS.register("cast_tool_binding", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_TOOL_HANDLE = ITEMS.register("cast_tool_handle", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_TOUGH_HANDLE = ITEMS.register("cast_tough_handle", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_WIRE = ITEMS.register("cast_wire", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> CAST_SWORD_GUARD = ITEMS.register("cast_sword_guard", () -> new Item(new Item.Properties()));

        /* FOOD */
        public static final RegistryObject<Item> BACON = ITEMS.register("bacon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(2f).build())));
        public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(2f).build())));

        /* PARTS */
        public static final ItemEntry<MaterialItem> PICKAXE_HEAD = REGISTRATE.item("pickaxe_head", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> TOOL_BINDING = REGISTRATE.item("tool_binding", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> TOOL_HANDLE = REGISTRATE.item("tool_handle", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> SWORD_BLADE = REGISTRATE.item("sword_blade", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> SWORD_GUARD = REGISTRATE.item("sword_guard", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> AXE_HEAD = REGISTRATE.item("axe_head", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> CLEAVER_BLADE = REGISTRATE.item("cleaver_blade", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> LARGE_PLATE = REGISTRATE.item("large_plate", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> TOUGH_HANDLE = REGISTRATE.item("tough_handle", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> ROUND_PLATE = REGISTRATE.item("round_plate", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<MaterialItem> BOWSTRING = REGISTRATE.item("bowstring", MaterialItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

        public static final ItemEntry<RepairKitItem> REPAIR_KIT = REGISTRATE.item("repair_kit", RepairKitItem::new)
                .properties(p -> p.rarity(Rarity.UNCOMMON))
                .model(AssetLookup.existingItemModel())
                .color(() -> PartColor::new)
                .register();

}
