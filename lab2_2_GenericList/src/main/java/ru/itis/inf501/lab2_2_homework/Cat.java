package ru.itis.inf501.lab2_2_homework;

public class Cat {
    private String name;
    private Gender gender;

    public Cat(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat {" +
                "name = '" + name + '\'' +
                ", age = " + gender +
                '}';
    }

    @Override
    public boolean equals(Object  o){
        if (this == o) {return true;}
        if (!o.getClass().equals(this.getClass())) return false;
        Cat p = (Cat) o;
        return p.gender == this.gender && ((p.name == null && this.name == null) || (p.name != null && p.name.equals(this.name)));
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + gender.hashCode();
    }
}
