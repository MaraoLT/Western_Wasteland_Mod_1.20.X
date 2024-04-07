package net.gbm.western_wasteland.item;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
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
                        output.accept(ModItems.DEAD_BULL_SPAWN_EGG.get());
                        // output.accept(Items.DIAMOND); // itens padrao tbm podem ser add e sem o .get()
                        output.accept(ModBlocks.ROSE_GOLD_BLOCK.get());
                        output.accept(ModBlocks.ROSE_GOLD_ORE.get());

                        output.accept(ModBlocks.TEMPERED_GLASS.get());

                        output.accept(ModBlocks.WESTERN_SANDSTONE.get());
                        output.accept(ModBlocks.WESTERN_CUT_SANDSTONE.get());
                        output.accept(ModBlocks.WESTERN_SAND.get());

                        output.accept(ModBlocks.DEADWOOD.get());
                        output.accept(ModBlocks.DEADWOOD_LOG.get());
                        output.accept(ModBlocks.STRIPPED_DEADWOOD.get());
                        output.accept(ModBlocks.STRIPPED_DEADWOOD_LOG.get());
                        output.accept(ModBlocks.DEADWOOD_PLANKS.get());
                        output.accept(ModBlocks.DEADWOOD_LEAVES.get());

                        output.accept(ModBlocks.DEADWOOD_STAIRS.get());
                        output.accept(ModBlocks.DEADWOOD_SLAB.get());
                        output.accept(ModBlocks.DEADWOOD_BUTTON.get());
                        output.accept(ModBlocks.DEADWOOD_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DEADWOOD_FENCE.get());
                        output.accept(ModBlocks.DEADWOOD_FENCE_GATE.get());
                        output.accept(ModBlocks.DEADWOOD_DOOR.get());
                        output.accept(ModBlocks.DEADWOOD_TRAPDOOR.get());

                        output.accept(ModBlocks.WESTERN_CACTUS.get());

                        output.accept(ModItems.ROSE_GOLD_HELMET.get());
                        output.accept(ModItems.ROSE_GOLD_CHESTPLATE.get());
                        output.accept(ModItems.ROSE_GOLD_LEGGINGS.get());
                        output.accept(ModItems.ROSE_GOLD_BOOTS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
