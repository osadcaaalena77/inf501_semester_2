package ru.itis.inf501.lab2_9_yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {
    private String type;
    @JsonProperty("VehicleMetaData")
    private VehicleMetaData vehicleMetaData;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VehicleMetaData getVehicleMetaData() {
        return vehicleMetaData;
    }

    public void setVehicleMetaData(VehicleMetaData vehicleMetaData) {
        this.vehicleMetaData = vehicleMetaData;
    }
}
