package ru.itis.inf501.lab2_9_yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleMetaData {
    private String id;
    @JsonProperty("Transport")
    private Transport transport;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
