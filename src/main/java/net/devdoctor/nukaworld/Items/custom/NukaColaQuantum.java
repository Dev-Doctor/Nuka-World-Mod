package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.NukaFlavors;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class NukaColaQuantum extends NukaCola {

    public NukaColaQuantum(@NotNull Block block, Properties properties) {
        super(block, properties);
        CAP_TYPE = NukaFlavors.NUKA_COLA_QUANTUM.cap_id;
    }
}
