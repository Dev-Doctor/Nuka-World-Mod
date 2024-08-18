package net.devdoctor.nukaworld.Items.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class AlcoholDrink extends Item {

    public AlcoholDrink(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull SoundEvent getEatingSound() {
        return super.getDrinkingSound();
    }
}
