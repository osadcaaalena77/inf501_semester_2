package ru.itis.inf501.lab2_2;

public class Test {
    public static void main(String args[]) {
        List501<Cat> set = new List501Generic<>();
        set.add(new Cat("Мурзик",1));
        set.add(new Cat("Барсик",1));
        set.add(new Cat("Коля",2));
        set.add(new Cat("Ирис",3));
        set.add(new Cat("Бубуська",1));
        System.out.println(set.get(3));
        System.out.println(set);
        System.out.println(set.delete(0));
        System.out.println(set);



    }
}
