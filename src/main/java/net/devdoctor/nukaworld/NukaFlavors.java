package net.devdoctor.nukaworld;

import net.devdoctor.nukaworld.Items.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public enum NukaFlavors {
    NUKA_COLA(ModItems.NUKA_COLA_CAP.get(), null),
    NUKA_COLA_CHERRY(ModItems.NUKA_COLA_CAP.get(), List.of(
            new MobEffectInstance(MobEffects.DIG_SPEED, 1, 30, true, false)
    )),
    NUKA_COLA_DARK(ModItems.NUKA_COLA_CAP.get(), null),
    NUKA_COLA_GRAPE(ModItems.NUKA_COLA_CAP.get(), null),
    NUKA_COLA_ORANGE(ModItems.NUKA_COLA_CAP.get(), null),
    NUKA_COLA_QUARTZ(ModItems.NUKA_COLA_CAP.get(), null),
    NUKA_COLA_WILD(ModItems.NUKA_COLA_CAP.get(), null),
    NUKA_COLA_QUANTUM(ModItems.NUKA_COLA_QUANTUM_CAP.get(), List.of(
            new MobEffectInstance(MobEffects.DIG_SPEED, 30, 1, true, false),
            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 3, true, false)
    )),
    NUKA_COLA_VICTORY(ModItems.NUKA_COLA_VICTORY_CAP.get(), null),
    NUKA_COLA_MIX(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_COLA_CIDE(ModItems.NUKA_COLA_CIDE_CAP.get(), null);

    final public ItemLike cap_id;
    final public List<MobEffectInstance> effects;

    NukaFlavors(ItemLike cap_id, List<MobEffectInstance> effects) {
        this.cap_id = cap_id;
        this.effects = effects;
    }
}
