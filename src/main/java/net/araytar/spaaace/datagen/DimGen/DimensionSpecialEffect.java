package net.araytar.spaaace.datagen.DimGen;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class DimensionSpecialEffect extends DimensionSpecialEffects {

    private final Supplier<Vec3> fogColorSupplier;
    private final Supplier<Boolean> isFoggyCheckSupplier;

    public DimensionSpecialEffect(float cloudLevel, boolean hasGround, SkyType skyType, boolean forceBrightLightmap, boolean constantAmbientLight, Supplier<Vec3> fogColorSupplier, Supplier<Boolean> isFoggyCheckSupplier) {
        super(cloudLevel, hasGround, skyType, forceBrightLightmap, constantAmbientLight);

        this.fogColorSupplier = fogColorSupplier;
        this.isFoggyCheckSupplier = isFoggyCheckSupplier;
    }

    @Override
    @NotNull
    public Vec3 getBrightnessDependentFogColor(@NotNull Vec3 originalColor, float timeOfDay) {
        if (isFoggyCheckSupplier.get() != null) {
            return fogColorSupplier.get();
        } else {
            return originalColor;
        }
    }

    @Override
    public boolean isFoggyAt(int i, int i1) {
        return isFoggyCheckSupplier.get();
    }
}
