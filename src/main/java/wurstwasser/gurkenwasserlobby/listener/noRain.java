package wurstwasser.gurkenwasserlobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class noRain implements Listener
{
    @EventHandler
    public void onWeather(WeatherChangeEvent e){
        if (e.toWeatherState()){
            e.setCancelled(true);
        }

    }
}
