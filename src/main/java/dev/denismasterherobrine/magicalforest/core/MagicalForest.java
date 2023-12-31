package dev.denismasterherobrine.magicalforest.core;

import dev.denismasterherobrine.magicalforest.init.ModBiomes;
import dev.denismasterherobrine.magicalforest.init.ModConfig;
import dev.denismasterherobrine.magicalforest.init.ModTags;
import dev.denismasterherobrine.magicalforest.util.DeferredRegisterUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.core.TerraBlenderForge;

@Mod(MagicalForest.MOD_ID)
public class MagicalForest {

    public static final String MOD_ID = "magicalforest";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final DeferredRegister<Biome> BIOMES_REGISTER = DeferredRegisterUtils.create(Registries.BIOME);
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE_REGISTER = DeferredRegisterUtils.create(Registries.CONFIGURED_FEATURE);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE_REGISTER = DeferredRegisterUtils.create(Registries.PLACED_FEATURE);

    public MagicalForest() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::loadComplete);

        BIOMES_REGISTER.register(modEventBus);
        CONFIGURED_FEATURE_REGISTER.register(modEventBus);
        PLACED_FEATURE_REGISTER.register(modEventBus);

        ModConfig.setup();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModBiomes.setupTerraBlender();
        });
    }

    private void loadComplete(final FMLLoadCompleteEvent event) {
        ModTags.setup();
    }

}
