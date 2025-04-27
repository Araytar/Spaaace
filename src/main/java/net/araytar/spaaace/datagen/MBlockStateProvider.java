package net.araytar.spaaace.datagen;

import net.araytar.spaaace.Spaaace;
import net.araytar.spaaace.items.MBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;


public class MBlockStateProvider extends BlockStateProvider {

    public MBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Spaaace.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(MBlocks.SPACE_BLOCK);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
