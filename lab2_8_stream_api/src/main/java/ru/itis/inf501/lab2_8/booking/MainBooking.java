package ru.itis.inf501.lab2_8.booking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainBooking {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            BookingData data = mapper.readValue(new File("C:\\Users\\Алёна\\Desktop\\inf501_semester2\\bookings.json"), BookingData.class);


            //1. вывести количество мужчин/женщин, бронирующих в гостинице с id = 150;
            long countMale = data.getBookings().stream()
                    .filter(b -> b.getHotel().getId() == 150 )
                    .filter(b -> b.getPerson().getGender().equals("Male"))
                    .count();
            long countFemale = data.getBookings().stream()
                    .filter(b -> b.getHotel().getId() == 150 )
                    .filter(b -> b.getPerson().getGender().equals("Female"))
                    .count();
            System.out.println("Количество мужчин: " + countMale + "; Количество женщин: " + countFemale);


            //2. вывести список населенных пунктов в отсортированном виде, из которых прибывают гости
            List<String> fromCity = new ArrayList<>();
            data.getBookings().stream()
                    .sorted((a,b) -> a.getPerson().getFromcity().compareTo(b.getPerson().getFromcity()))
                    .toList()
                    .forEach(b -> fromCity.add(b.getPerson().getFromcity()));
            fromCity.stream().distinct().forEach(a -> System.out.println(a));


            //3. вывести количество бронирований за декабрь 2021 года
            long countBooking = data.getBookings().stream()
                    .filter(b -> b.getArrivaldate().startsWith("2021-12"))
                    .count();
            System.out.println(countBooking);


            //4. вывести таблицу: название гостиницы - кол-во бронирований
            Map<String,Integer> mapHostel = data.getBookings().stream().collect(Collectors.toMap(
                    b -> b.getHotel().getName(),
                    b -> 1,
                    (a,b) -> a + b
            ));
            for (Map.Entry<String,Integer> x : mapHostel.entrySet()) {
                System.out.println(x);
            }


            //5. вывести таблицу: название населенного пункта - кол-во бронирований
            Map<String,Integer> mapFromCity = data.getBookings().stream().collect(Collectors.toMap(
                    b -> b.getPerson().getFromcity(),
                    b -> 1,
                    (a,b) -> a + b
            ));
            for (Map.Entry<String,Integer> x : mapFromCity.entrySet()) {
                System.out.println(x);
            }


            //6. вывести кол-во бронирований людей из Петербурга
            long countPiter = data.getBookings().stream()
                    .filter(b -> b.getPerson().getFromcity().endsWith("Санкт-Петербург"))
                    .count();
            System.out.println(countPiter);


//            data.getBookings().forEach(b -> System.out.println(b.getId()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
