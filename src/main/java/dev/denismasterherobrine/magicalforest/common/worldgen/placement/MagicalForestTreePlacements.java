package dev.denismasterherobrine.magicalforest.common.worldgen.placement;

import com.google.common.collect.ImmutableList;
import dev.denismasterherobrine.magicalforest.common.worldgen.feature.MagicalForestTreeFeatures;
import dev.denismasterherobrine.magicalforest.util.ResourceKeyUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class MagicalForestTreePlacements {

    public static final ResourceKey<PlacedFeature> FANCY_OAK = ResourceKeyUtils.create(Registries.PLACED_FEATURE, "fancy_oak");

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier placement) {
        return ImmutableList.<PlacementModifier>builder()
                .add(placement)
                .add(InSquarePlacement.spread())
                .add(SurfaceWaterDepthFilter.forMaxDepth(0))
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                .add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE)
                .add(PlacementUtils.HEIGHTMAP_TOP_SOLID)
                .add(BiomeFilter.biome());
    }

    private static List<PlacementModifier> treePlacement(PlacementModifier placement) {
        return treePlacementBase(placement).build();
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        var FANCY_OAK_TREE = holderGetter.getOrThrow(MagicalForestTreeFeatures.FANCY_OAK_TREE);

        PlacementUtils.register(context, MagicalForestTreePlacements.FANCY_OAK, FANCY_OAK_TREE,
                treePlacement(PlacementUtils.countExtra(5, 0.1f, 1)));
    }

    public static void addFancyOakTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FANCY_OAK);
    }

}
