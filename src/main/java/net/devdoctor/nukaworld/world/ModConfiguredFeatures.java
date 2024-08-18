package net.devdoctor.nukaworld.world;

import net.devdoctor.nukaworld.Blocks.ModBlocks;
import net.devdoctor.nukaworld.NukaWorld;
import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, NukaWorld.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> CITRUS =
            CONFIGURED_FEATURES.register("citrus", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(Blocks.ACACIA_LOG),
                            new StraightTrunkPlacer(3, 1, 3),
                            BlockStateProvider.simple(ModBlocks.CITRUS_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3 ),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
