package com.company.model;

public class Goalkeeper extends Player{

    public Goalkeeper(String playerName, int playerNumber, String clubName) {
        super(playerName, playerNumber, clubName);
    }

    @Override
    public int getPoints() {
        return 0;
    }
}
