package com.company.enums;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum Dates {
    DATE_FIRST(2021, 5, 30), DATE_SECOND(2021, 5, 6), DATE_THIRD(2021, 5, 13), DATE_FOURTH(2021, 5, 20), DATE_FIFTH(2021, 5, 27), DATE_SIXTH(2021, 6, 4), DATE_SEVENTH(2021, 6, 11), DATE_EIGHTH(2021, 6, 18), DATE_NINETH(2021, 6, 25);
    private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private Date date;

    Dates(int year, int month, int day) {
        try {
            this.date = SDF.parse(day + "/" + month + "/" + year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDate() {
        return date;
    }

}
