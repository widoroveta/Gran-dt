package com.company.model;

import com.company.enums.Points;

public class Forward extends Player {

    public Forward(String playerName, int playerNumber, String clubName, int price) {
        super(playerName, playerNumber, clubName, price);
    }

    public Forward() {
    }

    @Override
    public void doPoints() {
        int random = 951;// 1 + (int) (Math.random() * ((1000 - 1) + 1));

        //Goals
        if (random < 950) {
            super.setGoals(0);
        } else if (random >= 950 && random < 975) {

            super.setGoals(1);
        } else if (random >= 975 && random < 990) {

        } else if (random >= 990 && random < 1000) {

            super.setGoals(3);
        }
        super.setPoints(super.getGoals() * Points.GOAL_DEFENDER.getPoints());
        //Cards
        if (super.playYellowCard()) {
            super.setPoints(super.getPoints()-Points.YELLOW_CARD.getPoints());
        }
        if (super.playRedCard()) {
            super.setPoints(super.getPoints()-Points.RED_CARD.getPoints());}

    }

    @Override
    public int compareTo(Player o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
      return  "\nForward {"+super.toString()+"}";

    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();

    }


}
