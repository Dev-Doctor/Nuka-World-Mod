package net.devdoctor.nukaworld;

import net.devdoctor.nukaworld.Items.ModItems;
import net.minecraft.world.level.ItemLike;

public enum NukaColaTypes {
    NUKA_COLA(ModItems.NUKA_COLA_CAP.get()),
    NUKA_COLA_CHERRY(ModItems.NUKA_COLA_CAP.get()),
    NUKA_COLA_DARK(ModItems.NUKA_COLA_CAP.get()),
    NUKA_COLA_GRAPE(ModItems.NUKA_COLA_CAP.get()),
    NUKA_COLA_ORANGE(ModItems.NUKA_COLA_CAP.get()),
    NUKA_COLA_QUARTZ(ModItems.NUKA_COLA_CAP.get()),
    NUKA_COLA_WILD(ModItems.NUKA_COLA_CAP.get()),
    NUKA_COLA_QUANTUM(ModItems.NUKA_COLA_QUANTUM_CAP.get()),
    NUKA_COLA_VICTORY(ModItems.NUKA_COLA_VICTORY_CAP.get()),
    NUKA_COLA_MIX(ModItems.NUKA_COLA_MIX_CAP.get()),
    NUKA_COLA_CIDE(ModItems.NUKA_COLA_MIX_CAP.get());
    final public ItemLike cap_id;

    NukaColaTypes(ItemLike cap_id) {
        this.cap_id = cap_id;
    }
}
