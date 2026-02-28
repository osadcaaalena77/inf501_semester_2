package ru.itis.inf501.lab2_5;

public class Transport {
    private TransportType type;
    private String number;
    private String routeNumber;
    private String workTimeBegin;
    private String workTimeEnd;

    public Transport() {};

    public Transport(TransportType type, String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        this.routeNumber = routeNumber;
        this.workTimeEnd = workTimeEnd;
        this.workTimeBegin = workTimeBegin;
        this.number = number;
        this.type = type;
    }

    public TransportType getType() {
        return type;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRouteNumber() { return routeNumber; }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getWorkTimeBegin() {
        return workTimeBegin;
    }

    public void setWorkTimeBegin(String workTimeBegin) {
        this.workTimeBegin = workTimeBegin;
    }

    public String getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setWorkTimeEnd(String workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }
}
