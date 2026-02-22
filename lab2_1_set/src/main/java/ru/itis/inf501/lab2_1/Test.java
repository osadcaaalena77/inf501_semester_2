package ru.itis.inf501.lab2_1;

public class Test {
    public static void main(String args[]) {
        Set501 set = new Set501Implement();
        System.out.println(set.checkEmpty());
        set.add(new Person("Алёна",Gender.FEMALE));
        set.add(new Person("Кристина",Gender.FEMALE));
        set.add(new Person("Алина",Gender.FEMALE));
        set.add(new Person("hh",Gender.FEMALE));
        set.add(new Person("Диана",Gender.FEMALE));
        set.add(new Person("Fe",Gender.FEMALE));
        set.add(new Person("Gra",Gender.MALE));
        set.add(new Person("vf",Gender.FEMALE));

        System.out.println(set.contains(new Person("G",Gender.FEMALE)));
        System.out.println(set.contains(new Person("Алёна",Gender.FEMALE)));
        System.out.println(set);
        System.out.println(set.contains(new Person("vf",Gender.FEMALE)));
        set.delete(new Person("Алёна",Gender.FEMALE));
        set.delete(new Person("vf",Gender.FEMALE));
        System.out.println(set);

//        System.out.println((new Person("Fe",Gender.FEMALE)).hashCode() % 16);
//        System.out.println((new Person("Gra",Gender.MALE)).hashCode() % 16);
//        System.out.println((new Person("Алина",Gender.FEMALE)).hashCode() % 16);
//        System.out.println(Math.abs((new Person("Кристина",Gender.FEMALE)).hashCode()) % 16);
//        System.out.println((new Person("Диана",Gender.FEMALE)).hashCode() % 16);
//        System.out.println((new Person("hh",Gender.FEMALE)).hashCode() % 16);
//        System.out.println((new Person("vf",Gender.FEMALE)).hashCode() % 16);


    }
}
