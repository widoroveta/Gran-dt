package com.company.model;

import com.company.repository.ClubRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Club {
    private String club;
    private List<Player> playerList = new ArrayList<>();

    public Club(String club, List<Player> playerList) {
        this.club = club;
        this.playerList = playerList;
    }

    public Club() {
    }
    public List<Player> getTeam(String nameTeam)
    {
        List<Player>team =new ArrayList<>();
        List<Club> clubs = new ClubRepository().getClubs();

        Club clubSelect=new Club();

        for (Club club1:
             clubs) {
            if(club1.getClub().equalsIgnoreCase(nameTeam))
            {
                clubSelect=club1;
            }
        }

        int i =0;

        for (Player player : clubSelect.getPlayerList()     ) {

            if(player instanceof Goalkeeper && i==0)
            {
                team.add(player);
                i++;
            }
            if(player instanceof Defender && 4 >= i && i>0)
            {
                team.add(player);
                i++;
            }
            if(player instanceof Midfielder && 8 >= i && i>4)
            {
                team.add(player);
                i++;
            }if(player instanceof Forward && 10>= i && i>8)
            {
                team.add(player);
                i++;
            }
        }


        return team;
    }
    public String getClub() {

        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public String toString() {
        return "Club{" +
                "club='" + club + '\'' +
                ", playerList=" + playerList +
                '}';
    }
}
