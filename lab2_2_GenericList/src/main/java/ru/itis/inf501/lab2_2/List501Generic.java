package ru.itis.inf501.lab2_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class List501Generic<T> implements List501<T> {
    Object[] set = new Object[16];
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
    public boolean isExist(T o) {
        boolean flag = false;
        for(int i = 0; i < set.length; i++) {
            if (set[i] == o) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }
//    @Override
//    public Object[] getAll() {
//        Object[] result = new Object[size];
//        System.arraycopy(set, 0, result, 0, size);
//        return result;
//    }
/*
T[] newAll = (T[])Array.newInstance(componentType,size);
Array.newInstance(Person.class(),10);
 */
//    public T[] getAll(Class<T> clazz) {
//        T[] result = (T[]) Array.newInstance(clazz,size);
//        System.arraycopy(set, 0, result, 0, size);
//        return result;
//    }

    @Override
    public void add(T o) {
        if (size == set.length) {
            Object[] newSet = new Object[set.length * 2];
            for(int i = 0; i < set.length; i++) {
                newSet[i] = set[i];
            }
            System.arraycopy(set,0,newSet,0,set.length);
            set = newSet;
        }
        set[size++] = o;

    }

    @Override
    public T delete(int i) {
        if (i < set.length && i >= 0) {
            for (int k = i; k < size - 1; k++) {
                set[k] = set[k + 1];
            }
            set[size - 1] = null;
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return (T)set[i];
    }

    @Override
    public void clean() {
        for (int i = 0; i < set.length; i++) {
            set[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        return "List501Generic{" +
                "set = " + Arrays.toString(set) +
                ", size = " + size +
                '}';
    }

    @Override
    public T get(int i) {
        if (i < set.length && i >= 0) {
            return (T) set[i];
        } else {
            return null;
        }
    }

    @Override
    public T getAll(T clazz) {
        return null;
    }
}
