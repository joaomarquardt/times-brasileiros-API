package com.web.spring_clubs.infra;


import java.util.Map;

public class RestErrorResponse {
    private int status;
    private final Map<String, String> errors;

    public RestErrorResponse(int status, Map<String, String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
