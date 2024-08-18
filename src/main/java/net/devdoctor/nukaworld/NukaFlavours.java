package net.devdoctor.nukaworld;

import net.devdoctor.nukaworld.Items.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public enum NukaFlavours {
    NUKA_COLA(ModItems.NUKA_COLA_CAP.get(), Rarity.COMMON, List.of(
            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1),
            new MobEffectInstance(MobEffects.HEAL, 1, 1)
    )),
    NUKA_COLA_CHERRY(ModItems.NUKA_COLA_CAP.get(), Rarity.COMMON, List.of(
            new MobEffectInstance(MobEffects.DIG_SPEED, 1, 30, true, false)
    )),
    NUKA_COLA_DARK(ModItems.NUKA_COLA_CAP.get(), Rarity.UNCOMMON, List.of(
            new MobEffectInstance(MobEffects.INVISIBILITY, 4800, 30, true, false),
            new MobEffectInstance(MobEffects.CONFUSION, 200, 0)
    )),
    NUKA_COLA_GRAPE(ModItems.NUKA_COLA_CAP.get(), Rarity.COMMON, null),
    NUKA_COLA_ORANGE(ModItems.NUKA_COLA_CAP.get(), Rarity.UNCOMMON,null),
    NUKA_COLA_QUARTZ(ModItems.NUKA_COLA_CAP.get(), Rarity.RARE, List.of(
            new MobEffectInstance(MobEffects.GLOWING, 3600, 0),
            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 0),
            new MobEffectInstance(MobEffects.NIGHT_VISION, 3600, 0)
    )),
    NUKA_COLA_WILD(ModItems.NUKA_COLA_CAP.get(), Rarity.UNCOMMON, List.of(
            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 0),
            new MobEffectInstance(MobEffects.JUMP, 3600, 0),
            new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 0)
    )),
    NUKA_COLA_QUANTUM(ModItems.NUKA_COLA_QUANTUM_CAP.get(), Rarity.RARE, List.of(
            new MobEffectInstance(MobEffects.ABSORPTION, 4800, 3),
            new MobEffectInstance(MobEffects.REGENERATION, 4800, 0),
            new MobEffectInstance(MobEffects.GLOWING, 4800, 0),
            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1)
    )),
    NUKA_COLA_VICTORY(ModItems.NUKA_COLA_VICTORY_CAP.get(), Rarity.EPIC, List.of(
            new MobEffectInstance(MobEffects.HEALTH_BOOST, 4800, 3),
            new MobEffectInstance(MobEffects.REGENERATION, 4800, 1),
            new MobEffectInstance(MobEffects.GLOWING, 4800, 0),
            new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 2)
    )),
    NEWKA_COLA(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_BERRY(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_BOMBDROP(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_BUZZ(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_CIDE(ModItems.NUKA_COLA_CIDE_CAP.get(), null),
    NUKA_COOLER(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_FANCY(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_FREE(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_FRUTTI(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_HEARTY(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_LIXIR(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_LOVE(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_POWER(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_PUNCH(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_RAY(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_RUSH(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_SUNRISE(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_TWIN(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_VOID(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_XTREME(ModItems.NUKA_COLA_MIX_CAP.get(), null),
    NUKA_COLA_MIX(ModItems.NUKA_COLA_MIX_CAP.get(), null);


    final public ItemLike cap_id;
    final public List<MobEffectInstance> effects;
    final public Rarity rarity;

    NukaFlavours(ItemLike cap_id, Rarity rarity, List<MobEffectInstance> effects) {
        this.cap_id = cap_id;
        this.effects = effects;
        this.rarity = rarity;
    }

    NukaFlavours(ItemLike cap_id, List<MobEffectInstance> effects) {
        this.cap_id = cap_id;
        this.effects = effects;
        this.rarity = Rarity.COMMON;
    }
}
