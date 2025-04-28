package net.araytar.spaaace.datagen.DimGen;

import net.araytar.spaaace.Spaaace;
import net.araytar.spaaace.datagen.DimGen.models.InfiniburnOptions;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;

import java.util.OptionalLong;

@SuppressWarnings("DuplicateBranchesInSwitch")
public class DimensionBuilder {
    protected MinecraftServer server;

    protected boolean hasSkylight        = false;
    protected boolean hasCeiling         = false;
    protected boolean isUltraWarm        = false;
    protected boolean isNatural          = false;
    protected boolean bedWorks           = false;
    protected boolean respawnAnchorWorks = false;

    protected double coordinateScale      = 1.0;
    protected int    minY                 = 0;
    protected int    maxY                 = 256;
    protected int    logicalHeight        = 256;
    protected float  ambientLight         = 1.0f;
    protected OptionalLong fixedTime      = OptionalLong.empty();
    protected TagKey<Block> infiniburn    = BlockTags.INFINIBURN_OVERWORLD;

    protected DimensionType.MonsterSettings monsterSettings = new DimensionType.MonsterSettings();
    protected ResourceLocation dimensionSpecialEffects  = ResourceLocation.fromNamespaceAndPath("minecraft", "overworld");

    public DimensionBuilder(MinecraftServer server) {
        this.server = server;
    }

    public DimensionBuilder hasSkylight() {
        this.hasSkylight = true;
        return this;
    }

    public DimensionBuilder hasCeiling() {
        this.hasCeiling = true;
        return this;
    }

    public DimensionBuilder isUltraWarm() {
        this.isUltraWarm = true;
        return this;
    }

    public DimensionBuilder isNatural() {
        this.isNatural = true;
        return this;
    }

    public DimensionBuilder BedWorks() {
        this.bedWorks = true;
        return this;
    }

    public DimensionBuilder respawnAnchorWorks() {
        this.respawnAnchorWorks = true;
        return this;
    }

    public DimensionBuilder coordinateScale(double scale) {
        this.coordinateScale = scale;
        return this;
    }

    public DimensionBuilder minY(int minY) {
        this.minY = minY;
        return this;
    }

    public DimensionBuilder maxY(int maxY) {
        this.maxY = maxY;
        return this;
    }

    public DimensionBuilder logicalHeight(int logicalHeight) {
        this.logicalHeight = logicalHeight;
        return this;
    }

    public DimensionBuilder ambientLight(float ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    public DimensionBuilder fixedTime(Long fixedTime) {
        this.fixedTime = OptionalLong.of(fixedTime);
        return this;
    }

    public DimensionBuilder infiniburn(InfiniburnOptions setting) {
        switch (setting) {
            case OVERWORLD     -> this.infiniburn = BlockTags.INFINIBURN_OVERWORLD;
            case END           -> this.infiniburn = BlockTags.INFINIBURN_END;
            case NETHER        -> this.infiniburn = BlockTags.INFINIBURN_NETHER;
            case null, default -> this.infiniburn = BlockTags.INFINIBURN_OVERWORLD;
        }
        return this;
    }

    public DimensionBuilder dimensionSpecialEffects(DimensionSpecialEffects settings) {
        this.dimensionSpecialEffects = ;
        return this;
    }

    public DimensionBuilder build(String dimensionName) {
        RegistryAccess registryAccess = this.server.registryAccess();
        WritableRegistry<DimensionType> DIMENSION_TYPES = (WritableRegistry<DimensionType>) registryAccess.registryOrThrow(Registries.DIMENSION_TYPE);
        WritableRegistry<LevelStem> LEVEL_STEM  = (WritableRegistry<LevelStem>) registryAccess.registryOrThrow(Registries.LEVEL_STEM);

        ResourceLocation dimensionId = ResourceLocation.fromNamespaceAndPath(Spaaace.MODID, dimensionName);

        DimensionType dimensionType = new DimensionType(
                fixedTime,
                hasSkylight,
                hasCeiling,
                isUltraWarm,
                isNatural,
                coordinateScale,
                bedWorks,
                respawnAnchorWorks,
                minY,
                maxY,
                logicalHeight,
                infiniburn,
                dimensionSpecialEffects,
                ambientLight,





        );
    }
}
