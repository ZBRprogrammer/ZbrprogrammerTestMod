package net.zbrprogrammer.testmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zbrprogrammer.testmod.block.TestBlock;
import net.zbrprogrammer.testmod.item.TestCreativeModTabs;
import net.zbrprogrammer.testmod.item.TestItem;
import org.slf4j.Logger;


@Mod(TestMod.MODID)
public class TestMod {
    public static final String MODID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        TestCreativeModTabs.register(modEventBus);//add custom creative tab to main bus
        TestItem.register(modEventBus);//add custom items to main bus
        TestBlock.register(modEventBus);//add custom block to main bus
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {//添加物品所在创造模式选项卡
        if(event.getTabKey()== CreativeModeTabs.INGREDIENTS){
            event.accept(TestItem.item_name);
            event.accept(TestItem.item_with_creative_category);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
