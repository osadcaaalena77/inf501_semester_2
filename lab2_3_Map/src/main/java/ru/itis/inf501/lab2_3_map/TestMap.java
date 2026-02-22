package ru.itis.inf501.lab2_3_map;

public class TestMap {
    public static void main(String args[]) {
        Map501<Integer, String> map = new Map501Impl<>();

        map.put(1,"Один");
        map.put(1,"Один 1");
        map.put(2,"Два");
        map.put(3,"Три 33");
        map.put(4,"Четыре 4");


        System.out.println(map.get(1));
        System.out.println(map.getKeySet());
        System.out.println(map.getValues());
        System.out.println(map.getEntries());
        System.out.println(map.size());
    }
}
