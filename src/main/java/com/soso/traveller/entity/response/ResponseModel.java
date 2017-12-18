package com.soso.traveller.entity.response;

public class ResponseModel {
    long statusCode;

    public ResponseModel(){

    }

    public ResponseModel(long statusCode) {
        this.statusCode = statusCode;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
