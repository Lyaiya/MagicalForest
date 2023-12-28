package dev.denismasterherobrine.magicalforest.init;

import dev.denismasterherobrine.magicalforest.core.MagicalForest;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModTags {
    public static void setup() {
        Biomes.setup();
    }

    public static class Biomes {
        public static TagKey<Biome> MAGICAL_FORESTS = TagKey.create(Registries.BIOME, new ResourceLocation(MagicalForest.MOD_ID, "magical_forests"));

        private static void setup() {
        }
    }

}
