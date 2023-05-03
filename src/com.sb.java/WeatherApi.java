package com.sb.java;
/*import org.json.JSONArray;
import org.json.JSONObject;*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApi {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter weather station name: ");
    String station = scanner.nextLine();
    System.out.print("Enter page number: ");
    int page = scanner.nextInt();
    System.out.print("Enter page size: ");
    int pageSize = scanner.nextInt();
    
    String apiUrl = "https://api.weather.gov/stations/" + station + "/observations?limit=" + pageSize + "&page=" + page;
    try {
      URL url = new URL(apiUrl);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/geo+json");
      
      if (conn.getResponseCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
      }
      
      BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
      String output;
      while ((output = br.readLine()) != null) {
        /*JSONObject jsonObj = new JSONObject(output);
        JSONArray features = jsonObj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
          JSONObject feature = features.getJSONObject(i);
          JSONObject properties = feature.getJSONObject("properties");
          System.out.println("Timestamp: " + properties.getString("timestamp"));
          System.out.println("Temperature: " + properties.getJSONObject("temperature").getString("value"));
          System.out.println("Dewpoint: " + properties.getJSONObject("dewpoint").getString("value"));
          System.out.println("Wind Direction: " + properties.getJSONObject("windDirection").getString("value"));
          System.out.println("Wind Speed: " + properties.getJSONObject("windSpeed").getString("value"));
          System.out.println("Sea Level Pressure: " + properties.getJSONObject("seaLevelPressure").getString("value"));
          System.out.println();*//*
        }*/
      }
      
      conn.disconnect();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
