package net.marblednull.marbledsfirstaid.init.firstaiditems;

import net.marblednull.marbledsfirstaid.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class MorphineItem extends Item {

    public MorphineItem(Properties p_41346_) {
        super(p_41346_);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        super.finishUsingItem(stack, level, entity);
        if (entity instanceof ServerPlayer $$3) {
            CriteriaTriggers.CONSUME_ITEM.trigger($$3, stack);
            $$3.awardStat(Stats.ITEM_USED.get(this));
        }

        if (stack.isEmpty()) {
            return new ItemStack(ModItems.MEDICINE_BOTTLE.get());
        } else {
            if (entity instanceof Player && !((Player)entity).getAbilities().instabuild) {
                ItemStack $$4 = new ItemStack(ModItems.MEDICINE_BOTTLE.get());
                Player $$5 = (Player)entity;
                if (!$$5.getInventory().add($$4)) {
                    $$5.drop($$4, false);
                }
            }

            return stack;
        }
    }

    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 40;
    }

    public InteractionResult use(Level level, Player p_41353_, InteractionHand p_41354_) {
        return ItemUtils.startUsingInstantly(level, p_41353_, p_41354_);
    }

    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        {
            tooltipComponents.add(CommonComponents.EMPTY);
            tooltipComponents.add(Component.translatable("item.marbledsfirstaid.morphine.desc1").withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.morphine.desc2")).withStyle(ChatFormatting.BLUE));
            tooltipComponents.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.morphine.desc3")).withStyle(ChatFormatting.BLUE));
        }
    }
}
