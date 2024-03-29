package net.devdoctor.nukaworld.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.devdoctor.nukaworld.NukaWorld;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MixingStationScreen extends AbstractContainerScreen<MixingStationMenu> {
	private static final ResourceLocation TEXTURE =
			new ResourceLocation(NukaWorld.MOD_ID, "textures/gui/mixing_station_gui.png");

	public MixingStationScreen(MixingStationMenu menu, Inventory inventory, Component component) {
		super(menu, inventory, component);
		inventoryLabelY += 54;
	}

	@Override
	protected void init() {
		super.init();
	}

	@Override
	protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - imageWidth) / 2;
		int y = (height - imageHeight) / 2;

		this.blit(pPoseStack, x, y, 0, 0, 176, 220, 256, 256);
		renderProgressArrow(pPoseStack, x, y);
	}

	private void renderProgressArrow(PoseStack poseStack, int x, int y) {
		if(menu.isCrafting()) {
			blit(poseStack, x + 82, y + 88, 176, 0, 11, menu.getScaledProgress());
			// x + 105, y + 33, 176, 0, 0, menu.getScaledProgress()
		}
	}

	@Override
	public void render(PoseStack pPoseStack, int mouseX, int mouseY, float data) {
		this.renderBackground(pPoseStack);
		super.render(pPoseStack, mouseX, mouseY, data);
		renderTooltip(pPoseStack, mouseX, mouseY);
	}


}
