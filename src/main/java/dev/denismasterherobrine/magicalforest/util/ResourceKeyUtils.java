package dev.denismasterherobrine.magicalforest.util;

import dev.denismasterherobrine.magicalforest.core.MagicalForest;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class ResourceKeyUtils {

    public static <T> ResourceKey<T> create(ResourceKey<? extends Registry<T>> registryKey, String path) {
        return ResourceKey.create(registryKey, new ResourceLocation(MagicalForest.MOD_ID, path));
    }

}
