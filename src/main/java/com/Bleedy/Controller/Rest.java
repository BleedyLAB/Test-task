package com.Bleedy.Controller;

import com.Bleedy.Instrument.TransportManager;
import com.Bleedy.Instrument.WeatherAPI;
import com.Bleedy.interfaces.iResponse;
import com.Bleedy.Structure.Request;
import com.Bleedy.Structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
    public ResponseEntity<List<iResponse>> makeSome(@RequestBody Request request) {
        List<iResponse> list = new ArrayList<iResponse>();
        if (!request.getMsg().isEmpty() || request.getLng().name().equals("ru")) {
            //Get temperature by latitude and longitude from response
            double temp = weatherApi.getTemp(request.getLatitude(), request.getLongitude());
            //Compile full response for next server
            Response finalRes = new Response(request.getMsg(),
                    ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'h:m:ssZ")),
                    (int) temp);
            transportManager.sentWeaver(finalRes);
            list.add(finalRes);
            return ResponseEntity.ok(list);
        }
        return null;
    }
}
