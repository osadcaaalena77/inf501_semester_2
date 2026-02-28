package ru.itis.inf501.lab2_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportService {
    private static final String FILE_NAME = "transport.csv";

    public List<Transport> readAll() {
        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            List<Transport> result = new ArrayList<>();
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                Transport transport =
                    switch (data[0]) {
                        case "bus" -> transport = new Bus(data[1], data[2], data[3], data[4]);
                        case "tram" -> transport = new Tram(data[1], data[2], data[3], data[4]);
                        case "trolleybus" -> transport = new Trolleybus(data[1], data[2], data[3], data[4]);
                        default -> null;
                    };
                if (transport != null) result.add(transport);
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
    }
    public List<Transport> readAllType(TransportType type) {
        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            List<Transport> buses = new ArrayList<>();
            List<Transport> trolleybuses = new ArrayList<>();
            List<Transport> trams = new ArrayList<>();
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //
                String[] data = line.split(";");
                Transport bus =
                        switch (data[0]) {
                            case "bus" -> bus = new Bus(data[1], data[2], data[3], data[4]);
                            default -> null;
                        };
                if (bus != null) buses.add(bus);

                Transport trolleybus =
                        switch (data[0]) {
                            case "trolleybus" -> trolleybus = new Trolleybus(data[1], data[2], data[3], data[4]);
                            default -> null;
                        };
                if (trolleybus != null) trolleybuses.add(trolleybus);

                Transport tram =
                        switch (data[0]) {
                            case "tram" -> tram = new Tram(data[1], data[2], data[3], data[4]);
                            default -> null;
                        };
                if (tram != null) trams.add(tram);
            }
            if (type.equals(TransportType.bus)) {
                return buses;
            } else if(type.equals(TransportType.trolleybus)) {
                return trolleybuses;
            } else {
                return trams;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
    }
}