package ru.itis.inf501.database;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Wastes wastes1 = new Wastes(12 , -1, "шоколадка", new Date(), "хватит есть сладкое", 250);
//        Wastes wastes2 = new Wastes(13 , -1, "зефир", new Date(), "хватит есть зефир", 200);
//        Wastes wastes3 = new Wastes(14 , -1, "мороженое", new Date(), "хватит есть мороженое", 500);
//        Wastes wastes4 = new Wastes(15 , -1, "чебуреки", new Date(), "хватит есть чебуреки", 100);
//        Wastes wastes5 = new Wastes(16 , -1, "кофе", new Date(), "хватит тратить деньги на кофе", 100);
//        Wastes wastes6 = new Wastes(17 , 1, "папа скинул", new Date(), "спасибо папе!", 100);

//        Реализовать консольный интерфейс для операций:
//        добавление в БД
//        поиск по ID
//        удаление по ID
//        изменение данных















        try {
            DatabaseUtils du = new DatabaseUtils();
//            du.save(wastes2);
//            du.save(wastes3);
//            du.save(wastes4);
//            du.save(wastes5);
//            du.save(wastes6);
//            du.delete(13);
//             test = du.findByteId(13);
//            du.init();
//            Wastes test2 = du.findByteId(16);
//            System.out.println(test);
//            System.out.println(test2);
//            du.init();
            du.concolInterface();

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

