package ru.itis.inf501.lab2_8.stream_api;

import java.util.ArrayList;
import java.util.List;

public class StreamTask3 {
    public static void main(String args[]) {

        //3. список строк отфильтровать по длине, оставив только длиной 5, отсортировать полученный результат
        List<String> list = new ArrayList<>(List.of("какак","пока","приве"));
        List<String> list2 = list.stream().filter(a -> a.length() == 5).sorted((a,b) -> a.compareTo(b)).toList();
        System.out.println(list2);
    }
}
