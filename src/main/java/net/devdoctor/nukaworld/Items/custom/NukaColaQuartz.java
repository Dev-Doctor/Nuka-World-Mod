package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.NukaColaTypes;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class NukaColaQuartz extends NukaCola {

    public NukaColaQuartz(@NotNull Block block, Properties properties) {
        super(block, properties);
        CAP_TYPE = NukaColaTypes.NUKA_COLA_QUARTZ.cap_id;
    }
}
