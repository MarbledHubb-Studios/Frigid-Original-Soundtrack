package com.marbledhubb.frigid_ost;

import com.marbledhubb.frigid_ost.sounds.ModSoundEvents;
import com.marbledhubb.frigid_ost.world.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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

@Mod(FrigidOST.MOD_ID)
public class FrigidOST
{
    public static final String MOD_ID = "frigid_ost";

    public FrigidOST()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::onCreativeModeTab);
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModSoundEvents.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onCreativeModeTab(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
        {
            ItemStack item = ModItems.MUSIC_DISC_CAPRA.get().asItem().getDefaultInstance();
            event.getEntries().putAfter(Items.MUSIC_DISC_RELIC.getDefaultInstance(),item,event.getEntries().get(Items.MUSIC_DISC_RELIC.getDefaultInstance()));
        }

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            ItemStack item = ModItems.DISC_FRAGMENT_CAPRA.get().asItem().getDefaultInstance();
            event.getEntries().putAfter(Items.DISC_FRAGMENT_5.getDefaultInstance(),item,event.getEntries().get(Items.DISC_FRAGMENT_5.getDefaultInstance()));
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
