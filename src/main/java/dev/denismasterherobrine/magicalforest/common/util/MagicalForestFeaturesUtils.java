package dev.denismasterherobrine.magicalforest.common.util;

import dev.denismasterherobrine.magicalforest.common.worldgen.feature.MagicalForestTreeFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class MagicalForestFeaturesUtils {

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        MagicalForestTreeFeatures.bootstrap(context);
    }

}
