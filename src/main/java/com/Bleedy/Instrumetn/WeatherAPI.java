package com.Bleedy.Instrumetn;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class WeatherAPI {

    private final String OWM_KEY = "dc0aed0f8c7a357c5c1a1f2ad811c2ec";

    public double getTemp(String lat, String lon) throws UnirestException {
        HttpRequest request = Unirest.get("http://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={appid}&units={units}")
                .routeParam("lon", lon)
                .routeParam("lat", lat)
                .routeParam("appid", OWM_KEY)
                .routeParam("units", "metric");
        HttpResponse<JsonNode> jsonResponse = request.asJson();
        JSONObject responseJson = jsonResponse.getBody().getObject();
        double msg = responseJson.getJSONObject("main").getDouble("temp");
        return msg;
    }
}
