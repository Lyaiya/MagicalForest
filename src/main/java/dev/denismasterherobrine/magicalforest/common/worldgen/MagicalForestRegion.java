package dev.denismasterherobrine.magicalforest.common.worldgen;

import com.mojang.datafixers.util.Pair;
import dev.denismasterherobrine.magicalforest.core.MagicalForest;
import dev.denismasterherobrine.magicalforest.common.biome.MagicalForestOverworldBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class MagicalForestRegion extends Region {

    private static final ResourceLocation LOCATION = new ResourceLocation(MagicalForest.MOD_ID, "overworld");

    public MagicalForestRegion(int weight) {
        super(LOCATION, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addBiome(mapper,
                Climate.Parameter.point(0.35F),
                Climate.Parameter.point(0.5F),
                Climate.Parameter.point(0.03F),
                Climate.Parameter.point(0.6F),
                Climate.Parameter.point(0.02F),
                Climate.Parameter.point(0.125F),
                0F,
                MagicalForestOverworldBiomes.MAGICAL_FOREST
        );
    }

}
