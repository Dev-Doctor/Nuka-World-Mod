package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.Items.ModItems;
import net.devdoctor.nukaworld.NukaFlavors;
import net.devdoctor.nukaworld.sound.ModSounds;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class NukaCola extends BlockItem {
    ItemLike CAP_TYPE = NukaFlavors.NUKA_COLA.cap_id;
    private List<MobEffectInstance> effects;
    // effects list array

    private Block block;

    public NukaCola(Block pBlock, Item.Properties pProperties) {
        super(pBlock, pProperties);
        this.block = pBlock;
        this.effects = null;
    }

    @Override
    public ItemStack getDefaultInstance() {
        return new ItemStack(ModItems.EMPTY_ROCKET_BOTTLE.get());
    }

    public NukaCola(Block pBlock, Item.Properties pProperties, NukaFlavors flavour) {
        super(pBlock, pProperties);
        this.CAP_TYPE = flavour.cap_id;
        this.block = pBlock;
        this.effects = flavour.effects;
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
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        Player player = pLivingEntity instanceof Player ? (Player)pLivingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, pStack);
        }

        // PLAY DRINK SOUND
        pLevel.playSound(player, player.blockPosition(), ModSounds.NUKA_COLA_DRINK.get(), SoundSource.PLAYERS, 10, 1);

        // ADD NUKA COLA EFFECTS
        if (!pLevel.isClientSide) {
            if(effects != null) {
                for(MobEffectInstance effect : this.effects) {
                    player.addEffect(effect);
                }
            }
        }

        // REMOVE 1 ITEM
        if (player != null) {
            if (!player.getAbilities().instabuild) {
                pStack.shrink(1);
            }
        }

        // "DROP" LOGIC
        if (player == null || !player.getAbilities().instabuild) {
            if (pStack.isEmpty()) {
                player.getInventory().add(new ItemStack(CAP_TYPE));
                return new ItemStack(ModItems.EMPTY_ROCKET_BOTTLE.get());
            }

            if (player != null) {
                player.getInventory().add(new ItemStack(ModItems.EMPTY_ROCKET_BOTTLE.get()));
                player.getInventory().add(new ItemStack(CAP_TYPE));
            }
        }

        return pStack;
    }
}
