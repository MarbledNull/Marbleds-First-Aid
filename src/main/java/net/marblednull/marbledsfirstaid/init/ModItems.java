package net.marblednull.marbledsfirstaid.init;

import net.marblednull.marbledsfirstaid.MarbledsFirstAid;
import net.marblednull.marbledsfirstaid.init.firstaiditems.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MarbledsFirstAid.MODID);

    public static final RegistryObject<Item> CLOTH = ITEMS.register("cloth", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDICINE_BOTTLE = ITEMS.register("medicine_bottle", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AWKWARD_MEDICINE_BOTTLE = ITEMS.register("awkward_medicine_bottle", () -> new Item(new Item.Properties().food(ModFoods.AWKWARD_MEDICINE_BOTTLE).craftRemainder(ModItems.MEDICINE_BOTTLE.get())));
    public static final RegistryObject<Item> SYRINGE = ITEMS.register("syringe", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AWKWARD_SYRINGE = ITEMS.register("awkward_syringe", () -> new Item(new Item.Properties()));
    //first aid items
    public static final RegistryObject<Item> MEDKIT = ITEMS.register("medkit", () -> new MedkitItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BANDAGES = ITEMS.register("bandages", () -> new BandagesItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BANDIAD = ITEMS.register("bandaid", () -> new BandaidItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PAIN_PILLS = ITEMS.register("pain_pills", () -> new PainPillsItem(new Item.Properties().stacksTo(16)));
    //medicines
    public static final RegistryObject<Item> MORPHINE = ITEMS.register("morphine", () -> new MorphineItem(new Item.Properties().food(ModFoods.MORPHINE).stacksTo(1).craftRemainder(ModItems.MEDICINE_BOTTLE.get())));
    public static final RegistryObject<Item> EYE_DROPS = ITEMS.register("eye_drops", () -> new EyeDropsItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TONIC = ITEMS.register("tonic", () -> new TonicItem(new Item.Properties().food(ModFoods.TONIC).stacksTo(1).craftRemainder(ModItems.MEDICINE_BOTTLE.get())));
    public static final RegistryObject<Item> ANTIDOTE = ITEMS.register("antidote", () -> new AntidoteItem(new Item.Properties().food(ModFoods.ANTIDOTE).stacksTo(1).craftRemainder(ModItems.MEDICINE_BOTTLE.get())));
    public static final RegistryObject<Item> ELIXIR = ITEMS.register("elixir", () -> new ElixirItem(new Item.Properties().food(ModFoods.ELIXIR).stacksTo(1)));
    //syringes
    public static final RegistryObject<Item> STIMPACK = ITEMS.register("stimpack", () -> new StimpackItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ADRENALINE_SYRINGE = ITEMS.register("adrenaline_syringe", () -> new AdrenalineSyringeItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MORPHINE_SYRINGE = ITEMS.register("morphine_syringe", () -> new MorphineSyringeItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
