package com.company.model;

import com.company.enums.Dates;
import com.company.repository.ClubRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        ClubRepository clubRepository = new ClubRepository();
        List<Club> clubs = clubRepository.getClubs();
        for (Club c :
                clubs.subList(0, 9)) {
            teams.push(c.getClub());
        }
        for (Club c :
                clubs.subList(10, 19)) {
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

    }


    public void setDate() {
        int i = 0;
        int d = 0;
        int n = 0;
        Dates[] values = Dates.values();
        int size = values.length;
        for (Match m :
                fixture) {
            if (i < 9 && i >= d) {
                n = i - d;
                i++;
            } else {
                if (i > 8) {
                    i = 0;
                    d++;
                }
                n = size - d + i;
                i++;
            }
            m.assembleMatch();
            m.setDate(values[n].getDate());
        }
    }


    public void amountMatch(String c) {
        int i = 0;
        for (Match m :
                fixture) {
            if (m.getNameVisitor().equalsIgnoreCase(c) || m.getNameLocal().equalsIgnoreCase(c)) {
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
