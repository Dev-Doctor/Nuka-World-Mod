package net.devdoctor.nukaworld.CreativeTabs;

import net.devdoctor.nukaworld.Items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeTabs {
    public static final CreativeModeTab NUKA_COLAS = new CreativeModeTab("nukacola_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.NUKA_COLA.get());
        }
    };


    public static final CreativeModeTab NUKA_WORLD = new CreativeModeTab("nukaworld_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.NUKA_COLA_VICTORY.get());
        }
    };

}
