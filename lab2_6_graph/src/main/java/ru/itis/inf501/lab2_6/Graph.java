package ru.itis.inf501.lab2_6;

import java.util.*;

public class Graph {
    private Map<Node, Set<Node>> map = new HashMap<>();

    public void add(Node node, Node ... dependecies) {//многоточие это неопределенное количество элементов, которые будут в массиве
        map.put(node,new HashSet<>(List.of(dependecies)));
    }

    public Set<Node> findEmptyDependencies() {
        Set<Node> result = new HashSet<>();
        for (Map.Entry<Node,Set<Node>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public void removeDependencies(Set<Node> nodes) {
        for (Node node : nodes) {
            map.remove(node);
        }
        for (Map.Entry<Node, Set<Node>> entry : map.entrySet()) {
            entry.getValue().removeAll(nodes);

        }
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
}
