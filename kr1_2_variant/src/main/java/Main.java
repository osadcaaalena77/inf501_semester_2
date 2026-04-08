import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File file = new File("variant2.csv");
        List<Trip> trips = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String> lines = reader.lines().toList();

            for (String x : lines) {
                Trip trip =  new Trip(x);
                //номер переводится с латинского на кирилицу
                trip.setAvtoNumber(trip.getAvtoNumber().replace('A','А'));
                trips.add(trip);
            }

            //4. Создать и наполнить данными из файла структуру Map<Автомобиль(номер), кол-во поездок>
            System.out.println("4 ЗАДАНИЕ");
            trips.stream().collect(Collectors.toMap(
                    b -> b.getAvtoNumber(),
                    b -> 1,
                    (a,b) -> a + b
            )).forEach((a,b) -> System.out.println(a + " - " + b));
            System.out.println();

            //5. вывести все поездки в порядке возрастания времени начала поездки
            System.out.println("5 ЗАДАНИЕ");
            trips.stream().sorted((a,b) -> a.getDateOtpr().compareTo(b.getDateOtpr())).forEach(a -> System.out.println(a));
            System.out.println();

            //6.  подсчитать количество разных клиентов такси
            System.out.println("6 ЗАДАНИЕ");
            long countOfClients = trips.stream().map(a -> a.getClientName()).distinct().count();
            System.out.println(countOfClients);
            System.out.println();

            //7. Прочитать текст из файла, подсчитать количество разных клиентов такси (по определенному адресу)
            System.out.println("7 ЗАДАНИЕ");
            String address = "Чистопольская, 55";
            long count = trips.stream().filter(b -> {
                if (b.getAddressOtpr().startsWith(address)) return true;
                if (b.getAddressPrib().startsWith(address)) return true;
                return false;
            }).map(a -> a.getClientName()).distinct().count();
            System.out.println(count);
            System.out.println();

            //8. Прочитать текст из файла, найти количество разных адресов в базе данных
            System.out.println("8 ЗАДАНИЕ");
            Set<String> set1 = new HashSet<>();
            set1.addAll(trips.stream().map(b -> b.getAddressPrib()).toList());
            Set<String> set2 = new HashSet<>();
            set2.addAll(trips.stream().map(b -> b.getAddressOtpr()).toList());
            Set<String> set = new HashSet<>();
            for (String x : set1) {
                for (String y : set2) {
                    if (x.equals(y)) set.add(x);
                    else {
                        set.add(x);
                        set.add(y);
                    }
                }
            }
            System.out.println(set.size());
            System.out.println();

            //9. Прочитать текст из файла, найти количество разных автомобилей
            System.out.println("9 ЗАДАНИЕ");
            long countOfAvto = trips.stream().map(a -> a.getAvtoNumber()).distinct().count();
            System.out.println(countOfAvto);
            System.out.println();

            //10. Прочитать текст из файла, найти количество разных водителей
            System.out.println("10 ЗАДАНИЕ");
            long countOfVodila = trips.stream().map(a -> a.getVoditelName()).distinct().count();
            System.out.println(countOfVodila);
        } catch (IOException e) {
            e.printStackTrace();
        };

    }
}
