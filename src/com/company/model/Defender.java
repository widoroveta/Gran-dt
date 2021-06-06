package com.company.model;

import com.company.enums.Points;

public class Defender extends Player {
    public Defender(String playerName, int playerNumber, String clubName, int price) {
        super(playerName, playerNumber, clubName, price);
    }

    public Defender() {
    }

    @Override
    public void doPoints() {

        int random = 1 + (int) (Math.random() * ((1000 - 1) + 1));
        //Goals
        if (random > 990) {

            super.setGoals(1);
        } else {
            super.setGoals(0);
        }
        super.points = super.getGoals() * Points.GOAL_DEFENDER.getPoints();
        //Cards
        if (super.playYellowCard()) {
            super.points -= Points.YELLOW_CARD.getPoints();
        }
        if (super.playRedCard()) {
            super.points -= Points.RED_CARD.getPoints();
        }
    }

    @Override
    public int compareTo(Player o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        return "\nDefender {"+super.toString()+"}";
<<<<<<< HEAD
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
=======
>>>>>>> 4206238ad8d1fa2fe45c6dc78b339c5d1c417a35
    }
}

