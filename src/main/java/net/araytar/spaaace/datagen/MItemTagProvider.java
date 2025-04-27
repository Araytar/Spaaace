package net.araytar.spaaace.datagen;

import net.araytar.spaaace.Spaaace;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MItemTagProvider extends ItemTagsProvider {

    public MItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Spaaace.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        /* Nothing there yet, but this is how to add custom tags
        * tag(MTags.Items.TAG)
        *   .add(MItems.SPACE_BLOCK.get());
        * */
    }
}
