package com.company;

import com.company.model.Club;
import com.company.model.Fixture;
import com.company.model.Match;
import com.company.repository.ClubRepository;
import com.company.request.AllSportsApi;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

   /*     AllSportsApi api = new AllSportsApi();
     try {
            api.toUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
      Fixture fixture = new Fixture();

        fixture.doFixture();
        fixture.setDate();
        Club club = new Club();
      for (Match m : fixture.getFixture()) {
            club.getTeam(m.getNameLocal());
        }





        //    fixture.amountMatch("Swansea" );
        //    System.out.p



    }

}


