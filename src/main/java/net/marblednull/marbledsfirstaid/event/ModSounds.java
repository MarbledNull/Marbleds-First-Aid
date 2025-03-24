package net.marblednull.marbledsfirstaid.event;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "marbledsfirstaid");

    public static final DeferredHolder<SoundEvent, SoundEvent> MEDKIT = SOUND_EVENTS.register(
            "medkit",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("marbledsfirstaid", "medkit"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> STIM = SOUND_EVENTS.register(
            "stim",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("marbledsfirstaid", "stim"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BANDAGES = SOUND_EVENTS.register(
            "bandages",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("marbledsfirstaid", "bandages"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> EYE_DROPS = SOUND_EVENTS.register(
            "eye_drops",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("marbledsfirstaid", "eye_drops"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> PAIN_PILLS = SOUND_EVENTS.register(
            "pain_pills",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("marbledsfirstaid", "pain_pills"))
    );

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
