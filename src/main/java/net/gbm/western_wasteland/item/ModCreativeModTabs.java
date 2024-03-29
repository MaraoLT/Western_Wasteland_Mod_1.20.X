package net.gbm.western_wasteland.item;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Western_Wasteland.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WESTERN_WASTELAND = CREATIVE_MODE_TABS.register("western_wasteland_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HORN_BLADE.get()))
                        .title(Component.translatable("creativetab.western_wasteland_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // add itens que vao aparecer na nova aba do criativo
                        output.accept(ModItems.DEAD_HORN.get());
                        output.accept(ModItems.HORN_BLADE.get());
                        output.accept(ModItems.RAW_ROSE_GOLD.get());
                        output.accept(ModItems.ROSE_GOLD_INGOT.get());
                        output.accept(ModItems.BULLET.get());
                        output.accept(ModItems.CACTUS_FLOWER.get());
                        output.accept(ModItems.HARMONICA.get());
                        // output.accept(Items.DIAMOND); // itens padrao tbm podem ser add e sem o .get()
                        output.accept(ModBlocks.ROSE_GOLD_BLOCK.get());
                        output.accept(ModBlocks.ROSE_GOLD_ORE.get());
                        output.accept(ModBlocks.TEMPERED_GLASS.get());
                        output.accept(ModBlocks.WESTERN_SANDSTONE.get());
                        output.accept(ModBlocks.WESTERN_CUT_SANDSTONE.get());
                        output.accept(ModBlocks.WESTERN_SAND.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
