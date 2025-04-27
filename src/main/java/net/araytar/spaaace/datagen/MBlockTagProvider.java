package net.araytar.spaaace.datagen;

import net.araytar.spaaace.Spaaace;
import net.araytar.spaaace.items.MBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MBlockTagProvider extends BlockTagsProvider {
    public MBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Spaaace.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(MBlocks.SPACE_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(MBlocks.SPACE_BLOCK.get());
    }
}
