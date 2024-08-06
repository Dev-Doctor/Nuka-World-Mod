package net.devdoctor.nukaworld.Blocks;

import net.devdoctor.nukaworld.Blocks.custom.*;
import net.devdoctor.nukaworld.CreativeTabs.ModCreativeTabs;
import net.devdoctor.nukaworld.Items.ModItems;
import net.devdoctor.nukaworld.NukaWorld;
// import net.devdoctor.nukaworld.world.feature.CitrusTreeGrower; NEED TO UPDATE, DOESN'T WORK IN 1.19.2
import net.devdoctor.nukaworld.world.CitrusTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.TranslatableComponent; NEED TO UPDATE, DOESN'T WORK IN 1.19.2
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NukaWorld.MOD_ID);

    /* -------------------- CAP BLOCKS -------------------- */
    private static BlockBehaviour.Properties nuka_cap_block_base_values = BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.CHAIN).strength(.2f, .5f);
    public static final RegistryObject<Block> NUKA_CAP_BLOCK = registerBlock("nuka_cap_block", () -> new Block(nuka_cap_block_base_values), ModCreativeTabs.NUKA_WORLD);
    public static final RegistryObject<Block> NUKA_MIX_CAP_BLOCK = registerBlock("nuka_mix_cap_block", () -> new Block(nuka_cap_block_base_values), ModCreativeTabs.NUKA_WORLD);
    public static final RegistryObject<Block> NUKA_QUANTUM_CAP_BLOCK = registerBlock("nuka_quantum_cap_block", () -> new Block(nuka_cap_block_base_values), ModCreativeTabs.NUKA_WORLD);
    public static final RegistryObject<Block> NUKA_VICTORY_CAP_BLOCK = registerBlock("nuka_victory_cap_block", () -> new Block(nuka_cap_block_base_values), ModCreativeTabs.NUKA_WORLD);
    public static final RegistryObject<Block> NUKA_CIDE_CAP_BLOCK = registerBlock("nuka_cide_cap_block", () -> new Block(nuka_cap_block_base_values), ModCreativeTabs.NUKA_WORLD);

    /* -------------------- NUKA-COLAS -------------------- */
    private static BlockBehaviour.Properties nuka_cola_base_values = BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).instabreak();
    public static final RegistryObject<Block> NUKA_COLA = registerNukaCola("nuka_cola_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_COLA_CHERRY = registerNukaCola("nuka_cola_cherry_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_COLA_DARK = registerNukaCola("nuka_cola_dark_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_COLA_GRAPE = registerNukaCola("nuka_cola_grape_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_COLA_ORANGE = registerNukaCola("nuka_cola_orange_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_COLA_QUARTZ = registerNukaCola("nuka_cola_quartz_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_COLA_WILD = registerNukaCola("nuka_cola_wild_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_COLA_QUANTUM = registerNukaCola("nuka_cola_quantum_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_COLA_VICTORY = registerNukaCola("nuka_cola_victory_block", () -> new NukaColaBlock(nuka_cola_base_values));
    /* -------------------- MIXS -------------------- */
    public static final RegistryObject<Block> NEWKA_COLA = registerNukaCola("newka_cola_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_BERRY = registerNukaCola("nuka_berry_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_BOMBDROP = registerNukaCola("nuka_bombdrop_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_BUZZ = registerNukaCola("nuka_buzz_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_CIDE = registerNukaCola("nuka_cide_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_COOLER = registerNukaCola("nuka_cooler_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_FANCY = registerNukaCola("nuka_fancy_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_FREE = registerNukaCola("nuka_free_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_FRUTTI = registerNukaCola("nuka_frutti_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_HEARTY = registerNukaCola("nuka_hearty_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_LIXIR = registerNukaCola("nuka_lixir_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_LOVE = registerNukaCola("nuka_love_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_POWER = registerNukaCola("nuka_power_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_PUNCH = registerNukaCola("nuka_punch_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_RAY = registerNukaCola("nuka_ray_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_RUSH = registerNukaCola("nuka_rush_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_SUNRISE = registerNukaCola("nuka_sunrise_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_TWIN = registerNukaCola("nuka_twin_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_VOID = registerNukaCola("nuka_void_block", () -> new NukaColaBlock(nuka_cola_base_values));
    public static final RegistryObject<Block> NUKA_XTREME = registerNukaCola("nuka_xtreme_block", () -> new NukaColaBlock(nuka_cola_base_values));

    /* -------------------- OTHER BLOCKS -------------------- */
    public static final RegistryObject<Block> SUPER_CONCENTRATED_SUGAR = registerBlock("super_concentrated_sugar", () -> new SandBlock(14406560, BlockBehaviour.Properties.copy(Blocks.SAND)), ModCreativeTabs.NUKA_WORLD);
    public static final RegistryObject<Block> TATO_PLANT = registerBlockWithoutItem("tato_plant", () -> new TatoPlantBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion()));
    public static final RegistryObject<Block> MIXING_STATION = registerBlock("mixing_station", () -> new MixingStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), ModCreativeTabs.NUKA_WORLD);

    /* -------------------------- NEED TO UPDATE, DOESN'T WORK IN 1.19.2 -------------------------- */
    public static final RegistryObject<Block> CITRUS_SAPLING = registerBlock("citrus_sapling", () -> new SaplingBlock(new CitrusTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeTabs.NUKA_WORLD);

    public static final RegistryObject<Block> CITRUS_LEAVES = registerBlock("citrus_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeTabs.NUKA_WORLD);

    /* -------------------- REGISTER -------------------- */
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static <T extends Block>RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    /* -------------------- REGISTER NUKA COLA -------------------- */
    private static <T extends Block>RegistryObject<T> registerNukaCola(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }


    /* BLOCKS WITH TOOLTIPS */

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                // pTooltip.add(new TranslatableComponent(tooltipKey)); NEED TO UPDATE, DOESN'T WORK IN 1.19.2
            }
        });
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}