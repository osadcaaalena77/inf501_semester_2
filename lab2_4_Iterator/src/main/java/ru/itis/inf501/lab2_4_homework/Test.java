package ru.itis.inf501.lab2_4_homework;

public class Test {
    public static void main(String args[]) {
        Set501Implement<Person> set = new Set501Implement<>();
        System.out.println(set.checkEmpty());
        set.add(new Person("Алёна", Gender.FEMALE));
        set.add(new Person("Кристина", Gender.FEMALE));
        set.add(new Person("Алина", Gender.FEMALE));
        set.add(new Person("hh", Gender.FEMALE));
        set.add(new Person("Диана", Gender.FEMALE));
        set.add(new Person("Fe", Gender.FEMALE));
        set.add(new Person("Gra", Gender.MALE));
        set.add(new Person("vf", Gender.FEMALE));
        System.out.println(set);
        for (Person x : set) {
            System.out.println(x);
        }

//        System.out.println(set.contains(new Person("G", Gender.FEMALE)));
//        System.out.println(set.contains(new Person("Алёна", Gender.FEMALE)));
//        System.out.println(set);
//        System.out.println(set.contains(new Person("vf", Gender.FEMALE)));
//        set.delete(new Person("Алёна", Gender.FEMALE));
//        set.delete(new Person("vf", Gender.FEMALE));
//        System.out.println(set);

//        System.out.println((new Person("Fe", ru.itis.inf501.lab2_1.Gender.FEMALE)).hashCode() % 16);
//        System.out.println((new Person("Gra", ru.itis.inf501.lab2_1.Gender.MALE)).hashCode() % 16);
//        System.out.println((new Person("Алина", ru.itis.inf501.lab2_1.Gender.FEMALE)).hashCode() % 16);
//        System.out.println(Math.abs((new Person("Кристина", ru.itis.inf501.lab2_1.Gender.FEMALE)).hashCode()) % 16);
//        System.out.println((new Person("Диана", ru.itis.inf501.lab2_1.Gender.FEMALE)).hashCode() % 16);
//        System.out.println((new Person("hh", ru.itis.inf501.lab2_1.Gender.FEMALE)).hashCode() % 16);
//        System.out.println((new Person("vf", Gender.FEMALE)).hashCode() % 16);


    }
}
