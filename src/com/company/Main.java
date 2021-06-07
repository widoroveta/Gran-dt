package com.company;

import com.company.enums.Dates;
import com.company.model.Fixture;
import com.company.model.Match;
import com.company.model.Player;
import com.company.model.User;
import com.company.repository.FixtureRepository;
import com.company.repository.UserRepository;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
 /* AdminMenu adminMenu = new AdminMenu();
  adminMenu.menu();*/
       /* SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

        UserMenu menu = new UserMenu(new User());
        menu.preCharge();*/

        FixtureRepository fixtureRepository = new FixtureRepository();
        List<Match> all = fixtureRepository.getAll();
        Date date = new Date();
        UserRepository userRepository = new UserRepository();

        for (Match match :
                all) {

            if (match.getDate().before(date)) {
                if (match.getVisitorTeam().isEmpty() || match.getLocalTeam().isEmpty()) {

                    match.assembleMatch();

                    match.pointsPlayers();
                    System.out.println("messi");
                }

            }
        }
        Fixture fixture = new Fixture();
        fixture.setFixture(all);
        fixtureRepository.setFixture(fixture);
        fixtureRepository.save();

        List<User> all1 = userRepository.getAll();
        for (User us:
             all1) {
            for (Player p:
                 us.getMyTeam().getPlayers()) {
             System.out.println(fixtureRepository.searchPoints(p, Dates.DATE_FIRST.getDate()));
            }
        }
    }
}






