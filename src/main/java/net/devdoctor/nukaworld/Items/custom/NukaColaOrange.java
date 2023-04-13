package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.NukaFlavors;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class NukaColaOrange extends NukaCola {

    public NukaColaOrange(@NotNull Block block, Properties properties) {
        super(block, properties);
        CAP_TYPE = NukaFlavors.NUKA_COLA_ORANGE.cap_id;
    }
}
