package com.company;

import com.company.Views.AdminMenu;
import com.company.model.Club;
import com.company.model.Fixture;
import com.company.model.MyTeam;
import com.company.repository.ClubRepository;
import com.company.repository.FixtureRepository;
import com.company.request.AllSportsApi;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
      AdminMenu adminMenu=new AdminMenu();
      adminMenu.menu();
    /*  ClubRepository clubRepository = new ClubRepository();
        List<Club> clubs = clubRepository.getClubs();
        FixtureRepository repository = new FixtureRepository();
        Fixture fixture = new Fixture();

        fixture.doFixture();
        fixture.setDate();
        repository.setFixture(fixture);
        repository.save();

      // System.out.println(fixture.toStringOnlyViewMatch());
        System.out.println(clubs);
        //
      /*  MyTeam myTeam = new MyTeam();
        ClubRepository clubRepository = new ClubRepository();
        List<Club> clubs = clubRepository.getClubs();
        int i = 0;

        myTeam.addPlayer(clubs.get(3).getPlayerList().get(1)
        );
        myTeam.addPlayer(clubs.get(3).getPlayerList().get(10)
        );
        myTeam.addPlayer(clubs.get(3).getPlayerList().get(10)
        );    myTeam.addPlayer(clubs.get(3).getPlayerList().get(0)
        );    myTeam.addPlayer(clubs.get(3).getPlayerList().get(1)
        );myTeam.addPlayer(clubs.get(3).getPlayerList().get(5)
        );
        myTeam.change(
               clubs.get(3).getPlayerList().get(1),
                clubs.get(3).getPlayerList().get(5));
        System.out.println(myTeam);*/
    }

}


