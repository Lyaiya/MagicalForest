package dev.denismasterherobrine.magicalforest.biome;

import dev.denismasterherobrine.magicalforest.MagicalForest;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BiomeInitializer {
    public static final ResourceKey<Biome> MAGICAL_FOREST = create("magical_forest");

    private static ResourceKey<Biome> create(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(MagicalForest.MOD_ID, name));
    }
}