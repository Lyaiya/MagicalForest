package dev.denismasterherobrine.magicalforest.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.OptionalInt;

public class FancyOakTreeFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_OAK_TREES_KEY = FeatureUtils.createKey("trees_fancy_oak");
    public static final ResourceKey<PlacedFeature> FANCY_OAK_TREES_FEATURE_KEY = PlacementUtils.createKey("trees_fancy_oak_feature");

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

    private static TreeConfiguration.TreeConfigurationBuilder createFancyOak() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }

    public static void addFancyOakTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FancyOakTreeFeature.FANCY_OAK_TREES_FEATURE_KEY);
    }

    public static void bootstrapConfiguredFeature(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
        FeatureUtils.register(pContext, FANCY_OAK_TREES_KEY, Feature.TREE, createFancyOak().build());
    }

    public static void bootstrapPlacedFeature(BootstapContext<PlacedFeature> pContext) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = pContext.lookup(Registries.CONFIGURED_FEATURE);
        var holder = holdergetter.getOrThrow(FANCY_OAK_TREES_KEY);
        PlacementUtils.register(pContext, FANCY_OAK_TREES_FEATURE_KEY, holder, treePlacement(PlacementUtils.countExtra(5, 0.1f, 1)));
    }
}
