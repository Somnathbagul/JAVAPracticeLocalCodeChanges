import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApi {
  
  public static void main(String[] args) {
    String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=London";
    try {
      URL url = new URL(apiUrl);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");
      
      if (conn.getResponseCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
      }
      
      BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
      String output;
      StringBuilder sb = new StringBuilder();
      while ((output = br.readLine()) != null) {
        sb.append(output);
      }
      conn.disconnect();

      /*JSONObject jsonObj = new JSONObject(sb.toString());
      String country = jsonObj.getJSONObject("sys").getString("country");
      String weather = jsonObj.getJSONArray("weather").getJSONObject(0).getString("description");
      JSONObject windObj = jsonObj.getJSONObject("wind");
      double windSpeed = windObj.getDouble("speed");
      int windDeg = windObj.getInt("deg");
      int humidity = jsonObj.getJSONObject("main").getInt("humidity");

      JSONArray resultArr = new JSONArray();
      JSONObject resultObj = new JSONObject();
      resultObj.put("country", country);
      resultObj.put("weather", weather);
      resultObj.put("wind", "Speed: " + windSpeed + " m/s, Degree: " + windDeg);
      resultObj.put("humidity", humidity);
      resultArr.put(resultObj);

      System.out.println(resultArr.toString());*/
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
