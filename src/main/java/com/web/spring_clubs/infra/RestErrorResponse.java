package com.web.spring_clubs.infra;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Map;

public class RestErrorResponse {
    private int status;
    @JsonInclude(Include.NON_NULL)
    private String error;
    @JsonInclude(Include.NON_NULL)
    private Map<String, String> errors;

    public RestErrorResponse(int status, Map<String, String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public RestErrorResponse(int status, String error) {
        this.status = status;
        this.error = error;
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

    public String getError() {
        return error;
    }
}
