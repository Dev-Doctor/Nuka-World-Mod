package net.devdoctor.nukaworld.Items;

import net.devdoctor.nukaworld.Blocks.ModBlocks;
import net.devdoctor.nukaworld.CreativeTabs.ModCreativeTabs;
import net.devdoctor.nukaworld.Items.custom.*;
import net.devdoctor.nukaworld.NukaFlavours;
import net.devdoctor.nukaworld.NukaWorld;
import net.devdoctor.nukaworld.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NukaWorld.MOD_ID);

    /* -------------------- CAPS -------------------- */
    public static final RegistryObject<Item> NUKA_COLA_CAP = ITEMS.register("nuka_cap", () -> new Item(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD)));
    public static final RegistryObject<Item> NUKA_COLA_QUANTUM_CAP = ITEMS.register("quantum_cap", () -> new Item(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD)));
    public static final RegistryObject<Item> NUKA_COLA_VICTORY_CAP = ITEMS.register("victory_cap", () -> new Item(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD)));
    public static final RegistryObject<Item> NUKA_COLA_MIX_CAP = ITEMS.register("mix_cap", () -> new Item(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD)));
    public static final RegistryObject<Item> NUKA_COLA_CIDE_CAP = ITEMS.register("cide_cap", () -> new Item(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD)));

    /* -------------------- NUKA-COLAS -------------------- */
    public static final RegistryObject<Item> NUKA_COLA = ITEMS.register("nuka_cola", () -> new NukaCola(ModBlocks.NUKA_COLA.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COLA), NukaFlavours.NUKA_COLA));
    public static final RegistryObject<Item> NUKA_COLA_CHERRY = ITEMS.register("nuka_cola_cherry", () -> new NukaCola(ModBlocks.NUKA_COLA_CHERRY.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COLA_CHERRY), NukaFlavours.NUKA_COLA_CHERRY));
    public static final RegistryObject<Item> NUKA_COLA_DARK = ITEMS.register("nuka_cola_dark", () -> new NukaCola(ModBlocks.NUKA_COLA_DARK.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COLA_DARK), NukaFlavours.NUKA_COLA_DARK));
    public static final RegistryObject<Item> NUKA_COLA_GRAPE = ITEMS.register("nuka_cola_grape", () -> new NukaCola(ModBlocks.NUKA_COLA_GRAPE.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COLA_GRAPE), NukaFlavours.NUKA_COLA_GRAPE));
    public static final RegistryObject<Item> NUKA_COLA_ORANGE = ITEMS.register("nuka_cola_orange", () -> new NukaCola(ModBlocks.NUKA_COLA_ORANGE.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COLA_ORANGE), NukaFlavours.NUKA_COLA_ORANGE));
    public static final RegistryObject<Item> NUKA_COLA_QUARTZ = ITEMS.register("nuka_cola_quartz", () -> new NukaCola(ModBlocks.NUKA_COLA_QUARTZ.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COLA_QUARTZ), NukaFlavours.NUKA_COLA_QUARTZ));
    public static final RegistryObject<Item> NUKA_COLA_WILD = ITEMS.register("nuka_cola_wild", () -> new NukaCola(ModBlocks.NUKA_COLA_WILD.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COLA_WILD), NukaFlavours.NUKA_COLA_WILD));
    public static final RegistryObject<Item> NUKA_COLA_QUANTUM = ITEMS.register("nuka_cola_quantum", () -> new NukaCola(ModBlocks.NUKA_COLA_QUANTUM.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COLA_QUANTUM), NukaFlavours.NUKA_COLA_QUANTUM));
    public static final RegistryObject<Item> NUKA_COLA_VICTORY = ITEMS.register("nuka_cola_victory", () -> new NukaCola(ModBlocks.NUKA_COLA_VICTORY.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COLA_VICTORY), NukaFlavours.NUKA_COLA_VICTORY));

    /* -------------------- MIXS -------------------- */
    public static final RegistryObject<Item> NEWKA_COLA = ITEMS.register("newka_cola", () -> new NukaCola(ModBlocks.NEWKA_COLA.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NEWKA_COLA), NukaFlavours.NEWKA_COLA));
    public static final RegistryObject<Item> NUKA_BERRY = ITEMS.register("nuka_berry", () -> new NukaCola(ModBlocks.NUKA_BERRY.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_BERRY), NukaFlavours.NUKA_BERRY));
    public static final RegistryObject<Item> NUKA_BOMBDROP = ITEMS.register("nuka_bombdrop", () -> new NukaCola(ModBlocks.NUKA_BOMBDROP.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_BOMBDROP), NukaFlavours.NUKA_BOMBDROP));
    public static final RegistryObject<Item> NUKA_BUZZ = ITEMS.register("nuka_buzz", () -> new NukaCola(ModBlocks.NUKA_BUZZ.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_BUZZ), NukaFlavours.NUKA_BUZZ));
    public static final RegistryObject<Item> NUKA_CIDE = ITEMS.register("nuka_cide", () -> new NukaCola(ModBlocks.NUKA_CIDE.get(), new Item.Properties().rarity(Rarity.EPIC).tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_CIDE), NukaFlavours.NUKA_CIDE));
    public static final RegistryObject<Item> NUKA_COOLER = ITEMS.register("nuka_cooler", () -> new NukaCola(ModBlocks.NUKA_COOLER.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_COOLER), NukaFlavours.NUKA_COOLER));
    public static final RegistryObject<Item> NUKA_FANCY = ITEMS.register("nuka_fancy", () -> new NukaCola(ModBlocks.NUKA_FANCY.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_FANCY), NukaFlavours.NUKA_FANCY));
    public static final RegistryObject<Item> NUKA_FREE = ITEMS.register("nuka_free", () -> new NukaCola(ModBlocks.NUKA_FREE.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_FREE), NukaFlavours.NUKA_FREE));
    public static final RegistryObject<Item> NUKA_FRUTTI = ITEMS.register("nuka_frutti", () -> new NukaCola(ModBlocks.NUKA_FRUTTI.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_FRUTTI), NukaFlavours.NUKA_FRUTTI));
    public static final RegistryObject<Item> NUKA_HEARTY = ITEMS.register("nuka_hearty", () -> new NukaCola(ModBlocks.NUKA_HEARTY.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_HEARTY), NukaFlavours.NUKA_HEARTY));
    public static final RegistryObject<Item> NUKA_LIXIR = ITEMS.register("nuka_lixir", () -> new NukaCola(ModBlocks.NUKA_LIXIR.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_LIXIR), NukaFlavours.NUKA_LIXIR));
    public static final RegistryObject<Item> NUKA_LOVE = ITEMS.register("nuka_love", () -> new NukaCola(ModBlocks.NUKA_LOVE.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_LOVE), NukaFlavours.NUKA_LOVE));
    public static final RegistryObject<Item> NUKA_POWER = ITEMS.register("nuka_power", () -> new NukaCola(ModBlocks.NUKA_POWER.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_POWER), NukaFlavours.NUKA_POWER));
    public static final RegistryObject<Item> NUKA_PUNCH = ITEMS.register("nuka_punch", () -> new NukaCola(ModBlocks.NUKA_PUNCH.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_PUNCH), NukaFlavours.NUKA_PUNCH));
    public static final RegistryObject<Item> NUKA_RAY = ITEMS.register("nuka_ray", () -> new NukaCola(ModBlocks.NUKA_RAY.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_RAY), NukaFlavours.NUKA_RAY));
    public static final RegistryObject<Item> NUKA_RUSH = ITEMS.register("nuka_rush", () -> new NukaCola(ModBlocks.NUKA_RUSH.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_RUSH), NukaFlavours.NUKA_RUSH));
    public static final RegistryObject<Item> NUKA_SUNRISE = ITEMS.register("nuka_sunrise", () -> new NukaCola(ModBlocks.NUKA_SUNRISE.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_SUNRISE), NukaFlavours.NUKA_SUNRISE));
    public static final RegistryObject<Item> NUKA_TWIN = ITEMS.register("nuka_twin", () -> new NukaCola(ModBlocks.NUKA_TWIN.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_TWIN), NukaFlavours.NUKA_TWIN));
    public static final RegistryObject<Item> NUKA_VOID = ITEMS.register("nuka_void", () -> new NukaCola(ModBlocks.NUKA_VOID.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_VOID), NukaFlavours.NUKA_VOID));
    public static final RegistryObject<Item> NUKA_XTREME = ITEMS.register("nuka_xtreme", () -> new NukaCola(ModBlocks.NUKA_XTREME.get(), new Item.Properties().tab(ModCreativeTabs.NUKA_COLAS).food(ModFoods.NUKA_XTREME), NukaFlavours.NUKA_XTREME));

    /* -------------------- OTHER ITEMS -------------------- */
    public static final RegistryObject<Item> EMPTY_ROCKET_BOTTLE = ITEMS.register("empty_rocket_bottle", () -> new EmptyRocketBottle(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD)));
    public static final RegistryObject<Item> WATER_ROCKET_BOTTLE = ITEMS.register("water_rocket_bottle", () -> new Item(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD)));
    public static final RegistryObject<Item> SUGAR_ROCKET_BOTTLE = ITEMS.register("sugar_rocket_bottle", () -> new Item(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD).food(ModFoods.SUGAR_BOTTLE)));
    public static final RegistryObject<Item> NUKA_WORLD_THEME = ITEMS.register("nuka_world_theme_disc", () -> new RecordItem(4, ModSounds.NUKA_WORLD_THEME, new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD).stacksTo(1).rarity(Rarity.RARE), 1580));
    public static final RegistryObject<Item> BOTTLE_OPENER = ITEMS.register("bottle_opener", () -> new Item(new Item.Properties().stacksTo(1).tab(ModCreativeTabs.NUKA_WORLD)));
    public static final RegistryObject<Item> CONCENTRATED_SUGAR = ITEMS.register("concentrated_sugar", () -> new Item(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD)));
    public static final RegistryObject<Item> TATO = ITEMS.register("tato", () -> new ItemNameBlockItem(ModBlocks.TATO_PLANT.get(), new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.TATO)));
    public static final RegistryObject<Item> CARROT_FLOWER = ITEMS.register("carrot_flower", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.CARROT_FLOWER)));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.ORANGE)));
    public static final RegistryObject<Item> RUM = ITEMS.register("rum", () -> new AlcoholDrink(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD).food(ModFoods.ALCOHOL)));
    public static final RegistryObject<Item> VODKA = ITEMS.register("vodka", () -> new AlcoholDrink(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD).food(ModFoods.ALCOHOL)));
    public static final RegistryObject<Item> BOURBON = ITEMS.register("bourbon", () -> new AlcoholDrink(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD).food(ModFoods.ALCOHOL)));
    public static final RegistryObject<Item> DIRTY_WATER = ITEMS.register("dirty_water", () -> new AlcoholDrink(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD).food(ModFoods.ALCOHOL)));
    public static final RegistryObject<Item> MED_X = ITEMS.register("med_x", () -> new MedXItem(new Item.Properties().tab(ModCreativeTabs.NUKA_WORLD)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}