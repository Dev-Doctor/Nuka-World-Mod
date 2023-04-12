package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.NukaColaTypes;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class NukaColaWild extends NukaCola {

    public NukaColaWild(@NotNull Block block, Properties properties) {
        super(block, properties);
        CAP_TYPE = NukaColaTypes.NUKA_COLA_WILD.cap_id;
    }
}
