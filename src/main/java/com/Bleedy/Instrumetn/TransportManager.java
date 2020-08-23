package com.Bleedy.Instrumetn;

import com.Bleedy.Structure.Response;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import org.springframework.stereotype.Component;

@Component
public class TransportManager {

    private final String serviceBUrl = "some url";

    public void sentWeaver(Response response) {
        HttpRequest request = Unirest.post(serviceBUrl+"?txt={txt}&createdDt={createdDt}&currentTemp={currentTemp}")
                .routeParam("txt", response.getMsg())
                .routeParam("createdDt", response.getCreatedDt())
                .routeParam("currentTemp", response.getCurrentTemp().toString());
    }
}
