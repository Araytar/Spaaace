package net.araytar.spaaace.items;

import net.araytar.spaaace.Spaaace;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@EventBusSubscriber(modid = Spaaace.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Spaaace.MODID);

    public static Supplier<CreativeModeTab> SPAAACE_TAB = CREATIVE_MODE_TABS.register("spaaace_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creative_mode_tab." + Spaaace.MODID + ".space_tab"))
                    .icon(() -> new ItemStack(MBlocks.SPACE_BLOCK.get()))
                    .displayItems((params, output) -> {
                        output.accept(MBlocks.SPACE_BLOCK.get());
                    })
                    .build()
    );

    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == MCreativeModeTabs.SPAAACE_TAB) {
            event.accept(MBlocks.SPACE_BLOCK);
        }
    }
}
