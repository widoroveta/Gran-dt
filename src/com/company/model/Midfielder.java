package com.company.model;

public class Midfielder extends  Player{
    public Midfielder(String playerName, int playerNumber, String clubName) {
        super(playerName, playerNumber, clubName);
    }

    @Override
    public int getPoints() {
        int points = 0;
        int random = 1 + (int) (Math.random() * ((1000 - 1) + 1));
        //Goals
        if ( random < 450 ) {
            super.setGoals(0);
        } else if ( random >= 450 && random < 800 ) {
            points += 10;
            super.setGoals(1);
        } else if ( random >= 700 && random < 920 ) {
            points += 15;
            super.setGoals(2);
        }
        //Cards
        if ( super.playYellowCard() ) {
            points -= 5;
        }
        if ( super.playRedCard() ) {
            points -= 15;
        }
        return points;
    }
}
