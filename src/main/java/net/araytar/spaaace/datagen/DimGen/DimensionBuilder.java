package net.araytar.spaaace.datagen.DimGen;

import net.araytar.spaaace.Spaaace;
import net.araytar.spaaace.datagen.DimGen.models.InfiniburnOptions;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorPreset;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@SuppressWarnings("DuplicateBranchesInSwitch")
public class DimensionBuilder {
    protected MinecraftServer server;
    private final RegistryAccess registryAccess;
    private Holder<Biome> defaultBiome;

    public DimensionBuilder(MinecraftServer server) {
        this.server = server;
        this.registryAccess = server.registryAccess();
        Registry<Biome> biomeRegistry = this.registryAccess.registryOrThrow(Registries.BIOME);
        defaultBiome = biomeRegistry.getHolderOrThrow(Biomes.THE_VOID);

    }

    protected boolean hasSkylight        = false;
    protected boolean hasCeiling         = false;
    protected boolean isUltraWarm        = false;
    protected boolean isNatural          = false;
    protected boolean bedWorks           = false;
    protected boolean respawnAnchorWorks = false;
    protected boolean isPiglinSafe       = false;

    protected boolean hasRaids           = false;
    protected int    mobSpawnMaxLight     = 7;
    protected double coordinateScale      = 1.0;
    protected int    minY                 = 0;
    protected int    maxY                 = 256;
    protected int    logicalHeight        = 256;
    protected float  ambientLight         = 1.0f;
    protected OptionalLong fixedTime      = OptionalLong.empty();

    protected TagKey<Block> infiniburn    = BlockTags.INFINIBURN_OVERWORLD;
    protected IntProvider mobSpawnLightTest = UniformInt.of(0, 7);
    protected DimensionType.MonsterSettings monsterSettings = new DimensionType.MonsterSettings(isPiglinSafe, hasRaids, mobSpawnLightTest, mobSpawnMaxLight);

    protected ResourceLocation dimensionSpecialEffects = ResourceLocation.fromNamespaceAndPath("minecraft", "overworld");

    protected ChunkGenerator chunkGenerator = new FlatLevelSource(
            new FlatLevelGeneratorSettings(
                Optional.empty(),
                defaultBiome,
                List.of()
            )
    );


    public DimensionBuilder hasSkylight(@Nullable Boolean optionalFlag) {
        if (optionalFlag == null) {
            hasSkylight = true;
            return this;
        }
        hasSkylight = optionalFlag;
        return this;
    }

    public DimensionBuilder isPiglinSafe(@Nullable Boolean optionalFlag) {
        if (optionalFlag == null) {
            isPiglinSafe = true;
            return this;
        }
        isPiglinSafe = optionalFlag;
        return this;
    }

    public DimensionBuilder hasCeiling(@Nullable Boolean optionalFlag) {
        if (optionalFlag == null) {
            hasCeiling = true;
            return this;
        }
        this.hasCeiling = optionalFlag;
        return this;
    }

    public DimensionBuilder isUltraWarm(@Nullable Boolean optionalFlag) {
        if (optionalFlag == null) {
            isUltraWarm = true;
            return this;
        }
        this.isUltraWarm = optionalFlag;
        return this;
    }

    public DimensionBuilder isNatural(@Nullable Boolean optionalFlag) {
        if (optionalFlag == null) {
            isNatural = true;
            return this;
        }
        this.isNatural = optionalFlag;
        return this;
    }

    public DimensionBuilder BedWorks(@Nullable Boolean optionalFlag) {

        if (optionalFlag == null) {
            bedWorks = true;
            return this;
        }
        this.bedWorks = optionalFlag;
        return this;
    }

    public DimensionBuilder respawnAnchorWorks(@Nullable Boolean optionalFlag) {
        if (optionalFlag == null) {
            respawnAnchorWorks = true;
            return this;
        }
        this.respawnAnchorWorks = optionalFlag;
        return this;
    }

    public DimensionBuilder hasRaids (@Nullable Boolean optionalFlag) {
        if (optionalFlag == null) {
            hasRaids = true;
            return this;
        }
        this.hasRaids = optionalFlag;
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

    public DimensionBuilder mobSpawnLightLimit(int value) {
        this.mobSpawnMaxLight = value;
        return this;
    }

    public DimensionBuilder mobSpawnLightTest(IntProvider value) {
        this.mobSpawnLightTest = value;
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

    public DimensionBuilder dimensionSpecialEffects(ResourceLocation location) {
        this.dimensionSpecialEffects = location;
        return this;
    }

    public DimensionBuilder build(String dimensionName) {
        WritableRegistry<DimensionType> DIMENSION_TYPES = (WritableRegistry<DimensionType>) this.registryAccess.registryOrThrow(Registries.DIMENSION_TYPE);
        WritableRegistry<LevelStem> LEVEL_STEM  = (WritableRegistry<LevelStem>) this.registryAccess.registryOrThrow(Registries.LEVEL_STEM);

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
                monsterSettings
        );

        ResourceKey<DimensionType> dimensionTypeResourceKey = ResourceKey.create(Registries.DIMENSION_TYPE, dimensionId);
        DIMENSION_TYPES.register(dimensionTypeResourceKey, dimensionType, RegistrationInfo.BUILT_IN);
        Holder.Reference<DimensionType> dimensionTypeHolder = DIMENSION_TYPES.getHolderOrThrow(dimensionTypeResourceKey);

        LevelStem levelStem = new LevelStem(dimensionTypeHolder)

        return this;
    }
}
