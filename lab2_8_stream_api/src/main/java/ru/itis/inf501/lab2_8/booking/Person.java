package ru.itis.inf501.lab2_8.booking;

import java.util.Objects;

public class Person {
    private String gender;
    private String birthdate;
    private String fromcity;

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", fromcity='" + fromcity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(gender, person.gender) && Objects.equals(birthdate, person.birthdate) && Objects.equals(fromcity, person.fromcity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, birthdate, fromcity);
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    public String getGender() {
        return gender;
    }

    public String getFromcity() {
        return fromcity;
    }

    public String getBirthdate() {
        return birthdate;
    }
}
