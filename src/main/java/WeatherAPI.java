import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import org.json.JSONObject;

public class WeatherAPI {
    private JSONObject response;
    private String weather;

    public WeatherAPI() {
        this.makeConnection();
        this.weather = this.simplifyResponse();
    }
    /*
    String format: The weather for the coming 3 hours:
                    Temperature: x
                    Description: x
                    Humidity: x
    */
    private String simplifyResponse() {
        JSONObject list = this.response.getJSONArray("list").getJSONObject(0);
        JSONObject main = list.getJSONObject("main");
        //API returns value in kelvin, formula for kelvin to Celsius is C = K - 273.15
        int temperature = (int) Math.round(main.getDouble("temp") - 273.15);
        String description = list.getJSONArray("weather").getJSONObject(0).getString("description");
        int humidity = main.getInt("humidity");
        return String.format("The weather for the coming 3 hours: \n Temperature: %d°C \n Description: %s \n Humidity: %d%%", temperature, description, humidity);
    }

    private void makeConnection() {
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=4826,NL&appid=API_KEY");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                this.response = (new JSONObject(br.readLine()));
            }
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWeather() {
        if (this.weather != null) {
            return this.weather;
        } else {
            return "Couldn't fetch weather";
        }
    }
}
