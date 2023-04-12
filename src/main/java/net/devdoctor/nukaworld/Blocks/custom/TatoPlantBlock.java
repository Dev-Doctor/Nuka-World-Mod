package net.devdoctor.nukaworld.Blocks.custom;

import net.devdoctor.nukaworld.Items.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class TatoPlantBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public TatoPlantBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.TATO.get();
    }
}
