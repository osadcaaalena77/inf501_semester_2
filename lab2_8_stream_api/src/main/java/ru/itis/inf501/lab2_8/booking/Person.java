package ru.itis.inf501.lab2_8.booking;

public class Person {
    private String gender;
    private String birthdate;
    private String fromcity;

    public void setGender(String gender) {
        this.gender = gender;
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
