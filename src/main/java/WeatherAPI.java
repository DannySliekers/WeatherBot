import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import org.json.JSONObject;

public class WeatherAPI {
<<<<<<< HEAD
    private JSONObject response;
    private String weather;

    public WeatherAPI(){
=======
    private static final double KELVIN = 273.15;
    private JSONObject response;
    private String weather;

    public WeatherAPI() {
>>>>>>> master
        this.makeConnection();
        this.weather = this.simplifyResponse();
    }
    /*
    String format: The weather for the coming 3 hours:
                    Temperature: x
                    Description: x
                    Humidity: x
    */
<<<<<<< HEAD
    private String simplifyResponse(){
        JSONObject list = this.response.getJSONArray("list").getJSONObject(0);
        JSONObject main = list.getJSONObject("main");
        //API returns value in kelvin, formula for kelvin to Celsius is C = K - 273.15
        int temperature = (int) Math.round(main.getDouble("temp") - 273.15);
=======
    private String simplifyResponse() {
        JSONObject list = this.response.getJSONArray("list").getJSONObject(0);
        JSONObject main = list.getJSONObject("main");
        //API returns value in kelvin, formula for kelvin to Celsius is C = K - 273.15
        int temperature = (int) Math.round(main.getDouble("temp") - KELVIN);
>>>>>>> master
        String description = list.getJSONArray("weather").getJSONObject(0).getString("description");
        int humidity = main.getInt("humidity");
        return String.format("The weather for the coming 3 hours: \n Temperature: %d°C \n Description: %s \n Humidity: %d%%", temperature, description, humidity);
    }

<<<<<<< HEAD
    private void makeConnection(){
=======
    private void makeConnection() {
>>>>>>> master
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=4826,NL&appid=API_KEY");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();

            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                this.response = (new JSONObject(br.readLine()));
            }
<<<<<<< HEAD

=======
>>>>>>> master
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    public String getWeather(){
        if(this.weather != null){
=======
    public String getWeather() {
        if (this.weather != null) {
>>>>>>> master
            return this.weather;
        } else {
            return "Couldn't fetch weather";
        }
    }
}
