package ru.itis.inf501.lab2_3_map;

public interface List501<T> {
    int size();
    boolean isEmpty();
    boolean contains(T o);
    void add(T o);
    T delete(int o);
    void clean();
    T get(int i);
}
