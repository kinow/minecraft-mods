package br.eti.kinoshita.minecraft.niwa_weather.proxies;

import java.util.Timer;

import br.eti.kinoshita.minecraft.niwa_weather.NIWAWeatherAPIClient;

public class CommonProxy {

    private long delay = 15000;
    
    public void init() {
        // register items
        // register blocks
        // add language labels
        Timer timer = new Timer();
        timer.schedule(new NIWAWeatherAPIClient(), delay);
    }

}
