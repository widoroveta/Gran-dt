package com.company.model;

public class Defender extends Player{
    public Defender(String playerName, int playerNumber, String clubName) {
        super(playerName, playerNumber, clubName);
    }

    public Defender() {
    }

    @Override
    public int getPoints() {
        int points=0;
        int random =1 + (int)(Math.random() * ((1000 - 1) + 1));
        //Goals
        if(random>900){
            points+=15;
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
  /*      if (this.isPlayerStatus()) {
            int points = 0;
            points=super.getDatePoint();
            if (this.isRedCard()) {

            }
            if (this.isYellowCard()) {

            }
            if (this.isMvp()) {

            }
            if (this.goals != 0)
            {

            }

            return points;
        } else {*/

       // }

    @Override
    public String toString() {
        return super.toString();
    }
}

