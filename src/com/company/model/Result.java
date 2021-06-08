package com.company.model;

import java.util.Date;

public class Result {
    private String name;
    private Date date;
    private int score;

    public Result(String name, Date date, int score) {
        this.name = name;
        this.date = date;
        this.score = score;
    }

    public Result() {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", score=" + score +
                '}';
    }
}
