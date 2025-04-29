package net.araytar.spaaace.datagen.DimGen;

import net.minecraft.core.WritableRegistry;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Registries {
    public static WritableRegistry<DimensionSpecialEffect> DIMENSION_SPECIAL_EFFECTS;
    public static DeferredRegister<DimensionType> DIMENSION_TYPES;
    public static DeferredRegister<LevelStem> LEVEL_STEMS;
}
