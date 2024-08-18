package net.devdoctor.nukaworld.Blocks.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.devdoctor.nukaworld.Blocks.entity.MixingStationBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class MixingStationBlockEntityRenderer implements BlockEntityRenderer<MixingStationBlockEntity> {

    public MixingStationBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(MixingStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        ItemStack itemStack = pBlockEntity.getRenderStack();
        pPoseStack.pushPose();
        pPoseStack.translate(.5f, .1f, .5f);
        pPoseStack.scale(.5f,.5f,.5f);

        switch (pBlockEntity.getBlockState().getValue(MixingStationBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(0));
            case SOUTH -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(90));
            case EAST -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(180));
            case WEST -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(270));
        }

        itemRenderer.renderStatic(itemStack, ItemTransforms.TransformType.GUI,
                getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int blight = level.getBrightness(LightLayer.BLOCK, pos);
        int slight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(blight, slight);
    }

}
