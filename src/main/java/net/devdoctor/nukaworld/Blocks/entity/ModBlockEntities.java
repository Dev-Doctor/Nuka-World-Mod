package net.devdoctor.nukaworld.Blocks.entity;


import net.devdoctor.nukaworld.Blocks.ModBlocks;
import net.devdoctor.nukaworld.NukaWorld;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NukaWorld.MOD_ID);

    public static final RegistryObject<BlockEntityType<MixingStationBlockEntity>> MIXING_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("mixing_station_block_entity", () ->
                    BlockEntityType.Builder.of(MixingStationBlockEntity::new,
                            ModBlocks.MIXING_STATION.get()).build(null));

	public static final RegistryObject<BlockEntityType<MixingStationBlockEntity>> MIXING_STATION = BLOCK_ENTITIES.register("mixing_station", () ->
			BlockEntityType.Builder.of(MixingStationBlockEntity::new, ModBlocks.MIXING_STATION.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}