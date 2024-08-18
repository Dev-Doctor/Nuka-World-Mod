package net.devdoctor.nukaworld.event;

import net.devdoctor.nukaworld.Blocks.custom.MixingStationBlockEntityRenderer;
import net.devdoctor.nukaworld.Blocks.entity.ModBlockEntities;
import net.devdoctor.nukaworld.NukaWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = NukaWorld.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents { }

    @Mod.EventBusSubscriber(modid = NukaWorld.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.MIXING_STATION.get(),
                    MixingStationBlockEntityRenderer::new);
        }
    }
}
