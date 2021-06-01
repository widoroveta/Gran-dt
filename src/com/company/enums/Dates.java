package com.company.enums;

import java.util.Date;

public enum Dates {
    DATE_FIRST(2021, 5,30 ), DATE_SECOND(2021, 6, 6), DATE_THIRD(2021, 6, 13), DATE_FOURTH(2021, 6, 20), DATE_FIFTH(2021, 6, 27), DATE_SIXTH(2021, 7, 4), DATE_SEVENTH(2021, 7, 11), DATE_EIGHTH(2021, 7, 18), DATE_NINETH(2021, 76    , 25);
    private final Date date;

    Dates(int year, int month, int day) {
        this.date = new Date(year, month, day);
    }

    public Date getDate() {
        return date;
    }

}
