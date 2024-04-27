package net.zbrprogrammer.testmod.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zbrprogrammer.testmod.TestMod;
import net.zbrprogrammer.testmod.item.TestItem;

import java.util.function.Supplier;

public class TestBlock {
    //define the Block class
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);

    //register block item
    private static <T extends Block>RegistryObject<Item>registerBlockItem(String name,RegistryObject<T> block){
        return TestItem.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    }

    //register block
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }


    //add attribute to custom block(".copy()" to copy exist blocks, ".xxx()" to change exact attribute)
    public static final RegistryObject<Block>block_name=registerBlock("block_name",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));//


    //add block to the bus
    public static void register(IEventBus eventBus){BLOCKS.register(eventBus);}
}
