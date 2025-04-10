package net.marblednull.marbledsfirstaid.event;

import net.marblednull.marbledsfirstaid.MarbledsFirstAid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "marbledsfirstaid");

    public static final DeferredHolder<SoundEvent, SoundEvent> MEDKIT = registerSoundEvents("medkit");
    public static final DeferredHolder<SoundEvent, SoundEvent> SYRINGE = registerSoundEvents("syringe");
    public static final DeferredHolder<SoundEvent, SoundEvent> BANDAGES = registerSoundEvents("bandages");
    public static final DeferredHolder<SoundEvent, SoundEvent> EYE_DROPS = registerSoundEvents("eye_drops");
    public static final DeferredHolder<SoundEvent, SoundEvent> PAIN_PILLS = registerSoundEvents("pain_pills");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MarbledsFirstAid.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
