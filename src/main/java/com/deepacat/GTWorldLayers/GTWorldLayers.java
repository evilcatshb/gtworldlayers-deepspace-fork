package com.deepacat.GTWorldLayers;

import com.deepacat.GTWorldLayers.common.data.WLDatagen;
import com.deepacat.GTWorldLayers.common.data.WLRegistries;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.api.distmarker.Dist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GTWorldLayers.MOD_ID)
public class GTWorldLayers {
    public static final String MOD_ID = "gtworldgenlayers";
    public static final Logger LOGGER = LogManager.getLogger();

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, FormattingUtil.toLowerCaseUnderscore(path));
    }

    public GTWorldLayers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // GTRegistrate.create() already calls registerEventListeners internally in GT8;
        // just trigger datagen wiring here.
        WLDatagen.init();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addMaterials);
        modEventBus.addListener(this::modifyMaterials);

        // Only register the client setup listener on the physical client —
        // avoids touching client-only classes on a dedicated server.
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(this::clientSetup);
        }

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    // Register custom materials here (use your own namespace, not gtceu's).
    private void addMaterials(MaterialEvent event) {
        //CustomMaterials.init();
    }

    // Optional post-processing / modifications of existing materials.
    private void modifyMaterials(PostMaterialEvent event) {
        //CustomMaterials.modify();
    }

    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        //CustomRecipeTypes.init();
    }

    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        //CustomMachines.init();
    }
}