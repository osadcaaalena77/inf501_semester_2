package ru.itis.inf501.lab2_7_list;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestList {
    public static void main(String args[]) {
        List501<String> list = new List501Implements<>();
        list.add("0");
        list.add("12");
        list.add("678");
        list.add("555");
        list.add("45");

        List501<String> list2 = list.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 3;
            }
        });

        for (Object s : list2.getAll()) {
            System.out.println(s);
        }

        List<Integer> list3 = list.collect(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        for(Object s : list3) {
            System.out.println(s);
        }

        List<String> list4 = list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String s : list4) {
            System.out.println(s);
        }

    }
}
