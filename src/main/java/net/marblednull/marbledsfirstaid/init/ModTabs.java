package net.marblednull.marbledsfirstaid.init;

import net.marblednull.marbledsfirstaid.MarbledsFirstAid;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.marblednull.marbledsfirstaid.MarbledsFirstAid.MODID;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MarbledsFirstAid.MODID);

    public static final Supplier<CreativeModeTab> TABS = CREATIVE_MODE_TABS.register("marbledsfirstaidtab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MODID + ".marbleds_first_aid_tab"))
            .icon(() -> new ItemStack(ModItems.MEDKIT.get()))
            .displayItems((params, output) -> {
                output.accept(ModItems.MEDKIT.get());
                output.accept(ModItems.BANDAGES.get());
                output.accept(ModItems.PAIN_PILLS.get());
                output.accept(ModItems.BANDAID.get());
                output.accept(ModItems.CLOTH.get());
                output.accept(ModItems.MEDICINE_BOTTLE.get());
                output.accept(ModItems.AWKWARD_MEDICINE_BOTTLE.get());
                output.accept(ModItems.MORPHINE.get());
                output.accept(ModItems.EYE_DROPS.get());
                output.accept(ModItems.ANTIDOTE.get());
                output.accept(ModItems.TONIC.get());
                output.accept(ModItems.STIMPACK.get());
                output.accept(ModItems.ADRENALINE_SYRINGE.get());
            })
            .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}