package com.deepacat.GTWorldLayers.common.data;

import com.gregtechceu.gtceu.api.data.worldgen.IWorldGenLayer;
import com.gregtechceu.gtceu.api.data.worldgen.SimpleWorldGenLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.fml.ModList;

import java.util.Set;

public class WLWorldGenLayers {
    private static TagKey<Block> moonstone;
    private static TagKey<Block> marsstone;
    private static TagKey<Block> mercurystone;
    private static TagKey<Block> venusstone;
    private static TagKey<Block> glaciostone;

    public static IWorldGenLayer MOON;
    public static IWorldGenLayer MARS;
    public static IWorldGenLayer MERCURY;
    public static IWorldGenLayer VENUS;
    public static IWorldGenLayer GLACIO;

    public static void init() {
        if (ModList.get().isLoaded("ad_astra")) {
            moonstone   = BlockTags.create(ResourceLocation.fromNamespaceAndPath("ad_astra", "moon_stone_replaceables"));
            marsstone   = BlockTags.create(ResourceLocation.fromNamespaceAndPath("ad_astra", "mars_stone_replaceables"));
            mercurystone = BlockTags.create(ResourceLocation.fromNamespaceAndPath("ad_astra", "mercury_stone_replaceables"));
            venusstone  = BlockTags.create(ResourceLocation.fromNamespaceAndPath("ad_astra", "venus_stone_replaceables"));
            glaciostone = BlockTags.create(ResourceLocation.fromNamespaceAndPath("ad_astra", "glacio_stone_replaceables"));

            MOON    = new SimpleWorldGenLayer(ResourceLocation.fromNamespaceAndPath("gtworldgenlayers", "ad_astra_moon"),    () -> new TagMatchTest(moonstone),    Set.of(ResourceLocation.parse("ad_astra:moon")));
            MARS    = new SimpleWorldGenLayer(ResourceLocation.fromNamespaceAndPath("gtworldgenlayers", "ad_astra_mars"),    () -> new TagMatchTest(marsstone),    Set.of(ResourceLocation.parse("ad_astra:mars")));
            MERCURY = new SimpleWorldGenLayer(ResourceLocation.fromNamespaceAndPath("gtworldgenlayers", "ad_astra_mercury"), () -> new TagMatchTest(mercurystone), Set.of(ResourceLocation.parse("ad_astra:mercury")));
            VENUS   = new SimpleWorldGenLayer(ResourceLocation.fromNamespaceAndPath("gtworldgenlayers", "ad_astra_venus"),   () -> new TagMatchTest(venusstone),   Set.of(ResourceLocation.parse("ad_astra:venus")));
            GLACIO  = new SimpleWorldGenLayer(ResourceLocation.fromNamespaceAndPath("gtworldgenlayers", "ad_astra_glacio"),  () -> new TagMatchTest(glaciostone),  Set.of(ResourceLocation.parse("ad_astra:glacio")));
        }
    }
}
