package net.zbrprogrammer.testmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zbrprogrammer.testmod.TestMod;
import net.zbrprogrammer.testmod.block.TestBlock;

public class TestCreativeModTabs {
    //create creative tabs class
    public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TAB=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    //create an individual tab
    public static final RegistryObject<CreativeModeTab>creative_mode_tab_name=CREATIVE_MODE_TAB.register("creative_mode_tab_name",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(TestItem.item_name.get()))//set the icon
                    .title(Component.translatable("creativetab.test_creative_tab"))//set the title(pKey is going to be translated in lang)
                    .displayItems((itemDisplayParameters, output) -> {//the item it will contain
                        output.accept(TestItem.item_name.get());
                        output.accept(TestBlock.block_name.get());
                        output.accept(TestItem.item_with_creative_category.get());//Mod Items example

                        output.accept(Items.DIAMOND);//vanilla item example,only use ".get()" with custom item
                    })
                    .build());

    public static void register(IEventBus eventBus){CREATIVE_MODE_TAB.register(eventBus);}
}
