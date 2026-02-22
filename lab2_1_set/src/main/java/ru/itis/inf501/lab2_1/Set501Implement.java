package ru.itis.inf501.lab2_1;

import java.util.Arrays;

public class Set501Implement implements Set501 {

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
        int i = Math.abs(o.hashCode()) % 16;
        if(set[i] == null) {return false;}
        if (set[i].getValue().equals(o)) {
            return true;
        } else {
            Node current = set[i];
            while (current.getNext() != null) {
                current = current.getNext();
                if (current.getValue().equals(o)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public void add(Object o) {
        if (contains(o)) {
            return;
        }
        Node node = new Node(o);
        int i = Math.abs(o.hashCode()) % 16;
        if (set[i] == null) {
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
        int i = Math.abs(o.hashCode()) % 16;
        if (set[i] == null) {
            return;
        } else if (set[i].getValue().equals(o)) {
            Node current = set[i];
            set[i] = current.getNext();
        } else {
            Node current = set[i];
            while(!current.getNext().getValue().equals(o)) {
                current = current.getNext();
            }
            Node del = current.getNext();
            current.setNext(del.getNext());
        }
        size--;
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
        String result = "Set501Implement{";
        for (int i = 0; i < set.length; i++) {
            if (set[i] == null) {
                result += set[i];
                result += ",";
            } else if (set[i] != null && set[i].getNext() == null) {
                result += set[i].getValue();
                result += ",";
            } else {
                Node current = set[i];
                while(current != null) {
                    result += current.getValue();
                    result += ",";
                    current = current.getNext();
                }
            }

        }
        return result + "size = " + size + "}";
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

//    @Override
//    public Object getAll() {
//        Object[] result = new Object[size];
//        System.arraycopy(set,0,result,0,size);
//        return result;
//    }
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
