package br.eti.kinoshita.minecraft.niwa_weather;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = NIWAWeatherMod.MODID, version = NIWAWeatherMod.VERSION)
public class NIWAWeatherMod {
    public static final String MODID = "niwa-weather-mod";
    public static final String VERSION = "0.1";

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
}
