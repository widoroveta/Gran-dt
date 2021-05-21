package com.company.model;

public class Defender extends Player{
    public Defender(String playerName, int playerNumber, String clubName) {
        super(playerName, playerNumber, clubName);
    }

    @Override
    public int getPoints() {
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
            return 0;
       // }
    }
}
