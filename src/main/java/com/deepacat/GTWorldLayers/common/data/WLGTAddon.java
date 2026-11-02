package com.deepacat.GTWorldLayers.common.data;

import com.deepacat.GTWorldLayers.GTWorldLayers;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

@GTAddon
public class WLGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return WLRegistries.REGISTRATE;
    }

    @Override
    public void initializeAddon() {

    }

    @Override
    public String addonModId() {
        return GTWorldLayers.MOD_ID;
    }

    @Override
    @SuppressWarnings("removal")
    public void registerTagPrefixes() {
        if (ModList.get().isLoaded("ad_astra")) {
            TagPrefix.oreTagPrefix("moon", BlockTags.MINEABLE_WITH_PICKAXE)
                    .langValue("Moon %s Ore")
                    .registerOre(() -> BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ad_astra", "moon_stone")).defaultBlockState(),
                            null, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 3.0F),
                            ResourceLocation.fromNamespaceAndPath("ad_astra", "block/moon_stone"));
            TagPrefix.oreTagPrefix("mars", BlockTags.MINEABLE_WITH_PICKAXE)
                    .langValue("Mars %s Ore")
                    .registerOre(() -> BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ad_astra", "mars_stone")).defaultBlockState(),
                            null, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 3.0F),
                            ResourceLocation.fromNamespaceAndPath("ad_astra", "block/mars_stone"));
            TagPrefix.oreTagPrefix("mercury", BlockTags.MINEABLE_WITH_PICKAXE)
                    .langValue("Mercury %s Ore")
                    .registerOre(() -> BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ad_astra", "mercury_stone")).defaultBlockState(),
                            null, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 3.0F),
                            ResourceLocation.fromNamespaceAndPath("ad_astra", "block/mercury_stone"));
            TagPrefix.oreTagPrefix("venus", BlockTags.MINEABLE_WITH_PICKAXE)
                    .langValue("Venus %s Ore")
                    .registerOre(() -> BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ad_astra", "venus_stone")).defaultBlockState(),
                            null, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 3.0F),
                            ResourceLocation.fromNamespaceAndPath("ad_astra", "block/venus_stone"));
            TagPrefix.oreTagPrefix("glacio", BlockTags.MINEABLE_WITH_PICKAXE)
                    .langValue("Glacio %s Ore")
                    .registerOre(() -> BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("ad_astra", "glacio_stone")).defaultBlockState(),
                            null, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 3.0F),
                            ResourceLocation.fromNamespaceAndPath("ad_astra", "block/glacio_stone"));
        }
    }

    @Override
    @SuppressWarnings("removal")
    public void registerWorldgenLayers() {
        WLWorldGenLayers.init();
    }
}
