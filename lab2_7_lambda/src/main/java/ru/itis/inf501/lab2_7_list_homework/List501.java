package ru.itis.inf501.lab2_7_list_homework;

import ru.itis.inf501.lab2_7_set.Set501;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface List501<T> {
    int size();
    boolean isEmpty();
    boolean contains(T o);
    void add(T o);
    T delete(int o);
    void clean();
    T get(int i);
    List501<T> filter(Predicate<T> predicate);
    <R> List<R> collect(Function<T,R> function);
    //можем использовать тип R
    List<T> sort(Comparator<T> comparator);
    Object[] getAll();
}
