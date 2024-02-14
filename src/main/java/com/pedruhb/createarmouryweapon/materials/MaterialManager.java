package com.pedruhb.createarmouryweapon.materials;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.pedruhb.createarmouryweapon.materials.serialize.Material;
import com.simibubi.create.AllFluids.TintedFluidType;
import com.tterrag.registrate.builders.FluidBuilder.FluidTypeFactory;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Color;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidStack;

import java.util.*;
import java.util.function.Supplier;

import org.apache.commons.io.IOUtils;
import org.joml.Vector3f;
import org.slf4j.Logger;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class MaterialManager {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = (new GsonBuilder()).disableHtmlEscaping().create();
    public static Set<Material> MATERIALS = new HashSet<Material>();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateArmouryWeapon.MODID);
    public static ArrayList<ItemStack> parts_stacks = new ArrayList<ItemStack>();

    public static void load(ResourceManager resourceManager) {

        Map<ResourceLocation, Resource> resources = resourceManager.listResources("materials",
                s -> s.toString().endsWith(".json"));
        if (resources.isEmpty())
            return;

        for (ResourceLocation id : resources.keySet()) {

            String path = id.getPath().substring("materials".length() + 1, id.getPath().length() - ".json".length());
            ResourceLocation name = new ResourceLocation(id.getNamespace(), path);
            Optional<Resource> resourceOptional = resourceManager.getResource(id);

            if (resourceOptional.isPresent()) {

                Resource iresource = resourceOptional.get();
                JsonObject json = null;

                try {
                    json = GsonHelper.fromJson(GSON, IOUtils.toString(iresource.open(), StandardCharsets.UTF_8),
                            JsonObject.class);
                } catch (IOException ex) {
                    LOGGER.error("Could not read material {}", name, ex);
                }

                if (json == null) {

                    LOGGER.error("Could not load material {} as it's null or empty", name);

                } else {

                    String material_name = json.get("name").getAsString();

                    LOGGER.info("Loading {} material...", material_name);

                    Material material = new Material(json);
                    MATERIALS.add(material);

                }
            }

        }
    }

    public static Material getMaterialByName(String name) {
        for (Material material : MATERIALS) {
            if (material.getName().toLowerCase().equals(name.toLowerCase()))
                return material.getMaterial();
        }
        return null;
    }

    public static class SolidRenderedPlaceableFluidType extends TintedFluidType {

        private Vector3f fogColor;
        private Supplier<Float> fogDistance;

        public static FluidTypeFactory create(int fogColor, Supplier<Float> fogDistance) {
            return (p, s, f) -> {
                SolidRenderedPlaceableFluidType fluidType = new SolidRenderedPlaceableFluidType(p, s, f);
                fluidType.fogColor = new Color(fogColor, false).asVectorF();
                fluidType.fogDistance = fogDistance;
                return fluidType;
            };
        }

        private SolidRenderedPlaceableFluidType(Properties properties, ResourceLocation stillTexture,
                ResourceLocation flowingTexture) {
            super(properties, stillTexture, flowingTexture);
        }

        @Override
        protected int getTintColor(FluidStack stack) {
            return NO_TINT;
        }

        /*
         * Removing alpha from tint prevents optifine from forcibly applying biome
         * colors to modded fluids (this workaround only works for fluids in the solid
         * render layer)
         */
        @Override
        public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return 0x00ffffff;
        }

        @Override
        protected Vector3f getCustomFogColor() {
            return fogColor;
        }

        @Override
        protected float getFogDistanceModifier() {
            return fogDistance.get();
        }

    }
}