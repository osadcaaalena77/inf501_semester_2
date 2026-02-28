package ru.itis.inf501.lab2_5;

public class Bus extends Transport {
    public Bus(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(TransportType.bus, number, routeNumber, workTimeBegin, workTimeEnd);    }

    @Override
    public String toString() {
        return "Автобус номер " + getNumber() + ", маршрут " + getRouteNumber()
                + ", начало работы " + getWorkTimeBegin()
                + ", завершение работы " + getWorkTimeEnd();
    }
}
