package com.Bleedy.Controller;

import com.Bleedy.Instrumetn.TransportManager;
import com.Bleedy.Instrumetn.WeatherAPI;
import com.Bleedy.Structure.Request;
import com.Bleedy.Structure.Response;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/todo")
public class Rest {

    @Autowired
    WeatherAPI weatherApi;
    @Autowired
    TransportManager transportManager;

    @GetMapping
    public ResponseEntity<List<Request>> getList() {
        List<Request> list = new ArrayList<Request>();
        list.add(new Request());
        return ResponseEntity.ok(list);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Response>> makeSome(@RequestBody Request request) throws UnirestException {
        List<Response> list = new ArrayList<Response>();
        if (!request.getMsg().isEmpty() || request.getLng().name().equals("ru")) {
            double temp = weatherApi.getTemp(request.getLatitude(), request.getLongitude());
            Response finalRes = new Response(request.getMsg(),
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                    (int) temp);
            transportManager.sentWeaver(finalRes);
            list.add(finalRes);
            return ResponseEntity.ok(list);
        }
        return null;
    }
}
