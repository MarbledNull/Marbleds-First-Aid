package net.marblednull.marbledsfirstaid.init.firstaiditems;

import net.marblednull.marbledsfirstaid.event.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class PainPillsItem extends Item {

    public PainPillsItem(Properties p_41346_) {
        super(p_41346_);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        player.playSound(ModSounds.PAIN_PILLS.get(), 1.0F, 1.0F);
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        return false;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            //player.getCooldowns().addCooldown(this, 40);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0, false, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 0, false, false, false));
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        return stack;
    }

    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BOW;
    }

    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 20;
    }

    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        {
            tooltipComponents.add(CommonComponents.EMPTY);
            tooltipComponents.add(Component.translatable("item.marbledsfirstaid.pain_pills.desc1").withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.pain_pills.desc2")).withStyle(ChatFormatting.BLUE));
            tooltipComponents.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.pain_pills.desc3")).withStyle(ChatFormatting.BLUE));
        }
    }
}
