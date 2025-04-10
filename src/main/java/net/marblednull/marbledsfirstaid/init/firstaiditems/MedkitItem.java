package net.marblednull.marbledsfirstaid.init.firstaiditems;

import net.marblednull.marbledsfirstaid.events.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.List;

public class MedkitItem extends Item {

    public MedkitItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        play(level, player);
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            player.heal(20f);
            player.getCooldowns().addCooldown(this, 200);
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
        return 100;
    }

    private static void play(Level level, Player player) {
        level.playSound(player, player, ModSounds.MEDKIT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        level.gameEvent(GameEvent.ITEM_INTERACT_START, player.position(), GameEvent.Context.of(player));
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        {
            tooltipComponents.add(CommonComponents.EMPTY);
            tooltipComponents.add(Component.translatable("item.marbledsfirstaid.whenused.desc1").withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.medkit.desc1")).withStyle(ChatFormatting.BLUE));
        }
    }
}
