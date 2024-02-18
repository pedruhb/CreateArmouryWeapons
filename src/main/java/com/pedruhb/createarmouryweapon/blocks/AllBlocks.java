package com.pedruhb.createarmouryweapon.blocks;

import static com.pedruhb.createarmouryweapon.CreateArmouryWeapon.REGISTRATE;

import static com.simibubi.create.content.redstone.displayLink.AllDisplayBehaviours.assignDataBehaviour;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.blocks.CastingDepot.CastingDepotBlock;
import com.pedruhb.createarmouryweapon.blocks.CastingDepot.CastingDepotBlockEntity;
import com.pedruhb.createarmouryweapon.blocks.CastingDepot.CastingDepotRenderer;
import com.pedruhb.createarmouryweapon.blocks.SearedPipe.SearedPipeBlockStateGen;
import com.pedruhb.createarmouryweapon.blocks.SearedPipe.SearedPipeAttachmentModel;
import com.pedruhb.createarmouryweapon.blocks.SearedPipe.SearedPipeBlock;
import com.pedruhb.createarmouryweapon.blocks.SearedPipe.SearedPipeBlockEntity;
import com.pedruhb.createarmouryweapon.blocks.SearedSpout.SearedSpoutBlock;
import com.pedruhb.createarmouryweapon.blocks.SearedSpout.SearedSpoutBlockEntity;
import com.pedruhb.createarmouryweapon.blocks.SearedSpout.SearedSpoutRenderer;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankBlock;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankBlockEntity;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankGenerator;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankItem;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankModel;
import com.pedruhb.createarmouryweapon.blocks.SearedTank.SearedFluidTankRenderer;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.fluids.PipeAttachmentModel;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlock;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlockEntity;
import com.simibubi.create.content.fluids.spout.SpoutBlock;
import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.simibubi.create.content.fluids.spout.SpoutRenderer;
import com.simibubi.create.content.processing.AssemblyOperatorBlockItem;
import com.simibubi.create.content.redstone.displayLink.source.ItemNameDisplaySource;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllBlocks {

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateArmouryWeapon.MODID);
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateArmouryWeapon.MODID);

        public static final RegistryObject<Block> COBALT_BLOCK = BLOCKS.register("cobalt_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(6.0f, 7.0f)));
        public static final RegistryObject<Item> COBALT_BLOCK_ITEM = ITEMS.register("cobalt_block", () -> new BlockItem(COBALT_BLOCK.get(), new Item.Properties()));

        public static final RegistryObject<Block> ARDITE_ORE = BLOCKS.register("ardite_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops().strength(10.0F)));
        public static final RegistryObject<Item> ARDITE_ORE_ITEM = ITEMS.register("ardite_ore", () -> new BlockItem(ARDITE_ORE.get(), new Item.Properties()));

        public static final RegistryObject<Block> ARDITE_BLOCK = BLOCKS.register("ardite_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(6.0f, 7.0f)));
        public static final RegistryObject<Item> ARDITE_BLOCK_ITEM = ITEMS.register("ardite_block", () -> new BlockItem(ARDITE_BLOCK.get(), new Item.Properties()));

        public static final RegistryObject<Block> RAW_ARDITE_BLOCK = BLOCKS.register("raw_ardite_block", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(10.0F)));
        public static final RegistryObject<Item> RAW_ARDITE_BLOCK_ITEM = ITEMS.register("raw_ardite_block", () -> new BlockItem(RAW_ARDITE_BLOCK.get(), new Item.Properties()));

        public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops().strength(10.0F)));
        public static final RegistryObject<Item> COBALT_ORE_ITEM = ITEMS.register("cobalt_ore", () -> new BlockItem(COBALT_ORE.get(), new Item.Properties()));

        public static final RegistryObject<Block> RAW_COBALT_BLOCK = BLOCKS.register("raw_cobalt_block", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(10.0F)));
        public static final RegistryObject<Item> RAW_COBALT_BLOCK_ITEM = ITEMS.register("raw_cobalt_block", () -> new BlockItem(RAW_COBALT_BLOCK.get(), new Item.Properties()));

        public static final RegistryObject<Block> GROUT = BLOCKS.register("grout", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(3.0f).friction(0.8F)));
        public static final RegistryObject<Item> GROUT_ITEM = ITEMS.register("grout", () -> new BlockItem(GROUT.get(), new Item.Properties()));

        public static final RegistryObject<Block> NETHER_GROUT = BLOCKS.register("nether_grout", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(3.0f).friction(0.8F)));
        public static final RegistryObject<Item> NETHER_GROUT_ITEM = ITEMS.register("nether_grout", () -> new BlockItem(NETHER_GROUT.get(), new Item.Properties()));

        /* Seared */
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
        public static final RegistryObject<Block> SEARED_SMALL_BRICKS = BLOCKS.register("seared_small_bricks",() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(8.0F, 28F)));
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

        public static final BlockEntityEntry<SearedFluidTankBlockEntity> SEARED_TANK_ENTITY = REGISTRATE.blockEntity("seared_tank", SearedFluidTankBlockEntity::new)
                .validBlocks(SEARED_TANK)
                .renderer(() -> SearedFluidTankRenderer::new)
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
                .validBlocks(CASTING_DEPOT)
                .renderer(() -> CastingDepotRenderer::new)
                .register();

        /* Seared Spout */
        public static final BlockEntry<SearedSpoutBlock> SEARED_SPOUT = REGISTRATE.block("seared_spout", SearedSpoutBlock::new)
	        .initialProperties(SharedProperties::copperMetal)
	        .transform(pickaxeOnly())
	        .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), AssetLookup.partialBaseModel(ctx, prov)))
	        .addLayer(() -> RenderType::cutoutMipped)
	        .item(AssemblyOperatorBlockItem::new)
	        .transform(customItemModel())
	        .register();

        public static final BlockEntityEntry<SearedSpoutBlockEntity> SEARED_SPOUT_ENTITY = REGISTRATE.blockEntity("seared_spout", SearedSpoutBlockEntity::new)
	        .validBlocks(SEARED_SPOUT)
	        .renderer(() -> SearedSpoutRenderer::new)
	        .register();


        /* Seared Pipe  */
        public static final BlockEntry<SearedPipeBlock> SEARED_PIPE = REGISTRATE.block("seared_pipe", SearedPipeBlock::new)
                .initialProperties(SharedProperties::copperMetal)
                .properties(p -> p.forceSolidOn())
                .transform(pickaxeOnly())
                .blockstate(SearedPipeBlockStateGen.pipe())
                .onRegister(CreateRegistrate.blockModel(() -> SearedPipeAttachmentModel::new))
                .item()
                .transform(customItemModel())
                .register();

        public static final BlockEntityEntry<SearedPipeBlockEntity> SEARED_PIPE_ENTITY = REGISTRATE.blockEntity("seared_pipe", SearedPipeBlockEntity::new)
		.validBlocks(SEARED_PIPE)
		.register();
}

