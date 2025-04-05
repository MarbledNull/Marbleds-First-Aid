package net.marblednull.marbledsfirstaid.event;

import net.marblednull.marbledsfirstaid.MarbledsFirstAid;
import net.marblednull.marbledsfirstaid.init.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = MarbledsFirstAid.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModRecipes {
    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        //medicines
        event.getBuilder().addRecipe(Ingredient.of(ModItems.MEDICINE_BOTTLE), Ingredient.of(PotionContents.createItemStack(Items.POTION, Potions.AWKWARD)), new ItemStack(ModItems.AWKWARD_MEDICINE_BOTTLE.get()));
        event.getBuilder().addRecipe(Ingredient.of(ModItems.AWKWARD_MEDICINE_BOTTLE), Ingredient.of(new ItemStack(Items.BONE_MEAL)), new ItemStack(ModItems.EYE_DROPS.get()));
        event.getBuilder().addRecipe(Ingredient.of(ModItems.AWKWARD_MEDICINE_BOTTLE), Ingredient.of(new ItemStack(Items.AMETHYST_SHARD)), new ItemStack(ModItems.TONIC.get()));
        event.getBuilder().addRecipe(Ingredient.of(ModItems.AWKWARD_MEDICINE_BOTTLE), Ingredient.of(new ItemStack(Items.COPPER_INGOT)), new ItemStack(ModItems.ANTIDOTE.get()));
        event.getBuilder().addRecipe(Ingredient.of(ModItems.AWKWARD_MEDICINE_BOTTLE), Ingredient.of(new ItemStack(Items.FERMENTED_SPIDER_EYE)), new ItemStack(ModItems.MORPHINE.get()));
        event.getBuilder().addRecipe(Ingredient.of(ModItems.AWKWARD_MEDICINE_BOTTLE), Ingredient.of(new ItemStack(Items.IRON_INGOT)), new ItemStack(ModItems.ELIXIR.get()));
        //syringes
        event.getBuilder().addRecipe(Ingredient.of(ModItems.SYRINGE), Ingredient.of(PotionContents.createItemStack(Items.POTION, Potions.AWKWARD)), new ItemStack(ModItems.AWKWARD_SYRINGE.get()));
        event.getBuilder().addRecipe(Ingredient.of(ModItems.AWKWARD_SYRINGE), Ingredient.of(new ItemStack(Items.RABBIT_FOOT)), new ItemStack(ModItems.ADRENALINE_SYRINGE.get()));
        event.getBuilder().addRecipe(Ingredient.of(ModItems.AWKWARD_SYRINGE), Ingredient.of(new ItemStack(Items.FERMENTED_SPIDER_EYE)), new ItemStack(ModItems.MORPHINE_SYRINGE.get()));
        event.getBuilder().addRecipe(Ingredient.of(ModItems.AWKWARD_SYRINGE), Ingredient.of(new ItemStack(Items.GLOWSTONE_DUST)), new ItemStack(ModItems.STIMPACK.get()));
    }
}
