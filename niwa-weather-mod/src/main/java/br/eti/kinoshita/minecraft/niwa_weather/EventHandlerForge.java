package br.eti.kinoshita.minecraft.niwa_weather;

import org.apache.logging.log4j.Level;

import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.world.WorldEvent.Save;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandlerForge {

    // TODO: make it a mod configuration
    private final long sleepTime = 5 * 1000;

    private transient long lastTimeRead = 0;

    @SubscribeEvent
    public void worldSave(Save event) {
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void worldRender(RenderWorldLastEvent event) {
        // ClientTickHandler.checkClientWeather();
        // ClientTickHandler.weatherManager.tickRender(event.partialTicks);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerIcons(TextureStitchEvent event) {
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onWorldTick(WorldTickEvent event) {
        if (NIWAWeatherMod.logger.isDebugEnabled()) {
            // NIWAWeatherMod.logger.log(Level.DEBUG, "The world tick'd!");
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime > (lastTimeRead + sleepTime)) {
            if (NIWAWeatherMod.logger.isDebugEnabled())
                NIWAWeatherMod.logger.log(Level.DEBUG, "Trying to set the world weather...");
            final World world = event.world;
            NIWAWeatherMod mod = NIWAWeatherMod.instance;
            if (mod != null && mod.weatherToday != null) {
                NIWAWeatherResponse weather = mod.weatherToday;
                setWorldWeather(world, weather);
            }
            lastTimeRead = currentTime;
        }
    }

    protected void setWorldWeather(World world, NIWAWeatherResponse weather) {
        WorldInfo info = world.getWorldInfo();
        
        info.setRaining(weather.getRainAmount() > 0.0);
    }
    
}
