package ru.itis.inf501.lab2_1.generic;

import ru.itis.inf501.lab2_1.*;
import ru.itis.inf501.lab2_1.Set501;

public class Test {
    public static void main(String args[]) {
        Set501Gen<Person> set = new Set501Implement();
        Node person1 = new Node(new Person("Алёна", Gender.FEMALE));
        Node person2 = new Node(new Person("Кристина",Gender.FEMALE));
        Node person3 = new Node(new Person("Алина",Gender.FEMALE));
        Node person4 = new Node(new Person("Диана",Gender.FEMALE));

        System.out.println(set.checkEmpty());

        set.add(new Person("Алёна",Gender.FEMALE));
        set.add(new Person("Кристина",Gender.FEMALE));
        set.add(new Person("Алина",Gender.FEMALE));
        set.add(new Person("Диана",Gender.FEMALE));
        set.contains(new Person("Диана",Gender.FEMALE));
        //System.out.println(set.checkEmpty());
        //Person[] data =(Person[]) set.getAll();


        //set.add(new Node(new Person("Алёна",Gender.FEMALE)));
        //set.add(new Node(new Person("Кристина",Gender.FEMALE)));
        //set.add(new Person("Алина",Gender.FEMALE));
        //set.add(new Person("Володя",Gender.MALE));

       // System.out.println(set);
        //set.delete(new Node(new Person("Алёна", Gender.FEMALE)));
        System.out.println(set);
       // set.delete("Алёна",Gender.FEMALE);
//        System.out.println((new Person("Володя",Gender.MALE).hashCode()));
//        System.out.println((new Person("Володя",Gender.MALE).hashCode()));


    }
}
