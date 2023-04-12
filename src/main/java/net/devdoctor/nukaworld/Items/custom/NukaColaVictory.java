package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.Blocks.ModBlocks;
import net.devdoctor.nukaworld.NukaColaTypes;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class NukaColaVictory extends NukaCola {

    public NukaColaVictory(@NotNull Block block, Properties properties) {
        super(block, properties);
        CAP_TYPE = NukaColaTypes.NUKA_COLA_VICTORY.cap_id;
    }
}
