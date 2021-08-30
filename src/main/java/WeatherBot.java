import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherBot {
    private WeatherAPI weather;
    private TwitterAPI twitter;
    public WeatherBot() {
        this.weather = new WeatherAPI();
        this.twitter = new TwitterAPI();
        botLoop();
    }

    private void botLoop() {
        ScheduledExecutorService executor = Executors
                .newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                twitter.postTweet(weather.getWeather());
            }
        }, 0, 3, TimeUnit.HOURS);
    }
}
