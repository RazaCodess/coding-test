package com.health.appResponse;


import java.io.Serializable;

public class AppResponse {
    private int code;
    private String response;

    public AppResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public AppResponse(int code, String response) {
        this.code = code;
        this.response = response;
    }
}
