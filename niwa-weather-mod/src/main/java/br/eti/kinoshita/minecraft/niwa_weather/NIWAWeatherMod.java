package br.eti.kinoshita.minecraft.niwa_weather;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.eti.kinoshita.minecraft.niwa_weather.proxies.CommonProxy;
import br.eti.kinoshita.minecraft.niwa_weather.util.TextHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInformation.ID, version = ModInformation.VERSION)
public class NIWAWeatherMod {

    @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
    public static CommonProxy proxy;
    
    public static Logger logger = LogManager.getLogger(ModInformation.NAME);

    @Mod.Instance
    public static NIWAWeatherMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.preInit"));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.init"));
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.postInit"));
    }
}
