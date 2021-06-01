package com.company.request.APIClass;

public class Coaches {
    private String coach_name;
    private String coach_country;
    private int coach_age;

    public Coaches() {

    }

    public Coaches(String coach_name, String coach_country, int coach_age) {
        this.coach_name = coach_name;
        this.coach_country = coach_country;
        this.coach_age = coach_age;
    }

    @Override
    public String toString() {
        return "Coaches{" +
                "coach_name='" + coach_name + '\'' +
                ", coach_country='" + coach_country + '\'' +
                ", coach_age=" + coach_age +
                '}';
    }
}
