package net.marblednull.marbledsfirstaid.init.firstaiditems;

import net.marblednull.marbledsfirstaid.init.ModItems;
import net.marblednull.marbledsfirstaid.sound.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class EyeDropsItem extends Item {

    public EyeDropsItem(Properties p_41346_) {
        super(p_41346_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.playSound(ModSounds.EYE_DROPS.get(), 1.0F, 1.0F);
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public void releaseUsing(ItemStack p_40875_, Level p_40876_, LivingEntity p_40877_, int p_40878_) {

    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            player.getCooldowns().addCooldown(this, 20);
            player.removeEffect(MobEffects.BLINDNESS);
            player.removeEffect(MobEffects.DARKNESS);
            SoundSource soundsource = entity instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
            level.playSound((Player)null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.EYE_DROPS.get(), soundsource, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.0F + 0.0F) + 0.0F);
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
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
        return stack;
    }

    public UseAnim getUseAnimation(ItemStack p_41358_) {
        return UseAnim.BOW;
    }

    public int getUseDuration(ItemStack p_41360_) {
        return 20;
    }

    public void appendHoverText(ItemStack p_41211_, @Nullable Level p_41212_, List<Component> p_41213_, TooltipFlag p_41214_) {
        {
            p_41213_.add(CommonComponents.EMPTY);
            p_41213_.add(Component.translatable("item.marbledsfirstaid.eye_drops.desc1").withStyle(ChatFormatting.GRAY));
            p_41213_.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.eye_drops.desc2")).withStyle(ChatFormatting.BLUE));
            p_41213_.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.eye_drops.desc3")).withStyle(ChatFormatting.BLUE));
        }
    }
}
