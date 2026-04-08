package ru.itis.inf501.lab2_11;

public class Person {
    private String name;
    private String birthDate;
    private byte gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int y, int m, int d) {
        this.birthDate = String.format("%d-%02d-%d",y,m,d);
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender=" + gender +
                '}';
    }
}
