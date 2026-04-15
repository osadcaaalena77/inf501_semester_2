package ru.itis.inf501.lab2_12;

import java.io.Serializable;
import java.util.Date;

public class Many implements Serializable {
    private Integer id;
    private int type;  // 1 - доход, -1 расход
    private String name;
    private Date date;
    private String comment;

    public Many(Integer id, int type, String name, Date date, String comment) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.date = date;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Many{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", date=" + date.getYear() + " - "+ date.getMonth() + " - " + date.getDay() +
                ", comment='" + comment + '\'' +
                '}';
    }
}
//Map<Index,Long> index = ... - список всех данных