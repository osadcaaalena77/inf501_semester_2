package ru.itis.inf501.lab2_8.stream_api;

import java.util.ArrayList;
import java.util.List;

public class SteamTask4 {
    public static void main(String args[]) {
        List<Double> list = new ArrayList<>(List.of(62.44,334.5,53.4));
        List<Double> list2 = list.stream().sorted((a,b) -> String.valueOf(a).charAt(0) - String.valueOf(b).charAt(0)).toList();
        System.out.println(list2);

        List<Double> list3 = list.stream().sorted((a,b) -> a.intValue() % 10 - b.intValue() % 10).toList();
        System.out.println(list3);
    }
}
