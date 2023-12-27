package dev.denismasterherobrine.magicalforest.biome;

import dev.denismasterherobrine.magicalforest.MagicalForest;
import dev.denismasterherobrine.magicalforest.features.FancyOakTreeFeature;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeRegistry {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MagicalForest.MOD_ID);

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, FancyOakTreeFeature::bootstrapConfiguredFeature)
            .add(Registries.PLACED_FEATURE, FancyOakTreeFeature::bootstrapPlacedFeature)
            .add(Registries.BIOME, MagicalForestBiomeDecorator::decorateMagicalForest);

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var provider = new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), BUILDER, Set.of(MagicalForest.MOD_ID));
        generator.addProvider(event.includeServer(), provider);
    }
}