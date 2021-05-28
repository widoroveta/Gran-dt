package com.company;

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

        AllSportsApi api = new AllSportsApi();
        try {
            api.toUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }
      /*  ClubRepository clubRepository = new ClubRepository();
        List<Club> clubs = clubRepository.getClubs();*/
        FixtureRepository repository = new FixtureRepository();
        Fixture fixture = new Fixture();

        fixture.doFixture();
        fixture.setDate();
        repository.setFixture(fixture);
        repository.save();

        System.out.println(repository.getAll());
        //
        MyTeam myTeam = new MyTeam();
        ClubRepository clubRepository = new ClubRepository();
        List<Club> clubs = clubRepository.getClubs();
        int i = 0;
        for (Club c :
                clubs) {
            System.out.println("\n" + i + ")" + c.getClub());
            i++;
        }
        myTeam.selectPlayer(clubs.get(10), clubs);
    }

}


