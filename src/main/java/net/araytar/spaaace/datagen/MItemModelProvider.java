package net.araytar.spaaace.datagen;

import net.araytar.spaaace.Spaaace;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MItemModelProvider extends ItemModelProvider {
    public MItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Spaaace.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //basicItem(MItems.ITEM.get());
    }
}
