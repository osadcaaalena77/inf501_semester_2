package ru.itis.inf501.lab2_7_list_homework;

import ru.itis.inf501.lab2_7_set.Set501;
import ru.itis.inf501.lab2_7_set.Set501Implements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class List501Implements<T> implements List501<T> {
    private static final int COUNT_BLOCKS = 3;
    private Object[] list = new Object[COUNT_BLOCKS];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(t)) return true;
        }
        return false;
    }

    @Override
    public void add(T t) {
        if (size == list.length) {
            Object[] newList = new Object[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
        }
        list[size++] = t;
    }

    @Override
    public T delete(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T result = (T) list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[--size] = null;
        return result;
    }

    @Override
    public void clean() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        return (T) list[index];
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += list[i] + "; ";
        }
        return result;
    }

    @Override
    public List501<T> filter(Predicate<T> predicate ) {
        List501<T> result = new List501Implements<>();
        for (int i = 0; i < size; i++) {
            if(predicate.test((T)list[i])) {
                result.add((T) list[i]);
            }
        }
        return result;
    }

    @Override
    public <R> List<R> collect(Function<T,R> function) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(function.apply((T)list[i]));
        }
        return result;
    }

    @Override
    public List<T> sort(Comparator<T> comparator) {
        Object[] m = this.getAll();
        Arrays.sort((T[])m,comparator);
        List<T> result = new ArrayList<>();
        for (Object o : m) {
            result.add((T) o);
        }
        return result;
    }

    @Override
    public Object[] getAll() {
        Object[] result = new Object[size];
        System.arraycopy(list, 0, result, 0, size);
        return result;
    }


}
