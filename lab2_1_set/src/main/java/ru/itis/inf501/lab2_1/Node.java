package ru.itis.inf501.lab2_1;

public class Node {
    private Object value;
    private Node next;

    public Node(Object value) {this.value = value;}

    public Object getValue() {return value;}

    public void setNext(Node next) { this.next = next;}

    public Node getNext() {return next;}

}
