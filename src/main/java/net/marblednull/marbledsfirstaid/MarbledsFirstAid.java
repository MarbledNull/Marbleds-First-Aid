package net.marblednull.marbledsfirstaid;

import net.marblednull.marbledsfirstaid.events.ModSounds;
import net.marblednull.marbledsfirstaid.init.ModItems;
import net.marblednull.marbledsfirstaid.init.ModTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MarbledsFirstAid.MODID)
public class MarbledsFirstAid
{
    public static final String MODID = "marbledsfirstaid";

    public MarbledsFirstAid(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        ModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        //medicines
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.MEDICINE_BOTTLE.get())), Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)), new ItemStack(ModItems.AWKWARD_MEDICINE_BOTTLE.get())));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.AWKWARD_MEDICINE_BOTTLE.get())), Ingredient.of(new ItemStack(Items.BONE_MEAL)), new ItemStack(ModItems.EYE_DROPS.get())));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.AWKWARD_MEDICINE_BOTTLE.get())), Ingredient.of(new ItemStack(Items.AMETHYST_SHARD)), new ItemStack(ModItems.TONIC.get())));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.AWKWARD_MEDICINE_BOTTLE.get())), Ingredient.of(new ItemStack(Items.COPPER_INGOT)), new ItemStack(ModItems.ANTIDOTE.get())));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.AWKWARD_MEDICINE_BOTTLE.get())), Ingredient.of(new ItemStack(Items.FERMENTED_SPIDER_EYE)), new ItemStack(ModItems.MORPHINE.get())));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.AWKWARD_MEDICINE_BOTTLE.get())), Ingredient.of(new ItemStack(Items.IRON_INGOT)), new ItemStack(ModItems.ELIXIR.get())));
        //syringes
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.SYRINGE.get())), Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)), new ItemStack(ModItems.AWKWARD_SYRINGE.get())));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.AWKWARD_SYRINGE.get())), Ingredient.of(new ItemStack(Items.RABBIT_FOOT)), new ItemStack(ModItems.ADRENALINE_SYRINGE.get())));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.AWKWARD_SYRINGE.get())), Ingredient.of(new ItemStack(Items.FERMENTED_SPIDER_EYE)), new ItemStack(ModItems.MORPHINE_SYRINGE.get())));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(new ItemStack(ModItems.AWKWARD_SYRINGE.get())), Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)), new ItemStack(ModItems.STIMPACK.get())));
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
