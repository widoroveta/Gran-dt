package com.company.model;

public class Goalkeeper extends Player{

    public Goalkeeper(String playerName, int playerNumber, String clubName) {
        super(playerName, playerNumber, clubName);
    }

    public Goalkeeper() {
    }

    @Override
    public int getPoints() {
        int points=0;
        int random =1 + (int)(Math.random() * ((1000 - 1) + 1));
        //Goals
        if(random>980){
            points+=20;
            super.setGoals(1);
        }
        else{super.setGoals(0);}
        //Cards
        if(super.playYellowCard()){
            points-=5;
        }
        if(super.playRedCard()){
            points-=15;
        }
        return points;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
