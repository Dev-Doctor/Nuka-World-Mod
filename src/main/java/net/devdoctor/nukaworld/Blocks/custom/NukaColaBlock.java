package net.devdoctor.nukaworld.Blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class NukaColaBlock extends Block {

    public NukaColaBlock(Properties properties) {
        super(properties);
    }
    private static final VoxelShape SHAPE = Stream.of(Block.box(4, 0, 4, 12, 14, 12)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (!pLevel.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(pLevel, pPos, Blocks.DIRT.defaultBlockState(), pFallDistance, pEntity)) { // Forge: Move logic to Entity#canTrample
            pLevel.destroyBlock(pPos, false, pEntity);
        }

        super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
    }

    @Override
    protected void spawnDestroyParticles(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState) {
        super.spawnDestroyParticles(pLevel, pPlayer, pPos, pState);
    }


}
