package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.Items.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class EmptyRocketBottle extends BottleItem {

    public EmptyRocketBottle(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return super.use(pLevel, pPlayer, pHand);
    }

    @Override
    protected ItemStack turnBottleIntoItem(ItemStack pBottleStack, Player pPlayer, ItemStack pFilledBottleStack) {
        pFilledBottleStack = new ItemStack(ModItems.WATER_ROCKET_BOTTLE.get());
        return super.turnBottleIntoItem(pBottleStack, pPlayer, pFilledBottleStack);
    }
}
