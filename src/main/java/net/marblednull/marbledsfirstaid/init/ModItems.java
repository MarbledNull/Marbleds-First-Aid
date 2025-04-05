package net.marblednull.marbledsfirstaid.init;

import net.marblednull.marbledsfirstaid.MarbledsFirstAid;
import net.marblednull.marbledsfirstaid.init.firstaiditems.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MarbledsFirstAid.MODID);

    public static final DeferredItem<Item> CLOTH = ITEMS.registerItem("cloth", Item::new, new Item.Properties());
    public static final DeferredItem<Item> MEDICINE_BOTTLE = ITEMS.registerItem("medicine_bottle", Item::new, new Item.Properties());
    public static final DeferredItem<Item> AWKWARD_MEDICINE_BOTTLE = ITEMS.registerItem("awkward_medicine_bottle", Item::new, new Item.Properties());
    public static final DeferredItem<Item> SYRINGE = ITEMS.registerItem("syringe", Item::new, new Item.Properties());
    public static final DeferredItem<Item> AWKWARD_SYRINGE = ITEMS.registerItem("awkward_syringe", Item::new, new Item.Properties());
    //first aid items
    public static final DeferredItem<Item> MEDKIT = ITEMS.registerItem("medkit", MedkitItem::new, new Item.Properties().stacksTo(1).useCooldown(10f));
    public static final DeferredItem<Item> BANDAGES = ITEMS.registerItem("bandages", BandagesItem::new, new Item.Properties().stacksTo(16).useCooldown(5f));
    public static final DeferredItem<Item> BANDAID = ITEMS.registerItem("bandaid", BandaidItem::new, new Item.Properties().stacksTo(16).useCooldown(1f));
    public static final DeferredItem<Item> PAIN_PILLS = ITEMS.registerItem("pain_pills", PainPillsItem::new, new Item.Properties().stacksTo(16).useCooldown(2f));
    //medicines
    public static final DeferredItem<Item> MORPHINE = ITEMS.registerItem("morphine", MorphineItem::new, new Item.Properties().useCooldown(2).component(DataComponents.CONSUMABLE, Consumable.builder().sound(SoundEvents.HONEY_DRINK).soundAfterConsume(SoundEvents.HONEY_DRINK).animation(ItemUseAnimation.DRINK).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0, false, false, false), 1.0f)).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0, false, false, false), 1.0f)).build()));
    public static final DeferredItem<Item> EYE_DROPS = ITEMS.registerItem("eye_drops", EyeDropsItem::new, new Item.Properties().useCooldown(1));
    public static final DeferredItem<Item> TONIC = ITEMS.registerItem("tonic", TonicItem::new, new Item.Properties().food(new FoodProperties.Builder().build()));
    public static final DeferredItem<Item> ANTIDOTE = ITEMS.registerItem("antidote", AntidoteItem::new, new Item.Properties());
    public static final DeferredItem<Item> ELIXIR = ITEMS.registerItem("elixir", Item::new, new Item.Properties());
    //syringes
    public static final DeferredItem<Item> STIMPACK = ITEMS.registerItem("stimpack", StimpackItem::new, new Item.Properties().useCooldown(5f));
    public static final DeferredItem<Item> ADRENALINE_SYRINGE = ITEMS.registerItem("adrenaline_syringe", AdrenalineSyringeItem::new, new Item.Properties().useCooldown(5f));
    public static final DeferredItem<Item> MORPHINE_SYRINGE = ITEMS.registerItem("morphine_syringe", MorphineSyringeItem::new, new Item.Properties().useCooldown(5f));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
