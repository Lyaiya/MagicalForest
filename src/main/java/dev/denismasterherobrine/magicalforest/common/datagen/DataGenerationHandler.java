package dev.denismasterherobrine.magicalforest.common.datagen;

import dev.denismasterherobrine.magicalforest.core.MagicalForest;
import dev.denismasterherobrine.magicalforest.common.util.MagicalForestFeaturesUtils;
import dev.denismasterherobrine.magicalforest.common.util.MagicalForestPlacementUtils;
import dev.denismasterherobrine.magicalforest.init.ModBiomes;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MagicalForest.MOD_ID)
public class DataGenerationHandler {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, MagicalForestFeaturesUtils::bootstrap)
            .add(Registries.PLACED_FEATURE, MagicalForestPlacementUtils::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrapBiomes);

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var provider = new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), BUILDER, Set.of(MagicalForest.MOD_ID));
        generator.addProvider(event.includeServer(), provider);
    }
}