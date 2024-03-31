package net.gbm.western_wasteland.datagen;

import net.gbm.western_wasteland.Western_Wasteland;
import net.gbm.western_wasteland.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Western_Wasteland.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BULLET);
        simpleItem(ModItems.CACTUS_FLOWER);
        simpleItem(ModItems.DEAD_HORN);
        simpleItem(ModItems.HARMONICA);
        simpleItem(ModItems.HORN_BLADE);

        simpleItem(ModItems.RAW_ROSE_GOLD);
        simpleItem(ModItems.ROSE_GOLD_INGOT);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Western_Wasteland.MOD_ID,"item/" + item.getId().getPath()));
    }
}
