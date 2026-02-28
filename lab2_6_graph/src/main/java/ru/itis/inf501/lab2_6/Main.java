package ru.itis.inf501.lab2_6;

import java.util.*;
//set по алфавитному порядку выводит!!! не гарантирует тот порядок, по которому удаляем !!!
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.add(new Node("d"),new Node[0]);
        graph.add(new Node("a"),new Node("d"),new Node("c"));
        graph.add(new Node("f"),new Node("d"));
        graph.add(new Node("g"),new Node("d"),new Node("c"),new Node("f"));
        graph.add(new Node("c"),new Node[0]);
        graph.add(new Node("b"),new Node("g"),new Node("c"),new Node("f"),new Node("a"));

        ListGraph result = new ListGraph();
        while(!graph.isEmpty()) {
            Set<Node> empty = graph.findEmptyDependencies();
            graph.removeDependencies(empty);
            result.addAll(empty);
        }
        System.out.println(result);
        for (Node x : result) {
            System.out.println(x);
        }
    }
}
