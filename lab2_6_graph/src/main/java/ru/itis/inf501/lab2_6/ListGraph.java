package ru.itis.inf501.lab2_6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListGraph implements Iterable<Node>{
    private List<Node> list = new ArrayList<>();

    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            int current = 0;
            @Override
            public boolean hasNext() {
                return current < list.size();
            }

            @Override
            public Node next() {
                return list.get(current++);
            }
        };
    }

    public void addAll(Set<Node> empty) {
        for(Node node : empty) {
            list.add(node);
        }
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
            if (i != list.size() - 1) result += ", ";
        }
        return result + "]";
    }

}
