package ru.itis.inf501.lab2_4;

public class TestIterator {
    public static void main(String[] args) {
        List501Impl<String> list = new List501Impl();

        list.add("1");
        list.add("2");
        list.add("3");

        for(String x : list) {
            System.out.println(x);
        }
    }
}
