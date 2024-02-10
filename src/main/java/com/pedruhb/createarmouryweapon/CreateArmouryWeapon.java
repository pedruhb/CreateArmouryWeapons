package com.pedruhb.createarmouryweapon;

import com.mojang.logging.LogUtils;
import com.pedruhb.createarmouryweapon.blocks.CastingDepot.CastingDepotBlock;
import com.pedruhb.createarmouryweapon.blocks.CastingDepot.CastingDepotBlockEntity;
import com.pedruhb.createarmouryweapon.blocks.CastingDepot.CastingDepotRenderer;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankBlock;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankBlockEntity;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankGenerator;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankItem;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankModel;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankRenderer;
import com.pedruhb.createarmouryweapon.items.MaterialItem;
import com.pedruhb.createarmouryweapon.items.color.PartColor;
import com.pedruhb.createarmouryweapon.materials.MaterialManager;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.redstone.displayLink.source.ItemNameDisplaySource;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;


import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.content.redstone.displayLink.AllDisplayBehaviours.assignDataBehaviour;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;


@Mod(CreateArmouryWeapon.MODID)
public class CreateArmouryWeapon
{
    public static final String MODID = "createarmouryweapon";
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);
    public static final TagKey<Block> CAST_TAG = BlockTags.create(new ResourceLocation(MODID, "cast"));

    /* Blocks */
    public static final RegistryObject<Block> GROUT = BLOCKS.register("grout", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(3.0f).friction(0.8F)));
    public static final RegistryObject<Item> GROUT_ITEM = ITEMS.register("grout", () -> new BlockItem(GROUT.get(), new Item.Properties()));

    public static final RegistryObject<Block> NETHER_GROUT = BLOCKS.register("nether_grout", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(3.0f).friction(0.8F)));
    public static final RegistryObject<Item> NETHER_GROUT_ITEM = ITEMS.register("nether_grout", () -> new BlockItem(NETHER_GROUT.get(), new Item.Properties()));

    /* Ores */
    public static final RegistryObject<Block> ARDITE_ORE = BLOCKS.register("ardite_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops().strength(10.0F)));
    public static final RegistryObject<Item> ARDITE_ORE_ITEM = ITEMS.register("ardite_ore", () -> new BlockItem(ARDITE_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAW_ARDITE = ITEMS.register("raw_ardite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARDITE_INGOT = ITEMS.register("ardite_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARDITE_NUGGET = ITEMS.register("ardite_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Block> ARDITE_BLOCK = BLOCKS.register("ardite_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(6.0f, 7.0f)));
    public static final RegistryObject<Item> ARDITE_BLOCK_ITEM = ITEMS.register("ardite_block", () -> new BlockItem(ARDITE_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops().strength(10.0F)));
    public static final RegistryObject<Item> COBALT_ORE_ITEM = ITEMS.register("cobalt_ore", () -> new BlockItem(COBALT_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAW_COBALT = ITEMS.register("raw_cobalt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Block> COBALT_BLOCK = BLOCKS.register("cobalt_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(6.0f, 7.0f)));
    public static final RegistryObject<Item> COBALT_BLOCK_ITEM = ITEMS.register("cobalt_block", () -> new BlockItem(COBALT_BLOCK.get(), new Item.Properties()));

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
    public static final RegistryObject<Block> SEARED_BRICKS = BLOCKS.register("seared_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_BRICKS_ITEM = ITEMS.register("seared_bricks", () -> new BlockItem(SEARED_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_COBBLE = BLOCKS.register("seared_cobble", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_COBBLE_ITEM = ITEMS.register("seared_cobble", () -> new BlockItem(SEARED_COBBLE.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_CRACKED_BRICKS = BLOCKS.register("seared_cracked_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_CRACKED_BRICKS_ITEM = ITEMS.register("seared_cracked_bricks", () -> new BlockItem(SEARED_CRACKED_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_CREEPER = BLOCKS.register("seared_creeper", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_CREEPER_ITEM = ITEMS.register("seared_creeper", () -> new BlockItem(SEARED_CREEPER.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_FANCY_BRICKS = BLOCKS.register("seared_fancy_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_FANCY_BRICKS_ITEM = ITEMS.register("seared_fancy_bricks", () -> new BlockItem(SEARED_FANCY_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_LADDER = BLOCKS.register("seared_ladder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_LADDER_ITEM = ITEMS.register("seared_ladder", () -> new BlockItem(SEARED_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_PAVER = BLOCKS.register("seared_paver", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_PAVER_ITEM = ITEMS.register("seared_paver", () -> new BlockItem(SEARED_PAVER.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_PAVER_SLAB = BLOCKS.register("seared_paver_slab", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_PAVER_SLAB_ITEM = ITEMS.register("seared_paver_slab", () -> new BlockItem(SEARED_PAVER_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_ROAD = BLOCKS.register("seared_road", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_ROAD_ITEM = ITEMS.register("seared_road", () -> new BlockItem(SEARED_ROAD.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_SMALL_BRICKS = BLOCKS.register("seared_small_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_SMALL_BRICKS_ITEM = ITEMS.register("seared_small_bricks", () -> new BlockItem(SEARED_SMALL_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_SQUARE_BRICKS = BLOCKS.register("seared_square_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_SQUARE_BRICKS_ITEM = ITEMS.register("seared_square_bricks", () -> new BlockItem(SEARED_SQUARE_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_STONE = BLOCKS.register("seared_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_STONE_ITEM = ITEMS.register("seared_stone", () -> new BlockItem(SEARED_STONE.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_TILE = BLOCKS.register("seared_tile", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_TILE_ITEM = ITEMS.register("seared_tile", () -> new BlockItem(SEARED_TILE.get(), new Item.Properties()));
    public static final RegistryObject<Block> SEARED_TRIANGLE_BRICKS = BLOCKS.register("seared_triangle_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SEARED_TRIANGLE_BRICKS_ITEM = ITEMS.register("seared_triangle_bricks", () -> new BlockItem(SEARED_TRIANGLE_BRICKS.get(), new Item.Properties()));
    
    /* SCORCHED */
    public static final RegistryObject<Item> SCORCHED_BRICK = ITEMS.register("scorched_brick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Block> SCORCHED_STONE = BLOCKS.register("scorched_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.BASALT).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SCORCHED_STONE_ITEM = ITEMS.register("scorched_stone", () -> new BlockItem(SCORCHED_STONE.get(), new Item.Properties()));
    public static final RegistryObject<Block> SCORCHED_BRICKS = BLOCKS.register("scorched_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.BASALT).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SCORCHED_BRICKS_ITEM = ITEMS.register("scorched_bricks", () -> new BlockItem(SCORCHED_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Block> SCORCHED_CHISELED = BLOCKS.register("scorched_chiseled", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.BASALT).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SCORCHED_CHISELED_ITEM = ITEMS.register("scorched_chiseled", () -> new BlockItem(SCORCHED_CHISELED.get(), new Item.Properties()));
    public static final RegistryObject<Block> SCORCHED_LADDER = BLOCKS.register("scorched_ladder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.BASALT).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SCORCHED_LADDER_ITEM = ITEMS.register("scorched_ladder", () -> new BlockItem(SCORCHED_LADDER.get(), new Item.Properties()));
    public static final RegistryObject<Block> SCORCHED_POLISHED = BLOCKS.register("scorched_polished", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.BASALT).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SCORCHED_POLISHED_ITEM = ITEMS.register("scorched_polished", () -> new BlockItem(SCORCHED_POLISHED.get(), new Item.Properties()));
    public static final RegistryObject<Block> SCORCHED_ROAD = BLOCKS.register("scorched_road", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.BASALT).requiresCorrectToolForDrops().strength(8.0F, 28F)));
    public static final RegistryObject<Item> SCORCHED_ROAD_ITEM = ITEMS.register("scorched_road", () -> new BlockItem(SCORCHED_ROAD.get(), new Item.Properties()));

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

    /* FOOD */
    public static final RegistryObject<Item> BACON = ITEMS.register("bacon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(2f).build())));
    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(2f).build())));

    /* PARTS */
    //public static final RegistryObject<Item> TOOL_HANDLE = ITEMS.register("tool_handle", () -> new Item(new Item.Properties()));
    //public static final RegistryObject<Item> SWORD_BLADE = ITEMS.register("sword_blade", () -> new Item(new Item.Properties()));
    //public static final RegistryObject<Item> SWORD_GUARD = ITEMS.register("sword_guard", () -> new Item(new Item.Properties()));
    //public static final RegistryObject<Item> PICKAXE_HEAD = ITEMS.register("pickaxe_head", () -> new PickaxeHead(new Item.Properties()));
    //public static final RegistryObject<Item> TOOL_BINDING = ITEMS.register("tool_binding", () -> new Item(new Item.Properties()));

    public static final ItemEntry<MaterialItem> PICKAXE_HEAD =
    REGISTRATE.item("pickaxe_head", MaterialItem::new)
        .properties(p -> p.rarity(Rarity.UNCOMMON))
        .model(AssetLookup.existingItemModel())
        .color(() -> PartColor::new)
        .register();

    public static final ItemEntry<MaterialItem> TOOL_BINDING =
    REGISTRATE.item("tool_binding", MaterialItem::new)
        .properties(p -> p.rarity(Rarity.UNCOMMON))
        .model(AssetLookup.existingItemModel())
        .color(() -> PartColor::new)
        .register();

    public static final ItemEntry<MaterialItem> TOOL_HANDLE =
    REGISTRATE.item("tool_handle", MaterialItem::new)
        .properties(p -> p.rarity(Rarity.UNCOMMON))
        .model(AssetLookup.existingItemModel())
        .color(() -> PartColor::new)
        .register();

    public static final ItemEntry<MaterialItem> SWORD_BLADE =
    REGISTRATE.item("sword_blade", MaterialItem::new)
        .properties(p -> p.rarity(Rarity.UNCOMMON))
        .model(AssetLookup.existingItemModel())
        .color(() -> PartColor::new)
        .register();

    public static final ItemEntry<MaterialItem> SWORD_GUARD =
        REGISTRATE.item("sword_guard", MaterialItem::new)
        .properties(p -> p.rarity(Rarity.UNCOMMON))
        .model(AssetLookup.existingItemModel())
        .color(() -> PartColor::new)
        .register();

    /* CASINGS */
    public static final BlockEntry<CasingBlock> SEARED_CASING = REGISTRATE.block("seared_casing", CasingBlock::new)
	.transform(BuilderTransformers.casing(() -> CAWSpriteShifts.SEARED_CASING))
	.properties(p -> p.mapColor(MapColor.COLOR_BLACK))
	.properties(p -> p.strength(55.0F, 1200.0F))
	.properties(p -> p.sound(SoundType.STONE))
	.transform(pickaxeOnly())
	.register();
    
    public static final BlockEntry<CasingBlock> SCORCHED_CASING = REGISTRATE.block("scorched_casing", CasingBlock::new)
    .transform(BuilderTransformers.casing(() -> CAWSpriteShifts.SCORCHED_CASING))
    .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
    .properties(p -> p.strength(55.0F, 1200.0F))
    .properties(p -> p.sound(SoundType.STONE))
    .transform(pickaxeOnly())
    .register();

    /* Casting Depot */
    public static final BlockEntry<CastingDepotBlock> CASTING_DEPOT = REGISTRATE.block("casting_depot", CastingDepotBlock::new)
	.initialProperties(SharedProperties::stone)
	.properties(p -> p.mapColor(MapColor.COLOR_GRAY).noOcclusion())
    .transform(axeOrPickaxe())
	.blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
	.onRegister(assignDataBehaviour(new ItemNameDisplaySource(), "combine_item_names"))
	.item()
	.transform(customItemModel("_", "block"))
	.register();

    public static final BlockEntityEntry<CastingDepotBlockEntity> CASTING_DEPOT_ENTITY = REGISTRATE.blockEntity("casting_depot", CastingDepotBlockEntity::new)
	.validBlocks(CreateArmouryWeapon.CASTING_DEPOT)
	.renderer(() -> CastingDepotRenderer::new)
	.register();

    /* Seared Fluid Tank */
    public static final BlockEntry<SearedFluidTankBlock> SEARED_TANK = REGISTRATE.block("seared_tank", SearedFluidTankBlock::regular)
    .initialProperties(SharedProperties::copperMetal)
    .properties(p -> p.noOcclusion().isRedstoneConductor((p1, p2, p3) -> true))
    .properties(p -> p.isRedstoneConductor((p1, p2, p3) -> true))
    .transform(pickaxeOnly())
    .blockstate(new SearedFluidTankGenerator()::generate)
    .onRegister(CreateRegistrate.blockModel(() -> SearedFluidTankModel::standard))
    .addLayer(() -> RenderType::cutoutMipped)
    .item(SearedFluidTankItem::new)
    .model(AssetLookup.customBlockItemModel("_", "block_single_window"))
    .build()
    .register();

    public static final BlockEntityEntry<SearedFluidTankBlockEntity> SEARED_TANK_ENTITY = REGISTRATE
	.blockEntity("seared_tank", SearedFluidTankBlockEntity::new)
	.validBlocks(SEARED_TANK)
	.renderer(() -> SearedFluidTankRenderer::new)
	.register();

    /* ... */
    public static final RegistryObject<CreativeModeTab> CREATE_AW_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> BACON.get().getDefaultInstance())
            .title(Component.translatable(MODID))
            .build());

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == this.CREATE_AW_TAB.getKey()){
            event.accept(BACON);
            event.accept(FRIED_EGG);

            event.accept(GROUT);
            event.accept(NETHER_GROUT);

            event.accept(ARDITE_ORE);
            event.accept(RAW_ARDITE);
            event.accept(ARDITE_INGOT);
            event.accept(ARDITE_NUGGET);
            event.accept(ARDITE_BLOCK);

            event.accept(COBALT_ORE);
            event.accept(RAW_COBALT);
            event.accept(COBALT_INGOT);
            event.accept(COBALT_NUGGET);
            event.accept(COBALT_BLOCK);

            event.accept(CAST_BLANK);
            event.accept(CAST_BOW_GRIP);
            event.accept(CAT_BOW_LIMB);
            event.accept(CAST_BOWSTRING);
            event.accept(CAST_BROAD_AXE_HEAD);
            event.accept(CAST_BROAD_BLADE);
            event.accept(CAST_COIN);
            event.accept(CAST_GEAR);
            event.accept(CAST_GEM);
            event.accept(CAST_HAMMER_HEAD);
            event.accept(CAST_INGOT);
            event.accept(CAST_LARGE_PLATE);
            event.accept(CAST_NUGGET);
            event.accept(CAST_PICKAXE_HEAD);
            event.accept(CAST_PLATE);
            event.accept(CAST_REPAIR_KIT);
            event.accept(CAST_ROD);
            event.accept(CAST_ROUND_PLATE);
            event.accept(CAST_SMALL_AXE_HEAD);
            event.accept(CAST_SMALL_BLADE);
            event.accept(CAST_TOOL_BINDING);
            event.accept(CAST_TOOL_HANDLE);
            event.accept(CAST_TOUGH_HANDLE);
            event.accept(CAST_WIRE);

            event.accept(SEARED_BRICK);
            event.accept(SEARED_BRICKS);
            event.accept(SEARED_COBBLE);
            event.accept(SEARED_CRACKED_BRICKS);
            event.accept(SEARED_CREEPER);
            event.accept(SEARED_FANCY_BRICKS);
            event.accept(SEARED_LADDER);
            event.accept(SEARED_PAVER);
            event.accept(SEARED_PAVER_SLAB);
            event.accept(SEARED_ROAD);
            event.accept(SEARED_SMALL_BRICKS);
            event.accept(SEARED_SQUARE_BRICKS);
            event.accept(SEARED_STONE);
            event.accept(SEARED_TILE);
            event.accept(SEARED_TRIANGLE_BRICKS);

            event.accept(SCORCHED_BRICK);
            event.accept(SCORCHED_BRICKS);
            event.accept(SCORCHED_CHISELED);
            event.accept(SCORCHED_LADDER);
            event.accept(SCORCHED_POLISHED);
            event.accept(SCORCHED_ROAD);
            event.accept(SCORCHED_STONE);

            event.accept(REINFORCEMENT_BASE);
            event.accept(REINFORCEMENT_BRONZE);
            event.accept(REINFORCEMENT_COBALT);
            event.accept(REINFORCEMENT_EMERALD);
            event.accept(REINFORCEMENT_GOLD);
            event.accept(REINFORCEMENT_IRON);
            event.accept(REINFORCEMENT_SEARED);
            event.accept(REINFORCEMENT_SLIMESTEEL);

            event.accept(DEBRIS_NUGGET);
            event.accept(NETHERITE_NUGGET);

            event.accept(SEARED_CASING.get());
            event.accept(SCORCHED_CASING.get());
            event.accept(CASTING_DEPOT.get());
            event.accept(SEARED_TANK.get());

            event.accept(SWORD_BLADE.get());
            event.accept(SWORD_GUARD.get());
            event.accept(TOOL_BINDING.get());
            event.accept(TOOL_HANDLE.get());
            event.accept(PICKAXE_HEAD.get());
        }
    }

    public CreateArmouryWeapon()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    public static ResourceLocation getResource(String name) {
        return new ResourceLocation(MODID, name);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        MaterialManager.load(event.getServer().getResourceManager());
    }

}
