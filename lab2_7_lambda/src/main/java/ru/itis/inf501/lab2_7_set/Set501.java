package ru.itis.inf501.lab2_7_set;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.List;

public interface Set501<T> {
    int size();
    boolean checkEmpty();
    boolean contains(T o);
    void add(T o);
    void delete(T o);
    void clean();
    Object[] getAll();
    Set501<T> filter(Predicate<T> predicate);
    <R> List<R> collect(Function<T,R> function);
    //можем использовать тип R
    List<T> sort(Comparator<T>  comparator);
}
