package net.marblednull.marbledsfirstaid.init.firstaiditems;

import net.marblednull.marbledsfirstaid.events.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
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

import javax.annotation.Nullable;
import java.util.List;

public class PainPillsItem extends Item {

    public PainPillsItem(Properties p_41346_) {
        super(p_41346_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        play(level, player);
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            player.getCooldowns().addCooldown(this, 40);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0, false, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 0, false, false, false));
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        return stack;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    public int getUseDuration(ItemStack stack) {
        return 20;
    }

    private static void play(Level level, Player player) {
        level.playSound(player, player, ModSounds.PAIN_PILLS.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        level.gameEvent(GameEvent.ITEM_INTERACT_START, player.position(), GameEvent.Context.of(player));
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        {
            tooltipComponents.add(CommonComponents.EMPTY);
            tooltipComponents.add(Component.translatable("item.marbledsfirstaid.whenused.desc1").withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.pain_pills.desc1")).withStyle(ChatFormatting.BLUE));
            tooltipComponents.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.pain_pills.desc2")).withStyle(ChatFormatting.BLUE));
        }
    }
}
