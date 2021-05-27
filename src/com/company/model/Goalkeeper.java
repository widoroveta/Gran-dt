package com.company.model;

import com.company.enums.Points;

public class Goalkeeper extends Player{
    private boolean withoutGoals;
    public Goalkeeper(String playerName, int playerNumber, String clubName) {
        super(playerName, playerNumber, clubName);
    }

    public Goalkeeper() {
    }

    public boolean getWithoutGoals() {
        return withoutGoals;
    }

    public void setWithoutGoals(boolean withoutGoals) {
        this.withoutGoals = withoutGoals;
    }

    @Override
    public void doPoints() {
        int random =1 + (int)(Math.random() * ((1000 - 1) + 1));
        //Goals
        if(random>995){

            super.setGoals(1);
        }

        else{super.setGoals(0);}
        super.setPoints(super.getGoals()*Points.GOAL_GOALKEEPER.getPoints());
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
