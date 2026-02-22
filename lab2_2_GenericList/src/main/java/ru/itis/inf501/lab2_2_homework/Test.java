package ru.itis.inf501.lab2_2_homework;

public class Test {
    public static void main(String args[]) {
        List501<Cat> set = new List501Generic<>();
        set.add(new Cat("Барсик",Gender.MALE));
        set.add(new Cat("Мурзик",Gender.MALE));
        set.add(new Cat("Ирис",Gender.MALE));
        set.add(new Cat("Боня",Gender.MALE));
        set.add(new Cat("Мальвина",Gender.FEMALE));
        set.add(new Cat("Эльвина",Gender.FEMALE));
        set.add(new Cat("Ha",Gender.FEMALE));
        set.add(new Cat("fo",Gender.FEMALE));
        System.out.println(set.get(5));
        System.out.println(set.isExist(new Cat("Ha",Gender.FEMALE)));
        System.out.println(set.isExist(new Cat("fo",Gender.FEMALE)));
        System.out.println(set);
        set.delete(new Cat("K",Gender.FEMALE));
        set.delete(new Cat("Ирис",Gender.MALE));
        set.delete(new Cat("Мурзик",Gender.MALE));
        System.out.println(set);
        //set.clean();
        System.out.println(set);
//        System.out.println(set.get(5));
//        System.out.println(Math.abs(new Cat("Барсик",Gender.MALE).hashCode()) % 16);
//        System.out.println(Math.abs(new Cat("Мурзик",Gender.MALE).hashCode()) % 16);
//        System.out.println(Math.abs(new Cat("Ирис",Gender.MALE).hashCode()) % 16);
//        System.out.println(Math.abs(new Cat("Мальвина",Gender.FEMALE).hashCode()) % 16);
//        System.out.println(Math.abs(new Cat("Боня",Gender.MALE).hashCode()) % 16);
//        System.out.println(Math.abs(new Cat("Эльвина",Gender.FEMALE).hashCode()) % 16);
//        System.out.println(Math.abs(new Cat("Ha",Gender.FEMALE).hashCode()) % 16);
//        System.out.println(Math.abs(new Cat("fo",Gender.FEMALE).hashCode()) % 16);



    }
}
