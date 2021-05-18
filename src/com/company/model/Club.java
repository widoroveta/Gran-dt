package com.company.model;

import java.util.ArrayList;
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
