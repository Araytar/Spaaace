package net.araytar.spaaace.items;

import net.araytar.spaaace.Spaaace;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MBlocks {
    //public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Spaaace.MODID);

    public static final DeferredBlock<Block> SPACE_BLOCK = registerBlock("space_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.6f, 6f)
                    .mapColor(MapColor.COLOR_BLACK)
                    .sound(SoundType.STONE)
            )
    );




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> b = BLOCKS.register(name, block);
        registerBlockItem(name, b);
        return b;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        MItems.ITEMS.register(name, () -> new BlockItem(
                block.get(),
                new Item.Properties()
            )
        );
    }


}
