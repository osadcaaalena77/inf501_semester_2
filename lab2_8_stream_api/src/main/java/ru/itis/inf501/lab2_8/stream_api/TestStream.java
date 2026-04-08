package ru.itis.inf501.lab2_8.stream_api;

import java.util.ArrayList;
import java.util.List;

public class TestStream {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(3,6,5,11,18,0,9,22));

        //1.найти максимум списка(сразу применяется финализирующий метод)

        Integer max = numbers.stream().max((a,b) -> a - b).get();
        System.out.println(max);

        //2.найти минимум списка

        Integer min = numbers.stream().min((a,b) -> a - b).get();
        System.out.println(min);

        //3. найти все четные числа и найти их среднее
        Double avg = numbers.stream()
                .filter((a) -> a % 2 == 0) //применяем фильтрацию
                .mapToInt(a -> a) // преобразуем в целочисленный стрим (тривиальное преобразование)
                .average().getAsDouble(); // находим среднее (финализирующий метод)
        System.out.println(avg);

        //4. преобразование в строку из списка целых чисел
        List<String> list = numbers.stream()
                .map(a -> String.valueOf(a)) // описываем способ преобразования числа в строку
                .toList(); // финализирующий метод
        System.out.println(list);
    }
}
