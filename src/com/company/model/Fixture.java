package com.company.model;

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
                    clubs.subList(0, 20)) {
                teams.push(c.getClub());
            }
            t.addAll(teams);
            int a = 0;
            while (!teams.empty()) {
                String c = teams.pop();
                t.remove(c);
                for (String s : t) {
                            Match m = new Match(a++, c, s);
                           this.fixture.add(m);
                    }
                }

            for(int i =0;i<fixture.size();i++)
            {
                int as=0;
                                    
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




}

private void Filter()
{
    HashSet<Match> matches=new HashSet<>();
    for (Match m: this.fixture)
    {
         matches.add(m);

    }
    this.fixture.clear();
    for (Match m:
         matches) {
        this.fixture.add(m);
    }
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
