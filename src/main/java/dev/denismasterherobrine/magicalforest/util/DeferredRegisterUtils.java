package dev.denismasterherobrine.magicalforest.util;

import dev.denismasterherobrine.magicalforest.core.MagicalForest;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.DeferredRegister;

public class DeferredRegisterUtils {

    public static <B> DeferredRegister<B> create(ResourceKey<? extends Registry<B>> key) {
        return DeferredRegister.create(key, MagicalForest.MOD_ID);
    }

}
