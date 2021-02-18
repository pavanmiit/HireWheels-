package com.upgrad.hirewheels.response;

public class CustomResponse {
    private String errorMessage;
    private int statusCode;
    private String HahsCode;

    public CustomResponse(){
    }

    public CustomResponse(String errorMessage, int statusCode,String HahsCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }

    public CustomResponse(String message, int statusCode, int value) {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
