package com.marbledhubb.frigid_ost.world.item;

import com.marbledhubb.frigid_ost.sounds.ModSoundEvents;
import com.marbledhubb.frigid_ost.FrigidOST;
import net.minecraft.world.item.DiscFragmentItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FrigidOST.MOD_ID);

    public static final RegistryObject<Item> DISC_FRAGMENT_CAPRA = ITEMS.register("disc_fragment_capra", () -> new DiscFragmentItem(new Item.Properties()));
    public static final RegistryObject<Item> MUSIC_DISC_CAPRA = ITEMS.register("music_disc_capra", () -> new RecordItem(13, ModSoundEvents.MUSIC_DISC_CAPRA, (new Item.Properties()).stacksTo(1).rarity(Rarity.RARE), 3620));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
