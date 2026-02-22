package ru.itis.inf501.lab2_2_homework;


public class List501Generic<T> implements List501<T> {

    Node[] set = new Node[16];
    int size = 0;

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
        int i = Math.abs(o.hashCode()) % 16;
        if (set[i] == null) {return false;}
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
    public void add(T o) {
        if (isExist(o)) {
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
    public void delete(T o) {
        int i = Math.abs(o.hashCode()) % 16;
        if (set[i] == null) {
            return;
        } else if (set[i].getValue().equals(o)) {
            Node del = set[i];
            set[i] = del.getNext();
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
    public String toString() {
        String result = "List501Generic{";
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

    @Override
    public void clean() {
        for (int i = 0; i < set.length; i++) {
            set[i] = null;
        }
        size = 0;
    }

    @Override
    public String get(int i) {
        String res = "На позиции " + i + " находится(находятся): ";
        if (set[i] == null) {
            return res + "null";
        } else {
            Node current = set[i];
            while(current != null) {
                res += current.getValue();
                if(current.getNext() != null) {res += ", ";}
                current = current.getNext();
            }
        }
        return res;
    }
}
