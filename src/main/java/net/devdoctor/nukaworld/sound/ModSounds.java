package net.devdoctor.nukaworld.sound;

import net.devdoctor.nukaworld.NukaWorld;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NukaWorld.MOD_ID);

    public static final RegistryObject<SoundEvent> NUKA_COLA_DRINK = registerSoundEvent("nuka_cola_drink");
    public static final RegistryObject<SoundEvent> NUKA_WORLD_THEME = registerSoundEvent("nuka_world_theme");
    public static final RegistryObject<SoundEvent> USE_MED = registerSoundEvent("use_med");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENT.register(name, () -> new SoundEvent(new ResourceLocation(NukaWorld.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}
