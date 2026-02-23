package ru.itis.inf501.lab2_4_homework;


import java.util.Iterator;

public class Set501Implement<T> implements Set501<T>, Iterable<T> {

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
    public boolean contains(T o) {
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
    public void add(T o) {
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
    public void delete(T o) {
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int current = 0;
            int i = 0;
            Node nextNode;
            Node currentNode;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                while (set[i] == null) {
                    i++;
                }
                current++;
                currentNode = set[i];
                nextNode = currentNode.getNext();
                return (T) currentNode.getValue();
            }
        };
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
