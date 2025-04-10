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

    public MedkitItem(Properties p_41346_) {
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
            player.heal(20f);
            player.getCooldowns().addCooldown(this, 200);
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        return stack;
    }

    public UseAnim getUseAnimation(ItemStack p_41358_) {
        return UseAnim.BOW;
    }

    public int getUseDuration(ItemStack p_41360_) {
        return 100;
    }

    private static void play(Level level, Player player) {
        level.playSound(player, player, ModSounds.MEDKIT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        level.gameEvent(GameEvent.ITEM_INTERACT_START, player.position(), GameEvent.Context.of(player));
    }

    public void appendHoverText(ItemStack p_41211_, @Nullable Level p_41212_, List<Component> p_41213_, TooltipFlag p_41214_) {
        {
            p_41213_.add(CommonComponents.EMPTY);
            p_41213_.add(Component.translatable("item.marbledsfirstaid.medkit.desc1").withStyle(ChatFormatting.GRAY));
            p_41213_.add(CommonComponents.space().append(Component.translatable("item.marbledsfirstaid.medkit.desc2")).withStyle(ChatFormatting.BLUE));
        }
    }
}
