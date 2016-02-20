package br.eti.kinoshita.minecraft.niwa_weather.util;

import br.eti.kinoshita.minecraft.niwa_weather.ConfigHandler;
import br.eti.kinoshita.minecraft.niwa_weather.ModInformation;
import br.eti.kinoshita.minecraft.niwa_weather.NIWAWeatherMod;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (eventArgs.modID.equals(ModInformation.ID)) {
            ConfigHandler.syncConfig();
            NIWAWeatherMod.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.config.refresh"));
        }
    }
}
