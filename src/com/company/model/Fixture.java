package com.company.model;

import com.company.enums.Dates;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class Fixture {
    private List<Match> fixture = new ArrayList<>();


    public Fixture() {
    }

    public Fixture(List<Match> fixture) {
        this.fixture = fixture;
    }

    public void doFixture() {
        List<String> list = new ArrayList<>();
        Stack<String> teams = new Stack();
        ObjectMapper mapper = new ObjectMapper();

        List<String> t = new ArrayList<>();
        try {

            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<Club> clubs = mapper.readValue(new File("clubs.json"), new TypeReference<List<Club>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
            for (Club c :
                    clubs.subList(0, 9)) {
                teams.push(c.getClub());
            }
            for (Club c:
                clubs.subList(10,19) ) {
                t.add(c.getClub());
            }
            int a = 0;
            while (!teams.empty()) {
                String c = teams.pop();
                t.remove(c);
                for (String s : t) {
                    Match m = new Match(a++, c, s);
                    this.fixture.add(m);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

public void  setDate(){
    int i=0;
    int d=0;
    Dates[] values =Dates.values();
    int size=values.length;
    for (Match m :
         fixture) {
        if (i==9||i<0)
        {
            d++;
            i=0;
            i=-d;
            while (i!=0) {

                m.setDate(values[size-d].getDate());
                i++;
            }

        }else {

            m.setDate(values[i].getDate());
            i++;
        }

    }

}
    public void amountMatch(String c) {
       int i =0;
        for (Match m:
             fixture) {
            if(m.getNameVisitor().equalsIgnoreCase(c)||m.getNameLocal().equalsIgnoreCase(c))
            {
                i++;
            }
        }
        System.out.println(i);
    }


    public List<Match> getFixture() {
        return fixture;
    }

    @Override
    public String toString() {
        return "Fixture{" +
                "fixture=" + fixture +
                '}';
    }

}
