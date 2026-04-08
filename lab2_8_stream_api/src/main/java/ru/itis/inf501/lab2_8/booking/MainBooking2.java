package ru.itis.inf501.lab2_8.booking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MainBooking2 {
    public static void main(String args[]) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            BookingData data = mapper.readValue(new File("C:\\Users\\Алёна\\Desktop\\inf501_semester2\\bookings.json"), BookingData.class);

            //1. Найти гостиницу с максимальным числом броней за январь 2023 года
           String hotel = data.getBookings().stream()
                    .filter(a -> a.getArrivaldate().startsWith("2022-01"))
                    .collect(Collectors.toMap(
                    b -> b.getHotel().getName(),
                    b -> 1,
                    (a,b) -> a + b
            ))
                    .entrySet().stream()
                    .max((a,b) -> a.getValue().compareTo(b.getValue())).get().getKey();
            System.out.println(hotel);


            //2. Список городов из которых прибыли мужчины от 35 до 45 лет
            data.getBookings().stream()
                    .filter(a -> {
                            String b = a.getPerson().getGender();
                            if (b == null || b.equals("Female")) return false;
                            else return true;
                    })
                    .filter(a -> {
                        if (a.getPerson().getBirthdate() == null) return false;
                        String str = a.getPerson().getBirthdate().substring(0, 4);
                        if (str == null) return false;
                        Integer integer = Integer.parseInt(str);
                        if (integer >= 1977 && integer <= 1987) return true;
                        else return false;
                    }).collect(Collectors.toMap(
                            a -> a.getPerson().getFromcity(),
                            a -> 1,
                            (a, b) -> a + b
                    )).forEach((a, b) -> System.out.println(a));


            //3. вывести список гостиниц (названия) в которых проживали дети до 14 лет
            //(сравниваем год регистрации и год рождения)
            data.getBookings().stream()
                    .filter(a -> {
                        if (a.getPerson().getBirthdate() == null) return false;
                        if (a.getArrivaldate() == null) return false;
                        String str = a.getPerson().getBirthdate().substring(0, 4);
                        String str2 = a.getArrivaldate().substring(0,4);
                        if (str2 == null) return false;
                        Integer d = Integer.parseInt(str2);
                        if (str == null) return false;
                        Integer integer = Integer.parseInt(str);
                        if (d - integer <= 14 && d - integer >= 0) return true;
                        else return false;
                    }).map(a -> a.getHotel().getName())
                    .collect(Collectors.toSet())
                    .forEach(System.out::println);

            //4. вывести список людей с количеством бронирований больше 3
            data.getBookings().stream()
                    .collect(Collectors.toMap(
                            b -> b.getPerson(),
                            b -> 1,
                            (a, b) -> a + b
                    )).entrySet().stream()
                    .filter(e -> e.getValue() > 3)
                    .forEach(a -> System.out.println(a.getKey()));

            //5. Вывести гостиницы в которых проживали женщины из Санкт-Петербурга
            //в период с февраля по март 2023 года (использовать несколько фильтров)
            data.getBookings().stream().filter(a -> a.getPerson().getGender() != null && a.getPerson().getGender().equals("Female"))
                    .filter(a -> a.getPerson().getFromcity() != null && a.getPerson().getFromcity().contains("Санкт-Петербург"))
                    .filter(a -> compr(a.getArrivaldate(),a.getDeparturedate()))
                    .map(a -> a.getHotel().getName())
                    .forEach(System.out::println);

//          6. вывести таблицу возрастная группа - количество броней
//                    (группы: 1 - 0-14, 2 - 15-18, 3 - 19-25, 4 - 26-35, 5 - 36-45, 6 - 45-...)
            long count1 = data.getBookings().stream()
                    .filter( a -> {
                                if (a.getPerson().getBirthdate() == null) return false;
                                String str = a.getPerson().getBirthdate().substring(0, 4);
                                if (str == null) return false;
                                Integer integer = Integer.parseInt(str);
                                if (integer >= 2008 && integer <= 2022) return true;
                                else return false;
                    }).count();
            long count2 = data.getBookings().stream()
                    .filter( a -> {
                        if (a.getPerson().getBirthdate() == null) return false;
                        String str = a.getPerson().getBirthdate().substring(0, 4);
                        if (str == null) return false;
                        Integer integer = Integer.parseInt(str);
                        if (integer >= 2004 && integer <= 2007) return true;
                        else return false;
                    }).count();

            long count3 = data.getBookings().stream()
                    .filter( a -> {
                        if (a.getPerson().getBirthdate() == null) return false;
                        String str = a.getPerson().getBirthdate().substring(0, 4);
                        if (str == null) return false;
                        Integer integer = Integer.parseInt(str);
                        if (integer >= 1997 && integer <= 2003) return true;
                        else return false;
                    }).count();

            long count4 = data.getBookings().stream()
                    .filter( a -> {
                        if (a.getPerson().getBirthdate() == null) return false;
                        String str = a.getPerson().getBirthdate().substring(0, 4);
                        if (str == null) return false;
                        Integer integer = Integer.parseInt(str);
                        if (integer >= 1987 && integer <= 1996) return true;
                        else return false;
                    }).count();

            long count5 = data.getBookings().stream()
                    .filter( a -> {
                        if (a.getPerson().getBirthdate() == null) return false;
                        String str = a.getPerson().getBirthdate().substring(0, 4);
                        if (str == null) return false;
                        Integer integer = Integer.parseInt(str);
                        if (integer >= 1977 && integer <= 1986) return true;
                        else return false;
                    }).count();

            long count6 = data.getBookings().stream()
                    .filter( a -> {
                        if (a.getPerson().getBirthdate() == null) return false;
                        String str = a.getPerson().getBirthdate().substring(0, 4);
                        if (str == null) return false;
                        Integer integer = Integer.parseInt(str);
                        if (integer <= 1976) return true;
                        else return false;
                    }).count();
            Map<Integer, Long> map = new HashMap<>();
            map.put(1,count1);
            map.put(2,count2);
            map.put(3,count3);
            map.put(4,count4);
            map.put(5,count5);
            map.put(6,count6);
            for (Map.Entry<Integer,Long> x : map.entrySet()) {
                System.out.println(x);
            }

            //7. вывести список проживающих в гостинице с id=123, приехавших из Самарской области с апреля по май 2023г.
            data.getBookings().stream()
                    .filter(a -> a.getHotel().getId() != null && a.getHotel().getId() == 123)
                    .filter(a -> a.getPerson().getFromcity() != null && a.getPerson().getFromcity().contains("Самарская область"))
                    .filter(a -> a.getArrivaldate().startsWith("2022-03") || a.getArrivaldate().startsWith("2022-05"))
                    .forEach(a -> System.out.println(a.getPerson()));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }

        public static boolean compr(String a, String s) {
            if (a == null || s == null) return false;
            int a1 = Integer.parseInt(a.substring(5,7));
            int s1 = Integer.parseInt(s.substring(5,7));
            return (a1 <= 3 && s1 >= 2);

        }
}
