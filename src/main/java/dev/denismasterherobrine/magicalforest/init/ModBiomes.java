package dev.denismasterherobrine.magicalforest.init;

import dev.denismasterherobrine.magicalforest.core.MagicalForest;
import dev.denismasterherobrine.magicalforest.common.biome.MagicalForestOverworldBiomes;
import dev.denismasterherobrine.magicalforest.common.worldgen.MagicalForestRegion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.Regions;

public class ModBiomes {

    public static void setupTerraBlender() {
        if (ModConfig.biomeWeightForest.get().equals(0)) {
            MagicalForest.LOGGER.info("Magical Forest biome is disabled in the config! Please change 0 to something bigger to re-enable it.");
            return;
        }

        Regions.register(new MagicalForestRegion(ModConfig.biomeWeightForest.get()));
    }

    private static void register(BootstapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }

    public static void bootstrapBiomes(BootstapContext<Biome> context) {
        var placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);
        var carverGetter = context.lookup(Registries.CONFIGURED_CARVER);

        register(context, MagicalForestOverworldBiomes.MAGICAL_FOREST, MagicalForestOverworldBiomes.magicForest(placedFeatureGetter, carverGetter));
    }

}
