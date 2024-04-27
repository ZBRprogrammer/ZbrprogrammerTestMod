package net.zbrprogrammer.testmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zbrprogrammer.testmod.TestMod;

public class TestItem {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    public static final RegistryObject<Item> item_name=ITEMS.register("item_name",
            ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> item_with_creative_category=ITEMS.register("item_with_creative_category",
            ()->new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
