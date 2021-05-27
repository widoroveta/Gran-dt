package com.company.model;

import com.company.enums.Points;

public class Forward extends Player{

    public Forward(String playerName,int playerNumber, String clubName) {
        super(playerName, playerNumber, clubName);
    }

    public Forward() {
    }

    @Override
    public void doPoints() {
        int random = 1 + (int) (Math.random() * ((1000 - 1) + 1));

        //Goals
        if ( random < 450 ) {
            super.setGoals(0);
        } else if ( random >= 950 && random <975  ) {

            super.setGoals(1);
        } else if ( random >= 975 && random < 990 ) {

        } else if ( random >= 990 && random < 1000 ) {

            super.setGoals(3);
        }
        super.points=super.getGoals()*Points.GOAL_DEFENDER.getPoints();
        //Cards
        if(super.playYellowCard()){
            super.points-= Points.YELLOW_CARD.getPoints();
        }
        if(super.playRedCard()){
            super.points-=Points.RED_CARD.getPoints();
        }

    }


    @Override
    public String toString() {
        return super.toString();
    }
}
