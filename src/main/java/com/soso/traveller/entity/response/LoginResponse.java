package com.soso.traveller.entity.response;

public class LoginResponse {
    long statusCode;

    String name;

    public LoginResponse(long statusCode, String name) {
        this.statusCode = statusCode;
        this.name = name;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(long statusCode) {
        this.statusCode = statusCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
