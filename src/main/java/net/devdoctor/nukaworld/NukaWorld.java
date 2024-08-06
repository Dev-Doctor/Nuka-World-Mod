package net.devdoctor.nukaworld;

import com.mojang.logging.LogUtils;
import net.devdoctor.nukaworld.Blocks.ModBlocks;
import net.devdoctor.nukaworld.Blocks.entity.ModBlockEntities;
import net.devdoctor.nukaworld.Items.ModItems;
import net.devdoctor.nukaworld.recipe.ModRecipes;
import net.devdoctor.nukaworld.screen.MixingStationScreen;
import net.devdoctor.nukaworld.screen.ModMenuTypes;
import net.devdoctor.nukaworld.sound.ModSounds;
import net.devdoctor.nukaworld.world.ModConfiguredFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NukaWorld.MOD_ID)
public class NukaWorld {
    public static final String MOD_ID = "nukaworld";


    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public NukaWorld() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the setup method for modloading
        eventBus.addListener(this::setup);
        eventBus.addListener(this::ClientSetup);

        // REGISTER ITEMS
        ModItems.ITEMS.register(eventBus);

        // REGISTER BLOCKS
        ModBlocks.BLOCKS.register(eventBus);

        // REGISTER SOUNDS
        ModSounds.register(eventBus);

        //REGISTER BLOCK ENTITIES
        ModBlockEntities.register(eventBus);

        //REGISTER GUIs
        ModMenuTypes.register(eventBus);

        // REGISTER RECIPES
        ModRecipes.register(eventBus);

        // REGISTER WORLD CONFIGS
        ModConfiguredFeatures.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void ClientSetup(final FMLClientSetupEvent event) {
        /* -------------------------- NEED TO UPDATE, DOESN'T WORK IN 1.19.2 -------------------------- */
        //ItemBlockRenderTypes.setRenderLayer(ModBlocks.NUKA_COLA.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TATO_PLANT.get(), RenderType.cutout());
        //ItemBlockRenderTypes.setRenderLayer(ModBlocks.CITRUS_SAPLING.get(), RenderType.cutout());
        //ItemBlockRenderTypes.setRenderLayer(ModBlocks.CITRUS_LEAVES.get(), RenderType.cutout());

        MenuScreens.register(ModMenuTypes.MIXING_STATION_MENU.get(), MixingStationScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("NukaWorld Loading Complete!");
    }
}

