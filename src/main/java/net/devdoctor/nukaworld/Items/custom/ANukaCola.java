package net.devdoctor.nukaworld.Items.custom;

import net.devdoctor.nukaworld.Items.ModItems;
import net.devdoctor.nukaworld.NukaFlavours;
import net.devdoctor.nukaworld.sound.ModSounds;
import net.devdoctor.nukaworld.util.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.internal.TextComponentMessageFormatHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class ANukaCola extends BlockItem {
    private final NukaFlavours flavour;

    public ANukaCola(Block pBlock, Properties pProperties, NukaFlavours flavour) {
        super(pBlock, pProperties);
        this.flavour = flavour;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        if(this.flavour.effects == null) {
            pTooltip.add(Component.translatable("item.tooltip.nukaworld.nukacola.missingeffects").withStyle(ChatFormatting.RED));
        }
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return (flavour.rarity == null) ? super.getRarity(pStack) : flavour.rarity;
    }

    // Give the ability to drink the NukaCola only if the player has a bottle opener in the hand slot.
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(pPlayer.getOffhandItem().is(ModTags.Items.BOTTLE_OPENERS)) {
            return super.use(pLevel, pPlayer, pUsedHand);
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

    // Set the condition to crouch if the player wants to place the NukaCola
    @Override
    public @NotNull InteractionResult place(BlockPlaceContext pContext) {
        if(pContext.getPlayer().isShiftKeyDown()) {
            return super.place(pContext);
        }
        return InteractionResult.FAIL;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        Player player = pLivingEntity instanceof Player ? (Player)pLivingEntity : null;

        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, pStack);
        }

        // PLAY DRINK SOUND
        pLevel.playSound(player, player.blockPosition(), ModSounds.NUKA_COLA_DRINK.get(), SoundSource.PLAYERS, 10, 1);

        if (!pLevel.isClientSide && flavour.effects != null) {
            for(MobEffectInstance effect : flavour.effects) {
                if (effect.getEffect().isInstantenous()) {
                    effect.getEffect().applyInstantenousEffect(player, player, pLivingEntity, effect.getAmplifier(), 1.0D);
                } else {
                    pLivingEntity.addEffect(new MobEffectInstance(effect));
                }
            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                pStack.shrink(1);
            }
        }

        if (player == null || !player.getAbilities().instabuild) {
            player.getInventory().add(new ItemStack(ModItems.EMPTY_ROCKET_BOTTLE.get()));
            player.getInventory().add(new ItemStack(flavour.cap_id));
        }

        pLivingEntity.gameEvent(GameEvent.DRINK);
        return pStack;
    }

    // Set the item animation
    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public NukaFlavours getFlavour() {
        return flavour;
    }
}
