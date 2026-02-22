package ru.itis.inf501.lab2_1.generic;

import ru.itis.inf501.lab2_1.Node;
import ru.itis.inf501.lab2_1.Set501;

import java.util.Arrays;

public class Set501Implement<T> implements Set501Gen<T> {

    private Node[] set = new Node[16];
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean checkEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean flag = false;
        int i = o.hashCode() % 16;
        Node node = new Node(o);
        if (set[i].getValue().equals(o)) {
            flag = true;
        } else {
            Node current = set[i];
            while (current.getNext() != null) {
                current = current.getNext();
                if (current.getValue().equals(o)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public void add(Object o) {
//        if (contains(o)) {
//            return;
//        }
        int i = o.hashCode() % 16;
        Node node = new Node(o);
        if (set[i] == null) {
            //set[i] = new Node(o);
            set[i] = node;
        } else {
            Node current = set[i];
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
        size++;
    }

    @Override
    public void delete(Object o) {
//        int i = o.getValue().hashCode() % 16;
//        if (set[i].getValue().equals(o.getValue()) && set[i].getNext() == null) {
//            set[i] = null;
//        } if else() {
//
//        }
    }


//        int pos = -1;
//        for(int i = 0; i < set.length; i++) {
//            if (set[i].equals(o)) {
//                pos = i;
//                break;
//            }
//        }
//        if (pos == -1) {
//            throw new NotFoundException();
//        }
//        for(int i = pos; i < size - 1; i++) {
//            set[i] = set[i + 1];
//        }
//        set[size - 1] = null;
//        size--;


    @Override
    public void clean() {
        for (int i = 0; i < set.length; i++) {
            set[i] = null;
        }
        size = 0;
    }

    @Override
    public Object getAll() {
        Object[] result = new Object[size];
        System.arraycopy(set,0,result,0,size);
        return result;
    }

    @Override
    public String toString() {
        return "Set501Implement{" +
                "set = " + Arrays.toString(set) +
                ", size = " + size +
                '}';
    }
}






//метод contains
//        for(int i = 0; i < set.length; i++) {
//            if (set[i] == o) {
//                flag = true;
//            } else {
//                flag = false;
//            }
//        }
// метод add
//        if (size == set.length) {
//            Object[] newSet = new Object[set.length * 2];
//           for(int i = 0; i < set.length; i++) {
//                newSet[i] = set[i];
//           }
//            System.arraycopy(set,0,newSet,0,set.length);
//            set = newSet;
//        }
//        set[size++] = o;


//    @Override
//    public String toString() {
//        return "Set501Implement {" +
//                "set = " + Arrays.toString(set) +
//                ", size = " + size +
//                '}';
//    }
//

