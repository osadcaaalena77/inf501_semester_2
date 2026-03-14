package ru.itis.inf501.lab2_7_lambda;

public class Student implements StudentWork{
    private String name;
    private String group;
    private String birthDate;
    private String workName;

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Student(String group, String name, String birthDate, String workName) {
        this.group = group;
        this.name = name;
        this.birthDate = birthDate;
        this.workName = workName;

    }

    public String getWorkName() {
        return workName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String work () {
        String result;
        result = doWork(this.name, this.workName);
        if (this.workName.equals("Курсовая")) {
            return result + " не сдал";
        } else {
            return result + " сдал";
        }

    }

    public String doWork(String name, String workName) {
        return "" + name + " : " + workName;
    }
}
