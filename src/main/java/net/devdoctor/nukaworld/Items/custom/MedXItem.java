package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.effect.ModEffects;
import net.devdoctor.nukaworld.sound.ModSounds;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class MedXItem extends Item {

    public MedXItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        Player player = pLivingEntity instanceof Player ? (Player)pLivingEntity : null;

        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, pStack);
        }

        if(!pLevel.isClientSide()) {
            pStack.shrink(1);
            player.addEffect(new MobEffectInstance(ModEffects.POISON_RESISTANCE.get(), 3600));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600));
        }

        if (player != null) {
            pLevel.playSound(player, player, ModSounds.USE_MED.get(), SoundSource.PLAYERS, 100, 0);

            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                pStack.shrink(1);
            }
        }

        pLivingEntity.gameEvent(GameEvent.DRINK);
        return pStack;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 25;
    }
}
