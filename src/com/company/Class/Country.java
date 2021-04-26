package com.company.Class;

import com.sun.source.doctree.SerialDataTree;

import java.io.Serializable;

public class Country  {
    private int countryKey;
    private String countryName;
    private String countryLogo;
    private String countryIso;

    public Country(int countryKey, String countryName, String countryLogo, String countryIso) {
        this.countryKey = countryKey;
        this.countryName = countryName;
        this.countryLogo = countryLogo;
        this.countryIso = countryIso;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryKey=" + countryKey +
                ", countryName='" + countryName + '\'' +
                ", countryLogo='" + countryLogo + '\'' +
                ", countryIso='" + countryIso + '\'' +
                '}';
    }
}
