package net.lokoloky.polypsyche.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent COLIFLOWER = new FoodComponent.Builder().
            nutrition(3).
            saturationModifier(0.25f).
            statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1), 1.0f).
            build();
}
