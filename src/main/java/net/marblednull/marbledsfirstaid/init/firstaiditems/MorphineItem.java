package net.marblednull.marbledsfirstaid.init.firstaiditems;

import net.marblednull.marbledsfirstaid.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class MorphineItem extends Item {
    private static final int DRINK_DURATION = 40;

    public MorphineItem(Item.Properties p_41346_) {
        super(p_41346_);
    }

    public ItemStack finishUsingItem(ItemStack p_41348_, Level p_41349_, LivingEntity p_41350_) {
        super.finishUsingItem(p_41348_, p_41349_, p_41350_);
        if (p_41350_ instanceof ServerPlayer $$3) {
            CriteriaTriggers.CONSUME_ITEM.trigger($$3, p_41348_);
            $$3.awardStat(Stats.ITEM_USED.get(this));
        }

        if (p_41348_.isEmpty()) {
            return new ItemStack(ModItems.MEDICINE_BOTTLE.get());
        } else {
            if (p_41350_ instanceof Player && !((Player)p_41350_).getAbilities().instabuild) {
                ItemStack $$4 = new ItemStack(ModItems.MEDICINE_BOTTLE.get());
                Player $$5 = (Player)p_41350_;
                if (!$$5.getInventory().add($$4)) {
                    $$5.drop($$4, false);
                }
            }

            return p_41348_;
        }
    }

    public int getUseDuration(ItemStack p_41360_) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack p_41358_) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level p_41352_, Player p_41353_, InteractionHand p_41354_) {
        return ItemUtils.startUsingInstantly(p_41352_, p_41353_, p_41354_);
    }

    public void appendHoverText(ItemStack p_41211_, @Nullable Level p_41212_, List<Component> p_41213_, TooltipFlag p_41214_) {
        {
            p_41213_.add(CommonComponents.EMPTY);
            p_41213_.add(Component.translatable("item.marbledsfirstaid.morphine.desc1").withStyle(ChatFormatting.GRAY));
            p_41213_.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.morphine.desc2")).withStyle(ChatFormatting.BLUE));
            p_41213_.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.morphine.desc3")).withStyle(ChatFormatting.BLUE));
        }
    }
}
