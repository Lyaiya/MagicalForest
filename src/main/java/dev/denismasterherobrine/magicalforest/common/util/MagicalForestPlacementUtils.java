package dev.denismasterherobrine.magicalforest.common.util;

import dev.denismasterherobrine.magicalforest.common.worldgen.placement.MagicalForestTreePlacements;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class MagicalForestPlacementUtils {

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        MagicalForestTreePlacements.bootstrap(context);
    }

}
