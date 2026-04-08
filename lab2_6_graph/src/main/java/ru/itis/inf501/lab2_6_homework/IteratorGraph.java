package ru.itis.inf501.lab2_6_homework;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

public class IteratorGraph implements Iterator<Node>{
    private Graph graph;

    public IteratorGraph(Graph graph) {
        this.graph = graph;
    }


    List<Node> result = new ArrayList<>();

    public List<Node> findEmpty(List<Node> result) {
        while (!graph.isEmpty()) {
            Set<Node> empty = graph.findEmptyDependencies();
            graph.removeDependencies(empty);
            result.addAll(empty);
        }
        return result;
    }

    int current = 0;
    @Override
    public boolean hasNext() {
        result = findEmpty(result);
        return current < result.size();
    }
    @Override
    public Node next() {
        result = findEmpty(result);
        return result.get(current++);
    }

}
