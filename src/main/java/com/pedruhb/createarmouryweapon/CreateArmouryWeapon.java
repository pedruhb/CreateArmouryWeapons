package com.pedruhb.createarmouryweapon;

import com.mojang.logging.LogUtils;

import com.pedruhb.createarmouryweapon.blocks.AllBlocks;
import com.pedruhb.createarmouryweapon.blocks.AllPartialModels;
import com.pedruhb.createarmouryweapon.fluids.AllFluids;
import com.pedruhb.createarmouryweapon.materials.MaterialManager;
import com.pedruhb.createarmouryweapon.recipes.AllRecipeTypes;
import com.pedruhb.createarmouryweapon.items.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.network.chat.Component;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import org.slf4j.Logger;

@Mod(CreateArmouryWeapon.MODID)
public class CreateArmouryWeapon {

        public static final String MODID = "createarmouryweapon";

        public static final Logger LOGGER = LogUtils.getLogger();

        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, MODID);
        public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);

        public static final RegistryObject<CreativeModeTab> CREATE_AW_TAB = CREATIVE_MODE_TABS.register("create_aw_tab",
                        () -> CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.COMBAT)
                                        .icon(() -> AllItems.BACON.get().getDefaultInstance())
                                        .title(Component.translatable(MODID)).build());

        private void addCreative(BuildCreativeModeTabContentsEvent event) {

                if (event.getTabKey() == this.CREATE_AW_TAB.getKey()) {

                        event.accept(AllItems.BACON);
                        event.accept(AllItems.FRIED_EGG);

                        event.accept(AllBlocks.GROUT);
                        event.accept(AllBlocks.NETHER_GROUT);

                        event.accept(AllBlocks.ARDITE_ORE);
                        event.accept(AllItems.RAW_ARDITE);
                        event.accept(AllItems.ARDITE_INGOT);
                        event.accept(AllItems.ARDITE_NUGGET);
                        event.accept(AllBlocks.ARDITE_BLOCK);
                        event.accept(AllItems.CRUSHED_ARDITE);
                        event.accept(AllBlocks.RAW_ARDITE_BLOCK);

                        event.accept(AllBlocks.COBALT_ORE);
                        event.accept(AllItems.RAW_COBALT);
                        event.accept(AllItems.COBALT_INGOT);
                        event.accept(AllItems.COBALT_NUGGET);
                        event.accept(AllBlocks.COBALT_BLOCK);
                        event.accept(AllItems.CRUSHED_COBALT);
                        event.accept(AllBlocks.RAW_COBALT_BLOCK);

                        event.accept(AllItems.CAST_BLANK);
                        event.accept(AllItems.CAST_BOW_GRIP);
                        event.accept(AllItems.CAT_BOW_LIMB);
                        event.accept(AllItems.CAST_BOWSTRING);
                        event.accept(AllItems.CAST_BROAD_AXE_HEAD);
                        event.accept(AllItems.CAST_BROAD_BLADE);
                        event.accept(AllItems.CAST_COIN);
                        event.accept(AllItems.CAST_GEAR);
                        event.accept(AllItems.CAST_GEM);
                        event.accept(AllItems.CAST_HAMMER_HEAD);
                        event.accept(AllItems.CAST_INGOT);
                        event.accept(AllItems.CAST_LARGE_PLATE);
                        event.accept(AllItems.CAST_NUGGET);
                        event.accept(AllItems.CAST_PICKAXE_HEAD);
                        event.accept(AllItems.CAST_PLATE);
                        event.accept(AllItems.CAST_REPAIR_KIT);
                        event.accept(AllItems.CAST_ROD);
                        event.accept(AllItems.CAST_ROUND_PLATE);
                        event.accept(AllItems.CAST_SMALL_AXE_HEAD);
                        event.accept(AllItems.CAST_SMALL_BLADE);
                        event.accept(AllItems.CAST_TOOL_BINDING);
                        event.accept(AllItems.CAST_TOOL_HANDLE);
                        event.accept(AllItems.CAST_TOUGH_HANDLE);
                        event.accept(AllItems.CAST_WIRE);
                        event.accept(AllItems.CAST_SWORD_GUARD);

                        event.accept(AllItems.SEARED_BRICK);
                        event.accept(AllBlocks.SEARED_BRICKS);
                        event.accept(AllBlocks.SEARED_COBBLE);
                        event.accept(AllBlocks.SEARED_CRACKED_BRICKS);
                        event.accept(AllBlocks.SEARED_CREEPER);
                        event.accept(AllBlocks.SEARED_FANCY_BRICKS);
                        event.accept(AllBlocks.SEARED_LADDER);
                        event.accept(AllBlocks.SEARED_PAVER);
                        event.accept(AllBlocks.SEARED_PAVER_SLAB);
                        event.accept(AllBlocks.SEARED_ROAD);
                        event.accept(AllBlocks.SEARED_SMALL_BRICKS);
                        event.accept(AllBlocks.SEARED_SQUARE_BRICKS);
                        event.accept(AllBlocks.SEARED_STONE);
                        event.accept(AllBlocks.SEARED_TILE);
                        event.accept(AllBlocks.SEARED_TRIANGLE_BRICKS);

                        event.accept(AllBlocks.SCORCHED_BRICK);
                        event.accept(AllBlocks.SCORCHED_BRICKS);
                        event.accept(AllBlocks.SCORCHED_CHISELED);
                        event.accept(AllBlocks.SCORCHED_LADDER);
                        event.accept(AllBlocks.SCORCHED_POLISHED);
                        event.accept(AllBlocks.SCORCHED_ROAD);
                        event.accept(AllBlocks.SCORCHED_STONE);

                        event.accept(AllItems.REINFORCEMENT_BASE);
                        event.accept(AllItems.REINFORCEMENT_BRONZE);
                        event.accept(AllItems.REINFORCEMENT_COBALT);
                        event.accept(AllItems.REINFORCEMENT_EMERALD);
                        event.accept(AllItems.REINFORCEMENT_GOLD);
                        event.accept(AllItems.REINFORCEMENT_IRON);
                        event.accept(AllItems.REINFORCEMENT_SEARED);
                        event.accept(AllItems.REINFORCEMENT_SLIMESTEEL);

                        event.accept(AllItems.DEBRIS_NUGGET);
                        event.accept(AllItems.NETHERITE_NUGGET);

                        event.accept(AllBlocks.SEARED_CASING.get());
                        event.accept(AllBlocks.SCORCHED_CASING.get());

                        event.accept(AllBlocks.CASTING_DEPOT.get());
                        event.accept(AllBlocks.SEARED_TANK.get());
                        event.accept(AllBlocks.SEARED_SPOUT.get());
                        event.accept(AllBlocks.SEARED_PIPE.get());

                }

        }

        public CreateArmouryWeapon() {
                IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
                REGISTRATE.registerEventListeners(modEventBus);
                AllItems.ITEMS.register(modEventBus);
                AllBlocks.ITEMS.register(modEventBus);
                AllBlocks.BLOCKS.register(modEventBus);
                AllFluids.register();
                AllRecipeTypes.register(modEventBus);
                AllPartialModels.init();
                CREATIVE_MODE_TABS.register(modEventBus);
                MinecraftForge.EVENT_BUS.register(this);
                modEventBus.addListener(this::addCreative);
        }

        public static ResourceLocation getResource(String name) {
                return new ResourceLocation(MODID, name);
        }

        @SubscribeEvent
        public void onServerStarting(ServerStartingEvent event) {
                LOGGER.debug("Loading Materials...");
                MaterialManager.load(event.getServer().getResourceManager());
        }

        public static long convertString2Hex(String numberHexString) {

                char[] ChaArray = numberHexString.toCharArray();
                long HexSum = 0;
                long cChar = 0;

                for (int i = 0; i < numberHexString.length(); i++) {

                        if ((ChaArray[i] >= '0') && (ChaArray[i] <= '9')) {
                                cChar = ChaArray[i] - '0';
                        } else {
                                cChar = ChaArray[i] - 'A' + 10;
                        }

                        HexSum = 16 * HexSum + cChar;
                }

                return HexSum;
        }

}