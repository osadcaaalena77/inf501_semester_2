package ru.itis.inf501.lab2_8.stream_api;

import java.util.ArrayList;
import java.util.List;

public class StreamTask1 {
    public static void main(String args[]) {

        //1. преобразовать список строк и отобрать строки, начинающиеся на "Вл", и вывести среднюю длину таких строк
        List<String> list = new ArrayList<>(List.of("привет","Владивосток","Власть","пока"));
        List<String> sortList = list.stream().filter( a -> a.startsWith("Вл")).toList();
        System.out.println(sortList);
        Double avg = sortList.stream().map(a -> a.length()).mapToInt(a -> a).average().getAsDouble();
        System.out.println(avg);

    }
}
