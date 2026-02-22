package ru.itis.inf501.lab2_2_homework;

public interface List501<T> {
    int size();
    boolean isEmpty();
    boolean isExist(T o);
    void add(T o);
    void delete(T o);
    void clean();
    String get(int i);
}
