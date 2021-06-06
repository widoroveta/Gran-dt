package com.company.model;

import com.company.enums.Points;

public class Midfielder extends Player {
    public Midfielder(String playerName, int playerNumber, String clubName, int price) {
        super(playerName, playerNumber, clubName, price);
    }

    public Midfielder() {
    }

    @Override
    public void doPoints() {

        int random = 1 + (int) (Math.random() * ((1000 - 1) + 1));
        //Goals
        if (random < 450) {
            super.setGoals(0);
        } else if (random >= 975 && random < 990) {

            super.setGoals(1);
        } else if (random >= 990 && random < 1000) {

            super.setGoals(2);
        }
        super.setPoints(getGoals() * Points.GOAL_MIDFIELDER.getPoints());
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
        return "\nMidfielder {"+ super.toString()+"}";

    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();

    }
}
