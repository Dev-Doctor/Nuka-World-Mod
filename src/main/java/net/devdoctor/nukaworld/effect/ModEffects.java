package net.devdoctor.nukaworld.effect;

import net.devdoctor.nukaworld.CreativeTabs.ModCreativeTabs;
import net.devdoctor.nukaworld.NukaWorld;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NukaWorld.MOD_ID);

    public static final RegistryObject<MobEffect> POISON_RESISTANCE = MOB_EFFECTS.register("poison_resistance", () -> new PoisonResistancePotionEffect(MobEffectCategory.BENEFICIAL, 234123));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
