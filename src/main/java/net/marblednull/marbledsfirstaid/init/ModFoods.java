package net.marblednull.marbledsfirstaid.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties MORPHINE = new FoodProperties.Builder().nutrition(0).saturationMod(0.0f).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0, false, false, false), 1.0f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0, false, false, false), 1.0f).build();
    public static final FoodProperties TONIC = new FoodProperties.Builder().nutrition(0).saturationMod(0.0f).alwaysEat().build();
    public static final FoodProperties ANTIDOTE = new FoodProperties.Builder().nutrition(0).saturationMod(0.0f).alwaysEat().build();
    public static final FoodProperties AWKWARD_MEDICINE_BOTTLE = new FoodProperties.Builder().nutrition(0).saturationMod(0.0f).alwaysEat().build();

}
