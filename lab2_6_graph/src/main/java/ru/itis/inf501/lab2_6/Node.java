package ru.itis.inf501.lab2_6;

public class Node {
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return ((Node)o).getName().equals(this.name);
    }

    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
