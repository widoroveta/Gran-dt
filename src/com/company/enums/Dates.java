package com.company.enums;

import java.time.LocalDate;

public enum Dates {
    DATE_FIRST(2021,2,14),DATE_SECOND(2021,2,21),DATE_THIRD(2021,2,28),DATE_FOURTH(2021,3,7),DATE_FIFTH(2021,3,14),DATE_SIXTH(2021,3,21),DATE_SEVENTH(2021,3,28),DATE_EIGHTH(2021,4,4),DATE_NINETH(2021,4,11);
    private LocalDate date;
    Dates(int year,int month,int day){
        this.date=LocalDate.of(year,month,day);
    }

    public LocalDate getDate() {
        return date;
    }

}
