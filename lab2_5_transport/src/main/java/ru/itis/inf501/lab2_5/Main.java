package ru.itis.inf501.lab2_5;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        TransportService service = new TransportService();
        PrintService printService = new PrintService();
        List<Transport> buses = service.readAllType(TransportType.bus);
        List<Transport> trams = service.readAllType(TransportType.tram);
        List<Transport> transport = service.readAll();
        List<Transport> trolleybuses = service.readAllType(TransportType.trolleybus);

        System.out.print("{");
        for(int i = 0; i < buses.size(); i++) {
           System.out.print(buses.get(i));
           if (i != buses.size() - 1) System.out.print("; ");
        }
        System.out.println("}");

        printService.printNumberAndTimeBegin(buses);
        printService.printRouteNumberAndTimeEndAndTimeBegin(buses);
        printService.printNumberRoute(buses);
        printService.printTransportNumber(buses);
        printService.printRouteNumberAndTransport(buses);
        System.out.println();

        System.out.print("{");
        for(int i = 0; i < trolleybuses.size(); i++) {
            System.out.print(trolleybuses.get(i));
            if (i != trolleybuses.size() - 1) System.out.print("; ");
        }
        System.out.println("}");
        printService.printNumberAndTimeBegin(trolleybuses);
        printService.printRouteNumberAndTimeEndAndTimeBegin(trolleybuses);
        printService.printNumberRoute(trolleybuses);
        printService.printTransportNumber(trolleybuses);
        printService.printRouteNumberAndTransport(trolleybuses);
        System.out.println();

        System.out.print("{");
        for(int i = 0; i < trams.size(); i++) {
            System.out.print(trams.get(i));
            if (i != trams.size() - 1) System.out.print("; ");
        }
        System.out.println("}");
        printService.printNumberAndTimeBegin(trams);
        printService.printRouteNumberAndTimeEndAndTimeBegin(trams);
        printService.printNumberRoute(trams);
        printService.printTransportNumber(trams);
        printService.printRouteNumberAndTransport(trams);
        System.out.println();

        printService.printNumberAndTimeBegin(transport);
        printService.printRouteNumberAndTimeEndAndTimeBegin(transport);
        printService.printNumberRoute(transport);
        printService.printTransportNumber(transport);
        printService.printRouteNumberAndTransport(transport);
    }
}
