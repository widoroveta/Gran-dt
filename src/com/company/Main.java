package com.company;

import com.company.enums.Dates;
import com.company.enums.Points;
import com.company.model.Club;
import com.company.model.Fixture;
import com.company.model.Match;
import com.company.model.Player;
import com.company.repository.FixtureRepository;
import com.company.request.AllSportsApi;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

 /*AllSportsApi api = new AllSportsApi();
        try {
            api.toUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
     Fixture fixture = new Fixture();

     fixture.doFixture();
     fixture.setDate();
        for (Match m: fixture.getFixture()) {
            System.out.println(m+"\n");
        }

        }

    //    fixture.amountMatch("Swansea" );
    //    System.out.println(Points.GOAL_DEFENDER);
    }


