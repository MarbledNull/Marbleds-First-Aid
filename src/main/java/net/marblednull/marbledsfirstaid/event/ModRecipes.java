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
        event.getBuilder().addRecipe(Ingredient.of(ModItems.MEDICINE_BOTTLE), Ingredient.of(PotionContents.createItemStack(Items.POTION, Potions.AWKWARD)), new ItemStack(ModItems.AWKWARD_MEDICINE_BOTTLE.get()));
    }
}
