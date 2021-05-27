package com.company;

import com.company.model.*;
import com.company.repository.ClubRepository;
import com.company.repository.FixtureRepository;
import com.company.repository.UserRepository;
import com.company.request.AllSportsApi;

import javax.swing.undo.UndoableEditSupport;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

   /*     AllSportsApi api = new AllSportsApi();
     try {
            api.toUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        FixtureRepository repository =new FixtureRepository();
    Fixture fixture = new Fixture();

        fixture.doFixture();
        fixture.setDate();
     repository.saveFixture(fixture);
        MyTeam myTeam=new MyTeam();
        myTeam.selectPlayer();

    }

}


