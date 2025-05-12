package com.tektonlabs.percentagecalculationapi.dtos;

import java.time.LocalDateTime;

public class HistoryDto {

    private LocalDateTime date;
    private String endPoint;
    private String parameters;
    private String response;

    public HistoryDto() {
    }

    public HistoryDto(LocalDateTime date, String endPoint, String parameters, String response) {
        this.date = date;
        this.endPoint = endPoint;
        this.parameters = parameters;
        this.response = response;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
