package ru.itis.inf501.lab2_7_lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestLambda {
    public static void main(String args[]) {
        //1 задание
        Predicate<String> predicate =
                (s) -> s.startsWith("Муз");

        List<String> list = new ArrayList<>();
        list.add("Муз");
        list.add("Музыка");
        list.add("мяу");
        list.add("мур");

        for (String x : list) {
            System.out.println(predicate.test(x));
        }

        //2 задание
        Function<Integer,String> function =
                (s) -> String.valueOf(s);
        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        for (int x : list2) {
            System.out.println(function.apply(x));
        }
        System.out.println();

        //3 задание
        Comparator<Person> comparator =
                (a,b) -> a.getHeight() - b.getHeight();
        List<Person> list3 = new ArrayList<>();
        list3.add(new Person("fg",166));
        list3.add(new Person("er",175));
        list3.add(new Person("ff",189));
        list3.sort(comparator);
        for (Person x : list3) {
            System.out.println(x);
        }
        System.out.println();

        //4 задание
        Consumer<Person> consumer =
                (s) -> System.out.println(s.getName());
        for (Person x : list3) {
            consumer.accept(x);
        }
        System.out.println();

        //5 задание
        List<Integer> lst = new ArrayList<>(List.of(99,6,0,23,44,5));
        lst.sort((a,b) -> b - a);
        lst.forEach((a) -> System.out.println(a));
        System.out.println();

        //6 задание
        List<Integer> lst2 = new ArrayList<>(List.of(1, 553, 212, 0));
        lst2.replaceAll((s) -> s % 16);
        lst2.forEach((s) -> System.out.println(s));

        //7 задание
        List<Student> lst3 = new ArrayList<>();
        lst3.add(new Student("11-501", "Алёнка","09.09.2007","Семестровка"));
        lst3.add(new Student("11-501", "Олег","24.07.2007","Курсовая"));
        lst3.add(new Student("11-501", "Монгол","08.05.2004","Семестровка"));
        lst3.add(new Student("11-501", "Иришка-Чикипики","31.12.1900","Курсовая"));
        lst3.forEach((s) -> System.out.println(s.work()));

    }
}
