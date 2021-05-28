package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class MyTeam {
    private String teamName;
    private final List<Player> players = new ArrayList<>();
    private transient int score;

    /*    public void selectPlayer(){
           List<Player> players = new ArrayList<>();
            HashSet <Player> players1 =new HashSet<>();
            FixtureRepository fixtureRepository =new FixtureRepository();
            for (Match m:
            fixtureRepository.getAll()) {
                players1.addAll(m.getLocalTeam());
                players1.addAll(m.getVisitorTeam());
            }
            System.out.println(players1);
            System.out.println(players1.size());
        }*/
    public String selectPlayer(Club club, List<Club> clubs) {
        String playerList = null;
        boolean flag = false;
        while (flag == false) {
            for (Club c :
                    clubs) {
                if (c.getClub().equalsIgnoreCase(club.getClub())) {
                    flag = true;
                }
            }
        }
        int i = 0;
        for (Player player :
                club.getPlayerList()) {
            playerList += "\n" + i + "" + player;
            i++;
        }
        return playerList;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
