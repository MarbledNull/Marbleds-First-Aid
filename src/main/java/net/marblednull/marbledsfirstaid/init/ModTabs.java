package net.marblednull.marbledsfirstaid.init;

import net.marblednull.marbledsfirstaid.MarbledsFirstAid;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.marblednull.marbledsfirstaid.MarbledsFirstAid.MODID;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MarbledsFirstAid.MODID);

    public static final RegistryObject<CreativeModeTab> MARBLEDS_FIRST_AID = TABS.register("marbleds_first_aid",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MODID + ".marbleds_first_aid_tab"))
                    .icon(() -> new ItemStack(ModItems.MEDKIT.get()))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.MEDKIT.get());
                        output.accept(ModItems.BANDAGES.get());
                        output.accept(ModItems.PAIN_PILLS.get());
                        output.accept(ModItems.BANDIAD.get());
                        output.accept(ModItems.CLOTH.get());
                        output.accept(ModItems.MEDICINE_BOTTLE.get());
                        output.accept(ModItems.AWKWARD_MEDICINE_BOTTLE.get());
                        output.accept(ModItems.MORPHINE.get());
                        output.accept(ModItems.EYE_DROPS.get());
                        output.accept(ModItems.ANTIDOTE.get());
                        output.accept(ModItems.TONIC.get());
                        output.accept(ModItems.ELIXIR.get());
                        output.accept(ModItems.SYRINGE.get());
                        output.accept(ModItems.AWKWARD_SYRINGE.get());
                        output.accept(ModItems.ADRENALINE_SYRINGE.get());
                        output.accept(ModItems.MORPHINE_SYRINGE.get());
                        output.accept(ModItems.STIMPACK.get());
                    })
                    .build()
    );
    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
