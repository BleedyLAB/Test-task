package com.Bleedy.Instrument;

import com.Bleedy.Structure.Response;
import com.Bleedy.interfaces.iResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.springframework.stereotype.Component;

@Component
public class TransportManager {

    private final String serviceBUrl = "https://www.someUrl.com";

    // Sent complete weaver information to the next server
    public String sentWeaver(iResponse response) {
        try {
            HttpResponse<String> responseJson = Unirest.post(serviceBUrl)
                    .body("[{\"txt\":\"" + response.getMsg()
                            + "\",\"createdDt\":\"" + response.getCreatedDt()
                            + "\",\"currentTemp\":\"" + response.getCurrentTemp() + "\"}]").asString();
            return responseJson.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }
}
