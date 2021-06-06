package com.company;

import com.company.model.Forward;
import com.company.model.Match;
import com.company.model.Player;
import com.company.repository.ClubRepository;
import com.company.repository.FixtureRepository;

import java.lang.management.PlatformLoggingMXBean;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
     /*   AdminMenu adminMenu = new AdminMenu();
        //adminMenu.menu();
       /* SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

        UserMenu menu = new UserMenu(new User());
        menu.preCharge();*/

     /*   FixtureRepository fixtureRepository = new FixtureRepository();
        List<Match> all = fixtureRepository.getAll();
        Date date = new Date(System.currentTimeMillis());
        for (Match match :
                all) {
            if (match.getDate().after(date)) {
               match.assembleMatch();

                System.out.println("\n"+match);
            }
        }
/
      *

      */
        ClubRepository clubRepository =new ClubRepository();
        Player player = clubRepository.getClubs().get(1).getPlayerList().get(22);
        player.doPoints();
        System.out.println(player
        );
    }

}


