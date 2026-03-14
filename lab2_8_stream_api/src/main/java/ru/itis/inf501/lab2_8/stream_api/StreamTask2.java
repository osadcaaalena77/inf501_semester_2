package ru.itis.inf501.lab2_8.stream_api;

import java.util.ArrayList;
import java.util.List;

public class StreamTask2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(3, 0, 7, 12, 345, 6));
        List<Double> list2 = list.stream().sorted((a, b) -> b - a).map(a -> Math.sqrt(a)).toList();
        System.out.println(list2);
    }
}
