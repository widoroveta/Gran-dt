package com.company.model;

import com.company.enums.Points;

public class Forward extends Player{

    public Forward(String playerName,int playerNumber, String clubName) {
        super(playerName, playerNumber, clubName);
    }

    @Override
    public int getPoints() {
        int points = 0;
        int random = 1 + (int) (Math.random() * ((1000 - 1) + 1));
        //Goals
        if ( random < 450 ) {
            super.setGoals(0);
        } else if ( random >= 450 && random < 700 ) {
            points += 5;
            super.setGoals(1);
        } else if ( random >= 700 && random < 900 ) {
            points += 10;
            super.setGoals(2);
        } else if ( random >= 900 && random < 1000 ) {
            points += 15;
            super.setGoals(3);
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
      /*  if (this.isPlayerStatus()) {
            int points = 0;
            points=datePoint;
            if (this.isRedCard()) {
                int random =1 + (int)(Math.random() * ((1000 - 1) + 1));

            }
            if (this.isYellowCard()) {

            }
            if (this.isMvp()) {

            }
            if (this.goals != 0)
            {

            }
*/
      //      return points;
     //   } else {


    }
