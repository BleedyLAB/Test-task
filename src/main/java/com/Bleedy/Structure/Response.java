package com.Bleedy.Structure;

import com.Bleedy.interfaces.iResponse;
import org.springframework.stereotype.Component;

@Component
public class Response implements iResponse {

    public Response() {
    }

    public Response(String msg, String createdDt, Integer currentTemp) {
        this.msg = msg;
        this.createdDt = createdDt;
        this.currentTemp = currentTemp;
    }

    private String msg;

    private String createdDt;

    private Integer currentTemp;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(String createdDt) {
        this.createdDt = createdDt;
    }

    public Integer getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Integer currentTemp) {
        this.currentTemp = currentTemp;
    }
}
