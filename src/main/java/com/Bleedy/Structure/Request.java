package com.Bleedy.Structure;


public class Request {

    public Request() {
    }

    public Request(String msg, Lng lng, String latitude, String longitude) {
        this.msg = msg;
        this.lng = lng;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Request(String msg) {
        this.msg = msg;
    }

    private String msg;

    public enum Lng {
        ru("ru"),
        en("en"),
        es("es");

        private final String name;

        Lng(String e) {
            this.name = e;
        }
    }

    private Lng lng;

    private String latitude;

    private String longitude;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Lng getLng() {
        return lng;
    }

    public void setLng(Lng lng) {
        this.lng = lng;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
