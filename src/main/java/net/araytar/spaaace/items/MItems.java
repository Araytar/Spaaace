package net.araytar.spaaace.items;

import net.araytar.spaaace.Spaaace;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MItems {
    // public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build()));
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Spaaace.MODID);

    public static void register(FMLCommonSetupEvent event) {
        // Common Setup Tasks
    }
}
