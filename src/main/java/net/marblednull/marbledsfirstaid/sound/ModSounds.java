package net.marblednull.marbledsfirstaid.sound;

import net.marblednull.marbledsfirstaid.MarbledsFirstAid;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MarbledsFirstAid.MODID);

    public static final RegistryObject<SoundEvent> MEDKIT = registerSoundEvents("medkit");
    public static final RegistryObject<SoundEvent> STIM = registerSoundEvents("stim");
    public static final RegistryObject<SoundEvent> BANDAGES = registerSoundEvents("bandages");
    public static final RegistryObject<SoundEvent> EYE_DROPS = registerSoundEvents("eye_drops");
    public static final RegistryObject<SoundEvent> PAIN_PILLS = registerSoundEvents("pain_pills");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MarbledsFirstAid.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
