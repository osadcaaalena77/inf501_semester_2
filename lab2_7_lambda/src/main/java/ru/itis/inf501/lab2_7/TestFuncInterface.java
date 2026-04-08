package ru.itis.inf501.lab2_7;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestFuncInterface {
    public static void main(String args[]) {
        List<Fruit> fruits  = new ArrayList<>();
        fruits.add(new Fruit("Яблоко",140));
        fruits.add(new Fruit("Банан",130));
        fruits.add(new Fruit("Груша",200));
        fruits.add(new Fruit("Апельсин",160));
        fruits.add(new Fruit("Гранат",250));

        //подаем объект, умеющий сравнивать Fruit
        fruits.sort(new FruitComparator());

        // подаем объект, обрабатывающий Fruit
        //forEach перебирает все элементы и применяет к ним accept
        fruits.forEach(new FruitConsumer());

        //используем анонимный класс
        fruits.sort(new Comparator<Fruit>() {
            public int compare(Fruit o1, Fruit o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });

        fruits.forEach(new Consumer<Fruit>() {
            @Override
            public void accept(Fruit fruit) {
                System.out.println(fruit.getName() + " : " + fruit.getPrice());
            }
        });
    }
}
