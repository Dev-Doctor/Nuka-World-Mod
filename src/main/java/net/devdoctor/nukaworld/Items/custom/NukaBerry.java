package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.Items.ModItems;
import net.devdoctor.nukaworld.NukaFlavors;
import net.devdoctor.nukaworld.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class NukaBerry extends BlockItem {
    ItemLike CAP_TYPE = NukaFlavors.NUKA_COLA_MIX.cap_id;
    private Block block;

    public NukaBerry(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
        this.block = pBlock;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(pPlayer.getOffhandItem().is(ModItems.BOTTLE_OPENER.get())) {
            return super.use(pLevel, pPlayer, pUsedHand);
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResult place(BlockPlaceContext pContext) {
        Player p = pContext.getPlayer();
        if(p.isShiftKeyDown()) {
            return super.place(pContext);
        }
        return InteractionResult.FAIL;
    }

    @Override
    public SoundEvent getEatingSound() {
        return ModSounds.NUKA_COLA_DRINK.get();
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if(pLivingEntity instanceof Player) {
            Player player = (Player) pLivingEntity;
            player.addItem(new ItemStack(ModItems.EMPTY_ROCKET_BOTTLE.get(), 1));
            player.addItem(new ItemStack(CAP_TYPE, 1));
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
