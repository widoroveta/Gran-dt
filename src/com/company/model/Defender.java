package com.company.model;

import com.company.enums.Points;

public class Defender extends Player{
    public Defender(String playerName, int playerNumber, String clubName) {
        super(playerName, playerNumber, clubName);
    }

    public Defender() {
    }

    @Override
    public void doPoints() {

        int random =1 + (int)(Math.random() * ((1000 - 1) + 1));
        //Goals
        if(random>990){

            super.setGoals(1);
        }
        else{super.setGoals(0);}
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

