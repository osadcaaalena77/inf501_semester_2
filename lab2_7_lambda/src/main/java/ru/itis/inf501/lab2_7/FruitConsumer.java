package ru.itis.inf501.lab2_7;

import java.util.function.Consumer;

public class FruitConsumer implements Consumer<Fruit> {
    public void accept (Fruit fruit) {
        System.out.println(fruit.getName() + " : " + fruit.getPrice());
    }
}
