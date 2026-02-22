package ru.itis.inf501.lab2_1.generic;

public interface Set501Gen<T> {
    int size();
    boolean checkEmpty();
    boolean contains(Object o);
    void add(T o);
    void delete(T o);
    void clean();
    Object getAll();
}
