package br.eti.kinoshita.minecraft.niwa_weather;

import org.apache.logging.log4j.Level;

import net.minecraft.world.World;
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
        ClientTickHandler.checkClientWeather();
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
            NIWAWeatherMod.logger.log(Level.INFO, "Setting the time to rain modeeeee!!! Weeee");
            final World world = event.world;
            world.getWorldInfo().setRaining(true);
            lastTimeRead = currentTime;
        }
    }

}
