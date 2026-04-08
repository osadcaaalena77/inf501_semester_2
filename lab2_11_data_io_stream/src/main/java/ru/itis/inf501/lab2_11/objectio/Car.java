package ru.itis.inf501.lab2_11.objectio;

import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private String type;
    private String number;

    public Car(String name, String type, String number) {
        this.name = name;
        this.type = type;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
