package com.company;

import com.company.enums.Dates;
import com.company.model.*;
import com.company.repository.FixtureRepository;
import com.company.repository.ResultsRepository;
import com.company.repository.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
     /*  MainMenu menu =new MainMenu();
        menu.menuMain();*/
 /*AdminMenu adminMenu = new AdminMenu();
  adminMenu.menu();*/
       /* SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

        UserMenu menu = new UserMenu(new User());
        menu.preCharge();*/

        FixtureRepository fixtureRepository = new FixtureRepository();
        List<Match> all = fixtureRepository.getAll();
      //  Date date = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = SDF.parse("14/06/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserRepository userRepository = new UserRepository();

        for (Match match :
                all) {

            if (match.getDate().before(date)) {
                if (match.getVisitorTeam().isEmpty() || match.getLocalTeam().isEmpty()) {

                    match.assembleMatch();

                    match.pointsPlayers();

                }

            }
        }
        Fixture fixture = new Fixture();
        fixture.setFixture(all);
        fixtureRepository.setFixture(fixture);
        fixtureRepository.save();
        Dates[] values = Dates.values();
        List<User> all1 = userRepository.getAll();
        List<Result> results = new ArrayList<>();
        ResultsRepository repository = new ResultsRepository();
        int points = 0;
        for (User us :
                all1) {

            for (Dates d :
                    values) {
                points = 0;

                for (Player p :
                        us.getMyTeam().getPlayers()) {

                    points += fixtureRepository.searchPoints(p, d.getDate());
                }

                results.add(new Result(us.getName(), d.getDate(), points));
            }

            repository.setResults(results);
            repository.save();
        }
        for (User user:
             all1) {
            List<Result> all2 = repository.getAll();
            points=0;
            for (Result r:
                 all2) {

                if(r.getName().equals(user.getName()))
                {
             System.out.println(points+=r.getScore());
                }
            }
            user.getMyTeam().setScore(points);
        }
        System.out.println(all1);
    }
}






